package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bfl extends bea {
    public String fGh;
    public String scope;
    public String state;
    public String wRB;
    public String wRC;
    public String wRD;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.fGh != null) {
                aVar.g(2, this.fGh);
            }
            if (this.scope != null) {
                aVar.g(3, this.scope);
            }
            if (this.state != null) {
                aVar.g(4, this.state);
            }
            if (this.wRB != null) {
                aVar.g(5, this.wRB);
            }
            if (this.wRC != null) {
                aVar.g(6, this.wRC);
            }
            if (this.wRD == null) {
                return 0;
            }
            aVar.g(7, this.wRD);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.fGh != null) {
                fW += e.a.a.b.b.a.h(2, this.fGh);
            }
            if (this.scope != null) {
                fW += e.a.a.b.b.a.h(3, this.scope);
            }
            if (this.state != null) {
                fW += e.a.a.b.b.a.h(4, this.state);
            }
            if (this.wRB != null) {
                fW += e.a.a.b.b.a.h(5, this.wRB);
            }
            if (this.wRC != null) {
                fW += e.a.a.b.b.a.h(6, this.wRC);
            }
            if (this.wRD != null) {
                fW += e.a.a.b.b.a.h(7, this.wRD);
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
            bfl bfl = (bfl) objArr[1];
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
                        bfl.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bfl.fGh = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bfl.scope = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bfl.state = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bfl.wRB = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bfl.wRC = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bfl.wRD = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
