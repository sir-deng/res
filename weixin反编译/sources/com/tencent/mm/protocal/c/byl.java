package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class byl extends a {
    public bes vNQ;
    public String vTt;
    public bes vTx;
    public String xfF;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vTx == null) {
                throw new b("Not all required fields were included: KSid");
            } else if (this.vNQ == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.xfF != null) {
                    aVar.g(1, this.xfF);
                }
                if (this.vTx != null) {
                    aVar.fZ(2, this.vTx.bkL());
                    this.vTx.a(aVar);
                }
                if (this.vTt != null) {
                    aVar.g(3, this.vTt);
                }
                if (this.vNQ == null) {
                    return 0;
                }
                aVar.fZ(4, this.vNQ.bkL());
                this.vNQ.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.xfF != null) {
                h = e.a.a.b.b.a.h(1, this.xfF) + 0;
            } else {
                h = 0;
            }
            if (this.vTx != null) {
                h += e.a.a.a.fW(2, this.vTx.bkL());
            }
            if (this.vTt != null) {
                h += e.a.a.b.b.a.h(3, this.vTt);
            }
            if (this.vNQ != null) {
                h += e.a.a.a.fW(4, this.vNQ.bkL());
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.vTx == null) {
                throw new b("Not all required fields were included: KSid");
            } else if (this.vNQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byl byl = (byl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bes;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    byl.xfF = aVar3.AEQ.readString();
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
                        byl.vTx = bes;
                    }
                    return 0;
                case 3:
                    byl.vTt = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        byl.vNQ = bes;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
