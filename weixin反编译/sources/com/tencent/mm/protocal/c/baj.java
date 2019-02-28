package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class baj extends a {
    public String fHP;
    public int wNK;
    public boolean wNL;
    public String wNM;
    public int wNN;
    public int wNO;
    public LinkedList<bai> wNP = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fHP != null) {
                aVar.g(1, this.fHP);
            }
            aVar.fX(2, this.wNK);
            aVar.am(3, this.wNL);
            if (this.wNM != null) {
                aVar.g(4, this.wNM);
            }
            aVar.fX(5, this.wNN);
            aVar.fX(6, this.wNO);
            aVar.d(7, 8, this.wNP);
            return 0;
        } else if (i == 1) {
            if (this.fHP != null) {
                h = e.a.a.b.b.a.h(1, this.fHP) + 0;
            } else {
                h = 0;
            }
            h = (h + e.a.a.a.fU(2, this.wNK)) + (e.a.a.b.b.a.dX(3) + 1);
            if (this.wNM != null) {
                h += e.a.a.b.b.a.h(4, this.wNM);
            }
            return ((h + e.a.a.a.fU(5, this.wNN)) + e.a.a.a.fU(6, this.wNO)) + e.a.a.a.c(7, 8, this.wNP);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wNP.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            baj baj = (baj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    baj.fHP = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    baj.wNK = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    baj.wNL = aVar3.cKv();
                    return 0;
                case 4:
                    baj.wNM = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    baj.wNN = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    baj.wNO = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a bai = new bai();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bai.a(aVar4, bai, a.a(aVar4))) {
                        }
                        baj.wNP.add(bai);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
