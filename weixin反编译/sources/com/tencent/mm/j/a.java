package com.tencent.mm.j;

import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class a {
    public static final String gJJ = null;
    private static SharedPreferences gJK = null;
    private static SharedPreferences gJL = null;
    private static String gJM = gJJ;

    public static SharedPreferences zt() {
        SharedPreferences VQ = aa.VQ();
        gJL = VQ;
        return VQ;
    }

    public static boolean zu() {
        return com.tencent.mm.kernel.a.CD().getBoolean("command_notification_status", false);
    }

    public static boolean zv() {
        return com.tencent.mm.kernel.a.CD().getBoolean("settings_new_msg_notification", true);
    }

    public static boolean zw() {
        return com.tencent.mm.kernel.a.CD().getBoolean("settings_new_voip_msg_notification", true);
    }

    public static boolean zx() {
        return com.tencent.mm.kernel.a.CD().getBoolean("settings_show_detail", true);
    }

    public static boolean zy() {
        return com.tencent.mm.kernel.a.CD().getBoolean("settings_sound", true);
    }

    public static String zz() {
        String string = com.tencent.mm.kernel.a.CD().getString("settings.ringtone", gJJ);
        if (!(string == gJJ || string.equals(gJM))) {
            RingtoneManager ringtoneManager = new RingtoneManager(ad.getContext());
            ringtoneManager.setType(2);
            if (ringtoneManager.getRingtonePosition(Uri.parse(string)) < 0) {
                string = gJJ;
                eQ(string);
                x.i("MicroMsg.BaseNotificationConfig", "reset ringTone");
            }
            gJM = string;
        }
        return string;
    }

    static void eQ(String str) {
        ad.cgg().edit().putString("settings.ringtone", str).commit();
        com.tencent.mm.kernel.a.CD().edit().putString("settings.ringtone", str).commit();
    }

    public static boolean zA() {
        return com.tencent.mm.kernel.a.CD().getBoolean("settings_shake", true);
    }

    public static boolean zB() {
        return com.tencent.mm.kernel.a.CD().getBoolean("settings_active_time_full", true);
    }

    public static int zC() {
        return com.tencent.mm.kernel.a.CD().getInt("settings_active_begin_time_hour", 8);
    }

    public static int zD() {
        return com.tencent.mm.kernel.a.CD().getInt("settings_active_end_time_hour", 23);
    }

    public static int zE() {
        return com.tencent.mm.kernel.a.CD().getInt("settings_active_begin_time_min", 0);
    }

    public static int zF() {
        return com.tencent.mm.kernel.a.CD().getInt("settings_active_end_time_min", 0);
    }

    public static boolean aN(int i, int i2) {
        if (zB()) {
            return true;
        }
        int zC = zC();
        int zE = zE();
        int zD = zD();
        int zF = zF();
        if (zC == zD && zE == zF) {
            return false;
        }
        if (zC != zD || zE >= zF) {
            if (zD > zC) {
                if (i > zC && i < zD) {
                    return true;
                }
                if (i == zC && i2 > zE) {
                    return true;
                }
                if (i != zD || i2 >= zF) {
                    return false;
                }
                return true;
            } else if (zD >= zC && (zC != zD || zE <= zF)) {
                return true;
            } else {
                if (i > zC && i <= 23) {
                    return true;
                }
                if (i == zC && i2 > zE) {
                    return true;
                }
                if (i == zD && i2 < zF) {
                    return true;
                }
                if (i <= 0 || i >= zD) {
                    return false;
                }
                return true;
            }
        } else if (i != zC || i2 <= zE || i2 >= zF) {
            return false;
        } else {
            return true;
        }
    }
}
