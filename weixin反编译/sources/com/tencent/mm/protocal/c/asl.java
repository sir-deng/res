package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class asl extends a {
    public ake vSI;
    public akf vSJ;
    public int wGR;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vSI == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.vSJ == null) {
                throw new b("Not all required fields were included: HardDeviceAttr");
            } else {
                if (this.vSI != null) {
                    aVar.fZ(1, this.vSI.bkL());
                    this.vSI.a(aVar);
                }
                if (this.vSJ != null) {
                    aVar.fZ(2, this.vSJ.bkL());
                    this.vSJ.a(aVar);
                }
                aVar.fX(3, this.wGR);
                return 0;
            }
        } else if (i == 1) {
            if (this.vSI != null) {
                fW = e.a.a.a.fW(1, this.vSI.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vSJ != null) {
                fW += e.a.a.a.fW(2, this.vSJ.bkL());
            }
            return fW + e.a.a.a.fU(3, this.wGR);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vSI == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.vSJ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: HardDeviceAttr");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asl asl = (asl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a ake;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ake = new ake();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ake.a(aVar4, ake, a.a(aVar4))) {
                        }
                        asl.vSI = ake;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ake = new akf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ake.a(aVar4, ake, a.a(aVar4))) {
                        }
                        asl.vSJ = ake;
                    }
                    return 0;
                case 3:
                    asl.wGR = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
