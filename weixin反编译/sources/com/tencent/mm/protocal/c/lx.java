package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class lx extends bek {
    public String fxT;
    public int lot;
    public String lou;
    public int oeK;
    public String vOh;
    public String wbo;
    public String wbp;
    public String wbr;
    public String wbz;

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
            aVar.fX(2, this.lot);
            if (this.lou != null) {
                aVar.g(3, this.lou);
            }
            if (this.fxT != null) {
                aVar.g(4, this.fxT);
            }
            if (this.wbr != null) {
                aVar.g(5, this.wbr);
            }
            if (this.vOh != null) {
                aVar.g(6, this.vOh);
            }
            aVar.fX(7, this.oeK);
            if (this.wbz != null) {
                aVar.g(8, this.wbz);
            }
            if (this.wbp != null) {
                aVar.g(9, this.wbp);
            }
            if (this.wbo == null) {
                return 0;
            }
            aVar.g(10, this.wbo);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.lot);
            if (this.lou != null) {
                fW += e.a.a.b.b.a.h(3, this.lou);
            }
            if (this.fxT != null) {
                fW += e.a.a.b.b.a.h(4, this.fxT);
            }
            if (this.wbr != null) {
                fW += e.a.a.b.b.a.h(5, this.wbr);
            }
            if (this.vOh != null) {
                fW += e.a.a.b.b.a.h(6, this.vOh);
            }
            fW += e.a.a.a.fU(7, this.oeK);
            if (this.wbz != null) {
                fW += e.a.a.b.b.a.h(8, this.wbz);
            }
            if (this.wbp != null) {
                fW += e.a.a.b.b.a.h(9, this.wbp);
            }
            if (this.wbo != null) {
                fW += e.a.a.b.b.a.h(10, this.wbo);
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
            lx lxVar = (lx) objArr[1];
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
                        lxVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    lxVar.lot = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    lxVar.lou = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    lxVar.fxT = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    lxVar.wbr = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    lxVar.vOh = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    lxVar.oeK = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    lxVar.wbz = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    lxVar.wbp = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    lxVar.wbo = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
