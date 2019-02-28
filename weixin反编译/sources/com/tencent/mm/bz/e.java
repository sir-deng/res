package com.tencent.mm.bz;

public final class e {
    public static byte[] bB(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 18);
        }
        return bArr;
    }
}
