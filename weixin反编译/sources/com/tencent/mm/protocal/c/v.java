package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class v extends bek {
    public int lot = 268513600;
    public String lou = "请求不成功，请稍候再试";
    public int state;
    public String title;
    public int type;
    public String vJI;
    public LinkedList<t> vJN = new LinkedList();
    public int vJT;
    public String vKd;
    public String vKh;
    public long vKi;
    public int vKj;
    public long vKk;
    public int vKl;
    public int vKm;
    public int vKn;
    public int vKo;
    public long vKp;
    public long vKq;
    public long vKr;
    public int vKs;
    public String vKt;
    public int vKu;
    public long vKv;

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
            if (this.vJI != null) {
                aVar.g(4, this.vJI);
            }
            if (this.title != null) {
                aVar.g(5, this.title);
            }
            aVar.fX(6, this.type);
            if (this.vKh != null) {
                aVar.g(7, this.vKh);
            }
            aVar.S(8, this.vKi);
            aVar.fX(9, this.vKj);
            aVar.S(10, this.vKk);
            aVar.fX(11, this.vKl);
            aVar.fX(12, this.state);
            aVar.fX(13, this.vKm);
            aVar.fX(14, this.vKn);
            aVar.fX(15, this.vJT);
            aVar.fX(16, this.vKo);
            aVar.S(17, this.vKp);
            aVar.S(18, this.vKq);
            aVar.S(19, this.vKr);
            aVar.fX(20, this.vKs);
            if (this.vKd != null) {
                aVar.g(21, this.vKd);
            }
            aVar.d(22, 8, this.vJN);
            if (this.vKt != null) {
                aVar.g(23, this.vKt);
            }
            aVar.fX(24, this.vKu);
            aVar.S(25, this.vKv);
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
            if (this.vJI != null) {
                fW += e.a.a.b.b.a.h(4, this.vJI);
            }
            if (this.title != null) {
                fW += e.a.a.b.b.a.h(5, this.title);
            }
            fW += e.a.a.a.fU(6, this.type);
            if (this.vKh != null) {
                fW += e.a.a.b.b.a.h(7, this.vKh);
            }
            fW = ((((((((((((fW + e.a.a.a.R(8, this.vKi)) + e.a.a.a.fU(9, this.vKj)) + e.a.a.a.R(10, this.vKk)) + e.a.a.a.fU(11, this.vKl)) + e.a.a.a.fU(12, this.state)) + e.a.a.a.fU(13, this.vKm)) + e.a.a.a.fU(14, this.vKn)) + e.a.a.a.fU(15, this.vJT)) + e.a.a.a.fU(16, this.vKo)) + e.a.a.a.R(17, this.vKp)) + e.a.a.a.R(18, this.vKq)) + e.a.a.a.R(19, this.vKr)) + e.a.a.a.fU(20, this.vKs);
            if (this.vKd != null) {
                fW += e.a.a.b.b.a.h(21, this.vKd);
            }
            fW += e.a.a.a.c(22, 8, this.vJN);
            if (this.vKt != null) {
                fW += e.a.a.b.b.a.h(23, this.vKt);
            }
            return (fW + e.a.a.a.fU(24, this.vKu)) + e.a.a.a.R(25, this.vKv);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vJN.clear();
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
            v vVar = (v) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            com.tencent.mm.bp.a fiVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        vVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    vVar.lot = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    vVar.lou = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    vVar.vJI = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    vVar.title = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    vVar.type = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    vVar.vKh = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    vVar.vKi = aVar3.AEQ.rA();
                    return 0;
                case 9:
                    vVar.vKj = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    vVar.vKk = aVar3.AEQ.rA();
                    return 0;
                case 11:
                    vVar.vKl = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    vVar.state = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    vVar.vKm = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    vVar.vKn = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    vVar.vJT = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    vVar.vKo = aVar3.AEQ.rz();
                    return 0;
                case 17:
                    vVar.vKp = aVar3.AEQ.rA();
                    return 0;
                case 18:
                    vVar.vKq = aVar3.AEQ.rA();
                    return 0;
                case 19:
                    vVar.vKr = aVar3.AEQ.rA();
                    return 0;
                case 20:
                    vVar.vKs = aVar3.AEQ.rz();
                    return 0;
                case 21:
                    vVar.vKd = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        vVar.vJN.add(fiVar);
                    }
                    return 0;
                case 23:
                    vVar.vKt = aVar3.AEQ.readString();
                    return 0;
                case 24:
                    vVar.vKu = aVar3.AEQ.rz();
                    return 0;
                case 25:
                    vVar.vKv = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
