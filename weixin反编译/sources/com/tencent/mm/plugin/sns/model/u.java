package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.blz;
import com.tencent.mm.protocal.c.bma;
import com.tencent.mm.protocal.c.bmb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u extends k implements com.tencent.mm.network.k {
    private String frM;
    private int fvo;
    private b gLB;
    public e gLE;
    public LinkedList<blz> raC = null;
    public int raD;

    public u(int i) {
        String str;
        this.fvo = i;
        a aVar = new a();
        aVar.hnT = new bma();
        aVar.hnU = new bmb();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
        aVar.hnS = JsApiSetAudioState.CTRL_INDEX;
        aVar.hnV = 116;
        aVar.hnW = 1000000116;
        this.gLB = aVar.Kf();
        String str2 = ae.bwj().LV("@__weixintsnstag").field_md5;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        this.frM = str;
        bma bma = (bma) this.gLB.hnQ.hnY;
        bma.vKI = i;
        bma.wVV = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return JsApiSetAudioState.CTRL_INDEX;
    }

    public static s a(s sVar, blz blz) {
        sVar.field_tagId = blz.wVU;
        sVar.field_tagName = bi.aD(blz.noE, "");
        sVar.field_count = blz.kyA;
        sVar.bU(blz.kyB);
        x.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + blz.toString());
        return sVar;
    }

    private static boolean a(List<Long> list, Long l) {
        for (Long longValue : list) {
            if (longValue.longValue() == l.longValue()) {
                return true;
            }
        }
        return false;
    }

    public final List<String> eC(long j) {
        List<String> linkedList = new LinkedList();
        if (this.raC == null) {
            return linkedList;
        }
        Iterator it = this.raC.iterator();
        while (it.hasNext()) {
            blz blz = (blz) it.next();
            if (blz.wVU == j) {
                it = blz.kyB.iterator();
                while (it.hasNext()) {
                    linkedList.add(((bet) it.next()).wRo);
                }
                return linkedList;
            }
        }
        return linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsTagList", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            bmb bmb = (bmb) ((b) qVar).hnR.hnY;
            x.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", Integer.valueOf(this.raD));
            this.raD = bmb.raD;
            this.raC = bmb.kyB;
            String str2 = bmb.wVV;
            if (this.frM.equals(str2)) {
                this.gLE.a(i2, i3, str, this);
                return;
            }
            List bzB = ae.bwl().bzB();
            if (this.fvo != 3) {
                Iterator it = bzB.iterator();
                while (it.hasNext()) {
                    Object obj;
                    Long l = (Long) it.next();
                    Iterator it2 = bmb.kyB.iterator();
                    while (it2.hasNext()) {
                        if (l.longValue() == ((blz) it2.next()).wVU) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        it.remove();
                        ae.bwl().eV(l.longValue());
                    }
                }
            }
            Iterator it3 = bmb.kyB.iterator();
            while (it3.hasNext()) {
                blz blz = (blz) it3.next();
                s eU;
                if (a(bzB, Long.valueOf(blz.wVU))) {
                    eU = ae.bwl().eU(blz.wVU);
                    if ((eU.field_tagName != null && !eU.field_tagName.equals(blz.noE)) || eU.field_count != blz.kyA || b(eU, blz)) {
                        a(eU, blz);
                        ae.bwl().a(eU);
                    }
                } else {
                    eU = new s();
                    a(eU, blz);
                    ae.bwl().a(eU);
                }
            }
            com.tencent.mm.plugin.sns.storage.k LV = ae.bwj().LV("@__weixintsnstag");
            LV.field_md5 = str2;
            ae.bwj().a(LV);
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }

    private static boolean b(s sVar, blz blz) {
        String[] split = sVar.field_memberList.split(",");
        Iterator it = blz.kyB.iterator();
        while (it.hasNext()) {
            boolean z;
            bet bet = (bet) it.next();
            for (String equals : split) {
                if (equals.equals(bet)) {
                    z = true;
                    continue;
                    break;
                }
            }
            z = false;
            continue;
            if (!z) {
                return true;
            }
        }
        return false;
    }
}
