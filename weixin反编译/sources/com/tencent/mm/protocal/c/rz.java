package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class rz extends bea {
    public String aAM;
    public String fEe;
    public String fGh;
    public int scene;
    public String url;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.aAM != null) {
                aVar.g(2, this.aAM);
            }
            if (this.fGh != null) {
                aVar.g(3, this.fGh);
            }
            if (this.fEe != null) {
                aVar.g(4, this.fEe);
            }
            aVar.fX(5, this.scene);
            if (this.url == null) {
                return 0;
            }
            aVar.g(6, this.url);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.aAM != null) {
                fW += e.a.a.b.b.a.h(2, this.aAM);
            }
            if (this.fGh != null) {
                fW += e.a.a.b.b.a.h(3, this.fGh);
            }
            if (this.fEe != null) {
                fW += e.a.a.b.b.a.h(4, this.fEe);
            }
            fW += e.a.a.a.fU(5, this.scene);
            if (this.url != null) {
                fW += e.a.a.b.b.a.h(6, this.url);
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
            rz rzVar = (rz) objArr[1];
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
                        rzVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    rzVar.aAM = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    rzVar.fGh = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    rzVar.fEe = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    rzVar.scene = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    rzVar.url = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
