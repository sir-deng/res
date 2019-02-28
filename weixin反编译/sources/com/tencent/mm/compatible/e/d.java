package com.tencent.mm.compatible.e;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.x;

public final class d {

    public interface a {

        public static class a {
            public int fGt;
            public Camera gGm;
        }
    }

    public static int getNumberOfCameras() {
        if (q.gHF.gFK && q.gHF.gFQ) {
            i iVar = new i();
            return i.getNumberOfCameras();
        }
        g gVar = new g();
        return Camera.getNumberOfCameras();
    }

    public static int yr() {
        if (q.gHP.gGK == 1) {
            return 0;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (i < numberOfCameras) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                x.d("MicroMsg.CameraUtil", "tigercam get bid %d", Integer.valueOf(i));
                break;
            }
            i++;
        }
        i = 0;
        x.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", Integer.valueOf(i));
        return i;
    }

    public static boolean ys() {
        if (q.gHF.gFS == 1) {
            return true;
        }
        if (VERSION.SDK_INT == 10 && Build.MODEL.equals("GT-S5360")) {
            return true;
        }
        return false;
    }

    public static a o(Context context, int i) {
        if (q.gHF.gFS == 1) {
            x.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl20, cameraId = " + i);
            e eVar = new e();
            return e.yt();
        } else if (q.gHF.gFK) {
            x.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImplConfig, cameraId = " + i);
            i iVar = new i();
            return i.fH(i);
        } else if (Build.MODEL.equals("M9")) {
            j jVar = new j();
            return j.yt();
        } else if (getNumberOfCameras() > 1) {
            x.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl23, cameraId = " + i);
            g gVar = new g();
            return g.o(context, i);
        } else {
            f fVar = new f();
            return f.fH(i);
        }
    }
}
