package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cbh extends a {
    public String lTZ;
    public int sfa;
    public long vWt;
    public int wDS;
    public aou wDT;
    public String woK;
    public LinkedList<String> xhk = new LinkedList();
    public LinkedList<oz> xhl = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.xhk);
            aVar.fX(2, this.wDS);
            if (this.lTZ != null) {
                aVar.g(3, this.lTZ);
            }
            aVar.fX(4, this.sfa);
            aVar.S(5, this.vWt);
            if (this.woK != null) {
                aVar.g(6, this.woK);
            }
            if (this.wDT != null) {
                aVar.fZ(7, this.wDT.bkL());
                this.wDT.a(aVar);
            }
            aVar.d(8, 8, this.xhl);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 1, this.xhk) + 0) + e.a.a.a.fU(2, this.wDS);
            if (this.lTZ != null) {
                c += e.a.a.b.b.a.h(3, this.lTZ);
            }
            c = (c + e.a.a.a.fU(4, this.sfa)) + e.a.a.a.R(5, this.vWt);
            if (this.woK != null) {
                c += e.a.a.b.b.a.h(6, this.woK);
            }
            if (this.wDT != null) {
                c += e.a.a.a.fW(7, this.wDT.bkL());
            }
            return c + e.a.a.a.c(8, 8, this.xhl);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xhk.clear();
            this.xhl.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbh cbh = (cbh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a aou;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cbh.xhk.add(aVar3.AEQ.readString());
                    return 0;
                case 2:
                    cbh.wDS = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    cbh.lTZ = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cbh.sfa = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    cbh.vWt = aVar3.AEQ.rA();
                    return 0;
                case 6:
                    cbh.woK = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        aou = new aou();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aou.a(aVar4, aou, a.a(aVar4))) {
                        }
                        cbh.wDT = aou;
                    }
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        aou = new oz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aou.a(aVar4, aou, a.a(aVar4))) {
                        }
                        cbh.xhl.add(aou);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
