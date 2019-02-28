package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class mi extends a {
    public String pfi;
    public int wbG;
    public String wbH;
    public String wbI;
    public String wbJ;
    public int wbK;
    public String wbL;
    public int wbM;
    public String wbN;
    public int wbO;
    public String wbP;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wbG);
            if (this.wbH != null) {
                aVar.g(2, this.wbH);
            }
            if (this.wbI != null) {
                aVar.g(3, this.wbI);
            }
            if (this.wbJ != null) {
                aVar.g(4, this.wbJ);
            }
            aVar.fX(5, this.wbK);
            if (this.wbL != null) {
                aVar.g(6, this.wbL);
            }
            aVar.fX(7, this.wbM);
            if (this.pfi != null) {
                aVar.g(8, this.pfi);
            }
            if (this.wbN != null) {
                aVar.g(9, this.wbN);
            }
            aVar.fX(10, this.wbO);
            if (this.wbP != null) {
                aVar.g(11, this.wbP);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wbG) + 0;
            if (this.wbH != null) {
                fU += e.a.a.b.b.a.h(2, this.wbH);
            }
            if (this.wbI != null) {
                fU += e.a.a.b.b.a.h(3, this.wbI);
            }
            if (this.wbJ != null) {
                fU += e.a.a.b.b.a.h(4, this.wbJ);
            }
            fU += e.a.a.a.fU(5, this.wbK);
            if (this.wbL != null) {
                fU += e.a.a.b.b.a.h(6, this.wbL);
            }
            fU += e.a.a.a.fU(7, this.wbM);
            if (this.pfi != null) {
                fU += e.a.a.b.b.a.h(8, this.pfi);
            }
            if (this.wbN != null) {
                fU += e.a.a.b.b.a.h(9, this.wbN);
            }
            fU += e.a.a.a.fU(10, this.wbO);
            if (this.wbP != null) {
                return fU + e.a.a.b.b.a.h(11, this.wbP);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            mi miVar = (mi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    miVar.wbG = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    miVar.wbH = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    miVar.wbI = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    miVar.wbJ = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    miVar.wbK = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    miVar.wbL = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    miVar.wbM = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    miVar.pfi = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    miVar.wbN = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    miVar.wbO = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    miVar.wbP = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
