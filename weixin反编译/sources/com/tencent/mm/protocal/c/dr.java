package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class dr extends a {
    public String fsK;
    public String hKt;
    public String vPC;
    public LinkedList<String> vPD = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPC == null) {
                throw new b("Not all required fields were included: roomname");
            }
            if (this.vPC != null) {
                aVar.g(1, this.vPC);
            }
            if (this.fsK != null) {
                aVar.g(2, this.fsK);
            }
            if (this.hKt != null) {
                aVar.g(3, this.hKt);
            }
            aVar.d(4, 1, this.vPD);
            return 0;
        } else if (i == 1) {
            if (this.vPC != null) {
                h = e.a.a.b.b.a.h(1, this.vPC) + 0;
            } else {
                h = 0;
            }
            if (this.fsK != null) {
                h += e.a.a.b.b.a.h(2, this.fsK);
            }
            if (this.hKt != null) {
                h += e.a.a.b.b.a.h(3, this.hKt);
            }
            return h + e.a.a.a.c(4, 1, this.vPD);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vPD.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.vPC != null) {
                return 0;
            }
            throw new b("Not all required fields were included: roomname");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dr drVar = (dr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    drVar.vPC = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    drVar.fsK = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    drVar.hKt = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    drVar.vPD.add(aVar3.AEQ.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
