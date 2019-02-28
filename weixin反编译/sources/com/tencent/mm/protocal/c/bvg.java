package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bvg extends bek {
    public int nJA;
    public int nJp;
    public int nJv;
    public int nJw;
    public LinkedList<bva> vQG = new LinkedList();
    public b wNh;
    public long wim;
    public long xcP;
    public int xcU;
    public int xcV;
    public int xcW;
    public int xcX;
    public LinkedList<bva> xcY = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            aVar.S(2, this.xcP);
            aVar.S(3, this.wim);
            aVar.d(4, 8, this.vQG);
            aVar.fX(5, this.xcU);
            aVar.fX(6, this.nJv);
            aVar.fX(7, this.nJw);
            aVar.fX(8, this.nJp);
            aVar.fX(9, this.nJA);
            aVar.fX(10, this.xcV);
            aVar.fX(11, this.xcW);
            if (this.wNh != null) {
                aVar.b(12, this.wNh);
            }
            aVar.fX(13, this.xcX);
            aVar.d(14, 8, this.xcY);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (((((((((fW + e.a.a.a.R(2, this.xcP)) + e.a.a.a.R(3, this.wim)) + e.a.a.a.c(4, 8, this.vQG)) + e.a.a.a.fU(5, this.xcU)) + e.a.a.a.fU(6, this.nJv)) + e.a.a.a.fU(7, this.nJw)) + e.a.a.a.fU(8, this.nJp)) + e.a.a.a.fU(9, this.nJA)) + e.a.a.a.fU(10, this.xcV)) + e.a.a.a.fU(11, this.xcW);
            if (this.wNh != null) {
                fW += e.a.a.a.a(12, this.wNh);
            }
            return (fW + e.a.a.a.fU(13, this.xcX)) + e.a.a.a.c(14, 8, this.xcY);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vQG.clear();
            this.xcY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvg bvg = (bvg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            com.tencent.mm.bp.a fiVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bvg.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    bvg.xcP = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    bvg.wim = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bva();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bvg.vQG.add(fiVar);
                    }
                    return 0;
                case 5:
                    bvg.xcU = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bvg.nJv = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bvg.nJw = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bvg.nJp = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bvg.nJA = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    bvg.xcV = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    bvg.xcW = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    bvg.wNh = aVar3.cKw();
                    return 0;
                case 13:
                    bvg.xcX = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bva();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bvg.xcY.add(fiVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
