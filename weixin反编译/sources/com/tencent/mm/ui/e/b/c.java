package com.tencent.mm.ui.e.b;

import android.graphics.drawable.Drawable;

public final class c {
    private static b zkJ = null;

    public static void a(b bVar) {
        zkJ = bVar;
    }

    public static Drawable fV(String str, String str2) {
        if (zkJ == null) {
            return null;
        }
        a cm = zkJ.cm(str, str2);
        if (cm instanceof Drawable) {
            return (Drawable) cm;
        }
        return null;
    }
}
