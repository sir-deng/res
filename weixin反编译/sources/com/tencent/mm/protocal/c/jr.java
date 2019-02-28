package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class jr extends a {
    public int kzz;
    public jl vWJ;
    public jk vWK;
    public long vWL;
    public jq vWM;
    public jt vWN;
    public jp vWO;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.kzz);
            if (this.vWJ != null) {
                aVar.fZ(2, this.vWJ.bkL());
                this.vWJ.a(aVar);
            }
            if (this.vWK != null) {
                aVar.fZ(3, this.vWK.bkL());
                this.vWK.a(aVar);
            }
            aVar.S(4, this.vWL);
            if (this.vWM != null) {
                aVar.fZ(5, this.vWM.bkL());
                this.vWM.a(aVar);
            }
            if (this.vWN != null) {
                aVar.fZ(6, this.vWN.bkL());
                this.vWN.a(aVar);
            }
            if (this.vWO != null) {
                aVar.fZ(7, this.vWO.bkL());
                this.vWO.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.kzz) + 0;
            if (this.vWJ != null) {
                fU += e.a.a.a.fW(2, this.vWJ.bkL());
            }
            if (this.vWK != null) {
                fU += e.a.a.a.fW(3, this.vWK.bkL());
            }
            fU += e.a.a.a.R(4, this.vWL);
            if (this.vWM != null) {
                fU += e.a.a.a.fW(5, this.vWM.bkL());
            }
            if (this.vWN != null) {
                fU += e.a.a.a.fW(6, this.vWN.bkL());
            }
            if (this.vWO != null) {
                return fU + e.a.a.a.fW(7, this.vWO.bkL());
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jr jrVar = (jr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a jlVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jrVar.kzz = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jlVar = new jl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jlVar.a(aVar4, jlVar, a.a(aVar4))) {
                        }
                        jrVar.vWJ = jlVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jlVar = new jk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jlVar.a(aVar4, jlVar, a.a(aVar4))) {
                        }
                        jrVar.vWK = jlVar;
                    }
                    return 0;
                case 4:
                    jrVar.vWL = aVar3.AEQ.rA();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jlVar = new jq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jlVar.a(aVar4, jlVar, a.a(aVar4))) {
                        }
                        jrVar.vWM = jlVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jlVar = new jt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jlVar.a(aVar4, jlVar, a.a(aVar4))) {
                        }
                        jrVar.vWN = jlVar;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        jlVar = new jp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jlVar.a(aVar4, jlVar, a.a(aVar4))) {
                        }
                        jrVar.vWO = jlVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
