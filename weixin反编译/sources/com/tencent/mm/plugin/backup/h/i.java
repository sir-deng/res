package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class i extends a {
    public LinkedList<String> kyC = new LinkedList();
    public LinkedList<Long> kyD = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.kyC);
            aVar.d(2, 3, this.kyD);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 1, this.kyC) + 0) + e.a.a.a.c(2, 3, this.kyD);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.kyC.clear();
                this.kyD.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                i iVar = (i) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        iVar.kyC.add(aVar3.AEQ.readString());
                        return 0;
                    case 2:
                        iVar.kyD.add(Long.valueOf(aVar3.AEQ.rA()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
