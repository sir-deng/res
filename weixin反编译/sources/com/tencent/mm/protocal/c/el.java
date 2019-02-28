package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class el extends a {
    public bes vQw;
    public sc vQx;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQw == null) {
                throw new b("Not all required fields were included: AesEncryptKey");
            }
            if (this.vQw != null) {
                aVar.fZ(2, this.vQw.bkL());
                this.vQw.a(aVar);
            }
            if (this.vQx == null) {
                return 0;
            }
            aVar.fZ(3, this.vQx.bkL());
            this.vQx.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vQw != null) {
                fW = e.a.a.a.fW(2, this.vQw.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vQx != null) {
                fW += e.a.a.a.fW(3, this.vQx.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vQw != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AesEncryptKey");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            el elVar = (el) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bes;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        elVar.vQw = bes;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new sc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        elVar.vQx = bes;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
