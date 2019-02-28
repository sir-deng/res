package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ev extends a {
    public int kzz;
    public int vNL;
    public bet vNM;
    public bet vNN;
    public bet vNO;
    public String vNR;
    public long vNT;
    public String vOL;
    public int vQR;
    public int vQS;
    public int vQT;
    public LinkedList<bet> vQU = new LinkedList();
    public LinkedList<beu> vQV = new LinkedList();
    public bes vQW;
    public int vQX;
    public int vQY;
    public int vQZ;
    public long vRa;
    public int vRb;

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNM == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vNN == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.vNO == null) {
                throw new b("Not all required fields were included: Content");
            } else {
                aVar.fX(1, this.kzz);
                if (this.vOL != null) {
                    aVar.g(2, this.vOL);
                }
                if (this.vNM != null) {
                    aVar.fZ(3, this.vNM.bkL());
                    this.vNM.a(aVar);
                }
                if (this.vNN != null) {
                    aVar.fZ(4, this.vNN.bkL());
                    this.vNN.a(aVar);
                }
                if (this.vNO != null) {
                    aVar.fZ(5, this.vNO.bkL());
                    this.vNO.a(aVar);
                }
                aVar.fX(6, this.vQR);
                aVar.fX(7, this.vQS);
                if (this.vNR != null) {
                    aVar.g(8, this.vNR);
                }
                aVar.fX(9, this.vNL);
                aVar.fX(10, this.vQT);
                aVar.d(11, 8, this.vQU);
                aVar.d(12, 8, this.vQV);
                if (this.vQW != null) {
                    aVar.fZ(13, this.vQW.bkL());
                    this.vQW.a(aVar);
                }
                aVar.fX(14, this.vQX);
                aVar.fX(15, this.vQY);
                aVar.S(16, this.vNT);
                aVar.fX(17, this.vQZ);
                aVar.S(18, this.vRa);
                aVar.fX(19, this.vRb);
                return 0;
            }
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.kzz) + 0;
            if (this.vOL != null) {
                fU += e.a.a.b.b.a.h(2, this.vOL);
            }
            if (this.vNM != null) {
                fU += e.a.a.a.fW(3, this.vNM.bkL());
            }
            if (this.vNN != null) {
                fU += e.a.a.a.fW(4, this.vNN.bkL());
            }
            if (this.vNO != null) {
                fU += e.a.a.a.fW(5, this.vNO.bkL());
            }
            fU = (fU + e.a.a.a.fU(6, this.vQR)) + e.a.a.a.fU(7, this.vQS);
            if (this.vNR != null) {
                fU += e.a.a.b.b.a.h(8, this.vNR);
            }
            fU = (((fU + e.a.a.a.fU(9, this.vNL)) + e.a.a.a.fU(10, this.vQT)) + e.a.a.a.c(11, 8, this.vQU)) + e.a.a.a.c(12, 8, this.vQV);
            if (this.vQW != null) {
                fU += e.a.a.a.fW(13, this.vQW.bkL());
            }
            return (((((fU + e.a.a.a.fU(14, this.vQX)) + e.a.a.a.fU(15, this.vQY)) + e.a.a.a.R(16, this.vNT)) + e.a.a.a.fU(17, this.vQZ)) + e.a.a.a.R(18, this.vRa)) + e.a.a.a.fU(19, this.vRb);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vQU.clear();
            this.vQV.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.vNM == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.vNN == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.vNO != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ev evVar = (ev) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a bet;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    evVar.kzz = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    evVar.vOL = aVar3.AEQ.readString();
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
                        evVar.vNM = bet;
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
                        evVar.vNN = bet;
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
                        evVar.vNO = bet;
                    }
                    return 0;
                case 6:
                    evVar.vQR = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    evVar.vQS = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    evVar.vNR = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    evVar.vNL = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    evVar.vQT = aVar3.AEQ.rz();
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
                        evVar.vQU.add(bet);
                    }
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new beu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        evVar.vQV.add(bet);
                    }
                    return 0;
                case 13:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        evVar.vQW = bet;
                    }
                    return 0;
                case 14:
                    evVar.vQX = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    evVar.vQY = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    evVar.vNT = aVar3.AEQ.rA();
                    return 0;
                case 17:
                    evVar.vQZ = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    evVar.vRa = aVar3.AEQ.rA();
                    return 0;
                case 19:
                    evVar.vRb = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
