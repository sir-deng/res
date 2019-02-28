package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ayg extends a {
    public cbr wLU;
    public cbt wLV;
    public cbn wLW;
    public String wej;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wej == null) {
                throw new b("Not all required fields were included: PkgId");
            }
            if (this.wej != null) {
                aVar.g(1, this.wej);
            }
            if (this.wLU != null) {
                aVar.fZ(2, this.wLU.bkL());
                this.wLU.a(aVar);
            }
            if (this.wLV != null) {
                aVar.fZ(3, this.wLV.bkL());
                this.wLV.a(aVar);
            }
            if (this.wLW == null) {
                return 0;
            }
            aVar.fZ(4, this.wLW.bkL());
            this.wLW.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wej != null) {
                h = e.a.a.b.b.a.h(1, this.wej) + 0;
            } else {
                h = 0;
            }
            if (this.wLU != null) {
                h += e.a.a.a.fW(2, this.wLU.bkL());
            }
            if (this.wLV != null) {
                h += e.a.a.a.fW(3, this.wLV.bkL());
            }
            if (this.wLW != null) {
                h += e.a.a.a.fW(4, this.wLW.bkL());
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wej != null) {
                return 0;
            }
            throw new b("Not all required fields were included: PkgId");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ayg ayg = (ayg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a cbr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ayg.wej = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cbr = new cbr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbr.a(aVar4, cbr, a.a(aVar4))) {
                        }
                        ayg.wLU = cbr;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cbr = new cbt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbr.a(aVar4, cbr, a.a(aVar4))) {
                        }
                        ayg.wLV = cbr;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cbr = new cbn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbr.a(aVar4, cbr, a.a(aVar4))) {
                        }
                        ayg.wLW = cbr;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
