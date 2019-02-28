package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.af.y;
import com.tencent.mm.f.a.gx;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.j.g;
import com.tencent.mm.k.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.ui.TVInfoUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class k {

    /* renamed from: com.tencent.mm.plugin.shake.d.a.k$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ d qwa;
        final /* synthetic */ Context val$context;

        public AnonymousClass1(d dVar, Context context) {
            this.qwa = dVar;
            this.val$context = context;
        }

        public final void run() {
            k.a(this.qwa, this.val$context, false);
        }
    }

    public static void a(d dVar, Context context, boolean z) {
        int i = 4;
        if (dVar != null) {
            Intent intent;
            switch (dVar.field_type) {
                case 6:
                    String str = dVar.field_username;
                    as.Hm();
                    ag Xv = c.Ff().Xv(str);
                    if (Xv != null) {
                        Intent intent2 = new Intent();
                        if (a.ga(Xv.field_type) && Xv.ciN()) {
                            y.Ml().jN(str);
                            if (dVar.field_distance.equals("1")) {
                                intent2.putExtra("Chat_User", str);
                                intent2.putExtra("finish_direct", true);
                                com.tencent.mm.plugin.shake.a.ihN.e(intent2, context);
                                return;
                            }
                        }
                        intent2.putExtra("Contact_User", str);
                        intent2.putExtra("force_get_contact", true);
                        com.tencent.mm.bl.d.b(context, "profile", ".ui.ContactInfoUI", intent2);
                        return;
                    }
                    return;
                case 7:
                    Intent intent3 = new Intent();
                    i = 18;
                    if (z) {
                        i = 26;
                    }
                    intent3.putExtra("geta8key_scene", i);
                    intent3.putExtra("stastic_scene", 6);
                    intent3.putExtra("KAppId", "wxaf060266bfa9a35c");
                    Bundle bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", "wxaf060266bfa9a35c");
                    intent3.putExtra("jsapiargs", bundle);
                    intent3.putExtra("rawUrl", dVar.field_username);
                    intent3.putExtra("srcUsername", dVar.field_distance);
                    com.tencent.mm.plugin.shake.a.ihN.j(intent3, context);
                    return;
                case 8:
                    intent = new Intent();
                    intent.setClass(context, TVInfoUI.class);
                    intent.putExtra("key_TV_xml_bytes", dVar.field_lvbuffer);
                    intent.putExtra("key_TV_come_from_shake", true);
                    context.startActivity(intent);
                    return;
                case 9:
                    b gxVar = new gx();
                    gxVar.fxW.actionCode = 11;
                    gxVar.fxW.result = dVar.field_username;
                    gxVar.fxW.context = context;
                    gxVar.frD = null;
                    com.tencent.mm.sdk.b.a.xmy.a(gxVar, Looper.myLooper());
                    return;
                case 10:
                    intent = new Intent();
                    intent.putExtra("key_product_id", dVar.field_username);
                    intent.putExtra("key_product_scene", 9);
                    com.tencent.mm.bl.d.b(context, "product", ".ui.MallProductUI", intent);
                    return;
                case 12:
                    if (!z) {
                        i = 3;
                    }
                    a(dVar.field_distance, dVar.field_username, i, context);
                    return;
                case 13:
                    String str2 = dVar.field_username;
                    String str3 = dVar.field_reserved3;
                    int i2 = dVar.field_reserved2;
                    if (bi.oN(str2)) {
                        x.i("Micromsg.ShakeTVLogic", "gotoAppBrand commField.app_brand_user_name is null");
                        return;
                    }
                    b qrVar = new qr();
                    qrVar.fJd.userName = str2;
                    qrVar.fJd.fJf = bi.aD(str3, "");
                    qrVar.fJd.fJg = 0;
                    qrVar.fJd.scene = 1039;
                    qrVar.fJd.fJh = i2;
                    com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                    x.i("Micromsg.ShakeTVLogic", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d version:%d", qrVar.fJd.userName, qrVar.fJd.fJf, Integer.valueOf(qrVar.fJd.scene), Integer.valueOf(qrVar.fJd.fJg), Integer.valueOf(qrVar.fJd.fJh));
                    return;
                default:
                    return;
            }
        }
    }

    public static boolean ww(int i) {
        return 7 == i || 6 == i || 8 == i || 9 == i || 10 == i || 12 == i || 13 == i;
    }

    public static boolean bsk() {
        if (r.ifE) {
            return true;
        }
        String value = g.Af().getValue("ShowShakeTV");
        x.d("Micromsg.ShakeTVLogic", "DynamicConfig Get ShowShakeTV: %s", value);
        if (bi.oN(value) || !value.equals("1")) {
            return false;
        }
        return true;
    }

    public static void a(n nVar, Context context, int i) {
        if (nVar != null) {
            if (bi.oN(nVar.field_username) && bi.oN(nVar.field_deeplink)) {
                com.tencent.mm.plugin.report.service.g.pWK.h(12108, bi.oM(nVar.field_username), Integer.valueOf(i), Integer.valueOf(0));
                return;
            }
            a(nVar.field_username, nVar.field_deeplink, i, context);
            x.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start do nth");
        }
    }

    private static void a(String str, String str2, int i, Context context) {
        if (!bi.oN(str2)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str2));
            int i2 = 16;
            if (i == 3 || i == 4) {
                i2 = 17;
            }
            intent.putExtra("translate_link_scene", i2);
            context.startActivity(intent);
            x.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
            com.tencent.mm.plugin.report.service.g.pWK.h(12108, bi.oM(str), Integer.valueOf(i), Integer.valueOf(1));
        }
    }
}
