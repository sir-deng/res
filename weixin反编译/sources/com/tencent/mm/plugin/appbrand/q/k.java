package com.tencent.mm.plugin.appbrand.q;

public final class k {
    public static String bj(Object obj) {
        return "Token@" + (obj != null ? Integer.valueOf(obj.hashCode()) : "null");
    }

    public static String bH(long j) {
        return "Token@" + j;
    }
}
