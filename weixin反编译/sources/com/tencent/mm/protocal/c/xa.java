package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class xa extends bea {
    public String hxn;
    public String nnm;
    public LinkedList<String> wnY = new LinkedList();
    public LinkedList<String> wof = new LinkedList();
    public int wog;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.d(2, 1, this.wof);
            aVar.d(3, 1, this.wnY);
            if (this.nnm != null) {
                aVar.g(4, this.nnm);
            }
            if (this.hxn != null) {
                aVar.g(5, this.hxn);
            }
            aVar.fX(6, this.wog);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.c(2, 1, this.wof)) + e.a.a.a.c(3, 1, this.wnY);
            if (this.nnm != null) {
                fW += e.a.a.b.b.a.h(4, this.nnm);
            }
            if (this.hxn != null) {
                fW += e.a.a.b.b.a.h(5, this.hxn);
            }
            return fW + e.a.a.a.fU(6, this.wog);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wof.clear();
            this.wnY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            xa xaVar = (xa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        xaVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    xaVar.wof.add(aVar3.AEQ.readString());
                    return 0;
                case 3:
                    xaVar.wnY.add(aVar3.AEQ.readString());
                    return 0;
                case 4:
                    xaVar.nnm = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    xaVar.hxn = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    xaVar.wog = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
