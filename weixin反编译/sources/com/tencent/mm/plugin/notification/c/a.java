package com.tencent.mm.plugin.notification.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.app.z.d;
import com.tencent.mm.f.a.kf;
import com.tencent.mm.f.a.ry;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class a<T> implements c {
    public Context mContext;
    public b oZD;
    protected FailSendMsgNotification oZE;
    protected boolean oZF;
    protected ArrayList<Long> oZG;
    protected ArrayList<Long> oZH;
    protected ArrayList<Long> oZI;
    private ArrayList<al> oZJ;
    private al oZK;
    private c oZL;

    public abstract void K(ArrayList<Long> arrayList);

    public abstract String U(int i, int i2, int i3);

    public abstract long bE(T t);

    public abstract ArrayList<Long> bF(T t);

    public abstract void bhd();

    public abstract void dU(long j);

    public abstract boolean dV(long j);

    public abstract String dd(int i, int i2);

    public abstract String de(int i, int i2);

    public abstract int getType();

    public abstract String uA(int i);

    static /* synthetic */ void a(a aVar) {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, mMsgList.size:%d", Integer.valueOf(aVar.oZD.oZO.size()));
        aVar.bgV();
        if (VERSION.SDK_INT >= 16) {
            aVar.oZE.Ht(aVar.uA(aVar.oZD.oZO.size()));
        }
        x.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, after check, mMsgList.size:%d", Integer.valueOf(aVar.oZD.oZO.size()));
    }

    static /* synthetic */ void a(a aVar, long j) {
        while (!aVar.dV(j)) {
            aVar.oZH.add(Long.valueOf(j));
            x.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, msg:%d not exist", Long.valueOf(j));
            aVar.bgR();
            j = aVar.oZD.bhh();
            if (j == -1) {
                x.e("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg error, finalMsgId is -1, may be resend finish");
                if (aVar.oZG.size() + aVar.oZH.size() >= aVar.oZD.oZO.size()) {
                    x.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, resend finish");
                    aVar.bgS();
                    return;
                }
                return;
            }
        }
        x.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, finalMsgId:%d", Long.valueOf(j));
        aVar.dU(j);
        al alVar = new al(new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                if (!(a.this.oZG.contains(Long.valueOf(j)) || a.this.oZH.contains(Long.valueOf(j)) || !a.this.oZD.dX(j))) {
                    x.i("MicroMsg.AbstractSendMsgFailNotification", "msg:%d send timeout, move this message to fail list, continue send next message", Long.valueOf(j));
                    a.this.oZH.add(Long.valueOf(j));
                    a.this.oZI.add(Long.valueOf(j));
                    if (a.this.oZG.size() + a.this.oZH.size() >= a.this.oZD.oZO.size()) {
                        a.this.bgS();
                    } else {
                        a.this.dT(a.this.oZD.bhh());
                    }
                }
                return true;
            }
        }, false);
        alVar.K(1800000, 1800000);
        aVar.oZJ.add(alVar);
    }

    public a() {
        this.oZD = null;
        this.oZE = null;
        this.oZF = false;
        this.mContext = null;
        this.oZG = null;
        this.oZH = null;
        this.oZI = null;
        this.oZJ = new ArrayList();
        this.oZK = null;
        this.oZL = new c<ry>() {
            {
                this.xmG = ry.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                ry ryVar = (ry) bVar;
                a aVar = a.this;
                long j = ryVar.fKy.fKz;
                x.i("MicroMsg.AbstractSendMsgFailNotification", "updateMsgIdInMsgList, oldMsgId:%d, newMsgId:%d", Long.valueOf(j), Long.valueOf(ryVar.fKy.fKA));
                if (aVar.oZD.dX(j)) {
                    b bVar2 = aVar.oZD;
                    int indexOf = bVar2.oZO.indexOf(Long.valueOf(j));
                    if (indexOf != -1) {
                        bVar2.oZO.set(indexOf, Long.valueOf(r4));
                    }
                }
                return false;
            }
        };
        this.oZD = new b();
        this.oZE = new FailSendMsgNotification(getType());
        this.oZF = false;
        this.mContext = ad.getContext();
        this.oZG = new ArrayList();
        this.oZH = new ArrayList();
        this.oZI = new ArrayList();
        this.oZE.pax = new com.tencent.mm.plugin.notification.ui.a() {
            public final void bhe() {
                x.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
                ah.y(new Runnable() {
                    public final void run() {
                        g.pWK.h(11425, Integer.valueOf(a.this.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0));
                        a.this.bhb();
                        a.a(a.this);
                        a.this.bgU();
                    }
                });
            }

            public final void bhf() {
                x.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
                ah.y(new Runnable() {
                    public final void run() {
                        g.pWK.h(11425, Integer.valueOf(a.this.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0));
                        a.this.bhb();
                        a.this.bgX();
                        a.this.aUB();
                        a.this.oZE.dismiss();
                    }
                });
            }
        };
        this.oZE.pay = new com.tencent.mm.plugin.notification.ui.b() {
            public final void bhg() {
                g.pWK.h(11425, Integer.valueOf(a.this.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
                a.this.bhb();
                a.this.bhd();
                if (!a.this.oZF) {
                    a.this.oZE.dismiss();
                }
            }
        };
        this.oZE.paz = new com.tencent.mm.plugin.notification.ui.c() {
            public final void onDismiss() {
                a.this.aUB();
            }
        };
        bgP();
    }

    private void bgP() {
        this.oZK = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                if (!a.this.oZF) {
                    return false;
                }
                x.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", Integer.valueOf(a.this.oZD.oZO.size()), Integer.valueOf(a.this.oZG.size()), Integer.valueOf(a.this.oZH.size()));
                a.this.bgV();
                x.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", Integer.valueOf(a.this.oZD.oZO.size()), Integer.valueOf(a.this.oZG.size()), Integer.valueOf(a.this.oZH.size()));
                if (a.this.oZD.oZO.size() > 0) {
                    a.this.bgR();
                    return true;
                }
                a.this.bgS();
                return true;
            }
        }, true);
    }

    public final void bC(T t) {
        if (t != null) {
            x.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", Long.valueOf(bE(t)), bgY(), Boolean.valueOf(this.oZF));
            if (this.oZF) {
                if (this.oZD.dX(bE(t)) && !this.oZH.contains(Long.valueOf(bE(t)))) {
                    this.oZH.add(Long.valueOf(bE(t)));
                }
                if (!this.oZD.dX(bE(t))) {
                    x.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
                    this.oZD.dW(bE(t));
                }
                bgR();
                x.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", Integer.valueOf(this.oZG.size()), Integer.valueOf(this.oZH.size()));
                if (this.oZG.size() + this.oZH.size() < this.oZD.oZO.size()) {
                    long bhh = this.oZD.bhh();
                    if (bhh == -1) {
                        x.e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    x.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", Long.valueOf(bhh));
                    bhc();
                    dT(bhh);
                    return;
                }
                bgS();
            } else if (this.oZI.contains(Long.valueOf(bE(t)))) {
                this.oZI.remove(Long.valueOf(bE(t)));
            } else if (t == null) {
                x.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
            } else {
                Collection bF = bF(t);
                if (bF == null || bF.size() <= 0) {
                    x.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
                    return;
                }
                aUB();
                b bVar = this.oZD;
                if (bF != null && bF.size() > 0) {
                    bVar.oZO.addAll(bF);
                }
                bhc();
                x.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", Integer.valueOf(this.oZD.oZO.size()), bgY());
                g.pWK.h(11426, Integer.valueOf(getType()));
                ah.h(new Runnable() {
                    public final void run() {
                        a.this.bgQ();
                    }
                }, 1000);
            }
        }
    }

    private void bgQ() {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", Boolean.valueOf(f.bho()));
        this.oZE.paB = uA(this.oZD.oZO.size());
        this.oZE.bht();
        if (!f.bho() && !this.oZE.paG) {
            this.oZE.paA = uA(this.oZD.oZO.size());
            this.oZE.bhs();
            this.oZE.bhr();
            x.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
            this.oZE.show();
            com.tencent.mm.sdk.b.a.xmy.c(this.oZL);
            com.tencent.mm.sdk.b.a.xmy.b(this.oZL);
        } else if (this.oZE.paG) {
            this.oZE.bhs();
            this.oZE.bhr();
            x.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
            this.oZE.Ht(uA(this.oZD.oZO.size()));
            com.tencent.mm.sdk.b.a.xmy.c(this.oZL);
            com.tencent.mm.sdk.b.a.xmy.b(this.oZL);
        } else {
            x.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", Boolean.valueOf(f.bho()));
        }
    }

    public final void bD(T t) {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", Long.valueOf(bE(t)), bgY());
        if (this.oZD.dX(bE(t))) {
            long bE = bE(t);
            if (this.oZI.contains(Long.valueOf(bE)) && this.oZH.contains(Long.valueOf(bE))) {
                x.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
                this.oZI.remove(Long.valueOf(bE));
                this.oZH.remove(Long.valueOf(bE));
            }
            if (this.oZF) {
                this.oZG.add(Long.valueOf(bE));
                bgR();
                x.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", Integer.valueOf(this.oZG.size()), Integer.valueOf(this.oZH.size()));
                if (this.oZG.size() + this.oZH.size() < this.oZD.oZO.size()) {
                    bE = this.oZD.bhh();
                    if (bE == -1) {
                        x.e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    x.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", Long.valueOf(bE));
                    bhc();
                    dT(bE);
                    return;
                }
                bgS();
                return;
            }
            this.oZD.remove(bE(t));
            if (this.oZD.oZO.size() == 0) {
                this.oZE.dismiss();
                aUB();
                com.tencent.mm.plugin.notification.d.b.uC(getType());
                return;
            }
            x.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
            this.oZE.Ht(uA(this.oZD.oZO.size()));
        }
    }

    private void bgR() {
        if (VERSION.SDK_INT >= 16) {
            this.oZE.paB = uA(this.oZD.oZO.size());
            if (this.oZH.size() <= 0) {
                this.oZE.Ht(dd(this.oZD.oZO.size(), this.oZG.size() + this.oZH.size()));
            } else {
                this.oZE.Ht(U(this.oZD.oZO.size(), this.oZG.size() + this.oZH.size(), this.oZH.size()));
            }
        }
    }

    private void bgS() {
        Long l;
        this.oZF = false;
        x.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", Integer.valueOf(this.oZD.oZO.size()), Integer.valueOf(this.oZH.size()), Integer.valueOf(this.oZG.size()));
        x.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", Integer.valueOf(this.oZD.oZO.size()), Integer.valueOf(this.oZG.size()), Integer.valueOf(this.oZH.size()));
        bgV();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.oZG.iterator();
        while (it.hasNext()) {
            l = (Long) it.next();
            if (!dV(l.longValue())) {
                arrayList.add(l);
            }
        }
        it = arrayList.iterator();
        while (it.hasNext()) {
            this.oZG.remove((Long) it.next());
        }
        arrayList.clear();
        it = this.oZH.iterator();
        while (it.hasNext()) {
            l = (Long) it.next();
            if (!dV(l.longValue())) {
                arrayList.add(l);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.oZH.remove((Long) it2.next());
        }
        x.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", Integer.valueOf(this.oZD.oZO.size()), Integer.valueOf(this.oZG.size()), Integer.valueOf(this.oZH.size()));
        if (this.oZH.size() <= 0 || VERSION.SDK_INT < 16) {
            com.tencent.mm.plugin.notification.d.b.uC(getType());
        }
        g.pWK.h(11425, Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.oZG.size()), Integer.valueOf(this.oZH.size()));
        if (VERSION.SDK_INT >= 16) {
            this.oZE.bhs();
            this.oZE.paB = uA(this.oZD.oZO.size());
            FailSendMsgNotification failSendMsgNotification = this.oZE;
            this.oZD.oZO.size();
            failSendMsgNotification.Ht(de(this.oZG.size(), this.oZH.size()));
            this.oZE.bhr();
            if (this.oZH.size() > 0) {
                this.oZE.bht();
                this.oZE.show();
                bha();
                bhc();
            }
        }
        b kfVar = new kf();
        kfVar.fCt.type = getType();
        com.tencent.mm.sdk.b.a.xmy.m(kfVar);
        if (this.oZK != null) {
            this.oZK.TN();
        } else {
            x.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
        }
        bgW();
        com.tencent.mm.sdk.b.a.xmy.c(this.oZL);
        bgT();
    }

    public void bgT() {
    }

    public final void bgU() {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", Integer.valueOf(this.oZD.oZO.size()));
        this.oZF = true;
        if (VERSION.SDK_INT >= 16) {
            FailSendMsgNotification failSendMsgNotification = this.oZE;
            failSendMsgNotification.paI = false;
            failSendMsgNotification.pau = new d(failSendMsgNotification.mContext);
            failSendMsgNotification.bhq();
            failSendMsgNotification.show();
            x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
            failSendMsgNotification = this.oZE;
            failSendMsgNotification.pau.c(2, true);
            failSendMsgNotification.paH = true;
            failSendMsgNotification.show();
            x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
            this.oZE.Ht(dd(this.oZD.oZO.size(), 0));
        }
        this.oZD.currentIndex = 0;
        bgW();
        com.tencent.mm.sdk.b.a.xmy.c(this.oZL);
        com.tencent.mm.sdk.b.a.xmy.b(this.oZL);
        dT(this.oZD.bhh());
        if (this.oZK != null) {
            this.oZK.K(300000, 300000);
        } else {
            x.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
        }
    }

    void bgV() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.oZD.oZO.size(); i++) {
            long j = this.oZD.get(i);
            if (!dV(j)) {
                arrayList.add(Long.valueOf(j));
            }
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.oZD.remove(((Long) it.next()).longValue());
            }
        }
    }

    final void dT(final long j) {
        ah.h(new Runnable() {
            public final void run() {
                a.a(a.this, j);
            }
        }, 200);
    }

    private void bgW() {
        Iterator it = this.oZJ.iterator();
        while (it.hasNext()) {
            ((al) it.next()).TN();
        }
        this.oZJ.clear();
        this.oZI.clear();
    }

    public final void bgX() {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", Integer.valueOf(this.oZD.oZO.size()));
        if (this.oZD.oZO.size() > 0) {
            b bVar = this.oZD;
            ArrayList arrayList = new ArrayList();
            Iterator it = bVar.oZO.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Long) it.next()).longValue()));
            }
            K(arrayList);
        }
    }

    private void aUB() {
        this.oZD.clear();
        this.oZF = false;
        this.oZG.clear();
        this.oZH.clear();
        bgW();
    }

    private String bgY() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < this.oZD.oZO.size(); i++) {
            stringBuilder.append(this.oZD.get(i) + ", ");
        }
        return stringBuilder.toString();
    }

    public final FailSendMsgNotification bgZ() {
        return this.oZE;
    }

    private void bha() {
        this.oZD.currentIndex = 0;
        if (this.oZG.size() > 0) {
            Iterator it = this.oZG.iterator();
            while (it.hasNext()) {
                this.oZD.remove(((Long) it.next()).longValue());
            }
        }
        this.oZG.clear();
        this.oZH.clear();
    }

    protected final void bhb() {
        if (this.oZD == null || this.oZD.oZO.size() == 0) {
            x.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
            com.tencent.mm.plugin.notification.d.b.a uB = com.tencent.mm.plugin.notification.d.b.uB(getType());
            if (uB == null) {
                x.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
                return;
            }
            if (this.oZK == null) {
                bgP();
            }
            b bVar = uB.oZQ;
            Collection collection = uB.oZS;
            Collection collection2 = uB.oZT;
            int i = uB.oZR;
            if (collection.size() == 0 && collection2.size() == 0 && i == 0) {
                x.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
                this.oZD.clear();
                this.oZD = bVar;
                this.oZG.clear();
                this.oZH.clear();
                bgQ();
            } else if (collection.size() + collection2.size() >= bVar.oZO.size()) {
                x.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
                bgS();
            } else {
                x.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
                this.oZD.clear();
                this.oZD = bVar;
                this.oZD.currentIndex = i;
                this.oZG.clear();
                this.oZG.addAll(collection);
                this.oZH.clear();
                this.oZH.addAll(collection2);
                bgR();
            }
        }
    }

    private void bhc() {
        com.tencent.mm.plugin.notification.d.b.a(getType(), new com.tencent.mm.plugin.notification.d.b.a(this.oZD, this.oZD.currentIndex, this.oZG, this.oZH));
    }
}
