package com.tencent.mm.ap.a.d;

import android.graphics.Bitmap;

public final class b {
    public String aBD;
    public Bitmap bitmap;
    public byte[] data;
    public int fqZ;
    public int status;

    public b() {
        this.status = -1;
    }

    public b(Bitmap bitmap) {
        this.status = 0;
        this.fqZ = 0;
        this.bitmap = bitmap;
    }

    public b(byte[] bArr, String str) {
        this.data = bArr;
        this.aBD = str;
    }

    public b(byte[] bArr, String str, byte b) {
        this.data = bArr;
        this.fqZ = 2;
        this.aBD = str;
    }
}
