package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class buq extends bea {
    public int vSa;
    public int vUN;
    public int vVz;
    public bet wQB;
    public String wZM;
    public int wZO;
    public bes weD;
    public int xca;
    public LinkedList<bet> xcb = new LinkedList();
    public int xcc;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.weD == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.weD != null) {
                aVar.fZ(2, this.weD.bkL());
                this.weD.a(aVar);
            }
            aVar.fX(3, this.vUN);
            if (this.wZM != null) {
                aVar.g(4, this.wZM);
            }
            aVar.fX(5, this.vSa);
            aVar.fX(6, this.wZO);
            aVar.fX(7, this.vVz);
            aVar.fX(8, this.xca);
            aVar.d(9, 8, this.xcb);
            if (this.wQB != null) {
                aVar.fZ(10, this.wQB.bkL());
                this.wQB.a(aVar);
            }
            aVar.fX(11, this.xcc);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.weD != null) {
                fW += e.a.a.a.fW(2, this.weD.bkL());
            }
            fW += e.a.a.a.fU(3, this.vUN);
            if (this.wZM != null) {
                fW += e.a.a.b.b.a.h(4, this.wZM);
            }
            fW = ((((fW + e.a.a.a.fU(5, this.vSa)) + e.a.a.a.fU(6, this.wZO)) + e.a.a.a.fU(7, this.vVz)) + e.a.a.a.fU(8, this.xca)) + e.a.a.a.c(9, 8, this.xcb);
            if (this.wQB != null) {
                fW += e.a.a.a.fW(10, this.wQB.bkL());
            }
            return fW + e.a.a.a.fU(11, this.xcc);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xcb.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.weD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            buq buq = (buq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            com.tencent.mm.bp.a fhVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new fh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        buq.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        buq.weD = fhVar;
                    }
                    return 0;
                case 3:
                    buq.vUN = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    buq.wZM = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    buq.vSa = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    buq.wZO = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    buq.vVz = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    buq.xca = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        buq.xcb.add(fhVar);
                    }
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        buq.wQB = fhVar;
                    }
                    return 0;
                case 11:
                    buq.xcc = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
