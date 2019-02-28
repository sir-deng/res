package com.tencent.mm.protocal.b.a;

import com.tencent.mm.bp.a;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vh;
import java.util.LinkedList;

public final class c extends a {
    public String desc;
    public LinkedList<uz> hfI = new LinkedList();
    public String title;
    public String vJF;
    public vh vJG;
    public long vJH;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            aVar.d(3, 8, this.hfI);
            if (this.vJF != null) {
                aVar.g(4, this.vJF);
            }
            if (this.vJG != null) {
                aVar.fZ(5, this.vJG.bkL());
                this.vJG.a(aVar);
            }
            aVar.S(6, this.vJH);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.desc != null) {
                h += e.a.a.b.b.a.h(2, this.desc);
            }
            h += e.a.a.a.c(3, 8, this.hfI);
            if (this.vJF != null) {
                h += e.a.a.b.b.a.h(4, this.vJF);
            }
            if (this.vJG != null) {
                h += e.a.a.a.fW(5, this.vJG.bkL());
            }
            return h + e.a.a.a.R(6, this.vJH);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.hfI.clear();
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a uzVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.title = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cVar.desc = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        uzVar = new uz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uzVar.a(aVar4, uzVar, a.a(aVar4))) {
                        }
                        cVar.hfI.add(uzVar);
                    }
                    return 0;
                case 4:
                    cVar.vJF = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        uzVar = new vh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uzVar.a(aVar4, uzVar, a.a(aVar4))) {
                        }
                        cVar.vJG = uzVar;
                    }
                    return 0;
                case 6:
                    cVar.vJH = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
