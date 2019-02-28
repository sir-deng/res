package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bfm extends bek {
    public String hea;
    public LinkedList<auf> wIU = new LinkedList();
    public String wIV;
    public boolean wIW;
    public boolean wIX;
    public boolean wIY;
    public String wbT;

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
            aVar.d(3, 8, this.wIU);
            if (this.hea != null) {
                aVar.g(4, this.hea);
            }
            if (this.wIV != null) {
                aVar.g(5, this.wIV);
            }
            if (this.wbT != null) {
                aVar.g(6, this.wbT);
            }
            aVar.am(8, this.wIW);
            aVar.am(9, this.wIX);
            aVar.am(10, this.wIY);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.c(3, 8, this.wIU);
            if (this.hea != null) {
                fW += e.a.a.b.b.a.h(4, this.hea);
            }
            if (this.wIV != null) {
                fW += e.a.a.b.b.a.h(5, this.wIV);
            }
            if (this.wbT != null) {
                fW += e.a.a.b.b.a.h(6, this.wbT);
            }
            return ((fW + (e.a.a.b.b.a.dX(8) + 1)) + (e.a.a.b.b.a.dX(9) + 1)) + (e.a.a.b.b.a.dX(10) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wIU.clear();
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
            bfm bfm = (bfm) objArr[1];
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
                        bfm.wRa = fiVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new auf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfm.wIU.add(fiVar);
                    }
                    return 0;
                case 4:
                    bfm.hea = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bfm.wIV = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bfm.wbT = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bfm.wIW = aVar3.cKv();
                    return 0;
                case 9:
                    bfm.wIX = aVar3.cKv();
                    return 0;
                case 10:
                    bfm.wIY = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
