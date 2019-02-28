package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ana extends bek {
    public String hxh;
    public String noG;
    public String vKL;
    public String vKY;
    public String vML;
    public amh wAp;
    public String wAr;
    public String wAs;
    public String wAt;
    public int wAu;
    public LinkedList<bfh> woV = new LinkedList();

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
            if (this.wAp != null) {
                aVar.fZ(2, this.wAp.bkL());
                this.wAp.a(aVar);
            }
            if (this.wAs != null) {
                aVar.g(3, this.wAs);
            }
            aVar.d(4, 8, this.woV);
            if (this.noG != null) {
                aVar.g(5, this.noG);
            }
            if (this.vML != null) {
                aVar.g(6, this.vML);
            }
            if (this.vKY != null) {
                aVar.g(7, this.vKY);
            }
            if (this.vKL != null) {
                aVar.g(8, this.vKL);
            }
            if (this.wAt != null) {
                aVar.g(9, this.wAt);
            }
            aVar.fX(10, this.wAu);
            if (this.wAr != null) {
                aVar.g(11, this.wAr);
            }
            if (this.hxh == null) {
                return 0;
            }
            aVar.g(12, this.hxh);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wAp != null) {
                fW += e.a.a.a.fW(2, this.wAp.bkL());
            }
            if (this.wAs != null) {
                fW += e.a.a.b.b.a.h(3, this.wAs);
            }
            fW += e.a.a.a.c(4, 8, this.woV);
            if (this.noG != null) {
                fW += e.a.a.b.b.a.h(5, this.noG);
            }
            if (this.vML != null) {
                fW += e.a.a.b.b.a.h(6, this.vML);
            }
            if (this.vKY != null) {
                fW += e.a.a.b.b.a.h(7, this.vKY);
            }
            if (this.vKL != null) {
                fW += e.a.a.b.b.a.h(8, this.vKL);
            }
            if (this.wAt != null) {
                fW += e.a.a.b.b.a.h(9, this.wAt);
            }
            fW += e.a.a.a.fU(10, this.wAu);
            if (this.wAr != null) {
                fW += e.a.a.b.b.a.h(11, this.wAr);
            }
            if (this.hxh != null) {
                fW += e.a.a.b.b.a.h(12, this.hxh);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.woV.clear();
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
            ana ana = (ana) objArr[1];
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
                        ana.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new amh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ana.wAp = fiVar;
                    }
                    return 0;
                case 3:
                    ana.wAs = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bfh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ana.woV.add(fiVar);
                    }
                    return 0;
                case 5:
                    ana.noG = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    ana.vML = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    ana.vKY = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    ana.vKL = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    ana.wAt = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    ana.wAu = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    ana.wAr = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    ana.hxh = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
