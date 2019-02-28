package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.protocal.c.als;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.RandomAccessFile;

public final class a {
    private static final int mWa = (d.fO(14) ? 20 : 30);
    public b mWb = new b();
    private a mWc = new a();
    private f<String> mWd = new f();
    private f<b> mWe = new f();
    private volatile boolean mWf = false;

    private class a {

        /* renamed from: com.tencent.mm.plugin.gallery.model.a$a$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ com.tencent.mm.sdk.platformtools.at.a mWh;

            AnonymousClass1(com.tencent.mm.sdk.platformtools.at.a aVar) {
                this.mWh = aVar;
            }

            public final void run() {
                if (this.mWh.JH()) {
                    this.mWh.JI();
                }
                a.this.mWf = false;
                a.this.aOi();
            }

            public final String toString() {
                return super.toString() + "|QueueWorkerThreadForGallery";
            }
        }

        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }
    }

    private class b implements com.tencent.mm.sdk.platformtools.at.a {
        private Bitmap bitmap;
        private int fuz;
        String mFilePath;
        private String mWj;
        private long mWk;
        private int mWl;

        public b(a aVar, String str, int i, String str2, long j) {
            this(str, i, str2, j, (byte) 0);
        }

        private b(String str, int i, String str2, long j, byte b) {
            this.mFilePath = str;
            this.mWk = j;
            this.mWj = str2;
            this.mWl = 12288;
            this.fuz = i;
        }

        public final boolean JH() {
            b a = a.this.mWb;
            String str = this.mFilePath;
            String str2 = this.mWj;
            long j = this.mWk;
            this.bitmap = a.mWn == null ? null : a.mWn.qD(String.format("%s-%s-%d", new Object[]{str, str2, Long.valueOf(j)}).hashCode());
            if (this.bitmap != null) {
                x.d("MircoMsg.CacheService", "get bmp from disk cache ok, filePath[%s]", this.mFilePath);
                return true;
            }
            this.bitmap = j.a(this.mWk, this.fuz, this.mFilePath, this.mWj);
            if (this.bitmap == null) {
                return false;
            }
            a = a.this.mWb;
            str = this.mFilePath;
            str2 = this.mWj;
            j = this.mWk;
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                str = String.format("%s-%s-%d", new Object[]{str, str2, Long.valueOf(j)});
                if (a.mWn != null) {
                    d dVar = a.mWn;
                    int hashCode = str.hashCode();
                    if (dVar.mWE == null || dVar.mWE.size() <= 0) {
                        x.e("MicroMsg.DiskCache", "want to put bitmap, but data file is null");
                    } else if (bitmap == null) {
                        x.e("MicroMsg.DiskCache", "put bmp, value error: null");
                    } else {
                        int i;
                        x.d("MicroMsg.DiskCache", "put bmp key[%d] size[%d, %d]", Integer.valueOf(hashCode), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                        if (dVar.mWE == null || dVar.mWE.size() <= 0) {
                            i = -1;
                        } else {
                            int aOw = dVar.aOw();
                            if (aOw < 0) {
                                x.d("MicroMsg.DiskCache", "jacks check Data Size currentSuffix: %d", Integer.valueOf(dVar.mWG));
                                aOw = dVar.mWG + 1 >= 25 ? 0 : dVar.mWG + 1;
                                x.d("MicroMsg.DiskCache", "jacks reset Index and Data: %d", Integer.valueOf(aOw));
                                dVar.qC(aOw);
                                dVar.qB(aOw);
                            }
                            i = aOw;
                        }
                        if (i < 0) {
                            x.e("MicroMsg.DiskCache", "put bmp, file suffix < 0");
                        } else {
                            Object obj;
                            als als = (als) dVar.mWF.get(hashCode);
                            if (als == null) {
                                als = new als();
                                als.key = hashCode;
                                obj = als;
                            } else {
                                als obj2 = als;
                            }
                            Closeable byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                                try {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    RandomAccessFile randomAccessFile = (RandomAccessFile) dVar.mWE.get(i);
                                    obj2.wzE = randomAccessFile.length();
                                    obj2.wzF = i;
                                    obj2.length = byteArrayOutputStream.size();
                                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                                    randomAccessFile.seek(obj2.wzE);
                                    randomAccessFile.write(toByteArray);
                                    dVar.mWG = i;
                                    x.d("MicroMsg.DiskCache", "jacks [time: %d]save data ok, key[%d] beg pos %d, length %d, file_suffix %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(obj2.key), Long.valueOf(obj2.wzE), Integer.valueOf(obj2.length), Integer.valueOf(obj2.wzF));
                                    dVar.mvv = true;
                                    dVar.mWF.put(hashCode, obj2);
                                } catch (Exception e) {
                                    obj2 = "write data error:%s";
                                    x.e("MicroMsg.DiskCache", obj2, e.getMessage());
                                } finally {
                                    d.f(byteArrayOutputStream);
                                }
                            } catch (Throwable e2) {
                                x.e("MicroMsg.DiskCache", "compress bmp error:%s", e2.getMessage());
                                x.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
                                d.f(byteArrayOutputStream);
                            }
                        }
                    }
                }
            }
            return true;
        }

        public final boolean JI() {
            x.d("MircoMsg.CacheService", "do on post execute, filePath[%s]", this.mFilePath);
            a.this.mWd.bv(this.mFilePath);
            x.v("MircoMsg.CacheService", "remove filePathInService at position 0 : now position:[%d]", Integer.valueOf(a.this.mWd.size()));
            if (this.bitmap == null) {
                x.e("MircoMsg.CacheService", "decode file failed, %s ", this.mFilePath);
                return false;
            }
            b a = a.this.mWb;
            String str = this.mFilePath;
            Bitmap bitmap = this.bitmap;
            int i = this.mWl;
            if (a.mWm == null) {
                x.e("MicroMsg.GalleryCache", "cache is null");
            } else {
                a.mWm.l(str, new a(bitmap, i));
                a.hmJ.cb(str);
                a.hmJ.doNotify();
            }
            this.bitmap = null;
            return true;
        }

        public final boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            return bi.aD(this.mFilePath, "").equals(((b) obj).mFilePath);
        }

        public final int hashCode() {
            return bi.aD(this.mFilePath, "").hashCode();
        }
    }

    public final Bitmap b(String str, int i, String str2, long j) {
        if (bi.oN(str)) {
            x.w("MircoMsg.CacheService", "file path is null");
            return null;
        }
        Bitmap bitmap = this.mWb.getBitmap(str);
        if (bitmap != null) {
            x.v("MircoMsg.CacheService", "get bitmap from cache: %s", str);
            return bitmap;
        }
        x.v("MircoMsg.CacheService", "filePathInService size is : [%d]", Integer.valueOf(this.mWd.size()));
        if (this.mWd.bu(str)) {
            x.w("MircoMsg.CacheService", "has already getting bitmap from file, %s", str);
            aOi();
            return null;
        }
        if (this.mWd.size() > mWa) {
            x.w("MircoMsg.CacheService", "the running task has exceed 40, remove the first one");
            x.w("MircoMsg.CacheService", "filePathInService size: [%d], waitingDecodeTask size:[%d]", Integer.valueOf(this.mWd.size()), Integer.valueOf(this.mWe.size()));
            if (!this.mWe.isEmpty()) {
                b bVar = (b) this.mWe.aOE();
                if (bVar != null) {
                    this.mWd.bv(bVar.mFilePath);
                }
            }
        }
        this.mWd.add(str);
        this.mWe.add(new b(this, str, i, str2, j));
        aOi();
        return null;
    }

    public final Bitmap BW(String str) {
        if (bi.oN(str)) {
            x.w("MircoMsg.CacheService", "file path is null");
            return null;
        }
        Bitmap bitmap = this.mWb.getBitmap(str);
        if (bitmap == null) {
            return null;
        }
        x.v("MircoMsg.CacheService", "get bitmap from cache: %s", str);
        return bitmap;
    }

    private void aOi() {
        if (this.mWf) {
            x.w("MircoMsg.CacheService", "is decoding now, wait a minute");
        } else if (this.mWe == null || this.mWe.size() <= 0) {
            x.i("MircoMsg.CacheService", "all job empty");
            if (c.aOm() != null) {
                c.aOm().x(new Runnable() {
                    public final void run() {
                        b a = a.this.mWb;
                        if (a.mWn != null) {
                            d dVar = a.mWn;
                            if (dVar.mvv) {
                                dVar.mvv = false;
                                dVar.aOu();
                                dVar.aOv();
                                dVar.qB(-1);
                                dVar.aOx();
                            }
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|tryStartDocode";
                    }
                });
            }
        } else {
            this.mWf = true;
            b bVar = (b) this.mWe.aOE();
            if (bVar == null) {
                x.e("MircoMsg.CacheService", "obj is null");
                this.mWf = false;
                aOi();
                return;
            }
            a aVar = this.mWc;
            if (c.aOm() == null) {
                x.w("MircoMsg.CacheService", "add thread object, but worker thread is null");
                return;
            }
            e aOm = c.aOm();
            Runnable anonymousClass1 = new AnonymousClass1(bVar);
            ag aOy = aOm.aOy();
            if (aOy == null) {
                x.e("MicroMsg.GalleryHandlerThread", "post at front of queue, but decode handler is null");
                return;
            }
            boolean postAtFrontOfQueueV2 = aOy.postAtFrontOfQueueV2(anonymousClass1);
            x.i("MicroMsg.GalleryHandlerThread", "postAtFrontOfQueue:[%b]", Boolean.valueOf(postAtFrontOfQueueV2));
        }
    }

    public final void a(com.tencent.mm.plugin.gallery.model.b.b bVar) {
        b bVar2 = this.mWb;
        if (bVar2.hmK.size() > 64) {
            com.tencent.mm.plugin.gallery.model.b.b bVar3 = (com.tencent.mm.plugin.gallery.model.b.b) bVar2.hmK.remove(0);
            x.i("MicroMsg.GalleryCache", "has exceed the max listener size[%d], remove some listeners[%s]", Integer.valueOf(64), bVar3);
        }
        x.v("MicroMsg.GalleryCache", "try add listener[%s]", bVar);
        if (!bVar2.hmK.contains(bVar)) {
            x.d("MicroMsg.GalleryCache", "add listener[%s] ok", bVar);
            bVar2.hmK.add(bVar);
        }
    }
}
