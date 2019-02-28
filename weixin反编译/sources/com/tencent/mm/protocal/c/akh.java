package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class akh extends bek {
    public bes vPQ;
    public bes wyh;
    public bes wyi;
    public int wyj;
    public int wyk;
    public int wyl;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vPQ == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.wyh == null) {
                throw new b("Not all required fields were included: SessionBuffer");
            } else if (this.wyi == null) {
                throw new b("Not all required fields were included: KeyBuffer");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.vPQ != null) {
                    aVar.fZ(2, this.vPQ.bkL());
                    this.vPQ.a(aVar);
                }
                if (this.wyh != null) {
                    aVar.fZ(3, this.wyh.bkL());
                    this.wyh.a(aVar);
                }
                if (this.wyi != null) {
                    aVar.fZ(4, this.wyi.bkL());
                    this.wyi.a(aVar);
                }
                aVar.fX(5, this.wyj);
                aVar.fX(6, this.wyk);
                aVar.fX(7, this.wyl);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vPQ != null) {
                fW += e.a.a.a.fW(2, this.vPQ.bkL());
            }
            if (this.wyh != null) {
                fW += e.a.a.a.fW(3, this.wyh.bkL());
            }
            if (this.wyi != null) {
                fW += e.a.a.a.fW(4, this.wyi.bkL());
            }
            return ((fW + e.a.a.a.fU(5, this.wyj)) + e.a.a.a.fU(6, this.wyk)) + e.a.a.a.fU(7, this.wyl);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vPQ == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.wyh == null) {
                throw new b("Not all required fields were included: SessionBuffer");
            } else if (this.wyi != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuffer");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            akh akh = (akh) objArr[1];
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
                        akh.wRa = fiVar;
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
                        akh.vPQ = fiVar;
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
                        akh.wyh = fiVar;
                    }
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
                        akh.wyi = fiVar;
                    }
                    return 0;
                case 5:
                    akh.wyj = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    akh.wyk = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    akh.wyl = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
