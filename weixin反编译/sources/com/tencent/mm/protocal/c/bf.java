package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bf extends bea {
    public String bssid;
    public int cPf;
    public String hQh;
    public int scene;
    public String ssid;
    public int type;
    public String vMR;
    public long vMS;
    public int vMU;
    public String vMW;
    public int vMX;
    public int vNg;
    public be vNh;
    public bh vNi;
    public int vNj;
    public int vNk;
    public int vNl;

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
            aVar.fX(3, this.scene);
            aVar.fX(4, this.type);
            aVar.fX(5, this.vNg);
            if (this.ssid != null) {
                aVar.g(6, this.ssid);
            }
            if (this.bssid != null) {
                aVar.g(7, this.bssid);
            }
            aVar.S(8, this.vMS);
            if (this.vNh != null) {
                aVar.fZ(9, this.vNh.bkL());
                this.vNh.a(aVar);
            }
            if (this.vNi != null) {
                aVar.fZ(10, this.vNi.bkL());
                this.vNi.a(aVar);
            }
            aVar.fX(11, this.vMU);
            if (this.vMR != null) {
                aVar.g(12, this.vMR);
            }
            aVar.fX(13, this.cPf);
            if (this.vMW != null) {
                aVar.g(14, this.vMW);
            }
            aVar.fX(15, this.vNj);
            aVar.fX(16, this.vNk);
            aVar.fX(17, this.vNl);
            aVar.fX(18, this.vMX);
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
            fW = ((fW + e.a.a.a.fU(3, this.scene)) + e.a.a.a.fU(4, this.type)) + e.a.a.a.fU(5, this.vNg);
            if (this.ssid != null) {
                fW += e.a.a.b.b.a.h(6, this.ssid);
            }
            if (this.bssid != null) {
                fW += e.a.a.b.b.a.h(7, this.bssid);
            }
            fW += e.a.a.a.R(8, this.vMS);
            if (this.vNh != null) {
                fW += e.a.a.a.fW(9, this.vNh.bkL());
            }
            if (this.vNi != null) {
                fW += e.a.a.a.fW(10, this.vNi.bkL());
            }
            fW += e.a.a.a.fU(11, this.vMU);
            if (this.vMR != null) {
                fW += e.a.a.b.b.a.h(12, this.vMR);
            }
            fW += e.a.a.a.fU(13, this.cPf);
            if (this.vMW != null) {
                fW += e.a.a.b.b.a.h(14, this.vMW);
            }
            return (((fW + e.a.a.a.fU(15, this.vNj)) + e.a.a.a.fU(16, this.vNk)) + e.a.a.a.fU(17, this.vNl)) + e.a.a.a.fU(18, this.vMX);
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
            bf bfVar = (bf) objArr[1];
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
                        bfVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bfVar.hQh = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bfVar.scene = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bfVar.type = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bfVar.vNg = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bfVar.ssid = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bfVar.bssid = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bfVar.vMS = aVar3.AEQ.rA();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new be();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfVar.vNh = fhVar;
                    }
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfVar.vNi = fhVar;
                    }
                    return 0;
                case 11:
                    bfVar.vMU = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    bfVar.vMR = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    bfVar.cPf = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    bfVar.vMW = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    bfVar.vNj = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    bfVar.vNk = aVar3.AEQ.rz();
                    return 0;
                case 17:
                    bfVar.vNl = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    bfVar.vMX = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
