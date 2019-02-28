package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class lw extends bea {
    public int fDM;
    public int oeK;
    public String pQT;
    public String wbp;
    public String wbs;
    public String wbt;
    public int wbu;
    public String wbv;
    public String wbw;
    public String wbx;
    public String wby;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wbs == null) {
                throw new b("Not all required fields were included: receiver_name");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wbs != null) {
                aVar.g(2, this.wbs);
            }
            aVar.fX(3, this.oeK);
            if (this.wbt != null) {
                aVar.g(4, this.wbt);
            }
            if (this.pQT != null) {
                aVar.g(5, this.pQT);
            }
            aVar.fX(6, this.wbu);
            aVar.fX(7, this.fDM);
            if (this.wbv != null) {
                aVar.g(8, this.wbv);
            }
            if (this.wbp != null) {
                aVar.g(9, this.wbp);
            }
            if (this.wbw != null) {
                aVar.g(10, this.wbw);
            }
            if (this.wbx != null) {
                aVar.g(11, this.wbx);
            }
            if (this.wby == null) {
                return 0;
            }
            aVar.g(12, this.wby);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wbs != null) {
                fW += e.a.a.b.b.a.h(2, this.wbs);
            }
            fW += e.a.a.a.fU(3, this.oeK);
            if (this.wbt != null) {
                fW += e.a.a.b.b.a.h(4, this.wbt);
            }
            if (this.pQT != null) {
                fW += e.a.a.b.b.a.h(5, this.pQT);
            }
            fW = (fW + e.a.a.a.fU(6, this.wbu)) + e.a.a.a.fU(7, this.fDM);
            if (this.wbv != null) {
                fW += e.a.a.b.b.a.h(8, this.wbv);
            }
            if (this.wbp != null) {
                fW += e.a.a.b.b.a.h(9, this.wbp);
            }
            if (this.wbw != null) {
                fW += e.a.a.b.b.a.h(10, this.wbw);
            }
            if (this.wbx != null) {
                fW += e.a.a.b.b.a.h(11, this.wbx);
            }
            if (this.wby != null) {
                fW += e.a.a.b.b.a.h(12, this.wby);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wbs != null) {
                return 0;
            }
            throw new b("Not all required fields were included: receiver_name");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lw lwVar = (lw) objArr[1];
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
                        lwVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    lwVar.wbs = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    lwVar.oeK = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    lwVar.wbt = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    lwVar.pQT = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    lwVar.wbu = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    lwVar.fDM = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    lwVar.wbv = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    lwVar.wbp = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    lwVar.wbw = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    lwVar.wbx = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    lwVar.wby = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
