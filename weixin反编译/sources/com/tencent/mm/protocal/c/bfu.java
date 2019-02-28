package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bfu extends a {
    public int vRY;
    public bes wru;
    public String wrv;
    public long wrx;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wrv == null) {
                throw new b("Not all required fields were included: KeyWord");
            }
            aVar.fX(1, this.vRY);
            if (this.wrv != null) {
                aVar.g(2, this.wrv);
            }
            if (this.wru != null) {
                aVar.fZ(3, this.wru.bkL());
                this.wru.a(aVar);
            }
            aVar.S(4, this.wrx);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vRY) + 0;
            if (this.wrv != null) {
                fU += e.a.a.b.b.a.h(2, this.wrv);
            }
            if (this.wru != null) {
                fU += e.a.a.a.fW(3, this.wru.bkL());
            }
            return fU + e.a.a.a.R(4, this.wrx);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.wrv != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KeyWord");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfu bfu = (bfu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bfu.vRY = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bfu.wrv = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bes = new bes();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        bfu.wru = bes;
                    }
                    return 0;
                case 4:
                    bfu.wrx = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
