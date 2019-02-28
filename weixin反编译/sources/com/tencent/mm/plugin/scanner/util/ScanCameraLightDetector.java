package com.tencent.mm.plugin.scanner.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.f.a.om;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class ScanCameraLightDetector implements SensorEventListener {
    public static final ScanCameraLightDetector qgy = new ScanCameraLightDetector();
    public SensorManager hSO;
    public ag handler;
    public Sensor qgA;
    public boolean qgB = false;
    private float qgC = -1.0f;
    public HandlerThread qgD;
    public long qgz = -1;

    private class a {
        public int height;
        public byte[] ozs;
        public int width;

        private a() {
        }

        public /* synthetic */ a(ScanCameraLightDetector scanCameraLightDetector, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector$1 */
    class AnonymousClass1 extends ag {
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.what == 233) {
                a aVar = (a) message.obj;
                if (aVar != null) {
                    long Wz = bi.Wz();
                    x.i("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", Boolean.valueOf(ScanCameraLightDetector.r(aVar.ozs, aVar.width, aVar.height)), Float.valueOf(ScanCameraLightDetector.this.qgC), Long.valueOf(bi.bB(Wz)));
                    if (ScanCameraLightDetector.r(aVar.ozs, aVar.width, aVar.height)) {
                        x.i("MicroMsg.ScanCameraLightDetector", "is dark now");
                        ah.y(new Runnable() {
                            public final void run() {
                                b omVar = new om();
                                omVar.fHj.fHk = true;
                                com.tencent.mm.sdk.b.a.xmy.m(omVar);
                            }
                        });
                        return;
                    }
                    x.i("MicroMsg.ScanCameraLightDetector", "not dark");
                    ah.y(new Runnable() {
                        public final void run() {
                            b omVar = new om();
                            omVar.fHj.fHk = false;
                            com.tencent.mm.sdk.b.a.xmy.m(omVar);
                        }
                    });
                }
            }
        }
    }

    private static native int calcLumNative(byte[] bArr, int i, int i2);

    static /* synthetic */ boolean r(byte[] bArr, int i, int i2) {
        if (!bi.by(bArr) && bArr.length > i * i2) {
            x.i("MicroMsg.ScanCameraLightDetector", "lum light: %s", Integer.valueOf(calcLumNative(bArr, i, i2)));
            if (calcLumNative(bArr, i, i2) < 50) {
                return true;
            }
        }
        return false;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length > 0) {
            this.qgC = fArr[0];
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        x.d("MicroMsg.ScanCameraLightDetector", "onAccuracyChanged");
    }
}
