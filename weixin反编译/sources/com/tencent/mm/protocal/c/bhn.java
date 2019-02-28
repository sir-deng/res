package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bhn extends bea {
    public String fGh;
    public String fsK;
    public String pff;
    public String vQk;
    public LinkedList<Integer> wSC = new LinkedList();
    public String wSD;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.fGh != null) {
                aVar.g(2, this.fGh);
            }
            aVar.d(3, 2, this.wSC);
            if (this.wSD != null) {
                aVar.g(4, this.wSD);
            }
            if (this.vQk != null) {
                aVar.g(5, this.vQk);
            }
            if (this.fsK != null) {
                aVar.g(6, this.fsK);
            }
            if (this.pff == null) {
                return 0;
            }
            aVar.g(7, this.pff);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.fGh != null) {
                fW += e.a.a.b.b.a.h(2, this.fGh);
            }
            fW += e.a.a.a.c(3, 2, this.wSC);
            if (this.wSD != null) {
                fW += e.a.a.b.b.a.h(4, this.wSD);
            }
            if (this.vQk != null) {
                fW += e.a.a.b.b.a.h(5, this.vQk);
            }
            if (this.fsK != null) {
                fW += e.a.a.b.b.a.h(6, this.fsK);
            }
            if (this.pff != null) {
                fW += e.a.a.b.b.a.h(7, this.pff);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wSC.clear();
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
            bhn bhn = (bhn) objArr[1];
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
                        bhn.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bhn.fGh = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bhn.wSC.add(Integer.valueOf(aVar3.AEQ.rz()));
                    return 0;
                case 4:
                    bhn.wSD = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bhn.vQk = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bhn.fsK = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bhn.pff = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
