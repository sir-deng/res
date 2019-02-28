package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class axd extends bea {
    public String ael;
    public int wLa;
    public String wLc;
    public String wLd;
    public String wLe;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.wLa);
            if (this.ael != null) {
                aVar.g(3, this.ael);
            }
            if (this.wLc != null) {
                aVar.g(4, this.wLc);
            }
            if (this.wLd != null) {
                aVar.g(5, this.wLd);
            }
            if (this.wLe == null) {
                return 0;
            }
            aVar.g(6, this.wLe);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.wLa);
            if (this.ael != null) {
                fW += e.a.a.b.b.a.h(3, this.ael);
            }
            if (this.wLc != null) {
                fW += e.a.a.b.b.a.h(4, this.wLc);
            }
            if (this.wLd != null) {
                fW += e.a.a.b.b.a.h(5, this.wLd);
            }
            if (this.wLe != null) {
                fW += e.a.a.b.b.a.h(6, this.wLe);
            }
            return fW;
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
            axd axd = (axd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        axd.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    axd.wLa = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    axd.ael = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    axd.wLc = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    axd.wLd = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    axd.wLe = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
