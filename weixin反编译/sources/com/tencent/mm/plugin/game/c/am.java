package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class am extends a {
    public LinkedList<dd> nlu = new LinkedList();
    public da nmC;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.nlu);
            if (this.nmC != null) {
                aVar.fZ(2, this.nmC.bkL());
                this.nmC.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.nlu) + 0;
            if (this.nmC != null) {
                return c + e.a.a.a.fW(2, this.nmC.bkL());
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nlu.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            am amVar = (am) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a ddVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ddVar = new dd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ddVar.a(aVar4, ddVar, a.a(aVar4))) {
                        }
                        amVar.nlu.add(ddVar);
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ddVar = new da();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ddVar.a(aVar4, ddVar, a.a(aVar4))) {
                        }
                        amVar.nmC = ddVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
