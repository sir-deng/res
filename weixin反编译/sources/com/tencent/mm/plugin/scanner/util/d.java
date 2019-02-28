package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class d extends b {
    private static QbarNative qfL = new QbarNative();
    private Object hrp = new Object();
    public volatile boolean mWf = false;
    public boolean ozC = true;
    public boolean qcF = false;
    public boolean qfK = false;
    public int qfM;
    private byte[] qfN;
    private byte[] qfO;

    /* renamed from: com.tencent.mm.plugin.scanner.util.d$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ byte[] idb;
        final /* synthetic */ Point qfP;

        public AnonymousClass1(byte[] bArr, Point point) {
            this.idb = bArr;
            this.qfP = point;
        }

        public final void run() {
            if (d.this.a(this.idb, this.qfP)) {
                ah.y(new Runnable() {
                    public final void run() {
                        if (d.this.qfA != null) {
                            d.this.qfA.a(b.qfE, d.this.qfD, d.this.qfC, d.this.fqW, d.this.fqX);
                        }
                    }
                });
            } else {
                ah.y(new Runnable() {
                    public final void run() {
                        if (d.this.qfA != null) {
                            d.this.qfA.bpp();
                        }
                    }
                });
            }
        }
    }

    public d(a aVar, int i, boolean z) {
        super(aVar);
        this.qfM = i;
        this.ozC = z;
    }

    private synchronized byte[] a(byte[] bArr, Point point, Rect rect, Point point2) {
        byte[] bArr2;
        if (bArr != null) {
            if (bArr.length > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                Rect rect2 = new Rect();
                int width;
                int height;
                if (com.tencent.mm.compatible.e.d.ys() || this.ozC) {
                    width = rect.width() % 4;
                    height = rect.height() % 4;
                    rect2.left = rect.left;
                    rect2.right = rect.right - width;
                    rect2.top = rect.top;
                    rect2.bottom = rect.bottom - height;
                    if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                        bArr2 = null;
                    }
                } else {
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
                        bArr2 = null;
                    }
                }
                c cVar = new c(bArr, point.x, point.y, rect2);
                point2.x = cVar.width;
                point2.y = cVar.height;
                int i = 0;
                if (!com.tencent.mm.compatible.e.d.ys()) {
                    i = 90;
                    point2.x = cVar.height;
                    point2.y = cVar.width;
                }
                x.d("MicroMsg.scanner.QBarDecoder", "rotate angle: " + i);
                if (this.qfN == null) {
                    this.qfN = new byte[(((cVar.width * cVar.height) * 3) / 2)];
                    this.qfO = new byte[(cVar.width * cVar.height)];
                    x.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes = null, new byte[%s]", Integer.valueOf(((cVar.width * cVar.height) * 3) / 2));
                } else if (this.qfN.length != ((cVar.width * cVar.height) * 3) / 2) {
                    this.qfN = null;
                    this.qfN = new byte[(((cVar.width * cVar.height) * 3) / 2)];
                    this.qfO = null;
                    this.qfO = new byte[(cVar.width * cVar.height)];
                    x.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes size change, new byte[%s]", Integer.valueOf(((cVar.width * cVar.height) * 3) / 2));
                }
                if (QbarNative.a(this.qfN, new int[]{point2.x, point2.y}, bArr, point.x, point.y, cVar.left, cVar.top, cVar.width, cVar.height, i) != 1) {
                    x.e("MicroMsg.scanner.QBarDecoder", "decode pro_result %s", Integer.valueOf(QbarNative.a(this.qfN, new int[]{point2.x, point2.y}, bArr, point.x, point.y, cVar.left, cVar.top, cVar.width, cVar.height, i)));
                    bArr2 = null;
                } else {
                    System.arraycopy(this.qfN, 0, this.qfO, 0, this.qfO.length);
                    x.d("MicroMsg.scanner.QBarDecoder", "decode, rotate and gray, cost:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    bArr2 = this.qfO;
                }
            }
        }
        x.w("MicroMsg.scanner.QBarDecoder", "prepareGrayData , data is null");
        bArr2 = null;
        return bArr2;
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        Point point2 = new Point();
        byte[] a = a(bArr, point, rect, point2);
        if (a == null || a.length <= 0) {
            return false;
        }
        return a(a, point2);
    }

    public final synchronized byte[] a(byte[] bArr, Point point, int i, Rect rect, Point point2) {
        if (270 == i) {
            byte[] bArr2 = new byte[bArr.length];
            QbarNative.a(bArr2, bArr, point.x, point.y);
            bArr = new byte[bArr.length];
            QbarNative.a(bArr, bArr2, point.y, point.x);
            QbarNative.nativeRelease();
        }
        return a(bArr, point, rect, point2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(byte[] r17, android.graphics.Point r18) {
        /*
        r16 = this;
        r4 = java.lang.System.currentTimeMillis();
        r2 = "MicroMsg.scanner.QBarDecoder";
        r3 = "decode() start";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r0 = r16;
        r2 = r0.mWf;
        if (r2 == 0) goto L_0x001e;
    L_0x0013:
        r2 = "MicroMsg.scanner.QBarDecoder";
        r3 = "is decoding, return false";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r2 = 0;
    L_0x001d:
        return r2;
    L_0x001e:
        r0 = r16;
        r2 = r0.qcF;
        if (r2 == 0) goto L_0x002f;
    L_0x0024:
        r2 = "MicroMsg.scanner.QBarDecoder";
        r3 = "isReleasing, return false 1";
        com.tencent.mm.sdk.platformtools.x.w(r2, r3);
        r2 = 0;
        goto L_0x001d;
    L_0x002f:
        if (r17 != 0) goto L_0x003c;
    L_0x0031:
        r2 = "MicroMsg.scanner.QBarDecoder";
        r3 = "wrong args";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r2 = 0;
        goto L_0x001d;
    L_0x003c:
        r0 = r16;
        r6 = r0.hrp;
        monitor-enter(r6);
        r2 = 1;
        r0 = r16;
        r0.mWf = r2;	 Catch:{ all -> 0x0071 }
        r2 = 0;
        r0 = r16;
        r0.qfD = r2;	 Catch:{ all -> 0x0071 }
        r2 = 0;
        r0 = r16;
        r0.fqX = r2;	 Catch:{ all -> 0x0071 }
        r0 = r16;
        r0.fqW = r2;	 Catch:{ all -> 0x0071 }
        r2 = com.tencent.mm.plugin.scanner.a.l.pYQ;	 Catch:{ all -> 0x0071 }
        r2.bpn();	 Catch:{ all -> 0x0071 }
        r0 = r16;
        r2 = r0.qfM;	 Catch:{ Exception -> 0x01b6 }
        r3 = 0;
        r0 = r16;
        r2 = r0.ds(r2, r3);	 Catch:{ Exception -> 0x01b6 }
        if (r2 != 0) goto L_0x0074;
    L_0x0066:
        r16.kM();	 Catch:{ Exception -> 0x01b6 }
        r2 = 0;
        r0 = r16;
        r0.mWf = r2;	 Catch:{ Exception -> 0x01b6 }
        r2 = 0;
        monitor-exit(r6);	 Catch:{ all -> 0x0071 }
        goto L_0x001d;
    L_0x0071:
        r2 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0071 }
        throw r2;
    L_0x0074:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01b6 }
        r7 = "MicroMsg.scanner.QBarDecoder";
        r8 = "data len %d, image size %s";
        r9 = 2;
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x01b6 }
        r10 = 0;
        r0 = r17;
        r11 = r0.length;	 Catch:{ Exception -> 0x01b6 }
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ Exception -> 0x01b6 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x01b6 }
        r10 = 1;
        r9[r10] = r18;	 Catch:{ Exception -> 0x01b6 }
        com.tencent.mm.sdk.platformtools.x.i(r7, r8, r9);	 Catch:{ Exception -> 0x01b6 }
        r7 = qfL;	 Catch:{ Exception -> 0x01b6 }
        r0 = r18;
        r8 = r0.x;	 Catch:{ Exception -> 0x01b6 }
        r0 = r18;
        r9 = r0.y;	 Catch:{ Exception -> 0x01b6 }
        r0 = r17;
        r7 = r7.t(r0, r8, r9);	 Catch:{ Exception -> 0x01b6 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01b6 }
        r8 = r8 - r2;
        r2 = qfL;	 Catch:{ Exception -> 0x01b6 }
        r3 = com.tencent.qbar.QbarNative.zZR;	 Catch:{ Exception -> 0x01b6 }
        r10 = r2.zZW;	 Catch:{ Exception -> 0x01b6 }
        r2 = r2.GetPossibleInfo(r3, r10);	 Catch:{ Exception -> 0x01b6 }
        if (r2 == 0) goto L_0x016c;
    L_0x00b2:
        r2 = com.tencent.qbar.QbarNative.zZR;	 Catch:{ Exception -> 0x01b6 }
        r2 = r2.hasQrcode;	 Catch:{ Exception -> 0x01b6 }
    L_0x00b6:
        if (r2 == 0) goto L_0x016f;
    L_0x00b8:
        r2 = 1;
        r3 = r2;
    L_0x00ba:
        r2 = qfL;	 Catch:{ Exception -> 0x01b6 }
        r10 = com.tencent.qbar.QbarNative.zZR;	 Catch:{ Exception -> 0x01b6 }
        r11 = r2.zZW;	 Catch:{ Exception -> 0x01b6 }
        r2 = r2.GetPossibleInfo(r10, r11);	 Catch:{ Exception -> 0x01b6 }
        if (r2 == 0) goto L_0x0173;
    L_0x00c6:
        r2 = com.tencent.qbar.QbarNative.zZR;	 Catch:{ Exception -> 0x01b6 }
        r2 = r2.qrcodeAreaRatio;	 Catch:{ Exception -> 0x01b6 }
    L_0x00ca:
        r10 = "MicroMsg.scanner.QBarDecoder";
        r11 = "after scanImage, result:%d,hasCode: %s, areaRatio: %f";
        r12 = 3;
        r12 = new java.lang.Object[r12];	 Catch:{ Exception -> 0x01b6 }
        r13 = 0;
        r14 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x01b6 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x01b6 }
        r13 = 1;
        r14 = java.lang.Boolean.valueOf(r3);	 Catch:{ Exception -> 0x01b6 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x01b6 }
        r13 = 2;
        r14 = java.lang.Float.valueOf(r2);	 Catch:{ Exception -> 0x01b6 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x01b6 }
        com.tencent.mm.sdk.platformtools.x.i(r10, r11, r12);	 Catch:{ Exception -> 0x01b6 }
        if (r7 > 0) goto L_0x012a;
    L_0x00ed:
        if (r3 == 0) goto L_0x012a;
    L_0x00ef:
        r0 = r16;
        r3 = r0.qfA;	 Catch:{ Exception -> 0x01b6 }
        if (r3 == 0) goto L_0x012a;
    L_0x00f5:
        r3 = 1036831949; // 0x3dcccccd float:0.1 double:5.122630465E-315;
        r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r3 >= 0) goto L_0x012a;
    L_0x00fc:
        r3 = new android.os.Bundle;	 Catch:{ Exception -> 0x01b6 }
        r3.<init>();	 Catch:{ Exception -> 0x01b6 }
        r10 = "zoom_action";
        r11 = 6;
        r3.putInt(r10, r11);	 Catch:{ Exception -> 0x01b6 }
        r10 = "zoom_type";
        r11 = 1;
        r3.putInt(r10, r11);	 Catch:{ Exception -> 0x01b6 }
        r10 = "zoom_scale";
        r12 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r11 = 1036831949; // 0x3dcccccd float:0.1 double:5.122630465E-315;
        r2 = r11 / r2;
        r14 = (double) r2;	 Catch:{ Exception -> 0x01b6 }
        r14 = java.lang.Math.sqrt(r14);	 Catch:{ Exception -> 0x01b6 }
        r12 = r12 * r14;
        r2 = (int) r12;	 Catch:{ Exception -> 0x01b6 }
        r3.putInt(r10, r2);	 Catch:{ Exception -> 0x01b6 }
        r0 = r16;
        r2 = r0.qfA;	 Catch:{ Exception -> 0x01b6 }
        r2.D(r3);	 Catch:{ Exception -> 0x01b6 }
    L_0x012a:
        r2 = com.tencent.mm.plugin.scanner.a.l.pYQ;	 Catch:{ Exception -> 0x01b6 }
        r0 = r18;
        r3 = r0.x;	 Catch:{ Exception -> 0x01b6 }
        r0 = r18;
        r10 = r0.y;	 Catch:{ Exception -> 0x01b6 }
        r2.do(r3, r10);	 Catch:{ Exception -> 0x01b6 }
        r2 = com.tencent.mm.plugin.scanner.a.l.pYQ;	 Catch:{ Exception -> 0x01b6 }
        r2.bpo();	 Catch:{ Exception -> 0x01b6 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01b6 }
        r2 = r2 - r4;
        r10 = com.tencent.mm.plugin.scanner.a.l.pYQ;	 Catch:{ Exception -> 0x01b6 }
        r10.ef(r8);	 Catch:{ Exception -> 0x01b6 }
        r10 = "MicroMsg.scanner.QBarDecoder";
        r11 = "decode ScanImage %s, cost:%d";
        r12 = 2;
        r12 = new java.lang.Object[r12];	 Catch:{ Exception -> 0x01b6 }
        r13 = 0;
        r14 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x01b6 }
        r12[r13] = r14;	 Catch:{ Exception -> 0x01b6 }
        r13 = 1;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x01b6 }
        r12[r13] = r2;	 Catch:{ Exception -> 0x01b6 }
        com.tencent.mm.sdk.platformtools.x.d(r10, r11, r12);	 Catch:{ Exception -> 0x01b6 }
        r2 = 1;
        if (r7 == r2) goto L_0x0176;
    L_0x0163:
        r2 = 0;
        r0 = r16;
        r0.mWf = r2;	 Catch:{ Exception -> 0x01b6 }
        r2 = 0;
        monitor-exit(r6);	 Catch:{ all -> 0x0071 }
        goto L_0x001d;
    L_0x016c:
        r2 = 0;
        goto L_0x00b6;
    L_0x016f:
        r2 = 0;
        r3 = r2;
        goto L_0x00ba;
    L_0x0173:
        r2 = 0;
        goto L_0x00ca;
    L_0x0176:
        r2 = com.tencent.mm.plugin.scanner.a.l.pYQ;	 Catch:{ Exception -> 0x01b6 }
        r2.bpm();	 Catch:{ Exception -> 0x01b6 }
        r2 = com.tencent.mm.plugin.scanner.a.l.pYQ;	 Catch:{ Exception -> 0x01b6 }
        r2.eg(r8);	 Catch:{ Exception -> 0x01b6 }
        r16.bqh();	 Catch:{ Exception -> 0x01b6 }
    L_0x0183:
        r2 = 0;
        r0 = r16;
        r0.mWf = r2;	 Catch:{ all -> 0x0071 }
        r2 = "MicroMsg.scanner.QBarDecoder";
        r3 = "decode() finish, resultText = [%s], cost:%d";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0071 }
        r8 = 0;
        r0 = r16;
        r9 = r0.qfD;	 Catch:{ all -> 0x0071 }
        r7[r8] = r9;	 Catch:{ all -> 0x0071 }
        r8 = 1;
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0071 }
        r4 = r10 - r4;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0071 }
        r7[r8] = r4;	 Catch:{ all -> 0x0071 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r7);	 Catch:{ all -> 0x0071 }
        r0 = r16;
        r2 = r0.qfD;	 Catch:{ all -> 0x0071 }
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);	 Catch:{ all -> 0x0071 }
        if (r2 != 0) goto L_0x01c4;
    L_0x01b2:
        r2 = 1;
    L_0x01b3:
        monitor-exit(r6);	 Catch:{ all -> 0x0071 }
        goto L_0x001d;
    L_0x01b6:
        r2 = move-exception;
        r3 = "MicroMsg.scanner.QBarDecoder";
        r7 = "decodeInternal error";
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x0071 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r7, r8);	 Catch:{ all -> 0x0071 }
        goto L_0x0183;
    L_0x01c4:
        r2 = 0;
        goto L_0x01b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.util.d.a(byte[], android.graphics.Point):boolean");
    }

    public static Set<Integer> dr(int i, int i2) {
        Set<Integer> hashSet = new HashSet();
        if (i == 1) {
            if (i2 != 1) {
                hashSet.add(Integer.valueOf(2));
                hashSet.add(Integer.valueOf(3));
                hashSet.add(Integer.valueOf(4));
                hashSet.add(Integer.valueOf(5));
            } else {
                hashSet.add(Integer.valueOf(2));
                hashSet.add(Integer.valueOf(3));
                hashSet.add(Integer.valueOf(5));
            }
        } else if (i == 2) {
            if (i2 != 1) {
                hashSet.add(Integer.valueOf(0));
                hashSet.add(Integer.valueOf(3));
                hashSet.add(Integer.valueOf(4));
            } else {
                hashSet.add(Integer.valueOf(0));
                hashSet.add(Integer.valueOf(3));
            }
        } else if (i == 0) {
            if (i2 != 1) {
                hashSet.add(Integer.valueOf(2));
                hashSet.add(Integer.valueOf(0));
                hashSet.add(Integer.valueOf(3));
                hashSet.add(Integer.valueOf(4));
                hashSet.add(Integer.valueOf(5));
            } else {
                hashSet.add(Integer.valueOf(2));
                hashSet.add(Integer.valueOf(0));
                hashSet.add(Integer.valueOf(3));
                hashSet.add(Integer.valueOf(5));
            }
        } else if (i == 3 && i2 != 1) {
            hashSet.add(Integer.valueOf(2));
            hashSet.add(Integer.valueOf(5));
        }
        return hashSet;
    }

    private boolean ds(int i, int i2) {
        if (this.qfK) {
            return this.qfK;
        }
        return a(i2, dr(i, i2));
    }

    public final int f(Set<Integer> set) {
        int i = 0;
        if (!(set == null || set.isEmpty())) {
            int[] iArr = new int[set.size()];
            int i2 = 0;
            for (Integer num : set) {
                if (num != null) {
                    int i3 = i2 + 1;
                    iArr[i2] = num.intValue();
                    i2 = i3;
                }
            }
            x.i("MicroMsg.scanner.QBarDecoder", "QBarNative.SetReaders, readers:%s", Arrays.toString(iArr));
            synchronized (this.hrp) {
                QbarNative qbarNative = qfL;
                i = qbarNative.SetReaders(iArr, iArr.length, qbarNative.zZW);
            }
        }
        return i;
    }

    private boolean a(int i, Set<Integer> set) {
        if (!(this.qfK || set == null || set.isEmpty())) {
            QbarNative qbarNative = qfL;
            String str = "ANY";
            String str2 = "UTF-8";
            if (qbarNative.zZW < 0) {
                qbarNative.zZW = qbarNative.Init(2, 0, i, str, str2);
            }
            int i2 = qbarNative.zZW < 0 ? -1 : 1;
            l.pYQ.pZe = set.contains(Integer.valueOf(5));
            x.i("MicroMsg.scanner.QBarDecoder", "QbarNative.Init = [%s], SetReaders = [%s], version = [%s]", Integer.valueOf(i2), Integer.valueOf(f(set)), QbarNative.getVersion());
            if (i2 <= 0 || r3 <= 0) {
                x.e("MicroMsg.scanner.QBarDecoder", "QbarNative failed, releaseDecoder 1");
                return false;
            }
            this.qfK = true;
        }
        return this.qfK;
    }

    private void bqh() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        StringBuilder stringBuilder4 = new StringBuilder();
        int[] iArr = new int[2];
        if (qfL.a(stringBuilder, stringBuilder2, stringBuilder3, stringBuilder4, iArr) == 1) {
            x.d("MicroMsg.scanner.QBarDecoder", "decode type:%s, sCharset: %s, sBinaryMethod: %s, data:%s, gResult:%s", stringBuilder.toString(), stringBuilder3.toString(), stringBuilder4.toString(), stringBuilder2.toString(), Integer.valueOf(qfL.a(stringBuilder, stringBuilder2, stringBuilder3, stringBuilder4, iArr)));
            if (!bi.oN(stringBuilder2.toString())) {
                String stringBuilder5 = stringBuilder.toString();
                if (stringBuilder5.equals("QR_CODE") || stringBuilder5.equals("WX_CODE")) {
                    this.qfD = stringBuilder2.toString();
                    qfE = 1;
                } else {
                    this.qfD = stringBuilder5 + "," + stringBuilder2;
                    qfE = 2;
                }
            }
            this.fqW = p.Js(stringBuilder.toString());
            this.fqX = iArr[0];
        }
        l lVar = l.pYQ;
        String stringBuilder6 = stringBuilder.toString();
        String str = this.qfD;
        String stringBuilder7 = stringBuilder3.toString();
        int i = iArr[0];
        int i2 = iArr[1];
        x.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s", stringBuilder6, str, stringBuilder7, Integer.valueOf(i), Integer.valueOf(i2), stringBuilder4.toString());
        lVar.pYW = stringBuilder6;
        lVar.pYX = str;
        lVar.pYY = stringBuilder7;
        lVar.pYZ = i;
        lVar.pZa = i2;
        lVar.pZb = r4;
    }

    public final void kM() {
        x.d("MicroMsg.scanner.QBarDecoder", "releaseDecoder() start, hasInitQBar = %s", Boolean.valueOf(this.qfK));
        this.qcF = true;
        synchronized (this.hrp) {
            if (this.qfK) {
                this.qfK = false;
                x.d("MicroMsg.scanner.QBarDecoder", "QbarNative.Release() = [%s]", Integer.valueOf(0));
                x.d("MicroMsg.scanner.QBarDecoder", "ImgProcessScan.Release() = [%s]", Integer.valueOf(0));
            }
        }
        c.bqe();
    }

    public final void bqd() {
        if (this.qfK) {
            kM();
            this.qfK = false;
        }
        this.qcF = false;
        this.mWf = false;
    }

    public final com.tencent.mm.plugin.ac.a.d a(f.a aVar, Set<Integer> set) {
        com.tencent.mm.plugin.ac.a.d dVar = new com.tencent.mm.plugin.ac.a.d();
        synchronized (this.hrp) {
            try {
                this.qfD = null;
                if (set != null && !set.isEmpty() && !a(0, (Set) set)) {
                    kM();
                    this.mWf = false;
                    dVar = null;
                } else if (ds(0, 1)) {
                    int i;
                    x.d("MicroMsg.scanner.QBarDecoder", "directScanQRCodeImg, lumSrc==null:%b", Boolean.valueOf(false));
                    if (aVar.bqg() != null) {
                        x.i("MicroMsg.scanner.QBarDecoder", "directScanQRCodeImg, lumSrc.getMatrix.length: %d, lumSrc.getWidth: %d, lumSrc.getHeight: %d", Integer.valueOf(aVar.bqg().length), Integer.valueOf(aVar.width), Integer.valueOf(aVar.height));
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (aVar.bqg() == null || aVar.width * aVar.height != aVar.bqg().length) {
                        i = -1;
                    } else {
                        l.pYQ.do(aVar.width, aVar.height);
                        i = qfL.t(aVar.bqg(), aVar.width, aVar.height);
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    x.d("MicroMsg.scanner.QBarDecoder", "directScanQRCodeImg decode ScanImage %s, cost: %s", Integer.valueOf(i), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                    l.pYQ.ef(currentTimeMillis2 - currentTimeMillis);
                    l.pYQ.bpn();
                    if (i != 1) {
                        this.mWf = false;
                        dVar = null;
                    } else {
                        l.pYQ.bpm();
                        l.pYQ.eg(currentTimeMillis2 - currentTimeMillis);
                        bqh();
                        dVar.result = this.qfD;
                        dVar.fqW = this.fqW;
                        dVar.fqX = this.fqX;
                    }
                } else {
                    kM();
                    this.mWf = false;
                    dVar = null;
                }
            } catch (Throwable e) {
                x.e("MicroMsg.scanner.QBarDecoder", " Exception in directScanQRCodeImg() " + e.getMessage());
                x.printErrStackTrace("MicroMsg.scanner.QBarDecoder", e, "", new Object[0]);
            }
        }
        return dVar;
    }
}
