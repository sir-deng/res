package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bvr extends a {
    public String npW;
    public int wet;
    public bes weu;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.weu == null) {
                throw new b("Not all required fields were included: CmdBuf");
            }
            aVar.fX(1, this.wet);
            if (this.weu != null) {
                aVar.fZ(2, this.weu.bkL());
                this.weu.a(aVar);
            }
            if (this.npW != null) {
                aVar.g(3, this.npW);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wet) + 0;
            if (this.weu != null) {
                fU += e.a.a.a.fW(2, this.weu.bkL());
            }
            if (this.npW != null) {
                return fU + e.a.a.b.b.a.h(3, this.npW);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.weu != null) {
                return 0;
            }
            throw new b("Not all required fields were included: CmdBuf");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvr bvr = (bvr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bvr.wet = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bes = new bes();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        bvr.weu = bes;
                    }
                    return 0;
                case 3:
                    bvr.npW = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
