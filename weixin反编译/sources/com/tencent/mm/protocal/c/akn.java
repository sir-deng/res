package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class akn extends a {
    public fg wyo;
    public kb wyp;
    public ark wyq;
    public bnm wyr;
    public bfi wys;
    public ov wyt;
    public wf wyu;
    public wv wyv;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wyo != null) {
                aVar.fZ(1, this.wyo.bkL());
                this.wyo.a(aVar);
            }
            if (this.wyp != null) {
                aVar.fZ(2, this.wyp.bkL());
                this.wyp.a(aVar);
            }
            if (this.wyq != null) {
                aVar.fZ(3, this.wyq.bkL());
                this.wyq.a(aVar);
            }
            if (this.wyr != null) {
                aVar.fZ(4, this.wyr.bkL());
                this.wyr.a(aVar);
            }
            if (this.wys != null) {
                aVar.fZ(6, this.wys.bkL());
                this.wys.a(aVar);
            }
            if (this.wyt != null) {
                aVar.fZ(7, this.wyt.bkL());
                this.wyt.a(aVar);
            }
            if (this.wyu != null) {
                aVar.fZ(8, this.wyu.bkL());
                this.wyu.a(aVar);
            }
            if (this.wyv == null) {
                return 0;
            }
            aVar.fZ(9, this.wyv.bkL());
            this.wyv.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wyo != null) {
                fW = e.a.a.a.fW(1, this.wyo.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wyp != null) {
                fW += e.a.a.a.fW(2, this.wyp.bkL());
            }
            if (this.wyq != null) {
                fW += e.a.a.a.fW(3, this.wyq.bkL());
            }
            if (this.wyr != null) {
                fW += e.a.a.a.fW(4, this.wyr.bkL());
            }
            if (this.wys != null) {
                fW += e.a.a.a.fW(6, this.wys.bkL());
            }
            if (this.wyt != null) {
                fW += e.a.a.a.fW(7, this.wyt.bkL());
            }
            if (this.wyu != null) {
                fW += e.a.a.a.fW(8, this.wyu.bkL());
            }
            if (this.wyv != null) {
                fW += e.a.a.a.fW(9, this.wyv.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            akn akn = (akn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a fgVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fgVar = new fg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fgVar.a(aVar4, fgVar, a.a(aVar4))) {
                        }
                        akn.wyo = fgVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fgVar = new kb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fgVar.a(aVar4, fgVar, a.a(aVar4))) {
                        }
                        akn.wyp = fgVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fgVar = new ark();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fgVar.a(aVar4, fgVar, a.a(aVar4))) {
                        }
                        akn.wyq = fgVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fgVar = new bnm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fgVar.a(aVar4, fgVar, a.a(aVar4))) {
                        }
                        akn.wyr = fgVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fgVar = new bfi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fgVar.a(aVar4, fgVar, a.a(aVar4))) {
                        }
                        akn.wys = fgVar;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fgVar = new ov();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fgVar.a(aVar4, fgVar, a.a(aVar4))) {
                        }
                        akn.wyt = fgVar;
                    }
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fgVar = new wf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fgVar.a(aVar4, fgVar, a.a(aVar4))) {
                        }
                        akn.wyu = fgVar;
                    }
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fgVar = new wv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fgVar.a(aVar4, fgVar, a.a(aVar4))) {
                        }
                        akn.wyv = fgVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
