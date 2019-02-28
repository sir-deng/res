package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class az extends a {
    public String nkU;
    public String nlN;
    public String noG;
    public String vMJ;
    public String vMK;
    public String vML;
    public String vMM;
    public String vMN;
    public String vMO;
    public cdw vMP;
    public String vMQ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkU != null) {
                aVar.g(1, this.nkU);
            }
            if (this.vMJ != null) {
                aVar.g(2, this.vMJ);
            }
            if (this.vMK != null) {
                aVar.g(3, this.vMK);
            }
            if (this.nlN != null) {
                aVar.g(4, this.nlN);
            }
            if (this.noG != null) {
                aVar.g(5, this.noG);
            }
            if (this.vML != null) {
                aVar.g(6, this.vML);
            }
            if (this.vMM != null) {
                aVar.g(7, this.vMM);
            }
            if (this.vMN != null) {
                aVar.g(8, this.vMN);
            }
            if (this.vMO != null) {
                aVar.g(9, this.vMO);
            }
            if (this.vMP != null) {
                aVar.fZ(10, this.vMP.bkL());
                this.vMP.a(aVar);
            }
            if (this.vMQ == null) {
                return 0;
            }
            aVar.g(11, this.vMQ);
            return 0;
        } else if (i == 1) {
            if (this.nkU != null) {
                h = e.a.a.b.b.a.h(1, this.nkU) + 0;
            } else {
                h = 0;
            }
            if (this.vMJ != null) {
                h += e.a.a.b.b.a.h(2, this.vMJ);
            }
            if (this.vMK != null) {
                h += e.a.a.b.b.a.h(3, this.vMK);
            }
            if (this.nlN != null) {
                h += e.a.a.b.b.a.h(4, this.nlN);
            }
            if (this.noG != null) {
                h += e.a.a.b.b.a.h(5, this.noG);
            }
            if (this.vML != null) {
                h += e.a.a.b.b.a.h(6, this.vML);
            }
            if (this.vMM != null) {
                h += e.a.a.b.b.a.h(7, this.vMM);
            }
            if (this.vMN != null) {
                h += e.a.a.b.b.a.h(8, this.vMN);
            }
            if (this.vMO != null) {
                h += e.a.a.b.b.a.h(9, this.vMO);
            }
            if (this.vMP != null) {
                h += e.a.a.a.fW(10, this.vMP.bkL());
            }
            if (this.vMQ != null) {
                h += e.a.a.b.b.a.h(11, this.vMQ);
            }
            return h;
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
            az azVar = (az) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    azVar.nkU = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    azVar.vMJ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    azVar.vMK = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    azVar.nlN = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    azVar.noG = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    azVar.vML = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    azVar.vMM = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    azVar.vMN = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    azVar.vMO = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a cdw = new cdw();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cdw.a(aVar4, cdw, a.a(aVar4))) {
                        }
                        azVar.vMP = cdw;
                    }
                    return 0;
                case 11:
                    azVar.vMQ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
