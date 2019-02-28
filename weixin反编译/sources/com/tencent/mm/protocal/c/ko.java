package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ko extends a {
    public String code;
    public int status;
    public int vYb;
    public int vYc;
    public LinkedList<lb> vYd = new LinkedList();
    public LinkedList<lb> vYe = new LinkedList();
    public LinkedList<lb> vYf = new LinkedList();
    public LinkedList<String> vYg = new LinkedList();
    public int vYh;
    public int vYi;
    public LinkedList<oy> vYj = new LinkedList();
    public long vYk;
    public int vYl;
    public String vYm;
    public oy vYn;
    public LinkedList<aw> vYo = new LinkedList();
    public oy vYp;
    public oy vYq;
    public oy vYr;
    public rj vYs;
    public String vYt;
    public oy vYu;
    public String vYv;
    public oy vYw;
    public boolean vYx;
    public boolean vYy;

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.status);
            aVar.fX(2, this.vYb);
            aVar.fX(3, this.vYc);
            aVar.d(4, 8, this.vYd);
            aVar.d(5, 8, this.vYe);
            aVar.d(6, 8, this.vYf);
            aVar.d(7, 1, this.vYg);
            aVar.fX(8, this.vYh);
            if (this.code != null) {
                aVar.g(9, this.code);
            }
            aVar.fX(10, this.vYi);
            aVar.d(11, 8, this.vYj);
            aVar.S(12, this.vYk);
            aVar.fX(13, this.vYl);
            if (this.vYm != null) {
                aVar.g(14, this.vYm);
            }
            if (this.vYn != null) {
                aVar.fZ(15, this.vYn.bkL());
                this.vYn.a(aVar);
            }
            aVar.d(16, 8, this.vYo);
            if (this.vYp != null) {
                aVar.fZ(17, this.vYp.bkL());
                this.vYp.a(aVar);
            }
            if (this.vYq != null) {
                aVar.fZ(18, this.vYq.bkL());
                this.vYq.a(aVar);
            }
            if (this.vYr != null) {
                aVar.fZ(19, this.vYr.bkL());
                this.vYr.a(aVar);
            }
            if (this.vYs != null) {
                aVar.fZ(20, this.vYs.bkL());
                this.vYs.a(aVar);
            }
            if (this.vYt != null) {
                aVar.g(21, this.vYt);
            }
            if (this.vYu != null) {
                aVar.fZ(22, this.vYu.bkL());
                this.vYu.a(aVar);
            }
            if (this.vYv != null) {
                aVar.g(23, this.vYv);
            }
            if (this.vYw != null) {
                aVar.fZ(24, this.vYw.bkL());
                this.vYw.a(aVar);
            }
            aVar.am(25, this.vYx);
            aVar.am(26, this.vYy);
            return 0;
        } else if (i == 1) {
            fU = (((((((e.a.a.a.fU(1, this.status) + 0) + e.a.a.a.fU(2, this.vYb)) + e.a.a.a.fU(3, this.vYc)) + e.a.a.a.c(4, 8, this.vYd)) + e.a.a.a.c(5, 8, this.vYe)) + e.a.a.a.c(6, 8, this.vYf)) + e.a.a.a.c(7, 1, this.vYg)) + e.a.a.a.fU(8, this.vYh);
            if (this.code != null) {
                fU += e.a.a.b.b.a.h(9, this.code);
            }
            fU = (((fU + e.a.a.a.fU(10, this.vYi)) + e.a.a.a.c(11, 8, this.vYj)) + e.a.a.a.R(12, this.vYk)) + e.a.a.a.fU(13, this.vYl);
            if (this.vYm != null) {
                fU += e.a.a.b.b.a.h(14, this.vYm);
            }
            if (this.vYn != null) {
                fU += e.a.a.a.fW(15, this.vYn.bkL());
            }
            fU += e.a.a.a.c(16, 8, this.vYo);
            if (this.vYp != null) {
                fU += e.a.a.a.fW(17, this.vYp.bkL());
            }
            if (this.vYq != null) {
                fU += e.a.a.a.fW(18, this.vYq.bkL());
            }
            if (this.vYr != null) {
                fU += e.a.a.a.fW(19, this.vYr.bkL());
            }
            if (this.vYs != null) {
                fU += e.a.a.a.fW(20, this.vYs.bkL());
            }
            if (this.vYt != null) {
                fU += e.a.a.b.b.a.h(21, this.vYt);
            }
            if (this.vYu != null) {
                fU += e.a.a.a.fW(22, this.vYu.bkL());
            }
            if (this.vYv != null) {
                fU += e.a.a.b.b.a.h(23, this.vYv);
            }
            if (this.vYw != null) {
                fU += e.a.a.a.fW(24, this.vYw.bkL());
            }
            return (fU + (e.a.a.b.b.a.dX(25) + 1)) + (e.a.a.b.b.a.dX(26) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vYd.clear();
            this.vYe.clear();
            this.vYf.clear();
            this.vYg.clear();
            this.vYj.clear();
            this.vYo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ko koVar = (ko) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a lbVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    koVar.status = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    koVar.vYb = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    koVar.vYc = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        lbVar = new lb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lbVar.a(aVar4, lbVar, a.a(aVar4))) {
                        }
                        koVar.vYd.add(lbVar);
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        lbVar = new lb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lbVar.a(aVar4, lbVar, a.a(aVar4))) {
                        }
                        koVar.vYe.add(lbVar);
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        lbVar = new lb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lbVar.a(aVar4, lbVar, a.a(aVar4))) {
                        }
                        koVar.vYf.add(lbVar);
                    }
                    return 0;
                case 7:
                    koVar.vYg.add(aVar3.AEQ.readString());
                    return 0;
                case 8:
                    koVar.vYh = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    koVar.code = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    koVar.vYi = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        lbVar = new oy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lbVar.a(aVar4, lbVar, a.a(aVar4))) {
                        }
                        koVar.vYj.add(lbVar);
                    }
                    return 0;
                case 12:
                    koVar.vYk = aVar3.AEQ.rA();
                    return 0;
                case 13:
                    koVar.vYl = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    koVar.vYm = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        lbVar = new oy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lbVar.a(aVar4, lbVar, a.a(aVar4))) {
                        }
                        koVar.vYn = lbVar;
                    }
                    return 0;
                case 16:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        lbVar = new aw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lbVar.a(aVar4, lbVar, a.a(aVar4))) {
                        }
                        koVar.vYo.add(lbVar);
                    }
                    return 0;
                case 17:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        lbVar = new oy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lbVar.a(aVar4, lbVar, a.a(aVar4))) {
                        }
                        koVar.vYp = lbVar;
                    }
                    return 0;
                case 18:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        lbVar = new oy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lbVar.a(aVar4, lbVar, a.a(aVar4))) {
                        }
                        koVar.vYq = lbVar;
                    }
                    return 0;
                case 19:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        lbVar = new oy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lbVar.a(aVar4, lbVar, a.a(aVar4))) {
                        }
                        koVar.vYr = lbVar;
                    }
                    return 0;
                case 20:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        lbVar = new rj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lbVar.a(aVar4, lbVar, a.a(aVar4))) {
                        }
                        koVar.vYs = lbVar;
                    }
                    return 0;
                case 21:
                    koVar.vYt = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        lbVar = new oy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lbVar.a(aVar4, lbVar, a.a(aVar4))) {
                        }
                        koVar.vYu = lbVar;
                    }
                    return 0;
                case 23:
                    koVar.vYv = aVar3.AEQ.readString();
                    return 0;
                case 24:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        lbVar = new oy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lbVar.a(aVar4, lbVar, a.a(aVar4))) {
                        }
                        koVar.vYw = lbVar;
                    }
                    return 0;
                case 25:
                    koVar.vYx = aVar3.cKv();
                    return 0;
                case 26:
                    koVar.vYy = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
