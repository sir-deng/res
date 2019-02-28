package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class xd extends a {
    public ww wop;
    public LinkedList<String> woq = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wop == null) {
                throw new b("Not all required fields were included: GameItem");
            }
            if (this.wop != null) {
                aVar.fZ(1, this.wop.bkL());
                this.wop.a(aVar);
            }
            aVar.d(2, 1, this.woq);
            return 0;
        } else if (i == 1) {
            if (this.wop != null) {
                fW = e.a.a.a.fW(1, this.wop.bkL()) + 0;
            } else {
                fW = 0;
            }
            return fW + e.a.a.a.c(2, 1, this.woq);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.woq.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wop != null) {
                return 0;
            }
            throw new b("Not all required fields were included: GameItem");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xd xdVar = (xd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a wwVar = new ww();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = wwVar.a(aVar4, wwVar, a.a(aVar4))) {
                        }
                        xdVar.wop = wwVar;
                    }
                    return 0;
                case 2:
                    xdVar.woq.add(aVar3.AEQ.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
