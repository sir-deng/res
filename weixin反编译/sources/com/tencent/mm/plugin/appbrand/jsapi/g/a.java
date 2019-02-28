package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.b.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public enum a implements b {
    ;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a$3 */
    class AnonymousClass3 implements com.tencent.mm.ui.MMActivity.a {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.g.b.a jsp;

        AnonymousClass3(com.tencent.mm.plugin.appbrand.jsapi.g.b.a aVar) {
            this.jsp = aVar;
        }

        public final void b(int i, int i2, Intent intent) {
            if (i == (a.this.hashCode() & 65535)) {
                if (i2 == -1) {
                    if (this.jsp != null) {
                        this.jsp.a(1, null, null);
                    }
                } else if (this.jsp != null) {
                    this.jsp.a(2, null, null);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a$2 */
    class AnonymousClass2 implements com.tencent.mm.ui.MMActivity.a {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.g.b.a jsp;

        AnonymousClass2(com.tencent.mm.plugin.appbrand.jsapi.g.b.a aVar) {
            this.jsp = aVar;
        }

        public final void b(int i, int i2, Intent intent) {
            if (i == (a.this.hashCode() & 65535)) {
                if (i2 == -1) {
                    Map hashMap = new HashMap();
                    String aD = bi.aD(intent.getStringExtra("token"), "");
                    String aD2 = bi.aD(intent.getStringExtra("bind_serial"), "");
                    hashMap.put("token", aD);
                    hashMap.put("bindSerial", aD2);
                    if (this.jsp != null) {
                        this.jsp.a(1, null, hashMap);
                    }
                } else if (this.jsp != null) {
                    this.jsp.a(2, null, null);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a$4 */
    class AnonymousClass4 implements com.tencent.mm.ui.MMActivity.a {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.g.b.a jsp;

        AnonymousClass4(com.tencent.mm.plugin.appbrand.jsapi.g.b.a aVar) {
            this.jsp = aVar;
        }

        public final void b(int i, int i2, Intent intent) {
            if (i == (a.this.hashCode() & 65535)) {
                if (i2 == -1) {
                    if (this.jsp != null) {
                        this.jsp.a(1, null, null);
                    }
                } else if (i2 == 2) {
                    if (this.jsp != null) {
                        this.jsp.a(2, intent != null ? intent.getStringExtra("key_result_errmsg") : "", null);
                    }
                } else if (this.jsp != null) {
                    this.jsp.a(3, null, null);
                }
            }
        }
    }

    private a(String str) {
    }

    public final boolean a(MMActivity mMActivity, AppBrandStatObject appBrandStatObject, JSONObject jSONObject, final com.tencent.mm.plugin.appbrand.jsapi.g.b.a aVar, PString pString) {
        g gVar = new g(jSONObject);
        if (appBrandStatObject != null) {
            gVar.frE = g.eG(appBrandStatObject.scene, appBrandStatObject.fJm);
        }
        gVar.fDQ = 46;
        pString.value = gVar.packageExt;
        return h.a(mMActivity, gVar, hashCode() & 65535, new com.tencent.mm.ui.MMActivity.a() {
            public final void b(int i, int i2, Intent intent) {
                if (i == (a.this.hashCode() & 65535)) {
                    if (i2 == -1) {
                        if (aVar != null) {
                            aVar.a(1, null, null);
                        }
                    } else if (i2 == 5) {
                        int intExtra = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                        x.e("MicroMsg.AppBrandJsApiPayService", "errCode: %d, errMsg: %s", Integer.valueOf(intExtra), bi.oM(intent.getStringExtra("key_jsapi_pay_err_msg")));
                        if (aVar != null) {
                            aVar.a(2, r1, null);
                        }
                    } else if (aVar != null) {
                        aVar.a(3, null, null);
                    }
                }
            }
        });
    }

    public final void a(MMActivity mMActivity, JSONObject jSONObject, final b bVar) {
        com.tencent.mm.ui.MMActivity.a anonymousClass5 = new com.tencent.mm.ui.MMActivity.a() {
            public final void b(int i, int i2, Intent intent) {
                if (i == (a.this.hashCode() & 65535)) {
                    if (i2 == -1) {
                        Object obj = "";
                        if (intent != null) {
                            obj = bi.aD(intent.getStringExtra("token"), "");
                        }
                        if (TextUtils.isEmpty(obj)) {
                            x.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is empty, verifyWCPayPassword:fail");
                            if (bVar != null) {
                                bVar.d(false, null);
                                return;
                            }
                            return;
                        }
                        x.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is valid, verifyWCPayPassword:ok");
                        if (bVar != null) {
                            bVar.d(true, obj);
                        }
                    } else if (bVar != null) {
                        bVar.d(false, null);
                    }
                }
            }
        };
        g gVar = new g(jSONObject);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar.appId);
        intent.putExtra("timeStamp", gVar.timeStamp);
        intent.putExtra("nonceStr", gVar.nonceStr);
        intent.putExtra("packageExt", gVar.packageExt);
        intent.putExtra("signtype", gVar.signType);
        intent.putExtra("paySignature", gVar.fDO);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar.url);
        intent.putExtra("scene", 1);
        mMActivity.jCj = anonymousClass5;
        Context context = mMActivity;
        d.a(context, "wallet_core", ".ui.WalletCheckPwdUI", intent, 65535 & hashCode(), false);
    }
}
