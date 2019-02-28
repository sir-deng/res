package com.tencent.mm.plugin.appbrand.game;

import android.content.SharedPreferences;
import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.appbrand.debugger.q;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.f;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.r.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class l {
    boolean jaQ = false;
    j jaR;
    f jaS;
    com.tencent.mm.plugin.appbrand.g.a jaT;
    com.tencent.mm.plugin.appbrand.g.a jaU;
    private Boolean jaV = null;

    private class a {
        private a() {
        }

        /* synthetic */ a(l lVar, byte b) {
            this();
        }

        @JavascriptInterface
        public final int create(String str) {
            int i;
            synchronized (l.this) {
                if (!l.this.jaQ || l.this.jaS == null) {
                    x.e("MicroMsg.WAGameWeixinJSContextLogic", "create subContext failed. mStateReady = [%b] mSubContextAddon = [%s]", Boolean.valueOf(l.this.jaQ), l.this.jaS);
                    i = -1;
                } else {
                    b aek = l.this.jaS.aek();
                    l lVar = l.this;
                    if (aek.adY()) {
                        x.e("MicroMsg.WAGameWeixinJSContextLogic", "bindSubContext subContext = [" + aek + "]");
                    } else if (lVar.jaU == null) {
                        x.e("MicroMsg.WAGameWeixinJSContextLogic", "initSubJSContext mBridgeHolder == null");
                    } else {
                        lVar.jaU.a(aek, "WeixinJSContext");
                    }
                    String str2 = "";
                    if (!lVar.aeq()) {
                        aek.addJavascriptInterface(new d(lVar.jaR, aek), "WeixinJSCore");
                        str2 = a.a(lVar.jaR.iuk, "wxa_library/android.js", true);
                    }
                    x.i("MicroMsg.WAGameWeixinJSContextLogic", "Inject WAGameSubContext to SubContext");
                    str2 = bi.oM(str2) + a.a(lVar.jaR.iuk, "WAGameSubContext.js", false);
                    g.pWK.a(778, 17, 1, false);
                    h.a(aek, str2, new com.tencent.mm.plugin.appbrand.r.h.a() {
                        public final void pH(String str) {
                            x.i("MicroMsg.WAGameWeixinJSContextLogic", "Inject SDK WAGameSubContext Script suc: %s", str);
                            g.pWK.a(778, 19, 1, false);
                        }

                        public final void fs(String str) {
                            x.e("MicroMsg.WAGameWeixinJSContextLogic", "Inject SDK WAGameSubContext Script Failed: %s", str);
                            g.pWK.a(778, 18, 1, false);
                            com.tencent.mm.plugin.appbrand.report.a.C(l.this.jaR.iuk.mAppId, 24, 0);
                            com.tencent.mm.plugin.appbrand.report.a.a(l.this.jaR.mAppId, l.this.jaR.iuk.isS.iRU.iJb, l.this.jaR.iuk.isS.iRU.iJa, 778, 18);
                        }
                    });
                    l lVar2 = l.this;
                    if (!bi.oN(str)) {
                        String a = a.a(lVar2.jaR.iuk, str, false);
                        if (bi.oN(a)) {
                            x.e("MicroMsg.WAGameWeixinJSContextLogic", "bussiness code is null [%s]", a);
                        } else {
                            x.i("MicroMsg.WAGameWeixinJSContextLogic", "Inject SubContext subContext.js");
                            g.pWK.a(778, 21, 1, false);
                            h.a(aek, str, a, new com.tencent.mm.plugin.appbrand.r.h.a() {
                                public final void pH(String str) {
                                    x.i("MicroMsg.WAGameWeixinJSContextLogic", "Inject SDK subContext Script suc: %s", str);
                                    g.pWK.a(778, 23, 1, false);
                                }

                                public final void fs(String str) {
                                    x.e("MicroMsg.WAGameWeixinJSContextLogic", "Inject SDK subContext Script Failed: %s", str);
                                    g.pWK.a(778, 22, 1, false);
                                    com.tencent.mm.plugin.appbrand.report.a.C(l.this.jaR.mAppId, 24, 0);
                                    com.tencent.mm.plugin.appbrand.report.a.a(l.this.jaR.mAppId, l.this.jaR.iuk.isS.iRU.iJb, l.this.jaR.iuk.isS.iRU.iJa, 778, 22);
                                }
                            });
                            q.a(lVar2.jaR.iuk, aek, str);
                        }
                    }
                    x.i("MicroMsg.WAGameWeixinJSContextLogic", "create subContext success = [%d]", Integer.valueOf(aek.adZ()));
                    i = aek.adZ();
                }
            }
            return i;
        }

        @JavascriptInterface
        public final void destroy(int i) {
            synchronized (l.this) {
                if (!l.this.jaQ || l.this.jaS == null) {
                    x.e("MicroMsg.WAGameWeixinJSContextLogic", "destroy subContext failed. mStateReady = [%b] mSubContextAddon = [%s] contextId = [%d]", Boolean.valueOf(l.this.jaQ), l.this.jaS, Integer.valueOf(i));
                    return;
                }
                l.this.jaS.kh(i);
            }
        }
    }

    public l(j jVar, b bVar) {
        if (jVar == null || bVar == null) {
            x.e("MicroMsg.WAGameWeixinJSContextLogic", "Input failed. service is [%s] jsRuntime = [%s]", jVar, bVar);
            return;
        }
        f fVar = (f) bVar.v(f.class);
        if (fVar == null) {
            x.e("MicroMsg.WAGameWeixinJSContextLogic", "Input failed. jsRuntime not support subContext");
        } else if (fVar.aej() == null) {
            x.e("MicroMsg.WAGameWeixinJSContextLogic", "Input failed. subContext has no main jscontext, you should to init it first.");
        } else {
            synchronized (this) {
                this.jaR = jVar;
                this.jaS = fVar;
                this.jaT = fVar.aej();
                this.jaQ = true;
            }
        }
    }

    public final boolean aeq() {
        if (this.jaV == null) {
            boolean z;
            long Wz = bi.Wz();
            SharedPreferences cgg = ad.cgg();
            int i = cgg != null ? cgg.getInt("useisolatectxwxalibrary", 0) : 0;
            if (i == 1) {
                z = true;
            } else {
                if (i != -1) {
                    com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = b.gOV;
                    c fp = com.tencent.mm.ipcinvoker.wx_extension.a.a.fp("100378");
                    if (fp == null || !fp.isValid()) {
                        z = false;
                    } else if (bi.getInt((String) fp.civ().get("useisolatectxwxalibrary"), 0) == 1) {
                        z = true;
                    }
                }
                z = false;
            }
            this.jaV = Boolean.valueOf(z);
            x.i("MicroMsg.WAGameWeixinJSContextLogic", "read ShouldUseIsolateCtxWxaLibrary cost time = [%d]", Long.valueOf(bi.bB(Wz)));
        }
        return this.jaV.booleanValue();
    }
}
