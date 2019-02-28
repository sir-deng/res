package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class byk extends a {
    public String vTt;
    public String vTu;
    public bes vTx;
    public String xfF;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vTx == null) {
                throw new b("Not all required fields were included: KSid");
            }
            if (this.vTt != null) {
                aVar.g(1, this.vTt);
            }
            if (this.vTu != null) {
                aVar.g(2, this.vTu);
            }
            if (this.xfF != null) {
                aVar.g(3, this.xfF);
            }
            if (this.vTx == null) {
                return 0;
            }
            aVar.fZ(4, this.vTx.bkL());
            this.vTx.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vTt != null) {
                h = e.a.a.b.b.a.h(1, this.vTt) + 0;
            } else {
                h = 0;
            }
            if (this.vTu != null) {
                h += e.a.a.b.b.a.h(2, this.vTu);
            }
            if (this.xfF != null) {
                h += e.a.a.b.b.a.h(3, this.xfF);
            }
            if (this.vTx != null) {
                h += e.a.a.a.fW(4, this.vTx.bkL());
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.vTx != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KSid");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byk byk = (byk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    byk.vTt = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    byk.vTu = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    byk.xfF = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bes = new bes();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        byk.vTx = bes;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
