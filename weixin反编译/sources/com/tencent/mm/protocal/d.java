package com.tencent.mm.protocal;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

public final class d extends e {
    public static String DEVICE_TYPE = ("android-" + VERSION.SDK_INT);
    public static final String vHe = Build.BRAND;
    public static final String vHf = (Build.MODEL + Build.CPU_ABI);
    public static String vHg = ("android-" + VERSION.SDK_INT);
    public static final String vHh = ("android-" + Build.MANUFACTURER);
    public static String vHi = (VERSION.SDK_INT);
    public static final String vHj = (Build.MANUFACTURER + "-" + Build.MODEL);
    public static long vHk = 0;
    public static int vHl;
    public static boolean vHm = cel();
    public static boolean vHn = cek();
    public static boolean vHo = cei();
    public static boolean vHp = ceh();
    public static boolean vHq = cej();
    public static int vHr = 5;
    public static final byte[] vHs = null;
    public static final byte[] vHt = null;
    public static final byte[] vHu = null;

    public static void CX(int i) {
        vHl = i;
        vHo = cei();
        vHp = ceh();
        vHm = cel();
        vHn = cek();
        vHq = cej();
    }

    static {
        vHl = Integer.decode("0x26060532").intValue();
        try {
            int i = ad.getContext().getPackageManager().getApplicationInfo(ad.getPackageName(), FileUtils.S_IWUSR).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
            if (i > vHl && i - vHl < 255 && (i & 255) >= 48) {
                vHl = i;
            }
        } catch (Exception e) {
            x.j("MicroMsg.ConstantsProtocal", "", e);
        }
    }

    private static boolean ceh() {
        return (vHl & 255) >= 32 && (vHl & 255) <= 47;
    }

    private static boolean cei() {
        return (vHl & 255) >= 0 && (vHl & 255) <= 31;
    }

    private static boolean cej() {
        return (vHl & 255) >= 0 && (vHl & 255) <= 15;
    }

    private static boolean cek() {
        return (vHl & 255) >= 96 && (vHl & 255) <= JsApiGetBackgroundAudioState.CTRL_INDEX;
    }

    private static boolean cel() {
        return (vHl & 255) >= 48 && (vHl & 255) <= 95;
    }
}
