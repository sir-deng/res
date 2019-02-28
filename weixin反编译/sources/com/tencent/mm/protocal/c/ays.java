package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ays extends bek {
    public String content;
    public boolean kRS;
    public String kRl;
    public int status;
    public String vLD;
    public String vLE;
    public String wMh;
    public String wMi;
    public String wMj;
    public String wMk;
    public String wMl;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            if (this.vLD != null) {
                aVar.g(2, this.vLD);
            }
            if (this.vLE != null) {
                aVar.g(3, this.vLE);
            }
            aVar.fX(4, this.status);
            if (this.content != null) {
                aVar.g(5, this.content);
            }
            if (this.kRl != null) {
                aVar.g(6, this.kRl);
            }
            if (this.wMh != null) {
                aVar.g(7, this.wMh);
            }
            aVar.am(8, this.kRS);
            if (this.wMi != null) {
                aVar.g(9, this.wMi);
            }
            if (this.wMj != null) {
                aVar.g(10, this.wMj);
            }
            if (this.wMk != null) {
                aVar.g(11, this.wMk);
            }
            if (this.wMl == null) {
                return 0;
            }
            aVar.g(12, this.wMl);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vLD != null) {
                fW += e.a.a.b.b.a.h(2, this.vLD);
            }
            if (this.vLE != null) {
                fW += e.a.a.b.b.a.h(3, this.vLE);
            }
            fW += e.a.a.a.fU(4, this.status);
            if (this.content != null) {
                fW += e.a.a.b.b.a.h(5, this.content);
            }
            if (this.kRl != null) {
                fW += e.a.a.b.b.a.h(6, this.kRl);
            }
            if (this.wMh != null) {
                fW += e.a.a.b.b.a.h(7, this.wMh);
            }
            fW += e.a.a.b.b.a.dX(8) + 1;
            if (this.wMi != null) {
                fW += e.a.a.b.b.a.h(9, this.wMi);
            }
            if (this.wMj != null) {
                fW += e.a.a.b.b.a.h(10, this.wMj);
            }
            if (this.wMk != null) {
                fW += e.a.a.b.b.a.h(11, this.wMk);
            }
            if (this.wMl != null) {
                fW += e.a.a.b.b.a.h(12, this.wMl);
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
            ays ays = (ays) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fiVar = new fi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ays.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    ays.vLD = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ays.vLE = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ays.status = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    ays.content = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    ays.kRl = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    ays.wMh = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    ays.kRS = aVar3.cKv();
                    return 0;
                case 9:
                    ays.wMi = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    ays.wMj = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    ays.wMk = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    ays.wMl = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
