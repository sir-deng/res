package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bgc extends a {
    public long vWt;
    public aou wDT;
    public int wRL;
    public LinkedList<btb> wRM = new LinkedList();
    public String wrv;

    protected final int a(int i, Object... objArr) {
        int R;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wrv == null) {
                throw new b("Not all required fields were included: KeyWord");
            }
            aVar.S(1, this.vWt);
            if (this.wrv != null) {
                aVar.g(2, this.wrv);
            }
            if (this.wDT != null) {
                aVar.fZ(3, this.wDT.bkL());
                this.wDT.a(aVar);
            }
            aVar.fX(4, this.wRL);
            aVar.d(5, 8, this.wRM);
            return 0;
        } else if (i == 1) {
            R = e.a.a.a.R(1, this.vWt) + 0;
            if (this.wrv != null) {
                R += e.a.a.b.b.a.h(2, this.wrv);
            }
            if (this.wDT != null) {
                R += e.a.a.a.fW(3, this.wDT.bkL());
            }
            return (R + e.a.a.a.fU(4, this.wRL)) + e.a.a.a.c(5, 8, this.wRM);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wRM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (R = a.a(aVar2); R > 0; R = a.a(aVar2)) {
                if (!super.a(aVar2, this, R)) {
                    aVar2.cKx();
                }
            }
            if (this.wrv != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KeyWord");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bgc bgc = (bgc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a aou;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bgc.vWt = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    bgc.wrv = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        aou = new aou();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aou.a(aVar4, aou, a.a(aVar4))) {
                        }
                        bgc.wDT = aou;
                    }
                    return 0;
                case 4:
                    bgc.wRL = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        aou = new btb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aou.a(aVar4, aou, a.a(aVar4))) {
                        }
                        bgc.wRM.add(aou);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
