package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.mm.c.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    public static String rkX = ".adxml.adArgs.arg";
    public String fDn = "";
    public String fqG;
    public int hQn;
    public String rjU;
    public int rkA = 0;
    public String rkB = "";
    public String rkC = "";
    public String rkD = "";
    public String rkE = "";
    public String rkF = "";
    public int rkG = 0;
    public String rkH = "";
    public String rkI = "";
    public int rkJ = 0;
    public String rkK = "";
    public int rkL = 0;
    public String rkM = "";
    public String rkN = "";
    public String rkO = "";
    public String rkP = "";
    public String rkQ = "";
    public String rkR = "";
    public int rkS;
    public int rkT;
    public int rkU;
    public long rkV;
    public Map<String, String> rkW = new HashMap();
    boolean rkY;
    public int rkZ;
    boolean rkd;
    public String rky;
    public int rkz = 0;
    public int rla;
    public float rlb;
    public float rlc;
    public int rld;
    public int rle;
    public int rlf;
    public String rlg;
    public float rlh;
    public float rli;
    public float rlj;
    public float rlk;
    public int rll;
    public String rlm;
    public String rln;
    public b rlo;
    private a rlp;
    public c rlq;

    public class a {
        public String rlr;
        public String rls;
    }

    public class d {
        public String lUJ = "";
        public String rlx = "";
        public String rly = "";
        public String rlz = "";
        public String title = "";
    }

    public static class e {
        public String desc;
        public int rlA = 0;
        public String title;
    }

    public static class b {
        public String bpe;
        public String foj;
        public String fwG;
        public String rjU = "";
        public List<e> rlu = new ArrayList();

        public final void q(Map<String, String> map, String str) {
            this.rjU = bi.aD((String) map.get(str + ".adxml.adTurnActionLink"), "");
            String str2 = (String) map.get(str + ".adxml.adTurnActionExtWeApp.appUserName");
            if (!TextUtils.isEmpty(str2)) {
                this.fwG = str2;
                this.bpe = (String) map.get(str + ".adxml.adTurnActionExtWeApp.appVersion");
                this.foj = (String) map.get(str + ".adxml.adTurnActionExtWeApp.relativePagePath");
            }
            String str3 = str + ".adxml.adTurnInfo.materialInfo";
            int i = 0;
            while (true) {
                String str4;
                if (i > 0) {
                    str4 = str3 + i;
                } else {
                    str4 = str3;
                }
                if (map.get(str4 + ".displayType") != null && ((String) map.get(str4 + ".displayType")).length() > 0) {
                    e eVar = new e();
                    eVar.title = bi.aD((String) map.get(str4 + ".title"), "");
                    eVar.desc = bi.aD((String) map.get(str4 + ".desc"), "");
                    eVar.rlA = bi.Wo((String) map.get(str4 + ".displayType"));
                    this.rlu.add(eVar);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public class c {
        public String rlv = "";
        public ArrayList<d> rlw = new ArrayList();

        public final String xl(int i) {
            if (i < 0 || i >= this.rlw.size()) {
                return "";
            }
            return ((d) this.rlw.get(i)).rlz;
        }

        public final String xm(int i) {
            if (i < 0 || i >= this.rlw.size()) {
                return "";
            }
            return ((d) this.rlw.get(i)).title;
        }
    }

    public b(String str) {
        if (bi.oN(str) || !str.trim().startsWith("<RecXml")) {
            X(str, "", "adxml");
            return;
        }
        Map X = X(str, ".RecXml", "RecXml");
        if (X != null && !X.isEmpty()) {
            this.rkS = bi.Wo((String) X.get(".RecXml.$type"));
            this.rkT = bi.Wo((String) X.get(".RecXml.$source"));
            this.rkU = bi.Wo((String) X.get(".RecXml.$expId"));
            this.rkV = i.lV((String) X.get(".RecXml.$expOriginSnsId"));
        }
    }

    private Map<String, String> X(String str, String str2, String str3) {
        int i = 0;
        if (bi.oN(str) || bi.oN(str3)) {
            return null;
        }
        this.fDn = str;
        x.i("MicroMsg.ADXml", "feed xml %s, keyPrefix %s, tag %s", str, str2, str3);
        Map<String, String> y = f.y(str, str3);
        if (y == null) {
            return null;
        }
        String str4;
        this.hQn = bi.Wo((String) y.get(str2 + ".adxml.adType"));
        this.rky = bi.aD((String) y.get(str2 + ".adxml.adActionTitle"), "");
        this.rjU = bi.aD((String) y.get(str2 + ".adxml.adActionLink"), "");
        this.fqG = bi.aD((String) y.get(str2 + ".adxml.nickname"), "");
        this.rkz = bi.Wo((String) y.get(str2 + ".adxml.webviewRightBarShow"));
        this.rkA = bi.Wo((String) y.get(str2 + ".adxml.adActionLinkHidden"));
        this.rkB = bi.aD((String) y.get(str2 + ".adxml.adActionLinkName"), "");
        this.rkC = bi.aD((String) y.get(str2 + ".adxml.adActionLinkIcon"), "");
        this.rkD = bi.aD((String) y.get(str2 + ".adxml.adActionLinkTitle.zh"), "");
        this.rkF = bi.aD((String) y.get(str2 + ".adxml.adActionLinkTitle.tw"), "");
        this.rkE = bi.aD((String) y.get(str2 + ".adxml.adActionLinkTitle.en"), "");
        this.rkH = bi.aD((String) y.get(str2 + ".adxml.attachShareLinkWording"), "");
        this.rkI = bi.aD((String) y.get(str2 + ".adxml.attachShareLinkUrl"), "");
        this.rkG = bi.Wo((String) y.get(str2 + ".adxml.attachShareLinkIsHidden"));
        if (bi.oN(this.rkH) || bi.oN(this.rkI)) {
            this.rkG = 1;
        }
        this.rkM = bi.aD((String) y.get(str2 + ".adxml.expandOutsideTitle.zh"), "");
        this.rkO = bi.aD((String) y.get(str2 + ".adxml.expandOutsideTitle.tw"), "");
        this.rkN = bi.aD((String) y.get(str2 + ".adxml.expandOutsideTitle.en"), "");
        this.rkP = bi.aD((String) y.get(str2 + ".adxml.expandInsideTitle.zh"), "");
        this.rkR = bi.aD((String) y.get(str2 + ".adxml.expandInsideTitle.tw"), "");
        this.rkQ = bi.aD((String) y.get(str2 + ".adxml.expandInsideTitle.en"), "");
        this.rkJ = bi.Wo((String) y.get(str2 + ".adxml.headClickType"));
        this.rkK = bi.aD((String) y.get(str2 + ".adxml.headClickParam"), "");
        this.rkL = bi.Wo((String) y.get(str2 + ".adxml.headClickRightBarShow"));
        int i2 = 0;
        while (true) {
            String str5 = str2 + rkX + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".key";
            String str6 = (String) y.get(str5);
            if (str6 == null) {
                break;
            }
            String str7 = str2 + rkX + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".value";
            str4 = (String) y.get(str7);
            x.i("MicroMsg.ADXml", "newKey " + str5 + " " + str6 + " newValue : " + str7 + " " + str4);
            this.rkW.put(str6, str4);
            i2++;
        }
        this.rkd = y.containsKey(str2 + ".adxml.adCanvasInfo");
        this.rkZ = bi.Wo((String) y.get(str2 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
        this.rla = bi.Wo((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
        this.rlb = (float) bi.Wq((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth"));
        this.rlc = (float) bi.Wq((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight"));
        this.rlf = bi.Wo((String) y.get(str2 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
        this.rlg = bi.aD((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
        this.rld = bi.Wo((String) y.get(str2 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
        this.rle = bi.Wo((String) y.get(str2 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
        this.rlh = (float) bi.Wq((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconWidth"));
        this.rli = (float) bi.Wq((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconHeight"));
        this.rlj = (float) bi.Wq((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight"));
        this.rlk = (float) bi.Wq((String) y.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom"));
        this.rll = bi.Wo((String) y.get(str2 + ".adxml.adContentStyle"));
        this.rlm = bi.aD((String) y.get(str2 + ".adxml.adCardInfo.title"), "");
        this.rln = bi.aD((String) y.get(str2 + ".adxml.adCardInfo.description"), "");
        Object aD = bi.aD((String) y.get(str2 + ".adxml.adSelectInfo.leftBtnTitle"), "");
        Object aD2 = bi.aD((String) y.get(str2 + ".adxml.adSelectInfo.rightBtnTitle"), "");
        if (!(TextUtils.isEmpty(aD) || TextUtils.isEmpty(aD2))) {
            this.rlp = new a();
            this.rlp.rlr = aD;
            this.rlp.rls = aD2;
        }
        aD2 = bi.aD((String) y.get(str2 + ".adxml.adVoteInfo.componentUrl"), "");
        if (!TextUtils.isEmpty(aD2)) {
            this.rlq = new c();
            this.rlq.rlv = aD2;
            String str8 = str2 + ".adxml.adVoteInfo.optionList.option";
            while (true) {
                if (i != 0) {
                    str4 = str8 + i;
                } else {
                    str4 = str8;
                }
                if (TextUtils.isEmpty(bi.aD((String) y.get(str4 + ".title"), ""))) {
                    break;
                }
                d dVar = new d();
                dVar.title = bi.aD((String) y.get(str4 + ".title"), "");
                dVar.lUJ = bi.aD((String) y.get(str4 + ".shareTitle"), "");
                dVar.rlx = bi.aD((String) y.get(str4 + ".shareDesc"), "");
                dVar.rly = bi.aD((String) y.get(str4 + ".shareThumb"), "");
                dVar.rlz = bi.aD((String) y.get(str4 + ".selectedTitle"), "");
                this.rlq.rlw.add(dVar);
                i++;
            }
        }
        this.rkY = y.containsKey(str2 + ".adxml.adTurnCanvasInfo");
        this.rlo = new b();
        this.rlo.q(y, str2);
        return y;
    }

    public final boolean bxd() {
        return this.rkd || this.rkY;
    }

    public final String bxe() {
        if (bxj()) {
            return this.rlp.rlr;
        }
        if (bxk()) {
            return ((d) this.rlq.rlw.get(0)).title;
        }
        return "";
    }

    public final String bxf() {
        if (bxj()) {
            return this.rlp.rls;
        }
        if (bxk()) {
            return ((d) this.rlq.rlw.get(1)).title;
        }
        return "";
    }

    public final String bxg() {
        if (bxk()) {
            return this.rlq.rlv;
        }
        return "";
    }

    public final boolean bxh() {
        return this.rll == 2;
    }

    public final boolean bxi() {
        return this.rll == 1;
    }

    public final boolean bxj() {
        return this.rlp != null;
    }

    public final boolean bxk() {
        return this.rlq != null && this.rlq.rlw.size() > 1;
    }

    public final String bxl() {
        String str = this.fDn;
        if (str.contains("<adCanvasInfoLeft>")) {
            return str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "").replaceAll("adCanvasInfoLeft", "adCanvasInfo");
        }
        return str;
    }

    public final String bxm() {
        String str = this.fDn;
        if (str.contains("<adCanvasInfoRight>")) {
            return str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("adCanvasInfoRight", "adCanvasInfo");
        }
        return str;
    }

    public final String bxn() {
        String str = this.fDn;
        if (str.contains("<adTurnCanvasInfo>")) {
            return str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adTurnCanvasInfo", "adCanvasInfo");
        }
        return str;
    }

    public final boolean bxo() {
        return this.rkT == 2;
    }
}
