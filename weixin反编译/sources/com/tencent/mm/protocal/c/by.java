package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class by extends a {
    public int nlX;
    public int pgR;
    public long vNT;
    public int vNU;
    public bet vNV;
    public int vNW;
    public bet vNX;
    public int vNY;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNV == null) {
                throw new b("Not all required fields were included: ChatRoomId");
            } else if (this.vNX == null) {
                throw new b("Not all required fields were included: DigestContent");
            } else {
                if (this.vNV != null) {
                    aVar.fZ(1, this.vNV.bkL());
                    this.vNV.a(aVar);
                }
                aVar.S(2, this.vNT);
                aVar.fX(3, this.vNU);
                aVar.fX(4, this.pgR);
                aVar.fX(5, this.vNW);
                if (this.vNX != null) {
                    aVar.fZ(6, this.vNX.bkL());
                    this.vNX.a(aVar);
                }
                aVar.fX(7, this.vNY);
                aVar.fX(8, this.nlX);
                return 0;
            }
        } else if (i == 1) {
            if (this.vNV != null) {
                fW = e.a.a.a.fW(1, this.vNV.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (((fW + e.a.a.a.R(2, this.vNT)) + e.a.a.a.fU(3, this.vNU)) + e.a.a.a.fU(4, this.pgR)) + e.a.a.a.fU(5, this.vNW);
            if (this.vNX != null) {
                fW += e.a.a.a.fW(6, this.vNX.bkL());
            }
            return (fW + e.a.a.a.fU(7, this.vNY)) + e.a.a.a.fU(8, this.nlX);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vNV == null) {
                throw new b("Not all required fields were included: ChatRoomId");
            } else if (this.vNX != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DigestContent");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            by byVar = (by) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bet;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        byVar.vNV = bet;
                    }
                    return 0;
                case 2:
                    byVar.vNT = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    byVar.vNU = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    byVar.pgR = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    byVar.vNW = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        byVar.vNX = bet;
                    }
                    return 0;
                case 7:
                    byVar.vNY = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    byVar.nlX = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
