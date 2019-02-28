package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class arx extends a {
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
    public bet wFS;
    public bet wFT;
    public bet wFU;
    public int wGj;
    public String wbY;
    public String wbZ;
    public int weW;
    public bet wfA;
    public bet wfB;
    public bet wfM;
    public String wuV;
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
            } else if (this.wFS == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.wFT == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.wFU == null) {
                throw new b("Not all required fields were included: RemarkQuanPin");
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
                aVar.fX(7, this.wGj);
                if (this.wFS != null) {
                    aVar.fZ(8, this.wFS.bkL());
                    this.wFS.a(aVar);
                }
                if (this.wFT != null) {
                    aVar.fZ(9, this.wFT.bkL());
                    this.wFT.a(aVar);
                }
                if (this.wFU != null) {
                    aVar.fZ(10, this.wFU.bkL());
                    this.wFU.a(aVar);
                }
                aVar.fX(11, this.weW);
                if (this.hxf != null) {
                    aVar.g(12, this.hxf);
                }
                if (this.hxg != null) {
                    aVar.g(13, this.hxg);
                }
                if (this.hxh != null) {
                    aVar.g(14, this.hxh);
                }
                aVar.fX(15, this.hxi);
                aVar.fX(16, this.wCq);
                if (this.wCr != null) {
                    aVar.g(17, this.wCr);
                }
                if (this.wCs != null) {
                    aVar.g(18, this.wCs);
                }
                if (this.wuV != null) {
                    aVar.g(19, this.wuV);
                }
                if (this.wCt != null) {
                    aVar.g(20, this.wCt);
                }
                aVar.fX(21, this.wCu);
                aVar.fX(22, this.hxl);
                aVar.fX(23, this.hxk);
                if (this.hxm != null) {
                    aVar.g(24, this.hxm);
                }
                if (this.hxj != null) {
                    aVar.g(25, this.hxj);
                }
                if (this.wCw != null) {
                    aVar.fZ(26, this.wCw.bkL());
                    this.wCw.a(aVar);
                }
                if (this.hxn != null) {
                    aVar.g(27, this.hxn);
                }
                if (this.wbY != null) {
                    aVar.g(28, this.wbY);
                }
                if (this.wbZ != null) {
                    aVar.g(29, this.wbZ);
                }
                if (this.hxo != null) {
                    aVar.g(30, this.hxo);
                }
                if (this.wCx == null) {
                    return 0;
                }
                aVar.fZ(31, this.wCx.bkL());
                this.wCx.a(aVar);
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
            fW += e.a.a.a.fU(7, this.wGj);
            if (this.wFS != null) {
                fW += e.a.a.a.fW(8, this.wFS.bkL());
            }
            if (this.wFT != null) {
                fW += e.a.a.a.fW(9, this.wFT.bkL());
            }
            if (this.wFU != null) {
                fW += e.a.a.a.fW(10, this.wFU.bkL());
            }
            fW += e.a.a.a.fU(11, this.weW);
            if (this.hxf != null) {
                fW += e.a.a.b.b.a.h(12, this.hxf);
            }
            if (this.hxg != null) {
                fW += e.a.a.b.b.a.h(13, this.hxg);
            }
            if (this.hxh != null) {
                fW += e.a.a.b.b.a.h(14, this.hxh);
            }
            fW = (fW + e.a.a.a.fU(15, this.hxi)) + e.a.a.a.fU(16, this.wCq);
            if (this.wCr != null) {
                fW += e.a.a.b.b.a.h(17, this.wCr);
            }
            if (this.wCs != null) {
                fW += e.a.a.b.b.a.h(18, this.wCs);
            }
            if (this.wuV != null) {
                fW += e.a.a.b.b.a.h(19, this.wuV);
            }
            if (this.wCt != null) {
                fW += e.a.a.b.b.a.h(20, this.wCt);
            }
            fW = ((fW + e.a.a.a.fU(21, this.wCu)) + e.a.a.a.fU(22, this.hxl)) + e.a.a.a.fU(23, this.hxk);
            if (this.hxm != null) {
                fW += e.a.a.b.b.a.h(24, this.hxm);
            }
            if (this.hxj != null) {
                fW += e.a.a.b.b.a.h(25, this.hxj);
            }
            if (this.wCw != null) {
                fW += e.a.a.a.fW(26, this.wCw.bkL());
            }
            if (this.hxn != null) {
                fW += e.a.a.b.b.a.h(27, this.hxn);
            }
            if (this.wbY != null) {
                fW += e.a.a.b.b.a.h(28, this.wbY);
            }
            if (this.wbZ != null) {
                fW += e.a.a.b.b.a.h(29, this.wbZ);
            }
            if (this.hxo != null) {
                fW += e.a.a.b.b.a.h(30, this.hxo);
            }
            if (this.wCx != null) {
                fW += e.a.a.a.fW(31, this.wCx.bkL());
            }
            return fW;
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
            } else if (this.vNQ == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.wFS == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.wFT == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.wFU != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RemarkQuanPin");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            arx arx = (arx) objArr[1];
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
                        arx.wfM = bet;
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
                        arx.wzM = bet;
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
                        arx.wfA = bet;
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
                        arx.wfB = bet;
                    }
                    return 0;
                case 5:
                    arx.hxe = aVar3.AEQ.rz();
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
                        arx.vNQ = bet;
                    }
                    return 0;
                case 7:
                    arx.wGj = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        arx.wFS = bet;
                    }
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        arx.wFT = bet;
                    }
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
                        arx.wFU = bet;
                    }
                    return 0;
                case 11:
                    arx.weW = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    arx.hxf = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    arx.hxg = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    arx.hxh = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    arx.hxi = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    arx.wCq = aVar3.AEQ.rz();
                    return 0;
                case 17:
                    arx.wCr = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    arx.wCs = aVar3.AEQ.readString();
                    return 0;
                case 19:
                    arx.wuV = aVar3.AEQ.readString();
                    return 0;
                case 20:
                    arx.wCt = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    arx.wCu = aVar3.AEQ.rz();
                    return 0;
                case 22:
                    arx.hxl = aVar3.AEQ.rz();
                    return 0;
                case 23:
                    arx.hxk = aVar3.AEQ.rz();
                    return 0;
                case 24:
                    arx.hxm = aVar3.AEQ.readString();
                    return 0;
                case 25:
                    arx.hxj = aVar3.AEQ.readString();
                    return 0;
                case 26:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bmk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        arx.wCw = bet;
                    }
                    return 0;
                case 27:
                    arx.hxn = aVar3.AEQ.readString();
                    return 0;
                case 28:
                    arx.wbY = aVar3.AEQ.readString();
                    return 0;
                case 29:
                    arx.wbZ = aVar3.AEQ.readString();
                    return 0;
                case 30:
                    arx.hxo = aVar3.AEQ.readString();
                    return 0;
                case 31:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new py();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        arx.wCx = bet;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
