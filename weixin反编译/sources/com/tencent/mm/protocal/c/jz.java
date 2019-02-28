package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class jz extends bea {
    public String nlV;
    public String npV;
    public String npW;
    public int sfa;
    public String vMr;
    public String vMs;
    public String vMt;
    public String vNR;
    public int vON;
    public int vXA;
    public int vXB;
    public int vXC;
    public int vXD;
    public String vXE;
    public int vXF;
    public int vXG;
    public int vXH;
    public String vXt;
    public int vXu;
    public int vXv;
    public bes vXw;
    public float vXx;
    public float vXy;
    public String vXz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vXt != null) {
                aVar.g(1, this.vXt);
            }
            if (this.npW != null) {
                aVar.g(2, this.npW);
            }
            if (this.npV != null) {
                aVar.g(3, this.npV);
            }
            aVar.fX(4, this.vXu);
            aVar.fX(5, this.vXv);
            if (this.vNR != null) {
                aVar.g(6, this.vNR);
            }
            if (this.vXw != null) {
                aVar.fZ(7, this.vXw.bkL());
                this.vXw.a(aVar);
            }
            aVar.fX(8, this.sfa);
            aVar.m(9, this.vXx);
            aVar.m(10, this.vXy);
            if (this.vXz != null) {
                aVar.g(11, this.vXz);
            }
            aVar.fX(12, this.vXA);
            aVar.fX(13, this.vXB);
            aVar.fX(14, this.vXC);
            aVar.fX(15, this.vXD);
            if (this.vXE != null) {
                aVar.g(16, this.vXE);
            }
            aVar.fX(17, this.vXF);
            aVar.fX(18, this.vXG);
            aVar.fX(19, this.vXH);
            aVar.fX(20, this.vON);
            if (this.nlV != null) {
                aVar.g(21, this.nlV);
            }
            if (this.vMt != null) {
                aVar.g(22, this.vMt);
            }
            if (this.vMs != null) {
                aVar.g(23, this.vMs);
            }
            if (this.vMr == null) {
                return 0;
            }
            aVar.g(24, this.vMr);
            return 0;
        } else if (i == 1) {
            if (this.vXt != null) {
                h = e.a.a.b.b.a.h(1, this.vXt) + 0;
            } else {
                h = 0;
            }
            if (this.npW != null) {
                h += e.a.a.b.b.a.h(2, this.npW);
            }
            if (this.npV != null) {
                h += e.a.a.b.b.a.h(3, this.npV);
            }
            h = (h + e.a.a.a.fU(4, this.vXu)) + e.a.a.a.fU(5, this.vXv);
            if (this.vNR != null) {
                h += e.a.a.b.b.a.h(6, this.vNR);
            }
            if (this.vXw != null) {
                h += e.a.a.a.fW(7, this.vXw.bkL());
            }
            h = ((h + e.a.a.a.fU(8, this.sfa)) + (e.a.a.b.b.a.dX(9) + 4)) + (e.a.a.b.b.a.dX(10) + 4);
            if (this.vXz != null) {
                h += e.a.a.b.b.a.h(11, this.vXz);
            }
            h = (((h + e.a.a.a.fU(12, this.vXA)) + e.a.a.a.fU(13, this.vXB)) + e.a.a.a.fU(14, this.vXC)) + e.a.a.a.fU(15, this.vXD);
            if (this.vXE != null) {
                h += e.a.a.b.b.a.h(16, this.vXE);
            }
            h = (((h + e.a.a.a.fU(17, this.vXF)) + e.a.a.a.fU(18, this.vXG)) + e.a.a.a.fU(19, this.vXH)) + e.a.a.a.fU(20, this.vON);
            if (this.nlV != null) {
                h += e.a.a.b.b.a.h(21, this.nlV);
            }
            if (this.vMt != null) {
                h += e.a.a.b.b.a.h(22, this.vMt);
            }
            if (this.vMs != null) {
                h += e.a.a.b.b.a.h(23, this.vMs);
            }
            if (this.vMr != null) {
                h += e.a.a.b.b.a.h(24, this.vMr);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = com.tencent.mm.bp.a.a(aVar2); h > 0; h = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jz jzVar = (jz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jzVar.vXt = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    jzVar.npW = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    jzVar.npV = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    jzVar.vXu = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    jzVar.vXv = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    jzVar.vNR = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a bes = new bes();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bes.a(aVar4, bes, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        jzVar.vXw = bes;
                    }
                    return 0;
                case 8:
                    jzVar.sfa = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    jzVar.vXx = aVar3.AEQ.readFloat();
                    return 0;
                case 10:
                    jzVar.vXy = aVar3.AEQ.readFloat();
                    return 0;
                case 11:
                    jzVar.vXz = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    jzVar.vXA = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    jzVar.vXB = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    jzVar.vXC = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    jzVar.vXD = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    jzVar.vXE = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    jzVar.vXF = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    jzVar.vXG = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    jzVar.vXH = aVar3.AEQ.rz();
                    return 0;
                case 20:
                    jzVar.vON = aVar3.AEQ.rz();
                    return 0;
                case 21:
                    jzVar.nlV = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    jzVar.vMt = aVar3.AEQ.readString();
                    return 0;
                case 23:
                    jzVar.vMs = aVar3.AEQ.readString();
                    return 0;
                case 24:
                    jzVar.vMr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
