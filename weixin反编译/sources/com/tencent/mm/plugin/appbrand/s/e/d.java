package com.tencent.mm.plugin.appbrand.s.e;

import com.tencent.mm.sdk.platformtools.x;

public final class d extends g implements b {
    private String jZa = "*";

    public final void vq(String str) {
        if (str == null) {
            x.i("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
        } else {
            this.jZa = str;
        }
    }

    public final String amG() {
        return this.jZa;
    }
}
