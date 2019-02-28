package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bea;
import com.tencent.mm.protocal.c.fh;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bu extends bea {
    public String hxn;
    public LinkedList<String> nnJ = new LinkedList();
    public String nnm;
    public int nok;
    public int nol;
    public int nom;
    public boolean non;

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
            aVar.fX(2, this.nok);
            aVar.fX(3, this.nol);
            if (this.nnm != null) {
                aVar.g(4, this.nnm);
            }
            aVar.d(5, 1, this.nnJ);
            if (this.hxn != null) {
                aVar.g(6, this.hxn);
            }
            aVar.fX(7, this.nom);
            aVar.am(8, this.non);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.fU(2, this.nok)) + e.a.a.a.fU(3, this.nol);
            if (this.nnm != null) {
                fW += e.a.a.b.b.a.h(4, this.nnm);
            }
            fW += e.a.a.a.c(5, 1, this.nnJ);
            if (this.hxn != null) {
                fW += e.a.a.b.b.a.h(6, this.hxn);
            }
            return (fW + e.a.a.a.fU(7, this.nom)) + (e.a.a.b.b.a.dX(8) + 1);
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
            bu buVar = (bu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        buVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    buVar.nok = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    buVar.nol = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    buVar.nnm = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    buVar.nnJ.add(aVar3.AEQ.readString());
                    return 0;
                case 6:
                    buVar.hxn = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    buVar.nom = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    buVar.non = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
