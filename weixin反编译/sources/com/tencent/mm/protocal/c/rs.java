package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class rs extends bek {
    public String kyG;
    public String nlV;
    public int vPs;
    public int vPt;
    public int vPu;
    public bes weD;
    public String wgu;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.weD == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.nlV != null) {
                    aVar.g(2, this.nlV);
                }
                if (this.wgu != null) {
                    aVar.g(3, this.wgu);
                }
                if (this.kyG != null) {
                    aVar.g(4, this.kyG);
                }
                aVar.fX(5, this.vPs);
                aVar.fX(6, this.vPt);
                aVar.fX(7, this.vPu);
                if (this.weD == null) {
                    return 0;
                }
                aVar.fZ(8, this.weD.bkL());
                this.weD.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.nlV != null) {
                fW += e.a.a.b.b.a.h(2, this.nlV);
            }
            if (this.wgu != null) {
                fW += e.a.a.b.b.a.h(3, this.wgu);
            }
            if (this.kyG != null) {
                fW += e.a.a.b.b.a.h(4, this.kyG);
            }
            fW = ((fW + e.a.a.a.fU(5, this.vPs)) + e.a.a.a.fU(6, this.vPt)) + e.a.a.a.fU(7, this.vPu);
            if (this.weD != null) {
                fW += e.a.a.a.fW(8, this.weD.bkL());
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
            } else if (this.weD != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rs rsVar = (rs) objArr[1];
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
                        rsVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    rsVar.nlV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    rsVar.wgu = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    rsVar.kyG = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    rsVar.vPs = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    rsVar.vPt = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    rsVar.vPu = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        rsVar.weD = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
