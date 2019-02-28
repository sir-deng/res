package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class pp extends bek {
    public String sPd;
    public int version;
    public LinkedList<kn> wfs = new LinkedList();
    public int wft;
    public int wfu;

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
            aVar.d(2, 8, this.wfs);
            aVar.fX(3, this.version);
            aVar.fX(4, this.wft);
            aVar.fX(5, this.wfu);
            if (this.sPd == null) {
                return 0;
            }
            aVar.g(6, this.sPd);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (((fW + e.a.a.a.c(2, 8, this.wfs)) + e.a.a.a.fU(3, this.version)) + e.a.a.a.fU(4, this.wft)) + e.a.a.a.fU(5, this.wfu);
            if (this.sPd != null) {
                fW += e.a.a.b.b.a.h(6, this.sPd);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wfs.clear();
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
            pp ppVar = (pp) objArr[1];
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
                        ppVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new kn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ppVar.wfs.add(fiVar);
                    }
                    return 0;
                case 3:
                    ppVar.version = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    ppVar.wft = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    ppVar.wfu = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    ppVar.sPd = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
