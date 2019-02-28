package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cj extends a {
    public String fpg;
    public String noL;
    public LinkedList<String> noM = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg != null) {
                aVar.g(1, this.fpg);
            }
            if (this.noL != null) {
                aVar.g(2, this.noL);
            }
            aVar.d(3, 1, this.noM);
            return 0;
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            if (this.noL != null) {
                h += e.a.a.b.b.a.h(2, this.noL);
            }
            return h + e.a.a.a.c(3, 1, this.noM);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.noM.clear();
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
            cj cjVar = (cj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cjVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cjVar.noL = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cjVar.noM.add(aVar3.AEQ.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
