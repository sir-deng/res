package com.tencent.mm.plugin.mmsight.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.lr;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e implements SensorEventListener {
    private static int oxA = Integer.MAX_VALUE;
    static boolean oyc = true;
    private SensorManager bgR;
    public Camera gGm = null;
    private Context mContext = null;
    com.tencent.mm.compatible.e.d.a.a oxB;
    private Sensor oxC;
    private float oxD = 0.0f;
    private float oxE = 0.0f;
    private float oxF = 0.0f;
    private Point oxG = null;
    public Point oxH = null;
    private Point oxI = null;
    private int oxJ = 0;
    private byte[] oxK;
    private boolean oxL = false;
    private com.tencent.mm.plugin.base.model.a oxM = new com.tencent.mm.plugin.base.model.a();
    public boolean oxN = false;
    private List<f> oxO = new ArrayList();
    private boolean oxP = false;
    private a oxQ = a.Preview;
    private b oxR = new b("prevcameraCallback");
    private b oxS = new b("cameraCallback");
    private b oxT = new b("cameraPreviewCallback");
    private b oxU = new b("cameraCropCallback");
    private b oxV = new b("mirrorCameraCallback");
    private b oxW = new b("finishCallbackTimeCallback");
    private VideoTransPara oxX;
    public volatile byte[] oxY = null;
    public volatile boolean oxZ = false;
    private int oxt = -1;
    public int oxu = -1;
    private p oxv = p.baU();
    private boolean oxw = false;
    private boolean oxx = false;
    public boolean oxy = false;
    private int oxz = 0;
    public boolean oya = false;
    private boolean oyb = false;
    AutoFocusCallback oyd = new AutoFocusCallback() {
        public final void onAutoFocus(boolean z, Camera camera) {
            x.v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", Boolean.valueOf(z), e.this.oxQ);
            e.oyc = true;
        }
    };
    public c oye = new c(Looper.getMainLooper());
    public boolean oyf = true;
    private int scene = 0;

    public enum a {
        Preview,
        Recording,
        Stoping
    }

    private class c extends ag {
        public float nOR;
        boolean oxw = false;
        int oyl = 0;
        boolean oym = false;
        boolean oyn = false;
        public float oyo;
        public int oyp;
        public int oyq;

        private static Rect a(float f, float f2, float f3, int i, int i2) {
            float f4 = 80.0f * f3;
            float f5 = (((f / ((float) i)) * 2000.0f) - 1000.0f) - (f4 / 2.0f);
            float f6 = (((f2 / ((float) i2)) * 2000.0f) - 1000.0f) - (f4 / 2.0f);
            float f7 = f5 + f4;
            f4 += f6;
            RectF rectF = new RectF();
            rectF.set(f5, f6, f7, f4);
            return new Rect(te(Math.round(rectF.left)), te(Math.round(rectF.top)), te(Math.round(rectF.right)), te(Math.round(rectF.bottom)));
        }

        private static int te(int i) {
            if (i > 1000) {
                return 1000;
            }
            return i < DownloadResult.CODE_UNDEFINED ? DownloadResult.CODE_UNDEFINED : i;
        }

        final void e(Camera camera) {
            if (camera == null) {
                x.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
            } else if (e.oyc) {
                e.oyc = false;
                try {
                    x.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
                    camera.cancelAutoFocus();
                    camera.autoFocus(e.this.oyd);
                } catch (Exception e) {
                    x.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", e.getMessage());
                    e.oyc = true;
                }
            } else {
                x.w("MicroMsg.MMSightCamera", "auto focus not back");
            }
        }

        public c(Looper looper) {
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
                x.e("MicroMsg.MMSightCamera", "get target zoom value error: %s", e.getMessage());
                maxZoom = 0;
            }
            return maxZoom;
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            Camera camera;
            int zoom;
            switch (message.what) {
                case 4353:
                    if (!this.oyn) {
                        int b;
                        camera = (Camera) message.obj;
                        Parameters parameters = camera.getParameters();
                        x.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", Boolean.valueOf(this.oxw), Integer.valueOf(this.oyl), Integer.valueOf(parameters.getZoom()));
                        zoom = parameters.getZoom() + this.oyl;
                        if (this.oxw) {
                            b = b(parameters);
                            if (zoom < b) {
                                sendMessageDelayed(obtainMessage(4353, message.obj), this.oym ? 10 : 20);
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
                        } catch (Exception e) {
                        }
                        if (z) {
                            this.oyp = 0;
                            this.oyq = 0;
                            return;
                        }
                        return;
                    }
                    return;
                case 4354:
                    camera = (Camera) message.obj;
                    if (this.oyp == 0 || this.oyq == 0 || d.fO(14)) {
                        e(camera);
                        return;
                    }
                    float f = this.oyo;
                    float f2 = this.nOR;
                    zoom = this.oyp;
                    int i = this.oyq;
                    if (camera == null) {
                        x.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
                        return;
                    } else if (e.oyc) {
                        e.oyc = false;
                        try {
                            camera.cancelAutoFocus();
                            x.i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(zoom), Integer.valueOf(i));
                            x.i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", a(f, f2, 1.0f, zoom, i), a(f, f2, 1.5f, zoom, i));
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
                            camera.autoFocus(e.this.oyd);
                            return;
                        } catch (Exception e2) {
                            x.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", e2.getMessage());
                            e.oyc = true;
                            return;
                        }
                    } else {
                        x.w("MicroMsg.MMSightCamera", "auto focus not back");
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public interface b {
        void a(byte[] bArr, int i, int i2, int i3, int i4);
    }

    public final void a(com.tencent.mm.plugin.mmsight.model.e.b r8, boolean r9, int r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r4 = 1;
        r6 = 0;
        r0 = "MicroMsg.MMSightCamera";
        r1 = "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s";
        r2 = 4;
        r2 = new java.lang.Object[r2];
        r2[r6] = r8;
        r3 = r7.oxY;
        r2[r4] = r3;
        r3 = 2;
        r4 = java.lang.Boolean.valueOf(r9);
        r2[r3] = r4;
        r3 = 3;
        r4 = java.lang.Integer.valueOf(r10);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r7.oxY;
        if (r0 == 0) goto L_0x0064;
    L_0x0026:
        r0 = 1;
        r7.oxZ = r0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0 = new android.graphics.Point;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.<init>();	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r7.oxI;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        if (r1 == 0) goto L_0x0065;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
    L_0x0032:
        r1 = r7.oxI;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r1.x;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.x = r1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r7.oxI;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r1.y;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.y = r1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
    L_0x003e:
        r1 = com.tencent.mm.plugin.mmsight.model.a.j.oAr;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = r7.oxY;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = r2.length;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r1.h(r2);	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = r7.oxY;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r3 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r4 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r5 = r7.oxY;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r5 = r5.length;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        java.lang.System.arraycopy(r2, r3, r1, r4, r5);	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = r7.oxB;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r4 = r2.fGt;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = r0.x;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r3 = r0.y;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0 = r8;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r5 = r10;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.a(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r7.oxZ = r6;
    L_0x0064:
        return;
    L_0x0065:
        r1 = r7.oxK;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        if (r1 == 0) goto L_0x009d;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
    L_0x0069:
        r1 = r7.oxL;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        if (r1 == 0) goto L_0x009d;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
    L_0x006d:
        r1 = r7.oxH;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r1.x;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.x = r1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r7.oxH;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r1.y;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.y = r1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        goto L_0x003e;
    L_0x007a:
        r0 = move-exception;
        r1 = "MicroMsg.MMSightCamera";	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = "takePicture error: %s";	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r3 = 1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r4 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r3[r4] = r0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r7.oxZ = r0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r2 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r3 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r4 = -1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r5 = 0;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0 = r8;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.a(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r7.oxZ = r6;
        goto L_0x0064;
    L_0x009d:
        r1 = r7.oxv;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r1.mqM;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.x = r1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r7.oxv;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r1 = r1.mqN;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        r0.y = r1;	 Catch:{ Exception -> 0x007a, all -> 0x00aa }
        goto L_0x003e;
    L_0x00aa:
        r0 = move-exception;
        r7.oxZ = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.model.e.a(com.tencent.mm.plugin.mmsight.model.e$b, boolean, int):void");
    }

    static /* synthetic */ boolean a(e eVar, byte[] bArr) {
        boolean z = false;
        bi.Wz();
        if (eVar.oxO == null || eVar.oxO.size() == 0) {
            return false;
        }
        Iterator it = eVar.oxO.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = ((f) it.next()).R(bArr) | z2;
        }
    }

    public e(VideoTransPara videoTransPara, int i) {
        this.oxX = videoTransPara;
        this.scene = i;
    }

    public final void a(f fVar) {
        if (fVar != null) {
            this.oxO.add(fVar);
        }
    }

    public final void b(f fVar) {
        if (fVar != null) {
            this.oxO.remove(fVar);
        }
    }

    public final void a(a aVar) {
        this.oxQ = aVar;
        if (aVar == a.Stoping) {
            a baz = a.baz();
            String baB = this.oxS.baB();
            String baB2 = this.oxR.baB();
            com.tencent.mm.plugin.base.model.a aVar2 = this.oxM;
            int i = aVar2.kAm == 0 ? 0 : aVar2.kAl / aVar2.kAm;
            baz.owY = (int) (bi.Wq(baB) * 10.0d);
            baz.owZ = (int) (bi.Wq(baB2) * 10.0d);
            baz.oxf = i;
        }
    }

    public final void baD() {
        if (!(this.bgR == null || this.oxC == null)) {
            this.bgR.unregisterListener(this);
        }
        x.i("MicroMsg.MMSightCamera", this.oxR.getValue());
        x.i("MicroMsg.MMSightCamera", this.oxS.getValue());
        x.i("MicroMsg.MMSightCamera", this.oxT.getValue());
        x.i("MicroMsg.MMSightCamera", this.oxU.getValue());
        x.i("MicroMsg.MMSightCamera", this.oxV.getValue());
        x.i("MicroMsg.MMSightCamera", this.oxW.getValue());
        if (this.gGm != null) {
            long Wz = bi.Wz();
            x.i("MicroMsg.MMSightCamera", "release camera beg, %s", Looper.myLooper());
            this.oye.removeCallbacksAndMessages(null);
            this.oye.oyn = true;
            this.gGm.setPreviewCallback(null);
            this.gGm.stopPreview();
            this.gGm.release();
            this.gGm = null;
            this.oxy = false;
            x.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", Long.valueOf(bi.bB(Wz)), Looper.myLooper());
        }
        this.oxw = false;
        this.oxD = 0.0f;
        this.oxE = 0.0f;
        this.oxF = 0.0f;
        oyc = true;
        this.mContext = null;
        this.oyb = false;
        this.oxH = null;
        this.oxI = null;
        this.oxY = null;
        this.oxP = false;
    }

    private boolean a(Camera camera, boolean z) {
        if (camera == null) {
            return false;
        }
        try {
            a baz;
            boolean z2;
            int i;
            Parameters parameters = camera.getParameters();
            Point dc = com.tencent.mm.plugin.mmsight.d.dc(this.mContext);
            List supportedPreviewSizes;
            List supportedPictureSizes;
            int i2;
            if (this.oyf) {
                baz = a.baz();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                supportedPictureSizes = parameters.getSupportedPictureSizes();
                i2 = this.oxB.fGt;
                if (bi.oN(baz.owO)) {
                    baz.owO = com.tencent.mm.plugin.mmsight.d.bi(supportedPreviewSizes);
                }
                if (bi.oN(baz.owP)) {
                    baz.owP = com.tencent.mm.plugin.mmsight.d.bi(supportedPictureSizes);
                }
                baz.fGt = i2;
                baz.oxk = 1;
            } else {
                baz = a.baz();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                supportedPictureSizes = parameters.getSupportedPictureSizes();
                i2 = this.oxB.fGt;
                if (bi.oN(baz.owQ)) {
                    baz.owQ = com.tencent.mm.plugin.mmsight.d.bi(supportedPreviewSizes);
                }
                if (bi.oN(baz.owR)) {
                    baz.owR = com.tencent.mm.plugin.mmsight.d.bi(supportedPictureSizes);
                }
                baz.fGt = i2;
                baz.oxk = 2;
            }
            if (z) {
                z2 = this.oxB.fGt == 90 || this.oxB.fGt == 270;
                j.a(parameters, z2);
            }
            k.bbq();
            int bbs = k.bbs();
            z2 = this.oxB.fGt == 90 || this.oxB.fGt == 270;
            com.tencent.mm.plugin.mmsight.model.g.b b = g.b(parameters, dc, bbs, z2);
            j.a(b);
            Point point = b.oyr;
            if (point == null) {
                g.pWK.a(440, 140, 0, false);
            }
            if (point != null) {
                this.oxv.mqM = point.x;
                this.oxv.mqN = point.y;
                this.oxH = point;
            }
            Context context = this.mContext;
            z2 = this.oxB.fGt == 90 || this.oxB.fGt == 270;
            boolean a = com.tencent.mm.plugin.mmsight.d.a(context, point, z2);
            x.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", Boolean.valueOf(a));
            if (a) {
                if (j.oyD.gHU == 2) {
                    this.oxI = b.oyt;
                } else {
                    this.oxI = b.oys;
                }
                this.oxH = new Point(this.oxI.x, this.oxI.y);
                this.oxJ = ((this.oxI.x * this.oxI.y) * 3) / 2;
                x.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", this.oxI);
            }
            if (j.oyD.oyO) {
                Object obj = 1;
                if (this.oxB.fGt == 90 || this.oxB.fGt == 270) {
                    if (point.y < this.oxX.width || point.x < this.oxX.height) {
                        obj = null;
                        x.w("MicroMsg.MMSightCamera", "previewSize %s not support", point);
                    }
                    if (obj != null) {
                        if (j.oyD.oxc == 1080) {
                            this.oxH = new Point(com.tencent.mm.plugin.mmsight.d.cQ(this.oxI == null ? point.x / 2 : this.oxI.x / 2, this.oxI == null ? point.x : this.oxI.x), com.tencent.mm.plugin.mmsight.d.cQ(this.oxI == null ? point.y / 2 : this.oxI.y / 2, this.oxI == null ? point.y : this.oxI.y));
                        } else if (j.oyD.oxc == 720) {
                            this.oxH = new Point(com.tencent.mm.plugin.mmsight.d.cQ((int) (this.oxI == null ? ((float) point.x) * 0.75f : ((float) this.oxI.x) * 0.75f), this.oxI == null ? point.x : this.oxI.x), com.tencent.mm.plugin.mmsight.d.cQ((int) (this.oxI == null ? ((float) point.y) * 0.75f : ((float) this.oxI.y) * 0.75f), this.oxI == null ? point.y : this.oxI.y));
                        }
                    }
                } else {
                    if (point.x < this.oxX.width || point.y < this.oxX.height) {
                        obj = null;
                        x.w("MicroMsg.MMSightCamera", "previewSize %s not support", point);
                    }
                    if (obj != null) {
                        if (j.oyD.oxc == 1080) {
                            this.oxH = new Point(com.tencent.mm.plugin.mmsight.d.cQ(this.oxI == null ? point.y / 2 : this.oxI.y / 2, this.oxI == null ? point.y : this.oxI.y), com.tencent.mm.plugin.mmsight.d.cQ(this.oxI == null ? point.x / 2 : this.oxI.x / 2, this.oxI == null ? point.x : this.oxI.x));
                        } else if (j.oyD.oxc == 720) {
                            bbs = (int) (this.oxI == null ? ((float) point.x) * 0.75f : ((float) this.oxI.x) * 0.75f);
                            int cQ = com.tencent.mm.plugin.mmsight.d.cQ((int) (this.oxI == null ? ((float) point.y) * 0.75f : ((float) this.oxI.y) * 0.75f), this.oxI == null ? point.y : this.oxI.y);
                            if (this.oxI == null) {
                                i = point.x;
                            } else {
                                i = this.oxI.x;
                            }
                            this.oxH = new Point(cQ, com.tencent.mm.plugin.mmsight.d.cQ(bbs, i));
                        }
                    }
                }
            }
            baz = a.baz();
            dc = this.oxI;
            Point point2 = this.oxH;
            baz.owX = -1;
            baz.owW = -1;
            baz.owT = -1;
            baz.owS = -1;
            baz.owV = -1;
            baz.owU = -1;
            if (point != null) {
                baz.owU = point.x;
                baz.owV = point.y;
            }
            if (dc != null) {
                baz.owS = dc.x;
                baz.owT = dc.y;
            }
            if (point2 != null) {
                baz.owW = point2.x;
                baz.owX = point2.y;
            }
            if (z) {
                if (a || j.oyD.gHU != 2 || com.tencent.mm.plugin.mmsight.d.ta(this.oxH.y)) {
                    j.d(this.oxH);
                } else {
                    i = com.tencent.mm.plugin.mmsight.d.tb(this.oxH.y);
                    if (Math.abs(i - this.oxH.y) <= 16) {
                        x.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", this.oxH, Integer.valueOf(i));
                        this.oxG = new Point(this.oxH.x, this.oxH.y);
                        this.oxH.y = i;
                        this.oxL = true;
                        this.oxK = new byte[(((this.oxH.x * this.oxH.y) * 3) / 2)];
                    } else {
                        j.d(this.oxH);
                    }
                }
            } else if (!a && j.oyD.gHU == 2 && !com.tencent.mm.plugin.mmsight.d.ta(this.oxH.y) && this.oxL && this.oxK != null && this.oxG.y == this.oxH.y) {
                i = com.tencent.mm.plugin.mmsight.d.tb(this.oxH.y);
                if (this.oxK.length == ((this.oxH.x * i) * 3) / 2) {
                    this.oxH.y = i;
                }
            }
            x.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", point, this.oxH, this.oxI);
            parameters.setPreviewSize(this.oxv.mqM, this.oxv.mqN);
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            x.i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", Looper.myLooper(), e.getMessage());
            return false;
        }
    }

    private boolean a(Camera camera, int i, float f, boolean z) {
        if (camera == null || i <= 0) {
            return false;
        }
        try {
            int i2;
            Parameters parameters = camera.getParameters();
            Point point = new Point(i, (int) (((float) i) / f));
            Point fA = ae.fA(ad.getContext());
            float min = ((float) Math.min(fA.x, fA.y)) / ((float) Math.max(fA.x, fA.y));
            float f2 = 1.0f / f;
            if (f < 1.0f) {
                i2 = i;
            } else {
                i2 = Math.round(((float) i) / f2);
            }
            x.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(min));
            boolean z2 = this.oxB.fGt == 90 || this.oxB.fGt == 270;
            com.tencent.mm.plugin.mmsight.model.g.b a = g.a(parameters, fA, i2, z2);
            if (a == null || a.oyr == null) {
                x.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
                z2 = this.oxB.fGt == 90 || this.oxB.fGt == 270;
                a = g.c(parameters, fA, i, z2);
                this.oya = false;
            }
            if (!(a == null || a.oyr == null)) {
                x.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio result preview size: %s, cropHeight: %s", a.oyr, Integer.valueOf((int) (((float) a.oyr.x) * f)));
                if (((int) (((float) a.oyr.x) * f)) <= a.oyr.y) {
                    this.oya = false;
                } else {
                    this.oya = true;
                }
            }
            if (!(a == null || a.oyr == null)) {
                point = a.oyr;
                this.oxv.mqM = point.x;
                this.oxv.mqN = point.y;
                this.oxH = point;
                this.oxI = null;
                if (!z) {
                    if (j.oyD.gHU != 2 || com.tencent.mm.plugin.mmsight.d.ta(this.oxH.y)) {
                        j.d(this.oxH);
                    } else {
                        i2 = com.tencent.mm.plugin.mmsight.d.tb(this.oxH.y);
                        if (Math.abs(i2 - this.oxH.y) <= 16) {
                            x.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", this.oxH, Integer.valueOf(i2));
                            this.oxG = new Point(this.oxH.x, this.oxH.y);
                            this.oxH.y = i2;
                            this.oxL = true;
                            this.oxK = new byte[(((this.oxH.x * this.oxH.y) * 3) / 2)];
                        } else {
                            j.d(this.oxH);
                        }
                    }
                }
                x.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s, cropWidth: %s", point, this.oxH, this.oxI, Boolean.valueOf(this.oya));
                parameters.setPreviewSize(this.oxv.mqM, this.oxv.mqN);
                camera.setParameters(parameters);
                return true;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimit error: %s", e.getMessage());
        }
        return false;
    }

    @TargetApi(14)
    private static boolean a(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            x.i("MicroMsg.MMSightCameraSetting", "safeSetMetering");
            Parameters parameters = camera.getParameters();
            if (parameters.getMaxNumMeteringAreas() > 0) {
                List arrayList = new ArrayList();
                arrayList.add(new Area(new Rect(DownloadResult.CODE_UNDEFINED, DownloadResult.CODE_UNDEFINED, 1000, 1000), 600));
                parameters.setMeteringAreas(arrayList);
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            x.i("MicroMsg.MMSightCameraSetting", "safeSetMetering Exception, %s, %s", Looper.myLooper(), e.getMessage());
            return false;
        }
    }

    private static boolean b(Camera camera, boolean z) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            int i;
            if (z) {
                if (q.gHF.gFR > 0) {
                    x.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview frame rate");
                } else if (parameters == null) {
                    x.e("MicroMsg.MMSightCamera", "trySetPreviewFrameRateParameters error, p is null!");
                } else {
                    try {
                        Collection supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
                        if (supportedPreviewFrameRates != null && supportedPreviewFrameRates.size() > 0) {
                            parameters.setPreviewFrameRate(Math.min(30, ((Integer) Collections.max(supportedPreviewFrameRates)).intValue()));
                            x.i("MicroMsg.MMSightCameraSetting", "set preview frame rate %d", Integer.valueOf(i));
                        }
                    } catch (Exception e) {
                        x.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFrameRateParameters Exception, %s, %s", Looper.myLooper(), e.getMessage());
                    }
                }
            } else if (q.gHF.gFR > 0) {
                x.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview fps range");
            } else {
                List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                if (!(supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0)) {
                    int i2 = Integer.MIN_VALUE;
                    int i3 = Integer.MIN_VALUE;
                    Object obj = null;
                    int size = supportedPreviewFpsRange.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj2;
                        int i5;
                        int[] iArr = (int[]) supportedPreviewFpsRange.get(i4);
                        if (iArr != null && iArr.length > 1) {
                            int i6 = iArr[0];
                            i = iArr[1];
                            x.i("MicroMsg.MMSightCamera", "dkfps %d:[%d %d]", Integer.valueOf(i4), Integer.valueOf(i6), Integer.valueOf(i));
                            if (i6 >= 0 && i >= i6) {
                                if (i >= i3 && obj == null) {
                                    i3 = i;
                                    i2 = i6;
                                }
                                if (i >= 30000) {
                                    obj2 = 1;
                                    i5 = i3;
                                    i4++;
                                    i2 = i2;
                                    i3 = i5;
                                    obj = obj2;
                                }
                            }
                        }
                        obj2 = obj;
                        i5 = i3;
                        i4++;
                        i2 = i2;
                        i3 = i5;
                        obj = obj2;
                    }
                    x.i("MicroMsg.MMSightCameraSetting", "dkfps get fit  [%d %d], max target fps %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(30));
                    if (!(i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE)) {
                        try {
                            parameters.setPreviewFpsRange(i2, i3);
                            x.i("MicroMsg.MMSightCameraSetting", "set fps range %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
                        } catch (Exception e2) {
                            x.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFpsRangeParameters Exception, %s, %s", Looper.myLooper(), e2.getMessage());
                        }
                    }
                }
            }
            List supportedPreviewFrameRates2 = parameters.getSupportedPreviewFrameRates();
            x.i("MicroMsg.MMSightCameraSetting", "use fix mode %B, supported preview frame rates %s", Boolean.valueOf(z), supportedPreviewFrameRates2);
            camera.setParameters(parameters);
            return true;
        } catch (Exception e22) {
            x.i("MicroMsg.MMSightCameraSetting", "setPreviewFrameRate Exception, %s, %s", Looper.myLooper(), e22.getMessage());
            return false;
        }
    }

    private static boolean b(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            x.i("MicroMsg.MMSightCameraSetting", "safeSetPreviewFormat");
            Parameters parameters = camera.getParameters();
            List supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            if (supportedPreviewFormats == null || !supportedPreviewFormats.contains(Integer.valueOf(17))) {
                x.e("MicroMsg.MMSightCameraSetting", "not support YCbCr_420_SP");
            }
            parameters.setPreviewFormat(17);
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            x.i("MicroMsg.MMSightCameraSetting", "setPreviewFormat Exception, %s, %s", Looper.myLooper(), e.getMessage());
            return false;
        }
    }

    private static boolean c(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            List supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                x.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
                parameters.setFocusMode("continuous-picture");
            } else if (supportedFocusModes == null || !supportedFocusModes.contains("continuous-video")) {
                if (supportedFocusModes != null) {
                    if (supportedFocusModes.contains("auto")) {
                        x.i("MicroMsg.MMSightCameraSetting", "support auto focus");
                        parameters.setFocusMode("auto");
                    }
                }
                x.i("MicroMsg.MMSightCameraSetting", "not support continuous video or auto focus");
            } else {
                x.i("MicroMsg.MMSightCameraSetting", "support continuous video");
                parameters.setFocusMode("continuous-video");
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            x.i("MicroMsg.MMSightCameraSetting", "setFocusMode Exception, %s, %s", Looper.myLooper(), e.getMessage());
            return false;
        }
    }

    public final void baE() {
        x.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode");
        if (this.gGm != null && this.oxy) {
            try {
                Parameters parameters = this.gGm.getParameters();
                List supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                    x.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
                    parameters.setFocusMode("continuous-picture");
                }
                this.gGm.setParameters(parameters);
            } catch (Exception e) {
                x.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode error: %s", e.getMessage());
            }
        }
    }

    private void baF() {
        if (this.gGm != null) {
            try {
                Parameters parameters = this.gGm.getParameters();
                x.i("MicroMsg.MMSightCamera", "setPreviewCallbackImpl");
                int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * (this.oxv.mqM * this.oxv.mqN)) / 8;
                for (int i = 0; i < 5; i++) {
                    this.gGm.addCallbackBuffer(j.oAr.h(Integer.valueOf(bitsPerPixel)));
                }
                this.oxR.reset();
                this.oxS.reset();
                this.oxT.reset();
                this.oxU.reset();
                this.oxV.reset();
                this.oxW.reset();
                this.oxM = new com.tencent.mm.plugin.base.model.a();
                this.gGm.setPreviewCallbackWithBuffer(new PreviewCallback() {
                    public final void onPreviewFrame(byte[] bArr, Camera camera) {
                        boolean z = false;
                        if (!e.this.oxP) {
                            x.i("MicroMsg.MMSightCamera", "onPreviewFrame: %s %s", bArr, e.this.gGm);
                            e.this.oxP = true;
                        }
                        if (bArr == null || bArr.length <= 0) {
                            x.e("MicroMsg.MMSightCamera", "onPreviewFrame, frame data is null!!");
                            e.this.baG();
                            return;
                        }
                        byte[] bArr2;
                        com.tencent.mm.plugin.base.model.a e = e.this.oxM;
                        if (e.kAn == 0) {
                            e.kAm++;
                            e.kAl = bi.Wo(m.yz());
                        }
                        e.kAn++;
                        e.kAn = e.kAn >= 90 ? 0 : e.kAn;
                        long Wz;
                        int i;
                        if (e.this.oxZ || e.this.oxO == null || e.this.oxO.size() <= 0) {
                            bArr2 = bArr;
                        } else if (e.this.oxI != null) {
                            byte[] h = j.oAr.h(Integer.valueOf(((e.this.oxI.x * e.this.oxI.y) * 3) / 2));
                            e.this.oxT.dO(1);
                            Wz = bi.Wz();
                            SightVideoJNI.cropCameraData(bArr, h, e.this.oxv.mqM, e.this.oxv.mqN, e.this.oxI.y);
                            e.this.oxU.dO(bi.bB(Wz));
                            if (!e.this.oyf) {
                                Wz = bi.Wz();
                                i = e.this.oxI.x;
                                int i2 = e.this.oxI.y;
                                if (e.this.oxB.fGt == 270 || e.this.oxB.fGt == 90) {
                                    z = true;
                                }
                                SightVideoJNI.mirrorCameraData(h, i, i2, z);
                                e.this.oxV.dO(bi.bB(Wz));
                            }
                            long j = Wz;
                            boolean a = e.a(e.this, h);
                            j = bi.bB(j);
                            if (a) {
                                e.this.oxW.dO(j);
                            }
                            bArr2 = h;
                        } else {
                            Wz = bi.Wz();
                            if (!e.this.oyf) {
                                i = e.this.oxv.mqM;
                                int i3 = e.this.oxv.mqN;
                                if (e.this.oxB.fGt == 270 || e.this.oxB.fGt == 90) {
                                    z = true;
                                }
                                SightVideoJNI.mirrorCameraData(bArr, i, i3, z);
                                e.this.oxV.dO(bi.bB(Wz));
                            }
                            if (!e.this.oxL || e.this.oxK == null) {
                                bArr2 = bArr;
                            } else {
                                SightVideoJNI.paddingYuvData16(bArr, e.this.oxK, e.this.oxH.x, e.this.oxG.y, e.this.oxH.y);
                                bArr2 = e.this.oxK;
                            }
                            z = e.a(e.this, bArr2);
                            long bB = bi.bB(Wz);
                            if (z) {
                                e.this.oxW.dO(bB);
                            }
                            if ((!e.this.oxL || e.this.oxK == null) && z) {
                                bArr = j.oAr.h(Integer.valueOf(bArr.length));
                            }
                            if (e.this.oxL && e.this.oxK != null) {
                                byte[] h2;
                                e eVar = e.this;
                                if (z) {
                                    h2 = j.oAr.h(Integer.valueOf(e.this.oxK.length));
                                } else {
                                    h2 = e.this.oxK;
                                }
                                eVar.oxK = h2;
                            }
                        }
                        e.this.oxY = bArr2;
                        if (e.this.oxQ == a.Preview) {
                            e.this.oxS.dO(1);
                        } else if (e.this.oxQ == a.Recording) {
                            e.this.oxR.dO(1);
                        }
                        e.this.gGm.addCallbackBuffer(bArr);
                    }
                });
            } catch (Exception e) {
                x.e("MicroMsg.MMSightCamera", "setPreviewCallbackImpl error: %s", e.getMessage());
            }
        }
    }

    @TargetApi(11)
    public final int a(SurfaceTexture surfaceTexture, boolean z) {
        long Wz = bi.Wz();
        this.oxP = false;
        x.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", Boolean.valueOf(this.oxy), Looper.myLooper(), surfaceTexture, Boolean.valueOf(z));
        if (this.oxy) {
            return 0;
        }
        if (surfaceTexture == null) {
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
        x.i("MicroMsg.MMSightCamera", "this texture %s", surfaceTexture);
        try {
            Integer valueOf;
            boolean z2;
            a(this.gGm, z);
            Integer valueOf2 = Integer.valueOf(0);
            if (k.bbq().oAt != null) {
                valueOf = Integer.valueOf(k.bbq().oAt.owx);
            } else {
                valueOf = valueOf2;
            }
            String str = "MicroMsg.MMSightCamera";
            String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]";
            Object[] objArr = new Object[6];
            objArr[0] = valueOf;
            String str3 = q.gHF.gFW == 1 ? "Range" : q.gHF.gFV == 1 ? "Fix" : "Error";
            objArr[1] = str3;
            objArr[2] = Boolean.valueOf(q.gHF.gFX == 1);
            if (q.gHF.gFY == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[3] = Boolean.valueOf(z2);
            if (q.gHF.gFZ == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[4] = Boolean.valueOf(z2);
            if (q.gHF.gGa == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[5] = Boolean.valueOf(z2);
            x.i(str, str2, objArr);
            if (q.gHF.gFW == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 1)) {
                b(this.gGm, false);
            } else if (q.gHF.gFV == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 5)) {
                b(this.gGm, true);
            }
            if (q.gHF.gFX == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 2)) {
                b(this.gGm);
            }
            if (q.gHM.gIc != -1 && q.gHM.gIc == 1 && d.fP(14)) {
                a(this.gGm);
            }
            if (q.gHF.gFZ == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 4)) {
                c(this.gGm);
            }
            if (q.gHF.gGa == 1 && valueOf.intValue() != 0) {
                valueOf.intValue();
            }
            d(this.gGm);
            baF();
            this.gGm.setPreviewTexture(surfaceTexture);
            this.gGm.startPreview();
            if (!j.oyD.oyP) {
                this.bgR.registerListener(this, this.oxC, 2);
            } else if (!(q.gHF.gFZ != 0 || this.bgR == null || this.oxC == null)) {
                this.bgR.registerListener(this, this.oxC, 2);
            }
            this.oxy = true;
            x.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", Long.valueOf(bi.bB(Wz)), Looper.myLooper());
            return 0;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", Looper.myLooper(), e.getMessage());
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    public final int a(SurfaceTexture surfaceTexture, int i, float f, boolean z) {
        long Wz = bi.Wz();
        this.oxP = false;
        x.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s", Boolean.valueOf(this.oxy), Looper.myLooper(), surfaceTexture);
        if (this.oxy) {
            return 0;
        }
        if (surfaceTexture == null) {
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
        x.i("MicroMsg.MMSightCamera", "this texture %s", surfaceTexture);
        try {
            Integer valueOf;
            a(this.gGm, i, f, z);
            Integer valueOf2 = Integer.valueOf(0);
            if (k.bbq().oAt != null) {
                valueOf = Integer.valueOf(k.bbq().oAt.owx);
            } else {
                valueOf = valueOf2;
            }
            String str = "MicroMsg.MMSightCamera";
            String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]";
            Object[] objArr = new Object[6];
            objArr[0] = valueOf;
            String str3 = q.gHF.gFW == 1 ? "Range" : q.gHF.gFV == 1 ? "Fix" : "Error";
            objArr[1] = str3;
            objArr[2] = Boolean.valueOf(q.gHF.gFX == 1);
            objArr[3] = Boolean.valueOf(q.gHF.gFY == 1);
            objArr[4] = Boolean.valueOf(q.gHF.gFZ == 1);
            objArr[5] = Boolean.valueOf(q.gHF.gGa == 1);
            x.i(str, str2, objArr);
            if (q.gHF.gFW == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 1)) {
                b(this.gGm, false);
            } else if (q.gHF.gFV == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 5)) {
                b(this.gGm, true);
            }
            if (q.gHF.gFX == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 2)) {
                b(this.gGm);
            }
            if (q.gHM.gIc != -1 && q.gHM.gIc == 1 && d.fP(14)) {
                a(this.gGm);
            }
            if (q.gHF.gFZ == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 4)) {
                c(this.gGm);
            }
            if (q.gHF.gGa == 1 && valueOf.intValue() != 0) {
                valueOf.intValue();
            }
            d(this.gGm);
            baF();
            this.gGm.setPreviewTexture(surfaceTexture);
            this.gGm.startPreview();
            if (!j.oyD.oyP) {
                this.bgR.registerListener(this, this.oxC, 2);
            } else if (!(q.gHF.gFZ != 0 || this.bgR == null || this.oxC == null)) {
                this.bgR.registerListener(this, this.oxC, 2);
            }
            this.oxy = true;
            x.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", Long.valueOf(bi.bB(Wz)), Looper.myLooper());
            return 0;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", Looper.myLooper(), e.getMessage());
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    private static void d(Camera camera) {
        try {
            Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported()) {
                parameters.setZoom(0);
            }
            camera.setParameters(parameters);
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "safeResetZoom error: %s", e.getMessage());
        }
    }

    private void baG() {
        if (true != this.oyb && this.mContext != null) {
            if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || com.tencent.mm.compatible.f.b.zh()) {
                com.tencent.mm.sdk.b.b lrVar = new lr();
                lrVar.fDX.type = 2;
                com.tencent.mm.sdk.b.a.xmy.m(lrVar);
                if (lrVar.fDY.fDW) {
                    this.oyb = true;
                    return;
                }
                i h = h.h(this.mContext, com.tencent.mm.plugin.t.a.a.oJP, com.tencent.mm.plugin.t.a.a.dGZ);
                if (h != null) {
                    h.setCancelable(false);
                    h.setCanceledOnTouchOutside(false);
                    h.show();
                    this.oyb = true;
                }
            }
        }
    }

    public final String baH() {
        if (this.gGm == null) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList a = com.tencent.mm.plugin.mmsight.d.a(this.gGm.getParameters());
            Point dc = com.tencent.mm.plugin.mmsight.d.dc(this.mContext);
            stringBuffer.append(String.format("Screen size %d %d r:%.4f\n", new Object[]{Integer.valueOf(dc.x), Integer.valueOf(dc.y), Double.valueOf((((double) dc.x) * 1.0d) / ((double) dc.y))}));
            Iterator it = a.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                if ((aHt() == size.width && aHu() == size.height) || (aHt() == size.height && aHu() == size.width)) {
                    stringBuffer.append(String.format("%s*%s √ r:%.4f\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height), Double.valueOf((((double) size.height) * 1.0d) / ((double) size.width))}));
                } else {
                    stringBuffer.append(String.format("%s*%s X r:%.4f\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height), Double.valueOf((((double) size.height) * 1.0d) / ((double) size.width))}));
                }
            }
            if (this.oxI != null) {
                stringBuffer.append("\nSIGHTCROPMODE:  " + this.oxI.x + " " + this.oxI.y + " from " + this.oxv.mqM + " " + this.oxv.mqN);
            } else {
                stringBuffer.append("\nFinalPreviewSize: " + aHt() + " " + aHu());
            }
            stringBuffer.append("\ngetOrientation:" + getOrientation());
            stringBuffer.append("\nrecorderOption: " + q.gHM.gIb);
            return stringBuffer.toString();
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "getDebugInfo error: %s", e.getMessage());
            return null;
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if (Math.abs(this.oxD - f) > 5.0f || Math.abs(this.oxE - f2) > 5.0f || Math.abs(this.oxF - f3) > 5.0f) {
            x.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", Float.valueOf(5.0f), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
            this.oye.e(this.gGm);
            this.oxD = f;
            this.oxE = f2;
            this.oxF = f3;
        }
    }

    public final void b(boolean z, boolean z2, int i) {
        if (this.gGm != null && this.oxy) {
            try {
                x.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", Boolean.valueOf(z));
                if (this.oxx) {
                    x.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
                    return;
                }
                Parameters parameters = this.gGm.getParameters();
                if (parameters.isZoomSupported()) {
                    int i2;
                    this.oxx = true;
                    int zoom = parameters.getZoom();
                    int maxZoom = parameters.getMaxZoom();
                    if (!z2) {
                        if (this.oxt <= 0) {
                            this.oxt = Math.round(((float) maxZoom) / 15.0f);
                            if (this.oxt > 5) {
                                this.oxt = 5;
                            }
                        }
                        i2 = this.oxt;
                    } else if (this.oxu <= 0) {
                        x.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", Integer.valueOf(this.oxu));
                        this.oxx = false;
                        return;
                    } else {
                        i2 = this.oxu;
                    }
                    x.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", Integer.valueOf(zoom), Integer.valueOf(maxZoom), Integer.valueOf(this.oxt), Integer.valueOf(this.oxu), Integer.valueOf(i));
                    if (i > 0) {
                        i2 *= i;
                    }
                    if (z) {
                        if (zoom >= maxZoom) {
                            this.oxx = false;
                            return;
                        }
                        i2 += zoom;
                        if (i2 < maxZoom) {
                            maxZoom = i2;
                        }
                    } else if (zoom == 0) {
                        this.oxx = false;
                        return;
                    } else {
                        maxZoom = zoom - i2;
                        if (maxZoom <= 0) {
                            maxZoom = 0;
                        }
                    }
                    x.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", Integer.valueOf(maxZoom));
                    parameters.setZoom(maxZoom);
                    this.gGm.setParameters(parameters);
                }
                this.oxx = false;
            } catch (Exception e) {
                x.e("MicroMsg.MMSightCamera", "triggerSmallZoom error: %s", e.getMessage());
            } finally {
                this.oxx = false;
            }
        }
    }

    public final boolean i(Context context, boolean z) {
        if (!j.oyD.oyP || (q.gHF.gFZ == 0 && this.bgR == null && this.oxC == null)) {
            this.bgR = (SensorManager) context.getSystemService("sensor");
            this.oxC = this.bgR.getDefaultSensor(1);
        }
        if (this.gGm == null) {
            baD();
            this.oyf = z;
            if (z) {
                try {
                    this.oxz = com.tencent.mm.compatible.e.d.yr();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MMSightCamera", e, "try to get cameraid error %s, useBackCamera: %s", e.getMessage(), Boolean.valueOf(this.oyf));
                    this.oxz = 0;
                }
            } else {
                int numberOfCameras = Camera.getNumberOfCameras();
                CameraInfo cameraInfo = new CameraInfo();
                int i = 0;
                while (i < numberOfCameras) {
                    Camera.getCameraInfo(i, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        x.d("MicroMsg.CameraUtil", "tigercam get fid %d", Integer.valueOf(i));
                        break;
                    }
                    i++;
                }
                i = 0;
                x.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", Integer.valueOf(i));
                this.oxz = i;
            }
            x.i("MicroMsg.MMSightCamera", "use camera id %d, DeviceInfo id %d", Integer.valueOf(this.oxz), Integer.valueOf(q.gHF.gGc));
            this.oyb = false;
            this.mContext = context;
            this.oxB = new n().o(context, this.oxz);
            x.i("MicroMsg.MMSightCamera", "open camera end, %s", Looper.myLooper());
            if (this.oxB == null) {
                x.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", Looper.myLooper());
                baG();
                return false;
            }
            this.gGm = this.oxB.gGm;
            this.oye.oyn = false;
            this.oxv.fGt = this.oxB.fGt;
            if (this.gGm == null) {
                x.e("MicroMsg.MMSightCamera", "start camera FAILED!");
                baG();
                return false;
            }
        }
        return true;
    }

    public final boolean a(Context context, SurfaceTexture surfaceTexture, boolean z) {
        x.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", Boolean.valueOf(this.oyf));
        try {
            baD();
            i(context, !this.oyf);
            a(surfaceTexture, z);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "switchCamera error: %s", e);
            return false;
        }
    }

    public final boolean a(Context context, SurfaceTexture surfaceTexture, int i, float f, boolean z) {
        x.i("MicroMsg.MMSightCamera", "switch camera with limit, current useBack: %s", Boolean.valueOf(this.oyf));
        try {
            baD();
            i(context, !this.oyf);
            a(surfaceTexture, i, f, z);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "switchCamera error: %s", e);
            return false;
        }
    }

    public final void baI() {
        x.i("MicroMsg.MMSightCamera", "openFlash, camera: %s, isPreviewing: %s", this.gGm, Boolean.valueOf(this.oxy));
        if (this.gGm != null && this.oxy) {
            try {
                this.oxN = true;
                Parameters parameters = this.gGm.getParameters();
                if (bi.cC(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("torch")) {
                    x.i("MicroMsg.MMSightCamera", "camera not support flash!!");
                    return;
                }
                parameters.setFlashMode("torch");
                this.gGm.setParameters(parameters);
                x.i("MicroMsg.MMSightCamera", "open flash");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMSightCamera", e, "openFlash error: %s", e.getMessage());
            }
        }
    }

    public final void baJ() {
        x.i("MicroMsg.MMSightCamera", "closeFlash, camera: %s, isPreviewing: %s", this.gGm, Boolean.valueOf(this.oxy));
        if (this.gGm != null && this.oxy) {
            try {
                this.oxN = false;
                Parameters parameters = this.gGm.getParameters();
                if (bi.cC(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("off")) {
                    x.i("MicroMsg.MMSightCamera", "camera not support close flash!!");
                    return;
                }
                parameters.setFlashMode("off");
                this.gGm.setParameters(parameters);
                x.i("MicroMsg.MMSightCamera", "close flash");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMSightCamera", e, "closeFlash error: %s", e.getMessage());
            }
        }
    }

    public final int aHt() {
        if (this.gGm == null || this.oxB == null) {
            return 0;
        }
        try {
            return (!this.oxL || this.oxK == null) ? this.oxI == null ? (this.oxB.fGt == 0 || this.oxB.fGt == 180) ? this.oxv.mqM : this.oxv.mqN : (this.oxB.fGt == 0 || this.oxB.fGt == 180) ? this.oxI.x : this.oxI.y : (this.oxB.fGt == 0 || this.oxB.fGt == 180) ? this.oxH.x : this.oxH.y;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "getPreviewWidth: %s", e.getMessage());
            return 0;
        }
    }

    public final int aHu() {
        if (this.gGm == null || this.oxB == null) {
            return 0;
        }
        try {
            return (!this.oxL || this.oxK == null) ? this.oxI == null ? (this.oxB.fGt == 0 || this.oxB.fGt == 180) ? this.oxv.mqN : this.oxv.mqM : (this.oxB.fGt == 0 || this.oxB.fGt == 180) ? this.oxI.y : this.oxI.x : (this.oxB.fGt == 0 || this.oxB.fGt == 180) ? this.oxH.y : this.oxH.x;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "getPreviewHeight: %s", e.getMessage());
            return 0;
        }
    }

    public final int getOrientation() {
        if (this.oxB == null || !this.oxy) {
            return -1;
        }
        return this.oxB.fGt;
    }
}
