package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.List;

final class e implements SensorEventListener {
    private static int oxA = Integer.MAX_VALUE;
    Camera gGm = null;
    private Context mContext = null;
    private float oxD = 0.0f;
    private float oxE = 0.0f;
    private float oxF = 0.0f;
    boolean oxw = false;
    boolean oxy = false;
    private int oxz = 0;
    private boolean oyb = false;
    com.tencent.mm.pluginsdk.k.a qDx = com.tencent.mm.pluginsdk.k.a.caw();
    private PreviewCallback qDy = null;
    a qDz = new a(Looper.getMainLooper());

    private static class a extends ag {
        static boolean oyc = true;
        static AutoFocusCallback oyd = new AutoFocusCallback() {
            public final void onAutoFocus(boolean z, Camera camera) {
                x.v("MicroMsg.SightCamera", "auto focus callback");
                a.oyc = true;
            }
        };
        float nOR;
        boolean oxw = false;
        int oyl = 0;
        boolean oym = false;
        boolean oyn = false;
        float oyo;
        int oyp;
        int oyq;

        private static Rect a(float f, float f2, float f3, int i, int i2) {
            int intValue = Float.valueOf(((float) com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 72)) * f3).intValue();
            RectF rectF = new RectF();
            rectF.set((((f - ((float) (intValue / 2))) * 2000.0f) / ((float) i)) - 1000.0f, (((f2 - ((float) (intValue / 2))) * 2000.0f) / ((float) i2)) - 1000.0f, (((((float) (intValue / 2)) + f) * 2000.0f) / ((float) i)) - 1000.0f, (((((float) (intValue / 2)) + f2) * 2000.0f) / ((float) i2)) - 1000.0f);
            return new Rect(te(Math.round(rectF.left)), te(Math.round(rectF.top)), te(Math.round(rectF.right)), te(Math.round(rectF.bottom)));
        }

        private static int te(int i) {
            if (i > 1000) {
                return 1000;
            }
            return i < DownloadResult.CODE_UNDEFINED ? DownloadResult.CODE_UNDEFINED : i;
        }

        static void f(Camera camera) {
            if (camera == null) {
                x.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
            }
            if (oyc) {
                oyc = false;
                try {
                    camera.autoFocus(oyd);
                    return;
                } catch (Exception e) {
                    x.w("MicroMsg.SightCamera", "autofocus fail, exception %s", e.getMessage());
                    oyc = true;
                    return;
                }
            }
            x.w("MicroMsg.SightCamera", "auto focus not back");
        }

        public a(Looper looper) {
            super(looper);
        }

        private static int b(Parameters parameters) {
            if (parameters == null) {
                return 0;
            }
            int maxZoom;
            try {
                maxZoom = parameters.getMaxZoom() / 2;
                if (maxZoom <= 0) {
                    maxZoom = parameters.getMaxZoom();
                }
            } catch (Exception e) {
                x.e("MicroMsg.SightCamera", "get target zoom value error: %s", e.getMessage());
                maxZoom = 0;
            }
            return maxZoom;
        }

        static int d(Parameters parameters) {
            int b = b(parameters) / 6;
            if (b <= 0) {
                return 1;
            }
            return b;
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            Camera camera;
            switch (message.what) {
                case 4353:
                    if (!this.oyn) {
                        int b;
                        camera = (Camera) message.obj;
                        Parameters parameters = camera.getParameters();
                        x.i("MicroMsg.SightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", Boolean.valueOf(this.oxw), Integer.valueOf(this.oyl), Integer.valueOf(parameters.getZoom()));
                        int zoom = parameters.getZoom() + this.oyl;
                        if (this.oxw) {
                            b = b(parameters);
                            if (zoom < b) {
                                long j;
                                Message obtainMessage = obtainMessage(4353, message.obj);
                                if (this.oym) {
                                    j = 10;
                                } else {
                                    j = 20;
                                }
                                sendMessageDelayed(obtainMessage, j);
                                z = false;
                                b = zoom;
                            }
                        } else if (zoom <= 0) {
                            b = 0;
                        } else {
                            sendMessageDelayed(obtainMessage(4353, message.obj), this.oym ? 10 : 20);
                            z = false;
                            b = zoom;
                        }
                        parameters.setZoom(b);
                        try {
                            camera.setParameters(parameters);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.SightCamera", e, "", new Object[0]);
                        }
                        if (z) {
                            this.oyp = 0;
                            this.oyq = 0;
                            sendMessageDelayed(obtainMessage(4354, message.obj), 20);
                            return;
                        }
                        return;
                    }
                    return;
                case 4354:
                    camera = (Camera) message.obj;
                    if (this.oyp == 0 || this.oyp == 0 || d.fO(14)) {
                        f(camera);
                        return;
                    }
                    float f = this.oyo;
                    float f2 = this.nOR;
                    int i = this.oyp;
                    int i2 = this.oyq;
                    if (camera == null) {
                        x.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
                    }
                    if (oyc) {
                        oyc = false;
                        try {
                            x.i("MicroMsg.SightCamera", "ashutest:: touch %f %f, display %d %d", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2));
                            x.i("MicroMsg.SightCamera", "ashutest:: focus rect %s, meter rect %s", a(f, f2, 1.0f, i, i2), a(f, f2, 1.5f, i, i2));
                            Parameters parameters2 = camera.getParameters();
                            List supportedFocusModes = parameters2.getSupportedFocusModes();
                            if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                                parameters2.setFocusMode("auto");
                            }
                            if (parameters2.getMaxNumFocusAreas() > 0) {
                                supportedFocusModes = new ArrayList(1);
                                supportedFocusModes.add(new Area(r7, 1000));
                                parameters2.setFocusAreas(supportedFocusModes);
                            }
                            if (parameters2.getMaxNumMeteringAreas() > 0) {
                                supportedFocusModes = new ArrayList(1);
                                supportedFocusModes.add(new Area(r2, 1000));
                                parameters2.setMeteringAreas(supportedFocusModes);
                            }
                            camera.setParameters(parameters2);
                            camera.autoFocus(oyd);
                            return;
                        } catch (Exception e2) {
                            x.w("MicroMsg.SightCamera", "autofocus with area fail, exception %s", e2.getMessage());
                            oyc = true;
                            return;
                        }
                    }
                    x.w("MicroMsg.SightCamera", "auto focus not back");
                    return;
                default:
                    return;
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if (Math.abs(this.oxD - f) > 3.0f || Math.abs(this.oxE - f2) > 3.0f || Math.abs(this.oxF - f3) > 3.0f) {
            x.i("MicroMsg.SightCamera", "match accel limit %f, try auto focus", Float.valueOf(3.0f));
            a.f(this.gGm);
            this.oxD = f;
            this.oxE = f2;
            this.oxF = f3;
        }
    }
}
