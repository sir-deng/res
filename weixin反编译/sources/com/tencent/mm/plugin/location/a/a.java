package com.tencent.mm.plugin.location.a;

import e.a.a.b;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bp.a {
    public LinkedList<String> fBS = new LinkedList();
    public double latitude;
    public double longitude;
    public String nWa;
    public long timestamp;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            }
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            aVar.d(2, 1, this.fBS);
            aVar.b(3, this.longitude);
            aVar.b(4, this.latitude);
            if (this.nWa != null) {
                aVar.g(5, this.nWa);
            }
            aVar.S(6, this.timestamp);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                h = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            h = ((h + e.a.a.a.c(2, 1, this.fBS)) + (e.a.a.b.b.a.dX(3) + 8)) + (e.a.a.b.b.a.dX(4) + 8);
            if (this.nWa != null) {
                h += e.a.a.b.b.a.h(5, this.nWa);
            }
            return h + e.a.a.a.R(6, this.timestamp);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.fBS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = com.tencent.mm.bp.a.a(aVar2); h > 0; h = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.username != null) {
                return 0;
            }
            throw new b("Not all required fields were included: username");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.username = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    aVar4.fBS.add(aVar3.AEQ.readString());
                    return 0;
                case 3:
                    aVar4.longitude = aVar3.AEQ.readDouble();
                    return 0;
                case 4:
                    aVar4.latitude = aVar3.AEQ.readDouble();
                    return 0;
                case 5:
                    aVar4.nWa = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aVar4.timestamp = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
