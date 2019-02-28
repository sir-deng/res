package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cr extends a {
    public e nkO;
    public String noY;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkO == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.noY == null) {
                throw new b("Not all required fields were included: Rank");
            } else {
                if (this.nkO != null) {
                    aVar.fZ(1, this.nkO.bkL());
                    this.nkO.a(aVar);
                }
                if (this.noY == null) {
                    return 0;
                }
                aVar.g(2, this.noY);
                return 0;
            }
        } else if (i == 1) {
            if (this.nkO != null) {
                fW = e.a.a.a.fW(1, this.nkO.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.noY != null) {
                fW += e.a.a.b.b.a.h(2, this.noY);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.nkO == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.noY != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Rank");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cr crVar = (cr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        crVar.nkO = eVar;
                    }
                    return 0;
                case 2:
                    crVar.noY = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
