package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ai extends bea {
    public String fHP;
    public String fHQ;
    public int fHR;
    public String kQJ;
    public String vLs;
    public String vLt;
    public int vLu;
    public int vLv;
    public bmz vLw;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.fHP == null) {
                throw new b("Not all required fields were included: card_id");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.kQJ != null) {
                aVar.g(2, this.kQJ);
            }
            aVar.fX(3, this.fHR);
            if (this.fHP != null) {
                aVar.g(4, this.fHP);
            }
            if (this.fHQ != null) {
                aVar.g(5, this.fHQ);
            }
            if (this.vLs != null) {
                aVar.g(6, this.vLs);
            }
            if (this.vLt != null) {
                aVar.g(7, this.vLt);
            }
            aVar.fX(8, this.vLu);
            aVar.fX(9, this.vLv);
            if (this.vLw == null) {
                return 0;
            }
            aVar.fZ(10, this.vLw.bkL());
            this.vLw.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.kQJ != null) {
                fW += e.a.a.b.b.a.h(2, this.kQJ);
            }
            fW += e.a.a.a.fU(3, this.fHR);
            if (this.fHP != null) {
                fW += e.a.a.b.b.a.h(4, this.fHP);
            }
            if (this.fHQ != null) {
                fW += e.a.a.b.b.a.h(5, this.fHQ);
            }
            if (this.vLs != null) {
                fW += e.a.a.b.b.a.h(6, this.vLs);
            }
            if (this.vLt != null) {
                fW += e.a.a.b.b.a.h(7, this.vLt);
            }
            fW = (fW + e.a.a.a.fU(8, this.vLu)) + e.a.a.a.fU(9, this.vLv);
            if (this.vLw != null) {
                fW += e.a.a.a.fW(10, this.vLw.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.fHP != null) {
                return 0;
            }
            throw new b("Not all required fields were included: card_id");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ai aiVar = (ai) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a fhVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new fh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aiVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    aiVar.kQJ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aiVar.fHR = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    aiVar.fHP = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aiVar.fHQ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aiVar.vLs = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    aiVar.vLt = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    aiVar.vLu = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    aiVar.vLv = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bmz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aiVar.vLw = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
