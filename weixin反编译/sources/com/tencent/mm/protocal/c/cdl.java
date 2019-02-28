package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cdl extends a {
    public cdg xiG;
    public String xiT;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xiG != null) {
                aVar.fZ(1, this.xiG.bkL());
                this.xiG.a(aVar);
            }
            if (this.xiT == null) {
                return 0;
            }
            aVar.g(2, this.xiT);
            return 0;
        } else if (i == 1) {
            if (this.xiG != null) {
                fW = e.a.a.a.fW(1, this.xiG.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.xiT != null) {
                fW += e.a.a.b.b.a.h(2, this.xiT);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            cdl cdl = (cdl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a cdg = new cdg();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cdg.a(aVar4, cdg, a.a(aVar4))) {
                        }
                        cdl.xiG = cdg;
                    }
                    return 0;
                case 2:
                    cdl.xiT = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
