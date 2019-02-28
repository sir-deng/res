package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class m {
    private Context context;
    public Camera gGm;
    public boolean mmJ = false;
    public Point mmK = null;
    public Point mmL = null;
    private Point mmM = null;
    private boolean mmN;
    public int mmO;
    private boolean mmP = false;
    private boolean mmQ = true;
    public boolean mmR = false;
    public Point mmS = null;

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

    public m(Context context) {
        this.context = context;
    }

    public final void e(SurfaceTexture surfaceTexture) {
        if (this.mmJ) {
            x.w("MicroMsg.FaceScanCamera", "in open(), previewing");
            release();
        }
        this.mmQ = true;
        int numberOfCameras = Camera.getNumberOfCameras();
        int i = 0;
        while (i < numberOfCameras) {
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing != 1 || !this.mmQ) {
                if (cameraInfo.facing == 0 && !this.mmQ) {
                    x.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
                    break;
                }
                i++;
            } else {
                x.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
                break;
            }
        }
        i = -1;
        long Wz = bi.Wz();
        com.tencent.mm.compatible.e.d.a.a o = d.o(this.context, i);
        if (o == null) {
            x.e("MicroMsg.FaceScanCamera", "in open(), openCameraRes == null");
            throw new IOException();
        }
        boolean z;
        this.mmR = true;
        x.d("MicroMsg.FaceScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", Integer.valueOf(i), Long.valueOf(bi.bB(Wz)));
        this.mmO = o.fGt;
        if (o.fGt % 180 != 0) {
            z = true;
        } else {
            z = false;
        }
        this.mmN = z;
        this.gGm = o.gGm;
        if (this.gGm == null) {
            x.e("MicroMsg.FaceScanCamera", "in open(), camera == null, bNeedRotate=[%s]", Boolean.valueOf(this.mmN));
            throw new IOException();
        }
        String str;
        this.gGm.setPreviewTexture(surfaceTexture);
        Parameters parameters = this.gGm.getParameters();
        Point point = this.mmL;
        Point point2 = this.mmM;
        String str2 = parameters.get("preview-size-values");
        if (str2 == null) {
            str = parameters.get("preview-size-value");
        } else {
            str = str2;
        }
        Point point3 = null;
        if (str != null) {
            x.d("MicroMsg.FaceScanCamera", "preview-size-values parameter: " + str);
            point3 = a(parameters, point, false);
        }
        if (point3 == null) {
            point3 = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
        }
        this.mmK = point3;
        this.mmS = new Point(this.mmK);
        x.d("MicroMsg.FaceScanCamera", "getCameraResolution: " + this.mmL + " camera:" + this.mmK + "bestVideoEncodeSize: " + this.mmS);
        parameters.setPreviewSize(this.mmK.x, this.mmK.y);
        parameters.setZoom(0);
        parameters.setSceneMode("auto");
        try {
            List<Integer> supportedPreviewFormats;
            boolean z2;
            if (parameters.getSupportedFocusModes() == null || !parameters.getSupportedFocusModes().contains("auto")) {
                x.i("MicroMsg.FaceScanCamera", "camera not support FOCUS_MODE_AUTO");
                supportedPreviewFormats = parameters.getSupportedPreviewFormats();
                z2 = false;
                for (Integer intValue : supportedPreviewFormats) {
                    i = intValue.intValue();
                    x.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: " + i);
                    if (i == 17) {
                        z = true;
                        break;
                    }
                    if (i != 842094169) {
                        z = true;
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
                z = false;
                if (z) {
                    parameters.setPreviewFormat(17);
                } else if (z2) {
                    x.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", supportedPreviewFormats.get(0));
                    parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
                } else {
                    x.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                    parameters.setPreviewFormat(842094169);
                }
                if (this.mmN) {
                    parameters.setRotation(this.mmO);
                }
                this.gGm.setParameters(parameters);
            }
            x.i("MicroMsg.FaceScanCamera", "set FocusMode to FOCUS_MODE_AUTO");
            parameters.setFocusMode("auto");
            supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            z2 = false;
            while (r6.hasNext()) {
                i = intValue.intValue();
                x.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: " + i);
                if (i == 17) {
                    z = true;
                    break;
                }
                if (i != 842094169) {
                    z = z2;
                } else {
                    z = true;
                }
                z2 = z;
            }
            z = false;
            if (z) {
                parameters.setPreviewFormat(17);
            } else if (z2) {
                x.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", supportedPreviewFormats.get(0));
                parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
            } else {
                x.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                parameters.setPreviewFormat(842094169);
            }
            if (this.mmN) {
                parameters.setRotation(this.mmO);
            }
            this.gGm.setParameters(parameters);
        } catch (Exception e) {
            x.e("MicroMsg.FaceScanCamera", "set focus mode error: %s", e.getMessage());
        }
    }

    public final void release() {
        x.d("MicroMsg.FaceScanCamera", "release(), previewing = [%s]", Boolean.valueOf(this.mmJ));
        if (this.gGm != null) {
            long Wz = bi.Wz();
            if (this.mmJ) {
                this.gGm.setPreviewCallback(null);
                this.gGm.stopPreview();
                this.mmJ = false;
                x.d("MicroMsg.FaceScanCamera", "stopPreview costTime=[%s]", Long.valueOf(bi.bB(Wz)));
            }
            Wz = bi.Wz();
            this.gGm.release();
            this.gGm = null;
            this.mmR = false;
            x.d("MicroMsg.FaceScanCamera", "camera.release() costTime=[%s]", Long.valueOf(bi.bB(Wz)));
        }
        this.mmP = false;
    }

    public final int aHt() {
        x.v("MicroMsg.FaceScanCamera", "hy: preview width: %d", Integer.valueOf(this.mmK.x));
        return this.mmK.x;
    }

    public final int aHu() {
        x.v("MicroMsg.FaceScanCamera", "hy: preview height: %d", Integer.valueOf(this.mmK.y));
        return this.mmK.y;
    }

    private static Point a(Parameters parameters, Point point, boolean z) {
        Size previewSize;
        List<Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        Point point2 = null;
        x.d("MicroMsg.FaceScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y)));
        long eZ = bi.eZ(ad.getContext());
        x.d("MicroMsg.FaceScanCamera", "systemAvailableMemInMB: %d", Long.valueOf(eZ));
        int i = point.x;
        i = point.y;
        float f = Float.POSITIVE_INFINITY;
        for (Size previewSize2 : arrayList) {
            int i2 = previewSize2.width;
            int i3 = previewSize2.height;
            x.i("MicroMsg.FaceScanCamera", "realWidth: %d, realHeight: %d", Integer.valueOf(i2), Integer.valueOf(i3));
            int i4 = i2 * i3;
            if (i4 >= 150400 && i4 <= 983040) {
                Object obj = i2 > i3 ? 1 : null;
                if (obj != null) {
                    i = i3;
                } else {
                    i = i2;
                }
                if (obj != null) {
                    i4 = i2;
                } else {
                    i4 = i3;
                }
                x.d("MicroMsg.FaceScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", Integer.valueOf(i), Integer.valueOf(i4));
                if (i == point.x && i4 == point.y && e(i, i4, eZ)) {
                    point2 = new Point(i2, i3);
                    x.i("MicroMsg.FaceScanCamera", "Found preview size exactly matching screen size: " + point2);
                    return point2;
                }
                float f2;
                Point point3;
                float abs = Math.abs((((float) i) / ((float) i4)) - r8);
                if (abs >= f || !e(i2, i3, eZ)) {
                    f2 = f;
                    point3 = point2;
                } else {
                    point3 = new Point(i2, i3);
                    f2 = abs;
                }
                x.i("MicroMsg.FaceScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i2), Integer.valueOf(i3));
                point2 = point3;
                f = f2;
            }
        }
        if (point2 == null) {
            previewSize2 = parameters.getPreviewSize();
            if (previewSize2 != null) {
                point2 = new Point(previewSize2.width, previewSize2.height);
                x.i("MicroMsg.FaceScanCamera", "No suitable preview sizes, using default: " + point2);
            } else {
                x.e("MicroMsg.FaceScanCamera", "hy: can not find default size!!");
            }
        }
        x.i("MicroMsg.FaceScanCamera", "Found best approximate preview size: " + point2);
        return point2;
    }

    private static boolean e(int i, int i2, long j) {
        x.d("MicroMsg.FaceScanCamera", "dataSizeInMB: %f, availableMemInMb: %d", Double.valueOf(((((((double) i) * ((double) i2)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d), Long.valueOf(j));
        if (((double) j) / (((((((double) i) * ((double) i2)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d) >= 5.0d) {
            return true;
        }
        return false;
    }

    public final void setPreviewCallback(final PreviewCallback previewCallback) {
        if (this.gGm == null) {
            x.w("MicroMsg.FaceScanCamera", "hy: camera is null. setPreviewCallback failed");
            return;
        }
        this.gGm.addCallbackBuffer(c.mlG.h(Integer.valueOf(((aHt() * aHu()) * ImageFormat.getBitsPerPixel(this.gGm.getParameters().getPreviewFormat())) / 8)));
        this.gGm.setPreviewCallbackWithBuffer(new PreviewCallback() {
            public final void onPreviewFrame(byte[] bArr, Camera camera) {
                if (previewCallback != null) {
                    previewCallback.onPreviewFrame(bArr, camera);
                }
                camera.addCallbackBuffer(bArr);
            }
        });
    }
}
