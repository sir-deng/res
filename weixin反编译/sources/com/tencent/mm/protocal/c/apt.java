package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class apt extends a {
    public String hxd;
    public int hxe;
    public String hxf;
    public String hxg;
    public String hxh;
    public int hxi;
    public String hxj;
    public int hxk;
    public int hxl;
    public String hxm;
    public String hxn;
    public String hxo;
    public String vPp;
    public bmk wCw;
    public py wCx;
    public String wDh;
    public ud wDi;
    public String wbY;
    public String wbZ;
    public String woW;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPp != null) {
                aVar.g(1, this.vPp);
            }
            if (this.wDh != null) {
                aVar.g(2, this.wDh);
            }
            if (this.hxd != null) {
                aVar.g(3, this.hxd);
            }
            aVar.fX(4, this.hxe);
            if (this.hxf != null) {
                aVar.g(5, this.hxf);
            }
            if (this.hxg != null) {
                aVar.g(6, this.hxg);
            }
            if (this.hxh != null) {
                aVar.g(7, this.hxh);
            }
            aVar.fX(8, this.hxi);
            if (this.hxj != null) {
                aVar.g(9, this.hxj);
            }
            if (this.wDi != null) {
                aVar.fZ(10, this.wDi.bkL());
                this.wDi.a(aVar);
            }
            aVar.fX(11, this.hxk);
            aVar.fX(12, this.hxl);
            if (this.hxm != null) {
                aVar.g(13, this.hxm);
            }
            if (this.wCw != null) {
                aVar.fZ(14, this.wCw.bkL());
                this.wCw.a(aVar);
            }
            if (this.hxn != null) {
                aVar.g(15, this.hxn);
            }
            if (this.hxo != null) {
                aVar.g(16, this.hxo);
            }
            if (this.wCx != null) {
                aVar.fZ(17, this.wCx.bkL());
                this.wCx.a(aVar);
            }
            if (this.wbY != null) {
                aVar.g(20, this.wbY);
            }
            if (this.wbZ != null) {
                aVar.g(21, this.wbZ);
            }
            if (this.woW == null) {
                return 0;
            }
            aVar.g(22, this.woW);
            return 0;
        } else if (i == 1) {
            if (this.vPp != null) {
                h = e.a.a.b.b.a.h(1, this.vPp) + 0;
            } else {
                h = 0;
            }
            if (this.wDh != null) {
                h += e.a.a.b.b.a.h(2, this.wDh);
            }
            if (this.hxd != null) {
                h += e.a.a.b.b.a.h(3, this.hxd);
            }
            h += e.a.a.a.fU(4, this.hxe);
            if (this.hxf != null) {
                h += e.a.a.b.b.a.h(5, this.hxf);
            }
            if (this.hxg != null) {
                h += e.a.a.b.b.a.h(6, this.hxg);
            }
            if (this.hxh != null) {
                h += e.a.a.b.b.a.h(7, this.hxh);
            }
            h += e.a.a.a.fU(8, this.hxi);
            if (this.hxj != null) {
                h += e.a.a.b.b.a.h(9, this.hxj);
            }
            if (this.wDi != null) {
                h += e.a.a.a.fW(10, this.wDi.bkL());
            }
            h = (h + e.a.a.a.fU(11, this.hxk)) + e.a.a.a.fU(12, this.hxl);
            if (this.hxm != null) {
                h += e.a.a.b.b.a.h(13, this.hxm);
            }
            if (this.wCw != null) {
                h += e.a.a.a.fW(14, this.wCw.bkL());
            }
            if (this.hxn != null) {
                h += e.a.a.b.b.a.h(15, this.hxn);
            }
            if (this.hxo != null) {
                h += e.a.a.b.b.a.h(16, this.hxo);
            }
            if (this.wCx != null) {
                h += e.a.a.a.fW(17, this.wCx.bkL());
            }
            if (this.wbY != null) {
                h += e.a.a.b.b.a.h(20, this.wbY);
            }
            if (this.wbZ != null) {
                h += e.a.a.b.b.a.h(21, this.wbZ);
            }
            if (this.woW != null) {
                h += e.a.a.b.b.a.h(22, this.woW);
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
            apt apt = (apt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a udVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    apt.vPp = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    apt.wDh = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    apt.hxd = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    apt.hxe = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    apt.hxf = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    apt.hxg = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    apt.hxh = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    apt.hxi = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    apt.hxj = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        udVar = new ud();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = udVar.a(aVar4, udVar, a.a(aVar4))) {
                        }
                        apt.wDi = udVar;
                    }
                    return 0;
                case 11:
                    apt.hxk = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    apt.hxl = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    apt.hxm = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        udVar = new bmk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = udVar.a(aVar4, udVar, a.a(aVar4))) {
                        }
                        apt.wCw = udVar;
                    }
                    return 0;
                case 15:
                    apt.hxn = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    apt.hxo = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        udVar = new py();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = udVar.a(aVar4, udVar, a.a(aVar4))) {
                        }
                        apt.wCx = udVar;
                    }
                    return 0;
                case 20:
                    apt.wbY = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    apt.wbZ = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    apt.woW = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
