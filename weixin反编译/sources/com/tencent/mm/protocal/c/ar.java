package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ar extends a {
    public String vMo;
    public LinkedList<avt> vMp = new LinkedList();
    public LinkedList<avs> vMq = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vMo != null) {
                aVar.g(1, this.vMo);
            }
            aVar.d(2, 8, this.vMp);
            aVar.d(3, 8, this.vMq);
            return 0;
        } else if (i == 1) {
            if (this.vMo != null) {
                h = e.a.a.b.b.a.h(1, this.vMo) + 0;
            } else {
                h = 0;
            }
            return (h + e.a.a.a.c(2, 8, this.vMp)) + e.a.a.a.c(3, 8, this.vMq);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vMp.clear();
            this.vMq.clear();
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
            ar arVar = (ar) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a avt;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    arVar.vMo = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        avt = new avt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avt.a(aVar4, avt, a.a(aVar4))) {
                        }
                        arVar.vMp.add(avt);
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        avt = new avs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avt.a(aVar4, avt, a.a(aVar4))) {
                        }
                        arVar.vMq.add(avt);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
