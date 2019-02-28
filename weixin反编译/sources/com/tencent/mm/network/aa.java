package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ar;

public final class aa {
    private static boolean hasInit = false;
    private static aa icA;
    private static boolean icJ = false;
    private t gzw;
    private ag handler;
    private ab icB;
    private ac icC;
    private Context icD;
    private a icE;
    private z icF;
    private y icG;
    private Looper icH;
    private w icI;

    public interface a {
        void aU(boolean z);
    }

    private aa() {
    }

    private static aa VO() {
        if (icA == null) {
            icA = new aa();
        }
        return icA;
    }

    private static SharedPreferences VP() {
        return ad.getContext().getSharedPreferences("notify_key_pref_no_account", 4);
    }

    public static SharedPreferences VQ() {
        String string = VP().getString("login_weixin_username", "");
        if (bi.oN(string)) {
            string = ar.hhz.H("login_weixin_username", "");
            if (!bi.oN(string)) {
                VP().edit().putString("login_weixin_username", string).commit();
            }
        }
        if (string != null) {
            string = string.replace("[\\/\\\\]", "#").trim();
        }
        return ad.getContext().getSharedPreferences("notify_key_pref" + string, 4);
    }

    public static void VR() {
        if (!hasInit) {
            SharedPreferences VQ = VQ();
            long j = VQ.getLong("wakeup_alarm_last_tick", 0);
            int i = VQ.getInt("wakeup_alarm_last_cnt", 0);
            if (j == 0 || j > bi.Wy()) {
                x.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", Integer.valueOf(i));
                VQ.edit().putLong("wakeup_alarm_last_tick", bi.Wy()).commit();
                VQ.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                return;
            } else if (bi.bA(j) > 86400000) {
                VQ.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
                VQ.edit().putLong("wakeup_alarm_last_tick", bi.Wy()).commit();
                VQ.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                x.i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", Integer.valueOf(i));
            } else {
                VQ.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
                x.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", Integer.valueOf(i + 1));
            }
        }
        hasInit = true;
    }

    public static boolean VS() {
        String H = ar.hhz.H("login_user_name", "");
        if (H != null) {
            H = H.replaceAll("[/\\\\]", "#").trim();
        }
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("notify_key_pref" + H, 4);
        x.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", Integer.valueOf(sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0)), Integer.valueOf(sharedPreferences.getInt("wakeup_alarm_last_cnt", 0)));
        return (r0 > 10 ? 1 : 0) | (sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0) > 10 ? 1 : 0);
    }

    public static ab VT() {
        return VO().icB;
    }

    public static void a(ab abVar) {
        VO().icB = abVar;
    }

    public static ac VU() {
        return VO().icC;
    }

    public static void a(ac acVar) {
        VO().icC = acVar;
    }

    public static Context getContext() {
        return VO().icD;
    }

    public static void setContext(Context context) {
        VO().icD = context;
    }

    public static ag VV() {
        return VO().handler;
    }

    public static void a(ag agVar) {
        VO().handler = agVar;
    }

    public static a VW() {
        return VO().icE;
    }

    public static void a(a aVar) {
        VO().icE = aVar;
    }

    public static t VX() {
        return VO().gzw;
    }

    public static void b(t tVar) {
        VO().gzw = tVar;
    }

    public static z VY() {
        return VO().icF;
    }

    public static void a(z zVar) {
        VO().icF = zVar;
    }

    public static y VZ() {
        return VO().icG;
    }

    public static void a(y yVar) {
        VO().icG = yVar;
    }

    public static Looper Wa() {
        if (VO().icH == null) {
            HandlerThread WL = e.WL("MMPushCore_handlerThread");
            WL.start();
            VO().icH = WL.getLooper();
        }
        return VO().icH;
    }

    public static w Wb() {
        return VO().icI;
    }

    public static void a(w wVar) {
        VO().icI = wVar;
    }

    public static void ch(boolean z) {
        VO();
        icJ = z;
    }

    public static boolean Wc() {
        VO();
        return icJ;
    }
}
