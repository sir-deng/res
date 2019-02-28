package com.tencent.mm.plugin.sns;

import android.util.Base64;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bnd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.g.a;
import com.tencent.mm.y.u.b;

public final class l implements i {
    public final void b(String str, d dVar) {
        p.b(str, dVar);
    }

    public final String a(String str, PString pString) {
        return p.a(str, pString);
    }

    public final void a(String str, b bVar, au auVar) {
        if (auVar.aNJ()) {
            a fV = a.fV(auVar.field_content);
            if (fV != null && !bi.oN(fV.fHB)) {
                bVar.o(str, fV.fHB);
            }
        }
    }

    public final void V(au auVar) {
        String z = p.z(auVar);
        if (z != null) {
            byte[] decode = Base64.decode(z, 0);
            bnd bnd = new bnd();
            try {
                bnd.aH(decode);
                if (bnd.wXc != null) {
                    Object obj;
                    if (auVar.field_talker.endsWith("@chatroom")) {
                        obj = p.a.TalkChat.value;
                    } else {
                        String obj2 = p.a.Chat.value;
                    }
                    x.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", obj2, z, bnd.wXc.wXf, bnd.wXc.wXg);
                    ((c) g.h(c.class)).h(13235, obj2, bnd.wXc.wXf, bnd.wXc.wXg);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, "", new Object[0]);
            }
        }
    }

    public final String z(au auVar) {
        return p.z(auVar);
    }
}
