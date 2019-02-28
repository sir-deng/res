package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class b extends a {
    public e nkO;
    public String nkP;
    public String nkQ;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkP == null) {
                throw new e.a.a.b("Not all required fields were included: AdURL");
            }
            if (this.nkO != null) {
                aVar.fZ(1, this.nkO.bkL());
                this.nkO.a(aVar);
            }
            if (this.nkP != null) {
                aVar.g(2, this.nkP);
            }
            if (this.nkQ == null) {
                return 0;
            }
            aVar.g(3, this.nkQ);
            return 0;
        } else if (i == 1) {
            if (this.nkO != null) {
                fW = e.a.a.a.fW(1, this.nkO.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.nkP != null) {
                fW += e.a.a.b.b.a.h(2, this.nkP);
            }
            if (this.nkQ != null) {
                fW += e.a.a.b.b.a.h(3, this.nkQ);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.nkP != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: AdURL");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
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
                        bVar.nkO = eVar;
                    }
                    return 0;
                case 2:
                    bVar.nkP = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bVar.nkQ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
