package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class nv extends a {
    public String wdw;
    public String wdx;
    public LinkedList<bpd> wdy = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wdw == null) {
                throw new b("Not all required fields were included: baseid");
            }
            if (this.wdw != null) {
                aVar.g(1, this.wdw);
            }
            if (this.wdx != null) {
                aVar.g(2, this.wdx);
            }
            aVar.d(3, 8, this.wdy);
            return 0;
        } else if (i == 1) {
            if (this.wdw != null) {
                h = e.a.a.b.b.a.h(1, this.wdw) + 0;
            } else {
                h = 0;
            }
            if (this.wdx != null) {
                h += e.a.a.b.b.a.h(2, this.wdx);
            }
            return h + e.a.a.a.c(3, 8, this.wdy);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wdy.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wdw != null) {
                return 0;
            }
            throw new b("Not all required fields were included: baseid");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nv nvVar = (nv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    nvVar.wdw = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    nvVar.wdx = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a bpd = new bpd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bpd.a(aVar4, bpd, a.a(aVar4))) {
                        }
                        nvVar.wdy.add(bpd);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
