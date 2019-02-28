package com.tencent.mm.plugin.appbrand.r.b;

public interface b {

    public enum a {
        GPS,
        NETWORK;

        public static a vm(String str) {
            if ("gps".equals(str)) {
                return GPS;
            }
            return NETWORK;
        }
    }

    void a(double d, double d2, a aVar, double d3, double d4, double d5);
}
