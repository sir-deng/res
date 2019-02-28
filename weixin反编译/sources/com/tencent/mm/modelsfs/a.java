package com.tencent.mm.modelsfs;

import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static boolean hNJ = false;
    private long hNK = 0;
    private String hNL;
    private long hNM = 0;
    private long mNativePtr = 0;

    public a(long j) {
        this.hNL = String.valueOf(j);
        init();
    }

    public a(String str) {
        this.hNL = str;
        init();
    }

    private void init() {
        x.i("MicroMsg.EncEngine", "init  key  enckey " + this.hNL + "  hashcode " + hashCode());
        this.mNativePtr = MMIMAGEENCJNI.open(this.hNL);
        try {
            x.i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
        } catch (Exception e) {
            x.e("MicroMsg.EncEngine", "exception " + e.getMessage());
        }
    }

    public final void reset() {
        x.i("MicroMsg.EncEngine", "reset " + bi.chl());
        free();
        if (this.hNM == 0) {
            init();
            this.hNK = 0;
            return;
        }
        init();
        MMIMAGEENCJNI.seek(this.mNativePtr, this.hNM, 1);
        this.hNK = this.hNM;
    }

    public final long RB() {
        this.hNM = this.hNK;
        return this.hNM;
    }

    public final int w(byte[] bArr, int i) {
        if (this.mNativePtr == 0) {
            x.i("MicroMsg.EncEngine", "transFor " + bi.chl().toString());
        }
        if (hNJ) {
            x.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + bArr.length);
        }
        if (hNJ && this.hNK < 64) {
            x.d("MicroMsg.EncEngine", "dump before _offset " + this.hNK + "  length:" + i + " " + bi.bx(bArr) + " hashcode " + hashCode());
        }
        MMIMAGEENCJNI.transFor(this.mNativePtr, bArr, this.hNK, (long) i);
        if (hNJ && this.hNK < 64) {
            x.d("MicroMsg.EncEngine", "dump after _offset " + this.hNK + "  length:" + i + " " + bi.bx(bArr) + " hashcode " + hashCode());
        }
        this.hNK += (long) i;
        return i;
    }

    public final void seek(long j) {
        this.hNK = j;
        MMIMAGEENCJNI.seek(this.mNativePtr, j, 1);
    }

    public final void free() {
        x.i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
        MMIMAGEENCJNI.free(this.mNativePtr);
        this.mNativePtr = 0;
    }
}
