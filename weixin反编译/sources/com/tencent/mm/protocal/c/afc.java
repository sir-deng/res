package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class afc extends bek {
    public String nkL;
    public String nkW;
    public bes vOw;
    public LinkedList<sf> vSb = new LinkedList();
    public String vSi;
    public String whR;
    public LinkedList<sx> wrN = new LinkedList();
    public String wtQ;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wtQ == null) {
                throw new b("Not all required fields were included: BannerUrl");
            } else if (this.nkW == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.nkL == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.whR == null) {
                throw new b("Not all required fields were included: HeadUrl");
            } else if (this.vSi == null) {
                throw new b("Not all required fields were included: BizName");
            } else if (this.vOw == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                if (this.wtQ != null) {
                    aVar.g(2, this.wtQ);
                }
                if (this.nkW != null) {
                    aVar.g(3, this.nkW);
                }
                if (this.nkL != null) {
                    aVar.g(4, this.nkL);
                }
                if (this.whR != null) {
                    aVar.g(5, this.whR);
                }
                if (this.vSi != null) {
                    aVar.g(6, this.vSi);
                }
                aVar.d(7, 8, this.wrN);
                if (this.vOw != null) {
                    aVar.fZ(8, this.vOw.bkL());
                    this.vOw.a(aVar);
                }
                aVar.d(9, 8, this.vSb);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wtQ != null) {
                fW += e.a.a.b.b.a.h(2, this.wtQ);
            }
            if (this.nkW != null) {
                fW += e.a.a.b.b.a.h(3, this.nkW);
            }
            if (this.nkL != null) {
                fW += e.a.a.b.b.a.h(4, this.nkL);
            }
            if (this.whR != null) {
                fW += e.a.a.b.b.a.h(5, this.whR);
            }
            if (this.vSi != null) {
                fW += e.a.a.b.b.a.h(6, this.vSi);
            }
            fW += e.a.a.a.c(7, 8, this.wrN);
            if (this.vOw != null) {
                fW += e.a.a.a.fW(8, this.vOw.bkL());
            }
            return fW + e.a.a.a.c(9, 8, this.vSb);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wrN.clear();
            this.vSb.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.wtQ == null) {
                throw new b("Not all required fields were included: BannerUrl");
            } else if (this.nkW == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.nkL == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.whR == null) {
                throw new b("Not all required fields were included: HeadUrl");
            } else if (this.vSi == null) {
                throw new b("Not all required fields were included: BizName");
            } else if (this.vOw != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afc afc = (afc) objArr[1];
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
                        afc.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    afc.wtQ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    afc.nkW = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    afc.nkL = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    afc.whR = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    afc.vSi = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new sx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        afc.wrN.add(fiVar);
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
                        afc.vOw = fiVar;
                    }
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new sf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        afc.vSb.add(fiVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
