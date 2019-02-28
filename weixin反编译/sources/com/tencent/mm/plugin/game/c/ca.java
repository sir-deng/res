package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ca extends a {
    public String desc;
    public LinkedList<ci> kTc = new LinkedList();
    public String now;
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.now != null) {
                aVar.g(1, this.now);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            aVar.d(3, 8, this.kTc);
            if (this.url != null) {
                aVar.g(4, this.url);
            }
            if (this.title == null) {
                return 0;
            }
            aVar.g(5, this.title);
            return 0;
        } else if (i == 1) {
            if (this.now != null) {
                h = e.a.a.b.b.a.h(1, this.now) + 0;
            } else {
                h = 0;
            }
            if (this.desc != null) {
                h += e.a.a.b.b.a.h(2, this.desc);
            }
            h += e.a.a.a.c(3, 8, this.kTc);
            if (this.url != null) {
                h += e.a.a.b.b.a.h(4, this.url);
            }
            if (this.title != null) {
                h += e.a.a.b.b.a.h(5, this.title);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kTc.clear();
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
            ca caVar = (ca) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    caVar.now = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    caVar.desc = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a ciVar = new ci();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ciVar.a(aVar4, ciVar, a.a(aVar4))) {
                        }
                        caVar.kTc.add(ciVar);
                    }
                    return 0;
                case 4:
                    caVar.url = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    caVar.title = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
