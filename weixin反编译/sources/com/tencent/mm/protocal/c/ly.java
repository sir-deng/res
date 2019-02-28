package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ly extends bea {
    public int fDM;
    public String lov;
    public String wbw;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.lov == null) {
                throw new b("Not all required fields were included: qrcode_url");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.lov != null) {
                aVar.g(2, this.lov);
            }
            aVar.fX(3, this.fDM);
            if (this.wbw == null) {
                return 0;
            }
            aVar.g(4, this.wbw);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.lov != null) {
                fW += e.a.a.b.b.a.h(2, this.lov);
            }
            fW += e.a.a.a.fU(3, this.fDM);
            if (this.wbw != null) {
                fW += e.a.a.b.b.a.h(4, this.wbw);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.lov != null) {
                return 0;
            }
            throw new b("Not all required fields were included: qrcode_url");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ly lyVar = (ly) objArr[1];
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
                        lyVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    lyVar.lov = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    lyVar.fDM = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    lyVar.wbw = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
