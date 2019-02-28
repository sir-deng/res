package com.tencent.xweb.xwalk.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Process;
import com.tencent.xweb.xwalk.a.f.a;
import com.tencent.xweb.xwalk.a.f.c;
import java.io.File;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public final class e extends AsyncTask<String, Integer, Integer> {
    static XWalkUpdater ACG;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final /* synthetic */ java.lang.Object doInBackground(java.lang.Object[] r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = 0;
        com.tencent.xweb.xwalk.a.c.cJU();
        r2 = com.tencent.xweb.xwalk.a.c.cJX();
        if (r2 == 0) goto L_0x001f;
    L_0x000b:
        r2 = "time to update";
        org.xwalk.core.XWalkInitializer.addXWalkInitializeLog(r2);
        r2 = r0;
    L_0x0012:
        if (r2 == 0) goto L_0x0021;
    L_0x0014:
        r2 = cKb();
        if (r2 != 0) goto L_0x0040;
    L_0x001a:
        r0 = java.lang.Integer.valueOf(r0);
    L_0x001e:
        return r0;
    L_0x001f:
        r2 = r1;
        goto L_0x0012;
    L_0x0021:
        r2 = com.tencent.xweb.xwalk.a.c.cJZ();
        if (r2 == 0) goto L_0x003e;
    L_0x0027:
        com.tencent.xweb.xwalk.a.c.cJU();
        r2 = com.tencent.xweb.xwalk.a.c.cJV();
        if (r2 != 0) goto L_0x003e;
    L_0x0030:
        r2 = cKb();
        if (r2 != 0) goto L_0x003e;
    L_0x0036:
        if (r0 == 0) goto L_0x0040;
    L_0x0038:
        r0 = 2;
        r0 = java.lang.Integer.valueOf(r0);
        goto L_0x001e;
    L_0x003e:
        r0 = r1;
        goto L_0x0036;
    L_0x0040:
        r0 = java.lang.Integer.valueOf(r1);
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.a.e.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() == 1) {
            b(c.cKa());
        } else if (num.intValue() == 2) {
            if (NetworkUtil.isNetworkAvailable()) {
                a aVar = new a();
                aVar.mUrl = XWalkEnvironment.getXWalkUpdateConfigUrl();
                aVar.mFilePath = XWalkEnvironment.getUpdateConfigDir() + File.separator + "updateConfg.xml";
                aVar.ADi = true;
                c.cJY();
                com.tencent.xweb.util.e.cJD();
                b anonymousClass1 = new b() {
                    public final void a(c cVar) {
                        a.a aVar;
                        String str = cVar.mFilePath;
                        if (str == null) {
                            XWalkInitializer.addXWalkInitializeLog("parse config failed ,path is empty");
                            aVar = null;
                        } else {
                            File file = new File(str);
                            if (file.exists()) {
                                aVar = a.i(file, a.h(file, (int) file.length()));
                            } else {
                                XWalkInitializer.addXWalkInitializeLog("parse config failed ,file not exist");
                                aVar = null;
                            }
                        }
                        if (aVar == null) {
                            com.tencent.xweb.util.e.gC(35);
                            com.tencent.xweb.util.e.cJE();
                            com.tencent.xweb.util.e.bk(15123, "0,17," + cVar.ADk + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.ADl + "," + cVar.mTotalSize);
                            XWalkEnvironment.addXWalkInitializeLog("ConfigParser failed ");
                            return;
                        }
                        try {
                            com.tencent.xweb.a.a(aVar.ACK, aVar.ACI);
                        } catch (Exception e) {
                            XWalkEnvironment.addXWalkInitializeLog("apply cmds failed , " + e.getMessage());
                        }
                        com.tencent.xweb.util.e.gH(cVar.ADl);
                        com.tencent.xweb.util.e.bk(15123, aVar.ACI + ",17," + cVar.ADk + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.ADl + "," + cVar.mTotalSize);
                        c.cJU();
                        e.c(c.a(aVar));
                    }

                    public final void b(c cVar) {
                        com.tencent.xweb.util.e.gC(35);
                        com.tencent.xweb.util.e.cJE();
                        com.tencent.xweb.util.e.bk(15123, "0,17," + cVar.ADk + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.ADl + "," + cVar.mTotalSize);
                        XWalkEnvironment.addXWalkInitializeLog("get config onTaskFailed ");
                    }
                };
                f fVar = new f();
                fVar.ADd = anonymousClass1;
                fVar.ADe = aVar;
                fVar.ADf = 0;
                fVar.ADg = System.currentTimeMillis();
                fVar.execute(new a[]{fVar.ADe});
            } else {
                XWalkEnvironment.addXWalkInitializeLog("network not available!!");
            }
        }
        super.onPostExecute(num);
    }

    public e(XWalkUpdater xWalkUpdater) {
        ACG = xWalkUpdater;
    }

    private static boolean b(c.a aVar) {
        if (cKb() || !NetworkUtil.isNetworkAvailable()) {
            return false;
        }
        if (aVar.ACN || NetworkUtil.isWifiAvailable()) {
            UpdateConfig updateConfig;
            XWalkUpdater xWalkUpdater = ACG;
            if (aVar.ACW) {
                if (aVar.ACH != null && !aVar.ACH.isEmpty() && aVar.feB != null && !aVar.feB.isEmpty()) {
                    updateConfig = new UpdateConfig(aVar.feB, true, aVar.ACH, aVar.ACM, aVar.ACO);
                } else if (c.a.$assertionsDisabled) {
                    updateConfig = new UpdateConfig(aVar.ACM, true, aVar.ACO);
                } else {
                    throw new AssertionError("royle:no md5 info, maybe something wrong");
                }
            } else if (aVar.ACH != null && !aVar.ACH.isEmpty()) {
                updateConfig = new UpdateConfig(aVar.ACH, false, null, aVar.ACM, aVar.ACO);
            } else if (c.a.$assertionsDisabled) {
                updateConfig = new UpdateConfig(aVar.ACM, false, aVar.ACO);
            } else {
                throw new AssertionError("royle:no md5 info, maybe something wrong");
            }
            updateConfig.versionDetail = aVar.ACY;
            updateConfig.bUseCdn = aVar.bUseCdn;
            if (!xWalkUpdater.updateXWalkRuntime(updateConfig)) {
                return false;
            }
            cKc();
            return true;
        }
        XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
        return false;
    }

    public static boolean cKb() {
        int i = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getInt("UpdatingProcessId", -1);
        if (i == Process.myPid()) {
            XWalkInitializer.addXWalkInitializeLog("current process is in updating progress");
            return true;
        } else if (i < 0) {
            return false;
        } else {
            ActivityManager activityManager = (ActivityManager) XWalkEnvironment.getApplicationContext().getSystemService("activity");
            Process.myPid();
            int myUid = Process.myUid();
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i) {
                    if (runningAppProcessInfo.uid == myUid) {
                        XWalkInitializer.addXWalkInitializeLog("some process is in updating progress");
                        return true;
                    }
                    cKd();
                    return false;
                }
            }
            cKd();
            return false;
        }
    }

    public static void cKc() {
        int myPid = Process.myPid();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putInt("UpdatingProcessId", myPid);
        edit.commit();
        XWalkInitializer.addXWalkInitializeLog("start updating progress");
    }

    public static void cKd() {
        Process.myPid();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.remove("UpdatingProcessId");
        edit.commit();
        XWalkInitializer.addXWalkInitializeLog("finish updating progress");
    }

    public static void cKe() {
        XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        cKd();
        c.a(null);
    }

    public static void JA(int i) {
        cKd();
        c.JA(i);
    }

    static void c(c.a aVar) {
        if (aVar == null) {
            return;
        }
        if (!XWalkEnvironment.hasAvailableVersion()) {
            XWalkInitializer.addXWalkInitializeLog("no availableversion installed, do start download ");
            b(aVar);
        } else if (aVar.ACX <= System.currentTimeMillis()) {
            b(aVar);
        }
    }
}
