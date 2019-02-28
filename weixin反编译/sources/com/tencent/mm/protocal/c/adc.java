package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class adc extends a {
    public ake vSq;
    public int wsu;
    public int wsv;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vSq == null) {
                throw new b("Not all required fields were included: Device");
            }
            aVar.fX(1, this.wsu);
            aVar.fX(2, this.wsv);
            if (this.vSq != null) {
                aVar.fZ(3, this.vSq.bkL());
                this.vSq.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.wsu) + 0) + e.a.a.a.fU(2, this.wsv);
            if (this.vSq != null) {
                return fU + e.a.a.a.fW(3, this.vSq.bkL());
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.vSq != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Device");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            adc adc = (adc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    adc.wsu = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    adc.wsv = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a ake = new ake();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ake.a(aVar4, ake, a.a(aVar4))) {
                        }
                        adc.vSq = ake;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
