package com.tencent.mm.plugin.sport.c;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.plugin.appbrand.jsapi.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class k implements SensorEventListener {
    private static long saa = 0;
    private static long sab = 0;
    private static long sac = 0;
    private static long sad = 0;
    private static long sae = 0;
    private static long saf = 0;
    private static long sag = 0;
    private static long sah = 0;
    public c sai;

    public static long bEg() {
        return sac;
    }

    public static long bEh() {
        return sae;
    }

    public k() {
        sae = 0;
        saf = 0;
        sag = 0;
        sah = 0;
        saa = 0;
        sab = 0;
        sac = 0;
        sad = 0;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        JSONObject bEb = g.bEb();
        if (bEb.optInt("deviceStepSwitch") != 1) {
            if (this.sai != null) {
                this.sai.bDZ();
            }
            x.i("MicroMsg.Sport.SportStepDetector", "device step switch off");
            return;
        }
        int optInt = bEb.optInt("stepCounterMaxStep5m", 3000);
        String str;
        String str2;
        if (sensorEvent != null && sensorEvent.values != null && sensorEvent.values.length > 0) {
            x.i("MicroMsg.Sport.SportStepDetector", "Step change %f, accuracy %s, %s", Float.valueOf(sensorEvent.values[0]), Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp));
            long chg = bi.chg() / 10000;
            if (sae == 0) {
                sae = i.yv(202);
            }
            if (sab == 0) {
                sab = i.yv(203);
            }
            if (sac == 0) {
                sac = i.yv(201);
            }
            if (sad == 0) {
                sad = sac;
            }
            if (saf == 0) {
                saf = i.yv(d.CTRL_INDEX);
            }
            if (sag == 0) {
                sag = saf;
            }
            if (sah == 0) {
                sah = i.yv(c.CTRL_INDEX);
            }
            x.i("MicroMsg.Sport.SportStepDetector", "currentVar: beginOfToday %d saveTodayTime %d preSensorStep %d currentTodayStep %d lastSaveSensorStep %d lastSaveStepTime %d preSysStepTime %d preSensorNanoTime %d", Long.valueOf(chg), Long.valueOf(sae), Long.valueOf(sab), Long.valueOf(sac), Long.valueOf(sad), Long.valueOf(saf), Long.valueOf(sag), Long.valueOf(sah));
            long j = (long) sensorEvent.values[0];
            saa = j;
            if (j >= 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = sensorEvent.timestamp;
                if (sae != chg) {
                    x.i("MicroMsg.Sport.SportStepDetector", "new day beginOfToday: %s saveTodayTime: %s, ", n.bq(10000 * chg), n.bq(sae * 10000));
                    i.M(202, chg);
                    i.M(201, 0);
                    i.M(d.CTRL_INDEX, currentTimeMillis);
                    i.M(c.CTRL_INDEX, sensorEvent.timestamp);
                    i.M(203, (long) ((int) saa));
                    sab = saa;
                    sac = 0;
                    sad = 0;
                    sae = chg;
                    saf = currentTimeMillis;
                    sag = currentTimeMillis;
                    sah = j2;
                    return;
                }
                boolean z;
                long j3 = ((currentTimeMillis - sag) / 300000) + ((long) ((currentTimeMillis - sag) % 300000 > 0 ? 1 : 0));
                long j4 = (((j2 / 1000000) - (sah / 1000000)) / 300000) + ((long) (((j2 / 1000000) - (sah / 1000000)) % 300000 > 0 ? 1 : 0));
                x.i("MicroMsg.Sport.SportStepDetector", "timesOf5Minute(%d, %d). rebootTime: %d %s", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(i.yv(g.CTRL_INDEX)), n.bq(i.yv(g.CTRL_INDEX)));
                boolean z2 = false;
                str = "";
                long j5;
                if (i.yv(g.CTRL_INDEX) > saf) {
                    j5 = saa - sad;
                    if (j5 <= 0 || (j5 >= ((long) optInt) * j4 && j5 >= ((long) optInt) * j3)) {
                        str2 = str;
                        chg = 0;
                    } else {
                        str2 = "rebootIncrease Valid Step diffStep > 0";
                        chg = j5;
                    }
                    if (j5 < 0 && (saa < j4 * ((long) optInt) || saa < j3 * ((long) optInt))) {
                        chg = saa;
                        str2 = "rebootIncrease Valid Step diffStep < 0";
                    }
                    i.M(g.CTRL_INDEX, 0);
                    z = true;
                } else {
                    if (saa < sab) {
                        x.i("MicroMsg.Sport.SportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", Long.valueOf(saa), Long.valueOf(sab), Long.valueOf(sad));
                        j5 = saa;
                        sab = j5;
                        sad = j5;
                        z2 = true;
                    }
                    if (saa - sab < j4 * ((long) optInt) || saa - sab < j3 * ((long) optInt)) {
                        str2 = "normalIncrease Valid Step";
                        z = z2;
                        chg = saa - sab;
                    } else {
                        str2 = str;
                        z = z2;
                        chg = 0;
                    }
                }
                x.i("MicroMsg.Sport.SportStepDetector", "increase step %s %d %b", str2, Long.valueOf(chg), Boolean.valueOf(z));
                sac = chg + sac;
                if (currentTimeMillis - saf > ((long) bEb.optInt("stepCounterSaveInterval", 60000)) || saa - sad > ((long) bEb.optInt("stepCounterSaveStep")) || z) {
                    i.M(201, sac);
                    i.M(203, saa);
                    i.M(d.CTRL_INDEX, currentTimeMillis);
                    i.M(c.CTRL_INDEX, j2);
                    x.i("MicroMsg.Sport.SportStepDetector", "save to [file] currentTodayStep %d lastSaveSensorStep %d preSysStepTime %d lastSaveStepTime %d preSensorNanoTime %d", Long.valueOf(sac), Long.valueOf(sad), Long.valueOf(sag), Long.valueOf(saf), Long.valueOf(sah));
                    saf = currentTimeMillis;
                    sad = saa;
                } else {
                    x.i("MicroMsg.Sport.SportStepDetector", "save to cache currentTodayStep %d preSysStepTime %d lastSaveStepTime %d preSensorNanoTime %d", Long.valueOf(sac), Long.valueOf(sag), Long.valueOf(saf), Long.valueOf(sah));
                }
                sab = saa;
                sag = currentTimeMillis;
                sah = j2;
            }
        } else if (sensorEvent == null || sensorEvent.values == null) {
            str = "MicroMsg.Sport.SportStepDetector";
            str2 = "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(sensorEvent == null);
            objArr[1] = Boolean.valueOf(sensorEvent != null);
            x.e(str, str2, objArr);
        } else {
            x.e("MicroMsg.Sport.SportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp));
            int i = 0;
            float[] fArr = sensorEvent.values;
            int length = fArr.length;
            int i2 = 0;
            while (i2 < length) {
                float f = fArr[i2];
                r10 = new Object[2];
                int i3 = i + 1;
                r10[0] = Integer.valueOf(i);
                r10[1] = Float.valueOf(f);
                x.e("MicroMsg.Sport.SportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", r10);
                i2++;
                i = i3;
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
