package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class baw extends bek {
    public int lot;
    public String lou;
    public String mVD;
    public int oeK;
    public String pNv;
    public String pNw;
    public int state;
    public String wOA;
    public String wOB;
    public String wOC;
    public String wOx;
    public int wOy;
    public String wOz;

    protected final int a(int i, Object... objArr) {
        int fW;
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
            aVar.fX(4, this.state);
            if (this.wOx != null) {
                aVar.g(5, this.wOx);
            }
            aVar.fX(6, this.oeK);
            aVar.fX(7, this.wOy);
            if (this.pNv != null) {
                aVar.g(8, this.pNv);
            }
            if (this.wOz != null) {
                aVar.g(9, this.wOz);
            }
            if (this.pNw != null) {
                aVar.g(10, this.pNw);
            }
            if (this.wOA != null) {
                aVar.g(11, this.wOA);
            }
            if (this.wOB != null) {
                aVar.g(12, this.wOB);
            }
            if (this.wOC != null) {
                aVar.g(14, this.wOC);
            }
            if (this.mVD == null) {
                return 0;
            }
            aVar.g(15, this.mVD);
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
            fW += e.a.a.a.fU(4, this.state);
            if (this.wOx != null) {
                fW += e.a.a.b.b.a.h(5, this.wOx);
            }
            fW = (fW + e.a.a.a.fU(6, this.oeK)) + e.a.a.a.fU(7, this.wOy);
            if (this.pNv != null) {
                fW += e.a.a.b.b.a.h(8, this.pNv);
            }
            if (this.wOz != null) {
                fW += e.a.a.b.b.a.h(9, this.wOz);
            }
            if (this.pNw != null) {
                fW += e.a.a.b.b.a.h(10, this.pNw);
            }
            if (this.wOA != null) {
                fW += e.a.a.b.b.a.h(11, this.wOA);
            }
            if (this.wOB != null) {
                fW += e.a.a.b.b.a.h(12, this.wOB);
            }
            if (this.wOC != null) {
                fW += e.a.a.b.b.a.h(14, this.wOC);
            }
            if (this.mVD != null) {
                fW += e.a.a.b.b.a.h(15, this.mVD);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            baw baw = (baw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fiVar = new fi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        baw.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    baw.lot = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    baw.lou = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    baw.state = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    baw.wOx = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    baw.oeK = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    baw.wOy = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    baw.pNv = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    baw.wOz = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    baw.pNw = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    baw.wOA = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    baw.wOB = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    baw.wOC = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    baw.mVD = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
