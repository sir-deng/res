package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.ad.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.e;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.amn;
import com.tencent.mm.protocal.c.amo;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ak extends com.tencent.mm.plugin.game.gamewebview.jsapi.a {
    public static final int CTRL_BYTE = -3;
    public static final String NAME = "preVerifyJSAPI";

    private static class a implements com.tencent.mm.ipcinvoker.wx_extension.b.a {
        private String appId;
        private int jgb;
        private d nbK;

        a(d dVar, int i, String str) {
            this.nbK = dVar;
            this.jgb = i;
            this.appId = str;
        }

        public final void a(int i, int i2, String str, b bVar) {
            if (this.nbK != null) {
                if (i == 0 && i2 == 0) {
                    amo amo = (amo) bVar.hnR.hnY;
                    if (amo == null || amo.wzV == null || amo.wzV.fun != 0) {
                        sE(com.tencent.mm.plugin.game.gamewebview.a.d.Cf("pre_verify_jsapi:fail_" + str));
                        return;
                    }
                    d dVar = this.nbK;
                    String str2 = this.appId;
                    if (!(bi.oN(str2) || bi.oN(dVar.aPR()))) {
                        dVar.nfg.put(d.Cv(dVar.aPR()), str2);
                    }
                    c.d dVar2 = new c.d();
                    dVar2.appId = this.appId;
                    dVar2.tNg = amo.wAj;
                    d dVar3 = this.nbK;
                    if (!bi.oN(dVar3.aPR())) {
                        dVar3.nfh.put(dVar3.aPR(), dVar2);
                    }
                    Object obj = amo.wAi;
                    d dVar4 = this.nbK;
                    JsapiPermissionWrapper PN = dVar4.neF != null ? dVar4.neF.PN(dVar4.aPR()) : null;
                    if (PN == null) {
                        sE(com.tencent.mm.plugin.game.gamewebview.a.d.Cf("pre_verify_jsapi:ok"));
                        return;
                    }
                    if (!bi.cC(obj)) {
                        Iterator it = obj.iterator();
                        while (it.hasNext()) {
                            bto bto = (bto) it.next();
                            com.tencent.mm.plugin.game.gamewebview.jsapi.c cVar = (com.tencent.mm.plugin.game.gamewebview.jsapi.c) e.aPt().get(bto.wzP);
                            if (!(cVar == null || PN.CY(cVar.aPp()) == bto.state)) {
                                PN.a(cVar.aPp(), (byte) bto.state);
                            }
                        }
                    }
                    sE(com.tencent.mm.plugin.game.gamewebview.a.d.Cf("pre_verify_jsapi:ok"));
                    return;
                }
                x.e("MicroMsg.GameJsApiPreVerify", "errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                sE(com.tencent.mm.plugin.game.gamewebview.a.d.Cf("pre_verify_jsapi:fail_" + str));
            }
        }

        private void sE(String str) {
            this.nbK.E(this.jgb, str);
            this.nbK = null;
            this.appId = null;
        }
    }

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiPreVerify", "invoke");
        String optString = jSONObject.optString("verifyAppId");
        String optString2 = jSONObject.optString("verifySignature");
        String optString3 = jSONObject.optString("verifyNonceStr");
        String optString4 = jSONObject.optString("verifyTimestamp");
        String optString5 = jSONObject.optString("verifySignType");
        JSONArray optJSONArray = jSONObject.optJSONArray("verifyJsApiList");
        x.i("MicroMsg.GameJsApiPreVerify", "appid : %s, %s, %s, %s, %s", optString, optString2, optString3, optString4, optString5);
        String aPR = dVar.aPR();
        LinkedList linkedList = new LinkedList();
        try {
            x.i("MicroMsg.GameJsApiPreVerify", "jsItem length %s", Integer.valueOf(optJSONArray.length()));
            if (optJSONArray.length() == 0) {
                dVar.E(i, "checkJsApi:param is empty");
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String string = optJSONArray.getString(i2);
                if (!bi.oN(string)) {
                    linkedList.add(string);
                }
            }
            if (bi.oN(optString) || linkedList.size() <= 0 || bi.oN(aPR)) {
                x.e("MicroMsg.GameJsApiPreVerify", "handlePreVerify wrong args, %s", optString);
                dVar.E(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("pre_verify_jsapi:fail_invalid_args", null));
                return;
            }
            com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
            aVar.hnT = new amn();
            aVar.hnU = new amo();
            aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
            aVar.hnS = 1093;
            aVar.hnV = 0;
            aVar.hnW = 0;
            b Kf = aVar.Kf();
            amn amn = (amn) Kf.hnQ.hnY;
            amn.url = aPR;
            amn.fGh = optString;
            amn.wAg = linkedList;
            amn.fry = optString4;
            amn.wzR = optString3;
            amn.signature = optString2;
            amn.wzS = optString5;
            com.tencent.mm.ipcinvoker.wx_extension.b.a(Kf, new a(dVar, i, optString));
        } catch (Exception e) {
            x.w("MicroMsg.GameJsApiPreVerify", "exception occur " + e.getMessage());
            dVar.E(i, "pre_verify_jsapi:fail");
        }
    }
}
