package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import java.util.LinkedList;

public final class h extends a {
    public double sJA;
    public double sJB;
    public int sJC;
    public String sJD;
    public String sJE;
    public b sJH;
    public String sJI;
    public double sJJ;
    public LinkedList<e> sJK = new LinkedList();
    public double sJt;
    public LinkedList<q> sJv = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.sJI != null) {
                aVar.g(1, this.sJI);
            }
            aVar.b(2, this.sJJ);
            aVar.b(3, this.sJt);
            aVar.d(4, 8, this.sJK);
            aVar.d(5, 8, this.sJv);
            aVar.b(6, this.sJA);
            aVar.b(7, this.sJB);
            aVar.fX(8, this.sJC);
            if (this.sJD != null) {
                aVar.g(9, this.sJD);
            }
            if (this.sJE != null) {
                aVar.g(10, this.sJE);
            }
            if (this.sJH == null) {
                return 0;
            }
            aVar.b(11, this.sJH);
            return 0;
        } else if (i == 1) {
            if (this.sJI != null) {
                h = e.a.a.b.b.a.h(1, this.sJI) + 0;
            } else {
                h = 0;
            }
            h = ((((((h + (e.a.a.b.b.a.dX(2) + 8)) + (e.a.a.b.b.a.dX(3) + 8)) + e.a.a.a.c(4, 8, this.sJK)) + e.a.a.a.c(5, 8, this.sJv)) + (e.a.a.b.b.a.dX(6) + 8)) + (e.a.a.b.b.a.dX(7) + 8)) + e.a.a.a.fU(8, this.sJC);
            if (this.sJD != null) {
                h += e.a.a.b.b.a.h(9, this.sJD);
            }
            if (this.sJE != null) {
                h += e.a.a.b.b.a.h(10, this.sJE);
            }
            if (this.sJH != null) {
                h += e.a.a.a.a(11, this.sJH);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sJK.clear();
            this.sJv.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a eVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    hVar.sJI = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    hVar.sJJ = aVar3.AEQ.readDouble();
                    return 0;
                case 3:
                    hVar.sJt = aVar3.AEQ.readDouble();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        hVar.sJK.add(eVar);
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        eVar = new q();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        hVar.sJv.add(eVar);
                    }
                    return 0;
                case 6:
                    hVar.sJA = aVar3.AEQ.readDouble();
                    return 0;
                case 7:
                    hVar.sJB = aVar3.AEQ.readDouble();
                    return 0;
                case 8:
                    hVar.sJC = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    hVar.sJD = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    hVar.sJE = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    hVar.sJH = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
