package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bec extends bek {
    public int lot;
    public String lou;
    public String nHt;
    public String oiX;
    public String pNu;
    public String pNv;
    public String vWn;
    public cj wQJ;

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
            if (this.oiX != null) {
                aVar.g(4, this.oiX);
            }
            if (this.vWn != null) {
                aVar.g(5, this.vWn);
            }
            if (this.pNu != null) {
                aVar.g(6, this.pNu);
            }
            if (this.pNv != null) {
                aVar.g(7, this.pNv);
            }
            if (this.nHt != null) {
                aVar.g(8, this.nHt);
            }
            if (this.wQJ == null) {
                return 0;
            }
            aVar.fZ(9, this.wQJ.bkL());
            this.wQJ.a(aVar);
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
            if (this.oiX != null) {
                fW += e.a.a.b.b.a.h(4, this.oiX);
            }
            if (this.vWn != null) {
                fW += e.a.a.b.b.a.h(5, this.vWn);
            }
            if (this.pNu != null) {
                fW += e.a.a.b.b.a.h(6, this.pNu);
            }
            if (this.pNv != null) {
                fW += e.a.a.b.b.a.h(7, this.pNv);
            }
            if (this.nHt != null) {
                fW += e.a.a.b.b.a.h(8, this.nHt);
            }
            if (this.wQJ != null) {
                fW += e.a.a.a.fW(9, this.wQJ.bkL());
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
            bec bec = (bec) objArr[1];
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
                        bec.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    bec.lot = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bec.lou = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bec.oiX = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bec.vWn = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bec.pNu = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bec.pNv = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bec.nHt = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new cj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bec.wQJ = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
