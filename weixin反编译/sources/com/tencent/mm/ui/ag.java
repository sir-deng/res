package com.tencent.mm.ui;

public final class ag {
    private static a xVJ;
    private static a xVK;

    public interface a {
    }

    static {
        a anonymousClass1 = new a() {
        };
        xVJ = anonymousClass1;
        xVK = anonymousClass1;
    }

    public static void k(String str, Object... objArr) {
        if (xVK != null) {
            String.format(str, objArr);
        }
    }
}
