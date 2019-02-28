package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.d.a.c.i;
import com.tencent.mm.sdk.platformtools.x;
import java.security.Signature;

public enum s {
    ;
    
    public String mFv;
    public boolean mFw;
    public i sVA;
    private Signature sVz;

    private s(String str) {
        this.mFv = null;
        this.mFw = false;
        this.sVz = null;
        this.sVA = null;
    }

    public final void reset() {
        x.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
        this.sVz = null;
        this.mFv = null;
        this.mFw = false;
    }
}
