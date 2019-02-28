package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bkp extends a {
    public String vNF;
    public long vWS;
    public long wUt;
    public bko wUu;
    public bko wUv;

    protected final int a(int i, Object... objArr) {
        int R;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wUu == null) {
                throw new b("Not all required fields were included: CurrentAction");
            }
            aVar.S(1, this.vWS);
            aVar.S(2, this.wUt);
            if (this.wUu != null) {
                aVar.fZ(3, this.wUu.bkL());
                this.wUu.a(aVar);
            }
            if (this.wUv != null) {
                aVar.fZ(4, this.wUv.bkL());
                this.wUv.a(aVar);
            }
            if (this.vNF != null) {
                aVar.g(5, this.vNF);
            }
            return 0;
        } else if (i == 1) {
            R = (e.a.a.a.R(1, this.vWS) + 0) + e.a.a.a.R(2, this.wUt);
            if (this.wUu != null) {
                R += e.a.a.a.fW(3, this.wUu.bkL());
            }
            if (this.wUv != null) {
                R += e.a.a.a.fW(4, this.wUv.bkL());
            }
            if (this.vNF != null) {
                return R + e.a.a.b.b.a.h(5, this.vNF);
            }
            return R;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (R = a.a(aVar2); R > 0; R = a.a(aVar2)) {
                if (!super.a(aVar2, this, R)) {
                    aVar2.cKx();
                }
            }
            if (this.wUu != null) {
                return 0;
            }
            throw new b("Not all required fields were included: CurrentAction");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkp bkp = (bkp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bko;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bkp.vWS = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    bkp.wUt = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bko = new bko();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bko.a(aVar4, bko, a.a(aVar4))) {
                        }
                        bkp.wUu = bko;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bko = new bko();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bko.a(aVar4, bko, a.a(aVar4))) {
                        }
                        bkp.wUv = bko;
                    }
                    return 0;
                case 5:
                    bkp.vNF = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
