package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.licence.model.BankCardInfo;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class g extends b {
    private int mCount = 0;
    private boolean qge = false;
    public boolean qgf;
    private boolean qgg;
    public boolean[] qgh = new boolean[4];
    private boolean qgi;
    private boolean qgj;
    private boolean qgk;
    private Bitmap qgl;
    private final Object qgm = new Object();

    public g(a aVar, boolean z, boolean z2) {
        super(aVar);
        this.qgf = z;
        this.qgg = z2;
        x.d("MicroMsg.ScanBankCardDecoder", "isPortrait:%s, needRotate:%s", Boolean.valueOf(false), Boolean.valueOf(z));
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        boolean z;
        Throwable e;
        long currentTimeMillis;
        BankCardInfo bankCardInfo;
        int recognizeBankCardProcess;
        boolean z2;
        Options options;
        int[] rectX;
        int[] rectY;
        int i;
        int i2;
        synchronized (this.qgm) {
            long currentTimeMillis2 = System.currentTimeMillis();
            x.d("MicroMsg.ScanBankCardDecoder", "resolution:%s, coverage:%s", point, rect);
            if (true == this.qgi) {
                x.d("MicroMsg.ScanBankCardDecoder", "recognize bank succeed, no need more handle");
                z = false;
            } else {
                int focusedEngineForBankcardInit;
                int i3;
                float min = Math.min(Math.min(((float) point.x) / ((float) rect.width()), ((float) point.y) / ((float) rect.height())), 1.15f);
                int width = (((int) (((float) rect.width()) * (1.0f + ((min - 1.0f) * 1.6f)))) / 4) * 4;
                int height = (((int) (((float) rect.height()) * min)) / 4) * 4;
                x.d("MicroMsg.ScanBankCardDecoder", "rate:%f, cropWidth:%d, cropHeight:%d", Float.valueOf(min), Integer.valueOf(width), Integer.valueOf(height));
                if (!this.qgj) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    focusedEngineForBankcardInit = QbarNative.focusedEngineForBankcardInit(width, height, 8, this.qge);
                    x.d("MicroMsg.ScanBankCardDecoder", "focusedEngineForBankcardInit, cost: " + (System.currentTimeMillis() - currentTimeMillis3));
                    if (focusedEngineForBankcardInit != 0) {
                        x.e("MicroMsg.ScanBankCardDecoder", "init failed on init focusedEngine:" + focusedEngineForBankcardInit);
                        z = false;
                    } else {
                        this.qgj = true;
                    }
                }
                if (!this.qgk && true == this.qgj) {
                    x.d("MicroMsg.ScanBankCardDecoder", "init param:%d, %d, %d, %d, %s", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(rect.width()), Integer.valueOf(rect.height()), Boolean.valueOf(this.qge));
                    this.qgk = LibCardRecog.recognizeBankCardInit(width, height, this.qge) == 0;
                }
                x.d("MicroMsg.ScanBankCardDecoder", "crop image start:%d, %d, dataLen:%d", Integer.valueOf(rect.left - ((width - rect.width()) / 2)), Integer.valueOf(rect.top - ((height - rect.height()) / 2)), Integer.valueOf(bArr.length));
                String value = com.tencent.mm.j.g.Af().getValue("debug_scan_bank");
                if (value != null && value.equals("true")) {
                    this.mCount++;
                    i3 = point.x;
                    int i4 = point.y;
                    int i5 = this.mCount;
                    String str = "_scanImage_org.jpeg";
                    YuvImage yuvImage = new YuvImage(bArr, 17, i3, i4, null);
                    x.d("MicroMsg.ScanBankCardDecoder", "decode() compress jpeg by YuvImage");
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(new Rect(0, 0, i3, i4), 100, byteArrayOutputStream);
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    FileOutputStream fileOutputStream = null;
                    FileOutputStream fileOutputStream2;
                    try {
                        fileOutputStream2 = new FileOutputStream(new File(h.getExternalStorageDirectory().getAbsolutePath() + "/test/" + String.valueOf(i5) + str));
                        try {
                            fileOutputStream2.write(toByteArray);
                            fileOutputStream2.flush();
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e2, "", new Object[0]);
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e22, "", new Object[0]);
                            }
                        } catch (IOException e3) {
                            e22 = e3;
                            try {
                                x.e("MicroMsg.ScanBankCardDecoder", " Exception in decode() ApiTask : [%s]", e22.getMessage());
                                x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e22, "", new Object[0]);
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (Throwable e222) {
                                        x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e222, "", new Object[0]);
                                    }
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable e2222) {
                                    x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e2222, "", new Object[0]);
                                }
                                currentTimeMillis = System.currentTimeMillis();
                                bankCardInfo = new BankCardInfo(point.x, point.y);
                                recognizeBankCardProcess = LibCardRecog.recognizeBankCardProcess(bArr, point.y, point.x, r15, r16, height, width, bankCardInfo, this.qgh);
                                x.d("MicroMsg.ScanBankCardDecoder", "recognize bankcard cost: " + (System.currentTimeMillis() - currentTimeMillis));
                                if (!this.qgf) {
                                    z2 = this.qgh[0];
                                    this.qgh[0] = this.qgh[2];
                                    this.qgh[2] = z2;
                                    z2 = this.qgh[1];
                                    this.qgh[1] = this.qgh[3];
                                    this.qgh[3] = z2;
                                }
                                x.d("MicroMsg.ScanBankCardDecoder", "scan bankcard retCode:" + recognizeBankCardProcess);
                                if (recognizeBankCardProcess != 1) {
                                    x.d("MicroMsg.ScanBankCardDecoder", "scan bank failed:" + recognizeBankCardProcess);
                                    z = false;
                                } else {
                                    options = new Options();
                                    options.inSampleSize = 1;
                                    this.qgl = BitmapFactory.decodeByteArray(bankCardInfo.bitmapData, 0, bankCardInfo.bitmapLen, options).copy(Config.ARGB_8888, true);
                                    if (this.qgl == null) {
                                        z = false;
                                    } else {
                                        rectX = bankCardInfo.getRectX();
                                        rectY = bankCardInfo.getRectY();
                                        i = (rectX[bankCardInfo.getCardNumLen() - 1] - rectX[0]) + (rectX[1] - rectX[0]);
                                        recognizeBankCardProcess = (int) (((float) i) * 0.21319798f);
                                        i2 = (int) (((float) rectX[0]) - (((float) i) * 0.04568528f));
                                        i3 = i2 > 0 ? i2 : 0;
                                        i2 = ((int) (((float) (i * 2)) * 0.04568528f)) + i;
                                        focusedEngineForBankcardInit = (int) ((((float) rectY[0]) + ((((float) (rectX[1] - rectX[0])) * 1.3333334f) / 2.0f)) - ((float) (recognizeBankCardProcess / 2)));
                                        if (focusedEngineForBankcardInit <= 0) {
                                            focusedEngineForBankcardInit = 0;
                                        }
                                        if (i3 + i2 > bankCardInfo.width) {
                                            i2 = bankCardInfo.width - i3;
                                        }
                                        if (focusedEngineForBankcardInit + recognizeBankCardProcess > bankCardInfo.height) {
                                            recognizeBankCardProcess = bankCardInfo.height - focusedEngineForBankcardInit;
                                        }
                                        this.qgl = Bitmap.createBitmap(this.qgl, i3, focusedEngineForBankcardInit, i2, recognizeBankCardProcess);
                                        qfE = 3;
                                        if (this.qgg) {
                                            this.qfD = bankCardInfo.getCardNum();
                                        } else {
                                            this.qfD = LibCardRecog.recognizeBankCardSegmentNumber(bankCardInfo.getCardNum(), bankCardInfo.getCardNumLen(), rectX);
                                        }
                                        this.qgi = true;
                                        x.d("MicroMsg.ScanBankCardDecoder", "decode cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                                        z = true;
                                    }
                                }
                                return z;
                            } catch (Throwable th) {
                                e2222 = th;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable e4) {
                                        x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e4, "", new Object[0]);
                                    }
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable e42) {
                                    x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e42, "", new Object[0]);
                                }
                                throw e2222;
                            }
                        }
                    } catch (IOException e5) {
                        e2222 = e5;
                        fileOutputStream2 = null;
                        x.e("MicroMsg.ScanBankCardDecoder", " Exception in decode() ApiTask : [%s]", e2222.getMessage());
                        x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e2222, "", new Object[0]);
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        byteArrayOutputStream.close();
                        currentTimeMillis = System.currentTimeMillis();
                        bankCardInfo = new BankCardInfo(point.x, point.y);
                        recognizeBankCardProcess = LibCardRecog.recognizeBankCardProcess(bArr, point.y, point.x, r15, r16, height, width, bankCardInfo, this.qgh);
                        x.d("MicroMsg.ScanBankCardDecoder", "recognize bankcard cost: " + (System.currentTimeMillis() - currentTimeMillis));
                        if (this.qgf) {
                            z2 = this.qgh[0];
                            this.qgh[0] = this.qgh[2];
                            this.qgh[2] = z2;
                            z2 = this.qgh[1];
                            this.qgh[1] = this.qgh[3];
                            this.qgh[3] = z2;
                        }
                        x.d("MicroMsg.ScanBankCardDecoder", "scan bankcard retCode:" + recognizeBankCardProcess);
                        if (recognizeBankCardProcess != 1) {
                            options = new Options();
                            options.inSampleSize = 1;
                            this.qgl = BitmapFactory.decodeByteArray(bankCardInfo.bitmapData, 0, bankCardInfo.bitmapLen, options).copy(Config.ARGB_8888, true);
                            if (this.qgl == null) {
                                rectX = bankCardInfo.getRectX();
                                rectY = bankCardInfo.getRectY();
                                i = (rectX[bankCardInfo.getCardNumLen() - 1] - rectX[0]) + (rectX[1] - rectX[0]);
                                recognizeBankCardProcess = (int) (((float) i) * 0.21319798f);
                                i2 = (int) (((float) rectX[0]) - (((float) i) * 0.04568528f));
                                if (i2 > 0) {
                                }
                                i2 = ((int) (((float) (i * 2)) * 0.04568528f)) + i;
                                focusedEngineForBankcardInit = (int) ((((float) rectY[0]) + ((((float) (rectX[1] - rectX[0])) * 1.3333334f) / 2.0f)) - ((float) (recognizeBankCardProcess / 2)));
                                if (focusedEngineForBankcardInit <= 0) {
                                    focusedEngineForBankcardInit = 0;
                                }
                                if (i3 + i2 > bankCardInfo.width) {
                                    i2 = bankCardInfo.width - i3;
                                }
                                if (focusedEngineForBankcardInit + recognizeBankCardProcess > bankCardInfo.height) {
                                    recognizeBankCardProcess = bankCardInfo.height - focusedEngineForBankcardInit;
                                }
                                this.qgl = Bitmap.createBitmap(this.qgl, i3, focusedEngineForBankcardInit, i2, recognizeBankCardProcess);
                                qfE = 3;
                                if (this.qgg) {
                                    this.qfD = LibCardRecog.recognizeBankCardSegmentNumber(bankCardInfo.getCardNum(), bankCardInfo.getCardNumLen(), rectX);
                                } else {
                                    this.qfD = bankCardInfo.getCardNum();
                                }
                                this.qgi = true;
                                x.d("MicroMsg.ScanBankCardDecoder", "decode cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                                z = true;
                            } else {
                                z = false;
                            }
                        } else {
                            x.d("MicroMsg.ScanBankCardDecoder", "scan bank failed:" + recognizeBankCardProcess);
                            z = false;
                        }
                        return z;
                    } catch (Throwable th2) {
                        e2222 = th2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        byteArrayOutputStream.close();
                        throw e2222;
                    }
                }
                currentTimeMillis = System.currentTimeMillis();
                bankCardInfo = new BankCardInfo(point.x, point.y);
                recognizeBankCardProcess = LibCardRecog.recognizeBankCardProcess(bArr, point.y, point.x, r15, r16, height, width, bankCardInfo, this.qgh);
                x.d("MicroMsg.ScanBankCardDecoder", "recognize bankcard cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (this.qgf) {
                    z2 = this.qgh[0];
                    this.qgh[0] = this.qgh[2];
                    this.qgh[2] = z2;
                    z2 = this.qgh[1];
                    this.qgh[1] = this.qgh[3];
                    this.qgh[3] = z2;
                }
                x.d("MicroMsg.ScanBankCardDecoder", "scan bankcard retCode:" + recognizeBankCardProcess);
                if (recognizeBankCardProcess != 1) {
                    x.d("MicroMsg.ScanBankCardDecoder", "scan bank failed:" + recognizeBankCardProcess);
                    z = false;
                } else {
                    options = new Options();
                    options.inSampleSize = 1;
                    this.qgl = BitmapFactory.decodeByteArray(bankCardInfo.bitmapData, 0, bankCardInfo.bitmapLen, options).copy(Config.ARGB_8888, true);
                    if (this.qgl == null) {
                        z = false;
                    } else {
                        rectX = bankCardInfo.getRectX();
                        rectY = bankCardInfo.getRectY();
                        i = (rectX[bankCardInfo.getCardNumLen() - 1] - rectX[0]) + (rectX[1] - rectX[0]);
                        recognizeBankCardProcess = (int) (((float) i) * 0.21319798f);
                        i2 = (int) (((float) rectX[0]) - (((float) i) * 0.04568528f));
                        if (i2 > 0) {
                        }
                        i2 = ((int) (((float) (i * 2)) * 0.04568528f)) + i;
                        focusedEngineForBankcardInit = (int) ((((float) rectY[0]) + ((((float) (rectX[1] - rectX[0])) * 1.3333334f) / 2.0f)) - ((float) (recognizeBankCardProcess / 2)));
                        if (focusedEngineForBankcardInit <= 0) {
                            focusedEngineForBankcardInit = 0;
                        }
                        if (i3 + i2 > bankCardInfo.width) {
                            i2 = bankCardInfo.width - i3;
                        }
                        if (focusedEngineForBankcardInit + recognizeBankCardProcess > bankCardInfo.height) {
                            recognizeBankCardProcess = bankCardInfo.height - focusedEngineForBankcardInit;
                        }
                        this.qgl = Bitmap.createBitmap(this.qgl, i3, focusedEngineForBankcardInit, i2, recognizeBankCardProcess);
                        qfE = 3;
                        if (this.qgg) {
                            this.qfD = bankCardInfo.getCardNum();
                        } else {
                            this.qfD = LibCardRecog.recognizeBankCardSegmentNumber(bankCardInfo.getCardNum(), bankCardInfo.getCardNumLen(), rectX);
                        }
                        this.qgi = true;
                        x.d("MicroMsg.ScanBankCardDecoder", "decode cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public final void kM() {
        synchronized (this.qgm) {
            if (true == this.qgj) {
                QbarNative.focusedEngineRelease();
                this.qgj = false;
            }
            if (true == this.qgk) {
                LibCardRecog.recognizeBankCardRelease();
            }
            this.qgl = null;
        }
    }

    public final void bqd() {
        kM();
    }

    public final Bitmap bqk() {
        Bitmap bitmap;
        synchronized (this.qgm) {
            bitmap = this.qgl;
        }
        return bitmap;
    }
}
