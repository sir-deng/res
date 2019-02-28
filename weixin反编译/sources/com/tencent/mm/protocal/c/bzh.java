package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bzh extends a {
    public String nkL;
    public LinkedList<wh> xgm = new LinkedList();
    public String xgn;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xgn == null) {
                throw new b("Not all required fields were included: Charset");
            }
            aVar.d(1, 8, this.xgm);
            if (this.xgn != null) {
                aVar.g(2, this.xgn);
            }
            if (this.nkL != null) {
                aVar.g(3, this.nkL);
            }
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.xgm) + 0;
            if (this.xgn != null) {
                c += e.a.a.b.b.a.h(2, this.xgn);
            }
            if (this.nkL != null) {
                return c + e.a.a.b.b.a.h(3, this.nkL);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xgm.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cKx();
                }
            }
            if (this.xgn != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Charset");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzh bzh = (bzh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a whVar = new wh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = whVar.a(aVar4, whVar, a.a(aVar4))) {
                        }
                        bzh.xgm.add(whVar);
                    }
                    return 0;
                case 2:
                    bzh.xgn = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bzh.nkL = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
