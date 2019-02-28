package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class av extends a {
    public e nkO;
    public String nkS;
    public String nlr;
    public LinkedList<aw> nmY = new LinkedList();

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
            aVar.d(3, 8, this.nmY);
            if (this.nlr == null) {
                return 0;
            }
            aVar.g(4, this.nlr);
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
            fW += e.a.a.a.c(3, 8, this.nmY);
            if (this.nlr != null) {
                fW += e.a.a.b.b.a.h(4, this.nlr);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nmY.clear();
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
            av avVar = (av) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a eVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        avVar.nkO = eVar;
                    }
                    return 0;
                case 2:
                    avVar.nkS = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        eVar = new aw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        avVar.nmY.add(eVar);
                    }
                    return 0;
                case 4:
                    avVar.nlr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
