package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class nj extends bek {
    public String wcP;
    public String wcQ;
    public int wcX;
    public long wcY;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            aVar.fX(2, this.wcX);
            if (this.wcP != null) {
                aVar.g(3, this.wcP);
            }
            if (this.wcQ != null) {
                aVar.g(4, this.wcQ);
            }
            aVar.S(5, this.wcY);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.wcX);
            if (this.wcP != null) {
                fW += e.a.a.b.b.a.h(3, this.wcP);
            }
            if (this.wcQ != null) {
                fW += e.a.a.b.b.a.h(4, this.wcQ);
            }
            return fW + e.a.a.a.R(5, this.wcY);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nj njVar = (nj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fiVar = new fi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        njVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    njVar.wcX = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    njVar.wcP = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    njVar.wcQ = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    njVar.wcY = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
