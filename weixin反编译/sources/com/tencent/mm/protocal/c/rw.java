package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class rw extends bek {
    public int vNL;
    public long vNT;
    public String vOL;
    public int vSa;
    public int vUN;
    public bes weD;
    public int wgA;
    public int wgC;
    public int wgD;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.weD == null) {
                throw new b("Not all required fields were included: Data");
            } else if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else {
                aVar.fX(1, this.vNL);
                aVar.fX(2, this.vUN);
                aVar.fX(3, this.wgA);
                aVar.fX(5, this.wgC);
                if (this.vOL != null) {
                    aVar.g(6, this.vOL);
                }
                if (this.weD != null) {
                    aVar.fZ(7, this.weD.bkL());
                    this.weD.a(aVar);
                }
                aVar.fX(8, this.vSa);
                if (this.wRa != null) {
                    aVar.fZ(9, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                aVar.fX(10, this.wgD);
                aVar.S(11, this.vNT);
                return 0;
            }
        } else if (i == 1) {
            fU = (((e.a.a.a.fU(1, this.vNL) + 0) + e.a.a.a.fU(2, this.vUN)) + e.a.a.a.fU(3, this.wgA)) + e.a.a.a.fU(5, this.wgC);
            if (this.vOL != null) {
                fU += e.a.a.b.b.a.h(6, this.vOL);
            }
            if (this.weD != null) {
                fU += e.a.a.a.fW(7, this.weD.bkL());
            }
            fU += e.a.a.a.fU(8, this.vSa);
            if (this.wRa != null) {
                fU += e.a.a.a.fW(9, this.wRa.bkL());
            }
            return (fU + e.a.a.a.fU(10, this.wgD)) + e.a.a.a.R(11, this.vNT);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = com.tencent.mm.bp.a.a(aVar2); fU > 0; fU = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.weD == null) {
                throw new b("Not all required fields were included: Data");
            } else if (this.wRa != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BaseResponse");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rw rwVar = (rw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a bes;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    rwVar.vNL = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    rwVar.vUN = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    rwVar.wgA = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    rwVar.wgC = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    rwVar.vOL = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        rwVar.weD = bes;
                    }
                    return 0;
                case 8:
                    rwVar.vSa = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        rwVar.wRa = bes;
                    }
                    return 0;
                case 10:
                    rwVar.wgD = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    rwVar.vNT = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
