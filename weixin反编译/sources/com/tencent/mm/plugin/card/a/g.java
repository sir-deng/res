package com.tencent.mm.plugin.card.a;

import com.tencent.mm.ad.e;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.q;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ae;
import com.tencent.mm.plugin.card.model.ah;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.c.avz;
import com.tencent.mm.protocal.c.bai;
import com.tencent.mm.protocal.c.baj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements e {
    public c kOC;
    public int kOD;
    public al kOE = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
            g gVar = g.this;
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onShowTimeExpired()");
            if (gVar.kOg != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= gVar.kOg.size()) {
                        break;
                    }
                    WeakReference weakReference = (WeakReference) gVar.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.auI();
                        }
                    }
                    i = i2 + 1;
                }
            }
            return true;
        }
    }, false);
    public List<WeakReference<a>> kOg = new ArrayList();

    public interface a {
        void Y(int i, String str);

        void auI();

        void b(c cVar);

        void c(c cVar);
    }

    public final void release() {
        this.kOD = 0;
        auz();
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
        as.CN().b(1382, (e) this);
        as.CN().b(1275, (e) this);
    }

    public final void a(b bVar, q qVar) {
        if (!g(bVar)) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
            X(2, "");
        } else if (!l.isNetworkAvailable(ad.getContext())) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
            X(-1, "");
        } else if (this.kOD >= 3) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.kOD + ",cannot request!");
        } else {
            a(bVar.aum(), qVar);
            this.kOD++;
        }
    }

    public final void a(q qVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", Integer.valueOf(qVar.scene));
        List<CardInfo> auW = am.avh().auW();
        if (auW.isEmpty()) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard do update all offileQrcode is failure! is dynamic cardList is empyt!fromScene=%d", Integer.valueOf(qVar.scene));
            return;
        }
        for (CardInfo cardInfo : auW) {
            if (cardInfo == null) {
                x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! cardInfo is null fromScene=%d", Integer.valueOf(qVar.scene));
            } else if (qVar == null) {
                x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! fromScene is null!");
            } else {
                x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", cardInfo.aum(), Integer.valueOf(qVar.scene));
                if (g(cardInfo)) {
                    int i;
                    String aum = cardInfo.aum();
                    i wM = am.avw().wM(aum);
                    if (wM == null) {
                        i = 1;
                    } else {
                        List wN = am.avv().wN(aum);
                        if (wN.isEmpty()) {
                            i = 1;
                        } else if (wN.size() < wM.field_lower_bound) {
                            this.kOC = c.CARDCODEREFRESHACTION_UPDATECHANGE;
                            i = 1;
                        } else if (a(wM)) {
                            this.kOC = c.CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT;
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                    if (i == 0) {
                        x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", cardInfo.aum(), Integer.valueOf(qVar.scene));
                    } else {
                        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", Integer.valueOf(qVar.scene));
                        a(cardInfo.aum(), qVar);
                    }
                } else {
                    x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", cardInfo.aum());
                }
            }
        }
    }

    public final void b(com.tencent.mm.plugin.card.model.g gVar) {
        String str = gVar.field_card_id;
        com.tencent.mm.plugin.card.model.l avv = am.avv();
        List wN;
        k wP;
        if (gVar.kRe) {
            wN = am.avv().wN(str);
            wP = avv.wP(str);
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", str);
            if (avv.iI(str)) {
                if (wP != null) {
                    x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", str);
                    b(c.CARDCODEREFRESHACTION_BANCODE);
                }
                a(str, wN, c.CARDCODEREFRESHACTION_BANCODE);
                return;
            }
            return;
        }
        List<com.tencent.mm.plugin.card.model.g.c> wN2 = gVar.kRf;
        if (wN2 == null) {
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", str);
            return;
        }
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", str, Integer.valueOf(wN2.size()));
        wP = avv.wP(str);
        LinkedList linkedList = new LinkedList();
        for (com.tencent.mm.plugin.card.model.g.c cVar : wN2) {
            if (am.avv().bW(str, cVar.kRn)) {
                linkedList.add(b(str, cVar.kRn, c.CARDCODEREFRESHACTION_BANCODE));
            }
        }
        if (wP != null) {
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", str, wP.field_code_id);
            b(c.CARDCODEREFRESHACTION_BANCODE);
        }
        if (!linkedList.isEmpty()) {
            D(linkedList);
        }
    }

    public static boolean a(i iVar) {
        if (System.currentTimeMillis() - iVar.field_fetch_time <= ((long) (iVar.field_expire_time_interval * 1000))) {
            return false;
        }
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code  expire time is true! currentTime= %s,codeFetchTime=%s,field_expire_time_interval=%s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(iVar.field_fetch_time), Integer.valueOf(iVar.field_expire_time_interval));
        return true;
    }

    public final void auz() {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
        if (!this.kOE.cgx()) {
            this.kOE.TN();
        }
    }

    private static boolean g(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.auj() != null && bVar.auj().vYx) {
            return true;
        }
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
        return false;
    }

    private void a(String str, q qVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneGetDynamicQrcode, cardId:" + str + ",scene :" + (qVar == null ? 0 : qVar.scene));
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        com.tencent.mm.ad.k aeVar = new ae(linkedList, qVar == null ? 0 : qVar.scene);
        as.CN().a(1382, (e) this);
        as.CN().a(aeVar, 0);
    }

    private void a(String str, List<k> list, c cVar) {
        if (cVar == null) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport error! CardCodeRefreshAction is null! cannot report!");
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (k kVar : list) {
            linkedList.add(b(str, kVar.field_code_id, cVar));
        }
        D(linkedList);
    }

    public final void a(String str, String str2, c cVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(b(str, str2, cVar));
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", Integer.valueOf(linkedList.size()), Integer.valueOf(cVar.action));
        D(linkedList);
    }

    private void D(LinkedList<avz> linkedList) {
        as.CN().a(1275, (e) this);
        as.CN().a(new ah(linkedList), 0);
    }

    private static avz b(String str, String str2, c cVar) {
        avz avz = new avz();
        avz.fHP = str;
        avz.kRn = str2;
        avz.wKj = new Long(System.currentTimeMillis() / 1000).intValue();
        avz.wKk = cVar == null ? -1 : cVar.action;
        return avz;
    }

    private void a(baj baj) {
        if (baj != null) {
            String str = baj.fHP;
            if (am.avw().wM(str) == null) {
                am.avw().b(b(baj));
            } else {
                am.avw().c(b(baj), new String[0]);
            }
            List wN = am.avv().wN(str);
            if (!(wN.isEmpty() || !am.avv().iI(str) || this.kOC == null)) {
                a(str, wN, this.kOC);
            }
            Iterator it = baj.wNP.iterator();
            while (it.hasNext()) {
                bai bai = (bai) it.next();
                com.tencent.mm.sdk.e.c kVar = new k();
                kVar.field_card_id = str;
                kVar.field_code_id = bai.kRn;
                kVar.field_code = com.tencent.mm.plugin.card.b.e.cd(str, bai.data);
                am.avv().b(kVar);
            }
        }
    }

    private static i b(baj baj) {
        i iVar = new i();
        iVar.field_card_id = baj.fHP;
        iVar.field_lower_bound = baj.wNK;
        iVar.field_expire_time_interval = baj.wNN;
        iVar.field_need_insert_show_timestamp = baj.wNL;
        iVar.field_show_expire_interval = baj.wNO;
        iVar.field_show_timestamp_encrypt_key = baj.wNM;
        iVar.field_fetch_time = System.currentTimeMillis();
        return iVar;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, errType = " + i + " errCode = " + i2 + ",NetSceneBase=" + (kVar != null ? kVar.getClass() : ""));
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, errType = " + i + " errCode = " + i2 + " cmd:" + (kVar != null ? kVar.getType() : 0) + "  NetSceneBase=" + (kVar != null ? kVar.getClass() : ""));
            if (kVar instanceof ae) {
                X(i2, str);
                as.CN().b(1382, (e) this);
                return;
            }
            as.CN().b(1275, (e) this);
        } else if (kVar instanceof ae) {
            baj baj = ((ae) kVar).kRP;
            if (baj == null) {
                x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
                return;
            }
            a(baj);
            a(this.kOC);
            as.CN().b(1382, (e) this);
        } else {
            as.CN().b(1275, (e) this);
        }
    }

    private void a(c cVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
        if (this.kOg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.c(cVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void X(int i, String str) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
        if (this.kOg != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i3);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.Y(i, str);
                        }
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void b(c cVar) {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
        if (this.kOg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.b(cVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
