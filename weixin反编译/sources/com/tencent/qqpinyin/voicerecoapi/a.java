package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

public final class a {
    public static int MAX_FRAME_SIZE = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
    public int Aaa = 0;
    public TRSpeexNative Aab = new TRSpeexNative();
    private byte[] zZX = null;
    public byte[] zZY = null;
    private int zZZ = 0;

    public final int cDS() {
        if (this.zZZ != 0) {
            return -103;
        }
        int nativeTRSpeexInit = this.Aab.nativeTRSpeexInit();
        if (nativeTRSpeexInit == -1) {
            return nativeTRSpeexInit;
        }
        this.zZZ = nativeTRSpeexInit;
        this.zZX = new byte[(MAX_FRAME_SIZE * 10)];
        return 0;
    }

    public final byte[] S(byte[] bArr, int i) {
        if (this.zZZ == 0) {
            throw new b(-102);
        } else if (bArr == null || bArr.length == 0) {
            throw new b(-104);
        } else {
            int nativeTRSpeexEncode = this.Aab.nativeTRSpeexEncode(this.zZZ, bArr, 0, i, this.zZX);
            if (nativeTRSpeexEncode < 0) {
                throw new b(nativeTRSpeexEncode);
            } else if (nativeTRSpeexEncode == 0) {
                return null;
            } else {
                byte[] bArr2 = new byte[nativeTRSpeexEncode];
                System.arraycopy(this.zZX, 0, bArr2, 0, nativeTRSpeexEncode);
                return bArr2;
            }
        }
    }

    public final int cDT() {
        if (this.zZZ == 0) {
            return -102;
        }
        this.zZX = null;
        int nativeTRSpeexRelease = this.Aab.nativeTRSpeexRelease(this.zZZ);
        this.zZZ = 0;
        return nativeTRSpeexRelease;
    }
}
