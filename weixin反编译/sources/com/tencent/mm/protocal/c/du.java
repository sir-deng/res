package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class du extends a {
    public are vPH;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPH == null) {
                throw new b("Not all required fields were included: MediaObj");
            } else if (this.vPH == null) {
                return 0;
            } else {
                aVar.fZ(1, this.vPH.bkL());
                this.vPH.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.vPH != null) {
                fW = e.a.a.a.fW(1, this.vPH.bkL()) + 0;
            } else {
                fW = 0;
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vPH != null) {
                return 0;
            }
            throw new b("Not all required fields were included: MediaObj");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            du duVar = (du) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a are = new are();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = are.a(aVar4, are, a.a(aVar4))) {
                        }
                        duVar.vPH = are;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
