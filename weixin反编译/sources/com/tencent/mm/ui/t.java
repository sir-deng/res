package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.f.a.ja;
import com.tencent.mm.f.a.w;
import com.tencent.mm.f.a.y;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.s;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.Map;

public final class t {
    static ProgressDialog inI = null;
    private static boolean xSE = false;
    static SecurityImage xSF = null;

    /* renamed from: com.tencent.mm.ui.t$5 */
    static class AnonymousClass5 implements OnCancelListener {
        final /* synthetic */ Activity ieT;
        final /* synthetic */ Intent xSG = null;

        AnonymousClass5(Intent intent, Activity activity) {
            this.ieT = activity;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            g.pWK.a(405, 39, 1, true);
            if (this.xSG != null) {
                this.ieT.finish();
                this.ieT.startActivity(this.xSG);
                b.B(this.ieT, this.xSG);
            }
        }
    }

    public static class a {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean a(final android.content.Context r9, int r10, int r11, java.lang.String r12, int r13) {
            /*
            r1 = 0;
            r8 = 2;
            r3 = 0;
            r2 = 1;
            switch(r10) {
                case 1: goto L_0x0009;
                case 2: goto L_0x00ed;
                case 3: goto L_0x010b;
                case 4: goto L_0x010e;
                default: goto L_0x0007;
            };
        L_0x0007:
            r0 = r3;
        L_0x0008:
            return r0;
        L_0x0009:
            r0 = r13 & 2;
            if (r0 == 0) goto L_0x0028;
        L_0x000d:
            r0 = com.tencent.mm.y.as.CN();
            r0 = r0.Kt();
            if (r0 == 0) goto L_0x0028;
        L_0x0017:
            r0 = com.tencent.mm.y.as.CN();
            r0.getNetworkServerIp();
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r0.append(r11);
        L_0x0026:
            r0 = r2;
            goto L_0x0008;
        L_0x0028:
            r0 = r13 & 1;
            if (r0 == 0) goto L_0x0038;
        L_0x002c:
            r0 = com.tencent.mm.network.ab.bC(r9);
            if (r0 == 0) goto L_0x0038;
        L_0x0032:
            r0 = com.tencent.mm.pluginsdk.ui.k.ep(r9);
            if (r0 != 0) goto L_0x0026;
        L_0x0038:
            r0 = r13 & 4;
            if (r0 == 0) goto L_0x004b;
        L_0x003c:
            r0 = com.tencent.mm.sdk.platformtools.ao.isWap(r9);
            if (r0 == 0) goto L_0x004b;
        L_0x0042:
            r0 = com.tencent.mm.y.as.Hp();
            if (r0 != 0) goto L_0x0067;
        L_0x0048:
            r0 = r3;
        L_0x0049:
            if (r0 != 0) goto L_0x0026;
        L_0x004b:
            r0 = com.tencent.mm.R.l.eiQ;
            r1 = new java.lang.Object[r8];
            r4 = java.lang.Integer.valueOf(r2);
            r1[r3] = r4;
            r3 = java.lang.Integer.valueOf(r11);
            r1[r2] = r3;
            r0 = r9.getString(r0, r1);
            r0 = android.widget.Toast.makeText(r9, r0, r2);
            r0.show();
            goto L_0x0026;
        L_0x0067:
            com.tencent.mm.y.as.Hm();
            r0 = com.tencent.mm.y.c.Db();
            r4 = 61;
            r0 = r0.get(r4, r1);
            r0 = (java.lang.Boolean) r0;
            r0 = com.tencent.mm.sdk.platformtools.bi.c(r0);
            if (r0 == 0) goto L_0x007e;
        L_0x007c:
            r0 = r3;
            goto L_0x0049;
        L_0x007e:
            r0 = "show_wap_adviser";
            r0 = com.tencent.mm.sdk.platformtools.af.VI(r0);
            if (r0 != 0) goto L_0x0089;
        L_0x0087:
            r0 = r3;
            goto L_0x0049;
        L_0x0089:
            r0 = com.tencent.mm.R.i.dpc;
            r1 = android.view.View.inflate(r9, r0, r1);
            r0 = com.tencent.mm.R.h.czp;
            r0 = r1.findViewById(r0);
            r0 = (android.widget.TextView) r0;
            r4 = com.tencent.mm.R.l.eyb;
            r0.setText(r4);
            r0 = com.tencent.mm.R.h.czo;
            r0 = r1.findViewById(r0);
            r0 = (android.widget.CheckBox) r0;
            r4 = com.tencent.mm.R.l.eBm;
            r4 = r9.getString(r4);
            r0.setText(r4);
            r4 = new com.tencent.mm.ui.MMAppMgr$12;
            r4.<init>();
            r0.setOnCheckedChangeListener(r4);
            r0.setVisibility(r3);
            r0 = new com.tencent.mm.ui.base.i$a;
            r0.<init>(r9);
            r4 = com.tencent.mm.R.l.dGZ;
            r0.ES(r4);
            r0.dk(r1);
            r1 = com.tencent.mm.R.l.eBo;
            r1 = r0.EV(r1);
            r4 = new com.tencent.mm.ui.MMAppMgr$13;
            r4.<init>(r9);
            r1.a(r4);
            r0.mp(r3);
            r1 = com.tencent.mm.R.l.eBn;
            r0.EW(r1);
            r1 = new com.tencent.mm.ui.MMAppMgr$14;
            r1.<init>();
            r0.a(r1);
            r0 = r0.ale();
            r0.show();
            r0 = r2;
            goto L_0x0049;
        L_0x00ed:
            r0 = com.tencent.mm.R.l.eiR;
            r1 = new java.lang.Object[r8];
            r4 = java.lang.Integer.valueOf(r8);
            r1[r3] = r4;
            r3 = java.lang.Integer.valueOf(r11);
            r1[r2] = r3;
            r0 = r9.getString(r0, r1);
            r0 = android.widget.Toast.makeText(r9, r0, r2);
            r0.show();
            r0 = r2;
            goto L_0x0008;
        L_0x010b:
            r0 = r2;
            goto L_0x0008;
        L_0x010e:
            r4 = com.tencent.mm.g.a.eC(r12);
            if (r4 == 0) goto L_0x0007;
        L_0x0114:
            r0 = "MicroMsg.MMErrorProcessor";
            r5 = "summertips errCode[%d], showType[%d], url[%s], desc[%s]";
            r6 = 4;
            r6 = new java.lang.Object[r6];
            r7 = java.lang.Integer.valueOf(r11);
            r6[r3] = r7;
            r7 = r4.showType;
            r7 = java.lang.Integer.valueOf(r7);
            r6[r2] = r7;
            r7 = r4.url;
            r6[r8] = r7;
            r7 = 3;
            r8 = r4.desc;
            r6[r7] = r8;
            com.tencent.mm.sdk.platformtools.x.i(r0, r5, r6);
            r0 = r4.url;
            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
            if (r0 != 0) goto L_0x014d;
        L_0x013f:
            r0 = new com.tencent.mm.ui.t$a$1;
            r0.<init>(r4, r9);
        L_0x0144:
            r0 = r4.a(r9, r0, r1);
            if (r0 == 0) goto L_0x0007;
        L_0x014a:
            r0 = r2;
            goto L_0x0008;
        L_0x014d:
            r0 = r1;
            goto L_0x0144;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.t.a.a(android.content.Context, int, int, java.lang.String, int):boolean");
        }
    }

    public static boolean a(final Activity activity, int i, int i2, final Intent intent, String str) {
        if (i != 4) {
            return false;
        }
        x.d("MicroMsg.MMErrorProcessor", "errType = " + i + " errCode = " + i2);
        switch (i2) {
            case -205:
            case -72:
            case -9:
            case -4:
            case -3:
                x.e("MicroMsg.MMErrorProcessor", "account expired=" + i2);
                h.a((Context) activity, R.l.euI, R.l.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            b.B(activity, intent);
                            d.br(activity);
                        }
                    }
                });
                return true;
            case -140:
            case -104:
                x.e("MicroMsg.MMErrorProcessor", "accout errCode[%d], errMsg[%s]", Integer.valueOf(i2), str);
                if (bi.oN(str) || !str.startsWith("autoauth_errmsg_")) {
                    if (i2 == -104) {
                        x.i("MicroMsg.MMErrorProcessor", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", str);
                        break;
                    }
                }
                str = str.substring(16);
                if (!bi.oN(str) && str.startsWith("<")) {
                    Map y = bj.y(str, "e");
                    if (!(y == null || bi.oN((String) y.get(".e.Content")))) {
                        str = (String) y.get(".e.Content");
                    }
                }
                if (bi.oN(str)) {
                    str = ad.getContext().getString(R.l.euI);
                }
                h.a((Context) activity, str, ad.getContext().getString(R.l.dGZ), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            b.B(activity, intent);
                            d.br(activity);
                        }
                    }
                });
                return true;
            case -100:
                String Cp = as.Cp();
                x.e("MicroMsg.MMErrorProcessor", "account expired=" + i2 + " lastKickReason=" + Cp);
                com.tencent.mm.sdk.b.a.xmy.m(new w());
                com.tencent.mm.sdk.b.b jaVar = new ja();
                jaVar.fAx.status = 0;
                jaVar.fAx.aAk = 1;
                com.tencent.mm.sdk.b.a.xmy.m(jaVar);
                ad.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
                String str2;
                if (xSE) {
                    String str3 = "MicroMsg.MMErrorProcessor";
                    String str4 = "already show kickout dialog before, ignore. lastKickReason[%s]";
                    Object[] objArr = new Object[1];
                    if (bi.oN(Cp)) {
                        str2 = "";
                    } else {
                        str2 = Cp;
                    }
                    objArr[0] = str2;
                    x.i(str3, str4, objArr);
                    return true;
                }
                if (!bi.oN(Cp)) {
                    final com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(Cp);
                    if (eC != null) {
                        x.i("MicroMsg.MMErrorProcessor", "account expired br showType[%d]", Integer.valueOf(eC.showType));
                        if ((eC.showType == 3 || eC.showType == 4) && eC.a(activity, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (intent != null) {
                                    if (!(activity instanceof LauncherUI)) {
                                        activity.finish();
                                    }
                                    as.hold();
                                    if (bi.oN(eC.url)) {
                                        activity.startActivity(intent);
                                        b.B(activity, intent);
                                    } else {
                                        Intent intent = new Intent();
                                        StringBuilder stringBuilder = new StringBuilder(eC.url);
                                        stringBuilder.append("&wechat_real_lang=" + com.tencent.mm.sdk.platformtools.w.cfV());
                                        intent.putExtra("rawUrl", stringBuilder.toString());
                                        intent.putExtra("showShare", false);
                                        intent.putExtra("show_bottom", false);
                                        intent.putExtra("needRedirect", false);
                                        intent.putExtra("neverGetA8Key", true);
                                        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                                        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                                        com.tencent.mm.bl.d.b(activity, "webview", ".ui.tools.WebViewUI", intent);
                                    }
                                    d.br(activity);
                                    com.tencent.mm.sdk.b.b yVar = new y();
                                    yVar.foJ.foK = true;
                                    com.tencent.mm.sdk.b.a.xmy.m(yVar);
                                }
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (intent != null) {
                                    if (!(activity instanceof LauncherUI)) {
                                        activity.finish();
                                    }
                                    activity.startActivity(intent);
                                    b.B(activity, intent);
                                    d.br(activity);
                                }
                            }
                        })) {
                            xSE = true;
                            x.i("MicroMsg.MMErrorProcessor", "show kickout dialog by new logic.");
                            return true;
                        }
                    }
                }
                if (!bi.oN(Cp) && Cp.startsWith("<")) {
                    Map y2 = bj.y(Cp, "e");
                    if (!(y2 == null || bi.oN((String) y2.get(".e.Content")))) {
                        str2 = (String) y2.get(".e.Content");
                        x.i("MicroMsg.MMErrorProcessor", "account expired summerauthkick errmsg=" + str2 + " |v=" + y2);
                        Cp = str2;
                    }
                }
                x.i("MicroMsg.MMErrorProcessor", "account expired lastKickReason[%s]", Cp);
                if (bi.oN(Cp)) {
                    Cp = com.tencent.mm.bu.a.ac(activity, R.l.euH);
                }
                h.a((Context) activity, Cp, activity.getString(R.l.dGZ), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (intent != null) {
                            if (!(activity instanceof LauncherUI)) {
                                activity.finish();
                            }
                            as.hold();
                            activity.startActivity(intent);
                            b.B(activity, intent);
                            d.br(activity);
                            com.tencent.mm.sdk.b.b yVar = new y();
                            yVar.foJ.foK = true;
                            com.tencent.mm.sdk.b.a.xmy.m(yVar);
                        }
                    }
                }, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        if (intent != null) {
                            if (!(activity instanceof LauncherUI)) {
                                activity.finish();
                            }
                            activity.startActivity(intent);
                            b.B(activity, intent);
                            d.br(activity);
                        }
                    }
                });
                xSE = true;
                x.i("MicroMsg.MMErrorProcessor", "show kickout dialog by old logic.");
                return true;
            case -75:
                x.e("MicroMsg.MMErrorProcessor", "account expired=" + i2);
                h.a((Context) activity, R.l.dDQ, R.l.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            b.B(activity, intent);
                            d.br(activity);
                        }
                    }
                });
                return true;
        }
        return false;
    }

    public static i a(final Activity activity, String str, final String str2, final Intent intent) {
        com.tencent.mm.sdk.b.b jaVar = new ja();
        jaVar.fAx.status = 0;
        jaVar.fAx.aAk = 1;
        com.tencent.mm.sdk.b.a.xmy.m(jaVar);
        return h.a((Context) activity, str, activity.getString(R.l.dGZ), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                g.pWK.a(322, 23, 1, true);
                g gVar = g.pWK;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(4023);
                objArr[1] = String.format("%b|%s", new Object[]{Boolean.valueOf(bi.oN(str2)), str2});
                gVar.h(11098, objArr);
                as.hold();
                if (bi.oN(str2)) {
                    activity.startActivity(intent);
                    b.B(activity, intent);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                    com.tencent.mm.bl.d.b(activity, "webview", ".ui.tools.WebViewUI", intent);
                }
                d.br(activity);
            }
        }, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                g.pWK.a(322, 24, 1, true);
                g gVar = g.pWK;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(4024);
                objArr[1] = String.format("%b|%s", new Object[]{Boolean.valueOf(bi.oN(str2)), str2});
                gVar.h(11098, objArr);
                activity.startActivity(intent);
                b.B(activity, intent);
                d.br(activity);
            }
        });
    }

    public static boolean X(Activity activity) {
        boolean z = true;
        if (bi.Wo(com.tencent.mm.j.g.Af().getValue("SilentDownloadApkAtWiFi")) != 0) {
            return false;
        }
        as.Hm();
        boolean z2 = (((Integer) c.Db().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
        if (!(ao.isWifi((Context) activity) && z2)) {
            z = false;
        }
        if ((f.fek & 1) != 0) {
            x.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
            z = false;
        } else {
            x.d("MicroMsg.MMErrorProcessor", "not channel pack.");
        }
        if (z && p.bZO()) {
            return Y(activity);
        }
        return false;
    }

    public static boolean fv(final Context context) {
        final String bZL = p.bZL();
        final int bZM = p.bZM();
        x.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", bZL, Integer.valueOf(bZM));
        if (bi.oN(bZL) || p.bZN()) {
            return false;
        }
        as.Dt().F(new Runnable() {
            public final void run() {
                if (bZM == 4 && com.tencent.mm.pluginsdk.model.app.a.bZm() == null) {
                    x.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
                } else if (q.x.bYQ() != null && q.x.bYQ().Jg(bZL) != null) {
                    ah.y(new Runnable() {
                        public final void run() {
                            if (q.x.bYQ() != null) {
                                q.x.bYQ().dt(context);
                            }
                        }
                    });
                }
            }
        });
        return true;
    }

    public static boolean c(final Activity activity, int i, int i2) {
        x.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.protocal.d.vHl), Integer.valueOf(f.fei), Integer.valueOf(f.fek));
        if (i != 4) {
            return false;
        }
        s b;
        switch (i2) {
            case -17:
                long j = ad.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1);
                x.i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", Long.valueOf(j), Long.valueOf(bi.bz(j)));
                if (j != -1 && bi.bz(j) < 86400) {
                    return true;
                }
                if ((f.fek & 2) != 0) {
                    x.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                    return true;
                }
                x.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                String value = com.tencent.mm.j.g.Af().getValue("SilentDownloadApkAtWiFi");
                as.Hm();
                boolean z = ((((Integer) c.Db().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0 ? 1 : null) != null && (bi.oN(value) || bi.Wo(value) == 0);
                if ((f.fek & 1) != 0) {
                    x.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                    z = false;
                } else {
                    x.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                }
                if (bi.Wo(value) != 0) {
                    x.d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
                }
                x.d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", Boolean.valueOf(z));
                if (z) {
                    g.pWK.a(405, 40, 1, true);
                    return Y(activity);
                } else if (q.x.bYQ() == null) {
                    return false;
                } else {
                    b = q.x.bYQ().b(activity, new AnonymousClass5(null, activity));
                    g.pWK.a(405, 38, 1, true);
                    b.update(2);
                    return true;
                }
            case -16:
                if (q.x.bYQ() == null) {
                    return false;
                }
                b = q.x.bYQ().b(activity, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        g.pWK.a(405, 37, 1, true);
                        activity.finish();
                        MMAppMgr.b(activity, true);
                    }
                });
                g.pWK.a(405, 36, 1, true);
                b.update(1);
                return true;
            default:
                return false;
        }
    }

    private static boolean Y(Activity activity) {
        com.tencent.mm.pluginsdk.model.app.a bZm = com.tencent.mm.pluginsdk.model.app.a.bZm();
        if (bZm != null) {
            bZm.bZp();
            x.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
            return true;
        } else if (q.x.bYQ() == null) {
            return false;
        } else {
            q.x.bYQ().ds(activity).update(2);
            return true;
        }
    }
}
