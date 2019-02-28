package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.mm.protocal.c.alr;
import com.tencent.mm.protocal.c.als;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d {
    private File mWD;
    List<RandomAccessFile> mWE;
    SparseArray<als> mWF;
    int mWG;
    boolean mvv = true;

    d(File file) {
        if (!file.isDirectory()) {
            boolean mkdirs = file.mkdirs();
            x.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", file.getAbsolutePath(), Boolean.valueOf(mkdirs));
        }
        this.mWD = file;
        this.mWF = new SparseArray();
    }

    final void aOt() {
        File file = new File(this.mWD, "cache.idx");
        alr alr = new alr();
        String absolutePath = file.getAbsolutePath();
        if (!bi.oN(absolutePath)) {
            try {
                alr.aH(bi.readFromFile(absolutePath));
            } catch (Throwable e) {
                x.e("MicroMsg.DiskCache", "load index file error");
                x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                qC(-1);
                alr = new alr();
            } catch (Throwable e2) {
                x.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", Long.valueOf(file.length()));
                x.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
                qC(-1);
                alr = new alr();
            }
        }
        this.mWF.clear();
        Iterator it = alr.wzD.iterator();
        while (it.hasNext()) {
            als als = (als) it.next();
            this.mWF.put(als.key, als);
        }
    }

    final synchronized void qB(int i) {
        synchronized (this) {
            if (i >= 0) {
                try {
                    if (this.mWE != null) {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mWD, qE(i)), "rw");
                        this.mWE.remove(i);
                        this.mWE.add(i, randomAccessFile);
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.DiskCache", "create data file error: %s", e.getMessage());
                    x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                    this.mWE = null;
                }
            }
            this.mWE = new ArrayList();
            for (int i2 = 0; i2 < 25; i2++) {
                this.mWE.add(new RandomAccessFile(new File(this.mWD, qE(i2)), "rw"));
            }
        }
        return;
    }

    final void qC(int i) {
        int i2 = 0;
        if (this.mWE != null && this.mWE.size() > 0) {
            if (i < 0) {
                new File(this.mWD, "cache.idx").delete();
                this.mWF.clear();
            } else {
                SparseArray sparseArray = new SparseArray();
                for (int i3 = 0; i3 < this.mWF.size(); i3++) {
                    als als = (als) this.mWF.valueAt(i3);
                    if (als.wzF != i) {
                        sparseArray.put(this.mWF.keyAt(i3), als);
                    }
                    x.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", Integer.valueOf(als.key), Long.valueOf(als.wzE), Integer.valueOf(als.length));
                }
                this.mWF = sparseArray;
                aOu();
            }
            if (i < 0) {
                aOv();
                while (i2 < 25) {
                    new File(this.mWD, qE(25)).delete();
                    i2++;
                }
                return;
            }
            f((Closeable) this.mWE.get(i));
            new File(this.mWD, qE(i)).delete();
        }
    }

    static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                x.e("MicroMsg.DiskCache", "want close %s fail: %s", closeable.getClass().getName(), e.getMessage());
                x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
            }
        }
    }

    final void aOu() {
        alr alr = new alr();
        for (int i = 0; i < this.mWF.size(); i++) {
            alr.wzD.add(0, (als) this.mWF.valueAt(i));
            x.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", Integer.valueOf(r0.key), Long.valueOf(r0.wzE), Integer.valueOf(r0.length), Integer.valueOf(r0.wzF));
        }
        try {
            bi.q(new File(this.mWD, "cache.idx").getAbsolutePath(), alr.toByteArray());
        } catch (Throwable e) {
            x.e("MicroMsg.DiskCache", "save index data error: %s", e.getMessage());
            x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
        }
    }

    final synchronized void aOv() {
        if (this.mWE != null && this.mWE.size() > 0) {
            for (RandomAccessFile f : this.mWE) {
                f(f);
            }
        }
    }

    public final Bitmap qD(int i) {
        if (this.mWE == null || this.mWE.size() <= 0) {
            x.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
            return null;
        }
        als als = (als) this.mWF.get(i);
        if (als == null) {
            return null;
        }
        byte[] bArr = new byte[als.length];
        try {
            x.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", Long.valueOf(als.wzE), Integer.valueOf(als.length));
            RandomAccessFile randomAccessFile = (RandomAccessFile) this.mWE.get(als.wzF);
            randomAccessFile.seek(als.wzE);
            randomAccessFile.read(bArr, 0, als.length);
            Bitmap bn = com.tencent.mm.sdk.platformtools.d.bn(bArr);
            if (bn != null) {
                x.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", Integer.valueOf(bn.getWidth()), Integer.valueOf(bn.getHeight()));
                return bn;
            }
            this.mWF.remove(i);
            return bn;
        } catch (Throwable e) {
            x.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", Integer.valueOf(i), e.getMessage());
            x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
            this.mWF.remove(i);
            return null;
        }
    }

    private static String qE(int i) {
        return "cache.data" + (i == 0 ? "" : "." + i);
    }

    public final synchronized int aOw() {
        int i = 0;
        synchronized (this) {
            if (this.mWE != null && this.mWE.size() > 0) {
                try {
                    int i2 = -1;
                    for (RandomAccessFile length : this.mWE) {
                        i2++;
                        if (length.length() < 2097152) {
                            i = i2;
                            break;
                        }
                    }
                    i = -1;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                    i = -1;
                }
            }
        }
        return i;
    }

    public final void aOx() {
        ad.getContext().getSharedPreferences(ad.cgf(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", this.mWG).commit();
    }
}
