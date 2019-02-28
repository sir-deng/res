package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.jg.EType;
import com.jg.JgMethodChecked;

public class SensorController extends BroadcastReceiver implements SensorEventListener {
    private static float xqo = 4.2949673E9f;
    private static float xqq = 0.5f;
    public static boolean xqx = false;
    public static double xqy = -1.0d;
    private Context context;
    private SensorManager hSO;
    private float ror = -1.0f;
    private float xqp;
    private a xqr;
    private Sensor xqs;
    private final boolean xqt;
    private boolean xqu = false;
    public boolean xqv = false;
    private float xqw = -1.0f;

    public interface a {
        void dX(boolean z);
    }

    public SensorController(Context context) {
        if (context == null) {
            this.xqt = false;
            return;
        }
        boolean z;
        this.context = context;
        this.hSO = (SensorManager) context.getSystemService("sensor");
        this.xqs = this.hSO.getDefaultSensor(8);
        if (this.xqs != null) {
            this.ror = Math.min(10.0f, this.xqs.getMaximumRange());
        }
        if (this.ror < 0.0f) {
            x.e("MicroMsg.SensorController", "error, getMaximumRange return %s, set to 1", Float.valueOf(this.ror));
            this.ror = 1.0f;
        }
        if (this.xqs != null) {
            z = true;
        } else {
            z = false;
        }
        this.xqt = z;
        this.xqp = xqq + 1.0f;
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public final void a(a aVar) {
        x.i("MicroMsg.SensorController", "sensor callback set, isRegistered:" + this.xqv + ", proximitySensor: " + this.xqs + ", maxValue: " + this.ror);
        if (!this.xqv) {
            this.xqw = -1.0f;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            this.context.registerReceiver(this, intentFilter);
            this.hSO.registerListener(this, this.xqs, 2);
            this.xqv = true;
        }
        this.xqr = aVar;
    }

    public final void cgS() {
        x.i("MicroMsg.SensorController", "sensor callback removed");
        try {
            this.context.unregisterReceiver(this);
        } catch (Exception e) {
            x.v("MicroMsg.SensorController", "sensor receiver has already unregistered");
        }
        this.hSO.unregisterListener(this, this.xqs);
        this.hSO.unregisterListener(this);
        this.xqv = false;
        this.xqr = null;
        this.xqw = -1.0f;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null && sensorEvent.sensor != null && this.xqs != null && !this.xqu) {
            float f = sensorEvent.values[0];
            double d = 3.0d;
            x.i("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", Float.valueOf(f), Float.valueOf(this.ror), Double.valueOf(3.0d), Double.valueOf(xqy), Float.valueOf(this.xqw), Float.valueOf(this.xqs.getMaximumRange()));
            if (xqy > 0.0d) {
                d = xqy;
            }
            float maximumRange = (xqy > 0.0d || this.ror < 0.0f) ? this.xqs.getMaximumRange() : this.ror;
            x.i("MicroMsg.SensorController", "onSensorChanged, near threshold: %s, max: %s", Float.valueOf(Math.max(0.1f, (float) (((double) maximumRange) / d))), Float.valueOf(maximumRange));
            switch (sensorEvent.sensor.getType()) {
                case 8:
                    if (this.xqr != null && f != this.xqw) {
                        if (f < r0) {
                            x.i("MicroMsg.SensorController", "sensor near-far event near false");
                            this.xqr.dX(false);
                        } else {
                            x.i("MicroMsg.SensorController", "sensor near-far event far true");
                            this.xqr.dX(true);
                        }
                        this.xqw = f;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.HEADSET_PLUG")) {
                int intExtra = intent.getIntExtra("state", 0);
                if (intExtra == 1) {
                    this.xqu = true;
                }
                if (intExtra == 0) {
                    this.xqu = false;
                }
            }
        }
    }
}
