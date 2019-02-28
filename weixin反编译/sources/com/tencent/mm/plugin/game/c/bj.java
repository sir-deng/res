package com.tencent.mm.plugin.game.c;

import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.fi;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bj extends bek {
    public ao nnN;
    public ay nnO;
    public j nnP;
    public dr nnQ;
    public ec nnR;
    public am nnS;
    public cq nnT;
    public cp nnU;
    public cw nnV;
    public q nnW;
    public t nnX;
    public String nnY;
    public int nnZ;
    public String nnr;
    public boolean noa;

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
            if (this.nnN != null) {
                aVar.fZ(2, this.nnN.bkL());
                this.nnN.a(aVar);
            }
            if (this.nnO != null) {
                aVar.fZ(3, this.nnO.bkL());
                this.nnO.a(aVar);
            }
            if (this.nnr != null) {
                aVar.g(4, this.nnr);
            }
            if (this.nnP != null) {
                aVar.fZ(5, this.nnP.bkL());
                this.nnP.a(aVar);
            }
            if (this.nnQ != null) {
                aVar.fZ(6, this.nnQ.bkL());
                this.nnQ.a(aVar);
            }
            if (this.nnR != null) {
                aVar.fZ(7, this.nnR.bkL());
                this.nnR.a(aVar);
            }
            if (this.nnS != null) {
                aVar.fZ(8, this.nnS.bkL());
                this.nnS.a(aVar);
            }
            if (this.nnT != null) {
                aVar.fZ(9, this.nnT.bkL());
                this.nnT.a(aVar);
            }
            if (this.nnU != null) {
                aVar.fZ(10, this.nnU.bkL());
                this.nnU.a(aVar);
            }
            if (this.nnV != null) {
                aVar.fZ(11, this.nnV.bkL());
                this.nnV.a(aVar);
            }
            if (this.nnW != null) {
                aVar.fZ(12, this.nnW.bkL());
                this.nnW.a(aVar);
            }
            if (this.nnX != null) {
                aVar.fZ(13, this.nnX.bkL());
                this.nnX.a(aVar);
            }
            if (this.nnY != null) {
                aVar.g(14, this.nnY);
            }
            aVar.fX(15, this.nnZ);
            aVar.am(16, this.noa);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.nnN != null) {
                fW += e.a.a.a.fW(2, this.nnN.bkL());
            }
            if (this.nnO != null) {
                fW += e.a.a.a.fW(3, this.nnO.bkL());
            }
            if (this.nnr != null) {
                fW += e.a.a.b.b.a.h(4, this.nnr);
            }
            if (this.nnP != null) {
                fW += e.a.a.a.fW(5, this.nnP.bkL());
            }
            if (this.nnQ != null) {
                fW += e.a.a.a.fW(6, this.nnQ.bkL());
            }
            if (this.nnR != null) {
                fW += e.a.a.a.fW(7, this.nnR.bkL());
            }
            if (this.nnS != null) {
                fW += e.a.a.a.fW(8, this.nnS.bkL());
            }
            if (this.nnT != null) {
                fW += e.a.a.a.fW(9, this.nnT.bkL());
            }
            if (this.nnU != null) {
                fW += e.a.a.a.fW(10, this.nnU.bkL());
            }
            if (this.nnV != null) {
                fW += e.a.a.a.fW(11, this.nnV.bkL());
            }
            if (this.nnW != null) {
                fW += e.a.a.a.fW(12, this.nnW.bkL());
            }
            if (this.nnX != null) {
                fW += e.a.a.a.fW(13, this.nnX.bkL());
            }
            if (this.nnY != null) {
                fW += e.a.a.b.b.a.h(14, this.nnY);
            }
            return (fW + e.a.a.a.fU(15, this.nnZ)) + (e.a.a.b.b.a.dX(16) + 1);
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
            bj bjVar = (bj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
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
                        bjVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ao();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjVar.nnN = fiVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ay();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjVar.nnO = fiVar;
                    }
                    return 0;
                case 4:
                    bjVar.nnr = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new j();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjVar.nnP = fiVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new dr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjVar.nnQ = fiVar;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ec();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjVar.nnR = fiVar;
                    }
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new am();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjVar.nnS = fiVar;
                    }
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new cq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjVar.nnT = fiVar;
                    }
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new cp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjVar.nnU = fiVar;
                    }
                    return 0;
                case 11:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new cw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjVar.nnV = fiVar;
                    }
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new q();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjVar.nnW = fiVar;
                    }
                    return 0;
                case 13:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjVar.nnX = fiVar;
                    }
                    return 0;
                case 14:
                    bjVar.nnY = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    bjVar.nnZ = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    bjVar.noa = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
