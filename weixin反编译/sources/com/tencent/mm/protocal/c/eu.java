package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class eu extends a implements bkb {
    public String ID;
    public String vQK;
    public int vQL;
    public bes vQM;
    public String vQN;
    public int vQO;
    public String vQP;
    public String vQQ;
    public bes vQt;

    public final int getRet() {
        return this.vQL;
    }

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQM == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            } else if (this.vQt == null) {
                throw new b("Not all required fields were included: Key");
            } else {
                aVar.fX(1, this.vQL);
                if (this.vQM != null) {
                    aVar.fZ(2, this.vQM.bkL());
                    this.vQM.a(aVar);
                }
                if (this.vQN != null) {
                    aVar.g(3, this.vQN);
                }
                if (this.vQt != null) {
                    aVar.fZ(4, this.vQt.bkL());
                    this.vQt.a(aVar);
                }
                if (this.vQP != null) {
                    aVar.g(5, this.vQP);
                }
                if (this.vQQ != null) {
                    aVar.g(6, this.vQQ);
                }
                aVar.fX(7, this.vQO);
                if (this.ID != null) {
                    aVar.g(8, this.ID);
                }
                if (this.vQK != null) {
                    aVar.g(9, this.vQK);
                }
                return 0;
            }
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vQL) + 0;
            if (this.vQM != null) {
                fU += e.a.a.a.fW(2, this.vQM.bkL());
            }
            if (this.vQN != null) {
                fU += e.a.a.b.b.a.h(3, this.vQN);
            }
            if (this.vQt != null) {
                fU += e.a.a.a.fW(4, this.vQt.bkL());
            }
            if (this.vQP != null) {
                fU += e.a.a.b.b.a.h(5, this.vQP);
            }
            if (this.vQQ != null) {
                fU += e.a.a.b.b.a.h(6, this.vQQ);
            }
            fU += e.a.a.a.fU(7, this.vQO);
            if (this.ID != null) {
                fU += e.a.a.b.b.a.h(8, this.ID);
            }
            if (this.vQK != null) {
                return fU + e.a.a.b.b.a.h(9, this.vQK);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.vQM == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            } else if (this.vQt != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Key");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            eu euVar = (eu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bes;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    euVar.vQL = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        euVar.vQM = bes;
                    }
                    return 0;
                case 3:
                    euVar.vQN = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        euVar.vQt = bes;
                    }
                    return 0;
                case 5:
                    euVar.vQP = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    euVar.vQQ = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    euVar.vQO = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    euVar.ID = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    euVar.vQK = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
