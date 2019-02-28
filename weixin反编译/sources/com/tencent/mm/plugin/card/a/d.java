package com.tencent.mm.plugin.card.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ko;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d implements e, com.tencent.mm.plugin.card.a.l.a, com.tencent.mm.plugin.card.base.d {
    public WeakReference<Context> Zt;
    public List<WeakReference<a>> kOg = new ArrayList();
    public HashMap<a, Boolean> kOs = new HashMap();
    public HashMap<String, Boolean> kOt = new HashMap();
    public HashMap<String, Boolean> kOu = new HashMap();
    public b kOv = null;
    public boolean kOw = false;
    public String kOx;

    public interface a {
        void auF();

        void auG();

        void f(b bVar);

        void wD(String str);
    }

    public final void release() {
        as.CN().b(910, (e) this);
        am.avo().b(this);
        b avg = am.avg();
        if (avg.kOg != null && this != null) {
            for (int i = 0; i < avg.kOg.size(); i++) {
                WeakReference weakReference = (WeakReference) avg.kOg.get(i);
                if (weakReference != null) {
                    com.tencent.mm.plugin.card.base.d dVar = (com.tencent.mm.plugin.card.base.d) weakReference.get();
                    if (dVar != null && dVar.equals(this)) {
                        avg.kOg.remove(weakReference);
                        break;
                    }
                }
            }
        }
        this.kOg.clear();
        this.kOs.clear();
        this.kOu.clear();
        this.kOw = false;
    }

    public final void a(a aVar) {
        if (this.kOg == null) {
            this.kOg = new ArrayList();
        }
        if (aVar != null) {
            this.kOg.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.kOg != null && aVar != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar2 = (a) weakReference.get();
                        if (aVar2 != null && aVar2.equals(aVar)) {
                            this.kOg.remove(weakReference);
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void d(b bVar) {
        boolean z = false;
        this.kOv = bVar;
        if (!(!this.kOw || this.kOv == null || bVar.aum() == null || bVar.aum().equals(this.kOv.aum()))) {
            this.kOw = false;
        }
        if (this.kOg != null) {
            while (true) {
                boolean z2 = z;
                if (z2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(z2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        Boolean bool = (Boolean) this.kOs.get(aVar);
                        if (!(aVar == null || bool == null || bool.booleanValue())) {
                            aVar.f(bVar);
                        }
                    }
                    z = z2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void a(a aVar, boolean z) {
        if (this.kOs == null) {
            this.kOs = new HashMap();
        }
        this.kOs.put(aVar, Boolean.valueOf(z));
    }

    public final void c(a aVar) {
        if (this.kOs == null) {
            this.kOs = new HashMap();
        }
        this.kOs.remove(aVar);
    }

    public final void aut() {
        x.i("MicroMsg.CardConsumedMgr", "onDBchange()");
        if (this.kOv == null) {
            x.e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
            return;
        }
        b xb;
        if (this.kOv.atO()) {
            xb = am.avp().xb(this.kOv.aum());
        } else {
            Object xb2 = am.avh().wL(this.kOv.aum());
        }
        if (xb2 != null && xb2.auj() != null && this.kOv != null && this.kOv.auj() != null) {
            x.d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", Integer.valueOf(this.kOv.auj().status), Integer.valueOf(xb2.auj().status), Boolean.valueOf(this.kOw), Boolean.valueOf(this.kOv.atO()));
            if (this.kOv.atO() && (this.kOv instanceof ShareCardInfo)) {
                x.d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", Integer.valueOf(((ShareCardInfo) this.kOv).field_status));
            } else if (this.kOv.atO()) {
                x.e("MicroMsg.CardConsumedMgr", "onDBchange() mCardInfo is ShareCard, but not the ShareCardInfo instance!");
            }
            if (xb2.auj().status != r2) {
                auB();
                if (this.kOv.atO() && !this.kOw && xb2.auj().status == 1) {
                    x.i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
                    Boolean bool = (Boolean) this.kOt.get(this.kOv.aum());
                    if (bool == null || !bool.booleanValue()) {
                        x.i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
                        long currentTimeMillis = System.currentTimeMillis();
                        Context context = (Context) this.Zt.get();
                        x.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.kOv.aum());
                        com.tencent.mm.plugin.card.sharecard.a.b.a(context, this.kOv);
                        this.kOt.put(this.kOv.aum(), Boolean.valueOf(true));
                        long currentTimeMillis2 = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        IDKey iDKey = new IDKey();
                        iDKey.SetID(281);
                        iDKey.SetKey(30);
                        iDKey.SetValue(1);
                        IDKey iDKey2 = new IDKey();
                        iDKey2.SetID(281);
                        iDKey2.SetKey(31);
                        iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                        arrayList.add(iDKey);
                        arrayList.add(iDKey2);
                        g.pWK.a(arrayList, true);
                    } else {
                        x.i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
                    }
                    auD();
                } else if (this.kOv.atO() && this.kOw) {
                    x.i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
                } else {
                    x.i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
                    auC();
                }
                x.i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
            }
            this.kOv = xb2;
            e(this.kOv);
        }
    }

    public final void asP() {
        auB();
    }

    public final void a(com.tencent.mm.plugin.card.model.g gVar) {
        x.i("MicroMsg.CardConsumedMgr", "onChange()");
        x.i("MicroMsg.CardConsumedMgr", "card msg card id is " + gVar.field_card_id);
        if (this.kOv == null) {
            x.e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
            auC();
            return;
        }
        x.i("MicroMsg.CardConsumedMgr", "card msg card id is " + gVar.field_card_id);
        if (this.kOv.atN() && gVar.field_card_id != null && gVar.field_card_id.equals(this.kOv.aum()) && gVar.kRd == 3) {
            x.i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
            auC();
        } else if (!this.kOv.atO()) {
            x.i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
            auC();
        } else if (gVar.kRd == 3 || !(gVar.field_card_id == null || !gVar.field_card_id.equals(this.kOv.aum()) || TextUtils.isEmpty(gVar.field_consumed_box_id))) {
            long currentTimeMillis = System.currentTimeMillis();
            x.i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
            ko auj;
            if (gVar.field_card_id != null && gVar.field_card_id.equals(this.kOv.aum())) {
                b xb = am.avp().xb(this.kOv.aum());
                if (!(xb == null || xb.auj() == null)) {
                    int i = this.kOv.auj().status;
                    x.d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", Integer.valueOf(i), Integer.valueOf(xb.auj().status), Integer.valueOf(((ShareCardInfo) this.kOv).field_status));
                    if (xb.auj().status != i) {
                        auB();
                    } else if (i != 1) {
                        x.i("MicroMsg.CardConsumedMgr", "share card oldState status is " + i);
                        auj = this.kOv.auj();
                        auj.status = 1;
                        ((ShareCardInfo) this.kOv).field_status = 1;
                        this.kOv.a(auj);
                        l.j(this.kOv);
                    }
                }
            } else if (gVar.field_card_id != null) {
                b xb2 = am.avp().xb(gVar.field_card_id);
                if (xb2 == null || xb2.auj() == null) {
                    x.w("MicroMsg.CardConsumedMgr", "tempCard is null");
                } else {
                    x.d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", Integer.valueOf(xb2.auj().status), Integer.valueOf(xb2.field_status));
                    if (xb2.auj().status != 1) {
                        auj = xb2.auj();
                        auj.status = 1;
                        xb2.field_status = 1;
                        xb2.a(auj);
                        l.j(xb2);
                    }
                }
            }
            e(this.kOv);
            Boolean bool = (Boolean) this.kOt.get(this.kOv.aum());
            if (bool == null || !bool.booleanValue()) {
                Context context = (Context) this.Zt.get();
                x.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.kOv.aum());
                com.tencent.mm.plugin.card.sharecard.a.b.a(context, this.kOv);
                this.kOt.put(this.kOv.aum(), Boolean.valueOf(true));
                long currentTimeMillis2 = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                IDKey iDKey = new IDKey();
                iDKey.SetID(281);
                iDKey.SetKey(30);
                iDKey.SetValue(1);
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(281);
                iDKey2.SetKey(31);
                iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                arrayList.add(iDKey);
                arrayList.add(iDKey2);
                g.pWK.a(arrayList, true);
            } else {
                x.i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
            }
            auD();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
                com.tencent.mm.plugin.card.sharecard.model.d dVar = (com.tencent.mm.plugin.card.sharecard.model.d) kVar;
                if (TextUtils.isEmpty(dVar.kRy)) {
                    x.e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
                } else {
                    wC(dVar.kRy);
                }
                this.kOw = false;
                x.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
                auC();
            }
        } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
            this.kOw = false;
            x.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
            auC();
        }
    }

    private void wC(String str) {
        x.i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
        if (this.kOg != null) {
            int i = 0;
            boolean z = false;
            while (i < this.kOg.size()) {
                boolean z2;
                WeakReference weakReference = (WeakReference) this.kOg.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    Boolean bool = (Boolean) this.kOs.get(aVar);
                    if (!(aVar == null || bool == null || !bool.booleanValue())) {
                        aVar.wD(str);
                        z2 = true;
                        i++;
                        z = z2;
                    }
                }
                z2 = z;
                i++;
                z = z2;
            }
            Boolean bool2 = (Boolean) this.kOt.get(this.kOv.aum());
            if (z) {
                x.i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
                this.kOx = "";
            } else if (bool2 != null && bool2.booleanValue()) {
                x.i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
                this.kOx = str;
                this.kOu.put(this.kOv.aum(), Boolean.valueOf(true));
            }
        }
    }

    private void e(b bVar) {
        x.i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
        if (this.kOg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.f(bVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void auB() {
        x.i("MicroMsg.CardConsumedMgr", "doVibrate()");
        if (this.kOg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.auF();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void auC() {
        x.i("MicroMsg.CardConsumedMgr", "doFinishUI()");
        if (this.kOg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.auG();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void auD() {
        x.i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
        auE();
    }

    private synchronized void auE() {
        if (this.kOw) {
            x.i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is true, is doing NetSceneGetShareCardConsumedInfo. return");
        } else {
            x.i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is false, do NetSceneGetShareCardConsumedInfo. ");
            this.kOw = true;
            as.CN().a(new com.tencent.mm.plugin.card.sharecard.model.d(this.kOv.aum(), "", ""), 0);
        }
    }
}
