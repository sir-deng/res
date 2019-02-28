package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bed extends a {
    public int vXe;
    public int vnv;
    public int wMK;
    public beg wQK;
    public bef wQL;
    public int wQM;
    public String wQN;
    public int wQO;
    public int wQP;
    public int wQQ;
    public int wsu;
    public int wyO;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wQN == null) {
                throw new b("Not all required fields were included: SampleId");
            }
            aVar.fX(1, this.wMK);
            if (this.wQK != null) {
                aVar.fZ(2, this.wQK.bkL());
                this.wQK.a(aVar);
            }
            if (this.wQL != null) {
                aVar.fZ(3, this.wQL.bkL());
                this.wQL.a(aVar);
            }
            aVar.fX(4, this.wsu);
            aVar.fX(5, this.wQM);
            if (this.wQN != null) {
                aVar.g(6, this.wQN);
            }
            aVar.fX(7, this.vXe);
            aVar.fX(8, this.wQO);
            aVar.fX(9, this.vnv);
            aVar.fX(10, this.wQP);
            aVar.fX(11, this.wQQ);
            aVar.fX(12, this.wyO);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wMK) + 0;
            if (this.wQK != null) {
                fU += e.a.a.a.fW(2, this.wQK.bkL());
            }
            if (this.wQL != null) {
                fU += e.a.a.a.fW(3, this.wQL.bkL());
            }
            fU = (fU + e.a.a.a.fU(4, this.wsu)) + e.a.a.a.fU(5, this.wQM);
            if (this.wQN != null) {
                fU += e.a.a.b.b.a.h(6, this.wQN);
            }
            return (((((fU + e.a.a.a.fU(7, this.vXe)) + e.a.a.a.fU(8, this.wQO)) + e.a.a.a.fU(9, this.vnv)) + e.a.a.a.fU(10, this.wQP)) + e.a.a.a.fU(11, this.wQQ)) + e.a.a.a.fU(12, this.wyO);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.wQN != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SampleId");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bed bed = (bed) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a beg;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bed.wMK = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        beg = new beg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = beg.a(aVar4, beg, a.a(aVar4))) {
                        }
                        bed.wQK = beg;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        beg = new bef();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = beg.a(aVar4, beg, a.a(aVar4))) {
                        }
                        bed.wQL = beg;
                    }
                    return 0;
                case 4:
                    bed.wsu = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bed.wQM = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bed.wQN = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bed.vXe = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bed.wQO = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bed.vnv = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    bed.wQP = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    bed.wQQ = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    bed.wyO = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
