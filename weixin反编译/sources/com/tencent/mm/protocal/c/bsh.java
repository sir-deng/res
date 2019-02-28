package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bsh extends bek {
    public int pgR;
    public int vNL;
    public bet vNM;
    public bet vNN;
    public long vNT;
    public int vPs;
    public int vPt;
    public int vPu;
    public String vXE;
    public String vXI;
    public bet xaa;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.xaa == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.vNM == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vNN == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                aVar.fX(2, this.vNL);
                if (this.xaa != null) {
                    aVar.fZ(3, this.xaa.bkL());
                    this.xaa.a(aVar);
                }
                if (this.vNM != null) {
                    aVar.fZ(4, this.vNM.bkL());
                    this.vNM.a(aVar);
                }
                if (this.vNN != null) {
                    aVar.fZ(5, this.vNN.bkL());
                    this.vNN.a(aVar);
                }
                aVar.fX(6, this.vPs);
                aVar.fX(7, this.vPt);
                aVar.fX(8, this.vPu);
                aVar.fX(9, this.pgR);
                aVar.S(10, this.vNT);
                if (this.vXE != null) {
                    aVar.g(11, this.vXE);
                }
                if (this.vXI == null) {
                    return 0;
                }
                aVar.g(12, this.vXI);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.vNL);
            if (this.xaa != null) {
                fW += e.a.a.a.fW(3, this.xaa.bkL());
            }
            if (this.vNM != null) {
                fW += e.a.a.a.fW(4, this.vNM.bkL());
            }
            if (this.vNN != null) {
                fW += e.a.a.a.fW(5, this.vNN.bkL());
            }
            fW = ((((fW + e.a.a.a.fU(6, this.vPs)) + e.a.a.a.fU(7, this.vPt)) + e.a.a.a.fU(8, this.vPu)) + e.a.a.a.fU(9, this.pgR)) + e.a.a.a.R(10, this.vNT);
            if (this.vXE != null) {
                fW += e.a.a.b.b.a.h(11, this.vXE);
            }
            if (this.vXI != null) {
                fW += e.a.a.b.b.a.h(12, this.vXI);
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
            } else if (this.xaa == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.vNM == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vNN != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ToUserName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsh bsh = (bsh) objArr[1];
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
                        bsh.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    bsh.vNL = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bsh.xaa = fiVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bsh.vNM = fiVar;
                    }
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
                        bsh.vNN = fiVar;
                    }
                    return 0;
                case 6:
                    bsh.vPs = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bsh.vPt = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bsh.vPu = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bsh.pgR = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    bsh.vNT = aVar3.AEQ.rA();
                    return 0;
                case 11:
                    bsh.vXE = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    bsh.vXI = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
