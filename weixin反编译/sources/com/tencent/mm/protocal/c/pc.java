package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class pc extends a {
    public String fqs;
    public String fqt;
    public int version;
    public int weH;
    public int weI;
    public String weJ;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.version);
            aVar.fX(2, this.weH);
            aVar.fX(3, this.weI);
            if (this.fqt != null) {
                aVar.g(4, this.fqt);
            }
            if (this.weJ != null) {
                aVar.g(5, this.weJ);
            }
            if (this.fqs != null) {
                aVar.g(6, this.fqs);
            }
            return 0;
        } else if (i == 1) {
            fU = ((e.a.a.a.fU(1, this.version) + 0) + e.a.a.a.fU(2, this.weH)) + e.a.a.a.fU(3, this.weI);
            if (this.fqt != null) {
                fU += e.a.a.b.b.a.h(4, this.fqt);
            }
            if (this.weJ != null) {
                fU += e.a.a.b.b.a.h(5, this.weJ);
            }
            if (this.fqs != null) {
                return fU + e.a.a.b.b.a.h(6, this.fqs);
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
            pc pcVar = (pc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pcVar.version = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    pcVar.weH = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    pcVar.weI = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    pcVar.fqt = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    pcVar.weJ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    pcVar.fqs = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
