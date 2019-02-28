package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class awj extends a {
    public int kzt;
    public int kzy;
    public String nkW;
    public int npU;
    public bes vOM;
    public bes wKx;
    public String wgP;
    public String whv;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.npU);
            aVar.fX(2, this.kzy);
            if (this.nkW != null) {
                aVar.g(3, this.nkW);
            }
            aVar.fX(4, this.kzt);
            if (this.vOM != null) {
                aVar.fZ(5, this.vOM.bkL());
                this.vOM.a(aVar);
            }
            if (this.whv != null) {
                aVar.g(6, this.whv);
            }
            if (this.wKx != null) {
                aVar.fZ(7, this.wKx.bkL());
                this.wKx.a(aVar);
            }
            if (this.wgP != null) {
                aVar.g(8, this.wgP);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.npU) + 0) + e.a.a.a.fU(2, this.kzy);
            if (this.nkW != null) {
                fU += e.a.a.b.b.a.h(3, this.nkW);
            }
            fU += e.a.a.a.fU(4, this.kzt);
            if (this.vOM != null) {
                fU += e.a.a.a.fW(5, this.vOM.bkL());
            }
            if (this.whv != null) {
                fU += e.a.a.b.b.a.h(6, this.whv);
            }
            if (this.wKx != null) {
                fU += e.a.a.a.fW(7, this.wKx.bkL());
            }
            if (this.wgP != null) {
                return fU + e.a.a.b.b.a.h(8, this.wgP);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            awj awj = (awj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bes;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    awj.npU = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    awj.kzy = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    awj.nkW = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    awj.kzt = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        awj.vOM = bes;
                    }
                    return 0;
                case 6:
                    awj.whv = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        awj.wKx = bes;
                    }
                    return 0;
                case 8:
                    awj.wgP = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
