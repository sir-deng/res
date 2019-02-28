package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.blv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class aj {
    private static String bwB() {
        Throwable th;
        String str;
        Throwable e;
        String str2;
        String str3;
        String str4;
        String str5;
        List eV;
        int i;
        a aVar;
        StringBuilder stringBuilder;
        Context context = ad.getContext();
        if (context == null) {
            x.e("MicroMsg.SnsItemReportHelper", "ERROR Context is null scene");
            return null;
        }
        int i2 = 0;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            int subtype = activeNetworkInfo.getSubtype();
            if (activeNetworkInfo.getType() == 1) {
                i2 = 1;
            } else if (subtype == 13 || subtype == 15 || subtype == 14) {
                i2 = 4;
            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                i2 = 3;
            } else if (subtype == 1 || subtype == 2) {
                i2 = 2;
            } else {
                i2 = 0;
            }
        } catch (Throwable e2) {
            x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", bi.i(e2));
        }
        x.i("MicroMsg.SnsItemReportHelper", "get netType :%d", Integer.valueOf(i2));
        String str6 = "";
        String str7 = "";
        String str8 = "";
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
            int i6 = i3;
            str6 = stringBuffer.toString();
            str7 = stringBuffer2.toString();
            str8 = i6 + stringBuffer3.toString();
        } catch (Throwable e22) {
            th = e22;
            str = str7;
            str7 = str6;
            x.e("MicroMsg.SnsItemReportHelper", "getWifiInfo : %s", bi.i(th));
            str6 = str7;
            str7 = str;
        }
        x.d("MicroMsg.SnsItemReportHelper", "get wifi :[%s] [%s] [%s]", str7, str6, str8);
        String str9 = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getNetworkOperatorName();
                try {
                    if (bi.oN(str)) {
                        str = "";
                    }
                } catch (Exception e3) {
                    e = e3;
                    x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", bi.i(e));
                    str9 = str;
                    x.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", str9);
                    str2 = "";
                    str3 = "";
                    str4 = "";
                    str5 = "";
                    eV = ao.eV(context);
                    i = 0;
                    while (i < eV.size()) {
                        aVar = (a) eV.get(i);
                        str2 = bi.aD(aVar.xpi, "");
                        str3 = bi.aD(aVar.xpj, "");
                        str4 = str4 + "|";
                        if (!bi.oN(aVar.xpl)) {
                            str4 = str4 + aVar.xpl;
                        }
                        str5 = str5 + "|";
                        if (bi.oN(aVar.xpk)) {
                            str = str5 + aVar.xpk;
                        } else {
                            str = str5;
                        }
                        i++;
                        str5 = str;
                    }
                    str = str5;
                    str5 = str4;
                    str4 = str3;
                    str3 = str2;
                    x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str3, str4, str5, str);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(i2).append(",");
                    stringBuilder.append(str6.replace(",", " ")).append(",");
                    stringBuilder.append(str7.replace(",", " ")).append(",");
                    stringBuilder.append(str8.replace(",", " ")).append(",");
                    stringBuilder.append(str9.replace(",", " ")).append(",");
                    stringBuilder.append(str3.replace(",", " ")).append(",");
                    stringBuilder.append(str4.replace(",", " ")).append(",");
                    stringBuilder.append(str5.replace(",", " ")).append(",");
                    stringBuilder.append(str.replace(",", " "));
                    return stringBuilder.toString();
                }
            }
            str = str9;
            str9 = str;
        } catch (Throwable e222) {
            th = e222;
            str = str9;
            e = th;
            x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", bi.i(e));
            str9 = str;
            x.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", str9);
            str2 = "";
            str3 = "";
            str4 = "";
            str5 = "";
            eV = ao.eV(context);
            i = 0;
            while (i < eV.size()) {
                aVar = (a) eV.get(i);
                str2 = bi.aD(aVar.xpi, "");
                str3 = bi.aD(aVar.xpj, "");
                str4 = str4 + "|";
                if (bi.oN(aVar.xpl)) {
                    str4 = str4 + aVar.xpl;
                }
                str5 = str5 + "|";
                if (bi.oN(aVar.xpk)) {
                    str = str5 + aVar.xpk;
                } else {
                    str = str5;
                }
                i++;
                str5 = str;
            }
            str = str5;
            str5 = str4;
            str4 = str3;
            str3 = str2;
            x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str3, str4, str5, str);
            stringBuilder = new StringBuilder();
            stringBuilder.append(i2).append(",");
            stringBuilder.append(str6.replace(",", " ")).append(",");
            stringBuilder.append(str7.replace(",", " ")).append(",");
            stringBuilder.append(str8.replace(",", " ")).append(",");
            stringBuilder.append(str9.replace(",", " ")).append(",");
            stringBuilder.append(str3.replace(",", " ")).append(",");
            stringBuilder.append(str4.replace(",", " ")).append(",");
            stringBuilder.append(str5.replace(",", " ")).append(",");
            stringBuilder.append(str.replace(",", " "));
            return stringBuilder.toString();
        }
        x.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", str9);
        str2 = "";
        str3 = "";
        str4 = "";
        str5 = "";
        try {
            eV = ao.eV(context);
            i = 0;
            while (i < eV.size()) {
                aVar = (a) eV.get(i);
                str2 = bi.aD(aVar.xpi, "");
                str3 = bi.aD(aVar.xpj, "");
                if (str4.length() > 0 && !bi.oN(aVar.xpl)) {
                    str4 = str4 + "|";
                }
                if (bi.oN(aVar.xpl)) {
                    str4 = str4 + aVar.xpl;
                }
                if (str5.length() > 0 && !bi.oN(aVar.xpk)) {
                    str5 = str5 + "|";
                }
                if (bi.oN(aVar.xpk)) {
                    str = str5 + aVar.xpk;
                } else {
                    str = str5;
                }
                i++;
                str5 = str;
            }
            str = str5;
            str5 = str4;
            str4 = str3;
            str3 = str2;
        } catch (Throwable e2222) {
            th = e2222;
            str = str5;
            str5 = str4;
            str4 = str3;
            str3 = str2;
            x.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", bi.i(th));
        }
        x.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", str3, str4, str5, str);
        stringBuilder = new StringBuilder();
        stringBuilder.append(i2).append(",");
        stringBuilder.append(str6.replace(",", " ")).append(",");
        stringBuilder.append(str7.replace(",", " ")).append(",");
        stringBuilder.append(str8.replace(",", " ")).append(",");
        stringBuilder.append(str9.replace(",", " ")).append(",");
        stringBuilder.append(str3.replace(",", " ")).append(",");
        stringBuilder.append(str4.replace(",", " ")).append(",");
        stringBuilder.append(str5.replace(",", " ")).append(",");
        stringBuilder.append(str.replace(",", " "));
        return stringBuilder.toString();
    }

    public static void eI(long j) {
        if (j != 0) {
            m eS = ae.bwf().eS(j);
            if (eS != null && eS.field_type == 1) {
                arf byS = eS.byS();
                if (byS != null) {
                    List list = byS.wFz;
                    List list2 = eS.byF().wYj.wfh;
                    int min = Math.min(list.size(), list2.size());
                    String str = "";
                    if (min > 0) {
                        str = bwB();
                        if (bi.oN(str)) {
                            return;
                        }
                    }
                    String str2 = str;
                    for (int i = 0; i < min; i++) {
                        blv blv = (blv) list.get(i);
                        StringBuffer stringBuffer = new StringBuffer();
                        are are = (are) list2.get(i);
                        stringBuffer.append("||index: " + i);
                        stringBuffer.append("||item poi lat " + blv.wVN + " " + blv.wVO);
                        stringBuffer.append("||item poi accuracy loctype " + blv.biF + " " + blv.rAl);
                        stringBuffer.append("||item pic lat " + blv.wVL + " " + blv.wVM);
                        stringBuffer.append("||item exitime:" + blv.wVQ + " filetime: " + blv.wVR);
                        stringBuffer.append("||item source: " + blv.wVP);
                        stringBuffer.append("||url" + are.nlE);
                        String str3 = are.nlE;
                        if (str3.startsWith("http://mmsns.qpic.cn/mmsns/")) {
                            int lastIndexOf = str3.lastIndexOf("/");
                            if (lastIndexOf > 27 && lastIndexOf < str3.length()) {
                                str3 = str3.substring(27, lastIndexOf);
                            }
                        }
                        x.d("MicroMsg.SnsItemReportHelper", "report:%s", str3 + "," + i.er(j) + "," + i + "," + bi.Wx() + "," + blv.wVP + "," + blv.wVR + "," + blv.wVQ + "," + blv.wVM + "," + blv.wVL + "," + blv.wVO + "," + blv.wVN + "," + str2 + "," + blv.biF + "," + blv.rAl);
                        g.pWK.k(11985, str);
                    }
                }
            }
        }
    }
}
