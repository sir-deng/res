package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bfr extends bek {
    public int hxe;
    public String hxf;
    public String hxg;
    public String hxh;
    public int hxi;
    public String hxj;
    public int hxk;
    public int hxl;
    public String hxm;
    public String hxn;
    public String hxo;
    public bes vNQ;
    public int wCq;
    public String wCr;
    public String wCs;
    public String wCt;
    public int wCu;
    public bmk wCw;
    public py wCx;
    public int wRE;
    public bes wRG;
    public String wRH;
    public String wRI;
    public int wRJ;
    public LinkedList<bgg> wRK = new LinkedList();
    public String wbY;
    public String wbZ;
    public bet wfA;
    public bet wfB;
    public bet wfM;
    public String woW;
    public int wrp;
    public LinkedList<bfp> wrq = new LinkedList();
    public bet wzM;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wfM == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.wzM == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.wfA == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.wfB == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.vNQ == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.wfM != null) {
                    aVar.fZ(2, this.wfM.bkL());
                    this.wfM.a(aVar);
                }
                if (this.wzM != null) {
                    aVar.fZ(3, this.wzM.bkL());
                    this.wzM.a(aVar);
                }
                if (this.wfA != null) {
                    aVar.fZ(4, this.wfA.bkL());
                    this.wfA.a(aVar);
                }
                if (this.wfB != null) {
                    aVar.fZ(5, this.wfB.bkL());
                    this.wfB.a(aVar);
                }
                aVar.fX(6, this.hxe);
                if (this.vNQ != null) {
                    aVar.fZ(7, this.vNQ.bkL());
                    this.vNQ.a(aVar);
                }
                if (this.hxf != null) {
                    aVar.g(8, this.hxf);
                }
                if (this.hxg != null) {
                    aVar.g(9, this.hxg);
                }
                if (this.hxh != null) {
                    aVar.g(10, this.hxh);
                }
                aVar.fX(11, this.hxi);
                aVar.fX(12, this.wCq);
                if (this.wCr != null) {
                    aVar.g(13, this.wCr);
                }
                if (this.wCs != null) {
                    aVar.g(14, this.wCs);
                }
                if (this.hxj != null) {
                    aVar.g(15, this.hxj);
                }
                if (this.wCt != null) {
                    aVar.g(16, this.wCt);
                }
                aVar.fX(17, this.wCu);
                aVar.fX(18, this.hxl);
                aVar.fX(19, this.hxk);
                if (this.hxm != null) {
                    aVar.g(20, this.hxm);
                }
                if (this.wCw != null) {
                    aVar.fZ(21, this.wCw.bkL());
                    this.wCw.a(aVar);
                }
                if (this.hxn != null) {
                    aVar.g(22, this.hxn);
                }
                if (this.hxo != null) {
                    aVar.g(23, this.hxo);
                }
                if (this.wCx != null) {
                    aVar.fZ(24, this.wCx.bkL());
                    this.wCx.a(aVar);
                }
                aVar.fX(25, this.wrp);
                aVar.d(26, 8, this.wrq);
                if (this.wbY != null) {
                    aVar.g(27, this.wbY);
                }
                if (this.wbZ != null) {
                    aVar.g(28, this.wbZ);
                }
                if (this.wRG != null) {
                    aVar.fZ(29, this.wRG.bkL());
                    this.wRG.a(aVar);
                }
                if (this.woW != null) {
                    aVar.g(30, this.woW);
                }
                if (this.wRH != null) {
                    aVar.g(31, this.wRH);
                }
                aVar.fX(32, this.wRE);
                if (this.wRI != null) {
                    aVar.g(33, this.wRI);
                }
                aVar.fX(34, this.wRJ);
                aVar.d(35, 8, this.wRK);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wfM != null) {
                fW += e.a.a.a.fW(2, this.wfM.bkL());
            }
            if (this.wzM != null) {
                fW += e.a.a.a.fW(3, this.wzM.bkL());
            }
            if (this.wfA != null) {
                fW += e.a.a.a.fW(4, this.wfA.bkL());
            }
            if (this.wfB != null) {
                fW += e.a.a.a.fW(5, this.wfB.bkL());
            }
            fW += e.a.a.a.fU(6, this.hxe);
            if (this.vNQ != null) {
                fW += e.a.a.a.fW(7, this.vNQ.bkL());
            }
            if (this.hxf != null) {
                fW += e.a.a.b.b.a.h(8, this.hxf);
            }
            if (this.hxg != null) {
                fW += e.a.a.b.b.a.h(9, this.hxg);
            }
            if (this.hxh != null) {
                fW += e.a.a.b.b.a.h(10, this.hxh);
            }
            fW = (fW + e.a.a.a.fU(11, this.hxi)) + e.a.a.a.fU(12, this.wCq);
            if (this.wCr != null) {
                fW += e.a.a.b.b.a.h(13, this.wCr);
            }
            if (this.wCs != null) {
                fW += e.a.a.b.b.a.h(14, this.wCs);
            }
            if (this.hxj != null) {
                fW += e.a.a.b.b.a.h(15, this.hxj);
            }
            if (this.wCt != null) {
                fW += e.a.a.b.b.a.h(16, this.wCt);
            }
            fW = ((fW + e.a.a.a.fU(17, this.wCu)) + e.a.a.a.fU(18, this.hxl)) + e.a.a.a.fU(19, this.hxk);
            if (this.hxm != null) {
                fW += e.a.a.b.b.a.h(20, this.hxm);
            }
            if (this.wCw != null) {
                fW += e.a.a.a.fW(21, this.wCw.bkL());
            }
            if (this.hxn != null) {
                fW += e.a.a.b.b.a.h(22, this.hxn);
            }
            if (this.hxo != null) {
                fW += e.a.a.b.b.a.h(23, this.hxo);
            }
            if (this.wCx != null) {
                fW += e.a.a.a.fW(24, this.wCx.bkL());
            }
            fW = (fW + e.a.a.a.fU(25, this.wrp)) + e.a.a.a.c(26, 8, this.wrq);
            if (this.wbY != null) {
                fW += e.a.a.b.b.a.h(27, this.wbY);
            }
            if (this.wbZ != null) {
                fW += e.a.a.b.b.a.h(28, this.wbZ);
            }
            if (this.wRG != null) {
                fW += e.a.a.a.fW(29, this.wRG.bkL());
            }
            if (this.woW != null) {
                fW += e.a.a.b.b.a.h(30, this.woW);
            }
            if (this.wRH != null) {
                fW += e.a.a.b.b.a.h(31, this.wRH);
            }
            fW += e.a.a.a.fU(32, this.wRE);
            if (this.wRI != null) {
                fW += e.a.a.b.b.a.h(33, this.wRI);
            }
            return (fW + e.a.a.a.fU(34, this.wRJ)) + e.a.a.a.c(35, 8, this.wRK);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wrq.clear();
            this.wRK.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wfM == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.wzM == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.wfA == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.wfB == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.vNQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfr bfr = (bfr) objArr[1];
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
                        bfr.wRa = fiVar;
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
                        bfr.wfM = fiVar;
                    }
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
                        bfr.wzM = fiVar;
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
                        bfr.wfA = fiVar;
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
                        bfr.wfB = fiVar;
                    }
                    return 0;
                case 6:
                    bfr.hxe = aVar3.AEQ.rz();
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
                        bfr.vNQ = fiVar;
                    }
                    return 0;
                case 8:
                    bfr.hxf = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    bfr.hxg = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    bfr.hxh = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    bfr.hxi = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    bfr.wCq = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    bfr.wCr = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    bfr.wCs = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    bfr.hxj = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    bfr.wCt = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    bfr.wCu = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    bfr.hxl = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    bfr.hxk = aVar3.AEQ.rz();
                    return 0;
                case 20:
                    bfr.hxm = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bmk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfr.wCw = fiVar;
                    }
                    return 0;
                case 22:
                    bfr.hxn = aVar3.AEQ.readString();
                    return 0;
                case 23:
                    bfr.hxo = aVar3.AEQ.readString();
                    return 0;
                case 24:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new py();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfr.wCx = fiVar;
                    }
                    return 0;
                case 25:
                    bfr.wrp = aVar3.AEQ.rz();
                    return 0;
                case 26:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bfp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfr.wrq.add(fiVar);
                    }
                    return 0;
                case 27:
                    bfr.wbY = aVar3.AEQ.readString();
                    return 0;
                case 28:
                    bfr.wbZ = aVar3.AEQ.readString();
                    return 0;
                case 29:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfr.wRG = fiVar;
                    }
                    return 0;
                case 30:
                    bfr.woW = aVar3.AEQ.readString();
                    return 0;
                case 31:
                    bfr.wRH = aVar3.AEQ.readString();
                    return 0;
                case 32:
                    bfr.wRE = aVar3.AEQ.rz();
                    return 0;
                case 33:
                    bfr.wRI = aVar3.AEQ.readString();
                    return 0;
                case 34:
                    bfr.wRJ = aVar3.AEQ.rz();
                    return 0;
                case 35:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bgg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bfr.wRK.add(fiVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
