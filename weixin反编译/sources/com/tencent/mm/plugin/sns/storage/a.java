package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    public static int rjL = 0;
    public static int rjM = 1;
    public String fDn;
    public String iWv;
    public String rfQ;
    public int rjN;
    public long rjO;
    public long rjP;
    public int rjQ;
    public String rjR;
    public String rjS;
    public String rjT;
    public String rjU;
    public int rjV;
    public String rjW;
    public String rjX;
    public String rjY;
    public int rjZ;
    public String rka;
    public String rkb;
    public LinkedList<String> rkc;
    boolean rkd;
    public String rke;
    public String rkf;
    public String rkg;
    public HashMap<String, String> rkh;
    public a rki;
    public b rkj;
    public String rkk;
    public String rkl;
    public String rkm;
    public boolean rkn;
    public String rko;
    public boolean rkp;

    public static class a {
        public String bpe;
        public String foj;
        public String fwG;
    }

    public static class b {
        private List<a> rkq = new ArrayList();
        public Map<String, List<a>> rkr = new HashMap();

        public static class a {
            public static int rks = 101;
            public long qWN = 0;
            public String rkt = "";
            public String rku = "";
            public String rkv = "";
            public int rkw = 0;
            public long rkx = 0;

            public a(String str, String str2, String str3, int i) {
                this.rkt = str;
                this.rku = str2;
                this.rkv = str3;
                this.rkw = i;
            }
        }

        public final List<a> bxc() {
            Object obj;
            String eM = w.eM(ad.getContext());
            if ("zh_CN".equals(eM) || "zh_TW".equals(eM) || "zh_HK".equals(eM)) {
                String obj2 = eM;
            } else {
                obj2 = "en";
            }
            if (!this.rkr.containsKey(obj2)) {
                List arrayList = new ArrayList();
                for (a aVar : this.rkq) {
                    if ("zh_CN".equals(obj2) && !bi.oN(aVar.rkt)) {
                        arrayList.add(aVar);
                    } else if (("zh_TW".equals(obj2) || "zh_HK".equals(obj2)) && !bi.oN(aVar.rku)) {
                        arrayList.add(aVar);
                    } else if ("en".equals(obj2) && !bi.oN(aVar.rkv)) {
                        arrayList.add(aVar);
                    }
                }
                this.rkr.put(obj2, arrayList);
            }
            return (List) this.rkr.get(obj2);
        }

        public b(Map<String, String> map, String str) {
            String str2 = str + ".dislikeInfo.ReasonList";
            int i = 0;
            while (true) {
                String str3;
                int i2 = i;
                String str4 = str2 + ".Reason";
                if (i2 > 0) {
                    str3 = str4 + i2;
                } else {
                    str3 = str4;
                }
                if (map.get(str3 + ".ReasonId") != null) {
                    this.rkq.add(new a(bi.aD((String) map.get(str3 + ".Wording.zh"), ""), bi.aD((String) map.get(str3 + ".Wording.tw"), ""), bi.aD((String) map.get(str3 + ".Wording.en"), ""), bi.Wo((String) map.get(str3 + ".ReasonId"))));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final boolean bxb() {
        return this.rjQ == 4 && this.rki != null;
    }

    public a() {
        this.fDn = "";
        this.rfQ = "";
        this.rjQ = 0;
        this.rjR = "";
        this.rjS = "";
        this.rjT = "";
        this.rjU = "";
        this.rjV = 0;
        this.rjW = "";
        this.rjX = "";
        this.rjY = "";
        this.rjZ = rjL;
        this.rka = "";
        this.rkb = "";
        this.rkc = new LinkedList();
        this.rkg = "";
        this.rkj = new b();
        this.rkk = "";
        this.rkl = "";
        this.rkm = "";
        this.rkn = false;
        this.rko = "";
        this.rkp = false;
    }

    public a(String str) {
        this.fDn = "";
        this.rfQ = "";
        this.rjQ = 0;
        this.rjR = "";
        this.rjS = "";
        this.rjT = "";
        this.rjU = "";
        this.rjV = 0;
        this.rjW = "";
        this.rjX = "";
        this.rjY = "";
        this.rjZ = rjL;
        this.rka = "";
        this.rkb = "";
        this.rkc = new LinkedList();
        this.rkg = "";
        this.rkj = new b();
        this.rkk = "";
        this.rkl = "";
        this.rkm = "";
        this.rkn = false;
        this.rko = "";
        this.rkp = false;
        this.rkd = false;
        LA(str);
    }

    private void LA(String str) {
        boolean z = true;
        if (!bi.oN(str)) {
            x.i("MicroMsg.ADInfo", "feed xml %s", str);
            Map y = bj.y(str, "ADInfo");
            if (y != null) {
                this.iWv = bi.aD((String) y.get(".ADInfo.viewid"), "");
                if (y.get(".ADInfo.ad_sns_pos") != null) {
                    String aD;
                    boolean z2;
                    this.rjN = bi.Wo((String) y.get(".ADInfo.ad_sns_pos"));
                    this.rjO = bi.Wp((String) y.get(".ADInfo.noExposureExpireTime"));
                    this.rjP = bi.Wp((String) y.get(".ADInfo.exposureNoActionExpireTime"));
                    this.rfQ = bi.aD((String) y.get(".ADInfo.uxInfo"), "");
                    this.rjQ = bi.Wo((String) y.get(".ADInfo.adActionType"));
                    this.rjR = bi.aD((String) y.get(".ADInfo.adActionCardTitle"), "");
                    this.rjS = bi.aD((String) y.get(".ADInfo.adActionCardTpId"), "");
                    this.rjT = bi.aD((String) y.get(".ADInfo.adActionCardExt"), "");
                    this.rjU = bi.aD((String) y.get(".ADInfo.adActionLink"), "");
                    this.rjV = bi.Wo((String) y.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
                    this.rjW = bi.aD((String) y.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
                    this.rjX = bi.aD((String) y.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
                    this.rjY = bi.aD((String) y.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
                    String aD2 = bi.aD((String) y.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
                    this.rjZ = bi.Wo((String) y.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
                    this.rkb = bi.aD((String) y.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
                    if (this.rjZ == rjM) {
                        String aD3 = bi.aD((String) y.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
                        String str2 = ".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName";
                        this.rkc.clear();
                        int i = 0;
                        while (true) {
                            if (i == 0) {
                                aD = bi.aD((String) y.get(str2), "");
                            } else {
                                aD = bi.aD((String) y.get(str2 + i), "");
                            }
                            if (bi.oN(aD)) {
                                break;
                            }
                            this.rkc.add(aD);
                            i++;
                        }
                        z2 = aD3.indexOf("%s") >= 0;
                        i = aD3.indexOf("%");
                        int lastIndexOf = aD3.lastIndexOf("%");
                        if (!bi.oN(aD3) && z2 && i == lastIndexOf) {
                            this.rka = aD3;
                        } else {
                            this.rka = aD2;
                            this.rjZ = rjL;
                        }
                    } else {
                        this.rka = aD2;
                        this.rjZ = rjL;
                    }
                    this.rkd = y.containsKey(".ADInfo.adCanvasInfo");
                    this.rkf = (String) y.get(".ADInfo.session_data.aid");
                    this.rke = (String) y.get(".ADInfo.session_data.trace_id");
                    this.rkh = new HashMap();
                    aD2 = ".ADInfo.adCanvasExt.adCardItemList.cardItem";
                    int i2 = 0;
                    while (true) {
                        String str3;
                        if (i2 == 0) {
                            str3 = aD2;
                        } else {
                            str3 = aD2 + i2;
                        }
                        aD = (String) y.get(str3 + ".cardTpId");
                        str3 = (String) y.get(str3 + ".cardExt");
                        if (bi.oN(aD)) {
                            break;
                        }
                        this.rkh.put(aD, str3);
                        i2++;
                    }
                    Matcher matcher = Pattern.compile("<adCanvasExt>[\\s\\S]*</adCanvasExt>").matcher(str);
                    if (matcher.find()) {
                        aD = matcher.group();
                        if (!bi.oN(aD)) {
                            this.rkg = aD.replaceAll("</?adCanvasExt>", "");
                        }
                    }
                    aD = (String) y.get(".ADInfo.adActionExt.adActionExtWeApp.appUserName");
                    if (!TextUtils.isEmpty(aD)) {
                        this.rki = new a();
                        this.rki.fwG = aD;
                        this.rki.bpe = (String) y.get(".ADInfo.adActionExt.adActionExtWeApp.appVersion");
                        this.rki.foj = (String) y.get(".ADInfo.adActionExt.adActionExtWeApp.relativePagePath");
                    }
                    this.rkj = new b(y, ".ADInfo");
                    this.rkk = bi.aD((String) y.get(".ADInfo.dislikeInfo.Title.zh"), "");
                    this.rkm = bi.aD((String) y.get(".ADInfo.dislikeInfo.Title.tw"), "");
                    this.rkl = bi.aD((String) y.get(".ADInfo.dislikeInfo.Title.en"), "");
                    if (bi.Wo((String) y.get(".ADInfo.dislikeInfo.forbidClick")) > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.rkn = z2;
                    this.rko = bi.aD((String) y.get(".ADInfo.adInfoSyncBuffer"), "");
                    if (bi.Wo((String) y.get(".ADInfo.adInfoSyncBuffer.$imm")) != 1) {
                        z = false;
                    }
                    this.rkp = z;
                }
            }
        }
    }
}
