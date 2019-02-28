package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class adt extends bek {
    public String hxg;
    public int vWu;
    public String vWw;
    public bes wsT;
    public int wsY;
    public LinkedList<bet> wsZ = new LinkedList();
    public int wta;
    public LinkedList<aos> wtb = new LinkedList();
    public String wtc;
    public int wtd;
    public int wte;
    public aot wtf;
    public String wtg;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wsT == null) {
                throw new b("Not all required fields were included: Buff");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.wsT != null) {
                    aVar.fZ(2, this.wsT.bkL());
                    this.wsT.a(aVar);
                }
                aVar.fX(3, this.wsY);
                aVar.d(4, 8, this.wsZ);
                aVar.fX(5, this.wta);
                aVar.d(6, 8, this.wtb);
                aVar.fX(7, this.vWu);
                if (this.wtc != null) {
                    aVar.g(8, this.wtc);
                }
                if (this.vWw != null) {
                    aVar.g(9, this.vWw);
                }
                aVar.fX(10, this.wtd);
                if (this.hxg != null) {
                    aVar.g(11, this.hxg);
                }
                aVar.fX(12, this.wte);
                if (this.wtf != null) {
                    aVar.fZ(13, this.wtf.bkL());
                    this.wtf.a(aVar);
                }
                if (this.wtg == null) {
                    return 0;
                }
                aVar.g(14, this.wtg);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wsT != null) {
                fW += e.a.a.a.fW(2, this.wsT.bkL());
            }
            fW = ((((fW + e.a.a.a.fU(3, this.wsY)) + e.a.a.a.c(4, 8, this.wsZ)) + e.a.a.a.fU(5, this.wta)) + e.a.a.a.c(6, 8, this.wtb)) + e.a.a.a.fU(7, this.vWu);
            if (this.wtc != null) {
                fW += e.a.a.b.b.a.h(8, this.wtc);
            }
            if (this.vWw != null) {
                fW += e.a.a.b.b.a.h(9, this.vWw);
            }
            fW += e.a.a.a.fU(10, this.wtd);
            if (this.hxg != null) {
                fW += e.a.a.b.b.a.h(11, this.hxg);
            }
            fW += e.a.a.a.fU(12, this.wte);
            if (this.wtf != null) {
                fW += e.a.a.a.fW(13, this.wtf.bkL());
            }
            if (this.wtg != null) {
                fW += e.a.a.b.b.a.h(14, this.wtg);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wsZ.clear();
            this.wtb.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wsT != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Buff");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            adt adt = (adt) objArr[1];
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
                        adt.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        adt.wsT = fiVar;
                    }
                    return 0;
                case 3:
                    adt.wsY = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        adt.wsZ.add(fiVar);
                    }
                    return 0;
                case 5:
                    adt.wta = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new aos();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        adt.wtb.add(fiVar);
                    }
                    return 0;
                case 7:
                    adt.vWu = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    adt.wtc = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    adt.vWw = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    adt.wtd = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    adt.hxg = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    adt.wte = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new aot();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        adt.wtf = fiVar;
                    }
                    return 0;
                case 14:
                    adt.wtg = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
