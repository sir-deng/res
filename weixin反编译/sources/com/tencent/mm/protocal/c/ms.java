package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ms extends bea {
    public String hLi;
    public String npV;
    public String npW;
    public int vPv;
    public String vXE;
    public long wce;
    public String wcf;
    public String wcg;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.npW != null) {
                aVar.g(2, this.npW);
            }
            if (this.npV != null) {
                aVar.g(3, this.npV);
            }
            aVar.S(4, this.wce);
            if (this.vXE != null) {
                aVar.g(5, this.vXE);
            }
            if (this.wcf != null) {
                aVar.g(6, this.wcf);
            }
            aVar.fX(7, this.vPv);
            if (this.wcg != null) {
                aVar.g(8, this.wcg);
            }
            if (this.hLi == null) {
                return 0;
            }
            aVar.g(9, this.hLi);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.npW != null) {
                fW += e.a.a.b.b.a.h(2, this.npW);
            }
            if (this.npV != null) {
                fW += e.a.a.b.b.a.h(3, this.npV);
            }
            fW += e.a.a.a.R(4, this.wce);
            if (this.vXE != null) {
                fW += e.a.a.b.b.a.h(5, this.vXE);
            }
            if (this.wcf != null) {
                fW += e.a.a.b.b.a.h(6, this.wcf);
            }
            fW += e.a.a.a.fU(7, this.vPv);
            if (this.wcg != null) {
                fW += e.a.a.b.b.a.h(8, this.wcg);
            }
            if (this.hLi != null) {
                fW += e.a.a.b.b.a.h(9, this.hLi);
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
            ms msVar = (ms) objArr[1];
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
                        msVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    msVar.npW = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    msVar.npV = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    msVar.wce = aVar3.AEQ.rA();
                    return 0;
                case 5:
                    msVar.vXE = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    msVar.wcf = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    msVar.vPv = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    msVar.wcg = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    msVar.hLi = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
