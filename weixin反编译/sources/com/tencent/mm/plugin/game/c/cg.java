package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cg extends a {
    public String nkN;
    public String nkU;
    public cu nli;
    public String noF;
    public String noG;
    public String noH;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkU != null) {
                aVar.g(1, this.nkU);
            }
            if (this.noF != null) {
                aVar.g(2, this.noF);
            }
            if (this.noG != null) {
                aVar.g(3, this.noG);
            }
            if (this.noH != null) {
                aVar.g(4, this.noH);
            }
            if (this.nli != null) {
                aVar.fZ(5, this.nli.bkL());
                this.nli.a(aVar);
            }
            if (this.nkN == null) {
                return 0;
            }
            aVar.g(6, this.nkN);
            return 0;
        } else if (i == 1) {
            if (this.nkU != null) {
                h = e.a.a.b.b.a.h(1, this.nkU) + 0;
            } else {
                h = 0;
            }
            if (this.noF != null) {
                h += e.a.a.b.b.a.h(2, this.noF);
            }
            if (this.noG != null) {
                h += e.a.a.b.b.a.h(3, this.noG);
            }
            if (this.noH != null) {
                h += e.a.a.b.b.a.h(4, this.noH);
            }
            if (this.nli != null) {
                h += e.a.a.a.fW(5, this.nli.bkL());
            }
            if (this.nkN != null) {
                h += e.a.a.b.b.a.h(6, this.nkN);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            cg cgVar = (cg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cgVar.nkU = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cgVar.noF = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cgVar.noG = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cgVar.noH = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a cuVar = new cu();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cuVar.a(aVar4, cuVar, a.a(aVar4))) {
                        }
                        cgVar.nli = cuVar;
                    }
                    return 0;
                case 6:
                    cgVar.nkN = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
