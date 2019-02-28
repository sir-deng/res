package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ag extends a {
    public String nkN;
    public String nlV;
    public String nlr;
    public int nlw;
    public int nlz;
    public cj nml;
    public eh nmm;
    public cx nmn;
    public cy nmo;
    public bd nmp;
    public dk nmq;
    public ax nmr;
    public p nms;
    public dc nmt;
    public dq nmu;
    public o nmv;
    public o nmw;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.nlz);
            aVar.fX(2, this.nlw);
            if (this.nlr != null) {
                aVar.g(3, this.nlr);
            }
            if (this.nlV != null) {
                aVar.g(4, this.nlV);
            }
            if (this.nkN != null) {
                aVar.g(17, this.nkN);
            }
            if (this.nml != null) {
                aVar.fZ(5, this.nml.bkL());
                this.nml.a(aVar);
            }
            if (this.nmm != null) {
                aVar.fZ(6, this.nmm.bkL());
                this.nmm.a(aVar);
            }
            if (this.nmn != null) {
                aVar.fZ(7, this.nmn.bkL());
                this.nmn.a(aVar);
            }
            if (this.nmo != null) {
                aVar.fZ(8, this.nmo.bkL());
                this.nmo.a(aVar);
            }
            if (this.nmp != null) {
                aVar.fZ(9, this.nmp.bkL());
                this.nmp.a(aVar);
            }
            if (this.nmq != null) {
                aVar.fZ(10, this.nmq.bkL());
                this.nmq.a(aVar);
            }
            if (this.nmr != null) {
                aVar.fZ(11, this.nmr.bkL());
                this.nmr.a(aVar);
            }
            if (this.nms != null) {
                aVar.fZ(12, this.nms.bkL());
                this.nms.a(aVar);
            }
            if (this.nmt != null) {
                aVar.fZ(13, this.nmt.bkL());
                this.nmt.a(aVar);
            }
            if (this.nmu != null) {
                aVar.fZ(14, this.nmu.bkL());
                this.nmu.a(aVar);
            }
            if (this.nmv != null) {
                aVar.fZ(15, this.nmv.bkL());
                this.nmv.a(aVar);
            }
            if (this.nmw != null) {
                aVar.fZ(16, this.nmw.bkL());
                this.nmw.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.nlz) + 0) + e.a.a.a.fU(2, this.nlw);
            if (this.nlr != null) {
                fU += e.a.a.b.b.a.h(3, this.nlr);
            }
            if (this.nlV != null) {
                fU += e.a.a.b.b.a.h(4, this.nlV);
            }
            if (this.nkN != null) {
                fU += e.a.a.b.b.a.h(17, this.nkN);
            }
            if (this.nml != null) {
                fU += e.a.a.a.fW(5, this.nml.bkL());
            }
            if (this.nmm != null) {
                fU += e.a.a.a.fW(6, this.nmm.bkL());
            }
            if (this.nmn != null) {
                fU += e.a.a.a.fW(7, this.nmn.bkL());
            }
            if (this.nmo != null) {
                fU += e.a.a.a.fW(8, this.nmo.bkL());
            }
            if (this.nmp != null) {
                fU += e.a.a.a.fW(9, this.nmp.bkL());
            }
            if (this.nmq != null) {
                fU += e.a.a.a.fW(10, this.nmq.bkL());
            }
            if (this.nmr != null) {
                fU += e.a.a.a.fW(11, this.nmr.bkL());
            }
            if (this.nms != null) {
                fU += e.a.a.a.fW(12, this.nms.bkL());
            }
            if (this.nmt != null) {
                fU += e.a.a.a.fW(13, this.nmt.bkL());
            }
            if (this.nmu != null) {
                fU += e.a.a.a.fW(14, this.nmu.bkL());
            }
            if (this.nmv != null) {
                fU += e.a.a.a.fW(15, this.nmv.bkL());
            }
            if (this.nmw != null) {
                return fU + e.a.a.a.fW(16, this.nmw.bkL());
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ag agVar = (ag) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a cjVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    agVar.nlz = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    agVar.nlw = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    agVar.nlr = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    agVar.nlV = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cjVar = new cj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.nml = cjVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cjVar = new eh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.nmm = cjVar;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cjVar = new cx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.nmn = cjVar;
                    }
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cjVar = new cy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.nmo = cjVar;
                    }
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cjVar = new bd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.nmp = cjVar;
                    }
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cjVar = new dk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.nmq = cjVar;
                    }
                    return 0;
                case 11:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cjVar = new ax();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.nmr = cjVar;
                    }
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cjVar = new p();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.nms = cjVar;
                    }
                    return 0;
                case 13:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cjVar = new dc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.nmt = cjVar;
                    }
                    return 0;
                case 14:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cjVar = new dq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.nmu = cjVar;
                    }
                    return 0;
                case 15:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cjVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.nmv = cjVar;
                    }
                    return 0;
                case 16:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        cjVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        agVar.nmw = cjVar;
                    }
                    return 0;
                case 17:
                    agVar.nkN = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
