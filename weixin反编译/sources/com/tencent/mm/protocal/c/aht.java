package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aht extends bek {
    public String bhd;
    public String lUF;
    public String lUH;
    public boolean lUQ;
    public int mbA;
    public LinkedList<wk> vNK = new LinkedList();
    public LinkedList<bnl> vOn = new LinkedList();
    public String wvK;
    public ceb wvL;
    public LinkedList<ced> wvM = new LinkedList();
    public LinkedList<cec> wvN = new LinkedList();
    public LinkedList<String> wvO = new LinkedList();
    public String wvP;
    public String wvQ;
    public LinkedList<ju> wvR = new LinkedList();
    public boolean wvS;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wvK == null) {
                throw new b("Not all required fields were included: coverurl");
            } else if (this.lUH == null) {
                throw new b("Not all required fields were included: motto");
            } else if (this.wvL == null) {
                throw new b("Not all required fields were included: rankdesc");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.wvK != null) {
                    aVar.g(2, this.wvK);
                }
                if (this.lUH != null) {
                    aVar.g(3, this.lUH);
                }
                if (this.wvL != null) {
                    aVar.fZ(4, this.wvL.bkL());
                    this.wvL.a(aVar);
                }
                aVar.d(5, 8, this.wvM);
                aVar.d(6, 8, this.wvN);
                if (this.bhd != null) {
                    aVar.g(7, this.bhd);
                }
                aVar.d(8, 1, this.wvO);
                if (this.wvP != null) {
                    aVar.g(9, this.wvP);
                }
                if (this.wvQ != null) {
                    aVar.g(10, this.wvQ);
                }
                aVar.d(14, 8, this.vOn);
                aVar.d(15, 8, this.vNK);
                aVar.am(16, this.lUQ);
                aVar.d(17, 8, this.wvR);
                aVar.am(18, this.wvS);
                aVar.fX(19, this.mbA);
                if (this.lUF == null) {
                    return 0;
                }
                aVar.g(20, this.lUF);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wvK != null) {
                fW += e.a.a.b.b.a.h(2, this.wvK);
            }
            if (this.lUH != null) {
                fW += e.a.a.b.b.a.h(3, this.lUH);
            }
            if (this.wvL != null) {
                fW += e.a.a.a.fW(4, this.wvL.bkL());
            }
            fW = (fW + e.a.a.a.c(5, 8, this.wvM)) + e.a.a.a.c(6, 8, this.wvN);
            if (this.bhd != null) {
                fW += e.a.a.b.b.a.h(7, this.bhd);
            }
            fW += e.a.a.a.c(8, 1, this.wvO);
            if (this.wvP != null) {
                fW += e.a.a.b.b.a.h(9, this.wvP);
            }
            if (this.wvQ != null) {
                fW += e.a.a.b.b.a.h(10, this.wvQ);
            }
            fW = (((((fW + e.a.a.a.c(14, 8, this.vOn)) + e.a.a.a.c(15, 8, this.vNK)) + (e.a.a.b.b.a.dX(16) + 1)) + e.a.a.a.c(17, 8, this.wvR)) + (e.a.a.b.b.a.dX(18) + 1)) + e.a.a.a.fU(19, this.mbA);
            if (this.lUF != null) {
                fW += e.a.a.b.b.a.h(20, this.lUF);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wvM.clear();
            this.wvN.clear();
            this.wvO.clear();
            this.vOn.clear();
            this.vNK.clear();
            this.wvR.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wvK == null) {
                throw new b("Not all required fields were included: coverurl");
            } else if (this.lUH == null) {
                throw new b("Not all required fields were included: motto");
            } else if (this.wvL != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: rankdesc");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aht aht = (aht) objArr[1];
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
                        aht.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    aht.wvK = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aht.lUH = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ceb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aht.wvL = fiVar;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ced();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aht.wvM.add(fiVar);
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new cec();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aht.wvN.add(fiVar);
                    }
                    return 0;
                case 7:
                    aht.bhd = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    aht.wvO.add(aVar3.AEQ.readString());
                    return 0;
                case 9:
                    aht.wvP = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    aht.wvQ = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bnl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aht.vOn.add(fiVar);
                    }
                    return 0;
                case 15:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new wk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aht.vNK.add(fiVar);
                    }
                    return 0;
                case 16:
                    aht.lUQ = aVar3.cKv();
                    return 0;
                case 17:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ju();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aht.wvR.add(fiVar);
                    }
                    return 0;
                case 18:
                    aht.wvS = aVar3.cKv();
                    return 0;
                case 19:
                    aht.mbA = aVar3.AEQ.rz();
                    return 0;
                case 20:
                    aht.lUF = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
