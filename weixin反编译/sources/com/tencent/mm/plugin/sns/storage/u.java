package com.tencent.mm.plugin.sns.storage;

import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

public final class u {
    public static String af(String str, long j) {
        return str + j;
    }

    public static String ag(String str, long j) {
        return str + j;
    }

    public static boolean Mj(String str) {
        return str != null && str.startsWith("ad_table_");
    }

    public static boolean Ka(String str) {
        return str != null && str.startsWith("sns_table_");
    }

    public static long Mk(String str) {
        if (bi.oN(str)) {
            return 0;
        }
        if (str.startsWith("ad_table_")) {
            return bi.Wp(str.substring(9));
        }
        if (str.startsWith("sns_table_")) {
            return bi.Wp(str.substring(10));
        }
        return bi.Wp(str);
    }

    public static int Ml(String str) {
        if (bi.oN(str)) {
            return 0;
        }
        if (str.startsWith("ad_table_")) {
            return bi.Wo(str.substring(9));
        }
        return bi.Wo(str.substring(10));
    }

    public static boolean Mm(String str) {
        if (str.startsWith("ad_table_")) {
            if (bi.Wp(str.substring(9)) != 0) {
                return true;
            }
            return false;
        } else if (bi.Wp(str.substring(10)) == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean Mn(String str) {
        return !Mm(str);
    }

    public static int eu(String str, String str2) {
        g.Do();
        return Z(str, str2, a.Co());
    }

    public static int Z(String str, String str2, String str3) {
        String aa = aa(str, str2, str3);
        if (bi.oN(aa)) {
            return 0;
        }
        String[] split = aa.split("&");
        int i = 0;
        while (i < split.length) {
            if (split[i] != null && split[i].contains("voteResultIndex=")) {
                return Integer.valueOf(split[i].substring(16)).intValue();
            }
            i++;
        }
        return 0;
    }

    public static String aa(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        stringBuilder.append(str);
        if (str2 == null) {
            str2 = "";
        }
        stringBuilder.append(str2);
        if (str3 == null) {
            str3 = "";
        }
        stringBuilder.append(str3);
        if (stringBuilder.length() > 0) {
            return ad.getContext().getSharedPreferences("SnsAdVote", 0).getString(stringBuilder.toString(), "");
        }
        return "";
    }

    public static void f(String str, String str2, String str3, int i, int i2) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            if (str == null) {
                str = "";
            }
            stringBuilder.append(str);
            if (str2 == null) {
                str2 = "";
            }
            stringBuilder.append(str2);
            if (str3 == null) {
                str3 = "";
            }
            stringBuilder.append(str3);
            if (stringBuilder.length() > 0) {
                Editor edit = ad.getContext().getSharedPreferences("SnsAdVote", 0).edit();
                edit.putString(stringBuilder.toString(), "voteResultIndex=" + i + "&isUpdate=" + i2);
                edit.commit();
            }
        }
    }
}
