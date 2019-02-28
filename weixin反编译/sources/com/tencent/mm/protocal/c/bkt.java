package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bkt extends bek {
    public String vPF;
    public LinkedList<blf> vSf = new LinkedList();
    public int wGO;
    public String wUA;
    public int wUE;
    public int wUF;
    public blw wUG;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wUG == null) {
                throw new b("Not all required fields were included: ServerConfig");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.wUA != null) {
                    aVar.g(2, this.wUA);
                }
                aVar.fX(3, this.wGO);
                aVar.d(4, 8, this.vSf);
                aVar.fX(5, this.wUE);
                if (this.vPF != null) {
                    aVar.g(6, this.vPF);
                }
                aVar.fX(7, this.wUF);
                if (this.wUG == null) {
                    return 0;
                }
                aVar.fZ(8, this.wUG.bkL());
                this.wUG.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wUA != null) {
                fW += e.a.a.b.b.a.h(2, this.wUA);
            }
            fW = ((fW + e.a.a.a.fU(3, this.wGO)) + e.a.a.a.c(4, 8, this.vSf)) + e.a.a.a.fU(5, this.wUE);
            if (this.vPF != null) {
                fW += e.a.a.b.b.a.h(6, this.vPF);
            }
            fW += e.a.a.a.fU(7, this.wUF);
            if (this.wUG != null) {
                fW += e.a.a.a.fW(8, this.wUG.bkL());
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vSf.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wUG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ServerConfig");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkt bkt = (bkt) objArr[1];
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
                        bkt.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    bkt.wUA = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bkt.wGO = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new blf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bkt.vSf.add(fiVar);
                    }
                    return 0;
                case 5:
                    bkt.wUE = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bkt.vPF = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bkt.wUF = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new blw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bkt.wUG = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
