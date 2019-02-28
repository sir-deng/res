package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import java.util.LinkedList;

public final class q extends a {
    public String pgd;
    public String sJo;
    public String sJp;
    public String sJq;
    public int sKd;
    public int sKe;
    public long sKf;
    public String sKg;
    public String sKh;
    public String sKi;
    public double sKj;
    public double sKk;
    public int sKl;
    public String sKm;
    public String sKn;
    public LinkedList<b> sKo = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.sKd);
            aVar.fX(2, this.sKe);
            aVar.S(3, this.sKf);
            if (this.sKg != null) {
                aVar.g(4, this.sKg);
            }
            if (this.sJo != null) {
                aVar.g(5, this.sJo);
            }
            if (this.sKh != null) {
                aVar.g(6, this.sKh);
            }
            if (this.sKi != null) {
                aVar.g(7, this.sKi);
            }
            if (this.sJp != null) {
                aVar.g(8, this.sJp);
            }
            if (this.sJq != null) {
                aVar.g(9, this.sJq);
            }
            aVar.b(10, this.sKj);
            aVar.b(11, this.sKk);
            aVar.fX(12, this.sKl);
            if (this.sKm != null) {
                aVar.g(13, this.sKm);
            }
            if (this.pgd != null) {
                aVar.g(14, this.pgd);
            }
            if (this.sKn != null) {
                aVar.g(16, this.sKn);
            }
            aVar.d(17, 6, this.sKo);
            return 0;
        } else if (i == 1) {
            fU = ((e.a.a.a.fU(1, this.sKd) + 0) + e.a.a.a.fU(2, this.sKe)) + e.a.a.a.R(3, this.sKf);
            if (this.sKg != null) {
                fU += e.a.a.b.b.a.h(4, this.sKg);
            }
            if (this.sJo != null) {
                fU += e.a.a.b.b.a.h(5, this.sJo);
            }
            if (this.sKh != null) {
                fU += e.a.a.b.b.a.h(6, this.sKh);
            }
            if (this.sKi != null) {
                fU += e.a.a.b.b.a.h(7, this.sKi);
            }
            if (this.sJp != null) {
                fU += e.a.a.b.b.a.h(8, this.sJp);
            }
            if (this.sJq != null) {
                fU += e.a.a.b.b.a.h(9, this.sJq);
            }
            fU = ((fU + (e.a.a.b.b.a.dX(10) + 8)) + (e.a.a.b.b.a.dX(11) + 8)) + e.a.a.a.fU(12, this.sKl);
            if (this.sKm != null) {
                fU += e.a.a.b.b.a.h(13, this.sKm);
            }
            if (this.pgd != null) {
                fU += e.a.a.b.b.a.h(14, this.pgd);
            }
            if (this.sKn != null) {
                fU += e.a.a.b.b.a.h(16, this.sKn);
            }
            return fU + e.a.a.a.c(17, 6, this.sKo);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.sKo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.sKd = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    qVar.sKe = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    qVar.sKf = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    qVar.sKg = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    qVar.sJo = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    qVar.sKh = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    qVar.sKi = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    qVar.sJp = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    qVar.sJq = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    qVar.sKj = aVar3.AEQ.readDouble();
                    return 0;
                case 11:
                    qVar.sKk = aVar3.AEQ.readDouble();
                    return 0;
                case 12:
                    qVar.sKl = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    qVar.sKm = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    qVar.pgd = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    qVar.sKn = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    qVar.sKo.add(aVar3.cKw());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
