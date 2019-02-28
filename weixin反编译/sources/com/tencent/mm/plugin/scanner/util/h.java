package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public final class h {
    private static final Pattern qgn = Pattern.compile(",");
    public Activity fBA;
    public Camera gGm;
    public Rect mgX;
    public boolean mmJ = false;
    public Point mmK = null;
    public Point mmL = null;
    public Point mmM = null;
    public boolean mmN;
    public int mmO;
    public boolean mmP = false;
    public boolean oxN = false;
    public int qgo = 0;
    private boolean qgp;
    public Rect qgq;
    private Rect qgr;
    private Rect qgs;
    public int qgt = -1;
    private String qgu = "";
    private int qgv;
    private int qgw;
    private int qgx;

    private static class a implements Comparator<Size> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            int i = size.height * size.width;
            int i2 = size2.height * size2.width;
            if (i2 < i) {
                return -1;
            }
            return i2 > i ? 1 : 0;
        }
    }

    public h(Activity activity, int i, boolean z) {
        Point point;
        this.fBA = activity;
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            point = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        } else {
            point = ae.fA(activity);
        }
        this.mmL = point;
        this.qgp = z;
        this.qgo = i;
    }

    public final boolean isOpen() {
        if (this.gGm != null) {
            return true;
        }
        return false;
    }

    public final void wd(int i) {
        this.qgo = i;
        this.qgq = null;
        this.mgX = null;
    }

    public final String getFocusMode() {
        if (this.gGm == null || !this.mmJ) {
            return "";
        }
        return this.gGm.getParameters().getFocusMode();
    }

    public final void release() {
        x.d("MicroMsg.scanner.ScanCamera", "release(), previewing = [%s]", Boolean.valueOf(this.mmJ));
        if (this.gGm != null) {
            long Wz = bi.Wz();
            if (this.mmJ) {
                this.gGm.setPreviewCallback(null);
                this.gGm.stopPreview();
                this.mmJ = false;
                x.d("MicroMsg.scanner.ScanCamera", "stopPreview costTime=[%s]", Long.valueOf(bi.bB(Wz)));
            }
            Wz = bi.Wz();
            this.gGm.release();
            this.gGm = null;
            x.d("MicroMsg.scanner.ScanCamera", "camera.release() costTime=[%s]", Long.valueOf(bi.bB(Wz)));
        }
        this.oxN = false;
        this.mmP = false;
        this.qgt = -1;
        this.qgo = 0;
    }

    public final float bql() {
        if (!this.mmN || this.qgp) {
            return ((float) this.mmM.x) / ((float) this.mmK.x);
        }
        return ((float) this.mmM.x) / ((float) this.mmK.y);
    }

    public final float bqm() {
        if (!this.mmN || this.qgp) {
            return ((float) this.mmM.y) / ((float) this.mmK.y);
        }
        return ((float) this.mmM.y) / ((float) this.mmK.x);
    }

    private float bqn() {
        if (!this.mmN || this.qgp) {
            return ((float) this.mmK.x) / ((float) this.mmM.x);
        }
        return ((float) this.mmK.y) / ((float) this.mmM.x);
    }

    private float bqo() {
        if (!this.mmN || this.qgp) {
            return ((float) this.mmK.y) / ((float) this.mmM.y);
        }
        return ((float) this.mmK.x) / ((float) this.mmM.y);
    }

    public final Rect a(Rect rect, int i) {
        Rect rect2 = new Rect();
        x.i("MicroMsg.scanner.ScanCamera", "frame rect:%s, visibleResolution:%s", rect, this.mmM);
        if (!this.mmN || this.qgp) {
            rect2.left = (int) (((float) rect.left) * bqn());
            rect2.right = (int) (((float) rect.right) * bqn());
            rect2.top = (int) (((float) rect.top) * bqo());
            rect2.bottom = (int) (((float) rect.bottom) * bqo());
            if (rect2.bottom > this.mmK.y) {
                rect2.bottom = this.mmK.y;
            }
            if (rect2.right > this.mmK.x) {
                rect2.right = this.mmK.x;
            }
        } else {
            x.i("MicroMsg.scanner.ScanCamera", ", needRotate = " + this.mmN + " needLandscape = " + this.qgp);
            rect2.top = (this.mmK.y - ((int) (((float) rect.width()) * bqn()))) / 2;
            rect2.bottom = rect2.top + ((int) (((float) rect.width()) * bqn()));
            rect2.left = (this.mmK.x - ((int) (((float) rect.height()) * bqo()))) / 2;
            rect2.right = rect2.left + ((int) (((float) rect.height()) * bqo()));
            if (rect2.bottom > this.mmK.y) {
                rect2.bottom = this.mmK.y;
            }
            if (rect2.right > this.mmK.x) {
                rect2.right = this.mmK.x;
            }
        }
        if (7 == i || 11 == i) {
            int width;
            if (!this.mmN || this.qgp) {
                if ((((double) rect2.width()) * 1.0d) / ((double) rect2.height()) < 1.5859999656677246d) {
                    width = (int) (((float) rect2.width()) / 1.586f);
                    rect2.top = ((rect2.top + rect2.bottom) / 2) - (width / 2);
                    rect2.bottom = width + rect2.top;
                } else {
                    width = (int) (((float) rect2.height()) * 1.586f);
                    rect2.left = ((rect2.left + rect2.right) / 2) - (width / 2);
                    rect2.right = width + rect2.left;
                }
            } else if (((float) rect2.height()) / 1.586f < ((float) rect2.width())) {
                width = (int) (((float) rect2.height()) / 1.586f);
                rect2.left = ((rect2.left + rect2.right) / 2) - (width / 2);
                rect2.right = width + rect2.left;
            } else {
                width = (int) (((float) rect2.width()) * 1.586f);
                rect2.top = ((rect2.top + rect2.bottom) / 2) - (width / 2);
                rect2.bottom = width + rect2.top;
            }
        }
        return rect2;
    }

    public final void bqp() {
        if (this.gGm != null && !this.mmP) {
            try {
                int width;
                int height;
                Parameters parameters = this.gGm.getParameters();
                if (this.qgq != null) {
                    this.qgr = new Rect();
                    width = (int) ((((float) this.qgq.width()) / ((float) this.mmK.x)) * 2000.0f);
                    height = (int) ((((float) this.qgq.height()) / ((float) this.mmK.y)) * 2000.0f);
                    this.qgr.left = (-width) / 2;
                    this.qgr.right = width / 2;
                    this.qgr.top = (-height) / 2;
                    this.qgr.bottom = height / 2;
                    x.i("MicroMsg.scanner.ScanCamera", "set focus area:" + this.qgr);
                }
                if (this.qgq != null) {
                    this.qgs = new Rect();
                    width = (int) ((((float) this.qgq.width()) / ((float) this.mmK.x)) * 2000.0f);
                    height = (int) ((((float) this.qgq.height()) / ((float) this.mmK.y)) * 2000.0f);
                    this.qgs.left = (-width) / 2;
                    this.qgs.right = width / 2;
                    this.qgs.top = (-height) / 2;
                    this.qgs.bottom = height / 2;
                    x.i("MicroMsg.scanner.ScanCamera", "set metering area:" + this.qgs);
                }
                if (this.qgr != null && this.qgs != null) {
                    List arrayList;
                    this.mmP = true;
                    if (parameters.getMaxNumMeteringAreas() > 0) {
                        arrayList = new ArrayList();
                        arrayList.add(new Area(this.qgs, 1000));
                        parameters.setMeteringAreas(arrayList);
                    } else {
                        x.i("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea, camera not support set metering area");
                    }
                    if (parameters.getMaxNumFocusAreas() > 0) {
                        arrayList = new ArrayList();
                        arrayList.add(new Area(this.qgr, 1000));
                        parameters.setFocusAreas(arrayList);
                    } else {
                        x.i("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea, camera not support area focus");
                    }
                    this.gGm.setParameters(parameters);
                }
            } catch (Exception e) {
                x.e("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea error: %s", e.getMessage());
            }
        }
    }

    public static Point a(Parameters parameters, Point point, Point point2, boolean z) {
        String str;
        String str2 = parameters.get("preview-size-values");
        if (str2 == null) {
            str = parameters.get("preview-size-value");
        } else {
            str = str2;
        }
        Point point3 = null;
        if (str != null) {
            x.d("MicroMsg.scanner.ScanCamera", "preview-size-values parameter: " + str);
            point3 = a(parameters, point, z);
        }
        if (point3 == null) {
            return new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
        }
        return point3;
    }

    private static Point a(Parameters parameters, Point point, boolean z) {
        Size previewSize;
        List<Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        arrayList.remove(0);
        Point point2 = null;
        x.d("MicroMsg.scanner.ScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y)));
        x.i("MicroMsg.scanner.ScanCamera", "SCREEN_PIXELS: %s, MAX_PREVIEW_PIXELS_USE_BIGGER: %s", Integer.valueOf(point.x * point.y), Integer.valueOf(2073600));
        float f = Float.POSITIVE_INFINITY;
        for (Size previewSize2 : arrayList) {
            int i = previewSize2.width;
            int i2 = previewSize2.height;
            x.i("MicroMsg.scanner.ScanCamera", "realWidth: %d, realHeight: %d", Integer.valueOf(i), Integer.valueOf(i2));
            int i3 = i * i2;
            if (i3 >= 150400 && i3 <= 2073600) {
                if (i3 <= r7 || Math.min(point.x, point.y) < 720) {
                    int i4;
                    Object obj = i > i2 ? 1 : null;
                    if (obj == null || z) {
                        i4 = i;
                    } else {
                        i4 = i2;
                    }
                    if (obj == null || z) {
                        i3 = i2;
                    } else {
                        i3 = i;
                    }
                    x.d("MicroMsg.scanner.ScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", Integer.valueOf(i4), Integer.valueOf(i3));
                    if (i4 == point.x && i3 == point.y) {
                        point2 = new Point(i, i2);
                        x.i("MicroMsg.scanner.ScanCamera", "Found preview size exactly matching screen size: " + point2);
                        return point2;
                    }
                    Point point3;
                    float f2;
                    float abs = Math.abs((((float) i4) / ((float) i3)) - r6);
                    if (abs < f) {
                        point3 = new Point(i, i2);
                        f2 = abs;
                    } else {
                        f2 = f;
                        point3 = point2;
                    }
                    x.i("MicroMsg.scanner.ScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i), Integer.valueOf(i2));
                    point2 = point3;
                    f = f2;
                }
            }
        }
        if (point2 == null) {
            previewSize2 = parameters.getPreviewSize();
            point2 = new Point(previewSize2.width, previewSize2.height);
            x.i("MicroMsg.scanner.ScanCamera", "No suitable preview sizes, using default: " + point2);
        }
        x.i("MicroMsg.scanner.ScanCamera", "Found best approximate preview size: " + point2);
        return point2;
    }

    public final void bqq() {
        try {
            if (this.gGm != null) {
                Parameters parameters = this.gGm.getParameters();
                String str = parameters.get("zoom-supported");
                if (bi.oN(str) || !Boolean.parseBoolean(str)) {
                    x.i("MicroMsg.scanner.ScanCamera", "not support zoom");
                    return;
                }
                List zoomRatios = parameters.getZoomRatios();
                if (zoomRatios != null && zoomRatios.size() > 0) {
                    as.Hm();
                    q.eK(c.Dc().ckJ());
                    x.i("MicroMsg.scanner.ScanCamera", "needZoom: %s, qrCodeZoom: %s", Boolean.valueOf(q.gHP.gGO == 1), Integer.valueOf(q.gHP.gGO));
                    if ((q.gHP.gGO == 1) && this.mmL.x >= 720 && (this.qgo == 1 || this.qgo == 8 || this.qgo == 4)) {
                        this.qgw = zoomRatios.size() / 5;
                        if (this.qgw > 150) {
                            this.qgw = 150;
                        }
                    } else {
                        this.qgw = 0;
                    }
                    double d = 1.5d;
                    if (q.gHP.gGP != -1.0d) {
                        d = q.gHP.gGP;
                    }
                    this.qgx = (int) (((double) zoomRatios.size()) / d);
                    x.d("MicroMsg.scanner.ScanCamera", "divideRatio: %f,max zoom: %d", Double.valueOf(d), Integer.valueOf(this.qgx));
                    if (this.qgx < this.qgw) {
                        this.qgx = this.qgw;
                    } else if (this.qgx > 400) {
                        this.qgx = 400;
                    }
                    x.i("MicroMsg.scanner.ScanCamera", "default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", Integer.valueOf(this.qgw), zoomRatios.get(this.qgw), Integer.valueOf(this.qgx), zoomRatios.get(this.qgx));
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "init zoom exception!", new Object[0]);
        }
    }

    public final void we(int i) {
        if (this.gGm != null && this.mmJ && i > 0) {
            try {
                Parameters parameters = this.gGm.getParameters();
                List zoomRatios = parameters.getZoomRatios();
                if (zoomRatios != null && zoomRatios.size() > 0) {
                    int binarySearch;
                    int intValue = (int) (((double) ((Integer) zoomRatios.get(this.qgv)).intValue()) * (((double) i) / 100.0d));
                    x.d("MicroMsg.scanner.ScanCamera", "scale:%d,to ratio:%d", Integer.valueOf(i), Integer.valueOf(intValue));
                    if (intValue >= ((Integer) zoomRatios.get(this.qgw)).intValue() && intValue <= ((Integer) zoomRatios.get(this.qgx)).intValue()) {
                        if (zoomRatios != null && zoomRatios.size() > 0) {
                            x.i("MicroMsg.scanner.ScanCamera", "zoomRatios: %s,size: %d", zoomRatios, Integer.valueOf(zoomRatios.size()));
                            binarySearch = Collections.binarySearch(zoomRatios, Integer.valueOf(intValue));
                            x.i("MicroMsg.scanner.ScanCamera", "insert index:%d", Integer.valueOf(binarySearch));
                            if (binarySearch < 0) {
                                int i2 = -(binarySearch + 1);
                                int i3 = i2 - 1;
                                if (i2 >= 0) {
                                    if (i2 <= zoomRatios.size() - 1 && i3 >= 0 && i3 <= zoomRatios.size() - 1) {
                                        binarySearch = ((Integer) zoomRatios.get(i2)).intValue() - intValue > intValue - ((Integer) zoomRatios.get(i3)).intValue() ? i3 : i2;
                                    }
                                }
                                if (i2 >= 0 && i2 <= zoomRatios.size() - 1) {
                                    binarySearch = i2;
                                } else if (i3 >= 0 && i3 <= zoomRatios.size() - 1) {
                                    binarySearch = i3;
                                }
                            }
                        }
                        binarySearch = 0;
                    } else if (intValue < ((Integer) zoomRatios.get(this.qgw)).intValue()) {
                        binarySearch = this.qgw;
                    } else {
                        x.i("MicroMsg.scanner.ScanCamera", "exceed max zoom");
                        binarySearch = this.qgv + ((this.qgx - this.qgv) / 5);
                        if (binarySearch > this.qgx) {
                            binarySearch = this.qgx;
                        }
                    }
                    x.i("MicroMsg.scanner.ScanCamera", "zoom:%d,ratio:%d", Integer.valueOf(binarySearch), zoomRatios.get(binarySearch));
                    this.qgv = binarySearch;
                    parameters.setZoom(binarySearch);
                    this.gGm.setParameters(parameters);
                }
            } catch (Exception e) {
                x.e("MicroMsg.scanner.ScanCamera", "zoom scale exception:" + e.getMessage());
            }
        }
    }

    public final void wf(int i) {
        if (this.gGm != null && this.mmJ) {
            try {
                Parameters parameters = this.gGm.getParameters();
                List zoomRatios = parameters.getZoomRatios();
                if (zoomRatios != null && zoomRatios.size() > 0) {
                    x.i("MicroMsg.scanner.ScanCamera", "zoom action:%d,beforeZoom:%d", Integer.valueOf(i), Integer.valueOf(parameters.getZoom()));
                    switch (i) {
                        case 0:
                            this.qgv = 0;
                            break;
                        case 1:
                            this.qgv = this.qgw;
                            break;
                        case 2:
                            if (this.qgv < this.qgx) {
                                this.qgv++;
                                this.qgv = this.qgv > this.qgx ? this.qgx : this.qgv;
                                break;
                            }
                            break;
                        case 3:
                            if (this.qgv > this.qgw) {
                                this.qgv--;
                                this.qgv = this.qgv < this.qgw ? this.qgw : this.qgv;
                                break;
                            }
                            break;
                        case 4:
                            this.qgv = this.qgx;
                            break;
                        case 5:
                            if (this.qgv == this.qgw) {
                                this.qgv = this.qgx;
                                break;
                            } else {
                                this.qgv = this.qgw;
                                break;
                            }
                    }
                    parameters.setZoom(this.qgv);
                    this.gGm.setParameters(parameters);
                    x.i("MicroMsg.scanner.ScanCamera", "zoom action:%d,afterZoom:%d", Integer.valueOf(i), Integer.valueOf(parameters.getZoom()));
                }
            } catch (Exception e) {
                x.e("MicroMsg.scanner.ScanCamera", "zoom action exception:" + e.getMessage());
            }
        }
    }

    public final int bqr() {
        if (this.gGm == null || this.gGm.getParameters() == null || this.gGm.getParameters().getZoomRatios() == null || this.gGm.getParameters().getZoomRatios().size() <= 0) {
            return 100;
        }
        return ((Integer) this.gGm.getParameters().getZoomRatios().get(this.qgv)).intValue();
    }

    public static void c(Parameters parameters) {
        try {
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                x.d("MicroMsg.scanner.ScanCamera", "supported focus modes size = " + supportedFocusModes.size());
                for (String str : supportedFocusModes) {
                    x.d("MicroMsg.scanner.ScanCamera", "supported focus modes : " + str);
                }
                if (supportedFocusModes.contains("continuous-video")) {
                    x.d("MicroMsg.scanner.ScanCamera", "camera support continuous video focus");
                    parameters.setFocusMode("continuous-video");
                } else if (supportedFocusModes.contains("auto")) {
                    x.d("MicroMsg.scanner.ScanCamera", "camera support auto focus");
                    parameters.setFocusMode("auto");
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.scanner.ScanCamera", "setAutoFocus error: %s", e.getMessage());
        }
    }

    public final boolean bqs() {
        if (this.gGm != null && this.mmJ) {
            try {
                Parameters parameters = this.gGm.getParameters();
                if (!bi.cC(parameters.getSupportedFlashModes()) && parameters.getSupportedFlashModes().contains("torch")) {
                    return true;
                }
                x.i("MicroMsg.scanner.ScanCamera", "camera not support flash!!");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "isFlashSupported error: %s", e.getMessage());
            }
        }
        return false;
    }

    public final void baJ() {
        x.i("MicroMsg.scanner.ScanCamera", "closeFlash, camera: %s, isPreviewing: %s", this.gGm, Boolean.valueOf(this.mmJ));
        if (this.gGm != null && this.mmJ) {
            try {
                this.oxN = false;
                Parameters parameters = this.gGm.getParameters();
                if (bi.cC(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("off")) {
                    x.i("MicroMsg.scanner.ScanCamera", "camera not support close flash!!");
                    return;
                }
                parameters.setFlashMode("off");
                this.gGm.setParameters(parameters);
                x.i("MicroMsg.scanner.ScanCamera", "close flash");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "closeFlash error: %s", e.getMessage());
            }
        }
    }
}
