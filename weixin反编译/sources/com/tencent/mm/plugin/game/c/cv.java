package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cv extends a {
    public LinkedList<b> npb = new LinkedList();
    public di npc;
    public LinkedList<n> npd = new LinkedList();
    public db npe;
    public LinkedList<dv> npf = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.npb);
            if (this.npc != null) {
                aVar.fZ(2, this.npc.bkL());
                this.npc.a(aVar);
            }
            aVar.d(3, 8, this.npd);
            if (this.npe != null) {
                aVar.fZ(4, this.npe.bkL());
                this.npe.a(aVar);
            }
            aVar.d(5, 8, this.npf);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.npb) + 0;
            if (this.npc != null) {
                c += e.a.a.a.fW(2, this.npc.bkL());
            }
            c += e.a.a.a.c(3, 8, this.npd);
            if (this.npe != null) {
                c += e.a.a.a.fW(4, this.npe.bkL());
            }
            return c + e.a.a.a.c(5, 8, this.npf);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.npb.clear();
            this.npd.clear();
            this.npf.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cv cvVar = (cv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a bVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bVar = new b();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cvVar.npb.add(bVar);
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bVar = new di();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cvVar.npc = bVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bVar = new n();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cvVar.npd.add(bVar);
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bVar = new db();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cvVar.npe = bVar;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bVar = new dv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cvVar.npf.add(bVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
