package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cbg extends a {
    public long xhi;
    public io xhj;

    protected final int a(int i, Object... objArr) {
        int R;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.xhi);
            if (this.xhj != null) {
                aVar.fZ(2, this.xhj.bkL());
                this.xhj.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            R = e.a.a.a.R(1, this.xhi) + 0;
            if (this.xhj != null) {
                return R + e.a.a.a.fW(2, this.xhj.bkL());
            }
            return R;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (R = a.a(aVar2); R > 0; R = a.a(aVar2)) {
                if (!super.a(aVar2, this, R)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbg cbg = (cbg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbg.xhi = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a ioVar = new io();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ioVar.a(aVar4, ioVar, a.a(aVar4))) {
                        }
                        cbg.xhj = ioVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
