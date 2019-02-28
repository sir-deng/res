package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bm extends bea {
    public int lfj;
    public LinkedList<ari> vNu = new LinkedList();
    public bet vNv;
    public int vNw;
    public String vNx;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vNv == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.lfj);
            aVar.d(3, 8, this.vNu);
            if (this.vNv != null) {
                aVar.fZ(4, this.vNv.bkL());
                this.vNv.a(aVar);
            }
            aVar.fX(5, this.vNw);
            if (this.vNx == null) {
                return 0;
            }
            aVar.g(6, this.vNx);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.fU(2, this.lfj)) + e.a.a.a.c(3, 8, this.vNu);
            if (this.vNv != null) {
                fW += e.a.a.a.fW(4, this.vNv.bkL());
            }
            fW += e.a.a.a.fU(5, this.vNw);
            if (this.vNx != null) {
                fW += e.a.a.b.b.a.h(6, this.vNx);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vNu.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vNv != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ChatRoomName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bm bmVar = (bm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
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
                        bmVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bmVar.lfj = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new ari();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bmVar.vNu.add(fhVar);
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bmVar.vNv = fhVar;
                    }
                    return 0;
                case 5:
                    bmVar.vNw = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bmVar.vNx = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
