package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cbt extends a {
    public String vTU;
    public String wgP;
    public String xgn;
    public int xhD;
    public int xhE;
    public String xhI;
    public cbm xhJ;
    public cbs xhK;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xhI == null) {
                throw new b("Not all required fields were included: EntranceDomain");
            } else if (this.xgn == null) {
                throw new b("Not all required fields were included: Charset");
            } else {
                if (this.xhI != null) {
                    aVar.g(4, this.xhI);
                }
                if (this.xgn != null) {
                    aVar.g(12, this.xgn);
                }
                if (this.xhJ != null) {
                    aVar.fZ(9, this.xhJ.bkL());
                    this.xhJ.a(aVar);
                }
                if (this.xhK != null) {
                    aVar.fZ(10, this.xhK.bkL());
                    this.xhK.a(aVar);
                }
                if (this.wgP != null) {
                    aVar.g(5, this.wgP);
                }
                if (this.vTU != null) {
                    aVar.g(6, this.vTU);
                }
                aVar.fX(7, this.xhD);
                aVar.fX(8, this.xhE);
                return 0;
            }
        } else if (i == 1) {
            if (this.xhI != null) {
                h = e.a.a.b.b.a.h(4, this.xhI) + 0;
            } else {
                h = 0;
            }
            if (this.xgn != null) {
                h += e.a.a.b.b.a.h(12, this.xgn);
            }
            if (this.xhJ != null) {
                h += e.a.a.a.fW(9, this.xhJ.bkL());
            }
            if (this.xhK != null) {
                h += e.a.a.a.fW(10, this.xhK.bkL());
            }
            if (this.wgP != null) {
                h += e.a.a.b.b.a.h(5, this.wgP);
            }
            if (this.vTU != null) {
                h += e.a.a.b.b.a.h(6, this.vTU);
            }
            return (h + e.a.a.a.fU(7, this.xhD)) + e.a.a.a.fU(8, this.xhE);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.xhI == null) {
                throw new b("Not all required fields were included: EntranceDomain");
            } else if (this.xgn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Charset");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbt cbt = (cbt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a cbm;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 4:
                    cbt.xhI = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    cbt.wgP = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    cbt.vTU = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    cbt.xhD = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    cbt.xhE = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cbm = new cbm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbm.a(aVar4, cbm, a.a(aVar4))) {
                        }
                        cbt.xhJ = cbm;
                    }
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cbm = new cbs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbm.a(aVar4, cbm, a.a(aVar4))) {
                        }
                        cbt.xhK = cbm;
                    }
                    return 0;
                case 12:
                    cbt.xgn = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
