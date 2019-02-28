package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.plugin.licence.model.CardInfo;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

public final class k extends b {
    private final Object lock = new Object();
    private final int qgP;
    private Bitmap qgQ;
    public Bitmap qgR;
    private boolean[] qgh = new boolean[4];
    private boolean qgi = false;
    private boolean qgk = false;

    public k(a aVar, int i) {
        super(aVar);
        this.qgP = i;
    }

    public final boolean[] bqu() {
        boolean[] zArr;
        synchronized (this.lock) {
            zArr = this.qgh;
        }
        return zArr;
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        boolean z;
        x.d("MicroMsg.ScanLicenceDecoder", "smoothie, decode, resolution = %s, coverage = %s, data.length = %d", point, rect, Integer.valueOf(bArr.length));
        synchronized (this.lock) {
            if (!(this.qgQ == null || this.qgQ.isRecycled())) {
                x.d("MicroMsg.ScanLicenceDecoder", "[smoothie] recycle last bitmap");
                this.qgQ.recycle();
            }
            x.d("MicroMsg.ScanLicenceDecoder", "resolution:%s, coverage:%s", point, rect);
            if (this.qgi) {
                x.d("MicroMsg.ScanLicenceDecoder", "recognize id succeed, no need more handle");
                z = false;
            } else {
                int i;
                for (i = 0; i < 4; i++) {
                    this.qgh[i] = false;
                }
                float min = Math.min(Math.min(((float) point.x) / ((float) rect.width()), ((float) point.y) / ((float) rect.height())), 1.0f);
                int width = rect.width();
                int height = rect.height();
                x.d("MicroMsg.ScanLicenceDecoder", "rate:%f, cropWidth:%d, cropHeight:%d", Float.valueOf(min), Integer.valueOf(width), Integer.valueOf(height));
                if (!this.qgk) {
                    x.d("MicroMsg.ScanLicenceDecoder", "init param:%d, %d, %d, %d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(rect.width()), Integer.valueOf(rect.height()));
                    try {
                        LibCardRecog.recognizeCardInit(width, height, this.qgP);
                        this.qgk = true;
                    } catch (Exception e) {
                        x.e("MicroMsg.ScanLicenceDecoder", "lib init failed, exp = %s", e);
                        this.qgk = false;
                        bqv();
                        z = false;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                CardInfo cardInfo = new CardInfo(width, height);
                int i2 = rect.top;
                try {
                    i = LibCardRecog.recognizeCardProcess(bArr, point.y, point.x, rect.left, i2, height, width, cardInfo, this.qgh);
                    x.d("MicroMsg.ScanLicenceDecoder", "[smoothie] recognizeProcess, ret = %d", Integer.valueOf(i));
                    x.d("MicroMsg.ScanLicenceDecoder", "focusedEngineProcess cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    x.d("MicroMsg.ScanLicenceDecoder", "mRecogRectEdge: %s", Arrays.toString(this.qgh));
                    if (i == 0) {
                        z = false;
                    } else if (1 != i) {
                        for (i = 0; i < 4; i++) {
                            this.qgh[i] = false;
                        }
                        x.d("MicroMsg.ScanLicenceDecoder", "image is not enough clear");
                        z = false;
                    } else {
                        for (i = 0; i < 4; i++) {
                            this.qgh[i] = true;
                        }
                        this.qgQ = BitmapFactory.decodeByteArray(cardInfo.bitmapData, 0, cardInfo.bitmapLen);
                        this.qgR = this.qgQ.copy(Config.ARGB_8888, true);
                        this.qgi = true;
                        z = true;
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.ScanLicenceDecoder", "recognizeProcess failed, exp = %s", e2);
                    this.qgi = false;
                    z = false;
                }
            }
        }
        return z;
    }

    public final void kM() {
        if (!(this.qgQ == null || this.qgQ.isRecycled())) {
            this.qgQ.recycle();
        }
        bqv();
    }

    public final void bqd() {
        this.qgi = false;
    }

    private static void bqv() {
        x.i("MicroMsg.ScanLicenceDecoder", "lib release");
        try {
            LibCardRecog.recognizeCardRelease();
        } catch (Exception e) {
            x.e("MicroMsg.ScanLicenceDecoder", "lib release, exp = %s", e);
        }
    }
}
