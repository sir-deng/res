package com.tencent.mm.compatible.e;

import android.hardware.Camera;
import com.tencent.mm.compatible.e.d.a;

final class e implements a {
    e() {
    }

    public static a.a yt() {
        a.a aVar = new a.a();
        try {
            aVar.gGm = Camera.open();
            aVar.fGt = 0;
            if (aVar.gGm == null) {
                return null;
            }
            return aVar;
        } catch (Exception e) {
            return null;
        }
    }
}
