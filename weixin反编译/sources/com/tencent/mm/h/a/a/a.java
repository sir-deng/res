package com.tencent.mm.h.a.a;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bp.a {
    public int fBU;
    public int fEo;
    public LinkedList<b> gDp = new LinkedList();
    public int gDq;
    public String gDr;
    public int gDs;
    public int status;
    public int type;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.gDp);
            aVar.fX(2, this.fEo);
            aVar.fX(3, this.type);
            aVar.fX(4, this.status);
            aVar.fX(5, this.gDq);
            if (this.gDr != null) {
                aVar.g(6, this.gDr);
            }
            aVar.fX(7, this.fBU);
            aVar.fX(8, this.gDs);
            return 0;
        } else if (i == 1) {
            c = ((((e.a.a.a.c(1, 8, this.gDp) + 0) + e.a.a.a.fU(2, this.fEo)) + e.a.a.a.fU(3, this.type)) + e.a.a.a.fU(4, this.status)) + e.a.a.a.fU(5, this.gDq);
            if (this.gDr != null) {
                c += e.a.a.b.b.a.h(6, this.gDr);
            }
            return (c + e.a.a.a.fU(7, this.fBU)) + e.a.a.a.fU(8, this.gDs);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.gDp.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = com.tencent.mm.bp.a.a(aVar2); c > 0; c = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a bVar = new b();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bVar.a(aVar5, bVar, com.tencent.mm.bp.a.a(aVar5))) {
                        }
                        aVar4.gDp.add(bVar);
                    }
                    return 0;
                case 2:
                    aVar4.fEo = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    aVar4.type = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    aVar4.status = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    aVar4.gDq = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    aVar4.gDr = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    aVar4.fBU = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    aVar4.gDs = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
