package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class y extends a {
    public String kyG;
    public String nlZ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyG == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.nlZ == null) {
                throw new b("Not all required fields were included: Detail");
            } else {
                if (this.kyG != null) {
                    aVar.g(1, this.kyG);
                }
                if (this.nlZ == null) {
                    return 0;
                }
                aVar.g(2, this.nlZ);
                return 0;
            }
        } else if (i == 1) {
            if (this.kyG != null) {
                h = e.a.a.b.b.a.h(1, this.kyG) + 0;
            } else {
                h = 0;
            }
            if (this.nlZ != null) {
                h += e.a.a.b.b.a.h(2, this.nlZ);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.kyG == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.nlZ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Detail");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            y yVar = (y) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yVar.kyG = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    yVar.nlZ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
