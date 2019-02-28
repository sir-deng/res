package com.google.android.gms.c;

import java.util.Arrays;
import org.xwalk.core.R;

public final class av extends ay<av> {
    public a[] aZw;

    public static final class a extends ay<a> {
        private static volatile a[] aZx;
        public a aZy;
        public String name;

        public static final class a extends ay<a> {
            private static volatile a[] aZz;
            public a aZA;
            public int type;

            public static final class a extends ay<a> {
                public byte[] aZB;
                public String aZC;
                public double aZD;
                public float aZE;
                public long aZF;
                public int aZG;
                public int aZH;
                public boolean aZI;
                public a[] aZJ;
                public a[] aZK;
                public String[] aZL;
                public long[] aZM;
                public float[] aZN;
                public long aZO;

                public a() {
                    this.aZB = bh.bat;
                    this.aZC = "";
                    this.aZD = 0.0d;
                    this.aZE = 0.0f;
                    this.aZF = 0;
                    this.aZG = 0;
                    this.aZH = 0;
                    this.aZI = false;
                    this.aZJ = a.pW();
                    this.aZK = a.pX();
                    this.aZL = bh.bar;
                    this.aZM = bh.ban;
                    this.aZN = bh.bao;
                    this.aZO = 0;
                    this.aZZ = null;
                    this.bak = -1;
                }

