package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.f.a.jb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bck;
import com.tencent.mm.protocal.c.bcl;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class o {
    private static al fia = new al(g.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            try {
                o.hUk = Long.MAX_VALUE;
                if (o.hUl >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN || o.hUl <= 1000) {
                    o.a(o.hUl, 0.0f, 0.0f, 0, 0);
                } else {
                    o.iG(o.hUl);
                }
            } catch (Throwable e) {
                x.e("MicroMsg.NetTypeReporter", "run :%s", bi.i(e));
            }
            return false;
        }
    }, false);
    private static final byte[] gUq = new byte[0];
    private static long hUh = 86400000;
    private static HashMap<String, Long> hUi = new HashMap();
    private static String hUj = null;
    private static long hUk = Long.MAX_VALUE;
    private static int hUl = 0;
    private static long hUm = 0;
    private static long hUn = 0;
    private static float hUo = 0.0f;
    private static float hUp = 0.0f;
    private static int hUq = 0;
    private static int hUr = 0;
    private static long hUs = 0;
    private static String hUt = "";

    private static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            try {
                if (g.Do().CF()) {
                    g.Do();
                    if (!com.tencent.mm.kernel.a.Cz()) {
                        String str;
                        if (intent == null || bi.oN(intent.getAction())) {
                            String str2 = "MicroMsg.NetTypeReporter";
                            String str3 = "onReceive %s  ";
                            Object[] objArr = new Object[1];
                            if (intent == null) {
                                str = "intent is null";
                            } else {
                                str = "action is null";
                            }
                            objArr[0] = str;
                            x.e(str2, str3, objArr);
                            return;
                        }
                        str = intent.getAction();
                        x.i("MicroMsg.NetTypeReporter", "onReceive action:%s foreground:%b", str, Boolean.valueOf(b.foreground));
                        if (!b.foreground) {
                            return;
                        }
                        if (str.equals("android.net.wifi.supplicant.CONNECTION_CHANGE")) {
                            o.iF(1001);
                            return;
                        } else if (str.equals("android.net.wifi.supplicant.STATE_CHANGE")) {
                            o.iF(1002);
                            return;
                        } else if (str.equals("android.net.wifi.STATE_CHANGE")) {
                            o.iF(1003);
                            return;
                        } else if (str.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                            o.iF(1004);
                            return;
                        } else if (str.equals("android.net.wifi.SCAN_RESULTS")) {
                            o.iF(1005);
                            return;
                        } else if (str.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                            o.iF(1006);
                            com.tencent.mm.sdk.b.a.xmy.m(new jb());
                            return;
                        } else {
                            return;
                        }
                    }
                }
                Object[] objArr2 = new Object[2];
                objArr2[0] = Boolean.valueOf(g.Do().CF());
                g.Do();
                objArr2[1] = Boolean.valueOf(com.tencent.mm.kernel.a.Cz());
                x.e("MicroMsg.NetTypeReporter", "onReceive acc not ready .%b %b", objArr2);
            } catch (Throwable th) {
                x.e("MicroMsg.NetTypeReporter", "onReceive : %s", bi.i(th));
            }
        }
    }

    static /* synthetic */ void iG(int i) {
        long Wy = bi.Wy();
        if (hUm <= 0 || Wy - hUm <= 5000) {
            String[] iE = iE(i);
            if (iE == null || iE.length != 4 || bi.oN(iE[0])) {
                x.e("MicroMsg.NetTypeReporter", "report get failed val");
                return;
            }
            x.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", Integer.valueOf(i), Long.valueOf(bi.bA(Wy)), Float.valueOf(0.0f), Float.valueOf(0.0f), Integer.valueOf(0), Long.valueOf(0), iE[0]);
            Wy = bi.bA(hUm);
            if (Wy > 600000 || Wy < 0) {
                Wy = 0;
            }
            com.tencent.mm.plugin.report.service.g.pWK.k(11747, iE[0] + "1,0.0" + ",0.0" + ",0" + ",0" + "," + (b.foreground ? "1" : String.valueOf(Wy)) + "," + iE[1] + "," + iE[2] + "," + iE[3]);
            g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, Long.valueOf(bi.Wy()));
            return;
        }
        x.e("MicroMsg.NetTypeReporter", "never  report (reportKV) at  background :%d diff:%d", Long.valueOf(hUm), Long.valueOf(Wy - hUm));
    }

    public static void bA(Context context) {
        if (context == null) {
            try {
                x.e("MicroMsg.NetTypeReporter", "registerReceiver ctx == null");
                return;
            } catch (Throwable th) {
                x.e("MicroMsg.NetTypeReporter", "registerReceiver : %s", bi.i(th));
                return;
            }
        }
        BroadcastReceiver aVar = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.supplicant.CONNECTION_CHANGE");
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(aVar, intentFilter);
        x.i("MicroMsg.NetTypeReporter", "registerReceiver finish");
    }

    private static boolean h(ArrayList<String> arrayList) {
        Throwable e;
        Iterator it;
        boolean z;
        String str;
        long bA;
        boolean z2;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        FileOutputStream fileOutputStream2;
        ObjectOutputStream objectOutputStream2 = null;
        if (arrayList.size() == 0) {
            x.w("MicroMsg.NetTypeReporter", "checkBssidShouldReport no value in list.");
            return false;
        }
        if (bi.oN(hUj)) {
            hUj = g.Dq().cachePath + "bssidcache.bin";
        }
        if (hUi.size() == 0) {
            FileInputStream fileInputStream;
            ObjectInputStream objectInputStream;
            try {
                fileInputStream = new FileInputStream(hUj);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        hUi = (HashMap) objectInputStream.readObject();
                        x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport read file size:%d", Integer.valueOf(hUi.size()));
                        try {
                            objectInputStream.close();
                            fileInputStream.close();
                        } catch (Throwable e2) {
                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bi.i(e2));
                            hUi = new HashMap();
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bi.i(e2));
                            hUi = new HashMap();
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable e22) {
                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bi.i(e22));
                                    hUi = new HashMap();
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(hUi.size()), hUj);
                            com.tencent.mm.loader.stub.b.deleteFile(hUj);
                            it = arrayList.iterator();
                            z = false;
                            while (it.hasNext()) {
                                str = (String) it.next();
                                bA = bi.bA(bi.ca(hUi.get(str)));
                                x.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", str, Long.valueOf(bA));
                                if (bA > 0) {
                                }
                                hUi.put(str, Long.valueOf(bi.Wy()));
                                z2 = true;
                                z = z2;
                            }
                            try {
                                fileOutputStream = new FileOutputStream(hUj);
                                try {
                                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                    try {
                                        objectOutputStream.writeObject(hUi);
                                        fileOutputStream.flush();
                                        x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(hUi.size()));
                                        try {
                                            objectOutputStream.close();
                                            fileOutputStream.close();
                                        } catch (Throwable e222) {
                                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bi.i(e222));
                                        }
                                    } catch (Exception e4) {
                                        e222 = e4;
                                        objectOutputStream2 = objectOutputStream;
                                        fileOutputStream2 = fileOutputStream;
                                        try {
                                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bi.i(e222));
                                            if (objectOutputStream2 != null) {
                                                try {
                                                    objectOutputStream2.close();
                                                } catch (Throwable e2222) {
                                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bi.i(e2222));
                                                }
                                            }
                                            if (fileOutputStream2 != null) {
                                                fileOutputStream2.close();
                                            }
                                            return z;
                                        } catch (Throwable th) {
                                            e2222 = th;
                                            fileOutputStream = fileOutputStream2;
                                            objectOutputStream = objectOutputStream2;
                                            if (objectOutputStream != null) {
                                                try {
                                                    objectOutputStream.close();
                                                } catch (Throwable e5) {
                                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bi.i(e5));
                                                    throw e2222;
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            throw e2222;
                                        }
                                    } catch (Throwable th2) {
                                        e2222 = th2;
                                        if (objectOutputStream != null) {
                                            objectOutputStream.close();
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        throw e2222;
                                    }
                                } catch (Exception e6) {
                                    e2222 = e6;
                                    fileOutputStream2 = fileOutputStream;
                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bi.i(e2222));
                                    if (objectOutputStream2 != null) {
                                        objectOutputStream2.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    return z;
                                } catch (Throwable th3) {
                                    e2222 = th3;
                                    objectOutputStream = null;
                                    if (objectOutputStream != null) {
                                        objectOutputStream.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw e2222;
                                }
                            } catch (Exception e7) {
                                e2222 = e7;
                                fileOutputStream2 = null;
                                x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bi.i(e2222));
                                if (objectOutputStream2 != null) {
                                    objectOutputStream2.close();
                                }
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                }
                                return z;
                            } catch (Throwable th4) {
                                e2222 = th4;
                                objectOutputStream = null;
                                fileOutputStream = null;
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw e2222;
                            }
                            return z;
                        } catch (Throwable th5) {
                            e2222 = th5;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable e52) {
                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bi.i(e52));
                                    hUi = new HashMap();
                                    throw e2222;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw e2222;
                        }
                    }
                } catch (Exception e8) {
                    e2222 = e8;
                    objectInputStream = null;
                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bi.i(e2222));
                    hUi = new HashMap();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(hUi.size()), hUj);
                    com.tencent.mm.loader.stub.b.deleteFile(hUj);
                    it = arrayList.iterator();
                    z = false;
                    while (it.hasNext()) {
                        str = (String) it.next();
                        bA = bi.bA(bi.ca(hUi.get(str)));
                        x.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", str, Long.valueOf(bA));
                        if (bA > 0) {
                        }
                        hUi.put(str, Long.valueOf(bi.Wy()));
                        z2 = true;
                        z = z2;
                    }
                    fileOutputStream = new FileOutputStream(hUj);
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(hUi);
                    fileOutputStream.flush();
                    x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(hUi.size()));
                    objectOutputStream.close();
                    fileOutputStream.close();
                    return z;
                } catch (Throwable th6) {
                    e2222 = th6;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e2222;
                }
            } catch (Exception e9) {
                e2222 = e9;
                objectInputStream = null;
                fileInputStream = null;
                x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bi.i(e2222));
                hUi = new HashMap();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(hUi.size()), hUj);
                com.tencent.mm.loader.stub.b.deleteFile(hUj);
                it = arrayList.iterator();
                z = false;
                while (it.hasNext()) {
                    str = (String) it.next();
                    bA = bi.bA(bi.ca(hUi.get(str)));
                    x.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", str, Long.valueOf(bA));
                    if (bA > 0) {
                    }
                    hUi.put(str, Long.valueOf(bi.Wy()));
                    z2 = true;
                    z = z2;
                }
                fileOutputStream = new FileOutputStream(hUj);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(hUi);
                fileOutputStream.flush();
                x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(hUi.size()));
                objectOutputStream.close();
                fileOutputStream.close();
                return z;
            } catch (Throwable th7) {
                e2222 = th7;
                objectInputStream = null;
                fileInputStream = null;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e2222;
            }
            if (hUi.size() <= 0 || hUi.size() > 1000) {
                x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(hUi.size()), hUj);
                com.tencent.mm.loader.stub.b.deleteFile(hUj);
            }
        }
        it = arrayList.iterator();
        z = false;
        while (it.hasNext()) {
            str = (String) it.next();
            bA = bi.bA(bi.ca(hUi.get(str)));
            x.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", str, Long.valueOf(bA));
            if (bA > 0 || bA > hUh) {
                hUi.put(str, Long.valueOf(bi.Wy()));
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        if (z && hUi.size() > 0) {
            fileOutputStream = new FileOutputStream(hUj);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(hUi);
            fileOutputStream.flush();
            x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(hUi.size()));
            objectOutputStream.close();
            fileOutputStream.close();
        }
        return z;
    }

    private static String[] iE(int i) {
        Throwable th;
        x.i("MicroMsg.NetTypeReporter", "dkNetTypeRead scene:%d fg:%b time:%d diff:%d", Integer.valueOf(i), Boolean.valueOf(b.foreground), Long.valueOf(hUm), Long.valueOf(bi.bA(hUm)));
        if (i <= 0) {
            x.e("MicroMsg.NetTypeReporter", "ERROR PARAM: scene:%d", Integer.valueOf(i));
            return null;
        }
        Context context = ad.getContext();
        if (context == null) {
            x.e("MicroMsg.NetTypeReporter", "ERROR Context is null scene:%d", Integer.valueOf(i));
            return null;
        }
        int zc;
        x.i("MicroMsg.NetTypeReporter", "read scene:%d foreground:%b", Integer.valueOf(i), Boolean.valueOf(b.foreground));
        int i2 = 0;
        try {
            zc = w.zc();
        } catch (Throwable e) {
            x.e("MicroMsg.NetTypeReporter", "getNetType : %s", bi.i(e));
            zc = i2;
        }
        x.i("MicroMsg.NetTypeReporter", "get netType :%d", Integer.valueOf(zc));
        String str = "";
        String str2 = "";
        String str3 = "";
        String networkOperatorName;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            int i3 = 0;
            ArrayList arrayList = new ArrayList();
            stringBuffer.append(connectionInfo.getSSID());
            stringBuffer2.append(connectionInfo.getBSSID());
            String bssid = connectionInfo.getBSSID();
            arrayList.add(bssid);
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                Collections.sort(scanResults, new Comparator<ScanResult>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                    }
                });
                int i4 = 20;
                for (ScanResult scanResult : scanResults) {
                    if (!(scanResult == null || bi.oN(scanResult.BSSID))) {
                        if (!scanResult.BSSID.equals(bssid)) {
                            int i5 = i4 - 1;
                            if (i4 <= 0) {
                                break;
                            }
                            stringBuffer.append("|");
                            stringBuffer.append(bi.oM(scanResult.SSID).replace("|", "").replace(" ", ""));
                            stringBuffer2.append("|");
                            stringBuffer2.append(bi.oM(scanResult.BSSID).replace("|", "").replace(" ", ""));
                            arrayList.add(scanResult.BSSID);
                            stringBuffer3.append("|");
                            stringBuffer3.append(scanResult.level);
                            i4 = i5;
                        } else {
                            i3 = scanResult.level;
                        }
                    }
                }
            }
            i2 = i3;
            if (i >= 2000 || h(arrayList)) {
                str = stringBuffer.toString();
                str2 = stringBuffer2.toString();
                str3 = i2 + stringBuffer3.toString();
                x.d("MicroMsg.NetTypeReporter", "get wifi :[%s] [%s]", str2, str);
                String str4 = "";
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        networkOperatorName = telephonyManager.getNetworkOperatorName();
                    } else {
                        networkOperatorName = str4;
                    }
                    str4 = networkOperatorName;
                } catch (Throwable e2) {
                    x.e("MicroMsg.NetTypeReporter", "getNetType : %s", bi.i(e2));
                }
                x.i("MicroMsg.NetTypeReporter", "get ispName: %s", str4);
                String str5 = "";
                String str6 = "";
                String str7 = "";
                String str8 = "";
                String str9 = "";
                try {
                    List eV = ao.eV(context);
                    i2 = 0;
                    while (true) {
                        int i6 = i2;
                        if (i6 >= eV.size()) {
                            networkOperatorName = str9;
                            str9 = str8;
                            str8 = str7;
                            str7 = str6;
                            str6 = str5;
                            break;
                        }
                        com.tencent.mm.sdk.platformtools.ao.a aVar = (com.tencent.mm.sdk.platformtools.ao.a) eV.get(i6);
                        str5 = bi.aD(aVar.xpi, "");
                        str6 = bi.aD(aVar.xpj, "");
                        if (str7.length() > 0 && !bi.oN(aVar.xpl)) {
                            str7 = str7 + "|";
                        }
                        if (!bi.oN(aVar.xpl)) {
                            str7 = str7 + aVar.xpl;
                        }
                        if (str8.length() > 0 && !bi.oN(aVar.xpk)) {
                            str8 = str8 + "|";
                        }
                        if (!bi.oN(aVar.xpk)) {
                            str8 = str8 + aVar.xpk;
                        }
                        if (str9.length() > 0) {
                            str9 = str9 + "|";
                        }
                        StringBuilder append = new StringBuilder().append(str9);
                        if (bi.oN(aVar.xpo)) {
                            networkOperatorName = "0";
                        } else {
                            networkOperatorName = aVar.xpo;
                        }
                        str9 = append.append(networkOperatorName).toString();
                        i2 = i6 + 1;
                    }
                } catch (Throwable e22) {
                    th = e22;
                    networkOperatorName = str9;
                    str9 = str8;
                    str8 = str7;
                    str7 = str6;
                    str6 = str5;
                    x.e("MicroMsg.NetTypeReporter", "getNetType : %s", bi.i(th));
                }
                x.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", str6, str7, str8);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(bi.Wx()).append(",");
                stringBuilder.append(i).append(",");
                stringBuilder.append(zc).append(",");
                stringBuilder.append(str.replace(",", " ")).append(",");
                stringBuilder.append(mQ(str2.replace(",", " "))).append(",");
                stringBuilder.append(str4.replace(",", " ")).append(",");
                stringBuilder.append(mQ(str6.replace(",", " "))).append(",");
                stringBuilder.append(mQ(str7.replace(",", " "))).append(",");
                stringBuilder.append(mQ(str8.replace(",", " "))).append(",");
                if (Th() < 0) {
                    return null;
                }
                return new String[]{Th() + "," + stringBuilder.toString(), mQ(str3), mQ(str9), mQ(networkOperatorName)};
            }
            x.w("MicroMsg.NetTypeReporter", "checkBssid: find all report already  , give up. scene:%d ", Integer.valueOf(i));
            return null;
        } catch (Throwable e222) {
            th = e222;
            networkOperatorName = str2;
            str2 = str;
            x.e("MicroMsg.NetTypeReporter", "getWifiInfo : %s", bi.i(th));
            str = str2;
            str2 = networkOperatorName;
        }
    }

    private static String mQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (char c : str.toCharArray()) {
            if ((c < 'a' || c > 'z') && ((c < 'A' || c > 'Z') && ((c < '0' || c > '9') && c != '|' && c != '-' && c != ' ' && c != ':'))) {
                return "";
            }
        }
        return str;
    }

    private static long Th() {
        long a;
        synchronized (gUq) {
            try {
                a = bi.a((Long) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_REPORTNETTYPE_SEQ_LONG, null), 1);
                g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_REPORTNETTYPE_SEQ_LONG, Long.valueOf(1 + a));
                g.Dq().Db().lO(true);
                long a2 = bi.a((Long) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_REPORTNETTYPE_SEQ_LONG, null), 1);
                x.i("MicroMsg.NetTypeReporter", "incSeq after write  old:%d new:%d", Long.valueOf(a), Long.valueOf(a2));
            } catch (Throwable e) {
                x.e("MicroMsg.NetTypeReporter", "incSeq :%s", bi.i(e));
                return -1;
            }
        }
        return a;
    }

    private static void a(int i, float f, float f2, int i2, long j) {
        long Wy = bi.Wy();
        if (hUm <= 0 || Wy - hUm <= 5000) {
            final String[] iE = iE(i);
            if (iE == null || iE.length != 4 || bi.oN(iE[0])) {
                x.e("MicroMsg.NetTypeReporter", "report get failed val");
                return;
            }
            x.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", Integer.valueOf(i), Long.valueOf(bi.bA(Wy)), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Long.valueOf(j), iE[0]);
            com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
            aVar.hnT = new bck();
            aVar.hnU = new bcl();
            aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
            aVar.hnS = 716;
            com.tencent.mm.ad.b Kf = aVar.Kf();
            final bck bck = (bck) Kf.hnQ.hnY;
            bck.vUW = d.vHf;
            bck.vUX = d.vHe;
            bck.vUY = d.vHh;
            bck.vUZ = d.vHi;
            bck.vVa = com.tencent.mm.sdk.platformtools.w.cfV();
            bck.wBF = 11747;
            Wy = bi.bA(hUm);
            if (Wy > 600000 || Wy < 0) {
                Wy = 0;
            }
            bck.pWq = iE[0] + "0," + f + "," + f2 + "," + i2 + "," + j + "," + (b.foreground ? "1" : String.valueOf(Wy)) + "," + iE[1] + "," + iE[2] + "," + iE[3];
            final long Wy2 = bi.Wy();
            final float f3 = f;
            final float f4 = f2;
            final int i3 = i2;
            final long j2 = j;
            u.a(Kf, new com.tencent.mm.ad.u.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                    x.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(bi.bA(Wy2)), bck.pWq);
                    if (!(i == 0 && i2 == 0)) {
                        long bA = bi.bA(o.hUm);
                        if (bA > 600000 || bA < 0) {
                            bA = 0;
                        }
                        com.tencent.mm.plugin.report.service.g.pWK.k(11747, iE[0] + "1," + f3 + "," + f4 + "," + i3 + "," + j2 + "," + (b.foreground ? "1" : String.valueOf(bA)) + "," + iE[1] + "," + iE[2] + "," + iE[3]);
                    }
                    g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, Long.valueOf(bi.Wy()));
                    return 0;
                }
            }, true);
            return;
        }
        x.e("MicroMsg.NetTypeReporter", "never  report  at  background :%d diff:%d", Long.valueOf(hUm), Long.valueOf(Wy - hUm));
    }

    public static void w(int i, String str) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bck();
        aVar.hnU = new bcl();
        aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
        aVar.hnS = 716;
        com.tencent.mm.ad.b Kf = aVar.Kf();
        final bck bck = (bck) Kf.hnQ.hnY;
        bck.vUW = d.vHf;
        bck.vUX = d.vHe;
        bck.vUY = d.vHh;
        bck.vUZ = d.vHi;
        bck.vVa = com.tencent.mm.sdk.platformtools.w.cfV();
        bck.wBF = i;
        bck.pWq = str;
        x.i("MicroMsg.NetTypeReporter", "reportCgi logId:%d, value:%s", Integer.valueOf(i), str);
        final long Wy = bi.Wy();
        u.a(Kf, new com.tencent.mm.ad.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                x.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(bi.bA(Wy)), bck.pWq);
                return 0;
            }
        });
    }

    private static void b(int i, float f, float f2, int i2, long j) {
        try {
            x.i("MicroMsg.NetTypeReporter", "checkTimeReport scene:%d diff:%d  time:%d", Integer.valueOf(i), Long.valueOf(bi.bA(hUk)), Long.valueOf(hUk));
            if (i > MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN || bi.bA(hUk) > 300000) {
                x.i("MicroMsg.NetTypeReporter", "force Run, scene:%d diff:%d time:%d ", Integer.valueOf(i), Long.valueOf(bi.bA(hUk)), Long.valueOf(hUk));
                hUl = i;
                hUk = Long.MAX_VALUE;
                a(i, f, f2, i2, j);
                return;
            }
            if (hUk == Long.MAX_VALUE) {
                hUk = bi.Wy() + 60000;
            }
            hUl = i;
            fia.K(60000, 60000);
        } catch (Throwable th) {
            x.e("MicroMsg.NetTypeReporter", "checkTimeReport error: %s", bi.i(th));
        }
    }

    public static void bX(boolean z) {
        if (z) {
            hUm = 0;
        } else if (!fia.cgx()) {
            x.i("MicroMsg.NetTypeReporter", "setToForeground user turn to background run report now");
            hUm = bi.Wy();
            fia.K(0, 0);
        }
    }

    public static synchronized void a(int i, float f, float f2, int i2) {
        synchronized (o.class) {
            if (i < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN || f == 0.0f || f2 == 0.0f) {
                x.e("MicroMsg.NetTypeReporter", "reportGps, invalid args, scene = %d, lon = %f, lat = %f, pre = %d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
            } else if (bi.bA(hUs) < 60000) {
                x.e("MicroMsg.NetTypeReporter", "reportGps, hit lastReportGpsLimit, request dropped, scene = %d, lon = %f, lat = %f, pre = %d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
            } else {
                x.i("MicroMsg.NetTypeReporter", "reportGps scene:%d lon:%f lat:%f pre:%d last:%d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Long.valueOf(bi.bA(hUs)));
                hUs = bi.Wy();
                hUr = i;
                hUn = bi.Wy();
                hUq = i2;
                hUo = f2;
                hUp = f;
                try {
                    ((WifiManager) ad.getContext().getSystemService("wifi")).startScan();
                    g.Dt().g(new Runnable() {
                        public final void run() {
                            o.iF(1005);
                        }
                    }, 5000);
                } catch (Throwable e) {
                    x.e("MicroMsg.NetTypeReporter", "reportGps :%s", bi.i(e));
                }
            }
        }
        return;
    }

    public static synchronized void iF(int i) {
        synchronized (o.class) {
            x.i("MicroMsg.NetTypeReporter", "run scene:%d foreground:%b lastGpsTime:%d lastbssid:%s", Integer.valueOf(i), Boolean.valueOf(b.foreground), Long.valueOf(hUn), hUt);
            if (i == 1005) {
                try {
                    if (hUn > 0) {
                        x.d("MicroMsg.NetTypeReporter", "report gps scene:%d lastscene:%d [%f,%f,%d] lastGpsTime", Integer.valueOf(i), Integer.valueOf(hUr), Float.valueOf(hUp), Float.valueOf(hUo), Integer.valueOf(hUq), Long.valueOf(hUn));
                        long bA = bi.bA(hUn);
                        int i2 = hUr;
                        float f = hUo;
                        float f2 = hUp;
                        int i3 = hUq;
                        hUn = 0;
                        hUo = 0.0f;
                        hUp = 0.0f;
                        hUq = 0;
                        hUr = 0;
                        b(i2, f2, f, i3, bA);
                    }
                } catch (Throwable th) {
                    x.e("MicroMsg.NetTypeReporter", "run :%s", bi.i(th));
                }
            }
            if (!b.foreground) {
                x.w("MicroMsg.NetTypeReporter", "run is not foreground give up %d ", Integer.valueOf(i));
            } else if (i == 3) {
                String bssid = ((WifiManager) ad.getContext().getSystemService("wifi")).getConnectionInfo().getBSSID();
                x.d("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_BSSID_CHANGE %s %s ", Integer.valueOf(i), bssid, hUt);
                if (!(bi.oN(bssid) || bssid.equals(hUt))) {
                    hUt = bssid;
                    b(i, 0.0f, 0.0f, 0, 0);
                }
            } else if (i == 4) {
                x.i("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_TIMEOUT  diff:%d", Integer.valueOf(i), Long.valueOf(bi.bA(bi.a((Long) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, null), 0))));
                if (bi.bA(bi.a((Long) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, null), 0)) >= 21600000) {
                    b(i, 0.0f, 0.0f, 0, 0);
                }
            } else {
                b(i, 0.0f, 0.0f, 0, 0);
            }
        }
        return;
    }
}
