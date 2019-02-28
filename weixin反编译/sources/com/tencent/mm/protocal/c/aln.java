package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aln extends a {
    public int fpf;
    public int wzn;
    public int wzo;
    public int wzp;
    public int wzq;
    public int wzr;
    public int wzs;
    public int wzt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wzn);
            aVar.fX(2, this.fpf);
            aVar.fX(3, this.wzo);
            aVar.fX(4, this.wzp);
            aVar.fX(5, this.wzq);
            aVar.fX(6, this.wzr);
            aVar.fX(7, this.wzs);
            aVar.fX(8, this.wzt);
            return 0;
        } else if (i == 1) {
            return (((((((e.a.a.a.fU(1, this.wzn) + 0) + e.a.a.a.fU(2, this.fpf)) + e.a.a.a.fU(3, this.wzo)) + e.a.a.a.fU(4, this.wzp)) + e.a.a.a.fU(5, this.wzq)) + e.a.a.a.fU(6, this.wzr)) + e.a.a.a.fU(7, this.wzs)) + e.a.a.a.fU(8, this.wzt);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
                aln aln = (aln) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        aln.wzn = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        aln.fpf = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        aln.wzo = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        aln.wzp = aVar3.AEQ.rz();
                        return 0;
                    case 5:
                        aln.wzq = aVar3.AEQ.rz();
                        return 0;
                    case 6:
                        aln.wzr = aVar3.AEQ.rz();
                        return 0;
                    case 7:
                        aln.wzs = aVar3.AEQ.rz();
                        return 0;
                    case 8:
                        aln.wzt = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
