package com.tencent.mm.compatible.e;

import android.hardware.Camera;
import android.os.Build;
import com.tencent.mm.compatible.e.d.a;
import com.tencent.mm.sdk.platformtools.bi;

final class j implements a {
    j() {
    }

    public static a.a yt() {
        a.a aVar = new a.a();
        try {
            aVar.gGm = Camera.open();
            aVar.fGt = 0;
            if (aVar.gGm == null) {
                return null;
            }
            if (Build.DISPLAY.startsWith("Flyme")) {
                aVar.fGt = 90;
                aVar.gGm.setDisplayOrientation(90);
            } else {
                int i;
                if (Build.MODEL.equals("M9")) {
                    String str = Build.DISPLAY;
                    if (str.substring(0, 0).equals("1")) {
                        i = -1;
                    } else {
                        String[] split = str.split("-");
                        i = (split == null || split.length < 2) ? -1 : bi.getInt(split[1], 0);
                    }
                } else {
                    i = -1;
                }
                if (i >= 7093) {
                    aVar.fGt = 90;
                    aVar.gGm.setDisplayOrientation(180);
                }
            }
            return aVar;
        } catch (Exception e) {
            return null;
        }
    }
}
