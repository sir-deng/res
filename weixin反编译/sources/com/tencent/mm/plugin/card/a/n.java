package com.tencent.mm.plugin.card.a;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.protocal.c.kr;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class n implements e, com.tencent.mm.modelgeo.a.a {
    private ag handler;
    public Map<String, Set<a>> kPs = new HashMap();
    public HashMap<String, String> kPt = new HashMap();
    private String kPu;
    public v kPv;

    public interface a {
        void a(boolean z, ArrayList<kr> arrayList);
    }

    public n() {
        as.CN().a(563, (e) this);
        this.handler = new ag(Looper.getMainLooper());
    }

    public final void a(String str, a aVar) {
        synchronized (this.kPs) {
            try {
                if (this.kPs.get(str) != null) {
                    ((Set) this.kPs.get(str)).remove(aVar);
                }
            } catch (Exception e) {
            }
        }
        synchronized (this.kPt) {
            this.kPt.remove(str);
        }
    }

    private void a(final String str, final boolean z, final ArrayList<kr> arrayList) {
        this.handler.post(new Runnable() {
            public final void run() {
                Set set;
                synchronized (n.this.kPs) {
                    set = (Set) n.this.kPs.get(str);
                }
                if (set != null && set.size() > 0) {
                    Set<a> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (a aVar : hashSet) {
                        if (aVar != null) {
                            aVar.a(z, arrayList);
                        }
                    }
                }
            }
        });
    }

    public final boolean a(String str, String str2, a aVar) {
        int i;
        x.d("MicroMsg.CardShopLBSManager", "getShopList, cardTpId = %s, card_id = %s", str, str2);
        this.kPu = str;
        synchronized (this.kPs) {
            if (!this.kPs.containsKey(str)) {
                this.kPs.put(str, new HashSet());
            }
            if (!((Set) this.kPs.get(str)).contains(aVar)) {
                ((Set) this.kPs.get(str)).add(aVar);
            }
        }
        synchronized (this.kPt) {
            if (!TextUtils.isEmpty(str2)) {
                this.kPt.put(str, str2);
            }
        }
        com.tencent.mm.modelgeo.a OV = c.OV();
        if (OV == null) {
            x.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
            i = 0;
        } else {
            OV.b(this);
            i = 1;
        }
        if (i == 0) {
            x.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
            return false;
        }
        if (this.kPv != null) {
            as.CN().c(this.kPv);
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.kPv = null;
        String str2 = ((v) kVar).kRG;
        x.i("MicroMsg.CardShopLBSManager", "onSceneEnd, reqCardTpId = %s, errType = %d, errCode = %d", str2, Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            ArrayList arrayList = ((v) kVar).kRH;
            String str3 = "MicroMsg.CardShopLBSManager";
            String str4 = "onSceneEnd, respShopList size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            x.d(str3, str4, objArr);
            a(str2, true, arrayList);
            return;
        }
        x.e("MicroMsg.CardShopLBSManager", "onSceneEnd, cardshoplbs fail");
        a(str2, false, null);
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return true;
        }
        Set set;
        com.tencent.mm.modelgeo.a OV = c.OV();
        if (OV != null) {
            OV.c(this);
        }
        x.d("MicroMsg.CardShopLBSManager", "onGetLocation, fLongitude = %f, fLatitude = %f, locType = %d, speed = %f, accuracy = %f", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2));
        synchronized (this.kPs) {
            set = (Set) this.kPs.get(this.kPu);
        }
        if (set == null || set.size() == 0) {
            x.e("MicroMsg.CardShopLBSManager", "onGetLocation, already cancelled, no need to doScene");
            return false;
        }
        String str;
        synchronized (this.kPt) {
            str = (String) this.kPt.get(this.kPu);
        }
        k vVar = new v(this.kPu, f, f2, str);
        if (as.CN().a(vVar, 0)) {
            this.kPv = vVar;
        } else {
            x.e("MicroMsg.CardShopLBSManager", "doScene fail, callback immediate");
            a(this.kPu, false, null);
        }
        return true;
    }
}
