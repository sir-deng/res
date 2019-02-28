package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.i;

public class WalletIbgOrderInfoNewUI extends WalletOrderInfoNewUI {
    private Orders sKw;

    public void onCreate(Bundle bundle) {
        this.sKw = WalletIbgOrderInfoUI.sKw;
        super.onCreate(bundle);
    }

    protected final Orders bNr() {
        return this.sKw;
    }

    public final void done() {
        x.i("MicroMsg.WalletIbgOrderInfoNewUI", "hy: result is not set manly. set to OK");
        for (String str : this.tad) {
            if (!bi.oN(str)) {
                x.d("MicroMsg.WalletIbgOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", str);
                g.Dr();
                g.Dp().gRu.a(new i(str), 0);
            }
        }
        setResult(-1);
        finish();
    }
}
