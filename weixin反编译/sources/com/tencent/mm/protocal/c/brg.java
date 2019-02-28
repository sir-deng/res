package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class brg extends bea {
    public int aAk;
    public int scene;
    public String username;
    public int vVl;
    public int wZu;
    public int wZv;
    public int wZw;
    public String wZx;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.scene);
            aVar.fX(3, this.wZu);
            aVar.fX(4, this.vVl);
            aVar.fX(5, this.wZv);
            aVar.fX(6, this.wZw);
            if (this.username != null) {
                aVar.g(7, this.username);
            }
            aVar.fX(8, this.aAk);
            if (this.wZx == null) {
                return 0;
            }
            aVar.g(9, this.wZx);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((((fW + e.a.a.a.fU(2, this.scene)) + e.a.a.a.fU(3, this.wZu)) + e.a.a.a.fU(4, this.vVl)) + e.a.a.a.fU(5, this.wZv)) + e.a.a.a.fU(6, this.wZw);
            if (this.username != null) {
                fW += e.a.a.b.b.a.h(7, this.username);
            }
            fW += e.a.a.a.fU(8, this.aAk);
            if (this.wZx != null) {
                fW += e.a.a.b.b.a.h(9, this.wZx);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brg brg = (brg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        brg.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    brg.scene = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    brg.wZu = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    brg.vVl = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    brg.wZv = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    brg.wZw = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    brg.username = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    brg.aAk = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    brg.wZx = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
