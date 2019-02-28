package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bdq extends bea {
    public float fAo;
    public float fBX;
    public String fHP;
    public float wQf;
    public b wQg;
    public boolean wQh;
    public boolean wQi;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.m(2, this.fBX);
            aVar.m(3, this.fAo);
            aVar.m(4, this.wQf);
            if (this.wQg != null) {
                aVar.b(5, this.wQg);
            }
            if (this.fHP != null) {
                aVar.g(6, this.fHP);
            }
            aVar.am(7, this.wQh);
            aVar.am(8, this.wQi);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((fW + (e.a.a.b.b.a.dX(2) + 4)) + (e.a.a.b.b.a.dX(3) + 4)) + (e.a.a.b.b.a.dX(4) + 4);
            if (this.wQg != null) {
                fW += e.a.a.a.a(5, this.wQg);
            }
            if (this.fHP != null) {
                fW += e.a.a.b.b.a.h(6, this.fHP);
            }
            return (fW + (e.a.a.b.b.a.dX(7) + 1)) + (e.a.a.b.b.a.dX(8) + 1);
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
            bdq bdq = (bdq) objArr[1];
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
                        bdq.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bdq.fBX = aVar3.AEQ.readFloat();
                    return 0;
                case 3:
                    bdq.fAo = aVar3.AEQ.readFloat();
                    return 0;
                case 4:
                    bdq.wQf = aVar3.AEQ.readFloat();
                    return 0;
                case 5:
                    bdq.wQg = aVar3.cKw();
                    return 0;
                case 6:
                    bdq.fHP = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bdq.wQh = aVar3.cKv();
                    return 0;
                case 8:
                    bdq.wQi = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
