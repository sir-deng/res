package com.tencent.mm.audio.voicejoint;

import com.tencent.mm.audio.voicejoint.model.DenoiseResult;
import com.tencent.mm.audio.voicejoint.model.VoiceJointResult;
import com.tencent.mm.audio.voicejoint.model.VoiceSplitResult;
import com.tencent.mm.audio.voicejoint.model.c;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class VoiceSplitJointNative {
    private static final String TAG = "MicroMsg.VoiceSplitJointNative";
    private long nativeHandle;

    private native int nativeCheckBlack(byte[] bArr, int i);

    private native DenoiseResult nativeDenoise(byte[] bArr, int i);

    private native int[] nativeGetVersion();

    private native int nativeInit(String str, String str2, String str3);

    private native int nativeInitCheckBlack(String str, String str2, String str3);

    private native int nativeInitDenoise();

    private native VoiceJointResult nativeJointVoice(int i, int[] iArr, int[] iArr2, int[] iArr3, int i2, byte[] bArr, int i3, byte[] bArr2, int i4);

    private native void nativeRelease();

    private native int nativeReleaseCheckBlack();

    private native int nativeReleaseDenoise();

    private native VoiceSplitResult nativeSplitVoice(int i, byte[] bArr, int i2);

    public static void loadLibrary() {
    }

    static {
        k.b("voicesplitjoint", VoiceSplitJointNative.class.getClassLoader());
    }

    public int init(String str, String str2, String str3) {
        int nativeInit = nativeInit(str, str2, str3);
        x.i("alvinluo", "alvinluo after init the nativeHandle is %d", Long.valueOf(this.nativeHandle));
        return nativeInit;
    }

    public int[] getVersion() {
        x.i("alvinluo", "alvinluo getVersion nativeHandle is %d", Long.valueOf(this.nativeHandle));
        return nativeGetVersion();
    }

    public VoiceSplitResult splitVoice(int i, byte[] bArr, int i2) {
        x.i(TAG, "alvinluo splitVoice");
        VoiceSplitResult nativeSplitVoice = nativeSplitVoice(i, bArr, i2);
        if (nativeSplitVoice != null) {
            nativeSplitVoice.starVoiceId = i;
        }
        return nativeSplitVoice;
    }

    public VoiceJointResult jointVoice(c cVar, VoiceSplitResult voiceSplitResult, VoiceSplitResult voiceSplitResult2, byte[] bArr, byte[] bArr2) {
        VoiceJointResult nativeJointVoice = nativeJointVoice(cVar.fmL, voiceSplitResult2.splitResult, voiceSplitResult.splitResult, cVar.fmN, cVar.fmM, bArr2, bArr2.length, bArr, bArr.length);
        if (!(nativeJointVoice == null || nativeJointVoice.keywordStartPosList == null || nativeJointVoice.keywordLengthList == null)) {
            int min = Math.min(nativeJointVoice.keywordStartPosList.length, nativeJointVoice.keywordLengthList.length);
            for (int i = 0; i < min; i++) {
                x.d(TAG, "alvinluo jointVoice result startPos: %d, len: %d", Integer.valueOf(nativeJointVoice.keywordStartPosList[i]), Integer.valueOf(nativeJointVoice.keywordLengthList[i]));
            }
        }
        return nativeJointVoice;
    }

    public void release() {
        nativeRelease();
    }

    public int initCheckBlack(String str, String str2, String str3) {
        return nativeInitCheckBlack(str, str2, str3);
    }

    public int checkBlack(byte[] bArr, int i) {
        return nativeCheckBlack(bArr, i);
    }

    public void releaseCheckBlack() {
        nativeReleaseCheckBlack();
    }

    public int initDenoise() {
        return nativeInitDenoise();
    }

    public int releaseDenoise() {
        return nativeReleaseDenoise();
    }

    public DenoiseResult denoise(byte[] bArr, int i) {
        if (bi.by(bArr)) {
            return null;
        }
        return nativeDenoise(bArr, i);
    }
}
