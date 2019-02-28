package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class vv extends a implements bkb {
    public int vQL;
    public int vWu;
    public bes vYE;
    public ou vYH;

    public final int getRet() {
        return this.vQL;
    }

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vYH == null) {
                throw new b("Not all required fields were included: CmdList");
            } else if (this.vYE == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else {
                aVar.fX(1, this.vQL);
                if (this.vYH != null) {
                    aVar.fZ(2, this.vYH.bkL());
                    this.vYH.a(aVar);
                }
                if (this.vYE != null) {
                    aVar.fZ(3, this.vYE.bkL());
                    this.vYE.a(aVar);
                }
                aVar.fX(4, this.vWu);
                return 0;
            }
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vQL) + 0;
            if (this.vYH != null) {
                fU += e.a.a.a.fW(2, this.vYH.bkL());
            }
            if (this.vYE != null) {
                fU += e.a.a.a.fW(3, this.vYE.bkL());
            }
            return fU + e.a.a.a.fU(4, this.vWu);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.vYH == null) {
                throw new b("Not all required fields were included: CmdList");
            } else if (this.vYE != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            vv vvVar = (vv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a ouVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    vvVar.vQL = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ouVar = new ou();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ouVar.a(aVar4, ouVar, a.a(aVar4))) {
                        }
                        vvVar.vYH = ouVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ouVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ouVar.a(aVar4, ouVar, a.a(aVar4))) {
                        }
                        vvVar.vYE = ouVar;
                    }
                    return 0;
                case 4:
                    vvVar.vWu = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
