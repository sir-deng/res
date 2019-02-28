package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.x;

public final class i {
    public static g sAV;
    public static int sAW = -1;
    public static int sAX = -1;
    public static int sAY = 0;
    public static int sAZ = 0;
    public static int sBa = 0;
    public static boolean sBb = true;

    public static boolean bJs() {
        if (q.gHF.gFE && q.gHF.gFD == 8) {
            return false;
        }
        return true;
    }

    private static boolean bJt() {
        try {
            if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) != null) {
                return true;
            }
            x.d("GetfcMethod", "GetfcMethod is null");
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.CameraUtil", "find getNumberOfCameras failed: " + e.getMessage());
            return false;
        }
    }

    public static void dI(Context context) {
        if (sAV == null) {
            sAV = new g("*");
            boolean bJt = bJt();
            sBb = bJt;
            if (!bJt || q.gHF.gFC) {
                if (sBb && q.gHF.gFC) {
                    bJu();
                }
                if (q.gHF.gFC) {
                    sAV.gFB = q.gHF.gFB;
                }
                if (q.gHF.gFJ) {
                    if (q.gHF.gFI.gGi != 0) {
                        sAV.szE = true;
                    } else {
                        sAV.szE = false;
                    }
                }
                if (q.gHF.gFH) {
                    if (q.gHF.gFG.gGi != 0) {
                        sAV.szD = true;
                    } else {
                        sAV.szD = false;
                    }
                }
                if (q.gHF.gFH && q.gHF.gFG.gGj >= 0) {
                    sAV.szF = q.gHF.gFG.gGj;
                    sAY = sAV.szF;
                }
                if (q.gHF.gFJ && q.gHF.gFI.gGj >= 0) {
                    sAV.szG = q.gHF.gFI.gGj;
                    sAZ = sAV.szG;
                }
                if (q.gHF.gFH) {
                    if (sAV.szH == null) {
                        sAV.szH = new Point(0, 0);
                    }
                    sAV.szH = new Point(q.gHF.gFG.width, q.gHF.gFG.height);
                }
                if (q.gHF.gFJ) {
                    if (sAV.szI == null) {
                        sAV.szI = new Point(0, 0);
                    }
                    sAV.szI = new Point(q.gHF.gFI.width, q.gHF.gFI.height);
                }
                if (q.gHF.gFJ && q.gHF.gFI.fps != 0) {
                    sAV.szC = q.gHF.gFI.fps;
                }
                if (q.gHF.gFH && q.gHF.gFG.fps != 0) {
                    sAV.szC = q.gHF.gFG.fps;
                }
                PackageManager packageManager = context.getPackageManager();
                if (!(q.gHF.gFC || packageManager.hasSystemFeature("android.hardware.camera"))) {
                    sAV.gFB = 0;
                    sAV.szD = false;
                    sAV.szE = false;
                }
            } else {
                bJu();
            }
            if (q.gHF.ana) {
                sBa = q.gHF.gFF;
            }
            x.i("MicroMsg.CameraUtil", "gCameraNum:" + sAV.gFB + "\ngIsHasFrontCamera:" + sAV.szD + "\ngIsHasBackCamera:" + sAV.szE + "\ngFrontCameraId:" + sAW + "\ngBackCameraId:" + sAX + "\ngBackOrientation:" + sAV.szG + "\ngFrontOrientation:" + sAV.szF + "\ngBestFps:" + sAV.szC + "\ngFacePreviewSize:" + sAV.szH + "\ngNonFacePreviewSize:" + sAV.szI + "\ngFaceCameraIsRotate180:" + sAY + "\ngMainCameraIsRotate180:" + sAZ + "\ngCameraFormat:" + sBa + "\ngFaceNotRotate:SDK:" + VERSION.SDK_INT + "\n");
        }
    }

    private static void bJu() {
        sAV.gFB = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (i < sAV.gFB) {
            try {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 1) {
                    sAW = i;
                    sAV.szF = cameraInfo.orientation;
                    sAV.szD = true;
                } else if (cameraInfo.facing == 0) {
                    sAX = i;
                    sAV.szG = cameraInfo.orientation;
                    sAV.szE = true;
                }
                i++;
            } catch (Exception e) {
                x.e("MicroMsg.CameraUtil", "get camera info error: %s", e.getMessage());
            }
        }
        String property = System.getProperty("ro.media.enc.camera.platform", null);
        boolean equalsIgnoreCase = property == null ? false : property.equalsIgnoreCase("Mediatek");
        if (sAV.szF == 270 || (equalsIgnoreCase && sAV.szF == 0)) {
            sAY = 1;
        } else {
            sAY = 0;
        }
        if (sAV.szG == 270 || (equalsIgnoreCase && sAV.szG == 0)) {
            sAZ = 1;
        } else {
            sAZ = 0;
        }
    }
}
