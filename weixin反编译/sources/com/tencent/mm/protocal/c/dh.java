package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class dh extends a {
    public String nlV;
    public int vKI;
    public int vPe;
    public int vPf;
    public dm vPg;
    public dg vPh;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlV == null) {
                throw new b("Not all required fields were included: AppId");
            }
            aVar.fX(1, this.vKI);
            if (this.nlV != null) {
                aVar.g(2, this.nlV);
            }
            aVar.fX(3, this.vPe);
            aVar.fX(4, this.vPf);
            if (this.vPg != null) {
                aVar.fZ(5, this.vPg.bkL());
                this.vPg.a(aVar);
            }
            if (this.vPh != null) {
                aVar.fZ(6, this.vPh.bkL());
                this.vPh.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vKI) + 0;
            if (this.nlV != null) {
                fU += e.a.a.b.b.a.h(2, this.nlV);
            }
            fU = (fU + e.a.a.a.fU(3, this.vPe)) + e.a.a.a.fU(4, this.vPf);
            if (this.vPg != null) {
                fU += e.a.a.a.fW(5, this.vPg.bkL());
            }
            if (this.vPh != null) {
                return fU + e.a.a.a.fW(6, this.vPh.bkL());
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.nlV != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppId");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dh dhVar = (dh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a dmVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dhVar.vKI = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    dhVar.nlV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    dhVar.vPe = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    dhVar.vPf = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dmVar = new dm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dmVar.a(aVar4, dmVar, a.a(aVar4))) {
                        }
                        dhVar.vPg = dmVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dmVar = new dg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dmVar.a(aVar4, dmVar, a.a(aVar4))) {
                        }
                        dhVar.vPh = dmVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
