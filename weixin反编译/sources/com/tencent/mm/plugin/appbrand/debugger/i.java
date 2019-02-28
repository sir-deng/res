package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.j.j.a;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.protocal.c.bxb;
import com.tencent.mm.protocal.c.bxd;
import com.tencent.mm.protocal.c.bxg;
import com.tencent.mm.protocal.c.bxi;
import com.tencent.mm.protocal.c.bxj;
import com.tencent.mm.protocal.c.bxm;
import com.tencent.mm.protocal.c.bxp;
import com.tencent.mm.protocal.c.bxq;
import com.tencent.mm.protocal.c.bxr;
import com.tencent.mm.protocal.c.bxs;
import com.tencent.mm.protocal.c.bxt;
import com.tencent.mm.protocal.c.bxu;
import com.tencent.mm.protocal.c.bxv;
import com.tencent.mm.protocal.c.bxw;
import com.tencent.mm.protocal.c.bxz;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public final class i implements b {
    g iTJ;
    String iTK;
    Activity iTL;
    n iTM;
    k iTN = new k();
    p iTO;
    a iTP = new a() {
        public final void a(h hVar) {
            x.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
            i.this.iTJ.iTp = System.currentTimeMillis();
            i.this.iTJ.iTB = 0;
            if (!bi.oN(i.this.iTJ.acz())) {
                i.a(i.this);
            }
            k kVar = i.this.iTN;
            kVar.acK();
            kVar.bnp = new Timer();
            kVar.bnp.schedule(new TimerTask() {
                public final void run() {
                    if (k.this.iTJ.isBusy() && k.this.acI()) {
                        x.i("MicroMsg.RemoteDebugMsgMrg", "testServer");
                    } else {
                        k.this.acH();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - k.this.iTJ.iTp >= 10000) {
                            k kVar = k.this;
                            com.tencent.mm.bp.a bxr = new bxr();
                            bxr.xfe = kVar.iTJ.iTg;
                            bxr.xff = kVar.iTJ.acA();
                            kVar.iTM.a(o.a(1001, bxr));
                        }
                        if (k.this.iTJ.it() && currentTimeMillis - k.this.iTJ.iTq >= 30000) {
                            k.this.bB(k.this.iTJ.acA(), 0);
                        }
                    }
                    ah.y(new Runnable() {
                        public final void run() {
                            p.h(p.this);
                            p.this.iUv.setText(p.this.getContext().getString(j.iDC, new Object[]{Integer.valueOf(p.this.iTJ.iTx.size()), Integer.valueOf(p.this.iTJ.iTw.size()), Long.valueOf(p.this.iTJ.iTC)}));
                        }
                    });
                }
            }, 100, 1000);
        }

        public final void rA(String str) {
            x.i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", str);
            i.this.iTO.rG(str);
        }

        public final void rB(String str) {
            i.this.iTJ.iTp = System.currentTimeMillis();
        }

        public final void e(ByteBuffer byteBuffer) {
            i.this.iTJ.iTp = System.currentTimeMillis();
            try {
                bxb bxb = (bxb) new bxb().aH(c.j(byteBuffer));
                if (bxb.wgG == null) {
                    x.w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
                    return;
                }
                byte[] bArr = bxb.wgG.oz;
                k kVar;
                switch (bxb.pK) {
                    case 1001:
                        o.a(i.this.iTJ, bxb.pK, ((bxs) new bxs().aH(bArr)).xfg, i.this.iTO, i.this.iTN);
                        i.this.iTJ.iTp = System.currentTimeMillis();
                        break;
                    case 1002:
                        bxw bxw = (bxw) new bxw().aH(bArr);
                        i iVar = i.this;
                        if (o.a(iVar.iTJ, 1002, bxw.xfg, iVar.iTO, iVar.iTN)) {
                            x.i("MicroMsg.RemoteDebugJsEngine", "onLogin");
                            if (bxw.xfp != null) {
                                if (!bxw.xfp.xeY) {
                                    x.i("MicroMsg.RemoteDebugJsEngine", "joinRoom");
                                    iVar.iTJ.eR(2);
                                    com.tencent.mm.bp.a bxt = new bxt();
                                    bxt.xfe = iVar.iTJ.iTg;
                                    bxt.xeZ = iVar.iTJ.iTl.iTE;
                                    bxt.username = "";
                                    bxt.xfo = iVar.iTJ.iTl.iTF;
                                    iVar.iTM.a(o.a(1003, bxt));
                                    break;
                                }
                                iVar.iTJ.iTk = bxw.xfp;
                                iVar.onReady();
                                break;
                            }
                            x.e("MicroMsg.RemoteDebugJsEngine", "onLogin room info is null");
                            break;
                        }
                        break;
                    case 1003:
                        if (o.a(i.this.iTJ, bxb.pK, ((bxu) new bxu().aH(bArr)).xfg, i.this.iTO, i.this.iTN)) {
                            i iVar2 = i.this;
                            WxaPkgWrappingInfo aaa = ab.aaa();
                            com.tencent.mm.bp.a bxq = new bxq();
                            bxd bxd = new bxd();
                            bxq.xfk = bxd;
                            bxq.xfl = iVar2.isW.acN();
                            bxq.xfn = iVar2.isW.iuk.isS.iRU.frM;
                            String pW = ab.pW("WAService.js");
                            if (!bi.oN(pW)) {
                                bxq.xfm = g.s(pW.getBytes());
                            }
                            bxd.xeO = aaa.iJb;
                            bxd.xeL = d.vHf;
                            bxd.xeK = d.vHj;
                            bxd.xeN = f.ag(iVar2.iTL, d.vHl);
                            bxd.xeM = d.vHi;
                            bxd.xeQ = iVar2.iTL.getResources().getDisplayMetrics().density;
                            bxd.xeP = ((float) iVar2.iTL.getResources().getDisplayMetrics().widthPixels) / bxd.xeQ;
                            bxm bxm = new bxm();
                            k kVar2 = iVar2.iTN;
                            bxm.xeF = "WeixinJSCore";
                            kVar2.iTJ.iTv.clear();
                            for (Method method : kVar2.iul.getClass().getMethods()) {
                                if (method.isAnnotationPresent(JavascriptInterface.class)) {
                                    Class[] parameterTypes = method.getParameterTypes();
                                    if (parameterTypes.length > 5) {
                                        x.e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
                                    } else {
                                        bxj bxj = new bxj();
                                        bxj.xeG = method.getName();
                                        for (Class cls : parameterTypes) {
                                            if (cls == String.class) {
                                                bxj.xeH.add("String");
                                            } else if (cls == Integer.TYPE || cls == Integer.class) {
                                                bxj.xeH.add("Number");
                                            } else if (cls == Boolean.TYPE || cls == Boolean.class) {
                                                bxj.xeH.add("Boolean");
                                            } else {
                                                bxj.xeH.add("Unknown");
                                            }
                                        }
                                        bxm.xeX.add(bxj);
                                        kVar2.iTJ.iTv.put(bxj.xeG, bxj);
                                        kVar2.iTJ.iTu.put(method.getName(), method);
                                    }
                                }
                            }
                            bxq.xfj = bxm;
                            iVar2.iTN.a(o.a(bxq, iVar2.iTJ, "setupContext"));
                            x.d("MicroMsg.RemoteDebugJsEngine", "setupContext %s/%s/%d", bxq.xfm, bxq.xfn, Integer.valueOf(bxd.xeO));
                            break;
                        }
                        break;
                    case 1004:
                        k kVar3 = i.this.iTN;
                        x.i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
                        kVar3.iTJ.eR(4);
                        n nVar = kVar3.iTM;
                        String str = "quit";
                        if (nVar.iUl == null) {
                            x.w("MicroMsg.RemoteDebugSocket", "client is null");
                        } else {
                            nVar.iUl.V(1000, str);
                            x.d("MicroMsg.RemoteDebugSocket", "closeSocket code %d, reason %s", Integer.valueOf(1000), str);
                        }
                        p pVar = kVar3.iTO;
                        pVar.acS();
                        ah.y(new Runnable() {
                            public final void run() {
                                p.this.acQ();
                            }
                        });
                        break;
                    case 1005:
                        bxz bxz = (bxz) new bxz().aH(bArr);
                        kVar = i.this.iTN;
                        x.d("MicroMsg.RemoteDebugMsgMrg", "onSync");
                        if (o.a(kVar.iTJ, 1005, bxz.xfg, kVar.iTO, kVar)) {
                            kVar.r(bxz.xeU);
                            kVar.iTJ.jV(bxz.xfs);
                            kVar.acJ();
                            break;
                        }
                        break;
                    case 1006:
                        bxp bxp = (bxp) new bxp().aH(bArr);
                        kVar = i.this.iTN;
                        if (o.a(kVar.iTJ, 1006, bxp.xfg, kVar.iTO, kVar)) {
                            x.d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", Integer.valueOf(bxp.xfh), Integer.valueOf(bxp.xfi));
                            kVar.iTJ.bA(bxp.xfh, bxp.xfi);
                            kVar.bC(bxp.xfh, bxp.xfi);
                        }
                        l.a(bxb, (f) i.this.iTJ.iTy.get(bxb.njL));
                        break;
                    case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                        i.this.iTN.r(((bxi) new bxi().aH(bArr)).xeU);
                        break;
                    case 3001:
                        i.this.onReady();
                        break;
                    case 3002:
                        i.this.iTJ.eR(4);
                        i.this.iTN.quit();
                        break;
                }
                x.i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", Integer.valueOf(bxb.pK));
            } catch (Throwable th) {
                x.e("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", Log.getStackTraceString(th));
            }
        }

        public final void C(int i, String str) {
            int i2 = 1;
            x.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", Integer.valueOf(i), str);
            g gVar = i.this.iTJ;
            if (gVar.acD() || ((long) gVar.iTB) >= 10) {
                i2 = 0;
            }
            if (i2 != 0) {
                com.tencent.mm.plugin.appbrand.r.c.Dt().g(new Runnable() {
                    public final void run() {
                        i.this.connect();
                    }
                }, 1000);
                g gVar2 = i.this.iTJ;
                gVar2.iTB++;
            }
            i.this.iTN.acK();
            i.this.iTJ.iTp = System.currentTimeMillis();
            i.this.iTO.acS();
            i.this.iTJ.eR(5);
            i.this.iTO.rG(str);
        }

        public final void rC(String str) {
            x.i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", str);
        }
    };
    com.tencent.mm.plugin.appbrand.j isW;

    static /* synthetic */ void a(i iVar) {
        x.i("MicroMsg.RemoteDebugJsEngine", "login");
        iVar.iTJ.eR(1);
        com.tencent.mm.bp.a bxv = new bxv();
        bxv.xfe = iVar.iTJ.iTg;
        bxv.wuG = iVar.iTJ.acz();
        iVar.iTM.a(o.a(1002, bxv));
    }

    public final void addJavascriptInterface(Object obj, String str) {
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.iTJ.acC()) {
            if (this.iTJ.it()) {
                com.tencent.mm.bp.a bxg = new bxg();
                bxg.xeT = this.iTJ.iTr.incrementAndGet();
                bxg.script = str;
                this.iTN.a(o.a(bxg, this.iTJ, "evaluateJavascript"));
                int i = bxg.xeT;
                a aVar = new a();
                if (bi.oN(this.iTK)) {
                    aVar.fpd = l.rD(str);
                } else {
                    aVar.fpd = this.iTK;
                    this.iTK = null;
                }
                aVar.iTe = System.currentTimeMillis();
                aVar.size = str.length();
                aVar.iTd = valueCallback;
                this.iTJ.iTA.put(Integer.valueOf(i), aVar);
                return;
            }
            this.iTJ.iTw.add(new Pair(str, valueCallback));
            this.iTK = null;
        }
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        evaluateJavascript(str, valueCallback);
    }

    public final void a(com.tencent.xweb.d dVar) {
    }

    public final void destroy() {
        this.iTN.quit();
        this.iTN.acK();
    }

    public final <T extends com.tencent.mm.plugin.appbrand.g.c> T v(Class<T> cls) {
        return null;
    }

    final void connect() {
        if (this.iTM == null) {
            this.iTM = new n(this.isW.mAppId);
            k kVar = this.iTN;
            n nVar = this.iTM;
            g gVar = this.iTJ;
            Context context = this.iTL;
            com.tencent.mm.plugin.appbrand.jsapi.d dVar = this.isW.iul;
            p pVar = this.iTO;
            kVar.iTM = nVar;
            kVar.iTJ = gVar;
            kVar.mContext = context;
            kVar.iul = dVar;
            kVar.iTO = pVar;
        }
        if (this.iTJ.acE()) {
            this.iTM.a("ws://localhost:" + this.iTJ.iTl.iTI, this.iTP);
        } else {
            this.iTM.a("wss://wxagame.weixin.qq.com/remote/", this.iTP);
        }
    }

    final void onReady() {
        x.i("MicroMsg.RemoteDebugJsEngine", "onReady");
        this.iTJ.eR(3);
        x.i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
        Iterator it = this.iTJ.iTw.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            evaluateJavascript((String) pair.first, (ValueCallback) pair.second);
        }
        this.iTJ.iTw.clear();
        this.iTN.bB(this.iTJ.acA(), 0);
        this.iTO.acS();
    }
}
