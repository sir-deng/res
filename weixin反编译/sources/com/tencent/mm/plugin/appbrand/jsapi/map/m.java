package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.widget.e.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m extends com.tencent.mm.plugin.appbrand.widget.e.a {
    public static final int CTRL_INDEX = 200;
    public static final String NAME = "translateMapMarker";
    private static final LinkedList<JSONObject> jpG = new LinkedList();
    private p jlr;
    private com.tencent.mm.plugin.appbrand.widget.e.a.a jpH;
    private h jpI;
    private double jpJ;
    private double jpK;
    private int jpL;
    private f jpM;
    private a jpN = new a() {
        public final void afx() {
            c.Dt().F(new Runnable() {
                public final void run() {
                    synchronized (this) {
                        final JSONObject jSONObject = (JSONObject) m.jpG.pollFirst();
                        if (jSONObject != null) {
                            x.d("MicroMsg.JsApiTranslateMapMarker", "run, start post next animator!");
                            c.runOnUiThread(new Runnable() {
                                public final void run() {
                                    m.a(m.this, jSONObject);
                                }
                            });
                        } else {
                            x.d("MicroMsg.JsApiTranslateMapMarker", "run, animator end!");
                            m.this.jpM.sE(m.this.e("ok", null));
                            m.this.jpH.aok();
                        }
                    }
                }
            });
        }
    };
    private b jpn;

    public interface a {
        void afx();
    }

    static /* synthetic */ void a(m mVar, JSONObject jSONObject) {
        boolean z;
        int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
        if (jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)) {
            float optDouble = (float) jSONObject.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
            float rotation = mVar.jpI.getRotation();
            com.tencent.mm.plugin.appbrand.widget.e.c cVar = new com.tencent.mm.plugin.appbrand.widget.e.c(mVar.jpI, (long) optInt, rotation, optDouble + rotation);
            cVar.a(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                    x.d("MicroMsg.JsApiTranslateMapMarker", "MarkerRotateAnimator start");
                }

                public final void onAnimationEnd(Animator animator) {
                    x.d("MicroMsg.JsApiTranslateMapMarker", "MarkerRotateAnimator end");
                    m.this.jpN.afx();
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            cVar.aom();
            z = true;
        } else {
            z = false;
        }
        b.f[] fVarArr = new b.f[2];
        if (jSONObject.has("latitude") && jSONObject.has("longitude")) {
            float f = bi.getFloat(jSONObject.optString("latitude"), 0.0f);
            float f2 = bi.getFloat(jSONObject.optString("longitude"), 0.0f);
            fVarArr[0] = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).e(mVar.jpJ, mVar.jpK);
            fVarArr[1] = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).e((double) f, (double) f2);
            mVar.jpJ = (double) f;
            mVar.jpK = (double) f2;
            d dVar = new d(mVar.jpI, mVar.jpn, (long) optInt, fVarArr, z);
            dVar.a(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                    x.d("MicroMsg.JsApiTranslateMapMarker", "MarkerTranslateAnimator start");
                }

                public final void onAnimationEnd(Animator animator) {
                    x.d("MicroMsg.JsApiTranslateMapMarker", "MarkerTranslateAnimator end");
                    m.this.jpN.afx();
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            dVar.aom();
        }
    }

    protected final int j(JSONObject jSONObject) {
        int i = 0;
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiTranslateMapMarker", "get mapId error, exception : %s", e);
            return i;
        }
    }

    protected final boolean a(p pVar, int i, View view, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.widget.e.a.a aVar, f fVar) {
        this.jpH = aVar;
        this.jlr = pVar;
        this.jpL = i;
        this.jpM = fVar;
        u.b z = pVar.aeW().z(i, false);
        if (z == null) {
            x.e("MicroMsg.JsApiTranslateMapMarker", "KeyValueSet(%s) is null.", Integer.valueOf(i));
            fVar.sE(e("fail", null));
            return false;
        } else if (view instanceof CoverViewContainer) {
            String optString = jSONObject.optString("markerId");
            Map map = (Map) z.get("marker", null);
            if (map == null || map.size() < 0) {
                x.e("MicroMsg.JsApiTranslateMapMarker", "markerMap is empty!");
                fVar.sE(e("fail", null));
                return false;
            }
            this.jpI = (h) map.get(optString);
            if (this.jpI == null) {
                x.e("MicroMsg.JsApiTranslateMapMarker", "get marker failed!");
                fVar.sE(e("fail", null));
                return false;
            }
            this.jpn = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).bE(((CoverViewContainer) view).w(View.class));
            try {
                this.jpJ = this.jpI.abU().abS();
                this.jpK = this.jpI.abU().abT();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("keyFrames"));
                x.d("MicroMsg.JsApiTranslateMapMarker", "keyFramesArray size :%d", Integer.valueOf(jSONArray.length()));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    jpG.add((JSONObject) jSONArray.get(i2));
                }
                this.jpN.afx();
                return true;
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiTranslateMapMarker", "parse keyFrames error, exception : %s", e);
                fVar.sE(e("fail", null));
                return false;
            }
        } else {
            x.w("MicroMsg.JsApiTranslateMapMarker", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
            return false;
        }
    }

    protected final boolean agd() {
        return true;
    }
}
