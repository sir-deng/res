package com.tencent.mm.modelsimple;

import android.net.Uri;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc;
import com.tencent.mm.protocal.c.akw;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.ik;
import com.tencent.mm.protocal.c.xp;
import com.tencent.mm.protocal.c.xq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class l extends k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gLE;
    public Object tag;

    static class a {

        public enum a {
            AutoRoute,
            GetA8Key,
            MpGetA8Key,
            PayGetA8Key,
            MinorGetA8Key,
            ThridGetA8Key
        }

        static b a(a aVar) {
            com.tencent.mm.ad.b.a aVar2 = new com.tencent.mm.ad.b.a();
            aVar2.hnT = new xp();
            aVar2.hnU = new xq();
            switch (aVar) {
                case GetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/geta8key";
                    aVar2.hnS = 233;
                    aVar2.hnV = 155;
                    aVar2.hnW = 1000000155;
                    break;
                case MpGetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
                    aVar2.hnS = bc.CTRL_BYTE;
                    aVar2.hnV = 345;
                    aVar2.hnW = 1000000345;
                    break;
                case PayGetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
                    aVar2.hnS = 835;
                    aVar2.hnV = d.CTRL_INDEX;
                    aVar2.hnW = 1000000346;
                    break;
                case MinorGetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/minor-geta8key";
                    aVar2.hnS = 812;
                    aVar2.hnV = 387;
                    aVar2.hnW = 1000000387;
                    break;
                case ThridGetA8Key:
                    aVar2.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
                    aVar2.hnS = com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX;
                    aVar2.hnV = bb.CTRL_INDEX;
                    aVar2.hnW = 1000000388;
                    break;
                default:
                    aVar2.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
                    aVar2.hnS = com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX;
                    aVar2.hnV = bb.CTRL_INDEX;
                    aVar2.hnW = 1000000388;
                    break;
            }
            return aVar2.Kf();
        }

        static a R(String str, int i) {
            if (i == 5) {
                return a.MinorGetA8Key;
            }
            if (bi.oN(str)) {
                x.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
                return a.GetA8Key;
            }
            try {
                Uri parse = Uri.parse(str);
                if (parse == null) {
                    return a.ThridGetA8Key;
                }
                String toLowerCase = bi.oM(parse.getHost()).toLowerCase();
                x.d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", toLowerCase, bi.oN(parse.getFragment()) ? "" : "#" + parse.getFragment());
                if (toLowerCase.equals("open.weixin.qq.com") || toLowerCase.equals("mp.weixin.qq.com") || toLowerCase.equals("mp.weixinbridge.com")) {
                    return a.MpGetA8Key;
                }
                if (r0.contains("wechat_pay")) {
                    return a.PayGetA8Key;
                }
                if (toLowerCase.contains(".qq.com") || toLowerCase.equals("qq.com") || toLowerCase.contains(".wechat.com") || toLowerCase.equals("wechat.com") || toLowerCase.contains(".tenpay.com") || toLowerCase.equals("tenpay.com") || toLowerCase.contains(".url.cn") || toLowerCase.equals("url.com") || (!str.startsWith("http://") && !str.startsWith("https://"))) {
                    return a.GetA8Key;
                }
                return a.ThridGetA8Key;
            } catch (Exception e) {
                x.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", e.getMessage());
                return a.GetA8Key;
            }
        }

        static b b(b bVar) {
            xp xpVar = (xp) bVar.hnQ.hnY;
            g.Dr();
            String oM = bi.oM((String) g.Dq().Db().get(46, null));
            xpVar.vPZ = new bes().bl(bi.Wj(oM));
            g.Dr();
            String oM2 = bi.oM((String) g.Dq().Db().get(72, null));
            xpVar.woH = new bes().bl(bi.Wj(oM2));
            x.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + oM + " newa2=" + oM2);
            return bVar;
        }
    }

    private l() {
        this.gLB = a.b(a.a(a.GetA8Key));
    }

    private l(String str, int i) {
        a aVar = a.AutoRoute;
        if (aVar == a.AutoRoute) {
            aVar = a.R(str, i);
        }
        x.i("MicroMsg.NetSceneGetA8Key", "getCommReqRespFromReqUrl reqUrl=%s, type=%s, reason=%d", str, aVar, Integer.valueOf(i));
        this.gLB = a.b(a.a(aVar));
    }

    private l(a aVar) {
        this.gLB = a.a(aVar);
    }

    public l(String str, String str2, String str3, int i) {
        this(a.MpGetA8Key);
        xp xpVar = (xp) this.gLB.hnQ.hnY;
        xpVar.vKI = 1;
        xpVar.woA = new bet().Vf(str);
        xpVar.woB = new bet().Vf(str2);
        xpVar.woC = new bet().Vf(str3);
        xpVar.woL = i;
        x.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=%s requestId=%d", str, Integer.valueOf(i));
    }

    public l(String str, String str2, int i, int i2, byte[] bArr) {
        this(str, 0);
        xp xpVar = (xp) this.gLB.hnQ.hnY;
        xpVar.vKI = 2;
        xpVar.woD = new bet().Vf(str);
        xpVar.sfa = i;
        xpVar.kyG = str2;
        xpVar.woI = 0;
        xpVar.woL = i2;
        xpVar.woO = new bes().bl(bArr);
        x.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + str2 + ", scene = " + i + ", reason = 0, requestId = " + i2);
        x.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", bi.bA(bArr));
    }

    public l(String str, int i, int i2, int i3, String str2, int i4, byte[] bArr) {
        this(str, 0);
        xp xpVar = (xp) this.gLB.hnQ.hnY;
        xpVar.vKI = 2;
        xpVar.woD = new bet().Vf(str);
        xpVar.sfa = i;
        xpVar.kyG = null;
        xpVar.woI = 0;
        xpVar.wcr = i2;
        xpVar.wcs = i3;
        xpVar.woL = i4;
        xpVar.woA = new bet().Vf(str2);
        xpVar.woO = new bes().bl(bArr);
        x.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + null + ", scene = " + i + ", reason = 0, codeType = " + i2 + ", codeVersion = " + i3 + ", requestId = " + i4);
        x.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie = %s", bi.bA(bArr));
    }

    public l(String str, String str2, int i, int i2, int i3, String str3, int i4, String str4, String str5, int i5, byte[] bArr) {
        this(str, i2);
        xp xpVar = (xp) this.gLB.hnQ.hnY;
        xpVar.vKI = 2;
        xpVar.woD = new bet().Vf(str);
        xpVar.sfa = i;
        xpVar.kyG = str2;
        xpVar.woI = i2;
        xpVar.vNC = i3;
        xpVar.woK = str3;
        xpVar.woL = i4;
        xpVar.woM = str5;
        xpVar.woN = i5;
        xpVar.woA = new bet().Vf(str4);
        xpVar.woO = new bes().bl(bArr);
        x.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str3, Integer.valueOf(i4), str4, str5, Integer.valueOf(i5), bi.bA(bArr));
    }

    public l(int i, int i2) {
        this();
        xp xpVar = (xp) this.gLB.hnQ.hnY;
        xpVar.vKI = 3;
        xpVar.sfa = 5;
        xpVar.woF = i;
        xpVar.woL = i2;
        x.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d requestId", Integer.valueOf(i), Integer.valueOf(xpVar.vPZ.wRk), Integer.valueOf(i2));
    }

    public final int getType() {
        return 233;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", Integer.valueOf(i2), Integer.valueOf(i3), RL(), ((xq) this.gLB.hnR.hnY).woQ);
        x.d("MicroMsg.NetSceneGetA8Key", "a8KeyCookie:%s", bi.bA(RU()));
        this.gLE.a(i2, i3, str, this);
    }

    public final String RL() {
        return ((xq) this.gLB.hnR.hnY).woP;
    }

    public final String RM() {
        bet bet = ((xp) this.gLB.hnQ.hnY).woD;
        if (bet != null) {
            return bet.wRo;
        }
        return null;
    }

    public final String getTitle() {
        return ((xq) this.gLB.hnR.hnY).fpg;
    }

    public final String wl() {
        return ((xq) this.gLB.hnR.hnY).noL;
    }

    public final int RN() {
        return ((xq) this.gLB.hnR.hnY).vKQ;
    }

    public final byte[] RO() {
        xq xqVar = (xq) this.gLB.hnR.hnY;
        if (xqVar.woY == null) {
            return null;
        }
        try {
            return n.a(xqVar.woY);
        } catch (Exception e) {
            return null;
        }
    }

    public final String RP() {
        return ((xq) this.gLB.hnR.hnY).woT;
    }

    public final ArrayList<byte[]> RQ() {
        xq xqVar = (xq) this.gLB.hnR.hnY;
        ArrayList<byte[]> arrayList = new ArrayList();
        if (xqVar == null || xqVar.woV == null) {
            return arrayList;
        }
        Iterator it = xqVar.woV.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(((ik) it.next()).toByteArray());
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneGetA8Key", "exception:%s", bi.i(e));
            }
        }
        x.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    public final long RR() {
        xq xqVar = (xq) this.gLB.hnR.hnY;
        return xqVar.woX != null ? xqVar.woX.wfL : -1;
    }

    public final List<akw> RS() {
        return ((xq) this.gLB.hnR.hnY).wpa;
    }

    public final int RT() {
        return ((xp) this.gLB.hnQ.hnY).woL;
    }

    public final byte[] RU() {
        xq xqVar = (xq) this.gLB.hnR.hnY;
        if (xqVar.woO == null) {
            return new byte[0];
        }
        try {
            return n.a(xqVar.woO);
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
