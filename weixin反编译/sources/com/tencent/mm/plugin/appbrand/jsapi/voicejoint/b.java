package com.tencent.mm.plugin.appbrand.jsapi.voicejoint;

import com.tencent.mm.audio.voicejoint.VoiceSplitJointNative;
import com.tencent.mm.audio.voicejoint.model.VoiceJointResult;
import com.tencent.mm.audio.voicejoint.model.VoiceSplitResult;
import com.tencent.mm.audio.voicejoint.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload.e;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class b {
    private static boolean fmE = false;
    private static VoiceSplitJointNative jyP = null;
    private static VoiceSplitJointNative jyQ = null;
    private static boolean jyR = false;
    private static boolean jyS = false;
    private static boolean jyT = false;
    private static e jyU = new e();
    private static f jyV = new f();

    public static void init(final boolean z) {
        x.i("MicroMsg.VoiceSplitJointManager", "alvinluo VoiceSplitJointManager init");
        if (jyU != null) {
            a.xmy.a(jyU);
        }
        if (jyV != null) {
            a.xmy.a(jyV);
        }
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.VoiceSplitJointManager", "alvinluo init isUpgrade: %b", Boolean.valueOf(z));
                if (z) {
                    x.i("MicroMsg.VoiceSplitJointManager", "alvinluo upgrade and delete old model");
                    com.tencent.mm.loader.stub.b.deleteFile(com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.la(100));
                    com.tencent.mm.loader.stub.b.deleteFile(com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.la(101));
                }
                com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.aic();
                String la = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.la(100);
                x.i("MicroMsg.VoiceSplitJointManager", "alvinluo voiceSplitModel: %s, exist: %b, isForceUpdate: %b", la, Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.e.a.bO(la)), Boolean.valueOf(b.jyT));
                if (!com.tencent.mm.pluginsdk.i.a.e.a.bO(la) || b.jyT) {
                    com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.m(ad.getContext(), "voicesplitmodel.bin", la);
                }
                la = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.la(101);
                x.i("MicroMsg.VoiceSplitJointManager", "alvinluo voiceBlackModel: %s, exist: %b, isForceUpdate: %b", la, Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.e.a.bO(la)), Boolean.valueOf(b.jyT));
                if (!com.tencent.mm.pluginsdk.i.a.e.a.bO(la) || b.jyT) {
                    com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.m(ad.getContext(), "voiceblackmodel.bin", la);
                }
                VoiceSplitJointNative.loadLibrary();
            }
        }, "VoiceSplitJointInitModel");
    }

    public static void release() {
        x.i("MicroMsg.VoiceSplitJointManager", "alvinluo VoiceSplitJointManager release");
        if (jyU != null) {
            a.xmy.c(jyU);
        }
        if (jyV != null) {
            a.xmy.c(jyV);
        }
    }

    public static int M(int i, String str) {
        try {
            File file = new File(str);
            String parent = file.getParent();
            if (!parent.endsWith("/")) {
                parent = parent + "/";
            }
            String name = file.getName();
            x.i("MicroMsg.VoiceSplitJointManager", "alvinluo initModel modelType: %d, resPath: %s, model file name: %s", Integer.valueOf(i), parent, name);
            if (i == 100) {
                return bt(parent, name);
            }
            if (i == 101) {
                return bu(parent, name);
            }
            return -1;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoiceSplitJointManager", e, "alvinluo initModel exception", new Object[0]);
        }
    }

    public static int N(int i, String str) {
        VoiceSplitJointNative voiceSplitJointNative = new VoiceSplitJointNative();
        File file = new File(str);
        if (file.exists()) {
            boolean z;
            String parent = file.getParent();
            if (!parent.endsWith("/")) {
                parent = parent + "/";
            }
            x.i("MicroMsg.VoiceSplitJointManager", "alvinluo checkInitModel resPath: %s, model file name: %s", parent, file.getName());
            int init = voiceSplitJointNative.init(parent, r3, "");
            x.i("MicroMsg.VoiceSplitJointManager", "alvinluo checkInitModel result: %d", Integer.valueOf(init));
            if (init == 0) {
                if (voiceSplitJointNative.getVersion().length == 2) {
                    x.i("MicroMsg.VoiceSplitJointManager", "alvinluo checkInitModel modelType: %d, version: %d, %d", Integer.valueOf(i), Integer.valueOf(voiceSplitJointNative.getVersion()[0]), Integer.valueOf(voiceSplitJointNative.getVersion()[1]));
                }
                kO(i);
            } else {
                x.e("MicroMsg.VoiceSplitJointManager", "alvinluo init split model failed");
            }
            if (str.equalsIgnoreCase(com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.la(i))) {
                z = false;
            } else {
                z = true;
            }
            int i2 = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
            com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.x(init, z);
            return init;
        }
        x.e("MicroMsg.VoiceSplitJointManager", "alvinluo checkInitModel modelPath file not exist");
        return -1;
    }

    private static int bt(String str, String str2) {
        boolean z = true;
        if (!fmE || jyP == null) {
            try {
                VoiceSplitJointNative voiceSplitJointNative = new VoiceSplitJointNative();
                jyP = voiceSplitJointNative;
                int init = voiceSplitJointNative.init(str, str2, "");
                x.i("MicroMsg.VoiceSplitJointManager", "alvinluo initSplitModel result: %d", Integer.valueOf(init));
                if (init == 0) {
                    fmE = true;
                    if (jyP != null) {
                        int[] version = jyP.getVersion();
                        if (version != null && version.length >= 2) {
                            x.i("MicroMsg.VoiceSplitJointManager", "alvinluo sdkVersion: %d, binVersion: %d", Integer.valueOf(version[0]), Integer.valueOf(version[1]));
                        }
                    }
                }
                if (str2.equalsIgnoreCase("voicesplitmodel.bin")) {
                    z = false;
                }
                int i = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
                com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.x(init, z);
                return init;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoiceSplitJointManager", e, "alvinluo initSplitWithModelPath exception", new Object[0]);
                return -1;
            }
        }
        x.e("MicroMsg.VoiceSplitJointManager", "alvinluo init hasInited splitModel and return error");
        return -1;
    }

    private static int bu(String str, String str2) {
        boolean z = true;
        if (!jyR || jyQ == null) {
            try {
                VoiceSplitJointNative voiceSplitJointNative = new VoiceSplitJointNative();
                jyQ = voiceSplitJointNative;
                int initCheckBlack = voiceSplitJointNative.initCheckBlack(str, str2, "");
                x.i("MicroMsg.VoiceSplitJointManager", "alvinluo initBlackModel result: %d", Integer.valueOf(initCheckBlack));
                if (initCheckBlack == 0) {
                    jyR = true;
                }
                if (str2.equalsIgnoreCase("voiceblackmodel.bin")) {
                    z = false;
                }
                int i = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
                com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.x(initCheckBlack, z);
                return initCheckBlack;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoiceSplitJointManager", e, "alvinluo initBlackWithModelPath exception", new Object[0]);
                return -1;
            }
        }
        x.e("MicroMsg.VoiceSplitJointManager", "alvinluo init hasInited blackModel and return error");
        return -1;
    }

    public static void kO(int i) {
        if (i == 100) {
            if (jyP != null && fmE) {
                jyP.release();
                jyP = null;
                fmE = false;
            }
        } else if (i == 101 && jyQ != null && jyR) {
            jyQ.releaseCheckBlack();
            jyQ = null;
            jyR = false;
        }
    }

    public static VoiceJointResult a(c cVar, VoiceSplitResult voiceSplitResult) {
        byte[] d = FileOp.d(cVar.fmJ, 0, -1);
        byte[] d2 = FileOp.d(cVar.fmI, 0, -1);
        int i;
        if (d == null) {
            x.e("MicroMsg.VoiceSplitJointManager", "alvinluo jointVoice userOriginPcm is null");
            i = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
            com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.bL(cVar.starId, -106);
            i = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
            com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.kP(-106);
            return new VoiceJointResult(8004, "user origin pcm is null");
        } else if (d2 == null) {
            x.e("MicroMsg.VoiceSplitJointManager", "alvinluo jointVoice starPcm is null");
            i = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
            com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.bL(cVar.starId, -108);
            i = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
            com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.kP(-108);
            return new VoiceJointResult(8004, "star pcm is null");
        } else {
            VoiceSplitResult voiceSplitResult2;
            if (jyP == null || d == null || cVar == null) {
                voiceSplitResult2 = new VoiceSplitResult(-103);
            } else {
                voiceSplitResult2 = jyP.splitVoice(cVar.fmH, d, d.length);
                if (voiceSplitResult2 != null && voiceSplitResult2.isSuccess()) {
                    voiceSplitResult2.checkAdjustResult(cVar);
                }
            }
            if (!(voiceSplitResult2 == null || voiceSplitResult2.isSuccess())) {
                x.i("MicroMsg.VoiceSplitJointManager", "alvinluo splitResult resultCode: %d", Integer.valueOf(voiceSplitResult2.splitResultCode));
                i = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
                com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.bL(cVar.starId, voiceSplitResult2.splitResultCode);
                i = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
                com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.kP(voiceSplitResult2.splitResultCode);
            }
            if (voiceSplitResult2 == null || !voiceSplitResult2.isSuccess() || voiceSplitResult == null) {
                x.e("MicroMsg.VoiceSplitJointManager", "alvinluo splitResult invalid");
                return new VoiceJointResult(8004, "split failed");
            }
            byte[] d3 = FileOp.d(cVar.fmK, 0, -1);
            if (d3 == null) {
                x.e("MicroMsg.VoiceSplitJointManager", "alvinluo jointVoice user denoise pcm is null");
                i = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
                com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.bL(cVar.starId, -107);
                i = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
                com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.kP(-107);
                return new VoiceJointResult(8005, "user denoise pcm is null");
            }
            VoiceJointResult jointVoice;
            if (jyP != null) {
                x.i("MicroMsg.VoiceSplitJointManager", "alvinluo jointVoice");
                jointVoice = jyP.jointVoice(cVar, voiceSplitResult2, voiceSplitResult, d3, d2);
            } else {
                jointVoice = null;
            }
            if (jointVoice == null || !jointVoice.isSuccess()) {
                i = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
                com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.bL(cVar.starId, -200);
                i = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
                com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.kQ(-200);
                return new VoiceJointResult(8005, "joint failed");
            }
            voiceSplitResult2.userOriginPcmFilePath = cVar.fmJ;
            jointVoice.jointErrCode = 0;
            jointVoice.jointErrMsg = "ok";
            jointVoice.userSplitResult = voiceSplitResult2;
            jointVoice.starId = cVar.starId;
            int i2 = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
            com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.bL(cVar.starId, 1);
            i2 = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.jzB;
            com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f.kQ(1);
            return jointVoice;
        }
    }

    public static int checkBlack(byte[] bArr, int i) {
        if (jyQ != null) {
            return jyQ.checkBlack(bArr, i);
        }
        return -1;
    }
}
