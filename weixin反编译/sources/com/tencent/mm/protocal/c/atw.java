package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class atw extends a {
    public int kyY;
    public int vQL;
    public int vWu;
    public bes vYE;
    public ou vYH;
    public int wIH;
    public int wII;

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
                aVar.fX(3, this.vWu);
                if (this.vYE != null) {
                    aVar.fZ(4, this.vYE.bkL());
                    this.vYE.a(aVar);
                }
                aVar.fX(5, this.kyY);
                aVar.fX(6, this.wIH);
                aVar.fX(7, this.wII);
                return 0;
            }
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vQL) + 0;
            if (this.vYH != null) {
                fU += e.a.a.a.fW(2, this.vYH.bkL());
            }
            fU += e.a.a.a.fU(3, this.vWu);
            if (this.vYE != null) {
                fU += e.a.a.a.fW(4, this.vYE.bkL());
            }
            return ((fU + e.a.a.a.fU(5, this.kyY)) + e.a.a.a.fU(6, this.wIH)) + e.a.a.a.fU(7, this.wII);
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
            atw atw = (atw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a ouVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    atw.vQL = aVar3.AEQ.rz();
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
                        atw.vYH = ouVar;
                    }
                    return 0;
                case 3:
                    atw.vWu = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ouVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ouVar.a(aVar4, ouVar, a.a(aVar4))) {
                        }
                        atw.vYE = ouVar;
                    }
                    return 0;
                case 5:
                    atw.kyY = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    atw.wIH = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    atw.wII = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
