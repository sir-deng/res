package com.tencent.mm.plugin.address.d;

import com.tencent.mm.bp.a;

public final class b extends a {
    public int id;
    public String ioE;
    public String ioF;
    public String ioG;
    public String ioH;
    public String ioI;
    public String ioJ;
    public String ioK;
    public String ioL;
    public String ioM;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.id);
            if (this.ioE != null) {
                aVar.g(2, this.ioE);
            }
            if (this.ioF != null) {
                aVar.g(3, this.ioF);
            }
            if (this.ioG != null) {
                aVar.g(4, this.ioG);
            }
            if (this.ioH != null) {
                aVar.g(5, this.ioH);
            }
            if (this.ioI != null) {
                aVar.g(6, this.ioI);
            }
            if (this.ioJ != null) {
                aVar.g(7, this.ioJ);
            }
            if (this.ioK != null) {
                aVar.g(8, this.ioK);
            }
            if (this.ioL != null) {
                aVar.g(9, this.ioL);
            }
            if (this.ioM != null) {
                aVar.g(10, this.ioM);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.id) + 0;
            if (this.ioE != null) {
                fU += e.a.a.b.b.a.h(2, this.ioE);
            }
            if (this.ioF != null) {
                fU += e.a.a.b.b.a.h(3, this.ioF);
            }
            if (this.ioG != null) {
                fU += e.a.a.b.b.a.h(4, this.ioG);
            }
            if (this.ioH != null) {
                fU += e.a.a.b.b.a.h(5, this.ioH);
            }
            if (this.ioI != null) {
                fU += e.a.a.b.b.a.h(6, this.ioI);
            }
            if (this.ioJ != null) {
                fU += e.a.a.b.b.a.h(7, this.ioJ);
            }
            if (this.ioK != null) {
                fU += e.a.a.b.b.a.h(8, this.ioK);
            }
            if (this.ioL != null) {
                fU += e.a.a.b.b.a.h(9, this.ioL);
            }
            if (this.ioM != null) {
                return fU + e.a.a.b.b.a.h(10, this.ioM);
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
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.id = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bVar.ioE = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bVar.ioF = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bVar.ioG = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bVar.ioH = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bVar.ioI = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bVar.ioJ = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bVar.ioK = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    bVar.ioL = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    bVar.ioM = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
