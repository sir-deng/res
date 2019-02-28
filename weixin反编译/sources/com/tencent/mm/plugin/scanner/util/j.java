package com.tencent.mm.plugin.scanner.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class j extends b {
    private Object hrp = new Object();
    private boolean mWf = false;
    private int outHeight;
    private int outWidth;
    public boolean ozC = true;
    private boolean qcF = false;
    private float qdM = 1.0f;
    private byte[] qfN;
    private final int qgG = 25;
    private boolean qgH = false;
    private final int qgI = 1;
    private int qgJ = 0;
    private boolean qgK;
    private volatile boolean qgL;
    public volatile boolean qgM;
    private long qgN;
    private int quality = 50;

    public j(a aVar, int i, float f, boolean z, boolean z2) {
        super(aVar);
        this.quality = i;
        this.qdM = f;
        this.ozC = z2;
        this.qgK = z;
        x.i("MicroMsg.scanner.ScanImageDecoder", "quality = [%s], scaleRate = [%s], needRotate = [%s], ocrMode=[%s]", Integer.valueOf(i), Float.valueOf(f), Boolean.valueOf(z2), Boolean.valueOf(z));
    }

    @TargetApi(8)
    public final boolean a(byte[] bArr, Point point, Rect rect) {
        if (this.mWf) {
            x.e("MicroMsg.scanner.ScanImageDecoder", "decode() is decoding, return false");
            return false;
        }
        this.mWf = true;
        if (bArr == null || point == null || rect == null) {
            boolean z;
            String str = "MicroMsg.scanner.ScanImageDecoder";
            String str2 = "decode() data null:[%s], resolution null:[%s], coverage null:[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(bArr == null);
            if (point == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            if (rect == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
            this.mWf = false;
            return false;
        }
        try {
            if (this.qgJ <= 0) {
                this.qgJ++;
                this.mWf = false;
                return false;
            }
            synchronized (this.hrp) {
                int width;
                Rect rect2 = new Rect();
                int height;
                if (d.ys() || this.ozC) {
                    width = rect.width() % 4;
                    height = rect.height() % 4;
                    rect2.left = rect.left;
                    rect2.right = rect.right - width;
                    rect2.top = rect.top;
                    rect2.bottom = rect.bottom - height;
                    if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                        this.mWf = false;
                        return false;
                    }
                }
                rect2.left = (point.x / 2) - rect.height();
                rect2.right = (point.x / 2) + rect.height();
                rect2.top = (point.y / 2) - (rect.width() / 2);
                rect2.bottom = (point.y / 2) + (rect.width() / 2);
                if (rect2.left < 0) {
                    rect2.left = 0;
                }
                if (rect2.right > point.x - 1) {
                    rect2.right = point.x - 1;
                }
                if (rect2.top < 0) {
                    rect2.top = 0;
                }
                if (rect2.bottom > point.y - 1) {
                    rect2.bottom = point.y - 1;
                }
                width = rect2.width() % 4;
                height = rect2.height() % 4;
                if (width != 0) {
                    rect2.right -= width;
                }
                if (height != 0) {
                    rect2.bottom -= height;
                }
                if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                    this.mWf = false;
                    return false;
                }
                f.a cVar = new c(bArr, point.x, point.y, rect2);
                if (cVar.height == 0 || cVar.width == 0) {
                    this.mWf = false;
                    return false;
                } else if (this.qcF) {
                    x.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 1");
                    return false;
                } else {
                    byte[] bqf = cVar.bqf();
                    if (bqf == null) {
                        this.mWf = false;
                        return false;
                    }
                    if (!this.qgH) {
                        if (d.ys()) {
                            width = b(rect2.width(), rect2.height(), this.qgK, wg(q.gHF.gFT));
                            x.d("MicroMsg.scanner.ScanImageDecoder", "Focus init Landscape params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", Integer.valueOf(rect2.width()), Integer.valueOf(rect2.height()), Boolean.valueOf(this.qgK), Integer.valueOf(q.gHF.gFT));
                        } else {
                            width = b(rect2.height(), rect2.width(), this.qgK, wg(q.gHF.gFT));
                            x.d("MicroMsg.scanner.ScanImageDecoder", "Focus init params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", Integer.valueOf(rect2.height()), Integer.valueOf(rect2.width()), Boolean.valueOf(this.qgK), Integer.valueOf(q.gHF.gFT));
                        }
                        if (width == -1) {
                            x.e("MicroMsg.scanner.ScanImageDecoder", "error in Focus init = [%s]", Integer.valueOf(width));
                            return false;
                        }
                        this.qgH = true;
                    }
                    boolean[] zArr = new boolean[2];
                    long Wz = bi.Wz();
                    QbarNative.FocusPro(bqf, d.ys(), zArr);
                    x.d("MicroMsg.scanner.ScanImageDecoder", "is best:%s, need focus:%s, cost:%s", Boolean.valueOf(zArr[0]), Boolean.valueOf(zArr[1]), Long.valueOf(bi.bB(Wz)));
                    this.qgL = zArr[0];
                    this.qgM = zArr[1];
                    if (this.qgN == 0) {
                        this.qgN = System.currentTimeMillis();
                    }
                    if (!this.qgM && System.currentTimeMillis() - this.qgN > 9000) {
                        x.d("MicroMsg.scanner.ScanImageDecoder", "reach focus interfal");
                        this.qgM = true;
                        this.qgN = System.currentTimeMillis();
                    }
                    if (this.qgL) {
                        if (this.qcF) {
                            x.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 2");
                            return false;
                        }
                        this.outWidth = cVar.width;
                        this.outHeight = cVar.height;
                        int i = 0;
                        width = 0;
                        if (!d.ys()) {
                            i = 1;
                            this.outWidth = cVar.height;
                            this.outHeight = cVar.width;
                        }
                        if (((double) this.qdM) < 0.9d) {
                            width = 1;
                            this.outWidth /= 2;
                            this.outHeight /= 2;
                        }
                        if (this.qfN == null) {
                            this.qfN = new byte[(((this.outWidth * this.outHeight) * 3) / 2)];
                            x.v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes = null, new byte[%s]", Integer.valueOf(((this.outWidth * this.outHeight) * 3) / 2));
                        } else if (this.qfN.length != ((this.outWidth * this.outHeight) * 3) / 2) {
                            this.qfN = null;
                            this.qfN = new byte[(((this.outWidth * this.outHeight) * 3) / 2)];
                            x.v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes size change, new byte[%s]", Integer.valueOf(((this.outWidth * this.outHeight) * 3) / 2));
                        }
                        x.d("MicroMsg.scanner.ScanImageDecoder", "decode() imgRet = [%s], outWidth = [%s], outHeight = [%s], imgRotate=[%s], imgScale=[%s]", Integer.valueOf(QbarNative.a(this.qfN, bqf, this.outWidth, this.outHeight, width)), Integer.valueOf(this.outWidth), Integer.valueOf(this.outHeight), Integer.valueOf(i), Integer.valueOf(width));
                        if (QbarNative.a(this.qfN, bqf, this.outWidth, this.outHeight, width) != 1) {
                            this.qfC = null;
                            this.mWf = false;
                            return false;
                        } else if (this.qcF) {
                            x.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 3");
                            return false;
                        } else {
                            if (f.fN(8)) {
                                com.tencent.mm.compatible.a.a.a(8, new com.tencent.mm.compatible.a.a.a() {
                                    public final void run() {
                                        Throwable e;
                                        FileOutputStream fileOutputStream = null;
                                        YuvImage yuvImage = new YuvImage(j.this.qfN, 17, j.this.outWidth, j.this.outHeight, null);
                                        x.d("MicroMsg.scanner.ScanImageDecoder", "decode() compress jpeg by YuvImage");
                                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        yuvImage.compressToJpeg(new Rect(0, 0, j.this.outWidth, j.this.outHeight), j.this.quality, byteArrayOutputStream);
                                        j.this.qfC = byteArrayOutputStream.toByteArray();
                                        try {
                                            FileOutputStream fileOutputStream2;
                                            if (r.ifB) {
                                                fileOutputStream2 = new FileOutputStream(new File(h.getExternalStorageDirectory().getAbsolutePath() + "/_scanImage.JPEG"));
                                                try {
                                                    fileOutputStream2.write(j.this.qfC);
                                                    fileOutputStream2.flush();
                                                } catch (IOException e2) {
                                                    e = e2;
                                                    fileOutputStream = fileOutputStream2;
                                                    try {
                                                        x.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode() ApiTask : [%s]", e.getMessage());
                                                        x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e, "", new Object[0]);
                                                        if (fileOutputStream != null) {
                                                            try {
                                                                fileOutputStream.close();
                                                            } catch (Throwable e3) {
                                                                x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e3, "", new Object[0]);
                                                            }
                                                        }
                                                        try {
                                                            byteArrayOutputStream.close();
                                                        } catch (Throwable e32) {
                                                            x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e32, "", new Object[0]);
                                                            return;
                                                        }
                                                    } catch (Throwable th) {
                                                        e32 = th;
                                                        if (fileOutputStream != null) {
                                                            try {
                                                                fileOutputStream.close();
                                                            } catch (Throwable e4) {
                                                                x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e4, "", new Object[0]);
                                                            }
                                                        }
                                                        try {
                                                            byteArrayOutputStream.close();
                                                        } catch (Throwable e42) {
                                                            x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e42, "", new Object[0]);
                                                        }
                                                        throw e32;
                                                    }
                                                } catch (Throwable th2) {
                                                    e32 = th2;
                                                    fileOutputStream = fileOutputStream2;
                                                    if (fileOutputStream != null) {
                                                        fileOutputStream.close();
                                                    }
                                                    byteArrayOutputStream.close();
                                                    throw e32;
                                                }
                                            }
                                            fileOutputStream2 = null;
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (Throwable e322) {
                                                    x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e322, "", new Object[0]);
                                                }
                                            }
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Throwable e3222) {
                                                x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e3222, "", new Object[0]);
                                            }
                                        } catch (IOException e5) {
                                            e3222 = e5;
                                            x.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode() ApiTask : [%s]", e3222.getMessage());
                                            x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e3222, "", new Object[0]);
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            byteArrayOutputStream.close();
                                        }
                                    }
                                });
                            } else {
                                x.d("MicroMsg.scanner.ScanImageDecoder", "decode() compress jpeg by PlanarYUVLuminanceSource");
                                c cVar2 = new c(this.qfN, this.outWidth, this.outHeight, new Rect(0, 0, this.outWidth, this.outHeight));
                                int[] iArr = new int[(cVar2.width * cVar2.height)];
                                QbarNative.a(cVar2.fGr, iArr, cVar2.qfI, cVar2.qfJ, cVar2.left, cVar2.top, cVar2.width, cVar2.height);
                                QbarNative.nativeRelease();
                                Bitmap createBitmap = Bitmap.createBitmap(cVar2.width, cVar2.height, Config.ARGB_8888);
                                createBitmap.setPixels(iArr, 0, cVar2.width, 0, 0, cVar2.width, cVar2.height);
                                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                createBitmap.compress(CompressFormat.JPEG, this.quality, byteArrayOutputStream);
                                this.qfC = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                if (r.ifB) {
                                    com.tencent.mm.sdk.platformtools.d.a(createBitmap, this.quality, CompressFormat.JPEG, h.getExternalStorageDirectory().getAbsolutePath() + "/_scanImage_.JPEG", false);
                                }
                                createBitmap.recycle();
                            }
                            x.i("MicroMsg.scanner.ScanImageDecoder", "decode() finish greyData.length = [%s]", Integer.valueOf(this.qfC.length));
                            this.mWf = false;
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode(): [%s]", e.toString());
            x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e, "", new Object[0]);
        }
        this.qfC = null;
        this.mWf = false;
        return false;
    }

    public final void kM() {
        x.d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder start");
        this.qcF = true;
        if (this.hrp != null) {
            synchronized (this.hrp) {
                if (this.qgH) {
                    x.d("sizepara", "ImgProcessScan.FocusRelease() = [%s]", Integer.valueOf(0));
                    this.qgH = false;
                    x.d("MicroMsg.scanner.ScanImageDecoder", "ImgProcessScan.Release() = [%s]", Integer.valueOf(QbarNative.FocusRelease()));
                }
            }
        }
        this.qfN = null;
        c.bqe();
        x.d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder done");
    }

    public final void bqd() {
        if (this.qgH) {
            kM();
        }
        this.mWf = false;
        this.qcF = false;
        this.qgH = false;
    }

    private static int b(int i, int i2, boolean z, int i3) {
        if (i <= 0 || i2 <= 0) {
            return -1;
        }
        if (i3 == 1) {
            return QbarNative.FocusInit(i, i2, z, 6, b.CTRL_INDEX);
        }
        if (i3 == 2) {
            return QbarNative.FocusInit(i, i2, z, 8, 120);
        }
        if (i3 == 4) {
            return QbarNative.FocusInit(i, i2, z, 13, 80);
        }
        if (i3 == 5) {
            return QbarNative.FocusInit(i, i2, z, 15, 65);
        }
        return QbarNative.FocusInit(i, i2, z, 10, 100);
    }

    private static int wg(int i) {
        if (i <= 0 || i > 5) {
            return 3;
        }
        return i;
    }
}
