package com.tencent.mm.modelsfs;

import com.tencent.mm.sdk.platformtools.bi;

public final class f {
    public static boolean mp(String str) {
        if (str.lastIndexOf(";?enc=") > 0) {
            return true;
        }
        return false;
    }

    public static String p(String str, long j) {
        if (j == 0) {
            return String.format(str + ";?enc=%d", new Object[]{Long.valueOf(314159265)});
        }
        return String.format(str + ";?enc=%d", new Object[]{Long.valueOf(j)});
    }

    public static String mq(String str) {
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static long mr(String str) {
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            return bi.Wp(str.substring(lastIndexOf + 6));
        }
        return 0;
    }

    public static String ms(String str) {
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            return str.substring(lastIndexOf + 6).trim();
        }
        return "";
    }
}
