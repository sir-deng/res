package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.mm.bl.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a {
    private static SimpleDateFormat ldn = null;

    public static void bsg() {
        x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
        if (bsh()) {
            x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
            if (!bsC()) {
                x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_OPEN_BOOLEAN_SYNC, Boolean.valueOf(false));
                return;
            }
            return;
        }
        x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
        if (bsC()) {
            as.Hm();
            c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_OPEN_BOOLEAN_SYNC, Boolean.valueOf(true));
            x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
            return;
        }
        x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
    }

    public static boolean bsh() {
        if (as.Hp()) {
            boolean booleanValue;
            as.Hm();
            Object obj = c.Db().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_OPEN_BOOLEAN_SYNC, Boolean.valueOf(false));
            if (obj != null) {
                booleanValue = ((Boolean) obj).booleanValue();
            } else {
                booleanValue = false;
            }
            return booleanValue;
        }
        x.e("MicroMsg.ShakeCardUtil", "acc is not ready");
        return false;
    }

    private static boolean bsC() {
        as.Hm();
        int intValue = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(0))).intValue();
        as.Hm();
        int intValue2 = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(0))).intValue();
        x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time : " + intValue + " end time : " + intValue2);
        if (intValue <= 0) {
            x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is " + intValue + " , invalid");
            return false;
        } else if (intValue2 <= 0) {
            x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil end time  is " + intValue2 + " , invalid");
            return false;
        } else if (intValue >= intValue2) {
            x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is >= end time, invalid time");
            return false;
        } else {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time : " + currentTimeMillis);
            if (currentTimeMillis < intValue || currentTimeMillis > intValue2) {
                x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is not incled in [btime, etime]");
                return false;
            }
            x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is incled in [btime, etime]");
            return true;
        }
    }

    public static int bsD() {
        as.Hm();
        return ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
    }

    public static String bsE() {
        as.Hm();
        return (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, (Object) "");
    }

    public static String bsF() {
        as.Hm();
        return (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, (Object) "");
    }

    public static String bsG() {
        as.Hm();
        return (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, (Object) "");
    }

    public static String bsH() {
        as.Hm();
        return (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, (Object) "");
    }

    public static String bsI() {
        as.Hm();
        return (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_DESC_STRING_SYNC, (Object) "");
    }

    public static String bsJ() {
        as.Hm();
        return (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_ID_STRING_SYNC, (Object) "");
    }

    public static boolean wt(int i) {
        return i >= 0 && i <= 5;
    }

    public static int bsK() {
        as.Hm();
        int currentTimeMillis = (int) (System.currentTimeMillis() % 10);
        int nextInt = (new Random((long) c.Cn()).nextInt(10) + currentTimeMillis) % 10;
        x.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:" + nextInt);
        return nextInt;
    }

    public static int wu(int i) {
        switch (i) {
            case 1:
                return 10;
            case 2:
                return 30;
            case 3:
                return 60;
            case 4:
                return 120;
            case 5:
                return 240;
            default:
                return 0;
        }
    }

    public static int wv(int i) {
        switch (i) {
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 60;
            case 4:
                return 90;
            case 5:
                return 120;
            case 6:
                return 150;
            case 7:
                return 180;
            case 8:
                return 240;
            case 9:
                return 300;
            default:
                return 10;
        }
    }

    public static int xu(String str) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            x.e("MicroMsg.ShakeCardUtil", "string format error");
            return rgb;
        }
        try {
            String toUpperCase = str.substring(1).toUpperCase();
            return Color.argb(255, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
        } catch (Exception e) {
            x.e("MicroMsg.ShakeCardUtil", e.toString());
            return rgb;
        }
    }

    public static String bq(long j) {
        long j2 = 1000 * j;
        new GregorianCalendar().setTimeInMillis(j2);
        if (ldn == null) {
            ldn = new SimpleDateFormat("yyyy.MM.dd");
        }
        return ldn.format(new Date(j2));
    }

    public static void q(Context context, String str, String str2) {
        x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
        Intent intent = new Intent();
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_card_ext", str2);
        intent.putExtra("key_from_scene", 15);
        d.b(context, "card", ".ui.CardDetailUI", intent);
    }

    public static boolean bsL() {
        return bsh() && w.cfR();
    }

    public static void bsi() {
        x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i = 86400 + currentTimeMillis;
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(currentTimeMillis));
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(i));
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, (Object) "");
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(0));
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MIN_INT_SYNC, Integer.valueOf(1));
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MAX_INT_SYNC, Integer.valueOf(6));
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, (Object) "");
        com.tencent.mm.r.c.Bx().p(262154, true);
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, String.valueOf(currentTimeMillis));
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, (Object) "hello");
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, (Object) "shake card");
    }

    public static void bsj() {
        x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(0));
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(0));
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, (Object) "");
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(0));
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MIN_INT_SYNC, Integer.valueOf(0));
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MAX_INT_SYNC, Integer.valueOf(0));
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, (Object) "");
        com.tencent.mm.r.c.Bx().p(262154, false);
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, (Object) "");
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, (Object) "");
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, (Object) "");
    }
}
