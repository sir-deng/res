package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletOpenLqbProxyUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uV(4);
        c cCT = cCT();
        if (cCT != null) {
            int i = this.vf.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tfA, 0);
            String string = this.vf.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfG);
            x.i("MicroMsg.WalletOpenLqbProxyUI", "WalletOpenLqbProxyUI onCreate, openScene: %s, extraData: %s", Integer.valueOf(i), string);
            if (i == 3) {
                cCU().k(Integer.valueOf(i), string);
                return;
            }
            cCT.b((Activity) this, this.vf);
            finish();
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
