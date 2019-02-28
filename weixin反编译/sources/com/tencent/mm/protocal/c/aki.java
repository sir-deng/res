package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class aki extends a {
    public int kzz;
    public int pgR;
    public bes vQW;
    public long wym;

    protected final int a(int i, Object... objArr) {
        int R;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQW == null) {
                throw new b("Not all required fields were included: Buffer");
            }
            aVar.S(1, this.wym);
            aVar.fX(2, this.pgR);
            if (this.vQW != null) {
                aVar.fZ(3, this.vQW.bkL());
                this.vQW.a(aVar);
            }
            aVar.fX(4, this.kzz);
            return 0;
        } else if (i == 1) {
            R = (e.a.a.a.R(1, this.wym) + 0) + e.a.a.a.fU(2, this.pgR);
            if (this.vQW != null) {
                R += e.a.a.a.fW(3, this.vQW.bkL());
            }
            return R + e.a.a.a.fU(4, this.kzz);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (R = a.a(aVar2); R > 0; R = a.a(aVar2)) {
                if (!super.a(aVar2, this, R)) {
                    aVar2.cKx();
                }
            }
            if (this.vQW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buffer");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aki aki = (aki) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aki.wym = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    aki.pgR = aVar3.AEQ.rz();
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
                        aki.vQW = bes;
                    }
                    return 0;
                case 4:
                    aki.kzz = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
