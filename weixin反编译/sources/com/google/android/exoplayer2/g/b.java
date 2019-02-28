package com.google.android.exoplayer2.g;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class b extends d {
    private static final int[] azX = new int[0];
    private final com.google.android.exoplayer2.g.e.a azY;
    private final AtomicReference<b> azZ;

    public static final class b {
        public final String aAa;
        public final String aAb;
        public final int aAc;
        public final int aAd;
        public final int aAe;
        public final boolean aAf;
        public final boolean aAg;
        public final boolean aAh;
        public final boolean aAi;
        public final boolean aAj;
        public final int viewportHeight;
        public final int viewportWidth;

        public b() {
            this((byte) 0);
        }

        private b(byte b) {
            this.aAa = null;
            this.aAb = null;
            this.aAh = false;
            this.aAi = true;
            this.aAc = Integer.MAX_VALUE;
            this.aAd = Integer.MAX_VALUE;
            this.aAe = Integer.MAX_VALUE;
            this.aAf = true;
            this.aAj = true;
            this.viewportWidth = Integer.MAX_VALUE;
            this.viewportHeight = Integer.MAX_VALUE;
            this.aAg = true;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.aAh == bVar.aAh && this.aAi == bVar.aAi && this.aAc == bVar.aAc && this.aAd == bVar.aAd && this.aAf == bVar.aAf && this.aAj == bVar.aAj && this.aAg == bVar.aAg && this.viewportWidth == bVar.viewportWidth && this.viewportHeight == bVar.viewportHeight && this.aAe == bVar.aAe && TextUtils.equals(this.aAa, bVar.aAa) && TextUtils.equals(this.aAb, bVar.aAb)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int i;
            int i2 = 1;
            int hashCode = ((this.aAh ? 1 : 0) + (((this.aAa.hashCode() * 31) + this.aAb.hashCode()) * 31)) * 31;
            if (this.aAi) {
                i = 1;
            } else {
                i = 0;
            }
            hashCode = (((((((i + hashCode) * 31) + this.aAc) * 31) + this.aAd) * 31) + this.aAe) * 31;
            if (this.aAf) {
                i = 1;
            } else {
                i = 0;
            }
            hashCode = (i + hashCode) * 31;
            if (this.aAj) {
                i = 1;
            } else {
                i = 0;
            }
            i = (i + hashCode) * 31;
            if (!this.aAg) {
                i2 = 0;
            }
            return ((((i + i2) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
        }
    }

    private static final class a {
        public final int aef;
        public final String mimeType;
        public final int sampleRate;

        public a(int i, int i2, String str) {
            this.aef = i;
            this.sampleRate = i2;
            this.mimeType = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.aef == aVar.aef && this.sampleRate == aVar.sampleRate && TextUtils.equals(this.mimeType, aVar.mimeType)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.mimeType != null ? this.mimeType.hashCode() : 0) + (((this.aef * 31) + this.sampleRate) * 31);
        }
    }

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.azY = null;
        this.azZ = new AtomicReference(new b());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final com.google.android.exoplayer2.g.e[] a(com.google.android.exoplayer2.s[] r27, com.google.android.exoplayer2.source.m[] r28, int[][][] r29) {
        /*
        r26 = this;
        r0 = r27;
        r0 = r0.length;
        r19 = r0;
        r0 = r19;
        r0 = new com.google.android.exoplayer2.g.e[r0];
        r20 = r0;
        r0 = r26;
        r2 = r0.azZ;
        r2 = r2.get();
        r10 = r2;
        r10 = (com.google.android.exoplayer2.g.b.b) r10;
        r17 = 0;
        r3 = 0;
        r2 = 0;
        r18 = r2;
        r2 = r3;
    L_0x001d:
        r0 = r18;
        r1 = r19;
        if (r0 >= r1) goto L_0x0111;
    L_0x0023:
        r3 = 2;
        r4 = r27[r18];
        r4 = r4.getTrackType();
        if (r3 != r4) goto L_0x0175;
    L_0x002c:
        if (r2 != 0) goto L_0x008b;
    L_0x002e:
        r3 = r27[r18];
        r21 = r28[r18];
        r22 = r29[r18];
        r0 = r26;
        r0 = r0.azY;
        r23 = r0;
        r2 = 0;
        if (r23 == 0) goto L_0x007a;
    L_0x003d:
        r2 = r10.aAi;
        if (r2 == 0) goto L_0x009b;
    L_0x0041:
        r4 = 24;
    L_0x0043:
        r2 = r10.aAh;
        if (r2 == 0) goto L_0x009e;
    L_0x0047:
        r2 = r3.hV();
        r2 = r2 & r4;
        if (r2 == 0) goto L_0x009e;
    L_0x004e:
        r2 = 1;
        r11 = r2;
    L_0x0050:
        r2 = 0;
        r12 = r2;
    L_0x0052:
        r0 = r21;
        r2 = r0.length;
        if (r12 >= r2) goto L_0x0109;
    L_0x0058:
        r0 = r21;
        r2 = r0.asG;
        r2 = r2[r12];
        r3 = r22[r12];
        r6 = r10.aAc;
        r7 = r10.aAd;
        r8 = r10.aAe;
        r5 = r10.viewportWidth;
        r9 = r10.viewportHeight;
        r13 = r10.aAg;
        r14 = r2.length;
        r15 = 2;
        if (r14 >= r15) goto L_0x00a1;
    L_0x0071:
        r2 = azX;
    L_0x0073:
        r2 = r2.length;
        if (r2 <= 0) goto L_0x0104;
    L_0x0076:
        r2 = r23.lk();
    L_0x007a:
        if (r2 != 0) goto L_0x0084;
    L_0x007c:
        r0 = r21;
        r1 = r22;
        r2 = a(r0, r1, r10);
    L_0x0084:
        r20[r18] = r2;
        r2 = r20[r18];
        if (r2 == 0) goto L_0x010c;
    L_0x008a:
        r2 = 1;
    L_0x008b:
        r3 = r28[r18];
        r3 = r3.length;
        if (r3 <= 0) goto L_0x010f;
    L_0x0091:
        r3 = 1;
    L_0x0092:
        r3 = r3 | r17;
    L_0x0094:
        r4 = r18 + 1;
        r18 = r4;
        r17 = r3;
        goto L_0x001d;
    L_0x009b:
        r4 = 16;
        goto L_0x0043;
    L_0x009e:
        r2 = 0;
        r11 = r2;
        goto L_0x0050;
    L_0x00a1:
        r9 = a(r2, r5, r9, r13);
        r5 = r9.size();
        r13 = 2;
        if (r5 >= r13) goto L_0x00af;
    L_0x00ac:
        r2 = azX;
        goto L_0x0073;
    L_0x00af:
        r15 = 0;
        if (r11 != 0) goto L_0x0172;
    L_0x00b2:
        r24 = new java.util.HashSet;
        r24.<init>();
        r14 = 0;
        r5 = 0;
        r16 = r5;
    L_0x00bb:
        r5 = r9.size();
        r0 = r16;
        if (r0 >= r5) goto L_0x00ef;
    L_0x00c3:
        r0 = r16;
        r5 = r9.get(r0);
        r5 = (java.lang.Integer) r5;
        r5 = r5.intValue();
        r13 = r2.arZ;
        r5 = r13[r5];
        r5 = r5.adV;
        r0 = r24;
        r13 = r0.add(r5);
        if (r13 == 0) goto L_0x016e;
    L_0x00dd:
        r13 = a(r2, r3, r4, r5, r6, r7, r8, r9);
        if (r13 <= r14) goto L_0x016e;
    L_0x00e3:
        r25 = r13;
        r13 = r5;
        r5 = r25;
    L_0x00e8:
        r14 = r16 + 1;
        r16 = r14;
        r15 = r13;
        r14 = r5;
        goto L_0x00bb;
    L_0x00ef:
        r5 = r15;
    L_0x00f0:
        b(r2, r3, r4, r5, r6, r7, r8, r9);
        r2 = r9.size();
        r3 = 2;
        if (r2 >= r3) goto L_0x00fe;
    L_0x00fa:
        r2 = azX;
        goto L_0x0073;
    L_0x00fe:
        r2 = com.google.android.exoplayer2.i.t.o(r9);
        goto L_0x0073;
    L_0x0104:
        r2 = r12 + 1;
        r12 = r2;
        goto L_0x0052;
    L_0x0109:
        r2 = 0;
        goto L_0x007a;
    L_0x010c:
        r2 = 0;
        goto L_0x008b;
    L_0x010f:
        r3 = 0;
        goto L_0x0092;
    L_0x0111:
        r3 = 0;
        r4 = 0;
        r2 = 0;
        r5 = r2;
    L_0x0115:
        r0 = r19;
        if (r5 >= r0) goto L_0x016d;
    L_0x0119:
        r2 = r27[r5];
        r2 = r2.getTrackType();
        switch(r2) {
            case 1: goto L_0x0137;
            case 2: goto L_0x0134;
            case 3: goto L_0x0154;
            default: goto L_0x0122;
        };
    L_0x0122:
        r2 = r28[r5];
        r6 = r29[r5];
        r2 = c(r2, r6, r10);
        r20[r5] = r2;
    L_0x012c:
        r2 = r3;
        r3 = r4;
    L_0x012e:
        r4 = r5 + 1;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        goto L_0x0115;
    L_0x0134:
        r2 = r3;
        r3 = r4;
        goto L_0x012e;
    L_0x0137:
        if (r3 != 0) goto L_0x012c;
    L_0x0139:
        r3 = r28[r5];
        r6 = r29[r5];
        if (r17 == 0) goto L_0x014d;
    L_0x013f:
        r2 = 0;
    L_0x0140:
        r2 = a(r3, r6, r10, r2);
        r20[r5] = r2;
        r2 = r20[r5];
        if (r2 == 0) goto L_0x0152;
    L_0x014a:
        r2 = 1;
    L_0x014b:
        r3 = r4;
        goto L_0x012e;
    L_0x014d:
        r0 = r26;
        r2 = r0.azY;
        goto L_0x0140;
    L_0x0152:
        r2 = 0;
        goto L_0x014b;
    L_0x0154:
        if (r4 != 0) goto L_0x012c;
    L_0x0156:
        r2 = r28[r5];
        r4 = r29[r5];
        r2 = b(r2, r4, r10);
        r20[r5] = r2;
        r2 = r20[r5];
        if (r2 == 0) goto L_0x016b;
    L_0x0164:
        r2 = 1;
    L_0x0165:
        r25 = r3;
        r3 = r2;
        r2 = r25;
        goto L_0x012e;
    L_0x016b:
        r2 = 0;
        goto L_0x0165;
    L_0x016d:
        return r20;
    L_0x016e:
        r5 = r14;
        r13 = r15;
        goto L_0x00e8;
    L_0x0172:
        r5 = r15;
        goto L_0x00f0;
    L_0x0175:
        r3 = r17;
        goto L_0x0094;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.b.a(com.google.android.exoplayer2.s[], com.google.android.exoplayer2.source.m[], int[][][]):com.google.android.exoplayer2.g.e[]");
    }

    private static int a(l lVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            int i8 = i5;
            if (i7 >= list.size()) {
                return i8;
            }
            i5 = ((Integer) list.get(i7)).intValue();
            if (a(lVar.arZ[i5], str, iArr[i5], i, i2, i3, i4)) {
                i5 = i8 + 1;
            } else {
                i5 = i8;
            }
            i6 = i7 + 1;
        }
    }

    private static void b(l lVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) list.get(size)).intValue();
            if (!a(lVar.arZ[intValue], str, iArr[intValue], i, i2, i3, i4)) {
                list.remove(size);
            }
        }
    }

    private static boolean a(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        if (!l(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !t.h(format.adV, str)) {
            return false;
        }
        if (format.width != -1 && format.width > i3) {
            return false;
        }
        if (format.height != -1 && format.height > i4) {
            return false;
        }
        if (format.bitrate == -1 || format.bitrate <= i5) {
            return true;
        }
        return false;
    }

    private static e a(m mVar, int[][] iArr, b bVar) {
        l lVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        while (true) {
            int i6 = i2;
            if (i3 >= mVar.length) {
                break;
            }
            l lVar2 = mVar.asG[i3];
            List a = a(lVar2, bVar.viewportWidth, bVar.viewportHeight, bVar.aAg);
            int[] iArr2 = iArr[i3];
            int i7 = 0;
            while (i7 < lVar2.length) {
                l lVar3;
                if (l(iArr2[i7], bVar.aAj)) {
                    Format format = lVar2.arZ[i7];
                    Object obj = (!a.contains(Integer.valueOf(i7)) || ((format.width != -1 && format.width > bVar.aAc) || ((format.height != -1 && format.height > bVar.aAd) || (format.bitrate != -1 && format.bitrate > bVar.aAe)))) ? null : 1;
                    if (obj != null || bVar.aAf) {
                        i2 = obj != null ? 2 : 1;
                        boolean l = l(iArr2[i7], false);
                        if (l) {
                            i2 += 1000;
                        }
                        Object obj2 = i2 > i6 ? 1 : null;
                        if (i2 == i6) {
                            int ar;
                            if (format.ip() != i4) {
                                ar = ar(format.ip(), i4);
                            } else {
                                ar = ar(format.bitrate, i5);
                            }
                            obj2 = (!l || obj == null) ? ar < 0 ? 1 : null : ar > 0 ? 1 : null;
                        }
                        if (obj2 != null) {
                            i5 = format.bitrate;
                            i4 = format.ip();
                            i6 = i2;
                            lVar3 = lVar2;
                            i2 = i7;
                            i7++;
                            lVar = lVar3;
                            i = i2;
                        }
                    }
                }
                i2 = i;
                lVar3 = lVar;
                i7++;
                lVar = lVar3;
                i = i2;
            }
            i2 = i3 + 1;
        }
        return lVar == null ? null : new c(lVar, i);
    }

    private static int ar(int i, int i2) {
        return i == -1 ? i2 == -1 ? 0 : -1 : i2 == -1 ? 1 : i - i2;
    }

    private static e a(m mVar, int[][] iArr, b bVar, com.google.android.exoplayer2.g.e.a aVar) {
        int i;
        l lVar;
        int[] iArr2;
        int i2;
        int i3;
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        for (i = 0; i < mVar.length; i++) {
            lVar = mVar.asG[i];
            iArr2 = iArr[i];
            i2 = 0;
            while (i2 < lVar.length) {
                if (l(iArr2[i2], bVar.aAj)) {
                    Format format = lVar.arZ[i2];
                    int i7 = iArr2[i2];
                    String str = bVar.aAa;
                    Object obj = (format.aek & 1) != 0 ? 1 : null;
                    i3 = a(format, str) ? obj != null ? 4 : 3 : obj != null ? 2 : 1;
                    if (l(i7, false)) {
                        i3 += 1000;
                    }
                    if (i3 > i6) {
                        i5 = i3;
                        i4 = i2;
                        i3 = i;
                        i2++;
                        i6 = i5;
                        i5 = i4;
                        i4 = i3;
                    }
                }
                i3 = i4;
                i4 = i5;
                i5 = i6;
                i2++;
                i6 = i5;
                i5 = i4;
                i4 = i3;
            }
        }
        if (i4 == -1) {
            return null;
        }
        lVar = mVar.asG[i4];
        if (aVar != null) {
            int[] iArr3;
            iArr2 = iArr[i4];
            boolean z = bVar.aAh;
            i2 = 0;
            a aVar2 = null;
            HashSet hashSet = new HashSet();
            i3 = 0;
            while (i3 < lVar.length) {
                Format format2 = lVar.arZ[i3];
                a aVar3 = new a(format2.aef, format2.sampleRate, z ? null : format2.adV);
                if (hashSet.add(aVar3)) {
                    i4 = a(lVar, iArr2, aVar3);
                    if (i4 > i2) {
                        i6 = i4;
                        i2 = i6;
                        i3++;
                        aVar2 = aVar3;
                    }
                }
                aVar3 = aVar2;
                i6 = i2;
                i2 = i6;
                i3++;
                aVar2 = aVar3;
            }
            if (i2 > 1) {
                int[] iArr4 = new int[i2];
                i4 = 0;
                for (i = 0; i < lVar.length; i++) {
                    if (a(lVar.arZ[i], iArr2[i], aVar2)) {
                        i2 = i4 + 1;
                        iArr4[i4] = i;
                        i4 = i2;
                    }
                }
                iArr3 = iArr4;
            } else {
                iArr3 = azX;
            }
            if (iArr3.length > 0) {
                return aVar.lk();
            }
        }
        return new c(lVar, i5);
    }

    private static int a(l lVar, int[] iArr, a aVar) {
        int i = 0;
        int i2 = 0;
        while (i < lVar.length) {
            if (a(lVar.arZ[i], iArr[i], aVar)) {
                i2++;
            }
            i++;
        }
        return i2;
    }

    private static boolean a(Format format, int i, a aVar) {
        if (!l(i, false) || format.aef != aVar.aef || format.sampleRate != aVar.sampleRate) {
            return false;
        }
        if (aVar.mimeType == null || TextUtils.equals(aVar.mimeType, format.adV)) {
            return true;
        }
        return false;
    }

    private static e b(m mVar, int[][] iArr, b bVar) {
        l lVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2;
            if (i3 >= mVar.length) {
                break;
            }
            l lVar2 = mVar.asG[i3];
            int[] iArr2 = iArr[i3];
            int i5 = 0;
            while (i5 < lVar2.length) {
                l lVar3;
                if (l(iArr2[i5], bVar.aAj)) {
                    Format format = lVar2.arZ[i5];
                    Object obj = (format.aek & 1) != 0 ? 1 : null;
                    Object obj2 = (format.aek & 2) != 0 ? 1 : null;
                    if (a(format, bVar.aAb)) {
                        if (obj != null) {
                            i2 = 6;
                        } else if (obj2 == null) {
                            i2 = 5;
                        } else {
                            i2 = 4;
                        }
                    } else if (obj != null) {
                        i2 = 3;
                    } else if (obj2 != null) {
                        if (a(format, bVar.aAa)) {
                            i2 = 2;
                        } else {
                            i2 = 1;
                        }
                    }
                    if (l(iArr2[i5], false)) {
                        i2 += 1000;
                    }
                    if (i2 > i4) {
                        i4 = i2;
                        lVar3 = lVar2;
                        i2 = i5;
                        i5++;
                        lVar = lVar3;
                        i = i2;
                    }
                }
                i2 = i;
                lVar3 = lVar;
                i5++;
                lVar = lVar3;
                i = i2;
            }
            i2 = i3 + 1;
        }
        return lVar == null ? null : new c(lVar, i);
    }

    private static e c(m mVar, int[][] iArr, b bVar) {
        boolean z = false;
        int i = 0;
        l lVar = null;
        for (int i2 = 0; i2 < mVar.length; i2++) {
            l lVar2 = mVar.asG[i2];
            int[] iArr2 = iArr[i2];
            int i3 = 0;
            while (i3 < lVar2.length) {
                boolean z2;
                int i4;
                l lVar3;
                if (l(iArr2[i3], bVar.aAj)) {
                    if ((lVar2.arZ[i3].aek & 1) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (l(iArr2[i3], false)) {
                        z2 += 1000;
                    }
                    if (z2 > z) {
                        i4 = i3;
                        lVar3 = lVar2;
                        i3++;
                        lVar = lVar3;
                        i = i4;
                        z = z2;
                    }
                }
                z2 = z;
                i4 = i;
                lVar3 = lVar;
                i3++;
                lVar = lVar3;
                i = i4;
                z = z2;
            }
        }
        if (lVar == null) {
            return null;
        }
        return new c(lVar, i);
    }

    private static boolean l(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    private static boolean a(Format format, String str) {
        return str != null && TextUtils.equals(str, t.ah(format.ael));
    }

    private static List<Integer> a(l lVar, int i, int i2, boolean z) {
        int i3;
        ArrayList arrayList = new ArrayList(lVar.length);
        for (i3 = 0; i3 < lVar.length; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            return arrayList;
        }
        int i4 = Integer.MAX_VALUE;
        for (i3 = 0; i3 < lVar.length; i3++) {
            Format format = lVar.arZ[i3];
            if (format.width > 0 && format.height > 0) {
                int i5;
                int i6;
                Point point;
                int i7 = format.width;
                int i8 = format.height;
                if (z) {
                    Object obj;
                    Object obj2;
                    if (i7 > i8) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (i > i2) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj != obj2) {
                        i5 = i;
                        i6 = i2;
                        if (i7 * i5 < i8 * i6) {
                            point = new Point(i6, t.at(i6 * i8, i7));
                        } else {
                            point = new Point(t.at(i5 * i7, i8), i5);
                        }
                        i5 = format.width * format.height;
                        if (format.width >= ((int) (((float) point.x) * 0.98f)) && format.height >= ((int) (((float) point.y) * 0.98f)) && i5 < i4) {
                            i4 = i5;
                        }
                    }
                }
                i5 = i2;
                i6 = i;
                if (i7 * i5 < i8 * i6) {
                    point = new Point(t.at(i5 * i7, i8), i5);
                } else {
                    point = new Point(i6, t.at(i6 * i8, i7));
                }
                i5 = format.width * format.height;
                i4 = i5;
            }
        }
        if (i4 != Integer.MAX_VALUE) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                i3 = lVar.arZ[((Integer) arrayList.get(size)).intValue()].ip();
                if (i3 == -1 || i3 > i4) {
                    arrayList.remove(size);
                }
            }
        }
        return arrayList;
    }
}
