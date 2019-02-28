package com.tencent.mm.storage;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ag extends a {
    public int xGP;
    public LinkedList<Integer> xGQ = new LinkedList();
    public LinkedList<Integer> xGR = new LinkedList();
    public LinkedList<Integer> xGS = new LinkedList();
    public LinkedList<Long> xGT = new LinkedList();
    public LinkedList<Long> xGU = new LinkedList();
    public LinkedList<Long> xGV = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.xGP);
            aVar.d(2, 2, this.xGQ);
            aVar.d(3, 2, this.xGR);
            aVar.d(4, 2, this.xGS);
            aVar.d(5, 3, this.xGT);
            aVar.d(6, 3, this.xGU);
            aVar.d(7, 3, this.xGV);
            return 0;
        } else if (i == 1) {
            return ((((((e.a.a.a.fU(1, this.xGP) + 0) + e.a.a.a.c(2, 2, this.xGQ)) + e.a.a.a.c(3, 2, this.xGR)) + e.a.a.a.c(4, 2, this.xGS)) + e.a.a.a.c(5, 3, this.xGT)) + e.a.a.a.c(6, 3, this.xGU)) + e.a.a.a.c(7, 3, this.xGV);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.xGQ.clear();
                this.xGR.clear();
                this.xGS.clear();
                this.xGT.clear();
                this.xGU.clear();
                this.xGV.clear();
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
                ag agVar = (ag) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        agVar.xGP = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        agVar.xGQ.add(Integer.valueOf(aVar3.AEQ.rz()));
                        return 0;
                    case 3:
                        agVar.xGR.add(Integer.valueOf(aVar3.AEQ.rz()));
                        return 0;
                    case 4:
                        agVar.xGS.add(Integer.valueOf(aVar3.AEQ.rz()));
                        return 0;
                    case 5:
                        agVar.xGT.add(Long.valueOf(aVar3.AEQ.rA()));
                        return 0;
                    case 6:
                        agVar.xGU.add(Long.valueOf(aVar3.AEQ.rA()));
                        return 0;
                    case 7:
                        agVar.xGV.add(Long.valueOf(aVar3.AEQ.rA()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
