package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class la extends a {
    public jx vZH;
    public jx vZI;
    public jx vZJ;
    public bes vZK;
    public bes vZL;
    public jx vZM;
    public int vZN;
    public jw vZO;
    public jw vZP;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vZH != null) {
                aVar.fZ(1, this.vZH.bkL());
                this.vZH.a(aVar);
            }
            if (this.vZI != null) {
                aVar.fZ(2, this.vZI.bkL());
                this.vZI.a(aVar);
            }
            if (this.vZJ != null) {
                aVar.fZ(4, this.vZJ.bkL());
                this.vZJ.a(aVar);
            }
            if (this.vZK != null) {
                aVar.fZ(5, this.vZK.bkL());
                this.vZK.a(aVar);
            }
            if (this.vZL != null) {
                aVar.fZ(6, this.vZL.bkL());
                this.vZL.a(aVar);
            }
            if (this.vZM != null) {
                aVar.fZ(7, this.vZM.bkL());
                this.vZM.a(aVar);
            }
            aVar.fX(8, this.vZN);
            if (this.vZO != null) {
                aVar.fZ(9, this.vZO.bkL());
                this.vZO.a(aVar);
            }
            if (this.vZP == null) {
                return 0;
            }
            aVar.fZ(10, this.vZP.bkL());
            this.vZP.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vZH != null) {
                fW = e.a.a.a.fW(1, this.vZH.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vZI != null) {
                fW += e.a.a.a.fW(2, this.vZI.bkL());
            }
            if (this.vZJ != null) {
                fW += e.a.a.a.fW(4, this.vZJ.bkL());
            }
            if (this.vZK != null) {
                fW += e.a.a.a.fW(5, this.vZK.bkL());
            }
            if (this.vZL != null) {
                fW += e.a.a.a.fW(6, this.vZL.bkL());
            }
            if (this.vZM != null) {
                fW += e.a.a.a.fW(7, this.vZM.bkL());
            }
            fW += e.a.a.a.fU(8, this.vZN);
            if (this.vZO != null) {
                fW += e.a.a.a.fW(9, this.vZO.bkL());
            }
            if (this.vZP != null) {
                fW += e.a.a.a.fW(10, this.vZP.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            la laVar = (la) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a jxVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jxVar = new jx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jxVar.a(aVar4, jxVar, a.a(aVar4))) {
                        }
                        laVar.vZH = jxVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jxVar = new jx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jxVar.a(aVar4, jxVar, a.a(aVar4))) {
                        }
                        laVar.vZI = jxVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jxVar = new jx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jxVar.a(aVar4, jxVar, a.a(aVar4))) {
                        }
                        laVar.vZJ = jxVar;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jxVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jxVar.a(aVar4, jxVar, a.a(aVar4))) {
                        }
                        laVar.vZK = jxVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jxVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jxVar.a(aVar4, jxVar, a.a(aVar4))) {
                        }
                        laVar.vZL = jxVar;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jxVar = new jx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jxVar.a(aVar4, jxVar, a.a(aVar4))) {
                        }
                        laVar.vZM = jxVar;
                    }
                    return 0;
                case 8:
                    laVar.vZN = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jxVar = new jw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jxVar.a(aVar4, jxVar, a.a(aVar4))) {
                        }
                        laVar.vZO = jxVar;
                    }
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jxVar = new jw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jxVar.a(aVar4, jxVar, a.a(aVar4))) {
                        }
                        laVar.vZP = jxVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
