package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class btu extends bek {
    public bes vNQ;
    public bes vPT;
    public String vPY;
    public bes vPZ;
    public bet vTw;
    public bes vTx;
    public String wgO;
    public bet wwh;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wwh == null) {
                throw new b("Not all required fields were included: ImgSid");
            } else if (this.vNQ == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.wwh != null) {
                    aVar.fZ(2, this.wwh.bkL());
                    this.wwh.a(aVar);
                }
                if (this.vNQ != null) {
                    aVar.fZ(3, this.vNQ.bkL());
                    this.vNQ.a(aVar);
                }
                if (this.wgO != null) {
                    aVar.g(4, this.wgO);
                }
                if (this.vTw != null) {
                    aVar.fZ(5, this.vTw.bkL());
                    this.vTw.a(aVar);
                }
                if (this.vPZ != null) {
                    aVar.fZ(6, this.vPZ.bkL());
                    this.vPZ.a(aVar);
                }
                if (this.vTx != null) {
                    aVar.fZ(7, this.vTx.bkL());
                    this.vTx.a(aVar);
                }
                if (this.vPY != null) {
                    aVar.g(8, this.vPY);
                }
                if (this.vPT == null) {
                    return 0;
                }
                aVar.fZ(9, this.vPT.bkL());
                this.vPT.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wwh != null) {
                fW += e.a.a.a.fW(2, this.wwh.bkL());
            }
            if (this.vNQ != null) {
                fW += e.a.a.a.fW(3, this.vNQ.bkL());
            }
            if (this.wgO != null) {
                fW += e.a.a.b.b.a.h(4, this.wgO);
            }
            if (this.vTw != null) {
                fW += e.a.a.a.fW(5, this.vTw.bkL());
            }
            if (this.vPZ != null) {
                fW += e.a.a.a.fW(6, this.vPZ.bkL());
            }
            if (this.vTx != null) {
                fW += e.a.a.a.fW(7, this.vTx.bkL());
            }
            if (this.vPY != null) {
                fW += e.a.a.b.b.a.h(8, this.vPY);
            }
            if (this.vPT != null) {
                fW += e.a.a.a.fW(9, this.vPT.bkL());
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
            } else if (this.wwh == null) {
                throw new b("Not all required fields were included: ImgSid");
            } else if (this.vNQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btu btu = (btu) objArr[1];
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
                        btu.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        btu.wwh = fiVar;
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
                        btu.vNQ = fiVar;
                    }
                    return 0;
                case 4:
                    btu.wgO = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        btu.vTw = fiVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        btu.vPZ = fiVar;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        btu.vTx = fiVar;
                    }
                    return 0;
                case 8:
                    btu.vPY = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        btu.vPT = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
