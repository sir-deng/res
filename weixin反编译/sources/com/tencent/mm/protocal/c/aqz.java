package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aqz extends bea {
    public int nlX;
    public String nnl;
    public String phv;
    public int vXu;
    public int vXv;
    public int wEA;
    public int wEB;
    public bes wEC;
    public int wED;
    public int wEE;
    public int wEF;
    public int wEG;
    public int wEH;
    public String wEI;
    public String wEJ;
    public String wEt;
    public String wEu;
    public String wEv;
    public int wEw;
    public bes wEx;
    public int wEy;
    public int wEz;
    public int wto;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wEx == null) {
                throw new b("Not all required fields were included: DataBuffer");
            } else if (this.wEC == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.wEt != null) {
                    aVar.g(2, this.wEt);
                }
                if (this.wEu != null) {
                    aVar.g(3, this.wEu);
                }
                if (this.wEv != null) {
                    aVar.g(4, this.wEv);
                }
                aVar.fX(5, this.nlX);
                aVar.fX(6, this.wEw);
                if (this.wEx != null) {
                    aVar.fZ(7, this.wEx.bkL());
                    this.wEx.a(aVar);
                }
                aVar.fX(8, this.wEy);
                aVar.fX(9, this.wEz);
                aVar.fX(10, this.wEA);
                aVar.fX(11, this.wEB);
                if (this.wEC != null) {
                    aVar.fZ(12, this.wEC.bkL());
                    this.wEC.a(aVar);
                }
                aVar.fX(13, this.wED);
                aVar.fX(14, this.wEE);
                aVar.fX(15, this.wEF);
                aVar.fX(16, this.wEG);
                aVar.fX(17, this.wto);
                aVar.fX(18, this.wEH);
                if (this.nnl != null) {
                    aVar.g(19, this.nnl);
                }
                if (this.phv != null) {
                    aVar.g(20, this.phv);
                }
                aVar.fX(21, this.vXv);
                aVar.fX(22, this.vXu);
                if (this.wEI != null) {
                    aVar.g(23, this.wEI);
                }
                if (this.wEJ == null) {
                    return 0;
                }
                aVar.g(24, this.wEJ);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wEt != null) {
                fW += e.a.a.b.b.a.h(2, this.wEt);
            }
            if (this.wEu != null) {
                fW += e.a.a.b.b.a.h(3, this.wEu);
            }
            if (this.wEv != null) {
                fW += e.a.a.b.b.a.h(4, this.wEv);
            }
            fW = (fW + e.a.a.a.fU(5, this.nlX)) + e.a.a.a.fU(6, this.wEw);
            if (this.wEx != null) {
                fW += e.a.a.a.fW(7, this.wEx.bkL());
            }
            fW = (((fW + e.a.a.a.fU(8, this.wEy)) + e.a.a.a.fU(9, this.wEz)) + e.a.a.a.fU(10, this.wEA)) + e.a.a.a.fU(11, this.wEB);
            if (this.wEC != null) {
                fW += e.a.a.a.fW(12, this.wEC.bkL());
            }
            fW = (((((fW + e.a.a.a.fU(13, this.wED)) + e.a.a.a.fU(14, this.wEE)) + e.a.a.a.fU(15, this.wEF)) + e.a.a.a.fU(16, this.wEG)) + e.a.a.a.fU(17, this.wto)) + e.a.a.a.fU(18, this.wEH);
            if (this.nnl != null) {
                fW += e.a.a.b.b.a.h(19, this.nnl);
            }
            if (this.phv != null) {
                fW += e.a.a.b.b.a.h(20, this.phv);
            }
            fW = (fW + e.a.a.a.fU(21, this.vXv)) + e.a.a.a.fU(22, this.vXu);
            if (this.wEI != null) {
                fW += e.a.a.b.b.a.h(23, this.wEI);
            }
            if (this.wEJ != null) {
                fW += e.a.a.b.b.a.h(24, this.wEJ);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wEx == null) {
                throw new b("Not all required fields were included: DataBuffer");
            } else if (this.wEC != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThumbData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aqz aqz = (aqz) objArr[1];
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
                        aqz.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    aqz.wEt = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aqz.wEu = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aqz.wEv = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aqz.nlX = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    aqz.wEw = aVar3.AEQ.rz();
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
                        aqz.wEx = fhVar;
                    }
                    return 0;
                case 8:
                    aqz.wEy = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    aqz.wEz = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    aqz.wEA = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    aqz.wEB = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aqz.wEC = fhVar;
                    }
                    return 0;
                case 13:
                    aqz.wED = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    aqz.wEE = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    aqz.wEF = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    aqz.wEG = aVar3.AEQ.rz();
                    return 0;
                case 17:
                    aqz.wto = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    aqz.wEH = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    aqz.nnl = aVar3.AEQ.readString();
                    return 0;
                case 20:
                    aqz.phv = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    aqz.vXv = aVar3.AEQ.rz();
                    return 0;
                case 22:
                    aqz.vXu = aVar3.AEQ.rz();
                    return 0;
                case 23:
                    aqz.wEI = aVar3.AEQ.readString();
                    return 0;
                case 24:
                    aqz.wEJ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
