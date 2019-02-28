package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class jx extends a {
    public int lTO;
    public int vXd;
    public int vXe;
    public int vXf;
    public int vXg;
    public LinkedList<bet> vXh = new LinkedList();
    public String vXi;
    public bes vXj;
    public int vXk;
    public int vXl;
    public LinkedList<bet> vXm = new LinkedList();
    public LinkedList<jy> vXn = new LinkedList();
    public LinkedList<jy> vXo = new LinkedList();
    public int vXp;
    public int vXq;

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vXj == null) {
                throw new b("Not all required fields were included: AuthKey");
            }
            aVar.fX(1, this.vXd);
            aVar.fX(2, this.lTO);
            aVar.fX(3, this.vXe);
            aVar.fX(4, this.vXf);
            aVar.fX(5, this.vXg);
            aVar.d(6, 8, this.vXh);
            if (this.vXi != null) {
                aVar.g(7, this.vXi);
            }
            if (this.vXj != null) {
                aVar.fZ(8, this.vXj.bkL());
                this.vXj.a(aVar);
            }
            aVar.fX(9, this.vXk);
            aVar.fX(10, this.vXl);
            aVar.d(11, 8, this.vXm);
            aVar.d(12, 8, this.vXn);
            aVar.d(13, 8, this.vXo);
            aVar.fX(14, this.vXp);
            aVar.fX(15, this.vXq);
            return 0;
        } else if (i == 1) {
            fU = (((((e.a.a.a.fU(1, this.vXd) + 0) + e.a.a.a.fU(2, this.lTO)) + e.a.a.a.fU(3, this.vXe)) + e.a.a.a.fU(4, this.vXf)) + e.a.a.a.fU(5, this.vXg)) + e.a.a.a.c(6, 8, this.vXh);
            if (this.vXi != null) {
                fU += e.a.a.b.b.a.h(7, this.vXi);
            }
            if (this.vXj != null) {
                fU += e.a.a.a.fW(8, this.vXj.bkL());
            }
            return ((((((fU + e.a.a.a.fU(9, this.vXk)) + e.a.a.a.fU(10, this.vXl)) + e.a.a.a.c(11, 8, this.vXm)) + e.a.a.a.c(12, 8, this.vXn)) + e.a.a.a.c(13, 8, this.vXo)) + e.a.a.a.fU(14, this.vXp)) + e.a.a.a.fU(15, this.vXq);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vXh.clear();
            this.vXm.clear();
            this.vXn.clear();
            this.vXo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.vXj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AuthKey");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jx jxVar = (jx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a bet;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jxVar.vXd = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    jxVar.lTO = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    jxVar.vXe = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    jxVar.vXf = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    jxVar.vXg = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        jxVar.vXh.add(bet);
                    }
                    return 0;
                case 7:
                    jxVar.vXi = aVar3.AEQ.readString();
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
                        jxVar.vXj = bet;
                    }
                    return 0;
                case 9:
                    jxVar.vXk = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    jxVar.vXl = aVar3.AEQ.rz();
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
                        jxVar.vXm.add(bet);
                    }
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new jy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        jxVar.vXn.add(bet);
                    }
                    return 0;
                case 13:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new jy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        jxVar.vXo.add(bet);
                    }
                    return 0;
                case 14:
                    jxVar.vXp = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    jxVar.vXq = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
