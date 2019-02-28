package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class arq extends a {
    public String desc;
    public String kPA;
    public String path;
    public String title;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kPA != null) {
                aVar.g(1, this.kPA);
            }
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            if (this.desc != null) {
                aVar.g(3, this.desc);
            }
            if (this.username != null) {
                aVar.g(4, this.username);
            }
            if (this.path == null) {
                return 0;
            }
            aVar.g(5, this.path);
            return 0;
        } else if (i == 1) {
            if (this.kPA != null) {
                h = e.a.a.b.b.a.h(1, this.kPA) + 0;
            } else {
                h = 0;
            }
            if (this.title != null) {
                h += e.a.a.b.b.a.h(2, this.title);
            }
            if (this.desc != null) {
                h += e.a.a.b.b.a.h(3, this.desc);
            }
            if (this.username != null) {
                h += e.a.a.b.b.a.h(4, this.username);
            }
            if (this.path != null) {
                h += e.a.a.b.b.a.h(5, this.path);
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
            arq arq = (arq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    arq.kPA = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    arq.title = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    arq.desc = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    arq.username = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    arq.path = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
