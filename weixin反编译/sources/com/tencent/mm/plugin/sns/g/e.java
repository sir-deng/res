package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bp.a;
import com.tencent.mm.protocal.c.bkp;
import e.a.a.b;
import java.util.LinkedList;

public final class e extends a {
    public bkp qZK;
    public String rgT;
    public int rgU;
    public String rgV;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.rgT == null) {
                throw new b("Not all required fields were included: clientID");
            } else if (this.qZK == null) {
                throw new b("Not all required fields were included: actionGroup");
            } else {
                if (this.rgT != null) {
                    aVar.g(1, this.rgT);
                }
                if (this.qZK != null) {
                    aVar.fZ(2, this.qZK.bkL());
                    this.qZK.a(aVar);
                }
                aVar.fX(3, this.rgU);
                if (this.rgV == null) {
                    return 0;
                }
                aVar.g(4, this.rgV);
                return 0;
            }
        } else if (i == 1) {
            if (this.rgT != null) {
                h = e.a.a.b.b.a.h(1, this.rgT) + 0;
            } else {
                h = 0;
            }
            if (this.qZK != null) {
                h += e.a.a.a.fW(2, this.qZK.bkL());
            }
            h += e.a.a.a.fU(3, this.rgU);
            if (this.rgV != null) {
                h += e.a.a.b.b.a.h(4, this.rgV);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.rgT == null) {
                throw new b("Not all required fields were included: clientID");
            } else if (this.qZK != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: actionGroup");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.rgT = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bkp = new bkp();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bkp.a(aVar4, bkp, a.a(aVar4))) {
                        }
                        eVar.qZK = bkp;
                    }
                    return 0;
                case 3:
                    eVar.rgU = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    eVar.rgV = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
