package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class cp extends a {
    public String fzT;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fzT == null) {
                throw new b("Not all required fields were included: wording");
            } else if (this.url == null) {
                throw new b("Not all required fields were included: url");
            } else {
                aVar.fX(1, this.type);
                if (this.fzT != null) {
                    aVar.g(2, this.fzT);
                }
                if (this.url != null) {
                    aVar.g(3, this.url);
                }
                return 0;
            }
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.type) + 0;
            if (this.fzT != null) {
                fU += e.a.a.b.b.a.h(2, this.fzT);
            }
            if (this.url != null) {
                return fU + e.a.a.b.b.a.h(3, this.url);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.fzT == null) {
                throw new b("Not all required fields were included: wording");
            } else if (this.url != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: url");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cp cpVar = (cp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cpVar.type = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    cpVar.fzT = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cpVar.url = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
