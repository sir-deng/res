package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class axl extends a {
    public String noG;
    public String pgO;
    public String pgQ;
    public int pgR;
    public String pgS;
    public int pgT;
    public String pgU;
    public int pgV;
    public int pgW;
    public String pgX;
    public String pgY;
    public String pgZ;
    public String pha;
    public String phb;
    public int phc;
    public LinkedList<bka> phd = new LinkedList();
    public int wLB;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pgO != null) {
                aVar.g(1, this.pgO);
            }
            aVar.fX(2, this.wLB);
            if (this.pgQ != null) {
                aVar.g(3, this.pgQ);
            }
            aVar.fX(4, this.pgR);
            if (this.pgS != null) {
                aVar.g(5, this.pgS);
            }
            aVar.fX(6, this.pgT);
            if (this.pgU != null) {
                aVar.g(7, this.pgU);
            }
            aVar.fX(8, this.pgV);
            aVar.fX(9, this.pgW);
            if (this.pgX != null) {
                aVar.g(10, this.pgX);
            }
            if (this.noG != null) {
                aVar.g(11, this.noG);
            }
            if (this.pgY != null) {
                aVar.g(12, this.pgY);
            }
            if (this.pgZ != null) {
                aVar.g(13, this.pgZ);
            }
            if (this.pha != null) {
                aVar.g(14, this.pha);
            }
            if (this.phb != null) {
                aVar.g(15, this.phb);
            }
            aVar.fX(16, this.phc);
            aVar.d(17, 8, this.phd);
            return 0;
        } else if (i == 1) {
            if (this.pgO != null) {
                h = e.a.a.b.b.a.h(1, this.pgO) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.wLB);
            if (this.pgQ != null) {
                h += e.a.a.b.b.a.h(3, this.pgQ);
            }
            h += e.a.a.a.fU(4, this.pgR);
            if (this.pgS != null) {
                h += e.a.a.b.b.a.h(5, this.pgS);
            }
            h += e.a.a.a.fU(6, this.pgT);
            if (this.pgU != null) {
                h += e.a.a.b.b.a.h(7, this.pgU);
            }
            h = (h + e.a.a.a.fU(8, this.pgV)) + e.a.a.a.fU(9, this.pgW);
            if (this.pgX != null) {
                h += e.a.a.b.b.a.h(10, this.pgX);
            }
            if (this.noG != null) {
                h += e.a.a.b.b.a.h(11, this.noG);
            }
            if (this.pgY != null) {
                h += e.a.a.b.b.a.h(12, this.pgY);
            }
            if (this.pgZ != null) {
                h += e.a.a.b.b.a.h(13, this.pgZ);
            }
            if (this.pha != null) {
                h += e.a.a.b.b.a.h(14, this.pha);
            }
            if (this.phb != null) {
                h += e.a.a.b.b.a.h(15, this.phb);
            }
            return (h + e.a.a.a.fU(16, this.phc)) + e.a.a.a.c(17, 8, this.phd);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.phd.clear();
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
            axl axl = (axl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    axl.pgO = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    axl.wLB = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    axl.pgQ = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    axl.pgR = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    axl.pgS = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    axl.pgT = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    axl.pgU = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    axl.pgV = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    axl.pgW = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    axl.pgX = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    axl.noG = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    axl.pgY = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    axl.pgZ = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    axl.pha = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    axl.phb = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    axl.phc = aVar3.AEQ.rz();
                    return 0;
                case 17:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a bka = new bka();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bka.a(aVar4, bka, a.a(aVar4))) {
                        }
                        axl.phd.add(bka);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
