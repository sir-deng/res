package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class r extends a {
    public String nlM;
    public String nlN;
    public String nlO;
    public ej nlP;
    public int nlQ;
    public int nlR;
    public String nlS;
    public int nlT;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlM == null) {
                throw new b("Not all required fields were included: DownloadURL");
            }
            if (this.nlM != null) {
                aVar.g(1, this.nlM);
            }
            if (this.nlN != null) {
                aVar.g(2, this.nlN);
            }
            if (this.nlO != null) {
                aVar.g(4, this.nlO);
            }
            if (this.nlP != null) {
                aVar.fZ(5, this.nlP.bkL());
                this.nlP.a(aVar);
            }
            aVar.fX(6, this.nlQ);
            aVar.fX(7, this.nlR);
            if (this.nlS != null) {
                aVar.g(8, this.nlS);
            }
            aVar.fX(9, this.nlT);
            return 0;
        } else if (i == 1) {
            if (this.nlM != null) {
                h = e.a.a.b.b.a.h(1, this.nlM) + 0;
            } else {
                h = 0;
            }
            if (this.nlN != null) {
                h += e.a.a.b.b.a.h(2, this.nlN);
            }
            if (this.nlO != null) {
                h += e.a.a.b.b.a.h(4, this.nlO);
            }
            if (this.nlP != null) {
                h += e.a.a.a.fW(5, this.nlP.bkL());
            }
            h = (h + e.a.a.a.fU(6, this.nlQ)) + e.a.a.a.fU(7, this.nlR);
            if (this.nlS != null) {
                h += e.a.a.b.b.a.h(8, this.nlS);
            }
            return h + e.a.a.a.fU(9, this.nlT);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.nlM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: DownloadURL");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            r rVar = (r) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    rVar.nlM = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    rVar.nlN = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    rVar.nlO = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a ejVar = new ej();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ejVar.a(aVar4, ejVar, a.a(aVar4))) {
                        }
                        rVar.nlP = ejVar;
                    }
                    return 0;
                case 6:
                    rVar.nlQ = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    rVar.nlR = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    rVar.nlS = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    rVar.nlT = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
