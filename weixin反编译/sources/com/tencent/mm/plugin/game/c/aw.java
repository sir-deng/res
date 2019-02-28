package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class aw extends a {
    public String nlZ;
    public LinkedList<String> nmZ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlZ == null) {
                throw new b("Not all required fields were included: Detail");
            }
            if (this.nlZ != null) {
                aVar.g(2, this.nlZ);
            }
            aVar.d(3, 1, this.nmZ);
            return 0;
        } else if (i == 1) {
            if (this.nlZ != null) {
                h = e.a.a.b.b.a.h(2, this.nlZ) + 0;
            } else {
                h = 0;
            }
            return h + e.a.a.a.c(3, 1, this.nmZ);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.nmZ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.nlZ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Detail");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aw awVar = (aw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    awVar.nlZ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    awVar.nmZ.add(aVar3.AEQ.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
