package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class boy extends bek {
    public int wLL;
    public String wLM;
    public bes wyI;
    public int wyJ;
    public String wyK;
    public int wyL;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wyI == null) {
                throw new b("Not all required fields were included: RetText");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.wyI != null) {
                    aVar.fZ(2, this.wyI.bkL());
                    this.wyI.a(aVar);
                }
                aVar.fX(3, this.wyJ);
                if (this.wyK != null) {
                    aVar.g(4, this.wyK);
                }
                aVar.fX(5, this.wyL);
                aVar.fX(6, this.wLL);
                if (this.wLM == null) {
                    return 0;
                }
                aVar.g(7, this.wLM);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wyI != null) {
                fW += e.a.a.a.fW(2, this.wyI.bkL());
            }
            fW += e.a.a.a.fU(3, this.wyJ);
            if (this.wyK != null) {
                fW += e.a.a.b.b.a.h(4, this.wyK);
            }
            fW = (fW + e.a.a.a.fU(5, this.wyL)) + e.a.a.a.fU(6, this.wLL);
            if (this.wLM != null) {
                fW += e.a.a.b.b.a.h(7, this.wLM);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wyI != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RetText");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            boy boy = (boy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a fiVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        boy.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        boy.wyI = fiVar;
                    }
                    return 0;
                case 3:
                    boy.wyJ = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    boy.wyK = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    boy.wyL = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    boy.wLL = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    boy.wLM = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
