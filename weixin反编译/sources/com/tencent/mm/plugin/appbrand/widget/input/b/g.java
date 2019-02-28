package com.tencent.mm.plugin.appbrand.widget.input.b;

public enum g {
    LEFT,
    RIGHT,
    CENTER;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.b.g$1 */
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] kib = null;

        static {
            kib = new int[g.values().length];
            try {
                kib[g.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kib[g.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kib[g.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static g vH(String str) {
        Enum h = d.h(str, g.class);
        g gVar = LEFT;
        if (h != null) {
            Enum gVar2 = h;
        }
        return gVar2;
    }
}
