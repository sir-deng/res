package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class lp extends a {
    public lo wbj;
    public lo wbk;
    public lo wbl;
    public lo wbm;
    public lo wbn;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wbj != null) {
                aVar.fZ(1, this.wbj.bkL());
                this.wbj.a(aVar);
            }
            if (this.wbk != null) {
                aVar.fZ(2, this.wbk.bkL());
                this.wbk.a(aVar);
            }
            if (this.wbl != null) {
                aVar.fZ(3, this.wbl.bkL());
                this.wbl.a(aVar);
            }
            if (this.wbm != null) {
                aVar.fZ(4, this.wbm.bkL());
                this.wbm.a(aVar);
            }
            if (this.wbn == null) {
                return 0;
            }
            aVar.fZ(5, this.wbn.bkL());
            this.wbn.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wbj != null) {
                fW = e.a.a.a.fW(1, this.wbj.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wbk != null) {
                fW += e.a.a.a.fW(2, this.wbk.bkL());
            }
            if (this.wbl != null) {
                fW += e.a.a.a.fW(3, this.wbl.bkL());
            }
            if (this.wbm != null) {
                fW += e.a.a.a.fW(4, this.wbm.bkL());
            }
            if (this.wbn != null) {
                fW += e.a.a.a.fW(5, this.wbn.bkL());
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
            lp lpVar = (lp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a loVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        loVar = new lo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = loVar.a(aVar4, loVar, a.a(aVar4))) {
                        }
                        lpVar.wbj = loVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        loVar = new lo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = loVar.a(aVar4, loVar, a.a(aVar4))) {
                        }
                        lpVar.wbk = loVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        loVar = new lo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = loVar.a(aVar4, loVar, a.a(aVar4))) {
                        }
                        lpVar.wbl = loVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        loVar = new lo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = loVar.a(aVar4, loVar, a.a(aVar4))) {
                        }
                        lpVar.wbm = loVar;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        loVar = new lo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = loVar.a(aVar4, loVar, a.a(aVar4))) {
                        }
                        lpVar.wbn = loVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
