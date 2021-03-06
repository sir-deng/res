package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.r.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 92;
    public static final String NAME = "enableAccelerometer";
    private Handler mHandler = new Handler(c.Dt().oFY.getLooper());

    private static abstract class b extends com.tencent.mm.plugin.appbrand.c.b implements SensorEventListener {
        private f jtG;
        a jtH = new a();

        b(final j jVar) {
            this.jtH.a(jVar);
            this.jtG = new f((long) c.aha(), new com.tencent.mm.plugin.appbrand.r.f.a() {
                public final boolean g(Object... objArr) {
                    float[] fArr = (float[]) objArr[0];
                    Map hashMap = new HashMap();
                    hashMap.put("x", Float.valueOf((-fArr[0]) / 10.0f));
                    hashMap.put("y", Float.valueOf((-fArr[1]) / 10.0f));
                    hashMap.put("z", Float.valueOf((-fArr[2]) / 10.0f));
                    b.this.jtH.v(hashMap);
                    return c.agY().a(b.this.jtH, jVar);
                }
            });
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                if (fArr == null || fArr.length < 3) {
                    x.w("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
                    return;
                }
                boolean i = this.jtG.i(fArr);
                x.v("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", Boolean.valueOf(i));
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public static final class a extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 93;
        private static final String NAME = "onAccelerometerChange";
    }

    public final void a(final j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        try {
            boolean z = jSONObject.getBoolean("enable");
            final SensorManager sensorManager = (SensorManager) jVar.getContext().getSystemService("sensor");
            if (sensorManager == null) {
                x.i("MicroMsg.JsApiEnableAccelerometer", "getSystemService(SENSOR_SERVICE) failed.");
                jVar.E(i, e("fail", null));
                return;
            }
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor == null) {
                x.i("MicroMsg.JsApiEnableAccelerometer", "get Accelerometer sensor failed.");
                jVar.E(i, e("fail", null));
                return;
            }
            boolean z2;
            String e;
            String str = "JsApi#SensorAccelerometer" + jVar.hashCode();
            com.tencent.mm.y.u.b t;
            if (z) {
                com.tencent.mm.y.u.b hA = u.GQ().hA(str);
                if (hA == null) {
                    t = u.GQ().t(str, true);
                } else {
                    t = hA;
                }
                if (((b) t.get("sensor_event_listener", null)) != null) {
                    x.w("MicroMsg.JsApiEnableAccelerometer", "register failed, sensorEventListener has already registered.");
                    jVar.E(i, e("fail, has enable, should stop pre operation", null));
                    return;
                }
                com.tencent.mm.plugin.appbrand.c.b anonymousClass1 = new b(jVar) {
                    public final void onDestroy() {
                        com.tencent.mm.plugin.appbrand.c.b(jVar.mAppId, this);
                        sensorManager.unregisterListener(this);
                    }
                };
                com.tencent.mm.plugin.appbrand.c.a(jVar.mAppId, anonymousClass1);
                t.o("sensor_event_listener", anonymousClass1);
                z = sensorManager.registerListener(anonymousClass1, defaultSensor, 3, this.mHandler);
                if (!z) {
                    sensorManager.unregisterListener(anonymousClass1);
                    com.tencent.mm.plugin.appbrand.c.b(jVar.mAppId, anonymousClass1);
                    t.recycle();
                    u.GQ().hB(str);
                }
                x.i("MicroMsg.JsApiEnableAccelerometer", "register accelerometer sensor finished(s : %s, r : %s).", str, Boolean.valueOf(z));
                z2 = z;
            } else {
                t = u.GQ().hB(str);
                if (t == null) {
                    x.i("MicroMsg.JsApiEnableAccelerometer", "unregister sensor event listener failed, keyValueSet do not exist.");
                    jVar.E(i, e("fail", null));
                    return;
                }
                b bVar = (b) t.get("sensor_event_listener", null);
                if (bVar == null) {
                    x.i("MicroMsg.JsApiEnableAccelerometer", "unregister sensor event listener failed, listener do not exist.");
                    jVar.E(i, e("fail", null));
                    return;
                }
                sensorManager.unregisterListener(bVar);
                com.tencent.mm.plugin.appbrand.c.b(jVar.mAppId, bVar);
                t.recycle();
                x.i("MicroMsg.JsApiEnableAccelerometer", "unregister accelerometer sensor finished(s : %s).", str);
                z2 = true;
            }
            if (z2) {
                e = e("ok", null);
            } else {
                e = e("fail", null);
            }
            jVar.E(i, e);
        } catch (JSONException e2) {
            x.i("MicroMsg.JsApiEnableAccelerometer", "json data do not contains parameter enable.");
            jVar.E(i, e("fail", null));
        }
    }
}
