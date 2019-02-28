package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aea extends bea {
    public int vNL;
    public bet vNM;
    public bet vNN;
    public long vNT;
    public int vPs;
    public int vPt;
    public int vPu;
    public int wto;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vNM == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vNN == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                aVar.fX(2, this.vNL);
                if (this.vNM != null) {
                    aVar.fZ(3, this.vNM.bkL());
                    this.vNM.a(aVar);
                }
                if (this.vNN != null) {
                    aVar.fZ(4, this.vNN.bkL());
                    this.vNN.a(aVar);
                }
                aVar.fX(5, this.vPs);
                aVar.fX(6, this.vPt);
                aVar.fX(7, this.vPu);
                aVar.fX(8, this.wto);
                aVar.S(9, this.vNT);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.vNL);
            if (this.vNM != null) {
                fW += e.a.a.a.fW(3, this.vNM.bkL());
            }
            if (this.vNN != null) {
                fW += e.a.a.a.fW(4, this.vNN.bkL());
            }
            return ((((fW + e.a.a.a.fU(5, this.vPs)) + e.a.a.a.fU(6, this.vPt)) + e.a.a.a.fU(7, this.vPu)) + e.a.a.a.fU(8, this.wto)) + e.a.a.a.R(9, this.vNT);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vNM == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vNN != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ToUserName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aea aea = (aea) objArr[1];
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
                        aea.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    aea.vNL = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aea.vNM = fhVar;
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
                        aea.vNN = fhVar;
                    }
                    return 0;
                case 5:
                    aea.vPs = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    aea.vPt = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    aea.vPu = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    aea.wto = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    aea.vNT = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
