package com.tencent.mm.protocal.a.a;

public final class a extends com.tencent.mm.bp.a {
    public int count;
    public int vIM;
    public int value;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vIM);
            aVar.fX(2, this.value);
            aVar.fX(3, this.count);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fU(1, this.vIM) + 0) + e.a.a.a.fU(2, this.value)) + e.a.a.a.fU(3, this.count);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = com.tencent.mm.bp.a.a(aVar2); a > 0; a = com.tencent.mm.bp.a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                a aVar4 = (a) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        aVar4.vIM = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        aVar4.value = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        aVar4.count = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
