package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    a mFt;

    public interface a {
        void sE(String str);
    }

    public o(a aVar) {
        this.mFt = aVar;
    }

    public final void aLl() {
        e.post(new Runnable() {
            public final void run() {
                String str = "";
                if (e.aKP()) {
                    x.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
                    str = FingerPrintAuth.genRsaKey(e.cF(ad.getContext()), e.getUserId(), q.yM());
                } else {
                    x.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
                }
                if (o.this.mFt != null) {
                    o.this.mFt.sE(str);
                }
            }
        }, getClass().getName());
    }
}
