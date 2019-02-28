package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ak extends a {
    public String nlr;
    public String nlv;
    public String nmA;
    public String nmB;
    public LinkedList<do> nmz = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlv != null) {
                aVar.g(1, this.nlv);
            }
            aVar.d(2, 8, this.nmz);
            if (this.nmA != null) {
                aVar.g(3, this.nmA);
            }
            if (this.nmB != null) {
                aVar.g(4, this.nmB);
            }
            if (this.nlr == null) {
                return 0;
            }
            aVar.g(5, this.nlr);
            return 0;
        } else if (i == 1) {
            if (this.nlv != null) {
                h = e.a.a.b.b.a.h(1, this.nlv) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.c(2, 8, this.nmz);
            if (this.nmA != null) {
                h += e.a.a.b.b.a.h(3, this.nmA);
            }
            if (this.nmB != null) {
                h += e.a.a.b.b.a.h(4, this.nmB);
            }
            if (this.nlr != null) {
                h += e.a.a.b.b.a.h(5, this.nlr);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nmz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ak akVar = (ak) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    akVar.nlv = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a doVar = new do();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = doVar.a(aVar4, doVar, a.a(aVar4))) {
                        }
                        akVar.nmz.add(doVar);
                    }
                    return 0;
                case 3:
                    akVar.nmA = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    akVar.nmB = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    akVar.nlr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
