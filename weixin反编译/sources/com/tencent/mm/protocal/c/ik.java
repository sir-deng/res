package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ik extends a {
    public String vVc;
    public int vVd;
    public String vVe;
    public int vVf;
    public LinkedList<hk> vVg = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vVc != null) {
                aVar.g(1, this.vVc);
            }
            aVar.fX(2, this.vVd);
            if (this.vVe != null) {
                aVar.g(3, this.vVe);
            }
            aVar.fX(4, this.vVf);
            aVar.d(5, 8, this.vVg);
            return 0;
        } else if (i == 1) {
            if (this.vVc != null) {
                h = e.a.a.b.b.a.h(1, this.vVc) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.vVd);
            if (this.vVe != null) {
                h += e.a.a.b.b.a.h(3, this.vVe);
            }
            return (h + e.a.a.a.fU(4, this.vVf)) + e.a.a.a.c(5, 8, this.vVg);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vVg.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ik ikVar = (ik) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ikVar.vVc = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ikVar.vVd = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ikVar.vVe = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ikVar.vVf = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a hkVar = new hk();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hkVar.a(aVar4, hkVar, a.a(aVar4))) {
                        }
                        ikVar.vVg.add(hkVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
