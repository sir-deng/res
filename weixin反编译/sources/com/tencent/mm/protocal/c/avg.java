package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class avg extends a {
    public int cPf;
    public int fXa;
    public String fqG;
    public String iLo;
    public String idC;
    public String kPE;
    public int type;
    public String vNZ;
    public String wJT;
    public String wJU;
    public String wJV;
    public String wJW;
    public String wJX;
    public String wJY;
    public avh wJZ;
    public String wKa;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.idC != null) {
                aVar.g(1, this.idC);
            }
            if (this.fqG != null) {
                aVar.g(2, this.fqG);
            }
            aVar.fX(3, this.type);
            if (this.iLo != null) {
                aVar.g(4, this.iLo);
            }
            if (this.wJT != null) {
                aVar.g(5, this.wJT);
            }
            if (this.wJU != null) {
                aVar.g(6, this.wJU);
            }
            aVar.fX(7, this.cPf);
            if (this.wJV != null) {
                aVar.g(8, this.wJV);
            }
            if (this.wJW != null) {
                aVar.g(9, this.wJW);
            }
            if (this.wJX != null) {
                aVar.g(10, this.wJX);
            }
            if (this.wJY != null) {
                aVar.g(11, this.wJY);
            }
            if (this.wJZ != null) {
                aVar.fZ(12, this.wJZ.bkL());
                this.wJZ.a(aVar);
            }
            if (this.vNZ != null) {
                aVar.g(13, this.vNZ);
            }
            if (this.kPE != null) {
                aVar.g(14, this.kPE);
            }
            aVar.fX(15, this.fXa);
            if (this.wKa == null) {
                return 0;
            }
            aVar.g(16, this.wKa);
            return 0;
        } else if (i == 1) {
            if (this.idC != null) {
                h = e.a.a.b.b.a.h(1, this.idC) + 0;
            } else {
                h = 0;
            }
            if (this.fqG != null) {
                h += e.a.a.b.b.a.h(2, this.fqG);
            }
            h += e.a.a.a.fU(3, this.type);
            if (this.iLo != null) {
                h += e.a.a.b.b.a.h(4, this.iLo);
            }
            if (this.wJT != null) {
                h += e.a.a.b.b.a.h(5, this.wJT);
            }
            if (this.wJU != null) {
                h += e.a.a.b.b.a.h(6, this.wJU);
            }
            h += e.a.a.a.fU(7, this.cPf);
            if (this.wJV != null) {
                h += e.a.a.b.b.a.h(8, this.wJV);
            }
            if (this.wJW != null) {
                h += e.a.a.b.b.a.h(9, this.wJW);
            }
            if (this.wJX != null) {
                h += e.a.a.b.b.a.h(10, this.wJX);
            }
            if (this.wJY != null) {
                h += e.a.a.b.b.a.h(11, this.wJY);
            }
            if (this.wJZ != null) {
                h += e.a.a.a.fW(12, this.wJZ.bkL());
            }
            if (this.vNZ != null) {
                h += e.a.a.b.b.a.h(13, this.vNZ);
            }
            if (this.kPE != null) {
                h += e.a.a.b.b.a.h(14, this.kPE);
            }
            h += e.a.a.a.fU(15, this.fXa);
            if (this.wKa != null) {
                h += e.a.a.b.b.a.h(16, this.wKa);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            avg avg = (avg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    avg.idC = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    avg.fqG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    avg.type = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    avg.iLo = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    avg.wJT = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    avg.wJU = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    avg.cPf = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    avg.wJV = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    avg.wJW = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    avg.wJX = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    avg.wJY = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a avh = new avh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = avh.a(aVar4, avh, a.a(aVar4))) {
                        }
                        avg.wJZ = avh;
                    }
                    return 0;
                case 13:
                    avg.vNZ = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    avg.kPE = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    avg.fXa = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    avg.wKa = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
