package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class dr extends a {
    public i npJ;
    public dp npK;
    public dp npL;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.npJ != null) {
                aVar.fZ(1, this.npJ.bkL());
                this.npJ.a(aVar);
            }
            if (this.npK != null) {
                aVar.fZ(2, this.npK.bkL());
                this.npK.a(aVar);
            }
            if (this.npL == null) {
                return 0;
            }
            aVar.fZ(3, this.npL.bkL());
            this.npL.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.npJ != null) {
                fW = e.a.a.a.fW(1, this.npJ.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.npK != null) {
                fW += e.a.a.a.fW(2, this.npK.bkL());
            }
            if (this.npL != null) {
                fW += e.a.a.a.fW(3, this.npL.bkL());
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
            dr drVar = (dr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a iVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        iVar = new i();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        drVar.npJ = iVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        iVar = new dp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        drVar.npK = iVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        iVar = new dp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        drVar.npL = iVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
