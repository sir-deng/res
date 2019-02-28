package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public final class m {
    public static void a(final Activity activity, final Runnable runnable, boolean z, final int i) {
        if (com.tencent.mm.modelfriend.m.NT() == a.SUCC || com.tencent.mm.modelfriend.m.NT() == a.SUCC_UNLOAD) {
            as.Hm();
            if (bi.c((Boolean) c.Db().get(12322, null))) {
                x.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
            } else {
                if (!z) {
                    as.Hm();
                    if (bi.c((Boolean) c.Db().get(12323, null))) {
                        x.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
                    }
                }
                as.Hm();
                c.Db().set(12322, Boolean.valueOf(false));
                String oM = bi.oM(bi.fa(activity));
                if (oM.length() > 0) {
                    as.Hm();
                    if (oM.equals(c.Db().get(6, null))) {
                        as.Hm();
                        c.Db().set(12322, Boolean.valueOf(true));
                        x.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
                    }
                }
                h.a((Context) activity, R.l.dKP, R.l.dGZ, R.l.dHo, R.l.dGc, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(i));
                        g.pWK.h(11438, Integer.valueOf(i));
                        as.Hm();
                        c.Db().set(12322, Boolean.valueOf(true));
                        m.k(true, false);
                        com.tencent.mm.modelfriend.a.Ns();
                        if (runnable != null) {
                            runnable.run();
                        }
                        activity.getSharedPreferences(ad.cgf(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        as.Hm();
                        c.Db().set(12322, Boolean.valueOf(false));
                        m.k(false, false);
                        if (runnable != null) {
                            runnable.run();
                        }
                        activity.getSharedPreferences(ad.cgf(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
                    }
                });
                as.Hm();
                c.Db().set(12323, Boolean.valueOf(true));
                return;
            }
        }
        x.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void k(boolean z, boolean z2) {
        int Gc = q.Gc();
        if (z) {
            Gc &= -131073;
        } else {
            Gc |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        }
        x.d("MicroMsg.PostLoginUtil", "Reg By mobile update = " + Gc);
        as.Hm();
        c.Db().set(7, Integer.valueOf(Gc));
        Gc = !z ? 1 : 2;
        as.Hm();
        c.Fe().b(new com.tencent.mm.ax.g(17, Gc));
        if (z2) {
            com.tencent.mm.plugin.c.a.ihO.un();
        }
    }

    public static void oJ(String str) {
        ar.hhz.S("login_user_name", str);
    }

    public static void bE(final Context context) {
        String string = context.getString(R.l.dDQ);
        final String string2 = context.getString(R.l.dDP);
        String string3 = context.getString(R.l.dUn);
        String string4 = context.getString(R.l.dUl);
        OnClickListener anonymousClass3 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string2);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                com.tencent.mm.plugin.c.a.ihN.j(intent, context);
            }
        };
        h.a(context, string, "", string3, string4, anonymousClass3, null);
    }

    public static void j(final Context context, String str, final String str2) {
        com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
        if (eC != null) {
            eC.a(context, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                    com.tencent.mm.plugin.c.a.ihN.j(intent, context);
                }
            }, null);
        }
    }

    public static void a(Context context, v.a aVar, int i) {
        Intent intent = new Intent(context, BioHelperUI.class);
        intent.putExtra("k_type", aVar.type);
        intent.putExtra("KVoiceHelpCode", i);
        intent.putExtra("Kvertify_key", aVar.fsK);
        intent.putExtra("KVoiceHelpUrl", aVar.hPv);
        intent.putExtra("KVoiceHelpWording", aVar.fzT);
        intent.putExtra("Kusername", aVar.username);
        if (aVar.hPw != null) {
            intent.getExtras().putAll(aVar.hPw);
        }
        context.startActivity(intent);
    }

    public static void c(final Context context, String str, final int i) {
        final com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
        if (eC == null) {
            return;
        }
        if (eC.showType == 8) {
            d(context, eC.url, i);
            return;
        }
        String string = context.getString(R.l.dGf);
        String string2 = context.getString(R.l.dEy);
        OnClickListener anonymousClass5 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                m.d(context, eC.url, i);
            }
        };
        if (eC.showType != 1 && eC.showType != 4) {
            return;
        }
        if (bi.oN(eC.url)) {
            h.b(context, eC.desc, eC.fpg, true);
            return;
        }
        h.a(context, eC.desc, eC.fpg, string, string2, anonymousClass5, null);
    }

    static void d(Context context, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
        if (i > 0) {
            d.b(context, "webview", ".ui.tools.WebViewUI", intent, i);
        } else {
            d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
