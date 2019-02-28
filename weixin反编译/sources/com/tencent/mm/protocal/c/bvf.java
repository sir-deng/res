package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bvf extends bea {
    public long wMR;
    public int wMS;
    public int wdO;
    public String xcQ;
    public b xcR;
    public b xcS;
    public String xcT;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.xcQ == null) {
                throw new e.a.a.b("Not all required fields were included: ToBizUserName");
            } else if (this.xcS == null) {
                throw new e.a.a.b("Not all required fields were included: CapInfo");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                aVar.fX(2, this.wMS);
                if (this.xcQ != null) {
                    aVar.g(3, this.xcQ);
                }
                aVar.fX(4, this.wdO);
                if (this.xcR != null) {
                    aVar.b(5, this.xcR);
                }
                if (this.xcS != null) {
                    aVar.b(6, this.xcS);
                }
                aVar.S(7, this.wMR);
                if (this.xcT == null) {
                    return 0;
                }
                aVar.g(8, this.xcT);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.wMS);
            if (this.xcQ != null) {
                fW += e.a.a.b.b.a.h(3, this.xcQ);
            }
            fW += e.a.a.a.fU(4, this.wdO);
            if (this.xcR != null) {
                fW += e.a.a.a.a(5, this.xcR);
            }
            if (this.xcS != null) {
                fW += e.a.a.a.a(6, this.xcS);
            }
            fW += e.a.a.a.R(7, this.wMR);
            if (this.xcT != null) {
                fW += e.a.a.b.b.a.h(8, this.xcT);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.xcQ == null) {
                throw new e.a.a.b("Not all required fields were included: ToBizUserName");
            } else if (this.xcS != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: CapInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvf bvf = (bvf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bvf.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bvf.wMS = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bvf.xcQ = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bvf.wdO = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bvf.xcR = aVar3.cKw();
                    return 0;
                case 6:
                    bvf.xcS = aVar3.cKw();
                    return 0;
                case 7:
                    bvf.wMR = aVar3.AEQ.rA();
                    return 0;
                case 8:
                    bvf.xcT = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
