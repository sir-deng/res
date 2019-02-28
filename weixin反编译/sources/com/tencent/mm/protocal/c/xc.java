package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class xc extends a {
    public String fpg;
    public int type;
    public LinkedList<ww> woi = new LinkedList();
    public LinkedList<xe> woj = new LinkedList();
    public String wok;
    public String wol;
    public LinkedList<xd> wom = new LinkedList();
    public int won;
    public boolean woo;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg != null) {
                aVar.g(1, this.fpg);
            }
            aVar.fX(2, this.type);
            aVar.d(3, 8, this.woi);
            aVar.d(4, 8, this.woj);
            if (this.wok != null) {
                aVar.g(5, this.wok);
            }
            if (this.wol != null) {
                aVar.g(6, this.wol);
            }
            aVar.d(7, 8, this.wom);
            aVar.fX(8, this.won);
            aVar.am(9, this.woo);
            return 0;
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            h = ((h + e.a.a.a.fU(2, this.type)) + e.a.a.a.c(3, 8, this.woi)) + e.a.a.a.c(4, 8, this.woj);
            if (this.wok != null) {
                h += e.a.a.b.b.a.h(5, this.wok);
            }
            if (this.wol != null) {
                h += e.a.a.b.b.a.h(6, this.wol);
            }
            return ((h + e.a.a.a.c(7, 8, this.wom)) + e.a.a.a.fU(8, this.won)) + (e.a.a.b.b.a.dX(9) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.woi.clear();
            this.woj.clear();
            this.wom.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xc xcVar = (xc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a wwVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    xcVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    xcVar.type = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        wwVar = new ww();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wwVar.a(aVar4, wwVar, a.a(aVar4))) {
                        }
                        xcVar.woi.add(wwVar);
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        wwVar = new xe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wwVar.a(aVar4, wwVar, a.a(aVar4))) {
                        }
                        xcVar.woj.add(wwVar);
                    }
                    return 0;
                case 5:
                    xcVar.wok = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    xcVar.wol = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        wwVar = new xd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wwVar.a(aVar4, wwVar, a.a(aVar4))) {
                        }
                        xcVar.wom.add(wwVar);
                    }
                    return 0;
                case 8:
                    xcVar.won = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    xcVar.woo = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
