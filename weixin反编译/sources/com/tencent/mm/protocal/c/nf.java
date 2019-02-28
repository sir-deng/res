package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class nf extends a {
    public int sfa;
    public LinkedList<vf> wcM = new LinkedList();
    public vq wcN;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.wcM);
            aVar.fX(2, this.sfa);
            if (this.wcN != null) {
                aVar.fZ(3, this.wcN.bkL());
                this.wcN.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 8, this.wcM) + 0) + e.a.a.a.fU(2, this.sfa);
            if (this.wcN != null) {
                return c + e.a.a.a.fW(3, this.wcN.bkL());
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wcM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nf nfVar = (nf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a vfVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vfVar = new vf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vfVar.a(aVar4, vfVar, a.a(aVar4))) {
                        }
                        nfVar.wcM.add(vfVar);
                    }
                    return 0;
                case 2:
                    nfVar.sfa = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        vfVar = new vq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vfVar.a(aVar4, vfVar, a.a(aVar4))) {
                        }
                        nfVar.wcN = vfVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
