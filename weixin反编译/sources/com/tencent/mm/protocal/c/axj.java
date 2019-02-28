package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class axj extends a {
    public String desc;
    public String kPA;
    public String name;
    public int sGd;
    public String sGe;
    public String sGf;
    public String sGg;
    public String title;
    public bcq wLz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.g(1, this.name);
            }
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            if (this.desc != null) {
                aVar.g(3, this.desc);
            }
            if (this.kPA != null) {
                aVar.g(4, this.kPA);
            }
            aVar.fX(5, this.sGd);
            if (this.sGe != null) {
                aVar.g(6, this.sGe);
            }
            if (this.sGf != null) {
                aVar.g(7, this.sGf);
            }
            if (this.sGg != null) {
                aVar.g(8, this.sGg);
            }
            if (this.wLz == null) {
                return 0;
            }
            aVar.fZ(9, this.wLz.bkL());
            this.wLz.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                h = e.a.a.b.b.a.h(1, this.name) + 0;
            } else {
                h = 0;
            }
            if (this.title != null) {
                h += e.a.a.b.b.a.h(2, this.title);
            }
            if (this.desc != null) {
                h += e.a.a.b.b.a.h(3, this.desc);
            }
            if (this.kPA != null) {
                h += e.a.a.b.b.a.h(4, this.kPA);
            }
            h += e.a.a.a.fU(5, this.sGd);
            if (this.sGe != null) {
                h += e.a.a.b.b.a.h(6, this.sGe);
            }
            if (this.sGf != null) {
                h += e.a.a.b.b.a.h(7, this.sGf);
            }
            if (this.sGg != null) {
                h += e.a.a.b.b.a.h(8, this.sGg);
            }
            if (this.wLz != null) {
                h += e.a.a.a.fW(9, this.wLz.bkL());
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
            axj axj = (axj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    axj.name = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    axj.title = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    axj.desc = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    axj.kPA = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    axj.sGd = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    axj.sGe = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    axj.sGf = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    axj.sGg = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bcq = new bcq();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bcq.a(aVar4, bcq, a.a(aVar4))) {
                        }
                        axj.wLz = bcq;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
