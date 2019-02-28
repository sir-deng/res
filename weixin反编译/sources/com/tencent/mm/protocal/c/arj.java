package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class arj extends a {
    public int hxe;
    public String hxf;
    public String hxg;
    public String hxh;
    public int hxi;
    public String hxn;
    public int wCq;
    public String wCr;
    public int wFR;
    public bet wFS;
    public bet wFT;
    public bet wFU;
    public int weW;
    public bet wfA;
    public bet wfB;
    public bet wfS;
    public bet wzM;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wfS == null) {
                throw new b("Not all required fields were included: MemberName");
            } else if (this.wzM == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.wfA == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.wfB == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.wFS == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.wFT == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.wFU == null) {
                throw new b("Not all required fields were included: RemarkQuanPin");
            } else {
                if (this.wfS != null) {
                    aVar.fZ(1, this.wfS.bkL());
                    this.wfS.a(aVar);
                }
                aVar.fX(2, this.wFR);
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
                if (this.wFS != null) {
                    aVar.fZ(9, this.wFS.bkL());
                    this.wFS.a(aVar);
                }
                if (this.wFT != null) {
                    aVar.fZ(10, this.wFT.bkL());
                    this.wFT.a(aVar);
                }
                if (this.wFU != null) {
                    aVar.fZ(11, this.wFU.bkL());
                    this.wFU.a(aVar);
                }
                aVar.fX(12, this.weW);
                if (this.hxf != null) {
                    aVar.g(13, this.hxf);
                }
                if (this.hxg != null) {
                    aVar.g(14, this.hxg);
                }
                if (this.hxh != null) {
                    aVar.g(15, this.hxh);
                }
                aVar.fX(16, this.hxi);
                aVar.fX(17, this.wCq);
                if (this.wCr != null) {
                    aVar.g(18, this.wCr);
                }
                if (this.hxn == null) {
                    return 0;
                }
                aVar.g(19, this.hxn);
                return 0;
            }
        } else if (i == 1) {
            if (this.wfS != null) {
                fW = e.a.a.a.fW(1, this.wfS.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.wFR);
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
            if (this.wFS != null) {
                fW += e.a.a.a.fW(9, this.wFS.bkL());
            }
            if (this.wFT != null) {
                fW += e.a.a.a.fW(10, this.wFT.bkL());
            }
            if (this.wFU != null) {
                fW += e.a.a.a.fW(11, this.wFU.bkL());
            }
            fW += e.a.a.a.fU(12, this.weW);
            if (this.hxf != null) {
                fW += e.a.a.b.b.a.h(13, this.hxf);
            }
            if (this.hxg != null) {
                fW += e.a.a.b.b.a.h(14, this.hxg);
            }
            if (this.hxh != null) {
                fW += e.a.a.b.b.a.h(15, this.hxh);
            }
            fW = (fW + e.a.a.a.fU(16, this.hxi)) + e.a.a.a.fU(17, this.wCq);
            if (this.wCr != null) {
                fW += e.a.a.b.b.a.h(18, this.wCr);
            }
            if (this.hxn != null) {
                fW += e.a.a.b.b.a.h(19, this.hxn);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wfS == null) {
                throw new b("Not all required fields were included: MemberName");
            } else if (this.wzM == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.wfA == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.wfB == null) {
                throw new b("Not all required fields were included: QuanPin");
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
            arj arj = (arj) objArr[1];
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
                        arj.wfS = bet;
                    }
                    return 0;
                case 2:
                    arj.wFR = aVar3.AEQ.rz();
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
                        arj.wzM = bet;
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
                        arj.wfA = bet;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        arj.wfB = bet;
                    }
                    return 0;
                case 6:
                    arj.hxe = aVar3.AEQ.rz();
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
                        arj.wFS = bet;
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
                        arj.wFT = bet;
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
                        arj.wFU = bet;
                    }
                    return 0;
                case 12:
                    arj.weW = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    arj.hxf = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    arj.hxg = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    arj.hxh = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    arj.hxi = aVar3.AEQ.rz();
                    return 0;
                case 17:
                    arj.wCq = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    arj.wCr = aVar3.AEQ.readString();
                    return 0;
                case 19:
                    arj.hxn = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
