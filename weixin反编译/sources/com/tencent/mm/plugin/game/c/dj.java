package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class dj extends a {
    public e nkO;
    public String nkS;
    public boolean nlc;
    public LinkedList<String> nld = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkO == null) {
                throw new b("Not all required fields were included: AppItem");
            }
            if (this.nkO != null) {
                aVar.fZ(1, this.nkO.bkL());
                this.nkO.a(aVar);
            }
            if (this.nkS != null) {
                aVar.g(2, this.nkS);
            }
            aVar.am(3, this.nlc);
            aVar.d(4, 1, this.nld);
            return 0;
        } else if (i == 1) {
            if (this.nkO != null) {
                fW = e.a.a.a.fW(1, this.nkO.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.nkS != null) {
                fW += e.a.a.b.b.a.h(2, this.nkS);
            }
            return (fW + (e.a.a.b.b.a.dX(3) + 1)) + e.a.a.a.c(4, 1, this.nld);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nld.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.nkO != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppItem");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dj djVar = (dj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        djVar.nkO = eVar;
                    }
                    return 0;
                case 2:
                    djVar.nkS = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    djVar.nlc = aVar3.cKv();
                    return 0;
                case 4:
                    djVar.nld.add(aVar3.AEQ.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
