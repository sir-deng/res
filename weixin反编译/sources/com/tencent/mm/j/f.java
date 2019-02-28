package com.tencent.mm.j;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.af.y;
import com.tencent.mm.f.a.sr;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.mm.y.t;
import java.util.List;
import java.util.Map;

public final class f extends a {
    private static String TAG = "MicroMsg.NotificationConfig";

    public static void bl(boolean z) {
        ad.cgg().edit().putBoolean("settings_new_msg_notification", z).commit();
        a.CD().edit().putBoolean("settings_new_msg_notification", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", Boolean.valueOf(z));
    }

    public static void bm(boolean z) {
        ad.cgg().edit().putBoolean("settings_new_voip_msg_notification", z).commit();
        a.CD().edit().putBoolean("settings_new_voip_msg_notification", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", Boolean.valueOf(z));
    }

    public static void bn(boolean z) {
        ad.cgg().edit().putBoolean("settings_show_detail", z).commit();
        a.CD().edit().putBoolean("settings_show_detail", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", Boolean.valueOf(z));
    }

    public static void bo(boolean z) {
        a.CD().edit().putBoolean("command_notification_status", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]is notification by system: %B", Boolean.valueOf(z));
    }

    public static void bp(boolean z) {
        ad.cgg().edit().putBoolean("settings_sound", z).commit();
        a.CD().edit().putBoolean("settings_sound", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", Boolean.valueOf(z));
    }

    public static void bq(boolean z) {
        ad.cgg().edit().putBoolean("settings_shake", z).commit();
        a.CD().edit().putBoolean("settings_shake", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", Boolean.valueOf(z));
    }

    public static void eQ(String str) {
        a.eQ(str);
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", str);
    }

    public static void br(boolean z) {
        ad.cgg().edit().putBoolean("settings_active_time_full", z).commit();
        a.CD().edit().putBoolean("settings_active_time_full", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", Boolean.valueOf(z));
    }

    public static void aO(int i, int i2) {
        SharedPreferences cgg = ad.cgg();
        cgg.edit().putInt("settings_active_begin_time_hour", i).commit();
        cgg.edit().putInt("settings_active_begin_time_min", i2).commit();
        cgg = a.CD();
        cgg.edit().putInt("settings_active_begin_time_hour", i).commit();
        cgg.edit().putInt("settings_active_begin_time_min", i2).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static void aP(int i, int i2) {
        SharedPreferences cgg = ad.cgg();
        cgg.edit().putInt("settings_active_end_time_hour", i).commit();
        cgg.edit().putInt("settings_active_end_time_min", i2).commit();
        cgg = a.CD();
        cgg.edit().putInt("settings_active_end_time_hour", i).commit();
        cgg.edit().putInt("settings_active_end_time_min", i2).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static boolean zW() {
        return c.gC(a.CC());
    }

    public static void fS(int i) {
        a.CD().edit().putInt("notification.status.webonline.push.open", i).commit();
    }

    public static boolean zX() {
        return q.gM(a.CD().getInt("notification.status.webonline.push.open", 0));
    }

    public static void zY() {
        SharedPreferences cgg = ad.cgg();
        Editor edit = a.CD().edit();
        edit.putBoolean("settings_new_msg_notification", cgg.getBoolean("settings_new_msg_notification", true));
        edit.putBoolean("settings_new_voip_msg_notification", cgg.getBoolean("settings_new_voip_msg_notification", true));
        edit.putBoolean("settings_show_detail", cgg.getBoolean("settings_show_detail", true));
        edit.putBoolean("settings_sound", cgg.getBoolean("settings_sound", true));
        edit.putString("settings.ringtone", cgg.getString("settings.ringtone", gJJ));
        edit.putBoolean("settings_shake", cgg.getBoolean("settings_shake", true));
        edit.putBoolean("settings_active_time_full", cgg.getBoolean("settings_active_time_full", true));
        edit.putInt("settings_active_begin_time_hour", cgg.getInt("settings_active_begin_time_hour", 8));
        edit.putInt("settings_active_begin_time_min", cgg.getInt("settings_active_begin_time_min", 0));
        edit.putInt("settings_active_end_time_hour", cgg.getInt("settings_active_end_time_hour", 23));
        edit.putInt("settings_active_end_time_min", cgg.getInt("settings_active_end_time_min", 0));
        edit.commit();
        x.i(TAG, "notification config copyDefault, newMsgNotification: %B, showDetail: %B, isSound: %B, ringTone: %s, isShake: %B, isActiveTime: %B, begin: %d:%d, end: %d:Td", Boolean.valueOf(r2), Boolean.valueOf(r3), Boolean.valueOf(r4), r5, Boolean.valueOf(r6), Boolean.valueOf(r7), Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r0));
    }

    public static boolean fT(int i) {
        return i == 50 || i == 53;
    }

    public static boolean eT(String str) {
        b srVar = new sr();
        srVar.fLl.fvG = 1;
        srVar.fLl.content = str;
        com.tencent.mm.sdk.b.a.xmy.m(srVar);
        if (srVar.fLm.type == 2 || str.equals(au.xHC)) {
            return true;
        }
        return false;
    }

    public static boolean eU(String str) {
        b srVar = new sr();
        srVar.fLl.fvG = 1;
        srVar.fLl.content = str;
        com.tencent.mm.sdk.b.a.xmy.m(srVar);
        if (srVar.fLm.type == 3 || str.equals(au.xHB)) {
            return true;
        }
        return false;
    }

    public static int d(au auVar) {
        int i = 0;
        int i2 = s.gI(auVar.field_talker) ? 0 : 3;
        if (auVar.field_bizChatId != -1 && com.tencent.mm.af.f.eG(auVar.field_talker)) {
            com.tencent.mm.af.a.c ag = y.Mn().ag(auVar.field_bizChatId);
            if (!ag.Mz() && ag.hr(1)) {
                return i2;
            }
        }
        String str = auVar.gkD;
        if (bi.oN(str)) {
            return i2;
        }
        Map y = bj.y(str, "msgsource");
        if (y == null || y.isEmpty()) {
            return i2;
        }
        try {
            int parseInt = Integer.parseInt((String) y.get(".msgsource.tips"));
            if ((parseInt & 1) != 0 || (parseInt & 2) == 0) {
                i = parseInt;
            }
            return i;
        } catch (Exception e) {
            return i2;
        }
    }

    public static int zZ() {
        if (as.Hp()) {
            return t.hz(s.hgU);
        }
        x.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
        return 0;
    }

    public static List<String> Aa() {
        return t.G(s.hgU, -1);
    }

    public static int Ab() {
        if (as.Hp()) {
            return t.hy(s.hgU);
        }
        x.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
        return 0;
    }

    public static int eV(String str) {
        return t.M(str, null);
    }

    public static boolean eW(String str) {
        return com.tencent.mm.storage.x.gB(str);
    }

    public static boolean eX(String str) {
        return str.toLowerCase().endsWith("@chatroom");
    }

    public static int Ac() {
        return k.FU();
    }

    public static boolean eY(String str) {
        return s.hv(str) || (s.eX(str) && !s.hu(str));
    }

    public static int eZ(String str) {
        as.Hm();
        return c.Fk().XS(str);
    }

    public static boolean e(au auVar) {
        if (auVar == null) {
            return false;
        }
        return auVar.XX(q.FY());
    }

    public static boolean Ad() {
        as.Hm();
        return ((Boolean) c.Db().get(73217, Boolean.valueOf(true))).booleanValue();
    }

    public static boolean Ae() {
        as.Hm();
        return ((Boolean) c.Db().get(73218, Boolean.valueOf(true))).booleanValue();
    }
}
