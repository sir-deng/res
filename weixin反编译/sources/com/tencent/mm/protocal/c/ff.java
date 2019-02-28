package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ff extends a {
    public bes vPW;
    public bes vPX;
    public String vQc;
    public bes vRI;
    public byk vRJ;
    public cca vRK;
    public int vRL;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vRI != null) {
                aVar.fZ(1, this.vRI.bkL());
                this.vRI.a(aVar);
            }
            if (this.vRJ != null) {
                aVar.fZ(2, this.vRJ.bkL());
                this.vRJ.a(aVar);
            }
            if (this.vRK != null) {
                aVar.fZ(3, this.vRK.bkL());
                this.vRK.a(aVar);
            }
            if (this.vPW != null) {
                aVar.fZ(4, this.vPW.bkL());
                this.vPW.a(aVar);
            }
            if (this.vPX != null) {
                aVar.fZ(5, this.vPX.bkL());
                this.vPX.a(aVar);
            }
            aVar.fX(6, this.vRL);
            if (this.vQc == null) {
                return 0;
            }
            aVar.g(7, this.vQc);
            return 0;
        } else if (i == 1) {
            if (this.vRI != null) {
                fW = e.a.a.a.fW(1, this.vRI.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vRJ != null) {
                fW += e.a.a.a.fW(2, this.vRJ.bkL());
            }
            if (this.vRK != null) {
                fW += e.a.a.a.fW(3, this.vRK.bkL());
            }
            if (this.vPW != null) {
                fW += e.a.a.a.fW(4, this.vPW.bkL());
            }
            if (this.vPX != null) {
                fW += e.a.a.a.fW(5, this.vPX.bkL());
            }
            fW += e.a.a.a.fU(6, this.vRL);
            if (this.vQc != null) {
                fW += e.a.a.b.b.a.h(7, this.vQc);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ff ffVar = (ff) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bes;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        ffVar.vRI = bes;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new byk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        ffVar.vRJ = bes;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new cca();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        ffVar.vRK = bes;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        ffVar.vPW = bes;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        ffVar.vPX = bes;
                    }
                    return 0;
                case 6:
                    ffVar.vRL = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    ffVar.vQc = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
