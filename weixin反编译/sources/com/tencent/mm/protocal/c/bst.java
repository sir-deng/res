package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bst extends bea {
    public String npV;
    public String npW;
    public int vNL;
    public String vNR;
    public long vNT;
    public String vOL;
    public int vSa;
    public int vUN;
    public int wEH;
    public bes weD;
    public int wgA;
    public int wgC;
    public int wgD;
    public int whg;
    public int xaG;
    public int xaH;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.weD == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.npW != null) {
                aVar.g(1, this.npW);
            }
            if (this.npV != null) {
                aVar.g(2, this.npV);
            }
            aVar.fX(3, this.vUN);
            aVar.fX(4, this.wgA);
            if (this.vOL != null) {
                aVar.g(5, this.vOL);
            }
            aVar.fX(6, this.vNL);
            aVar.fX(7, this.wgC);
            if (this.weD != null) {
                aVar.fZ(8, this.weD.bkL());
                this.weD.a(aVar);
            }
            aVar.fX(9, this.vSa);
            if (this.wQE != null) {
                aVar.fZ(10, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(11, this.wgD);
            if (this.vNR != null) {
                aVar.g(12, this.vNR);
            }
            aVar.fX(13, this.wEH);
            aVar.fX(14, this.xaG);
            aVar.fX(15, this.xaH);
            aVar.S(16, this.vNT);
            aVar.fX(17, this.whg);
            return 0;
        } else if (i == 1) {
            if (this.npW != null) {
                h = e.a.a.b.b.a.h(1, this.npW) + 0;
            } else {
                h = 0;
            }
            if (this.npV != null) {
                h += e.a.a.b.b.a.h(2, this.npV);
            }
            h = (h + e.a.a.a.fU(3, this.vUN)) + e.a.a.a.fU(4, this.wgA);
            if (this.vOL != null) {
                h += e.a.a.b.b.a.h(5, this.vOL);
            }
            h = (h + e.a.a.a.fU(6, this.vNL)) + e.a.a.a.fU(7, this.wgC);
            if (this.weD != null) {
                h += e.a.a.a.fW(8, this.weD.bkL());
            }
            h += e.a.a.a.fU(9, this.vSa);
            if (this.wQE != null) {
                h += e.a.a.a.fW(10, this.wQE.bkL());
            }
            h += e.a.a.a.fU(11, this.wgD);
            if (this.vNR != null) {
                h += e.a.a.b.b.a.h(12, this.vNR);
            }
            return ((((h + e.a.a.a.fU(13, this.wEH)) + e.a.a.a.fU(14, this.xaG)) + e.a.a.a.fU(15, this.xaH)) + e.a.a.a.R(16, this.vNT)) + e.a.a.a.fU(17, this.whg);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = com.tencent.mm.bp.a.a(aVar2); h > 0; h = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
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
            bst bst = (bst) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a bes;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bst.npW = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bst.npV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bst.vUN = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bst.wgA = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bst.vOL = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bst.vNL = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bst.wgC = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bst.weD = bes;
                    }
                    return 0;
                case 9:
                    bst.vSa = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new fh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bst.wQE = bes;
                    }
                    return 0;
                case 11:
                    bst.wgD = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    bst.vNR = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    bst.wEH = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    bst.xaG = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    bst.xaH = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    bst.vNT = aVar3.AEQ.rA();
                    return 0;
                case 17:
                    bst.whg = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
