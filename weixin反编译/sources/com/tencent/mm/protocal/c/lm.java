package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class lm extends bek {
    public String desc;
    public String kMY;
    public String kRl;
    public int lot;
    public String lou;
    public String pPK;
    public String sQD;
    public boolean waZ;
    public String wba;
    public int wbb;
    public LinkedList<Integer> wbc = new LinkedList();
    public String wbd;
    public int wbe;
    public int wbf;

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
            aVar.fX(2, this.lot);
            if (this.lou != null) {
                aVar.g(3, this.lou);
            }
            aVar.am(4, this.waZ);
            if (this.pPK != null) {
                aVar.g(5, this.pPK);
            }
            if (this.wba != null) {
                aVar.g(6, this.wba);
            }
            if (this.kMY != null) {
                aVar.g(7, this.kMY);
            }
            aVar.fX(8, this.wbb);
            if (this.desc != null) {
                aVar.g(9, this.desc);
            }
            if (this.sQD != null) {
                aVar.g(10, this.sQD);
            }
            aVar.d(11, 2, this.wbc);
            if (this.wbd != null) {
                aVar.g(12, this.wbd);
            }
            if (this.kRl != null) {
                aVar.g(13, this.kRl);
            }
            aVar.fX(14, this.wbe);
            aVar.fX(15, this.wbf);
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
            fW += e.a.a.b.b.a.dX(4) + 1;
            if (this.pPK != null) {
                fW += e.a.a.b.b.a.h(5, this.pPK);
            }
            if (this.wba != null) {
                fW += e.a.a.b.b.a.h(6, this.wba);
            }
            if (this.kMY != null) {
                fW += e.a.a.b.b.a.h(7, this.kMY);
            }
            fW += e.a.a.a.fU(8, this.wbb);
            if (this.desc != null) {
                fW += e.a.a.b.b.a.h(9, this.desc);
            }
            if (this.sQD != null) {
                fW += e.a.a.b.b.a.h(10, this.sQD);
            }
            fW += e.a.a.a.c(11, 2, this.wbc);
            if (this.wbd != null) {
                fW += e.a.a.b.b.a.h(12, this.wbd);
            }
            if (this.kRl != null) {
                fW += e.a.a.b.b.a.h(13, this.kRl);
            }
            return (fW + e.a.a.a.fU(14, this.wbe)) + e.a.a.a.fU(15, this.wbf);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wbc.clear();
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
            lm lmVar = (lm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fiVar = new fi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        lmVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    lmVar.lot = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    lmVar.lou = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    lmVar.waZ = aVar3.cKv();
                    return 0;
                case 5:
                    lmVar.pPK = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    lmVar.wba = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    lmVar.kMY = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    lmVar.wbb = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    lmVar.desc = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    lmVar.sQD = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    lmVar.wbc.add(Integer.valueOf(aVar3.AEQ.rz()));
                    return 0;
                case 12:
                    lmVar.wbd = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    lmVar.kRl = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    lmVar.wbe = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    lmVar.wbf = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
