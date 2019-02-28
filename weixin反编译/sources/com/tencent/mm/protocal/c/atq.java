package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class atq extends bek {
    public int vLk;
    public int vWu;
    public bes wIa;
    public bes wIb;
    public int wIc;
    public int wId;
    public LinkedList<ot> wIe = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wIa == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.wIb == null) {
                throw new b("Not all required fields were included: MaxSynckey");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.wIa != null) {
                    aVar.fZ(2, this.wIa.bkL());
                    this.wIa.a(aVar);
                }
                if (this.wIb != null) {
                    aVar.fZ(3, this.wIb.bkL());
                    this.wIb.a(aVar);
                }
                aVar.fX(4, this.vWu);
                aVar.fX(5, this.wIc);
                aVar.fX(6, this.wId);
                aVar.d(7, 8, this.wIe);
                aVar.fX(8, this.vLk);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wIa != null) {
                fW += e.a.a.a.fW(2, this.wIa.bkL());
            }
            if (this.wIb != null) {
                fW += e.a.a.a.fW(3, this.wIb.bkL());
            }
            return ((((fW + e.a.a.a.fU(4, this.vWu)) + e.a.a.a.fU(5, this.wIc)) + e.a.a.a.fU(6, this.wId)) + e.a.a.a.c(7, 8, this.wIe)) + e.a.a.a.fU(8, this.vLk);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wIe.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wIa == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.wIb != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MaxSynckey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atq atq = (atq) objArr[1];
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
                        atq.wRa = fiVar;
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
                        atq.wIa = fiVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        atq.wIb = fiVar;
                    }
                    return 0;
                case 4:
                    atq.vWu = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    atq.wIc = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    atq.wId = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ot();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        atq.wIe.add(fiVar);
                    }
                    return 0;
                case 8:
                    atq.vLk = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
