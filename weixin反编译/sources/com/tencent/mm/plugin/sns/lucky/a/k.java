package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.nio.charset.Charset;

public final class k {
    public static i h(a aVar) {
        Exception e;
        i iVar = new i();
        g.Dr();
        String str = (String) g.Dq().Db().get(aVar, null);
        if (str == null) {
            x.i("MicroMsg.RedDotUtil", "load: redDotList data empty");
            return iVar;
        }
        i iVar2;
        try {
            iVar2 = (i) new i().aH(str.getBytes(Charset.forName("ISO-8859-1")));
            if (iVar2 == null) {
                try {
                    iVar2 = new i();
                } catch (Exception e2) {
                    Exception exception = e2;
                    iVar = iVar2;
                    e = exception;
                    x.e("MicroMsg.RedDotUtil", "getRedDotList " + e.getMessage());
                    iVar2 = iVar;
                    if (iVar2 == null) {
                        return new i();
                    }
                    return iVar2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            x.e("MicroMsg.RedDotUtil", "getRedDotList " + e.getMessage());
            iVar2 = iVar;
            if (iVar2 == null) {
                return iVar2;
            }
            return new i();
        }
        if (iVar2 == null) {
            return new i();
        }
        return iVar2;
    }
}
