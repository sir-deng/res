package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ac extends a {
    public int kyY;
    public int kym;
    public q kzR;
    public p kzS;
    public r kzT;
    public s kzU;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.kym);
            aVar.fX(2, this.kyY);
            if (this.kzR != null) {
                aVar.fZ(3, this.kzR.bkL());
                this.kzR.a(aVar);
            }
            if (this.kzS != null) {
                aVar.fZ(4, this.kzS.bkL());
                this.kzS.a(aVar);
            }
            if (this.kzT != null) {
                aVar.fZ(5, this.kzT.bkL());
                this.kzT.a(aVar);
            }
            if (this.kzU != null) {
                aVar.fZ(6, this.kzU.bkL());
                this.kzU.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.kym) + 0) + e.a.a.a.fU(2, this.kyY);
            if (this.kzR != null) {
                fU += e.a.a.a.fW(3, this.kzR.bkL());
            }
            if (this.kzS != null) {
                fU += e.a.a.a.fW(4, this.kzS.bkL());
            }
            if (this.kzT != null) {
                fU += e.a.a.a.fW(5, this.kzT.bkL());
            }
            if (this.kzU != null) {
                return fU + e.a.a.a.fW(6, this.kzU.bkL());
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ac acVar = (ac) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a qVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    acVar.kym = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    acVar.kyY = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        qVar = new q();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        acVar.kzR = qVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        qVar = new p();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        acVar.kzS = qVar;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        qVar = new r();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        acVar.kzT = qVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        qVar = new s();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        acVar.kzU = qVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
