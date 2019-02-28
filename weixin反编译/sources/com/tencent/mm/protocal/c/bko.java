package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bko extends a {
    public int kzz;
    public String noL;
    public int pgR;
    public int vON;
    public String wNo;
    public String wUk;
    public String wUl;
    public int wUm;
    public int wUn;
    public int wUo;
    public long wUp;
    public long wUq;
    public bes wUr;
    public int wUs;
    public String wik;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wNo != null) {
                aVar.g(1, this.wNo);
            }
            if (this.wik != null) {
                aVar.g(2, this.wik);
            }
            if (this.wUk != null) {
                aVar.g(3, this.wUk);
            }
            if (this.wUl != null) {
                aVar.g(4, this.wUl);
            }
            aVar.fX(5, this.kzz);
            aVar.fX(6, this.vON);
            aVar.fX(7, this.pgR);
            if (this.noL != null) {
                aVar.g(8, this.noL);
            }
            aVar.fX(9, this.wUm);
            aVar.fX(10, this.wUn);
            aVar.fX(11, this.wUo);
            aVar.S(12, this.wUp);
            aVar.S(13, this.wUq);
            if (this.wUr != null) {
                aVar.fZ(14, this.wUr.bkL());
                this.wUr.a(aVar);
            }
            aVar.fX(15, this.wUs);
            return 0;
        } else if (i == 1) {
            if (this.wNo != null) {
                h = e.a.a.b.b.a.h(1, this.wNo) + 0;
            } else {
                h = 0;
            }
            if (this.wik != null) {
                h += e.a.a.b.b.a.h(2, this.wik);
            }
            if (this.wUk != null) {
                h += e.a.a.b.b.a.h(3, this.wUk);
            }
            if (this.wUl != null) {
                h += e.a.a.b.b.a.h(4, this.wUl);
            }
            h = ((h + e.a.a.a.fU(5, this.kzz)) + e.a.a.a.fU(6, this.vON)) + e.a.a.a.fU(7, this.pgR);
            if (this.noL != null) {
                h += e.a.a.b.b.a.h(8, this.noL);
            }
            h = ((((h + e.a.a.a.fU(9, this.wUm)) + e.a.a.a.fU(10, this.wUn)) + e.a.a.a.fU(11, this.wUo)) + e.a.a.a.R(12, this.wUp)) + e.a.a.a.R(13, this.wUq);
            if (this.wUr != null) {
                h += e.a.a.a.fW(14, this.wUr.bkL());
            }
            return h + e.a.a.a.fU(15, this.wUs);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bko bko = (bko) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bko.wNo = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bko.wik = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bko.wUk = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bko.wUl = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bko.kzz = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bko.vON = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bko.pgR = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bko.noL = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    bko.wUm = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    bko.wUn = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    bko.wUo = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    bko.wUp = aVar3.AEQ.rA();
                    return 0;
                case 13:
                    bko.wUq = aVar3.AEQ.rA();
                    return 0;
                case 14:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bes = new bes();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        bko.wUr = bes;
                    }
                    return 0;
                case 15:
                    bko.wUs = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