                public final /* synthetic */ be a(aw awVar) {
                    while (true) {
                        int pY = awVar.pY();
                        int qb;
                        Object obj;
                        int dw;
                        switch (pY) {
                            case 0:
                                break;
                            case 10:
                                byte[] dz;
                                qb = awVar.qb();
                                if (qb > awVar.aZQ - awVar.aZS || qb <= 0) {
                                    dz = awVar.dz(qb);
                                } else {
                                    dz = new byte[qb];
                                    System.arraycopy(awVar.buffer, awVar.aZS, dz, 0, qb);
                                    awVar.aZS = qb + awVar.aZS;
                                }
                                this.aZB = dz;
                                continue;
                            case 18:
                                this.aZC = awVar.readString();
                                continue;
                            case 25:
                                this.aZD = Double.longBitsToDouble(awVar.qd());
                                continue;
                            case 37:
                                this.aZE = Float.intBitsToFloat(awVar.qc());
                                continue;
                            case 40:
                                this.aZF = awVar.pZ();
                                continue;
                            case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                                this.aZG = awVar.qb();
                                continue;
                            case 56:
                                pY = awVar.qb();
                                this.aZH = (-(pY & 1)) ^ (pY >>> 1);
                                continue;
                            case 64:
                                this.aZI = awVar.qa();
                                continue;
                            case 74:
                                qb = bh.b(awVar, 74);
                                pY = this.aZJ == null ? 0 : this.aZJ.length;
                                obj = new a[(qb + pY)];
                                if (pY != 0) {
                                    System.arraycopy(this.aZJ, 0, obj, 0, pY);
                                }
                                while (pY < obj.length - 1) {
                                    obj[pY] = new a();
                                    awVar.a(obj[pY]);
                                    awVar.pY();
                                    pY++;
                                }
                                obj[pY] = new a();
                                awVar.a(obj[pY]);
                                this.aZJ = obj;
                                continue;
                            case 82:
                                qb = bh.b(awVar, 82);
                                pY = this.aZK == null ? 0 : this.aZK.length;
                                obj = new a[(qb + pY)];
                                if (pY != 0) {
                                    System.arraycopy(this.aZK, 0, obj, 0, pY);
                                }
                                while (pY < obj.length - 1) {
                                    obj[pY] = new a();
                                    awVar.a(obj[pY]);
                                    awVar.pY();
                                    pY++;
                                }
                                obj[pY] = new a();
                                awVar.a(obj[pY]);
                                this.aZK = obj;
                                continue;
                            case 90:
                                qb = bh.b(awVar, 90);
                                pY = this.aZL == null ? 0 : this.aZL.length;
                                obj = new String[(qb + pY)];
                                if (pY != 0) {
                                    System.arraycopy(this.aZL, 0, obj, 0, pY);
                                }
                                while (pY < obj.length - 1) {
                                    obj[pY] = awVar.readString();
                                    awVar.pY();
                                    pY++;
                                }
                                obj[pY] = awVar.readString();
                                this.aZL = obj;
                                continue;
                            case 96:
                                qb = bh.b(awVar, 96);
                                pY = this.aZM == null ? 0 : this.aZM.length;
                                obj = new long[(qb + pY)];
                                if (pY != 0) {
                                    System.arraycopy(this.aZM, 0, obj, 0, pY);
                                }
                                while (pY < obj.length - 1) {
                                    obj[pY] = awVar.pZ();
                                    awVar.pY();
                                    pY++;
                                }
                                obj[pY] = awVar.pZ();
                                this.aZM = obj;
                                continue;
                            case 98:
                                dw = awVar.dw(awVar.qb());
                                qb = awVar.getPosition();
                                pY = 0;
                                while (awVar.qf() > 0) {
                                    awVar.pZ();
                                    pY++;
                                }
                                awVar.dy(qb);
                                qb = this.aZM == null ? 0 : this.aZM.length;
                                Object obj2 = new long[(pY + qb)];
                                if (qb != 0) {
                                    System.arraycopy(this.aZM, 0, obj2, 0, qb);
                                }
                                while (qb < obj2.length) {
                                    obj2[qb] = awVar.pZ();
                                    qb++;
                                }
                                this.aZM = obj2;
                                awVar.dx(dw);
                                continue;
                            case 104:
                                this.aZO = awVar.pZ();
                                continue;
                            case 114:
                                pY = awVar.qb();
                                qb = awVar.dw(pY);
                                dw = pY / 4;
                                pY = this.aZN == null ? 0 : this.aZN.length;
                                Object obj3 = new float[(dw + pY)];
                                if (pY != 0) {
                                    System.arraycopy(this.aZN, 0, obj3, 0, pY);
                                }
                                while (pY < obj3.length) {
                                    obj3[pY] = Float.intBitsToFloat(awVar.qc());
                                    pY++;
                                }
                                this.aZN = obj3;
                                awVar.dx(qb);
                                continue;
                            case 117:
                                qb = bh.b(awVar, 117);
                                pY = this.aZN == null ? 0 : this.aZN.length;
                                obj = new float[(qb + pY)];
                                if (pY != 0) {
                                    System.arraycopy(this.aZN, 0, obj, 0, pY);
                                }
                                while (pY < obj.length - 1) {
                                    obj[pY] = Float.intBitsToFloat(awVar.qc());
                                    awVar.pY();
                                    pY++;
                                }
                                obj[pY] = Float.intBitsToFloat(awVar.qc());
                                this.aZN = obj;
                                continue;
                            default:
                                if (!a(awVar, pY)) {
                                    break;
                                }
                                continue;
                        }
                    }
                    return this;
                }

