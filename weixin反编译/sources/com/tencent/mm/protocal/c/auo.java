package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import java.util.LinkedList;

public final class auo extends a {
    public b vRQ;
    public int wJi;
    public String wJj;
    public bes wJk;
    public int wJl;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wJk == null) {
                throw new e.a.a.b("Not all required fields were included: ClientKey");
            }
            aVar.fX(1, this.wJi);
            if (this.vRQ != null) {
                aVar.b(2, this.vRQ);
            }
            if (this.wJj != null) {
                aVar.g(3, this.wJj);
            }
            if (this.wJk != null) {
                aVar.fZ(4, this.wJk.bkL());
                this.wJk.a(aVar);
            }
            aVar.fX(5, this.wJl);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wJi) + 0;
            if (this.vRQ != null) {
                fU += e.a.a.a.a(2, this.vRQ);
            }
            if (this.wJj != null) {
                fU += e.a.a.b.b.a.h(3, this.wJj);
            }
            if (this.wJk != null) {
                fU += e.a.a.a.fW(4, this.wJk.bkL());
            }
            return fU + e.a.a.a.fU(5, this.wJl);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.wJk != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: ClientKey");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            auo auo = (auo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    auo.wJi = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    auo.vRQ = aVar3.cKw();
                    return 0;
                case 3:
                    auo.wJj = aVar3.AEQ.readString();
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
                        auo.wJk = bes;
                    }
                    return 0;
                case 5:
                    auo.wJl = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
