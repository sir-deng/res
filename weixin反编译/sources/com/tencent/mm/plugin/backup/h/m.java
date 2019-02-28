package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class m extends a {
    public String kyJ;
    public String kyK;
    public String kyL;
    public String kyM;
    public String kyN;
    public int kyO;
    public long kyP;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyJ == null) {
                throw new b("Not all required fields were included: DeviceID");
            } else if (this.kyK == null) {
                throw new b("Not all required fields were included: DeviceName");
            } else if (this.kyL == null) {
                throw new b("Not all required fields were included: Model");
            } else if (this.kyM == null) {
                throw new b("Not all required fields were included: SystemName");
            } else if (this.kyN == null) {
                throw new b("Not all required fields were included: SystemVersion");
            } else {
                if (this.kyJ != null) {
                    aVar.g(1, this.kyJ);
                }
                if (this.kyK != null) {
                    aVar.g(2, this.kyK);
                }
                if (this.kyL != null) {
                    aVar.g(3, this.kyL);
                }
                if (this.kyM != null) {
                    aVar.g(4, this.kyM);
                }
                if (this.kyN != null) {
                    aVar.g(5, this.kyN);
                }
                aVar.fX(6, this.kyO);
                aVar.S(7, this.kyP);
                return 0;
            }
        } else if (i == 1) {
            if (this.kyJ != null) {
                h = e.a.a.b.b.a.h(1, this.kyJ) + 0;
            } else {
                h = 0;
            }
            if (this.kyK != null) {
                h += e.a.a.b.b.a.h(2, this.kyK);
            }
            if (this.kyL != null) {
                h += e.a.a.b.b.a.h(3, this.kyL);
            }
            if (this.kyM != null) {
                h += e.a.a.b.b.a.h(4, this.kyM);
            }
            if (this.kyN != null) {
                h += e.a.a.b.b.a.h(5, this.kyN);
            }
            return (h + e.a.a.a.fU(6, this.kyO)) + e.a.a.a.R(7, this.kyP);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.kyJ == null) {
                throw new b("Not all required fields were included: DeviceID");
            } else if (this.kyK == null) {
                throw new b("Not all required fields were included: DeviceName");
            } else if (this.kyL == null) {
                throw new b("Not all required fields were included: Model");
            } else if (this.kyM == null) {
                throw new b("Not all required fields were included: SystemName");
            } else if (this.kyN != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SystemVersion");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.kyJ = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    mVar.kyK = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    mVar.kyL = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    mVar.kyM = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    mVar.kyN = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    mVar.kyO = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    mVar.kyP = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
