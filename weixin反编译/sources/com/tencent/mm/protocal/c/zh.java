package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class zh extends bek {
    public int lUc;
    public String lUd;
    public LinkedList<alh> wpW = new LinkedList();

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
            aVar.fX(2, this.lUc);
            if (this.lUd != null) {
                aVar.g(3, this.lUd);
            }
            aVar.d(4, 8, this.wpW);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.lUc);
            if (this.lUd != null) {
                fW += e.a.a.b.b.a.h(3, this.lUd);
            }
            return fW + e.a.a.a.c(4, 8, this.wpW);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wpW.clear();
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
            zh zhVar = (zh) objArr[1];
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
                        zhVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    zhVar.lUc = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    zhVar.lUd = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new alh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        zhVar.wpW.add(fiVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
