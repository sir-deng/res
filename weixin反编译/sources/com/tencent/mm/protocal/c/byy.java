package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class byy extends bea {
    public int kzz;
    public int vUN;
    public String vWw;
    public int wMK;
    public String wrv;
    public int xfY;
    public int xfZ = 2;
    public double xga;
    public double xgb;
    public String xgc;
    public String xgd;
    public String xge;
    public String xgf;
    public int xgg;
    public String xgh;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wrv != null) {
                aVar.g(2, this.wrv);
            }
            aVar.fX(3, this.vUN);
            aVar.fX(4, this.xfY);
            if (this.vWw != null) {
                aVar.g(5, this.vWw);
            }
            aVar.fX(6, this.xfZ);
            aVar.b(7, this.xga);
            aVar.b(8, this.xgb);
            aVar.fX(9, this.kzz);
            aVar.fX(10, this.wMK);
            if (this.xgc != null) {
                aVar.g(99, this.xgc);
            }
            if (this.xgd != null) {
                aVar.g(100, this.xgd);
            }
            if (this.xge != null) {
                aVar.g(101, this.xge);
            }
            if (this.xgf != null) {
                aVar.g(102, this.xgf);
            }
            aVar.fX(103, this.xgg);
            if (this.xgh == null) {
                return 0;
            }
            aVar.g(104, this.xgh);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wrv != null) {
                fW += e.a.a.b.b.a.h(2, this.wrv);
            }
            fW = (fW + e.a.a.a.fU(3, this.vUN)) + e.a.a.a.fU(4, this.xfY);
            if (this.vWw != null) {
                fW += e.a.a.b.b.a.h(5, this.vWw);
            }
            fW = ((((fW + e.a.a.a.fU(6, this.xfZ)) + (e.a.a.b.b.a.dX(7) + 8)) + (e.a.a.b.b.a.dX(8) + 8)) + e.a.a.a.fU(9, this.kzz)) + e.a.a.a.fU(10, this.wMK);
            if (this.xgc != null) {
                fW += e.a.a.b.b.a.h(99, this.xgc);
            }
            if (this.xgd != null) {
                fW += e.a.a.b.b.a.h(100, this.xgd);
            }
            if (this.xge != null) {
                fW += e.a.a.b.b.a.h(101, this.xge);
            }
            if (this.xgf != null) {
                fW += e.a.a.b.b.a.h(102, this.xgf);
            }
            fW += e.a.a.a.fU(103, this.xgg);
            if (this.xgh != null) {
                fW += e.a.a.b.b.a.h(104, this.xgh);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byy byy = (byy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        byy.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    byy.wrv = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    byy.vUN = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    byy.xfY = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    byy.vWw = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    byy.xfZ = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    byy.xga = aVar3.AEQ.readDouble();
                    return 0;
                case 8:
                    byy.xgb = aVar3.AEQ.readDouble();
                    return 0;
                case 9:
                    byy.kzz = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    byy.wMK = aVar3.AEQ.rz();
                    return 0;
                case 99:
                    byy.xgc = aVar3.AEQ.readString();
                    return 0;
                case 100:
                    byy.xgd = aVar3.AEQ.readString();
                    return 0;
                case 101:
                    byy.xge = aVar3.AEQ.readString();
                    return 0;
                case 102:
                    byy.xgf = aVar3.AEQ.readString();
                    return 0;
                case 103:
                    byy.xgg = aVar3.AEQ.rz();
                    return 0;
                case 104:
                    byy.xgh = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
