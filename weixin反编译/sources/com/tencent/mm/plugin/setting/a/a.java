package com.tencent.mm.plugin.setting.a;

import android.database.Cursor;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ht;
import com.tencent.mm.f.a.sg;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class a {
    public final ah gSq;
    Object mLock = new Object();
    public Runnable mRunnable;
    public long neh;
    public boolean qmj;
    public boolean qmk;
    public boolean qml;
    final CountDownLatch qmm;
    HashSet<String> qmn = new HashSet();
    HashSet<String> qmo = new HashSet();
    HashSet<String> qmp = new HashSet();
    HashSet<String> qmq = new HashSet();
    public a qmr;
    public h qms;

    class a implements e, Runnable {
        CountDownLatch lVE;
        k qmA;
        h qmz;
        long start;

        a(h hVar, CountDownLatch countDownLatch) {
            this.qmz = hVar;
            this.lVE = countDownLatch;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                this.lVE.countDown();
            } else if (kVar.getType() == JsApiSetAudioState.CTRL_INDEX) {
                this.qmA = kVar;
                com.tencent.mm.sdk.f.e.post(this, "load_unfamiliar_contact");
            }
        }

        public final void run() {
            b sgVar = new sg();
            sgVar.fKL.fKN = this.qmA;
            com.tencent.mm.sdk.b.a.xmy.m(sgVar);
            int i = sgVar.fKM.state;
            Object obj = sgVar.fKM.fKO;
            String str = "MicroMsg.UnfamiliarContactEngine";
            String str2 = "[callback] state:%s,tagList is null?%s,tagList size:%s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(obj == null);
            objArr[2] = Integer.valueOf(obj == null ? 0 : obj.size());
            x.i(str, str2, objArr);
            if (i != 1) {
                if (obj != null) {
                    a.this.qmq.addAll(obj);
                }
                x.i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", Long.valueOf(System.currentTimeMillis() - this.start));
                this.lVE.countDown();
                return;
            }
            if (this.qmz != null) {
                ah.y(new Runnable() {
                    public final void run() {
                        a.this.qmz.a(UnfamiliarContactDetailUI.e.OVER_ONE_MIN);
                    }
                });
            }
            a.this.gSq.g(new Runnable() {
                public final void run() {
                    a.brb();
                }
            }, 30000);
        }

        static void brb() {
            b htVar = new ht();
            htVar.fyV.fvG = 3;
            com.tencent.mm.sdk.b.a.xmy.m(htVar);
        }
    }

    static /* synthetic */ void a(a aVar, LinkedList linkedList) {
        if (aVar.qmk) {
            aVar.qmr = new a(aVar.qms, aVar.qmm);
            e eVar = aVar.qmr;
            eVar.start = System.currentTimeMillis();
            as.CN().a((int) JsApiSetAudioState.CTRL_INDEX, eVar);
            a.brb();
        }
        if (aVar.qmj) {
            final HashSet hashSet = new HashSet();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
            final long currentTimeMillis = System.currentTimeMillis() - 15552000000L;
            x.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] timestamp:%s size:%s", Long.valueOf(currentTimeMillis), Integer.valueOf(hashSet.size()));
            final long currentTimeMillis2 = System.currentTimeMillis();
            g gVar = new g();
            gVar.mRC = 9;
            gVar.fEe = String.valueOf(currentTimeMillis);
            gVar.mRK = new com.tencent.mm.plugin.fts.a.k() {
                public final void b(com.tencent.mm.plugin.fts.a.a.h hVar) {
                    List<j> list = hVar.mRN;
                    if (list != null) {
                        for (j jVar : list) {
                            hashSet.remove(jVar.mRd);
                            a.this.qmo.add(jVar.mRd);
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        as.Hm();
                        if (c.Fh().m(str, currentTimeMillis, System.currentTimeMillis()) > 0) {
                            x.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] talker:%s voipCount:%s", str, Integer.valueOf(c.Fh().m(str, currentTimeMillis, System.currentTimeMillis())));
                        } else {
                            as.Hm();
                            Cursor a = c.Fh().a(str, currentTimeMillis, System.currentTimeMillis(), true);
                            if (a.getCount() > 0) {
                                as.Hm();
                                Cursor a2 = c.Fh().a(str, currentTimeMillis, System.currentTimeMillis(), false);
                                if (a2.getCount() <= 0) {
                                    a.this.qmo.add(str);
                                }
                                a2.close();
                            } else {
                                a.this.qmo.add(str);
                            }
                            a.close();
                        }
                    }
                    x.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] query:%s cost:%sms", Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    a.this.qmm.countDown();
                }
            };
            gVar.handler = aVar.gSq.cgs();
            ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
        }
        if (aVar.qml) {
            aVar.f(linkedList, 0);
        }
        Runnable anonymousClass2 = new Runnable() {
            public final void run() {
                try {
                    a.this.qmm.await();
                    long currentTimeMillis = System.currentTimeMillis();
                    a.this.qmn.clear();
                    a.this.qmo.remove(q.FY());
                    a.this.qmn.addAll(a.this.qmo);
                    a.this.qmn.addAll(a.this.qmp);
                    a.this.qmn.addAll(a.this.qmq);
                    if (a.this.qmk) {
                        a.this.qmn.retainAll(a.this.qmq);
                    }
                    if (a.this.qml) {
                        a.this.qmn.retainAll(a.this.qmp);
                    }
                    if (a.this.qmj) {
                        a.this.qmn.retainAll(a.this.qmo);
                    }
                    a.this.qms.e(a.this.qmn);
                    x.i("MicroMsg.UnfamiliarContactEngine", "[onResult] :%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    ah.y(new Runnable() {
                        public final void run() {
                            a.this.qms.onSuccess();
                        }
                    });
                    x.i("MicroMsg.UnfamiliarContactEngine", "all cost:%sms", Long.valueOf(System.currentTimeMillis() - a.this.neh));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.UnfamiliarContactEngine", e, "", new Object[0]);
                    ah.y(new Runnable() {
                        public final void run() {
                            a.this.qms.onError();
                        }
                    });
                }
            }
        };
        aVar.mRunnable = anonymousClass2;
        com.tencent.mm.sdk.f.e.post(anonymousClass2, "MicroMsg.UnfamiliarContactEngineAwait");
    }

    public a(boolean z, boolean z2, boolean z3, h hVar) {
        this.qmj = z;
        this.qmk = z2;
        this.qml = z3;
        x.i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", Integer.valueOf((this.qml ? 1 : 0) + ((this.qmj ? 1 : 0) + (this.qmk ? 1 : 0))), Boolean.valueOf(this.qmk), Boolean.valueOf(this.qmj), Boolean.valueOf(this.qml));
        this.qmm = new CountDownLatch(r0);
        this.gSq = new ah("UnfamiliarContactEngine");
        this.qms = hVar;
    }

    final void f(LinkedList<String> linkedList, int i) {
        final long currentTimeMillis = System.currentTimeMillis();
        final int size = i + 10 < linkedList.size() ? i + 10 : linkedList.size();
        final List subList = linkedList.subList(i, size);
        g gVar = new g();
        gVar.mRC = 8;
        gVar.fEe = bi.d(subList, ",");
        final LinkedList<String> linkedList2 = linkedList;
        gVar.mRK = new com.tencent.mm.plugin.fts.a.k() {
            final int asN = size;

            public final void b(com.tencent.mm.plugin.fts.a.a.h hVar) {
                List list = hVar.mRN;
                String str;
                String str2;
                if (list == null || list.size() <= 0) {
                    str = "MicroMsg.UnfamiliarContactEngine";
                    str2 = "[getSameChatInfoTask] list is null? %s ";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(subList == null);
                    x.e(str, str2, objArr);
                } else {
                    j jVar = (j) list.get(0);
                    if (jVar.userData == null || !(jVar.userData instanceof HashMap)) {
                        str2 = "MicroMsg.UnfamiliarContactEngine";
                        String str3 = "[getSameChatInfoTask] is null?%s is instanceof List";
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = Boolean.valueOf(jVar.userData == null);
                        objArr2[1] = Boolean.valueOf(jVar.userData instanceof HashMap);
                        x.e(str2, str3, objArr2);
                    } else {
                        HashMap hashMap = (HashMap) jVar.userData;
                        synchronized (a.this.mLock) {
                            for (String str4 : subList) {
                                if (hashMap.containsKey(str4)) {
                                    int i;
                                    for (j jVar2 : (List) hashMap.get(str4)) {
                                        if (jVar2.mRQ < 100) {
                                            i = 1;
                                            break;
                                        }
                                    }
                                    i = 0;
                                    if (i == 0) {
                                        a.this.qmp.add(str4);
                                    }
                                } else {
                                    a.this.qmp.add(str4);
                                }
                            }
                        }
                    }
                }
                if (this.asN >= linkedList2.size()) {
                    x.i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", Integer.valueOf(linkedList2.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    a.this.qmm.countDown();
                    return;
                }
                a.this.f(linkedList2, this.asN);
            }
        };
        gVar.handler = this.gSq.cgs();
        ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
    }
}
