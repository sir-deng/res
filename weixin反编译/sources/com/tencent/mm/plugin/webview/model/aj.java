package com.tencent.mm.plugin.webview.model;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class aj {
    private static int ndJ = 0;
    private static int tzq = 0;
    public m tzd;
    public k tze;
    public l tzf;
    public j tzg;
    public f tzh;
    public b tzi;
    public g tzj;
    public d tzk;
    private e tzl;
    private i tzm;
    private h tzn;
    private c tzo;
    public a tzp;

    public class a {
        public Bundle mym = null;

        public a(Bundle bundle) {
            this.mym = bundle;
        }

        public final void putValue(String str, Object obj) {
            if (this.mym == null) {
                return;
            }
            if (obj instanceof String) {
                this.mym.putString(str, (String) obj);
            } else if (obj instanceof Boolean) {
                this.mym.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                this.mym.putInt(str, ((Integer) obj).intValue());
            } else {
                x.w("MicroMsg.WebviewReporter", "put unknow type value.");
            }
        }
    }

    public static class b {
        public String fJB;
        public boolean tzs = false;
        public boolean tzt = false;
    }

    public static class d {
        public Object[] tzv = null;

        public final void c(com.tencent.mm.plugin.webview.stub.d dVar) {
            if (dVar != null) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11577, this.tzv);
            }
        }
    }

    public class f {
        public int fNt;
        public boolean kLT = false;
        public long startTime = bi.Wy();
        public String tzz;
        public String url;
    }

    public class k {
        public int fNt;
        public HashMap<String, Long> tzK = new HashMap();
        public String tzz;

        public final void aO(String str, boolean z) {
            if (bi.oN(str)) {
                x.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
            } else if (!this.tzK.containsKey(str)) {
            } else {
                if (z) {
                    this.tzK.put(str, Long.valueOf(bi.Wy() - ((Long) this.tzK.get(str)).longValue()));
                    return;
                }
                this.tzK.put(str, Long.valueOf(-1));
            }
        }

        public final void c(com.tencent.mm.plugin.webview.stub.d dVar) {
            if (dVar != null) {
                int bRH = aj.bRH();
                for (Entry entry : this.tzK.entrySet()) {
                    String str = (String) entry.getKey();
                    long longValue = ((Long) entry.getValue()).longValue();
                    com.tencent.mm.plugin.report.service.g.pWK.a(32, 2, 1, true);
                    if (longValue == -1) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(32, 13, 1, true);
                        x.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", str, Integer.valueOf(bRH));
                    }
                    if (longValue >= 0 && longValue <= 60000) {
                        String str2 = this.tzz;
                        Object[] objArr = new Object[11];
                        objArr[0] = Integer.valueOf(2);
                        objArr[1] = Long.valueOf(longValue);
                        objArr[2] = Integer.valueOf(bRH);
                        objArr[3] = str == null ? str : str.replace(",", "!");
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(aj.ndJ);
                        objArr[8] = Integer.valueOf(aj.tzq);
                        objArr[9] = Integer.valueOf(this.fNt);
                        objArr[10] = this.tzz;
                        aj.a(dVar, str2, objArr);
                        x.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", str, Long.valueOf(longValue), Integer.valueOf(bRH), Integer.valueOf(this.fNt), this.tzz);
                        com.tencent.mm.plugin.report.service.g.pWK.a(32, 6, longValue, true);
                    }
                }
            }
        }
    }

    public class l {
        public int fNt;
        public HashMap<String, Long> tzL = new HashMap();
        public String tzz;
    }

    public class m {
        public int fNt;
        public boolean ftC = true;
        public long jNF;
        public String tzz;
        public String url;
    }

    public static class c {
        public boolean muv = false;
        public boolean tzu = false;
    }

    public static class h {
        public List<String> tzA;
    }

    public static class i {
        public List<String> tzA;
    }

    public static class j {
        public String appId;
        public String fJB;
        long gAW = (System.currentTimeMillis() / 1000);
        public String gkM;
        public long jNM;
        public String ncP;
        public String rzD;
        public int scene;
        public String title;
        public String tzB;
        public String tzC;
        public long tzD;
        public int tzE;
        public String tzF;
        public String tzG;
        public String tzH;
        public int tzI;
        public long tzJ = -1;
        public String username;
    }

    public class e {
        public int fNt;
        public String jOH = "";
        public HashMap<String, Long> tzw = new HashMap();
        public HashMap<String, Long> tzx = new HashMap();
        public boolean tzy = true;
        public String tzz;

        public final void c(com.tencent.mm.plugin.webview.stub.d dVar) {
            if (dVar != null) {
                String str;
                long longValue;
                String str2;
                Object[] objArr;
                int bRH = aj.bRH();
                for (Entry entry : this.tzw.entrySet()) {
                    str = (String) entry.getKey();
                    longValue = ((Long) entry.getValue()).longValue();
                    if (longValue >= 0 && longValue <= 180000) {
                        str2 = this.tzz;
                        objArr = new Object[11];
                        objArr[0] = Integer.valueOf(5);
                        objArr[1] = Long.valueOf(longValue);
                        objArr[2] = Integer.valueOf(bRH);
                        if (str != null) {
                            str = str.replace(",", "!");
                        }
                        objArr[3] = str;
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(aj.ndJ);
                        objArr[8] = Integer.valueOf(aj.tzq);
                        objArr[9] = Integer.valueOf(this.fNt);
                        objArr[10] = this.tzz;
                        aj.a(dVar, str2, objArr);
                        if (aj.ndJ == 1) {
                            com.tencent.mm.plugin.report.service.g.pWK.a(32, 18, 1, true);
                            com.tencent.mm.plugin.report.service.g.pWK.a(32, 19, longValue, true);
                        }
                        com.tencent.mm.plugin.report.service.g.pWK.a(32, 8, 1, true);
                        com.tencent.mm.plugin.report.service.g.pWK.a(32, 9, longValue, true);
                        x.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", Long.valueOf(longValue), Integer.valueOf(bRH), Integer.valueOf(aj.ndJ), Integer.valueOf(aj.tzq), Integer.valueOf(this.fNt), this.tzz);
                    } else {
                        return;
                    }
                }
                for (Entry entry2 : this.tzx.entrySet()) {
                    str = (String) entry2.getKey();
                    longValue = ((Long) entry2.getValue()).longValue();
                    if (longValue >= 0 && longValue <= 180000) {
                        str2 = this.tzz;
                        objArr = new Object[11];
                        objArr[0] = Integer.valueOf(6);
                        objArr[1] = Long.valueOf(longValue);
                        objArr[2] = Integer.valueOf(bRH);
                        if (str != null) {
                            str = str.replace(",", "!");
                        }
                        objArr[3] = str;
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(aj.ndJ);
                        objArr[8] = Integer.valueOf(aj.tzq);
                        objArr[9] = Integer.valueOf(this.fNt);
                        objArr[10] = this.tzz;
                        aj.a(dVar, str2, objArr);
                        if (aj.ndJ == 1) {
                            com.tencent.mm.plugin.report.service.g.pWK.a(32, 20, 1, true);
                            com.tencent.mm.plugin.report.service.g.pWK.a(32, 21, longValue, true);
                        }
                        com.tencent.mm.plugin.report.service.g.pWK.a(32, 10, 1, true);
                        com.tencent.mm.plugin.report.service.g.pWK.a(32, 11, longValue, true);
                        x.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", Long.valueOf(longValue), Integer.valueOf(bRH), Integer.valueOf(aj.ndJ), Integer.valueOf(aj.tzq), Integer.valueOf(this.fNt), this.tzz);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static class g {
        public Object[] tzv = null;

        public final void c(com.tencent.mm.plugin.webview.stub.d dVar) {
            if (dVar != null) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11576, this.tzv);
            }
        }
    }

    public static /* synthetic */ void a(com.tencent.mm.plugin.webview.stub.d dVar, String str, Object[] objArr) {
        if (dVar != null) {
            com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11215, objArr);
            if (str != null && str.startsWith("official_mall")) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 14919, objArr);
            }
        }
    }

    public static int bRH() {
        switch (ao.getNetType(ad.getContext())) {
            case -1:
                return 255;
            case 0:
                return 1;
            case 1:
            case 6:
            case 8:
                return 3;
            case 2:
            case 5:
            case 7:
                return 2;
            case 3:
            case 4:
                return 4;
            case 10:
                return 5;
            default:
                return 6;
        }
    }

    public static String bRI() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ad.getContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return "no";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        x.d("MicroMsg.WebviewReporter", "activeNetInfo extra=%s, type=%d, %s", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo());
        if (activeNetworkInfo.getExtraInfo() != null) {
            return activeNetworkInfo.getExtraInfo().toLowerCase();
        }
        return "no";
    }

    public final m bRJ() {
        if (this.tzd == null) {
            this.tzd = new m();
        }
        return this.tzd;
    }

    public final k bRK() {
        if (this.tze == null) {
            this.tze = new k();
        }
        return this.tze;
    }

    public final l bRL() {
        if (this.tzf == null) {
            this.tzf = new l();
        }
        return this.tzf;
    }

    public final e bRM() {
        if (this.tzl == null) {
            this.tzl = new e();
        }
        return this.tzl;
    }

    public final j bRN() {
        if (this.tzg == null) {
            this.tzg = new j();
        }
        return this.tzg;
    }

    public final f bRO() {
        if (this.tzh == null) {
            this.tzh = new f();
        }
        return this.tzh;
    }

    public final b bRP() {
        if (this.tzi == null) {
            this.tzi = new b();
        }
        return this.tzi;
    }

    public final g bRQ() {
        if (this.tzj == null) {
            this.tzj = new g();
        }
        return this.tzj;
    }

    public final d bRR() {
        if (this.tzk == null) {
            this.tzk = new d();
        }
        return this.tzk;
    }

    public final i bRS() {
        if (this.tzm == null) {
            this.tzm = new i();
        }
        return this.tzm;
    }

    public final h bRT() {
        if (this.tzn == null) {
            this.tzn = new h();
        }
        return this.tzn;
    }

    public final c bRU() {
        if (this.tzo == null) {
            this.tzo = new c();
        }
        return this.tzo;
    }

    public final void t(String str, Object obj) {
        if (this.tzp != null) {
            try {
                this.tzp.putValue(str, obj);
            } catch (Exception e) {
            }
        }
    }

    public final void Pa(String str) {
        if (this.tzp != null) {
            try {
                a aVar = this.tzp;
                if (aVar.mym.containsKey(str)) {
                    try {
                        aVar.putValue(str, Integer.valueOf(aVar.mym.getInt(str) + 1));
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                aVar.putValue(str, Integer.valueOf(1));
            } catch (Exception e2) {
            }
        }
    }

    public static void H(boolean z, boolean z2) {
        if (z) {
            ndJ = 1;
        } else {
            ndJ = 0;
        }
        if (z2) {
            tzq = 1;
        } else {
            tzq = 0;
        }
    }

    public final void c(com.tencent.mm.plugin.webview.stub.d dVar) {
        String str;
        l bRL = bRL();
        if (dVar != null) {
            int bRH = bRH();
            for (Entry entry : bRL.tzL.entrySet()) {
                String str2 = (String) entry.getKey();
                long longValue = ((Long) entry.getValue()).longValue();
                com.tencent.mm.plugin.report.service.g.pWK.a(32, 0, 1, true);
                if (longValue >= 0 && longValue <= 180000) {
                    str = bRL.tzz;
                    Object[] objArr = new Object[11];
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(bRH);
                    objArr[3] = str2 == null ? str2 : str2.replace(",", "!");
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(ndJ);
                    objArr[8] = Integer.valueOf(tzq);
                    objArr[9] = Integer.valueOf(bRL.fNt);
                    objArr[10] = bRL.tzz;
                    a(dVar, str, objArr);
                    com.tencent.mm.plugin.report.service.g.pWK.a(160, 0, 1, false);
                    if (-1 != com.tencent.mm.plugin.webview.ui.tools.a.fk(longValue)) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(160, (long) com.tencent.mm.plugin.webview.ui.tools.a.fk(longValue), 1, false);
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.a(32, 3, 1, true);
                    com.tencent.mm.plugin.report.service.g.pWK.a(32, 7, longValue, true);
                    if (tzq == 1) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(32, 16, 1, true);
                        com.tencent.mm.plugin.report.service.g.pWK.a(32, 17, longValue, true);
                    }
                    x.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", str2, Long.valueOf(longValue), Integer.valueOf(bRH), Integer.valueOf(ndJ), Integer.valueOf(tzq), Integer.valueOf(bRL.fNt), bRL.tzz);
                }
            }
        }
        j bRN = bRN();
        if (!bi.oN(bRN.tzC)) {
            x.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", bRN.tzC);
        }
        if (dVar != null) {
            Object obj;
            String str3 = "";
            try {
                Bundle e = dVar.e(23, new Bundle(0));
                if (e != null) {
                    str3 = e.getString("config_info_username");
                }
                obj = str3;
            } catch (RemoteException e2) {
                x.w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", e2);
                str = str3;
            }
            PString pString = new PString();
            x.d("MicroMsg.WebviewReporter", "report 10643(%s), username : %s, msgId : %s, msgIndex : %s, scene : %s, enterTime : %s, stayTime : %s, rawUrl : %s, publisher : %s, viewId : %s, publishId : %s,appId : %s, newMsgId : %s, preUsername : %s, curUsername : %s, referUrl : %s, statExtStr:%s(%s), chatType:%d, title:%s, expidstr[chatting_exp]:%s, sourceAppId:%s, allStayTime %d", Integer.valueOf(10643), bRN.username, Long.valueOf(bRN.tzD), Integer.valueOf(bRN.tzE), Integer.valueOf(bRN.scene), Long.valueOf(bRN.gAW), Long.valueOf(bRN.jNM), bRN.fJB, bRN.tzB, bRN.tzC, bRN.ncP, bRN.appId, bRN.tzF, bRN.tzG, obj, bRN.tzH, bRN.rzD, ((com.tencent.mm.plugin.sns.b.i) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sns.b.i.class)).a(bRN.rzD, pString), Integer.valueOf(bRN.tzI), bRN.title, bRN.gkM, pString.value, Long.valueOf(System.currentTimeMillis() - bRN.gAW));
            str3 = bRN.title;
            try {
                str3 = URLEncoder.encode(bRN.title, "UTF-8");
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.WebviewReporter", e3, "", new Object[0]);
            }
            Object[] objArr2 = new Object[21];
            objArr2[0] = bRN.username;
            objArr2[1] = Long.valueOf(bRN.tzD);
            objArr2[2] = Integer.valueOf(bRN.tzE);
            objArr2[3] = Integer.valueOf(bRN.scene);
            objArr2[4] = Long.valueOf(bRN.gAW);
            objArr2[5] = Long.valueOf(bRN.jNM);
            objArr2[6] = bRN.fJB == null ? bRN.fJB : bRN.fJB.replace(",", "!");
            objArr2[7] = bRN.tzB;
            objArr2[8] = bRN.tzC;
            objArr2[9] = bRN.ncP;
            objArr2[10] = bRN.appId;
            objArr2[11] = bRN.tzF;
            objArr2[12] = bRN.tzG;
            objArr2[13] = obj;
            objArr2[14] = bRN.tzH == null ? bRN.tzH : bRN.tzH.replace(",", "!");
            objArr2[15] = r7;
            objArr2[16] = Integer.valueOf(bRN.tzI);
            objArr2[17] = str3;
            objArr2[18] = bRN.gkM;
            objArr2[19] = pString.value;
            objArr2[20] = Long.valueOf(System.currentTimeMillis() - bRN.gAW);
            com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 10643, objArr2);
        }
        bRK().c(dVar);
        bRM().c(dVar);
        b bRP = bRP();
        if (dVar != null) {
            int bRH2 = bRH();
            if (!bRP.tzt) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, bRP.fJB, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(bRH2));
            } else if (bRP.tzs) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, bRP.fJB, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(bRH2));
            } else {
                com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11575, bRP.fJB, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(bRH2));
            }
        }
    }
}
