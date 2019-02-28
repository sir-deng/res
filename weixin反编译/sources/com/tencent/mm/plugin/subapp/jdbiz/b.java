package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.mm.pluginsdk.q.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.Map;

public final class b implements d {
    public String fEK = "";
    public long hSg = 0;
    public String iconUrl = "";
    public String jumpUrl = "";
    public String sbM = "";
    public String sbN = "";
    public boolean sbO = false;
    public boolean sbP = false;
    public String sbQ = "";
    public String sbR = "";
    public long sbS;
    public long sbT;
    public long sbU;
    public long sbV;
    public String sbW = "";
    public String sbX = "";
    public String sbY = "";
    public String sbZ = "";
    public long startTime;
    public String title = "";

    public static b bEq() {
        as.Hm();
        String str = (String) c.Db().get(327942, (Object) "");
        b bVar = new b();
        x.i("MicroMsg.JdMsgContent", " create xml : " + str);
        bVar.LA(str);
        return bVar;
    }

    public final void LA(String str) {
        this.sbM = "";
        this.sbN = "";
        this.hSg = 0;
        this.sbQ = "";
        this.sbO = false;
        this.sbP = false;
        this.sbX = "";
        this.sbY = "";
        this.sbZ = "";
        this.sbW = "";
        this.jumpUrl = "";
        this.fEK = "";
        this.fEK = str;
        if (!bi.oN(str)) {
            x.i("MicroMsg.JdMsgContent", "feed xml %s", str);
            Map y = bj.y(str, "sysmsg");
            if (y != null) {
                this.sbM = bi.aD((String) y.get(".sysmsg.biztype"), "");
                this.sbW = bi.aD((String) y.get(".sysmsg.alert"), "");
                this.sbN = bi.aD((String) y.get(".sysmsg.activityid"), "");
                this.startTime = bi.Wp((String) y.get(".sysmsg.starttime"));
                this.hSg = bi.Wp((String) y.get(".sysmsg.expiretime"));
                this.title = bi.aD((String) y.get(".sysmsg.content.title"), "");
                this.iconUrl = bi.aD((String) y.get(".sysmsg.content.icon"), "");
                this.jumpUrl = bi.aD((String) y.get(".sysmsg.content.jumpurl"), "");
                this.sbS = bi.Wp((String) y.get(".sysmsg.content.urlstarttime"));
                this.sbT = bi.Wp((String) y.get(".sysmsg.content.urlexpiretime"));
                this.sbQ = bi.aD((String) y.get(".sysmsg.content.jdcelltitle"), "");
                this.sbR = bi.aD((String) y.get(".sysmsg.content.jdcellicon"), "");
                this.sbU = bi.Wp((String) y.get(".sysmsg.content.titlestarttime"));
                this.sbV = bi.Wp((String) y.get(".sysmsg.content.titleexpiretime"));
                this.sbO = "1".equals(y.get(".sysmsg.content.findshowreddot"));
                this.sbP = "1".equals(y.get(".sysmsg.content.jdcellshowred"));
                this.sbX = bi.aD((String) y.get(".sysmsg.content.alertviewtitle"), "");
                this.sbY = bi.aD((String) y.get(".sysmsg.content.alertviewconfirm"), "");
                this.sbZ = bi.aD((String) y.get(".sysmsg.content.alertviewcancel"), "");
            }
        }
    }

    public final boolean agz() {
        return this.startTime < System.currentTimeMillis() / 1000;
    }

    public final boolean bEr() {
        return this.hSg != 0 && this.hSg < System.currentTimeMillis() / 1000;
    }

    public final boolean a(b bVar) {
        if (bVar != null && bi.aD(this.sbN, "").equals(bi.aD(bVar.sbN, ""))) {
            return false;
        }
        return true;
    }

    public final String bEs() {
        return bi.aD(this.fEK, "");
    }

    public final String bEt() {
        return this.sbN;
    }

    public final String bEu() {
        return this.sbQ;
    }

    public final boolean bEv() {
        return this.sbP;
    }

    public final String bEw() {
        return this.sbM;
    }

    public final String bEx() {
        return this.jumpUrl;
    }
}
