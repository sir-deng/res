package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ahj extends bek {
    public bes wvA;
    public int wvq;
    public String wvr;
    public int wvs;
    public String wvt;
    public int wvu;
    public LinkedList<bet> wvv = new LinkedList();
    public String wvw;
    public int wvx;
    public String wvy;
    public int wvz;

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
            aVar.fX(2, this.wvq);
            if (this.wvr != null) {
                aVar.g(3, this.wvr);
            }
            aVar.fX(4, this.wvs);
            if (this.wvt != null) {
                aVar.g(5, this.wvt);
            }
            aVar.fX(6, this.wvu);
            aVar.d(7, 8, this.wvv);
            if (this.wvw != null) {
                aVar.g(8, this.wvw);
            }
            aVar.fX(9, this.wvx);
            if (this.wvy != null) {
                aVar.g(10, this.wvy);
            }
            aVar.fX(11, this.wvz);
            if (this.wvA == null) {
                return 0;
            }
            aVar.fZ(12, this.wvA.bkL());
            this.wvA.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.wvq);
            if (this.wvr != null) {
                fW += e.a.a.b.b.a.h(3, this.wvr);
            }
            fW += e.a.a.a.fU(4, this.wvs);
            if (this.wvt != null) {
                fW += e.a.a.b.b.a.h(5, this.wvt);
            }
            fW = (fW + e.a.a.a.fU(6, this.wvu)) + e.a.a.a.c(7, 8, this.wvv);
            if (this.wvw != null) {
                fW += e.a.a.b.b.a.h(8, this.wvw);
            }
            fW += e.a.a.a.fU(9, this.wvx);
            if (this.wvy != null) {
                fW += e.a.a.b.b.a.h(10, this.wvy);
            }
            fW += e.a.a.a.fU(11, this.wvz);
            if (this.wvA != null) {
                fW += e.a.a.a.fW(12, this.wvA.bkL());
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wvv.clear();
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
            ahj ahj = (ahj) objArr[1];
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
                        ahj.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    ahj.wvq = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ahj.wvr = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ahj.wvs = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    ahj.wvt = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    ahj.wvu = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ahj.wvv.add(fiVar);
                    }
                    return 0;
                case 8:
                    ahj.wvw = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    ahj.wvx = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    ahj.wvy = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    ahj.wvz = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ahj.wvA = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
