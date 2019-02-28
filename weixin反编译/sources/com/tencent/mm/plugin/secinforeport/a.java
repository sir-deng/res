package com.tencent.mm.plugin.secinforeport;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.oo;
import com.tencent.mm.protocal.c.op;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.charset.Charset;

public enum a implements b {
    ;

    private a(String str) {
    }

    public final void a(int i, String str, int i2, byte[] bArr) {
        if (str == null) {
            x.w("MicroMsg.ClipBordReportImpl", "operationInfo isNullOrNil");
            return;
        }
        oo ooVar = new oo();
        ooVar.wek = i;
        ooVar.wem = i2;
        ooVar.wel = new bes().bl(str.getBytes(Charset.forName("UTF-8")));
        if (!bi.by(bArr)) {
            ooVar.wen = new bes().bl(bArr);
        }
        com.tencent.mm.bp.a opVar = new op();
        opVar.wep.add(ooVar);
        opVar.weo = opVar.wep.size();
        ((h) g.h(h.class)).Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, opVar));
    }
}
