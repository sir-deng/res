package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bgv extends bea {
    public String hxh;
    public int vPv;
    public int vXG;
    public db wSn;
    public String wSo;
    public String wSp;
    public int wSq;
    public String wgP;
    public int whg;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wSn == null) {
                throw new b("Not all required fields were included: Msg");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wSn != null) {
                aVar.fZ(2, this.wSn.bkL());
                this.wSn.a(aVar);
            }
            if (this.wSo != null) {
                aVar.g(3, this.wSo);
            }
            aVar.fX(4, this.whg);
            if (this.wgP != null) {
                aVar.g(5, this.wgP);
            }
            aVar.fX(6, this.vPv);
            if (this.hxh != null) {
                aVar.g(7, this.hxh);
            }
            if (this.wSp != null) {
                aVar.g(8, this.wSp);
            }
            aVar.fX(9, this.wSq);
            aVar.fX(10, this.vXG);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wSn != null) {
                fW += e.a.a.a.fW(2, this.wSn.bkL());
            }
            if (this.wSo != null) {
                fW += e.a.a.b.b.a.h(3, this.wSo);
            }
            fW += e.a.a.a.fU(4, this.whg);
            if (this.wgP != null) {
                fW += e.a.a.b.b.a.h(5, this.wgP);
            }
            fW += e.a.a.a.fU(6, this.vPv);
            if (this.hxh != null) {
                fW += e.a.a.b.b.a.h(7, this.hxh);
            }
            if (this.wSp != null) {
                fW += e.a.a.b.b.a.h(8, this.wSp);
            }
            return (fW + e.a.a.a.fU(9, this.wSq)) + e.a.a.a.fU(10, this.vXG);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wSn != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Msg");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bgv bgv = (bgv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a fhVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new fh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bgv.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new db();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bgv.wSn = fhVar;
                    }
                    return 0;
                case 3:
                    bgv.wSo = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bgv.whg = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bgv.wgP = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bgv.vPv = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bgv.hxh = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bgv.wSp = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    bgv.wSq = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    bgv.vXG = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
