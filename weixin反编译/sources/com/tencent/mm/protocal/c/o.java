package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class o extends bek {
    public String fFi;
    public int lot = 268513600;
    public String lou = "请求不成功，请稍候再试";
    public String oiX;
    public String pQF;
    public String vJK;
    public a vKc;
    public String vKd;

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
            if (this.fFi != null) {
                aVar.g(5, this.fFi);
            }
            if (this.pQF != null) {
                aVar.g(7, this.pQF);
            }
            if (this.vJK != null) {
                aVar.g(8, this.vJK);
            }
            if (this.vKc != null) {
                aVar.fZ(9, this.vKc.bkL());
                this.vKc.a(aVar);
            }
            if (this.vKd == null) {
                return 0;
            }
            aVar.g(10, this.vKd);
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
            if (this.fFi != null) {
                fW += e.a.a.b.b.a.h(5, this.fFi);
            }
            if (this.pQF != null) {
                fW += e.a.a.b.b.a.h(7, this.pQF);
            }
            if (this.vJK != null) {
                fW += e.a.a.b.b.a.h(8, this.vJK);
            }
            if (this.vKc != null) {
                fW += e.a.a.a.fW(9, this.vKc.bkL());
            }
            if (this.vKd != null) {
                fW += e.a.a.b.b.a.h(10, this.vKd);
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
            o oVar = (o) objArr[1];
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
                        oVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    oVar.lot = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    oVar.lou = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    oVar.oiX = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    oVar.fFi = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    oVar.pQF = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    oVar.vJK = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new a();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        oVar.vKc = fiVar;
                    }
                    return 0;
                case 10:
                    oVar.vKd = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
