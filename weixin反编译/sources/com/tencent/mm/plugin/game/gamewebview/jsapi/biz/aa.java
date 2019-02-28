package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.protocal.c.amx;
import com.tencent.mm.protocal.c.amy;
import com.tencent.mm.protocal.c.amz;
import com.tencent.mm.protocal.c.ana;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class aa extends a {
    public static final int CTRL_BYTE = 231;
    public static final String NAME = "login";

    /* renamed from: com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa$2 */
    class AnonymousClass2 implements b.a {
        final /* synthetic */ int iWq;
        final /* synthetic */ a.a nce;

        AnonymousClass2(a.a aVar, int i) {
            this.nce = aVar;
            this.iWq = i;
        }

        public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
            x.i("MicroMsg.GameJsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            a.a aVar;
            aa aaVar;
            if (i != 0 || i2 != 0) {
                aVar = this.nce;
                aaVar = aa.this;
                aVar.sE(a.e("loginfail", null));
            } else if (this.iWq == 2) {
                x.d("MicroMsg.GameJsApiLogin", "press reject button");
                aVar = this.nce;
                aaVar = aa.this;
                aVar.sE(a.e("loginfail", null));
            } else {
                amy amy = (amy) bVar.hnR.hnY;
                if (amy == null || amy.wAp == null) {
                    aVar = this.nce;
                    aaVar = aa.this;
                    aVar.sE(a.e("loginfail", null));
                    return;
                }
                int i3 = amy.wAp.fun;
                String str2 = amy.wAp.fuo;
                x.i("MicroMsg.GameJsApiLogin", "jsErrcode = %d", Integer.valueOf(i3));
                if (i3 == 0) {
                    new HashMap().put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, amy.wAs);
                    a.a aVar2 = this.nce;
                    aa aaVar2 = aa.this;
                    aVar2.sE(a.e("loginok", null));
                    x.d("MicroMsg.GameJsApiLogin", "resp data code [%s]", r0);
                    return;
                }
                aVar = this.nce;
                aaVar = aa.this;
                aVar.sE(a.e("loginfail", null));
                x.e("MicroMsg.GameJsApiLogin", "errMsg = %s", str2);
            }
        }
    }

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiLogin", "invoke");
        final Context aPO = dVar.aPO();
        LinkedList linkedList = new LinkedList();
        String str = "";
        String str2 = "";
        final String aPS = dVar.aPS();
        if (bi.oN(aPS)) {
            x.e("MicroMsg.GameJsApiLogin", "appId is null!");
            dVar.E(i, a.e("login:fail", null));
            return;
        }
        final a.a aVar = new a.a(dVar, i);
        com.tencent.mm.ad.b.a aVar2 = new com.tencent.mm.ad.b.a();
        com.tencent.mm.bp.a amz = new amz();
        aVar2.hnT = amz;
        aVar2.hnU = new ana();
        aVar2.uri = "/cgi-bin/mmbiz-bin/js-login";
        aVar2.hnS = 1029;
        aVar2.hnV = 0;
        aVar2.hnW = 0;
        amz.nlV = aPS;
        amz.wAl = linkedList;
        amz.wAq = 0;
        amz.nlE = str2;
        amz.wAr = str;
        amz.wAn = 0;
        b.a(aVar2.Kf(), new b.a() {
            public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
                x.i("MicroMsg.GameJsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                a.a aVar;
                aa aaVar;
                if (i == 0 && i2 == 0) {
                    ana ana = (ana) bVar.hnR.hnY;
                    if (ana == null || ana.wAp == null) {
                        aVar = aVar;
                        aaVar = aa.this;
                        aVar.sE(a.e("loginfail", null));
                        return;
                    }
                    int i3 = ana.wAp.fun;
                    String str2 = ana.wAp.fuo;
                    final String str3 = ana.wAr;
                    x.i("MicroMsg.GameJsApiLogin", "NetSceneJSLogin jsErrcode %d", Integer.valueOf(i3));
                    if (i3 == -12000) {
                        final LinkedList linkedList = ana.woV;
                        final String str4 = ana.noG;
                        final String str5 = ana.vML;
                        x.d("MicroMsg.GameJsApiLogin", "appName %s, appIconUrl %s", str4, str5);
                        ah.y(new Runnable() {
                            public final void run() {
                                h hVar = new h(aPO);
                                h.a anonymousClass1 = new h.a() {
                                    public final void d(int i, Bundle bundle) {
                                        x.i("MicroMsg.GameJsApiLogin", "onRevMsg resultCode %d", Integer.valueOf(i));
                                        aa aaVar;
                                        a.a aVar;
                                        switch (i) {
                                            case 1:
                                            case 2:
                                                aaVar = aa.this;
                                                String str = aPS;
                                                String str2 = str3;
                                                a.a aVar2 = aVar;
                                                ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                                LinkedList linkedList = new LinkedList();
                                                Iterator it = arrayList.iterator();
                                                while (it.hasNext()) {
                                                    linkedList.add((String) it.next());
                                                }
                                                com.tencent.mm.ad.b.a aVar3 = new com.tencent.mm.ad.b.a();
                                                com.tencent.mm.bp.a amx = new amx();
                                                aVar3.hnT = amx;
                                                aVar3.hnU = new amy();
                                                aVar3.uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
                                                aVar3.hnS = 1117;
                                                aVar3.hnV = 0;
                                                aVar3.hnW = 0;
                                                amx.nlV = str;
                                                amx.wAl = linkedList;
                                                amx.wAq = 0;
                                                amx.wAr = str2;
                                                amx.wAn = 0;
                                                amx.wAm = i;
                                                b.a(aVar3.Kf(), new AnonymousClass2(aVar2, i));
                                                if (i == 2) {
                                                    x.e("MicroMsg.GameJsApiLogin", "fail auth deny!");
                                                    aVar = aVar;
                                                    aaVar = aa.this;
                                                    aVar.sE(a.e("loginfail_auth_deny", null));
                                                    return;
                                                }
                                                return;
                                            default:
                                                x.i("MicroMsg.GameJsApiLogin", "press back button!");
                                                aVar = aVar;
                                                aaVar = aa.this;
                                                aVar.sE(a.e("loginfail_auth_cancel", null));
                                                return;
                                        }
                                    }
                                };
                                a.a aVar;
                                aa aaVar;
                                if (linkedList == null || linkedList.size() <= 0) {
                                    x.e("MicroMsg.GameJsApiLogin", "scopeInfoList is empty!");
                                    aVar = aVar;
                                    aaVar = aa.this;
                                    aVar.sE(a.e("loginfail", null));
                                } else if (!hVar.a(linkedList, str4, str5, anonymousClass1)) {
                                    aVar = aVar;
                                    aaVar = aa.this;
                                    aVar.sE(a.e("loginfail", null));
                                }
                            }
                        });
                        return;
                    } else if (i3 == 0) {
                        new HashMap().put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, ana.wAs);
                        x.d("MicroMsg.GameJsApiLogin", "resp data code [%s]", r0);
                        aVar = aVar;
                        aaVar = aa.this;
                        aVar.sE(a.e("loginok", null));
                        return;
                    } else {
                        x.e("MicroMsg.GameJsApiLogin", "onSceneEnd NetSceneJSLogin %s", str2);
                        aVar = aVar;
                        aaVar = aa.this;
                        aVar.sE(a.e("loginfail", null));
                        return;
                    }
                }
                aVar = aVar;
                aaVar = aa.this;
                aVar.sE(a.e("loginfail", null));
            }
        });
    }
}
