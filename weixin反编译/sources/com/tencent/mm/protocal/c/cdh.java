package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cdh extends a {
    public LinkedList<Integer> xbK = new LinkedList();
    public cdg xiG;
    public LinkedList<Integer> xiH = new LinkedList();
    public int xiI;
    public int xiJ;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xiG != null) {
                aVar.fZ(1, this.xiG.bkL());
                this.xiG.a(aVar);
            }
            aVar.d(2, 2, this.xiH);
            aVar.d(3, 2, this.xbK);
            aVar.fX(4, this.xiI);
            aVar.fX(5, this.xiJ);
            return 0;
        } else if (i == 1) {
            if (this.xiG != null) {
                fW = e.a.a.a.fW(1, this.xiG.bkL()) + 0;
            } else {
                fW = 0;
            }
            return (((fW + e.a.a.a.c(2, 2, this.xiH)) + e.a.a.a.c(3, 2, this.xbK)) + e.a.a.a.fU(4, this.xiI)) + e.a.a.a.fU(5, this.xiJ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xiH.clear();
            this.xbK.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdh cdh = (cdh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a cdg = new cdg();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cdg.a(aVar4, cdg, a.a(aVar4))) {
                        }
                        cdh.xiG = cdg;
                    }
                    return 0;
                case 2:
                    cdh.xiH.add(Integer.valueOf(aVar3.AEQ.rz()));
                    return 0;
                case 3:
                    cdh.xbK.add(Integer.valueOf(aVar3.AEQ.rz()));
                    return 0;
                case 4:
                    cdh.xiI = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    cdh.xiJ = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
