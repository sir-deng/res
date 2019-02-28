package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class awb extends bek {
    public String loF;
    public String loG;
    public int lot;
    public String lou;
    public int wKl;
    public int wKm;
    public String wKn;

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
            aVar.fX(4, this.wKl);
            aVar.fX(5, this.wKm);
            if (this.loF != null) {
                aVar.g(6, this.loF);
            }
            if (this.loG != null) {
                aVar.g(7, this.loG);
            }
            if (this.wKn == null) {
                return 0;
            }
            aVar.g(8, this.wKn);
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
            fW = (fW + e.a.a.a.fU(4, this.wKl)) + e.a.a.a.fU(5, this.wKm);
            if (this.loF != null) {
                fW += e.a.a.b.b.a.h(6, this.loF);
            }
            if (this.loG != null) {
                fW += e.a.a.b.b.a.h(7, this.loG);
            }
            if (this.wKn != null) {
                fW += e.a.a.b.b.a.h(8, this.wKn);
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
            awb awb = (awb) objArr[1];
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
                        awb.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    awb.lot = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    awb.lou = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    awb.wKl = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    awb.wKm = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    awb.loF = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    awb.loG = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    awb.wKn = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
