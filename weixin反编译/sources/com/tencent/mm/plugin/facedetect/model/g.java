package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.xwalk.core.XWalkUpdater;

public final class g {
    public FaceProNative mlW = null;

    public final FaceResult aHo() {
        if (this.mlW == null) {
            x.e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
            return null;
        }
        try {
            long Wz = bi.Wz();
            x.i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", Integer.valueOf(this.mlW.engineReleaseOut().result), Long.valueOf(bi.Wz() - Wz));
            this.mlW = null;
            return this.mlW.engineReleaseOut();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.FaceDetectNativeManager", th, "hy: face lib release crash!!!", new Object[0]);
            this.mlW.engineRelease();
            this.mlW = null;
            return null;
        }
    }

    public final int aHp() {
        String str = "MicroMsg.FaceDetectNativeManager";
        String str2 = "alvinluo cutDown sFaceProNative == null: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.mlW == null);
        x.v(str, str2, objArr);
        if (this.mlW == null) {
            x.e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
            return XWalkUpdater.ERROR_SET_VERNUM;
        }
        x.i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", Integer.valueOf(this.mlW.engineRelease()));
        this.mlW = null;
        return this.mlW.engineRelease();
    }
}
