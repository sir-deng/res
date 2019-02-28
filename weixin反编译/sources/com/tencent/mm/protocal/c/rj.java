package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class rj extends a {
    public String kPB;
    public String title;
    public int wgg;
    public LinkedList<oy> wgh = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.kPB != null) {
                aVar.g(2, this.kPB);
            }
            aVar.fX(3, this.wgg);
            aVar.d(4, 8, this.wgh);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.kPB != null) {
                h += e.a.a.b.b.a.h(2, this.kPB);
            }
            return (h + e.a.a.a.fU(3, this.wgg)) + e.a.a.a.c(4, 8, this.wgh);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wgh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            rj rjVar = (rj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    rjVar.title = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    rjVar.kPB = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    rjVar.wgg = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a oyVar = new oy();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = oyVar.a(aVar4, oyVar, a.a(aVar4))) {
                        }
                        rjVar.wgh.add(oyVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
