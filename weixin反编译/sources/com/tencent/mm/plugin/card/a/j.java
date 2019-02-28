package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.card.sharecard.model.f;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class j implements e {
    private List<WeakReference<a>> kOg = new ArrayList();
    public ArrayList<String> kPd = new ArrayList();
    public ArrayList<String> kPe = new ArrayList();
    public ag kPf = new ag();
    public HashMap<String, Runnable> kPg = new LinkedHashMap();

    /* renamed from: com.tencent.mm.plugin.card.a.j$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int hNw;
        final /* synthetic */ String kPh;
        final /* synthetic */ int kPi = 0;
        final /* synthetic */ int kPj = 0;

        AnonymousClass1(String str, int i, int i2, int i3) {
            this.kPh = str;
            this.hNw = i3;
        }

        public final void run() {
            j.g(this.kPh, this.kPi, this.kPj, this.hNw);
            x.i("MicroMsg.CardMarkCodeMgr", "run the unmark task, the card is " + this.kPh + " system.time:" + System.currentTimeMillis());
        }
    }

    public interface a {
        void b(String str, b bVar);

        void bV(String str, String str2);

        void wG(String str);
    }

    public static class b {
        public String kPl;
        public int kPm = 0;
        public String kPn;
        public int kPo;
        public String kPp;
    }

    public j() {
        as.CN().a(907, (e) this);
        this.kPd.clear();
        this.kPe.clear();
        this.kPg.clear();
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

    private void a(String str, b bVar) {
        x.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
        if (this.kOg != null) {
            if (this.kPd.contains(str) || this.kPe.contains(str)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.kOg.size()) {
                        WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                        if (weakReference != null) {
                            a aVar = (a) weakReference.get();
                            if (aVar != null) {
                                if (this.kPd.contains(str)) {
                                    aVar.b(str, bVar);
                                } else if (this.kPe.contains(str)) {
                                    aVar.wG(str);
                                }
                            }
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
            x.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
        }
    }

    private void bU(String str, String str2) {
        x.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
        if (this.kOg != null) {
            if (!this.kPd.contains(str) || this.kPe.contains(str)) {
                x.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.bV(str, str2);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void wE(String str) {
        x.i("MicroMsg.CardMarkCodeMgr", "removeId()");
        if (this.kPd.contains(str) && !this.kPe.contains(str)) {
            this.kPd.remove(str);
            x.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is " + str);
        }
        if (!this.kPd.contains(str) && this.kPe.contains(str)) {
            this.kPe.remove(str);
            Runnable runnable = (Runnable) this.kPg.get(str);
            this.kPg.remove(str);
            this.kPf.removeCallbacks(runnable);
            x.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is " + str);
            x.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is " + str);
        }
    }

    private void wF(String str) {
        x.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
        if (this.kPe.contains(str)) {
            this.kPe.remove(str);
            x.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is " + str);
        }
        if (this.kPg.containsKey(str)) {
            x.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is " + str);
            Runnable runnable = (Runnable) this.kPg.get(str);
            this.kPg.remove(str);
            this.kPf.removeCallbacks(runnable);
        }
    }

    public final void D(String str, int i, int i2) {
        x.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
        wF(str);
        if (!this.kPd.contains(str)) {
            this.kPd.add(str);
        }
        g(str, i, 1, i2);
    }

    public final void aX(String str, int i) {
        x.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
        wF(str);
        this.kPe.add(str);
        Runnable anonymousClass1 = new AnonymousClass1(str, 0, 0, i);
        this.kPf.postDelayed(anonymousClass1, (long) (bi.getInt(g.Ag().F("ShareCard", "UnMarkDelay"), 0) * 1000));
        this.kPg.put(str, anonymousClass1);
        x.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + str + " system.time:" + System.currentTimeMillis());
    }

    static void g(String str, int i, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            x.i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
            return;
        }
        x.i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
        as.CN().a(new f(str, i, i2, i3), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        f fVar;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof f) {
                fVar = (f) kVar;
                b bVar = new b();
                bVar.kPl = fVar.kPl;
                bVar.kPm = fVar.kPm;
                bVar.kPn = fVar.kPn;
                bVar.kPo = fVar.kPo;
                bVar.kPp = fVar.kPp;
                x.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + fVar.kSR);
                x.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + bVar.kPl + " mark_succ:" + bVar.kPm + " mark_card_id:" + bVar.kPn + " expire_time:" + bVar.kPo + " pay_qrcode_wording:" + bVar.kPp);
                a(fVar.kSR, bVar);
                wE(fVar.kSR);
            }
        } else if (kVar instanceof f) {
            fVar = (f) kVar;
            x.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + fVar.kSR);
            bU(fVar.kSR, str);
            wE(fVar.kSR);
        }
    }
}
