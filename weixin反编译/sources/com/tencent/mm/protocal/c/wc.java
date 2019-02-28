package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class wc extends a {
    public String canvasPageXml;
    public String desc;
    public int hcR;
    public String thumbUrl;
    public String title;
    public boolean wjG = false;
    public boolean wjH = false;
    public boolean wkS = false;
    public boolean wlT = false;
    public String wmD;
    public boolean wmE = false;
    public int wmF;
    public boolean wmG = false;
    public boolean wmH = false;

    public final wc Va(String str) {
        this.title = str;
        this.wjG = true;
        return this;
    }

    public final wc Vb(String str) {
        this.desc = str;
        this.wjH = true;
        return this;
    }

    public final wc Vc(String str) {
        this.wmD = str;
        this.wmE = true;
        return this;
    }

    public final wc Vd(String str) {
        this.thumbUrl = str;
        this.wlT = true;
        return this;
    }

    public final wc Dm(int i) {
        this.wmF = i;
        this.wmG = true;
        return this;
    }

    public final wc Dn(int i) {
        this.hcR = i;
        this.wmH = true;
        return this;
    }

    public final wc Ve(String str) {
        this.canvasPageXml = str;
        this.wkS = true;
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
            if (this.wmD != null) {
                aVar.g(3, this.wmD);
            }
            if (this.thumbUrl != null) {
                aVar.g(4, this.thumbUrl);
            }
            if (this.wmG) {
                aVar.fX(5, this.wmF);
            }
            if (this.wmH) {
                aVar.fX(6, this.hcR);
            }
            if (this.canvasPageXml == null) {
                return 0;
            }
            aVar.g(7, this.canvasPageXml);
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
            if (this.wmD != null) {
                h += e.a.a.b.b.a.h(3, this.wmD);
            }
            if (this.thumbUrl != null) {
                h += e.a.a.b.b.a.h(4, this.thumbUrl);
            }
            if (this.wmG) {
                h += e.a.a.a.fU(5, this.wmF);
            }
            if (this.wmH) {
                h += e.a.a.a.fU(6, this.hcR);
            }
            if (this.canvasPageXml != null) {
                h += e.a.a.b.b.a.h(7, this.canvasPageXml);
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
            wc wcVar = (wc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wcVar.title = aVar3.AEQ.readString();
                    wcVar.wjG = true;
                    return 0;
                case 2:
                    wcVar.desc = aVar3.AEQ.readString();
                    wcVar.wjH = true;
                    return 0;
                case 3:
                    wcVar.wmD = aVar3.AEQ.readString();
                    wcVar.wmE = true;
                    return 0;
                case 4:
                    wcVar.thumbUrl = aVar3.AEQ.readString();
                    wcVar.wlT = true;
                    return 0;
                case 5:
                    wcVar.wmF = aVar3.AEQ.rz();
                    wcVar.wmG = true;
                    return 0;
                case 6:
                    wcVar.hcR = aVar3.AEQ.rz();
                    wcVar.wmH = true;
                    return 0;
                case 7:
                    wcVar.canvasPageXml = aVar3.AEQ.readString();
                    wcVar.wkS = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
