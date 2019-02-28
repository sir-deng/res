package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;

public final class h extends a {
    private int[] amu;
    long duration;
    long ihB;
    private long ihC;
    private long ihD;
    private long ihE;
    private long ihF;
    private int[] ihG;
    private int[] ihH;
    private int[] ihI;
    private long[] ihJ;
    private int[] ihK;
    private int[] ihL;
    long ihr;
    long[] ihu;
    List<g> ihw = new LinkedList();
    List<Pair> ihx = new LinkedList();

    public h(int i, long j, int i2, long j2) {
        super(i, j, i2, 0);
    }

    public final void c(RandomAccessFile randomAccessFile) {
        byte[] bArr = new byte[8];
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        int read = randomAccessFile.read(bArr);
        while (read >= 8) {
            Object obj6;
            Object obj7;
            Object obj8;
            int y = c.y(bArr, 0);
            int y2 = c.y(bArr, 4);
            long j = 0;
            int i;
            int i2;
            int i3;
            Object obj9;
            if (y2 == a.akz) {
                this.ihB = randomAccessFile.getFilePointer();
                if (c.a(randomAccessFile, 4)) {
                    byte[] bArr2 = new byte[8];
                    if (randomAccessFile.read(bArr2, 0, 4) < 4) {
                        x.w("MicroMsg.StblAtom", "stts read entry count error");
                        j = -1;
                    } else {
                        int y3 = c.y(bArr2, 0);
                        long j2 = ((long) y3) * 8;
                        if (j2 > ((long) (y - 16)) || j2 <= 0) {
                            x.w("MicroMsg.StblAtom", "stts error entryCount : " + y3);
                            j = -1;
                        } else {
                            int i4 = 0;
                            i = 0;
                            this.ihu = new long[(((int) (this.duration / this.ihr)) + 2)];
                            i2 = 1;
                            this.ihu[0] = 1;
                            j = 0;
                            y2 = randomAccessFile.read(bArr2);
                            while (y2 >= 8) {
                                long j3 = ((long) y2) + j;
                                int y4 = c.y(bArr2, 0);
                                int y5 = c.y(bArr2, 4);
                                int i5 = i4;
                                int i6 = i2;
                                i2 = i;
                                i = 0;
                                y3 = i6;
                                while (i < y4) {
                                    g gVar = new g();
                                    gVar.ihz = (long) y5;
                                    this.ihw.add(gVar);
                                    i5 += y5;
                                    i4 = i2 + 1;
                                    while (((long) i5) >= this.ihr && y3 < this.ihu.length) {
                                        i5 = (int) (((long) i5) - this.ihr);
                                        this.ihu[y3] = (long) i4;
                                        y3++;
                                    }
                                    i++;
                                    i2 = i4;
                                }
                                if (j3 >= j2) {
                                    x.d("MicroMsg.StblAtom", "read stts Atom end");
                                    long j4 = j3;
                                    y2 = y3;
                                    i3 = i2;
                                    j = j4;
                                    break;
                                }
                                i4 = i5;
                                i = i2;
                                i2 = y3;
                                j = j3;
                                y2 = randomAccessFile.read(bArr2);
                            }
                            y2 = i2;
                            i3 = i;
                            if (y2 < this.ihu.length) {
                                this.ihu[y2] = (long) i3;
                            }
                            j += 8;
                        }
                    }
                } else {
                    j = -1;
                }
                obj = obj4;
                obj6 = obj3;
                obj7 = obj2;
                obj9 = obj5;
                obj5 = 1;
                obj8 = obj9;
            } else if (y2 == a.akC) {
                j = a(randomAccessFile, y);
                i2 = 1;
                obj7 = obj2;
                obj8 = obj5;
                obj5 = obj;
                obj = obj4;
            } else if (y2 == a.akF) {
                j = b(randomAccessFile, y);
                obj6 = obj3;
                i = 1;
                obj8 = obj5;
                obj5 = obj;
                obj = obj4;
            } else if (y2 == a.akG) {
                j = c(randomAccessFile, y);
                obj6 = obj3;
                i = 1;
                obj8 = obj5;
                obj5 = obj;
                obj = obj4;
            } else if (y2 == a.akD) {
                j = d(randomAccessFile, y);
                obj6 = obj3;
                obj7 = obj2;
                obj9 = obj5;
                obj5 = obj;
                i3 = 1;
                obj8 = obj9;
            } else if (y2 == a.akA) {
                j = e(randomAccessFile, y);
                obj8 = 1;
                obj6 = obj3;
                obj7 = obj2;
                obj5 = obj;
                obj = obj4;
            } else {
                obj8 = obj5;
                obj6 = obj3;
                obj7 = obj2;
                obj5 = obj;
                obj = obj4;
            }
            if (c.a(randomAccessFile, (((long) y) - j) - ((long) read))) {
                if (obj5 != null && obj7 != null && obj6 != null && obj != null && obj8 != null) {
                    x.i("MicroMsg.StblAtom", "read stbl atom finish");
                    break;
                }
                obj4 = obj;
                obj3 = obj6;
                obj2 = obj7;
                read = randomAccessFile.read(bArr);
                obj = obj5;
                obj5 = obj8;
            } else {
                throw new IOException("skip file error.");
            }
        }
        WG();
    }

