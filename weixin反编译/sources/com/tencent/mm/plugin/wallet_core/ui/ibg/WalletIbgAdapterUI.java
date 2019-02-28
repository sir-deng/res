package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletIbgAdapterUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uV(4);
        this.zSi.jl(1564);
        r(new b());
    }

    public void onResume() {
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof b)) {
            int i3 = ((b) kVar).sPj;
            String str2 = ((b) kVar).jumpUrl;
            x.i("MicroMsg.WalletH5AdapterUI", "hy: get success! url is: %s, download x5 = %b", str2, Integer.valueOf(i3));
            if (i3 == 1) {
                boolean z;
                x.i("MicroMsg.WalletH5AdapterUI", "now status = %d", Integer.valueOf(com.tencent.mm.pluginsdk.model.x.a.bZl()));
                switch (com.tencent.mm.pluginsdk.model.x.a.bZl()) {
                    case 1:
                    case 4:
                        z = true;
                        break;
                    case 2:
                    case 3:
                        g.Dr();
                        if (((Boolean) g.Dq().Db().get(w.a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue()) {
                            Toast.makeText(this, getString(i.veV), 1).show();
                            com.tencent.mm.pluginsdk.model.x.a.eh(this);
                            finish();
                        } else {
                            bNM();
                        }
                        z = false;
                        break;
                    default:
                        bNM();
                        z = false;
                        break;
                }
                if (z) {
                    NY(str2);
                    finish();
                }
            } else {
                NY(str2);
                finish();
            }
        } else {
            com.tencent.mm.wallet_core.a.c(this, null, 0);
        }
        return false;
    }

    public void onDestroy() {
        this.zSi.jm(1564);
        super.onDestroy();
    }

    private void NY(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(this, "webview", ".ui.tools.WebViewUI", intent);
    }

    private void bNM() {
        g.Dr();
        g.Dq().Db().a(w.a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.valueOf(true));
        h.a((Context) this, false, getString(i.veW), "", getString(i.veT), getString(i.veS), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.pluginsdk.model.x.a.eh(WalletIbgAdapterUI.this);
                Toast.makeText(WalletIbgAdapterUI.this, WalletIbgAdapterUI.this.getString(i.veU), 1).show();
                WalletIbgAdapterUI.this.finish();
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                WalletIbgAdapterUI.this.finish();
            }
        });
    }

    protected final int getLayoutId() {
        return -1;
    }
}
