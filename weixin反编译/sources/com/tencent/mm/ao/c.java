package com.tencent.mm.ao;

import android.text.TextUtils;
import com.tencent.mm.ac.h;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.f;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.ajs;
import com.tencent.mm.protocal.c.apf;
import com.tencent.mm.protocal.c.apg;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.g;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    private ArrayList<o> hAO;
    private int hAP;
    private int hAQ;
    private int hAR;
    private int hAS;
    private HashMap<String, o> hAT = new HashMap();
    private String hAU;

    public c(ArrayList<o> arrayList, int i, HashMap<String, o> hashMap, String str) {
        a aVar = new a();
        aVar.hnT = new apf();
        aVar.hnU = new apg();
        aVar.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
        aVar.hnS = 488;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.hAO = arrayList;
        this.hAP = i;
        this.hAQ = 0;
        this.hAS = 1;
        this.hAT = hashMap;
        this.hAU = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
        this.gLE = eVar2;
        apf apf = (apf) this.gLB.hnQ.hnY;
        if (this.hAO != null) {
            LinkedList linkedList = new LinkedList();
            this.hAR = this.hAO.size();
            int i = this.hAQ;
            while (true) {
                int i2 = i;
                if (i2 >= this.hAR || i2 >= this.hAQ + 500) {
                    apf.kyB = linkedList;
                    apf.kyA = linkedList.size();
                } else {
                    ajs ajs = new ajs();
                    ajs.vSF = ((o) this.hAO.get(i2)).field_googlegmail;
                    linkedList.add(ajs);
                    i = i2 + 1;
                }
            }
            apf.kyB = linkedList;
            apf.kyA = linkedList.size();
            if (this.hAQ + 500 > this.hAR) {
                this.hAS = 0;
            } else {
                this.hAS = 1;
            }
            apf.vWu = this.hAS;
            apf.wCK = this.hAP;
            x.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", Integer.valueOf(this.hAR), Integer.valueOf(this.hAQ), Integer.valueOf(this.hAS));
        }
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            a(Ph());
            if (this.hAS == 1) {
                this.hAQ += 500;
                if (a(this.hok, this.gLE) < 0) {
                    x.e("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene again failed");
                    this.gLE.a(3, -1, "", this);
                }
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final apg Ph() {
        return (apg) this.gLB.hnR.hnY;
    }

    private synchronized void a(apg apg) {
        x.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", Integer.valueOf(apg.kyA));
        if (apg.kyB != null && apg.kyB.size() > 0) {
            int size = apg.kyB.size();
            ArrayList arrayList = new ArrayList();
            List linkedList = new LinkedList();
            for (int i = 0; i < size; i++) {
                int i2;
                ajr ajr = (ajr) apg.kyB.get(i);
                if (TextUtils.isEmpty(ajr.kyG)) {
                    i2 = 1;
                } else {
                    as.Hm();
                    ag Xv = com.tencent.mm.y.c.Ff().Xv(ajr.kyG);
                    i2 = (Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type)) ? 0 : 2;
                }
                if (this.hAT != null && this.hAT.containsKey(ajr.vSF)) {
                    o oVar = (o) this.hAT.get(ajr.vSF);
                    oVar.field_username = ajr.kyG;
                    oVar.field_nickname = ajr.kzN;
                    oVar.field_usernamepy = com.tencent.mm.platformtools.c.oE(ajr.kzN);
                    oVar.field_nicknameqp = com.tencent.mm.platformtools.c.oD(ajr.kzN);
                    oVar.field_ret = ajr.vQL;
                    oVar.field_small_url = ajr.wxP;
                    oVar.field_big_url = ajr.wxO;
                    oVar.field_status = i2;
                    oVar.field_googlecgistatus = 2;
                    if (i2 == 2 || i2 == 0) {
                        oVar.field_contecttype = "weixin" + i;
                    } else {
                        oVar.field_contecttype = "google";
                    }
                    oVar.field_googlenamepy = com.tencent.mm.platformtools.c.oE(oVar.field_googlename);
                    arrayList.add(oVar);
                    Object obj = oVar.field_googleid;
                    String str = oVar.field_googlephotourl;
                    String str2 = this.hAU;
                    if (!(TextUtils.isEmpty(obj) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                        String str3 = obj + "@google";
                        h jp = n.JW().jp(str3);
                        if (jp == null) {
                            jp = new h();
                        }
                        jp.username = str3;
                        jp.fWZ = 3;
                        jp.hni = com.tencent.mm.ac.b.ab(str, str2);
                        jp.hnh = com.tencent.mm.ac.b.ab(str, str2);
                        jp.bC(true);
                        jp.fEo = 31;
                        n.JW().a(jp);
                    }
                    f aVar = new g.a();
                    aVar.field_userName = ajr.kyG;
                    aVar.field_scene = 58;
                    aVar.field_ticket = ajr.woW;
                    linkedList.add(aVar);
                }
            }
            af.OR().f(arrayList);
            as.Hm();
            com.tencent.mm.y.c.FP().cE(linkedList);
        }
    }

    public final int getType() {
        return 488;
    }

    protected final int Bo() {
        return 20;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }
}