    private long a(RandomAccessFile randomAccessFile, int i) {
        this.ihC = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[12];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stsc read entry count error");
            return -1;
        }
        int y = c.y(bArr, 0);
        long j = 12 * ((long) y);
        if (j > ((long) (i - 16)) || j <= 0) {
            x.w("MicroMsg.StblAtom", "stsc error entryCount : " + y);
            return -1;
        }
        x.d("MicroMsg.StblAtom", "handle stsc entryCount : " + y);
        this.ihG = new int[y];
        this.ihH = new int[y];
        int i2 = 0;
        long j2 = 0;
        int read = randomAccessFile.read(bArr);
        while (read >= 12) {
            j2 += (long) read;
            this.ihG[i2] = c.y(bArr, 0);
            this.ihH[i2] = c.y(bArr, 4);
            i2++;
            if (j2 >= j) {
                x.d("MicroMsg.StblAtom", "read stsc atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
        }
        return j2 + 8;
    }

    private long b(RandomAccessFile randomAccessFile, int i) {
        this.ihD = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stco read entry count error");
            return -1;
        }
        int y = c.y(bArr, 0);
        long j = 4 * ((long) y);
        if (j <= 0 || j > ((long) (i - 16))) {
            x.w("MicroMsg.StblAtom", "stco error entryCount : " + y);
            return -1;
        }
        this.ihI = new int[(y + 1)];
        int i2 = 1;
        long j2 = 0;
        int read = randomAccessFile.read(bArr);
        while (read >= 4) {
            j2 += (long) read;
            int i3 = i2 + 1;
            this.ihI[i2] = c.y(bArr, 0);
            if (j2 >= j) {
                x.d("MicroMsg.StblAtom", "read stco atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
            i2 = i3;
        }
        return j2 + 8;
    }

    private long c(RandomAccessFile randomAccessFile, int i) {
        this.ihE = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[8];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "co64 read entry count error");
            return -1;
        }
        int y = c.y(bArr, 0);
        long j = ((long) y) * 8;
        if (j <= 0 || j > ((long) (i - 16))) {
            x.w("MicroMsg.StblAtom", "stco error entryCount : " + y);
            return -1;
        }
        this.ihJ = new long[(y + 1)];
        int read = randomAccessFile.read(bArr);
        int i2 = 1;
        long j2 = 0;
        while (read >= 8) {
            j2 += (long) read;
            y = i2 + 1;
            this.ihJ[i2] = c.P(bArr);
            if (j2 >= j) {
                x.d("MicroMsg.StblAtom", "read stco atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
            i2 = y;
        }
        return j2 + 8;
    }

    private long d(RandomAccessFile randomAccessFile, int i) {
        this.ihF = randomAccessFile.getFilePointer();
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stsz read sample size error");
            return -1;
        }
        int y = c.y(bArr, 0);
        if (y > 0) {
            this.amu = new int[1];
            this.amu[0] = y;
            x.i("MicroMsg.StblAtom", "all sample size is the same. size : " + y);
            return 8;
        } else if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stsz read entry count error");
            return -1;
        } else {
            y = c.y(bArr, 0);
            long j = 4 * ((long) y);
            if (j <= 0 || j > ((long) (i - 20))) {
                x.w("MicroMsg.StblAtom", "stco error entryCount : " + y);
                return -1;
            }
            this.amu = new int[(y + 1)];
            int i2 = 1;
            int read = randomAccessFile.read(bArr);
            long j2 = 0;
            while (read >= 4) {
                j2 += (long) read;
                int i3 = i2 + 1;
                this.amu[i2] = c.y(bArr, 0);
                if (j2 >= j) {
                    x.d("MicroMsg.StblAtom", "read stsz atom end");
                    break;
                }
                read = randomAccessFile.read(bArr);
                i2 = i3;
            }
            return j2 + 12;
        }
    }

