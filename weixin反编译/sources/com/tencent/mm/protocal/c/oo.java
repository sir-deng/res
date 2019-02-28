package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class oo extends a {
    public int wek;
    public bes wel;
    public int wem;
    public bes wen;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wel == null) {
                throw new b("Not all required fields were included: OperationInfo");
            }
            aVar.fX(1, this.wek);
            if (this.wel != null) {
                aVar.fZ(2, this.wel.bkL());
                this.wel.a(aVar);
            }
            aVar.fX(3, this.wem);
            if (this.wen != null) {
                aVar.fZ(4, this.wen.bkL());
                this.wen.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wek) + 0;
            if (this.wel != null) {
                fU += e.a.a.a.fW(2, this.wel.bkL());
            }
            fU += e.a.a.a.fU(3, this.wem);
            if (this.wen != null) {
                return fU + e.a.a.a.fW(4, this.wen.bkL());
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.wel != null) {
                return 0;
            }
            throw new b("Not all required fields were included: OperationInfo");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            oo ooVar = (oo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bes;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ooVar.wek = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        ooVar.wel = bes;
                    }
                    return 0;
                case 3:
                    ooVar.wem = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        ooVar.wen = bes;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
