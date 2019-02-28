package com.tencent.mm.pluginsdk.k;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class c {
    private SensorManager vpi;
    private a vpj;

    public static abstract class a implements SensorEventListener {
        private static int vpm;
        private final float[] vpk = new float[]{2.0f, 2.5f, 0.5f};
        private float[] vpl = new float[3];

        public abstract void bfv();

        public abstract void onRelease();

        public static void reset() {
            x.d("MicroMsg.ShakeSensorListener", "reset threadHold");
            vpm = 5;
            if (Build.MODEL.equals("LG-E510")) {
                vpm = 4;
            }
        }

        static {
            vpm = 5;
            if (Build.MODEL.equals("LG-E510")) {
                vpm = 4;
            }
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = new float[3];
            float[] fArr2 = sensorEvent.values;
            int i = 0;
            for (int i2 = 0; i2 < 3; i2++) {
                fArr[i2] = (float) Math.round((this.vpk[i2] * (fArr2[i2] - this.vpl[i2])) * 0.45f);
                float abs = Math.abs(fArr[i2]);
                if (abs >= 4.0f) {
                    x.v("MicroMsg.ShakeSensorListener", "result:" + abs + " THREAHOLD:" + vpm);
                }
                if (vpm < 9) {
                    if (abs >= 14.0f) {
                        vpm = 9;
                    } else {
                        int i3 = (int) abs;
                        if (vpm < i3 - 4) {
                            vpm = i3 - 4;
                        }
                    }
                }
                if (abs > ((float) vpm)) {
                    i = 1;
                }
                this.vpl[i2] = fArr2[i2];
            }
            if (i != 0) {
                x.d("MicroMsg.ShakeSensorListener", "sensorChanged " + sensorEvent.sensor.getName() + " (" + fArr2[0] + ", " + fArr2[1] + ", " + fArr2[2] + ") diff(" + fArr[0] + " " + fArr[1] + " " + fArr[2] + ")");
                bfv();
                float[] fArr3 = sensorEvent.values;
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public c(Context context) {
        this.vpi = (SensorManager) context.getSystemService("sensor");
    }

    public final boolean cay() {
        return this.vpj != null;
    }

    public final void caz() {
        if (this.vpj != null) {
            a.reset();
        }
    }

    public final void a(a aVar) {
        aQC();
        if (caB()) {
            this.vpj = aVar;
            this.vpi.registerListener(this.vpj, this.vpi.getDefaultSensor(1), 1);
            return;
        }
        x.e("MicroMsg.ShakeSensorService", "no sensor found for shake detection");
    }

    public final void aQC() {
        if (this.vpj != null) {
            this.vpj.onRelease();
            this.vpi.unregisterListener(this.vpj, this.vpi.getDefaultSensor(1));
            this.vpj = null;
        }
    }

    public final boolean caA() {
        return caB();
    }

    private boolean caB() {
        if (this.vpi == null) {
            x.e("MicroMsg.ShakeSensorService", "cannot init sensor manager");
            return false;
        }
        List sensorList = this.vpi.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            return false;
        }
        return true;
    }
}
