package com.tinkerboots.sdk.a;

import com.tinkerboots.sdk.a.a.b;

public final class a {
    private static volatile a ADx;
    public b ADw;
    public long ADy = 10800000;
    public final com.tinkerboots.sdk.a.b.a ADz = com.tinkerboots.sdk.a.b.a.cKh();
    public boolean jyS;

    private a(b bVar) {
        this.ADw = bVar;
    }

    public static a a(b bVar) {
        if (ADx != null) {
            throw new RuntimeException("tinker server client is already init");
        }
        if (ADx == null) {
            synchronized (com.tinkerboots.sdk.a.b.a.class) {
                if (ADx == null) {
                    ADx = new a(bVar);
                }
            }
        }
        return ADx;
    }
}
