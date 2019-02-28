package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class iz extends bea {
    public int fDM;
    public int pPM;
    public String pQT;
    public String pQU;
    public int pQY;
    public String pQZ;
    public String pRa;
    public String rYp;
    public String rYq;
    public int scene;
    public wd vOj;
    public String vOk;
    public int vOl;
    public String vVH;
    public String vVN;
    public String vVO;
    public String vVP;
    public int vVQ;
    public boolean vVR;
    public boolean vVS;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vVN == null) {
                throw new b("Not all required fields were included: qrcode_id");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.pQZ != null) {
                aVar.g(2, this.pQZ);
            }
            if (this.vVN != null) {
                aVar.g(3, this.vVN);
            }
            aVar.fX(4, this.scene);
            if (this.vVO != null) {
                aVar.g(5, this.vVO);
            }
            if (this.pQT != null) {
                aVar.g(6, this.pQT);
            }
            aVar.fX(7, this.vOl);
            aVar.fX(8, this.fDM);
            if (this.pRa != null) {
                aVar.g(9, this.pRa);
            }
            if (this.pQU != null) {
                aVar.g(10, this.pQU);
            }
            if (this.vVP != null) {
                aVar.g(11, this.vVP);
            }
            aVar.fX(12, this.vVQ);
            aVar.fX(13, this.pQY);
            if (this.vOk != null) {
                aVar.g(14, this.vOk);
            }
            if (this.vOj != null) {
                aVar.fZ(15, this.vOj.bkL());
                this.vOj.a(aVar);
            }
            if (this.vVH != null) {
                aVar.g(16, this.vVH);
            }
            aVar.fX(17, this.pPM);
            aVar.am(18, this.vVR);
            aVar.am(19, this.vVS);
            if (this.rYp != null) {
                aVar.g(20, this.rYp);
            }
            if (this.rYq == null) {
                return 0;
            }
            aVar.g(21, this.rYq);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.pQZ != null) {
                fW += e.a.a.b.b.a.h(2, this.pQZ);
            }
            if (this.vVN != null) {
                fW += e.a.a.b.b.a.h(3, this.vVN);
            }
            fW += e.a.a.a.fU(4, this.scene);
            if (this.vVO != null) {
                fW += e.a.a.b.b.a.h(5, this.vVO);
            }
            if (this.pQT != null) {
                fW += e.a.a.b.b.a.h(6, this.pQT);
            }
            fW = (fW + e.a.a.a.fU(7, this.vOl)) + e.a.a.a.fU(8, this.fDM);
            if (this.pRa != null) {
                fW += e.a.a.b.b.a.h(9, this.pRa);
            }
            if (this.pQU != null) {
                fW += e.a.a.b.b.a.h(10, this.pQU);
            }
            if (this.vVP != null) {
                fW += e.a.a.b.b.a.h(11, this.vVP);
            }
            fW = (fW + e.a.a.a.fU(12, this.vVQ)) + e.a.a.a.fU(13, this.pQY);
            if (this.vOk != null) {
                fW += e.a.a.b.b.a.h(14, this.vOk);
            }
            if (this.vOj != null) {
                fW += e.a.a.a.fW(15, this.vOj.bkL());
            }
            if (this.vVH != null) {
                fW += e.a.a.b.b.a.h(16, this.vVH);
            }
            fW = ((fW + e.a.a.a.fU(17, this.pPM)) + (e.a.a.b.b.a.dX(18) + 1)) + (e.a.a.b.b.a.dX(19) + 1);
            if (this.rYp != null) {
                fW += e.a.a.b.b.a.h(20, this.rYp);
            }
            if (this.rYq != null) {
                fW += e.a.a.b.b.a.h(21, this.rYq);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vVN != null) {
                return 0;
            }
            throw new b("Not all required fields were included: qrcode_id");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            iz izVar = (iz) objArr[1];
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
                        izVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    izVar.pQZ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    izVar.vVN = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    izVar.scene = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    izVar.vVO = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    izVar.pQT = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    izVar.vOl = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    izVar.fDM = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    izVar.pRa = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    izVar.pQU = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    izVar.vVP = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    izVar.vVQ = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    izVar.pQY = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    izVar.vOk = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new wd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        izVar.vOj = fhVar;
                    }
                    return 0;
                case 16:
                    izVar.vVH = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    izVar.pPM = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    izVar.vVR = aVar3.cKv();
                    return 0;
                case 19:
                    izVar.vVS = aVar3.cKv();
                    return 0;
                case 20:
                    izVar.rYp = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    izVar.rYq = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
