package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class atv extends a {
    public int sfa;
    public String vQr;
    public int vYD;
    public bes vYE;
    public ou wIF;
    public int wIG;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wIF == null) {
                throw new b("Not all required fields were included: Oplog");
            } else if (this.vYE == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else {
                if (this.wIF != null) {
                    aVar.fZ(1, this.wIF.bkL());
                    this.wIF.a(aVar);
                }
                aVar.fX(2, this.vYD);
                if (this.vYE != null) {
                    aVar.fZ(3, this.vYE.bkL());
                    this.vYE.a(aVar);
                }
                aVar.fX(4, this.sfa);
                if (this.vQr != null) {
                    aVar.g(5, this.vQr);
                }
                aVar.fX(6, this.wIG);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIF != null) {
                fW = e.a.a.a.fW(1, this.wIF.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.vYD);
            if (this.vYE != null) {
                fW += e.a.a.a.fW(3, this.vYE.bkL());
            }
            fW += e.a.a.a.fU(4, this.sfa);
            if (this.vQr != null) {
                fW += e.a.a.b.b.a.h(5, this.vQr);
            }
            return fW + e.a.a.a.fU(6, this.wIG);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wIF == null) {
                throw new b("Not all required fields were included: Oplog");
            } else if (this.vYE != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atv atv = (atv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a ouVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ouVar = new ou();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ouVar.a(aVar4, ouVar, a.a(aVar4))) {
                        }
                        atv.wIF = ouVar;
                    }
                    return 0;
                case 2:
                    atv.vYD = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ouVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ouVar.a(aVar4, ouVar, a.a(aVar4))) {
                        }
                        atv.vYE = ouVar;
                    }
                    return 0;
                case 4:
                    atv.sfa = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    atv.vQr = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    atv.wIG = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
