package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class xr extends a {
    public int fEo;
    public int wpc;
    public LinkedList<to> wpd = new LinkedList();
    public int wpe;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wpc);
            aVar.d(2, 8, this.wpd);
            aVar.fX(3, this.wpe);
            aVar.fX(4, this.fEo);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fU(1, this.wpc) + 0) + e.a.a.a.c(2, 8, this.wpd)) + e.a.a.a.fU(3, this.wpe)) + e.a.a.a.fU(4, this.fEo);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wpd.clear();
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
                xr xrVar = (xr) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        xrVar.wpc = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        LinkedList JD = aVar3.JD(intValue);
                        int size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            a toVar = new to();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = toVar.a(aVar4, toVar, a.a(aVar4))) {
                            }
                            xrVar.wpd.add(toVar);
                        }
                        return 0;
                    case 3:
                        xrVar.wpe = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        xrVar.fEo = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
