package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class d extends a {
    public String content;
    public int ptM;
    public String ptN;
    public LinkedList<i> ptO = new LinkedList();
    public LinkedList<i> ptP = new LinkedList();
    public LinkedList<i> ptQ = new LinkedList();
    public LinkedList<y> ptR = new LinkedList();
    public String ptS;
    public int ptT = 5;

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.content == null) {
                throw new b("Not all required fields were included: content");
            }
            aVar.fX(1, this.ptM);
            if (this.ptN != null) {
                aVar.g(2, this.ptN);
            }
            aVar.d(3, 8, this.ptO);
            aVar.d(4, 8, this.ptP);
            aVar.d(5, 8, this.ptQ);
            aVar.d(6, 8, this.ptR);
            if (this.ptS != null) {
                aVar.g(7, this.ptS);
            }
            if (this.content != null) {
                aVar.g(8, this.content);
            }
            aVar.fX(9, this.ptT);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.ptM) + 0;
            if (this.ptN != null) {
                fU += e.a.a.b.b.a.h(2, this.ptN);
            }
            fU = (((fU + e.a.a.a.c(3, 8, this.ptO)) + e.a.a.a.c(4, 8, this.ptP)) + e.a.a.a.c(5, 8, this.ptQ)) + e.a.a.a.c(6, 8, this.ptR);
            if (this.ptS != null) {
                fU += e.a.a.b.b.a.h(7, this.ptS);
            }
            if (this.content != null) {
                fU += e.a.a.b.b.a.h(8, this.content);
            }
            return fU + e.a.a.a.fU(9, this.ptT);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ptO.clear();
            this.ptP.clear();
            this.ptQ.clear();
            this.ptR.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.content != null) {
                return 0;
            }
            throw new b("Not all required fields were included: content");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a iVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dVar.ptM = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    dVar.ptN = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        iVar = new i();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.ptO.add(iVar);
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        iVar = new i();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.ptP.add(iVar);
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        iVar = new i();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.ptQ.add(iVar);
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        iVar = new y();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.ptR.add(iVar);
                    }
                    return 0;
                case 7:
                    dVar.ptS = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    dVar.content = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    dVar.ptT = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
