package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.protocal.c.amt;
import com.tencent.mm.protocal.c.amu;
import com.tencent.mm.protocal.c.amv;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_BYTE = 232;
    public static final String NAME = "authorize";

    /* renamed from: com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d$2 */
    class AnonymousClass2 implements b.a {
        final /* synthetic */ int iWq;
        final /* synthetic */ a.a nce;

        AnonymousClass2(a.a aVar, int i) {
            this.nce = aVar;
            this.iWq = i;
        }

        public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
            x.i("MicroMsg.GameJsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            a.a aVar;
            d dVar;
            if (i != 0 || i2 != 0) {
                aVar = this.nce;
                dVar = d.this;
                aVar.sE(a.e("authorizefail", null));
            } else if (this.iWq == 2) {
                x.d("MicroMsg.GameJsApiAuthorize", "press reject button");
                aVar = this.nce;
                dVar = d.this;
                aVar.sE(a.e("authorizefail", null));
            } else {
                amu amu = (amu) bVar.hnR.hnY;
                if (amu == null || amu.wAp == null) {
                    aVar = this.nce;
                    dVar = d.this;
                    aVar.sE(a.e("authorizefail", null));
                    return;
                }
                int i3 = amu.wAp.fun;
                String str2 = amu.wAp.fuo;
                x.i("MicroMsg.GameJsApiAuthorize", "jsErrcode = %d", Integer.valueOf(i3));
                if (i3 == 0) {
                    aVar = this.nce;
                    dVar = d.this;
                    aVar.sE(a.e("authorizeok", null));
                    return;
                }
                x.e("MicroMsg.GameJsApiAuthorize", "ERROR = %s", str2);
                aVar = this.nce;
                dVar = d.this;
                aVar.sE(a.e("authorizefail", null));
            }
        }
    }

    public final void a(com.tencent.mm.plugin.game.gamewebview.ui.d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiAuthorize", "invoke");
        final Context aPO = dVar.aPO();
        JSONArray optJSONArray = jSONObject.optJSONArray("scope");
        if (optJSONArray == null) {
            x.e("MicroMsg.GameJsApiAuthorize", "scope is null!");
            dVar.E(i, a.e("authorize:fail", null));
            return;
        }
        final String aPS = dVar.aPS();
        if (bi.oN(aPS)) {
            x.e("MicroMsg.GameJsApiAuthorize", "appId is null!");
            dVar.E(i, a.e("authorize:fail", null));
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            linkedList.add(optJSONArray.optString(i2));
        }
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        com.tencent.mm.bp.a amv = new amv();
        aVar.hnT = amv;
        aVar.hnU = new amw();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        aVar.hnS = 1157;
        aVar.hnV = 0;
        aVar.hnW = 0;
        amv.nlV = aPS;
        amv.wAl = linkedList;
        amv.wAn = 0;
        final a.a aVar2 = new a.a(dVar, i);
        b.a(aVar.Kf(), new b.a() {
            public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
                x.i("MicroMsg.GameJsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    amw amw = (amw) bVar.hnR.hnY;
                    a.a aVar;
                    d dVar;
                    if (amw == null || amw.wAp == null) {
                        aVar = aVar2;
                        dVar = d.this;
                        aVar.sE(a.e("authorize:fail", null));
                        return;
                    }
                    int i3 = amw.wAp.fun;
                    String str2 = amw.wAp.fuo;
                    x.i("MicroMsg.GameJsApiAuthorize", "jsErrcode = %d", Integer.valueOf(i3));
                    if (i3 == -12000) {
                        final LinkedList linkedList = amw.woV;
                        str2 = amw.noG;
                        final String str3 = amw.vML;
                        ah.y(new Runnable() {
                            public final void run() {
                                h hVar = new h(aPO);
                                h.a anonymousClass1 = new h.a() {
                                    public final void d(int i, Bundle bundle) {
                                        x.i("MicroMsg.GameJsApiAuthorize", "stev onRevMsg resultCode %d", Integer.valueOf(i));
                                        d dVar;
                                        a.a aVar;
                                        switch (i) {
                                            case 1:
                                            case 2:
                                                dVar = d.this;
                                                String str = aPS;
                                                a.a aVar2 = aVar2;
                                                ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                                LinkedList linkedList = new LinkedList();
                                                Iterator it = arrayList.iterator();
                                                while (it.hasNext()) {
                                                    linkedList.add((String) it.next());
                                                }
                                                com.tencent.mm.ad.b.a aVar3 = new com.tencent.mm.ad.b.a();
                                                com.tencent.mm.bp.a amt = new amt();
                                                aVar3.hnT = amt;
                                                aVar3.hnU = new amu();
                                                aVar3.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                                                aVar3.hnS = 1158;
                                                aVar3.hnV = 0;
                                                aVar3.hnW = 0;
                                                amt.nlV = str;
                                                amt.wAl = linkedList;
                                                amt.wAn = 0;
                                                amt.wAm = i;
                                                b.a(aVar3.Kf(), new AnonymousClass2(aVar2, i));
                                                if (i == 2) {
                                                    aVar = aVar2;
                                                    dVar = d.this;
                                                    aVar.sE(a.e("authorize:fail_auth_deny", null));
                                                    return;
                                                }
                                                return;
                                            default:
                                                x.d("MicroMsg.GameJsApiAuthorize", "press back button!");
                                                aVar = aVar2;
                                                dVar = d.this;
                                                aVar.sE(a.e("authorize:fail_auth_cancel", null));
                                                return;
                                        }
                                    }
                                };
                                a.a aVar;
                                d dVar;
                                if (linkedList == null || linkedList.size() <= 0) {
                                    x.e("MicroMsg.GameJsApiAuthorize", "scopeInfoList is empty!");
                                    aVar = aVar2;
                                    dVar = d.this;
                                    aVar.sE(a.e("authorize:fail", null));
                                } else if (!hVar.a(linkedList, str2, str3, anonymousClass1)) {
                                    aVar = aVar2;
                                    dVar = d.this;
                                    aVar.sE(a.e("authorize:fail", null));
                                }
                            }
                        });
                        return;
                    } else if (i3 == 0) {
                        aVar = aVar2;
                        dVar = d.this;
                        aVar.sE(a.e("authorize:ok", null));
                        return;
                    } else {
                        x.e("MicroMsg.GameJsApiAuthorize", "ERROR = %s", str2);
                        aVar = aVar2;
                        dVar = d.this;
                        aVar.sE(a.e("authorize:fail", null));
                        return;
                    }
                }
                aVar2.sE(com.tencent.mm.plugin.game.gamewebview.a.d.Cf("authorize:fail"));
            }
        });
    }
}
