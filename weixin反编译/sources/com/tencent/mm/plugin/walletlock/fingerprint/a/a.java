package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    private static long tlX = -1;

    private static JSONArray Oh(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONArray(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
            return null;
        }
    }

    private static HashSet<String> z(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            HashSet<String> hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(jSONArray.getJSONObject(i).getString("fid"));
            }
            return hashSet;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
            return null;
        }
    }

    private static String bOp() {
        return (String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLETLOCK_FINGERPRINT_FID_LIST_STRING_SYNC, null);
    }

    public static boolean Oi(String str) {
        x.i("MicroMsg.FingerprintInfoStorage", "alvinluo add fid to local: %s", str);
        try {
            JSONArray Oh = Oh(bOp());
            HashSet z = z(Oh);
            if (Oh == null) {
                x.w("MicroMsg.FingerprintInfoStorage", "alvinluo list is null");
                Oh = new JSONArray();
            }
            if (z == null) {
                x.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet is null");
                z = new HashSet();
            }
            x.i("MicroMsg.FingerprintInfoStorage", "alvinluo fidList: %s before add fid", Oh.toString());
            if (!z.contains(str)) {
                x.w("MicroMsg.FingerprintInfoStorage", "alvinluo fidSet contains fid %s: %b", str, Boolean.valueOf(false));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fid", str);
                Oh.put(jSONObject);
                x.i("MicroMsg.FingerprintInfoStorage", "alvinluo list: %s", Oh.toString());
                g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_WALLETLOCK_FINGERPRINT_FID_LIST_STRING_SYNC, Oh.toString());
                g.Dq().Db().lO(true);
                return true;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FingerprintInfoStorage", e, "", new Object[0]);
        }
        return false;
    }

    public static boolean Oj(String str) {
        x.i("MicroMsg.FingerprintInfoStorage", "alvinluo fid: %s, fidInfoList: %s", str, bOp());
        HashSet z = z(Oh(r2));
        if (z == null || !z.contains(str)) {
            return false;
        }
        return true;
    }

    public static void bOq() {
        x.i("MicroMsg.FingerprintInfoStorage", "alvinluo clear local fids, stack: %s", bi.chl());
        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_WALLETLOCK_FINGERPRINT_FID_LIST_STRING_SYNC, null);
        g.Dq().Db().lO(true);
    }

    public static boolean bOr() {
        return ((Boolean) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLETLOCK_FINGERPRINT_IS_OPENED_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
    }

    public static void kb(boolean z) {
        x.i("MicroMsg.FingerprintInfoStorage", "alvinluo set fingerprint lock status isOpened: %b", Boolean.valueOf(z));
        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_WALLETLOCK_FINGERPRINT_IS_OPENED_BOOLEAN_SYNC, Boolean.valueOf(z));
        g.Dq().Db().lO(true);
    }

    public static boolean bOs() {
        com.tencent.mm.plugin.walletlock.gesture.a.g gVar;
        t Db = g.Dq().Db();
        if (Db == null) {
            gVar = new com.tencent.mm.plugin.walletlock.gesture.a.g();
        } else {
            String str = (String) Db.get(com.tencent.mm.storage.w.a.USERINFO_WALLETLOCK_FINGERPRINT_LAST_BLOCK_TIME_STRING_SYNC, null);
            gVar = str == null ? new com.tencent.mm.plugin.walletlock.gesture.a.g() : new com.tencent.mm.plugin.walletlock.gesture.a.g().aW(e.Ok(str));
        }
        if (gVar.tmx == -1) {
            return false;
        }
        e.a(gVar);
        if (gVar.tmy / 1000 < 30) {
            I(gVar.tmx, gVar.tmy);
            return true;
        }
        Db = g.Dq().Db();
        if (Db != null) {
            Db.a(com.tencent.mm.storage.w.a.USERINFO_WALLETLOCK_FINGERPRINT_LAST_BLOCK_TIME_STRING_SYNC, null);
            Db.lO(true);
        }
        return false;
    }

    public static void I(long j, long j2) {
        t Db = g.Dq().Db();
        if (Db != null) {
            com.tencent.mm.plugin.walletlock.gesture.a.g gVar = new com.tencent.mm.plugin.walletlock.gesture.a.g();
            gVar.tmx = j;
            gVar.tmy = j2;
            Db.a(com.tencent.mm.storage.w.a.USERINFO_WALLETLOCK_FINGERPRINT_LAST_BLOCK_TIME_STRING_SYNC, e.aV(gVar.toByteArray()));
            Db.lO(true);
        }
    }

    public static void bOt() {
        tlX = -1;
    }

    public static long bOu() {
        return tlX;
    }

    public static void fi(long j) {
        tlX = j;
    }
}
