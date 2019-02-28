package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public class l extends a {
    public int pjU;
    public String pkA;
    public int pkB;
    public LinkedList<e> pkC = new LinkedList();
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pkA == null) {
                throw new b("Not all required fields were included: id_info");
            }
            if (this.pkA != null) {
                aVar.g(1, this.pkA);
            }
            aVar.fX(2, this.pkB);
            if (this.url != null) {
                aVar.g(3, this.url);
            }
            aVar.d(4, 8, this.pkC);
            aVar.fX(5, this.pjU);
            return 0;
        } else if (i == 1) {
            if (this.pkA != null) {
                h = e.a.a.b.b.a.h(1, this.pkA) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.pkB);
            if (this.url != null) {
                h += e.a.a.b.b.a.h(3, this.url);
            }
            return (h + e.a.a.a.c(4, 8, this.pkC)) + e.a.a.a.fU(5, this.pjU);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.pkC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.pkA != null) {
                return 0;
            }
            throw new b("Not all required fields were included: id_info");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    lVar.pkA = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    lVar.pkB = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    lVar.url = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        lVar.pkC.add(eVar);
                    }
                    return 0;
                case 5:
                    lVar.pjU = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
