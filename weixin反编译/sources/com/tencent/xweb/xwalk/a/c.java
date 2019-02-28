package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.xweb.xwalk.a.a.b;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public class c {
    static c ACT;
    static a ACU;

    public static class a {
        static final /* synthetic */ boolean $assertionsDisabled = (!c.class.desiredAssertionStatus());
        public String ACH;
        public String ACI;
        public String ACM;
        public boolean ACN;
        public int ACO;
        public long ACV;
        public boolean ACW;
        public long ACX;
        public String ACY;
        public int ACZ;
        public boolean bUseCdn;
        public String feB;
    }

    private c() {
    }

    public static c cJU() {
        if (ACT == null) {
            ACT = new c();
        }
        return ACT;
    }

    public static void JA(int i) {
        if (NetworkUtil.isNetworkAvailable()) {
            SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
            int i2 = sharedPreferencesForUpdateConfig.getInt("nTryCnt", 0) + 1;
            if (i <= -2 && i >= -5) {
                i2 += 3;
            }
            if (i2 > 3) {
                XWalkInitializer.addXWalkInitializeLog("FailedTooManytimes at this version");
                XWalkInitializer.addXWalkInitializeLog("abandon Current Scheduler");
                a(null);
                return;
            }
            cKa().ACZ = i2;
            Editor edit = sharedPreferencesForUpdateConfig.edit();
            edit.putInt("nTryCnt", i2);
            long currentTimeMillis = System.currentTimeMillis() + ((long) (7200000 * i2));
            XWalkInitializer.addXWalkInitializeLog("rescheduler update time after " + ((i2 * 7200000) / 60000) + " minute");
            edit.putLong("nTimeToUpdate", currentTimeMillis);
            edit.commit();
        }
    }

    public static a a(com.tencent.xweb.xwalk.a.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        a cKa = cKa();
        if (cKa == null || cKa.ACI == aVar.ACI) {
            return null;
        }
        com.tencent.xweb.xwalk.a.a.c cVar;
        int i;
        cKa = new a();
        if (aVar == null || aVar.ACJ == null || aVar.ACJ.length == 0) {
            cVar = null;
        } else {
            i = VERSION.SDK_INT;
            for (com.tencent.xweb.xwalk.a.a.c cVar2 : aVar.ACJ) {
                if (cVar2 != null && cVar2.ACO > XWalkEnvironment.getAvailableVersion() && cVar2.AzW.cJt()) {
                    cVar = cVar2;
                    break;
                }
            }
            XWalkInitializer.addXWalkInitializeLog("no matched version");
            cVar = null;
        }
        if (cVar == null || cVar.ACO <= XWalkEnvironment.getAvailableVersion()) {
            XWalkInitializer.addXWalkInitializeLog("no matched version");
            cKa = null;
        } else {
            XWalkInitializer.addXWalkInitializeLog("got matched version");
            cKa.ACI = aVar.ACI;
            cKa.ACH = cVar.ACH;
            cKa.ACO = cVar.ACO;
            cKa.ACY = cVar.ACR.ACS;
            cKa.ACN = cVar.ACN;
            cKa.bUseCdn = cVar.bUseCdn;
            if (cVar.ACQ != null) {
                for (b bVar : cVar.ACQ) {
                    if (bVar.ACL == XWalkEnvironment.getAvailableVersion()) {
                        XWalkInitializer.addXWalkInitializeLog("got matched patch");
                        break;
                    }
                }
            }
            XWalkInitializer.addXWalkInitializeLog("no matched patch");
            b bVar2 = null;
            if (bVar2 != null) {
                cKa.ACW = true;
                cKa.ACM = bVar2.ACM;
                cKa.feB = bVar2.ACH;
                cKa.ACN = bVar2.ACN;
                cKa.bUseCdn = bVar2.bUseCdn;
            } else {
                cKa.ACW = false;
                cKa.ACM = cVar.ACM;
            }
            i = (int) (Math.random() * ((double) cVar.ACP));
            cKa.ACX = ((long) ((i * 60) * 1000)) + System.currentTimeMillis();
            XWalkInitializer.addXWalkInitializeLog("schedul after " + i + " minute to update");
        }
        if (cKa == null) {
            return null;
        }
        a(cKa);
        return cKa;
    }

    public static boolean cJV() {
        if (!cJW()) {
            return false;
        }
        XWalkInitializer.addXWalkInitializeLog("has scheduler for update");
        return true;
    }

    public static boolean cJW() {
        if (cKa() == null || cKa().ACM == null || cKa().ACM.isEmpty() || cKa().ACO <= XWalkEnvironment.getAvailableVersion()) {
            return false;
        }
        return true;
    }

    public static boolean cJX() {
        if (!cJW()) {
            return false;
        }
        if (System.currentTimeMillis() >= cKa().ACX) {
            XWalkInitializer.addXWalkInitializeLog("time to update");
            return true;
        }
        XWalkInitializer.addXWalkInitializeLog("has scheduler waiting for update, but time is not up");
        return false;
    }

    public static void a(a aVar) {
        ACU = aVar;
        if (aVar == null) {
            ACU = new a();
        }
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putString("strMd5", ACU.ACH);
        edit.putString("strUrl", ACU.ACM);
        edit.putString("strConfigVer", ACU.ACI);
        edit.putBoolean("bIsPatchUpdate", ACU.ACW);
        edit.putBoolean("bCanUseCellular", ACU.ACN);
        edit.putBoolean("bUseCdn", ACU.bUseCdn);
        edit.putLong("nTimeToUpdate", ACU.ACX);
        edit.putInt("nApkVer", ACU.ACO);
        edit.putInt("nTryCnt", ACU.ACZ);
        edit.putString("strPatchMd5", ACU.feB);
        edit.putString("strVersionDetail", ACU.ACY);
        edit.commit();
    }

    public static void cJY() {
        cKa().ACV = System.currentTimeMillis();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", cKa().ACV);
        edit.commit();
    }

    private static boolean M(long j, long j2) {
        if (j > j2 + 7200000 || j + 7200000 < j2) {
            return true;
        }
        XWalkInitializer.addXWalkInitializeLog("the most recent time to fetch config is too close");
        return false;
    }

    public static boolean cJZ() {
        if (cJW()) {
            XWalkInitializer.addXWalkInitializeLog("has scheduler , don't need to fetch config");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!M(currentTimeMillis, cKa().ACV)) {
            return false;
        }
        long j = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getLong("nLastFetchConfigTime", 0);
        cKa().ACV = j;
        if (!M(currentTimeMillis, j)) {
            return false;
        }
        XWalkInitializer.addXWalkInitializeLog("enough time after last time fetch config");
        return true;
    }

    public static a cKa() {
        if (ACU != null) {
            return ACU;
        }
        ACU = new a();
        SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
        ACU.ACV = sharedPreferencesForUpdateConfig.getLong("nLastFetchConfigTime", 0);
        if (!sharedPreferencesForUpdateConfig.contains("strUrl")) {
            return ACU;
        }
        ACU.ACH = sharedPreferencesForUpdateConfig.getString("strMd5", null);
        ACU.ACM = sharedPreferencesForUpdateConfig.getString("strUrl", null);
        ACU.ACI = sharedPreferencesForUpdateConfig.getString("strConfigVer", null);
        ACU.ACW = sharedPreferencesForUpdateConfig.getBoolean("bIsPatchUpdate", false);
        ACU.ACX = sharedPreferencesForUpdateConfig.getLong("nTimeToUpdate", 0);
        ACU.ACO = sharedPreferencesForUpdateConfig.getInt("nApkVer", 0);
        ACU.ACZ = sharedPreferencesForUpdateConfig.getInt("nTryCnt", 0);
        ACU.feB = sharedPreferencesForUpdateConfig.getString("strPatchMd5", null);
        ACU.ACY = sharedPreferencesForUpdateConfig.getString("strVersionDetail", null);
        ACU.ACN = sharedPreferencesForUpdateConfig.getBoolean("bCanUseCellular", false);
        ACU.bUseCdn = sharedPreferencesForUpdateConfig.getBoolean("bUseCdn", false);
        return ACU;
    }
}
