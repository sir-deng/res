package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bvo extends bek {
    public long wim;
    public long xcP;
    public int xcZ;
    public int xda;
    public int xdb;
    public int xdc;
    public b xdd;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            aVar.S(2, this.xcP);
            aVar.S(3, this.wim);
            aVar.fX(4, this.xcZ);
            aVar.fX(5, this.xda);
            aVar.fX(6, this.xdb);
            aVar.fX(7, this.xdc);
            if (this.xdd == null) {
                return 0;
            }
            aVar.b(8, this.xdd);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (((((fW + e.a.a.a.R(2, this.xcP)) + e.a.a.a.R(3, this.wim)) + e.a.a.a.fU(4, this.xcZ)) + e.a.a.a.fU(5, this.xda)) + e.a.a.a.fU(6, this.xdb)) + e.a.a.a.fU(7, this.xdc);
            if (this.xdd != null) {
                fW += e.a.a.a.a(8, this.xdd);
            }
            return fW;
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
            throw new e.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvo bvo = (bvo) objArr[1];
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
                        bvo.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    bvo.xcP = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    bvo.wim = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    bvo.xcZ = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bvo.xda = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bvo.xdb = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bvo.xdc = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bvo.xdd = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
