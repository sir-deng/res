package com.tencent.mm.x;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public class j extends a {
    public String fHu;
    public String fHv;
    public String gkB;
    public LinkedList<m> hfI = new LinkedList();
    public int hfJ;
    public String name;
    public int type;

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.type);
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.fHu != null) {
                aVar.g(3, this.fHu);
            }
            if (this.fHv != null) {
                aVar.g(4, this.fHv);
            }
            if (this.gkB != null) {
                aVar.g(5, this.gkB);
            }
            aVar.d(6, 8, this.hfI);
            aVar.fX(7, this.hfJ);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.type) + 0;
            if (this.name != null) {
                fU += e.a.a.b.b.a.h(2, this.name);
            }
            if (this.fHu != null) {
                fU += e.a.a.b.b.a.h(3, this.fHu);
            }
            if (this.fHv != null) {
                fU += e.a.a.b.b.a.h(4, this.fHv);
            }
            if (this.gkB != null) {
                fU += e.a.a.b.b.a.h(5, this.gkB);
            }
            return (fU + e.a.a.a.c(6, 8, this.hfI)) + e.a.a.a.fU(7, this.hfJ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.hfI.clear();
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
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.type = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    jVar.name = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    jVar.fHu = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    jVar.fHv = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    jVar.gkB = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a mVar = new m();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = mVar.a(aVar4, mVar, a.a(aVar4))) {
                        }
                        jVar.hfI.add(mVar);
                    }
                    return 0;
                case 7:
                    jVar.hfJ = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
