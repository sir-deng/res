package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bp.a;

public final class e extends a {
    public String sJo;
    public String sJp;
    public String sJq;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.sJo != null) {
                aVar.g(1, this.sJo);
            }
            if (this.sJp != null) {
                aVar.g(2, this.sJp);
            }
            if (this.sJq == null) {
                return 0;
            }
            aVar.g(3, this.sJq);
            return 0;
        } else if (i == 1) {
            if (this.sJo != null) {
                h = e.a.a.b.b.a.h(1, this.sJo) + 0;
            } else {
                h = 0;
            }
            if (this.sJp != null) {
                h += e.a.a.b.b.a.h(2, this.sJp);
            }
            if (this.sJq != null) {
                h += e.a.a.b.b.a.h(3, this.sJq);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eVar.sJo = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    eVar.sJp = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    eVar.sJq = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
