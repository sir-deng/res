package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bds extends a {
    public String wQj;
    public String wQk;
    public String wQl;
    public String wQm;
    public String wQn;
    public azd wQo;
    public azd wQp;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wQj != null) {
                aVar.g(1, this.wQj);
            }
            if (this.wQk != null) {
                aVar.g(2, this.wQk);
            }
            if (this.wQl != null) {
                aVar.g(3, this.wQl);
            }
            if (this.wQm != null) {
                aVar.g(4, this.wQm);
            }
            if (this.wQn != null) {
                aVar.g(5, this.wQn);
            }
            if (this.wQo != null) {
                aVar.fZ(6, this.wQo.bkL());
                this.wQo.a(aVar);
            }
            if (this.wQp == null) {
                return 0;
            }
            aVar.fZ(7, this.wQp.bkL());
            this.wQp.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQj != null) {
                h = e.a.a.b.b.a.h(1, this.wQj) + 0;
            } else {
                h = 0;
            }
            if (this.wQk != null) {
                h += e.a.a.b.b.a.h(2, this.wQk);
            }
            if (this.wQl != null) {
                h += e.a.a.b.b.a.h(3, this.wQl);
            }
            if (this.wQm != null) {
                h += e.a.a.b.b.a.h(4, this.wQm);
            }
            if (this.wQn != null) {
                h += e.a.a.b.b.a.h(5, this.wQn);
            }
            if (this.wQo != null) {
                h += e.a.a.a.fW(6, this.wQo.bkL());
            }
            if (this.wQp != null) {
                h += e.a.a.a.fW(7, this.wQp.bkL());
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            bds bds = (bds) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a azd;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bds.wQj = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bds.wQk = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bds.wQl = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bds.wQm = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bds.wQn = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        azd = new azd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azd.a(aVar4, azd, a.a(aVar4))) {
                        }
                        bds.wQo = azd;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        azd = new azd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azd.a(aVar4, azd, a.a(aVar4))) {
                        }
                        bds.wQp = azd;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
