package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cp extends a {
    public ea noT;
    public df noU;
    public v noV;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.noT != null) {
                aVar.fZ(1, this.noT.bkL());
                this.noT.a(aVar);
            }
            if (this.noU != null) {
                aVar.fZ(2, this.noU.bkL());
                this.noU.a(aVar);
            }
            if (this.noV == null) {
                return 0;
            }
            aVar.fZ(3, this.noV.bkL());
            this.noV.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.noT != null) {
                fW = e.a.a.a.fW(1, this.noT.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.noU != null) {
                fW += e.a.a.a.fW(2, this.noU.bkL());
            }
            if (this.noV != null) {
                fW += e.a.a.a.fW(3, this.noV.bkL());
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
            cp cpVar = (cp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a eaVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        eaVar = new ea();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eaVar.a(aVar4, eaVar, a.a(aVar4))) {
                        }
                        cpVar.noT = eaVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        eaVar = new df();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eaVar.a(aVar4, eaVar, a.a(aVar4))) {
                        }
                        cpVar.noU = eaVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        eaVar = new v();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eaVar.a(aVar4, eaVar, a.a(aVar4))) {
                        }
                        cpVar.noV = eaVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
