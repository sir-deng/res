package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ahv extends bek {
    public String hds;
    public boolean lVd;
    public LinkedList<wk> vNK = new LinkedList();
    public LinkedList<String> wvO = new LinkedList();
    public String wvP;
    public String wvQ;
    public boolean wvS;
    public LinkedList<cdz> wvV = new LinkedList();
    public LinkedList<cea> wvW = new LinkedList();
    public String wvX;
    public String wvY;
    public String wvZ;
    public String wwa;
    public boolean wwb;
    public int wwc;
    public String wwd;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wvX == null) {
                throw new b("Not all required fields were included: championcoverurl");
            } else if (this.wvY == null) {
                throw new b("Not all required fields were included: championmotto");
            } else if (this.hds == null) {
                throw new b("Not all required fields were included: rankid");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                aVar.d(2, 8, this.wvV);
                aVar.d(3, 8, this.wvW);
                aVar.d(4, 1, this.wvO);
                if (this.wvX != null) {
                    aVar.g(5, this.wvX);
                }
                if (this.wvY != null) {
                    aVar.g(6, this.wvY);
                }
                if (this.hds != null) {
                    aVar.g(7, this.hds);
                }
                if (this.wvZ != null) {
                    aVar.g(8, this.wvZ);
                }
                if (this.wvP != null) {
                    aVar.g(9, this.wvP);
                }
                aVar.am(10, this.lVd);
                if (this.wvQ != null) {
                    aVar.g(11, this.wvQ);
                }
                aVar.d(12, 8, this.vNK);
                aVar.am(13, this.wvS);
                if (this.wwa != null) {
                    aVar.g(14, this.wwa);
                }
                aVar.am(15, this.wwb);
                aVar.fX(16, this.wwc);
                if (this.wwd == null) {
                    return 0;
                }
                aVar.g(17, this.wwd);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((fW + e.a.a.a.c(2, 8, this.wvV)) + e.a.a.a.c(3, 8, this.wvW)) + e.a.a.a.c(4, 1, this.wvO);
            if (this.wvX != null) {
                fW += e.a.a.b.b.a.h(5, this.wvX);
            }
            if (this.wvY != null) {
                fW += e.a.a.b.b.a.h(6, this.wvY);
            }
            if (this.hds != null) {
                fW += e.a.a.b.b.a.h(7, this.hds);
            }
            if (this.wvZ != null) {
                fW += e.a.a.b.b.a.h(8, this.wvZ);
            }
            if (this.wvP != null) {
                fW += e.a.a.b.b.a.h(9, this.wvP);
            }
            fW += e.a.a.b.b.a.dX(10) + 1;
            if (this.wvQ != null) {
                fW += e.a.a.b.b.a.h(11, this.wvQ);
            }
            fW = (fW + e.a.a.a.c(12, 8, this.vNK)) + (e.a.a.b.b.a.dX(13) + 1);
            if (this.wwa != null) {
                fW += e.a.a.b.b.a.h(14, this.wwa);
            }
            fW = (fW + (e.a.a.b.b.a.dX(15) + 1)) + e.a.a.a.fU(16, this.wwc);
            if (this.wwd != null) {
                fW += e.a.a.b.b.a.h(17, this.wwd);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wvV.clear();
            this.wvW.clear();
            this.wvO.clear();
            this.vNK.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wvX == null) {
                throw new b("Not all required fields were included: championcoverurl");
            } else if (this.wvY == null) {
                throw new b("Not all required fields were included: championmotto");
            } else if (this.hds != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: rankid");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ahv ahv = (ahv) objArr[1];
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
                        ahv.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new cdz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ahv.wvV.add(fiVar);
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new cea();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ahv.wvW.add(fiVar);
                    }
                    return 0;
                case 4:
                    ahv.wvO.add(aVar3.AEQ.readString());
                    return 0;
                case 5:
                    ahv.wvX = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    ahv.wvY = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    ahv.hds = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    ahv.wvZ = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    ahv.wvP = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    ahv.lVd = aVar3.cKv();
                    return 0;
                case 11:
                    ahv.wvQ = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new wk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ahv.vNK.add(fiVar);
                    }
                    return 0;
                case 13:
                    ahv.wvS = aVar3.cKv();
                    return 0;
                case 14:
                    ahv.wwa = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    ahv.wwb = aVar3.cKv();
                    return 0;
                case 16:
                    ahv.wwc = aVar3.AEQ.rz();
                    return 0;
                case 17:
                    ahv.wwd = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
