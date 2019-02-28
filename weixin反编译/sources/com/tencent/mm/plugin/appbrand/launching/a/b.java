package com.tencent.mm.plugin.appbrand.launching.a;

enum b {
    WALLET("weapp://wallet/", 1019),
    SEARCH_NATIVE_FEATURE("weapp://search/", 1005);
    
    final String hNW;
    final int scene;

    private b(String str, int i) {
        this.hNW = str;
        this.scene = i;
    }

    static String aiK() {
        return "";
    }

    static int aiL() {
        return 0;
    }

    static String aiM() {
        return "";
    }
}
