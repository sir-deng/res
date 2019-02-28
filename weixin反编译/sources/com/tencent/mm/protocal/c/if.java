package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class if extends bek {
    public int kzz;
    public int vSa;
    public int vUK;
    public int vUO;
    public String vUQ;
    public float vUR;
    public float vUS;

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
            aVar.fX(2, this.vUK);
            aVar.fX(3, this.kzz);
            if (this.vUQ != null) {
                aVar.g(4, this.vUQ);
            }
            aVar.fX(5, this.vSa);
            aVar.fX(6, this.vUO);
            aVar.m(7, this.vUR);
            aVar.m(8, this.vUS);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.fU(2, this.vUK)) + e.a.a.a.fU(3, this.kzz);
            if (this.vUQ != null) {
                fW += e.a.a.b.b.a.h(4, this.vUQ);
            }
            return (((fW + e.a.a.a.fU(5, this.vSa)) + e.a.a.a.fU(6, this.vUO)) + (e.a.a.b.b.a.dX(7) + 4)) + (e.a.a.b.b.a.dX(8) + 4);
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
            if ifVar = (if) objArr[1];
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
                        ifVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    ifVar.vUK = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ifVar.kzz = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    ifVar.vUQ = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ifVar.vSa = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    ifVar.vUO = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    ifVar.vUR = aVar3.AEQ.readFloat();
                    return 0;
                case 8:
                    ifVar.vUS = aVar3.AEQ.readFloat();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
