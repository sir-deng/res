package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ni extends bea {
    public String wcP;
    public String wcQ;
    public String wcR;
    public String wcS;
    public String wcT;
    public long wcU;
    public String wcV;
    public String wcW;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wcP != null) {
                aVar.g(2, this.wcP);
            }
            if (this.wcQ != null) {
                aVar.g(3, this.wcQ);
            }
            if (this.wcR != null) {
                aVar.g(4, this.wcR);
            }
            if (this.wcS != null) {
                aVar.g(5, this.wcS);
            }
            if (this.wcT != null) {
                aVar.g(6, this.wcT);
            }
            aVar.S(7, this.wcU);
            if (this.wcV != null) {
                aVar.g(8, this.wcV);
            }
            if (this.wcW == null) {
                return 0;
            }
            aVar.g(9, this.wcW);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wcP != null) {
                fW += e.a.a.b.b.a.h(2, this.wcP);
            }
            if (this.wcQ != null) {
                fW += e.a.a.b.b.a.h(3, this.wcQ);
            }
            if (this.wcR != null) {
                fW += e.a.a.b.b.a.h(4, this.wcR);
            }
            if (this.wcS != null) {
                fW += e.a.a.b.b.a.h(5, this.wcS);
            }
            if (this.wcT != null) {
                fW += e.a.a.b.b.a.h(6, this.wcT);
            }
            fW += e.a.a.a.R(7, this.wcU);
            if (this.wcV != null) {
                fW += e.a.a.b.b.a.h(8, this.wcV);
            }
            if (this.wcW != null) {
                fW += e.a.a.b.b.a.h(9, this.wcW);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ni niVar = (ni) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        niVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    niVar.wcP = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    niVar.wcQ = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    niVar.wcR = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    niVar.wcS = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    niVar.wcT = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    niVar.wcU = aVar3.AEQ.rA();
                    return 0;
                case 8:
                    niVar.wcV = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    niVar.wcW = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
