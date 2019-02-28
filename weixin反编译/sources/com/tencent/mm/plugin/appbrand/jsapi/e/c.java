package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.b;
import com.tencent.mm.plugin.appbrand.widget.input.b.e;
import com.tencent.mm.plugin.appbrand.widget.input.v;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.g;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends f {
    private static final int CTRL_INDEX = 110;
    private static final String NAME = "insertTextArea";

    private static final class a extends f {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTextAreaHeightChange";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        super.a(pVar, jSONObject, i);
    }

    protected final boolean agB() {
        return false;
    }

    protected final boolean agC() {
        return false;
    }

    protected final boolean a(e eVar, JSONObject jSONObject, p pVar, int i) {
        if (!super.a(eVar, jSONObject, pVar, i)) {
            return false;
        }
        eVar.khN = Boolean.valueOf(true);
        eVar.khp = "emoji";
        eVar.khq = false;
        eVar.khr = false;
        eVar.khT = Boolean.valueOf(false);
        eVar.khO = Boolean.valueOf(jSONObject.optBoolean("confirm", true));
        return true;
    }

    protected final void a(final AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        super.a(appBrandInputInvokeHandler);
        appBrandInputInvokeHandler.setOnLineHeightChangeListener(new b() {
            public final void bI(int i, int i2) {
                int inputId = appBrandInputInvokeHandler.getInputId();
                p kA = a.kA(inputId);
                if (kA != null && kA.isRunning()) {
                    a aVar = new a();
                    Map hashMap = new HashMap();
                    hashMap.put("height", Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.lZ(i2)));
                    hashMap.put("lineCount", Integer.valueOf(i));
                    hashMap.put("inputId", Integer.valueOf(inputId));
                    aVar.aA(kA.mAppId, 0).v(hashMap).f(new int[]{kA.hashCode()});
                }
            }
        });
        appBrandInputInvokeHandler.setOnInputFocusChangeListener(new com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.a() {
            public final void cN(boolean r2) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r1 = this;
                if (r2 != 0) goto L_0x0003;
            L_0x0002:
                return;
            L_0x0003:
                r0 = r2;
                r0 = r0.getInputId();
                r0 = com.tencent.mm.plugin.appbrand.jsapi.e.a.kA(r0);
                if (r0 == 0) goto L_0x0002;
            L_0x000f:
                r0 = r0.isRunning();
                if (r0 != 0) goto L_0x0002;
            L_0x0015:
                goto L_0x0002;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.e.c.2.cN(boolean):void");
            }
        });
    }

    protected final AppBrandInputInvokeHandler a(final WeakReference<p> weakReference, final String str, final int i) {
        return new v() {
            public final void onInputDone(String str, int i, boolean z, boolean z2) {
                if (weakReference.get() != null) {
                    try {
                        String jSONObject = new JSONObject().put(Columns.VALUE, com.tencent.mm.plugin.appbrand.r.c.vl(str)).put("inputId", getInputId()).put("cursor", i).toString();
                        if (z) {
                            ((p) weakReference.get()).j("onKeyboardConfirm", jSONObject, 0);
                        }
                        if (!z2) {
                            ((p) weakReference.get()).j("onKeyboardComplete", jSONObject, 0);
                        }
                    } catch (Throwable e) {
                        x.e("MicroMsg.JsApiInsertTextArea", "dispatch input done, exp = %s", bi.i(e));
                    }
                    if (!z2) {
                        agE();
                    }
                }
            }

            public final void onInputInitialized() {
                if (weakReference.get() != null) {
                    int inputId = getInputId();
                    Map hashMap = new HashMap(1);
                    hashMap.put("inputId", Integer.valueOf(inputId));
                    ((p) weakReference.get()).E(i, c.this.e("ok", hashMap));
                    a.J(inputId, str);
                    a.a(inputId, (p) weakReference.get());
                }
            }

            public final void onRuntimeFail() {
                com.tencent.mm.plugin.appbrand.r.c.bl(this);
                if (weakReference.get() != null) {
                    ((p) weakReference.get()).E(i, c.this.e("fail", null));
                    agE();
                }
            }

            public final void kB(int i) {
                try {
                    p pVar = (p) weakReference.get();
                    if (pVar != null) {
                        pVar.j("onKeyboardShow", g.Ck().C("inputId", getInputId()).C("height", com.tencent.mm.plugin.appbrand.q.f.lZ(i)).toString(), 0);
                    }
                } catch (Exception e) {
                }
            }

            private void agE() {
                p pVar = (p) weakReference.get();
                if (pVar != null && pVar.jJw != null) {
                    com.tencent.mm.plugin.appbrand.widget.input.g.anh().p(pVar.jJw);
                }
            }
        };
    }

    protected final boolean agD() {
        return false;
    }
}
