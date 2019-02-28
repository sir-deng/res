package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bph extends a {
    public int state;
    public int wYA;
    public beg wYB;
    public int wYC;
    public LinkedList<bpf> wYD = new LinkedList();
    public LinkedList<bpg> wYy = new LinkedList();
    public int wYz;
    public String wdx;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wdx == null) {
                throw new b("Not all required fields were included: patchid");
            }
            if (this.wdx != null) {
                aVar.g(1, this.wdx);
            }
            aVar.fX(2, this.state);
            aVar.d(3, 8, this.wYy);
            aVar.fX(4, this.wYz);
            aVar.fX(5, this.wYA);
            if (this.wYB != null) {
                aVar.fZ(6, this.wYB.bkL());
                this.wYB.a(aVar);
            }
            aVar.fX(7, this.wYC);
            aVar.d(8, 8, this.wYD);
            return 0;
        } else if (i == 1) {
            if (this.wdx != null) {
                h = e.a.a.b.b.a.h(1, this.wdx) + 0;
            } else {
                h = 0;
            }
            h = (((h + e.a.a.a.fU(2, this.state)) + e.a.a.a.c(3, 8, this.wYy)) + e.a.a.a.fU(4, this.wYz)) + e.a.a.a.fU(5, this.wYA);
            if (this.wYB != null) {
                h += e.a.a.a.fW(6, this.wYB.bkL());
            }
            return (h + e.a.a.a.fU(7, this.wYC)) + e.a.a.a.c(8, 8, this.wYD);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wYy.clear();
            this.wYD.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wdx != null) {
                return 0;
            }
            throw new b("Not all required fields were included: patchid");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bph bph = (bph) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a bpg;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bph.wdx = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bph.state = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bpg = new bpg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpg.a(aVar4, bpg, a.a(aVar4))) {
                        }
                        bph.wYy.add(bpg);
                    }
                    return 0;
                case 4:
                    bph.wYz = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bph.wYA = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bpg = new beg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpg.a(aVar4, bpg, a.a(aVar4))) {
                        }
                        bph.wYB = bpg;
                    }
                    return 0;
                case 7:
                    bph.wYC = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bpg = new bpf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpg.a(aVar4, bpg, a.a(aVar4))) {
                        }
                        bph.wYD.add(bpg);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
