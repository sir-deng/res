package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class blf extends a {
    public int pgR;
    public LinkedList<bla> vOp = new LinkedList();
    public String vPp;
    public long vWS;
    public String wDh;
    public LinkedList<bet> wFx = new LinkedList();
    public int wGC;
    public int wGH;
    public int wHZ;
    public bes wUN;
    public int wUO;
    public int wUP;
    public int wUQ;
    public LinkedList<bku> wUR = new LinkedList();
    public int wUS;
    public int wUT;
    public LinkedList<bku> wUU = new LinkedList();
    public int wUV;
    public int wUW;
    public LinkedList<bku> wUX = new LinkedList();
    public int wUY;
    public String wUZ;
    public int wUo;
    public long wVa;
    public int wVb;
    public LinkedList<bet> wVc = new LinkedList();
    public int wVd;
    public bes wVe;
    public blu wVf;
    public ayt wVg;
    public bkq wVh;

    protected final int a(int i, Object... objArr) {
        int R;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wUN == null) {
                throw new b("Not all required fields were included: ObjectDesc");
            }
            aVar.S(1, this.vWS);
            if (this.vPp != null) {
                aVar.g(2, this.vPp);
            }
            if (this.wDh != null) {
                aVar.g(3, this.wDh);
            }
            aVar.fX(4, this.pgR);
            if (this.wUN != null) {
                aVar.fZ(5, this.wUN.bkL());
                this.wUN.a(aVar);
            }
            aVar.fX(6, this.wUO);
            aVar.fX(7, this.wUP);
            aVar.fX(8, this.wUQ);
            aVar.d(9, 8, this.wUR);
            aVar.fX(10, this.wUS);
            aVar.fX(11, this.wUT);
            aVar.d(12, 8, this.wUU);
            aVar.fX(13, this.wUV);
            aVar.fX(14, this.wUW);
            aVar.d(15, 8, this.wUX);
            aVar.fX(16, this.wGH);
            aVar.fX(17, this.wUY);
            aVar.fX(18, this.wHZ);
            aVar.d(19, 8, this.vOp);
            aVar.fX(20, this.wUo);
            if (this.wUZ != null) {
                aVar.g(21, this.wUZ);
            }
            aVar.S(22, this.wVa);
            aVar.fX(23, this.wVb);
            aVar.d(24, 8, this.wVc);
            aVar.fX(25, this.wGC);
            aVar.fX(26, this.wVd);
            aVar.d(27, 8, this.wFx);
            if (this.wVe != null) {
                aVar.fZ(28, this.wVe.bkL());
                this.wVe.a(aVar);
            }
            if (this.wVf != null) {
                aVar.fZ(29, this.wVf.bkL());
                this.wVf.a(aVar);
            }
            if (this.wVg != null) {
                aVar.fZ(30, this.wVg.bkL());
                this.wVg.a(aVar);
            }
            if (this.wVh != null) {
                aVar.fZ(31, this.wVh.bkL());
                this.wVh.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            R = e.a.a.a.R(1, this.vWS) + 0;
            if (this.vPp != null) {
                R += e.a.a.b.b.a.h(2, this.vPp);
            }
            if (this.wDh != null) {
                R += e.a.a.b.b.a.h(3, this.wDh);
            }
            R += e.a.a.a.fU(4, this.pgR);
            if (this.wUN != null) {
                R += e.a.a.a.fW(5, this.wUN.bkL());
            }
            R = ((((((((((((((R + e.a.a.a.fU(6, this.wUO)) + e.a.a.a.fU(7, this.wUP)) + e.a.a.a.fU(8, this.wUQ)) + e.a.a.a.c(9, 8, this.wUR)) + e.a.a.a.fU(10, this.wUS)) + e.a.a.a.fU(11, this.wUT)) + e.a.a.a.c(12, 8, this.wUU)) + e.a.a.a.fU(13, this.wUV)) + e.a.a.a.fU(14, this.wUW)) + e.a.a.a.c(15, 8, this.wUX)) + e.a.a.a.fU(16, this.wGH)) + e.a.a.a.fU(17, this.wUY)) + e.a.a.a.fU(18, this.wHZ)) + e.a.a.a.c(19, 8, this.vOp)) + e.a.a.a.fU(20, this.wUo);
            if (this.wUZ != null) {
                R += e.a.a.b.b.a.h(21, this.wUZ);
            }
            R = (((((R + e.a.a.a.R(22, this.wVa)) + e.a.a.a.fU(23, this.wVb)) + e.a.a.a.c(24, 8, this.wVc)) + e.a.a.a.fU(25, this.wGC)) + e.a.a.a.fU(26, this.wVd)) + e.a.a.a.c(27, 8, this.wFx);
            if (this.wVe != null) {
                R += e.a.a.a.fW(28, this.wVe.bkL());
            }
            if (this.wVf != null) {
                R += e.a.a.a.fW(29, this.wVf.bkL());
            }
            if (this.wVg != null) {
                R += e.a.a.a.fW(30, this.wVg.bkL());
            }
            if (this.wVh != null) {
                return R + e.a.a.a.fW(31, this.wVh.bkL());
            }
            return R;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wUR.clear();
            this.wUU.clear();
            this.wUX.clear();
            this.vOp.clear();
            this.wVc.clear();
            this.wFx.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (R = a.a(aVar2); R > 0; R = a.a(aVar2)) {
                if (!super.a(aVar2, this, R)) {
                    aVar2.cKx();
                }
            }
            if (this.wUN != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ObjectDesc");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            blf blf = (blf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a bes;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    blf.vWS = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    blf.vPp = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    blf.wDh = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    blf.pgR = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        blf.wUN = bes;
                    }
                    return 0;
                case 6:
                    blf.wUO = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    blf.wUP = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    blf.wUQ = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bku();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        blf.wUR.add(bes);
                    }
                    return 0;
                case 10:
                    blf.wUS = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    blf.wUT = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bku();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        blf.wUU.add(bes);
                    }
                    return 0;
                case 13:
                    blf.wUV = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    blf.wUW = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bku();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        blf.wUX.add(bes);
                    }
                    return 0;
                case 16:
                    blf.wGH = aVar3.AEQ.rz();
                    return 0;
                case 17:
                    blf.wUY = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    blf.wHZ = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bla();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        blf.vOp.add(bes);
                    }
                    return 0;
                case 20:
                    blf.wUo = aVar3.AEQ.rz();
                    return 0;
                case 21:
                    blf.wUZ = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    blf.wVa = aVar3.AEQ.rA();
                    return 0;
                case 23:
                    blf.wVb = aVar3.AEQ.rz();
                    return 0;
                case 24:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        blf.wVc.add(bes);
                    }
                    return 0;
                case 25:
                    blf.wGC = aVar3.AEQ.rz();
                    return 0;
                case 26:
                    blf.wVd = aVar3.AEQ.rz();
                    return 0;
                case 27:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        blf.wFx.add(bes);
                    }
                    return 0;
                case 28:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        blf.wVe = bes;
                    }
                    return 0;
                case 29:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new blu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        blf.wVf = bes;
                    }
                    return 0;
                case 30:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new ayt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        blf.wVg = bes;
                    }
                    return 0;
                case 31:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bkq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        blf.wVh = bes;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
