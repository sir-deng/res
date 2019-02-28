package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ab extends a {
    public String nlr;
    public ei nmc;
    public ae nmd;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nmc != null) {
                aVar.fZ(1, this.nmc.bkL());
                this.nmc.a(aVar);
            }
            if (this.nmd != null) {
                aVar.fZ(2, this.nmd.bkL());
                this.nmd.a(aVar);
            }
            if (this.nlr == null) {
                return 0;
            }
            aVar.g(3, this.nlr);
            return 0;
        } else if (i == 1) {
            if (this.nmc != null) {
                fW = e.a.a.a.fW(1, this.nmc.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.nmd != null) {
                fW += e.a.a.a.fW(2, this.nmd.bkL());
            }
            if (this.nlr != null) {
                fW += e.a.a.b.b.a.h(3, this.nlr);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ab abVar = (ab) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a eiVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        eiVar = new ei();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eiVar.a(aVar4, eiVar, a.a(aVar4))) {
                        }
                        abVar.nmc = eiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        eiVar = new ae();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eiVar.a(aVar4, eiVar, a.a(aVar4))) {
                        }
                        abVar.nmd = eiVar;
                    }
                    return 0;
                case 3:
                    abVar.nlr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
