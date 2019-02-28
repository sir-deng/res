package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class aky extends a {
    public int wyP;
    public alb wyQ;
    public ala wyR;
    public akz wyS;
    public akx wyT;
    public alc wyU;
    public ald wyV;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wyP);
            if (this.wyQ != null) {
                aVar.fZ(2, this.wyQ.bkL());
                this.wyQ.a(aVar);
            }
            if (this.wyR != null) {
                aVar.fZ(3, this.wyR.bkL());
                this.wyR.a(aVar);
            }
            if (this.wyS != null) {
                aVar.fZ(4, this.wyS.bkL());
                this.wyS.a(aVar);
            }
            if (this.wyT != null) {
                aVar.fZ(5, this.wyT.bkL());
                this.wyT.a(aVar);
            }
            if (this.wyU != null) {
                aVar.fZ(6, this.wyU.bkL());
                this.wyU.a(aVar);
            }
            if (this.wyV != null) {
                aVar.fZ(7, this.wyV.bkL());
                this.wyV.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wyP) + 0;
            if (this.wyQ != null) {
                fU += e.a.a.a.fW(2, this.wyQ.bkL());
            }
            if (this.wyR != null) {
                fU += e.a.a.a.fW(3, this.wyR.bkL());
            }
            if (this.wyS != null) {
                fU += e.a.a.a.fW(4, this.wyS.bkL());
            }
            if (this.wyT != null) {
                fU += e.a.a.a.fW(5, this.wyT.bkL());
            }
            if (this.wyU != null) {
                fU += e.a.a.a.fW(6, this.wyU.bkL());
            }
            if (this.wyV != null) {
                return fU + e.a.a.a.fW(7, this.wyV.bkL());
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
            aky aky = (aky) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a alb;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    aky.wyP = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        alb = new alb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alb.a(aVar4, alb, a.a(aVar4))) {
                        }
                        aky.wyQ = alb;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        alb = new ala();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alb.a(aVar4, alb, a.a(aVar4))) {
                        }
                        aky.wyR = alb;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        alb = new akz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alb.a(aVar4, alb, a.a(aVar4))) {
                        }
                        aky.wyS = alb;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        alb = new akx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alb.a(aVar4, alb, a.a(aVar4))) {
                        }
                        aky.wyT = alb;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        alb = new alc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alb.a(aVar4, alb, a.a(aVar4))) {
                        }
                        aky.wyU = alb;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        alb = new ald();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alb.a(aVar4, alb, a.a(aVar4))) {
                        }
                        aky.wyV = alb;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
