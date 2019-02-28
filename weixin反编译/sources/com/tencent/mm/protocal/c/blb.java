package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class blb extends a {
    public int pgR;
    public String vPp;
    public bes wUr;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wUr == null) {
                throw new b("Not all required fields were included: HBBuffer");
            }
            if (this.vPp != null) {
                aVar.g(1, this.vPp);
            }
            aVar.fX(2, this.pgR);
            if (this.wUr == null) {
                return 0;
            }
            aVar.fZ(3, this.wUr.bkL());
            this.wUr.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vPp != null) {
                h = e.a.a.b.b.a.h(1, this.vPp) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.pgR);
            if (this.wUr != null) {
                h += e.a.a.a.fW(3, this.wUr.bkL());
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wUr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: HBBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            blb blb = (blb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    blb.vPp = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    blb.pgR = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bes = new bes();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        blb.wUr = bes;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
