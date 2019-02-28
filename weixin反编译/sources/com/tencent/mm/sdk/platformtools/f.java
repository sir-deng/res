package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.wcdb.FileUtils;
import java.util.Map;

public final class f {
    public static int fei = 0;
    public static String fej = (VERSION.SDK_INT);
    public static int fek = 0;
    public static int feo = 0;
    public static int xmQ = 0;
    public static int xmR = 0;
    public static String xmS = ("market://details?id=" + ad.getPackageName());
    public static boolean xmT = false;
    public static boolean xmU = true;
    public static boolean xmV = false;
    public static boolean xmW = false;

    public static void eI(Context context) {
        try {
            fei = Integer.parseInt((String) r.Vz(bi.convertStreamToString(context.getAssets().open("channel.ini"))).get("CHANNEL"));
        } catch (Throwable e) {
            x.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
            x.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
        }
    }

    public static void eJ(Context context) {
        try {
            Map Vz = r.Vz(bi.convertStreamToString(context.getAssets().open("profile.ini")));
            String oM = bi.oM((String) Vz.get("PROFILE_DEVICE_TYPE"));
            fej = oM;
            if (oM.length() <= 0) {
                fej = VERSION.SDK_INT;
            }
            fek = parseInt((String) Vz.get("UPDATE_MODE"));
            xmR = parseInt((String) Vz.get("BUILD_REVISION"));
            xmV = parseBoolean((String) Vz.get("GPRS_ALERT"));
            feo = parseInt((String) Vz.get("AUTO_ADD_ACOUNT"));
            xmW = parseBoolean((String) Vz.get("NOKIA_AOL"));
            x.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + fej);
            x.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + fek);
            x.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + xmV);
            x.w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + feo);
            x.w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + xmW);
            oM = (String) Vz.get("MARKET_URL");
            if (!(oM == null || oM.trim().length() == 0 || Uri.parse(oM) == null)) {
                xmS = oM;
            }
            x.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + xmS);
        } catch (Throwable e) {
            x.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
            x.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
        }
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            x.w("MicroMsg.SDK.ChannelUtil", e.getMessage());
            return 0;
        }
    }

    private static boolean parseBoolean(String str) {
        boolean z = false;
        try {
            return Boolean.parseBoolean(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[z]);
            x.w("MicroMsg.SDK.ChannelUtil", e.getMessage());
            return z;
        }
    }

    public static String ag(Context context, int i) {
        return b(context, i, xmT);
    }

    public static String b(Context context, int i, boolean z) {
        String str;
        int i2 = (i >> 8) & 255;
        if (i2 == 0) {
            str = ((i >> 24) & 15) + "." + ((i >> 16) & 255);
        } else {
            str = ((i >> 24) & 15) + "." + ((i >> 16) & 255) + "." + i2;
        }
        x.d("MicroMsg.SDK.ChannelUtil", "minminor " + i2);
        i2 = 268435455 & i;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), FileUtils.S_IWUSR);
                if (packageInfo != null) {
                    i2 = packageInfo.versionCode;
                    str = packageInfo.versionName;
                }
            } catch (Throwable e) {
                Throwable th = e;
                int i3 = i2;
                x.printErrStackTrace("MicroMsg.SDK.ChannelUtil", th, "", new Object[0]);
                i2 = i3;
            }
        }
        if (z) {
            str = str + "_" + i2;
            x.d("MicroMsg.SDK.ChannelUtil", "full version: " + str);
            return str;
        }
        String[] split = str.split("\\.");
        if (split == null || split.length < 4) {
            return str;
        }
        str = split[0] + "." + split[1];
        return !split[2].trim().equals("0") ? str + "." + split[2] : str;
    }

    public static boolean cfD() {
        return fei == 1001;
    }
}
