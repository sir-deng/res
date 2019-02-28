package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.mm.bp.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.protocal.c.bwy;
import com.tencent.mm.protocal.c.bwz;
import com.tencent.mm.protocal.c.bxa;
import com.tencent.mm.protocal.c.bxb;
import com.tencent.mm.protocal.c.bxc;
import com.tencent.mm.protocal.c.bxf;
import com.tencent.mm.protocal.c.bxh;
import com.tencent.mm.protocal.c.bxj;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.bxl;
import com.tencent.mm.protocal.c.bxo;
import com.tencent.mm.protocal.c.bxx;
import com.tencent.mm.protocal.c.bxy;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;

public final class k {
    Timer bnp;
    g iTJ;
    n iTM;
    p iTO;
    private aa<Integer, Long> iUb = new aa(100);
    boolean iUc = false;
    private long iUd;
    LinkedList<j> iUe = new LinkedList();
    private final int iUf = 5000;
    private int iUg = 0;
    private long iUh = 0;
    d iul;
    Context mContext;

    public final void D(int i, String str) {
        a bxa = new bxa();
        bxa.xeI = i;
        bxa.fxq = str;
        a(o.a(bxa, this.iTJ, "callInterfaceResult"));
    }

    private synchronized void acG() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iTJ.iTz.size()) {
                int acA = i2 == 0 ? this.iTJ.acA() : ((bxc) this.iTJ.iTz.get(i2 - 1)).hQv;
                i = ((bxc) this.iTJ.iTz.get(i2)).hQv;
                if (acA - i != 1) {
                    bB(acA + 1, i - 1);
                }
                i = i2 + 1;
            }
        }
    }

    public final void bB(int i, int i2) {
        x.d("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != 0) {
            if (i <= i2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.iUb.get(Integer.valueOf(i)) == null || currentTimeMillis - ((Long) this.iUb.get(Integer.valueOf(i))).longValue() >= 3000) {
                    this.iUb.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
                } else {
                    x.i("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
                    return;
                }
            }
            return;
        }
        a bxy = new bxy();
        bxy.xfe = this.iTJ.iTg;
        bxy.xfq = i;
        bxy.xfr = i2;
        this.iTM.a(o.a(1005, bxy));
        this.iTJ.iTq = System.currentTimeMillis();
    }

    final void r(LinkedList<bxc> linkedList) {
        if (bi.cC(linkedList)) {
            x.w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
            return;
        }
        Iterator it = s(linkedList).iterator();
        while (it.hasNext()) {
            bxc bxc = (bxc) it.next();
            byte[] bArr = bxc.wgG.oz;
            String str = bxc.category;
            Object obj = -1;
            switch (str.hashCode()) {
                case -1680221061:
                    if (str.equals("callInterface")) {
                        obj = null;
                        break;
                    }
                    break;
                case -217209181:
                    if (str.equals("evaluateJavascriptResult")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 3441010:
                    if (str.equals("ping")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 95766211:
                    if (str.equals("domOp")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 1319027697:
                    if (str.equals("breakpoint")) {
                        obj = 3;
                        break;
                    }
                    break;
            }
            int i;
            switch (obj) {
                case null:
                    bwz bwz = (bwz) new bwz().aH(bArr);
                    x.i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", bwz.xeG, Integer.valueOf(bwz.xeI));
                    String str2 = bwz.xeG;
                    LinkedList linkedList2 = bwz.xeH;
                    bxj bxj = (bxj) this.iTJ.iTv.get(str2);
                    if (bxj != null) {
                        LinkedList linkedList3 = bxj.xeH;
                        if (linkedList2.size() >= linkedList3.size()) {
                            LinkedList linkedList4 = new LinkedList();
                            i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= linkedList3.size()) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    Method method = (Method) this.iTJ.iTu.get(str2);
                                    if (method == null) {
                                        x.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface callMethod is null");
                                        break;
                                    }
                                    Object invoke = linkedList4.size() == 0 ? method.invoke(this.iul, new Object[0]) : linkedList4.size() == 1 ? method.invoke(this.iul, new Object[]{linkedList4.get(0)}) : linkedList4.size() == 2 ? method.invoke(this.iul, new Object[]{linkedList4.get(0), linkedList4.get(1)}) : linkedList4.size() == 3 ? method.invoke(this.iul, new Object[]{linkedList4.get(0), linkedList4.get(1), linkedList4.get(2)}) : linkedList4.size() == 4 ? method.invoke(this.iul, new Object[]{linkedList4.get(0), linkedList4.get(1), linkedList4.get(2), linkedList4.get(3)}) : linkedList4.size() == 5 ? method.invoke(this.iul, new Object[]{linkedList4.get(0), linkedList4.get(1), linkedList4.get(2), linkedList4.get(3), linkedList4.get(4)}) : null;
                                    String valueOf = String.valueOf(invoke);
                                    if (!bi.oN(valueOf)) {
                                        D(bwz.xeI, valueOf);
                                    }
                                    l.a(str2, linkedList2, currentTimeMillis, bwz.bkL(), valueOf == null ? 0 : valueOf.length());
                                    break;
                                }
                                if ("Number".equals(linkedList3.get(i2))) {
                                    linkedList4.add(Integer.valueOf((String) linkedList2.get(i2)));
                                } else if ("Boolean".equals(linkedList3.get(i2))) {
                                    linkedList4.add(Boolean.valueOf((String) linkedList2.get(i2)));
                                } else {
                                    linkedList4.add(linkedList2.get(i2));
                                }
                                i = i2 + 1;
                            }
                        } else {
                            x.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
                            break;
                        }
                    }
                    x.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
                    break;
                case 1:
                    bxh bxh = (bxh) new bxh().aH(bArr);
                    x.i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", Integer.valueOf(bxh.xeT));
                    i = bxh.xeT;
                    String str3 = bxh.fxq;
                    a aVar = (a) this.iTJ.iTA.remove(Integer.valueOf(i));
                    if (aVar == null) {
                        break;
                    }
                    ValueCallback valueCallback = aVar.iTd;
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(str3);
                    }
                    x.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i + " ret: " + str3);
                    l.a(aVar, bxh.bkL());
                    break;
                case 2:
                    bxk bxk = (bxk) new bxk().aH(bArr);
                    a bxl = new bxl();
                    bxl.xeV = bxk.xeV;
                    bxl.xeW = l.acM();
                    x.i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", Integer.valueOf(bxl.xeW));
                    a(o.a(bxl, this.iTJ, "pong"));
                    break;
                case 3:
                    bwy bwy = (bwy) new bwy().aH(bArr);
                    if (this.iTJ.acC() != bwy.xeE) {
                        if (bwy.xeE) {
                            this.iTJ.cx(true);
                        } else {
                            this.iTJ.cx(false);
                        }
                        this.iTO.acO();
                        this.iTO.acR();
                        break;
                    }
                    break;
                case 4:
                    bxf bxf = (bxf) new bxf().aH(bArr);
                    x.d("MicroMsg.RemoteDebugMsgMrg", "onDomOp");
                    if (bxf.xeS == this.iTJ.iTf.iuk.isX.ajy().aeO().hashCode()) {
                        this.iTJ.iTf.a("remoteDebugCommand", bxf.xeR, null);
                        break;
                    } else {
                        x.w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", Integer.valueOf(bxf.xeS), Integer.valueOf(this.iTJ.iTf.iuk.isX.ajy().aeO().hashCode()));
                        break;
                    }
                default:
                    break;
            }
        }
        x.i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", Integer.valueOf(linkedList.size()), Integer.valueOf(this.iTJ.acA()));
        g gVar = this.iTJ;
        gVar.iTC += (long) linkedList.size();
        acG();
    }

    private synchronized LinkedList<bxc> s(LinkedList<bxc> linkedList) {
        LinkedList<bxc> linkedList2;
        if (linkedList == null) {
            linkedList2 = null;
        } else {
            LinkedList<bxc> linkedList3 = new LinkedList();
            Collection linkedList4 = new LinkedList();
            this.iTJ.iTz.addAll(linkedList);
            Collections.sort(this.iTJ.iTz, new Comparator<bxc>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    bxc bxc = (bxc) obj;
                    bxc bxc2 = (bxc) obj2;
                    return (bxc == null || bxc2 == null) ? 0 : bxc.hQv - bxc2.hQv;
                }
            });
            int acA = this.iTJ.acA();
            Iterator it = this.iTJ.iTz.iterator();
            int i = acA;
            while (it.hasNext()) {
                bxc bxc = (bxc) it.next();
                if (bxc != null) {
                    if (bxc.hQv > i) {
                        if (bxc.hQv - i != 1) {
                            break;
                        }
                        linkedList3.add(bxc);
                        i = bxc.hQv;
                    } else {
                        linkedList4.add(bxc);
                    }
                }
            }
            this.iTJ.jU(i);
            this.iTJ.iTz.removeAll(linkedList3);
            this.iTJ.iTz.removeAll(linkedList4);
            x.d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", Integer.valueOf(linkedList3.size()));
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }

    public final void a(j jVar) {
        if (!this.iTJ.acE()) {
            synchronized (this.iTJ.mLock) {
                if (System.currentTimeMillis() - this.iTJ.iTn <= 16 || this.iUc) {
                    this.iUe.add(jVar);
                    long currentTimeMillis = System.currentTimeMillis();
                    synchronized (this.iTJ.mLock) {
                        if (!this.iUc || currentTimeMillis - this.iUd >= 32) {
                            this.iUd = currentTimeMillis;
                            if (bi.cC(this.iUe)) {
                            } else {
                                this.iUc = true;
                                int currentTimeMillis2 = (int) (16 - (System.currentTimeMillis() - this.iTJ.iTn));
                                if (currentTimeMillis2 <= 0) {
                                    currentTimeMillis2 = 16;
                                }
                                c.Dt().g(new Runnable() {
                                    public final void run() {
                                        LinkedList linkedList = new LinkedList();
                                        synchronized (k.this.iTJ.mLock) {
                                            linkedList.addAll(k.this.iUe);
                                            k.this.iUe.clear();
                                            k.this.iUc = false;
                                        }
                                        k.this.a(linkedList, true);
                                    }
                                }, (long) currentTimeMillis2);
                            }
                        }
                    }
                    return;
                }
            }
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(jVar);
        a(linkedList, true);
    }

    final synchronized void a(LinkedList<j> linkedList, boolean z) {
        a(linkedList, z, false);
    }

    private synchronized void a(LinkedList<j> linkedList, boolean z, boolean z2) {
        if (!bi.cC(linkedList)) {
            a bxo = new bxo();
            bxo.xfe = this.iTJ.iTg;
            bxo.xff = this.iTJ.acA();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bxo.xeU.add(((j) it.next()).iTS);
            }
            bxb a = o.a(1006, bxo);
            if (!this.iTJ.isBusy() || z2) {
                x.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", Integer.valueOf(linkedList.size()));
                this.iTM.a(a);
            } else {
                x.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
            }
            if (z) {
                t(linkedList);
            }
            int i = a.pK;
            g gVar = this.iTJ;
            gVar.iTn = System.currentTimeMillis();
            gVar.iTp = System.currentTimeMillis();
            if (!this.iTJ.isBusy()) {
                this.iUg = 0;
            }
            f fVar = new f();
            fVar.size = a.bkL();
            fVar.iTe = System.currentTimeMillis();
            this.iTJ.iTy.put(a.njL, fVar);
        }
    }

    private synchronized void t(LinkedList<j> linkedList) {
        x.d("MicroMsg.RemoteDebugMsgMrg", "addToSendingMsg");
        if (!bi.cC(linkedList)) {
            this.iTJ.iTx.addAll(linkedList);
        }
    }

    public final synchronized void acH() {
        int i = 0;
        synchronized (this) {
            if (!this.iTJ.isBusy()) {
                long currentTimeMillis = System.currentTimeMillis();
                LinkedList linkedList = new LinkedList();
                Iterator it = this.iTJ.iTx.iterator();
                while (it.hasNext()) {
                    int i2;
                    j jVar = (j) it.next();
                    if (currentTimeMillis - jVar.iTe > 5000) {
                        jVar.iTe = System.currentTimeMillis();
                        linkedList.add(jVar);
                        i2 = jVar.iTT + i;
                        if (((long) i2) >= HardCoderJNI.ACTION_ALLOC_MEMORY || linkedList.size() > 800) {
                            x.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", Integer.valueOf(linkedList.size()));
                            a(linkedList, false);
                            linkedList.clear();
                            break;
                        }
                    } else {
                        i2 = i;
                    }
                    i = i2;
                }
                if (!bi.cC(linkedList)) {
                    x.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", Integer.valueOf(linkedList.size()));
                    a(linkedList, false);
                }
            }
        }
    }

    public final synchronized boolean acI() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.iUh < ((long) this.iUg)) {
            z = false;
        } else {
            j jVar;
            this.iUh = currentTimeMillis;
            if (this.iUg < 5000) {
                this.iUg += 1000;
            } else {
                this.iUg = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = this.iTJ.iTx.iterator();
            while (it.hasNext()) {
                jVar = (j) it.next();
                if (currentTimeMillis - jVar.iTe > 5000) {
                    jVar.iTe = System.currentTimeMillis();
                    linkedList.add(jVar);
                    a(linkedList, false, true);
                    z = true;
                    break;
                }
            }
            if (this.iTJ.iTx.size() > 0) {
                jVar = (j) this.iTJ.iTx.get(0);
                jVar.iTe = System.currentTimeMillis();
                linkedList.add(jVar);
                a(linkedList, false, true);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final void quit() {
        x.i("MicroMsg.RemoteDebugMsgMrg", "quit");
        a bxx = new bxx();
        bxx.xfe = this.iTJ.iTg;
        this.iTM.a(o.a(1004, bxx));
    }

    public final synchronized void bC(int i, int i2) {
        x.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        Collection linkedList = new LinkedList();
        Iterator it = this.iTJ.iTx.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (jVar.iTS == null) {
                linkedList.add(jVar);
            } else if (jVar.iTS.hQv >= i && jVar.iTS.hQv <= i2) {
                linkedList.add(jVar);
            }
        }
        this.iTJ.iTx.removeAll(linkedList);
    }

    public final synchronized void acJ() {
        x.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        Collection linkedList = new LinkedList();
        Iterator it = this.iTJ.iTx.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (jVar.iTS == null) {
                linkedList.add(jVar);
            } else if (jVar.iTS.hQv <= this.iTJ.acB()) {
                linkedList.add(jVar);
            }
        }
        this.iTJ.iTx.removeAll(linkedList);
    }

    public final void acK() {
        x.i("MicroMsg.RemoteDebugMsgMrg", "onClose");
        if (this.bnp != null) {
            this.bnp.cancel();
        }
    }
}
