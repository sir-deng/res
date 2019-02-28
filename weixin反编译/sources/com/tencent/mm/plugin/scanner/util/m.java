package com.tencent.mm.plugin.scanner.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class m implements SensorEventListener {
    public static final m qgZ = new m();
    public SensorManager bgR = ((SensorManager) ad.getContext().getSystemService("sensor"));
    public Sensor qgV = this.bgR.getDefaultSensor(1);
    public float[] qgW = new float[3];
    public int qgX;
    private long qgY;

    private m() {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            x.d("MicroMsg.ScanStableDetector", "x:%f,y:%f,z:%f", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), Float.valueOf(fArr[2]));
            if (this.qgW[0] == 0.0f && this.qgW[1] == 0.0f && this.qgW[2] == 0.0f) {
                this.qgW[0] = fArr[0];
                this.qgW[1] = fArr[1];
                this.qgW[2] = fArr[2];
                return;
            }
            if (Math.abs(fArr[0] - this.qgW[0]) > 0.7f || Math.abs(fArr[1] - this.qgW[1]) > 0.7f || Math.abs(fArr[2] - this.qgW[2]) > 0.7f) {
                x.d("MicroMsg.ScanStableDetector", "scan unstable");
                this.qgX = 0;
            } else {
                if (this.qgX == 0) {
                    this.qgY = System.currentTimeMillis();
                }
                this.qgX++;
                if (this.qgX >= 5) {
                    x.d("MicroMsg.ScanStableDetector", "scan stable");
                }
            }
            this.qgW[0] = fArr[0];
            this.qgW[1] = fArr[1];
            this.qgW[2] = fArr[2];
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void stop() {
        x.i("MicroMsg.ScanStableDetector", "stop detect scan stable");
        if (this.bgR != null) {
            x.i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
            this.bgR.unregisterListener(this);
        }
    }

    public final long bqx() {
        if (this.qgX >= 5) {
            return this.qgY;
        }
        return 0;
    }
}
