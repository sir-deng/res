package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ej extends a {
    public bes vQs;
    public bes vQt;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQs == null) {
                throw new b("Not all required fields were included: EncryptKey");
            } else if (this.vQt == null) {
                throw new b("Not all required fields were included: Key");
            } else {
                if (this.vQs != null) {
                    aVar.fZ(1, this.vQs.bkL());
                    this.vQs.a(aVar);
                }
                if (this.vQt == null) {
                    return 0;
                }
                aVar.fZ(2, this.vQt.bkL());
                this.vQt.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.vQs != null) {
                fW = e.a.a.a.fW(1, this.vQs.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vQt != null) {
                fW += e.a.a.a.fW(2, this.vQt.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vQs == null) {
                throw new b("Not all required fields were included: EncryptKey");
            } else if (this.vQt != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Key");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ej ejVar = (ej) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bes;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        ejVar.vQs = bes;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        ejVar.vQt = bes;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
