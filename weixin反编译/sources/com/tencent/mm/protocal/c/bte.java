package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bte extends a {
    public String vPp;
    public ayo xbj;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xbj == null) {
                throw new b("Not all required fields were included: Position");
            }
            if (this.vPp != null) {
                aVar.g(1, this.vPp);
            }
            if (this.xbj == null) {
                return 0;
            }
            aVar.fZ(2, this.xbj.bkL());
            this.xbj.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vPp != null) {
                h = e.a.a.b.b.a.h(1, this.vPp) + 0;
            } else {
                h = 0;
            }
            if (this.xbj != null) {
                h += e.a.a.a.fW(2, this.xbj.bkL());
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.xbj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Position");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bte bte = (bte) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bte.vPp = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a ayo = new ayo();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ayo.a(aVar4, ayo, a.a(aVar4))) {
                        }
                        bte.xbj = ayo;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
