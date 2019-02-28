package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class o extends a {
    public String ID;
    public long kyQ;
    public m kyT;
    public int kyV;
    public long kyW;
    public long kyX;
    public int kyY;
    public int kyZ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.g(1, this.ID);
            }
            aVar.S(2, this.kyW);
            aVar.S(3, this.kyX);
            aVar.fX(4, this.kyY);
            aVar.fX(5, this.kyZ);
            aVar.S(6, this.kyQ);
            if (this.kyT != null) {
                aVar.fZ(7, this.kyT.bkL());
                this.kyT.a(aVar);
            }
            aVar.fX(8, this.kyV);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                h = e.a.a.b.b.a.h(1, this.ID) + 0;
            } else {
                h = 0;
            }
            h = ((((h + e.a.a.a.R(2, this.kyW)) + e.a.a.a.R(3, this.kyX)) + e.a.a.a.fU(4, this.kyY)) + e.a.a.a.fU(5, this.kyZ)) + e.a.a.a.R(6, this.kyQ);
            if (this.kyT != null) {
                h += e.a.a.a.fW(7, this.kyT.bkL());
            }
            return h + e.a.a.a.fU(8, this.kyV);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    oVar.ID = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    oVar.kyW = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    oVar.kyX = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    oVar.kyY = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    oVar.kyZ = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    oVar.kyQ = aVar3.AEQ.rA();
                    return 0;
                case 7:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a mVar = new m();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = mVar.a(aVar4, mVar, a.a(aVar4))) {
                        }
                        oVar.kyT = mVar;
                    }
                    return 0;
                case 8:
                    oVar.kyV = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
