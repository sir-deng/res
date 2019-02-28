package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bfz extends bek {
    public ake vSI;
    public akf vSJ;
    public String vSo;
    public asc vSp;
    public int wRQ;
    public ch wRR;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vSp == null) {
                throw new b("Not all required fields were included: Contact");
            } else if (this.vSI == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.vSJ == null) {
                throw new b("Not all required fields were included: HardDeviceAttr");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.vSp != null) {
                    aVar.fZ(2, this.vSp.bkL());
                    this.vSp.a(aVar);
                }
                if (this.vSI != null) {
                    aVar.fZ(3, this.vSI.bkL());
                    this.vSI.a(aVar);
                }
                if (this.vSJ != null) {
                    aVar.fZ(4, this.vSJ.bkL());
                    this.vSJ.a(aVar);
                }
                if (this.vSo != null) {
                    aVar.g(5, this.vSo);
                }
                aVar.fX(6, this.wRQ);
                if (this.wRR == null) {
                    return 0;
                }
                aVar.fZ(7, this.wRR.bkL());
                this.wRR.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vSp != null) {
                fW += e.a.a.a.fW(2, this.vSp.bkL());
            }
            if (this.vSI != null) {
                fW += e.a.a.a.fW(3, this.vSI.bkL());
            }
            if (this.vSJ != null) {
                fW += e.a.a.a.fW(4, this.vSJ.bkL());
            }
            if (this.vSo != null) {
                fW += e.a.a.b.b.a.h(5, this.vSo);
            }
            fW += e.a.a.a.fU(6, this.wRQ);
            if (this.wRR != null) {
                fW += e.a.a.a.fW(7, this.wRR.bkL());
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
            } else if (this.vSp == null) {
                throw new b("Not all required fields were included: Contact");
            } else if (this.vSI == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.vSJ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: HardDeviceAttr");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfz bfz = (bfz) objArr[1];
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
                        bfz.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new asc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfz.vSp = fiVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ake();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfz.vSI = fiVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new akf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfz.vSJ = fiVar;
                    }
                    return 0;
                case 5:
                    bfz.vSo = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bfz.wRQ = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ch();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfz.wRR = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
