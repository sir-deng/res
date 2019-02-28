package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class aa extends bea {
    public String SSID;
    public String URL;
    public String vKF;
    public String vKG;
    public String vKH;
    public int vKI;
    public LinkedList<cq> vKJ = new LinkedList();
    public int vKK;
    public String vKL;
    public int vKM;
    public String vKN;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.URL != null) {
                aVar.g(2, this.URL);
            }
            if (this.SSID != null) {
                aVar.g(3, this.SSID);
            }
            if (this.vKF != null) {
                aVar.g(4, this.vKF);
            }
            if (this.vKG != null) {
                aVar.g(5, this.vKG);
            }
            if (this.vKH != null) {
                aVar.g(6, this.vKH);
            }
            aVar.fX(7, this.vKI);
            aVar.d(8, 8, this.vKJ);
            aVar.fX(9, this.vKK);
            if (this.vKL != null) {
                aVar.g(10, this.vKL);
            }
            aVar.fX(11, this.vKM);
            if (this.vKN == null) {
                return 0;
            }
            aVar.g(12, this.vKN);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.URL != null) {
                fW += e.a.a.b.b.a.h(2, this.URL);
            }
            if (this.SSID != null) {
                fW += e.a.a.b.b.a.h(3, this.SSID);
            }
            if (this.vKF != null) {
                fW += e.a.a.b.b.a.h(4, this.vKF);
            }
            if (this.vKG != null) {
                fW += e.a.a.b.b.a.h(5, this.vKG);
            }
            if (this.vKH != null) {
                fW += e.a.a.b.b.a.h(6, this.vKH);
            }
            fW = ((fW + e.a.a.a.fU(7, this.vKI)) + e.a.a.a.c(8, 8, this.vKJ)) + e.a.a.a.fU(9, this.vKK);
            if (this.vKL != null) {
                fW += e.a.a.b.b.a.h(10, this.vKL);
            }
            fW += e.a.a.a.fU(11, this.vKM);
            if (this.vKN != null) {
                fW += e.a.a.b.b.a.h(12, this.vKN);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aa aaVar = (aa) objArr[1];
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
                        aaVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    aaVar.URL = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aaVar.SSID = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aaVar.vKF = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aaVar.vKG = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aaVar.vKH = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    aaVar.vKI = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new cq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aaVar.vKJ.add(fhVar);
                    }
                    return 0;
                case 9:
                    aaVar.vKK = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    aaVar.vKL = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    aaVar.vKM = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    aaVar.vKN = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
