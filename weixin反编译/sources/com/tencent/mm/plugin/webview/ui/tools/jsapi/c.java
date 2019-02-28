package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.l;
import com.tencent.mm.plugin.webview.model.m;
import com.tencent.mm.plugin.webview.model.n;
import com.tencent.mm.plugin.webview.model.o;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.amf;
import com.tencent.mm.protocal.c.amg;
import com.tencent.mm.protocal.c.amn;
import com.tencent.mm.protocal.c.amo;
import com.tencent.mm.protocal.c.amq;
import com.tencent.mm.protocal.c.amr;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c implements e {
    private Context context;
    private com.tencent.mm.plugin.webview.stub.e fCC;
    final HashMap<String, d> nfh = new HashMap();
    final HashMap<String, ame> tMV = new HashMap();
    final HashMap<String, String> tMW = new HashMap();
    final int tyA;

    public interface a {

        public enum a {
            RET_OK(0),
            RET_FAIL(-1),
            RET_REJECT(-2),
            RET_ACCESS_DENIED(-3);
            
            private int code;

            private a(int i) {
                this.code = i;
            }

            public final int getCode() {
                return this.code;
            }
        }

        void a(a aVar, String str, LinkedList<bto> linkedList, int i, int i2);
    }

    public interface b {
        int bRr();
    }

    public static class d {
        public String appId;
        public List<String> tNg;
    }

    public static abstract class c implements a {
        public boolean tNf = true;

        public boolean bUY() {
            return this.tNf;
        }

        public final void kG(boolean z) {
            this.tNf = z;
        }
    }

    public final String Qf(String str) {
        if (str == null) {
            return null;
        }
        String str2 = (String) this.tMW.get(str);
        if (!bi.oN(str2)) {
            return str2;
        }
        String Cv = Cv(str);
        x.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", str2, str, Cv);
        if (bi.oN(Cv)) {
            return str2;
        }
        return (String) this.tMW.get(Cv);
    }

    public c(int i) {
        this.tyA = i;
    }

    final void a(Context context, com.tencent.mm.plugin.webview.stub.e eVar) {
        this.context = context;
        this.fCC = eVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (!(kVar instanceof b)) {
            x.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
        } else if (((b) kVar).bRr() != this.tyA) {
            x.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", Integer.valueOf(this.tyA), Integer.valueOf(((b) kVar).bRr()));
        } else {
            int type = kVar.getType();
            if (type == 1093) {
                as.CN().b(1093, (e) this);
                m mVar = (m) kVar;
                if (mVar == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "");
                } else if (mVar.tyy == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
                } else {
                    int i3 = 0;
                    if (!(mVar.bRs() == null || mVar.bRs().wzV == null)) {
                        i3 = mVar.bRs().wzV.fun;
                    }
                    if (i == 0 && i2 == 0) {
                        amo bRs = mVar.bRs();
                        amn amn = mVar.gLB == null ? null : (amn) mVar.gLB.hnQ.hnY;
                        if (bRs == null || bi.oN(mVar.jOH) || amn == null || bi.oN(amn.fGh)) {
                            String str2 = "MicroMsg.webview.JSVerifyHelper";
                            String str3 = "something null %b, %b, %b";
                            Object[] objArr = new Object[3];
                            objArr[0] = Boolean.valueOf(bRs == null);
                            objArr[1] = Boolean.valueOf(bi.oN(mVar.jOH));
                            objArr[2] = Boolean.valueOf(amn == null);
                            x.e(str2, str3, objArr);
                            mVar.tyy.a(a.RET_FAIL, null, null, i2, i3);
                        } else if (bRs.wzV == null) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
                            mVar.tyy.a(a.RET_FAIL, null, null, i2, i3);
                        } else if (bRs.wzV.fun != 0) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", Integer.valueOf(bRs.wzV.fun), bRs.wzV.fuo);
                            mVar.tyy.a(a.RET_FAIL, bRs.wzV.fuo, null, i2, i3);
                        } else {
                            this.tMW.put(Cv(amn.url), amn.fGh);
                            d dVar = new d();
                            dVar.appId = amn.fGh;
                            dVar.tNg = bRs.wAj;
                            this.nfh.put(Cv(amn.url), dVar);
                            mVar.tyy.a(a.RET_OK, null, bRs.wAi, i2, i3);
                        }
                    } else if (i == 4) {
                        mVar.tyy.a(a.RET_FAIL, i2 + "_" + str, null, i2, i3);
                    } else {
                        mVar.tyy.a(a.RET_FAIL, null, null, i2, i3);
                    }
                }
            } else if (type == 1095) {
                as.CN().b(1095, (e) this);
                a(i, i2, str, (l) kVar);
            } else if (type == 1094) {
                as.CN().b(1094, (e) this);
                n nVar = (n) kVar;
                if (nVar == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
                    return;
                }
                int i4;
                g.pWK.a(157, 24, 1, false);
                if (nVar.bRt() == null || nVar.bRt().wzV == null) {
                    i4 = 0;
                } else {
                    i4 = nVar.bRt().wzV.fun;
                }
                if (i == 0 && i2 == 0) {
                    amq bRt = nVar.bRt();
                    if (bRt == null || bRt.wzV == null) {
                        x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
                        nVar.tyy.a(a.RET_FAIL, null, null, i2, i4);
                        return;
                    } else if (bRt.wzV.fun != 0) {
                        x.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", Integer.valueOf(bRt.wzV.fun), bRt.wzV.fuo);
                        nVar.tyy.a(a.RET_FAIL, bRt.wzV.fuo, null, i2, i4);
                        return;
                    } else {
                        bto bto = bRt.wAk;
                        if (bto == null) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
                            nVar.tyy.a(a.RET_FAIL, "verifyFail", null, i2, i4);
                            return;
                        } else if (bto.xbq != 1) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", Integer.valueOf(bto.xbq));
                            nVar.tyy.a(a.RET_FAIL, "verifyFail", null, i2, i4);
                            return;
                        } else {
                            nVar.tyy.a(a.RET_OK, null, null, i2, i4);
                            return;
                        }
                    }
                }
                x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", Integer.valueOf(i), Integer.valueOf(i2));
                g.pWK.a(157, 25, 1, false);
                if (i == 4) {
                    nVar.tyy.a(a.RET_FAIL, i2 + "_" + str, null, i2, i4);
                } else {
                    nVar.tyy.a(a.RET_FAIL, null, null, i2, i4);
                }
            } else if (type == 1096) {
                as.CN().b(1096, (e) this);
                o oVar = (o) kVar;
                amr amr = oVar.gLB == null ? null : (amr) oVar.gLB.hnQ.hnY;
                if (amr == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
                } else if (i != 0 || i2 != 0) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", Integer.valueOf(i), Integer.valueOf(i2), amr.wzP);
                } else if (com.tencent.mm.protocal.c.TR(bi.oM(amr.wzP)) == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", Integer.valueOf(i), Integer.valueOf(i2));
                } else {
                    ame ame = ((o) kVar).tyB;
                    ame.vQj = 1;
                    this.tMV.put(amr.wzP + amr.url, ame);
                }
            }
        }
    }

    private void a(int i, final int i2, String str, final l lVar) {
        if (lVar == null) {
            x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth scene is null");
            return;
        }
        int i3 = 0;
        if (!(lVar.bRq() == null || lVar.bRq().wzV == null)) {
            i3 = lVar.bRq().wzV.fun;
        }
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 4) {
                lVar.tyy.a(a.RET_FAIL, str, null, i2, i3);
            } else {
                lVar.tyy.a(a.RET_FAIL, null, null, i2, i3);
            }
        } else if (bi.oN(lVar.tyz)) {
            x.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
            lVar.tyy.a(a.RET_FAIL, null, null, i2, i3);
        } else {
            amg bRq = lVar.bRq();
            if (bRq == null || bRq.wzV == null) {
                x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
                lVar.tyy.a(a.RET_FAIL, null, null, i2, i3);
            } else if (bRq.wzV.fun != 0) {
                x.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", Integer.valueOf(bRq.wzV.fun), bRq.wzV.fuo);
                lVar.tyy.a(a.RET_FAIL, bRq.wzV.fuo, null, i2, i3);
            } else {
                x.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", Integer.valueOf(lVar.bRp() == null ? 0 : lVar.bRp().wzU));
                if ((lVar.bRp() == null ? 0 : lVar.bRp().wzU) == 1) {
                    if (bRq.wzY == null) {
                        x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
                        lVar.tyy.a(a.RET_FAIL, null, null, i2, i3);
                        return;
                    }
                    Iterator it = bRq.wzY.iterator();
                    while (it.hasNext()) {
                        anf anf = (anf) it.next();
                        if (anf.wAz == null) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
                        } else {
                            Iterator it2 = anf.wAz.iterator();
                            while (it2.hasNext()) {
                                String str2 = (String) it2.next();
                                if (!bi.oN(str2)) {
                                    ame ame = new ame();
                                    ame.wzP = str2;
                                    ame.vQj = anf.wAy;
                                    ame.wzQ = anf.qmh;
                                    this.tMV.put(ame.wzP + lVar.url, ame);
                                }
                            }
                        }
                    }
                } else if (bRq.wzW == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
                    lVar.tyy.a(a.RET_FAIL, "nullAuthInfo", null, i2, i3);
                    return;
                } else {
                    Iterator it3 = bRq.wzW.iterator();
                    while (it3.hasNext()) {
                        ame ame2 = (ame) it3.next();
                        if (!bi.oN(ame2.wzP)) {
                            this.tMV.put(ame2.wzP + lVar.url, ame2);
                        }
                    }
                }
                final ame ame3 = (ame) this.tMV.get(lVar.tyz + lVar.url);
                if (ame3 == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", lVar.tyz, lVar.url);
                    lVar.tyy.a(a.RET_FAIL, null, null, i2, i3);
                } else if (ame3.vQj == 1) {
                    lVar.tyy.a(a.RET_OK, null, null, i2, i3);
                } else if (this.context == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "JSVerify context not activity");
                    a(lVar, i2, ame3);
                } else {
                    WebViewStubTempUI.a(this.context, this.fCC, bi.oM(ame3.wzQ), "", this.context.getString(R.l.esF), this.context.getString(R.l.esE), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
                            c.this.a(lVar, i2, ame3);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
                            lVar.tyy.a(a.RET_REJECT, "cancel", null, i2, lVar.bRq().wzV.fun);
                        }
                    });
                }
            }
        }
    }

    final void a(l lVar, int i, ame ame) {
        amf bRp = lVar.bRp();
        amg bRq = lVar.bRq();
        if (bRp == null) {
            x.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
            lVar.tyy.a(a.RET_FAIL, null, null, i, lVar.bRq().wzV.fun);
        } else if (bRq == null) {
            x.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
            lVar.tyy.a(a.RET_FAIL, null, null, i, lVar.bRq().wzV.fun);
        } else {
            as.CN().a(1096, (e) this);
            LinkedList linkedList = bRq.wzY;
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    anf anf = (anf) it.next();
                    if (anf != null) {
                        x.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", anf.wAz, anf.scope, anf.qmh, Integer.valueOf(anf.wAy), bRp.wzP);
                        anf.wAy = 1;
                    }
                }
                it = linkedList.iterator();
                while (it.hasNext()) {
                    if (((anf) it.next()) != null) {
                        x.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", ((anf) it.next()).wAz, ((anf) it.next()).scope, ((anf) it.next()).qmh, Integer.valueOf(((anf) it.next()).wAy), bRp.wzP);
                    }
                }
            }
            as.CN().a(new o(ame, bRp.url, bRp.nkU, bRp.wzP, bRp.fry, bRp.wzR, bRp.signature, bRp.wzS, bRp.wzT, bRp.wzU, linkedList, this.tyA), 0);
            lVar.tyy.a(a.RET_OK, null, null, i, lVar.bRq().wzV.fun);
        }
    }

    static String Cv(String str) {
        int indexOf = str.indexOf("#");
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }
}
