package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bfj extends bea {
    public String fGh;
    public String state;
    public int wIR;
    public LinkedList<String> wIS = new LinkedList();
    public String wRB;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(3, this.wIR);
            aVar.d(4, 1, this.wIS);
            if (this.fGh != null) {
                aVar.g(5, this.fGh);
            }
            if (this.state != null) {
                aVar.g(6, this.state);
            }
            if (this.wRB == null) {
                return 0;
            }
            aVar.g(7, this.wRB);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.fU(3, this.wIR)) + e.a.a.a.c(4, 1, this.wIS);
            if (this.fGh != null) {
                fW += e.a.a.b.b.a.h(5, this.fGh);
            }
            if (this.state != null) {
                fW += e.a.a.b.b.a.h(6, this.state);
            }
            if (this.wRB != null) {
                fW += e.a.a.b.b.a.h(7, this.wRB);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wIS.clear();
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
            bfj bfj = (bfj) objArr[1];
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
                        bfj.wQE = fhVar;
                    }
                    return 0;
                case 3:
                    bfj.wIR = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bfj.wIS.add(aVar3.AEQ.readString());
                    return 0;
                case 5:
                    bfj.fGh = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bfj.state = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bfj.wRB = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
