package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bae extends a {
    public int hxe;
    public String hxf;
    public String hxg;
    public String hxh;
    public int hxi;
    public String hxj;
    public int hxk;
    public int hxl;
    public String hxm;
    public String hxn;
    public String hxo;
    public String kyG;
    public String kzN;
    public bmk wCw;
    public py wCx;
    public int wND;
    public String wNE;
    public int wNF;
    public String wNG;
    public String wbY;
    public String wbZ;
    public String woW;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wND);
            if (this.kyG != null) {
                aVar.g(2, this.kyG);
            }
            if (this.kzN != null) {
                aVar.g(3, this.kzN);
            }
            if (this.wNE != null) {
                aVar.g(4, this.wNE);
            }
            aVar.fX(5, this.wNF);
            if (this.wNG != null) {
                aVar.g(6, this.wNG);
            }
            aVar.fX(7, this.hxe);
            if (this.hxf != null) {
                aVar.g(8, this.hxf);
            }
            if (this.hxg != null) {
                aVar.g(9, this.hxg);
            }
            if (this.hxh != null) {
                aVar.g(10, this.hxh);
            }
            aVar.fX(11, this.hxi);
            if (this.hxj != null) {
                aVar.g(12, this.hxj);
            }
            aVar.fX(13, this.hxk);
            aVar.fX(14, this.hxl);
            if (this.hxm != null) {
                aVar.g(15, this.hxm);
            }
            if (this.wCw != null) {
                aVar.fZ(16, this.wCw.bkL());
                this.wCw.a(aVar);
            }
            if (this.hxn != null) {
                aVar.g(17, this.hxn);
            }
            if (this.hxo != null) {
                aVar.g(18, this.hxo);
            }
            if (this.wCx != null) {
                aVar.fZ(19, this.wCx.bkL());
                this.wCx.a(aVar);
            }
            if (this.wbY != null) {
                aVar.g(20, this.wbY);
            }
            if (this.wbZ != null) {
                aVar.g(21, this.wbZ);
            }
            if (this.woW != null) {
                aVar.g(22, this.woW);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wND) + 0;
            if (this.kyG != null) {
                fU += e.a.a.b.b.a.h(2, this.kyG);
            }
            if (this.kzN != null) {
                fU += e.a.a.b.b.a.h(3, this.kzN);
            }
            if (this.wNE != null) {
                fU += e.a.a.b.b.a.h(4, this.wNE);
            }
            fU += e.a.a.a.fU(5, this.wNF);
            if (this.wNG != null) {
                fU += e.a.a.b.b.a.h(6, this.wNG);
            }
            fU += e.a.a.a.fU(7, this.hxe);
            if (this.hxf != null) {
                fU += e.a.a.b.b.a.h(8, this.hxf);
            }
            if (this.hxg != null) {
                fU += e.a.a.b.b.a.h(9, this.hxg);
            }
            if (this.hxh != null) {
                fU += e.a.a.b.b.a.h(10, this.hxh);
            }
            fU += e.a.a.a.fU(11, this.hxi);
            if (this.hxj != null) {
                fU += e.a.a.b.b.a.h(12, this.hxj);
            }
            fU = (fU + e.a.a.a.fU(13, this.hxk)) + e.a.a.a.fU(14, this.hxl);
            if (this.hxm != null) {
                fU += e.a.a.b.b.a.h(15, this.hxm);
            }
            if (this.wCw != null) {
                fU += e.a.a.a.fW(16, this.wCw.bkL());
            }
            if (this.hxn != null) {
                fU += e.a.a.b.b.a.h(17, this.hxn);
            }
            if (this.hxo != null) {
                fU += e.a.a.b.b.a.h(18, this.hxo);
            }
            if (this.wCx != null) {
                fU += e.a.a.a.fW(19, this.wCx.bkL());
            }
            if (this.wbY != null) {
                fU += e.a.a.b.b.a.h(20, this.wbY);
            }
            if (this.wbZ != null) {
                fU += e.a.a.b.b.a.h(21, this.wbZ);
            }
            if (this.woW != null) {
                return fU + e.a.a.b.b.a.h(22, this.woW);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bae bae = (bae) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bmk;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bae.wND = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bae.kyG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bae.kzN = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bae.wNE = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bae.wNF = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bae.wNG = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bae.hxe = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bae.hxf = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    bae.hxg = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    bae.hxh = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    bae.hxi = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    bae.hxj = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    bae.hxk = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    bae.hxl = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    bae.hxm = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bmk = new bmk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmk.a(aVar4, bmk, a.a(aVar4))) {
                        }
                        bae.wCw = bmk;
                    }
                    return 0;
                case 17:
                    bae.hxn = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    bae.hxo = aVar3.AEQ.readString();
                    return 0;
                case 19:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bmk = new py();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmk.a(aVar4, bmk, a.a(aVar4))) {
                        }
                        bae.wCx = bmk;
                    }
                    return 0;
                case 20:
                    bae.wbY = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    bae.wbZ = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    bae.woW = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
