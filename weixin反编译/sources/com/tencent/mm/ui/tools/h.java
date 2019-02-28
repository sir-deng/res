package com.tencent.mm.ui.tools;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h implements InputFilter {
    private int kdH;
    private int kdI;

    public enum a {
        ;

        static {
            ztX = 1;
            ztY = 2;
            ztZ = new int[]{ztX, ztY};
        }
    }

    public h(int i, int i2) {
        this.kdH = i;
        this.kdI = i2;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (dx(spanned.toString(), this.kdI) + dx(charSequence.toString(), this.kdI) > this.kdH) {
            return "";
        }
        return charSequence;
    }

    public static int dx(String str, int i) {
        if (i == a.ztX) {
            if (bi.oN(str)) {
                return 0;
            }
            return str.length();
        } else if (i == a.ztY) {
            return aaF(str);
        } else {
            return 0;
        }
    }

    public static int aaF(String str) {
        int i = 0;
        if (bi.oN(str)) {
            return 0;
        }
        int aaG = aaG(str) + str.length();
        if (!bi.oN(str)) {
            int i2 = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt >= 0 && charAt <= 127) {
                    i2++;
                }
                i++;
            }
            i = str.length() - (i2 + aaG(str));
        }
        return i + aaG;
    }

    public static int aaG(String str) {
        if (bi.oN(str)) {
            return 0;
        }
        Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str);
        int i = 0;
        while (matcher.find()) {
            int i2 = 0;
            while (i2 <= matcher.groupCount()) {
                i2++;
                i++;
            }
        }
        return i;
    }

    public static int be(int i, String str) {
        if (w.cfR()) {
            return Math.round(((float) (i - Math.round((float) aaF(str)))) / 2.0f);
        }
        return i - aaF(str);
    }

    public static int bf(int i, String str) {
        if (w.cfR()) {
            return Math.round(((float) (Math.round((float) aaF(str)) - i)) / 2.0f);
        }
        return aaF(str) - i;
    }
}
