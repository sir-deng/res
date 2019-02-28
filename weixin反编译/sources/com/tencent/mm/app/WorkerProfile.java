package com.tencent.mm.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.R;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.t;
import com.tencent.mm.ad.t.a;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.console.Shell;
import com.tencent.mm.console.Shell.Receiver;
import com.tencent.mm.f.a.ah;
import com.tencent.mm.f.a.bz;
import com.tencent.mm.f.a.cf;
import com.tencent.mm.f.a.es;
import com.tencent.mm.f.a.gg;
import com.tencent.mm.f.a.hd;
import com.tencent.mm.f.a.ie;
import com.tencent.mm.f.a.il;
import com.tencent.mm.f.a.ip;
import com.tencent.mm.f.a.ir;
import com.tencent.mm.f.a.ja;
import com.tencent.mm.f.a.kl;
import com.tencent.mm.f.a.kw;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.f.a.mz;
import com.tencent.mm.f.a.ns;
import com.tencent.mm.f.a.nx;
import com.tencent.mm.f.a.oe;
import com.tencent.mm.f.a.of;
import com.tencent.mm.f.a.og;
import com.tencent.mm.f.a.or;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.f.a.pl;
import com.tencent.mm.f.a.qx;
import com.tencent.mm.f.a.rn;
import com.tencent.mm.f.a.sk;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Statistics;
import com.tencent.mm.modelsfs.SFSContext.Statistics.BlockType;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.network.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity;
import com.tencent.mm.plugin.report.service.IKVReportNotify;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.age;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.mm.ui.tools.NewTaskUI;
import com.tencent.mm.y.ac;
import com.tencent.mm.y.ai;
import com.tencent.mm.y.aj;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bt;
import com.tencent.mm.y.f;
import com.tencent.mm.y.s;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public final class WorkerProfile extends e implements com.tencent.mm.ad.e, a, IKVReportNotify, ai, f.a {
    public static final String ffs = (ad.getPackageName());
    private static WorkerProfile fgy;
    private final Shell ffW = new Shell();
    private b fgA;
    private ac fgB;
    private boolean fgC;
    private boolean fgD = false;
    @Deprecated
    public boolean fgE;
    public boolean fgF;
    private final int fgG = 0;
    private final int fgH = 1;
    private int fgI;
    private final int fgJ = 2130706432;
    private StringBuilder fgK = new StringBuilder();
    private g fgL;
    private com.tencent.mm.g.b fgM;
    public final q fgN = new q();
    public final p fgO = new p();
    private final com.tencent.mm.console.a fgx = new com.tencent.mm.console.a();
    private aj fgz;
    protected Locale locale;

    public WorkerProfile() {
        fgy = this;
    }

    public static WorkerProfile uv() {
        return fgy;
    }

    public static void uw() {
    }

    public final void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        a.cl(ffs);
        x.v("MicroMsg.WorkerProfile", "workerProfile onCreate, step 1");
        x.i("MicroMsg.WorkerProfile", "start time check onCreate proc:%s pid:%d" + ffs + Process.myPid());
        x.i("MicroMsg.WorkerProfile", "appOnCreate start getAccStg %b, thread name %s", Boolean.valueOf(true), Thread.currentThread().getName());
        long currentTimeMillis2 = System.currentTimeMillis();
        com.tencent.mm.y.d.a IO = com.tencent.mm.y.d.a.IO();
        com.tencent.mm.y.d.a.ffI = ffs;
        if (ad.xnM) {
            x.i("MicroMsg.HandlerTraceManager", "trace setup delete old file ret: " + com.tencent.mm.loader.stub.b.deleteFile(com.tencent.mm.y.d.a.hkr));
        }
        IO.hkG = System.currentTimeMillis();
        ag.setLogCallback(new ag.b() {
            public final void onLog(Message message, Runnable runnable, Thread thread, long j, long j2, float f) {
                if (thread != null) {
                    long id = thread.getId();
                    String str = null;
                    if (j > a.this.hkv) {
                        if (message != null) {
                            str = "|HMonitor dispatch|msg = " + message + "|handler = " + message.getTarget() + "|threadName = " + thread.getName() + "|threadId = " + thread.getId() + "|priority = " + thread.getPriority() + "|usedTime = " + j + "|cpuTime = " + j2;
                        } else if (runnable != null) {
                            str = "|HMonitor run task|" + ag.dump(runnable, true);
                        }
                    } else if (j > a.this.hkw && id == a.hku) {
                        if (message != null) {
                            str = "|HMonitor dispatch|msg = " + message + "|handler = " + message.getTarget() + "|threadName = " + thread.getName() + "|threadId = " + thread.getId() + "|priority = " + thread.getPriority() + "|usedTime = " + j + "|cpuTime = " + j2;
                        } else if (runnable != null) {
                            str = "|HMonitor run task|" + ag.dump(runnable, true);
                        }
                    }
                    if (as.Dt().oFY.getLooper() == null) {
                        x.w("MicroMsg.HandlerTraceManager", "worker thread's looper is dead");
                        return;
                    }
                    long id2 = as.Dt().oFY.getLooper().getThread().getId();
                    if (runnable != null && j > a.this.hkB && id == id2) {
                        a aVar = new a();
                        aVar.hkL = j;
                        aVar.info = ag.dump(runnable, false);
                        if (a.this.hkI.size() >= a.this.hkC) {
                            a.this.hkI.pop();
                        }
                        a.this.hkI.add(aVar);
                    }
                    if (runnable != null && id == id2 && f > 0.0f && f <= 100.0f) {
                        Long[] f2;
                        if (f < 30.0f) {
                            f2 = a.this.hkF;
                            int i = (int) (f / 2.0f);
                            f2[i] = Long.valueOf(f2[i].longValue() + 1);
                        } else if (f < 40.0f) {
                            f2 = a.this.hkF;
                            f2[15] = Long.valueOf(f2[15].longValue() + 1);
                        } else if (f < 50.0f) {
                            f2 = a.this.hkF;
                            f2[16] = Long.valueOf(f2[16].longValue() + 1);
                        } else {
                            f2 = a.this.hkF;
                            f2[17] = Long.valueOf(f2[17].longValue() + 1);
                        }
                    }
                    if (System.currentTimeMillis() - a.this.hkG > ((long) a.this.hkE)) {
                        a.this.hkG = System.currentTimeMillis();
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= 18) {
                                break;
                            }
                            if (a.this.hkF[i3].longValue() > 0) {
                                com.tencent.mm.plugin.report.service.g.pWK.a(230, (long) i3, a.this.hkF[i3].longValue(), false);
                            }
                            i2 = i3 + 1;
                        }
                    }
                    if (str != null) {
                        if (!com.tencent.mm.sdk.a.b.foreground) {
                            x.i("MicroMsg.HandlerTraceManager", str);
                        }
                        if (!a.this.hkt) {
                            as.Dt().F(new Runnable(a.sDateFormat.format(new Date()) + str + "\n") {
                                public final void run() {
                                    a.a(a.this, a.hkr, r3);
                                }

                                public final String toString() {
                                    return super.toString() + "|mark";
                                }
                            });
                        }
                    }
                }
            }
        });
        ak.a("NetsceneQueue forbid in ", new ak.b() {
            public final String IU() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("worker thread id = " + as.Dt().oFY.getLooper().getThread().getId() + "[" + as.Dt().cgq() + "]\n");
                stringBuilder.append("#cpu freq(KHz)[max=" + m.yx() + ", min=" + m.yy() + ", cur=" + m.yz() + "]\n");
                LinkedList linkedList = new LinkedList(a.this.hkI);
                Iterator it = linkedList.iterator();
                stringBuilder.append("#done tasks size = " + linkedList.size() + 10);
                if (it != null) {
                    int i = 0;
                    while (it.hasNext() && i < a.this.hkD) {
                        stringBuilder.append("[index = " + i + " | taskinfo:" + ((a) it.next()).info + "]\n");
                        i++;
                    }
                }
                stringBuilder.append("\n#waiting" + as.Dt().cgs().dump(false));
                return stringBuilder.toString();
            }
        });
        as.CN().a(-1, (com.tencent.mm.ad.e) this);
        t.a(this);
        as.Hq().hgG = this;
        as.a(new n.a() {
            public final void eq(int i) {
                if ((i == 4 || i == 6) && as.Hp() && com.tencent.mm.kernel.g.Do().gRj && !as.Cz()) {
                    x.i("MicroMsg.WorkerProfile", "dkmsg Network connected , try send msg.");
                    as.CN().a(new j(), 0);
                }
            }
        });
        as.getSysCmdMsgExtension().a("getkvidkeystg", new bt.a() {
            public final void a(d.a aVar) {
                h.Jd(com.tencent.mm.platformtools.n.a(aVar.hoa.vNO));
            }
        }, true);
        Context context = this.app;
        com.tencent.mm.sdk.platformtools.f.eI(context);
        com.tencent.mm.sdk.platformtools.f.eJ(context);
        try {
            com.tencent.mm.c.a aVar;
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
            x.i("MicroMsg.WorkerProfile", "initChannelUtil sourceFile = %s", str);
            try {
                int bN = com.tencent.mm.a.e.bN(str);
                x.i("MicroMsg.WorkerProfile", "checkApkExternal, fileSize = %s", Integer.valueOf(bN));
                if (bN >= 8) {
                    com.tencent.mm.c.a.a w = com.tencent.mm.c.a.a.w(com.tencent.mm.a.e.e(str, bN - 8, 8));
                    if (w == null) {
                        x.e("MicroMsg.WorkerProfile", "checkApkExternal, header null");
                    } else if ((w.feh + 8) - 8 >= 0) {
                        com.tencent.mm.c.b bVar = new com.tencent.mm.c.b();
                        bVar.aH(com.tencent.mm.a.e.e(str, (bN - ((w.feh + 8) - 8)) - 8, (w.feh + 8) - 8));
                        aVar = new com.tencent.mm.c.a(bVar);
                        x.i("MicroMsg.WorkerProfile", "checkApkExternal, check ok");
                    } else {
                        x.e("MicroMsg.WorkerProfile", "checkApkExternal header wrong");
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                x.e("MicroMsg.WorkerProfile", "Exception in checkApkExternal, %s", e.getMessage());
            } catch (NameNotFoundException e2) {
                x.e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
            }
            aVar = com.tencent.mm.c.a.cg(str);
            c aA;
            int i;
            int i2;
            SharedPreferences sharedPreferences;
            int i3;
            int i4;
            Editor edit;
            Shell shell;
            Context context2;
            com.tencent.mm.pluginsdk.ui.j.a bVar2;
            com.tencent.mm.g.b bVar3;
            com.tencent.mm.k.a.a anonymousClass26;
            com.tencent.mm.plugin.report.service.g gVar;
            Object[] objArr;
            if (aVar == null || aVar.fef == null) {
                str = "MicroMsg.WorkerProfile";
                String str2 = "initChannelUtil something null %s";
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(aVar == null);
                x.e(str, str2, objArr2);
                c.tL();
                aA = c.aA(this.app);
                if (!(aA == null || aA.gzJ == -1)) {
                    com.tencent.mm.sdk.platformtools.f.fei = aA.gzJ;
                }
                context = this.app.getApplicationContext();
                i = com.tencent.mm.sdk.platformtools.f.fei;
                i2 = com.tencent.mm.protocal.d.vHl;
                if (context != null && i >= 0 && i2 >= 637534208) {
                    try {
                        sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                        i3 = sharedPreferences.getInt("channel", -1);
                        i4 = sharedPreferences.getInt("version", 0);
                        if (!(i3 == i && i4 == i2)) {
                            edit = sharedPreferences.edit();
                            edit.putInt("channel", i);
                            edit.putInt("version", i2);
                            edit.commit();
                        }
                    } catch (Throwable th) {
                    }
                }
                if (com.tencent.mm.sdk.platformtools.f.xmR > 0) {
                    com.tencent.mm.sdk.platformtools.f.xmT = true;
                }
                com.tencent.mm.bl.d.cdJ();
                com.tencent.mm.protocal.d.DEVICE_TYPE = "android-" + (bi.oN(com.tencent.mm.sdk.platformtools.f.fej) ? Integer.valueOf(VERSION.SDK_INT) : com.tencent.mm.sdk.platformtools.f.fej);
                if (!bi.oN(com.tencent.mm.sdk.a.b.cfy())) {
                    com.tencent.mm.protocal.d.DEVICE_TYPE = "android-" + com.tencent.mm.sdk.a.b.cfy();
                }
                x.v("MicroMsg.WorkerProfile", "set device type :%s  %s", com.tencent.mm.protocal.d.DEVICE_TYPE, com.tencent.mm.sdk.a.b.cfy());
                this.locale = MMActivity.initLanguage(this.app.getBaseContext());
                if (com.tencent.mm.sdk.a.b.cfx()) {
                    shell = this.ffW;
                    context2 = ad.getContext();
                    if (shell.gKq == null) {
                        shell.gKq = new Receiver();
                        context2.registerReceiver(shell.gKq, Shell.gKs);
                    }
                }
                com.tencent.mm.sdk.b.a.xmy.b(this.fgx);
                bVar2 = new b();
                x.d("MicroMsg.AvatarDrawable", "setLoader" + bVar2);
                com.tencent.mm.pluginsdk.ui.a.b.prd = bVar2;
                q.a.viZ = new q.e() {
                    public final void ar(Context context) {
                        MMAppMgr.b(context, true);
                    }

                    public final boolean uA() {
                        if (!(com.tencent.mm.protocal.d.vHo || com.tencent.mm.bl.d.TM("whatsnew"))) {
                            x.i("MicroMsg.MMAppMgr", "plugin cannot load");
                        }
                        return false;
                    }

                    public final void b(Context context, boolean z) {
                        MMAppMgr.b(context, z);
                    }
                };
                com.tencent.mm.kernel.g.a(o.class, new com.tencent.mm.kernel.c.d(this.fgO));
                com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.h.class, new com.tencent.mm.kernel.c.d(this.fgO));
                com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.j.class, new com.tencent.mm.kernel.c.d(this.fgO));
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.app.plugin.b.a.a());
                if (this.fgz == null) {
                    this.fgz = new com.tencent.mm.booter.notification.b(this.app);
                }
                this.fgM = new com.tencent.mm.g.b();
                bVar3 = this.fgM;
                x.i("MicroMsg.BroadcastController", "summerdiz init");
                com.tencent.mm.sdk.b.a.xmy.b(bVar3.gCK);
                if (this.fgC) {
                    a(null);
                    this.fgC = false;
                }
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<gg>() {
                    {
                        this.xmG = gg.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        for (String str : b.this.gUE.keySet()) {
                            c cVar = (c) b.this.gUE.get(str);
                            cVar.gUO.clear();
                            b.a(b.this, cVar);
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.a(new com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.d>() {
                    {
                        this.xmG = com.tencent.mm.f.a.d.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        com.tencent.mm.f.a.d dVar = (com.tencent.mm.f.a.d) bVar;
                        if (!(dVar == null || dVar.fnG == null)) {
                            com.tencent.mm.f.a.d.a aVar = dVar.fnG;
                            com.tencent.mm.kernel.g.Do();
                            aVar.fnH = com.tencent.mm.kernel.a.CE();
                            dVar.fnG.isReady = com.tencent.mm.kernel.g.Do().CF();
                            dVar.fnG.fnI = com.tencent.mm.kernel.g.Do().gRj;
                            x.i("MicroMsg.WorkerProfile", "summerasyncinit AccountInitializeStatus[%d, %b, %b, %b]", Integer.valueOf(dVar.fnG.cPf), Boolean.valueOf(dVar.fnG.fnH), Boolean.valueOf(dVar.fnG.isReady), Boolean.valueOf(dVar.fnG.fnI));
                            if (dVar.fnG.fnH && !(dVar.fnG.isReady && dVar.fnG.fnI)) {
                                com.tencent.mm.plugin.report.service.g.pWK.a(598, dVar.fnG.isReady ? 9 : 10, 1, false);
                                com.tencent.mm.plugin.report.service.g.pWK.a(598, com.tencent.mm.sdk.a.b.foreground ? 11 : 12, 1, false);
                                com.tencent.mm.plugin.report.service.g.pWK.a(598, (long) (dVar.fnG.cPf + 30), 1, false);
                            }
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.ui.bindqq.a());
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<ja>() {
                    {
                        this.xmG = ja.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        ja jaVar = (ja) bVar;
                        if (jaVar.fAx.aAk != 2 && jaVar.fAx.status == 0) {
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName(com.tencent.mm.ui.e.h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE");
                            ad.getContext().sendBroadcast(intent);
                        }
                        if (as.Hp()) {
                            if (jaVar.fAx.aAk == 3) {
                                ar.hhz.S("login_user_name", "");
                            } else {
                                ar arVar = ar.hhz;
                                as.Hm();
                                String str = (String) com.tencent.mm.y.c.Db().get(6, null);
                                as.Hm();
                                int intValue = ((Integer) com.tencent.mm.y.c.Db().get(9, null)).intValue();
                                as.Hm();
                                arVar.c(str, intValue, (String) com.tencent.mm.y.c.Db().get(5, null));
                            }
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<rn>() {
                    {
                        this.xmG = rn.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        rn rnVar = (rn) bVar;
                        if (rnVar.fKh.fKi == 3) {
                            NotifyReceiver.wM();
                        }
                        com.tencent.mm.bz.d.cmf().dh(rnVar.fKh.className, rnVar.fKh.fKi);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<il>() {
                    {
                        this.xmG = il.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        il ilVar = (il) bVar;
                        final String str = ilVar.fzK.imagePath;
                        final String str2 = ilVar.fzK.toUser;
                        final boolean booleanValue = ilVar.fzK.fzL.booleanValue();
                        final int i = ilVar.fzK.fzM;
                        if (ilVar.fzK.fzN.booleanValue()) {
                            as.Dt().F(new Runnable() {
                                public final void run() {
                                    com.tencent.mm.ap.n.Pt().a(0, i, str, str2, booleanValue, R.g.bAI);
                                }
                            });
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<pl>() {
                    {
                        this.xmG = pl.class.getName().hashCode();
                    }

                    private boolean a(pl plVar) {
                        byte[] bArr = plVar.fIi.data;
                        if (bArr != null) {
                            x.i("MicroMsg.WorkerProfile", "summerbadcr SilenceNotifyEvent callback data len:%d", Integer.valueOf(bArr.length));
                            final by byVar = new by();
                            try {
                                byVar.aH(bArr);
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                                x.e("MicroMsg.WorkerProfile", "summerbadcr SilenceNotifyEvent callback parse exception:" + e.getMessage());
                            }
                            as.Dt().F(new Runnable() {
                                public final void run() {
                                    if (as.Hp()) {
                                        x.i("MicroMsg.WorkerProfile", "summerbadcr SilenceNotifyEvent processAddMsgDigestList");
                                        new com.tencent.mm.modelmulti.a().a(byVar, new com.tencent.mm.plugin.bbom.q(true));
                                    }
                                }
                            });
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<sk>() {
                    {
                        this.xmG = sk.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        x.i("MicroMsg.WorkerProfile", "upload sql file");
                        com.tencent.mm.y.d.b.IV().iu(com.tencent.mm.y.d.b.is(com.tencent.mm.y.d.b.hkN + "MMSQL.trace"));
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<ot>() {
                    {
                        this.xmG = ot.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        ot otVar = (ot) bVar;
                        for (String jVar : bi.F(otVar.fHD.fHE.split(","))) {
                            as.CN().a(new j(jVar, otVar.fHD.content, otVar.fHD.type), 0);
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<or>() {
                    {
                        this.xmG = or.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        or orVar = (or) bVar;
                        for (String str : bi.F(orVar.fHs.toUser.split(","))) {
                            if (bi.oN(orVar.fHs.fHw)) {
                                WXMediaMessage wXMediaMessage = orVar.fHs.fzX;
                                String str2 = orVar.fHs.appId;
                                String str3 = orVar.fHs.appName;
                                int i = orVar.fHs.fHt;
                                String str4 = orVar.fHs.fHu;
                                String str5 = orVar.fHs.fHv;
                                String str6 = orVar.fHs.fHx;
                                String str7 = orVar.fHs.fHy;
                                String str8 = orVar.fHs.fHz;
                                String str9 = orVar.fHs.fHA;
                                String str10 = orVar.fHs.frp;
                                String str11 = orVar.fHs.fHB;
                                com.tencent.mm.sdk.e.c cVar = null;
                                com.tencent.mm.x.g.a aVar = new com.tencent.mm.x.g.a();
                                aVar.appId = str2;
                                aVar.appName = str3;
                                aVar.hcP = i;
                                aVar.fHu = str4;
                                aVar.fHv = str5;
                                aVar.fHx = str6;
                                aVar.fHy = str7;
                                aVar.fHz = str8;
                                aVar.fHA = str9;
                                aVar.fHB = str11;
                                str2 = l.b(aVar, wXMediaMessage, null);
                                x.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zo() + " content url:" + aVar.url + " lowUrl:" + aVar.hcL + " attachlen:" + aVar.hcM + " attachid:" + aVar.for + " attach file:" + str2);
                                String str12 = System.currentTimeMillis();
                                if (!bi.oN(str2)) {
                                    cVar = l.a(str12, aVar, str2);
                                    if (cVar == null) {
                                        com.tencent.mm.compatible.util.g.getLine();
                                    }
                                }
                                cg auVar = new au();
                                if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
                                    str2 = com.tencent.mm.ap.o.PC().a(6, wXMediaMessage.thumbData, aVar.type == 2, CompressFormat.PNG);
                                    x.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zo() + " thumbData MsgInfo path:" + str2);
                                    if (!bi.oN(str2)) {
                                        auVar.dV(str2);
                                        x.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + str2);
                                    }
                                }
                                if (cVar != null) {
                                    aVar.for = cVar.xrR;
                                }
                                auVar.setContent(com.tencent.mm.x.g.a.a(aVar, null, null));
                                auVar.eR(1);
                                auVar.dU(str);
                                auVar.aq(bb.hU(str));
                                auVar.eS(1);
                                auVar.setType(l.d(aVar));
                                if (com.tencent.mm.af.f.eG(auVar.field_talker)) {
                                    auVar.ea(com.tencent.mm.af.a.e.HJ());
                                    x.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", auVar.gkD);
                                }
                                as.Hm();
                                long Q = com.tencent.mm.y.c.Fh().Q(auVar);
                                x.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zo() + " msginfo insert id: " + Q);
                                if (Q < 0) {
                                    x.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.zo() + "insert msg failed :" + Q);
                                    com.tencent.mm.compatible.util.g.getLine();
                                } else {
                                    x.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + Q);
                                    auVar.ao(Q);
                                    com.tencent.mm.sdk.e.c gVar = new com.tencent.mm.x.g();
                                    gVar.field_xml = auVar.field_content;
                                    gVar.field_title = wXMediaMessage.title;
                                    gVar.field_type = wXMediaMessage.mediaObject.type();
                                    gVar.field_description = wXMediaMessage.description;
                                    gVar.field_msgId = Q;
                                    gVar.field_source = str3;
                                    an.bZF().b(gVar);
                                    if (cVar != null) {
                                        cVar.field_msgInfoId = Q;
                                        cVar.field_status = 101;
                                        an.aqK().c(cVar, new String[0]);
                                        an.bZH().run();
                                    } else {
                                        an.bZH();
                                        am.a.u(Q, str10);
                                    }
                                }
                            } else {
                                l.a(orVar.fHs.fzX, orVar.fHs.appId, orVar.fHs.appName, str, orVar.fHs.fHt, orVar.fHs.fHw);
                            }
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<oz>() {
                    {
                        this.xmG = oz.class.getName().hashCode();
                    }

                    public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        oz ozVar = (oz) bVar;
                        com.tencent.mm.ui.contact.e.a(ozVar.fHJ.intent, ozVar.fHJ.username);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.c>() {
                    {
                        this.xmG = com.tencent.mm.f.a.c.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        com.tencent.mm.f.a.c cVar = (com.tencent.mm.f.a.c) bVar;
                        Context context = cVar.fnE.fnF;
                        com.tencent.mm.ui.t.a(context, cVar.fnE.errType, cVar.fnE.errCode, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), null);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<ip>() {
                    {
                        this.xmG = ip.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        ip ipVar = (ip) bVar;
                        String str = ipVar.fzS.fzT;
                        String str2 = ipVar.fzS.url;
                        x.i("MicroMsg.WorkerProfile", "summertoken KickOffline callback wording[%s], url[%s]", str, str2);
                        com.tencent.mm.plugin.report.service.g.pWK.a(322, 21, 1, true);
                        Context cnu = LauncherUI.cnu();
                        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(4021);
                        String str3 = "%s|%s|%b";
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = str;
                        objArr2[1] = str2;
                        boolean z = cnu == null || cnu.isFinishing();
                        objArr2[2] = Boolean.valueOf(z);
                        objArr[1] = String.format(str3, objArr2);
                        gVar.h(11098, objArr);
                        if (cnu == null || cnu.isFinishing()) {
                            com.tencent.mm.plugin.report.service.g.pWK.a(322, 22, 1, true);
                            gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(4022);
                            str3 = "%s|%s|%b";
                            objArr2 = new Object[3];
                            objArr2[0] = str;
                            objArr2[1] = str2;
                            objArr2[2] = Boolean.valueOf(cnu == null);
                            objArr[1] = String.format(str3, objArr2);
                            gVar.h(11098, objArr);
                            x.w("MicroMsg.WorkerProfile", "summertoken KickOffline error LauncherUI is null launcherisFirst[%b], launcheruiOnTop[%b] return", Boolean.valueOf(WorkerProfile.this.fgE), Boolean.valueOf(WorkerProfile.this.fgF));
                        }
                        com.tencent.mm.ui.t.a(cnu, str, str2, new Intent().setClass(cnu, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864));
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<qx>() {
                    {
                        this.xmG = qx.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        qx qxVar = (qx) bVar;
                        Context context = qxVar.fJA.context;
                        String str = qxVar.fJA.fJB;
                        if (!(context == null || bi.oN(str))) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<kl>() {
                    {
                        this.xmG = kl.class.getName().hashCode();
                    }

                    @TargetApi(16)
                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        Notification a;
                        kl klVar = (kl) bVar;
                        int Ts = com.tencent.mm.be.l.TE().Ts();
                        int i = klVar.fCD.type;
                        String str = klVar.fCD.userName;
                        String WP = com.tencent.mm.bw.b.chK().WP(klVar.fCD.bgo);
                        if (WorkerProfile.this.fgL == null) {
                            WorkerProfile.this.fgL = new g(ad.getContext());
                        }
                        WorkerProfile.this.fgL;
                        int bYI = com.tencent.mm.bk.a.bYI();
                        Notification notification = new Notification();
                        notification.icon = R.g.icon;
                        notification.when = System.currentTimeMillis();
                        notification.flags = 16;
                        Intent intent = new Intent();
                        intent.setClassName(ad.getPackageName(), ad.getPackageName() + ".plugin.subapp.ui.friend.FMessageConversationUI");
                        intent.setFlags(335544320);
                        PendingIntent activity = PendingIntent.getActivity(ad.getContext(), 0, intent, 134217728);
                        if (i == 1) {
                            String string = ad.getContext().getString(R.l.ezj);
                            Bitmap a2 = com.tencent.mm.ac.b.a(str, false, -1);
                            String str2 = WP + string;
                            int i2 = R.g.bEt;
                            String string2 = ad.getContext().getString(R.l.eyZ);
                            int i3 = R.g.bEs;
                            String string3 = ad.getContext().getString(R.l.eiz);
                            Intent intent2 = new Intent();
                            intent2.setClassName(ad.getPackageName(), ad.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                            intent2.putExtra("friend_message_transfer_username", str);
                            intent2.setAction("friend_message_ignore_" + str);
                            PendingIntent activity2 = PendingIntent.getActivity(ad.getContext(), 0, intent2, 134217728);
                            intent2 = new Intent();
                            intent2.setClassName(ad.getPackageName(), ad.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                            intent2.putExtra("friend_message_transfer_username", str);
                            intent2.setAction("friend_message_accept_" + str);
                            a = as.getNotification().a(notification, bYI, activity, WP, string, str2, a2, i2, string2, activity2, i3, string3, PendingIntent.getActivity(ad.getContext(), 0, intent2, 134217728), str);
                        } else {
                            String str3;
                            String string4 = ad.getContext().getString(R.l.ezi);
                            if (Ts > 2) {
                                str3 = WP + ad.getContext().getString(R.l.ezf, new Object[]{Integer.valueOf(Ts)});
                            } else {
                                str3 = WP;
                            }
                            Bitmap decodeResource = BitmapFactory.decodeResource(ad.getContext().getResources(), bYI);
                            a = as.getNotification().a(notification, bYI, 1, activity, str3, string4, str3 + string4, decodeResource, str);
                        }
                        if (VERSION.SDK_INT >= 16) {
                            a.priority = 2;
                        }
                        if (str != null) {
                            WorkerProfile.this.fgI = 2130706432 | (str.hashCode() & 16777215);
                        } else {
                            WorkerProfile.this.fgI = 2130706432;
                        }
                        as.getNotification().a(WorkerProfile.this.fgI, a, false);
                        if (Ts == 0) {
                            com.tencent.mm.be.l.hUW = 0;
                        } else {
                            WorkerProfile.this.fgK.append(WorkerProfile.this.fgI + ",");
                            ad.getContext().getSharedPreferences("notify_newfriend_prep", 0).edit().putString("notify_newfriend_prep", WorkerProfile.this.fgK.toString()).commit();
                        }
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<ir>() {
                    {
                        this.xmG = ir.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        boolean z;
                        ir irVar = (ir) bVar;
                        Context context = irVar.fzV.context;
                        if (context == null) {
                            context = ad.getContext();
                        }
                        ir.b bVar2 = irVar.fzW;
                        String str = irVar.fzV.appId;
                        WXMediaMessage wXMediaMessage = irVar.fzV.fzX;
                        int i = irVar.fzV.showType;
                        com.tencent.mm.pluginsdk.model.app.g.a aVar = irVar.fzV.fzY;
                        Bundle bundle = irVar.fzV.frc;
                        if (context == null) {
                            x.e("MicroMsg.AppInfoLogic", "launch app failed: context is null");
                            if (aVar != null) {
                                aVar.cI(false);
                            }
                            z = false;
                        } else if (bi.oN(str)) {
                            x.e("MicroMsg.AppInfoLogic", "launch app failed: appid is null or nil");
                            if (aVar != null) {
                                aVar.cI(false);
                            }
                            z = false;
                        } else if (wXMediaMessage == null) {
                            x.e("MicroMsg.AppInfoLogic", "launch app failed: wxMsg is null");
                            if (aVar != null) {
                                aVar.cI(false);
                            }
                            z = false;
                        } else {
                            com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, true);
                            if (aZ == null) {
                                x.e("MicroMsg.AppInfoLogic", "get appinfo is null, appid is : [%s]", str);
                                if (aVar != null) {
                                    aVar.cI(false);
                                }
                                z = false;
                            } else if (aZ.field_status == 3) {
                                x.e("MicroMsg.AppInfoLogic", "requestAppShow fail, app is in blacklist, packageName = " + aZ.field_packageName);
                                if (aVar != null) {
                                    aVar.cI(false);
                                }
                                z = false;
                            } else {
                                z = com.tencent.mm.pluginsdk.model.app.g.a(context, aZ.field_packageName, wXMediaMessage, str, aZ.field_openId, i, aVar, bundle);
                            }
                        }
                        bVar2.fzZ = z;
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<es>() {
                    {
                        this.xmG = es.class.getName().hashCode();
                    }

                    private static boolean a(es esVar) {
                        if (esVar == null) {
                            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is null.");
                            return false;
                        } else if (!(esVar instanceof es)) {
                            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is not a instance of ExtCallBizEvent.");
                            return false;
                        } else if (esVar.fud == null) {
                            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event.data is null.");
                            return false;
                        } else {
                            Intent intent;
                            switch (esVar.fud.op) {
                                case 27:
                                    if (esVar.fud.selectionArgs == null || esVar.fud.selectionArgs.length < 2) {
                                        x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent selectionArgs error.");
                                        return true;
                                    }
                                    Object encode;
                                    String str = "";
                                    Object obj = esVar.fud.selectionArgs[0];
                                    String str2 = esVar.fud.selectionArgs[1];
                                    if (esVar.fud.selectionArgs.length >= 3) {
                                        Object oM = bi.oM(esVar.fud.selectionArgs[2]);
                                        try {
                                            encode = URLEncoder.encode(oM, "UTF-8");
                                        } catch (UnsupportedEncodingException e) {
                                            encode = oM;
                                        }
                                    } else {
                                        String encode2 = str;
                                    }
                                    if (obj == null || str2 == null) {
                                        x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent wrong args, %s, %s", obj, str2);
                                        return true;
                                    }
                                    int i;
                                    if (esVar.fud.selectionArgs.length >= 4) {
                                        str = esVar.fud.selectionArgs[3];
                                        if (!bi.oN(str)) {
                                            i = bi.getInt(str, 0);
                                            x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent jump biz tempSession");
                                            str = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{str2, obj, encode2, Integer.valueOf(i), Integer.valueOf(0)});
                                            intent = new Intent(esVar.fud.context, WXCustomSchemeEntryActivity.class);
                                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                            intent.setData(Uri.parse(str));
                                            intent.putExtra("translate_link_scene", 1);
                                            esVar.fud.context.startActivity(intent);
                                            return true;
                                        }
                                    }
                                    i = 0;
                                    x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent jump biz tempSession");
                                    str = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{str2, obj, encode2, Integer.valueOf(i), Integer.valueOf(0)});
                                    intent = new Intent(esVar.fud.context, WXCustomSchemeEntryActivity.class);
                                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                    intent.setData(Uri.parse(str));
                                    intent.putExtra("translate_link_scene", 1);
                                    esVar.fud.context.startActivity(intent);
                                    return true;
                                case 28:
                                    x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent open exdevice rank list.");
                                    Context context = esVar.fud.context;
                                    intent = new Intent(context, WXBizEntryActivity.class);
                                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                    intent.putExtra("key_command_id", 11);
                                    context.startActivity(intent);
                                    return true;
                                default:
                                    return AnonymousClass9.a(esVar.fud.context, esVar.fud.selectionArgs, esVar.fud.fnP, esVar.fud.cPf, esVar.fud.fue);
                            }
                        }
                    }

                    private static boolean a(Context context, String[] strArr, String[] strArr2, int i, String str) {
                        if (context == null) {
                            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:context is null.");
                            context = ad.getContext();
                        }
                        if (strArr == null || strArr.length < 2) {
                            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:args error.");
                            return false;
                        }
                        int i2;
                        int length = strArr.length;
                        for (i2 = 0; i2 < length; i2++) {
                            x.i("MicroMsg.WorkerProfile", "arg : %s", strArr[i2]);
                        }
                        String str2 = strArr[0];
                        String str3 = strArr[1];
                        String str4 = null;
                        if (strArr.length > 2) {
                            str4 = strArr[2];
                        }
                        length = 0;
                        if (strArr.length > 3) {
                            length = bi.getInt(strArr[3], 0);
                        }
                        int i3 = 0;
                        if (strArr.length > 4) {
                            i3 = bi.getInt(strArr[4], 0);
                        }
                        x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source(%d)", Integer.valueOf(i));
                        switch (i) {
                            case 1:
                                if (strArr2 == null || strArr2.length == 0) {
                                    x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:packageNames is null or nil.");
                                    return false;
                                }
                            case 2:
                                if (bi.oN(str)) {
                                    x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:fromURL(%s) is null or nil.", str);
                                    return false;
                                }
                                break;
                            default:
                                x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source is out of range.");
                                return false;
                        }
                        x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener: appId(%s), toUserName(%s), extInfo(%s), fromURL(%s)", str2, str3, str4, str);
                        if (bi.oN(str2) || bi.oN(str3)) {
                            x.e("MicroMsg.WorkerProfile", "appId or toUsername is null or nil.");
                            return false;
                        }
                        int i4 = 0;
                        if (length == 1) {
                            i4 = 8;
                        } else if (length == 0) {
                            i4 = 7;
                        }
                        Intent intent = new Intent(context, WXBizEntryActivity.class);
                        intent.putExtra("key_command_id", i4);
                        intent.putExtra("appId", str2);
                        intent.putExtra("toUserName", str3);
                        intent.putExtra("extInfo", str4);
                        intent.putExtra("source", i);
                        intent.putExtra("scene", length);
                        intent.putExtra("jump_profile_type", i3);
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864);
                        if (strArr2 != null && strArr2.length > 0) {
                            ArrayList arrayList = new ArrayList();
                            for (Object add : strArr2) {
                                arrayList.add(add);
                            }
                            intent.putStringArrayListExtra("androidPackNameList", arrayList);
                        }
                        context.startActivity(intent);
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<hd>() {
                    {
                        this.xmG = hd.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        hd hdVar = (hd) bVar;
                        if (hdVar == null || hdVar.fyh == null) {
                            x.w("MicroMsg.WorkerProfile", "summerdiz GetDisasterInfoEvent event null ret false");
                        } else {
                            final int i = hdVar.fyh.fyi;
                            final boolean z = hdVar.fyh.fyj;
                            x.i("MicroMsg.WorkerProfile", "summerdiz GetDisasterInfoEvent callback event noticeid[%d], manualauthSucc[%b]", Integer.valueOf(i), Boolean.valueOf(z));
                            as.Dt().F(new Runnable() {
                                public final void run() {
                                    as.CN().a(new com.tencent.mm.modelsimple.o(i, z), 0);
                                }
                            });
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<ns>() {
                    {
                        this.xmG = ns.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        au auVar = ((ns) bVar).fGB.fou;
                        if (auVar != null) {
                            x.i("MicroMsg.WorkerProfile", "resend msg, type:%d", Integer.valueOf(auVar.getType()));
                            long hU;
                            if (auVar.cjL()) {
                                af.aD(auVar);
                            } else if (auVar.cjT()) {
                                af.aE(auVar);
                            } else if (auVar.cjY()) {
                                af.aF(auVar);
                            } else if (auVar.cjV()) {
                                af.aH(auVar);
                            } else if (auVar.aNL()) {
                                af.aI(auVar);
                            } else if (auVar.cjZ()) {
                                af.aG(auVar);
                            } else if (auVar.aNJ()) {
                                x.i("MicroMsg.ResendMsgLogic", "resendAppMsg, msgId:%d", Long.valueOf(auVar.field_msgId));
                                hU = bb.hU(auVar.field_talker);
                                if (hU == auVar.field_createTime) {
                                    hU++;
                                }
                                auVar.aq(hU);
                                as.Hm();
                                com.tencent.mm.y.c.Fh().a(auVar.field_msgId, auVar);
                                String str = auVar.field_content;
                                int i = auVar.field_isSend;
                                String str2 = auVar.field_talker;
                                boolean z = s.gD(str2) || com.tencent.mm.y.m.gf(str2);
                                if (z && str != null && i == 0) {
                                    str = bb.hT(str);
                                }
                                com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
                                if ((fV == null || 19 != fV.type) && (fV == null || 24 != fV.type)) {
                                    l.aa(auVar);
                                } else {
                                    com.tencent.mm.sdk.b.b mvVar = new mv();
                                    mvVar.fFz.type = 4;
                                    mvVar.fFz.fFE = auVar;
                                    mvVar.fFz.toUser = auVar.field_talker;
                                    com.tencent.mm.sdk.b.a.xmy.m(mvVar);
                                }
                                bb.aL(auVar.field_msgId);
                            } else if (auVar.cjU()) {
                                af.aJ(auVar);
                            } else if (auVar.cjW() || auVar.cjX()) {
                                hU = bb.hU(auVar.field_talker);
                                if (hU == auVar.field_createTime) {
                                    hU++;
                                }
                                auVar.aq(hU);
                                as.Hm();
                                com.tencent.mm.y.c.Fh().a(auVar.field_msgId, auVar);
                                r nv = com.tencent.mm.modelvideo.o.Ub().nv(auVar.field_imgPath);
                                if (nv != null) {
                                    nv.hXs = auVar.field_createTime;
                                    nv.fEo = FileUtils.S_IWUSR;
                                    com.tencent.mm.modelvideo.o.Ub().b(nv);
                                    x.i("MicroMsg.ResendMsgLogic", "resendVideoMsg, msgId:%d, msgtime: %d, infotime:%d", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_createTime), Long.valueOf(nv.hXs));
                                }
                                as.Hm();
                                if (com.tencent.mm.y.c.isSDCardAvailable()) {
                                    com.tencent.mm.modelvideo.t.nI(auVar.field_imgPath);
                                } else {
                                    u.fJ(ad.getContext());
                                }
                            } else {
                                auVar.eR(5);
                                as.Hm();
                                com.tencent.mm.y.c.Fh().a(auVar.field_msgId, auVar);
                                x.e("MicroMsg.WorkerProfile", "resendMsg, unknown msg type");
                            }
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.h>() {
                    {
                        this.xmG = com.tencent.mm.f.a.h.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        String str = null;
                        com.tencent.mm.f.a.h hVar = (com.tencent.mm.f.a.h) bVar;
                        Context context = hVar.fnO.context;
                        if (context == null) {
                            x.e("MicroMsg.WorkerProfile", "add card to wx event, context is null");
                            return false;
                        }
                        String str2;
                        String str3;
                        String str4;
                        String str5;
                        String[] strArr = hVar.fnO.fnP;
                        if (strArr == null || strArr.length <= 0) {
                            str2 = null;
                            str3 = null;
                        } else {
                            str3 = strArr[0];
                            str2 = com.tencent.mm.a.g.s(p.aX(hVar.fnO.context, strArr[0])[0].toByteArray());
                        }
                        String[] strArr2 = hVar.fnO.selectionArgs;
                        if (strArr2 == null || strArr2.length <= 1) {
                            str4 = null;
                            str5 = null;
                        } else {
                            str4 = strArr2[0];
                            str5 = strArr2[1];
                        }
                        if (strArr2 != null && strArr2.length > 2) {
                            str = strArr2[2];
                        }
                        x.i("MicroMsg.WorkerProfile", "carlist = %s, appid = %s, transcation = %s", str5, str4, str);
                        Intent intent = new Intent(context, WXBizEntryActivity.class);
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(134217728).addFlags(67108864);
                        intent.putExtra("key_in_card_list", str5);
                        intent.putExtra("key_package_name", str3);
                        intent.putExtra("key_sign", str2);
                        intent.putExtra("key_from_scene", 8);
                        intent.putExtra("key_command_id", 9);
                        intent.putExtra("key_app_id", str4);
                        intent.putExtra("key_transaction", str);
                        context.startActivity(intent);
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.bi>() {
                    {
                        this.xmG = com.tencent.mm.f.a.bi.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        int i = 0;
                        com.tencent.mm.f.a.bi biVar = (com.tencent.mm.f.a.bi) bVar;
                        Context context = biVar.fqx.context;
                        if (context == null) {
                            x.e("MicroMsg.WorkerProfile", "choose card from wx event, context is null");
                            return false;
                        }
                        String[] strArr = biVar.fqx.fnP;
                        String str = null;
                        if (strArr != null && strArr.length > 0) {
                            str = strArr[0];
                            com.tencent.mm.a.g.s(p.aX(biVar.fqx.context, strArr[0])[0].toByteArray());
                        }
                        Object obj = biVar.fqx.selectionArgs;
                        if (obj == null || obj.length < 10) {
                            if (obj != null) {
                                i = obj.length;
                            }
                            x.e("MicroMsg.WorkerProfile", "ChooseCardFromWXEvent selectionArgs is null or length is < 10, the length is " + i);
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int i2 = 0; i2 < obj.length; i2++) {
                                stringBuilder.append(", selectionArgs[" + i2 + "]:" + obj[i2]);
                            }
                            x.i("MicroMsg.WorkerProfile", "ChooseCardFromWXEvent selectionArgs:", obj.toString());
                            Intent intent = new Intent(context, WXBizEntryActivity.class);
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(134217728).addFlags(67108864);
                            intent.putExtra("app_id", obj[0]);
                            intent.putExtra("shop_id", bi.getInt(obj[1], 0));
                            intent.putExtra("sign_type", obj[2]);
                            intent.putExtra("card_sign", obj[3]);
                            intent.putExtra("time_stamp", bi.getInt(obj[4], 0));
                            intent.putExtra("nonce_str", obj[5]);
                            intent.putExtra("card_tp_id", obj[6]);
                            intent.putExtra("card_type", obj[7]);
                            intent.putExtra("can_multi_select", bi.getInt(obj[8], 0));
                            intent.putExtra("key_from_scene", 8);
                            intent.putExtra("key_command_id", 16);
                            intent.putExtra("key_app_id", obj[0]);
                            intent.putExtra("key_package_name", str);
                            intent.putExtra("key_transaction", obj[9]);
                            context.startActivity(intent);
                        }
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<og>() {
                    {
                        this.xmG = og.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        og ogVar = (og) bVar;
                        Context context = ogVar.fGV.context;
                        if (context == null) {
                            x.e("MicroMsg.WorkerProfile", "context is null");
                        } else {
                            String[] strArr = ogVar.fGV.fnP;
                            String str = null;
                            String str2 = null;
                            if (strArr != null && strArr.length > 0) {
                                str = strArr[0];
                                str2 = com.tencent.mm.a.g.s(p.aX(ogVar.fGV.context, strArr[0])[0].toByteArray());
                            }
                            String[] strArr2 = ogVar.fGV.selectionArgs;
                            if (strArr2 == null || strArr2.length <= 0) {
                                x.e("MicroMsg.WorkerProfile", "args is null");
                            } else {
                                x.i("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle event, withType = %b", Boolean.valueOf(ogVar.fGV.fGW));
                                String str3;
                                String str4;
                                Intent intent;
                                com.tencent.mm.y.u.b t;
                                if (!ogVar.fGV.fGW) {
                                    str3 = null;
                                    str4 = null;
                                    if (strArr2 != null && strArr2.length > 1) {
                                        str3 = strArr2[0];
                                        str4 = strArr2[1];
                                    }
                                    x.i("MicroMsg.WorkerProfile", "open webview, appid = %s, url = %s", str3, str4);
                                    if (!(bi.oN(str3) || bi.oN(str4))) {
                                        x.i("MicroMsg.WorkerProfile", "url format = %s", String.format("weixin://dl/businessWebview/link?appid=%s&url=%s", new Object[]{str3, str4}));
                                        intent = new Intent(context, WXBizEntryActivity.class);
                                        intent.setData(Uri.parse(str4));
                                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                        intent.putExtra("key_package_name", str);
                                        intent.putExtra("translate_link_scene", 1);
                                        intent.putExtra("key_package_signature", str2);
                                        intent.putExtra("key_command_id", 12);
                                        t = com.tencent.mm.y.u.GQ().t("key_data_center_session_id", true);
                                        t.o("key_package_name", str);
                                        t.o("key_package_signature", str2);
                                        x.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", str, str2);
                                        context.startActivity(intent);
                                        return true;
                                    }
                                } else if (strArr2 == null || strArr2.length <= 0) {
                                    x.e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle fail, selectionArgs length invalid");
                                } else {
                                    str4 = strArr2[0];
                                    x.i("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent, typeStr = %s, appid = %s", strArr2[1], str4);
                                    String str5;
                                    switch (bi.Wo(str3)) {
                                        case 1:
                                            if (strArr2.length < 5) {
                                                x.e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle subscribe message, lenght = %d", Integer.valueOf(strArr2.length));
                                            }
                                            String str6 = strArr2[2];
                                            String str7 = strArr2[3];
                                            str5 = strArr2[4];
                                            x.i("MicroMsg.WorkerProfile", "openwebviewwithtype, appid = %s, type = %s, scene = %s, templateID = %s, reserved = %s", str4, Integer.valueOf(r3), str6, str7, str5);
                                            if (bi.oN(str4)) {
                                                x.e("MicroMsg.WorkerProfile", "openwebviewwithtype fail, appId is null");
                                                break;
                                            }
                                            str5 = Uri.encode(String.format("scene=%s&template_id=%s&reserved=%s", new Object[]{str6, str7, str5}));
                                            x.i("MicroMsg.WorkerProfile", "openwebviewwithtype url format = %s", String.format("weixin://dl/businessWebview/link?appid=%s&type=%d&query=%s", new Object[]{str4, Integer.valueOf(r3), str5}));
                                            intent = new Intent(context, WXBizEntryActivity.class);
                                            intent.setData(Uri.parse(str4));
                                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                            intent.putExtra("key_package_name", str);
                                            intent.putExtra("translate_link_scene", 1);
                                            intent.putExtra("key_package_signature", str2);
                                            intent.putExtra("key_command_id", 12);
                                            t = com.tencent.mm.y.u.GQ().t("key_data_center_session_id", true);
                                            t.o("key_package_name", str);
                                            t.o("key_package_signature", str2);
                                            x.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", str, str2);
                                            context.startActivity(intent);
                                            return true;
                                        default:
                                            if (strArr2.length < 3) {
                                                x.e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent fail, unknown type = %d", Integer.valueOf(r3));
                                                break;
                                            }
                                            str5 = strArr2[2];
                                            x.i("MicroMsg.WorkerProfile", "default url format = %s", String.format("weixin://dl/businessWebview/link?appid=%s&type=%d&query=%s", new Object[]{str4, Integer.valueOf(r3), str5}));
                                            intent = new Intent(context, WXBizEntryActivity.class);
                                            intent.setData(Uri.parse(str4));
                                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                            intent.putExtra("key_package_name", str);
                                            intent.putExtra("translate_link_scene", 1);
                                            intent.putExtra("key_package_signature", str2);
                                            intent.putExtra("key_command_id", 12);
                                            t = com.tencent.mm.y.u.GQ().t("key_data_center_session_id", true);
                                            t.o("key_package_name", str);
                                            t.o("key_package_signature", str2);
                                            x.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", str, str2);
                                            context.startActivity(intent);
                                            return true;
                                    }
                                }
                            }
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<oe>() {
                    {
                        this.xmG = oe.class.getName().hashCode();
                    }

                    private static boolean a(oe oeVar) {
                        String str = null;
                        String[] strArr = oeVar.fGT.selectionArgs;
                        if (strArr == null || strArr.length == 0) {
                            x.e("MicroMsg.WorkerProfile", "args is null");
                        } else if (strArr.length < 2) {
                            x.e("MicroMsg.WorkerProfile", "args must contain appid and username");
                        } else {
                            int i;
                            String str2;
                            Context context = oeVar.fGT.context;
                            String str3 = strArr[0];
                            String str4 = strArr[1];
                            String str5 = "";
                            if (strArr.length > 2) {
                                str5 = strArr[2];
                            }
                            if (strArr.length > 3) {
                                i = bi.getInt(strArr[3], 0);
                            } else {
                                i = 0;
                            }
                            if (!bi.oN(str5)) {
                                String[] split = str5.split("\\?");
                                if (split.length > 1) {
                                    str5 = split[0] + ".html?" + split[1];
                                } else {
                                    str5 = split[0] + ".html";
                                }
                                try {
                                    str5 = URLEncoder.encode(str5);
                                } catch (Exception e) {
                                    x.e("MicroMsg.WorkerProfile", "encode path failed : %s", e.getMessage());
                                    str5 = "";
                                }
                            }
                            String[] strArr2 = oeVar.fGT.fnP;
                            if (strArr2 == null || strArr2.length <= 0) {
                                str2 = null;
                            } else {
                                str2 = strArr2[0];
                                str = com.tencent.mm.a.g.s(p.aX(oeVar.fGT.context, strArr2[0])[0].toByteArray());
                            }
                            x.i("MicroMsg.WorkerProfile", "sdk launch wxminiprogram, appid = %s, username = %s, path = %s, type = %d", str3, str4, str5, Integer.valueOf(i));
                            x.i("MicroMsg.WorkerProfile", "sdk launch wxminiprogram, package name = %s, sig = %s", str2, str);
                            x.i("MicroMsg.WorkerProfile", "url format = %s", String.format("weixin://dl/jumpWxa/?appid=%s&userName=%s@app&path=%s", new Object[]{str3, str4, str5}));
                            Intent intent = new Intent(context, WXBizEntryActivity.class);
                            intent.setData(Uri.parse(str5));
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.putExtra("key_package_name", str2);
                            intent.putExtra("translate_link_scene", 1);
                            intent.putExtra("key_package_signature", str);
                            intent.putExtra("key_command_id", 19);
                            com.tencent.mm.y.u.b t = com.tencent.mm.y.u.GQ().t("key_data_center_session_id", true);
                            t.o("key_package_name", str2);
                            t.o("key_package_signature", str);
                            t.o("key_launch_miniprogram_type", Integer.valueOf(i));
                            x.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s, type = %d", str2, str, Integer.valueOf(i));
                            context.startActivity(intent);
                        }
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<ie>() {
                    {
                        this.xmG = ie.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        String str = null;
                        ie ieVar = (ie) bVar;
                        Context context = ieVar.fzw.context;
                        if (context == null) {
                            x.e("MicroMsg.WorkerProfile", "context is null");
                        } else {
                            String str2;
                            String str3;
                            String[] strArr = ieVar.fzw.fnP;
                            if (strArr == null || strArr.length <= 0) {
                                str2 = null;
                                str3 = null;
                            } else {
                                str3 = strArr[0];
                                str2 = com.tencent.mm.a.g.s(p.aX(ieVar.fzw.context, strArr[0])[0].toByteArray());
                            }
                            String[] strArr2 = ieVar.fzw.selectionArgs;
                            if (strArr2 == null || strArr2.length <= 0) {
                                x.e("MicroMsg.WorkerProfile", "args is null");
                            } else {
                                String str4;
                                if (strArr2 == null || strArr2.length <= 1) {
                                    str4 = null;
                                } else {
                                    str4 = strArr2[0];
                                    str = strArr2[1];
                                }
                                x.i("MicroMsg.WorkerProfile", "handleScanResult, appid = %s, scanResult = %s", str4, str);
                                if (!(bi.oN(str4) || bi.oN(str))) {
                                    str = String.format("weixin://dl/handleScanResult?appid=%s&result=%s", new Object[]{str4, str});
                                    Intent intent = new Intent(context, WXBizEntryActivity.class);
                                    intent.setData(Uri.parse(str));
                                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(134217728).addFlags(67108864);
                                    intent.putExtra("key_command_id", 17);
                                    intent.putExtra("key_package_name", str3);
                                    intent.putExtra("translate_link_scene", 1);
                                    intent.putExtra("key_package_signature", str2);
                                    context.startActivity(intent);
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<bz>() {
                    {
                        this.xmG = bz.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        bz bzVar = (bz) bVar;
                        Context context = bzVar.fqU.context;
                        if (context == null) {
                            x.e("MicroMsg.WorkerProfile", "CreateOrJoinChatroomEvent, context is null");
                            return false;
                        }
                        String[] strArr = bzVar.fqU.selectionArgs;
                        if (strArr == null || strArr.length < 2) {
                            x.e("MicroMsg.WorkerProfile", "CreateOrJoinChatroomEvent, invalid args");
                            return false;
                        }
                        String str;
                        int i;
                        String[] strArr2 = bzVar.fqU.fnP;
                        String str2 = "";
                        if (strArr2 != null && strArr2.length > 0) {
                            str2 = strArr2[0];
                        }
                        String str3 = strArr[0];
                        String str4 = strArr[1];
                        String str5 = strArr[2];
                        String str6 = "";
                        String str7 = "";
                        String str8 = "";
                        String str9 = "";
                        if (bzVar.fqU.action == 1) {
                            str = "action_create";
                            if (strArr.length >= 4) {
                                str6 = strArr[3];
                            }
                            if (strArr.length >= 5) {
                                str7 = strArr[4];
                            }
                            if (strArr.length >= 6) {
                                str8 = strArr[5];
                            }
                            if (strArr.length >= 7) {
                                str9 = strArr[6];
                            }
                            i = 14;
                        } else if (bzVar.fqU.action != 2) {
                            return false;
                        } else {
                            str = "action_join";
                            if (strArr.length >= 4) {
                                str7 = strArr[3];
                            }
                            if (strArr.length >= 5) {
                                str8 = strArr[4];
                            }
                            if (strArr.length >= 6) {
                                str9 = strArr[5];
                            }
                            i = 15;
                        }
                        Intent intent = new Intent(context, WXBizEntryActivity.class);
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(134217728).addFlags(67108864);
                        intent.putExtra("key_app_id", str3);
                        intent.putExtra("key_transaction", str4);
                        intent.putExtra("key_command_id", i);
                        intent.putExtra("action", str);
                        intent.putExtra("package_name", str2);
                        intent.putExtra("group_id", str5);
                        intent.putExtra("chatroom_name", str6);
                        intent.putExtra("chatroom_nickname", str7);
                        intent.putExtra("ext_msg", str8);
                        intent.putExtra("open_id", str9);
                        context.startActivity(intent);
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<of>() {
                    {
                        this.xmG = of.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        String str = null;
                        of ofVar = (of) bVar;
                        Context context = ofVar.fGU.context;
                        if (context == null) {
                            x.e("MicroMsg.WorkerProfile", "add card to wx event, context is null");
                        } else {
                            String str2;
                            String[] strArr = ofVar.fGU.fnP;
                            if (strArr == null || strArr.length <= 0) {
                                str2 = null;
                            } else {
                                str2 = strArr[0];
                                str = com.tencent.mm.a.g.s(p.aX(ofVar.fGU.context, strArr[0])[0].toByteArray());
                            }
                            strArr = ofVar.fGU.selectionArgs;
                            if (strArr != null && strArr.length >= 6) {
                                Intent intent = new Intent(context, WXBizEntryActivity.class);
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(134217728).addFlags(67108864);
                                intent.putExtra("key_way", 4);
                                intent.putExtra("appId", strArr[0]);
                                intent.putExtra("timeStamp", strArr[1]);
                                intent.putExtra("nonceStr", strArr[2]);
                                intent.putExtra("packageExt", strArr[5]);
                                intent.putExtra("signtype", strArr[3]);
                                intent.putExtra("paySignature", strArr[4]);
                                intent.putExtra("key_wxapi_package_name", str2);
                                intent.putExtra("key_wxapi_sign", str);
                                intent.putExtra("key_command_id", 13);
                                context.startActivity(intent);
                            }
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<kw>() {
                    {
                        this.xmG = kw.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        return uz();
                    }

                    private boolean uz() {
                        as.CN().a(1145, new com.tencent.mm.ad.e() {
                            public final void a(int i, int i2, String str, k kVar) {
                                as.CN().b(1145, (com.tencent.mm.ad.e) this);
                                x.i("MicroMsg.WorkerProfile", "onSceneEnd(GetServiceNotifyOptions), errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                                if (i == 0 && i2 == 0 && kVar.getType() == 1145) {
                                    com.tencent.mm.modelappbrand.l lVar = (com.tencent.mm.modelappbrand.l) kVar;
                                    if ((((age) lVar.hln.hnQ.hnY).wuK & 1) != 0) {
                                        boolean z = lVar.Jh().vSs;
                                        as.Hm();
                                        if (z != com.tencent.mm.y.c.Db().getBoolean(w.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                                            x.i("MicroMsg.WorkerProfile", "service notify message notice switch changed(to : %b)", Boolean.valueOf(z));
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, Boolean.valueOf(z));
                                            com.tencent.mm.sdk.b.a.xmy.m(new mz());
                                        }
                                        z = lVar.Jh().wuL;
                                        as.Hm();
                                        if (z != com.tencent.mm.y.c.Db().getBoolean(w.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                                            x.i("MicroMsg.WorkerProfile", "wxa custom session notify message notice switch changed(to : %b)", Boolean.valueOf(z));
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, Boolean.valueOf(z));
                                            com.tencent.mm.sdk.b.a.xmy.m(new mz());
                                        }
                                    }
                                }
                            }
                        });
                        as.CN().a(new com.tencent.mm.modelappbrand.l(5), 0);
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.e>() {
                    Runnable fgU;

                    {
                        this.fgU = new Runnable() {
                            int fgV;
                            long fgW;
                            Map<String, Statistics> fgX;

                            /* JADX WARNING: inconsistent code. */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void run() {
                                /*
                                r19 = this;
                                r0 = r19;
                                r2 = r0.fgW;
                                r4 = 0;
                                r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                                if (r2 == 0) goto L_0x0017;
                            L_0x000a:
                                r0 = r19;
                                r2 = r0.fgV;
                                com.tencent.mm.y.as.Hm();
                                r3 = com.tencent.mm.y.c.Cn();
                                if (r2 == r3) goto L_0x0025;
                            L_0x0017:
                                r19.load();
                                com.tencent.mm.y.as.Hm();
                                r2 = com.tencent.mm.y.c.Cn();
                                r0 = r19;
                                r0.fgV = r2;
                            L_0x0025:
                                r2 = java.lang.System.currentTimeMillis();
                                r0 = r19;
                                r4 = r0.fgW;
                                r2 = r2 - r4;
                                r4 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
                                r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                                if (r2 >= 0) goto L_0x0036;
                            L_0x0035:
                                return;
                            L_0x0036:
                                r7 = com.tencent.mm.modelsfs.FileOp.RD();
                                r0 = r19;
                                r2 = r0.fgX;
                                if (r2 == 0) goto L_0x0212;
                            L_0x0040:
                                r2 = r7.entrySet();
                                r8 = r2.iterator();
                            L_0x0048:
                                r2 = r8.hasNext();
                                if (r2 == 0) goto L_0x01ad;
                            L_0x004e:
                                r2 = r8.next();
                                r2 = (java.util.Map.Entry) r2;
                                r3 = r2.getValue();
                                r3 = (com.tencent.mm.modelsfs.SFSContext.Statistics) r3;
                                r0 = r19;
                                r4 = r0.fgX;
                                r5 = r2.getKey();
                                r4 = r4.get(r5);
                                r4 = (com.tencent.mm.modelsfs.SFSContext.Statistics) r4;
                                if (r4 == 0) goto L_0x0048;
                            L_0x006a:
                                if (r3 == 0) goto L_0x0048;
                            L_0x006c:
                                r5 = 1;
                                r5 = com.tencent.mm.app.WorkerProfile.21.AnonymousClass1.a(r3, r5);
                                r6 = 0;
                                r6 = com.tencent.mm.app.WorkerProfile.21.AnonymousClass1.a(r3, r6);
                                r9 = com.tencent.mm.plugin.report.service.g.pWK;
                                r10 = 12671; // 0x317f float:1.7756E-41 double:6.2603E-320;
                                r11 = 15;
                                r11 = new java.lang.Object[r11];
                                r12 = 0;
                                r13 = r2.getKey();
                                r11[r12] = r13;
                                r12 = 1;
                                r14 = r3.totalActualSize;
                                r13 = java.lang.Long.valueOf(r14);
                                r11[r12] = r13;
                                r12 = 2;
                                r14 = r3.blockSizeUsed;
                                r13 = java.lang.Long.valueOf(r14);
                                r11[r12] = r13;
                                r12 = 3;
                                r14 = r3.blockSizeEmpty;
                                r13 = java.lang.Long.valueOf(r14);
                                r11[r12] = r13;
                                r12 = 4;
                                r14 = r3.overflowActualSize;
                                r13 = java.lang.Long.valueOf(r14);
                                r11[r12] = r13;
                                r12 = 5;
                                r13 = java.lang.Integer.valueOf(r5);
                                r11[r12] = r13;
                                r12 = 6;
                                r13 = java.lang.Integer.valueOf(r6);
                                r11[r12] = r13;
                                r12 = 7;
                                r14 = r3.totalActualSize;
                                r0 = r4.totalActualSize;
                                r16 = r0;
                                r14 = r14 - r16;
                                r13 = java.lang.Long.valueOf(r14);
                                r11[r12] = r13;
                                r12 = 8;
                                r14 = r3.blockSizeUsed;
                                r0 = r4.blockSizeUsed;
                                r16 = r0;
                                r14 = r14 - r16;
                                r13 = java.lang.Long.valueOf(r14);
                                r11[r12] = r13;
                                r12 = 9;
                                r14 = r3.blockSizeEmpty;
                                r0 = r4.blockSizeEmpty;
                                r16 = r0;
                                r14 = r14 - r16;
                                r13 = java.lang.Long.valueOf(r14);
                                r11[r12] = r13;
                                r12 = 10;
                                r14 = r3.overflowActualSize;
                                r0 = r4.overflowActualSize;
                                r16 = r0;
                                r14 = r14 - r16;
                                r13 = java.lang.Long.valueOf(r14);
                                r11[r12] = r13;
                                r12 = 11;
                                r13 = 1;
                                r13 = com.tencent.mm.app.WorkerProfile.21.AnonymousClass1.a(r4, r13);
                                r5 = r5 - r13;
                                r5 = java.lang.Integer.valueOf(r5);
                                r11[r12] = r5;
                                r5 = 12;
                                r12 = 0;
                                r12 = com.tencent.mm.app.WorkerProfile.21.AnonymousClass1.a(r4, r12);
                                r6 = r6 - r12;
                                r6 = java.lang.Integer.valueOf(r6);
                                r11[r5] = r6;
                                r5 = 13;
                                r6 = r3.blockFiles;
                                r6 = r6.length;
                                r6 = java.lang.Integer.valueOf(r6);
                                r11[r5] = r6;
                                r12 = 14;
                                r6 = 0;
                                r13 = r3.blockFiles;
                                r14 = r13.length;
                                r5 = 0;
                                r18 = r5;
                                r5 = r6;
                                r6 = r18;
                            L_0x0129:
                                if (r6 >= r14) goto L_0x0136;
                            L_0x012b:
                                r15 = r13[r6];
                                r15 = r15.deleted;
                                if (r15 == 0) goto L_0x0133;
                            L_0x0131:
                                r5 = r5 + 1;
                            L_0x0133:
                                r6 = r6 + 1;
                                goto L_0x0129;
                            L_0x0136:
                                r5 = java.lang.Integer.valueOf(r5);
                                r11[r12] = r5;
                                r9.h(r10, r11);
                                r5 = 0;
                            L_0x0140:
                                r6 = r3.blockTypes;
                                r6 = r6.length;
                                if (r5 >= r6) goto L_0x0048;
                            L_0x0145:
                                r6 = r3.blockTypes;
                                r6 = r6[r5];
                                r9 = r4.blockTypes;
                                r9 = r9[r5];
                                r10 = com.tencent.mm.plugin.report.service.g.pWK;
                                r11 = 12672; // 0x3180 float:1.7757E-41 double:6.261E-320;
                                r12 = 8;
                                r12 = new java.lang.Object[r12];
                                r13 = 0;
                                r14 = r2.getKey();
                                r12[r13] = r14;
                                r13 = 1;
                                r14 = r6.blockSize;
                                r14 = java.lang.Integer.valueOf(r14);
                                r12[r13] = r14;
                                r13 = 2;
                                r14 = r6.usedCount;
                                r14 = java.lang.Integer.valueOf(r14);
                                r12[r13] = r14;
                                r13 = 3;
                                r14 = r6.emptyCount;
                                r14 = java.lang.Integer.valueOf(r14);
                                r12[r13] = r14;
                                r13 = 4;
                                r14 = r6.actualSize;
                                r14 = java.lang.Long.valueOf(r14);
                                r12[r13] = r14;
                                r13 = 5;
                                r14 = r6.usedCount;
                                r15 = r9.usedCount;
                                r14 = r14 - r15;
                                r14 = java.lang.Integer.valueOf(r14);
                                r12[r13] = r14;
                                r13 = 6;
                                r14 = r6.emptyCount;
                                r15 = r9.emptyCount;
                                r14 = r14 - r15;
                                r14 = java.lang.Integer.valueOf(r14);
                                r12[r13] = r14;
                                r13 = 7;
                                r14 = r6.actualSize;
                                r0 = r9.actualSize;
                                r16 = r0;
                                r14 = r14 - r16;
                                r6 = java.lang.Long.valueOf(r14);
                                r12[r13] = r6;
                                r10.h(r11, r12);
                                r5 = r5 + 1;
                                goto L_0x0140;
                            L_0x01ad:
                                r0 = r19;
                                r0.fgX = r7;
                                r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0205 }
                                r2 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
                                r4.<init>(r2);	 Catch:{ Exception -> 0x0205 }
                                r2 = "Reported SFS statistics:\n";
                                r4.append(r2);	 Catch:{ Exception -> 0x0205 }
                                r0 = r19;
                                r2 = r0.fgX;	 Catch:{ Exception -> 0x0205 }
                                r2 = r2.entrySet();	 Catch:{ Exception -> 0x0205 }
                                r5 = r2.iterator();	 Catch:{ Exception -> 0x0205 }
                            L_0x01ca:
                                r2 = r5.hasNext();	 Catch:{ Exception -> 0x0205 }
                                if (r2 == 0) goto L_0x0223;
                            L_0x01d0:
                                r2 = r5.next();	 Catch:{ Exception -> 0x0205 }
                                r0 = r2;
                                r0 = (java.util.Map.Entry) r0;	 Catch:{ Exception -> 0x0205 }
                                r3 = r0;
                                r2 = "===== ";
                                r6 = r4.append(r2);	 Catch:{ Exception -> 0x0205 }
                                r2 = r3.getKey();	 Catch:{ Exception -> 0x0205 }
                                r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0205 }
                                r2 = r6.append(r2);	 Catch:{ Exception -> 0x0205 }
                                r6 = " =====\n";
                                r6 = r2.append(r6);	 Catch:{ Exception -> 0x0205 }
                                r2 = r3.getValue();	 Catch:{ Exception -> 0x0205 }
                                r2 = (com.tencent.mm.modelsfs.SFSContext.Statistics) r2;	 Catch:{ Exception -> 0x0205 }
                                r2 = r2.toString();	 Catch:{ Exception -> 0x0205 }
                                r2 = r6.append(r2);	 Catch:{ Exception -> 0x0205 }
                                r3 = "\n\n";
                                r2.append(r3);	 Catch:{ Exception -> 0x0205 }
                                goto L_0x01ca;
                            L_0x0205:
                                r2 = move-exception;
                                r3 = "MicroMsg.WorkerProfile";
                                r4 = "";
                                r5 = 0;
                                r5 = new java.lang.Object[r5];
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
                            L_0x0212:
                                r2 = java.lang.System.currentTimeMillis();
                                r0 = r19;
                                r0.fgW = r2;
                                r0 = r19;
                                r0.fgX = r7;
                                r19.save();
                                goto L_0x0035;
                            L_0x0223:
                                r2 = "MicroMsg.WorkerProfile";
                                r3 = r4.toString();	 Catch:{ Exception -> 0x0205 }
                                com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ Exception -> 0x0205 }
                                goto L_0x0212;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.WorkerProfile.21.1.run():void");
                            }

                            private boolean load() {
                                Throwable th;
                                Throwable th2;
                                ObjectInputStream objectInputStream = null;
                                x.i("MicroMsg.WorkerProfile", "Load previous SFS statistics.");
                                ObjectInputStream objectInputStream2;
                                try {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    as.Hm();
                                    objectInputStream2 = new ObjectInputStream(new FileInputStream(stringBuilder.append(com.tencent.mm.y.c.FI()).append("sfs/sfs_stats.bin").toString()));
                                    try {
                                        this.fgW = objectInputStream2.readLong();
                                        this.fgX = (TreeMap) objectInputStream2.readObject();
                                        try {
                                            objectInputStream2.close();
                                        } catch (IOException e) {
                                        }
                                        return true;
                                    } catch (Exception e2) {
                                        objectInputStream = objectInputStream2;
                                        try {
                                            x.e("MicroMsg.WorkerProfile", "Can't read previous SFS statistics, use default.");
                                            this.fgW = System.currentTimeMillis();
                                            this.fgX = null;
                                            if (objectInputStream != null) {
                                                try {
                                                    objectInputStream.close();
                                                } catch (IOException e3) {
                                                }
                                            }
                                            return save();
                                        } catch (Throwable th3) {
                                            th = th3;
                                            objectInputStream2 = objectInputStream;
                                            th2 = th;
                                            if (objectInputStream2 != null) {
                                                try {
                                                    objectInputStream2.close();
                                                } catch (IOException e4) {
                                                }
                                            }
                                            throw th2;
                                        }
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                        if (objectInputStream2 != null) {
                                            objectInputStream2.close();
                                        }
                                        throw th2;
                                    }
                                } catch (Exception e5) {
                                    x.e("MicroMsg.WorkerProfile", "Can't read previous SFS statistics, use default.");
                                    this.fgW = System.currentTimeMillis();
                                    this.fgX = null;
                                    if (objectInputStream != null) {
                                        objectInputStream.close();
                                    }
                                    return save();
                                } catch (Throwable th32) {
                                    th = th32;
                                    objectInputStream2 = null;
                                    th2 = th;
                                    if (objectInputStream2 != null) {
                                        objectInputStream2.close();
                                    }
                                    throw th2;
                                }
                            }

                            private boolean save() {
                                Throwable e;
                                Throwable th;
                                ObjectOutputStream objectOutputStream = null;
                                x.i("MicroMsg.WorkerProfile", "Save previous SFS statistics.");
                                ObjectOutputStream objectOutputStream2;
                                try {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    as.Hm();
                                    String stringBuilder2 = stringBuilder.append(com.tencent.mm.y.c.FI()).append("sfs").toString();
                                    FileOp.ml(stringBuilder2);
                                    objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(stringBuilder2 + "/sfs_stats.bin"));
                                    try {
                                        Object treeMap;
                                        if (this.fgX != null) {
                                            treeMap = new TreeMap(this.fgX);
                                        }
                                        objectOutputStream2.writeLong(this.fgW);
                                        objectOutputStream2.writeObject(treeMap);
                                        try {
                                            objectOutputStream2.close();
                                        } catch (IOException e2) {
                                        }
                                        return true;
                                    } catch (IOException e3) {
                                        e = e3;
                                    }
                                } catch (IOException e4) {
                                    e = e4;
                                    objectOutputStream2 = null;
                                    try {
                                        x.printErrStackTrace("MicroMsg.WorkerProfile", e, "Can't read previous SFS statistics, use default.", new Object[0]);
                                        if (objectOutputStream2 == null) {
                                            return false;
                                        }
                                        try {
                                            objectOutputStream2.close();
                                            return false;
                                        } catch (IOException e5) {
                                            return false;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        objectOutputStream = objectOutputStream2;
                                        if (objectOutputStream != null) {
                                            try {
                                                objectOutputStream.close();
                                            } catch (IOException e6) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (objectOutputStream != null) {
                                        objectOutputStream.close();
                                    }
                                    throw th;
                                }
                            }

                            private static int a(Statistics statistics, boolean z) {
                                int i = 0;
                                for (BlockType blockType : statistics.blockTypes) {
                                    i += z ? blockType.usedCount : blockType.emptyCount;
                                }
                                return i;
                            }
                        };
                        this.xmG = com.tencent.mm.f.a.e.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        if (!((com.tencent.mm.f.a.e) bVar).fnJ.fnK && as.Hp()) {
                            as.Dt().F(this.fgU);
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<nx>() {
                    {
                        this.xmG = nx.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        com.tencent.mm.booter.notification.d.fp(0);
                        com.tencent.mm.booter.notification.d.aY(true);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xmy.b(new j(2, 12));
                com.tencent.mm.plugin.messenger.a.f.otT = new com.tencent.mm.ui.transmit.d();
                q.a.vjg = new com.tencent.mm.app.plugin.a();
                q.a.vjh = new com.tencent.mm.app.plugin.c();
                com.tencent.mm.pluginsdk.ui.d.b.a.vAZ = com.tencent.mm.app.plugin.d.uC();
                if (!as.Cz()) {
                    as.Hm();
                }
                com.tencent.mm.sdk.b.a.xmy.m(new cf());
                this.fgD = true;
                Log.setLogImpl(new ILog() {
                    public final void v(String str, String str2) {
                        x.v(str, str2);
                    }

                    public final void d(String str, String str2) {
                        x.d(str, str2);
                    }

                    public final void i(String str, String str2) {
                        x.i(str, str2);
                    }

                    public final void w(String str, String str2) {
                        x.w(str, str2);
                    }

                    public final void e(String str, String str2) {
                        x.e(str, str2);
                    }
                });
                x.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - currentTimeMillis2));
                context = ad.getContext();
                anonymousClass26 = new com.tencent.mm.k.a.a() {
                    final Map<String, Integer> fgZ = new HashMap();
                    final Map<String, Integer> map = new HashMap();

                    public final String cE(String str) {
                        if (this.map.containsKey(str)) {
                            return context.getString(((Integer) this.map.get(str)).intValue());
                        }
                        return null;
                    }

                    public final String cF(String str) {
                        if (this.fgZ.containsKey(str)) {
                            return context.getString(((Integer) this.fgZ.get(str)).intValue());
                        }
                        return null;
                    }
                };
                anonymousClass26.map.put("qqmail", Integer.valueOf(R.l.eoP));
                anonymousClass26.map.put("fmessage", Integer.valueOf(R.l.eon));
                anonymousClass26.map.put("floatbottle", Integer.valueOf(R.l.eoa));
                anonymousClass26.map.put("lbsapp", Integer.valueOf(R.l.eot));
                anonymousClass26.map.put("shakeapp", Integer.valueOf(R.l.eoZ));
                anonymousClass26.map.put("medianote", Integer.valueOf(R.l.eoC));
                anonymousClass26.map.put("qqfriend", Integer.valueOf(R.l.eoM));
                anonymousClass26.map.put("newsapp", Integer.valueOf(R.l.eoV));
                anonymousClass26.map.put("facebookapp", Integer.valueOf(R.l.eoh));
                anonymousClass26.map.put("masssendapp", Integer.valueOf(R.l.eoz));
                anonymousClass26.map.put("meishiapp", Integer.valueOf(R.l.eoF));
                anonymousClass26.map.put("feedsapp", Integer.valueOf(R.l.eok));
                anonymousClass26.map.put("voipapp", Integer.valueOf(R.l.epg));
                anonymousClass26.map.put("weixin", Integer.valueOf(R.l.ezV));
                anonymousClass26.map.put("filehelper", Integer.valueOf(R.l.enW));
                anonymousClass26.map.put("cardpackage", Integer.valueOf(R.l.eod));
                anonymousClass26.map.put("officialaccounts", Integer.valueOf(R.l.eoJ));
                anonymousClass26.map.put("voicevoipapp", Integer.valueOf(R.l.epj));
                anonymousClass26.map.put("helper_entry", Integer.valueOf(R.l.eoq));
                anonymousClass26.map.put("voiceinputapp", Integer.valueOf(R.l.epd));
                anonymousClass26.map.put("linkedinplugin", Integer.valueOf(R.l.eow));
                anonymousClass26.map.put("notifymessage", Integer.valueOf(R.l.eoG));
                anonymousClass26.map.put("gh_43f2581f6fd6", Integer.valueOf(R.l.epc));
                anonymousClass26.map.put("appbrandcustomerservicemsg", Integer.valueOf(R.l.enX));
                anonymousClass26.fgZ.put("weixin", Integer.valueOf(R.l.ezU));
                com.tencent.mm.k.a.a(anonymousClass26);
                if (!com.tencent.mm.compatible.util.f.zl()) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(340, com.tencent.mm.compatible.util.d.fN(19) ? 5 : 6, 1, false);
                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(com.tencent.mm.compatible.util.d.fN(19) ? 5001 : 5002);
                    objArr[1] = String.format("%s;%s;%s", new Object[]{com.tencent.mm.compatible.util.e.bnD, Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()});
                    gVar.h(11098, objArr);
                }
                x.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(this.fgE), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.fei), Integer.valueOf(com.tencent.mm.protocal.d.vHl), bi.fe(ad.getContext()));
            }
            x.i("MicroMsg.WorkerProfile", "apk external info not null");
            if (aVar.fef.fei != 0) {
                com.tencent.mm.sdk.platformtools.f.fei = aVar.fef.fei;
                x.i("MicroMsg.WorkerProfile", "read channelId from apk external");
            }
            if (aVar.fef.fek != 0) {
                com.tencent.mm.sdk.platformtools.f.fek = aVar.fef.fek;
                x.i("MicroMsg.WorkerProfile", "ext.updateMode = %s", Integer.valueOf(com.tencent.mm.sdk.platformtools.f.fek));
            }
            if (aVar.fef.fel != null) {
                com.tencent.mm.sdk.platformtools.f.xmR = bi.getInt(aVar.fef.fel, 0);
            }
            if (aVar.fef.fem != null) {
                com.tencent.mm.sdk.platformtools.f.xmS = aVar.fef.fem;
            }
            if (aVar.fef.fej != null) {
                com.tencent.mm.sdk.platformtools.f.fej = aVar.fef.fej;
            }
            if (aVar.fef.fep) {
                com.tencent.mm.sdk.platformtools.f.xmW = aVar.fef.fep;
                x.i("MicroMsg.WorkerProfile", "ext.isNokiaol = %s", Boolean.valueOf(com.tencent.mm.sdk.platformtools.f.xmW));
            }
            if (aVar.fef.feo != 0) {
                com.tencent.mm.sdk.platformtools.f.feo = aVar.fef.feo;
                x.i("MicroMsg.WorkerProfile", "ext.autoAddAccount = %s", Integer.valueOf(com.tencent.mm.sdk.platformtools.f.feo));
            }
            if (aVar.fef.fen) {
                com.tencent.mm.sdk.platformtools.f.xmV = aVar.fef.fen;
                x.i("MicroMsg.WorkerProfile", "ext.shouldShowGprsAlert = %s", Boolean.valueOf(com.tencent.mm.sdk.platformtools.f.xmV));
            }
            c.tL();
            aA = c.aA(this.app);
            com.tencent.mm.sdk.platformtools.f.fei = aA.gzJ;
            context = this.app.getApplicationContext();
            i = com.tencent.mm.sdk.platformtools.f.fei;
            i2 = com.tencent.mm.protocal.d.vHl;
            sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
            i3 = sharedPreferences.getInt("channel", -1);
            i4 = sharedPreferences.getInt("version", 0);
            edit = sharedPreferences.edit();
            edit.putInt("channel", i);
            edit.putInt("version", i2);
            edit.commit();
            if (com.tencent.mm.sdk.platformtools.f.xmR > 0) {
                com.tencent.mm.sdk.platformtools.f.xmT = true;
            }
            com.tencent.mm.bl.d.cdJ();
            if (bi.oN(com.tencent.mm.sdk.platformtools.f.fej)) {
            }
            com.tencent.mm.protocal.d.DEVICE_TYPE = "android-" + (bi.oN(com.tencent.mm.sdk.platformtools.f.fej) ? Integer.valueOf(VERSION.SDK_INT) : com.tencent.mm.sdk.platformtools.f.fej);
            if (bi.oN(com.tencent.mm.sdk.a.b.cfy())) {
                com.tencent.mm.protocal.d.DEVICE_TYPE = "android-" + com.tencent.mm.sdk.a.b.cfy();
            }
            x.v("MicroMsg.WorkerProfile", "set device type :%s  %s", com.tencent.mm.protocal.d.DEVICE_TYPE, com.tencent.mm.sdk.a.b.cfy());
            this.locale = MMActivity.initLanguage(this.app.getBaseContext());
            if (com.tencent.mm.sdk.a.b.cfx()) {
                shell = this.ffW;
                context2 = ad.getContext();
                if (shell.gKq == null) {
                    shell.gKq = new Receiver();
                    context2.registerReceiver(shell.gKq, Shell.gKs);
                }
            }
            com.tencent.mm.sdk.b.a.xmy.b(this.fgx);
            bVar2 = new b();
            x.d("MicroMsg.AvatarDrawable", "setLoader" + bVar2);
            com.tencent.mm.pluginsdk.ui.a.b.prd = bVar2;
            q.a.viZ = /* anonymous class already generated */;
            com.tencent.mm.kernel.g.a(o.class, new com.tencent.mm.kernel.c.d(this.fgO));
            com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.h.class, new com.tencent.mm.kernel.c.d(this.fgO));
            com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.j.class, new com.tencent.mm.kernel.c.d(this.fgO));
            com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.app.plugin.b.a.a());
            if (this.fgz == null) {
                this.fgz = new com.tencent.mm.booter.notification.b(this.app);
            }
            this.fgM = new com.tencent.mm.g.b();
            bVar3 = this.fgM;
            x.i("MicroMsg.BroadcastController", "summerdiz init");
            com.tencent.mm.sdk.b.a.xmy.b(bVar3.gCK);
            if (this.fgC) {
                a(null);
                this.fgC = false;
            }
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.a(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.ui.bindqq.a());
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xmy.b(new j(2, 12));
            com.tencent.mm.plugin.messenger.a.f.otT = new com.tencent.mm.ui.transmit.d();
            q.a.vjg = new com.tencent.mm.app.plugin.a();
            q.a.vjh = new com.tencent.mm.app.plugin.c();
            com.tencent.mm.pluginsdk.ui.d.b.a.vAZ = com.tencent.mm.app.plugin.d.uC();
            if (as.Cz()) {
                as.Hm();
            }
            com.tencent.mm.sdk.b.a.xmy.m(new cf());
            this.fgD = true;
            Log.setLogImpl(/* anonymous class already generated */);
            x.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - currentTimeMillis2));
            context = ad.getContext();
            anonymousClass26 = /* anonymous class already generated */;
            anonymousClass26.map.put("qqmail", Integer.valueOf(R.l.eoP));
            anonymousClass26.map.put("fmessage", Integer.valueOf(R.l.eon));
            anonymousClass26.map.put("floatbottle", Integer.valueOf(R.l.eoa));
            anonymousClass26.map.put("lbsapp", Integer.valueOf(R.l.eot));
            anonymousClass26.map.put("shakeapp", Integer.valueOf(R.l.eoZ));
            anonymousClass26.map.put("medianote", Integer.valueOf(R.l.eoC));
            anonymousClass26.map.put("qqfriend", Integer.valueOf(R.l.eoM));
            anonymousClass26.map.put("newsapp", Integer.valueOf(R.l.eoV));
            anonymousClass26.map.put("facebookapp", Integer.valueOf(R.l.eoh));
            anonymousClass26.map.put("masssendapp", Integer.valueOf(R.l.eoz));
            anonymousClass26.map.put("meishiapp", Integer.valueOf(R.l.eoF));
            anonymousClass26.map.put("feedsapp", Integer.valueOf(R.l.eok));
            anonymousClass26.map.put("voipapp", Integer.valueOf(R.l.epg));
            anonymousClass26.map.put("weixin", Integer.valueOf(R.l.ezV));
            anonymousClass26.map.put("filehelper", Integer.valueOf(R.l.enW));
            anonymousClass26.map.put("cardpackage", Integer.valueOf(R.l.eod));
            anonymousClass26.map.put("officialaccounts", Integer.valueOf(R.l.eoJ));
            anonymousClass26.map.put("voicevoipapp", Integer.valueOf(R.l.epj));
            anonymousClass26.map.put("helper_entry", Integer.valueOf(R.l.eoq));
            anonymousClass26.map.put("voiceinputapp", Integer.valueOf(R.l.epd));
            anonymousClass26.map.put("linkedinplugin", Integer.valueOf(R.l.eow));
            anonymousClass26.map.put("notifymessage", Integer.valueOf(R.l.eoG));
            anonymousClass26.map.put("gh_43f2581f6fd6", Integer.valueOf(R.l.epc));
            anonymousClass26.map.put("appbrandcustomerservicemsg", Integer.valueOf(R.l.enX));
            anonymousClass26.fgZ.put("weixin", Integer.valueOf(R.l.ezU));
            com.tencent.mm.k.a.a(anonymousClass26);
            if (com.tencent.mm.compatible.util.f.zl()) {
                if (com.tencent.mm.compatible.util.d.fN(19)) {
                }
                com.tencent.mm.plugin.report.service.g.pWK.a(340, com.tencent.mm.compatible.util.d.fN(19) ? 5 : 6, 1, false);
                gVar = com.tencent.mm.plugin.report.service.g.pWK;
                objArr = new Object[2];
                if (com.tencent.mm.compatible.util.d.fN(19)) {
                }
                objArr[0] = Integer.valueOf(com.tencent.mm.compatible.util.d.fN(19) ? 5001 : 5002);
                objArr[1] = String.format("%s;%s;%s", new Object[]{com.tencent.mm.compatible.util.e.bnD, Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()});
                gVar.h(11098, objArr);
            }
            x.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(this.fgE), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.fei), Integer.valueOf(com.tencent.mm.protocal.d.vHl), bi.fe(ad.getContext()));
        } catch (NameNotFoundException e22) {
            x.e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
        } catch (Exception e3) {
            x.e("MicroMsg.WorkerProfile", "Exception in initChannel, %s", e3.getMessage());
        }
    }

    public final void onTerminate() {
        super.onTerminate();
        com.tencent.mm.g.b bVar = this.fgM;
        x.i("MicroMsg.BroadcastController", "summerdiz release oldNoticeInfo[%s], newDisasterNoticeInfoMap[%d]", bVar.gCH, Integer.valueOf(bVar.gCJ.size()));
        com.tencent.mm.sdk.b.a.xmy.c(bVar.gCK);
        bVar.gCH = null;
        bVar.gCI.clear();
        bVar.gCJ.clear();
        this.fgM = null;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        String property = be.getProperty("system_property_key_locale");
        if (property != null && property.length() > 0) {
            this.locale = new Locale(property);
        }
        synchronized (this) {
            if (this.fgD) {
                a(configuration);
                return;
            }
            this.fgC = true;
        }
    }

    private void a(Configuration configuration) {
        com.tencent.mm.sdk.platformtools.w.c(configuration);
        String property = be.getProperty("system_property_key_locale");
        if (property != null && property.length() > 0) {
            if ("language_default".equalsIgnoreCase(property)) {
                this.locale = Locale.getDefault();
            } else {
                String[] split = property.split("_");
                if (split == null || split.length < 2) {
                    this.locale = new Locale(property);
                } else {
                    x.d("MicroMsg.WorkerProfile", "initLanguage arr.length = %s", Integer.valueOf(split.length));
                    this.locale = new Locale(split[0], split[1]);
                }
            }
        }
        Locale initLanguage = MMActivity.initLanguage(this.app.getBaseContext());
        x.d("MicroMsg.WorkerProfile", "onConfigurationChanged, locale = %s, n = %s, lang = %s", this.locale, initLanguage, property);
        if (initLanguage != null && this.locale != null && !initLanguage.equals(this.locale)) {
            if (as.Hp()) {
                try {
                    com.tencent.mm.network.e eVar = as.CN().hoF;
                    if (eVar != null) {
                        com.tencent.mm.network.c KD = eVar.KD();
                        if (KD != null) {
                            byte[] bArr = new byte[0];
                            as.Hm();
                            KD.v(bArr, com.tencent.mm.y.c.Cn());
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                    x.printErrStackTrace("MicroMsg.WorkerProfile", e, "what the f$!k", new Object[0]);
                }
            }
            x.w("MicroMsg.WorkerProfile", "language changed, restart process");
            System.exit(-1);
        }
    }

    public final String toString() {
        return ffs;
    }

    public final aj getNotification() {
        if (this.fgz == null) {
            this.fgz = new com.tencent.mm.booter.notification.b(this.app);
        }
        return this.fgz;
    }

    public final b ux() {
        if (this.fgA == null) {
            this.fgA = new b() {
                public final void a(au auVar, PString pString, PString pString2, PInt pInt, boolean z) {
                    com.tencent.mm.booter.notification.a.h.b(auVar, pString, pString2, pInt, z);
                }

                public final String a(int i, String str, String str2, int i2, Context context) {
                    return com.tencent.mm.booter.notification.a.h.a(i, str, str2, i2, context);
                }
            };
        }
        return this.fgA;
    }

    public final ac uy() {
        if (this.fgB == null) {
            this.fgB = com.tencent.mm.booter.a.wG();
        }
        return this.fgB;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WorkerProfile", "onSceneEnd dkwt type:%d [%d,%d,%s]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 3 && i2 == -1) {
            x.i("MicroMsg.WorkerProfile", "getStack([ %s ]), ThreadID: %s", bi.chl(), Long.valueOf(Thread.currentThread().getId()));
        }
        com.tencent.mm.sdk.b.b ahVar;
        Intent intent;
        if (i == 4 && i2 == -3002) {
            if (bi.oN(str)) {
                x.e("MicroMsg.WorkerProfile", "summerdiz -3002 but errMsg is null");
                return;
            }
            if (str.startsWith("autoauth_errmsg_")) {
                str = str.substring(16);
            }
            x.i("MicroMsg.WorkerProfile", "summerdiz MM_ERR_IDCDISASTER -3002 errStr:%s", str);
            ahVar = new ah();
            ahVar.fpb.type = 4;
            ahVar.fpb.fpd = str;
            com.tencent.mm.sdk.b.a.xmy.m(ahVar);
        } else if (as.Hp() && i == 4 && ((i2 == -6 || i2 == -310 || i2 == -311) && str != null && str.startsWith("autoauth_errmsg_"))) {
            if (NewTaskUI.cyO() == null) {
                intent = new Intent();
                intent.setClass(ad.getContext(), NewTaskUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                ad.getContext().startActivity(intent);
            }
        } else if (i == 4 && i2 == -213) {
            ahVar = new ja();
            ahVar.fAx.status = 0;
            ahVar.fAx.aAk = 3;
            com.tencent.mm.sdk.b.a.xmy.m(ahVar);
            if (AccountDeletedAlphaAlertUI.cym() == null) {
                intent = new Intent();
                intent.setClass(ad.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("errmsg", str);
                ad.getContext().startActivity(intent);
            }
        }
    }

    public final void onReportKVDataReady(byte[] bArr, final byte[] bArr2, final int i) {
        as.Dt().F(new Runnable() {
            public final void run() {
                if (!as.Hf()) {
                    x.i("MicroMsg.WorkerProfile", "summeranrt onReportKVDataReady channel:" + i);
                    as.CN().a(new com.tencent.mm.plugin.report.b.e(bArr2, i), 0);
                }
            }
        });
    }

    public final void cC(String str) {
        x.i("MicroMsg.WorkerProfile", "summerdiz onOldDisaster errStr[%s]", str);
        com.tencent.mm.sdk.b.b ahVar = new ah();
        ahVar.fpb.type = 4;
        ahVar.fpb.fpd = str;
        com.tencent.mm.sdk.b.a.xmy.m(ahVar);
    }

    public final void cD(String str) {
        x.i("MicroMsg.WorkerProfile", "summerdiz onReMoveNoticeId:%s", str);
        com.tencent.mm.sdk.b.b ahVar = new ah();
        ahVar.fpb.type = 1;
        ahVar.fpb.fpd = str;
        com.tencent.mm.sdk.b.a.xmy.m(ahVar);
    }
}
