package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ahp extends bek {
    public int vQj;
    public String wvG;
    public String wvH;
    public LinkedList<String> wvI = new LinkedList();

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
            if (this.wvG != null) {
                aVar.g(2, this.wvG);
            }
            aVar.fX(3, this.vQj);
            if (this.wvH != null) {
                aVar.g(4, this.wvH);
            }
            aVar.d(5, 1, this.wvI);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wvG != null) {
                fW += e.a.a.b.b.a.h(2, this.wvG);
            }
            fW += e.a.a.a.fU(3, this.vQj);
            if (this.wvH != null) {
                fW += e.a.a.b.b.a.h(4, this.wvH);
            }
            return fW + e.a.a.a.c(5, 1, this.wvI);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wvI.clear();
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
            ahp ahp = (ahp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fiVar = new fi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ahp.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    ahp.wvG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ahp.vQj = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    ahp.wvH = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ahp.wvI.add(aVar3.AEQ.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
