package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class dv extends a {
    public String vKY;
    public String vPI;
    public sv vPJ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPI == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.vPJ == null) {
                throw new b("Not all required fields were included: Price");
            } else {
                if (this.vPI != null) {
                    aVar.g(1, this.vPI);
                }
                if (this.vPJ != null) {
                    aVar.fZ(2, this.vPJ.bkL());
                    this.vPJ.a(aVar);
                }
                if (this.vKY == null) {
                    return 0;
                }
                aVar.g(3, this.vKY);
                return 0;
            }
        } else if (i == 1) {
            if (this.vPI != null) {
                h = e.a.a.b.b.a.h(1, this.vPI) + 0;
            } else {
                h = 0;
            }
            if (this.vPJ != null) {
                h += e.a.a.a.fW(2, this.vPJ.bkL());
            }
            if (this.vKY != null) {
                h += e.a.a.b.b.a.h(3, this.vKY);
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
            } else if (this.vPJ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Price");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dv dvVar = (dv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dvVar.vPI = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a svVar = new sv();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = svVar.a(aVar4, svVar, a.a(aVar4))) {
                        }
                        dvVar.vPJ = svVar;
                    }
                    return 0;
                case 3:
                    dvVar.vKY = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
