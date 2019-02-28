package com.tencent.mm.ui.widget.celltextview.g;

import android.graphics.Paint;
import android.graphics.Rect;
import java.util.regex.Pattern;

public final class a {
    static Pattern yHg = Pattern.compile("[`\"~!@#$^&*()=|{}':;',\\[\\].<>/?～！@#￥……&*（）——|{}【】‘；：”“'。，、？「」]$");
    private static Rect zHa = new Rect();

    public static boolean q(char c) {
        return (c >= 'a' && c <= 'z') || ((c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == '_' || c == '-' || c == '@'));
    }

    public static boolean r(char c) {
        if (c == 12289 || c == 65289 || c == 65292 || c == 12290 || c == 12299 || c == 12305 || c == 12301 || c == 65311 || c == 65307 || c == 65306 || c == 8221) {
            return true;
        }
        return false;
    }

    public static boolean s(char c) {
        if (c == 65288 || c == 12298 || c == 12300 || c == 12304 || c == 8220) {
            return true;
        }
        return false;
    }

    public static int dA(String str, int i) {
        while (i >= 0) {
            if (!q(str.charAt(i))) {
                return i + 1;
            }
            i--;
        }
        return 0;
    }

    public static int dB(String str, int i) {
        while (i >= 0) {
            if (!t(str.charAt(i))) {
                return i + 1;
            }
            i--;
        }
        return 0;
    }

    public static int dC(String str, int i) {
        while (i < str.length()) {
            if (!t(str.charAt(i))) {
                return i - 1;
            }
            i++;
        }
        return i - 1;
    }

    public static char dy(String str, int i) {
        if (i < 0 || str == null || i >= str.length()) {
            return 0;
        }
        return str.charAt(i);
    }

    public static char[] aj(String str, int i, int i2) {
        int i3 = i2 - i;
        if (str == null || i < 0 || i > i2) {
            return new char[i3];
        }
        char[] cArr = new char[i3];
        if (i2 > str.length()) {
            i2 = str.length();
        }
        str.getChars(i, i2, cArr, 0);
        return cArr;
    }

    public static boolean t(char c) {
        return yHg.matcher(Character.toString(c)).find();
    }

    public static float a(char c, Paint paint) {
        String valueOf = String.valueOf(c);
        float measureText = paint.measureText(valueOf);
        paint.getTextBounds(valueOf, 0, 1, zHa);
        int i = (int) (measureText - ((float) zHa.right));
        return i > 0 ? (float) i : 0.0f;
    }

    public static float b(char c, Paint paint) {
        paint.getTextBounds(String.valueOf(c), 0, 1, zHa);
        int i = zHa.left;
        return i > 0 ? (float) i : 0.0f;
    }
}
