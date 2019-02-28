package com.tencent.mm.ui.e.c;

import android.content.Context;

public final class b {
    private static a zkK = null;

    public static void a(a aVar) {
        zkK = aVar;
    }

    public static CharSequence a(Context context, CharSequence charSequence, int i) {
        if (zkK != null) {
            return zkK.a(context, charSequence, i);
        }
        return charSequence;
    }

    public static CharSequence c(Context context, CharSequence charSequence, float f) {
        if (zkK != null) {
            return zkK.c(context, charSequence, f);
        }
        return charSequence;
    }

    public static int r(Context context, String str, int i) {
        if (zkK != null) {
            return zkK.bd(str, i);
        }
        return i;
    }
}
