package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class dz extends a {
    public int lTO;
    public String vMn;
    public sc vPP;
    public bes vPQ;
    public bes vPR;
    public int vPS;
    public bes vPT;
    public byl vPU;
    public ccb vPV;
    public bes vPW;
    public bes vPX;
    public String vPY;
    public bes vPZ;
    public String vQa;
    public bjx vQb;
    public String vQc;
    public int vQd;
    public int vQe;
    public int vQf;
    public int vQg;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPP == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.vPQ == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.vPR == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else {
                aVar.fX(1, this.lTO);
                if (this.vPP != null) {
                    aVar.fZ(2, this.vPP.bkL());
                    this.vPP.a(aVar);
                }
                if (this.vPQ != null) {
                    aVar.fZ(3, this.vPQ.bkL());
                    this.vPQ.a(aVar);
                }
                if (this.vPR != null) {
                    aVar.fZ(4, this.vPR.bkL());
                    this.vPR.a(aVar);
                }
                aVar.fX(5, this.vPS);
                if (this.vPT != null) {
                    aVar.fZ(6, this.vPT.bkL());
                    this.vPT.a(aVar);
                }
                if (this.vPU != null) {
                    aVar.fZ(7, this.vPU.bkL());
                    this.vPU.a(aVar);
                }
                if (this.vPV != null) {
                    aVar.fZ(8, this.vPV.bkL());
                    this.vPV.a(aVar);
                }
                if (this.vPW != null) {
                    aVar.fZ(9, this.vPW.bkL());
                    this.vPW.a(aVar);
                }
                if (this.vPX != null) {
                    aVar.fZ(10, this.vPX.bkL());
                    this.vPX.a(aVar);
                }
                if (this.vPY != null) {
                    aVar.g(11, this.vPY);
                }
                if (this.vPZ != null) {
                    aVar.fZ(12, this.vPZ.bkL());
                    this.vPZ.a(aVar);
                }
                if (this.vQa != null) {
                    aVar.g(14, this.vQa);
                }
                if (this.vQb != null) {
                    aVar.fZ(15, this.vQb.bkL());
                    this.vQb.a(aVar);
                }
                if (this.vQc != null) {
                    aVar.g(16, this.vQc);
                }
                aVar.fX(17, this.vQd);
                aVar.fX(18, this.vQe);
                aVar.fX(19, this.vQf);
                if (this.vMn != null) {
                    aVar.g(20, this.vMn);
                }
                aVar.fX(21, this.vQg);
                return 0;
            }
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.lTO) + 0;
            if (this.vPP != null) {
                fU += e.a.a.a.fW(2, this.vPP.bkL());
            }
            if (this.vPQ != null) {
                fU += e.a.a.a.fW(3, this.vPQ.bkL());
            }
            if (this.vPR != null) {
                fU += e.a.a.a.fW(4, this.vPR.bkL());
            }
            fU += e.a.a.a.fU(5, this.vPS);
            if (this.vPT != null) {
                fU += e.a.a.a.fW(6, this.vPT.bkL());
            }
            if (this.vPU != null) {
                fU += e.a.a.a.fW(7, this.vPU.bkL());
            }
            if (this.vPV != null) {
                fU += e.a.a.a.fW(8, this.vPV.bkL());
            }
            if (this.vPW != null) {
                fU += e.a.a.a.fW(9, this.vPW.bkL());
            }
            if (this.vPX != null) {
                fU += e.a.a.a.fW(10, this.vPX.bkL());
            }
            if (this.vPY != null) {
                fU += e.a.a.b.b.a.h(11, this.vPY);
            }
            if (this.vPZ != null) {
                fU += e.a.a.a.fW(12, this.vPZ.bkL());
            }
            if (this.vQa != null) {
                fU += e.a.a.b.b.a.h(14, this.vQa);
            }
            if (this.vQb != null) {
                fU += e.a.a.a.fW(15, this.vQb.bkL());
            }
            if (this.vQc != null) {
                fU += e.a.a.b.b.a.h(16, this.vQc);
            }
            fU = ((fU + e.a.a.a.fU(17, this.vQd)) + e.a.a.a.fU(18, this.vQe)) + e.a.a.a.fU(19, this.vQf);
            if (this.vMn != null) {
                fU += e.a.a.b.b.a.h(20, this.vMn);
            }
            return fU + e.a.a.a.fU(21, this.vQg);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.vPP == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.vPQ == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.vPR != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AutoAuthKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dz dzVar = (dz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a scVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dzVar.lTO = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        scVar = new sc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = scVar.a(aVar4, scVar, a.a(aVar4))) {
                        }
                        dzVar.vPP = scVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        scVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = scVar.a(aVar4, scVar, a.a(aVar4))) {
                        }
                        dzVar.vPQ = scVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        scVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = scVar.a(aVar4, scVar, a.a(aVar4))) {
                        }
                        dzVar.vPR = scVar;
                    }
                    return 0;
                case 5:
                    dzVar.vPS = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        scVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = scVar.a(aVar4, scVar, a.a(aVar4))) {
                        }
                        dzVar.vPT = scVar;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        scVar = new byl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = scVar.a(aVar4, scVar, a.a(aVar4))) {
                        }
                        dzVar.vPU = scVar;
                    }
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        scVar = new ccb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = scVar.a(aVar4, scVar, a.a(aVar4))) {
                        }
                        dzVar.vPV = scVar;
                    }
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        scVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = scVar.a(aVar4, scVar, a.a(aVar4))) {
                        }
                        dzVar.vPW = scVar;
                    }
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        scVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = scVar.a(aVar4, scVar, a.a(aVar4))) {
                        }
                        dzVar.vPX = scVar;
                    }
                    return 0;
                case 11:
                    dzVar.vPY = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        scVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = scVar.a(aVar4, scVar, a.a(aVar4))) {
                        }
                        dzVar.vPZ = scVar;
                    }
                    return 0;
                case 14:
                    dzVar.vQa = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        scVar = new bjx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = scVar.a(aVar4, scVar, a.a(aVar4))) {
                        }
                        dzVar.vQb = scVar;
                    }
                    return 0;
                case 16:
                    dzVar.vQc = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    dzVar.vQd = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    dzVar.vQe = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    dzVar.vQf = aVar3.AEQ.rz();
                    return 0;
                case 20:
                    dzVar.vMn = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    dzVar.vQg = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
