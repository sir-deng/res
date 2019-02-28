package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bso extends bea {
    public String npV;
    public String npW;
    public String vNR;
    public String vOL;
    public int vON;
    public String vXE;
    public int vXF;
    public int vXG;
    public int vXH;
    public int wEA;
    public int wEB;
    public bes wEC;
    public int wED;
    public int wSq;
    public int wgy;
    public int whg;
    public String wzc;
    public String wze;
    public String xaA;
    public String xaB;
    public String xaC;
    public String xaD;
    public String xaE;
    public String xaF;
    public int xag;
    public int xah;
    public int xai;
    public int xao;
    public int xap;
    public bes xaq;
    public int xar;
    public int xas;
    public String xat;
    public int xau;
    public String xav;
    public String xaw;
    public int xax;
    public String xay;
    public String xaz;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wEC == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else if (this.xaq == null) {
                throw new b("Not all required fields were included: VideoData");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.vOL != null) {
                    aVar.g(2, this.vOL);
                }
                if (this.npW != null) {
                    aVar.g(3, this.npW);
                }
                if (this.npV != null) {
                    aVar.g(4, this.npV);
                }
                aVar.fX(5, this.wEA);
                aVar.fX(6, this.wEB);
                if (this.wEC != null) {
                    aVar.fZ(7, this.wEC.bkL());
                    this.wEC.a(aVar);
                }
                aVar.fX(8, this.xao);
                aVar.fX(9, this.xap);
                if (this.xaq != null) {
                    aVar.fZ(10, this.xaq.bkL());
                    this.xaq.a(aVar);
                }
                aVar.fX(11, this.xar);
                aVar.fX(12, this.wgy);
                aVar.fX(13, this.wED);
                aVar.fX(14, this.xas);
                if (this.vNR != null) {
                    aVar.g(15, this.vNR);
                }
                if (this.xat != null) {
                    aVar.g(16, this.xat);
                }
                if (this.vXE != null) {
                    aVar.g(17, this.vXE);
                }
                aVar.fX(18, this.vXF);
                if (this.wzc != null) {
                    aVar.g(19, this.wzc);
                }
                aVar.fX(20, this.xag);
                aVar.fX(21, this.xah);
                aVar.fX(22, this.xai);
                if (this.wze != null) {
                    aVar.g(23, this.wze);
                }
                aVar.fX(24, this.xau);
                aVar.fX(25, this.whg);
                if (this.xav != null) {
                    aVar.g(26, this.xav);
                }
                if (this.xaw != null) {
                    aVar.g(27, this.xaw);
                }
                aVar.fX(28, this.xax);
                if (this.xay != null) {
                    aVar.g(29, this.xay);
                }
                if (this.xaz != null) {
                    aVar.g(30, this.xaz);
                }
                if (this.xaA != null) {
                    aVar.g(31, this.xaA);
                }
                if (this.xaB != null) {
                    aVar.g(32, this.xaB);
                }
                if (this.xaC != null) {
                    aVar.g(33, this.xaC);
                }
                if (this.xaD != null) {
                    aVar.g(34, this.xaD);
                }
                if (this.xaE != null) {
                    aVar.g(35, this.xaE);
                }
                aVar.fX(36, this.wSq);
                if (this.xaF != null) {
                    aVar.g(37, this.xaF);
                }
                aVar.fX(38, this.vXG);
                aVar.fX(39, this.vXH);
                aVar.fX(40, this.vON);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vOL != null) {
                fW += e.a.a.b.b.a.h(2, this.vOL);
            }
            if (this.npW != null) {
                fW += e.a.a.b.b.a.h(3, this.npW);
            }
            if (this.npV != null) {
                fW += e.a.a.b.b.a.h(4, this.npV);
            }
            fW = (fW + e.a.a.a.fU(5, this.wEA)) + e.a.a.a.fU(6, this.wEB);
            if (this.wEC != null) {
                fW += e.a.a.a.fW(7, this.wEC.bkL());
            }
            fW = (fW + e.a.a.a.fU(8, this.xao)) + e.a.a.a.fU(9, this.xap);
            if (this.xaq != null) {
                fW += e.a.a.a.fW(10, this.xaq.bkL());
            }
            fW = (((fW + e.a.a.a.fU(11, this.xar)) + e.a.a.a.fU(12, this.wgy)) + e.a.a.a.fU(13, this.wED)) + e.a.a.a.fU(14, this.xas);
            if (this.vNR != null) {
                fW += e.a.a.b.b.a.h(15, this.vNR);
            }
            if (this.xat != null) {
                fW += e.a.a.b.b.a.h(16, this.xat);
            }
            if (this.vXE != null) {
                fW += e.a.a.b.b.a.h(17, this.vXE);
            }
            fW += e.a.a.a.fU(18, this.vXF);
            if (this.wzc != null) {
                fW += e.a.a.b.b.a.h(19, this.wzc);
            }
            fW = ((fW + e.a.a.a.fU(20, this.xag)) + e.a.a.a.fU(21, this.xah)) + e.a.a.a.fU(22, this.xai);
            if (this.wze != null) {
                fW += e.a.a.b.b.a.h(23, this.wze);
            }
            fW = (fW + e.a.a.a.fU(24, this.xau)) + e.a.a.a.fU(25, this.whg);
            if (this.xav != null) {
                fW += e.a.a.b.b.a.h(26, this.xav);
            }
            if (this.xaw != null) {
                fW += e.a.a.b.b.a.h(27, this.xaw);
            }
            fW += e.a.a.a.fU(28, this.xax);
            if (this.xay != null) {
                fW += e.a.a.b.b.a.h(29, this.xay);
            }
            if (this.xaz != null) {
                fW += e.a.a.b.b.a.h(30, this.xaz);
            }
            if (this.xaA != null) {
                fW += e.a.a.b.b.a.h(31, this.xaA);
            }
            if (this.xaB != null) {
                fW += e.a.a.b.b.a.h(32, this.xaB);
            }
            if (this.xaC != null) {
                fW += e.a.a.b.b.a.h(33, this.xaC);
            }
            if (this.xaD != null) {
                fW += e.a.a.b.b.a.h(34, this.xaD);
            }
            if (this.xaE != null) {
                fW += e.a.a.b.b.a.h(35, this.xaE);
            }
            fW += e.a.a.a.fU(36, this.wSq);
            if (this.xaF != null) {
                fW += e.a.a.b.b.a.h(37, this.xaF);
            }
            return ((fW + e.a.a.a.fU(38, this.vXG)) + e.a.a.a.fU(39, this.vXH)) + e.a.a.a.fU(40, this.vON);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wEC == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else if (this.xaq != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: VideoData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bso bso = (bso) objArr[1];
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
                        bso.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bso.vOL = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bso.npW = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bso.npV = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bso.wEA = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bso.wEB = aVar3.AEQ.rz();
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
                        bso.wEC = fhVar;
                    }
                    return 0;
                case 8:
                    bso.xao = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bso.xap = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bso.xaq = fhVar;
                    }
                    return 0;
                case 11:
                    bso.xar = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    bso.wgy = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    bso.wED = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    bso.xas = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    bso.vNR = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    bso.xat = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    bso.vXE = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    bso.vXF = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    bso.wzc = aVar3.AEQ.readString();
                    return 0;
                case 20:
                    bso.xag = aVar3.AEQ.rz();
                    return 0;
                case 21:
                    bso.xah = aVar3.AEQ.rz();
                    return 0;
                case 22:
                    bso.xai = aVar3.AEQ.rz();
                    return 0;
                case 23:
                    bso.wze = aVar3.AEQ.readString();
                    return 0;
                case 24:
                    bso.xau = aVar3.AEQ.rz();
                    return 0;
                case 25:
                    bso.whg = aVar3.AEQ.rz();
                    return 0;
                case 26:
                    bso.xav = aVar3.AEQ.readString();
                    return 0;
                case 27:
                    bso.xaw = aVar3.AEQ.readString();
                    return 0;
                case 28:
                    bso.xax = aVar3.AEQ.rz();
                    return 0;
                case 29:
                    bso.xay = aVar3.AEQ.readString();
                    return 0;
                case 30:
                    bso.xaz = aVar3.AEQ.readString();
                    return 0;
                case 31:
                    bso.xaA = aVar3.AEQ.readString();
                    return 0;
                case 32:
                    bso.xaB = aVar3.AEQ.readString();
                    return 0;
                case 33:
                    bso.xaC = aVar3.AEQ.readString();
                    return 0;
                case 34:
                    bso.xaD = aVar3.AEQ.readString();
                    return 0;
                case 35:
                    bso.xaE = aVar3.AEQ.readString();
                    return 0;
                case 36:
                    bso.wSq = aVar3.AEQ.rz();
                    return 0;
                case 37:
                    bso.xaF = aVar3.AEQ.readString();
                    return 0;
                case 38:
                    bso.vXG = aVar3.AEQ.rz();
                    return 0;
                case 39:
                    bso.vXH = aVar3.AEQ.rz();
                    return 0;
                case 40:
                    bso.vON = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
