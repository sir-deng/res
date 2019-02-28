package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class oj extends a implements bkb {
    public int vQL;
    public int wdV;
    public int wdW;
    public int wdX;
    public LinkedList<bnn> wdY = new LinkedList();
    public LinkedList<bnn> wdZ = new LinkedList();
    public LinkedList<bnn> wea = new LinkedList();
    public int web;
    public int wec;
    public int wed;
    public akq wee;

    public final int getRet() {
        return this.vQL;
    }

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vQL);
            aVar.fX(2, this.wdV);
            aVar.fX(3, this.wdW);
            aVar.fX(4, this.wdX);
            aVar.d(5, 8, this.wdY);
            aVar.d(6, 8, this.wdZ);
            aVar.d(7, 8, this.wea);
            aVar.fX(8, this.web);
            aVar.fX(9, this.wec);
            aVar.fX(10, this.wed);
            if (this.wee != null) {
                aVar.fZ(11, this.wee.bkL());
                this.wee.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = (((((((((e.a.a.a.fU(1, this.vQL) + 0) + e.a.a.a.fU(2, this.wdV)) + e.a.a.a.fU(3, this.wdW)) + e.a.a.a.fU(4, this.wdX)) + e.a.a.a.c(5, 8, this.wdY)) + e.a.a.a.c(6, 8, this.wdZ)) + e.a.a.a.c(7, 8, this.wea)) + e.a.a.a.fU(8, this.web)) + e.a.a.a.fU(9, this.wec)) + e.a.a.a.fU(10, this.wed);
            if (this.wee != null) {
                return fU + e.a.a.a.fW(11, this.wee.bkL());
            }
            return fU;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wdY.clear();
            this.wdZ.clear();
            this.wea.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            oj ojVar = (oj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a bnn;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ojVar.vQL = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    ojVar.wdV = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ojVar.wdW = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    ojVar.wdX = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bnn = new bnn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnn.a(aVar4, bnn, a.a(aVar4))) {
                        }
                        ojVar.wdY.add(bnn);
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bnn = new bnn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnn.a(aVar4, bnn, a.a(aVar4))) {
                        }
                        ojVar.wdZ.add(bnn);
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bnn = new bnn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnn.a(aVar4, bnn, a.a(aVar4))) {
                        }
                        ojVar.wea.add(bnn);
                    }
                    return 0;
                case 8:
                    ojVar.web = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    ojVar.wec = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    ojVar.wed = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bnn = new akq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnn.a(aVar4, bnn, a.a(aVar4))) {
                        }
                        ojVar.wee = bnn;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
