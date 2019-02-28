package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class awe extends a {
    public int vQL;
    public awf wKo;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wKo == null) {
                throw new b("Not all required fields were included: OplogRet");
            }
            aVar.fX(1, this.vQL);
            if (this.wKo != null) {
                aVar.fZ(2, this.wKo.bkL());
                this.wKo.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vQL) + 0;
            if (this.wKo != null) {
                return fU + e.a.a.a.fW(2, this.wKo.bkL());
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.wKo != null) {
                return 0;
            }
            throw new b("Not all required fields were included: OplogRet");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            awe awe = (awe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    awe.vQL = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a awf = new awf();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = awf.a(aVar4, awf, a.a(aVar4))) {
                        }
                        awe.wKo = awf;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
