package com.tencent.mm.au;

import com.tencent.mm.f.a.js;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

public final class b {

    /* renamed from: com.tencent.mm.au.b$7 */
    static class AnonymousClass7 implements Runnable {
        final /* synthetic */ List hJH;
        final /* synthetic */ int hJI;

        public AnonymousClass7(List list, int i) {
            this.hJH = list;
            this.hJI = i;
        }

        public final void run() {
            com.tencent.mm.sdk.b.b jsVar = new js();
            jsVar.fBo.action = 0;
            jsVar.fBo.fwA = this.hJH;
            jsVar.fBo.fBr = this.hJI;
            a.xmy.m(jsVar);
        }
    }

    /* renamed from: com.tencent.mm.au.b$9 */
    static class AnonymousClass9 implements Runnable {
        final /* synthetic */ List hJJ;
        final /* synthetic */ boolean hJK = true;

        public AnonymousClass9(List list, boolean z) {
            this.hJJ = list;
        }

        public final void run() {
            com.tencent.mm.sdk.b.b jsVar = new js();
            jsVar.fBo.action = 5;
            jsVar.fBo.fwA = this.hJJ;
            jsVar.fBo.fBs = this.hJK;
            a.xmy.m(jsVar);
        }
    }

    public static final void xZ() {
        ah.y(new Runnable() {
            public final void run() {
                com.tencent.mm.sdk.b.b jsVar = new js();
                jsVar.fBo.action = 1;
                a.xmy.m(jsVar);
            }
        });
    }

    public static final void ya() {
        ah.y(new Runnable() {
            public final void run() {
                com.tencent.mm.sdk.b.b jsVar = new js();
                jsVar.fBo.action = 2;
                a.xmy.m(jsVar);
            }
        });
    }

    public static final void Qv() {
        ah.y(new Runnable() {
            public final void run() {
                com.tencent.mm.sdk.b.b jsVar = new js();
                jsVar.fBo.action = -1;
                a.xmy.m(jsVar);
            }
        });
    }

    public static final void Qw() {
        ah.y(new Runnable() {
            public final void run() {
                com.tencent.mm.sdk.b.b jsVar = new js();
                jsVar.fBo.action = 11;
                a.xmy.m(jsVar);
            }
        });
    }

    public static final void a(final ati ati) {
        ah.y(new Runnable() {
            public final void run() {
                com.tencent.mm.sdk.b.b jsVar = new js();
                jsVar.fBo.action = 6;
                jsVar.fBo.fBq = ati;
                a.xmy.m(jsVar);
            }
        });
    }

    public static boolean Qx() {
        com.tencent.mm.sdk.b.b jsVar = new js();
        jsVar.fBo.action = -3;
        a.xmy.m(jsVar);
        return jsVar.fBp.foB;
    }

    public static boolean Qy() {
        com.tencent.mm.sdk.b.b jsVar = new js();
        jsVar.fBo.action = 9;
        a.xmy.m(jsVar);
        return jsVar.fBp.foB;
    }

    public static ati Qz() {
        com.tencent.mm.sdk.b.b jsVar = new js();
        jsVar.fBo.action = -2;
        a.xmy.m(jsVar);
        return jsVar.fBp.fBq;
    }

    public static void b(final ati ati) {
        ah.y(new Runnable() {
            public final void run() {
                com.tencent.mm.sdk.b.b jsVar = new js();
                jsVar.fBo.action = 0;
                jsVar.fBo.fBq = ati;
                a.xmy.m(jsVar);
            }
        });
    }

    public static void c(final ati ati) {
        ah.y(new Runnable() {
            public final void run() {
                com.tencent.mm.sdk.b.b jsVar = new js();
                jsVar.fBo.action = 3;
                jsVar.fBo.fBq = ati;
                a.xmy.m(jsVar);
            }
        });
    }

    public static boolean d(ati ati) {
        if (ati == null) {
            return false;
        }
        switch (ati.wHt) {
            case 1:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean ii(int i) {
        com.tencent.mm.sdk.b.b jsVar = new js();
        jsVar.fBo.action = 7;
        jsVar.fBo.position = i;
        a.xmy.m(jsVar);
        return jsVar.fBp.foB;
    }

    public static d QA() {
        com.tencent.mm.sdk.b.b jsVar = new js();
        jsVar.fBo.action = 8;
        a.xmy.m(jsVar);
        return jsVar.fBp.fBt;
    }
}
