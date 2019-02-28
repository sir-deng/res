package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

public final class h {
    public static h mlZ;
    public int lNI = 0;
    public int[] mlX = null;
    public int mlY = -1;

    public static class a {
        public String ipn;
        public long mma;
        public long mmb;
        public boolean mmc;
        public long mmd;
        public String mme;
        public boolean mmf;
        public boolean mmg;
        public int type;

        public a(int i, String str) {
            this.type = i;
            this.mme = str;
            switch (this.type) {
                case 0:
                    this.mma = 30;
                    this.mmb = 7000;
                    this.ipn = ad.getContext().getString(com.tencent.mm.plugin.facedetect.a.h.mkl);
                    this.mmc = true;
                    this.mmd = 2500;
                    this.mmf = false;
                    this.mmg = false;
                    return;
                case 1:
                    this.mma = 30;
                    this.mmb = 7000;
                    this.ipn = ad.getContext().getString(com.tencent.mm.plugin.facedetect.a.h.mjH);
                    this.mmc = false;
                    this.mmd = -1;
                    this.mmf = true;
                    this.mmg = true;
                    return;
                case 2:
                    this.mma = 30;
                    this.mmb = 7000;
                    this.ipn = ad.getContext().getString(com.tencent.mm.plugin.facedetect.a.h.mjI);
                    this.mmc = false;
                    this.mmd = -1;
                    this.mmf = true;
                    this.mmg = true;
                    return;
                case 3:
                    this.mma = 30;
                    this.mmb = 7000;
                    this.ipn = ad.getContext().getString(com.tencent.mm.plugin.facedetect.a.h.mjG);
                    this.mmc = true;
                    this.mmd = -1;
                    this.mmf = true;
                    this.mmg = true;
                    return;
                case 4:
                    this.mma = 30;
                    this.mmb = 7000;
                    this.ipn = ad.getContext().getString(com.tencent.mm.plugin.facedetect.a.h.mjJ);
                    this.mmc = true;
                    this.mmd = 1000;
                    this.mmf = true;
                    this.mmg = true;
                    return;
                default:
                    x.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
                    this.type = 100;
                    return;
            }
        }

        public final String toString() {
            return "FaceProcessItem{type=" + this.type + ", frameTween=" + this.mma + ", hintTween=" + this.mmb + ", hintStr='" + this.ipn + '\'' + ", isCheckFace=" + this.mmc + ", minSuccTime=" + this.mmd + ", actionData='" + this.mme + '\'' + '}';
        }
    }

    public static a aHq() {
        String str;
        int aHm = f.mlS.aHm();
        g gVar = f.mlS.mlT.mnX;
        if (gVar.mlW == null) {
            x.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
            str = null;
        } else {
            str = gVar.mlW.engineGetCurrMotionData();
        }
        return new a(aHm, str);
    }

    public final String toString() {
        return "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.mlX) + '}';
    }
}
