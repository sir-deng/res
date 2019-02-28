package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class azo extends a {
    public int nJz;
    public LinkedList<azx> wNj = new LinkedList();
    public int wil;
    public long wim;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wil);
            aVar.S(2, this.wim);
            aVar.d(3, 8, this.wNj);
            aVar.fX(4, this.nJz);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fU(1, this.wil) + 0) + e.a.a.a.R(2, this.wim)) + e.a.a.a.c(3, 8, this.wNj)) + e.a.a.a.fU(4, this.nJz);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wNj.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                azo azo = (azo) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        azo.wil = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        azo.wim = aVar3.AEQ.rA();
                        return 0;
                    case 3:
                        LinkedList JD = aVar3.JD(intValue);
                        int size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            a azx = new azx();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = azx.a(aVar4, azx, a.a(aVar4))) {
                            }
                            azo.wNj.add(azx);
                        }
                        return 0;
                    case 4:
                        azo.nJz = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
