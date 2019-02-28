package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.List;

public final class f {
    private long duration;
    private String filePath;
    private long hvA;
    private long ihr;
    private long[] ihu;
    public int ihv;
    private List<g> ihw;
    private List<Pair> ihx;
    public int ihy = 0;

    public final int WF() {
        try {
            if (this.ihx == null) {
                return 0;
            }
            if (this.ihy == 0) {
                this.ihy = (int) ((((Long) ((Pair) this.ihx.get(this.ihx.size() - 1)).second).longValue() / 1000) / 1000);
            }
            return this.ihy;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Mp4Parser", e, "get last key frame error.", new Object[0]);
            return 0;
        }
    }

    @TargetApi(5)
    public final boolean b(int i, PInt pInt, PInt pInt2) {
        boolean z;
        Throwable th;
        try {
            if (this.ihx == null) {
                return false;
            }
            boolean z2;
            int size = this.ihx.size();
            long j = 1000 * (((long) i) * 1000);
            pInt2.value = 0;
            pInt.value = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Pair pair = (Pair) this.ihx.get(i2);
                if (((Long) pair.second).longValue() > j) {
                    pInt2.value = (int) ((((Long) pair.second).longValue() / 1000) / 1000);
                    z2 = true;
                    break;
                }
                pInt.value = (int) ((((Long) pair.second).longValue() / 1000) / 1000);
            }
            z2 = false;
            if (z2) {
                z = z2;
            } else {
                try {
                    pInt.value = (int) ((((Long) ((Pair) this.ihx.get(size - 1)).second).longValue() / 1000) / 1000);
                    pInt2.value = i;
                    z = true;
                } catch (Throwable e) {
                    Throwable th2 = e;
                    z = z2;
                    th = th2;
                    x.printErrStackTrace("MicroMsg.Mp4Parser", th, "seekVFrame seekTime[%d]", Integer.valueOf(i));
                    x.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", Integer.valueOf(i), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
                    return z;
                }
            }
            x.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", Integer.valueOf(i), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
            return z;
        } catch (Throwable e2) {
            th = e2;
            z = false;
        }
    }

    public final boolean a(int i, int i2, PInt pInt, PInt pInt2) {
        if (this.ihu == null) {
            return false;
        }
        if (i < 0) {
            i = 0;
        }
        int length = this.ihu.length;
        if (i >= length || i2 >= length) {
            i = length - 2;
            i2 = length - 1;
        }
        long j = this.ihu[i];
        long j2 = this.ihu[i2];
        if (i == 0) {
            pInt.value = 0;
            pInt2.value = (int) j2;
        } else {
            pInt.value = (int) j;
            pInt2.value = ((int) j2) - ((int) j);
        }
        return true;
    }

    public final int bu(int i, int i2) {
        int i3 = 0;
        if (this.ihu == null) {
            return 0;
        }
        long j = (long) (i + i2);
        int i4 = 0;
        while (i3 < this.ihu.length) {
            if (this.ihu[i3] == j) {
                i4 = i3;
                break;
            }
            if (this.ihu[i3] >= j) {
                if (this.ihu[i3] > j) {
                    break;
                }
            } else {
                i4 = i3;
            }
            i3++;
        }
        return i4;
    }

    public final boolean r(String str, long j) {
        Throwable e;
        RandomAccessFile randomAccessFile;
        this.filePath = null;
        this.ihu = null;
        this.ihv = 0;
        this.duration = 0;
        this.ihr = 0;
        this.hvA = 0;
        if (this.ihw != null) {
            this.ihw.clear();
        }
        if (this.ihx != null) {
            this.ihx.clear();
        }
        this.ihy = 0;
        this.filePath = str;
        this.hvA = j;
        File file = new File(this.filePath);
        if (!file.exists()) {
            return false;
        }
        RandomAccessFile randomAccessFile2;
        try {
            byte[] bArr = new byte[8];
            randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                a a = a(randomAccessFile2, bArr, this.hvA);
                while (a != null) {
                    x.d("MicroMsg.Mp4Parser", "last trak atom file pos : " + a.igW);
                    e b = i.b(randomAccessFile2, bArr);
                    if (b == null || !b.a(randomAccessFile2, bArr)) {
                        x.w("MicroMsg.Mp4Parser", "mdia atom parser fail.");
                        a = null;
                    } else {
                        int i;
                        if (b.ihs == ((long) e.iho)) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i == 0) {
                            long WE = a.WE() - randomAccessFile2.getFilePointer();
                            x.d("MicroMsg.Mp4Parser", "this trak atom is not video trak skip: " + WE);
                            a = a(randomAccessFile2, bArr, WE);
                        } else {
                            this.ihr = b.ihr;
                            this.duration = b.duration;
                            x.d("MicroMsg.Mp4Parser", "this trak atom is video trak. timeScale: " + this.ihr + " duration: " + this.duration);
                            randomAccessFile2.seek(b.iht);
                            h hVar = (h) c.a(randomAccessFile2, bArr, a.ajT);
                            if (hVar != null) {
                                hVar.duration = this.duration;
                                hVar.ihr = this.ihr;
                                hVar.c(randomAccessFile2);
                                this.ihu = hVar.ihu;
                                this.ihv = this.ihu.length - 2;
                                this.ihw = hVar.ihw;
                                this.ihx = hVar.ihx;
                            }
                        }
                    }
                }
                try {
                    randomAccessFile2.close();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Mp4Parser", e2, "", new Object[0]);
                }
                return true;
            } catch (Exception e3) {
                e2 = e3;
                randomAccessFile = randomAccessFile2;
            } catch (Throwable th) {
                e2 = th;
            }
        } catch (Exception e4) {
            e2 = e4;
            randomAccessFile = null;
            try {
                x.printErrStackTrace("MicroMsg.Mp4Parser", e2, "", new Object[0]);
                x.e("MicroMsg.Mp4Parser", "parser mp4 error. e: " + e2.toString());
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.Mp4Parser", e22, "", new Object[0]);
                    }
                }
                return false;
            } catch (Throwable th2) {
                e22 = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Throwable e5) {
                        x.printErrStackTrace("MicroMsg.Mp4Parser", e5, "", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Throwable th3) {
            e22 = th3;
            randomAccessFile2 = null;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw e22;
        }
    }

    private static i a(RandomAccessFile randomAccessFile, byte[] bArr, long j) {
        x.d("MicroMsg.Mp4Parser", "start to find trak atom.");
        if (c.a(randomAccessFile, j)) {
            return (i) c.a(randomAccessFile, bArr, a.ajQ);
        }
        return null;
    }
}
