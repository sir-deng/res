package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class aa extends a {
    public String kyy;
    public long kzK;
    public long kzL;
    public String kzM;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyy == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.kzM == null) {
                throw new b("Not all required fields were included: MsgDataID");
            } else {
                if (this.kyy != null) {
                    aVar.g(1, this.kyy);
                }
                aVar.S(2, this.kzK);
                aVar.S(3, this.kzL);
                if (this.kzM == null) {
                    return 0;
                }
                aVar.g(4, this.kzM);
                return 0;
            }
        } else if (i == 1) {
            if (this.kyy != null) {
                h = e.a.a.b.b.a.h(1, this.kyy) + 0;
            } else {
                h = 0;
            }
            h = (h + e.a.a.a.R(2, this.kzK)) + e.a.a.a.R(3, this.kzL);
            if (this.kzM != null) {
                h += e.a.a.b.b.a.h(4, this.kzM);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.kyy == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.kzM != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MsgDataID");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aa aaVar = (aa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aaVar.kyy = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    aaVar.kzK = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    aaVar.kzL = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    aaVar.kzM = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
