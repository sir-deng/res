package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ph extends a {
    public int vPt;
    public int wfe;
    public bes wff;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wff == null) {
                throw new b("Not all required fields were included: Content");
            }
            aVar.fX(1, this.vPt);
            aVar.fX(2, this.wfe);
            if (this.wff != null) {
                aVar.fZ(3, this.wff.bkL());
                this.wff.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.vPt) + 0) + e.a.a.a.fU(2, this.wfe);
            if (this.wff != null) {
                return fU + e.a.a.a.fW(3, this.wff.bkL());
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.wff != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Content");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ph phVar = (ph) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    phVar.vPt = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    phVar.wfe = aVar3.AEQ.rz();
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
                        phVar.wff = bes;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