                public final void a(ax axVar) {
                    int i;
                    int i2 = 0;
                    if (!Arrays.equals(this.aZB, bh.bat)) {
                        byte[] bArr = this.aZB;
                        axVar.ay(1, 2);
                        axVar.dE(bArr.length);
                        axVar.l(bArr);
                    }
                    if (!this.aZC.equals("")) {
                        axVar.e(2, this.aZC);
                    }
                    if (Double.doubleToLongBits(this.aZD) != Double.doubleToLongBits(0.0d)) {
                        double d = this.aZD;
                        axVar.ay(3, 1);
                        long doubleToLongBits = Double.doubleToLongBits(d);
                        axVar.dC(((int) doubleToLongBits) & 255);
                        axVar.dC(((int) (doubleToLongBits >> 8)) & 255);
                        axVar.dC(((int) (doubleToLongBits >> 16)) & 255);
                        axVar.dC(((int) (doubleToLongBits >> 24)) & 255);
                        axVar.dC(((int) (doubleToLongBits >> 32)) & 255);
                        axVar.dC(((int) (doubleToLongBits >> 40)) & 255);
                        axVar.dC(((int) (doubleToLongBits >> 48)) & 255);
                        axVar.dC(((int) (doubleToLongBits >> 56)) & 255);
                    }
                    if (Float.floatToIntBits(this.aZE) != Float.floatToIntBits(0.0f)) {
                        axVar.d(4, this.aZE);
                    }
                    if (this.aZF != 0) {
                        axVar.h(5, this.aZF);
                    }
                    if (this.aZG != 0) {
                        axVar.aw(6, this.aZG);
                    }
                    if (this.aZH != 0) {
                        i = this.aZH;
                        axVar.ay(7, 0);
                        axVar.dE(ax.dG(i));
                    }
                    if (this.aZI) {
                        axVar.m(8, this.aZI);
                    }
                    if (this.aZJ != null && this.aZJ.length > 0) {
                        for (be beVar : this.aZJ) {
                            if (beVar != null) {
                                axVar.a(9, beVar);
                            }
                        }
                    }
                    if (this.aZK != null && this.aZK.length > 0) {
                        for (be beVar2 : this.aZK) {
                            if (beVar2 != null) {
                                axVar.a(10, beVar2);
                            }
                        }
                    }
                    if (this.aZL != null && this.aZL.length > 0) {
                        for (String str : this.aZL) {
                            if (str != null) {
                                axVar.e(11, str);
                            }
                        }
                    }
                    if (this.aZM != null && this.aZM.length > 0) {
                        for (long h : this.aZM) {
                            axVar.h(12, h);
                        }
                    }
                    if (this.aZO != 0) {
                        axVar.h(13, this.aZO);
                    }
                    if (this.aZN != null && this.aZN.length > 0) {
                        while (i2 < this.aZN.length) {
                            axVar.d(14, this.aZN[i2]);
                            i2++;
                        }
                    }
                    super.a(axVar);
                }

                public final boolean equals(Object obj) {
                    if (obj == this) {
                        return true;
                    }
                    if (!(obj instanceof a)) {
                        return false;
                    }
                    a aVar = (a) obj;
                    if (!Arrays.equals(this.aZB, aVar.aZB)) {
                        return false;
                    }
                    if (this.aZC == null) {
                        if (aVar.aZC != null) {
                            return false;
                        }
                    } else if (!this.aZC.equals(aVar.aZC)) {
                        return false;
                    }
                    return (Double.doubleToLongBits(this.aZD) == Double.doubleToLongBits(aVar.aZD) && Float.floatToIntBits(this.aZE) == Float.floatToIntBits(aVar.aZE) && this.aZF == aVar.aZF && this.aZG == aVar.aZG && this.aZH == aVar.aZH && this.aZI == aVar.aZI && bc.equals(this.aZJ, aVar.aZJ) && bc.equals(this.aZK, aVar.aZK) && bc.equals(this.aZL, aVar.aZL) && bc.equals(this.aZM, aVar.aZM) && bc.equals(this.aZN, aVar.aZN) && this.aZO == aVar.aZO) ? a((ay) aVar) : false;
                }

