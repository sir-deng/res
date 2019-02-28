package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class de extends a {
    public String nlY;
    public dg npn;
    public dg npo;
    public dg npp;
    public dg npq;
    public dg npr;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.npn != null) {
                aVar.fZ(1, this.npn.bkL());
                this.npn.a(aVar);
            }
            if (this.npo != null) {
                aVar.fZ(2, this.npo.bkL());
                this.npo.a(aVar);
            }
            if (this.npp != null) {
                aVar.fZ(3, this.npp.bkL());
                this.npp.a(aVar);
            }
            if (this.npq != null) {
                aVar.fZ(4, this.npq.bkL());
                this.npq.a(aVar);
            }
            if (this.npr != null) {
                aVar.fZ(6, this.npr.bkL());
                this.npr.a(aVar);
            }
            if (this.nlY == null) {
                return 0;
            }
            aVar.g(5, this.nlY);
            return 0;
        } else if (i == 1) {
            if (this.npn != null) {
                fW = e.a.a.a.fW(1, this.npn.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.npo != null) {
                fW += e.a.a.a.fW(2, this.npo.bkL());
            }
            if (this.npp != null) {
                fW += e.a.a.a.fW(3, this.npp.bkL());
            }
            if (this.npq != null) {
                fW += e.a.a.a.fW(4, this.npq.bkL());
            }
            if (this.npr != null) {
                fW += e.a.a.a.fW(6, this.npr.bkL());
            }
            if (this.nlY != null) {
                fW += e.a.a.b.b.a.h(5, this.nlY);
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
            de deVar = (de) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a dgVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dgVar = new dg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dgVar.a(aVar4, dgVar, a.a(aVar4))) {
                        }
                        deVar.npn = dgVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dgVar = new dg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dgVar.a(aVar4, dgVar, a.a(aVar4))) {
                        }
                        deVar.npo = dgVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dgVar = new dg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dgVar.a(aVar4, dgVar, a.a(aVar4))) {
                        }
                        deVar.npp = dgVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dgVar = new dg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dgVar.a(aVar4, dgVar, a.a(aVar4))) {
                        }
                        deVar.npq = dgVar;
                    }
                    return 0;
                case 5:
                    deVar.nlY = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dgVar = new dg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dgVar.a(aVar4, dgVar, a.a(aVar4))) {
                        }
                        deVar.npr = dgVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
