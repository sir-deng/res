package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public enum f {
    ;
    
    private static ah mlU;
    public FaceDetectProcessService mlT;

    private f(String str) {
        this.mlT = null;
    }

    static {
        mlU = new ah("face_process");
    }

    public static void w(Runnable runnable) {
        mlU.F(runnable);
    }

    public static void aHh() {
        mlU.cgs().removeCallbacksAndMessages(null);
    }

    public static ag aHi() {
        return mlU.cgs();
    }

    public final boolean eX(boolean z) {
        x.i("MicroMsg.FaceDetectManager", "alvinluo: face detect isCheckDynCfg: %b", Boolean.valueOf(z));
        boolean aHj = aHj();
        boolean aHv = o.aHv();
        if (z) {
            x.i("MicroMsg.FaceDetectManager", "hy: face config support: %b, hardware support: %b, isModelFileValid: %b", Boolean.valueOf(bi.getInt(((a) g.h(a.class)).Af().getValue("BioSigFaceEntry"), 0) == 1), Boolean.valueOf(aHj), Boolean.valueOf(aHv));
            if (!(bi.getInt(((a) g.h(a.class)).Af().getValue("BioSigFaceEntry"), 0) == 1) || (aHj & aHv) == 0) {
                return false;
            }
            return true;
        }
        x.i("MicroMsg.FaceDetectManager", "hy: hardware support: %b, isModelFileValid: %b", Boolean.valueOf(aHj), Boolean.valueOf(aHv));
        if (aHv && aHj) {
            return true;
        }
        return false;
    }

    public static boolean aHj() {
        return ad.getContext().getPackageManager().hasSystemFeature("android.hardware.camera.front");
    }

    public static boolean aHk() {
        return o.aHv();
    }

    public final int aHl() {
        g gVar = this.mlT.mnX;
        if (gVar.mlW != null) {
            return gVar.mlW.engineReleaseCurrMotion();
        }
        x.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
        return -3;
    }

    public final int aHm() {
        g gVar = this.mlT.mnX;
        if (gVar.mlW != null) {
            return gVar.mlW.engineGetCurrMotion();
        }
        x.e("MicroMsg.FaceDetectNativeManager", "hy: getCurrentMotion not init");
        return -1;
    }

    public static int aHn() {
        return FaceProNative.engineVersion();
    }
}
