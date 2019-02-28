package com.tencent.mm.ay;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class d extends a {
    public LinkedList<e> hLc = new LinkedList();
    public int hLd;
    public int hLe;
    public int hLf;
    public int hLg;
    public String hLh;
    public String hLi;
    public int hLj;
    public int hLk;
    public int hLl;
    public int maxSize;
    public String name;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.hLc);
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            aVar.fX(3, this.hLd);
            aVar.fX(4, this.hLe);
            aVar.fX(5, this.hLf);
            aVar.fX(6, this.hLg);
            if (this.hLh != null) {
                aVar.g(7, this.hLh);
            }
            if (this.hLi != null) {
                aVar.g(8, this.hLi);
            }
            aVar.fX(9, this.hLj);
            aVar.fX(10, this.hLk);
            aVar.fX(11, this.hLl);
            aVar.fX(12, this.maxSize);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.hLc) + 0;
            if (this.name != null) {
                c += e.a.a.b.b.a.h(2, this.name);
            }
            c = (((c + e.a.a.a.fU(3, this.hLd)) + e.a.a.a.fU(4, this.hLe)) + e.a.a.a.fU(5, this.hLf)) + e.a.a.a.fU(6, this.hLg);
            if (this.hLh != null) {
                c += e.a.a.b.b.a.h(7, this.hLh);
            }
            if (this.hLi != null) {
                c += e.a.a.b.b.a.h(8, this.hLi);
            }
            return (((c + e.a.a.a.fU(9, this.hLj)) + e.a.a.a.fU(10, this.hLk)) + e.a.a.a.fU(11, this.hLl)) + e.a.a.a.fU(12, this.maxSize);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.hLc.clear();
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
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        dVar.hLc.add(eVar);
                    }
                    return 0;
                case 2:
                    dVar.name = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    dVar.hLd = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    dVar.hLe = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    dVar.hLf = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    dVar.hLg = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    dVar.hLh = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    dVar.hLi = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    dVar.hLj = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    dVar.hLk = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    dVar.hLl = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    dVar.maxSize = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
