package com.tencent.mm.booter;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class o {
    static long gAt = 0;

    static class a {
        int gAv;
        int gAw = 1;
        int gAx;
        int gAy;
        int gAz;

        a() {
        }

        public final boolean em(String str) {
            String[] split = str.split(",");
            if (split == null || split.length != 5) {
                x.e("MicroMsg.ProcessReport", "error format");
                return false;
            }
            try {
                this.gAv = bi.getInt(split[0], 0);
                this.gAw = bi.getInt(split[1], 0);
                this.gAx = bi.getInt(split[2], 0);
                this.gAy = bi.getInt(split[3], 0);
                this.gAz = bi.getInt(split[4], 0);
                return true;
            } catch (Throwable e) {
                x.e("MicroMsg.ProcessReport", "ParseFrom parse failed");
                x.printErrStackTrace("MicroMsg.ProcessReport", e, "", new Object[0]);
                return false;
            }
        }

        public final String toString() {
            return String.format("%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(this.gAv), Integer.valueOf(this.gAw), Integer.valueOf(this.gAx), Integer.valueOf(this.gAy), Integer.valueOf(this.gAz)});
        }
    }

    static /* synthetic */ void el(String str) {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split == null || split.length <= 1) {
            x.i("MicroMsg.ProcessReport", "nothing to reprot");
            return;
        }
        for (int i = 0; i < split.length - 1; i++) {
            x.i("MicroMsg.ProcessReport", "reprot %s: %s", str, split[i]);
            g.pWK.k(10667, split[i]);
        }
        sharedPreferences.edit().putString("startup_info", split[split.length - 1]).commit();
    }

    public static void onCreate(boolean z) {
        if (z) {
            u("mm_proc_startup", 2);
        } else {
            u("push_proc_startup", 1);
        }
    }

    private static void u(String str, int i) {
        a aVar;
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split != null && split.length > 0) {
            aVar = new a();
            if (aVar.em(split[split.length - 1])) {
                aVar.gAz = Process.myPid();
                split[split.length - 1] = aVar.toString();
            }
        }
        aVar = new a();
        aVar.gAv = i;
        aVar.gAx = Process.myPid();
        aVar.gAy = (int) bi.Wx();
        String d = d(split);
        String aVar2 = aVar.toString();
        if (d.length() > 0) {
            aVar2 = d + "=" + aVar2;
        }
        x.d("MicroMsg.ProcessReport", "startProc new info %s", aVar2);
        sharedPreferences.edit().putString("startup_info", aVar2).commit();
    }

    public static void ut() {
        ek("mm_proc_startup");
        ek("push_proc_startup");
    }

    private static void ek(String str) {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split != null && split.length != 0) {
            a aVar = new a();
            if (aVar.em(split[split.length - 1])) {
                aVar.gAw = 2;
                split[split.length - 1] = aVar.toString();
            }
            x.d("MicroMsg.ProcessReport", "uerExit new info %s", d(split));
            sharedPreferences.edit().putString("startup_info", r1).commit();
        }
    }

    public static void xd() {
        if (gAt == 0 || bi.bB(gAt) >= 3600000) {
            final int intValue = ((Integer) as.Hk().get(37, Integer.valueOf(0))).intValue();
            if (d.vHl != intValue) {
                as.Hk().set(37, Integer.valueOf(d.vHl));
                new ag(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        g.pWK.k(10675, intValue + "," + f.fei);
                    }
                });
            }
            gAt = bi.Wz();
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    o.el("mm_proc_startup");
                    o.el("push_proc_startup");
                }
            });
        }
    }

    private static String d(String[] strArr) {
        String str = "";
        Object obj = 1;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            if (obj != null) {
                obj = null;
            } else {
                str = str + "=";
            }
            i++;
            str = str + str2;
        }
        return str;
    }
}
