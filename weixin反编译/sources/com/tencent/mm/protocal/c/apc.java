package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class apc extends bea {
    public int fGi;
    public String hds;
    public String mcb;
    public String username;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            } else if (this.mcb == null) {
                throw new b("Not all required fields were included: appusername");
            } else if (this.hds == null) {
                throw new b("Not all required fields were included: rankid");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.username != null) {
                    aVar.g(2, this.username);
                }
                if (this.mcb != null) {
                    aVar.g(3, this.mcb);
                }
                aVar.fX(4, this.fGi);
                if (this.hds == null) {
                    return 0;
                }
                aVar.g(5, this.hds);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.username != null) {
                fW += e.a.a.b.b.a.h(2, this.username);
            }
            if (this.mcb != null) {
                fW += e.a.a.b.b.a.h(3, this.mcb);
            }
            fW += e.a.a.a.fU(4, this.fGi);
            if (this.hds != null) {
                fW += e.a.a.b.b.a.h(5, this.hds);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            } else if (this.mcb == null) {
                throw new b("Not all required fields were included: appusername");
            } else if (this.hds != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: rankid");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            apc apc = (apc) objArr[1];
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
                        apc.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    apc.username = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    apc.mcb = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    apc.fGi = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    apc.hds = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
