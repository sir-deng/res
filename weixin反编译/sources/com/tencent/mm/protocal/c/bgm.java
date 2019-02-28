package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bgm extends a {
    public int hxe;
    public String hxf;
    public String hxg;
    public String hxh;
    public int hxi;
    public String hxj;
    public String hxn;
    public int wCq;
    public String wCr;
    public String wCs;
    public String wCt;
    public int wCu;
    public pz wSd;
    public String wbY;
    public String wbZ;
    public bet wfM;
    public bet wzM;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wfM == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.wzM == null) {
                throw new b("Not all required fields were included: NickName");
            } else {
                if (this.wfM != null) {
                    aVar.fZ(1, this.wfM.bkL());
                    this.wfM.a(aVar);
                }
                if (this.wzM != null) {
                    aVar.fZ(2, this.wzM.bkL());
                    this.wzM.a(aVar);
                }
                aVar.fX(3, this.hxe);
                if (this.hxf != null) {
                    aVar.g(4, this.hxf);
                }
                if (this.hxg != null) {
                    aVar.g(5, this.hxg);
                }
                if (this.hxh != null) {
                    aVar.g(6, this.hxh);
                }
                aVar.fX(7, this.hxi);
                aVar.fX(8, this.wCq);
                if (this.wCr != null) {
                    aVar.g(9, this.wCr);
                }
                if (this.wCs != null) {
                    aVar.g(10, this.wCs);
                }
                if (this.hxj != null) {
                    aVar.g(11, this.hxj);
                }
                if (this.wCt != null) {
                    aVar.g(12, this.wCt);
                }
                aVar.fX(13, this.wCu);
                if (this.hxn != null) {
                    aVar.g(14, this.hxn);
                }
                if (this.wSd != null) {
                    aVar.fZ(15, this.wSd.bkL());
                    this.wSd.a(aVar);
                }
                if (this.wbY != null) {
                    aVar.g(16, this.wbY);
                }
                if (this.wbZ == null) {
                    return 0;
                }
                aVar.g(17, this.wbZ);
                return 0;
            }
        } else if (i == 1) {
            if (this.wfM != null) {
                fW = e.a.a.a.fW(1, this.wfM.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wzM != null) {
                fW += e.a.a.a.fW(2, this.wzM.bkL());
            }
            fW += e.a.a.a.fU(3, this.hxe);
            if (this.hxf != null) {
                fW += e.a.a.b.b.a.h(4, this.hxf);
            }
            if (this.hxg != null) {
                fW += e.a.a.b.b.a.h(5, this.hxg);
            }
            if (this.hxh != null) {
                fW += e.a.a.b.b.a.h(6, this.hxh);
            }
            fW = (fW + e.a.a.a.fU(7, this.hxi)) + e.a.a.a.fU(8, this.wCq);
            if (this.wCr != null) {
                fW += e.a.a.b.b.a.h(9, this.wCr);
            }
            if (this.wCs != null) {
                fW += e.a.a.b.b.a.h(10, this.wCs);
            }
            if (this.hxj != null) {
                fW += e.a.a.b.b.a.h(11, this.hxj);
            }
            if (this.wCt != null) {
                fW += e.a.a.b.b.a.h(12, this.wCt);
            }
            fW += e.a.a.a.fU(13, this.wCu);
            if (this.hxn != null) {
                fW += e.a.a.b.b.a.h(14, this.hxn);
            }
            if (this.wSd != null) {
                fW += e.a.a.a.fW(15, this.wSd.bkL());
            }
            if (this.wbY != null) {
                fW += e.a.a.b.b.a.h(16, this.wbY);
            }
            if (this.wbZ != null) {
                fW += e.a.a.b.b.a.h(17, this.wbZ);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wfM == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.wzM != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bgm bgm = (bgm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bet;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bgm.wfM = bet;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bgm.wzM = bet;
                    }
                    return 0;
                case 3:
                    bgm.hxe = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bgm.hxf = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bgm.hxg = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bgm.hxh = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bgm.hxi = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bgm.wCq = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bgm.wCr = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    bgm.wCs = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    bgm.hxj = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    bgm.wCt = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    bgm.wCu = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    bgm.hxn = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new pz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bgm.wSd = bet;
                    }
                    return 0;
                case 16:
                    bgm.wbY = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    bgm.wbZ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
