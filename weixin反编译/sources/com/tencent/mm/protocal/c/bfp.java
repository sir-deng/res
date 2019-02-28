package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bfp extends a {
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
    public String wbY;
    public String wbZ;
    public bet wfA;
    public bet wfB;
    public bet wfM;
    public String woW;
    public bet wzM;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wfM == null) {
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
                if (this.wfM != null) {
                    aVar.fZ(1, this.wfM.bkL());
                    this.wfM.a(aVar);
                }
                if (this.wzM != null) {
                    aVar.fZ(2, this.wzM.bkL());
                    this.wzM.a(aVar);
                }
                if (this.wfA != null) {
                    aVar.fZ(3, this.wfA.bkL());
                    this.wfA.a(aVar);
                }
                if (this.wfB != null) {
                    aVar.fZ(4, this.wfB.bkL());
                    this.wfB.a(aVar);
                }
                aVar.fX(5, this.hxe);
                if (this.vNQ != null) {
                    aVar.fZ(6, this.vNQ.bkL());
                    this.vNQ.a(aVar);
                }
                if (this.hxf != null) {
                    aVar.g(7, this.hxf);
                }
                if (this.hxg != null) {
                    aVar.g(8, this.hxg);
                }
                if (this.hxh != null) {
                    aVar.g(9, this.hxh);
                }
                aVar.fX(10, this.hxi);
                aVar.fX(11, this.wCq);
                if (this.wCr != null) {
                    aVar.g(12, this.wCr);
                }
                if (this.wCs != null) {
                    aVar.g(13, this.wCs);
                }
                if (this.hxj != null) {
                    aVar.g(14, this.hxj);
                }
                if (this.wCt != null) {
                    aVar.g(15, this.wCt);
                }
                aVar.fX(16, this.wCu);
                aVar.fX(17, this.hxl);
                aVar.fX(18, this.hxk);
                if (this.hxm != null) {
                    aVar.g(19, this.hxm);
                }
                if (this.wCw != null) {
                    aVar.fZ(20, this.wCw.bkL());
                    this.wCw.a(aVar);
                }
                if (this.hxn != null) {
                    aVar.g(21, this.hxn);
                }
                if (this.hxo != null) {
                    aVar.g(22, this.hxo);
                }
                if (this.wCx != null) {
                    aVar.fZ(23, this.wCx.bkL());
                    this.wCx.a(aVar);
                }
                if (this.wbY != null) {
                    aVar.g(24, this.wbY);
                }
                if (this.wbZ != null) {
                    aVar.g(25, this.wbZ);
                }
                if (this.woW != null) {
                    aVar.g(26, this.woW);
                }
                aVar.fX(27, this.wRE);
                return 0;
            }
        } else if (i == 1) {
            if (this.wfM != null) {
                fW = e.a.a.a.fW(1, this.wfM.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wzM != null) {
                fW += e.a.a.a.fW(2, this.wzM.bkL());
            }
            if (this.wfA != null) {
                fW += e.a.a.a.fW(3, this.wfA.bkL());
            }
            if (this.wfB != null) {
                fW += e.a.a.a.fW(4, this.wfB.bkL());
            }
            fW += e.a.a.a.fU(5, this.hxe);
            if (this.vNQ != null) {
                fW += e.a.a.a.fW(6, this.vNQ.bkL());
            }
            if (this.hxf != null) {
                fW += e.a.a.b.b.a.h(7, this.hxf);
            }
            if (this.hxg != null) {
                fW += e.a.a.b.b.a.h(8, this.hxg);
            }
            if (this.hxh != null) {
                fW += e.a.a.b.b.a.h(9, this.hxh);
            }
            fW = (fW + e.a.a.a.fU(10, this.hxi)) + e.a.a.a.fU(11, this.wCq);
            if (this.wCr != null) {
                fW += e.a.a.b.b.a.h(12, this.wCr);
            }
            if (this.wCs != null) {
                fW += e.a.a.b.b.a.h(13, this.wCs);
            }
            if (this.hxj != null) {
                fW += e.a.a.b.b.a.h(14, this.hxj);
            }
            if (this.wCt != null) {
                fW += e.a.a.b.b.a.h(15, this.wCt);
            }
            fW = ((fW + e.a.a.a.fU(16, this.wCu)) + e.a.a.a.fU(17, this.hxl)) + e.a.a.a.fU(18, this.hxk);
            if (this.hxm != null) {
                fW += e.a.a.b.b.a.h(19, this.hxm);
            }
            if (this.wCw != null) {
                fW += e.a.a.a.fW(20, this.wCw.bkL());
            }
            if (this.hxn != null) {
                fW += e.a.a.b.b.a.h(21, this.hxn);
            }
            if (this.hxo != null) {
                fW += e.a.a.b.b.a.h(22, this.hxo);
            }
            if (this.wCx != null) {
                fW += e.a.a.a.fW(23, this.wCx.bkL());
            }
            if (this.wbY != null) {
                fW += e.a.a.b.b.a.h(24, this.wbY);
            }
            if (this.wbZ != null) {
                fW += e.a.a.b.b.a.h(25, this.wbZ);
            }
            if (this.woW != null) {
                fW += e.a.a.b.b.a.h(26, this.woW);
            }
            return fW + e.a.a.a.fU(27, this.wRE);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wfM == null) {
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
            bfp bfp = (bfp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bet;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bfp.wfM = bet;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bfp.wzM = bet;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bfp.wfA = bet;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bfp.wfB = bet;
                    }
                    return 0;
                case 5:
                    bfp.hxe = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bfp.vNQ = bet;
                    }
                    return 0;
                case 7:
                    bfp.hxf = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bfp.hxg = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    bfp.hxh = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    bfp.hxi = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    bfp.wCq = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    bfp.wCr = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    bfp.wCs = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    bfp.hxj = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    bfp.wCt = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    bfp.wCu = aVar3.AEQ.rz();
                    return 0;
                case 17:
                    bfp.hxl = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    bfp.hxk = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    bfp.hxm = aVar3.AEQ.readString();
                    return 0;
                case 20:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bmk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bfp.wCw = bet;
                    }
                    return 0;
                case 21:
                    bfp.hxn = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    bfp.hxo = aVar3.AEQ.readString();
                    return 0;
                case 23:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new py();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bfp.wCx = bet;
                    }
                    return 0;
                case 24:
                    bfp.wbY = aVar3.AEQ.readString();
                    return 0;
                case 25:
                    bfp.wbZ = aVar3.AEQ.readString();
                    return 0;
                case 26:
                    bfp.woW = aVar3.AEQ.readString();
                    return 0;
                case 27:
                    bfp.wRE = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
