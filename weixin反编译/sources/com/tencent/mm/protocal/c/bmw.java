package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bmw extends a {
    public int wWF;
    public int wWG;
    public int wWH;
    public int wWI;
    public int wWJ;
    public LinkedList<Integer> wWK = new LinkedList();
    public int wWL;
    public int wWM;
    public LinkedList<Integer> wWN = new LinkedList();
    public int wWO;
    public int wWP;
    public int wdO;
    public int wil;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wil);
            aVar.fX(2, this.wWF);
            aVar.fX(3, this.wdO);
            aVar.fX(4, this.wWG);
            aVar.fX(5, this.wWH);
            aVar.fX(6, this.wWI);
            aVar.fX(7, this.wWJ);
            aVar.d(8, 2, this.wWK);
            aVar.fX(9, this.wWL);
            aVar.fX(10, this.wWM);
            aVar.d(11, 2, this.wWN);
            aVar.fX(12, this.wWO);
            aVar.fX(13, this.wWP);
            return 0;
        } else if (i == 1) {
            return ((((((((((((e.a.a.a.fU(1, this.wil) + 0) + e.a.a.a.fU(2, this.wWF)) + e.a.a.a.fU(3, this.wdO)) + e.a.a.a.fU(4, this.wWG)) + e.a.a.a.fU(5, this.wWH)) + e.a.a.a.fU(6, this.wWI)) + e.a.a.a.fU(7, this.wWJ)) + e.a.a.a.c(8, 2, this.wWK)) + e.a.a.a.fU(9, this.wWL)) + e.a.a.a.fU(10, this.wWM)) + e.a.a.a.c(11, 2, this.wWN)) + e.a.a.a.fU(12, this.wWO)) + e.a.a.a.fU(13, this.wWP);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.wWK.clear();
                this.wWN.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                bmw bmw = (bmw) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bmw.wil = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        bmw.wWF = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        bmw.wdO = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        bmw.wWG = aVar3.AEQ.rz();
                        return 0;
                    case 5:
                        bmw.wWH = aVar3.AEQ.rz();
                        return 0;
                    case 6:
                        bmw.wWI = aVar3.AEQ.rz();
                        return 0;
                    case 7:
                        bmw.wWJ = aVar3.AEQ.rz();
                        return 0;
                    case 8:
                        bmw.wWK.add(Integer.valueOf(aVar3.AEQ.rz()));
                        return 0;
                    case 9:
                        bmw.wWL = aVar3.AEQ.rz();
                        return 0;
                    case 10:
                        bmw.wWM = aVar3.AEQ.rz();
                        return 0;
                    case 11:
                        bmw.wWN.add(Integer.valueOf(aVar3.AEQ.rz()));
                        return 0;
                    case 12:
                        bmw.wWO = aVar3.AEQ.rz();
                        return 0;
                    case 13:
                        bmw.wWP = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
