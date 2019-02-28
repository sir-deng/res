package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class f extends a {
    public double sJA;
    public double sJB;
    public int sJC;
    public String sJD;
    public String sJE;
    public a sJF;
    public double sJr;
    public double sJs;
    public double sJt;
    public String sJu;
    public LinkedList<q> sJv = new LinkedList();
    public g sJw;
    public int sJx;
    public String sJy;
    public String sJz;

    protected final int a(int i, Object... objArr) {
        int dX;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.b(1, this.sJr);
            aVar.b(2, this.sJs);
            aVar.b(3, this.sJt);
            if (this.sJu != null) {
                aVar.g(4, this.sJu);
            }
            aVar.d(5, 8, this.sJv);
            if (this.sJw != null) {
                aVar.fZ(6, this.sJw.bkL());
                this.sJw.a(aVar);
            }
            aVar.fX(7, this.sJx);
            if (this.sJy != null) {
                aVar.g(8, this.sJy);
            }
            if (this.sJz != null) {
                aVar.g(9, this.sJz);
            }
            aVar.b(10, this.sJA);
            aVar.b(11, this.sJB);
            aVar.fX(12, this.sJC);
            if (this.sJD != null) {
                aVar.g(13, this.sJD);
            }
            if (this.sJE != null) {
                aVar.g(14, this.sJE);
            }
            if (this.sJF != null) {
                aVar.fZ(15, this.sJF.bkL());
                this.sJF.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            dX = (((e.a.a.b.b.a.dX(1) + 8) + 0) + (e.a.a.b.b.a.dX(2) + 8)) + (e.a.a.b.b.a.dX(3) + 8);
            if (this.sJu != null) {
                dX += e.a.a.b.b.a.h(4, this.sJu);
            }
            dX += e.a.a.a.c(5, 8, this.sJv);
            if (this.sJw != null) {
                dX += e.a.a.a.fW(6, this.sJw.bkL());
            }
            dX += e.a.a.a.fU(7, this.sJx);
            if (this.sJy != null) {
                dX += e.a.a.b.b.a.h(8, this.sJy);
            }
            if (this.sJz != null) {
                dX += e.a.a.b.b.a.h(9, this.sJz);
            }
            dX = ((dX + (e.a.a.b.b.a.dX(10) + 8)) + (e.a.a.b.b.a.dX(11) + 8)) + e.a.a.a.fU(12, this.sJC);
            if (this.sJD != null) {
                dX += e.a.a.b.b.a.h(13, this.sJD);
            }
            if (this.sJE != null) {
                dX += e.a.a.b.b.a.h(14, this.sJE);
            }
            if (this.sJF != null) {
                return dX + e.a.a.a.fW(15, this.sJF.bkL());
            }
            return dX;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sJv.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (dX = a.a(aVar2); dX > 0; dX = a.a(aVar2)) {
                if (!super.a(aVar2, this, dX)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a qVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    fVar.sJr = aVar3.AEQ.readDouble();
                    return 0;
                case 2:
                    fVar.sJs = aVar3.AEQ.readDouble();
                    return 0;
                case 3:
                    fVar.sJt = aVar3.AEQ.readDouble();
                    return 0;
                case 4:
                    fVar.sJu = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        qVar = new q();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        fVar.sJv.add(qVar);
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        qVar = new g();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        fVar.sJw = qVar;
                    }
                    return 0;
                case 7:
                    fVar.sJx = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    fVar.sJy = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    fVar.sJz = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    fVar.sJA = aVar3.AEQ.readDouble();
                    return 0;
                case 11:
                    fVar.sJB = aVar3.AEQ.readDouble();
                    return 0;
                case 12:
                    fVar.sJC = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    fVar.sJD = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    fVar.sJE = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        qVar = new a();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        fVar.sJF = qVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
