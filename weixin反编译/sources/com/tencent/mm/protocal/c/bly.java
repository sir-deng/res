package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bly extends bek {
    public int vWu;
    public bes vYE;
    public ou vYH;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vYH == null) {
                throw new b("Not all required fields were included: CmdList");
            } else if (this.vYE == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.vYH != null) {
                    aVar.fZ(2, this.vYH.bkL());
                    this.vYH.a(aVar);
                }
                aVar.fX(3, this.vWu);
                if (this.vYE == null) {
                    return 0;
                }
                aVar.fZ(4, this.vYE.bkL());
                this.vYE.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vYH != null) {
                fW += e.a.a.a.fW(2, this.vYH.bkL());
            }
            fW += e.a.a.a.fU(3, this.vWu);
            if (this.vYE != null) {
                fW += e.a.a.a.fW(4, this.vYE.bkL());
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
            } else if (this.vYH == null) {
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
            bly bly = (bly) objArr[1];
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
                        bly.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ou();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bly.vYH = fiVar;
                    }
                    return 0;
                case 3:
                    bly.vWu = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bly.vYE = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
