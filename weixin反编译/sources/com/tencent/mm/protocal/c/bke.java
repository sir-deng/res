package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bke extends a {
    public int phc;
    public String vXS;
    public LinkedList<azc> wTV = new LinkedList();
    public tr wTW;
    public LinkedList<bcn> wTX = new LinkedList();
    public int wTY;
    public ce wsF;

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.phc);
            aVar.d(2, 8, this.wTV);
            if (this.wTW != null) {
                aVar.fZ(3, this.wTW.bkL());
                this.wTW.a(aVar);
            }
            if (this.wsF != null) {
                aVar.fZ(4, this.wsF.bkL());
                this.wsF.a(aVar);
            }
            aVar.d(5, 8, this.wTX);
            aVar.fX(6, this.wTY);
            if (this.vXS != null) {
                aVar.g(7, this.vXS);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.phc) + 0) + e.a.a.a.c(2, 8, this.wTV);
            if (this.wTW != null) {
                fU += e.a.a.a.fW(3, this.wTW.bkL());
            }
            if (this.wsF != null) {
                fU += e.a.a.a.fW(4, this.wsF.bkL());
            }
            fU = (fU + e.a.a.a.c(5, 8, this.wTX)) + e.a.a.a.fU(6, this.wTY);
            if (this.vXS != null) {
                return fU + e.a.a.b.b.a.h(7, this.vXS);
            }
            return fU;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wTV.clear();
            this.wTX.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            bke bke = (bke) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a azc;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bke.phc = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        azc = new azc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azc.a(aVar4, azc, a.a(aVar4))) {
                        }
                        bke.wTV.add(azc);
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        azc = new tr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azc.a(aVar4, azc, a.a(aVar4))) {
                        }
                        bke.wTW = azc;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        azc = new ce();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azc.a(aVar4, azc, a.a(aVar4))) {
                        }
                        bke.wsF = azc;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        azc = new bcn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azc.a(aVar4, azc, a.a(aVar4))) {
                        }
                        bke.wTX.add(azc);
                    }
                    return 0;
                case 6:
                    bke.wTY = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bke.vXS = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
