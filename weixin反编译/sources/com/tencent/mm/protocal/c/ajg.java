package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ajg extends bek {
    public ccd wcE;
    public int wxm;
    public LinkedList<cdb> wxs = new LinkedList();
    public cdb wxt;
    public String wxu;
    public int wxv;
    public String wxw;
    public String wxx;
    public String wxy;
    public String wxz;

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
            if (this.wcE != null) {
                aVar.fZ(2, this.wcE.bkL());
                this.wcE.a(aVar);
            }
            aVar.d(3, 8, this.wxs);
            if (this.wxt != null) {
                aVar.fZ(4, this.wxt.bkL());
                this.wxt.a(aVar);
            }
            if (this.wxu != null) {
                aVar.g(5, this.wxu);
            }
            aVar.fX(6, this.wxv);
            if (this.wxw != null) {
                aVar.g(7, this.wxw);
            }
            if (this.wxx != null) {
                aVar.g(8, this.wxx);
            }
            if (this.wxy != null) {
                aVar.g(9, this.wxy);
            }
            if (this.wxz != null) {
                aVar.g(10, this.wxz);
            }
            aVar.fX(11, this.wxm);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wcE != null) {
                fW += e.a.a.a.fW(2, this.wcE.bkL());
            }
            fW += e.a.a.a.c(3, 8, this.wxs);
            if (this.wxt != null) {
                fW += e.a.a.a.fW(4, this.wxt.bkL());
            }
            if (this.wxu != null) {
                fW += e.a.a.b.b.a.h(5, this.wxu);
            }
            fW += e.a.a.a.fU(6, this.wxv);
            if (this.wxw != null) {
                fW += e.a.a.b.b.a.h(7, this.wxw);
            }
            if (this.wxx != null) {
                fW += e.a.a.b.b.a.h(8, this.wxx);
            }
            if (this.wxy != null) {
                fW += e.a.a.b.b.a.h(9, this.wxy);
            }
            if (this.wxz != null) {
                fW += e.a.a.b.b.a.h(10, this.wxz);
            }
            return fW + e.a.a.a.fU(11, this.wxm);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wxs.clear();
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
            ajg ajg = (ajg) objArr[1];
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
                        ajg.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ccd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ajg.wcE = fiVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new cdb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ajg.wxs.add(fiVar);
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new cdb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ajg.wxt = fiVar;
                    }
                    return 0;
                case 5:
                    ajg.wxu = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    ajg.wxv = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    ajg.wxw = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    ajg.wxx = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    ajg.wxy = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    ajg.wxz = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    ajg.wxm = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
