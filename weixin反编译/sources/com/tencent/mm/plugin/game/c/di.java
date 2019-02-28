package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class di extends a {
    public String noz;
    public LinkedList<dj> npw = new LinkedList();
    public String npx;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.npw);
            if (this.noz != null) {
                aVar.g(2, this.noz);
            }
            if (this.npx != null) {
                aVar.g(3, this.npx);
            }
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.npw) + 0;
            if (this.noz != null) {
                c += e.a.a.b.b.a.h(2, this.noz);
            }
            if (this.npx != null) {
                return c + e.a.a.b.b.a.h(3, this.npx);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.npw.clear();
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
            di diVar = (di) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a djVar = new dj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = djVar.a(aVar4, djVar, a.a(aVar4))) {
                        }
                        diVar.npw.add(djVar);
                    }
                    return 0;
                case 2:
                    diVar.noz = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    diVar.npx = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
