package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.R;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.bjy;
import com.tencent.mm.protocal.c.cq;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.protocal.c.yu;
import com.tencent.mm.protocal.c.yv;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends c {
    private static int mKC = 7200;
    private String mac;
    private String ssid;

    protected final void aMC() {
        a aVar = new a();
        aVar.hnT = new yu();
        aVar.hnU = new yv();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
        aVar.hnS = 1726;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
    }

    public final int getType() {
        return 1726;
    }

    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        aMC();
        this.ssid = str;
        this.mac = str2;
        cq cqVar = new cq();
        cqVar.mac = str2;
        cqVar.ssid = str;
        yu yuVar = (yu) this.gLB.hnQ.hnY;
        yuVar.appId = str3;
        yuVar.mLc = str4;
        yuVar.mLd = str5;
        yuVar.mLe = str6;
        yuVar.fry = str7;
        yuVar.sign = str8;
        yuVar.wpM = cqVar;
    }

    protected final void b(int i, int i2, int i3, String str) {
        int i4;
        c cVar;
        c Bw = j.aMv().Bw(this.ssid);
        if (Bw == null) {
            Bw = new com.tencent.mm.plugin.freewifi.g.c();
            Bw.field_ssidmd5 = ac.VF(this.ssid);
            i4 = 1;
            cVar = Bw;
        } else {
            i4 = 0;
            cVar = Bw;
        }
        boolean b;
        if (i2 == 0 && i3 == 0) {
            yv yvVar = (yv) this.gLB.hnR.hnY;
            cVar.field_ssid = this.ssid;
            cVar.field_showUrl = yvVar.vKR;
            bjy bjy = yvVar.vKS;
            if (bjy != null) {
                x.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", bjy.wTQ, bjy.wTR, bjy.wTS);
                cVar.field_showWordCn = bjy.wTR;
                cVar.field_showWordEn = bjy.wTQ;
                cVar.field_showWordTw = bjy.wTS;
            } else {
                cVar.field_showWordCn = ad.getContext().getResources().getString(R.l.ekq);
                cVar.field_showWordEn = ad.getContext().getResources().getString(R.l.ekq);
                cVar.field_showWordTw = ad.getContext().getResources().getString(R.l.ekq);
            }
            cVar.field_action = yvVar.vKQ;
            cVar.field_verifyResult = 1;
            cVar.field_connectState = -1;
            if (yvVar.vLa <= 0) {
                yvVar.vLa = mKC;
            }
            cVar.field_expiredTime = bi.Wx() + ((long) yvVar.vLa);
            cVar.field_mac = this.mac;
            if (i4 != 0) {
                b = j.aMv().b(cVar);
                x.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", Boolean.valueOf(b));
            } else {
                b = j.aMv().c(cVar, new String[0]);
                x.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", Boolean.valueOf(b));
            }
            j.aMv().Bx(this.ssid);
            return;
        }
        x.e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", this.ssid);
        if (i4 == 0) {
            b = j.aMv().a(cVar, new String[0]);
            x.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", this.ssid, Boolean.valueOf(b));
        }
    }

    public final em aMJ() {
        return ((yv) this.gLB.hnR.hnY).mNm;
    }
}
