package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bgt extends a {
    public sc vPP;
    public bes vPQ;
    public bes vPR;
    public int vQf;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPR == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else if (this.vPP == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.vPQ == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else {
                if (this.vPR != null) {
                    aVar.fZ(1, this.vPR.bkL());
                    this.vPR.a(aVar);
                }
                if (this.vPP != null) {
                    aVar.fZ(2, this.vPP.bkL());
                    this.vPP.a(aVar);
                }
                if (this.vPQ != null) {
                    aVar.fZ(3, this.vPQ.bkL());
                    this.vPQ.a(aVar);
                }
                aVar.fX(4, this.vQf);
                return 0;
            }
        } else if (i == 1) {
            if (this.vPR != null) {
                fW = e.a.a.a.fW(1, this.vPR.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vPP != null) {
                fW += e.a.a.a.fW(2, this.vPP.bkL());
            }
            if (this.vPQ != null) {
                fW += e.a.a.a.fW(3, this.vPQ.bkL());
            }
            return fW + e.a.a.a.fU(4, this.vQf);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vPR == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else if (this.vPP == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.vPQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SessionKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bgt bgt = (bgt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bes;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        bgt.vPR = bes;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new sc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        bgt.vPP = bes;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        bgt.vPQ = bes;
                    }
                    return 0;
                case 4:
                    bgt.vQf = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
