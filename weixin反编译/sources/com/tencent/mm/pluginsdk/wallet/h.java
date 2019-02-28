package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.y.q;

public final class h {
    public static boolean a(Context context, Bundle bundle, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("orderhandlerui_checkapp_result", z);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        d.b(context, "wallet_index", ".ui.OrderHandlerUI", intent);
        return true;
    }

    public static boolean a(MMActivity mMActivity, g gVar, int i, a aVar) {
        Intent intent = new Intent();
        intent.putExtra("appId", gVar.appId);
        intent.putExtra("timeStamp", gVar.timeStamp);
        intent.putExtra("nonceStr", gVar.nonceStr);
        intent.putExtra("packageExt", gVar.packageExt);
        intent.putExtra("signtype", gVar.signType);
        intent.putExtra("paySignature", gVar.fDO);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar.url);
        intent.putExtra("bizUsername", gVar.fDP);
        intent.putExtra("pay_channel", gVar.frE);
        intent.putExtra("pay_for_wallet_type", gVar.vGv);
        intent.putExtra("pay_scene", gVar.fDQ);
        intent.putExtra("result_jump_mode", gVar.vGx);
        intent.putExtra("ext_info", gVar.extInfo);
        if (aVar != null) {
            mMActivity.jCj = aVar;
        }
        d.a(mMActivity, "wallet_index", ".ui.WalletBrandUI", intent, i, false);
        return true;
    }

    public static void W(Context context, int i) {
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", i);
        d.b(context, "collect", ".ui.CollectAdapterUI", intent);
    }

    public static boolean a(Context context, String str, String str2, int i, int i2) {
        return bi.oN(str) ? false : a(context, a(str, str2, null, null, i, 0), i2);
    }

    public static PayInfo a(String str, String str2, String str3, String str4, int i, int i2) {
        PayInfo payInfo = new PayInfo();
        payInfo.fvC = str;
        payInfo.appId = str2;
        payInfo.tgP = null;
        payInfo.fDQ = i;
        payInfo.foE = null;
        payInfo.fDM = 0;
        return payInfo;
    }

    public static boolean a(Context context, PayInfo payInfo, int i) {
        return a(context, false, "", payInfo, i);
    }

    public static boolean a(Context context, boolean z, String str, PayInfo payInfo, int i) {
        return a(context, z, str, payInfo, null, new Intent(), i);
    }

    public static boolean a(Context context, boolean z, String str, PayInfo payInfo, String str2, Intent intent, int i) {
        return a(context, z, str, "", payInfo, str2, intent, i);
    }

    public static boolean a(Context context, boolean z, String str, String str2, PayInfo payInfo, String str3, Intent intent, int i) {
        if (2 == payInfo.fDQ || 1 == payInfo.fDQ || 4 == payInfo.fDQ || 36 == payInfo.fDQ) {
            payInfo.niF = false;
        } else {
            payInfo.niF = true;
        }
        if (payInfo.fDQ == 4 || payInfo.fDQ == 1 || 36 == payInfo.fDQ || 8 == payInfo.fDQ) {
            payInfo.vGj = true;
        } else {
            payInfo.vGj = false;
        }
        intent.putExtra("key_pay_info", payInfo);
        intent.putExtra("key_force_use_bind_serail", bi.oM(str));
        intent.putExtra("key_is_force_use_given_card", z);
        if (!bi.oN(str2)) {
            intent.putExtra("key_is_use_default_card", str2);
        }
        intent.putExtra("key_receiver_true_name", str3);
        if (q.Gl()) {
            d.b(context, "wallet_payu", ".pay.ui.WalletPayUPayUI", intent, i);
        } else {
            d.b(context, "wallet", ".pay.ui.WalletPayUI", intent, i);
        }
        return true;
    }

    public static boolean a(Context context, String str, String str2, String str3, int i, int i2) {
        if (bi.oN(str2)) {
            return false;
        }
        return a(context, true, str, a(str2, str3, null, null, i, 0), i2);
    }

    public static boolean b(MMActivity mMActivity, g gVar, int i, a aVar) {
        Intent intent = new Intent();
        intent.putExtra("appId", gVar.appId);
        intent.putExtra("timeStamp", gVar.timeStamp);
        intent.putExtra("nonceStr", gVar.nonceStr);
        intent.putExtra("packageExt", gVar.packageExt);
        intent.putExtra("signtype", gVar.signType);
        intent.putExtra("paySignature", gVar.fDO);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar.url);
        intent.putExtra("key_bind_scene", gVar.fDR);
        intent.putExtra("pay_channel", gVar.frE);
        mMActivity.jCj = aVar;
        d.a(mMActivity, "wallet", ".bind.ui.WalletBindUI", intent, i, false);
        return true;
    }

    public static boolean X(Context context, int i) {
        Intent intent = new Intent();
        intent.putExtra("key_bind_scene", 5);
        intent.putExtra("key_offline_add_fee", i);
        d.b(context, "wallet", ".bind.ui.WalletBindUI", intent);
        return true;
    }

    public static boolean Y(Context context, int i) {
        Intent intent = new Intent();
        intent.putExtra("key_scene_balance_manager", i);
        if (q.Gl()) {
            d.b(context, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", intent);
        } else {
            d.b(context, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
        }
        return true;
    }

    public static boolean a(Context context, int i, String str, int i2, com.tencent.mm.plugin.wallet.a aVar) {
        Intent intent = new Intent();
        intent.putExtra("scene", i);
        intent.putExtra("receiver_name", str);
        if (i2 > 0) {
            intent.putExtra("pay_channel", i2);
        }
        com.tencent.mm.plugin.wallet.a.a(aVar, intent);
        if (q.Gl()) {
            d.b(context, "wallet_payu", ".remittance.ui.PayURemittanceAdapterUI", intent);
        } else if (q.Gm()) {
            d.b(context, "remittance", ".ui.RemittanceAdapterUI", intent);
            g.pWK.h(12097, Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            g.pWK.h(11850, Integer.valueOf(7), Integer.valueOf(1));
        } else {
            d.b(context, "remittance", ".ui.RemittanceAdapterUI", intent);
            g.pWK.h(12097, Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            g.pWK.h(11850, Integer.valueOf(3), Integer.valueOf(1));
        }
        return true;
    }

    public static void a(Context context, String str, int i, String str2, int i2) {
        Intent intent = new Intent();
        intent.putExtra("key_qrcode_url", str);
        intent.putExtra("key_channel", i);
        intent.putExtra("key_web_url", str2);
        intent.putExtra("key_scene", i2);
        d.b(context, "collect", ".reward.ui.QrRewardSelectMoneyUI", intent);
    }
}
