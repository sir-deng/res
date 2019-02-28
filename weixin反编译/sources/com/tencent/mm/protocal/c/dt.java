package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class dt extends a {
    public String fpg;
    public String nkW;
    public String vPE;
    public String vPF;
    public du vPG;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPG == null) {
                throw new b("Not all required fields were included: ArtisIcon");
            }
            if (this.nkW != null) {
                aVar.g(1, this.nkW);
            }
            if (this.fpg != null) {
                aVar.g(2, this.fpg);
            }
            if (this.vPE != null) {
                aVar.g(3, this.vPE);
            }
            if (this.vPF != null) {
                aVar.g(4, this.vPF);
            }
            if (this.vPG == null) {
                return 0;
            }
            aVar.fZ(5, this.vPG.bkL());
            this.vPG.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.nkW != null) {
                h = e.a.a.b.b.a.h(1, this.nkW) + 0;
            } else {
                h = 0;
            }
            if (this.fpg != null) {
                h += e.a.a.b.b.a.h(2, this.fpg);
            }
            if (this.vPE != null) {
                h += e.a.a.b.b.a.h(3, this.vPE);
            }
            if (this.vPF != null) {
                h += e.a.a.b.b.a.h(4, this.vPF);
            }
            if (this.vPG != null) {
                h += e.a.a.a.fW(5, this.vPG.bkL());
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.vPG != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ArtisIcon");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dt dtVar = (dt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dtVar.nkW = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    dtVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    dtVar.vPE = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    dtVar.vPF = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a duVar = new du();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = duVar.a(aVar4, duVar, a.a(aVar4))) {
                        }
                        dtVar.vPG = duVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
