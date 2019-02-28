package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.b;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.fi;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bl extends bek {
    public String nlv;
    public LinkedList<ag> noc = new LinkedList();
    public b nod;
    public boolean noe;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            aVar.d(2, 8, this.noc);
            if (this.nod != null) {
                aVar.b(3, this.nod);
            }
            aVar.am(4, this.noe);
            if (this.nlv == null) {
                return 0;
            }
            aVar.g(5, this.nlv);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.c(2, 8, this.noc);
            if (this.nod != null) {
                fW += e.a.a.a.a(3, this.nod);
            }
            fW += e.a.a.b.b.a.dX(4) + 1;
            if (this.nlv != null) {
                fW += e.a.a.b.b.a.h(5, this.nlv);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.noc.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bl blVar = (bl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            com.tencent.mm.bp.a fiVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ag();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blVar.noc.add(fiVar);
                    }
                    return 0;
                case 3:
                    blVar.nod = aVar3.cKw();
                    return 0;
                case 4:
                    blVar.noe = aVar3.cKv();
                    return 0;
                case 5:
                    blVar.nlv = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
