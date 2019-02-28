package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class bnj extends a {
    public String content;
    public String type;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.type == null) {
                throw new b("Not all required fields were included: type");
            }
            if (this.type != null) {
                aVar.g(1, this.type);
            }
            if (this.content == null) {
                return 0;
            }
            aVar.g(2, this.content);
            return 0;
        } else if (i == 1) {
            if (this.type != null) {
                h = e.a.a.b.b.a.h(1, this.type) + 0;
            } else {
                h = 0;
            }
            if (this.content != null) {
                h += e.a.a.b.b.a.h(2, this.content);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.type != null) {
                return 0;
            }
            throw new b("Not all required fields were included: type");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnj bnj = (bnj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bnj.type = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bnj.content = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
