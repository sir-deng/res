package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class iu extends a {
    public LinkedList<we> vVE = new LinkedList();
    public LinkedList<wd> vVF = new LinkedList();
    public String vVG;
    public String vVH;
    public String vVI;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.vVE);
            aVar.d(2, 8, this.vVF);
            if (this.vVG != null) {
                aVar.g(3, this.vVG);
            }
            if (this.vVH != null) {
                aVar.g(4, this.vVH);
            }
            if (this.vVI != null) {
                aVar.g(5, this.vVI);
            }
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 8, this.vVE) + 0) + e.a.a.a.c(2, 8, this.vVF);
            if (this.vVG != null) {
                c += e.a.a.b.b.a.h(3, this.vVG);
            }
            if (this.vVH != null) {
                c += e.a.a.b.b.a.h(4, this.vVH);
            }
            if (this.vVI != null) {
                return c + e.a.a.b.b.a.h(5, this.vVI);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vVE.clear();
            this.vVF.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            iu iuVar = (iu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a weVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        weVar = new we();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = weVar.a(aVar4, weVar, a.a(aVar4))) {
                        }
                        iuVar.vVE.add(weVar);
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        weVar = new wd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = weVar.a(aVar4, weVar, a.a(aVar4))) {
                        }
                        iuVar.vVF.add(weVar);
                    }
                    return 0;
                case 3:
                    iuVar.vVG = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    iuVar.vVH = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    iuVar.vVI = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
