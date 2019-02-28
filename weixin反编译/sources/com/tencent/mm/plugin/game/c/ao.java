package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ao extends a {
    public ck nmJ;
    public ck nmK;
    public ck nmL;
    public ds nmM;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nmJ != null) {
                aVar.fZ(1, this.nmJ.bkL());
                this.nmJ.a(aVar);
            }
            if (this.nmK != null) {
                aVar.fZ(2, this.nmK.bkL());
                this.nmK.a(aVar);
            }
            if (this.nmL != null) {
                aVar.fZ(3, this.nmL.bkL());
                this.nmL.a(aVar);
            }
            if (this.nmM == null) {
                return 0;
            }
            aVar.fZ(4, this.nmM.bkL());
            this.nmM.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.nmJ != null) {
                fW = e.a.a.a.fW(1, this.nmJ.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.nmK != null) {
                fW += e.a.a.a.fW(2, this.nmK.bkL());
            }
            if (this.nmL != null) {
                fW += e.a.a.a.fW(3, this.nmL.bkL());
            }
            if (this.nmM != null) {
                fW += e.a.a.a.fW(4, this.nmM.bkL());
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
            ao aoVar = (ao) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a ckVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ckVar = new ck();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ckVar.a(aVar4, ckVar, a.a(aVar4))) {
                        }
                        aoVar.nmJ = ckVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ckVar = new ck();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ckVar.a(aVar4, ckVar, a.a(aVar4))) {
                        }
                        aoVar.nmK = ckVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ckVar = new ck();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ckVar.a(aVar4, ckVar, a.a(aVar4))) {
                        }
                        aoVar.nmL = ckVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ckVar = new ds();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ckVar.a(aVar4, ckVar, a.a(aVar4))) {
                        }
                        aoVar.nmM = ckVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
