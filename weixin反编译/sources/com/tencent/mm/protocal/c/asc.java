package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;
import org.xwalk.core.R;

public final class asc extends a {
    public String fXy;
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
    public String nqi;
    public bes vNQ;
    public int vON;
    public String vPF;
    public int wCq;
    public String wCr;
    public String wCs;
    public String wCt;
    public int wCu;
    public bmk wCw;
    public py wCx;
    public bet wFS;
    public bet wFT;
    public bet wFU;
    public int wGA;
    public int wGB;
    public int wGC;
    public String wGD;
    public ayc wGE;
    public int wGF;
    public int wGG;
    public int wGH;
    public int wGj;
    public bet wGn;
    public int wGo;
    public int wGp;
    public String wGq;
    public String wGr;
    public String wGs;
    public String wGt;
    public String wGu;
    public String wGv;
    public String wGw;
    public String wGx;
    public cd wGy;
    public int wGz;
    public String wbY;
    public String wbZ;
    public int weQ;
    public int weR;
    public int weW;
    public int weX;
    public LinkedList<ber> weY = new LinkedList();
    public bet wfA;
    public bet wfB;
    public bet wfM;
    public int wfO;
    public String wfP;
    public int wfa;
    public int wfb;
    public mm wra;
    public String wuV;
    public bet wzM;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
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
                aVar.fX(7, this.weQ);
                aVar.fX(8, this.weR);
                aVar.fX(9, this.wGj);
                if (this.wFS != null) {
                    aVar.fZ(10, this.wFS.bkL());
                    this.wFS.a(aVar);
                }
                if (this.wFT != null) {
                    aVar.fZ(11, this.wFT.bkL());
                    this.wFT.a(aVar);
                }
                if (this.wFU != null) {
                    aVar.fZ(12, this.wFU.bkL());
                    this.wFU.a(aVar);
                }
                aVar.fX(13, this.weW);
                aVar.fX(14, this.weX);
                aVar.d(15, 8, this.weY);
                if (this.wGn != null) {
                    aVar.fZ(16, this.wGn.bkL());
                    this.wGn.a(aVar);
                }
                aVar.fX(17, this.wfa);
                aVar.fX(18, this.wfb);
                if (this.hxf != null) {
                    aVar.g(19, this.hxf);
                }
                if (this.hxg != null) {
                    aVar.g(20, this.hxg);
                }
                if (this.hxh != null) {
                    aVar.g(21, this.hxh);
                }
                aVar.fX(22, this.hxi);
                aVar.fX(23, this.wGo);
                aVar.fX(24, this.wCq);
                if (this.wCr != null) {
                    aVar.g(25, this.wCr);
                }
                aVar.fX(26, this.wGp);
                aVar.fX(27, this.vON);
                if (this.wCs != null) {
                    aVar.g(28, this.wCs);
                }
                if (this.wuV != null) {
                    aVar.g(29, this.wuV);
                }
                if (this.hxj != null) {
                    aVar.g(30, this.hxj);
                }
                if (this.wGq != null) {
                    aVar.g(31, this.wGq);
                }
                if (this.wCt != null) {
                    aVar.g(32, this.wCt);
                }
                aVar.fX(33, this.wCu);
                aVar.fX(34, this.hxl);
                aVar.fX(35, this.hxk);
                if (this.hxm != null) {
                    aVar.g(36, this.hxm);
                }
                if (this.wCw != null) {
                    aVar.fZ(37, this.wCw.bkL());
                    this.wCw.a(aVar);
                }
                if (this.hxn != null) {
                    aVar.g(38, this.hxn);
                }
                if (this.wbY != null) {
                    aVar.g(39, this.wbY);
                }
                if (this.wbZ != null) {
                    aVar.g(40, this.wbZ);
                }
                if (this.hxo != null) {
                    aVar.g(41, this.hxo);
                }
                if (this.wCx != null) {
                    aVar.fZ(42, this.wCx.bkL());
                    this.wCx.a(aVar);
                }
                if (this.wGr != null) {
                    aVar.g(43, this.wGr);
                }
                if (this.wGs != null) {
                    aVar.g(44, this.wGs);
                }
                if (this.wGt != null) {
                    aVar.g(45, this.wGt);
                }
                if (this.wGu != null) {
                    aVar.g(46, this.wGu);
                }
                if (this.wGv != null) {
                    aVar.g(47, this.wGv);
                }
                if (this.wGw != null) {
                    aVar.g(48, this.wGw);
                }
                if (this.wGx != null) {
                    aVar.g(49, this.wGx);
                }
                if (this.wGy != null) {
                    aVar.fZ(50, this.wGy.bkL());
                    this.wGy.a(aVar);
                }
                aVar.fX(53, this.wGz);
                if (this.nqi != null) {
                    aVar.g(54, this.nqi);
                }
                aVar.fX(55, this.wGA);
                aVar.fX(56, this.wGB);
                if (this.wra != null) {
                    aVar.fZ(57, this.wra.bkL());
                    this.wra.a(aVar);
                }
                aVar.fX(58, this.wGC);
                if (this.vPF != null) {
                    aVar.g(59, this.vPF);
                }
                if (this.wGD != null) {
                    aVar.g(60, this.wGD);
                }
                if (this.wfP != null) {
                    aVar.g(61, this.wfP);
                }
                if (this.wGE != null) {
                    aVar.fZ(62, this.wGE.bkL());
                    this.wGE.a(aVar);
                }
                if (this.fXy != null) {
                    aVar.g(63, this.fXy);
                }
                aVar.fX(64, this.wGF);
                aVar.fX(65, this.wfO);
                aVar.fX(66, this.wGG);
                aVar.fX(67, this.wGH);
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
            fW = ((fW + e.a.a.a.fU(7, this.weQ)) + e.a.a.a.fU(8, this.weR)) + e.a.a.a.fU(9, this.wGj);
            if (this.wFS != null) {
                fW += e.a.a.a.fW(10, this.wFS.bkL());
            }
            if (this.wFT != null) {
                fW += e.a.a.a.fW(11, this.wFT.bkL());
            }
            if (this.wFU != null) {
                fW += e.a.a.a.fW(12, this.wFU.bkL());
            }
            fW = ((fW + e.a.a.a.fU(13, this.weW)) + e.a.a.a.fU(14, this.weX)) + e.a.a.a.c(15, 8, this.weY);
            if (this.wGn != null) {
                fW += e.a.a.a.fW(16, this.wGn.bkL());
            }
            fW = (fW + e.a.a.a.fU(17, this.wfa)) + e.a.a.a.fU(18, this.wfb);
            if (this.hxf != null) {
                fW += e.a.a.b.b.a.h(19, this.hxf);
            }
            if (this.hxg != null) {
                fW += e.a.a.b.b.a.h(20, this.hxg);
            }
            if (this.hxh != null) {
                fW += e.a.a.b.b.a.h(21, this.hxh);
            }
            fW = ((fW + e.a.a.a.fU(22, this.hxi)) + e.a.a.a.fU(23, this.wGo)) + e.a.a.a.fU(24, this.wCq);
            if (this.wCr != null) {
                fW += e.a.a.b.b.a.h(25, this.wCr);
            }
            fW = (fW + e.a.a.a.fU(26, this.wGp)) + e.a.a.a.fU(27, this.vON);
            if (this.wCs != null) {
                fW += e.a.a.b.b.a.h(28, this.wCs);
            }
            if (this.wuV != null) {
                fW += e.a.a.b.b.a.h(29, this.wuV);
            }
            if (this.hxj != null) {
                fW += e.a.a.b.b.a.h(30, this.hxj);
            }
            if (this.wGq != null) {
                fW += e.a.a.b.b.a.h(31, this.wGq);
            }
            if (this.wCt != null) {
                fW += e.a.a.b.b.a.h(32, this.wCt);
            }
            fW = ((fW + e.a.a.a.fU(33, this.wCu)) + e.a.a.a.fU(34, this.hxl)) + e.a.a.a.fU(35, this.hxk);
            if (this.hxm != null) {
                fW += e.a.a.b.b.a.h(36, this.hxm);
            }
            if (this.wCw != null) {
                fW += e.a.a.a.fW(37, this.wCw.bkL());
            }
            if (this.hxn != null) {
                fW += e.a.a.b.b.a.h(38, this.hxn);
            }
            if (this.wbY != null) {
                fW += e.a.a.b.b.a.h(39, this.wbY);
            }
            if (this.wbZ != null) {
                fW += e.a.a.b.b.a.h(40, this.wbZ);
            }
            if (this.hxo != null) {
                fW += e.a.a.b.b.a.h(41, this.hxo);
            }
            if (this.wCx != null) {
                fW += e.a.a.a.fW(42, this.wCx.bkL());
            }
            if (this.wGr != null) {
                fW += e.a.a.b.b.a.h(43, this.wGr);
            }
            if (this.wGs != null) {
                fW += e.a.a.b.b.a.h(44, this.wGs);
            }
            if (this.wGt != null) {
                fW += e.a.a.b.b.a.h(45, this.wGt);
            }
            if (this.wGu != null) {
                fW += e.a.a.b.b.a.h(46, this.wGu);
            }
            if (this.wGv != null) {
                fW += e.a.a.b.b.a.h(47, this.wGv);
            }
            if (this.wGw != null) {
                fW += e.a.a.b.b.a.h(48, this.wGw);
            }
            if (this.wGx != null) {
                fW += e.a.a.b.b.a.h(49, this.wGx);
            }
            if (this.wGy != null) {
                fW += e.a.a.a.fW(50, this.wGy.bkL());
            }
            fW += e.a.a.a.fU(53, this.wGz);
            if (this.nqi != null) {
                fW += e.a.a.b.b.a.h(54, this.nqi);
            }
            fW = (fW + e.a.a.a.fU(55, this.wGA)) + e.a.a.a.fU(56, this.wGB);
            if (this.wra != null) {
                fW += e.a.a.a.fW(57, this.wra.bkL());
            }
            fW += e.a.a.a.fU(58, this.wGC);
            if (this.vPF != null) {
                fW += e.a.a.b.b.a.h(59, this.vPF);
            }
            if (this.wGD != null) {
                fW += e.a.a.b.b.a.h(60, this.wGD);
            }
            if (this.wfP != null) {
                fW += e.a.a.b.b.a.h(61, this.wfP);
            }
            if (this.wGE != null) {
                fW += e.a.a.a.fW(62, this.wGE.bkL());
            }
            if (this.fXy != null) {
                fW += e.a.a.b.b.a.h(63, this.fXy);
            }
            return (((fW + e.a.a.a.fU(64, this.wGF)) + e.a.a.a.fU(65, this.wfO)) + e.a.a.a.fU(66, this.wGG)) + e.a.a.a.fU(67, this.wGH);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.weY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            asc asc = (asc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
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
                        asc.wfM = bet;
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
                        asc.wzM = bet;
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
                        asc.wfA = bet;
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
                        asc.wfB = bet;
                    }
                    return 0;
                case 5:
                    asc.hxe = aVar3.AEQ.rz();
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
                        asc.vNQ = bet;
                    }
                    return 0;
                case 7:
                    asc.weQ = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    asc.weR = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    asc.wGj = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        asc.wFS = bet;
                    }
                    return 0;
                case 11:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        asc.wFT = bet;
                    }
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        asc.wFU = bet;
                    }
                    return 0;
                case 13:
                    asc.weW = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    asc.weX = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new ber();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        asc.weY.add(bet);
                    }
                    return 0;
                case 16:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        asc.wGn = bet;
                    }
                    return 0;
                case 17:
                    asc.wfa = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    asc.wfb = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    asc.hxf = aVar3.AEQ.readString();
                    return 0;
                case 20:
                    asc.hxg = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    asc.hxh = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    asc.hxi = aVar3.AEQ.rz();
                    return 0;
                case 23:
                    asc.wGo = aVar3.AEQ.rz();
                    return 0;
                case 24:
                    asc.wCq = aVar3.AEQ.rz();
                    return 0;
                case 25:
                    asc.wCr = aVar3.AEQ.readString();
                    return 0;
                case 26:
                    asc.wGp = aVar3.AEQ.rz();
                    return 0;
                case 27:
                    asc.vON = aVar3.AEQ.rz();
                    return 0;
                case 28:
                    asc.wCs = aVar3.AEQ.readString();
                    return 0;
                case 29:
                    asc.wuV = aVar3.AEQ.readString();
                    return 0;
                case 30:
                    asc.hxj = aVar3.AEQ.readString();
                    return 0;
                case 31:
                    asc.wGq = aVar3.AEQ.readString();
                    return 0;
                case 32:
                    asc.wCt = aVar3.AEQ.readString();
                    return 0;
                case 33:
                    asc.wCu = aVar3.AEQ.rz();
                    return 0;
                case 34:
                    asc.hxl = aVar3.AEQ.rz();
                    return 0;
                case 35:
                    asc.hxk = aVar3.AEQ.rz();
                    return 0;
                case 36:
                    asc.hxm = aVar3.AEQ.readString();
                    return 0;
                case 37:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bmk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        asc.wCw = bet;
                    }
                    return 0;
                case 38:
                    asc.hxn = aVar3.AEQ.readString();
                    return 0;
                case 39:
                    asc.wbY = aVar3.AEQ.readString();
                    return 0;
                case 40:
                    asc.wbZ = aVar3.AEQ.readString();
                    return 0;
                case 41:
                    asc.hxo = aVar3.AEQ.readString();
                    return 0;
                case R.styleable.AppCompatTheme_dialogTheme /*42*/:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new py();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        asc.wCx = bet;
                    }
                    return 0;
                case R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    asc.wGr = aVar3.AEQ.readString();
                    return 0;
                case R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                    asc.wGs = aVar3.AEQ.readString();
                    return 0;
                case R.styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                    asc.wGt = aVar3.AEQ.readString();
                    return 0;
                case 46:
                    asc.wGu = aVar3.AEQ.readString();
                    return 0;
                case 47:
                    asc.wGv = aVar3.AEQ.readString();
                    return 0;
                case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    asc.wGw = aVar3.AEQ.readString();
                    return 0;
                case R.styleable.AppCompatTheme_actionButtonStyle /*49*/:
                    asc.wGx = aVar3.AEQ.readString();
                    return 0;
                case 50:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new cd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        asc.wGy = bet;
                    }
                    return 0;
                case 53:
                    asc.wGz = aVar3.AEQ.rz();
                    return 0;
                case 54:
                    asc.nqi = aVar3.AEQ.readString();
                    return 0;
                case 55:
                    asc.wGA = aVar3.AEQ.rz();
                    return 0;
                case 56:
                    asc.wGB = aVar3.AEQ.rz();
                    return 0;
                case 57:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new mm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        asc.wra = bet;
                    }
                    return 0;
                case 58:
                    asc.wGC = aVar3.AEQ.rz();
                    return 0;
                case 59:
                    asc.vPF = aVar3.AEQ.readString();
                    return 0;
                case 60:
                    asc.wGD = aVar3.AEQ.readString();
                    return 0;
                case 61:
                    asc.wfP = aVar3.AEQ.readString();
                    return 0;
                case 62:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new ayc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        asc.wGE = bet;
                    }
                    return 0;
                case 63:
                    asc.fXy = aVar3.AEQ.readString();
                    return 0;
                case 64:
                    asc.wGF = aVar3.AEQ.rz();
                    return 0;
                case 65:
                    asc.wfO = aVar3.AEQ.rz();
                    return 0;
                case 66:
                    asc.wGG = aVar3.AEQ.rz();
                    return 0;
                case 67:
                    asc.wGH = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
