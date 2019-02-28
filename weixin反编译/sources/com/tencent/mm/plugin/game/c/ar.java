package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ar extends a {
    public String fpg;
    public String nlr;
    public String nmT;
    public LinkedList<dl> nmU = new LinkedList();
    public ei nmV;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nmT != null) {
                aVar.g(1, this.nmT);
            }
            if (this.fpg != null) {
                aVar.g(2, this.fpg);
            }
            aVar.d(3, 8, this.nmU);
            if (this.nmV != null) {
                aVar.fZ(4, this.nmV.bkL());
                this.nmV.a(aVar);
            }
            if (this.nlr == null) {
                return 0;
            }
            aVar.g(5, this.nlr);
            return 0;
        } else if (i == 1) {
            if (this.nmT != null) {
                h = e.a.a.b.b.a.h(1, this.nmT) + 0;
            } else {
                h = 0;
            }
            if (this.fpg != null) {
                h += e.a.a.b.b.a.h(2, this.fpg);
            }
            h += e.a.a.a.c(3, 8, this.nmU);
            if (this.nmV != null) {
                h += e.a.a.a.fW(4, this.nmV.bkL());
            }
            if (this.nlr != null) {
                h += e.a.a.b.b.a.h(5, this.nlr);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nmU.clear();
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
            ar arVar = (ar) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a dlVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    arVar.nmT = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    arVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dlVar = new dl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dlVar.a(aVar4, dlVar, a.a(aVar4))) {
                        }
                        arVar.nmU.add(dlVar);
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        dlVar = new ei();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dlVar.a(aVar4, dlVar, a.a(aVar4))) {
                        }
                        arVar.nmV = dlVar;
                    }
                    return 0;
                case 5:
                    arVar.nlr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
