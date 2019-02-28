package com.tencent.mm.plugin.backup.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.n;
import com.tencent.mm.bp.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.backup.a.f.b;
import com.tencent.mm.plugin.backup.h.m;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.beu;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.conn.util.InetAddressUtils;

public final class g {
    private static List<String> koG = null;

    public static <T extends a> T a(T t, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            t.aH(bArr);
            return t;
        } catch (Throwable e) {
            x.e("MicroMsg.BackupUtil", "ERROR: parseProBuf [%s] [%s]", e.getMessage(), bi.i(e));
            return null;
        }
    }

    public static void a(String str, com.tencent.mm.plugin.backup.h.x xVar) {
        Throwable e;
        RandomAccessFile randomAccessFile = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = str + xVar.kzD;
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str2, "rw");
            try {
                randomAccessFile2.setLength((long) xVar.kzF);
                randomAccessFile2.seek((long) xVar.kzG);
                randomAccessFile2.write(xVar.kyn.oz);
                try {
                    randomAccessFile2.close();
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                e = e3;
                randomAccessFile = randomAccessFile2;
                try {
                    x.printErrStackTrace("MicroMsg.BackupUtil", e, "writeMediaToFile fail with exception", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e4) {
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e;
            }
        } catch (Exception e6) {
            e = e6;
            x.printErrStackTrace("MicroMsg.BackupUtil", e, "writeMediaToFile fail with exception", new Object[0]);
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
    }

    public static long vQ(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return -1;
        }
        if (!file.canRead()) {
            return -2;
        }
        if (file.canWrite()) {
            return file.length();
        }
        return -3;
    }

    public static void b(String str, com.tencent.mm.plugin.backup.h.x xVar) {
        if (TextUtils.isEmpty(str) || xVar == null) {
            x.e("MicroMsg.BackupUtil", "appendFile dir:%s req:%s ", str, xVar);
        } else if (TextUtils.isEmpty(xVar.kzD) || xVar.kyn == null || bi.bz(xVar.kyn.oz) <= 0) {
            String str2;
            String str3 = "MicroMsg.BackupUtil";
            String str4 = "appendFile dataid:%s data:%s  %s";
            Object[] objArr = new Object[3];
            objArr[0] = xVar.kzD;
            objArr[1] = xVar.kyn;
            if (xVar.kyn == null) {
                str2 = "null";
            } else {
                str2 = Integer.valueOf(bi.bz(xVar.kyn.oz));
            }
            objArr[2] = str2;
            x.e(str3, str4, objArr);
        } else {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    long vQ = vQ(str + xVar.kzD);
                    File file = new File(str + xVar.kzD);
                    long length = file.exists() ? file.length() : 0;
                    int a = e.a(str, xVar.kzD, xVar.kyn.oz);
                    File file2 = new File(str + xVar.kzD);
                    if (length == (file2.exists() ? file2.length() : 0)) {
                        x.e("MicroMsg.BackupUtil", "append failed and try again:%s", str + xVar.kzD);
                        i = e.a(str, xVar.kzD, xVar.kyn.oz) * 10000;
                    } else {
                        i = a;
                    }
                    long vQ2 = vQ(str + xVar.kzD);
                    if (i != 0 || vQ2 < ((long) xVar.kyn.oz.length)) {
                        x.e("MicroMsg.BackupUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(vQ), Long.valueOf(vQ2), Integer.valueOf(xVar.kyn.oz.length));
                        i = i2;
                    } else {
                        x.d("MicroMsg.BackupUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(vQ), Long.valueOf(vQ2), Integer.valueOf(xVar.kyn.oz.length));
                        return;
                    }
                }
                return;
            }
        }
    }

    public static String cm(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager.getWifiState() == 3) {
            String ssid;
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                try {
                    ssid = connectionInfo.getSSID();
                } catch (Throwable e) {
                    x.e("MicroMsg.BackupUtil", "getConnectionInfo %s", e);
                    x.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
                    return "";
                }
            }
            ssid = "wifi";
            return (ssid.length() >= 2 && ssid.startsWith("\"") && ssid.endsWith("\"")) ? ssid.substring(1, ssid.length() - 1) : ssid;
        } else {
            int intValue;
            int i = 13;
            try {
                i = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
                intValue = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
            } catch (Throwable e2) {
                x.e("MicroMsg.BackupUtil", "getWifiApState %s", e2);
                x.printErrStackTrace("MicroMsg.BackupUtil", e2, "", new Object[0]);
                intValue = 0;
            }
            if (intValue == i) {
                x.i("MicroMsg.BackupUtil", "getWifiName apmode");
                try {
                    return ((WifiConfiguration) wifiManager.getClass().getMethod("getWifiApConfiguration", new Class[0]).invoke(wifiManager, new Object[0])).SSID;
                } catch (Throwable e3) {
                    x.e("MicroMsg.BackupUtil", "getWifiApConfiguration %s", e3);
                    x.printErrStackTrace("MicroMsg.BackupUtil", e3, "", new Object[0]);
                }
            }
            return "";
        }
    }

    public static String apc() {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(c.FJ()).append("backupRecover/").toString();
    }

    public static String vR(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        return apc() + "backupItem/" + vT(str);
    }

    public static String vS(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        return apc() + "backupMeida/" + vT(str);
    }

    private static String vT(String str) {
        if (str == null) {
            return "";
        }
        String s = com.tencent.mm.a.g.s(str.getBytes());
        String str2 = "";
        String str3 = "";
        if (s.length() > 0) {
            str2 = s.charAt(0) + "/";
        }
        if (s.length() >= 2) {
            str3 = s.charAt(1) + "/";
        }
        return str2 + str3;
    }

    public static int apd() {
        Intent registerReceiver = ad.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return 100;
        }
        int intExtra = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
        boolean z = intExtra == 2 || intExtra == 5;
        x.i("MicroMsg.BackupUtil", "checkBatteryLevel, battery isCharging[%b]", Boolean.valueOf(z));
        if (z) {
            return 100;
        }
        intExtra = registerReceiver.getIntExtra("level", -1);
        int intExtra2 = registerReceiver.getIntExtra("scale", -1);
        if (intExtra < 0 || intExtra2 <= 0) {
            intExtra = 100;
        } else {
            intExtra = (intExtra * 100) / intExtra2;
        }
        x.i("MicroMsg.BackupUtil", "checkBatteryLevel, battery level remaining[%d]", Integer.valueOf(intExtra));
        return intExtra;
    }

    public static boolean vU(String str) {
        int ipAddress;
        int intValue;
        Throwable e;
        String[] split = str.split("\\.");
        int u = n.u(new byte[]{(byte) (bi.getInt(split[0], 0) & 255), (byte) (bi.getInt(split[1], 0) & 255), (byte) (bi.getInt(split[2], 0) & 255), (byte) (bi.getInt(split[3], 0) & 255)});
        int u2 = n.u(new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) 0});
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
        if (wifiManager.getWifiState() == 3) {
            ipAddress = wifiManager.getConnectionInfo().getIpAddress();
            String str2 = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
            x.i("MicroMsg.BackupUtil", "oldIpStr:%s, localIp:%s", str, str2);
            if ((u2 & u) == (ipAddress & u2)) {
                return true;
            }
            return false;
        }
        try {
            intValue = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
            try {
                ipAddress = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            intValue = 13;
        }
        if (ipAddress != intValue) {
            x.i("MicroMsg.BackupUtil", "matchip in apmode");
            return cf(u2, u);
        }
        x.i("MicroMsg.BackupUtil", "apState:%d", Integer.valueOf(ipAddress));
        return false;
        x.e("MicroMsg.BackupUtil", "getWifiApState %s", e);
        x.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
        ipAddress = 0;
        if (ipAddress != intValue) {
            x.i("MicroMsg.BackupUtil", "apState:%d", Integer.valueOf(ipAddress));
            return false;
        }
        x.i("MicroMsg.BackupUtil", "matchip in apmode");
        return cf(u2, u);
    }

    private static boolean cf(int i, int i2) {
        try {
            for (NetworkInterface inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(inetAddresses.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String toUpperCase = inetAddress.getHostAddress().toUpperCase();
                        x.i("MicroMsg.BackupUtil", "check ip:%s, isIPv4:%b", toUpperCase, Boolean.valueOf(InetAddressUtils.isIPv4Address(toUpperCase)));
                        if (InetAddressUtils.isIPv4Address(toUpperCase)) {
                            String[] split = toUpperCase.split("\\.");
                            if ((i & i2) == (n.u(new byte[]{(byte) (bi.getInt(split[0], 0) & 255), (byte) (bi.getInt(split[1], 0) & 255), (byte) (bi.getInt(split[2], 0) & 255), (byte) (bi.getInt(split[3], 0) & 255)}) & i)) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean vV(String str) {
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (bj.y(str, "msg") != null) {
            return true;
        }
        return false;
    }

    public static String a(ev evVar, int i) {
        return a(evVar, i, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(com.tencent.mm.protocal.c.ev r5, int r6, java.lang.String r7) {
        /*
        r2 = 0;
        r0 = r5.vQY;
        if (r0 != r6) goto L_0x0014;
    L_0x0005:
        r0 = r5.vQW;
        if (r0 == 0) goto L_0x0014;
    L_0x0009:
        r0 = r5.vQW;
        r0 = r0.wRm;
        r0 = r0.oz;
        r0 = com.tencent.mm.a.g.s(r0);
    L_0x0013:
        return r0;
    L_0x0014:
        r0 = 0;
        r1 = r5.vQV;
        if (r1 == 0) goto L_0x0071;
    L_0x0019:
        r1 = r5.vQU;
        if (r1 == 0) goto L_0x0071;
    L_0x001d:
        r1 = r5.vQV;
        r3 = r1.iterator();
        r1 = r0;
    L_0x0024:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0071;
    L_0x002a:
        r0 = r3.next();
        r0 = (com.tencent.mm.protocal.c.beu) r0;
        r0 = r0.wRq;
        if (r0 != r6) goto L_0x006d;
    L_0x0034:
        r0 = r5.vQU;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.protocal.c.bet) r0;
        r0 = r0.wRo;
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
        if (r4 != 0) goto L_0x0050;
    L_0x0044:
        r4 = r0.endsWith(r7);
        if (r4 != 0) goto L_0x0050;
    L_0x004a:
        r0 = r1 + 1;
        r0 = r0 + 1;
        r1 = r0;
        goto L_0x0024;
    L_0x0050:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = vS(r0);
        r1 = r1.append(r3);
        r1 = r1.append(r0);
        r1 = r1.toString();
        r1 = com.tencent.mm.a.e.bO(r1);
        if (r1 != 0) goto L_0x0013;
    L_0x006b:
        r0 = r2;
        goto L_0x0013;
    L_0x006d:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0024;
    L_0x0071:
        r0 = r2;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.a.g.a(com.tencent.mm.protocal.c.ev, int, java.lang.String):java.lang.String");
    }

    public static int aS(String str, int i) {
        if (bi.oN(str)) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
            return i;
        }
    }

    public static boolean b(ev evVar, int i, String str) {
        if (evVar.vQY == i) {
            byte[] bArr = evVar.vQW.wRm.oz;
            if (bArr.length <= 0) {
                return false;
            }
            e.b(str, bArr, bArr.length);
            return true;
        }
        String a = a(evVar, i, null);
        if (bi.oN(a)) {
            return false;
        }
        k.r(vS(a) + a, str, false);
        return true;
    }

    public static byte[] b(ev evVar, int i) {
        if (evVar.vQY == i && evVar.vQW != null) {
            return evVar.vQW.wRm.oz;
        }
        if (!(evVar.vQV == null || evVar.vQU == null)) {
            Iterator it = evVar.vQV.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (((beu) it.next()).wRq == i) {
                    String str = ((bet) evVar.vQU.get(i2)).wRo;
                    str = vS(str) + str;
                    i2 = e.bN(str);
                    if (i2 != 0 && i2 <= 1048576) {
                        return e.e(str, 0, -1);
                    }
                    x.e("MicroMsg.BackupUtil", "thumb not exist or  too big!");
                    return null;
                }
                i2++;
            }
        }
        return null;
    }

    public static int c(ev evVar, int i) {
        if (evVar.vQY == i) {
            if (evVar.vQW == null) {
                return 0;
            }
            return evVar.vQW.wRm.oz.length;
        } else if (evVar.vQV == null || evVar.vQU == null) {
            return 0;
        } else {
            Iterator it = evVar.vQV.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (((beu) it.next()).wRq == i) {
                    String str = ((bet) evVar.vQU.get(i2)).wRo;
                    return e.bN(vS(str) + str);
                }
                i2++;
            }
            return 0;
        }
    }

    public static boolean d(ev evVar, int i) {
        if (evVar.vQY == i && evVar.vQW != null) {
            return true;
        }
        Iterator it = evVar.vQV.iterator();
        while (it.hasNext()) {
            if (((beu) it.next()).wRq == i) {
                return true;
            }
        }
        return false;
    }

    public static List<String> ape() {
        if (koG != null) {
            return koG;
        }
        koG = new LinkedList();
        for (Object add : s.hhb) {
            koG.add(add);
        }
        koG.add("weixin");
        koG.add("weibo");
        koG.add("qqmail");
        koG.add("fmessage");
        koG.add("tmessage");
        koG.add("qmessage");
        koG.add("qqsync");
        koG.add("floatbottle");
        koG.add("lbsapp");
        koG.add("shakeapp");
        koG.add("medianote");
        koG.add("qqfriend");
        koG.add("readerapp");
        koG.add("newsapp");
        koG.add("blogapp");
        koG.add("facebookapp");
        koG.add("masssendapp");
        koG.add("meishiapp");
        koG.add("feedsapp");
        koG.add("voipapp");
        koG.add("officialaccounts");
        koG.add("helper_entry");
        koG.add("pc_share");
        koG.add("cardpackage");
        koG.add("voicevoipapp");
        koG.add("voiceinputapp");
        koG.add("linkedinplugin");
        koG.add("appbrandcustomerservicemsg");
        return koG;
    }

    public static boolean a(PLong pLong, PLong pLong2, String str) {
        StatFs statFs = new StatFs(h.getExternalStorageDirectory().getPath());
        pLong.value = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        File dataDirectory = h.getDataDirectory();
        statFs = new StatFs(dataDirectory.getPath());
        long blockCount = (long) statFs.getBlockCount();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        pLong2.value = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        x.i("MicroMsg.BackupUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", Long.valueOf(pLong.value), Long.valueOf(pLong2.value), Long.valueOf(0));
        if (blockCount <= 0) {
            return false;
        }
        if (blockCount - availableBlocks < 0) {
            return false;
        }
        if (pLong.value == pLong2.value || str.startsWith(dataDirectory.getPath())) {
            pLong.value = 0;
        }
        if (0 > pLong2.value) {
            return false;
        }
        return true;
    }

    public static long vW(String str) {
        long j = 0;
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss").parse(str).getTime();
        } catch (ParseException e) {
            x.e("MicroMsg.BackupUtil", "dateToTimeStamp failed. date:%s, stack:%s", str, bi.chl());
            return j;
        }
    }

    public static LinkedList<String> v(LinkedList<b> linkedList) {
        LinkedList<String> linkedList2 = new LinkedList();
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(((b) it.next()).koB);
            }
        }
        return linkedList2;
    }

    public static String a(String str, String str2, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return str;
        }
        StringBuilder stringBuilder;
        int i;
        if (str.equals("")) {
            stringBuilder = new StringBuilder(strArr[0]);
            i = 1;
        } else {
            stringBuilder = new StringBuilder(str);
            i = 0;
        }
        for (String str3 : strArr) {
            if (i != 0) {
                i = 0;
            } else {
                stringBuilder.append(str2).append(str3);
            }
        }
        return stringBuilder.toString();
    }

    public static String[] bM(String str, String str2) {
        return str.split(str2);
    }

    public static m bI(long j) {
        m mVar = new m();
        String deviceID = q.getDeviceID(ad.getContext());
        if (deviceID == null) {
            deviceID = q.yM();
        }
        mVar.kyJ = deviceID;
        mVar.kyK = Build.MANUFACTURER;
        mVar.kyL = Build.MODEL;
        mVar.kyM = "Android";
        mVar.kyN = VERSION.RELEASE;
        mVar.kyO = d.vHl;
        mVar.kyP = j;
        x.i("MicroMsg.BackupUtil", "getBackupStartGeneralInfo WechatVersion[%s], freespace[%d], deviceId[%s]", Integer.valueOf(d.vHl), Long.valueOf(j), mVar.kyJ);
        return mVar;
    }
}
