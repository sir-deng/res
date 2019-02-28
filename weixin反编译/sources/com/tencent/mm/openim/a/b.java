package com.tencent.mm.openim.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import com.tencent.mm.ad.e;

public interface b extends e, com.tencent.mm.kernel.c.a {

    public enum a {
        ;

        static {
            idv = 1;
            idw = 2;
            idx = new int[]{idv, idw};
        }
    }

    String J(String str, String str2, int i);

    CharSequence a(Context context, String str, String str2, float f);

    void aA(String str, String str2);

    String aB(String str, String str2);

    SpannableString b(Context context, String str, int i);

    String h(String str, String str2, int i);

    String i(String str, String str2, int i);

    Bitmap ox(String str);

    int oy(String str);
}
