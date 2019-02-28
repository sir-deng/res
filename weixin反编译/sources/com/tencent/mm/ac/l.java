package com.tencent.mm.ac;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.brw;
import com.tencent.mm.protocal.c.brx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.io.IOException;
import java.io.OutputStream;

public final class l extends k implements com.tencent.mm.network.k {
    private String fAn;
    private e gLE;
    private int hmZ;
    private int hna;
    private int hnb;
    private String hnr;
    private String hns;
    private String hnt = q.FY();

    private static int ae(String str, String str2) {
        Options Vq = d.Vq(str);
        if (Vq.outHeight >= 640 || Vq.outWidth >= 640) {
            int indexOf;
            int intValue;
            int intValue2;
            int i;
            int i2;
            double sqrt;
            Bitmap decodeFile;
            Bitmap createScaledBitmap;
            OutputStream outputStream;
            int i3 = 50;
            try {
                if (ao.isWifi(ad.getContext())) {
                    i3 = bi.getInt(((a) g.h(a.class)).Af().getValue("HeadImageCompressPicLevelForWifi"), 50);
                } else if (ao.is2G(ad.getContext())) {
                    i3 = bi.getInt(((a) g.h(a.class)).Af().getValue("HeadImageCompressPicLevelFor2G"), 50);
                } else if (ao.is3G(ad.getContext())) {
                    i3 = bi.getInt(((a) g.h(a.class)).Af().getValue("HeadImageCompressPicLevelFor3G"), 50);
                } else {
                    i3 = bi.getInt(((a) g.h(a.class)).Af().getValue("HeadImageCompressPicLevelFor4G"), 50);
                }
            } catch (Exception e) {
            }
            try {
                String value;
                if (ao.isWifi(ad.getContext())) {
                    value = ((a) g.h(a.class)).Af().getValue("HeadImageCompressResolutionForWifi");
                } else if (ao.is2G(ad.getContext())) {
                    value = ((a) g.h(a.class)).Af().getValue("HeadImageCompressResolutionFor2G");
                } else if (ao.is3G(ad.getContext())) {
                    value = ((a) g.h(a.class)).Af().getValue("HeadImageCompressResolutionFor3G");
                } else {
                    value = ((a) g.h(a.class)).Af().getValue("HeadImageCompressResolutionFor4G");
                }
                indexOf = value.indexOf("*");
                if (-1 != indexOf) {
                    intValue = Integer.valueOf(value.substring(0, indexOf)).intValue();
                    intValue2 = Integer.valueOf(value.substring(indexOf + 1)).intValue();
                    i = intValue;
                    if (i > 0 && intValue2 <= 0) {
                        i = 0;
                        intValue2 = 1080;
                    } else if (intValue2 < 2160) {
                        i = 0;
                        intValue2 = 1080;
                    } else if (intValue2 <= 0 && i > 3240) {
                        i = 1620;
                        intValue2 = 0;
                    }
                    intValue = Vq.outWidth <= Vq.outHeight ? Vq.outWidth : Vq.outHeight;
                    indexOf = Vq.outWidth >= Vq.outHeight ? Vq.outWidth : Vq.outHeight;
                    x.i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG configLong:%d configShort:%d, CompressPicLevel-level:%d, srcW:%d, srcH:%d", Integer.valueOf(i), Integer.valueOf(intValue2), Integer.valueOf(i3), Integer.valueOf(Vq.outWidth), Integer.valueOf(Vq.outHeight));
                    if (intValue2 <= 0) {
                        i = indexOf / intValue2;
                        intValue = (Vq.outHeight * intValue2) / indexOf;
                        intValue2 = (intValue2 * Vq.outWidth) / indexOf;
                        indexOf = i;
                        i = intValue2;
                        intValue2 = intValue;
                    } else {
                        intValue2 = intValue / i;
                        indexOf = (Vq.outHeight * i) / intValue;
                        i = (i * Vq.outWidth) / intValue;
                        i2 = intValue2;
                        intValue2 = indexOf;
                        indexOf = i2;
                    }
                    if (intValue2 * i > 10240000) {
                        sqrt = Math.sqrt(1.024E7d / ((double) (intValue2 * i)));
                        intValue2 = (int) (((double) intValue2) / sqrt);
                        i = (int) (((double) i) / sqrt);
                    }
                    Vq = new Options();
                    Vq.inPreferredConfig = Config.ARGB_8888;
                    if (indexOf >= 2) {
                        Vq.inSampleSize = indexOf;
                    }
                    decodeFile = d.decodeFile(str, Vq);
                    if (decodeFile != null) {
                        x.e("MicroMsg.NetSceneUploadHDHeadImg", "decode file fail %d", Integer.valueOf(Vq.inSampleSize));
                        return 0 - com.tencent.mm.compatible.util.g.getLine();
                    }
                    x.d("MicroMsg.NetSceneUploadHDHeadImg", "dest:w:%d h:%d", Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()));
                    if (indexOf <= 1) {
                        createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, i, intValue2, true);
                        if (decodeFile != createScaledBitmap) {
                            x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", decodeFile.toString());
                            decodeFile.recycle();
                        }
                        if (createScaledBitmap == null) {
                            x.e("MicroMsg.NetSceneUploadHDHeadImg", "Scale file fail");
                            return 0 - com.tencent.mm.compatible.util.g.getLine();
                        }
                    }
                    createScaledBitmap = decodeFile;
                    outputStream = null;
                    try {
                        outputStream = FileOp.iH(str2);
                        createScaledBitmap.compress(CompressFormat.JPEG, i3, outputStream);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s, fileSize:%d -> %d", createScaledBitmap.toString(), Long.valueOf(FileOp.mi(str)), Long.valueOf(FileOp.mi(str2)));
                        createScaledBitmap.recycle();
                        return 0;
                    } catch (Throwable e3) {
                        x.e("MicroMsg.NetSceneUploadHDHeadImg", "open FileOutputStream fail");
                        x.e("MicroMsg.NetSceneUploadHDHeadImg", "exception:%s", bi.i(e3));
                        x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", createScaledBitmap.toString());
                        createScaledBitmap.recycle();
                        intValue2 = 0 - com.tencent.mm.compatible.util.g.getLine();
                        if (outputStream == null) {
                            return intValue2;
                        }
                        try {
                            outputStream.close();
                            return intValue2;
                        } catch (IOException e4) {
                            return intValue2;
                        }
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                    }
                }
            } catch (Exception e6) {
            }
            intValue2 = 1080;
            i = 0;
            if (i > 0) {
            }
            if (intValue2 < 2160) {
                i = 1620;
                intValue2 = 0;
            } else {
                i = 0;
                intValue2 = 1080;
            }
            if (Vq.outWidth <= Vq.outHeight) {
            }
            if (Vq.outWidth >= Vq.outHeight) {
            }
            x.i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG configLong:%d configShort:%d, CompressPicLevel-level:%d, srcW:%d, srcH:%d", Integer.valueOf(i), Integer.valueOf(intValue2), Integer.valueOf(i3), Integer.valueOf(Vq.outWidth), Integer.valueOf(Vq.outHeight));
            if (intValue2 <= 0) {
                intValue2 = intValue / i;
                indexOf = (Vq.outHeight * i) / intValue;
                i = (i * Vq.outWidth) / intValue;
                i2 = intValue2;
                intValue2 = indexOf;
                indexOf = i2;
            } else {
                i = indexOf / intValue2;
                intValue = (Vq.outHeight * intValue2) / indexOf;
                intValue2 = (intValue2 * Vq.outWidth) / indexOf;
                indexOf = i;
                i = intValue2;
                intValue2 = intValue;
            }
            if (intValue2 * i > 10240000) {
                sqrt = Math.sqrt(1.024E7d / ((double) (intValue2 * i)));
                intValue2 = (int) (((double) intValue2) / sqrt);
                i = (int) (((double) i) / sqrt);
            }
            Vq = new Options();
            Vq.inPreferredConfig = Config.ARGB_8888;
            if (indexOf >= 2) {
                Vq.inSampleSize = indexOf;
            }
            decodeFile = d.decodeFile(str, Vq);
            if (decodeFile != null) {
                x.d("MicroMsg.NetSceneUploadHDHeadImg", "dest:w:%d h:%d", Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()));
                if (indexOf <= 1) {
                    createScaledBitmap = decodeFile;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, i, intValue2, true);
                    if (decodeFile != createScaledBitmap) {
                        x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", decodeFile.toString());
                        decodeFile.recycle();
                    }
                    if (createScaledBitmap == null) {
                        x.e("MicroMsg.NetSceneUploadHDHeadImg", "Scale file fail");
                        return 0 - com.tencent.mm.compatible.util.g.getLine();
                    }
                }
                outputStream = null;
                outputStream = FileOp.iH(str2);
                createScaledBitmap.compress(CompressFormat.JPEG, i3, outputStream);
                if (outputStream != null) {
                    outputStream.close();
                }
                x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s, fileSize:%d -> %d", createScaledBitmap.toString(), Long.valueOf(FileOp.mi(str)), Long.valueOf(FileOp.mi(str2)));
                createScaledBitmap.recycle();
                return 0;
            }
            x.e("MicroMsg.NetSceneUploadHDHeadImg", "decode file fail %d", Integer.valueOf(Vq.inSampleSize));
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
        FileOp.x(str, str2);
        x.i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG copySrc outHeight and outWidth: %d,%d , do not scale.", Integer.valueOf(Vq.outHeight), Integer.valueOf(Vq.outWidth));
        return 0;
    }

    public l(int i, String str) {
        if (i == 2) {
            this.hnt = com.tencent.mm.storage.x.Xk(this.hnt);
        }
        n.JF();
        this.hnr = d.x(this.hnt, true);
        String str2 = this.hnr + ".tmp";
        if (ae(str, str2) == 0) {
            this.fAn = str2;
            this.hnb = i;
            n.JF();
            this.hns = com.tencent.mm.a.g.s(FileOp.d(d.x(this.hnt, true), 0, -1));
            this.hmZ = 0;
            this.hna = 0;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        if (this.fAn == null || this.fAn.length() == 0) {
            x.e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
            return -1;
        } else if (FileOp.bO(this.fAn)) {
            if (this.hmZ == 0) {
                this.hmZ = (int) FileOp.mi(this.fAn);
            }
            byte[] d = FileOp.d(this.fAn, this.hna, Math.min(this.hmZ - this.hna, 8192));
            if (d == null) {
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
                return -1;
            }
            x.i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", Integer.valueOf(d.length), Integer.valueOf(this.hmZ));
            b.a aVar = new b.a();
            aVar.hnT = new brw();
            aVar.hnU = new brx();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
            aVar.hnS = 157;
            aVar.hnV = 46;
            aVar.hnW = 1000000046;
            com.tencent.mm.network.q Kf = aVar.Kf();
            brw brw = (brw) Kf.hnQ.hnY;
            brw.vPs = this.hmZ;
            brw.vPt = this.hna;
            brw.wss = this.hnb;
            brw.weD = new bes().bl(d);
            brw.wZK = this.hns;
            return a(eVar, Kf, this);
        } else {
            x.e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.fAn);
            return -1;
        }
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        if (this.fAn == null || this.fAn.length() == 0) {
            return b.hoA;
        }
        return b.hoz;
    }

    protected final int Bo() {
        return 200;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        int i4 = 0;
        brx brx = (brx) ((b) qVar).hnR.hnY;
        x.d("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i2 + " errCode:" + i3);
        if (i2 != 4 && i3 != 0) {
            x.e("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i2 + " errCode:" + i3);
            this.gLE.a(i2, i3, str, this);
        } else if (i2 == 4 || i2 == 5) {
            this.gLE.a(i2, i3, str, this);
            x.e("MicroMsg.NetSceneUploadHDHeadImg", "ErrType:" + i2);
        } else {
            if (qVar.Hv().vIb == -4) {
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "retcode == %d", Integer.valueOf(qVar.Hv().vIb));
                i4 = 1;
            }
            if (i4 != 0) {
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "handleCertainError");
                this.gLE.a(i2, i3, str, this);
                return;
            }
            this.hna = brx.vPt;
            if (this.hna < this.hmZ) {
                if (a(this.hok, this.gLE) < 0) {
                    x.e("MicroMsg.NetSceneUploadHDHeadImg", "doScene again failed");
                    this.gLE.a(3, -1, "", this);
                }
                x.d("MicroMsg.NetSceneUploadHDHeadImg", "doScene again");
                return;
            }
            try {
                FileOp.at(this.fAn, this.hnr);
                g.Dq().Db().set(12297, brx.wZL);
                n.JF().e(this.hnt, d.Vs(this.hnr));
                String FY = q.FY();
                if (!bi.oN(FY)) {
                    h hVar = new h();
                    hVar.username = FY;
                    hVar.bC(true);
                    hVar.fEo = 32;
                    hVar.fWZ = 3;
                    hVar.fEo = 34;
                    n.JW().a(hVar);
                }
                this.gLE.a(i2, i3, str, this);
            } catch (Exception e) {
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "rename temp file failed :" + e.getMessage());
                this.gLE.a(3, -1, "", this);
            }
        }
    }

    protected final void cancel() {
        super.cancel();
    }

    public final int getType() {
        return 157;
    }
}
