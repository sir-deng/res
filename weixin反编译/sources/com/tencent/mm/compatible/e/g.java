package com.tencent.mm.compatible.e;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.view.WindowManager;
import com.tencent.mm.compatible.e.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g implements a {
    public static a.a o(Context context, int i) {
        a.a aVar = new a.a();
        aVar.gGm = null;
        try {
            long Wz = bi.Wz();
            x.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", Integer.valueOf(i));
            aVar.gGm = Camera.open(i);
            x.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back, use %dms", Long.valueOf(bi.bB(Wz)));
            if (aVar.gGm == null) {
                x.e("MicroMsg.CameraUtil", "open camera error, not exception, but camera null");
                return null;
            }
            int i2;
            CameraInfo cameraInfo = new CameraInfo();
            Wz = bi.Wz();
            x.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", Integer.valueOf(i));
            Camera.getCameraInfo(i, cameraInfo);
            x.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", Long.valueOf(bi.bB(Wz)));
            switch (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()) {
                case 0:
                    i2 = 0;
                    break;
                case 1:
                    i2 = 90;
                    break;
                case 2:
                    i2 = 180;
                    break;
                case 3:
                    i2 = 270;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            if (cameraInfo.facing == 1) {
                i2 = (360 - (cameraInfo.orientation % 360)) % 360;
            } else {
                i2 = ((cameraInfo.orientation - i2) + 360) % 360;
            }
            Wz = bi.Wz();
            x.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", Integer.valueOf(i2));
            aVar.gGm.setDisplayOrientation(i2);
            x.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", Long.valueOf(bi.bB(Wz)));
            aVar.fGt = cameraInfo.orientation;
            return aVar;
        } catch (Throwable e) {
            x.e("MicroMsg.CameraUtil", "open camera error %s", e.getMessage());
            x.printErrStackTrace("MicroMsg.CameraUtil", e, "", new Object[0]);
            return null;
        }
    }
}
