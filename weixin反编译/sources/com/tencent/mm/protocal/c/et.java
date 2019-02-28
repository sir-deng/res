package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class et extends a {
    public String ID;
    public int vQL;
    public bes vQM;
    public String vQN;
    public int vQO;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQM == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            }
            aVar.fX(1, this.vQL);
            if (this.vQM != null) {
                aVar.fZ(2, this.vQM.bkL());
                this.vQM.a(aVar);
            }
            if (this.vQN != null) {
                aVar.g(3, this.vQN);
            }
            aVar.fX(4, this.vQO);
            if (this.ID != null) {
                aVar.g(5, this.ID);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vQL) + 0;
            if (this.vQM != null) {
                fU += e.a.a.a.fW(2, this.vQM.bkL());
            }
            if (this.vQN != null) {
                fU += e.a.a.b.b.a.h(3, this.vQN);
            }
            fU += e.a.a.a.fU(4, this.vQO);
            if (this.ID != null) {
                return fU + e.a.a.b.b.a.h(5, this.ID);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.vQM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: QRCodeBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            et etVar = (et) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    etVar.vQL = aVar3.AEQ.rz();
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
                        etVar.vQM = bes;
                    }
                    return 0;
                case 3:
                    etVar.vQN = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    etVar.vQO = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    etVar.ID = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
