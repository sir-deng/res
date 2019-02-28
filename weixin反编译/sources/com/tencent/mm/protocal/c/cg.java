package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cg extends a {
    public int fDM;
    public int pPM;
    public String pQZ;
    public int scene;
    public String vOg;
    public String vOh;
    public String vOi;
    public wd vOj;
    public String vOk;
    public int vOl;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vOg == null) {
                throw new b("Not all required fields were included: f2f_id");
            } else if (this.vOi == null) {
                throw new b("Not all required fields were included: payok_checksign");
            } else {
                if (this.vOg != null) {
                    aVar.g(1, this.vOg);
                }
                if (this.vOh != null) {
                    aVar.g(2, this.vOh);
                }
                aVar.fX(3, this.fDM);
                aVar.fX(4, this.pPM);
                aVar.fX(5, this.scene);
                if (this.vOi != null) {
                    aVar.g(6, this.vOi);
                }
                if (this.vOj != null) {
                    aVar.fZ(7, this.vOj.bkL());
                    this.vOj.a(aVar);
                }
                if (this.vOk != null) {
                    aVar.g(8, this.vOk);
                }
                if (this.pQZ != null) {
                    aVar.g(9, this.pQZ);
                }
                aVar.fX(10, this.vOl);
                return 0;
            }
        } else if (i == 1) {
            if (this.vOg != null) {
                h = e.a.a.b.b.a.h(1, this.vOg) + 0;
            } else {
                h = 0;
            }
            if (this.vOh != null) {
                h += e.a.a.b.b.a.h(2, this.vOh);
            }
            h = ((h + e.a.a.a.fU(3, this.fDM)) + e.a.a.a.fU(4, this.pPM)) + e.a.a.a.fU(5, this.scene);
            if (this.vOi != null) {
                h += e.a.a.b.b.a.h(6, this.vOi);
            }
            if (this.vOj != null) {
                h += e.a.a.a.fW(7, this.vOj.bkL());
            }
            if (this.vOk != null) {
                h += e.a.a.b.b.a.h(8, this.vOk);
            }
            if (this.pQZ != null) {
                h += e.a.a.b.b.a.h(9, this.pQZ);
            }
            return h + e.a.a.a.fU(10, this.vOl);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.vOg == null) {
                throw new b("Not all required fields were included: f2f_id");
            } else if (this.vOi != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: payok_checksign");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cg cgVar = (cg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cgVar.vOg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cgVar.vOh = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cgVar.fDM = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    cgVar.pPM = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    cgVar.scene = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    cgVar.vOi = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a wdVar = new wd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = wdVar.a(aVar4, wdVar, a.a(aVar4))) {
                        }
                        cgVar.vOj = wdVar;
                    }
                    return 0;
                case 8:
                    cgVar.vOk = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    cgVar.pQZ = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    cgVar.vOl = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
