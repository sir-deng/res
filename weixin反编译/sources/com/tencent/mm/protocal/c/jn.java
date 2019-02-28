package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class jn extends a {
    public String nlA;
    public String vWx;
    public String vWy;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlA == null) {
                throw new b("Not all required fields were included: IconUrl");
            }
            if (this.nlA != null) {
                aVar.g(1, this.nlA);
            }
            if (this.vWx != null) {
                aVar.g(2, this.vWx);
            }
            if (this.vWy == null) {
                return 0;
            }
            aVar.g(3, this.vWy);
            return 0;
        } else if (i == 1) {
            if (this.nlA != null) {
                h = e.a.a.b.b.a.h(1, this.nlA) + 0;
            } else {
                h = 0;
            }
            if (this.vWx != null) {
                h += e.a.a.b.b.a.h(2, this.vWx);
            }
            if (this.vWy != null) {
                h += e.a.a.b.b.a.h(3, this.vWy);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.nlA != null) {
                return 0;
            }
            throw new b("Not all required fields were included: IconUrl");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jn jnVar = (jn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jnVar.nlA = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    jnVar.vWx = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    jnVar.vWy = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
