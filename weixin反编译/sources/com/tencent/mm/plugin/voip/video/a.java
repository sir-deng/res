package com.tencent.mm.plugin.voip.video;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.f.a.lr;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class a implements com.tencent.mm.plugin.video.a, b {
    private static final Pattern qgn = Pattern.compile(",");
    private static int syO = 20;
    private static int syP = 70;
    protected int mHeight = 240;
    protected int mWidth = 320;
    protected boolean syQ = false;
    protected boolean syR = false;
    protected boolean syS = false;
    protected boolean syT = false;
    protected boolean syU = false;
    protected long syV = 0;
    protected long syW = 30000;
    protected int syX = 0;
    protected Camera syY;
    protected Parameters syZ;
    protected Size sza;
    protected int szb;
    protected boolean szc = false;
    protected boolean szd = false;
    protected boolean sze = false;
    protected ObservableSurfaceView szf = null;
    protected ObservableTextureView szg;
    protected f szh;
    protected boolean szi = false;
    protected boolean szj = false;
    protected byte[] szk = null;
    protected int[] szl = null;
    protected List<byte[]> szm;
    protected boolean szn = true;
    protected int szo;
    protected int szp = 0;
    protected int szq = 0;
    protected int szr = 0;
    PreviewCallback szs = new PreviewCallback() {
        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            if (bArr == null || bArr.length <= 0) {
                g.pWK.a(159, 0, 1, false);
                g.pWK.a(159, 3, 1, false);
                if (a.this.szh != null) {
                    a.this.szh.bdJ();
                }
            } else if (a.this.sza == null) {
                x.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
            } else if (a.this.szh != null) {
                int i;
                boolean z;
                int i2;
                int i3;
                boolean z2;
                int i4;
                if (a.this.syQ) {
                    i4 = i.sAY;
                    if (q.gHF.gFH && q.gHF.gFG.fGt != 0) {
                        i = q.gHF.gFG.gGk;
                        z = true;
                        i2 = i4;
                    }
                    z = false;
                    i = 1;
                    i2 = i4;
                } else {
                    i4 = i.sAZ;
                    if (q.gHF.gFJ && q.gHF.gFI.fGt != 0) {
                        i = q.gHF.gFI.gGk;
                        z = true;
                        i2 = i4;
                    }
                    z = false;
                    i = 1;
                    i2 = i4;
                }
                if (i2 > 0) {
                    i3 = 32;
                } else {
                    i3 = 0;
                }
                a aVar = a.this;
                if (z || i2 <= 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                aVar.syR = z2;
                i2 = a.this.sza.width;
                int i5 = a.this.sza.height;
                if (z) {
                    if (a.this.szk == null) {
                        a.this.szk = new byte[(((i2 * i5) * 3) / 2)];
                        a.this.szk[0] = (byte) 90;
                    }
                    m bGT = d.bGT();
                    int length = bArr.length;
                    int i6 = a.this.szb;
                    byte[] bArr2 = a.this.szk;
                    int length2 = a.this.szk.length;
                    com.tencent.mm.plugin.voip.model.g gVar = bGT.ssY.soQ.sql;
                    if (gVar.sqF != com.tencent.mm.plugin.voip.model.g.sqE && gVar.soQ.sqj.oCT && gVar.soQ.bHf()) {
                        gVar.soQ.sqj.videoRorate90D(bArr, length, i2, i5, i6, bArr2, length2, i2, i5, i);
                    }
                    a.this.szh.c(a.this.szk, (long) a.this.szk.length, i2, i5, a.this.szb + i3);
                } else {
                    a.this.szh.c(bArr, (long) bArr.length, a.this.sza.width, a.this.sza.height, a.this.szb + i3);
                }
                if (com.tencent.mm.plugin.voip.b.d.bIX() >= 8) {
                    a.this.syY.addCallbackBuffer(bArr);
                }
            }
        }
    };

    public a(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        i.dI(ad.getContext().getApplicationContext());
        x.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight));
    }

    public final void a(ObservableSurfaceView observableSurfaceView) {
        if (observableSurfaceView != null) {
            this.szf = observableSurfaceView;
            this.szf.a(this);
            this.sze = true;
        }
    }

    public final void a(ObservableTextureView observableTextureView) {
        x.d("MicroMsg.Voip.CaptureRender", "bindTextureView");
        if (observableTextureView != null) {
            this.szg = observableTextureView;
            this.szg.a(this);
            this.sze = false;
        }
    }

    public final void a(SurfaceHolder surfaceHolder) {
        boolean z = false;
        x.d("MicroMsg.Voip.CaptureRender", "surfaceChange");
        if (!this.szc || surfaceHolder.getSurface() == null) {
            String str = "MicroMsg.Voip.CaptureRender";
            String str2 = "surfaceChange failed, CameraOpen: %b, surface: %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.szc);
            if (surfaceHolder.getSurface() == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
            return;
        }
        try {
            this.syY.setPreviewCallback(null);
            this.syY.stopPreview();
            this.syY.setPreviewDisplay(surfaceHolder);
            bJd();
            this.syY.startPreview();
        } catch (Exception e) {
            Exception exception = e;
            g.pWK.a(159, 0, 1, false);
            g.pWK.a(159, 2, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + exception.getMessage());
            this.syX = 1;
        }
        if (this.szj) {
            bJf();
            this.szj = false;
        }
        d.bGT().yY(this.syX);
    }

    public final void d(SurfaceTexture surfaceTexture) {
        boolean z = false;
        x.d("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable");
        if (!this.szc || surfaceTexture == null) {
            String str = "MicroMsg.Voip.CaptureRender";
            String str2 = "onSurfaceTextureAvailable failed, CameraOpen: %b, surface: %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.szc);
            if (surfaceTexture == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
            return;
        }
        try {
            this.syY.setPreviewCallback(null);
            this.syY.stopPreview();
            this.syY.setPreviewTexture(surfaceTexture);
            bJd();
            this.syY.startPreview();
        } catch (Exception e) {
            Exception exception = e;
            g.pWK.a(159, 0, 1, false);
            g.pWK.a(159, 2, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + exception.getMessage());
            this.syX = 1;
        }
        if (this.szj) {
            bJf();
            this.szj = false;
        }
        d.bGT().yY(this.syX);
    }

    public final int a(f fVar, boolean z) {
        if (i.sAV.gFB <= 0) {
            this.syX = 1;
            return -1;
        }
        if (z) {
            if (!i.sAV.szD) {
                z = false;
            }
        } else if (!i.sAV.szE) {
            z = true;
        }
        this.szh = fVar;
        if (d(z, this.mWidth, this.mHeight) <= 0) {
            int d = d(z, 0, 0);
            if (d <= 0) {
                this.syX = 1;
                return d;
            }
        }
        bJd();
        this.syX = 0;
        return 1;
    }

    private void bJd() {
        int i = 0;
        if (this.sza == null || this.sza.height <= 0 || this.sza.width <= 0) {
            this.syY.setPreviewCallback(this.szs);
            return;
        }
        int i2;
        int i3 = ((this.sza.height * this.sza.width) * 3) / 2;
        if (this.szm == null) {
            this.szm = new ArrayList(3);
            for (i2 = 0; i2 < 3; i2++) {
                this.szm.add(new byte[i3]);
            }
        }
        while (true) {
            i2 = i;
            if (i2 < this.szm.size()) {
                this.syY.addCallbackBuffer((byte[]) this.szm.get(i2));
                i = i2 + 1;
            } else {
                this.syY.setPreviewCallbackWithBuffer(this.szs);
                return;
            }
        }
    }

    private static Camera js(boolean z) {
        Camera camera = null;
        if (i.sAV.gFB <= 0 || !i.sBb) {
            return null;
        }
        if (z) {
            try {
                camera = Camera.open(i.sAW);
                x.i("Camera", "Use front");
                return camera;
            } catch (Exception e) {
                Exception exception = e;
                g.pWK.a(159, 0, 1, false);
                g.pWK.a(159, 1, 1, false);
                x.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:" + exception.toString());
                return camera;
            }
        }
        camera = Camera.open(i.sAX);
        x.i("Camera", "Use back");
        return camera;
    }

    private Camera jt(boolean z) {
        Camera js = js(z);
        if (js == null) {
            try {
                js = Camera.open();
                try {
                    Parameters parameters = js.getParameters();
                    parameters.set("camera-id", z ? 2 : 1);
                    js.setParameters(parameters);
                } catch (Exception e) {
                    Exception exception = e;
                    g.pWK.a(159, 0, 1, false);
                    x.e("MicroMsg.Voip.CaptureRender", "set camera-id error:" + exception.toString());
                }
            } catch (Exception e2) {
                x.e("MicroMsg.Voip.CaptureRender", "OpenCameraError:" + e2.toString());
                g.pWK.a(159, 0, 1, false);
                g.pWK.a(159, 1, 1, false);
                if (this.szh != null) {
                    this.szh.bdJ();
                }
                return null;
            }
        }
        this.syQ = z;
        i(js);
        h(js);
        return js;
    }

    private static boolean a(Camera camera, int i, int i2) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            if (i > 0 && i2 > 0) {
                parameters.setPreviewSize(i, i2);
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            g.pWK.a(159, 0, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + e.toString());
            return false;
        }
    }

    private boolean g(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                x.d("MicroMsg.Voip.CaptureRender", "supported focus modes size = " + supportedFocusModes.size());
                for (String str : supportedFocusModes) {
                    x.d("MicroMsg.Voip.CaptureRender", "supported focus modes : " + str);
                }
                if (q.gHF.gGh == 0) {
                    if (supportedFocusModes.contains("auto")) {
                        x.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                        parameters.setFocusMode("auto");
                        this.szd = false;
                    } else if (supportedFocusModes.contains("continuous-video")) {
                        x.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                        parameters.setFocusMode("continuous-video");
                        this.szd = true;
                    }
                } else if (q.gHF.gGh == 1) {
                    if (supportedFocusModes.contains("continuous-video")) {
                        x.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                        parameters.setFocusMode("continuous-video");
                        this.szd = true;
                    } else if (supportedFocusModes.contains("auto")) {
                        x.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                        parameters.setFocusMode("auto");
                        this.szd = false;
                    }
                }
                camera.setParameters(parameters);
            }
            return true;
        } catch (Exception e) {
            g.pWK.a(159, 0, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:" + e.toString());
            return false;
        }
    }

    private static Point a(CharSequence charSequence, Point point) {
        int indexOf;
        int parseInt;
        String[] split = qgn.split(charSequence);
        int length = split.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        while (i < length) {
            int i5;
            String trim = split[i].trim();
            indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                x.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: " + trim);
                i5 = i2;
                i2 = i3;
            } else {
                try {
                    parseInt = Integer.parseInt(trim.substring(0, indexOf));
                    indexOf = Integer.parseInt(trim.substring(indexOf + 1));
                    i5 = Math.abs(parseInt - point.x) + Math.abs(indexOf - point.y);
                    if (i5 == 0) {
                        break;
                    } else if (i5 >= i4 || parseInt == indexOf) {
                        i5 = i2;
                        i2 = i3;
                    } else {
                        i4 = i5;
                        i2 = parseInt;
                        i5 = indexOf;
                    }
                } catch (NumberFormatException e) {
                    x.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: " + trim);
                    i5 = i2;
                    i2 = i3;
                }
            }
            i++;
            i3 = i2;
            i2 = i5;
        }
        indexOf = i2;
        parseInt = i3;
        if (parseInt <= 0 || indexOf <= 0) {
            return null;
        }
        return new Point(parseInt, indexOf);
    }

    private int d(boolean z, int i, int i2) {
        Exception e;
        Object obj;
        Size size;
        Camera camera;
        CameraInfo cameraInfo;
        int i3;
        x.i("MicroMsg.Voip.CaptureRender", "try open camera, face: " + z);
        this.szd = false;
        Object obj2 = 1;
        if (this.syY != null) {
            if (this.syQ != z) {
                this.syY.setPreviewCallback(null);
                this.syY.stopPreview();
                this.syY.release();
                this.syY = null;
            } else {
                obj2 = null;
            }
        }
        if (obj2 != null) {
            this.syY = jt(z);
            if (this.syY == null) {
                this.szc = false;
                return -1;
            }
        }
        try {
            Parameters parameters;
            Point point;
            Size size2;
            boolean a;
            if (this.syY != null) {
                this.syY.getParameters();
            }
            this.szc = true;
            Camera camera2 = this.syY;
            int i4 = i.sAV.szC;
            if (camera2 != null) {
                try {
                    parameters = camera2.getParameters();
                    if (l.xn()) {
                        parameters.setPreviewFpsRange(i4 * 1000, i4 * 1000);
                    } else {
                        parameters.setPreviewFrameRate(i4);
                    }
                    camera2.setParameters(parameters);
                } catch (Exception e2) {
                    x.e("MicroMsg.Voip.CaptureRender", "SafeSetFps error:" + e2.toString());
                }
            }
            x.i("MicroMsg.Voip.CaptureRender", "Camera Open Success, try set size: w,h:" + i + "," + i2);
            if (z) {
                point = i.sAV.szH;
            } else {
                point = i.sAV.szI;
            }
            if (point != null) {
                obj = 1;
            } else {
                obj = null;
            }
            Size size3 = null;
            if (point != null) {
                Camera camera3 = this.syY;
                camera3.getClass();
                Size size4 = new Size(camera3, point.x, point.y);
                x.i("MicroMsg.Voip.CaptureRender", "getCameraSize from table:" + size4.width + "," + size4.height);
                size = size4;
            } else {
                size = null;
            }
            try {
                CharSequence charSequence;
                Camera camera4 = this.syY;
                parameters = camera4.getParameters();
                Point point2 = new Point(i, i2);
                String str = parameters.get("preview-size-values");
                if (str == null) {
                    charSequence = parameters.get("preview-size-value");
                } else {
                    Object charSequence2 = str;
                }
                Point point3 = null;
                if (charSequence2 != null) {
                    x.i("MicroMsg.Voip.CaptureRender", "preview-size-values parameter: " + charSequence2);
                    point3 = a(charSequence2, point2);
                }
                if (point3 == null) {
                    point3 = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
                }
                camera4.getClass();
                size2 = new Size(camera4, point3.x, point3.y);
                try {
                    x.i("MicroMsg.Voip.CaptureRender", "getCameraResolution:" + size2.width + "," + size2.height);
                } catch (Exception e3) {
                    e2 = e3;
                    size3 = size2;
                    x.e("MicroMsg.Voip.CaptureRender", "getCameraResolution failed: %s", e2.getMessage());
                    size2 = size3;
                    if (obj != null) {
                        x.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
                        if (size2 != null) {
                            x.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                            if (!a(this.syY, size2.width, size2.height)) {
                                x.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                                return -1;
                            }
                        }
                    }
                    a = a(this.syY, size.width, size.height);
                    x.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                    x.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                    if (!a(this.syY, size2.width, size2.height)) {
                        x.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                    g(this.syY);
                    this.syZ = this.syY.getParameters();
                    this.sza = this.syZ.getPreviewSize();
                    i4 = this.syZ.getPreviewFrameRate();
                    this.szb = i.sBa;
                    if (this.szb <= 0) {
                        this.szb = 7;
                    }
                    try {
                        camera = this.syY;
                        cameraInfo = new CameraInfo();
                        Camera.getCameraInfo(this.syQ ? i.sAX : i.sAW, cameraInfo);
                        i3 = 0;
                        switch (((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                            case 0:
                                i3 = 0;
                                break;
                            case 1:
                                i3 = 90;
                                break;
                            case 2:
                                i3 = 180;
                                break;
                            case 3:
                                i3 = 270;
                                break;
                        }
                        i3 = this.syQ ? ((cameraInfo.orientation - i3) + 360) % 360 : (360 - ((i3 + cameraInfo.orientation) % 360)) % 360;
                        camera.setDisplayOrientation(i3);
                        this.szo = i3;
                    } catch (Exception e22) {
                        x.e("MicroMsg.Voip.CaptureRender", "setDisplayOrientation failed: %s", e22.getMessage());
                    }
                    x.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", Integer.valueOf(i4), Integer.valueOf(this.sza.width), Integer.valueOf(this.sza.height), Integer.valueOf(this.szb), Integer.valueOf(i.sAY), Integer.valueOf(this.szo));
                    return 1;
                }
            } catch (Exception e4) {
                e22 = e4;
                x.e("MicroMsg.Voip.CaptureRender", "getCameraResolution failed: %s", e22.getMessage());
                size2 = size3;
                if (obj != null) {
                    a = a(this.syY, size.width, size.height);
                    x.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                    x.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                    if (a(this.syY, size2.width, size2.height)) {
                        x.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                }
                x.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
                if (size2 != null) {
                    x.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                    if (a(this.syY, size2.width, size2.height)) {
                        x.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                }
                g(this.syY);
                this.syZ = this.syY.getParameters();
                this.sza = this.syZ.getPreviewSize();
                i4 = this.syZ.getPreviewFrameRate();
                this.szb = i.sBa;
                if (this.szb <= 0) {
                    this.szb = 7;
                }
                camera = this.syY;
                cameraInfo = new CameraInfo();
                if (this.syQ) {
                }
                Camera.getCameraInfo(this.syQ ? i.sAX : i.sAW, cameraInfo);
                i3 = 0;
                switch (((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                    case 0:
                        i3 = 0;
                        break;
                    case 1:
                        i3 = 90;
                        break;
                    case 2:
                        i3 = 180;
                        break;
                    case 3:
                        i3 = 270;
                        break;
                }
                if (this.syQ) {
                }
                camera.setDisplayOrientation(i3);
                this.szo = i3;
                x.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", Integer.valueOf(i4), Integer.valueOf(this.sza.width), Integer.valueOf(this.sza.height), Integer.valueOf(this.szb), Integer.valueOf(i.sAY), Integer.valueOf(this.szo));
                return 1;
            }
            if (obj != null) {
                a = a(this.syY, size.width, size.height);
                x.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                if (!(a || size2 == null)) {
                    x.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                    if (a(this.syY, size2.width, size2.height)) {
                        x.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                }
            }
            x.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
            if (size2 != null) {
                x.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                if (a(this.syY, size2.width, size2.height)) {
                    x.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                    return -1;
                }
            }
            g(this.syY);
            try {
                this.syZ = this.syY.getParameters();
                this.sza = this.syZ.getPreviewSize();
                i4 = this.syZ.getPreviewFrameRate();
                this.szb = i.sBa;
                if (this.szb <= 0) {
                    this.szb = 7;
                }
                camera = this.syY;
                cameraInfo = new CameraInfo();
                if (this.syQ) {
                }
                Camera.getCameraInfo(this.syQ ? i.sAX : i.sAW, cameraInfo);
                i3 = 0;
                switch (((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                    case 0:
                        i3 = 0;
                        break;
                    case 1:
                        i3 = 90;
                        break;
                    case 2:
                        i3 = 180;
                        break;
                    case 3:
                        i3 = 270;
                        break;
                }
                if (this.syQ) {
                }
                camera.setDisplayOrientation(i3);
                this.szo = i3;
                x.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", Integer.valueOf(i4), Integer.valueOf(this.sza.width), Integer.valueOf(this.sza.height), Integer.valueOf(this.szb), Integer.valueOf(i.sAY), Integer.valueOf(this.szo));
                return 1;
            } catch (Exception e222) {
                g.pWK.a(159, 0, 1, false);
                x.e("MicroMsg.Voip.CaptureRender", "try getParameters and getPreviewSize fail, error:%s", e222.getMessage());
                return -1;
            }
        } catch (Exception e2222) {
            g.pWK.a(159, 0, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "Camera open failed, error:%s", e2222.getMessage());
            if (this.szh != null) {
                this.szh.bdJ();
            }
            return -1;
        }
    }

    public final void bJe() {
        if (i.sAV.gFB < 2) {
            x.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + i.sAV.gFB);
            return;
        }
        x.i("MicroMsg.Voip.CaptureRender", "ExchangeCapture start, gCameraNum= " + i.sAV.gFB);
        bJg();
        a(this.szh, !this.syQ);
        bJf();
        d.bGT().yY(this.syX);
        this.szn = true;
    }

    public final int bJf() {
        if (!this.szc) {
            x.e("MicroMsg.Voip.CaptureRender", "StartCapture: failed without open camera");
            this.syX = 1;
            return -1;
        } else if (this.szi) {
            x.e("MicroMsg.Voip.CaptureRender", "StartCapture: is in capture already ");
            return -1;
        } else if (this.szf == null || this.szf.bGn()) {
            x.d("MicroMsg.Voip.CaptureRender", "StartCapture now, isUesSurfacePreivew: %b", Boolean.valueOf(this.sze));
            if (this.szf != null && this.sze) {
                try {
                    this.syY.setPreviewDisplay(this.szf.getSurfaceHolder());
                } catch (Exception e) {
                    g.pWK.a(159, 0, 1, false);
                    g.pWK.a(159, 2, 1, false);
                    this.syX = 1;
                    x.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + e.toString());
                }
            } else if (!(this.szg == null || this.sze)) {
                try {
                    this.syY.setPreviewTexture(this.szg.getSurfaceTexture());
                } catch (Exception e2) {
                    g.pWK.a(159, 0, 1, false);
                    g.pWK.a(159, 2, 1, false);
                    this.syX = 1;
                    x.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + e2.toString());
                }
            }
            try {
                this.syY.startPreview();
            } catch (Exception e22) {
                g.pWK.a(159, 0, 1, false);
                g.pWK.a(159, 2, 1, false);
                this.syX = 1;
                if (this.szh != null) {
                    this.szh.bdJ();
                }
                x.e("MicroMsg.Voip.CaptureRender", "startPreview:error" + e22.toString());
            }
            this.szi = true;
            return 1;
        } else {
            x.d("MicroMsg.Voip.CaptureRender", "StartCapture:surface not ready, try later.... ");
            this.szj = true;
            return 0;
        }
    }

    public final void bJg() {
        x.d("MicroMsg.Voip.CaptureRender", "StopCapture....mIsInCapture = " + this.szi);
        if (this.szi) {
            this.szj = false;
            this.syY.setPreviewCallback(null);
            try {
                this.syY.stopPreview();
            } catch (Exception e) {
                x.e("MicroMsg.Voip.CaptureRender", "stopPreview:error" + e.toString());
            }
            this.szi = false;
        }
        if (1 == this.syX) {
            com.tencent.mm.sdk.b.b lrVar = new lr();
            lrVar.fDX.type = 2;
            com.tencent.mm.sdk.b.a.xmy.m(lrVar);
        }
        x.d("MicroMsg.Voip.CaptureRender", "UnInitCapture....mCameraOpen = " + this.szc);
        if (this.szc) {
            this.syX = 0;
            this.szj = false;
            this.syY.setPreviewCallback(null);
            this.syY.release();
            this.syY = null;
            this.szc = false;
        } else if (this.syY != null) {
            this.syY.release();
            this.syY = null;
            this.szc = false;
        }
        this.szk = null;
        if (this.szm != null) {
            this.szm.clear();
        }
        this.szm = null;
        this.szd = false;
    }

    public static void bJh() {
    }

    @TargetApi(14)
    public final void l(int[] iArr) {
        boolean z = true;
        if (q.gHF.gGh != 1 || !this.szd) {
            if (q.gHF.gGg > MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                this.syW = (long) q.gHF.gGg;
            }
            boolean z2;
            boolean z3;
            if (iArr == null) {
                x.e("MicroMsg.Voip.CaptureRender", "focusOnFace error, faceLocation is null");
                z2 = System.currentTimeMillis() - this.syV > this.syW;
                if (!this.syS || z2 || this.syT != this.syQ) {
                    String str = "MicroMsg.Voip.CaptureRender";
                    StringBuilder stringBuilder = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
                    if (this.syS) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    StringBuilder append = stringBuilder.append(z3).append(",isAutoFocusTimeout: ").append(z2).append(",mAutoFocusTimeOut:").append(this.syW).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
                    if (this.syT == this.syQ) {
                        z = false;
                    }
                    x.i(str, append.append(z).append(",isClickScreen :false").toString());
                    try {
                        if (this.syY != null && this.syY.getParameters() != null && this.syY.getParameters().getFocusMode() != null && this.syY.getParameters().getFocusMode().equals("auto")) {
                            this.syY.autoFocus(null);
                            this.szl = null;
                            this.syV = System.currentTimeMillis();
                            this.syS = true;
                            this.syT = this.syQ;
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        x.e("MicroMsg.Voip.CaptureRender", "mCamera.getParameters() or autoFocus fail!" + e.toString());
                        return;
                    }
                }
                return;
            }
            Rect rect;
            Parameters parameters;
            if (this.szl == null) {
                this.szl = iArr;
                z2 = true;
            } else {
                z2 = false;
            }
            int[] iArr2 = this.szl;
            int abs = Math.abs(iArr2[3] - iArr[3]) + ((Math.abs(iArr2[0] - iArr[0]) + Math.abs(iArr2[1] - iArr[1])) + Math.abs(iArr2[2] - iArr[2]));
            x.d("MicroMsg.Voip.CaptureRender", "face location diff:%d", Integer.valueOf(abs));
            if (abs > syP || abs > syO) {
                this.szl = iArr;
                if (abs > syP) {
                    z2 = true;
                }
                if (abs > syO) {
                    z3 = true;
                    if (!z2 || z3) {
                        List arrayList;
                        rect = new Rect(this.szl[0], this.szl[1], this.szl[2], this.szl[3]);
                        parameters = this.syY.getParameters();
                        if (z3) {
                            if (com.tencent.mm.compatible.util.d.fN(14) || parameters.getMaxNumMeteringAreas() <= 0) {
                                x.d("MicroMsg.Voip.CaptureRender", "camera not support metering area");
                                z3 = false;
                            } else {
                                arrayList = new ArrayList();
                                arrayList.add(new Area(rect, 1000));
                                parameters.setMeteringAreas(arrayList);
                            }
                        }
                        if (z2) {
                            if (com.tencent.mm.compatible.util.d.fN(14) || parameters.getMaxNumFocusAreas() <= 0) {
                                x.d("MicroMsg.Voip.CaptureRender", "camera not support area focus");
                                z2 = false;
                            } else {
                                arrayList = new ArrayList();
                                arrayList.add(new Area(rect, 1000));
                                parameters.setFocusAreas(arrayList);
                            }
                        }
                        if (z2 || r3) {
                            this.syY.setParameters(parameters);
                        }
                        if (z2) {
                            x.d("MicroMsg.Voip.CaptureRender", "refocus, mIsFocusOnFace:%b", Boolean.valueOf(this.szn));
                            if (this.szn) {
                                this.syS = false;
                                this.szn = false;
                                this.syY.autoFocus(new AutoFocusCallback() {
                                    public final void onAutoFocus(boolean z, Camera camera) {
                                        x.d("MicroMsg.Voip.CaptureRender", "onAutoFocus, success:%b", Boolean.valueOf(z));
                                        a.this.szn = true;
                                    }
                                });
                            }
                        }
                    }
                    return;
                }
            }
            z3 = false;
            if (z2) {
            }
            try {
                rect = new Rect(this.szl[0], this.szl[1], this.szl[2], this.szl[3]);
                parameters = this.syY.getParameters();
                if (z3) {
                    if (com.tencent.mm.compatible.util.d.fN(14)) {
                    }
                    x.d("MicroMsg.Voip.CaptureRender", "camera not support metering area");
                    z3 = false;
                }
                if (z2) {
                    if (com.tencent.mm.compatible.util.d.fN(14)) {
                    }
                    x.d("MicroMsg.Voip.CaptureRender", "camera not support area focus");
                    z2 = false;
                }
                this.syY.setParameters(parameters);
                if (z2) {
                    x.d("MicroMsg.Voip.CaptureRender", "refocus, mIsFocusOnFace:%b", Boolean.valueOf(this.szn));
                    if (this.szn) {
                        this.syS = false;
                        this.szn = false;
                        this.syY.autoFocus(/* anonymous class already generated */);
                    }
                }
            } catch (Exception e2) {
                x.e("MicroMsg.Voip.CaptureRender", "focusOnFace exception:%s", e2.getMessage());
            }
        }
    }

    private int h(Camera camera) {
        int i;
        Throwable th;
        if (camera == null) {
            return 0;
        }
        try {
            int i2;
            List<Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                i2 = 0;
            } else {
                i2 = 0;
                for (Size size : supportedPreviewSizes) {
                    try {
                        x.d("MicroMsg.Voip.CaptureRender", "support Size:" + size.width + "," + size.height);
                        if (i2 == 0) {
                            this.szp = size.width;
                            this.szq = size.height;
                        }
                        i2++;
                    } catch (Throwable e) {
                        Throwable th2 = e;
                        i = i2;
                        th = th2;
                    }
                }
            }
            List<Integer> supportedPreviewFormats = camera.getParameters().getSupportedPreviewFormats();
            if (!(supportedPreviewFormats == null || supportedPreviewFormats.size() == 0)) {
                for (Integer intValue : supportedPreviewFormats) {
                    x.i("MicroMsg.Voip.CaptureRender", "support Format:" + intValue.intValue());
                }
            }
            return i2;
        } catch (Throwable e2) {
            th = e2;
            i = 0;
            x.printErrStackTrace("MicroMsg.Voip.CaptureRender", th, "", new Object[0]);
            return i;
        }
    }

    private static void i(Camera camera) {
        List supportedPreviewFrameRates;
        String str;
        List list = null;
        try {
            supportedPreviewFrameRates = camera.getParameters().getSupportedPreviewFrameRates();
        } catch (Exception e) {
            x.d("MicroMsg.Voip.CaptureRender", "getSupportedPreviewFrameRates:error:" + e.toString());
            supportedPreviewFrameRates = list;
        }
        String str2 = "supportFps:";
        if (supportedPreviewFrameRates != null) {
            int i = 0;
            str = str2;
            while (true) {
                int i2 = i;
                if (i2 >= supportedPreviewFrameRates.size()) {
                    break;
                }
                str = str + ((Integer) supportedPreviewFrameRates.get(i2)).intValue() + ",";
                i = i2 + 1;
            }
        } else {
            str = str2;
        }
        x.i("MicroMsg.Voip.CaptureRender", str);
    }

    public final boolean bJi() {
        return this.syQ;
    }

    public final boolean bJj() {
        return this.syR;
    }

    public final int bJk() {
        return this.syX;
    }

    public final void bJl() {
        try {
            if (this.syZ != null) {
                Size previewSize = this.syZ.getPreviewSize();
                c bJE = com.tencent.mm.plugin.voip_cs.b.b.bJE();
                int i = this.szc ? 1 : 0;
                this.syZ.getPreviewFrameRate();
                int i2 = this.szp;
                int i3 = this.szq;
                int i4 = previewSize.width;
                int i5 = previewSize.height;
                x.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
                bJE.sCk = i;
                bJE.sCg = i2;
                bJE.sCh = i3;
                bJE.sCi = i4;
                bJE.sCj = i5;
            }
        } catch (Exception e) {
            x.e("MicroMsg.Voip.CaptureRender", "getCameraDataForVoipCS failed" + e.getMessage());
        }
    }
}
