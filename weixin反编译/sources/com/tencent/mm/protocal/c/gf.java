package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class gf extends a {
    public LinkedList<ge> vSk = new LinkedList();
    public gd vSl;
    public int vSm;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.vSk);
            if (this.vSl != null) {
                aVar.fZ(2, this.vSl.bkL());
                this.vSl.a(aVar);
            }
            aVar.fX(3, this.vSm);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.vSk) + 0;
            if (this.vSl != null) {
                c += e.a.a.a.fW(2, this.vSl.bkL());
            }
            return c + e.a.a.a.fU(3, this.vSm);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vSk.clear();
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
            gf gfVar = (gf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a geVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        geVar = new ge();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = geVar.a(aVar4, geVar, a.a(aVar4))) {
                        }
                        gfVar.vSk.add(geVar);
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        geVar = new gd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = geVar.a(aVar4, geVar, a.a(aVar4))) {
                        }
                        gfVar.vSl = geVar;
                    }
                    return 0;
                case 3:
                    gfVar.vSm = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
