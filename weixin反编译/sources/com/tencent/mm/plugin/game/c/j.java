package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class j extends a {
    public String nlr;
    public LinkedList<av> nlu = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.nlu);
            if (this.nlr != null) {
                aVar.g(2, this.nlr);
            }
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.nlu) + 0;
            if (this.nlr != null) {
                return c + e.a.a.b.b.a.h(2, this.nlr);
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
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a avVar = new av();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = avVar.a(aVar4, avVar, a.a(aVar4))) {
                        }
                        jVar.nlu.add(avVar);
                    }
                    return 0;
                case 2:
                    jVar.nlr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
