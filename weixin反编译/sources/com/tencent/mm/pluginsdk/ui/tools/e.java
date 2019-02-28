package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mm.pluginsdk.ui.tools.r.a;
import com.tencent.mm.sdk.platformtools.x;

public final class e implements a {
    public static e vDM = null;
    public boolean hasInit = false;
    private SensorEventListener tOp;
    private float[] vDI = new float[3];
    int vDJ = -10000;
    int vDK = -10000;
    private SensorManager vDL;

    public final int cdj() {
        x.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.vDJ);
        return this.vDJ;
    }

    public final int getPitch() {
        x.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.vDK);
        return this.vDK;
    }

    public final void eq(Context context) {
        x.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
        if (context == null) {
            x.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
            return;
        }
        if (this.vDL == null) {
            this.vDL = (SensorManager) context.getSystemService("sensor");
        }
        if (this.tOp == null) {
            this.tOp = new SensorEventListener() {
                public final void onSensorChanged(SensorEvent sensorEvent) {
                    if (sensorEvent.sensor.getType() == 3) {
                        e.this.vDI[0] = sensorEvent.values[0];
                        e.this.vDI[1] = sensorEvent.values[1];
                        e.this.vDI[2] = sensorEvent.values[2];
                        if (e.this.vDJ == -10000) {
                            e.this.vDJ = (int) e.this.vDI[0];
                        } else if (e.this.vDI[0] - ((float) e.this.vDJ) > 300.0f || e.this.vDI[0] - ((float) e.this.vDJ) < -300.0f) {
                            e.this.vDJ = (int) e.this.vDI[0];
                        } else {
                            e.this.vDJ = (int) ((((double) e.this.vDJ) * 0.6d) + (((double) e.this.vDI[0]) * 0.4d));
                        }
                        if (e.this.vDJ == 0) {
                            e.this.vDJ = 1;
                        }
                        if (e.this.vDJ == 365) {
                            e.this.vDJ = 364;
                        }
                        if (e.this.vDK == -10000) {
                            e.this.vDK = (int) e.this.vDI[1];
                        } else if (e.this.vDI[1] < -68.0f) {
                            int i = (int) (-68.0d + (((double) (e.this.vDI[1] + 68.0f)) / 1.5d));
                            if (i < -89) {
                                i = -89;
                            }
                            e.this.vDK = i;
                        } else if (e.this.vDI[1] > 89.0f) {
                            e.this.vDK = 89;
                        } else {
                            e.this.vDK = (int) ((((double) e.this.vDK) * 0.6d) + (((double) e.this.vDI[1]) * 0.4d));
                        }
                    }
                }

                public final void onAccuracyChanged(Sensor sensor, int i) {
                    x.i("MicroMsg.HeadingPitchSensorMgr", "onAccuracyChanged");
                }
            };
        }
        boolean registerListener = this.vDL.registerListener(this.tOp, this.vDL.getDefaultSensor(3), 3);
        this.hasInit = true;
        x.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", Boolean.valueOf(registerListener));
    }

    private void cdk() {
        x.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
        if (!(this.vDL == null || this.tOp == null)) {
            x.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
            this.vDL.unregisterListener(this.tOp);
            this.vDL = null;
            this.tOp = null;
        }
        this.hasInit = false;
    }

    public final String getName() {
        return "HeadingPitchSensorMgr";
    }

    public final void bUb() {
        vDM = null;
        cdk();
    }

    public final void dQ(Context context) {
        eq(context);
    }

    public final void bUc() {
        cdk();
    }
}
