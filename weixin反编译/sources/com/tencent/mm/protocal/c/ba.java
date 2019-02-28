package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ba extends bea {
    public String bssid;
    public int cPf;
    public String hQh;
    public int hQl;
    public int scene;
    public String ssid;
    public String vMR;
    public long vMS;
    public bl vMT;
    public int vMU;
    public int vMV;
    public String vMW;
    public int vMX;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.hQh != null) {
                aVar.g(2, this.hQh);
            }
            aVar.fX(3, this.hQl);
            if (this.vMR != null) {
                aVar.g(4, this.vMR);
            }
            aVar.fX(5, this.scene);
            if (this.ssid != null) {
                aVar.g(6, this.ssid);
            }
            if (this.bssid != null) {
                aVar.g(7, this.bssid);
            }
            aVar.S(8, this.vMS);
            if (this.vMT != null) {
                aVar.fZ(9, this.vMT.bkL());
                this.vMT.a(aVar);
            }
            aVar.fX(10, this.vMU);
            aVar.fX(11, this.vMV);
            aVar.fX(12, this.cPf);
            if (this.vMW != null) {
                aVar.g(13, this.vMW);
            }
            aVar.fX(14, this.vMX);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.hQh != null) {
                fW += e.a.a.b.b.a.h(2, this.hQh);
            }
            fW += e.a.a.a.fU(3, this.hQl);
            if (this.vMR != null) {
                fW += e.a.a.b.b.a.h(4, this.vMR);
            }
            fW += e.a.a.a.fU(5, this.scene);
            if (this.ssid != null) {
                fW += e.a.a.b.b.a.h(6, this.ssid);
            }
            if (this.bssid != null) {
                fW += e.a.a.b.b.a.h(7, this.bssid);
            }
            fW += e.a.a.a.R(8, this.vMS);
            if (this.vMT != null) {
                fW += e.a.a.a.fW(9, this.vMT.bkL());
            }
            fW = ((fW + e.a.a.a.fU(10, this.vMU)) + e.a.a.a.fU(11, this.vMV)) + e.a.a.a.fU(12, this.cPf);
            if (this.vMW != null) {
                fW += e.a.a.b.b.a.h(13, this.vMW);
            }
            return fW + e.a.a.a.fU(14, this.vMX);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            ba baVar = (ba) objArr[1];
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
                        baVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    baVar.hQh = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    baVar.hQl = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    baVar.vMR = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    baVar.scene = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    baVar.ssid = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    baVar.bssid = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    baVar.vMS = aVar3.AEQ.rA();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        baVar.vMT = fhVar;
                    }
                    return 0;
                case 10:
                    baVar.vMU = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    baVar.vMV = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    baVar.cPf = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    baVar.vMW = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    baVar.vMX = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
