package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class abk extends bek {
    public String ID;
    public long kyU;
    public int kzz;
    public int sfa;
    public int vQF;
    public LinkedList<pd> vQG = new LinkedList();
    public String vQH;
    public String vQI;
    public String vQJ;
    public int vQO;
    public String vQP;
    public String vQQ;
    public bes vQt;
    public String wrh;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vQt == null) {
                throw new b("Not all required fields were included: Key");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.ID != null) {
                    aVar.g(2, this.ID);
                }
                if (this.vQt != null) {
                    aVar.fZ(3, this.vQt.bkL());
                    this.vQt.a(aVar);
                }
                if (this.vQP != null) {
                    aVar.g(4, this.vQP);
                }
                if (this.vQQ != null) {
                    aVar.g(5, this.vQQ);
                }
                aVar.fX(6, this.kzz);
                aVar.fX(7, this.vQF);
                aVar.d(8, 8, this.vQG);
                if (this.wrh != null) {
                    aVar.g(9, this.wrh);
                }
                if (this.vQH != null) {
                    aVar.g(10, this.vQH);
                }
                if (this.vQI != null) {
                    aVar.g(11, this.vQI);
                }
                aVar.fX(12, this.vQO);
                aVar.fX(13, this.sfa);
                aVar.S(14, this.kyU);
                if (this.vQJ == null) {
                    return 0;
                }
                aVar.g(15, this.vQJ);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.ID != null) {
                fW += e.a.a.b.b.a.h(2, this.ID);
            }
            if (this.vQt != null) {
                fW += e.a.a.a.fW(3, this.vQt.bkL());
            }
            if (this.vQP != null) {
                fW += e.a.a.b.b.a.h(4, this.vQP);
            }
            if (this.vQQ != null) {
                fW += e.a.a.b.b.a.h(5, this.vQQ);
            }
            fW = ((fW + e.a.a.a.fU(6, this.kzz)) + e.a.a.a.fU(7, this.vQF)) + e.a.a.a.c(8, 8, this.vQG);
            if (this.wrh != null) {
                fW += e.a.a.b.b.a.h(9, this.wrh);
            }
            if (this.vQH != null) {
                fW += e.a.a.b.b.a.h(10, this.vQH);
            }
            if (this.vQI != null) {
                fW += e.a.a.b.b.a.h(11, this.vQI);
            }
            fW = ((fW + e.a.a.a.fU(12, this.vQO)) + e.a.a.a.fU(13, this.sfa)) + e.a.a.a.R(14, this.kyU);
            if (this.vQJ != null) {
                fW += e.a.a.b.b.a.h(15, this.vQJ);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vQG.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vQt != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Key");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abk abk = (abk) objArr[1];
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
                        abk.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    abk.ID = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        abk.vQt = fiVar;
                    }
                    return 0;
                case 4:
                    abk.vQP = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    abk.vQQ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    abk.kzz = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    abk.vQF = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new pd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        abk.vQG.add(fiVar);
                    }
                    return 0;
                case 9:
                    abk.wrh = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    abk.vQH = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    abk.vQI = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    abk.vQO = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    abk.sfa = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    abk.kyU = aVar3.AEQ.rA();
                    return 0;
                case 15:
                    abk.vQJ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
