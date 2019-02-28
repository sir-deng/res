package com.tencent.mm.plugin.music.model.b;

import com.tencent.mm.plugin.music.model.f.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private byte[] buffer = new byte[81920];
    public int hX = 0;
    public c oQF;
    public c oQG;
    public f oQH;
    public int oQI = -1;
    public int oQJ = 0;
    public int wn = -1;

    public b(c cVar) {
        this.oQF = cVar;
    }

    public final synchronized boolean tM(int i) {
        boolean z;
        z = this.wn <= i && i <= this.wn + 81920;
        return z;
    }

    public final synchronized boolean tN(int i) {
        boolean z;
        z = this.wn <= i && i <= this.wn + this.hX;
        return z;
    }

    public final synchronized boolean beP() {
        boolean z = false;
        synchronized (this) {
            if (this.wn < 0 || this.hX <= 0) {
                x.e("MicroMsg.FileBytesCacheMgr", "flushBufferAll(), mOffset:%d, mSize:%d", Integer.valueOf(this.wn), Integer.valueOf(this.hX));
            } else {
                int[] iArr;
                Object obj = new byte[this.hX];
                System.arraycopy(this.buffer, 0, obj, 0, this.hX);
                this.oQH.c(obj, (long) this.wn, this.hX);
                c cVar = this.oQG;
                int i = this.wn;
                int i2 = this.hX;
                if (i < 0 || i2 < 0 || ((long) i) > cVar.igZ || ((long) (i + i2)) > cVar.igZ) {
                    x.i("MicroMsg.IndexBitMgr", "getWriteBuffIndexRange offset %d, size %d, fileLength %d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(cVar.igZ));
                    x.e("MicroMsg.IndexBitMgr", "getWriteBuffRange invalid parameter!");
                    iArr = null;
                } else {
                    int[] iArr2 = new int[]{-1, -1};
                    int i3 = i + i2;
                    int index = cVar.getIndex(i);
                    int index2 = cVar.getIndex(i3);
                    for (i2 = index; i2 <= index2; i2++) {
                        int i4 = (i2 + 1) * 8192;
                        if (i2 * 8192 >= i && i4 <= i3) {
                            if (iArr2[0] == -1) {
                                iArr2[0] = i2;
                            }
                            if (iArr2[0] > i2) {
                                iArr2[0] = i2;
                            }
                            if (iArr2[1] == -1) {
                                iArr2[1] = i2;
                            }
                            if (iArr2[1] < i2) {
                                iArr2[1] = i2;
                            }
                        }
                    }
                    if (iArr2[0] == -1 && iArr2[1] == -1 && ((long) i3) == cVar.igZ) {
                        x.i("MicroMsg.IndexBitMgr", "write to file end!");
                        iArr2[0] = index;
                        iArr2[1] = index2;
                    }
                    iArr = iArr2;
                }
                if (iArr == null) {
                    x.e("MicroMsg.FileBytesCacheMgr", "flushBufferAll, range is null");
                } else if (iArr[0] == -1 || iArr[1] == -1) {
                    x.d("MicroMsg.FileBytesCacheMgr", "flushBufferAll range[0]:%d, range[1]:%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                } else {
                    int i5;
                    for (i5 = iArr[0]; i5 <= iArr[1]; i5++) {
                        this.oQG.tR(i5);
                    }
                    i5 = iArr[0];
                    if (i5 > 0) {
                        if (!this.oQG.tQ(i5 - 1) && this.oQI + this.oQJ == this.wn && this.hX > 0 && this.oQJ >= 8192) {
                            x.i("MicroMsg.FileBytesCacheMgr", "isCanSavePreviousIndex, save index :%d", Integer.valueOf(i5));
                            z = true;
                        }
                    }
                    if (z) {
                        this.oQG.tR(iArr[0] - 1);
                    }
                    this.oQG.beQ();
                    z = true;
                }
            }
        }
        return z;
    }

    public final synchronized void tO(int i) {
        this.oQI = this.wn;
        this.oQJ = this.hX;
        this.wn = i;
        this.hX = 0;
    }

    public final synchronized void p(byte[] bArr, int i, int i2) {
        int i3 = i - this.wn;
        this.hX = i3 + i2;
        System.arraycopy(bArr, 0, this.buffer, i3, i2);
    }
}
