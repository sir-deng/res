package com.tencent.mm.pluginsdk.k;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.view.SurfaceHolder;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.h;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class f implements SensorEventListener {
    static int oxz = 0;
    SensorManager bgR;
    Camera gGm = null;
    a oxB;
    Sensor oxC;
    private float oxD = 0.0f;
    private float oxE = 0.0f;
    private float oxF = 0.0f;
    private boolean oxy = false;
    private PreviewCallback qDy = null;
    private SurfaceHolder sjj = null;
    a vpn;
    List<Integer> vpo = new ArrayList();
    private boolean vpp = true;
    private boolean vpq = true;
    private AutoFocusCallback vpr = new AutoFocusCallback() {
        public final void onAutoFocus(boolean z, Camera camera) {
            x.d("MicroMsg.YuvReocrder", "auto focus callback");
            f.this.vpq = true;
        }
    };

    public static int caC() {
        return oxz;
    }

    public final void baD() {
        if (!(this.bgR == null || this.oxC == null)) {
            this.bgR.unregisterListener(this);
        }
        if (this.gGm != null) {
            x.d("MicroMsg.YuvReocrder", "release camera");
            this.gGm.setPreviewCallback(null);
            this.gGm.stopPreview();
            this.gGm.release();
            this.gGm = null;
            this.oxy = false;
        }
    }

    @TargetApi(9)
    private static void e(Parameters parameters) {
        int i = Integer.MIN_VALUE;
        if (q.gHF.gFR <= 0 && VERSION.SDK_INT >= 9) {
            List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            if (supportedPreviewFpsRange != null && supportedPreviewFpsRange.size() != 0) {
                int size = supportedPreviewFpsRange.size();
                int i2 = 0;
                int i3 = Integer.MIN_VALUE;
                while (i2 < size) {
                    int i4;
                    int[] iArr = (int[]) supportedPreviewFpsRange.get(i2);
                    if (iArr != null && iArr.length > 1) {
                        int i5 = iArr[0];
                        i4 = iArr[1];
                        x.d("MicroMsg.YuvReocrder", "dkfps %d:[%d %d]", Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(i4));
                        if (i5 >= 0 && i4 >= i5 && i4 >= i) {
                            i = i5;
                            i2++;
                            i3 = i;
                            i = i4;
                        }
                    }
                    i4 = i;
                    i = i3;
                    i2++;
                    i3 = i;
                    i = i4;
                }
                x.d("MicroMsg.YuvReocrder", "dkfps get fit  [%d %d]", Integer.valueOf(i3), Integer.valueOf(i));
                if (i3 != Integer.MAX_VALUE && i != Integer.MAX_VALUE) {
                    try {
                        parameters.setPreviewFpsRange(i3, i);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.YuvReocrder", e, "", new Object[0]);
                    }
                }
            }
        }
    }

    public final int b(SurfaceHolder surfaceHolder) {
        if (this.oxy) {
            return 0;
        }
        if (surfaceHolder == null) {
            return 0 - g.getLine();
        }
        try {
            List supportedVideoSizes;
            List supportedPreviewSizes;
            this.sjj = surfaceHolder;
            Parameters parameters = this.gGm.getParameters();
            a aVar = this.vpn;
            x.d("MicroMsg.YuvReocrder", "getFitRecordSize");
            int i = Integer.MAX_VALUE;
            if (VERSION.SDK_INT >= 11) {
                h hVar = new h();
                supportedVideoSizes = parameters.getSupportedVideoSizes();
            } else {
                supportedVideoSizes = null;
            }
            if (supportedVideoSizes == null) {
                x.d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
                com.tencent.mm.compatible.e.g gVar = new com.tencent.mm.compatible.e.g();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            } else {
                supportedPreviewSizes = supportedVideoSizes;
            }
            Size previewSize;
            if (supportedPreviewSizes != null) {
                int i2 = 0;
                boolean z = false;
                while (i2 < supportedPreviewSizes.size()) {
                    int i3;
                    boolean z2;
                    int i4 = ((Size) supportedPreviewSizes.get(i2)).height;
                    int i5 = ((Size) supportedPreviewSizes.get(i2)).width;
                    x.d("MicroMsg.YuvReocrder", "supp w:" + i5 + " h:" + i4);
                    int i6 = i4 * i5;
                    if ((((aVar.fGt == 0 || aVar.fGt == 180) && i4 >= aVar.oyV && i5 >= aVar.oyW) || ((aVar.fGt == 90 || aVar.fGt == 270) && i5 >= aVar.oyV && i4 >= aVar.oyW)) && i6 < i) {
                        aVar.mqM = i5;
                        aVar.mqN = i4;
                        i3 = i6;
                        z2 = true;
                    } else {
                        z2 = z;
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                    z = z2;
                }
                if (!z) {
                    previewSize = parameters.getPreviewSize();
                    aVar.mqN = previewSize.height;
                    aVar.mqM = previewSize.width;
                }
            } else {
                previewSize = parameters.getPreviewSize();
                aVar.mqN = previewSize.height;
                aVar.mqM = previewSize.width;
            }
            x.d("MicroMsg.YuvReocrder", " rotate:" + aVar.fGt + " w:" + aVar.mqM + " h:" + aVar.mqN);
            parameters.setPreviewSize(this.vpn.mqM, this.vpn.mqN);
            e(parameters);
            Collection supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
            this.vpo.clear();
            this.vpo.addAll(supportedPreviewFrameRates);
            parameters.setPreviewFormat(17);
            supportedVideoSizes = parameters.getSupportedFocusModes();
            if (supportedVideoSizes != null) {
                if (d.fP(9) && true == supportedVideoSizes.contains("continuous-video")) {
                    x.i("MicroMsg.YuvReocrder", "support continous-video");
                    this.vpp = false;
                    parameters.setFocusMode("continuous-video");
                } else if (!supportedVideoSizes.contains("auto")) {
                    x.i("MicroMsg.YuvReocrder", "don't support auto");
                    this.vpp = false;
                }
            }
            this.gGm.setParameters(parameters);
            this.gGm.setPreviewDisplay(surfaceHolder);
            this.gGm.startPreview();
            if (!(this.bgR == null || this.oxC == null || !this.vpp)) {
                this.bgR.registerListener(this, this.oxC, 2);
            }
            this.oxy = true;
            return 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.YuvReocrder", e, "", new Object[0]);
            x.e("MicroMsg.YuvReocrder", "Start preview FAILED :" + e.getMessage());
            return 0 - g.getLine();
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if ((Math.abs(this.oxD - f) > 2.0f || Math.abs(this.oxE - f2) > 2.0f || Math.abs(this.oxF - f3) > 2.0f) && this.gGm != null && this.vpq && true == this.vpp) {
            try {
                x.d("MicroMsg.YuvReocrder", "auto focus");
                this.gGm.autoFocus(this.vpr);
                this.vpq = false;
            } catch (Exception e) {
                x.d("MicroMsg.YuvReocrder", "auto focus failed");
            }
        }
        this.oxD = f;
        this.oxE = f2;
        this.oxF = f3;
    }
}
