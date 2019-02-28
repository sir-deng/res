package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bok extends a {
    public String nqc;
    public String wXQ;
    public cdi wXT;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wXQ == null) {
                throw new b("Not all required fields were included: WxaUserName");
            }
            if (this.wXQ != null) {
                aVar.g(1, this.wXQ);
            }
            if (this.wXT != null) {
                aVar.fZ(2, this.wXT.bkL());
                this.wXT.a(aVar);
            }
            if (this.nqc == null) {
                return 0;
            }
            aVar.g(3, this.nqc);
            return 0;
        } else if (i == 1) {
            if (this.wXQ != null) {
                h = e.a.a.b.b.a.h(1, this.wXQ) + 0;
            } else {
                h = 0;
            }
            if (this.wXT != null) {
                h += e.a.a.a.fW(2, this.wXT.bkL());
            }
            if (this.nqc != null) {
                h += e.a.a.b.b.a.h(3, this.nqc);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wXQ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: WxaUserName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bok bok = (bok) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bok.wXQ = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a cdi = new cdi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cdi.a(aVar4, cdi, a.a(aVar4))) {
                        }
                        bok.wXT = cdi;
                    }
                    return 0;
                case 3:
                    bok.nqc = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
