package com.tencent.mm.plugin.appbrand.r;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class j {
    private static final Comparator<e> jXQ = new Comparator<e>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            e eVar = (e) obj;
            e eVar2 = (e) obj2;
            int i = eVar.x - eVar2.x;
            return i == 0 ? eVar.y - eVar2.y : i;
        }
    };

    public static abstract class a {
        public abstract int alm();

        public abstract int aln();

        public abstract boolean bW(int i, int i2);

        public abstract boolean bX(int i, int i2);

        public Object bY(int i, int i2) {
            return null;
        }
    }

    private static class c {
        int jXY;
        int jXZ;
        boolean jYa;

        public c(int i, int i2, boolean z) {
            this.jXY = i;
            this.jXZ = i2;
            this.jYa = z;
        }
    }

    static class e {
        boolean jYa;
        boolean jYf;
        public int size;
        public int x;
        public int y;

        e() {
        }
    }

    static class d {
        int jYb;
        int jYc;
        int jYd;
        int jYe;

        public d(int i, int i2) {
            this.jYb = 0;
            this.jYc = i;
            this.jYd = 0;
            this.jYe = i2;
        }
    }

    public static class b {
        public final List<e> jXR;
        public final int[] jXS;
        private final int[] jXT;
        public final a jXU;
        public final int jXV;
        public final int jXW;
        private final boolean jXX;

        b(a aVar, List<e> list, int[] iArr, int[] iArr2, boolean z) {
            this.jXR = list;
            this.jXS = iArr;
            this.jXT = iArr2;
            Arrays.fill(this.jXS, 0);
            Arrays.fill(this.jXT, 0);
            this.jXU = aVar;
            this.jXV = aVar.alm();
            this.jXW = aVar.aln();
            this.jXX = z;
            e eVar = this.jXR.isEmpty() ? null : (e) this.jXR.get(0);
            if (!(eVar != null && eVar.x == 0 && eVar.y == 0)) {
                eVar = new e();
                eVar.x = 0;
                eVar.y = 0;
                eVar.jYa = false;
                eVar.size = 0;
                eVar.jYf = false;
                this.jXR.add(0, eVar);
            }
            ams();
        }

        private void ams() {
            int i = this.jXV;
            int i2 = this.jXW;
            for (int size = this.jXR.size() - 1; size >= 0; size--) {
                e eVar = (e) this.jXR.get(size);
                int i3 = eVar.x + eVar.size;
                int i4 = eVar.y + eVar.size;
                if (this.jXX) {
                    while (i > i3) {
                        if (this.jXS[i - 1] == 0) {
                            c(i, i2, size, false);
                        }
                        i--;
                    }
                    while (i2 > i4) {
                        if (this.jXT[i2 - 1] == 0) {
                            c(i, i2, size, true);
                        }
                        i2--;
                    }
                }
                for (i2 = 0; i2 < eVar.size; i2++) {
                    i3 = eVar.x + i2;
                    i4 = eVar.y + i2;
                    i = this.jXU.bX(i3, i4) ? 1 : 2;
                    this.jXS[i3] = (i4 << 5) | i;
                    this.jXT[i4] = i | (i3 << 5);
                }
                i = eVar.x;
                i2 = eVar.y;
            }
        }

        private boolean c(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            int i6;
            int i7 = 8;
            if (z) {
                i4 = i2 - 1;
                i2--;
                i5 = i;
                i6 = i4;
            } else {
                i6 = i - 1;
                i5 = i - 1;
            }
            while (i3 >= 0) {
                e eVar = (e) this.jXR.get(i3);
                int i8 = eVar.x + eVar.size;
                int i9 = eVar.y + eVar.size;
                if (z) {
                    for (i5--; i5 >= i8; i5--) {
                        if (this.jXU.bW(i5, i6)) {
                            i4 = this.jXU.bX(i5, i6) ? 8 : 4;
                            this.jXT[i6] = (i5 << 5) | 16;
                            this.jXS[i5] = i4 | (i6 << 5);
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (i5 = i2 - 1; i5 >= i9; i5--) {
                        if (this.jXU.bW(i6, i5)) {
                            if (!this.jXU.bX(i6, i5)) {
                                i7 = 4;
                            }
                            this.jXS[i - 1] = (i5 << 5) | 16;
                            this.jXT[i5] = i7 | ((i - 1) << 5);
                            return true;
                        }
                    }
                    continue;
                }
                i5 = eVar.x;
                i2 = eVar.y;
                i3--;
            }
            return false;
        }

        private static c b(List<c> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                c cVar = (c) list.get(size);
                if (cVar.jXY == i && cVar.jYa == z) {
                    list.remove(size);
                    while (true) {
                        int i2 = size;
                        if (i2 >= list.size()) {
                            return cVar;
                        }
                        c cVar2 = (c) list.get(i2);
                        cVar2.jXZ = (z ? 1 : -1) + cVar2.jXZ;
                        size = i2 + 1;
                    }
                } else {
                    size--;
                }
            }
            return null;
        }

        public final void a(List<c> list, k kVar, int i, int i2, int i3) {
            if (this.jXX) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    int i5 = this.jXT[i3 + i4] & 31;
                    switch (i5) {
                        case 0:
                            kVar.bS(i, 1);
                            for (c cVar : list) {
                                cVar.jXZ++;
                            }
                            break;
                        case 4:
                        case 8:
                            int i6 = this.jXT[i3 + i4] >> 5;
                            kVar.bU(b(list, i6, true).jXZ, i);
                            if (i5 != 4) {
                                break;
                            }
                            kVar.d(i, 1, this.jXU.bY(i6, i3 + i4));
                            break;
                        case 16:
                            list.add(new c(i3 + i4, i, false));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                    }
                }
                return;
            }
            kVar.bS(i, i2);
        }

        public final void b(List<c> list, k kVar, int i, int i2, int i3) {
            if (this.jXX) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    int i5 = this.jXS[i3 + i4] & 31;
                    switch (i5) {
                        case 0:
                            kVar.bT(i + i4, 1);
                            for (c cVar : list) {
                                cVar.jXZ--;
                            }
                            break;
                        case 4:
                        case 8:
                            int i6 = this.jXS[i3 + i4] >> 5;
                            c b = b(list, i6, false);
                            kVar.bU(i + i4, b.jXZ - 1);
                            if (i5 != 4) {
                                break;
                            }
                            kVar.d(b.jXZ - 1, 1, this.jXU.bY(i3 + i4, i6));
                            break;
                        case 16:
                            list.add(new c(i3 + i4, i + i4, true));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                    }
                }
                return;
            }
            kVar.bT(i, i2);
        }
    }

    public static b a(a aVar, boolean z) {
        int alm = aVar.alm();
        int aln = aVar.aln();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList2.add(new d(alm, aln));
        int abs = (alm + aln) + Math.abs(alm - aln);
        int[] iArr = new int[(abs * 2)];
        int[] iArr2 = new int[(abs * 2)];
        List arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            d dVar = (d) arrayList2.remove(arrayList2.size() - 1);
            e a = a(aVar, dVar.jYb, dVar.jYc, dVar.jYd, dVar.jYe, iArr, iArr2, abs);
            if (a != null) {
                if (a.size > 0) {
                    arrayList.add(a);
                }
                a.x += dVar.jYb;
                a.y += dVar.jYd;
                d dVar2 = arrayList3.isEmpty() ? new d() : (d) arrayList3.remove(arrayList3.size() - 1);
                dVar2.jYb = dVar.jYb;
                dVar2.jYd = dVar.jYd;
                if (a.jYf) {
                    dVar2.jYc = a.x;
                    dVar2.jYe = a.y;
                } else if (a.jYa) {
                    dVar2.jYc = a.x - 1;
                    dVar2.jYe = a.y;
                } else {
                    dVar2.jYc = a.x;
                    dVar2.jYe = a.y - 1;
                }
                arrayList2.add(dVar2);
                if (!a.jYf) {
                    dVar.jYb = a.x + a.size;
                    dVar.jYd = a.y + a.size;
                } else if (a.jYa) {
                    dVar.jYb = (a.x + a.size) + 1;
                    dVar.jYd = a.y + a.size;
                } else {
                    dVar.jYb = a.x + a.size;
                    dVar.jYd = (a.y + a.size) + 1;
                }
                arrayList2.add(dVar);
            } else {
                arrayList3.add(dVar);
            }
        }
        Collections.sort(arrayList, jXQ);
        return new b(aVar, arrayList, iArr, iArr2, z);
    }

    private static e a(a aVar, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i2 - i <= 0 || i4 - i3 <= 0) {
            return null;
        }
        int i8 = i6 - i7;
        int i9 = ((i6 + i7) + 1) / 2;
        Arrays.fill(iArr, (i5 - i9) - 1, (i5 + i9) + 1, 0);
        Arrays.fill(iArr2, ((i5 - i9) - 1) + i8, ((i5 + i9) + 1) + i8, i6);
        Object obj = i8 % 2 != 0 ? 1 : null;
        int i10 = 0;
        while (i10 <= i9) {
            int i11;
            boolean z;
            int i12;
            e eVar;
            int i13 = -i10;
            while (i13 <= i10) {
                if (i13 == (-i10) || (i13 != i10 && iArr[(i5 + i13) - 1] < iArr[(i5 + i13) + 1])) {
                    i11 = iArr[(i5 + i13) + 1];
                    z = false;
                } else {
                    i11 = iArr[(i5 + i13) - 1] + 1;
                    z = true;
                }
                i12 = i11;
                i11 -= i13;
                while (i12 < i6 && i11 < i7 && aVar.bW(i + i12, i3 + i11)) {
                    i12++;
                    i11++;
                }
                iArr[i5 + i13] = i12;
                if (obj == null || i13 < (i8 - i10) + 1 || i13 > (i8 + i10) - 1 || iArr[i5 + i13] < iArr2[i5 + i13]) {
                    i13 += 2;
                } else {
                    eVar = new e();
                    eVar.x = iArr2[i5 + i13];
                    eVar.y = eVar.x - i13;
                    eVar.size = iArr[i5 + i13] - iArr2[i5 + i13];
                    eVar.jYa = z;
                    eVar.jYf = false;
                    return eVar;
                }
            }
            i13 = -i10;
            while (i13 <= i10) {
                int i14 = i13 + i8;
                if (i14 == i10 + i8 || (i14 != (-i10) + i8 && iArr2[(i5 + i14) - 1] < iArr2[(i5 + i14) + 1])) {
                    i11 = iArr2[(i5 + i14) - 1];
                    z = false;
                } else {
                    i11 = iArr2[(i5 + i14) + 1] - 1;
                    z = true;
                }
                i12 = i11;
                i11 -= i14;
                while (i12 > 0 && i11 > 0 && aVar.bW((i + i12) - 1, (i3 + i11) - 1)) {
                    i12--;
                    i11--;
                }
                iArr2[i5 + i14] = i12;
                if (obj != null || i13 + i8 < (-i10) || i13 + i8 > i10 || iArr[i5 + i14] < iArr2[i5 + i14]) {
                    i13 += 2;
                } else {
                    eVar = new e();
                    eVar.x = iArr2[i5 + i14];
                    eVar.y = eVar.x - i14;
                    eVar.size = iArr[i5 + i14] - iArr2[i5 + i14];
                    eVar.jYa = z;
                    eVar.jYf = true;
                    return eVar;
                }
            }
            i10++;
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
}
