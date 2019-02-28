package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.compat.a.b.k;
import com.tencent.mm.plugin.appbrand.compat.a.b.l;
import com.tencent.mm.plugin.appbrand.compat.a.b.m;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    public static final int CTRL_INDEX = 2;
    public static final String NAME = "insertMap";

    private class b implements SensorEventListener {
        int fAB;
        com.tencent.mm.y.u.b iWz;
        private float jpE = 0.0f;
        private long timestamp = 200;

        public b(int i, com.tencent.mm.y.u.b bVar) {
            this.fAB = i;
            this.iWz = bVar;
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
                float aA = r.aA(sensorEvent.values[0]);
                if (currentTimeMillis > 200 && Math.abs(aA - this.jpE) > 3.0f) {
                    AppbrandMapLocationPoint appbrandMapLocationPoint = (AppbrandMapLocationPoint) this.iWz.get(this.fAB, null);
                    if (appbrandMapLocationPoint != null) {
                        float f = this.jpE;
                        float f2 = (f < 0.0f || f > 45.0f || aA < 315.0f || aA >= 360.0f) ? aA : aA - 360.0f;
                        if ((f < 0.0f || f > 45.0f || aA < 315.0f || aA >= 360.0f) && f >= 315.0f && f < 360.0f && aA >= 0.0f && aA <= 45.0f) {
                            f -= 360.0f;
                        }
                        Animation rotateAnimation = new RotateAnimation(f, f2, 1, 0.5f, 1, 0.5f);
                        rotateAnimation.setDuration(200);
                        rotateAnimation.setFillAfter(true);
                        appbrandMapLocationPoint.jpf.startAnimation(rotateAnimation);
                    }
                    this.jpE = aA;
                    this.timestamp = System.currentTimeMillis();
                }
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public static class a extends f {
        private static final int CTRL_INDEX = 147;
        private static final String NAME = "onMapRegionChange";
    }

    public static class c extends f {
        private static final int CTRL_INDEX = 151;
        private static final String NAME = "onMapClick";
    }

    protected final View a(p pVar, JSONObject jSONObject) {
        float f = bi.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
        float f2 = bi.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
        if (Math.abs(f) > 90.0f || Math.abs(f2) > 180.0f) {
            x.d("MicroMsg.JsApiInsertMap", "centerLatitude or centerLongitude value is error!");
            return null;
        }
        com.tencent.mm.plugin.appbrand.compat.a.b bP;
        Context context = pVar.mContext;
        String optString = jSONObject.optString("theme", "normal");
        x.i("MicroMsg.JsApiInsertMap", "theme:%s", optString);
        if (optString.equals("normal") || !optString.equals("handDraw")) {
            bP = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).bP(context);
        } else {
            bP = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).bQ(context);
        }
        bP.getView().setVisibility(0);
        return new CoverViewContainer(context, bP.getView());
    }

    protected final int j(JSONObject jSONObject) {
        return jSONObject.getInt("mapId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        final com.tencent.mm.plugin.appbrand.compat.a.b bE = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).bE(((CoverViewContainer) view).w(View.class));
        com.tencent.mm.y.u.b z = pVar.aeW().z(i, true);
        if (jSONObject.optBoolean("showLocation")) {
            final com.tencent.mm.y.u.b z2 = pVar.aeW().z(i, true);
            final p pVar2 = pVar;
            final int i2 = i;
            com.tencent.mm.plugin.appbrand.r.b.b anonymousClass5 = new com.tencent.mm.plugin.appbrand.r.b.b() {
                public final void a(double d, double d2, com.tencent.mm.plugin.appbrand.r.b.b.a aVar, double d3, double d4, double d5) {
                    if (pVar2.mContext == null || com.tencent.mm.pluginsdk.g.a.aZ(pVar2.mContext, "android.permission.ACCESS_COARSE_LOCATION")) {
                        x.d("MicroMsg.JsApiInsertMap", "refresh location latitude = %f, longitude = %f", Double.valueOf(d), Double.valueOf(d2));
                        final double d6 = d;
                        final double d7 = d2;
                        ah.y(new Runnable() {
                            public final void run() {
                                View appbrandMapLocationPoint;
                                View view = (View) z2.get(i2, null);
                                if (view == null) {
                                    appbrandMapLocationPoint = new AppbrandMapLocationPoint(pVar2.mContext);
                                    bE.a(appbrandMapLocationPoint, d6, d7);
                                    z2.o(i2, appbrandMapLocationPoint);
                                } else {
                                    appbrandMapLocationPoint = view;
                                }
                                if (appbrandMapLocationPoint instanceof AppbrandMapLocationPoint) {
                                    AppbrandMapLocationPoint appbrandMapLocationPoint2 = (AppbrandMapLocationPoint) appbrandMapLocationPoint;
                                    bE.b(appbrandMapLocationPoint, d6, d7);
                                    appbrandMapLocationPoint2.jpf.setImageResource(q.f.ivF);
                                    double d = d6;
                                    double d2 = d7;
                                    if (appbrandMapLocationPoint2.jpi == -1.0d && appbrandMapLocationPoint2.jpj == -1.0d) {
                                        appbrandMapLocationPoint2.jpi = d;
                                        appbrandMapLocationPoint2.jpg = d;
                                        appbrandMapLocationPoint2.jpj = d2;
                                        appbrandMapLocationPoint2.jph = d2;
                                        return;
                                    }
                                    appbrandMapLocationPoint2.jpi = appbrandMapLocationPoint2.jpg;
                                    appbrandMapLocationPoint2.jpj = appbrandMapLocationPoint2.jph;
                                    appbrandMapLocationPoint2.jph = d2;
                                    appbrandMapLocationPoint2.jpg = d;
                                }
                            }
                        });
                        return;
                    }
                    x.e("MicroMsg.JsApiInsertMap", "need gps permission");
                }
            };
            b.jYv.a(anonymousClass5);
            final Object bVar = new b(i, z2);
            final SensorManager sensorManager = (SensorManager) ad.getContext().getSystemService("sensor");
            sensorManager.registerListener(bVar, sensorManager.getDefaultSensor(3), 1);
            if (((e) z2.get("mapDestroyListener", null)) == null) {
                final p pVar3 = pVar;
                final com.tencent.mm.plugin.appbrand.compat.a.b bVar2 = bE;
                final com.tencent.mm.plugin.appbrand.r.b.b bVar3 = anonymousClass5;
                final com.tencent.mm.y.u.b bVar4 = z2;
                e anonymousClass6 = new e() {
                    public final void onDestroy() {
                        pVar3.b((e) this);
                        ah.y(new Runnable() {
                            public final void run() {
                                if (bVar2 != null) {
                                    bVar2.getView().setVisibility(8);
                                    bVar2.clean();
                                }
                            }
                        });
                        if (sensorManager != null) {
                            sensorManager.unregisterListener(bVar);
                        }
                        b.jYv.b(bVar3);
                        bVar4.recycle();
                    }
                };
                z2.o("mapDestroyListener", anonymousClass6);
                pVar.a(anonymousClass6);
            }
        } else {
            if (((e) z.get("mapDestroyListener", null)) == null) {
                final p pVar4 = pVar;
                final com.tencent.mm.y.u.b bVar5 = z;
                e anonymousClass1 = new e() {
                    public final void onDestroy() {
                        pVar4.b((e) this);
                        ah.y(new Runnable() {
                            public final void run() {
                                if (bE != null) {
                                    bE.getView().setVisibility(8);
                                    bE.clean();
                                }
                            }
                        });
                        bVar5.recycle();
                    }
                };
                z.o("mapDestroyListener", anonymousClass1);
                pVar.a(anonymousClass1);
            }
        }
        final JSONObject jSONObject2 = jSONObject;
        bE.a(new m() {
            public final void abP() {
                x.i("MicroMsg.JsApiInsertMap", "onMapLoaded");
                float f = bi.getFloat(jSONObject2.optString("centerLatitude"), 0.0f);
                float f2 = bi.getFloat(jSONObject2.optString("centerLongitude"), 0.0f);
                if (Math.abs(f) > 90.0f || Math.abs(f2) > 180.0f) {
                    x.e("MicroMsg.JsApiInsertMap", "[onMapLoaded] centerLatitude or centerLongitude value is error!");
                    return;
                }
                bE.a((double) f, (double) f2, jSONObject2.optInt("scale", 16));
            }
        });
        final int i3 = i;
        final p pVar5 = pVar;
        bE.a(new l() {
            public final void abZ() {
                c cVar = new c();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i3);
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                }
                f a = cVar.a(pVar5);
                a.mData = jSONObject.toString();
                a.afI();
            }
        });
        i3 = i;
        pVar5 = pVar;
        bE.a(new k() {
            boolean jpw = false;
            JSONObject jpx = new JSONObject();
            a jpy = new a();

            public final void abX() {
                try {
                    this.jpx.put("mapId", i3);
                    this.jpx.put(Columns.TYPE, "begin");
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                }
                if (!this.jpw) {
                    this.jpw = true;
                    f a = this.jpy.a(pVar5);
                    a.mData = this.jpx.toString();
                    a.afI();
                }
            }

            public final void abY() {
                try {
                    this.jpx.put("mapId", i3);
                    this.jpx.put(Columns.TYPE, "end");
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                }
                if (this.jpw) {
                    this.jpw = false;
                    f a = this.jpy.a(pVar5);
                    a.mData = this.jpx.toString();
                    a.afI();
                }
            }
        });
        try {
            List arrayList;
            JSONArray jSONArray;
            int i4;
            int i5;
            JSONObject jSONObject3;
            float f;
            float f2;
            String vk;
            com.tencent.mm.plugin.appbrand.compat.a.b.i abM;
            if (jSONObject.has("markers")) {
                arrayList = new ArrayList();
                jSONArray = new JSONArray(jSONObject.optString("markers"));
                i4 = 0;
                while (true) {
                    i5 = i4;
                    if (i5 >= jSONArray.length()) {
                        break;
                    }
                    jSONObject3 = (JSONObject) jSONArray.get(i5);
                    f = bi.getFloat(jSONObject3.optString("latitude"), 0.0f);
                    f2 = bi.getFloat(jSONObject3.optString("longitude"), 0.0f);
                    vk = com.tencent.mm.plugin.appbrand.r.c.vk(jSONObject3.optString("name"));
                    String vk2 = com.tencent.mm.plugin.appbrand.r.c.vk(jSONObject3.optString("desc"));
                    abM = bE.abM();
                    abM.f((double) f, (double) f2);
                    abM.qS(vk);
                    if (!bi.oN(vk2)) {
                        abM.qT(vk2);
                    }
                    arrayList.add(bE.a(abM));
                    i4 = i5 + 1;
                }
                z.o("markers", arrayList);
            }
            try {
                if (jSONObject.has("covers")) {
                    arrayList = new ArrayList();
                    jSONArray = new JSONArray(jSONObject.optString("covers"));
                    i4 = 0;
                    while (true) {
                        i5 = i4;
                        if (i5 < jSONArray.length()) {
                            jSONObject3 = (JSONObject) jSONArray.get(i5);
                            f = bi.getFloat(jSONObject3.optString("latitude"), 0.0f);
                            f2 = bi.getFloat(jSONObject3.optString("longitude"), 0.0f);
                            vk = jSONObject3.optString("iconPath");
                            float optDouble = (float) jSONObject3.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                            abM = bE.abM();
                            abM.f((double) f, (double) f2);
                            Bitmap j = o.j(pVar.iuk, vk);
                            if (!(j == null || j.isRecycled())) {
                                abM.p(j);
                            }
                            abM.T(optDouble);
                            h a = bE.a(abM);
                            a.qR("cover");
                            arrayList.add(a);
                            i4 = i5 + 1;
                        } else {
                            z.o("converters", arrayList);
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.JsApiInsertMap", "parse covers error, exception : %s", e);
            }
        } catch (Exception e2) {
            x.e("MicroMsg.JsApiInsertMap", "parse markers error, exception : %s", e2);
        }
    }
}
