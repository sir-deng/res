package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bnd extends a {
    public bne wXc;
    public bnc wXd;
    public bnb wXe;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wXc != null) {
                aVar.fZ(1, this.wXc.bkL());
                this.wXc.a(aVar);
            }
            if (this.wXd != null) {
                aVar.fZ(2, this.wXd.bkL());
                this.wXd.a(aVar);
            }
            if (this.wXe == null) {
                return 0;
            }
            aVar.fZ(3, this.wXe.bkL());
            this.wXe.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wXc != null) {
                fW = e.a.a.a.fW(1, this.wXc.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wXd != null) {
                fW += e.a.a.a.fW(2, this.wXd.bkL());
            }
            if (this.wXe != null) {
                fW += e.a.a.a.fW(3, this.wXe.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnd bnd = (bnd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bne;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bne = new bne();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bne.a(aVar4, bne, a.a(aVar4))) {
                        }
                        bnd.wXc = bne;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bne = new bnc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bne.a(aVar4, bne, a.a(aVar4))) {
                        }
                        bnd.wXd = bne;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bne = new bnb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bne.a(aVar4, bne, a.a(aVar4))) {
                        }
                        bnd.wXe = bne;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
