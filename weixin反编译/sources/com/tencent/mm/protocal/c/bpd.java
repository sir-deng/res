package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bpd extends a {
    public String aAM;
    public String pQt;
    public String value;
    public LinkedList<String> wYu = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.aAM == null) {
                throw new b("Not all required fields were included: key");
            } else if (this.value == null) {
                throw new b("Not all required fields were included: value");
            } else {
                if (this.aAM != null) {
                    aVar.g(1, this.aAM);
                }
                if (this.value != null) {
                    aVar.g(2, this.value);
                }
                if (this.pQt != null) {
                    aVar.g(3, this.pQt);
                }
                aVar.d(4, 1, this.wYu);
                return 0;
            }
        } else if (i == 1) {
            if (this.aAM != null) {
                h = e.a.a.b.b.a.h(1, this.aAM) + 0;
            } else {
                h = 0;
            }
            if (this.value != null) {
                h += e.a.a.b.b.a.h(2, this.value);
            }
            if (this.pQt != null) {
                h += e.a.a.b.b.a.h(3, this.pQt);
            }
            return h + e.a.a.a.c(4, 1, this.wYu);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wYu.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.aAM == null) {
                throw new b("Not all required fields were included: key");
            } else if (this.value != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: value");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpd bpd = (bpd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bpd.aAM = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bpd.value = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bpd.pQt = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bpd.wYu.add(aVar3.AEQ.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
