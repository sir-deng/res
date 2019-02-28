package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bsc extends bea {
    public int nph;
    public int vPs;
    public int vPt;
    public int vPu;
    public bet wZT;
    public bet wZU;
    public int wZV;
    public int wZW;
    public int wZX;
    public int wZY;
    public bes weD;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wZT == null) {
                throw new b("Not all required fields were included: ClientMediaId");
            } else if (this.wZU == null) {
                throw new b("Not all required fields were included: DataMD5");
            } else if (this.weD == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.wZT != null) {
                    aVar.fZ(2, this.wZT.bkL());
                    this.wZT.a(aVar);
                }
                if (this.wZU != null) {
                    aVar.fZ(3, this.wZU.bkL());
                    this.wZU.a(aVar);
                }
                aVar.fX(4, this.vPs);
                aVar.fX(5, this.vPt);
                aVar.fX(6, this.vPu);
                if (this.weD != null) {
                    aVar.fZ(7, this.weD.bkL());
                    this.weD.a(aVar);
                }
                aVar.fX(8, this.nph);
                aVar.fX(9, this.wZV);
                aVar.fX(10, this.wZW);
                aVar.fX(11, this.wZX);
                aVar.fX(12, this.wZY);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wZT != null) {
                fW += e.a.a.a.fW(2, this.wZT.bkL());
            }
            if (this.wZU != null) {
                fW += e.a.a.a.fW(3, this.wZU.bkL());
            }
            fW = ((fW + e.a.a.a.fU(4, this.vPs)) + e.a.a.a.fU(5, this.vPt)) + e.a.a.a.fU(6, this.vPu);
            if (this.weD != null) {
                fW += e.a.a.a.fW(7, this.weD.bkL());
            }
            return ((((fW + e.a.a.a.fU(8, this.nph)) + e.a.a.a.fU(9, this.wZV)) + e.a.a.a.fU(10, this.wZW)) + e.a.a.a.fU(11, this.wZX)) + e.a.a.a.fU(12, this.wZY);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wZT == null) {
                throw new b("Not all required fields were included: ClientMediaId");
            } else if (this.wZU == null) {
                throw new b("Not all required fields were included: DataMD5");
            } else if (this.weD != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsc bsc = (bsc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
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
                        bsc.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bsc.wZT = fhVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bsc.wZU = fhVar;
                    }
                    return 0;
                case 4:
                    bsc.vPs = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bsc.vPt = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bsc.vPu = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bsc.weD = fhVar;
                    }
                    return 0;
                case 8:
                    bsc.nph = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bsc.wZV = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    bsc.wZW = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    bsc.wZX = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    bsc.wZY = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
