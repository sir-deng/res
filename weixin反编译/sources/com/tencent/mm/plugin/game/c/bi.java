package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bea;
import com.tencent.mm.protocal.c.fh;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bi extends bea {
    public String hxn;
    public LinkedList<String> nnJ = new LinkedList();
    public s nnK;
    public int nnL;
    public boolean nnM;
    public String nnm;
    public int nnn;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.nnm == null) {
                throw new b("Not all required fields were included: Lang");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.nnm != null) {
                aVar.g(2, this.nnm);
            }
            aVar.d(3, 1, this.nnJ);
            if (this.hxn != null) {
                aVar.g(4, this.hxn);
            }
            if (this.nnK != null) {
                aVar.fZ(5, this.nnK.bkL());
                this.nnK.a(aVar);
            }
            aVar.fX(6, this.nnL);
            aVar.am(7, this.nnM);
            aVar.fX(8, this.nnn);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.nnm != null) {
                fW += e.a.a.b.b.a.h(2, this.nnm);
            }
            fW += e.a.a.a.c(3, 1, this.nnJ);
            if (this.hxn != null) {
                fW += e.a.a.b.b.a.h(4, this.hxn);
            }
            if (this.nnK != null) {
                fW += e.a.a.a.fW(5, this.nnK.bkL());
            }
            return ((fW + e.a.a.a.fU(6, this.nnL)) + (e.a.a.b.b.a.dX(7) + 1)) + e.a.a.a.fU(8, this.nnn);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nnJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.nnm != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Lang");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bi biVar = (bi) objArr[1];
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
                        biVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    biVar.nnm = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    biVar.nnJ.add(aVar3.AEQ.readString());
                    return 0;
                case 4:
                    biVar.hxn = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new s();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        biVar.nnK = fhVar;
                    }
                    return 0;
                case 6:
                    biVar.nnL = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    biVar.nnM = aVar3.cKv();
                    return 0;
                case 8:
                    biVar.nnn = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
