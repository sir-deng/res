package com.tencent.mm.compatible.f;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.SparseArray;
import com.tencent.mm.a.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class a {
    public static Boolean gIJ;

    private static class b {
        public int gIM;
        public SparseArray<String> gIN;
        public String gIO;
        public String model;
        public String version;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final String toString() {
            return String.format(Locale.US, "manufacture: %s, model: %s, version: %s, value: %s, chkExp: %d", new Object[]{this.gIO, this.model, this.version, this.gIN, Integer.valueOf(this.gIM)});
        }
    }

    private static class a {
        public String ffM;
        public int gIK;
        public int gIL;
        public int gIM;
        public SparseArray<String> gIN;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final String toString() {
            return String.format(Locale.US, "pkgname: %s, minCode:%d, maxCode: %d, value: %s, chkExp: %d", new Object[]{this.ffM, Integer.valueOf(this.gIK), Integer.valueOf(this.gIL), this.gIN, Integer.valueOf(this.gIM)});
        }
    }

    public static boolean a(String str, String str2, PInt pInt, PBool pBool) {
        if (str == null) {
            pBool.value = false;
            return false;
        } else if (str2 == null) {
            pBool.value = true;
            return false;
        } else if (str.equals(str2)) {
            pInt.value++;
            pBool.value = true;
            return true;
        } else {
            pBool.value = false;
            return false;
        }
    }

    public static List<PackageInfo> bj(boolean z) {
        Set hashSet = new HashSet();
        if (z) {
            ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
            if (activityManager != null) {
                try {
                    List<RunningServiceInfo> runningServices = activityManager.getRunningServices(32767);
                    if (runningServices != null) {
                        for (RunningServiceInfo runningServiceInfo : runningServices) {
                            hashSet.add(runningServiceInfo.service.getPackageName());
                        }
                    }
                } catch (SecurityException e) {
                    x.e("MicroMsg.PermissionConfig", "getRunningServices failed");
                }
            }
        }
        PackageManager packageManager = ad.getContext().getPackageManager();
        if (packageManager == null) {
            return null;
        }
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        if (installedPackages == null || !z) {
            return installedPackages;
        }
        List<PackageInfo> arrayList = new ArrayList();
        for (PackageInfo packageInfo : installedPackages) {
            if (hashSet.contains(packageInfo.packageName)) {
                arrayList.add(packageInfo);
            }
        }
        return arrayList;
    }

    public static void a(String str, List<b> list, List<a> list2) {
        Throwable th;
        if (e.bO(str)) {
            String str2 = ".perm.values.";
            String str3 = "";
            String cfV = w.cfV();
            if (cfV.equals("zh_CN")) {
                cfV = "zh_CN";
            } else if (cfV.equals("zh_TW") || cfV.equals("zh_HK")) {
                cfV = str3 + "zh_TW";
            } else {
                cfV = str3 + "en";
            }
            BufferedReader bufferedReader = null;
            BufferedReader bufferedReader2;
            try {
                bufferedReader2 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        str3 = bufferedReader2.readLine();
                        if (str3 != null) {
                            String trim = str3.trim();
                            if (trim.length() != 0) {
                                Map y = bj.y(trim, "perm");
                                if (y == null) {
                                    x.e("MicroMsg.PermissionConfig", "unable to parse xml, " + trim);
                                } else {
                                    str3 = (String) y.get(".perm.type");
                                    if (str3 == null) {
                                        x.e("MicroMsg.PermissionConfig", "invalid config, " + trim);
                                    } else if (str3.equals("1")) {
                                        b bVar = new b();
                                        bVar.gIN = new SparseArray();
                                        bVar.gIO = (String) y.get(".perm.manufacture");
                                        bVar.model = (String) y.get(".perm.model");
                                        bVar.version = (String) y.get(".perm.version_release");
                                        bVar.gIN.append(1, y.get(str2 + cfV));
                                        bVar.gIN.append(2, y.get(str2 + "camera." + cfV));
                                        bVar.gIM = bi.Wo((String) y.get(".perm.check_exception"));
                                        list.add(bVar);
                                    } else if (str3.equals("2")) {
                                        a aVar = new a();
                                        aVar.gIN = new SparseArray();
                                        aVar.ffM = (String) y.get(".perm.package");
                                        aVar.gIK = bi.Wo((String) y.get(".perm.min_versioncode"));
                                        aVar.gIL = bi.Wo((String) y.get(".perm.max_versioncode"));
                                        aVar.gIN.append(1, y.get(str2 + cfV));
                                        aVar.gIN.append(2, y.get(str2 + "camera." + cfV));
                                        aVar.gIM = bi.Wo((String) y.get(".perm.check_exception"));
                                        list2.add(aVar);
                                    }
                                }
                            }
                        } else {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        bufferedReader = bufferedReader2;
                    } catch (IOException e3) {
                    }
                }
            } catch (FileNotFoundException e4) {
                try {
                    x.e("MicroMsg.PermissionConfig", "file not found exception");
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (IOException e5) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    bufferedReader2 = bufferedReader;
                    th = th2;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                bufferedReader2 = null;
                try {
                    x.e("MicroMsg.PermissionConfig", "read permission config file failed");
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                            return;
                        } catch (IOException e8) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    throw th;
                }
            } catch (Throwable th22) {
                bufferedReader2 = null;
                th = th22;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                throw th;
            }
        }
        x.i("MicroMsg.PermissionConfig", "file is not exists");
    }
}
