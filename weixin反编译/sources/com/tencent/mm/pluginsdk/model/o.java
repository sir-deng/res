package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.btz;
import com.tencent.mm.protocal.c.bub;
import com.tencent.mm.protocal.c.buc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class o extends k implements com.tencent.mm.network.k {
    public int fvG;
    public final b gLB;
    private e gLE;
    public String hAN;
    public List<String> vkg;
    public String vkh;
    private List<String> vki;

    private o(int i, String str, String str2, int i2) {
        this.vkg = null;
        this.fvG = 0;
        this.vki = null;
        Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
        this.vkg = new LinkedList();
        this.vkg.add(str);
        this.fvG = 3;
        a aVar = new a();
        aVar.hnT = new bub();
        aVar.hnU = new buc();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyuser";
        aVar.hnS = 137;
        aVar.hnV = 44;
        aVar.hnW = 1000000044;
        this.gLB = aVar.Kf();
        bub bub = (bub) this.gLB.hnQ.hnY;
        bub.vQC = 3;
        bub.wuV = "";
        LinkedList linkedList = new LinkedList();
        btz btz = new btz();
        btz.pWq = str;
        btz.xbB = str2;
        btz.woW = com.tencent.mm.plugin.d.a.Yf().FP().WX(str);
        btz.wRd = null;
        linkedList.add(btz);
        bub.xbI = linkedList;
        bub.xbH = linkedList.size();
        linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(i2));
        bub.xbK = linkedList;
        bub.xbJ = linkedList.size();
        bub.wCD = new bes().bl(d.oXY.bgp());
        x.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify scene:%d user:%d ticket:%s anti:%s", Integer.valueOf(bub.xbI.size()), Integer.valueOf(bub.xbK.size()), str2, btz.woW);
    }

    public o(int i, List<String> list, List<Integer> list2, List<String> list3, String str, String str2, Map<String, Integer> map, String str3, String str4) {
        List list32;
        int i2;
        int i3;
        int i4;
        this.vkg = null;
        this.fvG = 0;
        this.vki = null;
        Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", i != 3);
        this.fvG = i;
        this.vkg = list;
        if (list32 == null || list32.size() == 0) {
            list32 = new LinkedList();
        }
        a aVar = new a();
        aVar.hnT = new bub();
        aVar.hnU = new buc();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyuser";
        aVar.hnS = 137;
        aVar.hnV = 44;
        aVar.hnW = 1000000044;
        this.gLB = aVar.Kf();
        if (list32 != null && list32.size() > 0) {
            if (list32.size() == list.size()) {
                i2 = 0;
                while (true) {
                    i3 = i2;
                    if (i3 >= list32.size()) {
                        break;
                    }
                    com.tencent.mm.plugin.d.a.Yf().FP().y((String) list.get(i3), 2147483633, (String) list32.get(i3));
                    i2 = i3 + 1;
                }
            } else {
                x.e("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify Error lstAntispamTicket:%d lstVerifyUser:%d", Integer.valueOf(list32.size()), Integer.valueOf(list.size()));
            }
        }
        if (i == 2) {
            i2 = 0;
            while (true) {
                i4 = i2;
                if (i4 >= list.size()) {
                    break;
                }
                list32.add(bi.aD(com.tencent.mm.plugin.d.a.Yf().FP().WX((String) list.get(i4)), ""));
                i2 = i4 + 1;
            }
        }
        bub bub = (bub) this.gLB.hnQ.hnY;
        bub.vQC = i;
        bub.wuV = str;
        this.vkh = str;
        LinkedList linkedList = new LinkedList();
        i4 = 0;
        while (true) {
            i3 = i4;
            if (i3 < list.size()) {
                String str5;
                btz btz = new btz();
                btz.pWq = (String) list.get(i3);
                if (str2 == null) {
                    str5 = "";
                } else {
                    str5 = str2;
                }
                btz.xbB = str5;
                g FP = com.tencent.mm.plugin.d.a.Yf().FP();
                String str6 = btz.pWq;
                ((Integer) list2.get(i3)).intValue();
                btz.woW = bi.aD(FP.WX(str6), "");
                if (TextUtils.isEmpty(btz.woW) && list32 != null && list32.size() > i3) {
                    btz.woW = (String) list32.get(i3);
                }
                btz.wRd = str3;
                if (map != null) {
                    if (map.containsKey(btz.pWq)) {
                        btz.xbC = ((Integer) map.get(btz.pWq)).intValue();
                    }
                }
                btz.xbG = str4;
                x.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s", Integer.valueOf(this.fvG), Integer.valueOf(i3), btz.pWq, btz.woW, str3, str4);
                linkedList.add(btz);
                i4 = i3 + 1;
            } else {
                bub.xbI = linkedList;
                bub.xbH = linkedList.size();
                LinkedList linkedList2 = new LinkedList();
                linkedList2.addAll(list2);
                bub.xbK = linkedList2;
                bub.xbJ = linkedList2.size();
                bub.wCD = new bes().bl(d.oXY.bgp());
                x.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", Integer.valueOf(this.fvG), Integer.valueOf(bub.xbI.size()), Integer.valueOf(bub.xbK.size()), bi.d(list32, ","), str3, bi.chl());
                return;
            }
        }
    }

    public o(int i, List<String> list, List<Integer> list2, String str, String str2, Map<String, Integer> map, String str3) {
        this(2, list, list2, null, str, str2, map, str3, "");
    }

    public o(String str, String str2, int i) {
        this(3, str, str2, i);
    }

    public o(int i, List<String> list, List<Integer> list2, String str, String str2) {
        this(i, list, list2, null, str, str2, null, null, "");
    }

    public final void fj(String str, String str2) {
        Iterator it = ((bub) this.gLB.hnQ.hnY).xbI.iterator();
        while (it.hasNext()) {
            btz btz = (btz) it.next();
            btz.xbD = str;
            btz.xbE = str2;
        }
    }

    public final String bZf() {
        if (this.gLB == null || this.gLB.hnR == null) {
            return "";
        }
        return ((buc) this.gLB.hnR.hnY).kyG;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int bZg() {
        return this.fvG;
    }

    public final int getType() {
        return 30;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            x.e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.gLE.a(i2, i3, str, this);
    }
}
