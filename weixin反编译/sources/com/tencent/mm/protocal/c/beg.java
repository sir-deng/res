package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import java.util.LinkedList;

public final class beg extends a {
    public String nlE;
    public int wQU;
    public int wQV;
    public LinkedList<bjz> wQW = new LinkedList();
    public String wQX;
    public int wfl;
    public b wgG;
    public String wgY;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wgY == null) {
                throw new e.a.a.b("Not all required fields were included: MD5");
            } else if (this.nlE == null) {
                throw new e.a.a.b("Not all required fields were included: Url");
            } else if (this.wQX == null) {
                throw new e.a.a.b("Not all required fields were included: OriginalMD5");
            } else {
                if (this.wgY != null) {
                    aVar.g(1, this.wgY);
                }
                aVar.fX(2, this.wQU);
                if (this.nlE != null) {
                    aVar.g(3, this.nlE);
                }
                aVar.fX(4, this.wQV);
                aVar.d(5, 8, this.wQW);
                if (this.wgG != null) {
                    aVar.b(6, this.wgG);
                }
                if (this.wQX != null) {
                    aVar.g(7, this.wQX);
                }
                aVar.fX(8, this.wfl);
                return 0;
            }
        } else if (i == 1) {
            if (this.wgY != null) {
                h = e.a.a.b.b.a.h(1, this.wgY) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.wQU);
            if (this.nlE != null) {
                h += e.a.a.b.b.a.h(3, this.nlE);
            }
            h = (h + e.a.a.a.fU(4, this.wQV)) + e.a.a.a.c(5, 8, this.wQW);
            if (this.wgG != null) {
                h += e.a.a.a.a(6, this.wgG);
            }
            if (this.wQX != null) {
                h += e.a.a.b.b.a.h(7, this.wQX);
            }
            return h + e.a.a.a.fU(8, this.wfl);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wQW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wgY == null) {
                throw new e.a.a.b("Not all required fields were included: MD5");
            } else if (this.nlE == null) {
                throw new e.a.a.b("Not all required fields were included: Url");
            } else if (this.wQX != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: OriginalMD5");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            beg beg = (beg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    beg.wgY = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    beg.wQU = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    beg.nlE = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    beg.wQV = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a bjz = new bjz();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bjz.a(aVar4, bjz, a.a(aVar4))) {
                        }
                        beg.wQW.add(bjz);
                    }
                    return 0;
                case 6:
                    beg.wgG = aVar3.cKw();
                    return 0;
                case 7:
                    beg.wQX = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    beg.wfl = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
