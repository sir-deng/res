package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import java.util.LinkedList;

public final class js extends a {
    public b vWP;
    public b vWQ;
    public LinkedList<bib> vWR = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int a;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vWP == null) {
                throw new e.a.a.b("Not all required fields were included: Title");
            } else if (this.vWQ == null) {
                throw new e.a.a.b("Not all required fields were included: ServiceUrl");
            } else {
                if (this.vWP != null) {
                    aVar.b(1, this.vWP);
                }
                if (this.vWQ != null) {
                    aVar.b(2, this.vWQ);
                }
                aVar.d(3, 8, this.vWR);
                return 0;
            }
        } else if (i == 1) {
            if (this.vWP != null) {
                a = e.a.a.a.a(1, this.vWP) + 0;
            } else {
                a = 0;
            }
            if (this.vWQ != null) {
                a += e.a.a.a.a(2, this.vWQ);
            }
            return a + e.a.a.a.c(3, 8, this.vWR);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vWR.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cKx();
                }
            }
            if (this.vWP == null) {
                throw new e.a.a.b("Not all required fields were included: Title");
            } else if (this.vWQ != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: ServiceUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            js jsVar = (js) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jsVar.vWP = aVar3.cKw();
                    return 0;
                case 2:
                    jsVar.vWQ = aVar3.cKw();
                    return 0;
                case 3:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a bib = new bib();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bib.a(aVar4, bib, a.a(aVar4))) {
                        }
                        jsVar.vWR.add(bib);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
