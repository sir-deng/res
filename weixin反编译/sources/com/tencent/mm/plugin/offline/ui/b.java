package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.e;

public final class b {

    /* renamed from: com.tencent.mm.plugin.offline.ui.b$2 */
    static class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ Activity oZ;
        final /* synthetic */ String pdi;

        AnonymousClass2(String str, Activity activity) {
            this.pdi = str;
            this.oZ = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.pdi);
            d.b(this.oZ, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            e.HX(3);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.b$4 */
    static class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ Activity oZ;

        AnonymousClass4(Activity activity) {
            this.oZ = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.oZ instanceof WalletOfflineCoinPurseUI) {
                ((WalletOfflineCoinPurseUI) this.oZ).pej = false;
            }
            dialogInterface.dismiss();
        }
    }

    public static void b(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            str = activity.getString(i.vdG);
        }
        h.a((Context) activity, str, null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }
}
