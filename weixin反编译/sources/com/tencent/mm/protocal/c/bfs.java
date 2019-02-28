package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bfs extends a {
    public int sfa;
    public int vUN;
    public long vWt;
    public String vWw;
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
            aVar.fX(3, this.vUN);
            if (this.wDT != null) {
                aVar.fZ(4, this.wDT.bkL());
                this.wDT.a(aVar);
            }
            aVar.fX(5, this.wRL);
            aVar.d(6, 8, this.wRM);
            aVar.fX(7, this.sfa);
            if (this.vWw != null) {
                aVar.g(8, this.vWw);
            }
            return 0;
        } else if (i == 1) {
            R = e.a.a.a.R(1, this.vWt) + 0;
            if (this.wrv != null) {
                R += e.a.a.b.b.a.h(2, this.wrv);
            }
            R += e.a.a.a.fU(3, this.vUN);
            if (this.wDT != null) {
                R += e.a.a.a.fW(4, this.wDT.bkL());
            }
            R = ((R + e.a.a.a.fU(5, this.wRL)) + e.a.a.a.c(6, 8, this.wRM)) + e.a.a.a.fU(7, this.sfa);
            if (this.vWw != null) {
                return R + e.a.a.b.b.a.h(8, this.vWw);
            }
            return R;
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
            bfs bfs = (bfs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a aou;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bfs.vWt = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    bfs.wrv = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bfs.vUN = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        aou = new aou();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aou.a(aVar4, aou, a.a(aVar4))) {
                        }
                        bfs.wDT = aou;
                    }
                    return 0;
                case 5:
                    bfs.wRL = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        aou = new btb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aou.a(aVar4, aou, a.a(aVar4))) {
                        }
                        bfs.wRM.add(aou);
                    }
                    return 0;
                case 7:
                    bfs.sfa = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bfs.vWw = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
