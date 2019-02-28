package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class an extends a {
    public String nlr;
    public String nlv;
    public int nlz;
    public String nmD;
    public int nmE;
    public cm nmF;
    public cl nmG;
    public cn nmH;
    public eg nmI;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlv != null) {
                aVar.g(1, this.nlv);
            }
            if (this.nmD != null) {
                aVar.g(2, this.nmD);
            }
            aVar.fX(3, this.nmE);
            if (this.nlr != null) {
                aVar.g(4, this.nlr);
            }
            aVar.fX(5, this.nlz);
            if (this.nmF != null) {
                aVar.fZ(6, this.nmF.bkL());
                this.nmF.a(aVar);
            }
            if (this.nmG != null) {
                aVar.fZ(7, this.nmG.bkL());
                this.nmG.a(aVar);
            }
            if (this.nmH != null) {
                aVar.fZ(9, this.nmH.bkL());
                this.nmH.a(aVar);
            }
            if (this.nmI == null) {
                return 0;
            }
            aVar.fZ(10, this.nmI.bkL());
            this.nmI.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.nlv != null) {
                h = e.a.a.b.b.a.h(1, this.nlv) + 0;
            } else {
                h = 0;
            }
            if (this.nmD != null) {
                h += e.a.a.b.b.a.h(2, this.nmD);
            }
            h += e.a.a.a.fU(3, this.nmE);
            if (this.nlr != null) {
                h += e.a.a.b.b.a.h(4, this.nlr);
            }
            h += e.a.a.a.fU(5, this.nlz);
            if (this.nmF != null) {
                h += e.a.a.a.fW(6, this.nmF.bkL());
            }
            if (this.nmG != null) {
                h += e.a.a.a.fW(7, this.nmG.bkL());
            }
            if (this.nmH != null) {
                h += e.a.a.a.fW(9, this.nmH.bkL());
            }
            if (this.nmI != null) {
                h += e.a.a.a.fW(10, this.nmI.bkL());
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
            an anVar = (an) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a cmVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    anVar.nlv = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    anVar.nmD = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    anVar.nmE = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    anVar.nlr = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    anVar.nlz = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cmVar = new cm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmVar.a(aVar4, cmVar, a.a(aVar4))) {
                        }
                        anVar.nmF = cmVar;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cmVar = new cl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmVar.a(aVar4, cmVar, a.a(aVar4))) {
                        }
                        anVar.nmG = cmVar;
                    }
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cmVar = new cn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmVar.a(aVar4, cmVar, a.a(aVar4))) {
                        }
                        anVar.nmH = cmVar;
                    }
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cmVar = new eg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmVar.a(aVar4, cmVar, a.a(aVar4))) {
                        }
                        anVar.nmI = cmVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
