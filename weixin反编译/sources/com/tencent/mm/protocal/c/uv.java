package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class uv extends bek {
    public int lfj;
    public LinkedList<uw> vNu = new LinkedList();
    public String wfN;
    public String wgO;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            if (this.wgO != null) {
                aVar.g(2, this.wgO);
            }
            aVar.fX(3, this.lfj);
            aVar.d(4, 8, this.vNu);
            if (this.wfN == null) {
                return 0;
            }
            aVar.g(5, this.wfN);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wgO != null) {
                fW += e.a.a.b.b.a.h(2, this.wgO);
            }
            fW = (fW + e.a.a.a.fU(3, this.lfj)) + e.a.a.a.c(4, 8, this.vNu);
            if (this.wfN != null) {
                fW += e.a.a.b.b.a.h(5, this.wfN);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vNu.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            uv uvVar = (uv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
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
                        uvVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    uvVar.wgO = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    uvVar.lfj = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new uw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        uvVar.vNu.add(fiVar);
                    }
                    return 0;
                case 5:
                    uvVar.wfN = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
