package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aba extends bek {
    public String wqJ;
    public int wqK;
    public String wqL;
    public int wqM;

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
            if (this.wqJ != null) {
                aVar.g(2, this.wqJ);
            }
            aVar.fX(3, this.wqK);
            if (this.wqL != null) {
                aVar.g(4, this.wqL);
            }
            aVar.fX(5, this.wqM);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wqJ != null) {
                fW += e.a.a.b.b.a.h(2, this.wqJ);
            }
            fW += e.a.a.a.fU(3, this.wqK);
            if (this.wqL != null) {
                fW += e.a.a.b.b.a.h(4, this.wqL);
            }
            return fW + e.a.a.a.fU(5, this.wqM);
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
            aba aba = (aba) objArr[1];
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
                        aba.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    aba.wqJ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aba.wqK = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    aba.wqL = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aba.wqM = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
