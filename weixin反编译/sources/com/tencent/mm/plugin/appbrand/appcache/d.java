package com.tencent.mm.plugin.appbrand.appcache;

public interface d {
    public static final int[] iGg = new int[]{0, 10002, 10102};
    public static final int[] iGh = new int[]{1, 2, 999, 10000, 10001, 10100, 10101};

    public enum a {
        ;

        public static boolean jy(int i) {
            return com.tencent.mm.compatible.loader.a.b(d.iGg, i);
        }

        public static boolean hi(int i) {
            return com.tencent.mm.compatible.loader.a.b(d.iGh, i);
        }
    }
}
