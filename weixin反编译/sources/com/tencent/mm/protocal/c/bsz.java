package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bsz extends a {
    public String fXy;
    public String hxo;
    public int vMj;
    public ape vOb;
    public String vSF;
    public bew vTm;
    public bmk wCw;
    public String wGu;
    public String wGv;
    public String wbY;
    public String wbZ;
    public int woN;
    public String xaO;
    public String xaP;
    public int xaQ;
    public int xaR;
    public int xaS;
    public String xaT;
    public int xaU;
    public bet xaV;
    public int xaW;
    public String xaX;
    public String xaY;
    public String xaZ;
    public String xba;
    public String xbb;
    public awn xbc;
    public String xbd;
    public int xbe;
    public long xbf;
    public String xbg;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wCw == null) {
                throw new b("Not all required fields were included: SnsUserInfo");
            }
            if (this.wCw != null) {
                aVar.fZ(1, this.wCw.bkL());
                this.wCw.a(aVar);
            }
            if (this.hxo != null) {
                aVar.g(2, this.hxo);
            }
            if (this.xaO != null) {
                aVar.g(3, this.xaO);
            }
            if (this.xaP != null) {
                aVar.g(4, this.xaP);
            }
            aVar.fX(5, this.xaQ);
            aVar.fX(6, this.xaR);
            aVar.fX(7, this.xaS);
            if (this.xaT != null) {
                aVar.g(8, this.xaT);
            }
            if (this.wbY != null) {
                aVar.g(9, this.wbY);
            }
            if (this.wbZ != null) {
                aVar.g(10, this.wbZ);
            }
            aVar.fX(11, this.xaU);
            if (this.xaV != null) {
                aVar.fZ(12, this.xaV.bkL());
                this.xaV.a(aVar);
            }
            if (this.vTm != null) {
                aVar.fZ(13, this.vTm.bkL());
                this.vTm.a(aVar);
            }
            aVar.fX(14, this.vMj);
            aVar.fX(15, this.xaW);
            if (this.vSF != null) {
                aVar.g(16, this.vSF);
            }
            if (this.wGu != null) {
                aVar.g(17, this.wGu);
            }
            if (this.wGv != null) {
                aVar.g(18, this.wGv);
            }
            if (this.xaX != null) {
                aVar.g(19, this.xaX);
            }
            if (this.xaY != null) {
                aVar.g(20, this.xaY);
            }
            if (this.xaZ != null) {
                aVar.g(21, this.xaZ);
            }
            if (this.xba != null) {
                aVar.g(22, this.xba);
            }
            if (this.vOb != null) {
                aVar.fZ(23, this.vOb.bkL());
                this.vOb.a(aVar);
            }
            if (this.xbb != null) {
                aVar.g(24, this.xbb);
            }
            if (this.xbc != null) {
                aVar.fZ(25, this.xbc.bkL());
                this.xbc.a(aVar);
            }
            if (this.xbd != null) {
                aVar.g(26, this.xbd);
            }
            aVar.fX(27, this.xbe);
            if (this.fXy != null) {
                aVar.g(28, this.fXy);
            }
            aVar.fX(29, this.woN);
            aVar.S(30, this.xbf);
            if (this.xbg == null) {
                return 0;
            }
            aVar.g(31, this.xbg);
            return 0;
        } else if (i == 1) {
            if (this.wCw != null) {
                fW = e.a.a.a.fW(1, this.wCw.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.hxo != null) {
                fW += e.a.a.b.b.a.h(2, this.hxo);
            }
            if (this.xaO != null) {
                fW += e.a.a.b.b.a.h(3, this.xaO);
            }
            if (this.xaP != null) {
                fW += e.a.a.b.b.a.h(4, this.xaP);
            }
            fW = ((fW + e.a.a.a.fU(5, this.xaQ)) + e.a.a.a.fU(6, this.xaR)) + e.a.a.a.fU(7, this.xaS);
            if (this.xaT != null) {
                fW += e.a.a.b.b.a.h(8, this.xaT);
            }
            if (this.wbY != null) {
                fW += e.a.a.b.b.a.h(9, this.wbY);
            }
            if (this.wbZ != null) {
                fW += e.a.a.b.b.a.h(10, this.wbZ);
            }
            fW += e.a.a.a.fU(11, this.xaU);
            if (this.xaV != null) {
                fW += e.a.a.a.fW(12, this.xaV.bkL());
            }
            if (this.vTm != null) {
                fW += e.a.a.a.fW(13, this.vTm.bkL());
            }
            fW = (fW + e.a.a.a.fU(14, this.vMj)) + e.a.a.a.fU(15, this.xaW);
            if (this.vSF != null) {
                fW += e.a.a.b.b.a.h(16, this.vSF);
            }
            if (this.wGu != null) {
                fW += e.a.a.b.b.a.h(17, this.wGu);
            }
            if (this.wGv != null) {
                fW += e.a.a.b.b.a.h(18, this.wGv);
            }
            if (this.xaX != null) {
                fW += e.a.a.b.b.a.h(19, this.xaX);
            }
            if (this.xaY != null) {
                fW += e.a.a.b.b.a.h(20, this.xaY);
            }
            if (this.xaZ != null) {
                fW += e.a.a.b.b.a.h(21, this.xaZ);
            }
            if (this.xba != null) {
                fW += e.a.a.b.b.a.h(22, this.xba);
            }
            if (this.vOb != null) {
                fW += e.a.a.a.fW(23, this.vOb.bkL());
            }
            if (this.xbb != null) {
                fW += e.a.a.b.b.a.h(24, this.xbb);
            }
            if (this.xbc != null) {
                fW += e.a.a.a.fW(25, this.xbc.bkL());
            }
            if (this.xbd != null) {
                fW += e.a.a.b.b.a.h(26, this.xbd);
            }
            fW += e.a.a.a.fU(27, this.xbe);
            if (this.fXy != null) {
                fW += e.a.a.b.b.a.h(28, this.fXy);
            }
            fW = (fW + e.a.a.a.fU(29, this.woN)) + e.a.a.a.R(30, this.xbf);
            if (this.xbg != null) {
                fW += e.a.a.b.b.a.h(31, this.xbg);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wCw != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SnsUserInfo");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsz bsz = (bsz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bmk;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bmk = new bmk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmk.a(aVar4, bmk, a.a(aVar4))) {
                        }
                        bsz.wCw = bmk;
                    }
                    return 0;
                case 2:
                    bsz.hxo = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bsz.xaO = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bsz.xaP = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bsz.xaQ = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bsz.xaR = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bsz.xaS = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bsz.xaT = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    bsz.wbY = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    bsz.wbZ = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    bsz.xaU = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bmk = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmk.a(aVar4, bmk, a.a(aVar4))) {
                        }
                        bsz.xaV = bmk;
                    }
                    return 0;
                case 13:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bmk = new bew();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmk.a(aVar4, bmk, a.a(aVar4))) {
                        }
                        bsz.vTm = bmk;
                    }
                    return 0;
                case 14:
                    bsz.vMj = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    bsz.xaW = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    bsz.vSF = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    bsz.wGu = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    bsz.wGv = aVar3.AEQ.readString();
                    return 0;
                case 19:
                    bsz.xaX = aVar3.AEQ.readString();
                    return 0;
                case 20:
                    bsz.xaY = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    bsz.xaZ = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    bsz.xba = aVar3.AEQ.readString();
                    return 0;
                case 23:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bmk = new ape();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmk.a(aVar4, bmk, a.a(aVar4))) {
                        }
                        bsz.vOb = bmk;
                    }
                    return 0;
                case 24:
                    bsz.xbb = aVar3.AEQ.readString();
                    return 0;
                case 25:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bmk = new awn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmk.a(aVar4, bmk, a.a(aVar4))) {
                        }
                        bsz.xbc = bmk;
                    }
                    return 0;
                case 26:
                    bsz.xbd = aVar3.AEQ.readString();
                    return 0;
                case 27:
                    bsz.xbe = aVar3.AEQ.rz();
                    return 0;
                case 28:
                    bsz.fXy = aVar3.AEQ.readString();
                    return 0;
                case 29:
                    bsz.woN = aVar3.AEQ.rz();
                    return 0;
                case 30:
                    bsz.xbf = aVar3.AEQ.rA();
                    return 0;
                case 31:
                    bsz.xbg = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
