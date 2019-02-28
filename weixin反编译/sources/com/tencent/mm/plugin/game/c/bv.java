package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.fi;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bv extends bek {
    public cv noo;
    public LinkedList<c> nop = new LinkedList();
    public boolean noq;
    public int nor;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            if (this.noo != null) {
                aVar.fZ(2, this.noo.bkL());
                this.noo.a(aVar);
            }
            aVar.d(3, 8, this.nop);
            aVar.am(4, this.noq);
            aVar.fX(5, this.nor);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.noo != null) {
                fW += e.a.a.a.fW(2, this.noo.bkL());
            }
            return ((fW + e.a.a.a.c(3, 8, this.nop)) + (e.a.a.b.b.a.dX(4) + 1)) + e.a.a.a.fU(5, this.nor);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nop.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            bv bvVar = (bv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            com.tencent.mm.bp.a fiVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bvVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new cv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bvVar.noo = fiVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new c();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bvVar.nop.add(fiVar);
                    }
                    return 0;
                case 4:
                    bvVar.noq = aVar3.cKv();
                    return 0;
                case 5:
                    bvVar.nor = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
