package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import java.util.List;

public final class az {
    private SensorManager vpi;
    private a xqz;

    static class a implements SensorListener {
        private Runnable frD;
        private float[] vpl = new float[]{0.0f, 0.0f, 0.0f};

        public a(Runnable runnable) {
            this.frD = runnable;
        }

        public final void onAccuracyChanged(int i, int i2) {
        }

        public final void onSensorChanged(int i, float[] fArr) {
            Object obj = null;
            float[] fArr2 = new float[3];
            int i2 = 0;
            while (i2 < 3) {
                fArr2[i2] = Math.abs(fArr[i2] - this.vpl[i2]);
                if (this.vpl[i2] != 0.0f && fArr2[i2] > 1.0f) {
                    obj = 1;
                    x.d("MicroMsg.ShakeManager", "isONShake:" + fArr2[i2]);
                }
                this.vpl[i2] = fArr[i2];
                i2++;
            }
            if (obj != null) {
                this.frD.run();
            }
        }
    }

    public az(Context context) {
        this.vpi = (SensorManager) context.getSystemService("sensor");
    }

    public final boolean O(Runnable runnable) {
        if (this.vpi == null) {
            return false;
        }
        List sensorList = this.vpi.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            return false;
        }
        this.xqz = new a(runnable);
        this.vpi.registerListener(this.xqz, 2, 3);
        return true;
    }

    public final void cgT() {
        if (this.vpi != null && this.xqz != null) {
            this.vpi.unregisterListener(this.xqz, 2);
        }
    }
}
