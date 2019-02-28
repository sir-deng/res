package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ct extends a {
    public String fpg;
    public String nlZ;
    public LinkedList<cz> noZ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nlZ == null) {
                throw new b("Not all required fields were included: Detail");
            } else {
                if (this.fpg != null) {
                    aVar.g(1, this.fpg);
                }
                aVar.d(2, 8, this.noZ);
                if (this.nlZ == null) {
                    return 0;
                }
                aVar.g(3, this.nlZ);
                return 0;
            }
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.c(2, 8, this.noZ);
            if (this.nlZ != null) {
                h += e.a.a.b.b.a.h(3, this.nlZ);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.noZ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nlZ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Detail");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ct ctVar = (ct) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ctVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a czVar = new cz();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = czVar.a(aVar4, czVar, a.a(aVar4))) {
                        }
                        ctVar.noZ.add(czVar);
                    }
                    return 0;
                case 3:
                    ctVar.nlZ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
