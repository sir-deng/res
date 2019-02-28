package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class biz extends a {
    public int hxe;
    public String hxf;
    public String hxg;
    public String hxh;
    public String hxn;
    public String hxo;
    public String kyG;
    public String kzN;
    public int vNP;
    public String wCp;
    public int wCq;
    public String wCr;
    public String wCs;
    public String wCt;
    public int wCu;
    public int wCv;
    public bmk wCw;
    public py wCx;
    public int wSW;
    public bes wSX;
    public int wSY;
    public String wbY;
    public String wbZ;
    public String woW;
    public String wuV;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wSX == null) {
                throw new b("Not all required fields were included: ImgBuffer");
            }
            if (this.kyG != null) {
                aVar.g(1, this.kyG);
            }
            if (this.kzN != null) {
                aVar.g(2, this.kzN);
            }
            if (this.hxf != null) {
                aVar.g(3, this.hxf);
            }
            if (this.hxg != null) {
                aVar.g(4, this.hxg);
            }
            if (this.hxh != null) {
                aVar.g(5, this.hxh);
            }
            if (this.wCp != null) {
                aVar.g(6, this.wCp);
            }
            aVar.fX(7, this.hxe);
            aVar.fX(8, this.vNP);
            aVar.fX(9, this.wSW);
            if (this.wSX != null) {
                aVar.fZ(10, this.wSX.bkL());
                this.wSX.a(aVar);
            }
            aVar.fX(11, this.wSY);
            if (this.wCs != null) {
                aVar.g(12, this.wCs);
            }
            if (this.wCt != null) {
                aVar.g(13, this.wCt);
            }
            aVar.fX(14, this.wCu);
            aVar.fX(15, this.wCq);
            if (this.wCr != null) {
                aVar.g(16, this.wCr);
            }
            if (this.wuV != null) {
                aVar.g(17, this.wuV);
            }
            aVar.fX(21, this.wCv);
            if (this.wCw != null) {
                aVar.fZ(22, this.wCw.bkL());
                this.wCw.a(aVar);
            }
            if (this.hxn != null) {
                aVar.g(23, this.hxn);
            }
            if (this.wbY != null) {
                aVar.g(24, this.wbY);
            }
            if (this.wbZ != null) {
                aVar.g(25, this.wbZ);
            }
            if (this.hxo != null) {
                aVar.g(26, this.hxo);
            }
            if (this.wCx != null) {
                aVar.fZ(27, this.wCx.bkL());
                this.wCx.a(aVar);
            }
            if (this.woW == null) {
                return 0;
            }
            aVar.g(28, this.woW);
            return 0;
        } else if (i == 1) {
            if (this.kyG != null) {
                h = e.a.a.b.b.a.h(1, this.kyG) + 0;
            } else {
                h = 0;
            }
            if (this.kzN != null) {
                h += e.a.a.b.b.a.h(2, this.kzN);
            }
            if (this.hxf != null) {
                h += e.a.a.b.b.a.h(3, this.hxf);
            }
            if (this.hxg != null) {
                h += e.a.a.b.b.a.h(4, this.hxg);
            }
            if (this.hxh != null) {
                h += e.a.a.b.b.a.h(5, this.hxh);
            }
            if (this.wCp != null) {
                h += e.a.a.b.b.a.h(6, this.wCp);
            }
            h = ((h + e.a.a.a.fU(7, this.hxe)) + e.a.a.a.fU(8, this.vNP)) + e.a.a.a.fU(9, this.wSW);
            if (this.wSX != null) {
                h += e.a.a.a.fW(10, this.wSX.bkL());
            }
            h += e.a.a.a.fU(11, this.wSY);
            if (this.wCs != null) {
                h += e.a.a.b.b.a.h(12, this.wCs);
            }
            if (this.wCt != null) {
                h += e.a.a.b.b.a.h(13, this.wCt);
            }
            h = (h + e.a.a.a.fU(14, this.wCu)) + e.a.a.a.fU(15, this.wCq);
            if (this.wCr != null) {
                h += e.a.a.b.b.a.h(16, this.wCr);
            }
            if (this.wuV != null) {
                h += e.a.a.b.b.a.h(17, this.wuV);
            }
            h += e.a.a.a.fU(21, this.wCv);
            if (this.wCw != null) {
                h += e.a.a.a.fW(22, this.wCw.bkL());
            }
            if (this.hxn != null) {
                h += e.a.a.b.b.a.h(23, this.hxn);
            }
            if (this.wbY != null) {
                h += e.a.a.b.b.a.h(24, this.wbY);
            }
            if (this.wbZ != null) {
                h += e.a.a.b.b.a.h(25, this.wbZ);
            }
            if (this.hxo != null) {
                h += e.a.a.b.b.a.h(26, this.hxo);
            }
            if (this.wCx != null) {
                h += e.a.a.a.fW(27, this.wCx.bkL());
            }
            if (this.woW != null) {
                h += e.a.a.b.b.a.h(28, this.woW);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wSX != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ImgBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            biz biz = (biz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bes;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    biz.kyG = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    biz.kzN = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    biz.hxf = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    biz.hxg = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    biz.hxh = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    biz.wCp = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    biz.hxe = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    biz.vNP = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    biz.wSW = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        biz.wSX = bes;
                    }
                    return 0;
                case 11:
                    biz.wSY = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    biz.wCs = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    biz.wCt = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    biz.wCu = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    biz.wCq = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    biz.wCr = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    biz.wuV = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    biz.wCv = aVar3.AEQ.rz();
                    return 0;
                case 22:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new bmk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        biz.wCw = bes;
                    }
                    return 0;
                case 23:
                    biz.hxn = aVar3.AEQ.readString();
                    return 0;
                case 24:
                    biz.wbY = aVar3.AEQ.readString();
                    return 0;
                case 25:
                    biz.wbZ = aVar3.AEQ.readString();
                    return 0;
                case 26:
                    biz.hxo = aVar3.AEQ.readString();
                    return 0;
                case 27:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bes = new py();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        biz.wCx = bes;
                    }
                    return 0;
                case 28:
                    biz.woW = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
