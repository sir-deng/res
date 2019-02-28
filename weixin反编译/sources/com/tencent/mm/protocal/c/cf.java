package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cf extends a {
    public bkj vOe;
    public bet vOf;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vOe == null) {
                throw new b("Not all required fields were included: SnsADObject");
            }
            if (this.vOe != null) {
                aVar.fZ(1, this.vOe.bkL());
                this.vOe.a(aVar);
            }
            if (this.vOf == null) {
                return 0;
            }
            aVar.fZ(2, this.vOf.bkL());
            this.vOf.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vOe != null) {
                fW = e.a.a.a.fW(1, this.vOe.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vOf != null) {
                fW += e.a.a.a.fW(2, this.vOf.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vOe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SnsADObject");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cf cfVar = (cf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bkj;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bkj = new bkj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkj.a(aVar4, bkj, a.a(aVar4))) {
                        }
                        cfVar.vOe = bkj;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bkj = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkj.a(aVar4, bkj, a.a(aVar4))) {
                        }
                        cfVar.vOf = bkj;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