    private long e(RandomAccessFile randomAccessFile, int i) {
        if (!c.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            x.w("MicroMsg.StblAtom", "stss rread entry count error");
            return -1;
        }
        int y = c.y(bArr, 0);
        long j = 4 * ((long) y);
        if (j <= 0 || j > ((long) (i - 16))) {
            x.w("MicroMsg.StblAtom", "stss error entryCount : " + y);
            return -1;
        }
        this.ihK = new int[y];
        int i2 = 0;
        int read = randomAccessFile.read(bArr);
        long j2 = 0;
        while (read >= 4) {
            j2 += (long) read;
            int i3 = i2 + 1;
            this.ihK[i2] = c.y(bArr, 0);
            if (j2 >= j) {
                x.d("MicroMsg.StblAtom", "read stss atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
            i2 = i3;
        }
        return j2 + 8;
    }

    private boolean WG() {
        int i;
        int i2;
        int i3;
        int i4;
        g gVar;
        long j = 0;
        int length = (this.ihI != null ? this.ihI.length : this.ihJ.length) - 1;
        int length2 = this.ihG.length;
        for (i = 1; i < length2; i++) {
            this.ihG[i - 1] = this.ihG[i] - this.ihG[i - 1];
        }
        this.ihG[length2 - 1] = (length - this.ihG[length2 - 1]) + 1;
        this.ihL = new int[(length + 1)];
        this.ihL[0] = 0;
        i = 1;
        for (i2 = 0; i2 < length2; i2++) {
            i3 = this.ihG[i2];
            i4 = this.ihH[i2];
            for (length = 0; length < i3; length++) {
                this.ihL[i] = this.ihL[i - 1] + i4;
                i++;
            }
        }
        for (i2 = 0; i2 < this.ihu.length; i2++) {
            long j2;
            i3 = (int) this.ihu[i2];
            i4 = jb(i3);
            i = this.ihL[i4 - 1] + 1;
            if (this.amu.length == 1) {
                j2 = ((long) (i3 - i)) * ((long) this.amu[0]);
            } else {
                j2 = 0;
                for (length2 = i; length2 <= i3; length2++) {
                    j2 += (long) this.amu[length2];
                }
            }
            this.ihu[i2] = j2 + jc(i4);
        }
        long j3 = 0;
        length = 0;
        i4 = 1;
        for (g gVar2 : this.ihw) {
            gVar2.size = this.amu[i4];
            i2 = jb(i4);
            if (i2 != length) {
                gVar2.start = jc(i2);
            } else {
                gVar2.start = j3;
            }
            j3 = gVar2.start + ((long) gVar2.size);
            j += gVar2.ihz;
            gVar2.ihz = (long) ((((((float) j) * 1.0f) / ((float) this.ihr)) * 1000.0f) * 1000.0f);
            gVar2.id = i4;
            length = i2;
            i4++;
        }
        for (length = 0; length < this.ihK.length; length++) {
            gVar2 = (g) this.ihw.get(this.ihK[length] - 1);
            gVar2.ihA = 1;
            x.d("MicroMsg.StblAtom", "stss key frame [%s %s]", r2.first, new Pair(Integer.valueOf(this.ihK[length] - 1), Long.valueOf(gVar2.ihz)).second);
            this.ihx.add(r2);
        }
        return true;
    }

    private int jb(int i) {
        for (int i2 = 0; i2 < this.ihL.length; i2++) {
            if (i <= this.ihL[i2]) {
                return i2;
            }
        }
        return 0;
    }

    private long jc(int i) {
        if (this.ihI != null) {
            return (long) this.ihI[i];
        }
        if (this.ihJ != null) {
            return this.ihJ[i];
        }
        return 0;
    }
}
