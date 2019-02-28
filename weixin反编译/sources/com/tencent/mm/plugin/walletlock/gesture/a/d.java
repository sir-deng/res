package com.tencent.mm.plugin.walletlock.gesture.a;

import android.util.Base64;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.protocal.c.awn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;

public final class d {
    private static long tlX = -1;

    public static g bOE() {
        t Db = g.Dq().Db();
        if (Db == null) {
            return new g();
        }
        Object obj = Db.get(339969, null);
        if (obj == null) {
            return new g();
        }
        return new g().aW(e.Ok((String) obj));
    }

    public static void I(long j, long j2) {
        t Db = g.Dq().Db();
        if (Db != null) {
            g gVar = new g();
            gVar.tmx = j;
            gVar.tmy = j2;
            Db.set(339969, e.aV(gVar.toByteArray()));
            Db.lO(true);
        }
    }

    public static void bOF() {
        t Db = g.Dq().Db();
        if (Db != null) {
            Db.set(339969, null);
            Db.lO(true);
        }
    }

    public static long bOu() {
        return tlX;
    }

    public static void fi(long j) {
        tlX = j;
    }

    public static void bOt() {
        tlX = -1;
    }

    public static g bOG() {
        t Db = g.Dq().Db();
        if (Db == null) {
            return new g();
        }
        Object obj = Db.get(339971, null);
        if (obj == null) {
            return new g();
        }
        return new g().aW(e.Ok((String) obj));
    }

    public static void J(long j, long j2) {
        t Db = g.Dq().Db();
        if (Db != null) {
            g gVar = new g();
            gVar.tmx = j;
            gVar.tmy = j2;
            Db.set(339971, e.aV(gVar.toByteArray()));
            Db.lO(true);
        }
    }

    public static void bOH() {
        t Db = g.Dq().Db();
        if (Db != null) {
            Db.set(339971, null);
            Db.lO(true);
        }
    }

    public static awm bOI() {
        t Db = g.Dq().Db();
        if (Db == null) {
            return null;
        }
        String str = (String) Db.get(339989, null);
        if (bi.oN(str)) {
            return null;
        }
        try {
            return (awm) new awm().aH(Base64.decode(str, 2));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            return null;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            return null;
        }
    }

    public static void a(awm awm) {
        t Db = g.Dq().Db();
        if (Db != null) {
            try {
                Db.set(339989, Base64.encodeToString(awm.toByteArray(), 2));
                Db.lO(true);
                x.v("MicroMsg.GestureGuardInfoManager", "alvinluo savePatternBuffer isUserSetGesturePwd: %b", Boolean.valueOf(e.bOC()));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            }
        }
    }

    public static awn bOJ() {
        t Db = g.Dq().Db();
        if (Db == null) {
            x.e("MicroMsg.GestureGuardInfoManager", "alvinluo configstg is null");
            return null;
        }
        String str = (String) Db.get(339990, null);
        if (bi.oN(str)) {
            return null;
        }
        try {
            return (awn) new awn().aH(Base64.decode(str, 2));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            return null;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e2, "", new Object[0]);
            return null;
        }
    }

    public static void a(awn awn) {
        if (awn != null) {
            x.i("MicroMsg.GestureGuardInfoManager", "alvinluo saveSyncedPatternInfo version: %d, status: %d", Integer.valueOf(awn.wKE), Integer.valueOf(awn.wKG));
        }
        t Db = g.Dq().Db();
        if (Db != null) {
            try {
                Db.set(339990, Base64.encodeToString(awn.toByteArray(), 2));
                Db.lO(true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GestureGuardInfoManager", e, "", new Object[0]);
            }
        }
    }

    public static int bOK() {
        t Db = g.Dq().Db();
        if (Db == null) {
            return -1;
        }
        Object obj = Db.get(339972, null);
        if (obj == null) {
            return -1;
        }
        return ((Integer) obj).intValue();
    }

    public static void zO(int i) {
        t Db = g.Dq().Db();
        if (Db != null) {
            Db.set(339972, Integer.valueOf(i));
            Db.lO(true);
        }
    }

    public static void bOL() {
        t Db = g.Dq().Db();
        if (Db != null) {
            Db.set(339972, null);
            Db.lO(true);
        }
    }
}
