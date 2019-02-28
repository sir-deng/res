package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aci extends bek {
    public bes vOw;
    public int wrM;
    public LinkedList<sx> wrN = new LinkedList();
    public sm wrO;
    public int wrP;
    public LinkedList<sm> wrQ = new LinkedList();
    public int wrR;
    public LinkedList<sq> wrS = new LinkedList();
    public int wrT;
    public LinkedList<so> wrU = new LinkedList();
    public int wrV;
    public int wrW;
    public int wrX;
    public LinkedList<so> wrY = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vOw == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.vOw != null) {
                    aVar.fZ(2, this.vOw.bkL());
                    this.vOw.a(aVar);
                }
                aVar.fX(3, this.wrM);
                aVar.d(4, 8, this.wrN);
                if (this.wrO != null) {
                    aVar.fZ(5, this.wrO.bkL());
                    this.wrO.a(aVar);
                }
                aVar.fX(6, this.wrP);
                aVar.d(7, 8, this.wrQ);
                aVar.fX(8, this.wrR);
                aVar.d(9, 8, this.wrS);
                aVar.fX(10, this.wrT);
                aVar.d(11, 8, this.wrU);
                aVar.fX(12, this.wrV);
                aVar.fX(13, this.wrW);
                aVar.fX(14, this.wrX);
                aVar.d(15, 8, this.wrY);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vOw != null) {
                fW += e.a.a.a.fW(2, this.vOw.bkL());
            }
            fW = (fW + e.a.a.a.fU(3, this.wrM)) + e.a.a.a.c(4, 8, this.wrN);
            if (this.wrO != null) {
                fW += e.a.a.a.fW(5, this.wrO.bkL());
            }
            return (((((((((fW + e.a.a.a.fU(6, this.wrP)) + e.a.a.a.c(7, 8, this.wrQ)) + e.a.a.a.fU(8, this.wrR)) + e.a.a.a.c(9, 8, this.wrS)) + e.a.a.a.fU(10, this.wrT)) + e.a.a.a.c(11, 8, this.wrU)) + e.a.a.a.fU(12, this.wrV)) + e.a.a.a.fU(13, this.wrW)) + e.a.a.a.fU(14, this.wrX)) + e.a.a.a.c(15, 8, this.wrY);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wrN.clear();
            this.wrQ.clear();
            this.wrS.clear();
            this.wrU.clear();
            this.wrY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vOw != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aci aci = (aci) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            com.tencent.mm.bp.a fiVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aci.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aci.vOw = fiVar;
                    }
                    return 0;
                case 3:
                    aci.wrM = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new sx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aci.wrN.add(fiVar);
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new sm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aci.wrO = fiVar;
                    }
                    return 0;
                case 6:
                    aci.wrP = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new sm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aci.wrQ.add(fiVar);
                    }
                    return 0;
                case 8:
                    aci.wrR = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new sq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aci.wrS.add(fiVar);
                    }
                    return 0;
                case 10:
                    aci.wrT = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new so();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aci.wrU.add(fiVar);
                    }
                    return 0;
                case 12:
                    aci.wrV = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    aci.wrW = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    aci.wrX = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new so();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aci.wrY.add(fiVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
