package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.r.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 94;
    public static final String NAME = "enableCompass";
    SensorManager bgR;
    private Handler mHandler = new Handler(c.Dt().oFY.getLooper());

    private static abstract class b extends com.tencent.mm.plugin.appbrand.c.b implements SensorEventListener {
        private f jtG;
        boolean jtK;
        private float[] jtL = new float[3];
        private float[] jtM = new float[3];
        a jtN = new a();

        b(final j jVar) {
            this.jtN.a(jVar);
            this.jtG = new f((long) c.aha(), new com.tencent.mm.plugin.appbrand.r.f.a() {
                public final boolean g(Object... objArr) {
                    x.v("MicroMsg.JsApiEnableCompass", "onAction.");
                    float[] fArr = new float[3];
                    float[] fArr2 = new float[9];
                    SensorManager.getRotationMatrix(fArr2, null, b.this.jtL, b.this.jtM);
                    SensorManager.getOrientation(fArr2, fArr);
                    Map hashMap = new HashMap();
                    float toDegrees = (float) Math.toDegrees((double) fArr[0]);
                    if (toDegrees < 0.0f) {
                        toDegrees += 360.0f;
                    }
                    hashMap.put(TencentLocation.EXTRA_DIRECTION, Float.valueOf(toDegrees));
                    b.this.jtN.v(hashMap);
                    return c.agY().a(b.this.jtN, jVar);
                }
            });
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (!this.jtK) {
                if (sensorEvent.values == null || sensorEvent.values.length < 3) {
                    x.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
                    return;
                }
                if (sensorEvent.sensor.getType() == 2) {
                    this.jtM = sensorEvent.values;
                } else if (sensorEvent.sensor.getType() == 1) {
                    this.jtL = sensorEvent.values;
                } else {
                    return;
                }
                boolean i = this.jtG.i(new Object[0]);
                x.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", Boolean.valueOf(i));
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public static final class a extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 95;
        private static final String NAME = "onCompassChange";
    }

    public final void a(final j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        try {
            boolean z = jSONObject.getBoolean("enable");
            if (this.bgR == null) {
                this.bgR = (SensorManager) jVar.getContext().getSystemService("sensor");
            }
            if (this.bgR == null) {
                x.i("MicroMsg.JsApiEnableCompass", "getSystemService(SENSOR_SERVICE) failed.");
                jVar.E(i, e("fail", null));
                return;
            }
            Sensor defaultSensor = this.bgR.getDefaultSensor(2);
            Sensor defaultSensor2 = this.bgR.getDefaultSensor(1);
            if (defaultSensor == null || defaultSensor2 == null) {
                x.i("MicroMsg.JsApiEnableCompass", "get compass or accelerometer sensor failed.");
                jVar.E(i, e("fail", null));
                return;
            }
            boolean z2;
            String e;
            String str = "JsApi#SensorMagneticField" + jVar.hashCode();
            com.tencent.mm.y.u.b t;
            if (z) {
                com.tencent.mm.y.u.b hA = u.GQ().hA(str);
                if (hA == null) {
                    t = u.GQ().t(str, true);
                } else {
                    t = hA;
                }
                if (((b) t.get("sensor_event_listener", null)) != null) {
                    x.w("MicroMsg.JsApiEnableCompass", "register failed, sensorEventListener has already registered.");
                    jVar.E(i, e("fail, has enable, should stop pre operation", null));
                    return;
                }
                com.tencent.mm.plugin.appbrand.c.b anonymousClass1 = new b(jVar) {
                    public final void onDestroy() {
                        com.tencent.mm.plugin.appbrand.c.b(jVar.mAppId, this);
                        b.this.bgR.unregisterListener(this);
                    }
                };
                com.tencent.mm.plugin.appbrand.c.a(jVar.mAppId, anonymousClass1);
                t.o("sensor_event_listener", anonymousClass1);
                z2 = this.bgR.registerListener(anonymousClass1, defaultSensor, 3, this.mHandler) && this.bgR.registerListener(anonymousClass1, defaultSensor2, 3, this.mHandler);
                if (!z2) {
                    this.bgR.unregisterListener(anonymousClass1);
                    anonymousClass1.jtK = true;
                    com.tencent.mm.plugin.appbrand.c.b(jVar.mAppId, anonymousClass1);
                    t.recycle();
                    u.GQ().hB(str);
                }
                x.i("MicroMsg.JsApiEnableCompass", "register compass sensor finished(s : %s, r : %s).", str, Boolean.valueOf(z2));
            } else {
                t = u.GQ().hB(str);
                if (t == null) {
                    x.i("MicroMsg.JsApiEnableCompass", "unregister sensor event listener failed, keyValueSet do not exist.");
                    jVar.E(i, e("fail", null));
                    return;
                }
                b bVar = (b) t.get("sensor_event_listener", null);
                if (bVar == null) {
                    x.i("MicroMsg.JsApiEnableCompass", "unregister sensor event listener failed, listener do not exist.");
                    jVar.E(i, e("fail", null));
                    return;
                }
                this.bgR.unregisterListener(bVar);
                com.tencent.mm.plugin.appbrand.c.b(jVar.mAppId, bVar);
                bVar.jtK = true;
                t.recycle();
                x.i("MicroMsg.JsApiEnableCompass", "unregister compass sensor finished(%s).", str);
                z2 = true;
            }
            if (z2) {
                e = e("ok", null);
            } else {
                e = e("fail", null);
            }
            jVar.E(i, e);
        } catch (JSONException e2) {
            x.i("MicroMsg.JsApiEnableCompass", "json data do not contains parameter enable.");
            jVar.E(i, e("fail", null));
        }
    }
}
