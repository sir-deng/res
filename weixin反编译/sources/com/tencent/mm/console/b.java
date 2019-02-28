package com.tencent.mm.console;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.console.a.a;
import com.tencent.mm.console.a.c;
import com.tencent.mm.console.a.d;
import com.tencent.mm.console.a.e;
import com.tencent.mm.console.a.f;
import com.tencent.mm.console.a.g;
import com.tencent.mm.console.a.h;
import com.tencent.mm.console.a.i;
import com.tencent.mm.console.a.j;
import com.tencent.mm.console.a.k;
import com.tencent.mm.console.a.l;
import com.tencent.mm.f.a.bc;
import com.tencent.mm.f.a.bj;
import com.tencent.mm.f.a.bl;
import com.tencent.mm.f.a.cd;
import com.tencent.mm.f.a.ci;
import com.tencent.mm.f.a.cj;
import com.tencent.mm.f.a.ck;
import com.tencent.mm.f.a.cl;
import com.tencent.mm.f.a.fp;
import com.tencent.mm.f.a.md;
import com.tencent.mm.f.a.po;
import com.tencent.mm.f.a.pr;
import com.tencent.mm.f.a.qc;
import com.tencent.mm.f.a.qh;
import com.tencent.mm.f.a.tv;
import com.tencent.mm.f.a.tx;
import com.tencent.mm.f.a.y;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.i.a.b.m;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.ui.applet.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.atc;
import com.tencent.mm.protocal.c.atd;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.o;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.y.ah;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.az;
import com.tencent.mm.y.ba;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bd;
import com.tencent.mm.y.be;
import com.tencent.mm.y.q;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.wcdb.FileUtils;
import com.tencent.xweb.WebView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class b {
    static {
        c.init();
        h.init();
        i.init();
        f.init();
        d.init();
        e.init();
        a.init();
        com.tencent.mm.console.a.b.init();
        k.init();
        g.init();
        j.init();
        l.init();
        try {
            Class.forName("com.tencent.mm.console.a.b.a");
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.CommandProcessor", th, "", new Object[0]);
        }
        com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a.a(), "//fsd");
        com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a.b(), "//hcsetting");
    }

    private static int fa(String str) {
        if (!str.startsWith("//") || str.length() <= 2) {
            return 0;
        }
        int indexOf = str.indexOf(" ");
        if (indexOf == -1) {
            indexOf = str.length();
        }
        try {
            indexOf = bi.getInt(str.substring(2, indexOf), 0);
            int i = com.tencent.mm.protocal.d.vHl % 256;
            if (i == 0 || indexOf < i || indexOf % i != 0) {
                return 0;
            }
            return indexOf / i;
        } catch (Exception e) {
            return 0;
        }
    }

    private static String fb(String str) {
        int indexOf = str.indexOf(" ");
        if (indexOf < 0) {
            return "";
        }
        return str.substring(indexOf).trim();
    }

    public static boolean u(final Context context, final String str) {
        if (!str.startsWith("//")) {
            return false;
        }
        if (com.tencent.mm.pluginsdk.cmd.b.aU(context, str)) {
            return true;
        }
        StringBuilder stringBuilder;
        View textView;
        int dimensionPixelSize;
        String[] split;
        SharedPreferences sharedPreferences;
        Editor edit;
        if (str.startsWith("//clearWXSNSDB")) {
            com.tencent.mm.sdk.b.a.xmy.m(new po());
            return true;
        } else if (str.startsWith("//verifytokenerror")) {
            r.igF = true;
            return true;
        } else if (str.startsWith("//resetbackupdata")) {
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.valueOf(false));
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.valueOf(false));
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.valueOf(false));
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_BACKUP_MOVE_BACKUPING_BOOLEAN, Boolean.valueOf(false));
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.valueOf(false));
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.valueOf(false));
            as.Hm().FS().ciy();
            as.Hm().FT().ciy();
            as.Hm().FR().ciy();
            Toast.makeText(ad.getContext(), "backup data has been reset!", 1).show();
            return true;
        } else if (str.equalsIgnoreCase("//ftsmsbiz")) {
            atd Re = com.tencent.mm.bb.d.Re();
            stringBuilder = new StringBuilder();
            Iterator it = Re.kyB.iterator();
            while (it.hasNext()) {
                atc atc = (atc) it.next();
                stringBuilder.append(String.format("%s | %.2f | %s", new Object[]{com.tencent.mm.y.r.gw(atc.vPp), Double.valueOf(atc.wHr), n.ak("yyyy-MM-dd HH:mm", atc.wHs / 1000)}));
                stringBuilder.append("\n");
            }
            textView = new TextView(context);
            textView.setText(stringBuilder.toString());
            textView.setGravity(19);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setTextColor(-16711936);
            textView.setTypeface(Typeface.MONOSPACE);
            dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bvw);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            com.tencent.mm.ui.base.h.a(context, null, textView, null);
            return true;
        } else if (str.startsWith("//setgamejs")) {
            split = str.split(" ");
            if (split.length == 2) {
                if (split[1] == null || split[1].isEmpty() || split[1].endsWith("/")) {
                    u.makeText(context, "param set error, please don't end with /", 0).show();
                } else {
                    sharedPreferences = ad.getContext().getSharedPreferences("app_brand_global_sp", 0);
                    if (sharedPreferences != null) {
                        edit = sharedPreferences.edit();
                        edit.remove("app_brand_game_js_path");
                        edit.commit();
                        if (!split[1].equalsIgnoreCase("null")) {
                            edit.putString("app_brand_game_js_path", split[1]);
                            edit.commit();
                        }
                    }
                }
            }
            return true;
        } else {
            if (com.tencent.mm.sdk.a.b.cfx()) {
                if (str.startsWith("//launchapp clear")) {
                    com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_LAUNCH_APP_NOT_ASK_PKG_STRING, (Object) "");
                    return true;
                } else if (str.startsWith("//setsupportwxcode")) {
                    com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, Boolean.valueOf(true));
                    return true;
                } else if (str.startsWith("//setnotsupportwxcode")) {
                    com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, Boolean.valueOf(false));
                    return true;
                } else if (str.startsWith("//resetsupportwxcode")) {
                    com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, null);
                    return true;
                }
            }
            Intent intent;
            if (str.startsWith("//testsightwidget")) {
                intent = new Intent();
                intent.putExtra("KSightPath", "/mnt/sdcard/tencent/tempvideo4.mp4");
                intent.putExtra("KSightThumbPath", "");
                intent.putExtra("sight_md5", com.tencent.mm.a.g.bV("/mnt/sdcard/tencent/tempvideo4.mp4"));
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", bi.Wx());
                intent.putExtra("Ksnsupload_type", 14);
                com.tencent.mm.bl.d.b(context, "sns", ".ui.SnsUploadUI", intent);
                return true;
            } else if (str.startsWith("//openremitbank")) {
                com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(1));
                return true;
            } else if (str.startsWith("//closeremitbank")) {
                com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(0));
                return true;
            } else {
                com.tencent.mm.sdk.b.b bcVar;
                if (str.startsWith("//ftstemplatetest")) {
                    bcVar = new bc();
                    bcVar.fqf.fqg = 27;
                    bcVar.fqf.fqg = 1;
                    bcVar.fqf.filePath = "/sdcard/fts_template.zip";
                    com.tencent.mm.sdk.b.a.xmy.m(bcVar);
                }
                String str2;
                String[] split2;
                Intent intent2;
                int intValue;
                final String eP;
                if (str.startsWith("//sightforward")) {
                    intent = new Intent();
                    intent.setClassName(context, "com.tencent.mm.ui.transmit.SightForwardUI");
                    context.startActivity(intent);
                    return true;
                } else if (str.startsWith("//remit")) {
                    com.tencent.mm.bl.d.b(context, "remittance", ".ui.RemittanceBusiUI", new Intent());
                    return true;
                } else if (str.startsWith("//uplog")) {
                    str2 = "weixin";
                    if (as.Hp()) {
                        str2 = q.FY();
                    }
                    split2 = str.split(" ");
                    dimensionPixelSize = 0;
                    if (split2 != null) {
                        if (split2.length > 1) {
                            dimensionPixelSize = bi.getInt(split2[1], 0);
                        }
                        if (split2.length > 2) {
                            str2 = split2[2];
                        }
                    }
                    as.CN().d(new be(new be.a() {
                        public final void a(com.tencent.mm.network.e eVar) {
                            as.CN().a(1, "", 0, false);
                            x.cfX();
                            as.CN().a(2, str2, dimensionPixelSize, as.Hp());
                        }
                    }));
                    context.getString(R.l.dGZ);
                    final ProgressDialog a = com.tencent.mm.ui.base.h.a(context, context.getString(R.l.eYV), false, null);
                    as.a(new ah() {
                        public final void fX(int i) {
                            x.i("MicroMsg.CommandProcessor", "ipxx progress:%d", Integer.valueOf(i));
                            if (i < 0) {
                                as.a(null);
                                a.dismiss();
                                com.tencent.mm.ui.base.h.h(context, R.l.eSv, R.l.dGZ);
                            } else if (i >= 100) {
                                as.a(null);
                                a.dismiss();
                                com.tencent.mm.ui.base.h.h(context, R.l.eSz, R.l.dGZ);
                            } else {
                                a.setMessage(context.getString(R.l.eSw) + i + "%");
                            }
                        }
                    });
                    return true;
                } else if (str.startsWith("//upcrash")) {
                    str2 = "weixin";
                    if (as.Hp()) {
                        str2 = q.FY();
                    }
                    split2 = str.split(" ");
                    dimensionPixelSize = 0;
                    if (split2 != null) {
                        if (split2.length > 1) {
                            dimensionPixelSize = bi.getInt(split2[1], 0);
                        }
                        if (split2.length > 2) {
                            str2 = split2[2];
                        }
                    }
                    as.CN().d(new be(new be.a() {
                        public final void a(com.tencent.mm.network.e eVar) {
                            as.CN().a(3, str2, dimensionPixelSize, as.Hp());
                        }
                    }));
                    return true;
                } else if (str.startsWith("//switchnotificationstatus")) {
                    com.tencent.mm.j.f.bo(!com.tencent.mm.j.a.zu());
                    return true;
                } else if (str.startsWith("//fixError0831")) {
                    x.i("MicroMsg.CommandProcessor", "fixError0831");
                    com.tencent.mm.sdk.b.a.xmy.m(new bj());
                    return true;
                } else if (str.startsWith("//resetbankremit")) {
                    com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0));
                    return true;
                } else if (str.startsWith("//busiluck ")) {
                    str2 = "weixin://openNativeUrl/weixinHB/startreceivebizhbrequest?sendid=" + str.replace("//busiluck ", "");
                    intent2 = new Intent();
                    intent2.putExtra("key_way", 5);
                    intent2.putExtra("key_native_url", str2);
                    com.tencent.mm.bl.d.b(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent2);
                    return true;
                } else if (str.startsWith("//testsoter")) {
                    intent = new Intent();
                    intent.setClassName(ad.getPackageName(), "com.tencent.mm.plugin.soter.ui.SoterTestUI");
                    context.startActivity(intent);
                    return true;
                } else if (str.startsWith("//facevideo")) {
                    split = str.split(" ");
                    if (split.length == 3) {
                        ar.hhz.S("imgType", split[1]);
                        ar.hhz.S("depth", split[2]);
                    }
                    return true;
                } else if (str.startsWith("//alpha")) {
                    split = str.split(" ");
                    if (split.length == 2) {
                        ar.hhz.S("alpha_duration", split[1]);
                    }
                    return true;
                } else if (str.startsWith("//rectwidth")) {
                    split = str.split(" ");
                    if (split.length == 2) {
                        ar.hhz.S("rect_width", split[1]);
                    }
                    return true;
                } else if (str.startsWith("//newyearsw ")) {
                    as.Hm();
                    intValue = ((Integer) com.tencent.mm.y.c.Db().get(w.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue() ^ 1;
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(intValue));
                    return true;
                } else if (str.startsWith("//commitxlog")) {
                    as.CN().a(1, "", 0, false);
                    x.cfX();
                    return true;
                } else if (str.startsWith("//open neattextview")) {
                    com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC, Boolean.valueOf(true));
                    return true;
                } else if (str.startsWith("//close neattextview")) {
                    com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC, Boolean.valueOf(false));
                    return true;
                } else if (str.startsWith("//unprint specialtext")) {
                    MMNeatTextView.zCY = false;
                    return true;
                } else if (str.startsWith("//print specialtext")) {
                    MMNeatTextView.zCY = true;
                    return true;
                } else if (str.startsWith("//netstatus")) {
                    eP = ao.eP(ad.getContext());
                    com.tencent.mm.ui.base.h.a(context, eP, "netstatus", context.getString(R.l.eVE), context.getString(R.l.dUl), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ((ClipboardManager) context.getSystemService("clipboard")).setText(eP);
                        }
                    }, null);
                    return true;
                } else {
                    long j;
                    if (str.startsWith("//scaninterval ")) {
                        j = -1;
                        try {
                            j = bi.getLong(str.split(" ")[1], -1);
                        } catch (Exception e) {
                        }
                        if (j > 0) {
                            as.Hm();
                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_WECHAT_FILE_SCAN_INTERVAL_LONG, Long.valueOf(j));
                            x.i("MicroMsg.CommandProcessor", "summerclean reset scaninterval[%d]", Long.valueOf(j));
                            return true;
                        }
                    }
                    if (str.startsWith("//scanwait ")) {
                        j = -1;
                        try {
                            j = bi.getLong(str.split(" ")[1], -1);
                        } catch (Exception e2) {
                        }
                        if (j > 0) {
                            as.Hm();
                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_WECHAT_FILE_SCAN_WAIT_TIME_LONG, Long.valueOf(j));
                            x.i("MicroMsg.CommandProcessor", "summerclean reset scanwait[%d]", Long.valueOf(j));
                            return true;
                        }
                    }
                    SharedPreferences cgg;
                    boolean z;
                    boolean booleanValue;
                    View textView2;
                    com.tencent.mm.storage.x Xv;
                    String str3;
                    String str4;
                    boolean z2;
                    int tbsSDKVersion;
                    Editor edit2;
                    if (str.equalsIgnoreCase("//delayquery")) {
                        r.igI = !r.igI;
                        return true;
                    } else if (str.startsWith("//newinit -hard")) {
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dq().Db().set(15, Integer.valueOf(0));
                        return true;
                    } else if (str.startsWith("//opensearchpreload ")) {
                        split = str.split("\\s+");
                        if (split.length == 2) {
                            if ("1".equals(split[1].trim())) {
                                com.tencent.mm.plugin.aj.d.bPz().kl(true);
                            } else if ("0".equals(split[1].trim())) {
                                com.tencent.mm.plugin.aj.d.bPz().kl(false);
                            }
                        }
                        return true;
                    } else if (str.startsWith("//closesearchhtmlpreload ")) {
                        split = str.split("\\s+");
                        if (split.length == 2) {
                            if ("1".equals(split[1].trim())) {
                                com.tencent.mm.plugin.aj.a.g.bPH();
                            } else if ("0".equals(split[1].trim())) {
                                com.tencent.mm.plugin.aj.a.g.bPH();
                            }
                        }
                        return true;
                    } else if (str.equalsIgnoreCase("//swipe")) {
                        cgg = ad.cgg();
                        cgg.edit().putBoolean("settings_support_swipe", !cgg.getBoolean("settings_support_swipe", true)).commit();
                        return true;
                    } else if (str.equalsIgnoreCase("//multiwebview")) {
                        cgg = LauncherUI.cnu().getSharedPreferences(ad.cgf(), 0);
                        z = cgg.getBoolean("settings_multi_webview", false);
                        if (z) {
                            cgg.edit().putBoolean("settings_multi_webview", !z).commit();
                        }
                        return true;
                    } else if (str.equalsIgnoreCase("//sightinfo")) {
                        as.Hm();
                        booleanValue = ((Boolean) com.tencent.mm.y.c.Db().get(344065, Boolean.valueOf(false))).booleanValue();
                        as.Hm();
                        com.tencent.mm.y.c.Db().set(344065, Boolean.valueOf(!booleanValue));
                        as.Hm();
                        com.tencent.mm.y.c.Db().lO(true);
                        return true;
                    } else if (str.startsWith("//sighttest")) {
                        intValue = bi.Wo(str.replace("//sighttest ", ""));
                        as.Hm();
                        com.tencent.mm.y.c.Db().set(344066, Integer.valueOf(intValue));
                        as.Hm();
                        com.tencent.mm.y.c.Db().lO(true);
                        return true;
                    } else if (str.startsWith("//wxcamera")) {
                        x.i("MicroMsg.CommandProcessor", "set param %d", Integer.valueOf(bi.Wo(str.replace("//wxcamera ", ""))));
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, Integer.valueOf(intValue));
                        return true;
                    } else if (str.startsWith("//printcrash")) {
                        str2 = str.replace("//printcrash ", "");
                        textView2 = new TextView(context);
                        textView2.setText(fU(bi.getInt(str2, 0)));
                        textView2.setGravity(19);
                        textView2.setTextSize(1, 8.0f);
                        textView2.setLayoutParams(new LayoutParams(-1, -2));
                        textView2.setTextColor(-16711936);
                        textView2.setTypeface(Typeface.MONOSPACE);
                        intValue = context.getResources().getDimensionPixelSize(R.f.bvW);
                        textView2.setPadding(intValue, intValue, intValue, intValue);
                        textView2.setMovementMethod(ScrollingMovementMethod.getInstance());
                        com.tencent.mm.ui.base.h.a(context, null, textView2, null);
                        return true;
                    } else if (str.startsWith("//printleak")) {
                        textView = new TextView(context);
                        textView.setText(com.tencent.mm.compatible.b.f.yg());
                        textView.setGravity(19);
                        textView.setTextSize(1, 8.0f);
                        textView.setLayoutParams(new LayoutParams(-1, -2));
                        textView.setTextColor(-16711936);
                        textView.setTypeface(Typeface.MONOSPACE);
                        dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bvW);
                        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
                        com.tencent.mm.ui.base.h.a(context, null, textView, null);
                        return true;
                    } else if (str.startsWith("//resetmapcnt")) {
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_TENCENT_MAP_COUNT_INT, Integer.valueOf(0));
                        return true;
                    } else if (str.equals("//testrsa")) {
                        ac.H("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                        return true;
                    } else if (str.equals("//testrsabad")) {
                        ac.H("010001", "F338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                        return true;
                    } else if (str.equals("//walletofflinetest")) {
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(false));
                        return false;
                    } else if (str.startsWith("//makemsgdata ")) {
                        intValue = bi.getInt(str.split(" ")[1], 0);
                        as.Hm();
                        com.tencent.mm.y.c.Fh().F(ChattingUI.a.yEQ, (long) intValue);
                        return true;
                    } else if (str.startsWith("//pullappservice")) {
                        com.tencent.mm.pluginsdk.model.app.ao.bZI().ek(ad.getContext());
                        return true;
                    } else if (str.startsWith("//boundaryconfig")) {
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig SessionTextMsg:%d", Integer.valueOf(bi.getInt(com.tencent.mm.j.g.Af().getValue("InputLimitSessionTextMsg"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig SNSObjectText:%d", Integer.valueOf(bi.getInt(com.tencent.mm.j.g.Af().getValue("InputLimitSNSObjectText"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig SnsCommentMaxSize:%d", Integer.valueOf(bi.getInt(com.tencent.mm.j.g.Af().getValue("SnsCommentMaxSize"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig FavText:%d", Integer.valueOf(bi.getInt(com.tencent.mm.j.g.Af().getValue("InputLimitFavText"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionBufSize:%d", Integer.valueOf(bi.getInt(com.tencent.mm.j.g.Af().getValue("InputLimitSendEmotionBufSize"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionWidth:%d", Integer.valueOf(bi.getInt(com.tencent.mm.j.g.Af().getValue("InputLimitSendEmotionWidth"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig FavImageSize:%d", Integer.valueOf(bi.getInt(com.tencent.mm.j.g.Af().getValue("InputLimitFavImageSize"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig FavVoiceLength:%d", Integer.valueOf(bi.getInt(com.tencent.mm.j.g.Af().getValue("InputLimitFavVoiceLength"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig ShortVideoAutoDownloadBufSize:%d", Integer.valueOf(bi.getInt(com.tencent.mm.j.g.Af().getValue("InputLimitSessionShortVideoBufSize"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig VideoSize:%d", Integer.valueOf(bi.getInt(com.tencent.mm.j.g.Af().getValue("InputLimitVideoSize"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig FileSize:%d", Integer.valueOf(bi.getInt(com.tencent.mm.j.g.Af().getValue("InputLimitFileSize"), 0)));
                        return true;
                    } else if (str.startsWith("//whatsnew")) {
                        MMAppMgr.W((Activity) context);
                        return true;
                    } else if (str.startsWith("//profile ")) {
                        as.Hm();
                        Xv = com.tencent.mm.y.c.Ff().Xv(str.replace("//profile ", "").trim());
                        if (!(Xv == null || Xv.AV() == 0)) {
                            intent2 = new Intent();
                            intent2.putExtra("Contact_User", Xv.getUsername());
                            com.tencent.mm.bl.d.b(context, "profile", ".ui.ContactInfoUI", intent2);
                        }
                        return true;
                    } else if (str.startsWith("//minigameupdate")) {
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_MINIGAME_SEARCH_LIST_UPDATE_TIME_LONG, Long.valueOf(0));
                        return true;
                    } else if (str.startsWith("//cs")) {
                        intent = new Intent();
                        intent.putExtra("voipCSBizId", "gh_b35727b00b78");
                        intent.putExtra("voipCSAppId", "wx6e7147e8d764e85d");
                        com.tencent.mm.bl.d.b(ad.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                        return true;
                    } else if (str.startsWith("//acs")) {
                        intent = new Intent();
                        intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                        intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                        com.tencent.mm.bl.d.b(ad.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                        return true;
                    } else if (str.startsWith("//wifiset")) {
                        intent = new Intent();
                        intent.putExtra("free_wifi_ssid", "Xiaomi_WENDY");
                        intent.putExtra("free_wifi_passowrd", "WX12345789");
                        com.tencent.mm.bl.d.b(ad.getContext(), "freewifi", ".ui.FreeWifiCopyPwdUI", intent);
                        return true;
                    } else if (str.startsWith("//bcs")) {
                        intent = new Intent();
                        intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                        intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                        intent.putExtra("voipCSAllowBackCamera", "1");
                        intent.putExtra("voipCSShowOther", "1");
                        intent.putExtra("voipCSAvatarUrl", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=28737416,3249768666&fm=58");
                        intent.putExtra("voipCSContext", "test");
                        com.tencent.mm.bl.d.b(ad.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                        return true;
                    } else if (str.startsWith("//getfpkey")) {
                        eP = com.tencent.mm.storage.be.ckL();
                        com.tencent.mm.ui.base.h.a(context, eP, "Fingerprint Key", context.getString(R.l.eVE), context.getString(R.l.dUl), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ((ClipboardManager) context.getSystemService("clipboard")).setText(eP);
                                Toast.makeText(context, R.l.eVF, 0).show();
                            }
                        }, null);
                        return true;
                    } else if (str.startsWith("//commitwd")) {
                        WatchDogPushReceiver.To();
                        return true;
                    } else if (str.startsWith("//setsnstestenv")) {
                        String[] split3 = str.split(" +");
                        if (split3.length > 1) {
                            str3 = split3[1];
                            if (com.tencent.mm.sdk.platformtools.q.isIPv4Address(str3) || com.tencent.mm.sdk.platformtools.q.isIPv6Address(str3)) {
                                if (split3.length > 2) {
                                    str4 = split3[2];
                                    if (com.tencent.mm.sdk.platformtools.q.isIPv4Address(str4) || com.tencent.mm.sdk.platformtools.q.isIPv6Address(str4)) {
                                        eP = split3.length > 3 ? split3[3] : null;
                                        r.igg = str3 != null;
                                        r.ifX = str3;
                                        r.igz = str4;
                                        r.igA = eP;
                                        com.tencent.mm.modelcdntran.g.MM().MR();
                                        Toast.makeText(context, String.format("%s %s %s", new Object[]{r.ifX, r.igz, r.igA}), 1).show();
                                        return true;
                                    }
                                }
                                str4 = null;
                                eP = null;
                                if (str3 != null) {
                                }
                                r.igg = str3 != null;
                                r.ifX = str3;
                                r.igz = str4;
                                r.igA = eP;
                                com.tencent.mm.modelcdntran.g.MM().MR();
                                Toast.makeText(context, String.format("%s %s %s", new Object[]{r.ifX, r.igz, r.igA}), 1).show();
                                return true;
                            }
                        }
                        str3 = null;
                        str4 = null;
                        eP = null;
                        if (str3 != null) {
                        }
                        r.igg = str3 != null;
                        r.ifX = str3;
                        r.igz = str4;
                        r.igA = eP;
                        com.tencent.mm.modelcdntran.g.MM().MR();
                        Toast.makeText(context, String.format("%s %s %s", new Object[]{r.ifX, r.igz, r.igA}), 1).show();
                        return true;
                    } else if (str.startsWith("//snsvcodec")) {
                        split = str.split(" +");
                        if (split.length > 1) {
                            str2 = split[1];
                            if ("on".equalsIgnoreCase(str2)) {
                                fV(1);
                                x.i("MicroMsg.CommandProcessor", "snsvcodec val: 1");
                            } else if ("off".equalsIgnoreCase(str2)) {
                                fV(0);
                                x.i("MicroMsg.CommandProcessor", "snsvcodec val: 0");
                            }
                        } else {
                            fV(-1);
                            x.i("MicroMsg.CommandProcessor", "snsvcodec val: -1");
                        }
                        return true;
                    } else if (str.startsWith("//snswxpc")) {
                        split = str.split(" +");
                        if (split.length > 1) {
                            str2 = split[1];
                            if ("on".equalsIgnoreCase(str2)) {
                                fW(1);
                                x.i("MicroMsg.CommandProcessor", "snswxpc val: 1");
                            } else if ("off".equalsIgnoreCase(str2)) {
                                fW(0);
                                x.i("MicroMsg.CommandProcessor", "snswxpc val: 0");
                            }
                        } else {
                            fW(-1);
                            x.i("MicroMsg.CommandProcessor", "snswxpc val: -1");
                        }
                        return true;
                    } else if (str.startsWith("//mmdumpsys")) {
                        as.Dt().F(new Runnable() {
                            public final void run() {
                                new al(new al.a() {
                                    /* JADX WARNING: inconsistent code. */
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public final boolean uG() {
                                        /*
                                        r10 = this;
                                        r5 = 23;
                                        r9 = 2;
                                        r8 = 0;
                                        r7 = 1;
                                        r0 = com.tencent.mm.compatible.util.d.fN(r5);
                                        if (r0 == 0) goto L_0x00de;
                                    L_0x000b:
                                        r0 = android.os.Debug.getRuntimeStats();
                                        r1 = "MicroMsg.CommandProcessor";
                                        r2 = "gcCount: %s";
                                        r3 = new java.lang.Object[r7];
                                        r3[r8] = r0;
                                        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
                                    L_0x001c:
                                        r0 = android.os.Debug.getPss();
                                        r2 = new android.os.Debug$MemoryInfo;
                                        r2.<init>();
                                        android.os.Debug.getMemoryInfo(r2);
                                        r3 = com.tencent.mm.compatible.util.d.fN(r5);
                                        if (r3 == 0) goto L_0x00ff;
                                    L_0x002e:
                                        r3 = "MicroMsg.CommandProcessor";
                                        r4 = "pss: %d, memoryInfo:%s";
                                        r5 = new java.lang.Object[r9];
                                        r0 = java.lang.Long.valueOf(r0);
                                        r5[r8] = r0;
                                        r0 = r2.getMemoryStats();
                                        r5[r7] = r0;
                                        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
                                    L_0x0045:
                                        r2 = 0;
                                        r0 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x016b, all -> 0x014d }
                                        r1 = "top -m 5 -n 1";
                                        r0 = r0.exec(r1);	 Catch:{ Exception -> 0x016b, all -> 0x014d }
                                        r1 = new java.io.LineNumberReader;	 Catch:{ Exception -> 0x016b, all -> 0x014d }
                                        r3 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x016b, all -> 0x014d }
                                        r4 = r0.getInputStream();	 Catch:{ Exception -> 0x016b, all -> 0x014d }
                                        r3.<init>(r4);	 Catch:{ Exception -> 0x016b, all -> 0x014d }
                                        r1.<init>(r3);	 Catch:{ Exception -> 0x016b, all -> 0x014d }
                                    L_0x005f:
                                        r2 = r1.readLine();	 Catch:{ Exception -> 0x0072 }
                                        if (r2 == 0) goto L_0x011a;
                                    L_0x0065:
                                        r3 = r2.length();	 Catch:{ Exception -> 0x0072 }
                                        if (r3 <= 0) goto L_0x005f;
                                    L_0x006b:
                                        r3 = "MicroMsg.CommandProcessor";
                                        com.tencent.mm.sdk.platformtools.x.i(r3, r2);	 Catch:{ Exception -> 0x0072 }
                                        goto L_0x005f;
                                    L_0x0072:
                                        r0 = move-exception;
                                    L_0x0073:
                                        r2 = "MicroMsg.CommandProcessor";
                                        r3 = "getRunningAppProcessesByPs fail, ex = %s";
                                        r4 = 1;
                                        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0169 }
                                        r5 = 0;
                                        r0 = r0.getMessage();	 Catch:{ all -> 0x0169 }
                                        r4[r5] = r0;	 Catch:{ all -> 0x0169 }
                                        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0169 }
                                        if (r1 == 0) goto L_0x008b;
                                    L_0x0088:
                                        r1.close();	 Catch:{ Exception -> 0x0139 }
                                    L_0x008b:
                                        r0 = java.lang.Thread.activeCount();
                                        r1 = "MicroMsg.CommandProcessor";
                                        r2 = "thread count:%d";
                                        r3 = new java.lang.Object[r7];
                                        r0 = java.lang.Integer.valueOf(r0);
                                        r3[r8] = r0;
                                        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
                                        r1 = java.lang.Thread.getAllStackTraces();
                                        r0 = r1.keySet();
                                        r2 = r0.iterator();
                                    L_0x00ac:
                                        r0 = r2.hasNext();
                                        if (r0 == 0) goto L_0x0168;
                                    L_0x00b2:
                                        r0 = r2.next();
                                        r0 = (java.lang.Thread) r0;
                                        r3 = r0.getState();
                                        r4 = java.lang.Thread.State.RUNNABLE;
                                        if (r3 != r4) goto L_0x00ac;
                                    L_0x00c0:
                                        r3 = "MicroMsg.CommandProcessor";
                                        r4 = "Running thread: %s\n %s";
                                        r5 = new java.lang.Object[r9];
                                        r6 = r0.getName();
                                        r5[r8] = r6;
                                        r0 = r1.get(r0);
                                        r0 = (java.lang.StackTraceElement[]) r0;
                                        r0 = com.tencent.mm.sdk.platformtools.aj.b(r0);
                                        r5[r7] = r0;
                                        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
                                        goto L_0x00ac;
                                    L_0x00de:
                                        r0 = android.os.Debug.getGlobalGcInvocationCount();
                                        r1 = android.os.Debug.getThreadGcInvocationCount();
                                        r2 = "MicroMsg.CommandProcessor";
                                        r3 = "gcCount: %d %d";
                                        r4 = new java.lang.Object[r9];
                                        r0 = java.lang.Integer.valueOf(r0);
                                        r4[r8] = r0;
                                        r0 = java.lang.Integer.valueOf(r1);
                                        r4[r7] = r0;
                                        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
                                        goto L_0x001c;
                                    L_0x00ff:
                                        r3 = "MicroMsg.CommandProcessor";
                                        r4 = "pss: %d, memoryInfo:%d";
                                        r5 = new java.lang.Object[r9];
                                        r0 = java.lang.Long.valueOf(r0);
                                        r5[r8] = r0;
                                        r0 = r2.nativePss;
                                        r0 = java.lang.Integer.valueOf(r0);
                                        r5[r7] = r0;
                                        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
                                        goto L_0x0045;
                                    L_0x011a:
                                        r0.waitFor();	 Catch:{ Exception -> 0x0072 }
                                        r0.destroy();	 Catch:{ Exception -> 0x0072 }
                                        r1.close();	 Catch:{ Exception -> 0x0125 }
                                        goto L_0x008b;
                                    L_0x0125:
                                        r0 = move-exception;
                                        r1 = "MicroMsg.CommandProcessor";
                                        r2 = "getRunningProcessesByPs finally got ex = %s";
                                        r3 = new java.lang.Object[r7];
                                        r0 = r0.getMessage();
                                        r3[r8] = r0;
                                        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
                                        goto L_0x008b;
                                    L_0x0139:
                                        r0 = move-exception;
                                        r1 = "MicroMsg.CommandProcessor";
                                        r2 = "getRunningProcessesByPs finally got ex = %s";
                                        r3 = new java.lang.Object[r7];
                                        r0 = r0.getMessage();
                                        r3[r8] = r0;
                                        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
                                        goto L_0x008b;
                                    L_0x014d:
                                        r0 = move-exception;
                                        r1 = r2;
                                    L_0x014f:
                                        if (r1 == 0) goto L_0x0154;
                                    L_0x0151:
                                        r1.close();	 Catch:{ Exception -> 0x0155 }
                                    L_0x0154:
                                        throw r0;
                                    L_0x0155:
                                        r1 = move-exception;
                                        r2 = "MicroMsg.CommandProcessor";
                                        r3 = "getRunningProcessesByPs finally got ex = %s";
                                        r4 = new java.lang.Object[r7];
                                        r1 = r1.getMessage();
                                        r4[r8] = r1;
                                        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);
                                        goto L_0x0154;
                                    L_0x0168:
                                        return r7;
                                    L_0x0169:
                                        r0 = move-exception;
                                        goto L_0x014f;
                                    L_0x016b:
                                        r0 = move-exception;
                                        r1 = r2;
                                        goto L_0x0073;
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.console.b.14.1.uG():boolean");
                                    }
                                }, true).K(10000, 10000);
                            }
                        });
                        return true;
                    } else if (str.startsWith("//remittance reset")) {
                        as.Hm();
                        com.tencent.mm.y.c.Db().set(327729, "0");
                        return true;
                    } else if (str.startsWith("//wv ")) {
                        str2 = str.replace("//wv ", "");
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                        return true;
                    } else if (str.startsWith("//wvjsapi ")) {
                        str2 = str.replace("//wvjsapi ", "");
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.WebViewTestUI", intent2);
                        return true;
                    } else if (str.startsWith("//setibeacontabuinopen")) {
                        if (!as.Hp()) {
                            return false;
                        }
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(1));
                        return true;
                    } else if (str.startsWith("//setibeacontabuinclose")) {
                        if (!as.Hp()) {
                            return false;
                        }
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(0));
                        return true;
                    } else if (str.startsWith("//setibeaconpushopen")) {
                        if (!as.Hp()) {
                            return false;
                        }
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(true));
                        return true;
                    } else if (str.startsWith("//setibeaconpushclose")) {
                        if (!as.Hp()) {
                            return false;
                        }
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(false));
                        return true;
                    } else if (str.startsWith("//ibeacon")) {
                        booleanValue = false;
                        z = false;
                        if (VERSION.SDK_INT >= 18) {
                            booleanValue = true;
                        }
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null && defaultAdapter.getState() == 12) {
                            z = true;
                        }
                        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                        z2 = booleanValue && z && hasSystemFeature;
                        eP = "isNowSupportedIbeacon:" + z2 + "\n\nisSystemSupported:" + booleanValue + "\nisBlueStateOn:" + z + "\nisSupportedBLE:" + hasSystemFeature + "\nSDK:" + VERSION.SDK_INT + "\nModel:" + Build.BRAND + "-" + com.tencent.mm.compatible.e.q.yQ() + "\noperatingSystemInfo:" + com.tencent.mm.compatible.e.q.yU();
                        com.tencent.mm.ui.base.h.a(context, eP, "TestResult", context.getString(R.l.dQV), context.getString(R.l.dUl), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ((ClipboardManager) context.getSystemService("clipboard")).setText(eP);
                            }
                        }, null);
                        return true;
                    } else if (str.startsWith("//gettbs")) {
                        booleanValue = com.tencent.mm.compatible.e.q.gHI.gIw;
                        sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                        str4 = sharedPreferences.getString("tbs_download", null);
                        str3 = sharedPreferences.getString("tbs_webview_disable", null);
                        boolean z3 = sharedPreferences.getBoolean("x5_jscore_enabled", false);
                        int tbsCoreVersion = WebView.getTbsCoreVersion(context);
                        tbsSDKVersion = WebView.getTbsSDKVersion(context);
                        String string = sharedPreferences.getString("tbs_webview_min_sdk_version", null);
                        eP = sharedPreferences.getString("tbs_webview_max_sdk_version", null);
                        Toast.makeText(context, String.format("forceSys:%b\ntbs_download:%s\ntbs_disable:%s\ntbs_disable_min_sdk_version:%s\ntbs_disable_max_sdk_version:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d\nx5JsCoreEnabled:%b", new Object[]{Boolean.valueOf(booleanValue), str4, str3, string, eP, Integer.valueOf(tbsCoreVersion), Integer.valueOf(tbsSDKVersion), Boolean.valueOf(z3)}), 1).show();
                        return true;
                    } else if (str.startsWith("//deletetbs")) {
                        intent = new Intent();
                        intent.setComponent(new ComponentName(ad.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                        context.sendBroadcast(intent);
                        edit2 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                        edit2.putLong("last_check_ts", 0);
                        edit2.apply();
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.valueOf(false));
                        return true;
                    } else if (str.startsWith("//tbsDisableOverScroll")) {
                        edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                        try {
                            str2 = str.substring(str.indexOf(":") + 1);
                        } catch (IndexOutOfBoundsException e3) {
                            str2 = "";
                        }
                        edit.putBoolean("tbs_disable_over_scroll", Boolean.parseBoolean(str2));
                        edit.apply();
                        return true;
                    } else if (str.startsWith("//enabletbs")) {
                        edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                        str4 = str.replace("//enabletbs ", "");
                        edit.putString("tbs_webview_disable", "1".equals(str4) ? "0" : "1");
                        if ("0".equals(str4)) {
                            edit.putString("tbs_webview_min_sdk_version", "0");
                            edit.putString("tbs_webview_max_sdk_version", "0");
                        }
                        edit.apply();
                        return true;
                    } else if (str.startsWith("//wvsha1")) {
                        edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                        try {
                            str2 = str.substring(str.indexOf(":") + 1);
                        } catch (IndexOutOfBoundsException e4) {
                            str2 = "";
                        }
                        edit.putBoolean("wvsha1", Boolean.parseBoolean(str2));
                        edit.apply();
                        return true;
                    } else {
                        if (str.startsWith("//channelId")) {
                            com.tencent.mm.ui.base.h.B(context, com.tencent.mm.sdk.platformtools.f.fei, DownloadInfoColumns.CHANNELID);
                        }
                        if (str.startsWith("//traceroute")) {
                            com.tencent.mm.bl.d.y(context, "traceroute", ".ui.NetworkDiagnoseIntroUI");
                            return true;
                        }
                        if (str.startsWith("//qzone ")) {
                            new s(context).SZ(str.replace("//qzone ", ""));
                        }
                        int i;
                        if (str.startsWith("//dumpcrash")) {
                            com.tencent.mm.sdk.platformtools.k.r(com.tencent.mm.compatible.util.e.hbv + "crash/", com.tencent.mm.compatible.util.e.hbx, false);
                            return true;
                        } else if (str.startsWith("//dumpanr")) {
                            com.tencent.mm.sdk.platformtools.k.r("/data/anr/", com.tencent.mm.compatible.util.e.hbx, false);
                            return true;
                        } else if (str.startsWith("//testanr")) {
                            try {
                                Thread.sleep(10000);
                            } catch (Throwable e5) {
                                x.printErrStackTrace("MicroMsg.CommandProcessor", e5, "", new Object[0]);
                            }
                            return true;
                        } else if (str.startsWith("//opensnsadRightbar")) {
                            r.ifW = true;
                            return true;
                        } else if (str.startsWith("//setlocation ")) {
                            split = str.split(" ");
                            if (split == null || !com.tencent.mm.sdk.a.b.cfx()) {
                                return false;
                            }
                            r.ifm = true;
                            if (split.length > 0) {
                                r.lat = bi.getDouble(split[1], 0.0d);
                            }
                            if (split.length > 1) {
                                r.lng = bi.getDouble(split[2], 0.0d);
                            }
                            return true;
                        } else if (str.startsWith("//switchsdcard")) {
                            String str5;
                            ArrayList cgO = ax.cgO();
                            int size = cgO.size();
                            x.i("MicroMsg.CommandProcessor", "switchsdcard sdcard size = " + size);
                            if (!(size <= 0 || cgO.get(0) == null || bi.oN(((ax.a) cgO.get(0)).xqh))) {
                                for (intValue = 0; intValue < size; intValue++) {
                                    x.i("MicroMsg.CommandProcessor", "switchsdcard list i = " + intValue + " StatMountParse: " + cgO.get(intValue));
                                }
                            }
                            for (i = 0; i < size; i++) {
                                if (!((ax.a) cgO.get(i)).xqh.equals(com.tencent.mm.compatible.util.e.bnD)) {
                                    str5 = ((ax.a) cgO.get(i)).xqh;
                                    break;
                                }
                            }
                            str5 = null;
                            final Activity activity = (Activity) context;
                            x.i("MicroMsg.CommandProcessor", "switchsdcard newSdcard: " + str5);
                            if (bi.oN(str5)) {
                                com.tencent.mm.ui.base.h.bs(context, context.getString(R.l.eQE));
                                return true;
                            }
                            com.tencent.mm.ui.base.h.a(context, context.getString(R.l.eQF), "", context.getString(R.l.dGf), context.getString(R.l.dEy), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    com.tencent.mm.storage.s sVar = new com.tencent.mm.storage.s(w.hbv + "SdcardInfo.cfg");
                                    sVar.set(1, str5);
                                    x.i("MicroMsg.CommandProcessor", "switchsdcard reset to sdcard root: " + sVar.get(1));
                                    af.VJ("welcome_page_show");
                                    com.tencent.mm.kernel.k.e(context, true);
                                    com.tencent.mm.sdk.b.b yVar = new y();
                                    yVar.foJ.foK = false;
                                    com.tencent.mm.sdk.b.a.xmy.m(yVar);
                                    WorkerProfile.uv().fgO.uq();
                                    as.getNotification().xf();
                                    Intent intent = new Intent();
                                    intent.setComponent(new ComponentName(com.tencent.mm.ui.e.h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                                    ad.getContext().sendBroadcast(intent);
                                    if (com.tencent.mm.pluginsdk.q.a.viZ != null) {
                                        com.tencent.mm.pluginsdk.q.a.viZ.ar(activity);
                                    }
                                    activity.finish();
                                }
                            }, null);
                            return true;
                        } else if (str.startsWith("//getip")) {
                            as.CN().d(new be(new be.a() {
                                public final void a(com.tencent.mm.network.e eVar) {
                                    if (eVar != null) {
                                        int i;
                                        String[] iPsString = eVar.getIPsString(true);
                                        for (i = 0; i < iPsString.length; i++) {
                                            x.d("MicroMsg.CommandProcessor", "dkip long:%d  %s", Integer.valueOf(i), iPsString[i]);
                                            x.d("MicroMsg.CommandProcessor", "dkip long:%d %s", Integer.valueOf(i), com.tencent.mm.network.a.c.on(iPsString[i]).toString());
                                        }
                                        iPsString = eVar.getIPsString(false);
                                        for (i = 0; i < iPsString.length; i++) {
                                            x.d("MicroMsg.CommandProcessor", "dkip short:%d %s", Integer.valueOf(i), iPsString[i]);
                                            x.d("MicroMsg.CommandProcessor", "dkip long:%d %s", Integer.valueOf(i), com.tencent.mm.network.a.c.on(iPsString[i]).toString());
                                        }
                                    }
                                }
                            }));
                            return true;
                        } else if (str.startsWith("//localjsapi")) {
                            x.v("MicroMsg.CommandProcessor", "alvinluo path: %s", "file://" + com.tencent.mm.compatible.util.e.bnF + "test_jsapi.html");
                            intent2 = new Intent();
                            intent2.putExtra("rawUrl", str2);
                            com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                            return true;
                        } else if (str.startsWith("//getlocalkey")) {
                            eP = com.tencent.mm.storage.be.ckK();
                            com.tencent.mm.ui.base.h.a(context, eP, "Fingerprint Key", context.getString(R.l.eVE), context.getString(R.l.dUl), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    ((ClipboardManager) context.getSystemService("clipboard")).setText(eP);
                                    Toast.makeText(context, R.l.eVF, 0).show();
                                }
                            }, null);
                            return true;
                        } else if (str.startsWith("//getdevid")) {
                            eP = com.tencent.mm.compatible.e.q.yM();
                            com.tencent.mm.ui.base.h.a(context, eP, "devid", context.getString(R.l.dQV), context.getString(R.l.dUl), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    ((ClipboardManager) context.getSystemService("clipboard")).setText(eP);
                                }
                            }, null);
                            return true;
                        } else if (str.startsWith("//testhtml")) {
                            intent = new Intent();
                            intent.putExtra("rawUrl", "file:///android_asset/jsapi/reader_test1.html");
                            com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                            return true;
                        } else if (str.startsWith("//testlocalhtml ")) {
                            str2 = str.replace("//testlocalhtml ", "");
                            intent2 = new Intent();
                            intent2.putExtra("rawUrl", "file://" + str2);
                            intent2.putExtra("neverGetA8Key", true);
                            com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                            return true;
                        } else if (str.startsWith("//setkey")) {
                            if (com.tencent.mm.storage.be.Yr(str.replace("//setkey", ""))) {
                                Toast.makeText(context, R.l.eUL, 0).show();
                            }
                            return true;
                        } else if (str.startsWith("//checkspell")) {
                            eP = str.replace("//checkspell ", "");
                            if (bi.oN(eP)) {
                                return true;
                            }
                            StringBuilder stringBuilder2 = new StringBuilder();
                            for (intValue = 0; intValue < eP.length(); intValue++) {
                                stringBuilder2.append("[" + eP.charAt(intValue) + ":" + SpellMap.g(eP.charAt(intValue)) + "]");
                            }
                            com.tencent.mm.ui.base.h.B(context, stringBuilder2.toString(), "Check Spell");
                            return true;
                        } else if (str.startsWith("//gallery ")) {
                            str2 = str.replace("//gallery ", "");
                            if (bi.oN(str2)) {
                                return true;
                            }
                            context.getSharedPreferences(ad.cgf(), 0).edit().putString("gallery", str2).commit();
                            return true;
                        } else if (str.startsWith("//svgtag")) {
                            str2 = str.replace("//svgtag ", "");
                            if (str2.equals("on")) {
                                com.tencent.mm.bv.c.lB(true);
                            } else if (str2.equals("off")) {
                                com.tencent.mm.bv.c.lB(false);
                            }
                            return true;
                        } else if (str.startsWith("//svgcode")) {
                            try {
                                str2 = str.replace("//svgcode ", "");
                                if (!str2.equals("on")) {
                                    str2.equals("off");
                                }
                                Class cls = Class.forName("com.tencent.mm.BuildConfig");
                                Field declaredField = cls.getDeclaredField("SVGCode");
                                declaredField.setAccessible(true);
                                booleanValue = declaredField.getBoolean(cls);
                                try {
                                    Toast.makeText(ad.getContext(), "Using SVG Code : " + booleanValue + " " + com.tencent.mm.svg.b.b.clW(), 1).show();
                                } catch (Exception e6) {
                                }
                            } catch (Throwable e52) {
                                x.printErrStackTrace("MicroMsg.CommandProcessor", e52, "", new Object[0]);
                                booleanValue = false;
                            } catch (Throwable e522) {
                                x.printErrStackTrace("MicroMsg.CommandProcessor", e522, "", new Object[0]);
                                booleanValue = false;
                            } catch (Throwable e5222) {
                                x.printErrStackTrace("MicroMsg.CommandProcessor", e5222, "", new Object[0]);
                                booleanValue = false;
                            } catch (Throwable e52222) {
                                x.printErrStackTrace("MicroMsg.CommandProcessor", e52222, "", new Object[0]);
                                booleanValue = false;
                            }
                            return true;
                        } else if (str.startsWith("//testMbanner")) {
                            try {
                                split = str.replace("//testMbanner ", "").split(",");
                                if (split.length >= 2) {
                                    ba.Hy().a(new az(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue(), null));
                                }
                            } catch (Exception e7) {
                            }
                            return true;
                        } else {
                            if (str.startsWith("//testrsa")) {
                                ac.H("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                            }
                            com.tencent.mm.sdk.b.b bbVar;
                            CharSequence replace;
                            final ArrayList cgO2;
                            if (str.startsWith("//recomT")) {
                                try {
                                    as.Hm().FM().a(str.replace("//recomT ", ""), true, null);
                                } catch (Exception e8) {
                                }
                                return true;
                            } else if (str.startsWith("//recomF")) {
                                try {
                                    as.Hm().FM().a(str.replace("//recomF ", ""), false, null);
                                } catch (Exception e9) {
                                }
                                return true;
                            } else if (str.startsWith("//testgetreg")) {
                                try {
                                    split = str.replace("//testgetreg ", "").split(",");
                                    if (split.length > 2) {
                                        new com.tencent.mm.y.bi.a().hb(Integer.valueOf(split[0]).intValue()).hd(Integer.valueOf(split[1]).intValue()).hc(Integer.valueOf(split[2]).intValue()).commit();
                                    }
                                } catch (Exception e10) {
                                }
                                return true;
                            } else if (str.startsWith("//resetwxpayagree")) {
                                com.tencent.mm.kernel.g.Dr();
                                com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.valueOf(false));
                                return true;
                            } else if (str.startsWith("//ffmpeg")) {
                                try {
                                    intValue = str.indexOf("-r ");
                                    dimensionPixelSize = str.indexOf("-b ");
                                    str2 = str.substring(intValue + 3, dimensionPixelSize);
                                    eP = str.substring(dimensionPixelSize + 3);
                                    float f = bi.getFloat(str2.trim(), 0.0f);
                                    dimensionPixelSize = bi.getInt(eP.trim(), 0);
                                    com.tencent.mm.plugin.sight.base.b.qzb = dimensionPixelSize;
                                    com.tencent.mm.plugin.sight.base.b.qzc = f;
                                    Toast.makeText(ad.getContext(), "set C2C video encode frame rate " + f + " bitrate " + dimensionPixelSize, 0).show();
                                } catch (Exception e11) {
                                    Toast.makeText(ad.getContext(), "set C2C video frame rate fail, please ensure your command.", 1).show();
                                }
                                return true;
                            } else if (str.startsWith("//onlinevideo")) {
                                try {
                                    intValue = bi.getInt(str.replace("//onlinevideo ", ""), 0);
                                    as.Hm();
                                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(intValue));
                                    Toast.makeText(ad.getContext(), intValue > 0 ? "online video" : "offline video", 0).show();
                                } catch (Throwable e522222) {
                                    x.printErrStackTrace("MicroMsg.CommandProcessor", e522222, "", new Object[0]);
                                    Toast.makeText(ad.getContext(), "set online video fail, please ensure your command.", 1).show();
                                }
                                return true;
                            } else if (str.startsWith("//hevcinfo")) {
                                str2 = com.tencent.mm.plugin.s.e.baj();
                                eP = ChattingUI.a.yEQ;
                                au auVar = new au();
                                auVar.dU(eP);
                                auVar.eS(2);
                                auVar.setType(1);
                                auVar.aq(System.currentTimeMillis());
                                auVar.setContent(str2);
                                bb.i(auVar);
                                return true;
                            } else if (str.startsWith("//presns")) {
                                com.tencent.mm.kernel.g.Dt().g(new Runnable() {
                                    public final void run() {
                                        com.tencent.mm.sdk.b.a.xmy.m(new qc());
                                    }
                                }, 3000);
                                Toast.makeText(ad.getContext(), "preload sns", 0).show();
                                return true;
                            } else if (str.startsWith("//calcwxdata")) {
                                as.Hm();
                                com.tencent.mm.y.c.Db().a(w.a.USERINFO_BACKGROUND_CALC_TIME_LONG, Long.valueOf(0));
                                Toast.makeText(ad.getContext(), "calc wx data success", 0).show();
                                return true;
                            } else if (str.startsWith("//checkspace")) {
                                try {
                                    intValue = bi.getInt(str.replace("//checkspace ", ""), 0);
                                    bbVar = new com.tencent.mm.f.a.bb();
                                    bbVar.fqd.fqe = intValue;
                                    com.tencent.mm.sdk.b.a.xmy.m(bbVar);
                                    Toast.makeText(ad.getContext(), "check space code " + intValue, 0).show();
                                } catch (Throwable e5222222) {
                                    x.printErrStackTrace("MicroMsg.CommandProcessor", e5222222, "", new Object[0]);
                                    Toast.makeText(ad.getContext(), "check space code fail, please ensure your command.", 1).show();
                                }
                                return true;
                            } else if (str.startsWith("//upfacemodel")) {
                                as.CN().d(new m(42));
                                return true;
                            } else if (str.startsWith("//facett")) {
                                as.Hm();
                                com.tencent.mm.y.c.Db().a(w.a.USERINFO_FACE_SHOW_TUTORIAL_BOOLEAN_SYNC, Boolean.valueOf(false));
                                return true;
                            } else if (str.startsWith("//switchpaytype")) {
                                split = str.split(" ");
                                if (split == null || split.length < 2) {
                                    return false;
                                }
                                try {
                                    intValue = bi.getInt(split[1], 0);
                                    as.Hm();
                                    com.tencent.mm.y.c.Db().set(339975, Integer.valueOf(intValue));
                                    return true;
                                } catch (Exception e12) {
                                    x.e("MicroMsg.CommandProcessor", "hy: switch wallet type error");
                                    return false;
                                }
                            } else if (str.startsWith("//setNfcOpenUrl ")) {
                                str2 = str.replace("//setNfcOpenUrl ", "");
                                edit = ad.cgh().edit();
                                if (str2.equalsIgnoreCase("null")) {
                                    str2 = "";
                                }
                                edit.putString("nfc_open_url", str2);
                                edit.commit();
                                return true;
                            } else if (str.startsWith("//setMBV8Debug ")) {
                                str2 = str.replace("//setMBV8Debug ", "");
                                edit = ad.cgh().edit();
                                if (str2.equalsIgnoreCase("true")) {
                                    edit.putBoolean("appbrandgame_open_v8debug", true);
                                } else {
                                    edit.putBoolean("appbrandgame_open_v8debug", false);
                                }
                                edit.commit();
                                return true;
                            } else if (str.startsWith("//setAppBrandActionBar ")) {
                                str2 = str.replace("//setAppBrandActionBar ", "");
                                edit = ad.cgh().edit();
                                if (str2.equalsIgnoreCase("new")) {
                                    edit.putBoolean("appbrand_new_actionbar", true);
                                } else {
                                    edit.putBoolean("appbrand_new_actionbar", false);
                                }
                                edit.commit();
                                return true;
                            } else if (str.startsWith("//snskvtest ")) {
                                str2 = str.replace("//snskvtest", "").trim();
                                if (str2.equals("0")) {
                                    r.igs = false;
                                } else if (str2.equals("1")) {
                                    r.igs = true;
                                }
                                return true;
                            } else if (str.startsWith("//emoji ")) {
                                ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yR(str.replace("//emoji ", ""));
                                return true;
                            } else if (str.startsWith("//share ")) {
                                intValue = Integer.valueOf(str.replace("//share ", "")).intValue();
                                as.Hm();
                                com.tencent.mm.y.c.Db().set(229635, Integer.valueOf(intValue));
                                return true;
                            } else if (str.startsWith("//dumpappinfoblob ")) {
                                com.tencent.mm.pluginsdk.model.app.f Sk = an.biT().Sk(str.replace("//dumpappinfoblob ", ""));
                                com.tencent.mm.ui.base.h.B(context, Sk.vR() + "\n" + Sk.vS() + "\n" + Sk.vT(), "");
                                return true;
                            } else if (str.startsWith("//googleauth ")) {
                                replace = str.replace("//googleauth ", "");
                                if (!TextUtils.isEmpty(replace)) {
                                    if ("webview".equals(replace)) {
                                        context.getSharedPreferences(ad.cgf(), 0).edit().putBoolean("googleauth", true).commit();
                                    } else if ("local".equals(replace)) {
                                        context.getSharedPreferences(ad.cgf(), 0).edit().putBoolean("googleauth", false).commit();
                                    }
                                }
                                return true;
                            } else if (str.startsWith("//clrgamecache")) {
                                com.tencent.mm.pluginsdk.q.j bYM = com.tencent.mm.pluginsdk.q.a.bYM();
                                if (bYM != null) {
                                    bYM.cR(context);
                                }
                                return true;
                            } else if (str.startsWith("//clearwepkg")) {
                                bcVar = new tx();
                                bcVar.fNy.fql = 6;
                                eP = str.replace("//clearwepkg ", "").trim();
                                if (!(bi.oN(eP) || eP.equals("//clearwepkg"))) {
                                    bcVar.fNy.fNz = eP;
                                }
                                com.tencent.mm.sdk.b.a.xmy.m(bcVar);
                                return true;
                            } else if (str.startsWith("//googlemap")) {
                                r.ifV = true;
                                return true;
                            } else if (str.startsWith("//sosomap")) {
                                r.ifV = false;
                                return true;
                            } else if (str.startsWith("//opentrace")) {
                                com.tencent.mm.ui.applet.d dVar = new com.tencent.mm.ui.applet.d();
                                com.tencent.mm.ui.applet.d.fD(ad.getContext());
                                return true;
                            } else if (str.startsWith("//updateConversation")) {
                                x.i("MicroMsg.CommandProcessor", "update all conversation start");
                                as.Hm();
                                for (String str22 : com.tencent.mm.y.c.Fk().cju()) {
                                    as.Hm();
                                    au dr = com.tencent.mm.y.c.Fh().dr(str22, " and not ( type = 10000 and isSend != 2 ) ");
                                    as.Hm();
                                    com.tencent.mm.y.c.Fk().ad(dr);
                                }
                                x.i("MicroMsg.CommandProcessor", "update all conversation end");
                                return true;
                            } else if (str.startsWith("//setshakecarddata")) {
                                com.tencent.mm.pluginsdk.q.a.bYL().bsi();
                                return true;
                            } else if (str.startsWith("//clearshakecarddata")) {
                                com.tencent.mm.pluginsdk.q.a.bYL().bsj();
                                return true;
                            } else if (str.startsWith("//pageSize")) {
                                Context context2 = ad.getContext();
                                stringBuilder = new StringBuilder("pageSize is ");
                                as.Hm();
                                Toast.makeText(context2, stringBuilder.append(com.tencent.mm.y.c.Fc().getPageSize()).toString(), 1).show();
                                return true;
                            } else if (str.startsWith("//resetDBStatus")) {
                                as.Hm();
                                File file = new File(com.tencent.mm.y.c.CZ());
                                try {
                                    stringBuilder = new StringBuilder();
                                    as.Hm();
                                    com.tencent.mm.ui.tools.e.g(new File(stringBuilder.append(com.tencent.mm.y.c.FI()).append(file.getName().replace(".db", ".db.backup")).toString()), file);
                                    x.i("MicroMsg.CommandProcessor", "backupPath db path is %s", eP);
                                    com.tencent.mm.a.e.b(file, new File(file.getAbsolutePath() + "err" + System.currentTimeMillis()));
                                    Toast.makeText(ad.getContext(), "db状态已重置,请重启微信", 1).show();
                                } catch (Exception e13) {
                                    x.w("MicroMsg.CommandProcessor", "delete failed: " + e13.getMessage());
                                }
                                return true;
                            } else if (str.startsWith("//makesnsdata ")) {
                                com.tencent.mm.pluginsdk.q.y.bYR().en((long) bi.getInt(str.replace("//makesnsdata ", ""), 0));
                                return true;
                            } else if (str.startsWith("//setsnsupload ")) {
                                r.igf = bi.getInt(str.replace("//setsnsupload ", ""), 0);
                                return true;
                            } else if (str.startsWith("//logsnstable")) {
                                com.tencent.mm.sdk.b.a.xmy.m(new ck());
                                return true;
                            } else if (str.startsWith("//fpsreset ")) {
                                bcVar = new fp();
                                if (str.equalsIgnoreCase("//fpsreset on")) {
                                    bcVar.fvP.fql = 1;
                                } else {
                                    bcVar.fvP.fql = 0;
                                }
                                com.tencent.mm.sdk.b.a.xmy.m(bcVar);
                                return true;
                            } else if (str.startsWith("//resetsnstip")) {
                                as.Hm();
                                com.tencent.mm.y.c.Db().set(327776, Integer.valueOf(0));
                                return true;
                            } else if (str.startsWith("//checkcount")) {
                                as.Hm();
                                intValue = com.tencent.mm.y.c.Fh().Fu(ChattingUI.a.yEQ);
                                as.Hm();
                                Toast.makeText(context, "current count :" + intValue + " countAuto :" + com.tencent.mm.y.c.Fh().Fs(ChattingUI.a.yEQ), 1).show();
                                return true;
                            } else if (str.startsWith("//changeframe ")) {
                                ad.getContext().getSharedPreferences("preferences_animation", 0).edit().putFloat("frameInterval", Float.valueOf(str.replace("//changeframe ", "")).floatValue()).commit();
                                return true;
                            } else if (str.startsWith("//opendumpview")) {
                                com.tencent.mm.ui.applet.c cVar = new com.tencent.mm.ui.applet.c();
                                com.tencent.mm.ui.applet.c.fC(ad.getContext());
                                return true;
                            } else if (str.startsWith("//dumpmemory")) {
                                System.gc();
                                System.gc();
                                com.tencent.mm.bz.b.cmd();
                                return true;
                            } else if (str.startsWith("//dumpsnsfile")) {
                                com.tencent.mm.sdk.b.a.xmy.m(new pr());
                                return true;
                            } else if (str.startsWith("//coverage")) {
                                com.tencent.mm.plugin.report.b.f.Jc(str.trim().substring(10));
                                return true;
                            } else if (str.startsWith("//dumpthreadpool")) {
                                com.tencent.mm.sdk.f.e.chH();
                                return true;
                            } else if (str.startsWith("//testverifypsw ")) {
                                str22 = str.replace("//testverifypsw ", "").trim();
                                if (str22.equals("0")) {
                                    r.igu = false;
                                } else if (str22.equals("1")) {
                                    r.igu = true;
                                }
                                x.d("MicroMsg.CommandProcessor", "summerdktext testverifypsw msg[%s], testVerifyPsw[%b]", str, Boolean.valueOf(r.igu));
                                return true;
                            } else if (str.startsWith("//pickpoi")) {
                                intent = new Intent();
                                intent.putExtra("map_view_type", 8);
                                com.tencent.mm.bl.d.b(context, "location", ".ui.RedirectUI", intent);
                                return true;
                            } else if (str.startsWith("//configlist")) {
                                if (str.matches("^//configlist set ([\\S]*)=([\\S]*)$")) {
                                    List aE = t.aE(str, "^//configlist set ([\\S]*)=([\\S]*)$");
                                    if (aE != null && aE.size() == 2) {
                                        com.tencent.mm.j.g.Af().put((String) aE.get(0), (String) aE.get(1));
                                        com.tencent.mm.sdk.b.a.xmy.m(new cl());
                                    }
                                } else if (str.matches("^//configlist get ([\\S]*)$")) {
                                    List aE2 = t.aE(str, "^//configlist get ([\\S]*)$");
                                    if (aE2 != null && aE2.size() == 1) {
                                        str22 = (String) aE2.get(0);
                                        Toast.makeText(context, str22 + "=" + com.tencent.mm.j.g.Af().getValue(str22), 0).show();
                                    }
                                } else {
                                    as.Hm();
                                    str22 = (String) com.tencent.mm.y.c.Db().get(278530, (Object) "");
                                    as.Hm();
                                    eP = (String) com.tencent.mm.y.c.Db().get(278529, (Object) "");
                                    str4 = com.tencent.mm.compatible.util.e.bnF + "dynacfg.xml";
                                    bi.q(str4, (str22 + eP).getBytes());
                                    Toast.makeText(context, "output dynacfg xml to " + str4, 0).show();
                                }
                                return true;
                            } else if (str.startsWith("//security")) {
                                try {
                                    as.Hm().FN().a(str.replace("//security ", ""), true, null);
                                } catch (Exception e14) {
                                }
                                return true;
                            } else if (str.startsWith("//updatepackage")) {
                                try {
                                    as.CN().d(new com.tencent.mm.ay.k(bi.getInt(str.replace("//updatepackage ", "").trim(), 0)));
                                } catch (Exception e15) {
                                }
                                return true;
                            } else if (str.startsWith("//copypackage")) {
                                x.i("MicroMsg.CommandProcessor", "summercmd copypackage msg:%s", str);
                                cgO2 = ax.cgO();
                                tbsSDKVersion = cgO2.size();
                                x.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d", Integer.valueOf(tbsSDKVersion));
                                if (tbsSDKVersion < 2) {
                                    com.tencent.mm.ui.base.h.bs(context, context.getString(R.l.dXR));
                                } else {
                                    com.tencent.mm.ui.base.h.a(context, context.getString(R.l.dXT), "", context.getString(R.l.dGf), context.getString(R.l.dEy), new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            com.tencent.mm.sdk.f.e.post(new Runnable() {
                                                public final void run() {
                                                    try {
                                                        String str = com.tencent.mm.compatible.util.e.bnD;
                                                        as.Hm();
                                                        String Fz = com.tencent.mm.y.c.Fz();
                                                        as.Hm();
                                                        String EY = com.tencent.mm.y.c.EY();
                                                        x.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d, root:%s, pkgFullPath:%s, sysPath:%s, pkgPath:%s", Integer.valueOf(tbsSDKVersion), str, Fz, EY, Fz.substring(str.length()));
                                                        for (int i = 0; i < tbsSDKVersion; i++) {
                                                            Object obj = ((ax.a) cgO2.get(i)).xqh;
                                                            if (!(bi.oN(obj) || str.contains(obj))) {
                                                                File file = new File(obj + r5);
                                                                if (file.exists() && file.isDirectory()) {
                                                                    x.i("MicroMsg.CommandProcessor", "summercmd copypackage done pkgFullPath:%s, old:%s, ret:%b", Fz, file.getAbsolutePath(), Boolean.valueOf(com.tencent.mm.sdk.platformtools.k.r(file.getAbsolutePath(), Fz, false)));
                                                                    if (com.tencent.mm.sdk.platformtools.k.r(file.getAbsolutePath(), Fz, false)) {
                                                                        new ag(Looper.getMainLooper()).post(new Runnable() {
                                                                            public final void run() {
                                                                                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.dXS));
                                                                            }
                                                                        });
                                                                        return;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        new ag(Looper.getMainLooper()).post(new Runnable() {
                                                            public final void run() {
                                                                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.dXR));
                                                            }
                                                        });
                                                    } catch (Exception e) {
                                                        x.w("MicroMsg.CommandProcessor", "summercmd copypackage e:%s", e.getMessage());
                                                    }
                                                }
                                            }, "copypackage");
                                        }
                                    }, null);
                                }
                                return true;
                            } else if (str.startsWith("//copy -n ")) {
                                x.i("MicroMsg.CommandProcessor", "summercmd copy -n msg:%s ", str);
                                cgO2 = ax.cgO();
                                tbsSDKVersion = cgO2.size();
                                x.i("MicroMsg.CommandProcessor", "summercmd copy -n size:%d", Integer.valueOf(tbsSDKVersion));
                                if (tbsSDKVersion < 2) {
                                    com.tencent.mm.ui.base.h.bs(context, context.getString(R.l.dXR));
                                } else {
                                    com.tencent.mm.ui.base.h.a(context, context.getString(R.l.dXT), "", context.getString(R.l.dGf), context.getString(R.l.dEy), new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            com.tencent.mm.sdk.f.e.post(new Runnable() {
                                                public final void run() {
                                                    try {
                                                        String substring = str.substring(10);
                                                        String str = com.tencent.mm.compatible.util.e.bnD;
                                                        as.Hm();
                                                        String str2 = com.tencent.mm.y.c.FJ() + substring;
                                                        x.i("MicroMsg.CommandProcessor", "summercmd copy -n subDir:%s, root:%s, accPath:%s destPath:%s, subPath:%s", substring, str, r1, str2, str2.substring(str.length()));
                                                        for (int i = 0; i < tbsSDKVersion; i++) {
                                                            Object obj = ((ax.a) cgO2.get(i)).xqh;
                                                            if (!(bi.oN(obj) || str.contains(obj))) {
                                                                File file = new File(obj + r5);
                                                                if (file.exists() && file.isDirectory()) {
                                                                    File file2 = new File(str2);
                                                                    if (!file2.exists()) {
                                                                        file2.mkdir();
                                                                    }
                                                                    x.i("MicroMsg.CommandProcessor", "summercmd copy -n done new:%s, old:%s, ret:%b", file2.getAbsolutePath(), file.getAbsolutePath(), Boolean.valueOf(com.tencent.mm.sdk.platformtools.k.r(file.getAbsolutePath(), file2.getAbsolutePath(), false)));
                                                                    if (com.tencent.mm.sdk.platformtools.k.r(file.getAbsolutePath(), file2.getAbsolutePath(), false)) {
                                                                        new ag(Looper.getMainLooper()).post(new Runnable() {
                                                                            public final void run() {
                                                                                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.dXS));
                                                                            }
                                                                        });
                                                                        return;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        new ag(Looper.getMainLooper()).post(new Runnable() {
                                                            public final void run() {
                                                                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.dXR));
                                                            }
                                                        });
                                                    } catch (Exception e) {
                                                        x.w("MicroMsg.CommandProcessor", "summercmd copy -n e:%s", e.getMessage());
                                                    }
                                                }
                                            }, "copy -n");
                                        }
                                    }, null);
                                }
                                return true;
                            } else if (str.startsWith("//deletepackage")) {
                                try {
                                    str22 = str.replace("//deletepackage ", "");
                                    bbVar = new cd();
                                    bbVar.fri.frj = bi.getInt(str22, 0);
                                    com.tencent.mm.sdk.b.a.xmy.m(bbVar);
                                } catch (Exception e16) {
                                }
                                return true;
                            } else if (str.startsWith("//audiowritetofile")) {
                                com.tencent.mm.compatible.e.q.gHG.gEW = true;
                                return true;
                            } else if (str.startsWith("//bankcard")) {
                                intent = new Intent();
                                intent.putExtra("BaseScanUI_select_scan_mode", 7);
                                intent.putExtra("bank_card_owner", "test");
                                if (!(com.tencent.mm.modelvideo.y.aV(context) || com.tencent.mm.at.a.aU(context))) {
                                    com.tencent.mm.bl.d.b((Activity) context, "scanner", ".ui.BaseScanUI", intent);
                                }
                                return true;
                            } else {
                                if (str.startsWith("//banner")) {
                                    Map y = com.tencent.mm.sdk.platformtools.bj.y("<sysmsg type=\"banner\"><mainframebanner type=\"11\"><showtype>1</showtype></mainframebanner></sysmsg>", "sysmsg");
                                    str22 = (String) y.get(".sysmsg.mainframebanner.$type");
                                    eP = (String) y.get(".sysmsg.mainframebanner.showtype");
                                    str4 = (String) y.get(".sysmsg.mainframebanner.data");
                                    x.d("MicroMsg.CommandProcessor", "type:%s showType:%s data:%s", str22, eP, str4);
                                }
                                if (str.startsWith("//gamemsg")) {
                                    bcVar = new md();
                                    bcVar.fEC.content = str;
                                    com.tencent.mm.sdk.b.a.xmy.m(bcVar);
                                    return true;
                                } else if (str.startsWith("//shortcut#")) {
                                    bcVar = new tv();
                                    bcVar.fNh.fNi = str;
                                    com.tencent.mm.sdk.b.a.xmy.m(bcVar);
                                    return true;
                                } else if (str.startsWith("//gallerytype")) {
                                    o.yAK = !o.yAK;
                                    return true;
                                } else {
                                    context.getString(R.l.eWt);
                                    Object replace2;
                                    if (str.startsWith("//fullexit")) {
                                        af.VJ("show_whatsnew");
                                        com.tencent.mm.kernel.k.e(context, true);
                                        MMAppMgr.ar(context);
                                        as.hold();
                                        com.tencent.mm.kernel.g.Dr().fO("");
                                        MMAppMgr.adx();
                                        return true;
                                    } else if (str.startsWith("//cleardldb")) {
                                        as.Hm();
                                        com.tencent.mm.y.c.Fl().aAQ();
                                        return true;
                                    } else if (str.startsWith("//setcardlayouttestdata")) {
                                        replace2 = str.replace("//setcardlayouttestdata ", "");
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARDLAYOUT_TESTDATA_STRING, replace2);
                                        return true;
                                    } else if (str.startsWith("//delchatroomsysmsg")) {
                                        str22 = str.replace("//delchatroomsysmsg ", "");
                                        dimensionPixelSize = str22.indexOf(" ");
                                        str4 = str22.substring(0, dimensionPixelSize);
                                        str22 = str22.substring(dimensionPixelSize);
                                        if (bi.oN(str4)) {
                                            return false;
                                        }
                                        if (!str22.startsWith("<")) {
                                            return false;
                                        }
                                        au auVar2 = new au();
                                        auVar2.aq(System.currentTimeMillis());
                                        auVar2.setType(10002);
                                        auVar2.setContent(str22);
                                        auVar2.eS(0);
                                        auVar2.dU(str4);
                                        bb.i(auVar2);
                                        return true;
                                    } else {
                                        if (str.startsWith("//resetcrseq")) {
                                            split = str.split(" ");
                                            try {
                                                long j2 = bi.getLong(split[1], -1);
                                                long j3 = bi.getLong(split[2], -1);
                                                long j4 = bi.getLong(split[3], -1);
                                                intValue = bi.getInt(split[4], -1);
                                                if (j2 > 0) {
                                                    eP = j2 + "@chatroom";
                                                    as.Hm();
                                                    ae XF = com.tencent.mm.y.c.Fk().XF(eP);
                                                    if (XF != null) {
                                                        x.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] before [%d, %d, %d] [%d, %d, %d]", XF.getUsername(), Long.valueOf(XF.wf()), Long.valueOf(XF.wd()), Integer.valueOf(XF.we()), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(intValue));
                                                        if (j3 > -1) {
                                                            XF.am(j3);
                                                        }
                                                        if (j4 > -1) {
                                                            XF.al(j4);
                                                        }
                                                        if (intValue >= 0) {
                                                            XF.eX(intValue);
                                                        }
                                                        as.Hm();
                                                        intValue = com.tencent.mm.y.c.Fk().a(XF, XF.getUsername(), false);
                                                        x.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] done [%d, %d, %d] ret:%d", XF.getUsername(), Long.valueOf(XF.wf()), Long.valueOf(XF.wd()), Integer.valueOf(XF.we()), Integer.valueOf(intValue));
                                                        return true;
                                                    }
                                                }
                                            } catch (Throwable e52222222) {
                                                x.printErrStackTrace("MicroMsg.CommandProcessor", e52222222, "summerbadcr resetcrseq", new Object[0]);
                                            }
                                        }
                                        if (str.startsWith("//printchatroominfo")) {
                                            str22 = ChattingUI.a.yEQ;
                                            if (!com.tencent.mm.y.s.eX(str22)) {
                                                return false;
                                            }
                                            as.Hm();
                                            final com.tencent.mm.storage.q hG = com.tencent.mm.y.c.Fo().hG(str22);
                                            if (hG == null) {
                                                x.e("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], member is null", str22);
                                                return false;
                                            }
                                            as.Dt().F(new Runnable() {
                                                public final void run() {
                                                    int ciD = hG.ciD();
                                                    int i = hG.field_chatroomdataflag;
                                                    int ciG = hG.ciG();
                                                    com.tencent.mm.storage.q qVar = hG;
                                                    if (qVar.b(qVar.xuR)) {
                                                        qVar.ciC();
                                                    }
                                                    int i2 = qVar.xuR.status;
                                                    int ciH = hG.ciH();
                                                    qVar = hG;
                                                    if (qVar.b(qVar.xuR)) {
                                                        qVar.ciC();
                                                    }
                                                    String str = qVar.xuR.gDr;
                                                    List My = hG.My();
                                                    as.Hm();
                                                    cg dr = com.tencent.mm.y.c.Fh().dr(str22, " and flag != 0 and msgSeq != 0");
                                                    boolean z = dr != null && dr.field_msgId > 0;
                                                    as.Hm();
                                                    x.i("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], version[%d], flag[%d], type[%d], status[%d], get[%b], msgCount[%d], maxCount[%d], upgrader[%s], membersize[%d]", str22, Integer.valueOf(ciD), Integer.valueOf(i), Integer.valueOf(ciG), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(com.tencent.mm.y.c.Fh().Fs(str22)), Integer.valueOf(ciH), str, Integer.valueOf(My.size()));
                                                    StringBuilder stringBuilder = new StringBuilder();
                                                    stringBuilder.append("---chatroominfo---\nid:").append(str22).append("\nver:").append(ciD).append("\nflag:").append(i).append("\ntype:").append(ciG).append("\nstatus:").append(i2).append("\nget:").append(z).append("\nmsgCount:").append(r8).append("\nmaxCount:").append(ciH).append("\nupgrader:").append(str).append("\nmembersize:").append(My.size());
                                                    int i3 = -1;
                                                    try {
                                                        i3 = bi.getInt(str.split(" ")[1], 0);
                                                    } catch (Exception e) {
                                                    }
                                                    if (i3 == -1) {
                                                        i3 = My.size();
                                                    }
                                                    if (i3 > My.size()) {
                                                        i3 = My.size();
                                                    }
                                                    if (i3 > 10) {
                                                        i = 10;
                                                    } else {
                                                        i = i3;
                                                    }
                                                    if (i > 0) {
                                                        stringBuilder.append("\nmember:");
                                                    }
                                                    for (ciD = 0; ciD < i; ciD++) {
                                                        stringBuilder.append("\n").append((String) My.get(ciD));
                                                    }
                                                    au auVar = new au();
                                                    auVar.dU(str22);
                                                    auVar.eS(2);
                                                    auVar.setType(1);
                                                    auVar.aq(System.currentTimeMillis());
                                                    auVar.setContent(stringBuilder.toString());
                                                    bb.i(auVar);
                                                }
                                            });
                                            return true;
                                        } else if (str.equals("//testupdate")) {
                                            str22 = "";
                                            try {
                                                str22 = bi.convertStreamToString(context.getAssets().open("aplha_update_info.xml"));
                                            } catch (Throwable e17) {
                                                x.printErrStackTrace("MicroMsg.CommandProcessor", e17, "", new Object[0]);
                                            }
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().set(352273, str22);
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().set(352274, Long.valueOf(System.currentTimeMillis()));
                                            new com.tencent.mm.pluginsdk.model.app.a(str22).bZp();
                                            return true;
                                        } else if (str.equals("//checkUpdate0") || str.equals("//checkUpdate1")) {
                                            com.tencent.mm.pluginsdk.q.x.bYQ().hK(str.equals("//checkUpdate1"));
                                            com.tencent.mm.pluginsdk.q.x.vjk = true;
                                            return true;
                                        } else if (str.equals("//debugsnstimelinestat")) {
                                            r.ign = !r.ign;
                                            Toast.makeText(ad.getContext(), "debugSnsTimelineStat: " + r.ign, 0).show();
                                            return true;
                                        } else if (str.startsWith("//abtestmsg") && com.tencent.mm.sdk.a.b.cfx()) {
                                            com.tencent.mm.y.c.a.a ip = com.tencent.mm.y.c.a.ip(str.replace("//abtestmsg", ""));
                                            com.tencent.mm.y.c.c.IL().i(ip.hkf, 0);
                                            com.tencent.mm.y.c.c.IM().i(ip.hkg, 1);
                                            return true;
                                        } else if (str.startsWith("//triggergetabtest")) {
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, Long.valueOf(1));
                                            return true;
                                        } else if (str.startsWith("//vad")) {
                                            cgg = ad.cgg();
                                            if (cgg == null) {
                                                return false;
                                            }
                                            if (str.startsWith("//vad get")) {
                                                com.tencent.mm.ui.base.h.B(context, com.tencent.mm.bf.a.c.Vh(), "VAD PARAMS").show();
                                                return true;
                                            }
                                            edit2 = cgg.edit();
                                            if (str.startsWith("//vad sd")) {
                                                edit2.putInt("s_delay_time", Integer.valueOf(str.substring(9).trim()).intValue());
                                            }
                                            if (str.startsWith("//vad st")) {
                                                edit2.putInt("sil_time", Integer.valueOf(str.substring(9).trim()).intValue());
                                            }
                                            if (str.startsWith("//vad snr")) {
                                                edit2.putFloat("s_n_ration", Float.valueOf(str.substring(10).trim()).floatValue());
                                            }
                                            if (str.startsWith("//vad sw")) {
                                                edit2.putInt("s_window", Integer.valueOf(str.substring(9).trim()).intValue());
                                            }
                                            if (str.startsWith("//vad sl")) {
                                                edit2.putInt("s_length", Integer.valueOf(str.substring(9).trim()).intValue());
                                            }
                                            edit2.apply();
                                            return true;
                                        } else if (str.startsWith("//dumpabtestrecords")) {
                                            if (2 < x.getLogLevel()) {
                                                return false;
                                            }
                                            if (str.contains("info")) {
                                                replace = com.tencent.mm.y.c.c.IM().ciu();
                                            } else {
                                                replace = com.tencent.mm.y.c.c.IL().ciu();
                                            }
                                            textView2 = new TextView(context);
                                            textView2.setText(replace);
                                            textView2.setGravity(8388627);
                                            textView2.setTextSize(1, 10.0f);
                                            textView2.setLayoutParams(new LayoutParams(-1, -2));
                                            textView2.setTextColor(-16744704);
                                            textView2.setTypeface(Typeface.MONOSPACE);
                                            textView2.setMovementMethod(new ScrollingMovementMethod());
                                            intValue = context.getResources().getDimensionPixelSize(R.f.bvw);
                                            textView2.setPadding(intValue, intValue, intValue, intValue);
                                            com.tencent.mm.ui.base.h.a(context, null, textView2, null);
                                            return true;
                                        } else if (str.startsWith("//triggerWebViewCookiesCleanup")) {
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, Long.valueOf(0));
                                            return true;
                                        } else if (str.startsWith("//cleanwebcache")) {
                                            com.tencent.mm.sdk.b.a.xmy.m(new bl());
                                            return true;
                                        } else if (str.startsWith("//triggerWebViewCacheCleanup")) {
                                            intent = new Intent();
                                            intent.setComponent(new ComponentName(com.tencent.mm.ui.e.h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                                            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                                            context.sendBroadcast(intent);
                                            return true;
                                        } else if (str.startsWith("//dumpsnsabtest")) {
                                            com.tencent.mm.sdk.b.a.xmy.m(new ci());
                                            return true;
                                        } else if (str.startsWith("//dumpsilkvoicefile")) {
                                            r.igr = true;
                                            return true;
                                        } else if (str.startsWith("//fucktit")) {
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_SUBMENU_SHOW_TIT_BOOLEAN, Boolean.valueOf(true));
                                            return true;
                                        } else if (str.startsWith("//clog ")) {
                                            com.tencent.mm.plugin.report.service.g.pWK.dY(str.substring(7), "test cLog " + System.currentTimeMillis());
                                            return true;
                                        } else if (str.startsWith("//testformsg") && com.tencent.mm.sdk.a.b.cfx()) {
                                            str22 = str.substring(12).trim();
                                            x.i("MicroMsg.CommandProcessor", "MMCore.getSysCmdMsgExtension() " + as.getSysCmdMsgExtension());
                                            bx bxVar = new bx();
                                            bxVar.vNO = com.tencent.mm.platformtools.n.oK(str22);
                                            bxVar.nlX = 10002;
                                            as.getSysCmdMsgExtension().b(new com.tencent.mm.ad.d.a(bxVar, false, false, false));
                                            return true;
                                        } else if (str.startsWith("//canwebviewcachedownload")) {
                                            booleanValue = bi.getInt(bi.oM(str.substring(25)).trim(), 1) > 0;
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_SET_CAN_WEBVIEW_CACHE_DOWNLOAD_BOOLEAN, Boolean.valueOf(booleanValue));
                                            return true;
                                        } else if (str.startsWith("//canwebviewcacheprepushdownload")) {
                                            booleanValue = bi.getInt(bi.oM(str.substring(32)).trim(), 1) > 0;
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_SET_CAN_WEBVIEW_CACHE_PRE_PUSH_DOWNLOAD_BOOLEAN, Boolean.valueOf(booleanValue));
                                            return true;
                                        } else if (str.startsWith("//resetsnslukcy")) {
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCTRLHASSHOW_BOOLEAN_SYNC, Boolean.valueOf(false));
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, Integer.valueOf(0));
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, Integer.valueOf(0));
                                            com.tencent.mm.sdk.b.a.xmy.m(new qh());
                                            return true;
                                        } else if (str.startsWith("//mmimgdec ")) {
                                            str22 = str.substring(11);
                                            if ("on".equalsIgnoreCase(str22)) {
                                                MMBitmapFactory.setUseMMBitmapFactory(true);
                                                Toast.makeText(context, "内置图片(png)解析库开启", 0).show();
                                            } else if ("off".equalsIgnoreCase(str22)) {
                                                MMBitmapFactory.setUseMMBitmapFactory(false);
                                                Toast.makeText(context, "内置图片(png)解析库关闭", 0).show();
                                            }
                                            return true;
                                        } else if (str.startsWith("//enablempsp")) {
                                            com.tencent.mm.sdk.platformtools.an.a.lI(false);
                                            Toast.makeText(context, "设置成功，请重启微信！", 0).show();
                                            return true;
                                        } else if (str.startsWith("//disablempsp")) {
                                            com.tencent.mm.sdk.platformtools.an.a.lI(true);
                                            Toast.makeText(context, "设置成功，请重启微信！", 0).show();
                                            return true;
                                        } else if (str.startsWith("//soterpay")) {
                                            com.tencent.mm.bl.d.y(context, "fingerprint", ".ui.SoterPayTestUI");
                                            return true;
                                        } else if (str.startsWith(context.getString(R.l.eVr))) {
                                            r.igy = !r.igy;
                                            Toast.makeText(ad.getContext(), String.format("showVoipDebugLog:%b", new Object[]{Boolean.valueOf(r.igy)}), 0).show();
                                            return true;
                                        } else if (str.startsWith("//getdltaskinfo")) {
                                            str22 = str.replace("//getdltaskinfo ", "");
                                            try {
                                                if (com.tencent.mm.plugin.downloader.model.e.cf(bi.getLong(str22, 0)) != null) {
                                                    x.i("getdltaskinfo", "%d, %s, %s, %s", Long.valueOf(com.tencent.mm.plugin.downloader.model.e.cf(bi.getLong(str22, 0)).field_downloadId), com.tencent.mm.plugin.downloader.model.e.cf(bi.getLong(str22, 0)).field_downloadUrl, com.tencent.mm.plugin.downloader.model.e.cf(bi.getLong(str22, 0)).field_filePath, com.tencent.mm.plugin.downloader.model.e.cf(bi.getLong(str22, 0)).field_md5);
                                                } else {
                                                    x.i("getdltaskinfo", "infoID null");
                                                }
                                            } catch (Exception e18) {
                                                if (com.tencent.mm.plugin.downloader.model.e.yn(str22) != null) {
                                                    x.i("getdltaskinfo", "%d, %s, %s, %s", Long.valueOf(com.tencent.mm.plugin.downloader.model.e.yn(str22).field_downloadId), com.tencent.mm.plugin.downloader.model.e.yn(str22).field_downloadUrl, com.tencent.mm.plugin.downloader.model.e.yn(str22).field_filePath, com.tencent.mm.plugin.downloader.model.e.yn(str22).field_md5);
                                                } else {
                                                    x.i("getdltaskinfo", "infoURL null");
                                                }
                                            }
                                            return true;
                                        } else if (str.startsWith("//testscan ")) {
                                            split = str.split(" ");
                                            r.igx = bi.getFloat(split[1], 0.0f);
                                            r.igw = bi.getFloat(split[2], 0.0f);
                                            Toast.makeText(ad.getContext(), "mode auto:" + r.igx + ",mode continuous:" + r.igw, 1).show();
                                            return true;
                                        } else if (str.startsWith("//switchrecordmode")) {
                                            sharedPreferences = ad.cgg();
                                            z2 = sharedPreferences.getBoolean("settings_voicerecorder_mode", false);
                                            sharedPreferences.edit().putBoolean("settings_voicerecorder_mode", !z2).commit();
                                            if (z2) {
                                                Toast.makeText(ad.getContext(), "Turn off silk record", 1).show();
                                            } else {
                                                Toast.makeText(ad.getContext(), "Turn on silk record", 1).show();
                                            }
                                            return true;
                                        } else if (str.startsWith("//indoorsensorconfig ")) {
                                            com.tencent.mm.modelstat.e.SZ().mP(str.replace("//indoorsensorconfig ", ""));
                                            return true;
                                        } else if (str.startsWith("//testindoorsensor ")) {
                                            String[] split4 = str.replace("//testindoorsensor ", "").split(",");
                                            com.tencent.mm.modelstat.e.SZ().a(12345, false, split4[0].equals("1"), bi.getFloat(split4[1], 0.0f), bi.getFloat(split4[2], 0.0f), 12);
                                            return true;
                                        } else if (str.startsWith("//facedebug")) {
                                            return true;
                                        } else {
                                            if (str.startsWith("//rstfacett")) {
                                                return true;
                                            }
                                            if (str.startsWith("//switchjsc")) {
                                                str22 = str.replace("//switchjsc ", "");
                                                sharedPreferences = ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                                                if ("clear".equals(str22)) {
                                                    sharedPreferences.edit().remove("switch_x5_jscore").apply();
                                                } else if ("true".equals(str22)) {
                                                    sharedPreferences.edit().putBoolean("switch_x5_jscore", true).apply();
                                                } else if ("false".equals(str22)) {
                                                    sharedPreferences.edit().putBoolean("switch_x5_jscore", false).apply();
                                                }
                                                return true;
                                            } else if (str.startsWith("//rfcdn")) {
                                                try {
                                                    com.tencent.mm.modelcdntran.g.MQ().keep_OnRequestDoGetCdnDnsInfo(888);
                                                } catch (Throwable e522222222) {
                                                    x.e("MicroMsg.CommandProcessor", "rfcdn :%s", bi.i(e522222222));
                                                }
                                                return true;
                                            } else {
                                                if (str.startsWith("//testcrscroll ")) {
                                                    split = str.split(" ");
                                                    if (split != null && split.length > 1) {
                                                        com.tencent.mm.ui.chatting.b.w.yJP = bi.getInt(split[1], 0);
                                                        x.i("MicroMsg.CommandProcessor", "summerbadcr testscroll new BADCR_SCROLL_DELAY[%d]", Integer.valueOf(com.tencent.mm.ui.chatting.b.w.yJP));
                                                        return true;
                                                    }
                                                }
                                                if (str.startsWith("//switchx5jscore")) {
                                                    cgg = ad.cgg();
                                                    cgg.edit().putBoolean("switch_x5_jscore", !cgg.getBoolean("switch_x5_jscore", true)).apply();
                                                    return true;
                                                } else if (str.startsWith("//removeaudioplayer")) {
                                                    split = str.split(" ");
                                                    if (split.length >= 2) {
                                                        intValue = bi.getInt(split[1], 3);
                                                        if (intValue >= 2 && intValue <= 9) {
                                                            as.Hm();
                                                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_MUSIC_RREMOVE_PLAYING_AUDIO_PLAYER_GROUP_COUNT_INT_SYNC, Integer.valueOf(intValue));
                                                        }
                                                    }
                                                    return true;
                                                } else if (str.startsWith("//showaudiotoast")) {
                                                    split = str.split(" ");
                                                    if (split.length >= 2) {
                                                        intValue = bi.getInt(split[1], 0);
                                                        as.Hm();
                                                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_MUSIC_SHOW_AUDIO_TOAST_BOOLEAN_SYNC, Boolean.valueOf(intValue == 1));
                                                    }
                                                    return true;
                                                } else if (str.startsWith("//switchmusicplayer")) {
                                                    x.i("MicroMsg.CommandProcessor", "msg:%s", str);
                                                    split2 = str.split(" ");
                                                    if (split2.length > 2) {
                                                        Object obj;
                                                        if (bi.getInt(split2[1], 0) == 0) {
                                                            obj = null;
                                                        } else {
                                                            dimensionPixelSize = 1;
                                                        }
                                                        int i2 = bi.getInt(split2[2], -1);
                                                        as.Hm();
                                                        i = ((Integer) com.tencent.mm.y.c.Db().get(w.a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(0))).intValue();
                                                        replace2 = 1;
                                                        if (i2 == -1) {
                                                            if (obj != null) {
                                                                dimensionPixelSize = 255;
                                                            } else {
                                                                dimensionPixelSize = 0;
                                                            }
                                                        } else if (i2 == 0) {
                                                            if (obj != null) {
                                                                dimensionPixelSize = i | 1;
                                                            } else {
                                                                dimensionPixelSize = i & -2;
                                                            }
                                                        } else if (i2 == 1) {
                                                            if (obj != null) {
                                                                dimensionPixelSize = i | 2;
                                                            } else {
                                                                dimensionPixelSize = i & -3;
                                                            }
                                                        } else if (i2 == 4) {
                                                            if (obj != null) {
                                                                dimensionPixelSize = i | 4;
                                                            } else {
                                                                dimensionPixelSize = i & -5;
                                                            }
                                                        } else if (i2 == 6) {
                                                            if (obj != null) {
                                                                dimensionPixelSize = i | 16;
                                                            } else {
                                                                dimensionPixelSize = i & -17;
                                                            }
                                                        } else if (i2 == 7) {
                                                            if (obj != null) {
                                                                dimensionPixelSize = i | 32;
                                                            } else {
                                                                dimensionPixelSize = i & -33;
                                                            }
                                                        } else if (i2 == 8) {
                                                            if (obj != null) {
                                                                dimensionPixelSize = i | 64;
                                                            } else {
                                                                dimensionPixelSize = i & -65;
                                                            }
                                                        } else if (i2 != 9) {
                                                            replace2 = null;
                                                            dimensionPixelSize = i;
                                                        } else if (obj != null) {
                                                            dimensionPixelSize = i | FileUtils.S_IWUSR;
                                                        } else {
                                                            dimensionPixelSize = i & -129;
                                                        }
                                                        if (replace2 != null) {
                                                            as.Hm();
                                                            com.tencent.mm.y.c.Db().a(w.a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(dimensionPixelSize));
                                                        }
                                                    }
                                                    return true;
                                                } else if (str.startsWith("//testdefaultrsa")) {
                                                    x.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa");
                                                    split = str.split(" ");
                                                    booleanValue = split != null && split.length > 1;
                                                    ac.H("", "", 0);
                                                    new v("", "", "", 0).Se().a(com.tencent.mm.kernel.g.Dp().CN().CR(), new com.tencent.mm.ad.e() {
                                                        public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                                                            x.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa NetSceneManualAuth onSceneEnd [%d, %d, %s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                                                            if (i != 4 || i2 == -102 || booleanValue) {
                                                                new com.tencent.mm.modelsimple.m().a(com.tencent.mm.kernel.g.Dp().gRu.hoF, new com.tencent.mm.ad.e() {
                                                                    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                                                                        x.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa  NetSceneGetCert onSceneEnd [%d, %d, %s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                                                                        if (i == 4 && i2 == -102) {
                                                                            com.tencent.mm.sdk.platformtools.ah.y(new Runnable() {
                                                                                public final void run() {
                                                                                    b.v(context, "RSA(base) fatal err, must recheck!!!");
                                                                                }
                                                                            });
                                                                            return;
                                                                        }
                                                                        Toast.makeText(context, "DefaultRSA check pass", 0).show();
                                                                        b.v(context, "");
                                                                    }
                                                                });
                                                            } else {
                                                                com.tencent.mm.sdk.platformtools.ah.y(new Runnable() {
                                                                    public final void run() {
                                                                        b.v(context, "RSA(req) fatal err, must recheck!!!");
                                                                    }
                                                                });
                                                            }
                                                        }
                                                    });
                                                    return true;
                                                } else if (str.startsWith("//dumpdefaultrsa")) {
                                                    return v(context, "");
                                                } else {
                                                    if (str.startsWith("//hardwareinfo")) {
                                                        ((com.tencent.mm.plugin.hardwareopt.a.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.hardwareopt.a.a.a.class)).fO(true);
                                                        return true;
                                                    } else if (str.startsWith("//showStringName")) {
                                                        cgg = ad.cgg();
                                                        cgg.edit().putBoolean("ShowStringName", !cgg.getBoolean("ShowStringName", false)).commit();
                                                        return true;
                                                    } else if (str.startsWith("//mmphotoedit")) {
                                                        com.tencent.mm.bl.d.b(context, "mmsight", ".ui.TestVideoEditUI", new Intent());
                                                        return true;
                                                    } else if (str.startsWith("//openwebviewhistory")) {
                                                        com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.fts.FtsBrowseHistoryUI", new Intent());
                                                        return true;
                                                    } else if (str.startsWith("//msgDelay")) {
                                                        com.tencent.mm.ui.conversation.a.m.fX(context);
                                                        return true;
                                                    } else if (str.startsWith("//cpDelayedMsg")) {
                                                        com.tencent.mm.ui.conversation.a.m.fY(context);
                                                        return true;
                                                    } else if (str.startsWith("//testhce")) {
                                                        com.tencent.mm.bl.d.y(context, "nfc", ".ui.HceTestUI");
                                                        return true;
                                                    } else if (str.startsWith("//testservice ")) {
                                                        str22 = str.replace("//testservice ", "");
                                                        edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                                                        str4 = "forceTrigger";
                                                        booleanValue = str22 != null && str22.equals("1");
                                                        edit.putBoolean(str4, booleanValue).commit();
                                                        return true;
                                                    } else if (str.startsWith("//openDetect")) {
                                                        ad.getContext().getSharedPreferences("system_config_prefs", 4).edit().putBoolean("msg_delay_close_detect", false).apply();
                                                        return true;
                                                    } else if (str.startsWith("//closeDetect")) {
                                                        ad.getContext().getSharedPreferences("system_config_prefs", 4).edit().putBoolean("msg_delay_close_detect", true).apply();
                                                        return true;
                                                    } else if (str.startsWith("//jointtest")) {
                                                        split = str.split(" ");
                                                        if (split.length == 2) {
                                                            if (split[1].equals("1")) {
                                                                ad.cgg().edit().putBoolean("voice_split_test", true).apply();
                                                            } else if (split[1].equals("0")) {
                                                                ad.cgg().edit().putBoolean("voice_split_test", false).apply();
                                                            }
                                                        }
                                                        return true;
                                                    } else {
                                                        x.d("MicroMsg.CommandProcessor", "processed : in ret:[%d]", Integer.valueOf(fa(str)));
                                                        switch (fa(str)) {
                                                            case 0:
                                                                return false;
                                                            case 568:
                                                                Assert.assertTrue("test errlog", false);
                                                                return true;
                                                            case 569:
                                                                as.Hm().FK();
                                                                return true;
                                                            case 570:
                                                                if (com.tencent.mm.storage.be.Yr(fb(str))) {
                                                                    Toast.makeText(context, R.l.eUL, 0).show();
                                                                }
                                                                return true;
                                                            case 571:
                                                                str22 = fb(str);
                                                                as.Hm();
                                                                com.tencent.mm.y.c.Db().set(8195, str22);
                                                                return true;
                                                            case 572:
                                                                com.tencent.mm.sdk.platformtools.f.fek = Integer.valueOf(fb(str)).intValue();
                                                                return true;
                                                            case 574:
                                                                StringBuilder append = new StringBuilder().append(com.tencent.mm.compatible.e.q.yL());
                                                                as.Hm();
                                                                com.tencent.mm.ui.base.h.B(context, com.tencent.mm.a.g.s(append.append(com.tencent.mm.y.c.Cn()).toString().getBytes()), "md5");
                                                                return true;
                                                            case 579:
                                                                ak.a.GW().Q(fb(str), "");
                                                                return true;
                                                            case 580:
                                                                as.CN().d(new be(new be.a() {
                                                                    public final void a(com.tencent.mm.network.e eVar) {
                                                                        if (eVar != null) {
                                                                            com.tencent.mm.network.c KD = eVar.KD();
                                                                            byte[] bArr = new byte[0];
                                                                            as.Hm();
                                                                            KD.v(bArr, com.tencent.mm.y.c.Cn());
                                                                        }
                                                                    }
                                                                }));
                                                                return true;
                                                            case 581:
                                                                an.biS().Si(fb(str));
                                                                return true;
                                                            case 582:
                                                                str22 = fb(str);
                                                                as.Hm();
                                                                Xv = com.tencent.mm.y.c.Ff().Xv(str22);
                                                                if (Xv == null || Xv.AV() == 0) {
                                                                    return false;
                                                                }
                                                                Xv.An();
                                                                com.tencent.mm.y.s.t(Xv);
                                                                return true;
                                                            case 583:
                                                                as.Hm();
                                                                com.tencent.mm.y.c.FL();
                                                                return true;
                                                            case 584:
                                                            case 585:
                                                                bd.hY(fb(str));
                                                                return true;
                                                            case 586:
                                                                split = str.split(" ");
                                                                if (split != null && split.length == 3) {
                                                                    com.tencent.mm.modelmulti.t.bd(bi.getInt(split[1], 0), bi.getInt(split[2], 0));
                                                                }
                                                                return true;
                                                            case 587:
                                                                com.tencent.mm.sdk.b.a.xmy.m(new cj());
                                                                return true;
                                                            case 588:
                                                                com.tencent.mm.a.e.bS("/sdcard/tencent/MicroMsg/back");
                                                                as.Hm();
                                                                com.tencent.mm.sdk.platformtools.k.r(com.tencent.mm.y.c.FI(), "/sdcard/tencent/MicroMsg/back", false);
                                                                return true;
                                                            case 590:
                                                                return true;
                                                            case 591:
                                                                try {
                                                                    split = str.split(" ");
                                                                    if (split != null && split.length > 1) {
                                                                        as.Hm().FO().p(com.tencent.mm.sdk.platformtools.bj.y(split[0], "sysmsg"));
                                                                    }
                                                                } catch (Throwable e5222222222) {
                                                                    x.printErrStackTrace("MicroMsg.CommandProcessor", e5222222222, "hy: error occured in commandProcessor", new Object[0]);
                                                                }
                                                                return true;
                                                            default:
                                                                return false;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean v(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!bi.oN(str)) {
            stringBuffer.append(str + "\n\n");
        }
        stringBuffer.append("Default RSA Info:\n");
        stringBuffer.append("ClientVersion: " + com.tencent.mm.sdk.platformtools.e.CLIENT_VERSION + "\n");
        stringBuffer.append("BASE_RSA_PUBLIC_VERSION = 169\n");
        stringBuffer.append("BASE_RSA_PUBLIC_KEYN = C8B29DB2928FF09CBF561E20E0BDCB9700BF14E02E8291F45811C41569153644267C7C74060BD9D35B6D831F532D3552C8D453682C624F935DFF256E9ACA6735DBB7F9578CF87B0223A8C59CF1740CBA1C34A531D3C0AFED9A076781DCB9611448B3384DF377AF1FF3FD3663756ED675F663F3CCA0B1C7C800644721ECC0823730EC77F8159C2D48BFE0493035914655D24E77940F31C770DD661D7512342CC67C13D1FFBDA1EF32961F5DEA5D94F176FA7A338338D9E039EC194F90637C324B1C627CBBE9DC4004843B37FE7854C6D8A99A5E288EC525E0847618BD0196A87218060ADF0C8D82D8AF07BF718BDDA54D0140DF8293EE76FFC93D3DCFD20F8883 len(512" + ")\n");
        stringBuffer.append("BASE_RSA_PUBLIC_KEYE = 010001\n\n");
        stringBuffer.append("REQ_RSA_PUBLIC_VERSION = 170\n");
        stringBuffer.append("REQ_RSA_PUBLIC_KEYN = 994B7DB5D0A2C31D8F68D63224EEC9EB5866B665B03656B357EACCA065257A9B8360E647F91E770B0B52B8015CEBF06CCEE57164021661F1DAF533284C12FAB4EB6D7B808F62E6AD3975BD138693ADCA93A147BC81843A9ED177D504A3D157CC8DD99ADA3DC2A348E498939507A70A6C20880B070D030CDEC304B3C3248F9D2D352B8932D865BFDAD64CF74F98A073043CB43A51A3F582AF36E2523FC56A8224DD2056EDF8790ABE32724F205A949A31E2FFD055823F9D249081482672EAC75BE0755E0EE9DF3FBCA3F50004CFC17B84590FA963DA07765B983EDC39673CCE269CACB6CBAFCA62C13FCBF1461F7C07E8FFA5B6E3EB4D54DEC6872AC8B26585EF len(512" + ")\n");
        stringBuffer.append("REQ_RSA_PUBLIC_KEYE = 010001\n");
        x.i("MicroMsg.CommandProcessor", "summercert dumpdefaultrsa " + stringBuffer.toString());
        if (!com.tencent.mm.sdk.a.b.cfx()) {
            return false;
        }
        View textView = new TextView(context);
        textView.setText(stringBuffer.toString());
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16711936);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bvW);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        com.tencent.mm.ui.base.h.a(context, null, textView, null);
        if (!ac.ceC()) {
            return true;
        }
        Toast.makeText(context, "dump file:" + com.tencent.mm.compatible.util.e.bnF + "DefaultRSA.java", 1).show();
        return true;
    }

    private static StringBuilder fU(int i) {
        Throwable e;
        Date date = new Date(bi.Wy() - (((long) i) * 86400000));
        String str = com.tencent.mm.compatible.util.e.hbx + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt";
        StringBuilder stringBuilder = new StringBuilder();
        if (!new File(str).exists()) {
            return new StringBuilder(" day -" + i + " no crash.");
        }
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            try {
                if (bi.oN(bufferedReader.readLine())) {
                    bufferedReader.close();
                    StringBuilder stringBuilder2 = new StringBuilder("read day -" + i + "file failed");
                    try {
                        bufferedReader.close();
                        return stringBuilder2;
                    } catch (Exception e2) {
                        return stringBuilder2;
                    }
                }
                while (true) {
                    str = bufferedReader.readLine();
                    if (str != null) {
                        stringBuilder.append(new String(Base64.decode(str.split("error_")[1], 0)).split("#accinfo.uin=")[1]);
                        stringBuilder.append("\n_____________________________________\n");
                    } else {
                        try {
                            bufferedReader.close();
                            break;
                        } catch (Exception e3) {
                        }
                    }
                }
                return stringBuilder;
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            try {
                x.printErrStackTrace("MicroMsg.CommandProcessor", e, "", new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e6) {
                    }
                }
                return stringBuilder;
            } catch (Throwable th) {
                e = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e7) {
                    }
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e;
        }
    }

    private static void fV(int i) {
        SharedPreferences bh = com.tencent.mm.sdk.platformtools.an.bh(ad.getContext(), "sp_sns_dynswitch_stg");
        switch (i) {
            case -1:
                bh.edit().remove("st_sw_use_vcodec_img").commit();
                return;
            case 0:
                bh.edit().putBoolean("st_sw_use_vcodec_img", false).commit();
                return;
            case 1:
                bh.edit().putBoolean("st_sw_use_vcodec_img", true).commit();
                return;
            default:
                throw new IllegalArgumentException("Bad op parameter: " + i);
        }
    }

    private static void fW(int i) {
        SharedPreferences bh = com.tencent.mm.sdk.platformtools.an.bh(ad.getContext(), "sp_sns_dynswitch_stg");
        switch (i) {
            case -1:
                bh.edit().remove("st_sw_use_wxpc_img").commit();
                return;
            case 0:
                bh.edit().putBoolean("st_sw_use_wxpc_img", false).commit();
                return;
            case 1:
                bh.edit().putBoolean("st_sw_use_wxpc_img", true).commit();
                return;
            default:
                throw new IllegalArgumentException("Bad op parameter: " + i);
        }
    }
}
