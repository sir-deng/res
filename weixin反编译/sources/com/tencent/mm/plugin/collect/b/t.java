package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.bp.a;
import e.a.a.b;

public class t extends a {
    public int cRQ;
    public String fqK;
    public String fvD;
    public String gDt;
    public double loS;
    public String loT;
    public int msgType;
    public int scene;
    public int status;
    public String type;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            } else if (this.fvD == null) {
                throw new b("Not all required fields were included: transactionId");
            } else if (this.fqK == null) {
                throw new b("Not all required fields were included: feeType");
            } else {
                if (this.username != null) {
                    aVar.g(1, this.username);
                }
                if (this.fvD != null) {
                    aVar.g(2, this.fvD);
                }
                aVar.b(3, this.loS);
                if (this.fqK != null) {
                    aVar.g(4, this.fqK);
                }
                aVar.fX(5, this.cRQ);
                aVar.fX(6, this.scene);
                aVar.fX(7, this.status);
                if (this.gDt != null) {
                    aVar.g(8, this.gDt);
                }
                if (this.loT != null) {
                    aVar.g(9, this.loT);
                }
                aVar.fX(10, this.msgType);
                if (this.type == null) {
                    return 0;
                }
                aVar.g(11, this.type);
                return 0;
            }
        } else if (i == 1) {
            if (this.username != null) {
                h = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            if (this.fvD != null) {
                h += e.a.a.b.b.a.h(2, this.fvD);
            }
            h += e.a.a.b.b.a.dX(3) + 8;
            if (this.fqK != null) {
                h += e.a.a.b.b.a.h(4, this.fqK);
            }
            h = ((h + e.a.a.a.fU(5, this.cRQ)) + e.a.a.a.fU(6, this.scene)) + e.a.a.a.fU(7, this.status);
            if (this.gDt != null) {
                h += e.a.a.b.b.a.h(8, this.gDt);
            }
            if (this.loT != null) {
                h += e.a.a.b.b.a.h(9, this.loT);
            }
            h += e.a.a.a.fU(10, this.msgType);
            if (this.type != null) {
                h += e.a.a.b.b.a.h(11, this.type);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            } else if (this.fvD == null) {
                throw new b("Not all required fields were included: transactionId");
            } else if (this.fqK != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: feeType");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.username = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    tVar.fvD = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    tVar.loS = aVar3.AEQ.readDouble();
                    return 0;
                case 4:
                    tVar.fqK = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    tVar.cRQ = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    tVar.scene = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    tVar.status = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    tVar.gDt = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    tVar.loT = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    tVar.msgType = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    tVar.type = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
