package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class axa extends bek {
    public int lUc;
    public String lUd;
    public String nkN;
    public String wKZ;
    public String wov;
    public String wow;

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
            if (this.wov != null) {
                aVar.g(2, this.wov);
            }
            if (this.nkN != null) {
                aVar.g(3, this.nkN);
            }
            if (this.wow != null) {
                aVar.g(4, this.wow);
            }
            aVar.fX(5, this.lUc);
            if (this.lUd != null) {
                aVar.g(6, this.lUd);
            }
            if (this.wKZ == null) {
                return 0;
            }
            aVar.g(7, this.wKZ);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wov != null) {
                fW += e.a.a.b.b.a.h(2, this.wov);
            }
            if (this.nkN != null) {
                fW += e.a.a.b.b.a.h(3, this.nkN);
            }
            if (this.wow != null) {
                fW += e.a.a.b.b.a.h(4, this.wow);
            }
            fW += e.a.a.a.fU(5, this.lUc);
            if (this.lUd != null) {
                fW += e.a.a.b.b.a.h(6, this.lUd);
            }
            if (this.wKZ != null) {
                fW += e.a.a.b.b.a.h(7, this.wKZ);
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
            axa axa = (axa) objArr[1];
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
                        axa.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    axa.wov = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    axa.nkN = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    axa.wow = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    axa.lUc = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    axa.lUd = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    axa.wKZ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
