package com.tencent.mm.plugin.webview.fts.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.webview.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b implements c {
    Map<a, a> gLL = new HashMap();
    Map<a, CountDownLatch> ttI = new ConcurrentHashMap();
    private k ttJ = new k() {
        public final void b(h hVar) {
            a aVar = (a) hVar.mRL.mQY;
            if (aVar != null) {
                CountDownLatch countDownLatch = (CountDownLatch) b.this.ttI.remove(aVar);
                switch (hVar.bjW) {
                    case -3:
                    case -2:
                    case -1:
                        aVar.cm(Collections.emptyList());
                        break;
                    case 0:
                        if (hVar.mRN != null && hVar.mRN.size() != 0) {
                            aVar.cm(hVar.mRN);
                            break;
                        }
                        x.i("FTSMatchContact", "local contact search size 0");
                        aVar.cm(Collections.emptyList());
                        countDownLatch.countDown();
                        return;
                }
                countDownLatch.countDown();
            }
        }
    };
    private k ttK = new k() {
        public final void b(h hVar) {
            a aVar = (a) hVar.mRL.mQY;
            if (aVar != null) {
                a aVar2 = (a) b.this.gLL.remove(aVar);
                if (aVar2 != null) {
                    switch (hVar.bjW) {
                        case -3:
                        case -2:
                        case -1:
                            aVar.cm(Collections.emptyList());
                            break;
                        case 0:
                            if (hVar.mRN != null && hVar.mRN.size() != 0) {
                                aVar.cm(hVar.mRN);
                                break;
                            }
                            x.i("FTSMatchContact", "local contact search size 0");
                            aVar2.bPU();
                            return;
                            break;
                    }
                    aVar2.bPU();
                }
            }
        }
    };

    public final a OD(String str) {
        a eVar = new e(str, Integer.MAX_VALUE);
        CountDownLatch countDownLatch = (CountDownLatch) this.ttI.get(eVar);
        if (countDownLatch != null) {
            x.i("FTSMatchContact", "have a running task ,wait for result, query %s,maxMatch %d", str, Integer.valueOf(Integer.MAX_VALUE));
        } else if (a(eVar, this.ttJ)) {
            x.i("FTSMatchContact", "not have a running task ,start new task, query %s,maxMatch %d", str, Integer.valueOf(Integer.MAX_VALUE));
            countDownLatch = new CountDownLatch(1);
            this.ttI.put(eVar, countDownLatch);
        } else {
            x.i("FTSMatchContact", "start new task fail, query %s,maxMatch %d", str, Integer.valueOf(Integer.MAX_VALUE));
        }
        if (countDownLatch != null) {
            try {
                countDownLatch.await(2000, TimeUnit.MILLISECONDS);
            } catch (Throwable e) {
                x.printErrStackTrace("FTSMatchContact", e, "", new Object[0]);
            }
        }
        this.ttI.remove(eVar);
        return eVar;
    }

    public final void a(a aVar, a aVar2) {
        this.gLL.put(aVar, aVar2);
        a(aVar, this.ttK);
    }

    private static boolean a(a aVar, k kVar) {
        if (bi.oN(aVar.fEe)) {
            return false;
        }
        int[] iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
        int[] iArr2 = new int[]{1, 5};
        g gVar = new g();
        gVar.fEe = aVar.fEe;
        gVar.mRF = iArr;
        gVar.mRG = iArr2;
        gVar.mRH = aVar.ttH;
        gVar.mRJ = com.tencent.mm.plugin.fts.a.c.b.mSk;
        gVar.mRI = new HashSet();
        gVar.mRK = kVar;
        gVar.scene = 1;
        ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar).mQY = aVar;
        return true;
    }
}
