package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class amn extends bea {
    public String fGh;
    public String fry;
    public int scene;
    public String signature;
    public String url;
    public LinkedList<String> wAg = new LinkedList();
    public String wAh;
    public String wzR;
    public String wzS;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.fGh != null) {
                aVar.g(3, this.fGh);
            }
            aVar.d(4, 1, this.wAg);
            if (this.fry != null) {
                aVar.g(5, this.fry);
            }
            if (this.wzR != null) {
                aVar.g(6, this.wzR);
            }
            if (this.signature != null) {
                aVar.g(7, this.signature);
            }
            if (this.wzS != null) {
                aVar.g(8, this.wzS);
            }
            aVar.fX(9, this.scene);
            if (this.wAh == null) {
                return 0;
            }
            aVar.g(10, this.wAh);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.url != null) {
                fW += e.a.a.b.b.a.h(2, this.url);
            }
            if (this.fGh != null) {
                fW += e.a.a.b.b.a.h(3, this.fGh);
            }
            fW += e.a.a.a.c(4, 1, this.wAg);
            if (this.fry != null) {
                fW += e.a.a.b.b.a.h(5, this.fry);
            }
            if (this.wzR != null) {
                fW += e.a.a.b.b.a.h(6, this.wzR);
            }
            if (this.signature != null) {
                fW += e.a.a.b.b.a.h(7, this.signature);
            }
            if (this.wzS != null) {
                fW += e.a.a.b.b.a.h(8, this.wzS);
            }
            fW += e.a.a.a.fU(9, this.scene);
            if (this.wAh != null) {
                fW += e.a.a.b.b.a.h(10, this.wAh);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wAg.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            amn amn = (amn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        amn.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    amn.url = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    amn.fGh = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    amn.wAg.add(aVar3.AEQ.readString());
                    return 0;
                case 5:
                    amn.fry = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    amn.wzR = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    amn.signature = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    amn.wzS = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    amn.scene = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    amn.wAh = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
