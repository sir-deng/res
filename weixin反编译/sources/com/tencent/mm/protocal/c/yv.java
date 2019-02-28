package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class yv extends bek {
    public em mNm;
    public int vKM;
    public int vKQ;
    public String vKR;
    public bjy vKS;
    public int vLa;

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
            aVar.fX(2, this.vKQ);
            aVar.fX(3, this.vLa);
            if (this.vKR != null) {
                aVar.g(4, this.vKR);
            }
            if (this.vKS != null) {
                aVar.fZ(5, this.vKS.bkL());
                this.vKS.a(aVar);
            }
            if (this.mNm != null) {
                aVar.fZ(6, this.mNm.bkL());
                this.mNm.a(aVar);
            }
            aVar.fX(7, this.vKM);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.fU(2, this.vKQ)) + e.a.a.a.fU(3, this.vLa);
            if (this.vKR != null) {
                fW += e.a.a.b.b.a.h(4, this.vKR);
            }
            if (this.vKS != null) {
                fW += e.a.a.a.fW(5, this.vKS.bkL());
            }
            if (this.mNm != null) {
                fW += e.a.a.a.fW(6, this.mNm.bkL());
            }
            return fW + e.a.a.a.fU(7, this.vKM);
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
            yv yvVar = (yv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a fiVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        yvVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    yvVar.vKQ = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    yvVar.vLa = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    yvVar.vKR = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bjy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        yvVar.vKS = fiVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new em();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        yvVar.mNm = fiVar;
                    }
                    return 0;
                case 7:
                    yvVar.vKM = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
