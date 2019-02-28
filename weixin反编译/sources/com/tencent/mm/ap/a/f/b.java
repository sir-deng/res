package com.tencent.mm.ap.a.f;

import android.graphics.Bitmap;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.ap.a.c.a;
import com.tencent.mm.ap.a.c.d;
import com.tencent.mm.ap.a.c.e;
import com.tencent.mm.ap.a.c.f;
import com.tencent.mm.ap.a.c.g;
import com.tencent.mm.ap.a.c.i;
import com.tencent.mm.ap.a.c.j;
import com.tencent.mm.ap.a.c.k;
import com.tencent.mm.ap.a.c.l;
import com.tencent.mm.ap.a.c.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.InputStream;

public final class b implements Runnable {
    private final com.tencent.mm.ap.a.a.b hEG = this.hFT.hEG;
    public final c hEY;
    private final m hEZ;
    private final com.tencent.mm.ap.a.b hFT;
    public final com.tencent.mm.ap.a.c hFV;
    private final ag hFW;
    private final i hFX;
    private final g hFY;
    private final k hFZ;
    private final a hFa;
    private final com.tencent.mm.ap.a.c.b hFb;
    private final f hFc;
    private final j hFd;
    private final e hFf;
    private final d hGa;
    private final l hGb;
    public final String url;

    public b(String str, com.tencent.mm.ap.a.c cVar, ag agVar, c cVar2, i iVar, j jVar, com.tencent.mm.ap.a.b bVar, g gVar, e eVar, d dVar, l lVar) {
        this.url = str;
        this.hFV = cVar;
        this.hFW = agVar;
        this.hFT = bVar;
        this.hFY = gVar;
        if (cVar2 == null) {
            this.hEY = this.hEG.hEY;
        } else {
            this.hEY = cVar2;
        }
        this.hFX = iVar;
        if (jVar == null) {
            this.hFd = this.hEG.hFd;
        } else {
            this.hFd = jVar;
        }
        if (this.hEY.hFb != null) {
            this.hFb = this.hEY.hFb;
        } else {
            this.hFb = this.hEG.hFb;
        }
        this.hEZ = this.hEG.hEZ;
        this.hFa = this.hEG.hFa;
        this.hFc = this.hEG.hFc;
        this.hFZ = this.hEG.hFe;
        if (eVar == null) {
            this.hFf = this.hEG.hFf;
        } else {
            this.hFf = eVar;
        }
        this.hGa = dVar;
        this.hGb = lVar;
    }

