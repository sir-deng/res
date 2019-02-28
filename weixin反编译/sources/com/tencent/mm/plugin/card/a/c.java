package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.card.model.ac;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements e {
    List<WeakReference<a>> kOg = new ArrayList();
    String kOh = "";
    public LinkedList<String> kOi = new LinkedList();
    public int kOj;
    private int kOk;
    private int kOl;
    private int kOm;
    private int kOn = 60;
    private boolean kOo = false;
    private al kOp = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            x.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
            c.this.wB(c.this.kOh);
            c.this.auw();
            return true;
        }
    }, false);
    private al kOq = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            x.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
            c cVar = c.this;
            x.i("MicroMsg.CardCodeMgr", "onCodeChange()");
            if (cVar.kOg != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= cVar.kOg.size()) {
                        break;
                    }
                    WeakReference weakReference = (WeakReference) cVar.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.auA();
                        }
                    }
                    i = i2 + 1;
                }
            }
            c.this.auy();
            return true;
        }
    }, false);

    public interface a {
        void auA();

        void onSuccess();

        void wA(String str);
    }

    public final void release() {
        as.CN().b(577, (e) this);
        this.kOi.clear();
        this.kOo = false;
        this.kOh = "";
        this.kOj = 0;
        this.kOk = 0;
        this.kOl = 0;
        this.kOm = 0;
        aux();
        auz();
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

    private void onSuccess() {
        x.i("MicroMsg.CardCodeMgr", "onSuccess()");
        if (this.kOg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.onSuccess();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void wA(String str) {
        x.i("MicroMsg.CardCodeMgr", "onFail()");
        if (this.kOg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.wA(str);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final String getCode() {
        if (this.kOi == null || this.kOi.size() == 0) {
            x.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            return "";
        } else if (this.kOj >= this.kOi.size()) {
            x.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            wB(this.kOh);
            return "";
        } else {
            if (this.kOl >= this.kOi.size() - this.kOj) {
                x.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
                wB(this.kOh);
            }
            x.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.kOj + " request_count:" + this.kOl + " codes size:" + this.kOi.size());
            LinkedList linkedList = this.kOi;
            int i = this.kOj;
            this.kOj = i + 1;
            return (String) linkedList.get(i);
        }
    }

    public final boolean isEmpty() {
        if (this.kOi == null || this.kOi.size() == 0) {
            x.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            return true;
        } else if (this.kOj < this.kOi.size()) {
            return false;
        } else {
            x.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            return true;
        }
    }

    public final void wB(String str) {
        if (this.kOo) {
            x.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), is doing get codes");
        } else if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), mCardId is empty!");
        } else {
            x.i("MicroMsg.CardCodeMgr", "doGetCardCodes() do get codes, card id " + str);
            this.kOo = true;
            this.kOh = str;
            as.CN().a(new ac(this.kOh), 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof ac) {
                this.kOo = false;
                x.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.kOh);
                ac acVar = (ac) kVar;
                this.kOk = acVar.kOk;
                this.kOl = acVar.kOl;
                this.kOm = acVar.kOm;
                if (acVar.kOi != null) {
                    this.kOi.clear();
                    this.kOi.addAll(acVar.kOi);
                    this.kOj = 0;
                }
                onSuccess();
                auw();
                if (this.kOm != 0) {
                    auy();
                }
            }
        } else if (kVar instanceof ac) {
            this.kOo = false;
            x.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.kOh);
            wA(str);
        }
    }

    public final void auw() {
        aux();
        x.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.kOk);
        if (this.kOk <= 0 || TextUtils.isEmpty(this.kOh)) {
            x.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
            return;
        }
        long j = (long) (this.kOk * 1000);
        this.kOp.K(j, j);
        x.i("MicroMsg.CardCodeMgr", "start request code timer!");
    }

    private void aux() {
        x.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
        if (!this.kOp.cgx()) {
            this.kOp.TN();
        }
    }

    public final void auy() {
        auz();
        x.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.kOm);
        long j;
        if (this.kOm > 0) {
            j = (long) (this.kOm * 1000);
            this.kOq.K(j, j);
            x.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
            return;
        }
        j = (long) (this.kOn * 1000);
        this.kOq.K(j, j);
        x.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
    }

    public final void auz() {
        x.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
        if (!this.kOq.cgx()) {
            this.kOq.TN();
        }
    }
}
