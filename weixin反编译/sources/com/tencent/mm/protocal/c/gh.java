package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class gh extends a {
    public String kyK;
    public int vQL;
    public String vSj;
    public String vSo;
    public asc vSp;
    public ake vSq;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vQL);
            if (this.vSo != null) {
                aVar.g(2, this.vSo);
            }
            if (this.vSp != null) {
                aVar.fZ(3, this.vSp.bkL());
                this.vSp.a(aVar);
            }
            if (this.vSj != null) {
                aVar.g(4, this.vSj);
            }
            if (this.kyK != null) {
                aVar.g(5, this.kyK);
            }
            if (this.vSq != null) {
                aVar.fZ(6, this.vSq.bkL());
                this.vSq.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vQL) + 0;
            if (this.vSo != null) {
                fU += e.a.a.b.b.a.h(2, this.vSo);
            }
            if (this.vSp != null) {
                fU += e.a.a.a.fW(3, this.vSp.bkL());
            }
            if (this.vSj != null) {
                fU += e.a.a.b.b.a.h(4, this.vSj);
            }
            if (this.kyK != null) {
                fU += e.a.a.b.b.a.h(5, this.kyK);
            }
            if (this.vSq != null) {
                return fU + e.a.a.a.fW(6, this.vSq.bkL());
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
            gh ghVar = (gh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a asc;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ghVar.vQL = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    ghVar.vSo = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        asc = new asc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asc.a(aVar4, asc, a.a(aVar4))) {
                        }
                        ghVar.vSp = asc;
                    }
                    return 0;
                case 4:
                    ghVar.vSj = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ghVar.kyK = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        asc = new ake();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asc.a(aVar4, asc, a.a(aVar4))) {
                        }
                        ghVar.vSq = asc;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
