package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class cd extends a {
    public String desc;
    public String hcs;
    public String noB;
    public String noC;
    public String title;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.hcs != null) {
                aVar.g(2, this.hcs);
            }
            if (this.noB != null) {
                aVar.g(3, this.noB);
            }
            if (this.desc != null) {
                aVar.g(4, this.desc);
            }
            if (this.noC == null) {
                return 0;
            }
            aVar.g(5, this.noC);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.hcs != null) {
                h += e.a.a.b.b.a.h(2, this.hcs);
            }
            if (this.noB != null) {
                h += e.a.a.b.b.a.h(3, this.noB);
            }
            if (this.desc != null) {
                h += e.a.a.b.b.a.h(4, this.desc);
            }
            if (this.noC != null) {
                h += e.a.a.b.b.a.h(5, this.noC);
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
            cd cdVar = (cd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdVar.title = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cdVar.hcs = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cdVar.noB = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cdVar.desc = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    cdVar.noC = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
