package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ah extends a {
    public String nkL;
    public e nkO;
    public aj nmx;
    public ai nmy;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkO == null) {
                throw new b("Not all required fields were included: AppItem");
            }
            if (this.nkO != null) {
                aVar.fZ(1, this.nkO.bkL());
                this.nkO.a(aVar);
            }
            if (this.nmx != null) {
                aVar.fZ(2, this.nmx.bkL());
                this.nmx.a(aVar);
            }
            if (this.nmy != null) {
                aVar.fZ(3, this.nmy.bkL());
                this.nmy.a(aVar);
            }
            if (this.nkL == null) {
                return 0;
            }
            aVar.g(4, this.nkL);
            return 0;
        } else if (i == 1) {
            if (this.nkO != null) {
                fW = e.a.a.a.fW(1, this.nkO.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.nmx != null) {
                fW += e.a.a.a.fW(2, this.nmx.bkL());
            }
            if (this.nmy != null) {
                fW += e.a.a.a.fW(3, this.nmy.bkL());
            }
            if (this.nkL != null) {
                fW += e.a.a.b.b.a.h(4, this.nkL);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.nkO != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppItem");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ah ahVar = (ah) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a eVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        ahVar.nkO = eVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        eVar = new aj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        ahVar.nmx = eVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        eVar = new ai();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        ahVar.nmy = eVar;
                    }
                    return 0;
                case 4:
                    ahVar.nkL = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
