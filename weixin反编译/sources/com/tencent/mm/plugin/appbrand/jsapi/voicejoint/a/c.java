package com.tencent.mm.plugin.appbrand.jsapi.voicejoint.a;

public final class c {
    private static a jzc = null;

    public static byte[] c(byte[] bArr, long j) {
        if (jzc == null) {
            a dVar = new d();
            jzc = dVar;
            dVar.g(j, 1);
        }
        if (jzc != null) {
            return jzc.W(bArr);
        }
        return null;
    }
}
