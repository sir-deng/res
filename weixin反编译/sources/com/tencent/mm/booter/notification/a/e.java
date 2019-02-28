package com.tencent.mm.booter.notification.a;

import android.media.AudioManager;
import android.text.format.Time;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.f.a.sr;
import com.tencent.mm.j.a;
import com.tencent.mm.j.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.HashSet;
import java.util.Set;

public final class e {
    private static final Set<String> gCb;
    public boolean gCc;

    static {
        Set hashSet = new HashSet();
        gCb = hashSet;
        hashSet.add("readerapp");
        gCb.add("blogapp");
        gCb.add("newsapp");
    }

    public static boolean ev(String str) {
        if (af.VK("keep_chatting_silent" + str)) {
            x.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: FALSE");
            return true;
        }
        x.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: TRUE");
        return false;
    }

    public static boolean a(boolean[] zArr, boolean z, boolean z2) {
        boolean z3;
        if (z || z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        zArr[0] = zArr[0] & z;
        zArr[1] = zArr[1] & z2;
        return z3;
    }

    public static boolean a(boolean[] zArr, boolean z) {
        boolean z2;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        zArr[0] = zArr[0] & z;
        zArr[1] = zArr[1] & z;
        return z2;
    }

    public static boolean ew(String str) {
        boolean z = true;
        boolean contains = gCb.contains(str);
        String str2 = "MicroMsg.Notification.Silent.Handle";
        String str3 = "check is NOT Siler User: %B";
        Object[] objArr = new Object[1];
        if (contains) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        return contains;
    }

    public static boolean xu() {
        Time time = new Time();
        time.setToNow();
        if (a.aN(time.hour, time.minute)) {
            return false;
        }
        x.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
        return true;
    }

    public static boolean xv() {
        x.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", Boolean.valueOf(a.zy()));
        return a.zy();
    }

    public static boolean ft(int i) {
        boolean z;
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Sound: %B", Boolean.valueOf(z));
        return z;
    }

    public static boolean a(String str, au auVar) {
        boolean z;
        boolean z2 = true;
        if (!f.eY(str) || f.e(auVar)) {
            z = false;
        } else {
            z = true;
        }
        String str2 = "MicroMsg.Notification.Silent.Handle";
        String str3 = "check is NOT Must Mute: %B";
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        x.i(str2, str3, objArr);
        return z;
    }

    public static boolean xw() {
        boolean z;
        boolean z2 = true;
        try {
            b srVar = new sr();
            srVar.fLl.fvG = 2;
            com.tencent.mm.sdk.b.a.xmy.m(srVar);
            z = srVar.fLm.fLn;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Notification.Silent.Handle", e, "", new Object[0]);
            z = false;
        }
        String str = "MicroMsg.Notification.Silent.Handle";
        String str2 = "check is Voip NOT Calling: %B";
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        x.d(str, str2, objArr);
        return z;
    }

    public static boolean o(int i, String str) {
        boolean Ad;
        if (f.fT(i)) {
            if (f.eT(str)) {
                Ad = f.Ad();
            } else if (f.eU(str)) {
                Ad = f.Ae();
            }
            x.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", Boolean.valueOf(Ad));
            return Ad;
        }
        Ad = true;
        x.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", Boolean.valueOf(Ad));
        return Ad;
    }

    public static boolean xx() {
        boolean zA = a.zA();
        if (xy() == 0) {
            zA = false;
        }
        x.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", Boolean.valueOf(zA), Integer.valueOf(xy()));
        return zA;
    }

    public static int xy() {
        return ((AudioManager) ad.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getRingerMode();
    }

    public static boolean fu(int i) {
        boolean z;
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Shake: %B", Boolean.valueOf(z));
        return z;
    }
}
