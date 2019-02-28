package com.tencent.mm.plugin.freewifi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.protocal.c.rk;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.ConnectException;
import java.net.NetworkInterface;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public final class m {
    private static SimpleDateFormat ksc = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

    public interface a {
        void i(int i, int i2, String str, k kVar);
    }

    public static boolean Bf(String str) {
        return str == null || str.length() == 0;
    }

    public static String Bg(String str) {
        if (Bf(str)) {
            return "";
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    public static boolean aLO() {
        String by = bi.by(ad.getContext());
        return by != null && by.toLowerCase().startsWith(ad.getPackageName());
    }

    public static void C(Intent intent) {
        if (Bf(intent.getStringExtra("free_wifi_sessionkey"))) {
            d(intent, aLP());
        }
    }

    public static String aLP() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void d(Intent intent, String str) {
        intent.putExtra("free_wifi_sessionkey", str);
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0);
    }

    public static String D(Intent intent) {
        return Bh(intent.getStringExtra("free_wifi_sessionkey"));
    }

    public static int E(Intent intent) {
        int intExtra = intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0) + 1;
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", intExtra);
        return intExtra;
    }

    public static int F(Intent intent) {
        return intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    }

    public static int G(Intent intent) {
        return intent.getIntExtra("free_wifi_channel_id", 0);
    }

    public static String H(Intent intent) {
        return intent.getStringExtra("free_wifi_ap_key");
    }

    public static String Bh(String str) {
        return str == null ? "" : str;
    }

    public static String Bi(String str) {
        if (aLS()) {
            WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String ssid = connectionInfo.getSSID();
            if (Bf(ssid)) {
                x.i(str, "getConnectedWifiSsid() is empty");
                return "";
            }
            x.i(str, "getConnectedWifiSsid()=" + Bg(ssid));
            return Bg(ssid);
        }
        x.i(str, "wifi not connected. getConnectedWifiSsid() is empty");
        return "";
    }

    public static String Bj(String str) {
        if (aLS()) {
            WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String toLowerCase = Bh(connectionInfo.getBSSID()).toLowerCase();
            x.i(str, "getConnectedWifiBssid()=" + toLowerCase);
            return toLowerCase;
        }
        x.i(str, "wifi not connected. getConnectedWifiBssid() is empty");
        return "";
    }

    public static String Bk(String str) {
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            x.e(str, "error wifiManager is null!!");
            return "";
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            x.e(str, "error wifiInfo is null!!");
            return "";
        }
        String macAddress = connectionInfo.getMacAddress();
        if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
            macAddress = aLQ();
        }
        macAddress = Bh(macAddress).toLowerCase();
        x.i(str, "getConnectedWifiClientMac()=" + macAddress);
        return macAddress;
    }

    public static String aLQ() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String str = "wlan0";
            if (NetworkInterface.getNetworkInterfaces() != null) {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase(str)) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            x.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                            return "02:00:00:00:00:00";
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                        }
                        if (stringBuilder.length() > 0) {
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        }
                        x.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                        return stringBuilder.toString();
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.Utils", "get mobile mac from net fail!" + e);
        }
        x.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
        return "02:00:00:00:00:00";
    }

    public static String e(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        String Bh = Bh(stringWriter.toString());
        if (Bh.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            return Bh.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        return Bh;
    }

    public static String f(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return Bh(stringWriter.toString());
    }

    public static String a(int i, b bVar, int i2) {
        Object format;
        x.i("MicroMsg.FreeWifi.Utils", "getUiErrorCode, protocol=%d, stageName=%s, stageCode=%d, errocode=%d", Integer.valueOf(i), bVar.name, Long.valueOf(bVar.mIW), Integer.valueOf(i2));
        int abs = Math.abs(i2);
        StringBuilder append = new StringBuilder().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%03d", new Object[]{Long.valueOf(bVar.mIW)}));
        if (abs <= 999) {
            format = String.format("%03d", new Object[]{Integer.valueOf(abs)});
        } else {
            format = Integer.valueOf(abs);
        }
        return append.append(format).toString();
    }

    public static void a(Intent intent, String str, final int i, int i2, final FreeWifiFrontPageUI freeWifiFrontPageUI, final String str2) {
        a(intent, str, i, i2, new a() {
            public final void i(int i, int i2, String str, k kVar) {
                FreeWifiFrontPageUI freeWifiFrontPageUI;
                d dVar;
                com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a aVar;
                if (i == 0 && i2 == 0) {
                    if (kVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                        em aMJ = ((com.tencent.mm.plugin.freewifi.d.a) kVar).aMJ();
                        if (aMJ != null) {
                            x.i(str2, "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", aMJ.nqc, aMJ.kzN, aMJ.kyG, Integer.valueOf(aMJ.vQy), aMJ.vQz, aMJ.hxh, aMJ.vQA);
                            FreeWifiFrontPageUI freeWifiFrontPageUI2 = freeWifiFrontPageUI;
                            d dVar2 = d.SUCCESS;
                            FreeWifiFrontPageUI.b bVar = new FreeWifiFrontPageUI.b();
                            bVar.mNm = aMJ;
                            freeWifiFrontPageUI2.a(dVar2, bVar);
                            return;
                        }
                        x.i(str2, "backPageInfo is null");
                        freeWifiFrontPageUI = freeWifiFrontPageUI;
                        dVar = d.FAIL;
                        aVar = new com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a();
                        aVar.mMO = m.a(i, b.GetBackPageReturn, 21);
                        freeWifiFrontPageUI.a(dVar, aVar);
                    }
                } else if (!m.cE(i, i2) || m.Bf(str)) {
                    freeWifiFrontPageUI = freeWifiFrontPageUI;
                    dVar = d.FAIL;
                    aVar = new com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a();
                    aVar.mMO = m.a(i, b.GetBackPageReturn, i2);
                    freeWifiFrontPageUI.a(dVar, aVar);
                } else {
                    freeWifiFrontPageUI = freeWifiFrontPageUI;
                    dVar = d.FAIL;
                    aVar = new com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a();
                    aVar.text = str;
                    aVar.mMO = m.a(i, b.GetBackPageReturn, i2);
                    freeWifiFrontPageUI.a(dVar, aVar);
                }
            }
        }, str2);
    }

    public static void a(Intent intent, String str, int i, int i2, a aVar, String str2) {
        final String str3 = str2;
        final String str4 = str;
        final Intent intent2 = intent;
        final int i3 = i;
        final int i4 = i2;
        final a aVar2 = aVar;
        j.aMy().aMg().post(new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.freewifi.k.a aLL = k.aLL();
                aLL.ssid = m.Bi(str3);
                aLL.bssid = m.Bj(str3);
                aLL.fqv = m.Bk(str3);
                aLL.fqu = str4;
                aLL.mIi = m.D(intent2);
                aLL.mIj = i3;
                aLL.mIk = b.GetBackPage.mIW;
                aLL.mIl = b.GetBackPage.name;
                aLL.fDM = m.G(intent2);
                aLL.result = 0;
                aLL.aLN().aLM();
                String Bj = m.Bj(str3);
                String Bi = m.Bi(str3);
                int aMj = com.tencent.mm.plugin.freewifi.model.d.aMj();
                x.i(str3, "NetStatusUtil.getNetType(MMApplicationContext.getContext()) = " + ao.getNetType(ad.getContext()));
                x.i(str3, "sessionKey=%s, step=%d, method=getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", m.D(intent2), Integer.valueOf(m.E(intent2)), str4, Bj, Bi, Integer.valueOf(aMj));
                new com.tencent.mm.plugin.freewifi.d.a(str4, Bj, Bi, aMj, i4, m.D(intent2)).b(new e() {
                    public final void a(int i, int i2, String str, k kVar) {
                        x.i(str3, "sessionKey=%s, step=%d, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", m.D(intent2), Integer.valueOf(m.E(intent2)), Integer.valueOf(i), Integer.valueOf(i2), str);
                        com.tencent.mm.plugin.freewifi.k.a aLL = k.aLL();
                        aLL.ssid = m.Bi(str3);
                        aLL.bssid = m.Bj(str3);
                        aLL.fqv = m.Bk(str3);
                        aLL.fqu = str4;
                        aLL.mIi = m.D(intent2);
                        aLL.mIj = m.F(intent2);
                        aLL.mIk = b.GetBackPage33Return.mIW;
                        aLL.mIl = b.GetBackPage33Return.name;
                        aLL.fDM = m.G(intent2);
                        aLL.result = i2;
                        aLL.lfa = str;
                        aLL.aLN().b(intent2, true).aLM();
                        aVar2.i(i, i2, str, kVar);
                    }
                });
            }
        });
    }

    public static int aLR() {
        com.tencent.mm.modelfriend.m.a NT = com.tencent.mm.modelfriend.m.NT();
        if (NT == com.tencent.mm.modelfriend.m.a.NO_INIT || NT == com.tencent.mm.modelfriend.m.a.SET_MOBILE) {
            return 1;
        }
        as.Hm();
        String str = (String) c.Db().get(6, null);
        if (Bf(str)) {
            return 1;
        }
        Object DK;
        if (str.startsWith("+")) {
            DK = ap.DK(str);
        } else {
            DK = "86";
        }
        if ("86".equals(DK)) {
            return 2;
        }
        return 3;
    }

    public static void cH(Context context) {
        Intent intent = new Intent(context, BindMContactUI.class);
        intent.putExtra("is_bind_for_safe_device", false);
        intent.putExtra("is_bind_for_change_mobile", false);
        String simCountryIso = ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
        if (!bi.oN(simCountryIso)) {
            com.tencent.mm.aq.b.a h = com.tencent.mm.aq.b.h(context, simCountryIso, context.getString(R.l.bZd));
            if (h != null) {
                intent.putExtra("country_name", h.hGi);
                intent.putExtra("couttry_code", h.hGh);
            }
        }
        MMWizardActivity.A(context, intent);
    }

    public static boolean cD(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return true;
        }
        return false;
    }

    public static boolean cE(int i, int i2) {
        if (i != 4 || i2 > -30000 || i2 <= -31000) {
            return false;
        }
        return true;
    }

    public static int g(Exception exception) {
        if (exception instanceof SocketTimeoutException) {
            String f = f(exception);
            if (f.indexOf(".read") != -1) {
                return 105;
            }
            if (f.indexOf(".connect") != -1) {
                return 104;
            }
            return 101;
        } else if (exception instanceof ConnectException) {
            return 106;
        } else {
            if (exception instanceof UnknownHostException) {
                return 102;
            }
            return 101;
        }
    }

    public static boolean k(Map<String, String> map, String str) {
        x.i(str, "CLIENT_VERSION=" + com.tencent.mm.protocal.d.vHl);
        String str2 = (String) map.get(".sysmsg.apply_versions.version_desc.$minInclude");
        String str3 = (String) map.get(".sysmsg.apply_versions.version_desc.$maxInclude");
        x.i(str, "checkMsgPushedVersion. min0=%s,max0=%s", str2, str3);
        if (Bf(str2) && Bf(str3)) {
            return false;
        }
        if (cF(str2, str3)) {
            return true;
        }
        int i = 1;
        while (true) {
            str2 = (String) map.get(".sysmsg.apply_versions.version_desc#" + i + ".$minInclude");
            str3 = (String) map.get(".sysmsg.apply_versions.version_desc#" + i + ".$maxInclude");
            x.i(str, "checkMsgPushedVersion. min" + i + "=%s,max" + i + "=%s", str2, str3);
            if (Bf(str2) && Bf(str3)) {
                return false;
            }
            if (cF(str2, str3)) {
                return true;
            }
            i++;
        }
    }

    private static boolean cF(String str, String str2) {
        int i = bi.getInt(str, 0);
        int i2 = bi.getInt(str2, 0);
        if (i == 0 && i2 != 0 && com.tencent.mm.protocal.d.vHl <= i2) {
            return true;
        }
        if (i != 0 && i2 == 0 && com.tencent.mm.protocal.d.vHl >= i) {
            return true;
        }
        if (i == 0 || i2 == 0 || com.tencent.mm.protocal.d.vHl < i || com.tencent.mm.protocal.d.vHl > i2) {
            return false;
        }
        return true;
    }

    public static boolean aLS() {
        if (((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
            x.i("TAG", "isWifiConnected()=true");
            return true;
        }
        x.i("TAG", "isWifiConnected()=false");
        return false;
    }

    public static rk aLT() {
        rk rkVar = new rk();
        rkVar.deviceBrand = com.tencent.mm.protocal.d.vHe;
        if (d.mHO == null || d.mHO.equals("")) {
            rkVar.wgi = Bk("MicroMsg.FreeWifi.Utils");
        } else {
            rkVar.wgi = d.mHO;
        }
        rkVar.deviceModel = com.tencent.mm.protocal.d.vHf;
        rkVar.osName = com.tencent.mm.protocal.d.vHh;
        rkVar.osVersion = com.tencent.mm.protocal.d.vHi;
        return rkVar;
    }

    public static String a(String str, LinkedHashMap<String, Class> linkedHashMap, i iVar, String str2) {
        String str3;
        if (linkedHashMap.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str).append("\r\n");
        StringBuilder stringBuilder2 = new StringBuilder();
        for (Entry key : linkedHashMap.entrySet()) {
            stringBuilder2.append((String) key.getKey()).append(",");
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder2.delete(stringBuilder2.length() - 1, stringBuilder2.length());
        }
        String str4 = "select " + stringBuilder2.toString() + " from " + str;
        for (Entry key2 : linkedHashMap.entrySet()) {
            stringBuilder.append((String) key2.getKey()).append("\t");
        }
        stringBuilder.append("\r\n");
        Cursor rawQuery = iVar.rawQuery(str4, new String[0]);
        while (rawQuery.moveToNext()) {
            int i = 0;
            for (Entry key22 : linkedHashMap.entrySet()) {
                Class cls = (Class) key22.getValue();
                if (cls == String.class) {
                    stringBuilder.append(rawQuery.getString(i));
                } else if (cls == Integer.TYPE) {
                    stringBuilder.append(rawQuery.getInt(i));
                } else {
                    try {
                        if (cls == Long.TYPE) {
                            stringBuilder.append(rawQuery.getLong(i));
                        } else if (cls == Float.TYPE) {
                            stringBuilder.append(rawQuery.getFloat(i));
                        } else if (cls == Double.TYPE) {
                            stringBuilder.append(rawQuery.getDouble(i));
                        } else {
                            x.e(str2, "unkonwn type " + cls.toString());
                            stringBuilder.append(rawQuery.getString(i));
                        }
                    } catch (Exception e) {
                        x.i(str2, "print " + str + "error." + e.getMessage());
                        str3 = "";
                        return str3;
                    } finally {
                        rawQuery.close();
                    }
                }
                stringBuilder.append("\t");
                i++;
            }
            stringBuilder.append("\r\n");
        }
        x.i(str2, stringBuilder.toString());
        str3 = stringBuilder.toString();
        return str3;
    }

    public static void Bl(String str) {
        x.i("FreeWifi", str);
    }
}
