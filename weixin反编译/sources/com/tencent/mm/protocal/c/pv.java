package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class pv extends bek {
    public int lfj;
    public bes vNQ;
    public LinkedList<arj> vNu = new LinkedList();
    public bet vNv;
    public String wbY;
    public String wbZ;
    public bet wfA;
    public bet wfB;
    public bet wfy;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wfy == null) {
                throw new b("Not all required fields were included: Topic");
            } else if (this.wfA == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.wfB == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.vNv == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            } else if (this.vNQ == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.wfy != null) {
                    aVar.fZ(2, this.wfy.bkL());
                    this.wfy.a(aVar);
                }
                if (this.wfA != null) {
                    aVar.fZ(3, this.wfA.bkL());
                    this.wfA.a(aVar);
                }
                if (this.wfB != null) {
                    aVar.fZ(4, this.wfB.bkL());
                    this.wfB.a(aVar);
                }
                aVar.fX(5, this.lfj);
                aVar.d(6, 8, this.vNu);
                if (this.vNv != null) {
                    aVar.fZ(7, this.vNv.bkL());
                    this.vNv.a(aVar);
                }
                if (this.vNQ != null) {
                    aVar.fZ(8, this.vNQ.bkL());
                    this.vNQ.a(aVar);
                }
                if (this.wbY != null) {
                    aVar.g(9, this.wbY);
                }
                if (this.wbZ == null) {
                    return 0;
                }
                aVar.g(10, this.wbZ);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wfy != null) {
                fW += e.a.a.a.fW(2, this.wfy.bkL());
            }
            if (this.wfA != null) {
                fW += e.a.a.a.fW(3, this.wfA.bkL());
            }
            if (this.wfB != null) {
                fW += e.a.a.a.fW(4, this.wfB.bkL());
            }
            fW = (fW + e.a.a.a.fU(5, this.lfj)) + e.a.a.a.c(6, 8, this.vNu);
            if (this.vNv != null) {
                fW += e.a.a.a.fW(7, this.vNv.bkL());
            }
            if (this.vNQ != null) {
                fW += e.a.a.a.fW(8, this.vNQ.bkL());
            }
            if (this.wbY != null) {
                fW += e.a.a.b.b.a.h(9, this.wbY);
            }
            if (this.wbZ != null) {
                fW += e.a.a.b.b.a.h(10, this.wbZ);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vNu.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wfy == null) {
                throw new b("Not all required fields were included: Topic");
            } else if (this.wfA == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.wfB == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.vNv == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            } else if (this.vNQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            pv pvVar = (pv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
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
                        pvVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        pvVar.wfy = fiVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        pvVar.wfA = fiVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        pvVar.wfB = fiVar;
                    }
                    return 0;
                case 5:
                    pvVar.lfj = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new arj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        pvVar.vNu.add(fiVar);
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        pvVar.vNv = fiVar;
                    }
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        pvVar.vNQ = fiVar;
                    }
                    return 0;
                case 9:
                    pvVar.wbY = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    pvVar.wbZ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
