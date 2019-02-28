package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class r extends a {
    public String ID;
    public long kyX;
    public int kza;
    public int kzb;
    public int kzc;
    public long kzd;
    public long kze;
    public LinkedList<t> kzp = new LinkedList();
    public LinkedList<t> kzq = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.g(1, this.ID);
            }
            aVar.fX(2, this.kza);
            aVar.fX(3, this.kzb);
            aVar.fX(4, this.kzc);
            aVar.S(5, this.kyX);
            aVar.S(6, this.kzd);
            aVar.S(7, this.kze);
            aVar.d(8, 8, this.kzp);
            aVar.d(9, 8, this.kzq);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                h = e.a.a.b.b.a.h(1, this.ID) + 0;
            } else {
                h = 0;
            }
            return (((((((h + e.a.a.a.fU(2, this.kza)) + e.a.a.a.fU(3, this.kzb)) + e.a.a.a.fU(4, this.kzc)) + e.a.a.a.R(5, this.kyX)) + e.a.a.a.R(6, this.kzd)) + e.a.a.a.R(7, this.kze)) + e.a.a.a.c(8, 8, this.kzp)) + e.a.a.a.c(9, 8, this.kzq);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kzp.clear();
            this.kzq.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            r rVar = (r) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a tVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    rVar.ID = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    rVar.kza = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    rVar.kzb = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    rVar.kzc = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    rVar.kyX = aVar3.AEQ.rA();
                    return 0;
                case 6:
                    rVar.kzd = aVar3.AEQ.rA();
                    return 0;
                case 7:
                    rVar.kze = aVar3.AEQ.rA();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        tVar = new t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tVar.a(aVar4, tVar, a.a(aVar4))) {
                        }
                        rVar.kzp.add(tVar);
                    }
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        tVar = new t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tVar.a(aVar4, tVar, a.a(aVar4))) {
                        }
                        rVar.kzq.add(tVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
