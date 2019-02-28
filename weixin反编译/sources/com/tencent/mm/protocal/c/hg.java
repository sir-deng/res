package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class hg extends bek {
    public int kyY;
    public int vMj;
    public int vMm;
    public bes vNQ;
    public bes vPT;
    public bes vPZ;
    public String vTA;
    public String vTB;
    public bew vTm;
    public String vTt;
    public bet vTw;
    public bes vTx;
    public int vTz;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vNQ == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.vTt != null) {
                    aVar.g(2, this.vTt);
                }
                if (this.vNQ != null) {
                    aVar.fZ(3, this.vNQ.bkL());
                    this.vNQ.a(aVar);
                }
                aVar.fX(4, this.vMm);
                aVar.fX(5, this.vTz);
                if (this.vTA != null) {
                    aVar.g(6, this.vTA);
                }
                aVar.fX(7, this.kyY);
                if (this.vTB != null) {
                    aVar.g(8, this.vTB);
                }
                if (this.vTw != null) {
                    aVar.fZ(9, this.vTw.bkL());
                    this.vTw.a(aVar);
                }
                if (this.vPZ != null) {
                    aVar.fZ(10, this.vPZ.bkL());
                    this.vPZ.a(aVar);
                }
                if (this.vTx != null) {
                    aVar.fZ(11, this.vTx.bkL());
                    this.vTx.a(aVar);
                }
                if (this.vTm != null) {
                    aVar.fZ(12, this.vTm.bkL());
                    this.vTm.a(aVar);
                }
                aVar.fX(13, this.vMj);
                if (this.vPT == null) {
                    return 0;
                }
                aVar.fZ(14, this.vPT.bkL());
                this.vPT.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vTt != null) {
                fW += e.a.a.b.b.a.h(2, this.vTt);
            }
            if (this.vNQ != null) {
                fW += e.a.a.a.fW(3, this.vNQ.bkL());
            }
            fW = (fW + e.a.a.a.fU(4, this.vMm)) + e.a.a.a.fU(5, this.vTz);
            if (this.vTA != null) {
                fW += e.a.a.b.b.a.h(6, this.vTA);
            }
            fW += e.a.a.a.fU(7, this.kyY);
            if (this.vTB != null) {
                fW += e.a.a.b.b.a.h(8, this.vTB);
            }
            if (this.vTw != null) {
                fW += e.a.a.a.fW(9, this.vTw.bkL());
            }
            if (this.vPZ != null) {
                fW += e.a.a.a.fW(10, this.vPZ.bkL());
            }
            if (this.vTx != null) {
                fW += e.a.a.a.fW(11, this.vTx.bkL());
            }
            if (this.vTm != null) {
                fW += e.a.a.a.fW(12, this.vTm.bkL());
            }
            fW += e.a.a.a.fU(13, this.vMj);
            if (this.vPT != null) {
                fW += e.a.a.a.fW(14, this.vPT.bkL());
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
            } else if (this.vNQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hg hgVar = (hg) objArr[1];
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
                        hgVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    hgVar.vTt = aVar3.AEQ.readString();
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
                        hgVar.vNQ = fiVar;
                    }
                    return 0;
                case 4:
                    hgVar.vMm = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    hgVar.vTz = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    hgVar.vTA = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    hgVar.kyY = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    hgVar.vTB = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        hgVar.vTw = fiVar;
                    }
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        hgVar.vPZ = fiVar;
                    }
                    return 0;
                case 11:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        hgVar.vTx = fiVar;
                    }
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bew();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        hgVar.vTm = fiVar;
                    }
                    return 0;
                case 13:
                    hgVar.vMj = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        hgVar.vPT = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
