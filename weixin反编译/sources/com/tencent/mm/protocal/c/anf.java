package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class anf extends a {
    public String qmh;
    public String scope;
    public int wAy;
    public LinkedList<String> wAz = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.g(1, this.scope);
            }
            aVar.fX(2, this.wAy);
            if (this.qmh != null) {
                aVar.g(3, this.qmh);
            }
            aVar.d(4, 1, this.wAz);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                h = e.a.a.b.b.a.h(1, this.scope) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.wAy);
            if (this.qmh != null) {
                h += e.a.a.b.b.a.h(3, this.qmh);
            }
            return h + e.a.a.a.c(4, 1, this.wAz);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wAz.clear();
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
            anf anf = (anf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    anf.scope = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    anf.wAy = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    anf.qmh = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    anf.wAz.add(aVar3.AEQ.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
