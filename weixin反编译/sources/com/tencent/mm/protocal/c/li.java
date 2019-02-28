package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class li extends bek {
    public int pQV;
    public String pQW;
    public String pQX;
    public String sQD;
    public String url;
    public LinkedList<arm> waP = new LinkedList();
    public arm waQ;
    public String waR;
    public boolean waS;
    public String waT;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.url == null) {
                throw new b("Not all required fields were included: url");
            } else if (this.waQ == null) {
                throw new b("Not all required fields were included: bottom_item");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.url != null) {
                    aVar.g(2, this.url);
                }
                aVar.d(3, 8, this.waP);
                if (this.waQ != null) {
                    aVar.fZ(4, this.waQ.bkL());
                    this.waQ.a(aVar);
                }
                if (this.sQD != null) {
                    aVar.g(5, this.sQD);
                }
                if (this.waR != null) {
                    aVar.g(6, this.waR);
                }
                aVar.am(7, this.waS);
                aVar.fX(8, this.pQV);
                if (this.waT != null) {
                    aVar.g(9, this.waT);
                }
                if (this.pQW != null) {
                    aVar.g(10, this.pQW);
                }
                if (this.pQX == null) {
                    return 0;
                }
                aVar.g(11, this.pQX);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.url != null) {
                fW += e.a.a.b.b.a.h(2, this.url);
            }
            fW += e.a.a.a.c(3, 8, this.waP);
            if (this.waQ != null) {
                fW += e.a.a.a.fW(4, this.waQ.bkL());
            }
            if (this.sQD != null) {
                fW += e.a.a.b.b.a.h(5, this.sQD);
            }
            if (this.waR != null) {
                fW += e.a.a.b.b.a.h(6, this.waR);
            }
            fW = (fW + (e.a.a.b.b.a.dX(7) + 1)) + e.a.a.a.fU(8, this.pQV);
            if (this.waT != null) {
                fW += e.a.a.b.b.a.h(9, this.waT);
            }
            if (this.pQW != null) {
                fW += e.a.a.b.b.a.h(10, this.pQW);
            }
            if (this.pQX != null) {
                fW += e.a.a.b.b.a.h(11, this.pQX);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.waP.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.url == null) {
                throw new b("Not all required fields were included: url");
            } else if (this.waQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: bottom_item");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            li liVar = (li) objArr[1];
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
                        liVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    liVar.url = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new arm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        liVar.waP.add(fiVar);
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new arm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        liVar.waQ = fiVar;
                    }
                    return 0;
                case 5:
                    liVar.sQD = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    liVar.waR = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    liVar.waS = aVar3.cKv();
                    return 0;
                case 8:
                    liVar.pQV = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    liVar.waT = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    liVar.pQW = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    liVar.pQX = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
