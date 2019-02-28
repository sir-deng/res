package com.tencent.mm.c;

public final class j {
    public static int ck(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return str.length() <= 0 ? 0 : Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