    public final void run() {
        Bitmap bitmap = null;
        com.tencent.mm.ap.a.d.b bVar = new com.tencent.mm.ap.a.d.b();
        Exception e;
        Bitmap bitmap2;
        com.tencent.mm.ap.a.d.b bVar2;
        InputStream inputStream;
        try {
            Bitmap b;
            long currentTimeMillis;
            String lH = lH(this.url);
            x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from disk. key:%s", this.url);
            long currentTimeMillis2 = System.currentTimeMillis();
            int i = this.hEY.hFq;
            boolean z = this.hEY.hFt;
            String str = this.hEY.frM;
            x.d("MicroMsg.imageloader.ImageLoadTask", "hy: should check md5:" + z);
            x.d("MicroMsg.imageloader.ImageLoadTask", "hy: fileType: %d", Integer.valueOf(i));
            x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] test view width:%d height:%d", Integer.valueOf(this.hFV.width), Integer.valueOf(this.hFV.height));
            switch (i) {
                case 1:
                    String str2 = this.hEY.fwx;
                    if (!this.hEY.hFx || bi.oN(str2) || !com.tencent.mm.a.e.bO(str2)) {
                        if (!bi.oN(this.url)) {
                            if (!com.tencent.mm.a.e.bO(this.url)) {
                                if (this.hEY.hFy) {
                                    this.hFf.e(this.hEY.hFO);
                                }
                                x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] file does not exist.");
                                break;
                            }
                            if (z) {
                                if (!this.hFZ.an(str, this.url)) {
                                    x.w("MicroMsg.imageloader.ImageLoadTask", "hy: file md5 check failed");
                                    bitmap = null;
                                    break;
                                }
                            }
                            if (this.hEY.hFL) {
                                b = com.tencent.mm.ap.a.g.a.b(this.hFV, this.url, this.hEY.hFr, this.hEY.hFs);
                            } else if (this.hGa != null) {
                                b = com.tencent.mm.ap.a.g.a.a(this.hFV, this.hGa.f(this.hEY.hFO), this.hEY.hFr, this.hEY.hFs, this.hEY.hFz, this.hEY.alpha, this.hEY.hFu);
                            } else {
                                b = com.tencent.mm.ap.a.g.a.a(this.hFV, this.url, this.hEY.hFr, this.hEY.hFs);
                            }
                            if (this.hEY.hFN && r3 == null && this.hGb != null) {
                                if (this.hGa != null) {
                                    b = this.hGb.I(this.hGa.f(this.hEY.hFO));
                                } else {
                                    b = this.hGb.lG(this.url);
                                }
                            }
                            if (b != null && this.hEY.density > 0) {
                                b.setDensity(this.hEY.density);
                            }
                            x.d("MicroMsg.imageloader.ImageLoadTask", "hy: file md5 check success or do not need md5 check");
                            bitmap = b;
                            break;
                        }
                        x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] url is null.");
                        break;
                    }
                    if (this.hEY.hFL) {
                        b = com.tencent.mm.ap.a.g.a.b(this.hFV, str2, this.hEY.hFr, this.hEY.hFs);
                    } else {
                        b = com.tencent.mm.ap.a.g.a.a(this.hFV, str2, this.hEY.hFr, this.hEY.hFs);
                    }
                    try {
                        if (this.hEY.density <= 0) {
                            bitmap = b;
                            break;
                        }
                        b.setDensity(this.hEY.density);
                        bitmap = b;
                        break;
                    } catch (Exception e2) {
                        e = e2;
                        bitmap2 = b;
                        bVar2 = bVar;
                        break;
                    }
                case 2:
                    bitmap = com.tencent.mm.ap.a.g.a.c(this.hFV, this.url, this.hEY.hFr, this.hEY.hFs);
                    break;
                case 3:
                    bitmap = com.tencent.mm.ap.a.g.a.a(this.hFV, this.hEG.hEV.getIdentifier(this.url, "drawable", this.hEG.packageName), this.hEY.hFr, this.hEY.hFs);
                    break;
                case 4:
                    bitmap = com.tencent.mm.ap.a.g.a.a(this.hFV, Integer.valueOf(this.url).intValue(), this.hEY.hFr, this.hEY.hFs);
                    break;
                case 5:
                    inputStream = null;
                    Object obj = null;
                    inputStream = this.hFa.d(this.url, this.hEY);
                    if (inputStream == null) {
                        bitmap2 = null;
                    } else if (!z || this.hFZ.b(str, inputStream)) {
                        Bitmap a;
                        com.tencent.mm.ap.a.c cVar = this.hFV;
                        int i2 = this.hEY.hFr;
                        int i3 = this.hEY.hFs;
                        boolean z2 = this.hEY.hFz;
                        float f = this.hEY.alpha;
                        boolean z3 = this.hEY.hFu;
                        if (i2 > 0 && i3 > 0) {
                            a = com.tencent.mm.sdk.platformtools.d.a(inputStream, 0.0f, i2, i3);
                        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
                            a = com.tencent.mm.sdk.platformtools.d.decodeStream(inputStream);
                        } else {
                            a = com.tencent.mm.sdk.platformtools.d.a(inputStream, 0.0f, cVar.width, cVar.height);
                        }
                        if (z2) {
                            a = com.tencent.mm.sdk.platformtools.d.a(a, i2, i3, false, true);
                        }
                        if (f > 0.0f) {
                            a = com.tencent.mm.sdk.platformtools.d.c(a, f);
                        }
                        if (z3) {
                            a = com.tencent.mm.sdk.platformtools.d.S(a);
                        }
                        bitmap2 = a;
                        obj = 1;
                    } else {
                        obj = 1;
                        bitmap2 = null;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (obj != null && bitmap2 == null) {
                        try {
                            this.hFa.c(this.url, this.hEY);
                            bitmap = bitmap2;
                            break;
                        } catch (Exception e4) {
                            e = e4;
                            bVar2 = bVar;
                            break;
                        }
                    }
                    bitmap = bitmap2;
                    break;
                    break;
                default:
                    x.e("MicroMsg.imageloader.ImageLoadTask", "[cpan] unknow file type :%d", Integer.valueOf(i));
                    break;
            }
            try {
                currentTimeMillis = System.currentTimeMillis();
            } catch (Exception e5) {
                e = e5;
                bVar2 = bVar;
                bitmap2 = bitmap;
            }
            Bitmap bitmap3;
            String str3;
            int min;
            i iVar;
            com.tencent.mm.ap.a.b bVar3;
            if (bitmap == null || bitmap.isRecycled()) {
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run get bitmap failed");
                        bitmap3 = bitmap;
                        break;
                    case 5:
                        currentTimeMillis2 = System.currentTimeMillis();
                        x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from memory failed.now try to get from network.");
                        if (this.hFY != null) {
                            g gVar = this.hFY;
                            str3 = this.url;
                            this.hFV.Jx();
                            gVar.lF(str3);
                        }
                        bVar2 = this.hFb.lD(this.url);
                        if (bVar2 == null) {
                            try {
                                bVar = new com.tencent.mm.ap.a.d.b(null, null);
                            } catch (Exception e6) {
                                e = e6;
                                bitmap2 = bitmap;
                                break;
                            }
                        }
                        bVar = bVar2;
                        try {
                            if (bVar.data != null) {
                                if (z) {
                                    if (!this.hFZ.i(str, bVar.data)) {
                                        bVar.status = 2;
                                        x.w("MicroMsg.imageloader.ImageLoadTask", "hy: image data md5 check failed");
                                        bitmap3 = null;
                                        break;
                                    }
                                }
                                x.d("MicroMsg.imageloader.ImageLoadTask", "hy: image data md5 check success or do not need md5 check");
                                long currentTimeMillis3 = System.currentTimeMillis();
                                b = com.tencent.mm.ap.a.g.a.a(this.hFV, bVar.data, this.hEY.hFr, this.hEY.hFs, this.hEY.hFz, this.hEY.alpha, this.hEY.hFu);
                                if (b != null) {
                                    byte[] bArr = bVar.data;
                                    if (this.hEY.hFl) {
                                        this.hFa.a(this.url, bArr, this.hEY);
                                    }
                                    if (this.hEY.hFk) {
                                        this.hFa.a(this.url, bArr, this.hEY);
                                    }
                                    if (this.hEY.hFJ) {
                                        if (this.hEY.hFK != 0.0f) {
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, this.hEY.hFK);
                                        } else if (b.getWidth() == b.getHeight()) {
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
                                        } else {
                                            min = Math.min(b.getWidth(), b.getHeight());
                                            if (min <= 0) {
                                                min = Math.max(b.getWidth(), b.getHeight());
                                            }
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, min, min, true);
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
                                        }
                                    }
                                    b = a(bVar, b);
                                    j(lH, b);
                                    bn(currentTimeMillis3 - currentTimeMillis2);
                                    bitmap3 = b;
                                    break;
                                }
                                try {
                                    bVar.status = 3;
                                    bitmap3 = b;
                                    break;
                                } catch (Exception e7) {
                                    e = e7;
                                    bitmap2 = b;
                                    bVar2 = bVar;
                                    break;
                                }
                            }
                            bVar.status = 1;
                            bitmap3 = bitmap;
                            break;
                        } catch (Exception e8) {
                            e = e8;
                            bVar2 = bVar;
                            bitmap2 = bitmap;
                            break;
                        }
                    default:
                        x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run unknow file type");
                        bitmap3 = bitmap;
                        break;
                }
                x.e("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. exception. %s", e.toString());
                bVar = bVar2;
                bitmap3 = bitmap2;
                if (bitmap3 != null || bitmap3.isRecycled()) {
                    x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap failed");
                } else {
                    x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap successs.");
                    if (this.hEY.hFv) {
                        bitmap3 = com.tencent.mm.sdk.platformtools.d.c(bitmap3, this.hEY.hFw);
                    }
                    Runnable cVar2 = new c(this.url, this.hFV, bitmap3, this.hFT, lH(this.url));
                    if (this.hFW != null) {
                        this.hFW.post(cVar2);
                    }
                    bVar.bitmap = bitmap3;
                }
                if (!(this.hFY == null || bVar == null)) {
                    bVar.bitmap = bitmap3;
                    this.hFY.a(this.url, this.hFV.Jx(), bVar);
                }
                iVar = this.hFX;
                str3 = this.url;
                this.hFV.Jx();
                iVar.a(str3, bitmap3, this.hEY.hFO);
                bVar3 = this.hFT;
                if (bVar3.hEK != null && this != null && this.hFV != null) {
                    bVar3.hEK.remove(Integer.valueOf(this.hFV.PO()));
                    return;
                }
                return;
            }
            if (!this.hEY.hFJ) {
                b = bitmap;
            } else if (this.hEY.hFK != 0.0f) {
                b = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, this.hEY.hFK);
            } else if (bitmap.getWidth() == bitmap.getHeight()) {
                b = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, (float) (bitmap.getWidth() / 2));
            } else {
                min = Math.min(bitmap.getWidth(), bitmap.getHeight());
                if (min <= 0) {
                    min = Math.max(bitmap.getWidth(), bitmap.getHeight());
                }
                b = com.tencent.mm.sdk.platformtools.d.a(bitmap, min, min, true);
                b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
            }
            b = a(bVar, b);
            j(lH, b);
            bn(currentTimeMillis - currentTimeMillis2);
            x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from disk success.");
            bitmap3 = b;
            if (bitmap3 != null) {
            }
            x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap failed");
            bVar.bitmap = bitmap3;
            this.hFY.a(this.url, this.hFV.Jx(), bVar);
            iVar = this.hFX;
            str3 = this.url;
            this.hFV.Jx();
            iVar.a(str3, bitmap3, this.hEY.hFO);
            bVar3 = this.hFT;
            if (bVar3.hEK != null) {
            }
        } catch (Exception e9) {
            e = e9;
            bVar2 = bVar;
            bitmap2 = null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                }
            }
        }
    }

    private void j(String str, Bitmap bitmap) {
        if (this.hEY.hFj) {
            x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. put key %s to memory cache.", this.url);
            this.hEZ.c(str, bitmap);
        }
    }

    private Bitmap a(com.tencent.mm.ap.a.d.b bVar, Bitmap bitmap) {
        if (this.hFY == null || bVar == null) {
            return bitmap;
        }
        bVar.bitmap = bitmap;
        g gVar = this.hFY;
        String str = this.url;
        this.hFV.Jx();
        Bitmap a = gVar.a(str, bVar);
        if (a == null || a.isRecycled()) {
            return bitmap;
        }
        return a;
    }

    public final String lH(String str) {
        if (bi.oN(str) || this.hEY == null) {
            return null;
        }
        if (this.hEY.hFJ) {
            str = str + "round" + this.hEY.hFK;
        }
        if (!bi.oN(this.hEY.hFG)) {
            str = str + this.hEY.hFG;
        }
        return str + "size" + this.hEY.hFr + this.hEY.hFs;
    }

    public final void bn(long j) {
        if (this.hFd != null) {
            this.hFd.bn(j);
        }
    }
}
