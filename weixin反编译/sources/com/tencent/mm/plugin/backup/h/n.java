package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class n extends a {
    public String ID;
    public long kyQ;
    public long kyR;
    public long kyS;
    public m kyT;
    public long kyU;
    public int kyV;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.g(1, this.ID);
            }
            aVar.S(2, this.kyQ);
            aVar.S(3, this.kyR);
            aVar.S(4, this.kyS);
            if (this.kyT != null) {
                aVar.fZ(5, this.kyT.bkL());
                this.kyT.a(aVar);
            }
            aVar.S(6, this.kyU);
            aVar.fX(7, this.kyV);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                h = e.a.a.b.b.a.h(1, this.ID) + 0;
            } else {
                h = 0;
            }
            h = ((h + e.a.a.a.R(2, this.kyQ)) + e.a.a.a.R(3, this.kyR)) + e.a.a.a.R(4, this.kyS);
            if (this.kyT != null) {
                h += e.a.a.a.fW(5, this.kyT.bkL());
            }
            return (h + e.a.a.a.R(6, this.kyU)) + e.a.a.a.fU(7, this.kyV);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    nVar.ID = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    nVar.kyQ = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    nVar.kyR = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    nVar.kyS = aVar3.AEQ.rA();
                    return 0;
                case 5:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a mVar = new m();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = mVar.a(aVar4, mVar, a.a(aVar4))) {
                        }
                        nVar.kyT = mVar;
                    }
                    return 0;
                case 6:
                    nVar.kyU = aVar3.AEQ.rA();
                    return 0;
                case 7:
                    nVar.kyV = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
