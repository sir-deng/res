package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aem extends bek {
    public String nlE;
    public int vKI;
    public String vKY;
    public String vWw;
    public String wmc;
    public bes wsT;
    public int wtF;
    public LinkedList<awg> wtG = new LinkedList();
    public int wtH;
    public String wtc;
    public int wtd;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wsT == null) {
                throw new b("Not all required fields were included: Buff");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                aVar.fX(2, this.wtF);
                aVar.d(3, 8, this.wtG);
                aVar.fX(4, this.vKI);
                aVar.fX(5, this.wtH);
                if (this.wsT != null) {
                    aVar.fZ(6, this.wsT.bkL());
                    this.wsT.a(aVar);
                }
                if (this.nlE != null) {
                    aVar.g(7, this.nlE);
                }
                if (this.wtc != null) {
                    aVar.g(8, this.wtc);
                }
                if (this.wmc != null) {
                    aVar.g(9, this.wmc);
                }
                if (this.vKY != null) {
                    aVar.g(10, this.vKY);
                }
                aVar.fX(11, this.wtd);
                if (this.vWw == null) {
                    return 0;
                }
                aVar.g(12, this.vWw);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (((fW + e.a.a.a.fU(2, this.wtF)) + e.a.a.a.c(3, 8, this.wtG)) + e.a.a.a.fU(4, this.vKI)) + e.a.a.a.fU(5, this.wtH);
            if (this.wsT != null) {
                fW += e.a.a.a.fW(6, this.wsT.bkL());
            }
            if (this.nlE != null) {
                fW += e.a.a.b.b.a.h(7, this.nlE);
            }
            if (this.wtc != null) {
                fW += e.a.a.b.b.a.h(8, this.wtc);
            }
            if (this.wmc != null) {
                fW += e.a.a.b.b.a.h(9, this.wmc);
            }
            if (this.vKY != null) {
                fW += e.a.a.b.b.a.h(10, this.vKY);
            }
            fW += e.a.a.a.fU(11, this.wtd);
            if (this.vWw != null) {
                fW += e.a.a.b.b.a.h(12, this.vWw);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wtG.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wsT != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Buff");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aem aem = (aem) objArr[1];
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
                        aem.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    aem.wtF = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new awg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aem.wtG.add(fiVar);
                    }
                    return 0;
                case 4:
                    aem.vKI = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    aem.wtH = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aem.wsT = fiVar;
                    }
                    return 0;
                case 7:
                    aem.nlE = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    aem.wtc = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    aem.wmc = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    aem.vKY = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    aem.wtd = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    aem.vWw = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
