package com.tencent.tinker.a.a;

import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Arrays;

public final class t {
    public final a AoA = new a(0, true);
    public final a AoB = new a(1, true);
    public final a AoC = new a(2, true);
    public final a AoD = new a(3, true);
    public final a AoE = new a(4, true);
    public final a AoF = new a(5, true);
    public final a AoG = new a(6, true);
    public final a AoH = new a(Downloads.RECV_BUFFER_SIZE, true);
    public final a AoI = new a(4097, true);
    public final a AoJ = new a(4098, true);
    public final a AoK = new a(4099, true);
    public final a AoL = new a(8192, false);
    public final a AoM = new a(8193, true);
    public final a AoN = new a(8194, false);
    public final a AoO = new a(8195, false);
    public final a AoP = new a(8196, false);
    public final a AoQ = new a(8197, false);
    public final a AoR = new a(8198, true);
    public final a[] AoS = new a[]{this.AoA, this.AoB, this.AoC, this.AoD, this.AoE, this.AoF, this.AoG, this.AoH, this.AoI, this.AoJ, this.AoK, this.AoL, this.AoM, this.AoN, this.AoO, this.AoP, this.AoQ, this.AoR};
    public int AoT;
    public int AoU;
    public int AoV;
    public int AoW;
    public byte[] Aoo = new byte[20];
    public int fileSize;
    public int hZs;

    public static class a implements Comparable<a> {
        public final short AoX;
        public boolean AoY;
        public int AoZ = 0;
        public int dzH = -1;
        public int size = 0;

        public static abstract class a<T> implements Comparable<T> {
            public int dzH;

            public a(int i) {
                this.dzH = i;
            }

            public boolean equals(Object obj) {
                return compareTo(obj) == 0;
            }
        }

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            if (this.dzH != aVar.dzH) {
                return this.dzH < aVar.dzH ? -1 : 1;
            } else {
                int Iy = Iy(this.AoX);
                int Iy2 = Iy(aVar.AoX);
                if (Iy != Iy2) {
                    return Iy >= Iy2 ? 1 : -1;
                } else {
                    return 0;
                }
            }
        }

        public a(int i, boolean z) {
            this.AoX = (short) i;
            this.AoY = z;
            if (i == 0) {
                this.dzH = 0;
                this.size = 1;
                this.AoZ = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
            } else if (i == Downloads.RECV_BUFFER_SIZE) {
                this.size = 1;
            }
        }

        public final boolean exists() {
            return this.size > 0;
        }

        private static int Iy(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case Downloads.RECV_BUFFER_SIZE /*4096*/:
                    return 17;
                case 4097:
                    return 8;
                case 4098:
                    return 11;
                case 4099:
                    return 10;
                case 8192:
                    return 15;
                case 8193:
                    return 14;
                case 8194:
                    return 7;
                case 8195:
                    return 13;
                case 8196:
                    return 9;
                case 8197:
                    return 16;
                case 8198:
                    return 12;
                default:
                    throw new IllegalArgumentException("unknown section type: " + i);
            }
        }

        public final String toString() {
            return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[]{Short.valueOf(this.AoX), Integer.valueOf(this.dzH), Integer.valueOf(this.size)});
        }
    }

    final void a(e eVar) {
        int i;
        int i2 = eVar.aif.getInt();
        int i3 = 0;
        a aVar = null;
        while (i3 < i2) {
            short s = eVar.aif.getShort();
            eVar.aif.getShort();
            for (a aVar2 : this.AoS) {
                if (aVar2.AoX == s) {
                    i = eVar.aif.getInt();
                    int i4 = eVar.aif.getInt();
                    if ((aVar2.size == 0 || aVar2.size == i) && (aVar2.dzH == -1 || aVar2.dzH == i4)) {
                        aVar2.size = i;
                        aVar2.dzH = i4;
                        if (aVar == null || aVar.dzH <= aVar2.dzH) {
                            i3++;
                            aVar = aVar2;
                        } else {
                            throw new j("Map is unsorted at " + aVar + ", " + aVar2);
                        }
                    }
                    throw new j("Unexpected map value for 0x" + Integer.toHexString(s));
                }
            }
            throw new IllegalArgumentException("No such map item: " + s);
        }
        this.AoA.dzH = 0;
        Arrays.sort(this.AoS);
        for (i = 1; i < this.AoS.length; i++) {
            if (this.AoS[i].dzH == -1) {
                this.AoS[i].dzH = this.AoS[i - 1].dzH;
            }
        }
    }

    public final void cHH() {
        int i = this.fileSize;
        for (int length = this.AoS.length - 1; length >= 0; length--) {
            a aVar = this.AoS[length];
            if (aVar.dzH != -1) {
                if (aVar.dzH > i) {
                    throw new j("Map is unsorted at " + aVar);
                }
                aVar.AoZ = i - aVar.dzH;
                i = aVar.dzH;
            }
        }
        this.AoW = (((((this.AoA.AoZ + this.AoB.AoZ) + this.AoC.AoZ) + this.AoD.AoZ) + this.AoE.AoZ) + this.AoF.AoZ) + this.AoG.AoZ;
        this.AoV = this.fileSize - this.AoW;
    }

    public final void b(e eVar) {
        int i = 0;
        for (a exists : this.AoS) {
            if (exists.exists()) {
                i++;
            }
        }
        eVar.writeInt(i);
        for (a aVar : this.AoS) {
            if (aVar.exists()) {
                eVar.writeShort(aVar.AoX);
                eVar.writeShort((short) 0);
                eVar.writeInt(aVar.size);
                eVar.writeInt(aVar.dzH);
            }
        }
    }
}
