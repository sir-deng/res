package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class vw extends a {
    public String desc;
    public String info;
    public String thumbUrl;
    public String title;
    public boolean wjG = false;
    public boolean wjH = false;
    public boolean wlT = false;
    public boolean wlU = false;

    public final vw UW(String str) {
        this.title = str;
        this.wjG = true;
        return this;
    }

    public final vw UX(String str) {
        this.desc = str;
        this.wjH = true;
        return this;
    }

    public final vw UY(String str) {
        this.thumbUrl = str;
        this.wlT = true;
        return this;
    }

    public final vw UZ(String str) {
        this.info = str;
        this.wlU = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            if (this.thumbUrl != null) {
                aVar.g(3, this.thumbUrl);
            }
            if (this.info == null) {
                return 0;
            }
            aVar.g(4, this.info);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.desc != null) {
                h += e.a.a.b.b.a.h(2, this.desc);
            }
            if (this.thumbUrl != null) {
                h += e.a.a.b.b.a.h(3, this.thumbUrl);
            }
            if (this.info != null) {
                h += e.a.a.b.b.a.h(4, this.info);
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
            vw vwVar = (vw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vwVar.title = aVar3.AEQ.readString();
                    vwVar.wjG = true;
                    return 0;
                case 2:
                    vwVar.desc = aVar3.AEQ.readString();
                    vwVar.wjH = true;
                    return 0;
                case 3:
                    vwVar.thumbUrl = aVar3.AEQ.readString();
                    vwVar.wlT = true;
                    return 0;
                case 4:
                    vwVar.info = aVar3.AEQ.readString();
                    vwVar.wlU = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
