package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class alq extends a {
    public bes vNQ;
    public bet wzC;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNQ == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.wzC == null) {
                throw new b("Not all required fields were included: Username");
            } else {
                if (this.vNQ != null) {
                    aVar.fZ(1, this.vNQ.bkL());
                    this.vNQ.a(aVar);
                }
                if (this.wzC == null) {
                    return 0;
                }
                aVar.fZ(2, this.wzC.bkL());
                this.wzC.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.vNQ != null) {
                fW = e.a.a.a.fW(1, this.vNQ.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wzC != null) {
                fW += e.a.a.a.fW(2, this.wzC.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vNQ == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.wzC != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Username");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            alq alq = (alq) objArr[1];
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
                        alq.vNQ = bes;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        alq.wzC = bes;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
