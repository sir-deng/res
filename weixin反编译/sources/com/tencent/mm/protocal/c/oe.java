package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class oe extends bek {
    public int kyY;
    public bur wdI;
    public bsq wdJ;
    public bbd wdK;
    public int wdL;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wdI == null) {
                throw new b("Not all required fields were included: TransRes");
            } else if (this.wdJ == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.wdK == null) {
                throw new b("Not all required fields were included: QueryCtx");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                aVar.fX(2, this.kyY);
                if (this.wdI != null) {
                    aVar.fZ(3, this.wdI.bkL());
                    this.wdI.a(aVar);
                }
                if (this.wdJ != null) {
                    aVar.fZ(4, this.wdJ.bkL());
                    this.wdJ.a(aVar);
                }
                if (this.wdK != null) {
                    aVar.fZ(5, this.wdK.bkL());
                    this.wdK.a(aVar);
                }
                aVar.fX(6, this.wdL);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.kyY);
            if (this.wdI != null) {
                fW += e.a.a.a.fW(3, this.wdI.bkL());
            }
            if (this.wdJ != null) {
                fW += e.a.a.a.fW(4, this.wdJ.bkL());
            }
            if (this.wdK != null) {
                fW += e.a.a.a.fW(5, this.wdK.bkL());
            }
            return fW + e.a.a.a.fU(6, this.wdL);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wdI == null) {
                throw new b("Not all required fields were included: TransRes");
            } else if (this.wdJ == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.wdK != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: QueryCtx");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            oe oeVar = (oe) objArr[1];
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
                        oeVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    oeVar.kyY = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bur();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        oeVar.wdI = fiVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bsq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        oeVar.wdJ = fiVar;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bbd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        oeVar.wdK = fiVar;
                    }
                    return 0;
                case 6:
                    oeVar.wdL = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
