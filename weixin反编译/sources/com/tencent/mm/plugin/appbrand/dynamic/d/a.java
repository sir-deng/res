package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d;
import com.tencent.mm.protocal.c.amt;
import com.tencent.mm.protocal.c.amu;
import com.tencent.mm.protocal.c.amv;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {
    private static String iWk = "com.tencent.mm:tools";

    private interface a {
        void i(Bundle bundle);
    }

    private static class b implements h<Bundle, Bundle> {
        private static final String[] iWm = new String[]{"scope.userLocation"};

        private b() {
        }

        static /* synthetic */ void a(b bVar, String str) {
            View rJ = e.acW().rJ(str);
            if (rJ instanceof com.tencent.mm.plugin.appbrand.dynamic.h) {
                ((com.tencent.mm.plugin.appbrand.dynamic.h) rJ).c(str, new p() {
                    public final void b(boolean z, String str, Bundle bundle) {
                    }
                });
                return;
            }
            x.i("MicroMsg.IPCInvoke_DoAuthorize", "authorize failed, view is not a instance of DynamicPageAccessible.(%s)", str);
        }

        static /* synthetic */ void a(b bVar, final String str, String str2, Bundle bundle, final int i) {
            ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
            LinkedList linkedList = new LinkedList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                linkedList.add((String) it.next());
            }
            com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
            aVar.hnS = 1158;
            aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
            com.tencent.mm.bp.a amt = new amt();
            amt.nlV = str2;
            amt.wAl = linkedList;
            amt.wAn = 0;
            amt.wAm = i;
            aVar.hnT = amt;
            aVar.hnU = new amu();
            com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.Kf(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
                    x.d("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i == 0 && i2 == 0 && bVar.hnR.hnY != null && i != 2) {
                        amu amu = (amu) bVar.hnR.hnY;
                        int i3 = amu.wAp.fun;
                        String str2 = amu.wAp.fuo;
                        x.i("MicroMsg.IPCInvoke_DoAuthorize", "NetSceneJSAuthorizeConfirm jsErrcode[%d], jsErrmsg[%s]", Integer.valueOf(i3), str2);
                        if (i3 == 0) {
                            b.a(b.this, str);
                        }
                    }
                }
            });
        }

        static /* synthetic */ void a(b bVar, String str, String str2, String str3, LinkedList linkedList, a aVar) {
            final String str4 = str;
            final a aVar2 = aVar;
            final LinkedList linkedList2 = linkedList;
            final String str5 = str2;
            final String str6 = str3;
            ah.y(new Runnable() {
                public final void run() {
                    int i = 1;
                    IPCDynamicPageView rR = com.tencent.mm.plugin.appbrand.dynamic.h.a.adv().rR(str4);
                    if (rR == null) {
                        x.e("MicroMsg.IPCInvoke_DoAuthorize", "dynamicPageView not found! widgetid[%s]", str4);
                        return;
                    }
                    com.tencent.mm.plugin.appbrand.dynamic.widget.b bVar = new com.tencent.mm.plugin.appbrand.dynamic.widget.b(rR.getContext());
                    com.tencent.mm.plugin.appbrand.dynamic.widget.b.a anonymousClass1 = new com.tencent.mm.plugin.appbrand.dynamic.widget.b.a() {
                        public final void d(int i, Bundle bundle) {
                            x.i("MicroMsg.IPCInvoke_DoAuthorize", "stev onRevMsg resultCode %d", Integer.valueOf(i));
                            Bundle bundle2 = new Bundle();
                            switch (i) {
                                case 1:
                                case 2:
                                    bundle2.putInt("retCode", 0);
                                    bundle2.putInt("resultCode", i);
                                    bundle2.putBundle("resultData", bundle);
                                    break;
                                default:
                                    x.d("MicroMsg.IPCInvoke_DoAuthorize", "press back button!");
                                    bundle2.putInt("retCode", -1);
                                    break;
                            }
                            aVar2.i(bundle2);
                        }
                    };
                    if (linkedList2 == null || linkedList2.size() <= 0) {
                        x.e("MicroMsg.IPCInvoke_DoAuthorize", "scopeInfoList is empty!");
                    } else {
                        LinkedList linkedList = linkedList2;
                        String str = str5;
                        String str2 = str6;
                        x.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
                        bVar.mAppName = str;
                        bVar.iYN = str2;
                        if (bVar.a(null, linkedList, anonymousClass1)) {
                            i = 0;
                        }
                    }
                    if (i != 0) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("retCode", -2);
                        aVar2.i(bundle);
                    }
                }
            });
        }

        static /* synthetic */ String rO(String str) {
            return str != null ? str : "";
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            Bundle bundle = (Bundle) obj;
            x.i("MicroMsg.IPCInvoke_DoAuthorize", "widget doOauthAuthorize!");
            String string = bundle.getString("scope");
            final String string2 = bundle.getString("appId");
            final String string3 = bundle.getString("widgetId");
            LinkedList linkedList = new LinkedList();
            try {
                List asList = Arrays.asList(iWm);
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String optString = jSONArray.optString(i);
                    if (asList.contains(optString)) {
                        linkedList.add(optString);
                    }
                }
                if (linkedList.size() <= 0) {
                    x.w("MicroMsg.IPCInvoke_DoAuthorize", "no valid scope, raw scope[%s]", string);
                    return;
                }
                com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
                aVar.hnS = 1157;
                aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize";
                com.tencent.mm.bp.a amv = new amv();
                amv.nlV = string2;
                amv.wAl = linkedList;
                amv.wAn = 0;
                aVar.hnT = amv;
                aVar.hnU = new amw();
                com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.Kf(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                    public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
                        x.i("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd errType[%d], errCode[%d] ,errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                            amw amw = (amw) bVar.hnR.hnY;
                            int i3 = amw.wAp.fun;
                            String str2 = amw.wAp.fuo;
                            x.i("MicroMsg.IPCInvoke_DoAuthorize", "NetSceneJSAuthorize jsErrcode[%d], jsErrmsg[%s]", Integer.valueOf(i3), str2);
                            if (i3 == -12000) {
                                b.a(b.this, string3, b.rO(amw.noG), b.rO(amw.vML), amw.woV, new a() {
                                    public final void i(Bundle bundle) {
                                        if (bundle.getInt("retCode") == 0) {
                                            int i = bundle.getInt("resultCode");
                                            b.a(b.this, string3, string2, bundle.getBundle("resultData"), i);
                                            return;
                                        }
                                        x.e("MicroMsg.IPCInvoke_DoAuthorize", "authorize fail, retCode[%d]", Integer.valueOf(bundle.getInt("retCode")));
                                    }
                                });
                            } else if (i3 == 0) {
                                b.a(b.this, string3);
                            } else {
                                x.e("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd NetSceneJSAuthorize ERROR %s", str2);
                            }
                        }
                    }
                });
            } catch (Exception e) {
                x.e("MicroMsg.IPCInvoke_DoAuthorize", "Parse scrope array string Exception[%s]", e.getMessage());
            }
        }
    }

    public a() {
        super(d.NAME, 419);
    }

    protected final void a(com.tencent.mm.t.c.a aVar, JSONObject jSONObject, com.tencent.mm.t.b.b.a<JSONObject> aVar2) {
        com.tencent.mm.y.u.b Ci = aVar.Ci();
        Bundle bundle = new Bundle();
        try {
            bundle.putString("scope", jSONObject.getString("scope"));
            bundle.putString("appId", Ci.getString("__page_app_id", ""));
            bundle.putString("widgetId", Ci.getString("__page_view_id", ""));
            XIPCInvoker.a(Ci.getString("__process_name", iWk), bundle, b.class, new i<Bundle>() {
                public final /* bridge */ /* synthetic */ void as(Object obj) {
                }
            });
        } catch (Exception e) {
            x.e("MicroMsg.JsApiFunc_DoAuthroize", "JSON Exception[%s]", e.getMessage());
        }
    }
}
