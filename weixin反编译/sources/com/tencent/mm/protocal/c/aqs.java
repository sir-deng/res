package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class aqs extends a {
    public String kyG;
    public sc vQx;
    public bes vSZ;
    public String vTg;
    public String vTs;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vSZ == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            } else if (this.vQx == null) {
                throw new b("Not all required fields were included: CliPubECDHKey");
            } else {
                if (this.vSZ != null) {
                    aVar.fZ(1, this.vSZ.bkL());
                    this.vSZ.a(aVar);
                }
                if (this.vQx != null) {
                    aVar.fZ(2, this.vQx.bkL());
                    this.vQx.a(aVar);
                }
                if (this.kyG != null) {
                    aVar.g(3, this.kyG);
                }
                if (this.vTg != null) {
                    aVar.g(4, this.vTg);
                }
                if (this.vTs == null) {
                    return 0;
                }
                aVar.g(5, this.vTs);
                return 0;
            }
        } else if (i == 1) {
            if (this.vSZ != null) {
                fW = e.a.a.a.fW(1, this.vSZ.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vQx != null) {
                fW += e.a.a.a.fW(2, this.vQx.bkL());
            }
            if (this.kyG != null) {
                fW += e.a.a.b.b.a.h(3, this.kyG);
            }
            if (this.vTg != null) {
                fW += e.a.a.b.b.a.h(4, this.vTg);
            }
            if (this.vTs != null) {
                fW += e.a.a.b.b.a.h(5, this.vTs);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vSZ == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            } else if (this.vQx != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CliPubECDHKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aqs aqs = (aqs) objArr[1];
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
                        aqs.vSZ = bes;
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
                        aqs.vQx = bes;
                    }
                    return 0;
                case 3:
                    aqs.kyG = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aqs.vTg = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aqs.vTs = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
