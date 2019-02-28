package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.f.a.jt;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.x.g.a;

public final class s {
    public p fhH;
    public c jil = new c<jt>() {
        {
            this.xmG = jt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            switch (((jt) bVar).fBu.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    s.this.fhH.cpZ();
                    break;
            }
            return false;
        }
    };

    /* renamed from: com.tencent.mm.ui.chatting.b.s$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String fhB;
        final /* synthetic */ String yJl;
        final /* synthetic */ long yJm;

        public AnonymousClass2(String str, String str2, long j) {
            this.yJl = str;
            this.fhB = str2;
            this.yJm = j;
        }

        public final void run() {
            String str = this.yJl;
            if (com.tencent.mm.y.s.eX(this.fhB) && !bi.aD(str, "").startsWith("<")) {
                int indexOf = this.yJl.indexOf(58);
                if (indexOf != -1) {
                    str = this.yJl.substring(indexOf + 1);
                }
            }
            a fV = a.fV(bi.Wn(str));
            if (fV != null) {
                switch (fV.type) {
                    case 3:
                        ati Qz = com.tencent.mm.au.b.Qz();
                        if (Qz != null && Qz.wdd != null && Qz.wHt == 0) {
                            try {
                                if (this.yJm == bi.getLong(Qz.wdd, 0)) {
                                    ah.y(new Runnable() {
                                        public final void run() {
                                            com.tencent.mm.au.b.Qv();
                                        }
                                    });
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public s(p pVar) {
        this.fhH = pVar;
    }
}
