package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ua extends a {
    public String wiB;
    public String wiM;
    public LinkedList<String> wiN = new LinkedList();
    public boolean wiO;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wiB == null) {
                throw new b("Not all required fields were included: LoginUrl");
            }
            if (this.wiB != null) {
                aVar.g(1, this.wiB);
            }
            if (this.wiM != null) {
                aVar.g(2, this.wiM);
            }
            aVar.d(3, 1, this.wiN);
            aVar.am(4, this.wiO);
            return 0;
        } else if (i == 1) {
            if (this.wiB != null) {
                h = e.a.a.b.b.a.h(1, this.wiB) + 0;
            } else {
                h = 0;
            }
            if (this.wiM != null) {
                h += e.a.a.b.b.a.h(2, this.wiM);
            }
            return (h + e.a.a.a.c(3, 1, this.wiN)) + (e.a.a.b.b.a.dX(4) + 1);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wiN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wiB != null) {
                return 0;
            }
            throw new b("Not all required fields were included: LoginUrl");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ua uaVar = (ua) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uaVar.wiB = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    uaVar.wiM = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    uaVar.wiN.add(aVar3.AEQ.readString());
                    return 0;
                case 4:
                    uaVar.wiO = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
