package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ch extends a {
    public dz noI;
    public de noJ;
    public u noK;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.noI != null) {
                aVar.fZ(1, this.noI.bkL());
                this.noI.a(aVar);
            }
            if (this.noJ != null) {
                aVar.fZ(2, this.noJ.bkL());
                this.noJ.a(aVar);
            }
            if (this.noK == null) {
                return 0;
            }
            aVar.fZ(3, this.noK.bkL());
            this.noK.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.noI != null) {
                fW = e.a.a.a.fW(1, this.noI.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.noJ != null) {
                fW += e.a.a.a.fW(2, this.noJ.bkL());
            }
            if (this.noK != null) {
                fW += e.a.a.a.fW(3, this.noK.bkL());
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
            ch chVar = (ch) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a dzVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dzVar = new dz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dzVar.a(aVar4, dzVar, a.a(aVar4))) {
                        }
                        chVar.noI = dzVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dzVar = new de();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dzVar.a(aVar4, dzVar, a.a(aVar4))) {
                        }
                        chVar.noJ = dzVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dzVar = new u();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dzVar.a(aVar4, dzVar, a.a(aVar4))) {
                        }
                        chVar.noK = dzVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
