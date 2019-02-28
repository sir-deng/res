package com.tencent.mm.compatible.e;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.tencent.mm.compatible.e.d.a;
import com.tencent.mm.sdk.platformtools.x;

final class i implements a {
    i() {
    }

    public static int getNumberOfCameras() {
        int numberOfCameras;
        if (!q.gHF.gFQ || q.gHF.gFP == -1) {
            numberOfCameras = d.getNumberOfCameras();
            x.d("CameraUtilImplConfig", "getNumberOfCameras " + numberOfCameras);
            return numberOfCameras <= 1 ? 0 : numberOfCameras;
        } else {
            numberOfCameras = q.gHF.gFP;
            x.d("CameraUtilImplConfig", "mVRCameraNum " + numberOfCameras);
            return numberOfCameras;
        }
    }

    public static a.a fH(int i) {
        a.a aVar = new a.a();
        aVar.gGm = null;
        try {
            aVar.gGm = Camera.open(i);
            if (aVar.gGm == null) {
                return null;
            }
            aVar.fGt = 0;
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.hasVRInfo " + q.gHF.gFK);
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceRotate " + q.gHF.gFL);
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + q.gHF.gFM);
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackRotate " + q.gHF.gFN);
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + q.gHF.gFO);
            if (getNumberOfCameras() > 1) {
                try {
                    CameraInfo cameraInfo = new CameraInfo();
                    Camera.getCameraInfo(i, cameraInfo);
                    x.d("CameraUtilImplConfig", "info.facing " + cameraInfo.facing);
                    if (cameraInfo.facing == 1) {
                        if (q.gHF.gFK && q.gHF.gFL != -1) {
                            aVar.fGt = q.gHF.gFL;
                        }
                        if (q.gHF.gFK && q.gHF.gFM != -1) {
                            aVar.gGm.setDisplayOrientation(q.gHF.gFM);
                        }
                    } else {
                        if (q.gHF.gFK && q.gHF.gFN != -1) {
                            aVar.fGt = q.gHF.gFN;
                        }
                        if (q.gHF.gFK && q.gHF.gFO != -1) {
                            aVar.gGm.setDisplayOrientation(q.gHF.gFO);
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("CameraUtilImplConfig", e, "", new Object[0]);
                }
            } else {
                if (q.gHF.gFK && q.gHF.gFN != -1) {
                    aVar.fGt = q.gHF.gFN;
                }
                if (q.gHF.gFK && q.gHF.gFO != -1) {
                    aVar.gGm.setDisplayOrientation(q.gHF.gFO);
                }
            }
            return aVar;
        } catch (Exception e2) {
            return null;
        }
    }
}
