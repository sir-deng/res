package com.tencent.mm.plugin.bbom;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.R;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.booter.MMReceivers.ExdeviceProcessReceiver;
import com.tencent.mm.booter.MMReceivers.SandBoxProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsProcessReceiver;
import com.tencent.mm.booter.d.c;
import com.tencent.mm.booter.q;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMAppMgr.Receiver;
import com.tencent.mm.ui.d;
import com.tencent.mm.ui.d.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.t;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteTrace;
import java.util.List;
import java.util.Map;

public class PluginBigBallOfMud extends f implements ApplicationLifeCycleBucket {
    private static final String TAG = "MicroMsg.PluginBigBallOfMud";
    public Application app;
    private final MMAppMgr appMgr = new MMAppMgr();
    private e mProfileCompat;

    public String toString() {
        return "plugin-big-ball-of-mud";
    }

    public void installed() {
    }

    public void dependency() {
        dependsOn(b.class);
        dependsOn(n.class);
    }

    public void configure(g gVar) {
        String str;
        e eVar;
        int i;
        d.a(new a() {
            public final void b(long j, String str, String str2) {
                com.tencent.mm.plugin.report.d.pVE.h(14976, Long.valueOf(j), str, str2);
            }
        });
        ToolsProcessReceiver.a(new c());
        SandBoxProcessReceiver.a(new com.tencent.mm.booter.d.b());
        ExdeviceProcessReceiver.a(new com.tencent.mm.booter.d.a());
        com.tencent.mm.plugin.zero.a.d dVar = (com.tencent.mm.plugin.zero.a.d) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.zero.a.d.class);
        dVar.setILightPushDelegate(new i());
        dVar.addNotifyReceiverCallback(new n());
        dVar.addICoreServiceLifecycleCallback(new f());
        x.i(TAG, "zero %s", dVar);
        this.app = gVar.gUt;
        com.tencent.mm.modelstat.d.a(this.app);
        x.i(TAG, "app.getResources() is:" + gVar.gUt.getResources());
        ad.a(com.tencent.mm.bv.a.a(gVar.gUt.getResources(), gVar.gUt));
        com.tencent.mm.app.c.al(this.app.getApplicationContext());
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.compatible.loader.f fVar = new com.tencent.mm.compatible.loader.f();
        Application application = this.app;
        String str2 = gVar.gQd;
        if (str2 == null || str2.length() <= 0) {
            HandlerThread WL = com.tencent.mm.sdk.f.e.WL("ProfileFactoryImp_handlerThread");
            WL.start();
            str2 = (String) new bd<String>() {
                protected final /* synthetic */ Object run() {
                    return AnonymousClass1.ze();
                }

                private static String ze() {
                    while (true) {
                        String r = bi.r(ad.getContext(), Process.myPid());
                        if (r != null) {
                            return r;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.ProfileFactoryImpl", e, "", new Object[0]);
                        }
                    }
                }
            }.b(new ag(WL.getLooper()));
            WL.getLooper().quit();
            str = str2;
        } else {
            str = str2;
        }
        if (str == null) {
            x.e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
            eVar = null;
        } else {
            ad.VG(str);
            if (str.equals(ad.getPackageName())) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.WorkerProfile");
            } else if (str.equals(ad.getPackageName() + ":push")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.PusherProfile");
            } else if (str.equals(ad.getPackageName() + ":tools")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.ToolsProfile");
            } else if (str.equals(ad.getPackageName() + ":sandbox")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.SandBoxProfile");
            } else if (str.equals(ad.getPackageName() + ":exdevice")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.ExDeviceProfile");
            } else if (str.equals(ad.getPackageName() + ":TMAssistantDownloadSDKService")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.TMAssistantProfile");
            } else if (str.equals(ad.getPackageName() + ":nospace")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.NoSpaceProfile");
            } else if (str.equals(ad.getPackageName() + ":patch")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.PatchProfile");
            } else if (str.startsWith(ad.getPackageName() + ":appbrand")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.AppBrandProfile");
            } else if (str.startsWith(ad.getPackageName() + ":support")) {
                eVar = com.tencent.mm.compatible.loader.f.a(application, ".app.SupportProfile");
            } else {
                com.tencent.mm.sdk.a.b.z("MMApplication onCreate profile == null", "profile is null and initMMcore failed");
                eVar = null;
            }
            x.w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", str);
        }
        this.mProfileCompat = eVar;
        if (!(this.mProfileCompat == null || gVar.DZ())) {
            x.i(TAG, "before profile oncreate.");
            this.mProfileCompat.onCreate();
        }
        x.i(TAG, "after profile oncreate.");
        ((h) gVar).mProfileCompat = this.mProfileCompat;
        SharedPreferences sharedPreferences = gVar.gUt.getSharedPreferences("system_config_prefs", 0);
        if (sharedPreferences != null) {
            i = sharedPreferences.getInt("default_uin", 0);
        } else {
            i = 0;
        }
        x.i(TAG, "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", gVar.gQd, Long.valueOf(bi.bA(MMApplicationLike.sAppStartTime)), Long.valueOf(bi.bA(currentTimeMillis)), Integer.valueOf(i), w.hbv, com.tencent.mm.compatible.util.e.bnD);
        com.tencent.mm.i.a.a.a(new com.tencent.mm.i.a() {
            public final void b(au auVar) {
                if (com.tencent.mm.af.f.eG(auVar.field_talker)) {
                    auVar.ea(com.tencent.mm.af.a.e.HJ());
                }
            }

            public final String z(String str, int i) {
                if (com.tencent.mm.af.f.eG(str)) {
                    return com.tencent.mm.af.a.e.ku(((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI((long) i).gkD);
                }
                return com.tencent.mm.y.bd.HK();
            }

            public final String c(au auVar) {
                if (com.tencent.mm.af.f.eG(auVar.field_talker)) {
                    return com.tencent.mm.af.a.e.ku(auVar.gkD);
                }
                return null;
            }

            public final boolean eG(String str) {
                return com.tencent.mm.af.f.eG(str);
            }
        });
        com.tencent.mm.compatible.d.a.a(new com.tencent.mm.compatible.d.a.a() {
            public final void k(long j, long j2) {
                com.tencent.mm.plugin.report.service.g.pWK.a(853, j2, 1, false);
            }
        });
        if (gVar.DZ()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            k.b("hardcoder", getClass().getClassLoader());
            HardCoderJNI.initReporter(new com.tencent.mm.pluginsdk.f());
            currentTimeMillis = SystemClock.elapsedRealtime();
            x.i(TAG, "summerhardcoder initHardCoder[%d %d %d %d] take[%d]ms", Long.valueOf(com.tencent.mm.kernel.a.a.gST), Long.valueOf(com.tencent.mm.kernel.a.a.gSU), Long.valueOf(elapsedRealtime), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - com.tencent.mm.kernel.a.a.gST));
            HardCoderJNI.initHardCoder();
            s.hya = new s.a() {
                public final String Or() {
                    if (com.tencent.mm.sdk.platformtools.f.xmW) {
                        return ad.getContext().getString(R.l.eGS);
                    }
                    return ad.getContext().getString(R.l.eGR);
                }
            };
            com.tencent.mm.bx.f.a(new SQLiteTrace() {
                public final void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i, long j) {
                    try {
                        com.tencent.mm.y.d.b IV = com.tencent.mm.y.d.b.IV();
                        boolean isMainThread = ah.isMainThread();
                        String path = sQLiteDatabase.getPath();
                        if ((j > IV.hkO && isMainThread) || (j > IV.hkQ && !isMainThread)) {
                            for (String str2 : com.tencent.mm.y.d.b.hkW) {
                                if (!isMainThread && path.contains(str2)) {
                                    return;
                                }
                            }
                            if (i != 2 || !isMainThread || j >= IV.hkP) {
                                if (IV.hkt) {
                                    x.i("MicroMsg.SQLTraceManager", "mark stop as file is full !");
                                    return;
                                }
                                String toUpperCase = str.trim().toUpperCase();
                                if (toUpperCase.startsWith("INSERT") || toUpperCase.startsWith("UPDATE") || toUpperCase.startsWith("DELETE") || toUpperCase.startsWith("COMMIT") || toUpperCase.startsWith("SELECT")) {
                                    if (toUpperCase.startsWith("INSERT")) {
                                        toUpperCase = toUpperCase.substring(0, toUpperCase.indexOf("(", 0));
                                    } else if (toUpperCase.startsWith("COMMIT")) {
                                        toUpperCase = j > IV.hkR ? toUpperCase + "task:" + bi.chl() : null;
                                    }
                                    if (toUpperCase.length() > WXMediaMessage.TITLE_LENGTH_LIMIT) {
                                        toUpperCase = toUpperCase.substring(0, WXMediaMessage.TITLE_LENGTH_LIMIT) + "...";
                                    }
                                    if (!toUpperCase.trim().endsWith(";")) {
                                        toUpperCase = toUpperCase + ";";
                                    }
                                } else {
                                    toUpperCase = null;
                                }
                                if (!bi.oN(toUpperCase)) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    com.tencent.mm.y.d.b.a("tid", String.valueOf(Thread.currentThread().getId()), stringBuilder);
                                    com.tencent.mm.y.d.b.a("sql", toUpperCase, stringBuilder);
                                    com.tencent.mm.y.d.b.a("lastTime", String.valueOf(j), stringBuilder);
                                    com.tencent.mm.y.d.b.a("foreground", com.tencent.mm.sdk.a.b.foreground ? "1" : "0", stringBuilder);
                                    com.tencent.mm.y.d.b.a("tname", Thread.currentThread().getName(), stringBuilder);
                                    toUpperCase = stringBuilder.toString();
                                    x.d("MicroMsg.SQLTraceManager", "SQL Trace mark : " + toUpperCase);
                                    as.Dt().F(new com.tencent.mm.y.d.b.AnonymousClass3(toUpperCase));
                                }
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SQLiteTrace", e, "Failed to send trace.", new Object[0]);
                    }
                }

                public final void onConnectionObtained(SQLiteDatabase sQLiteDatabase, String str, long j, boolean z) {
                }

                public final void onConnectionPoolBusy(SQLiteDatabase sQLiteDatabase, String str, List<String> list, String str2) {
                    int cgq;
                    boolean z = HardCoderJNI.hcDBEnable;
                    int i = HardCoderJNI.hcDBDelayWrite;
                    int i2 = HardCoderJNI.hcDBCPU;
                    int i3 = HardCoderJNI.hcDBIO;
                    if (HardCoderJNI.hcDBThr) {
                        cgq = com.tencent.mm.kernel.g.Dt().cgq();
                    } else {
                        cgq = 0;
                    }
                    HardCoderJNI.startPerformance(z, i, i2, i3, cgq, HardCoderJNI.hcDBTimeoutBusy, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, PluginBigBallOfMud.TAG);
                }

                public final void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase) {
                }
            });
            com.tencent.mm.storage.e.xuM = new j() {
                public final String F(au auVar) {
                    int i = (auVar.field_bizChatId == -1 || !com.tencent.mm.af.f.eG(auVar.field_talker)) ? 0 : 1;
                    if (i == 0) {
                        return auVar.field_talker;
                    }
                    x.d(PluginBigBallOfMud.TAG, "mapNotifyInfo key:%s", auVar.field_talker + ":" + auVar.field_bizChatId);
                    return auVar.field_talker + ":" + auVar.field_bizChatId;
                }
            };
            t.a(new t.a() {
                public final boolean a(String str, String str2, PInt pInt) {
                    if (!com.tencent.mm.y.s.gI(str)) {
                        return false;
                    }
                    if (com.tencent.mm.af.f.eG(str)) {
                        if (com.tencent.mm.af.a.e.kq(str2)) {
                            pInt.value = 5;
                        } else {
                            pInt.value = 4;
                        }
                    } else if (com.tencent.mm.af.f.jZ(str)) {
                        pInt.value = 3;
                    } else if (com.tencent.mm.af.f.ka(str)) {
                        pInt.value = 0;
                    } else if (com.tencent.mm.af.f.jW(str)) {
                        pInt.value = 6;
                    } else {
                        pInt.value = 7;
                    }
                    return true;
                }
            });
            com.tencent.mm.plugin.messenger.foundation.a.s.b(new com.tencent.mm.cc.c<r>() {
                public final /* synthetic */ Object get() {
                    return new q();
                }
            });
            p aVar = new com.tencent.mm.modelmulti.a();
            p.a.a(69, aVar);
            p.a.a(68, aVar);
            p.a.a(22, aVar);
            p.a.a(13, aVar);
            p.a.a(15, aVar);
            p.a.a(23, aVar);
            p.a.a(25, aVar);
            p.a.a(24, aVar);
            p.a.a(33, aVar);
            p.a.a(35, aVar);
            p.a.a(44, aVar);
            p.a.a(999999, aVar);
            p.a.a(53, aVar);
            p.a.a(com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX, aVar);
            com.tencent.mm.ad.e cVar = new c();
            ((com.tencent.mm.plugin.messenger.foundation.a.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(cVar);
            com.tencent.mm.kernel.g.CN().a(681, cVar);
            com.tencent.mm.plugin.messenger.foundation.a.s.a(5, new k());
            com.tencent.mm.plugin.messenger.foundation.a.s.a(1, new r());
            com.tencent.mm.plugin.messenger.foundation.a.s.a(4, new g());
            ((b) com.tencent.mm.kernel.g.k(b.class)).addHandleAuthResponse(new a());
            com.tencent.mm.plugin.messenger.foundation.a.f lVar = new l();
            ((o) com.tencent.mm.kernel.g.h(o.class)).a((com.tencent.mm.plugin.messenger.foundation.a.k) lVar);
            ((o) com.tencent.mm.kernel.g.h(o.class)).a(lVar);
            com.tencent.mm.y.e.a(new b());
            com.tencent.mm.permission.b bVar = new com.tencent.mm.permission.b();
            new p().cfB();
            com.tencent.mm.kernel.g.CN().b(138, m.kBp);
            com.tencent.mm.kernel.g.CN().b(39, m.kBp);
            com.tencent.mm.kernel.g.CN().b(268369922, m.kBp);
            if (m.kBp == null) {
                m.kBp = new m();
            }
            com.tencent.mm.kernel.g.CN().a(138, m.kBp);
            com.tencent.mm.kernel.g.CN().a(39, m.kBp);
            com.tencent.mm.kernel.g.CN().a(268369922, m.kBp);
            o.cc(this.app);
            com.tencent.mm.aw.a.a.a("delchatroommember", new com.tencent.mm.aw.a.a() {
                public final com.tencent.mm.aw.a a(Map<String, String> map, au auVar) {
                    return new com.tencent.mm.aw.d(map, auVar);
                }
            });
            com.tencent.mm.aw.a.a.a("NewXmlChatRoomAccessVerifyApplication", new com.tencent.mm.aw.a.a() {
                public final com.tencent.mm.aw.a a(Map<String, String> map, au auVar) {
                    return new com.tencent.mm.aw.c(map, auVar);
                }
            });
            com.tencent.mm.aw.a.a.a("NewXmlChatRoomAccessVerifyApproval", new com.tencent.mm.aw.a.a() {
                public final com.tencent.mm.aw.a a(Map<String, String> map, au auVar) {
                    return new com.tencent.mm.aw.b(map, auVar);
                }
            });
            com.tencent.mm.aw.a.a.a("invokeMessage", new com.tencent.mm.aw.a.a() {
                public final com.tencent.mm.aw.a a(Map<String, String> map, au auVar) {
                    return new a(map, auVar);
                }
            });
            MMAppMgr mMAppMgr = this.appMgr;
            Context context = this.app;
            if (mMAppMgr.xSs == null) {
                mMAppMgr.xSs = new Receiver(mMAppMgr);
            }
            MMActivity.cnF();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mm.ui.ACTION_ACTIVE");
            intentFilter.addAction("com.tencent.mm.ui.ACTION_DEACTIVE");
            intentFilter.addAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
            intentFilter.addAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            intentFilter.addAction("MINIQB_OPEN_RET");
            context.registerReceiver(mMAppMgr.xSs, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
            q xVar = new com.tencent.mm.booter.x(com.tencent.mm.booter.c.aA(this.app));
            xVar.eg("MM");
            com.tencent.mm.platformtools.r.ifT = bi.a(xVar.eh(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
            com.tencent.mm.platformtools.r.ifb = bi.a(xVar.eh(".com.tencent.mm.debug.test.display_errcode"), false);
            com.tencent.mm.platformtools.r.ifc = bi.a(xVar.eh(".com.tencent.mm.debug.test.display_msgstate"), false);
            com.tencent.mm.platformtools.r.ifd = bi.a(xVar.eh(".com.tencent.mm.debug.test.network.simulate_fault"), false);
            com.tencent.mm.platformtools.r.ife = bi.a(xVar.eh(".com.tencent.mm.debug.test.network.force_touch"), false);
            com.tencent.mm.platformtools.r.iff = bi.a(xVar.eh(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
            com.tencent.mm.platformtools.r.ifg = bi.a(xVar.eh(".com.tencent.mm.debug.test.crashIsExit"), false);
            com.tencent.mm.platformtools.r.ifF = bi.getInt(bi.aD(xVar.getString(".com.tencent.mm.debug.datatransfer.times"), "0"), 0);
            com.tencent.mm.platformtools.r.ifG = bi.getInt(bi.aD(xVar.getString(".com.tencent.mm.debug.datatransfer.duration"), "0"), 0);
            com.tencent.mm.platformtools.r.ifi = bi.a(xVar.eh(".com.tencent.mm.debug.test.album_drop_table"), false);
            com.tencent.mm.platformtools.r.ifj = bi.a(xVar.eh(".com.tencent.mm.debug.test.album_dle_file"), false);
            com.tencent.mm.platformtools.r.ifk = bi.a(xVar.eh(".com.tencent.mm.debug.test.album_show_info"), false);
            com.tencent.mm.platformtools.r.ifl = bi.a(xVar.eh(".com.tencent.mm.debug.test.location_help"), false);
            com.tencent.mm.platformtools.r.ifo = bi.a(xVar.eh(".com.tencent.mm.debug.test.force_soso"), false);
            com.tencent.mm.platformtools.r.ifp = bi.a(xVar.eh(".com.tencent.mm.debug.test.simulatePostServerError"), false);
            com.tencent.mm.platformtools.r.ifq = bi.a(xVar.eh(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
            com.tencent.mm.platformtools.r.ifr = bi.a(xVar.eh(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
            com.tencent.mm.platformtools.r.ifu = bi.a(xVar.eh(".com.tencent.mm.debug.test.filterfpnp"), false);
            com.tencent.mm.platformtools.r.ifv = bi.a(xVar.eh(".com.tencent.mm.debug.test.testForPull"), false);
            int a = bi.a(xVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
            com.tencent.mm.platformtools.r.ifs = a;
            if (a != 4 && com.tencent.mm.platformtools.r.ifs > 0) {
                v.xuZ = com.tencent.mm.platformtools.r.ifs;
                x.e("MicroMsg.WorkerDebugger", "cdn thread num " + com.tencent.mm.platformtools.r.ifs);
            }
            com.tencent.mm.platformtools.r.ift = bi.a(xVar.eh(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
            com.tencent.mm.platformtools.r.ifw = bi.aD(xVar.getString(".com.tencent.mm.debug.server.host.http"), "");
            com.tencent.mm.platformtools.r.ifx = bi.aD(xVar.getString(".com.tencent.mm.debug.server.host.socket"), "");
            if (bi.a(xVar.eh(".com.tencent.mm.debug.test.show_full_version"), false)) {
                com.tencent.mm.sdk.platformtools.f.xmT = true;
            }
            try {
                a = Integer.decode(xVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
                com.tencent.mm.protocal.d.CX(a);
                new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
            } catch (Exception e) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                str = xVar.getString(".com.tencent.mm.debug.log.setapilevel");
                if (!bi.oN(str)) {
                    com.tencent.mm.protocal.d.DEVICE_TYPE = "android-" + str;
                    com.tencent.mm.protocal.d.vHg = "android-" + str;
                    com.tencent.mm.protocal.d.vHi = str;
                    com.tencent.mm.sdk.a.b.Vn(str);
                    new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.DEVICE_TYPE).append(" ").append(com.tencent.mm.sdk.a.b.cfy());
                }
            } catch (Exception e2) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                elapsedRealtime = Long.decode(xVar.getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.vHk).append(" new: ").append(elapsedRealtime);
                com.tencent.mm.protocal.d.vHk = elapsedRealtime;
            } catch (Exception e3) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                xVar.gAA.gzJ = Integer.decode(xVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            } catch (Exception e4) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                boolean a2 = bi.a(xVar.eh(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean a3 = bi.a(xVar.eh(".com.tencent.mm.debug.report.kvstat"), false);
                boolean a4 = bi.a(xVar.eh(".com.tencent.mm.debug.report.clientpref"), false);
                boolean a5 = bi.a(xVar.eh(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
                new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
            } catch (Exception e5) {
                x.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            com.tencent.mm.platformtools.r.ifA = bi.a(xVar.eh(".com.tencent.mm.debug.test.update_test"), false);
            com.tencent.mm.platformtools.r.ifB = bi.a(xVar.eh(".com.tencent.mm.debug.test.scan_save_image"), false);
            com.tencent.mm.platformtools.r.ifD = bi.a(xVar.eh(".com.tencent.mm.debug.test.shake_get_config_list"), false);
            com.tencent.mm.platformtools.r.ifE = bi.a(xVar.eh(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
            com.tencent.mm.platformtools.r.ifI = bi.aD(xVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
            x.d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.r.ifI);
            com.tencent.mm.platformtools.r.ifX = bi.aD(xVar.getString(".com.tencent.mm.debug.cdn.front"), "");
            com.tencent.mm.platformtools.r.ifY = bi.aD(xVar.getString(".com.tencent.mm.debug.cdn.zone"), "");
            com.tencent.mm.platformtools.r.ifZ = bi.aD(xVar.getString(".com.tencent.mm.debug.cdn.wifi_elt"), "");
            com.tencent.mm.platformtools.r.iga = bi.aD(xVar.getString(".com.tencent.mm.debug.cdn.nowifi_elt"), "");
            com.tencent.mm.platformtools.r.igb = bi.aD(xVar.getString(".com.tencent.mm.debug.cdn.ptl"), "");
            com.tencent.mm.platformtools.r.igc = bi.a(xVar.eh(".com.tencent.mm.debug.cdn.usestream"), false);
            com.tencent.mm.platformtools.r.igd = bi.a(xVar.eh(".com.tencent.mm.debug.cdn.onlysendetl"), false);
            com.tencent.mm.platformtools.r.ige = bi.a(xVar.eh(".com.tencent.mm.debug.cdn.onlysendptl"), false);
            com.tencent.mm.platformtools.r.igg = bi.a(xVar.eh(".com.tencent.mm.debug.cdn.enable_debug"), false);
            com.tencent.mm.platformtools.r.igh = bi.a(xVar.eh(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
            com.tencent.mm.platformtools.r.igi = bi.a(xVar.eh(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
            com.tencent.mm.platformtools.r.igo = bi.a(xVar.eh(".com.tencent.mm.debug.bakmove_hardcode"), false);
            x.d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + com.tencent.mm.platformtools.r.igo);
            com.tencent.mm.platformtools.r.igp = bi.aD(xVar.getString(".com.tencent.mm.debug.bakmove_ip"), "");
            com.tencent.mm.platformtools.r.igq = bi.getInt(bi.aD(xVar.getString(".com.tencent.mm.debug.bakmove_port"), "0"), 0);
            com.tencent.mm.platformtools.r.igl = bi.a(xVar.eh(".com.tencent.mm.debug.cursormode_enabled"), true);
            com.tencent.mm.platformtools.r.igN = bi.a(xVar.eh(".com.tencent.mm.debug.disaster_ignore_interval"), false);
            com.tencent.mm.platformtools.r.igO = bi.a(xVar.eh(".com.tencent.mm.debug.disaster_ignore_expire"), false);
            com.tencent.mm.platformtools.r.igP = bi.a(xVar.eh(".com.tencent.mm.debug.disaster_ignore_remove"), false);
            com.tencent.mm.platformtools.r.igB = bi.a(xVar.eh(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
            com.tencent.mm.platformtools.r.igD = bi.aD(xVar.getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), "");
            com.tencent.mm.platformtools.r.igC = bi.a(xVar.eh(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
            com.tencent.mm.platformtools.r.igE = bi.aD(xVar.getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), "");
            com.tencent.mm.platformtools.r.igK = bi.a(xVar.eh(".com.tencent.mm.debug.netmock"), false);
            ComponentName fd = bi.fd(ad.getContext());
            if (fd != null && fd.getPackageName().equals(ad.getPackageName()) && fd.getClassName().equals(ad.cgd())) {
                WorkerProfile.uv().fgE = true;
                WorkerProfile.uv().fgF = true;
                x.i(TAG, "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", fd.getPackageName(), fd.getClassName());
            } else {
                if (fd != null) {
                    x.i(TAG, "start time check onCreate appOnCreate currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", fd.getPackageName(), fd.getClassName());
                } else {
                    x.i(TAG, "start time check onCreate appOnCreate currentActivity == null");
                }
                if (!(fd == null || fd.getPackageName().equals(ad.getPackageName()))) {
                    WorkerProfile.uv().fgE = true;
                }
            }
            com.tencent.mm.y.d.b.IV();
            com.tencent.mm.y.d.b.setup();
            AppLogic.setCallBack(new AppCallBack(ad.getContext()));
            SmcLogic.setCallBack(new com.tencent.mm.plugin.report.service.h());
            com.tencent.mm.plugin.report.service.h.pWZ = (WorkerProfile) this.mProfileCompat;
            k.b(com.tencent.mm.sdk.a.xmq, getClass().getClassLoader());
            BaseEvent.onCreate();
            SmcLogic.SetDebugFlag(com.tencent.mm.plugin.report.a.c.pVH);
            str = TAG;
            String str3 = "SmcLogic, class loader %s, %s";
            Object[] objArr = new Object[2];
            if (getClass().getClassLoader() == null) {
                i = -1;
            } else {
                i = getClass().getClassLoader().hashCode();
            }
            objArr[0] = Integer.valueOf(i);
            if (Thread.currentThread().getContextClassLoader() == null) {
                i = -1;
            } else {
                i = Thread.currentThread().getContextClassLoader().hashCode();
            }
            objArr[1] = Integer.valueOf(i);
            x.i(str, str3, objArr);
            try {
                if (com.tencent.mm.compatible.util.d.fO(20)) {
                    x.i(TAG, "weird");
                    SmcLogic.setUin(0);
                }
            } catch (Throwable th) {
                x.printErrStackTrace(TAG, th, "", new Object[0]);
            }
            n nVar = (n) com.tencent.mm.kernel.g.k(n.class);
            com.tencent.mm.plugin.zero.a.d dVar2 = (com.tencent.mm.plugin.zero.a.d) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.zero.a.d.class);
            new com.tencent.mm.plugin.h.d().after(nVar).before(this);
            new com.tencent.mm.plugin.h.f().after((com.tencent.mm.plugin.h.b) new com.tencent.mm.plugin.h.b().after(nVar).before(this)).before(this);
            new com.tencent.mm.plugin.h.c().after(nVar).before(this);
            new com.tencent.mm.plugin.h.a().after(dVar2);
        }
        com.tencent.mm.pluginsdk.i.a.b.n.a(new com.tencent.mm.pluginsdk.i.a.a.a() {
            public final boolean nu(int i) {
                if (i != 39 || com.tencent.mm.plugin.ipcall.d.aTK()) {
                    return false;
                }
                return true;
            }
        });
        com.tencent.mm.x.g.b.a(new com.tencent.mm.cc.c<com.tencent.mm.x.c>() {
            public final /* synthetic */ Object get() {
                return new com.tencent.mm.x.c();
            }
        });
        com.tencent.mm.x.g.b.a(new com.tencent.mm.cc.c<com.tencent.mm.x.b>() {
            public final /* synthetic */ Object get() {
                return new com.tencent.mm.x.b();
            }
        });
        com.tencent.mm.x.g.b.a(new com.tencent.mm.cc.c<com.tencent.mm.x.e>() {
            public final /* synthetic */ Object get() {
                return new com.tencent.mm.x.e();
            }
        });
        com.tencent.mm.x.g.b.a(new com.tencent.mm.cc.c<com.tencent.mm.x.a>() {
            public final /* synthetic */ Object get() {
                return new com.tencent.mm.x.a();
            }
        });
        com.tencent.mm.x.g.b.a(new com.tencent.mm.cc.c<com.tencent.mm.x.f>() {
            public final /* synthetic */ Object get() {
                return new com.tencent.mm.x.f();
            }
        });
    }

    public void execute(g gVar) {
    }

    public void onTerminate() {
        x.i(TAG, "onTerminate(%s)", ad.By());
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onTerminate();
        }
        MMAppMgr mMAppMgr = this.appMgr;
        Context context = this.app;
        if (mMAppMgr.xSs != null) {
            context.unregisterReceiver(mMAppMgr.xSs);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onConfigurationChanged(configuration);
        }
        Resources resources = ad.getResources();
        if (resources instanceof com.tencent.mm.bv.a) {
            ((com.tencent.mm.bv.a) resources).ceL();
        }
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        x.i(TAG, "onTrimMemory, level = %d, process = %s", Integer.valueOf(i), ad.By());
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onTrimMemory(i);
        }
    }

    public void onCreate() {
    }

    public void onBaseContextAttached(Context context) {
    }
}