                public final int hashCode() {
                    int hashCode = (this.aZC == null ? 0 : this.aZC.hashCode()) + ((Arrays.hashCode(this.aZB) + 527) * 31);
                    long doubleToLongBits = Double.doubleToLongBits(this.aZD);
                    return (((((((((((((((this.aZI ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.aZE)) * 31) + ((int) (this.aZF ^ (this.aZF >>> 32)))) * 31) + this.aZG) * 31) + this.aZH) * 31)) * 31) + bc.hashCode(this.aZJ)) * 31) + bc.hashCode(this.aZK)) * 31) + bc.hashCode(this.aZL)) * 31) + bc.hashCode(this.aZM)) * 31) + bc.hashCode(this.aZN)) * 31) + ((int) (this.aZO ^ (this.aZO >>> 32)))) * 31) + qh();
                }

                protected final int px() {
                    int i;
                    int i2 = 0;
                    int px = super.px();
                    if (!Arrays.equals(this.aZB, bh.bat)) {
                        byte[] bArr = this.aZB;
                        px += (bArr.length + ax.dF(bArr.length)) + ax.dD(1);
                    }
                    if (!this.aZC.equals("")) {
                        px += ax.f(2, this.aZC);
                    }
                    if (Double.doubleToLongBits(this.aZD) != Double.doubleToLongBits(0.0d)) {
                        px += ax.dD(3) + 8;
                    }
                    if (Float.floatToIntBits(this.aZE) != Float.floatToIntBits(0.0f)) {
                        px += ax.dD(4) + 4;
                    }
                    if (this.aZF != 0) {
                        px += ax.i(5, this.aZF);
                    }
                    if (this.aZG != 0) {
                        px += ax.ax(6, this.aZG);
                    }
                    if (this.aZH != 0) {
                        px += ax.dF(ax.dG(this.aZH)) + ax.dD(7);
                    }
                    if (this.aZI) {
                        px += ax.dD(8) + 1;
                    }
                    if (this.aZJ != null && this.aZJ.length > 0) {
                        i = px;
                        for (be beVar : this.aZJ) {
                            if (beVar != null) {
                                i += ax.b(9, beVar);
                            }
                        }
                        px = i;
                    }
                    if (this.aZK != null && this.aZK.length > 0) {
                        i = px;
                        for (be beVar2 : this.aZK) {
                            if (beVar2 != null) {
                                i += ax.b(10, beVar2);
                            }
                        }
                        px = i;
                    }
                    if (this.aZL != null && this.aZL.length > 0) {
                        int i3 = 0;
                        int i4 = 0;
                        for (String str : this.aZL) {
                            if (str != null) {
                                i4++;
                                i3 += ax.bb(str);
                            }
                        }
                        px = (px + i3) + (i4 * 1);
                    }
                    if (this.aZM != null && this.aZM.length > 0) {
                        i = 0;
                        while (i2 < this.aZM.length) {
                            i += ax.aa(this.aZM[i2]);
                            i2++;
                        }
                        px = (px + i) + (this.aZM.length * 1);
                    }
                    if (this.aZO != 0) {
                        px += ax.i(13, this.aZO);
                    }
                    return (this.aZN == null || this.aZN.length <= 0) ? px : (px + (this.aZN.length * 4)) + (this.aZN.length * 1);
                }
            }

            public a() {
                this.type = 1;
                this.aZA = null;
                this.aZZ = null;
                this.bak = -1;
            }

            public static a[] pX() {
                if (aZz == null) {
                    synchronized (bc.baj) {
                        if (aZz == null) {
                            aZz = new a[0];
                        }
                    }
                }
                return aZz;
            }

            public final /* synthetic */ be a(aw awVar) {
                while (true) {
                    int pY = awVar.pY();
                    switch (pY) {
                        case 0:
                            break;
                        case 8:
                            pY = awVar.qb();
                            switch (pY) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                    this.type = pY;
                                    break;
                                default:
                                    continue;
                            }
                        case 18:
                            if (this.aZA == null) {
                                this.aZA = new a();
                            }
                            awVar.a(this.aZA);
                            continue;
                        default:
                            if (!a(awVar, pY)) {
                                break;
                            }
                            continue;
                    }
                }
                return this;
            }

            public final void a(ax axVar) {
                axVar.aw(1, this.type);
                if (this.aZA != null) {
                    axVar.a(2, this.aZA);
                }
                super.a(axVar);
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                if (this.type != aVar.type) {
                    return false;
                }
                if (this.aZA == null) {
                    if (aVar.aZA != null) {
                        return false;
                    }
                } else if (!this.aZA.equals(aVar.aZA)) {
                    return false;
                }
                return a((ay) aVar);
            }

            public final int hashCode() {
                return (((this.aZA == null ? 0 : this.aZA.hashCode()) + ((this.type + 527) * 31)) * 31) + qh();
            }

            protected final int px() {
                int px = super.px() + ax.ax(1, this.type);
                return this.aZA != null ? px + ax.b(2, this.aZA) : px;
            }
        }

        public a() {
            this.name = "";
            this.aZy = null;
            this.aZZ = null;
            this.bak = -1;
        }

        public static a[] pW() {
            if (aZx == null) {
                synchronized (bc.baj) {
                    if (aZx == null) {
                        aZx = new a[0];
                    }
                }
            }
            return aZx;
        }

        public final /* synthetic */ be a(aw awVar) {
            while (true) {
                int pY = awVar.pY();
                switch (pY) {
                    case 0:
                        break;
                    case 10:
                        this.name = awVar.readString();
                        continue;
                    case 18:
                        if (this.aZy == null) {
                            this.aZy = new a();
                        }
                        awVar.a(this.aZy);
                        continue;
                    default:
                        if (!a(awVar, pY)) {
                            break;
                        }
                        continue;
                }
            }
            return this;
        }

        public final void a(ax axVar) {
            axVar.e(1, this.name);
            if (this.aZy != null) {
                axVar.a(2, this.aZy);
            }
            super.a(axVar);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.name == null) {
                if (aVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(aVar.name)) {
                return false;
            }
            if (this.aZy == null) {
                if (aVar.aZy != null) {
                    return false;
                }
            } else if (!this.aZy.equals(aVar.aZy)) {
                return false;
            }
            return a((ay) aVar);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.aZy != null) {
                i = this.aZy.hashCode();
            }
            return ((hashCode + i) * 31) + qh();
        }

        protected final int px() {
            int px = super.px() + ax.f(1, this.name);
            return this.aZy != null ? px + ax.b(2, this.aZy) : px;
        }
    }

    public av() {
        this.aZw = a.pW();
        this.aZZ = null;
        this.bak = -1;
    }

    public final /* synthetic */ be a(aw awVar) {
        while (true) {
            int pY = awVar.pY();
            switch (pY) {
                case 0:
                    break;
                case 10:
                    int b = bh.b(awVar, 10);
                    pY = this.aZw == null ? 0 : this.aZw.length;
                    Object obj = new a[(b + pY)];
                    if (pY != 0) {
                        System.arraycopy(this.aZw, 0, obj, 0, pY);
                    }
                    while (pY < obj.length - 1) {
                        obj[pY] = new a();
                        awVar.a(obj[pY]);
                        awVar.pY();
                        pY++;
                    }
                    obj[pY] = new a();
                    awVar.a(obj[pY]);
                    this.aZw = obj;
                    continue;
                default:
                    if (!a(awVar, pY)) {
                        break;
                    }
                    continue;
            }
        }
        return this;
    }

    public final void a(ax axVar) {
        if (this.aZw != null && this.aZw.length > 0) {
            for (be beVar : this.aZw) {
                if (beVar != null) {
                    axVar.a(1, beVar);
                }
            }
        }
        super.a(axVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof av)) {
            return false;
        }
        av avVar = (av) obj;
        return bc.equals(this.aZw, avVar.aZw) ? a((ay) avVar) : false;
    }

    public final int hashCode() {
        return ((bc.hashCode(this.aZw) + 527) * 31) + qh();
    }

    protected final int px() {
        int px = super.px();
        if (this.aZw != null && this.aZw.length > 0) {
            for (be beVar : this.aZw) {
                if (beVar != null) {
                    px += ax.b(1, beVar);
                }
            }
        }
        return px;
    }
}
