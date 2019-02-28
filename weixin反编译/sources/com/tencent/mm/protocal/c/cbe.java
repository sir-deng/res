package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cbe extends a {
    public int sfa;
    public int vUN;
    public String vWw;
    public int wDS;
    public aou wDT;
    public int wQu;
    public String wnX;
    public int xfZ = 2;
    public String xgc;
    public int xhg;
    public LinkedList<oz> xhh = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vUN);
            aVar.fX(2, this.wDS);
            aVar.fX(3, this.wQu);
            if (this.wnX != null) {
                aVar.g(4, this.wnX);
            }
            if (this.wDT != null) {
                aVar.fZ(5, this.wDT.bkL());
                this.wDT.a(aVar);
            }
            aVar.fX(6, this.sfa);
            if (this.vWw != null) {
                aVar.g(7, this.vWw);
            }
            aVar.fX(8, this.xhg);
            aVar.fX(9, this.xfZ);
            aVar.d(10, 8, this.xhh);
            if (this.xgc != null) {
                aVar.g(11, this.xgc);
            }
            return 0;
        } else if (i == 1) {
            fU = ((e.a.a.a.fU(1, this.vUN) + 0) + e.a.a.a.fU(2, this.wDS)) + e.a.a.a.fU(3, this.wQu);
            if (this.wnX != null) {
                fU += e.a.a.b.b.a.h(4, this.wnX);
            }
            if (this.wDT != null) {
                fU += e.a.a.a.fW(5, this.wDT.bkL());
            }
            fU += e.a.a.a.fU(6, this.sfa);
            if (this.vWw != null) {
                fU += e.a.a.b.b.a.h(7, this.vWw);
            }
            fU = ((fU + e.a.a.a.fU(8, this.xhg)) + e.a.a.a.fU(9, this.xfZ)) + e.a.a.a.c(10, 8, this.xhh);
            if (this.xgc != null) {
                return fU + e.a.a.b.b.a.h(11, this.xgc);
            }
            return fU;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xhh.clear();
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
            cbe cbe = (cbe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a aou;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cbe.vUN = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    cbe.wDS = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    cbe.wQu = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    cbe.wnX = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        aou = new aou();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aou.a(aVar4, aou, a.a(aVar4))) {
                        }
                        cbe.wDT = aou;
                    }
                    return 0;
                case 6:
                    cbe.sfa = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    cbe.vWw = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    cbe.xhg = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    cbe.xfZ = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        aou = new oz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aou.a(aVar4, aou, a.a(aVar4))) {
                        }
                        cbe.xhh.add(aou);
                    }
                    return 0;
                case 11:
                    cbe.xgc = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
