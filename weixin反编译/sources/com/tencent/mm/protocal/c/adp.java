package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class adp extends bek {
    public String wnA;
    public String wnB;
    public int wnC;
    public String wnD;
    public int wnz;
    public String wsJ;
    public String wsK;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            if (this.wsJ != null) {
                aVar.g(2, this.wsJ);
            }
            aVar.fX(3, this.wnz);
            if (this.wnA != null) {
                aVar.g(4, this.wnA);
            }
            if (this.wnB != null) {
                aVar.g(5, this.wnB);
            }
            aVar.fX(6, this.wnC);
            if (this.wnD != null) {
                aVar.g(7, this.wnD);
            }
            if (this.wsK == null) {
                return 0;
            }
            aVar.g(8, this.wsK);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wsJ != null) {
                fW += e.a.a.b.b.a.h(2, this.wsJ);
            }
            fW += e.a.a.a.fU(3, this.wnz);
            if (this.wnA != null) {
                fW += e.a.a.b.b.a.h(4, this.wnA);
            }
            if (this.wnB != null) {
                fW += e.a.a.b.b.a.h(5, this.wnB);
            }
            fW += e.a.a.a.fU(6, this.wnC);
            if (this.wnD != null) {
                fW += e.a.a.b.b.a.h(7, this.wnD);
            }
            if (this.wsK != null) {
                fW += e.a.a.b.b.a.h(8, this.wsK);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            adp adp = (adp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fiVar = new fi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        adp.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    adp.wsJ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    adp.wnz = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    adp.wnA = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    adp.wnB = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    adp.wnC = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    adp.wnD = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    adp.wsK = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
