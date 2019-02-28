package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class btt extends bea {
    public int vKI;
    public bes vRI;
    public String vTs;
    public bet vTw;
    public bes vTx;
    public int wTb;
    public bet wwh;
    public String xbu;
    public bet xbv;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.vKI);
            if (this.xbu != null) {
                aVar.g(3, this.xbu);
            }
            if (this.vTs != null) {
                aVar.g(4, this.vTs);
            }
            if (this.wwh != null) {
                aVar.fZ(5, this.wwh.bkL());
                this.wwh.a(aVar);
            }
            if (this.xbv != null) {
                aVar.fZ(6, this.xbv.bkL());
                this.xbv.a(aVar);
            }
            if (this.vTw != null) {
                aVar.fZ(7, this.vTw.bkL());
                this.vTw.a(aVar);
            }
            if (this.vTx != null) {
                aVar.fZ(8, this.vTx.bkL());
                this.vTx.a(aVar);
            }
            aVar.fX(9, this.wTb);
            if (this.vRI == null) {
                return 0;
            }
            aVar.fZ(10, this.vRI.bkL());
            this.vRI.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.vKI);
            if (this.xbu != null) {
                fW += e.a.a.b.b.a.h(3, this.xbu);
            }
            if (this.vTs != null) {
                fW += e.a.a.b.b.a.h(4, this.vTs);
            }
            if (this.wwh != null) {
                fW += e.a.a.a.fW(5, this.wwh.bkL());
            }
            if (this.xbv != null) {
                fW += e.a.a.a.fW(6, this.xbv.bkL());
            }
            if (this.vTw != null) {
                fW += e.a.a.a.fW(7, this.vTw.bkL());
            }
            if (this.vTx != null) {
                fW += e.a.a.a.fW(8, this.vTx.bkL());
            }
            fW += e.a.a.a.fU(9, this.wTb);
            if (this.vRI != null) {
                fW += e.a.a.a.fW(10, this.vRI.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btt btt = (btt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a fhVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new fh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        btt.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    btt.vKI = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    btt.xbu = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    btt.vTs = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        btt.wwh = fhVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        btt.xbv = fhVar;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        btt.vTw = fhVar;
                    }
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        btt.vTx = fhVar;
                    }
                    return 0;
                case 9:
                    btt.wTb = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        btt.vRI = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
