package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class fd extends a {
    public String nHt;
    public String pMZ;
    public int pNa;
    public int pNb;
    public String pNc;
    public String pNd;
    public String pNe;
    public String pff;
    public LinkedList<tf> vRD = new LinkedList();
    public String vRE;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pff != null) {
                aVar.g(1, this.pff);
            }
            if (this.nHt != null) {
                aVar.g(2, this.nHt);
            }
            if (this.pMZ != null) {
                aVar.g(3, this.pMZ);
            }
            aVar.fX(4, this.pNa);
            aVar.fX(5, this.pNb);
            aVar.d(6, 8, this.vRD);
            if (this.pNc != null) {
                aVar.g(7, this.pNc);
            }
            if (this.pNd != null) {
                aVar.g(8, this.pNd);
            }
            if (this.pNe != null) {
                aVar.g(9, this.pNe);
            }
            if (this.vRE == null) {
                return 0;
            }
            aVar.g(10, this.vRE);
            return 0;
        } else if (i == 1) {
            if (this.pff != null) {
                h = e.a.a.b.b.a.h(1, this.pff) + 0;
            } else {
                h = 0;
            }
            if (this.nHt != null) {
                h += e.a.a.b.b.a.h(2, this.nHt);
            }
            if (this.pMZ != null) {
                h += e.a.a.b.b.a.h(3, this.pMZ);
            }
            h = ((h + e.a.a.a.fU(4, this.pNa)) + e.a.a.a.fU(5, this.pNb)) + e.a.a.a.c(6, 8, this.vRD);
            if (this.pNc != null) {
                h += e.a.a.b.b.a.h(7, this.pNc);
            }
            if (this.pNd != null) {
                h += e.a.a.b.b.a.h(8, this.pNd);
            }
            if (this.pNe != null) {
                h += e.a.a.b.b.a.h(9, this.pNe);
            }
            if (this.vRE != null) {
                h += e.a.a.b.b.a.h(10, this.vRE);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vRD.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fd fdVar = (fd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fdVar.pff = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    fdVar.nHt = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    fdVar.pMZ = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    fdVar.pNa = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    fdVar.pNb = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a tfVar = new tf();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = tfVar.a(aVar4, tfVar, a.a(aVar4))) {
                        }
                        fdVar.vRD.add(tfVar);
                    }
                    return 0;
                case 7:
                    fdVar.pNc = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    fdVar.pNd = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    fdVar.pNe = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    fdVar.vRE = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
