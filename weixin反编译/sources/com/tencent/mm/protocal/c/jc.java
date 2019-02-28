package com.tencent.mm.protocal.c;

import d.a.a.c;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class jc extends bek {
    public String kRA;
    public int kRz;
    public c sUS;
    public long sUU;
    public long vWh;
    public LinkedList<String> vWi = new LinkedList();
    public int vWj;
    public int vWk;

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
            aVar.fX(2, this.kRz);
            if (this.kRA != null) {
                aVar.g(3, this.kRA);
            }
            aVar.S(4, this.sUU);
            if (this.sUS != null) {
                aVar.fZ(5, this.sUS.bkL());
                this.sUS.a(aVar);
            }
            aVar.S(6, this.vWh);
            aVar.d(7, 1, this.vWi);
            aVar.fX(8, this.vWj);
            aVar.fX(9, this.vWk);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.kRz);
            if (this.kRA != null) {
                fW += e.a.a.b.b.a.h(3, this.kRA);
            }
            fW += e.a.a.a.R(4, this.sUU);
            if (this.sUS != null) {
                fW += e.a.a.a.fW(5, this.sUS.bkL());
            }
            return (((fW + e.a.a.a.R(6, this.vWh)) + e.a.a.a.c(7, 1, this.vWi)) + e.a.a.a.fU(8, this.vWj)) + e.a.a.a.fU(9, this.vWk);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vWi.clear();
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
            jc jcVar = (jc) objArr[1];
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
                        jcVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    jcVar.kRz = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    jcVar.kRA = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    jcVar.sUU = aVar3.AEQ.rA();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new c();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        jcVar.sUS = fiVar;
                    }
                    return 0;
                case 6:
                    jcVar.vWh = aVar3.AEQ.rA();
                    return 0;
                case 7:
                    jcVar.vWi.add(aVar3.AEQ.readString());
                    return 0;
                case 8:
                    jcVar.vWj = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    jcVar.vWk = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
