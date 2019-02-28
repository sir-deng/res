package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bx extends a {
    public int kyY;
    public int nlX;
    public int pgR;
    public int vNL;
    public bet vNM;
    public bet vNN;
    public bet vNO;
    public int vNP;
    public bes vNQ;
    public String vNR;
    public String vNS;
    public long vNT;
    public int vNU;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNM == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vNN == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.vNO == null) {
                throw new b("Not all required fields were included: Content");
            } else if (this.vNQ == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                aVar.fX(1, this.vNL);
                if (this.vNM != null) {
                    aVar.fZ(2, this.vNM.bkL());
                    this.vNM.a(aVar);
                }
                if (this.vNN != null) {
                    aVar.fZ(3, this.vNN.bkL());
                    this.vNN.a(aVar);
                }
                aVar.fX(4, this.nlX);
                if (this.vNO != null) {
                    aVar.fZ(5, this.vNO.bkL());
                    this.vNO.a(aVar);
                }
                aVar.fX(6, this.kyY);
                aVar.fX(7, this.vNP);
                if (this.vNQ != null) {
                    aVar.fZ(8, this.vNQ.bkL());
                    this.vNQ.a(aVar);
                }
                aVar.fX(9, this.pgR);
                if (this.vNR != null) {
                    aVar.g(10, this.vNR);
                }
                if (this.vNS != null) {
                    aVar.g(11, this.vNS);
                }
                aVar.S(12, this.vNT);
                aVar.fX(13, this.vNU);
                return 0;
            }
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vNL) + 0;
            if (this.vNM != null) {
                fU += e.a.a.a.fW(2, this.vNM.bkL());
            }
            if (this.vNN != null) {
                fU += e.a.a.a.fW(3, this.vNN.bkL());
            }
            fU += e.a.a.a.fU(4, this.nlX);
            if (this.vNO != null) {
                fU += e.a.a.a.fW(5, this.vNO.bkL());
            }
            fU = (fU + e.a.a.a.fU(6, this.kyY)) + e.a.a.a.fU(7, this.vNP);
            if (this.vNQ != null) {
                fU += e.a.a.a.fW(8, this.vNQ.bkL());
            }
            fU += e.a.a.a.fU(9, this.pgR);
            if (this.vNR != null) {
                fU += e.a.a.b.b.a.h(10, this.vNR);
            }
            if (this.vNS != null) {
                fU += e.a.a.b.b.a.h(11, this.vNS);
            }
            return (fU + e.a.a.a.R(12, this.vNT)) + e.a.a.a.fU(13, this.vNU);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.vNM == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vNN == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.vNO == null) {
                throw new b("Not all required fields were included: Content");
            } else if (this.vNQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bx bxVar = (bx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bet;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bxVar.vNL = aVar3.AEQ.rz();
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
                        bxVar.vNM = bet;
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
                        bxVar.vNN = bet;
                    }
                    return 0;
                case 4:
                    bxVar.nlX = aVar3.AEQ.rz();
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
                        bxVar.vNO = bet;
                    }
                    return 0;
                case 6:
                    bxVar.kyY = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bxVar.vNP = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bxVar.vNQ = bet;
                    }
                    return 0;
                case 9:
                    bxVar.pgR = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    bxVar.vNR = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    bxVar.vNS = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    bxVar.vNT = aVar3.AEQ.rA();
                    return 0;
                case 13:
                    bxVar.vNU = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
