package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class afu extends bek {
    public int lot;
    public String lou;
    public boolean sOv;
    public String wuA;
    public String wuB;
    public String wuC;
    public boolean wuD;
    public LinkedList<String> wuE = new LinkedList();
    public String wuo;
    public String wup;
    public String wuq;
    public String wur;
    public String wus;
    public boolean wut;
    public String wuu;
    public long wuv;
    public boolean wuw;
    public boolean wux;
    public boolean wuy;
    public String wuz;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            aVar.fX(2, this.lot);
            if (this.lou != null) {
                aVar.g(3, this.lou);
            }
            if (this.wuo != null) {
                aVar.g(4, this.wuo);
            }
            if (this.wup != null) {
                aVar.g(5, this.wup);
            }
            if (this.wuq != null) {
                aVar.g(6, this.wuq);
            }
            if (this.wur != null) {
                aVar.g(7, this.wur);
            }
            if (this.wus != null) {
                aVar.g(8, this.wus);
            }
            aVar.am(9, this.wut);
            if (this.wuu != null) {
                aVar.g(10, this.wuu);
            }
            aVar.S(11, this.wuv);
            aVar.am(12, this.wuw);
            aVar.am(13, this.wux);
            aVar.am(14, this.wuy);
            if (this.wuz != null) {
                aVar.g(15, this.wuz);
            }
            if (this.wuA != null) {
                aVar.g(16, this.wuA);
            }
            if (this.wuB != null) {
                aVar.g(17, this.wuB);
            }
            if (this.wuC != null) {
                aVar.g(18, this.wuC);
            }
            aVar.am(19, this.wuD);
            aVar.d(20, 1, this.wuE);
            aVar.am(21, this.sOv);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.lot);
            if (this.lou != null) {
                fW += e.a.a.b.b.a.h(3, this.lou);
            }
            if (this.wuo != null) {
                fW += e.a.a.b.b.a.h(4, this.wuo);
            }
            if (this.wup != null) {
                fW += e.a.a.b.b.a.h(5, this.wup);
            }
            if (this.wuq != null) {
                fW += e.a.a.b.b.a.h(6, this.wuq);
            }
            if (this.wur != null) {
                fW += e.a.a.b.b.a.h(7, this.wur);
            }
            if (this.wus != null) {
                fW += e.a.a.b.b.a.h(8, this.wus);
            }
            fW += e.a.a.b.b.a.dX(9) + 1;
            if (this.wuu != null) {
                fW += e.a.a.b.b.a.h(10, this.wuu);
            }
            fW = (((fW + e.a.a.a.R(11, this.wuv)) + (e.a.a.b.b.a.dX(12) + 1)) + (e.a.a.b.b.a.dX(13) + 1)) + (e.a.a.b.b.a.dX(14) + 1);
            if (this.wuz != null) {
                fW += e.a.a.b.b.a.h(15, this.wuz);
            }
            if (this.wuA != null) {
                fW += e.a.a.b.b.a.h(16, this.wuA);
            }
            if (this.wuB != null) {
                fW += e.a.a.b.b.a.h(17, this.wuB);
            }
            if (this.wuC != null) {
                fW += e.a.a.b.b.a.h(18, this.wuC);
            }
            return ((fW + (e.a.a.b.b.a.dX(19) + 1)) + e.a.a.a.c(20, 1, this.wuE)) + (e.a.a.b.b.a.dX(21) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wuE.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afu afu = (afu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fiVar = new fi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        afu.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    afu.lot = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    afu.lou = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    afu.wuo = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    afu.wup = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    afu.wuq = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    afu.wur = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    afu.wus = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    afu.wut = aVar3.cKv();
                    return 0;
                case 10:
                    afu.wuu = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    afu.wuv = aVar3.AEQ.rA();
                    return 0;
                case 12:
                    afu.wuw = aVar3.cKv();
                    return 0;
                case 13:
                    afu.wux = aVar3.cKv();
                    return 0;
                case 14:
                    afu.wuy = aVar3.cKv();
                    return 0;
                case 15:
                    afu.wuz = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    afu.wuA = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    afu.wuB = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    afu.wuC = aVar3.AEQ.readString();
                    return 0;
                case 19:
                    afu.wuD = aVar3.cKv();
                    return 0;
                case 20:
                    afu.wuE.add(aVar3.AEQ.readString());
                    return 0;
                case 21:
                    afu.sOv = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
