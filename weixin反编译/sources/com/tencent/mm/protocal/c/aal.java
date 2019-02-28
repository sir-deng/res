package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class aal extends bek {
    public String content;
    public String hdx;
    public String kPy;
    public String kQA;
    public String kQz;
    public String vLC;
    public String vLD;
    public String vLE;
    public String vLF;
    public String vLG;
    public String vLH;
    public String vLI;
    public String vLJ;
    public String vLK;
    public String vLL;
    public String vLM;
    public String vLN;
    public boolean vLO = false;
    public int vLP;
    public int vLQ;
    public int vLR;
    public String vLS;
    public String vLT;
    public int vLU;
    public String vLV;
    public String vLW;
    public String vLX;
    public String vLY;
    public String vLZ;
    public String vMa;
    public String vMb;
    public String vMc;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            if (this.vLC != null) {
                aVar.g(2, this.vLC);
            }
            if (this.vLD != null) {
                aVar.g(3, this.vLD);
            }
            if (this.vLE != null) {
                aVar.g(4, this.vLE);
            }
            if (this.content != null) {
                aVar.g(5, this.content);
            }
            if (this.vLF != null) {
                aVar.g(6, this.vLF);
            }
            if (this.vLG != null) {
                aVar.g(7, this.vLG);
            }
            if (this.vLH != null) {
                aVar.g(8, this.vLH);
            }
            if (this.vLI != null) {
                aVar.g(9, this.vLI);
            }
            if (this.vLJ != null) {
                aVar.g(10, this.vLJ);
            }
            if (this.vLK != null) {
                aVar.g(11, this.vLK);
            }
            if (this.vLL != null) {
                aVar.g(12, this.vLL);
            }
            if (this.vLM != null) {
                aVar.g(13, this.vLM);
            }
            if (this.kQz != null) {
                aVar.g(14, this.kQz);
            }
            if (this.kQA != null) {
                aVar.g(15, this.kQA);
            }
            if (this.vLN != null) {
                aVar.g(16, this.vLN);
            }
            aVar.am(17, this.vLO);
            aVar.fX(18, this.vLP);
            aVar.fX(19, this.vLQ);
            aVar.fX(20, this.vLR);
            if (this.hdx != null) {
                aVar.g(21, this.hdx);
            }
            if (this.vLS != null) {
                aVar.g(22, this.vLS);
            }
            if (this.vLT != null) {
                aVar.g(23, this.vLT);
            }
            aVar.fX(24, this.vLU);
            if (this.vLV != null) {
                aVar.g(25, this.vLV);
            }
            if (this.vLW != null) {
                aVar.g(26, this.vLW);
            }
            if (this.vLX != null) {
                aVar.g(27, this.vLX);
            }
            if (this.vLY != null) {
                aVar.g(28, this.vLY);
            }
            if (this.vLZ != null) {
                aVar.g(29, this.vLZ);
            }
            if (this.vMa != null) {
                aVar.g(30, this.vMa);
            }
            if (this.vMb != null) {
                aVar.g(31, this.vMb);
            }
            if (this.kPy != null) {
                aVar.g(32, this.kPy);
            }
            if (this.vMc == null) {
                return 0;
            }
            aVar.g(33, this.vMc);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vLC != null) {
                fW += e.a.a.b.b.a.h(2, this.vLC);
            }
            if (this.vLD != null) {
                fW += e.a.a.b.b.a.h(3, this.vLD);
            }
            if (this.vLE != null) {
                fW += e.a.a.b.b.a.h(4, this.vLE);
            }
            if (this.content != null) {
                fW += e.a.a.b.b.a.h(5, this.content);
            }
            if (this.vLF != null) {
                fW += e.a.a.b.b.a.h(6, this.vLF);
            }
            if (this.vLG != null) {
                fW += e.a.a.b.b.a.h(7, this.vLG);
            }
            if (this.vLH != null) {
                fW += e.a.a.b.b.a.h(8, this.vLH);
            }
            if (this.vLI != null) {
                fW += e.a.a.b.b.a.h(9, this.vLI);
            }
            if (this.vLJ != null) {
                fW += e.a.a.b.b.a.h(10, this.vLJ);
            }
            if (this.vLK != null) {
                fW += e.a.a.b.b.a.h(11, this.vLK);
            }
            if (this.vLL != null) {
                fW += e.a.a.b.b.a.h(12, this.vLL);
            }
            if (this.vLM != null) {
                fW += e.a.a.b.b.a.h(13, this.vLM);
            }
            if (this.kQz != null) {
                fW += e.a.a.b.b.a.h(14, this.kQz);
            }
            if (this.kQA != null) {
                fW += e.a.a.b.b.a.h(15, this.kQA);
            }
            if (this.vLN != null) {
                fW += e.a.a.b.b.a.h(16, this.vLN);
            }
            fW = (((fW + (e.a.a.b.b.a.dX(17) + 1)) + e.a.a.a.fU(18, this.vLP)) + e.a.a.a.fU(19, this.vLQ)) + e.a.a.a.fU(20, this.vLR);
            if (this.hdx != null) {
                fW += e.a.a.b.b.a.h(21, this.hdx);
            }
            if (this.vLS != null) {
                fW += e.a.a.b.b.a.h(22, this.vLS);
            }
            if (this.vLT != null) {
                fW += e.a.a.b.b.a.h(23, this.vLT);
            }
            fW += e.a.a.a.fU(24, this.vLU);
            if (this.vLV != null) {
                fW += e.a.a.b.b.a.h(25, this.vLV);
            }
            if (this.vLW != null) {
                fW += e.a.a.b.b.a.h(26, this.vLW);
            }
            if (this.vLX != null) {
                fW += e.a.a.b.b.a.h(27, this.vLX);
            }
            if (this.vLY != null) {
                fW += e.a.a.b.b.a.h(28, this.vLY);
            }
            if (this.vLZ != null) {
                fW += e.a.a.b.b.a.h(29, this.vLZ);
            }
            if (this.vMa != null) {
                fW += e.a.a.b.b.a.h(30, this.vMa);
            }
            if (this.vMb != null) {
                fW += e.a.a.b.b.a.h(31, this.vMb);
            }
            if (this.kPy != null) {
                fW += e.a.a.b.b.a.h(32, this.kPy);
            }
            if (this.vMc != null) {
                fW += e.a.a.b.b.a.h(33, this.vMc);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aal aal = (aal) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fiVar = new fi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aal.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    aal.vLC = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aal.vLD = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aal.vLE = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aal.content = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aal.vLF = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    aal.vLG = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    aal.vLH = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    aal.vLI = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    aal.vLJ = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    aal.vLK = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    aal.vLL = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    aal.vLM = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    aal.kQz = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    aal.kQA = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    aal.vLN = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    aal.vLO = aVar3.cKv();
                    return 0;
                case 18:
                    aal.vLP = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    aal.vLQ = aVar3.AEQ.rz();
                    return 0;
                case 20:
                    aal.vLR = aVar3.AEQ.rz();
                    return 0;
                case 21:
                    aal.hdx = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    aal.vLS = aVar3.AEQ.readString();
                    return 0;
                case 23:
                    aal.vLT = aVar3.AEQ.readString();
                    return 0;
                case 24:
                    aal.vLU = aVar3.AEQ.rz();
                    return 0;
                case 25:
                    aal.vLV = aVar3.AEQ.readString();
                    return 0;
                case 26:
                    aal.vLW = aVar3.AEQ.readString();
                    return 0;
                case 27:
                    aal.vLX = aVar3.AEQ.readString();
                    return 0;
                case 28:
                    aal.vLY = aVar3.AEQ.readString();
                    return 0;
                case 29:
                    aal.vLZ = aVar3.AEQ.readString();
                    return 0;
                case 30:
                    aal.vMa = aVar3.AEQ.readString();
                    return 0;
                case 31:
                    aal.vMb = aVar3.AEQ.readString();
                    return 0;
                case 32:
                    aal.kPy = aVar3.AEQ.readString();
                    return 0;
                case 33:
                    aal.vMc = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
