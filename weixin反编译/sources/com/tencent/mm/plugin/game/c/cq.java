package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cq extends a {
    public String fpg;
    public LinkedList<cr> noW = new LinkedList();
    public cs noX;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.fpg != null) {
                aVar.g(1, this.fpg);
            }
            aVar.d(2, 8, this.noW);
            if (this.noX == null) {
                return 0;
            }
            aVar.fZ(3, this.noX.bkL());
            this.noX.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.c(2, 8, this.noW);
            if (this.noX != null) {
                h += e.a.a.a.fW(3, this.noX.bkL());
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.noW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.fpg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Title");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cq cqVar = (cq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a crVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cqVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        crVar = new cr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = crVar.a(aVar4, crVar, a.a(aVar4))) {
                        }
                        cqVar.noW.add(crVar);
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        crVar = new cs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = crVar.a(aVar4, crVar, a.a(aVar4))) {
                        }
                        cqVar.noX = crVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
