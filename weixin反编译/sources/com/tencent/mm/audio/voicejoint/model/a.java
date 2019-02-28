package com.tencent.mm.audio.voicejoint.model;

import com.tencent.mm.audio.voicejoint.VoiceSplitJointNative;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static VoiceSplitJointNative fmD = null;
    private static boolean fmE = false;

    public static int initDenoise() {
        if (!fmE) {
            fmD = new VoiceSplitJointNative();
        }
        if (fmD == null) {
            return -1;
        }
        int initDenoise = fmD.initDenoise();
        x.i("MicroMsg.VoiceDenoiseHandler", "alvinluo denoise init result: %d", Integer.valueOf(initDenoise));
        if (initDenoise != 0) {
            fmE = false;
            return initDenoise;
        }
        fmE = true;
        return initDenoise;
    }

    public static int releaseDenoise() {
        if (!fmE || fmD == null) {
            return 0;
        }
        int releaseDenoise = fmD.releaseDenoise();
        fmE = false;
        fmD = null;
        return releaseDenoise;
    }

    public static DenoiseResult denoise(byte[] bArr, int i) {
        if (fmE && fmD != null) {
            return fmD.denoise(bArr, i);
        }
        x.e("MicroMsg.VoiceDenoiseHandler", "alvinluo denoise not init");
        return null;
    }
}
