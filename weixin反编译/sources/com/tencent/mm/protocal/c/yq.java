package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class yq extends bea {
    public String kPE;
    public String kPy;
    public b kRX;
    public int kZN;
    public String kZO;
    public String kZP;
    public String kZQ;
    public String kZR;
    public int time_stamp;
    public int wpG;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.kPE != null) {
                aVar.g(2, this.kPE);
            }
            aVar.fX(3, this.kZN);
            if (this.kZO != null) {
                aVar.g(4, this.kZO);
            }
            if (this.kZP != null) {
                aVar.g(5, this.kZP);
            }
            aVar.fX(6, this.time_stamp);
            if (this.kZQ != null) {
                aVar.g(7, this.kZQ);
            }
            if (this.kPy != null) {
                aVar.g(8, this.kPy);
            }
            if (this.kZR != null) {
                aVar.g(9, this.kZR);
            }
            if (this.kRX != null) {
                aVar.b(10, this.kRX);
            }
            aVar.fX(11, this.wpG);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.kPE != null) {
                fW += e.a.a.b.b.a.h(2, this.kPE);
            }
            fW += e.a.a.a.fU(3, this.kZN);
            if (this.kZO != null) {
                fW += e.a.a.b.b.a.h(4, this.kZO);
            }
            if (this.kZP != null) {
                fW += e.a.a.b.b.a.h(5, this.kZP);
            }
            fW += e.a.a.a.fU(6, this.time_stamp);
            if (this.kZQ != null) {
                fW += e.a.a.b.b.a.h(7, this.kZQ);
            }
            if (this.kPy != null) {
                fW += e.a.a.b.b.a.h(8, this.kPy);
            }
            if (this.kZR != null) {
                fW += e.a.a.b.b.a.h(9, this.kZR);
            }
            if (this.kRX != null) {
                fW += e.a.a.a.a(10, this.kRX);
            }
            return fW + e.a.a.a.fU(11, this.wpG);
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
            yq yqVar = (yq) objArr[1];
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
                        yqVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    yqVar.kPE = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    yqVar.kZN = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    yqVar.kZO = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    yqVar.kZP = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    yqVar.time_stamp = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    yqVar.kZQ = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    yqVar.kPy = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    yqVar.kZR = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    yqVar.kRX = aVar3.cKw();
                    return 0;
                case 11:
                    yqVar.wpG = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
