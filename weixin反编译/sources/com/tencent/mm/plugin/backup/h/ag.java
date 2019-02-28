package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ag extends a {
    public String kyy;
    public LinkedList<Long> kzV = new LinkedList();
    public LinkedList<String> kzW = new LinkedList();
    public LinkedList<String> kzX = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int c;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyy == null) {
                throw new b("Not all required fields were included: BakChatName");
            }
            aVar.d(1, 3, this.kzV);
            aVar.d(2, 1, this.kzW);
            aVar.d(3, 1, this.kzX);
            if (this.kyy != null) {
                aVar.g(4, this.kyy);
            }
            return 0;
        } else if (i == 1) {
            c = ((e.a.a.a.c(1, 3, this.kzV) + 0) + e.a.a.a.c(2, 1, this.kzW)) + e.a.a.a.c(3, 1, this.kzX);
            if (this.kyy != null) {
                return c + e.a.a.b.b.a.h(4, this.kyy);
            }
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.kzV.clear();
            this.kzW.clear();
            this.kzX.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cKx();
                }
            }
            if (this.kyy != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BakChatName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ag agVar = (ag) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    agVar.kzV.add(Long.valueOf(aVar3.AEQ.rA()));
                    return 0;
                case 2:
                    agVar.kzW.add(aVar3.AEQ.readString());
                    return 0;
                case 3:
                    agVar.kzX.add(aVar3.AEQ.readString());
                    return 0;
                case 4:
                    agVar.kyy = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
