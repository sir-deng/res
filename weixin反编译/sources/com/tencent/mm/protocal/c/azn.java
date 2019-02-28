package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class azn extends bek {
    public int nJA;
    public int nJD;
    public int nJk;
    public String nJl;
    public int nJp;
    public int nJv;
    public int nJw;
    public int nJx;
    public b nJy;
    public LinkedList<azf> vQG = new LinkedList();
    public long wMU;
    public int wNd;
    public int wNe;
    public LinkedList<azf> wNf = new LinkedList();
    public String wNg;
    public b wNh;
    public int wNi;
    public int wil;
    public long wim;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            aVar.fX(2, this.wil);
            aVar.S(3, this.wim);
            aVar.fX(4, this.wNd);
            aVar.d(5, 8, this.vQG);
            aVar.fX(6, this.wNe);
            aVar.fX(7, this.nJv);
            aVar.fX(8, this.nJw);
            aVar.S(9, this.wMU);
            aVar.fX(10, this.nJx);
            if (this.nJy != null) {
                aVar.b(11, this.nJy);
            }
            aVar.fX(12, this.nJp);
            aVar.fX(13, this.nJk);
            if (this.nJl != null) {
                aVar.g(14, this.nJl);
            }
            aVar.fX(15, this.nJA);
            aVar.d(16, 8, this.wNf);
            aVar.fX(17, this.nJD);
            if (this.wNg != null) {
                aVar.g(18, this.wNg);
            }
            if (this.wNh != null) {
                aVar.b(19, this.wNh);
            }
            aVar.fX(20, this.wNi);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((((((((fW + e.a.a.a.fU(2, this.wil)) + e.a.a.a.R(3, this.wim)) + e.a.a.a.fU(4, this.wNd)) + e.a.a.a.c(5, 8, this.vQG)) + e.a.a.a.fU(6, this.wNe)) + e.a.a.a.fU(7, this.nJv)) + e.a.a.a.fU(8, this.nJw)) + e.a.a.a.R(9, this.wMU)) + e.a.a.a.fU(10, this.nJx);
            if (this.nJy != null) {
                fW += e.a.a.a.a(11, this.nJy);
            }
            fW = (fW + e.a.a.a.fU(12, this.nJp)) + e.a.a.a.fU(13, this.nJk);
            if (this.nJl != null) {
                fW += e.a.a.b.b.a.h(14, this.nJl);
            }
            fW = ((fW + e.a.a.a.fU(15, this.nJA)) + e.a.a.a.c(16, 8, this.wNf)) + e.a.a.a.fU(17, this.nJD);
            if (this.wNg != null) {
                fW += e.a.a.b.b.a.h(18, this.wNg);
            }
            if (this.wNh != null) {
                fW += e.a.a.a.a(19, this.wNh);
            }
            return fW + e.a.a.a.fU(20, this.wNi);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vQG.clear();
            this.wNf.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            azn azn = (azn) objArr[1];
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
                        azn.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    azn.wil = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    azn.wim = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    azn.wNd = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new azf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        azn.vQG.add(fiVar);
                    }
                    return 0;
                case 6:
                    azn.wNe = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    azn.nJv = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    azn.nJw = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    azn.wMU = aVar3.AEQ.rA();
                    return 0;
                case 10:
                    azn.nJx = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    azn.nJy = aVar3.cKw();
                    return 0;
                case 12:
                    azn.nJp = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    azn.nJk = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    azn.nJl = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    azn.nJA = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new azf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        azn.wNf.add(fiVar);
                    }
                    return 0;
                case 17:
                    azn.nJD = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    azn.wNg = aVar3.AEQ.readString();
                    return 0;
                case 19:
                    azn.wNh = aVar3.cKw();
                    return 0;
                case 20:
                    azn.wNi = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
