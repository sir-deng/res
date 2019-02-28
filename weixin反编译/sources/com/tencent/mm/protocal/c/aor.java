package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public class aor extends a {
    public int hxe;
    public String hxf;
    public String hxg;
    public String hxh;
    public String hxj;
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
    public String wbY;
    public String wbZ;
    public String woW;
    public String wuV;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
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
            aVar.fX(9, this.wCq);
            if (this.wCr != null) {
                aVar.g(10, this.wCr);
            }
            if (this.wuV != null) {
                aVar.g(11, this.wuV);
            }
            if (this.hxj != null) {
                aVar.g(12, this.hxj);
            }
            if (this.wCs != null) {
                aVar.g(13, this.wCs);
            }
            if (this.wCt != null) {
                aVar.g(14, this.wCt);
            }
            aVar.fX(15, this.wCu);
            aVar.fX(19, this.wCv);
            if (this.wCw != null) {
                aVar.fZ(20, this.wCw.bkL());
                this.wCw.a(aVar);
            }
            if (this.hxn != null) {
                aVar.g(21, this.hxn);
            }
            if (this.wbY != null) {
                aVar.g(22, this.wbY);
            }
            if (this.wbZ != null) {
                aVar.g(23, this.wbZ);
            }
            if (this.hxo != null) {
                aVar.g(24, this.hxo);
            }
            if (this.wCx != null) {
                aVar.fZ(25, this.wCx.bkL());
                this.wCx.a(aVar);
            }
            if (this.woW == null) {
                return 0;
            }
            aVar.g(26, this.woW);
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
            h = ((h + e.a.a.a.fU(7, this.hxe)) + e.a.a.a.fU(8, this.vNP)) + e.a.a.a.fU(9, this.wCq);
            if (this.wCr != null) {
                h += e.a.a.b.b.a.h(10, this.wCr);
            }
            if (this.wuV != null) {
                h += e.a.a.b.b.a.h(11, this.wuV);
            }
            if (this.hxj != null) {
                h += e.a.a.b.b.a.h(12, this.hxj);
            }
            if (this.wCs != null) {
                h += e.a.a.b.b.a.h(13, this.wCs);
            }
            if (this.wCt != null) {
                h += e.a.a.b.b.a.h(14, this.wCt);
            }
            h = (h + e.a.a.a.fU(15, this.wCu)) + e.a.a.a.fU(19, this.wCv);
            if (this.wCw != null) {
                h += e.a.a.a.fW(20, this.wCw.bkL());
            }
            if (this.hxn != null) {
                h += e.a.a.b.b.a.h(21, this.hxn);
            }
            if (this.wbY != null) {
                h += e.a.a.b.b.a.h(22, this.wbY);
            }
            if (this.wbZ != null) {
                h += e.a.a.b.b.a.h(23, this.wbZ);
            }
            if (this.hxo != null) {
                h += e.a.a.b.b.a.h(24, this.hxo);
            }
            if (this.wCx != null) {
                h += e.a.a.a.fW(25, this.wCx.bkL());
            }
            if (this.woW != null) {
                h += e.a.a.b.b.a.h(26, this.woW);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aor aor = (aor) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bmk;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    aor.kyG = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    aor.kzN = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aor.hxf = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aor.hxg = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aor.hxh = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aor.wCp = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    aor.hxe = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    aor.vNP = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    aor.wCq = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    aor.wCr = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    aor.wuV = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    aor.hxj = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    aor.wCs = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    aor.wCt = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    aor.wCu = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    aor.wCv = aVar3.AEQ.rz();
                    return 0;
                case 20:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bmk = new bmk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmk.a(aVar4, bmk, a.a(aVar4))) {
                        }
                        aor.wCw = bmk;
                    }
                    return 0;
                case 21:
                    aor.hxn = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    aor.wbY = aVar3.AEQ.readString();
                    return 0;
                case 23:
                    aor.wbZ = aVar3.AEQ.readString();
                    return 0;
                case 24:
                    aor.hxo = aVar3.AEQ.readString();
                    return 0;
                case 25:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bmk = new py();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmk.a(aVar4, bmk, a.a(aVar4))) {
                        }
                        aor.wCx = bmk;
                    }
                    return 0;
                case 26:
                    aor.woW = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
