package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.graphics.Color;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.appbrand.widget.input.b.b;
import com.tencent.mm.plugin.appbrand.widget.input.b.d;
import com.tencent.mm.plugin.appbrand.widget.input.b.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

abstract class a<P extends f> extends com.tencent.mm.plugin.appbrand.jsapi.a {
    a() {
    }

    protected boolean a(P p, JSONObject jSONObject, p pVar, int i) {
        JSONObject jSONObject2;
        Throwable e;
        JSONObject jSONObject3;
        try {
            jSONObject2 = new JSONObject(jSONObject.getString("style"));
            try {
                p.khv = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject2, "width"));
                try {
                    p.khw = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject2, "height"));
                } catch (Exception e2) {
                }
                p.khx = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject2, "top"));
                p.khy = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject2, "left"));
            } catch (Exception e3) {
                e = e3;
                if (!agA()) {
                    x.e("MicroMsg.AppBrandJsApiInputBase", "get position info from style, exp = %s", bi.i(e));
                    pVar.E(i, e("fail:invalid data", null));
                    return false;
                }
                if (jSONObject2 == null) {
                    p.khF = jSONObject2.optString("fontWeight", null);
                    try {
                        p.khz = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject2, "minHeight"));
                    } catch (Exception e4) {
                    }
                    try {
                        p.khA = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject2, "maxHeight"));
                    } catch (Exception e5) {
                    }
                    p.khB = jSONObject2.optString("textAlign", null);
                    try {
                        p.khD = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
                    } catch (Exception e6) {
                    }
                    try {
                        p.khC = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
                    } catch (Exception e7) {
                    }
                    try {
                        p.khE = Float.valueOf(com.tencent.mm.plugin.appbrand.q.f.e(jSONObject2, "fontSize"));
                    } catch (Exception e8) {
                    }
                    try {
                        p.khR = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject2, "marginBottom"));
                    } catch (Exception e9) {
                        p.khR = null;
                    }
                    p.khV = d.bo(jSONObject2.opt("lineSpace"));
                    if (p.khV != null) {
                        p.khV = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.ma(p.khV.intValue()));
                    }
                    p.khW = d.bo(jSONObject2.opt("lineHeight"));
                    if (p.khW != null) {
                        p.khW = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.ma(p.khW.intValue()));
                    }
                } else if (!agA()) {
                    x.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
                    pVar.E(i, e("fail:invalid data", null));
                    return false;
                }
                p.khP = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
                p.khu = jSONObject.optString("defaultValue", jSONObject.optString(Columns.VALUE, null));
                p.khG = Integer.valueOf(jSONObject.getInt("maxLength"));
                p.khH = jSONObject.optString("placeholder");
                jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
                p.khK = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
                p.khJ = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject3, "fontSize"));
                p.khI = jSONObject3.optString("fontWeight", "normal");
                p.khM = Boolean.valueOf(jSONObject.getBoolean("hidden"));
                p.khL = Boolean.valueOf(jSONObject.getBoolean("disabled"));
                p.khQ = Boolean.valueOf(jSONObject.getBoolean("fixed"));
                p.khS = b.vF(jSONObject.optString("confirmType"));
                p.khT = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
                p.khU = g.bm(jSONObject.opt("adjustPosition"));
                return true;
            }
        } catch (Exception e10) {
            e = e10;
            jSONObject2 = null;
            if (agA()) {
                x.e("MicroMsg.AppBrandJsApiInputBase", "get position info from style, exp = %s", bi.i(e));
                pVar.E(i, e("fail:invalid data", null));
                return false;
            }
            if (jSONObject2 == null) {
                p.khF = jSONObject2.optString("fontWeight", null);
                p.khz = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject2, "minHeight"));
                p.khA = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject2, "maxHeight"));
                p.khB = jSONObject2.optString("textAlign", null);
                p.khD = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
                p.khC = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
                p.khE = Float.valueOf(com.tencent.mm.plugin.appbrand.q.f.e(jSONObject2, "fontSize"));
                p.khR = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject2, "marginBottom"));
                p.khV = d.bo(jSONObject2.opt("lineSpace"));
                if (p.khV != null) {
                    p.khV = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.ma(p.khV.intValue()));
                }
                p.khW = d.bo(jSONObject2.opt("lineHeight"));
                if (p.khW != null) {
                    p.khW = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.ma(p.khW.intValue()));
                }
            } else if (agA()) {
                x.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
                pVar.E(i, e("fail:invalid data", null));
                return false;
            }
            p.khP = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
            p.khu = jSONObject.optString("defaultValue", jSONObject.optString(Columns.VALUE, null));
            p.khG = Integer.valueOf(jSONObject.getInt("maxLength"));
            p.khH = jSONObject.optString("placeholder");
            jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
            p.khK = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
            p.khJ = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject3, "fontSize"));
            p.khI = jSONObject3.optString("fontWeight", "normal");
            p.khM = Boolean.valueOf(jSONObject.getBoolean("hidden"));
            p.khL = Boolean.valueOf(jSONObject.getBoolean("disabled"));
            p.khQ = Boolean.valueOf(jSONObject.getBoolean("fixed"));
            p.khS = b.vF(jSONObject.optString("confirmType"));
            p.khT = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
            p.khU = g.bm(jSONObject.opt("adjustPosition"));
            return true;
        }
        if (jSONObject2 == null) {
            p.khF = jSONObject2.optString("fontWeight", null);
            p.khz = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject2, "minHeight"));
            p.khA = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject2, "maxHeight"));
            p.khB = jSONObject2.optString("textAlign", null);
            p.khD = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
            p.khC = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
            p.khE = Float.valueOf(com.tencent.mm.plugin.appbrand.q.f.e(jSONObject2, "fontSize"));
            p.khR = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject2, "marginBottom"));
            p.khV = d.bo(jSONObject2.opt("lineSpace"));
            if (p.khV != null) {
                p.khV = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.ma(p.khV.intValue()));
            }
            p.khW = d.bo(jSONObject2.opt("lineHeight"));
            if (p.khW != null) {
                p.khW = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.ma(p.khW.intValue()));
            }
        } else if (agA()) {
            x.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
            pVar.E(i, e("fail:invalid data", null));
            return false;
        }
        try {
            p.khP = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
        } catch (Exception e11) {
        }
        p.khu = jSONObject.optString("defaultValue", jSONObject.optString(Columns.VALUE, null));
        try {
            p.khG = Integer.valueOf(jSONObject.getInt("maxLength"));
        } catch (Exception e12) {
        }
        p.khH = jSONObject.optString("placeholder");
        try {
            jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
            p.khK = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
            p.khJ = Integer.valueOf(com.tencent.mm.plugin.appbrand.q.f.c(jSONObject3, "fontSize"));
            p.khI = jSONObject3.optString("fontWeight", "normal");
        } catch (Exception e13) {
        }
        try {
            p.khM = Boolean.valueOf(jSONObject.getBoolean("hidden"));
        } catch (JSONException e14) {
            p.khM = null;
        }
        try {
            p.khL = Boolean.valueOf(jSONObject.getBoolean("disabled"));
        } catch (Exception e15) {
            p.khL = null;
        }
        try {
            p.khQ = Boolean.valueOf(jSONObject.getBoolean("fixed"));
        } catch (Exception e16) {
            p.khQ = null;
        }
        p.khS = b.vF(jSONObject.optString("confirmType"));
        try {
            p.khT = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
        } catch (Exception e17) {
            p.khT = null;
        }
        p.khU = g.bm(jSONObject.opt("adjustPosition"));
        return true;
    }

    protected boolean agA() {
        return false;
    }

    protected static void J(int i, String str) {
        u.GQ().t("AppBrandJsInput@" + i, true).O("passing_data", str);
    }

    protected static void a(int i, p pVar) {
        if (pVar != null) {
            u.GQ().t("AppBrandJsInput@" + i, true).o("webview_reference", new WeakReference(pVar));
        }
    }

    protected static p kA(int i) {
        u.b hA = u.GQ().hA("AppBrandJsInput@" + i);
        if (hA == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) hA.get("webview_reference", null);
        return weakReference == null ? null : (p) weakReference.get();
    }
}
