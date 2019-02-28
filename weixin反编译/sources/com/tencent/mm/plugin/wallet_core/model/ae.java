package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

public final class ae {
    public int sWf = 0;

    public ae(int i) {
        g.Dr();
        g.Dq().Db().set(196660, Integer.valueOf(i));
        this.sWf = i;
        x.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + i);
    }

    public ae() {
        g.Dr();
        this.sWf = ((Integer) g.Dq().Db().get(196660, Integer.valueOf(0))).intValue();
        x.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.sWf);
    }

    public final boolean bMp() {
        boolean z;
        if ((this.sWf & 2) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.sWf));
        return z;
    }

    public final boolean bMq() {
        boolean z;
        if ((this.sWf & FileUtils.S_IWUSR) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.sWf));
        return z;
    }

    public final boolean bMr() {
        boolean z;
        if ((this.sWf & 256) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.sWf));
        return z;
    }

    public final boolean bMs() {
        boolean z;
        if ((this.sWf & 2048) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.sWf));
        return z;
    }

    public final boolean bMt() {
        boolean z;
        if ((this.sWf & 65536) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isShowH5TradeDetail, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.sWf));
        return z;
    }

    public final boolean bMu() {
        boolean z;
        if ((this.sWf & 2097152) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.sWf));
        return z;
    }
}
