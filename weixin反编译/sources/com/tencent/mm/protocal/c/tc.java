package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class tc extends bek {
    public LinkedList<bot> vNu = new LinkedList();
    public int vQF;
    public LinkedList<bos> vQG = new LinkedList();
    public int wil;
    public long wim;
    public int win;
    public int wio;
    public int wip;

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
            aVar.fX(2, this.wil);
            aVar.S(3, this.wim);
            aVar.fX(4, this.win);
            aVar.fX(5, this.wio);
            aVar.d(6, 8, this.vNu);
            aVar.fX(7, this.wip);
            aVar.fX(8, this.vQF);
            aVar.d(9, 8, this.vQG);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            return (((((((fW + e.a.a.a.fU(2, this.wil)) + e.a.a.a.R(3, this.wim)) + e.a.a.a.fU(4, this.win)) + e.a.a.a.fU(5, this.wio)) + e.a.a.a.c(6, 8, this.vNu)) + e.a.a.a.fU(7, this.wip)) + e.a.a.a.fU(8, this.vQF)) + e.a.a.a.c(9, 8, this.vQG);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vNu.clear();
            this.vQG.clear();
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
            tc tcVar = (tc) objArr[1];
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
                        tcVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    tcVar.wil = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    tcVar.wim = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    tcVar.win = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    tcVar.wio = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bot();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        tcVar.vNu.add(fiVar);
                    }
                    return 0;
                case 7:
                    tcVar.wip = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    tcVar.vQF = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bos();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        tcVar.vQG.add(fiVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
