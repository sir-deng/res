package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.fi;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bh extends bek {
    public e nkO;
    public LinkedList<x> nnA = new LinkedList();
    public ct nnB;
    public ce nnC;
    public cb nnD;
    public dm nnE;
    public LinkedList<y> nnF = new LinkedList();
    public dt nnG;
    public cd nnH;
    public ca nnI;
    public String nnz;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.nkO == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.nnz == null) {
                throw new b("Not all required fields were included: BackGroundURL");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.nkO != null) {
                    aVar.fZ(2, this.nkO.bkL());
                    this.nkO.a(aVar);
                }
                if (this.nnz != null) {
                    aVar.g(3, this.nnz);
                }
                aVar.d(4, 8, this.nnA);
                if (this.nnB != null) {
                    aVar.fZ(5, this.nnB.bkL());
                    this.nnB.a(aVar);
                }
                if (this.nnC != null) {
                    aVar.fZ(7, this.nnC.bkL());
                    this.nnC.a(aVar);
                }
                if (this.nnD != null) {
                    aVar.fZ(8, this.nnD.bkL());
                    this.nnD.a(aVar);
                }
                if (this.nnE != null) {
                    aVar.fZ(9, this.nnE.bkL());
                    this.nnE.a(aVar);
                }
                aVar.d(10, 8, this.nnF);
                if (this.nnG != null) {
                    aVar.fZ(11, this.nnG.bkL());
                    this.nnG.a(aVar);
                }
                if (this.nnH != null) {
                    aVar.fZ(12, this.nnH.bkL());
                    this.nnH.a(aVar);
                }
                if (this.nnI == null) {
                    return 0;
                }
                aVar.fZ(13, this.nnI.bkL());
                this.nnI.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.nkO != null) {
                fW += e.a.a.a.fW(2, this.nkO.bkL());
            }
            if (this.nnz != null) {
                fW += e.a.a.b.b.a.h(3, this.nnz);
            }
            fW += e.a.a.a.c(4, 8, this.nnA);
            if (this.nnB != null) {
                fW += e.a.a.a.fW(5, this.nnB.bkL());
            }
            if (this.nnC != null) {
                fW += e.a.a.a.fW(7, this.nnC.bkL());
            }
            if (this.nnD != null) {
                fW += e.a.a.a.fW(8, this.nnD.bkL());
            }
            if (this.nnE != null) {
                fW += e.a.a.a.fW(9, this.nnE.bkL());
            }
            fW += e.a.a.a.c(10, 8, this.nnF);
            if (this.nnG != null) {
                fW += e.a.a.a.fW(11, this.nnG.bkL());
            }
            if (this.nnH != null) {
                fW += e.a.a.a.fW(12, this.nnH.bkL());
            }
            if (this.nnI != null) {
                fW += e.a.a.a.fW(13, this.nnI.bkL());
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nnA.clear();
            this.nnF.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.nkO == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.nnz != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BackGroundURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bh bhVar = (bh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
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
                        bhVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bhVar.nkO = fiVar;
                    }
                    return 0;
                case 3:
                    bhVar.nnz = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new x();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bhVar.nnA.add(fiVar);
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ct();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bhVar.nnB = fiVar;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ce();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bhVar.nnC = fiVar;
                    }
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new cb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bhVar.nnD = fiVar;
                    }
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new dm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bhVar.nnE = fiVar;
                    }
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new y();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bhVar.nnF.add(fiVar);
                    }
                    return 0;
                case 11:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new dt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bhVar.nnG = fiVar;
                    }
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new cd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bhVar.nnH = fiVar;
                    }
                    return 0;
                case 13:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ca();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bhVar.nnI = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
