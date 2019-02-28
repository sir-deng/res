package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.f.a.sd;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.awj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class i extends c<sd> {
    public i() {
        this.xmG = sd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        List list = ((sd) bVar).fKI.fKJ;
        if (list == null || list.size() <= 0) {
            x.e("MicroMsg.UpdateMassSendPlaceTopListener", "empty mass send top config package");
        } else {
            byte[] a = n.a(((awj) list.get(0)).vOM);
            if (!(a == null || a.length == 0)) {
                String str = new String(a);
                x.i("MicroMsg.UpdateMassSendPlaceTopListener", "MassSendTopConfXml:" + str);
                h.aZk().EL(str);
            }
        }
        return false;
    }
}
