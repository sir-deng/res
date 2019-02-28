package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class afr extends bea {
    public int Height;
    public String URL;
    public int Width;
    public String wun;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.URL == null) {
                throw new b("Not all required fields were included: URL");
            } else if (this.wun == null) {
                throw new b("Not all required fields were included: UserAgent");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.URL != null) {
                    aVar.g(2, this.URL);
                }
                if (this.wun != null) {
                    aVar.g(3, this.wun);
                }
                aVar.fX(4, this.Width);
                aVar.fX(5, this.Height);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.URL != null) {
                fW += e.a.a.b.b.a.h(2, this.URL);
            }
            if (this.wun != null) {
                fW += e.a.a.b.b.a.h(3, this.wun);
            }
            return (fW + e.a.a.a.fU(4, this.Width)) + e.a.a.a.fU(5, this.Height);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.URL == null) {
                throw new b("Not all required fields were included: URL");
            } else if (this.wun != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: UserAgent");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afr afr = (afr) objArr[1];
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
                        afr.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    afr.URL = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    afr.wun = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    afr.Width = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    afr.Height = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
