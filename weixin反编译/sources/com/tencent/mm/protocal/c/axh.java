package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class axh extends a {
    public String hDV;
    public String pRd;
    public String pgf;
    public int wLp;
    public String wLq;
    public int wLr;
    public String wLs;
    public int wLt;
    public String wLu;
    public long wLv;
    public LinkedList<awy> wLw = new LinkedList();
    public String wzy;

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wLp);
            if (this.wLq != null) {
                aVar.g(2, this.wLq);
            }
            if (this.wzy != null) {
                aVar.g(3, this.wzy);
            }
            aVar.fX(4, this.wLr);
            if (this.pgf != null) {
                aVar.g(5, this.pgf);
            }
            if (this.wLs != null) {
                aVar.g(6, this.wLs);
            }
            if (this.pRd != null) {
                aVar.g(7, this.pRd);
            }
            aVar.fX(8, this.wLt);
            if (this.hDV != null) {
                aVar.g(9, this.hDV);
            }
            if (this.wLu != null) {
                aVar.g(10, this.wLu);
            }
            aVar.S(11, this.wLv);
            aVar.d(12, 8, this.wLw);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wLp) + 0;
            if (this.wLq != null) {
                fU += e.a.a.b.b.a.h(2, this.wLq);
            }
            if (this.wzy != null) {
                fU += e.a.a.b.b.a.h(3, this.wzy);
            }
            fU += e.a.a.a.fU(4, this.wLr);
            if (this.pgf != null) {
                fU += e.a.a.b.b.a.h(5, this.pgf);
            }
            if (this.wLs != null) {
                fU += e.a.a.b.b.a.h(6, this.wLs);
            }
            if (this.pRd != null) {
                fU += e.a.a.b.b.a.h(7, this.pRd);
            }
            fU += e.a.a.a.fU(8, this.wLt);
            if (this.hDV != null) {
                fU += e.a.a.b.b.a.h(9, this.hDV);
            }
            if (this.wLu != null) {
                fU += e.a.a.b.b.a.h(10, this.wLu);
            }
            return (fU + e.a.a.a.R(11, this.wLv)) + e.a.a.a.c(12, 8, this.wLw);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wLw.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axh axh = (axh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    axh.wLp = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    axh.wLq = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    axh.wzy = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    axh.wLr = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    axh.pgf = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    axh.wLs = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    axh.pRd = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    axh.wLt = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    axh.hDV = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    axh.wLu = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    axh.wLv = aVar3.AEQ.rA();
                    return 0;
                case 12:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a awy = new awy();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = awy.a(aVar4, awy, a.a(aVar4))) {
                        }
                        axh.wLw.add(awy);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
