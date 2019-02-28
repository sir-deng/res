package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cb extends a {
    public String fpg;
    public LinkedList<cc> nox = new LinkedList();
    public String noy;
    public String noz;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.fpg != null) {
                aVar.g(1, this.fpg);
            }
            aVar.d(2, 8, this.nox);
            if (this.noy != null) {
                aVar.g(3, this.noy);
            }
            if (this.noz == null) {
                return 0;
            }
            aVar.g(4, this.noz);
            return 0;
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.c(2, 8, this.nox);
            if (this.noy != null) {
                h += e.a.a.b.b.a.h(3, this.noy);
            }
            if (this.noz != null) {
                h += e.a.a.b.b.a.h(4, this.noz);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nox.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.fpg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Title");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cb cbVar = (cb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a ccVar = new cc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ccVar.a(aVar4, ccVar, a.a(aVar4))) {
                        }
                        cbVar.nox.add(ccVar);
                    }
                    return 0;
                case 3:
                    cbVar.noy = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cbVar.noz = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
