package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class alh extends a {
    public int major;
    public String njL;
    public LinkedList<alj> wzh = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.njL != null) {
                aVar.g(1, this.njL);
            }
            aVar.fX(2, this.major);
            aVar.d(3, 8, this.wzh);
            return 0;
        } else if (i == 1) {
            if (this.njL != null) {
                h = e.a.a.b.b.a.h(1, this.njL) + 0;
            } else {
                h = 0;
            }
            return (h + e.a.a.a.fU(2, this.major)) + e.a.a.a.c(3, 8, this.wzh);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wzh.clear();
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
            alh alh = (alh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    alh.njL = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    alh.major = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a alj = new alj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = alj.a(aVar4, alj, a.a(aVar4))) {
                        }
                        alh.wzh.add(alj);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
