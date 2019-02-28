package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.plugin.clean.c.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;

public final class d {
    private static long lkI = 0;
    private static long lkJ = 0;
    private static b lkT;
    private static long lkY = 0;
    private static long lkZ = 0;
    private static final ag llh = new ag();
    private static HashSet<String> lli;
    private static ArrayList<b> llj;
    private static int llk = 0;

    public static void a(b bVar) {
        lkT = bVar;
    }

    public static b ayP() {
        boolean z = true;
        String str = "MicroMsg.CleanLogic";
        String str2 = "getThreadController threadController is null? %b";
        Object[] objArr = new Object[1];
        if (lkT != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        return lkT;
    }

    public static void b(HashSet<String> hashSet) {
        lli = hashSet;
    }

    public static HashSet<String> ayQ() {
        return lli;
    }

    public static void m(ArrayList<b> arrayList) {
        boolean z = true;
        String str = "MicroMsg.CleanLogic";
        String str2 = "set analyse data: is null? %b";
        Object[] objArr = new Object[1];
        if (arrayList != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        llj = arrayList;
    }

    public static ArrayList<b> ayR() {
        return llj;
    }

    public static void bS(long j) {
        lkZ = j;
    }

    public static long ayS() {
        return lkZ;
    }

    public static void bT(long j) {
        lkI = j;
    }

    public static long ayT() {
        return lkI;
    }

    public static void bU(long j) {
        if (j <= 0) {
            j = 0;
        }
        lkJ = j;
    }

    public static long ayU() {
        return lkJ;
    }

    public static void bV(long j) {
        lkY = j;
    }

    public static long ayV() {
        return lkY;
    }

    public static final void ayW() {
        x.i("MicroMsg.CleanLogic", "startCleanDataNow");
        llh.removeCallbacksAndMessages(null);
        lkZ = 0;
        lkY = 0;
        m(null);
        llk = 0;
    }

    public static final void ayX() {
        x.i("MicroMsg.CleanLogic", "start to post clean runnable!!");
        llh.removeCallbacksAndMessages(null);
        llh.postDelayed(new Runnable() {
            public final void run() {
                if (d.llk == 0) {
                    x.i("MicroMsg.CleanLogic", "clean data");
                    d.bS(0);
                    d.m(null);
                    return;
                }
                x.i("MicroMsg.CleanLogic", "clean data is using");
            }
        }, 300000);
    }

    public static final void ayY() {
        llk++;
    }

    public static final void ayZ() {
        llk--;
    }
}
