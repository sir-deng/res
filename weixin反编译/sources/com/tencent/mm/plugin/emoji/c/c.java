package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.a.e;
import com.tencent.mm.f.a.be;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.io.File;

public final class c extends com.tencent.mm.sdk.b.c<be> {
    public c() {
        this.xmG = be.class.getName().hashCode();
    }

    private static boolean a(be beVar) {
        if (beVar.fqo.fqg == 37) {
            if (beVar.fqo.fqh == 5 && beVar.fqo.fql == 2) {
                i aBN = i.aBN();
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    as.Hm();
                    b.deleteFile(stringBuilder.append(com.tencent.mm.y.c.FI()).append("eggingfo.ini").toString());
                    e.g(new File(i.aBO(), i.lBC));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
                }
                aBN.lBT = null;
            }
            if (beVar.fqo.fql == 0) {
                x.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", Integer.valueOf(beVar.fqo.fqg), Integer.valueOf(beVar.fqo.fqh));
            }
        }
        return false;
    }
}
