package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class acf extends a {
    public bes vOw;
    public String vPI;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPI == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.vOw == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.vPI != null) {
                    aVar.g(1, this.vPI);
                }
                if (this.vOw == null) {
                    return 0;
                }
                aVar.fZ(2, this.vOw.bkL());
                this.vOw.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.vPI != null) {
                h = e.a.a.b.b.a.h(1, this.vPI) + 0;
            } else {
                h = 0;
            }
            if (this.vOw != null) {
                h += e.a.a.a.fW(2, this.vOw.bkL());
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.vPI == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.vOw != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            acf acf = (acf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    acf.vPI = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bes = new bes();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        acf.vOw = bes;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
