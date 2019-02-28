package com.tencent.mm.plugin.product.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.product.ui.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.anz;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.azc;
import com.tencent.mm.protocal.c.bcn;
import com.tencent.mm.protocal.c.bex;
import com.tencent.mm.protocal.c.bke;
import com.tencent.mm.protocal.c.ce;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.protocal.c.tr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.x.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class c {
    public int mCount = 1;
    public String pjA;
    public String pjB;
    public int pjC;
    public Map<String, e> pjD;
    public Map<String, String> pjE = new HashMap();
    public LinkedList<tr> pjF;
    public LinkedList<at> pjG;
    public e pjH;
    private e pjI;
    public Map<String, LinkedList<rl>> pjJ = null;
    private d pjr = null;
    public m pjs;
    public List<n> pjt;
    public String pju;
    public String pjv;
    public String pjw;
    public tr pjx;
    public ce pjy;
    public bcn pjz;

    public final void clear() {
        this.pjs = null;
        if (this.pjt != null) {
            this.pjt.clear();
            this.pjt = null;
        }
        this.pju = null;
        this.pjv = null;
        this.mCount = 1;
        this.pjw = null;
        this.pjx = null;
        this.pjz = null;
        this.pjA = null;
        this.pjC = 0;
        this.pjH = null;
        if (this.pjD != null) {
            this.pjD.clear();
            this.pjD = null;
        }
        if (this.pjE != null) {
            this.pjE.clear();
        }
        if (this.pjF != null) {
            this.pjF.clear();
            this.pjF = null;
        }
        if (this.pjJ != null) {
            this.pjJ.clear();
            this.pjJ = null;
        }
    }

    public final void a(m mVar, List<n> list) {
        int i;
        int i2 = 0;
        clear();
        this.pjs = mVar;
        this.pjt = list;
        if (bi.oN(this.pjs.pka)) {
            this.pjs.pka = this.pjv;
        }
        LinkedList linkedList = this.pjs.pjY;
        this.pjD = new HashMap();
        if (linkedList != null && linkedList.size() > 0) {
            int size = linkedList.size();
            for (int i3 = 0; i3 < size; i3++) {
                l lVar = (l) linkedList.get(i3);
                a(lVar.pkA.split(";"), lVar);
            }
            bjK();
        }
        if (!(this.pjs.pjW == null || this.pjs.pjW.pkr == null)) {
            this.pjC = this.pjs.pjW.pkr.size();
        }
        if (!(this.pjs.pjW == null || this.pjs.pjW.pkk == null || this.pjs.pjW.pkk.size() <= 0)) {
            this.pjA = (String) this.pjs.pjW.pkk.get(0);
        }
        if (!bi.oN(this.pjs.bjO())) {
            j.a(new com.tencent.mm.plugin.product.ui.c(this.pjs.bjO()));
            x.d("MicroMsg.MallProductManager", "product img path : " + bjC());
        }
        if (this.pjs.pjZ == null || this.pjs.pjZ.pkv == null) {
            i = 0;
        } else {
            i = this.pjs.pjZ.pkv.fEo;
        }
        if (this.pjs.pjX != null) {
            i2 = this.pjs.pjX.fEo;
        }
        this.pjI = new e(i, i2);
    }

    public final e bjv() {
        if (this.pjI == null) {
            this.pjI = new e(0, 0);
        }
        return this.pjI;
    }

    public final String bjw() {
        if (this.pjH == null || bi.oN(this.pjH.url)) {
            return this.pjA;
        }
        return this.pjH.url;
    }

    public final String bjx() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.pjs.pjW.pkr.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            String str = (String) this.pjE.get(mVar.pkD);
            if (str != null) {
                Iterator it2 = mVar.pkF.iterator();
                while (it2.hasNext()) {
                    h hVar = (h) it2.next();
                    if (str.equals(hVar.id)) {
                        stringBuilder.append(hVar.name).append(" ");
                        break;
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    public final void S(Intent intent) {
        ce ceVar = new ce();
        ceVar.kyG = bi.aD(intent.getStringExtra("userName"), "");
        ceVar.vOc = bi.aD(intent.getStringExtra("telNumber"), "");
        ceVar.vOd = bi.aD(intent.getStringExtra("addressPostalCode"), "");
        ceVar.hxf = bi.aD(intent.getStringExtra("proviceFirstStageName"), "");
        ceVar.hxg = bi.aD(intent.getStringExtra("addressCitySecondStageName"), "");
        ceVar.hxn = bi.aD(intent.getStringExtra("addressCountiesThirdStageName"), "");
        ceVar.nlZ = bi.aD(intent.getStringExtra("addressDetailInfo"), "");
        if (!bi.oN(ceVar.kyG) && !bi.oN(ceVar.vOc)) {
            this.pjy = ceVar;
        }
    }

    public final LinkedList<a> G(Activity activity) {
        LinkedList<a> linkedList = new LinkedList();
        if (this.pjG != null) {
            Iterator it = this.pjG.iterator();
            while (it.hasNext()) {
                at atVar = (at) it.next();
                a aVar = new a();
                aVar.nkW = atVar.nkW;
                aVar.pke = atVar.pke;
                aVar.noL = atVar.noL;
                aVar.kzz = atVar.kzz;
                aVar.nlA = atVar.nlA;
                if (aVar.kzz == 1 && HX(aVar.noL) > 0) {
                    aVar.pke = activity.getString(i.uSi, new Object[]{b.c((double) r0, this.pjs.pjW.pgf)});
                }
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    public final void uU(int i) {
        if (this.pjF != null && i < this.pjF.size() && i >= 0) {
            this.pjx = (tr) this.pjF.get(i);
        }
    }

    public final int bjy() {
        int i = 0;
        if (!(bjv().bjR() || this.pjx == null)) {
            i = this.pjx.vWH + 0;
        }
        if (this.pjH != null) {
            i += this.pjH.pjL * this.mCount;
        } else {
            i += this.pjs.pjW.pki * this.mCount;
        }
        return i - bjz();
    }

    public final int bjz() {
        int i = 0;
        if (this.pjJ == null || this.pjJ.size() <= 0) {
            return 0;
        }
        Iterator it = this.pjJ.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            LinkedList linkedList = (LinkedList) it.next();
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    i2 += ((rl) it2.next()).vWH;
                }
            }
            i = i2;
        }
    }

    private int HX(String str) {
        int i = 0;
        if (this.pjJ != null && this.pjJ.size() > 0) {
            LinkedList linkedList = (LinkedList) this.pjJ.get(str);
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    i = ((rl) it.next()).vWH + i;
                }
            }
        }
        return i;
    }

    public final bcn bjA() {
        if (this.pjz != null) {
            return this.pjz;
        }
        if (this.pjr == null) {
            this.pjr = com.tencent.mm.plugin.product.a.a.bjs().bju();
        }
        d dVar = this.pjr;
        String str = (dVar.pjK == null || dVar.pjK.size() <= 0) ? null : (String) dVar.pjK.get(0);
        if (bi.oN(str)) {
            ce ceVar = this.pjy;
            if (ceVar == null || bi.oN(ceVar.kyG)) {
                return null;
            }
            this.pjz = new bcn();
            this.pjz.nlZ = ceVar.kyG;
            this.pjz.wPp = 1;
            return this.pjz;
        }
        this.pjz = new bcn();
        this.pjz.nlZ = str;
        this.pjz.wPp = 1;
        return this.pjz;
    }

    public final String getAppId() {
        if (this.pjs.pjX != null) {
            return this.pjs.pjX.fGh;
        }
        return null;
    }

    public final String bjB() {
        if (this.pjs.pjX != null) {
            return this.pjs.pjX.username;
        }
        return null;
    }

    public final String bjC() {
        if (bi.oN(this.pjs.bjO())) {
            return null;
        }
        return com.tencent.mm.plugin.product.ui.c.HZ(this.pjs.bjO());
    }

    public final String bjD() {
        if (this.pjs.pjW != null && this.pjs.pjW.pkt != null) {
            return this.pjs.pjW.pkt.url;
        }
        if (bi.oN(this.pjs.pka)) {
            return this.pjv;
        }
        return this.pjs.pka;
    }

    public final int bjE() {
        int i = this.pjs.pjU;
        if (this.pjH == null || i <= this.pjH.pjU) {
            return i;
        }
        return this.pjH.pjU;
    }

    public final boolean bjF() {
        return (this.mCount <= 0 || this.pjs == null || this.mCount > bjE() || this.pjs.pjW == null || this.pjs.pjW.pkr == null) ? false : true;
    }

    public final boolean bjG() {
        if (!bjF() || this.pjE == null || this.pjE.size() != this.pjC) {
            return false;
        }
        if (this.pjC > 0) {
            if (this.pjH == null || this.mCount <= 0 || this.mCount > bjE()) {
                return false;
            }
            return true;
        } else if (this.pjC == 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean bjH() {
        if (!bjG() || this.pjy == null) {
            return false;
        }
        if (bjv().bjR() || this.pjx != null) {
            return true;
        }
        return false;
    }

    public final LinkedList<bex> bjI() {
        LinkedList<bex> linkedList = new LinkedList();
        bex bex = new bex();
        bex.kyA = this.mCount;
        bex.wtR = this.pjs.pjS;
        bex.wMI = this.pjs.pka;
        bex.wMJ = this.pjw;
        linkedList.add(bex);
        return linkedList;
    }

    public final bke bjJ() {
        bke bke = new bke();
        bke.vXS = this.pju;
        bke.phc = 1;
        bke.wTV = new LinkedList();
        azc azc = new azc();
        azc.kyA = this.mCount;
        azc.wtR = this.pjs.pjS;
        azc.nkW = this.pjs.pjW.name;
        if (this.pjH != null) {
            azc.wMH = this.pjH.pjL;
        } else {
            azc.wMH = this.pjs.pjW.pki;
        }
        azc.wMI = this.pjs.pka;
        azc.wMJ = this.pjw;
        azc.kzz = this.pjs.pjT;
        azc.wMF = this.pjC;
        azc.wMG = new LinkedList();
        for (String str : this.pjE.keySet()) {
            String str2 = (String) this.pjE.get(str);
            anz anz = new anz();
            anz.vUa = str;
            anz.pWq = str2;
            azc.wMG.add(anz);
        }
        azc.wMN = new LinkedList();
        azc.wMM = 0;
        if (this.pjJ != null && this.pjJ.size() > 0) {
            for (LinkedList linkedList : this.pjJ.values()) {
                azc.wMN.addAll(linkedList);
                azc.wMM = linkedList.size() + azc.wMM;
            }
        }
        bke.wTV.add(azc);
        bke.wTX = new LinkedList();
        bke.wTY = 1;
        this.pjz = bjA();
        if (this.pjz != null) {
            bke.wTX.add(this.pjz);
        } else {
            this.pjz = new bcn();
            this.pjz.wPp = 0;
            bke.wTX.add(this.pjz);
        }
        bke.wsF = this.pjy;
        bke.wTW = this.pjx;
        return bke;
    }

    public final void bjK() {
        if (this.pjE != null) {
            Iterator it = this.pjs.pjW.pkr.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                Iterator it2 = mVar.pkF.iterator();
                while (it2.hasNext()) {
                    boolean z;
                    h hVar = (h) it2.next();
                    String str = mVar.pkD;
                    String str2 = hVar.id;
                    String str3;
                    e eVar;
                    if (this.pjE == null || this.pjD == null) {
                        z = false;
                    } else if (this.pjE.containsKey(str)) {
                        str3 = (String) this.pjE.get(str);
                        this.pjE.put(str, str2);
                        str2 = L(this.pjE);
                        this.pjE.put(str, str3);
                        eVar = (e) this.pjD.get(str2);
                        z = eVar != null ? eVar.pjU > 0 : false;
                    } else {
                        this.pjE.put(str, str2);
                        str3 = L(this.pjE);
                        this.pjE.remove(str);
                        eVar = (e) this.pjD.get(str3);
                        z = eVar != null ? eVar.pjU > 0 : false;
                    }
                    hVar.pkx = z;
                    x.d("MicroMsg.MallProductManager", "(" + mVar.pkD + " , " + hVar.id + ") hasStock--> " + hVar.pkx);
                }
            }
        }
    }

    public static String L(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Object arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator<Entry<String, String>>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((String) ((Entry) obj).getKey()).compareTo((String) ((Entry) obj2).getKey());
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append((String) entry.getKey()).append(":").append((String) entry.getValue()).append(";");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));
        return stringBuilder.toString();
    }

    private void a(String[] strArr, l lVar) {
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = -1 >>> (32 - length);
            for (int i2 = 1; i2 <= i; i2++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i3 = 0; i3 < length; i3++) {
                    if (((i2 << (31 - i3)) >> 31) == -1) {
                        stringBuilder.append(strArr[i3]).append(";");
                    }
                }
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));
                e eVar = (e) this.pjD.get(stringBuilder.toString());
                if (eVar != null) {
                    if (eVar.pjL < lVar.pkB) {
                        eVar.pjL = lVar.pkB;
                    }
                    if (eVar.pjM > lVar.pkB) {
                        eVar.pjM = lVar.pkB;
                    }
                    eVar.pjU += lVar.pjU;
                } else {
                    eVar = new e();
                    eVar.pjL = lVar.pkB;
                    eVar.pjM = lVar.pkB;
                    eVar.pjU = lVar.pjU;
                    eVar.pkC = lVar.pkC;
                    eVar.url = lVar.url;
                    this.pjD.put(stringBuilder.toString(), eVar);
                }
            }
        }
    }

    public final String bjL() {
        g.a aVar = new g.a();
        aVar.title = this.pjs.pjW.name;
        aVar.description = bjM();
        aVar.type = 13;
        aVar.url = bjD();
        aVar.thumburl = this.pjs.bjO();
        aVar.hdn = this.pjs.pjT;
        aVar.hdo = a(this.pjs);
        return g.a.a(aVar, null, null);
    }

    public final String bjM() {
        return b.c((double) this.pjs.pjW.pkj, this.pjs.pjW.pgf);
    }

    public final String a(m mVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<mallProductInfo>");
        stringBuilder.append("<type>").append(mVar.pjT).append("</type>");
        stringBuilder.append("<id>").append(mVar.pjS).append("</id>");
        stringBuilder.append("<version>").append(mVar.pjW.version).append("</version>");
        stringBuilder.append("<name>").append(bi.Wm(mVar.pjW.name)).append("</name>");
        stringBuilder.append("<highPrice>").append(mVar.pjW.pki).append("</highPrice>");
        stringBuilder.append("<lowPrice>").append(mVar.pjW.pkj).append("</lowPrice>");
        stringBuilder.append("<originPrice>").append(mVar.pjW.pkh).append("</originPrice>");
        stringBuilder.append("<sourceUrl>").append(bi.Wm(this.pjs.pka)).append("</sourceUrl>");
        if (mVar.pjW.pkk != null) {
            stringBuilder.append("<imgCount>").append(mVar.pjW.pkk.size()).append("</imgCount>");
            stringBuilder.append("<imgList>");
            Iterator it = mVar.pjW.pkk.iterator();
            while (it.hasNext()) {
                stringBuilder.append("<imgUrl>").append(bi.Wm((String) it.next())).append("</imgUrl>");
            }
            stringBuilder.append("</imgList>");
        }
        stringBuilder.append("<shareInfo>");
        stringBuilder.append("<shareUrl>").append(bi.Wm(bjD())).append("</shareUrl>");
        stringBuilder.append("<shareThumbUrl>").append(bi.Wm(mVar.bjO())).append("</shareThumbUrl>");
        stringBuilder.append("</shareInfo>");
        if (this.pjs.pjX != null) {
            stringBuilder.append("<sellerInfo>");
            stringBuilder.append("<appID>").append(mVar.pjX.fGh).append("</appID>");
            stringBuilder.append("<appName>").append(mVar.pjX.name).append("</appName>");
            stringBuilder.append("<usrName>").append(mVar.pjX.username).append("</usrName>");
            stringBuilder.append("</sellerInfo>");
        }
        stringBuilder.append("</mallProductInfo>");
        return stringBuilder.toString();
    }
}
