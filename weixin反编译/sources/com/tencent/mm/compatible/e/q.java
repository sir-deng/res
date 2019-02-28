package com.tencent.mm.compatible.e;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.mm.f.a.ce;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public final class q {
    public static o gHE = new o();
    public static c gHF = new c();
    public static b gHG = new b();
    public static v gHH = new v();
    public static z gHI = new z();
    public static s gHJ = new s();
    public static u gHK = new u();
    public static x gHL = new x();
    public static t gHM = new t();
    public static a gHN = new a();
    private static int gHO = -1;
    public static k gHP = new k();
    public static p gHQ = new p();
    private static String gHR = null;

    class a implements FileFilter {
        a() {
        }

        public final boolean accept(File file) {
            if (Pattern.matches("cpu[0-9]+", file.getName())) {
                return true;
            }
            return false;
        }
    }

    public static String yL() {
        String str = (String) l.yu().get(258);
        if (str == null) {
            str = getDeviceID(ad.getContext());
            if (str == null) {
                str = "1234567890ABCDEF";
            }
            l.yu().set(258, str);
        }
        return str;
    }

    public static String getDeviceID(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            String deviceId = telephonyManager.getDeviceId();
            return deviceId == null ? null : deviceId.trim();
        } catch (SecurityException e) {
            x.e("MicroMsg.DeviceInfo", "getDeviceId failed, security exception");
            return null;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.DeviceInfo", e2, "", new Object[0]);
            return null;
        }
    }

    public static String yM() {
        return bh(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String bh(boolean r6) {
        /*
        r4 = 259; // 0x103 float:3.63E-43 double:1.28E-321;
        r3 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r5 = 0;
        if (r6 != 0) goto L_0x000b;
    L_0x0007:
        r0 = gHR;
        if (r0 != 0) goto L_0x008f;
    L_0x000b:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r0 = r0.getContentResolver();
        r2 = "android_id";
        r0 = android.provider.Settings.Secure.getString(r0, r2);
        r1.append(r0);
        if (r6 != 0) goto L_0x0092;
    L_0x0024:
        r0 = com.tencent.mm.compatible.e.l.yu();
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x0092;
    L_0x0030:
        r1.append(r0);
        r0 = com.tencent.mm.compatible.e.l.yu();
        r0 = r0.get(r4);
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x009e;
    L_0x003f:
        r2 = "MicroMsg.DeviceInfo";
        r3 = new java.lang.StringBuilder;
        r4 = "getHardWareId from file ";
        r3.<init>(r4);
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
    L_0x0055:
        r1.append(r0);
        r0 = r1.toString();
        r1 = new java.lang.StringBuilder;
        r2 = "A";
        r1.<init>(r2);
        r2 = r0.getBytes();
        r2 = com.tencent.mm.a.g.s(r2);
        r3 = 15;
        r2 = r2.substring(r5, r3);
        r1 = r1.append(r2);
        r1 = r1.toString();
        gHR = r1;
        r1 = "MicroMsg.DeviceInfo";
        r2 = "guid:%s, dev=%s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = gHR;
        r3[r5] = r4;
        r4 = 1;
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.x.w(r1, r2, r3);
    L_0x008f:
        r0 = gHR;
        return r0;
    L_0x0092:
        r0 = yP();
        r2 = com.tencent.mm.compatible.e.l.yu();
        r2.set(r3, r0);
        goto L_0x0030;
    L_0x009e:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = android.os.Build.MANUFACTURER;
        r0 = r0.append(r2);
        r2 = android.os.Build.MODEL;
        r0 = r0.append(r2);
        r2 = com.tencent.mm.compatible.e.n.yB();
        r0 = r0.append(r2);
        r0 = r0.toString();
        r2 = com.tencent.mm.compatible.e.l.yu();
        r2.set(r4, r0);
        r2 = "MicroMsg.DeviceInfo";
        r3 = new java.lang.StringBuilder;
        r4 = "getHardWareId ";
        r3.<init>(r4);
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        goto L_0x0055;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.e.q.bh(boolean):java.lang.String");
    }

    public static String yN() {
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getMacAddress() : null;
    }

    public static String yO() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            return defaultAdapter.getAddress();
        }
        return null;
    }

    private static String yP() {
        String str;
        String eY = bi.eY(ad.getContext());
        if (eY == null || eY.length() <= 0) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            str = "A";
            int i = 0;
            while (i < 15) {
                i++;
                str = str + ((char) (random.nextInt(25) + 65));
            }
        } else {
            str = ("A" + eY + "123456789ABCDEF").substring(0, 15);
        }
        x.w("MicroMsg.DeviceInfo", "generated deviceId=" + str);
        return str;
    }

    public static void eK(String str) {
        x.i("MicroMsg.DeviceInfo", "update deviceInfo %s", str);
        if (str != null && str.length() > 0 && str.hashCode() != gHO) {
            gHO = str.hashCode();
            gHE.reset();
            gHF.reset();
            gHG.reset();
            gHP.reset();
            gHH.reset();
            gHI.reset();
            s sVar = gHJ;
            sVar.gHS = 0;
            sVar.gHT = 0;
            u uVar = gHK;
            uVar.gIg = "";
            uVar.gIh = null;
            gHL.fJK = false;
            gHM.reset();
            a aVar = gHN;
            aVar.gEp = false;
            aVar.gEq = "";
            r rVar = new r();
            if (r.a(str, gHE, gHF, gHG, gHP, gHH, gHI, gHJ, gHK, gHL, gHM, gHN)) {
                x.d("MicroMsg.DeviceInfo", "steve: mCameraInfo.mNeedEnhance = " + gHF.gGd);
                com.tencent.mm.sdk.b.a.xmy.m(new ce());
            }
        }
    }

    public static String yQ() {
        return Build.MODEL;
    }

    public static String aI(Context context) {
        try {
            x.i("MicroMsg.DeviceInfo", "lm: getManufacturer CurrentLanguage is %s", w.eM(context));
            if (gHK == null || gHK.gIh == null || gHK.gIh.size() == 0) {
                x.i("MicroMsg.DeviceInfo", "lm: getManufacturer return is %s", Build.MANUFACTURER);
                return Build.MANUFACTURER;
            }
            String str = (String) gHK.gIh.get(".manufacturerName." + w.eM(context));
            x.i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", str);
            if (!bi.oN(str)) {
                return str;
            }
            str = (String) gHK.gIh.get(".manufacturerName.en");
            x.i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", str);
            if (bi.oN(str)) {
                return Build.MANUFACTURER;
            }
            return str;
        } catch (Exception e) {
            return Build.MANUFACTURER;
        }
    }

    public static String aJ(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DeviceInfo", e, "getMobileSPType", new Object[0]);
            return "";
        }
    }

    public static String getSimCountryIso() {
        TelephonyManager telephonyManager = (TelephonyManager) ad.getContext().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        x.i("MicroMsg.DeviceInfo", "get isoCode:[%s]", telephonyManager.getSimCountryIso());
        return telephonyManager.getSimCountryIso();
    }

    public static String[] yR() {
        Throwable th;
        String[] strArr = new String[]{"", "0"};
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            try {
                String[] split = bi.oM(bufferedReader2.readLine()).split("\\s+");
                for (int i = 2; i < split.length; i++) {
                    strArr[0] = strArr[0] + split[i] + " ";
                }
                strArr[1] = bi.oM(bufferedReader2.readLine()).split("\\s+")[2];
                try {
                    bufferedReader2.close();
                } catch (Exception e) {
                }
            } catch (IOException e2) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e3) {
                    }
                }
                return strArr;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                bufferedReader = bufferedReader2;
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            bufferedReader2 = null;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return strArr;
        } catch (Throwable th4) {
            th = th4;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        return strArr;
    }

    public static String getAndroidId() {
        x.i("MicroMsg.DeviceInfo", "androidid:[%s]", Secure.getString(ad.getContext().getContentResolver(), "android_id"));
        return Secure.getString(ad.getContext().getContentResolver(), "android_id");
    }

    public static String yS() {
        String str = null;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                str = defaultAdapter.getAddress();
            }
            return bi.oM(str);
        } catch (Throwable e) {
            x.e("MicroMsg.DeviceInfo", "getBlueToothAddress failed: %s", bi.i(e));
            return "";
        }
    }

    @SuppressLint({"NewApi"})
    public static String yT() {
        String str = null;
        try {
            if (VERSION.SDK_INT >= 14) {
                str = Build.getRadioVersion();
            } else {
                str = Build.RADIO;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
            throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
        } catch (Throwable th) {
        }
        return bi.oM(str);
    }

    public static String yU() {
        return VERSION.RELEASE;
    }

    public static String yV() {
        try {
            return bi.oM(((TelephonyManager) ad.getContext().getSystemService("phone")).getSubscriberId());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DeviceInfo", e, "getPhoneIMSI", new Object[0]);
            return "";
        }
    }

    public static String yW() {
        try {
            return bi.oM(((TelephonyManager) ad.getContext().getSystemService("phone")).getSimSerialNumber());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DeviceInfo", e, "getPhoneICCID", new Object[0]);
            return "";
        }
    }

    @SuppressLint({"NewApi"})
    public static String yX() {
        String str = null;
        if (VERSION.SDK_INT >= 9) {
            str = Build.SERIAL;
        }
        return bi.oM(str);
    }

    public static Map<String, String> yY() {
        Throwable e;
        Map<String, String> hashMap = new HashMap();
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bi.d(bufferedReader);
                        break;
                    } else if (!readLine.trim().equals("")) {
                        String[] split = readLine.split(":");
                        if (split.length > 1) {
                            hashMap.put(split[0].trim().toLowerCase(), split[1].trim());
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
            try {
                x.printErrStackTrace("MicroMsg.DeviceInfo", e, "getInfoMapOfCpu() failed.", new Object[0]);
                bi.d(bufferedReader);
                return hashMap;
            } catch (Throwable th) {
                e = th;
                bi.d(bufferedReader);
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            bi.d(bufferedReader);
            throw e;
        }
        return hashMap;
    }

    public static int yZ() {
        try {
            return new File("/sys/devices/system/cpu").listFiles(new a()).length;
        } catch (Exception e) {
            return 1;
        }
    }

    public static String za() {
        return "android-" + Build.MODEL + "-" + VERSION.SDK_INT;
    }
}
