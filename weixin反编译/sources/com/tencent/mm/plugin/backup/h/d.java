package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class d extends a {
    public String ID;
    public h kyo;
    public int kyp;
    public int kyq;
    public int kyr;
    public int kys;
    public int kyt;
    public int kyu;
    public int kyv;
    public int kyw;
    public int kyx;

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
            if (this.kyo != null) {
                aVar.fZ(2, this.kyo.bkL());
                this.kyo.a(aVar);
            }
            aVar.fX(3, this.kyp);
            aVar.fX(4, this.kyq);
            aVar.fX(5, this.kyr);
            aVar.fX(6, this.kys);
            aVar.fX(7, this.kyt);
            aVar.fX(8, this.kyu);
            aVar.fX(9, this.kyv);
            aVar.fX(10, this.kyw);
            aVar.fX(11, this.kyx);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                h = e.a.a.b.b.a.h(1, this.ID) + 0;
            } else {
                h = 0;
            }
            if (this.kyo != null) {
                h += e.a.a.a.fW(2, this.kyo.bkL());
            }
            return ((((((((h + e.a.a.a.fU(3, this.kyp)) + e.a.a.a.fU(4, this.kyq)) + e.a.a.a.fU(5, this.kyr)) + e.a.a.a.fU(6, this.kys)) + e.a.a.a.fU(7, this.kyt)) + e.a.a.a.fU(8, this.kyu)) + e.a.a.a.fU(9, this.kyv)) + e.a.a.a.fU(10, this.kyw)) + e.a.a.a.fU(11, this.kyx);
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
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dVar.ID = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a hVar = new h();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        dVar.kyo = hVar;
                    }
                    return 0;
                case 3:
                    dVar.kyp = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    dVar.kyq = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    dVar.kyr = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    dVar.kys = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    dVar.kyt = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    dVar.kyu = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    dVar.kyv = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    dVar.kyw = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    dVar.kyx = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
