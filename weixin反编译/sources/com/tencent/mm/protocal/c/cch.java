package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cch extends bek {
    public String frM;
    public String fzB;
    public String url;
    public int version;
    public int wNv;
    public int xhV;
    public int xhW;

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
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.frM != null) {
                aVar.g(3, this.frM);
            }
            aVar.fX(4, this.version);
            aVar.fX(5, this.xhV);
            aVar.fX(6, this.wNv);
            aVar.fX(7, this.xhW);
            if (this.fzB == null) {
                return 0;
            }
            aVar.g(8, this.fzB);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.url != null) {
                fW += e.a.a.b.b.a.h(2, this.url);
            }
            if (this.frM != null) {
                fW += e.a.a.b.b.a.h(3, this.frM);
            }
            fW = (((fW + e.a.a.a.fU(4, this.version)) + e.a.a.a.fU(5, this.xhV)) + e.a.a.a.fU(6, this.wNv)) + e.a.a.a.fU(7, this.xhW);
            if (this.fzB != null) {
                fW += e.a.a.b.b.a.h(8, this.fzB);
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
            cch cch = (cch) objArr[1];
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
                        cch.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    cch.url = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cch.frM = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cch.version = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    cch.xhV = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    cch.wNv = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    cch.xhW = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    cch.fzB = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
