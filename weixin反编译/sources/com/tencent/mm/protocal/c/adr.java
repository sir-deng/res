package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class adr extends bek {
    public int ceA;
    public String fHQ;
    public String hdx;
    public String kPA;
    public String kPB;
    public String kPC;
    public String kPy;
    public String kQL;
    public int qur;
    public String qus;
    public String qut;
    public String quu;
    public String quw;
    public boolean qux;
    public String title;
    public boolean wsL;
    public boolean wsM;
    public String wsN;
    public String wsO;
    public int wsP;
    public String wsQ;
    public int wsR;
    public String wsS;

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
            aVar.am(2, this.wsL);
            aVar.am(3, this.wsM);
            if (this.wsN != null) {
                aVar.g(4, this.wsN);
            }
            if (this.wsO != null) {
                aVar.g(5, this.wsO);
            }
            aVar.fX(6, this.wsP);
            if (this.wsQ != null) {
                aVar.g(7, this.wsQ);
            }
            aVar.fX(8, this.wsR);
            if (this.kPy != null) {
                aVar.g(9, this.kPy);
            }
            if (this.fHQ != null) {
                aVar.g(10, this.fHQ);
            }
            if (this.title != null) {
                aVar.g(11, this.title);
            }
            if (this.kPB != null) {
                aVar.g(12, this.kPB);
            }
            if (this.kPC != null) {
                aVar.g(13, this.kPC);
            }
            if (this.kQL != null) {
                aVar.g(14, this.kQL);
            }
            if (this.kPA != null) {
                aVar.g(15, this.kPA);
            }
            if (this.hdx != null) {
                aVar.g(16, this.hdx);
            }
            aVar.fX(17, this.qur);
            if (this.qus != null) {
                aVar.g(18, this.qus);
            }
            if (this.qut != null) {
                aVar.g(19, this.qut);
            }
            if (this.quu != null) {
                aVar.g(20, this.quu);
            }
            aVar.fX(21, this.ceA);
            if (this.quw != null) {
                aVar.g(22, this.quw);
            }
            if (this.wsS != null) {
                aVar.g(23, this.wsS);
            }
            aVar.am(24, this.qux);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + (e.a.a.b.b.a.dX(2) + 1)) + (e.a.a.b.b.a.dX(3) + 1);
            if (this.wsN != null) {
                fW += e.a.a.b.b.a.h(4, this.wsN);
            }
            if (this.wsO != null) {
                fW += e.a.a.b.b.a.h(5, this.wsO);
            }
            fW += e.a.a.a.fU(6, this.wsP);
            if (this.wsQ != null) {
                fW += e.a.a.b.b.a.h(7, this.wsQ);
            }
            fW += e.a.a.a.fU(8, this.wsR);
            if (this.kPy != null) {
                fW += e.a.a.b.b.a.h(9, this.kPy);
            }
            if (this.fHQ != null) {
                fW += e.a.a.b.b.a.h(10, this.fHQ);
            }
            if (this.title != null) {
                fW += e.a.a.b.b.a.h(11, this.title);
            }
            if (this.kPB != null) {
                fW += e.a.a.b.b.a.h(12, this.kPB);
            }
            if (this.kPC != null) {
                fW += e.a.a.b.b.a.h(13, this.kPC);
            }
            if (this.kQL != null) {
                fW += e.a.a.b.b.a.h(14, this.kQL);
            }
            if (this.kPA != null) {
                fW += e.a.a.b.b.a.h(15, this.kPA);
            }
            if (this.hdx != null) {
                fW += e.a.a.b.b.a.h(16, this.hdx);
            }
            fW += e.a.a.a.fU(17, this.qur);
            if (this.qus != null) {
                fW += e.a.a.b.b.a.h(18, this.qus);
            }
            if (this.qut != null) {
                fW += e.a.a.b.b.a.h(19, this.qut);
            }
            if (this.quu != null) {
                fW += e.a.a.b.b.a.h(20, this.quu);
            }
            fW += e.a.a.a.fU(21, this.ceA);
            if (this.quw != null) {
                fW += e.a.a.b.b.a.h(22, this.quw);
            }
            if (this.wsS != null) {
                fW += e.a.a.b.b.a.h(23, this.wsS);
            }
            return fW + (e.a.a.b.b.a.dX(24) + 1);
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
            adr adr = (adr) objArr[1];
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
                        adr.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    adr.wsL = aVar3.cKv();
                    return 0;
                case 3:
                    adr.wsM = aVar3.cKv();
                    return 0;
                case 4:
                    adr.wsN = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    adr.wsO = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    adr.wsP = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    adr.wsQ = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    adr.wsR = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    adr.kPy = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    adr.fHQ = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    adr.title = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    adr.kPB = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    adr.kPC = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    adr.kQL = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    adr.kPA = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    adr.hdx = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    adr.qur = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    adr.qus = aVar3.AEQ.readString();
                    return 0;
                case 19:
                    adr.qut = aVar3.AEQ.readString();
                    return 0;
                case 20:
                    adr.quu = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    adr.ceA = aVar3.AEQ.rz();
                    return 0;
                case 22:
                    adr.quw = aVar3.AEQ.readString();
                    return 0;
                case 23:
                    adr.wsS = aVar3.AEQ.readString();
                    return 0;
                case 24:
                    adr.qux = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
