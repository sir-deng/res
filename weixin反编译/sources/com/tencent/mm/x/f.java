package com.tencent.mm.x;

import android.util.Base64;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.protocal.c.bnb;
import com.tencent.mm.protocal.c.bnd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.x.g.a;
import java.util.Map;

public final class f extends d {
    public final d EQ() {
        return new f();
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult keep_sceneresult, int i, int i2) {
        if (!bi.oN(aVar.appId)) {
            String replace;
            String str2 = aVar.fHB;
            bnd bnd = new bnd();
            if (str2 != null) {
                try {
                    bnd.aH(Base64.decode(str2, 0));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", e, "", new Object[0]);
                }
            }
            bnd.wXe = new bnb();
            bnd.wXe.nhB = aVar.appId;
            try {
                str2 = Base64.encodeToString(bnd.toByteArray(), 0);
                replace = str2.replace("\n", "");
            } catch (Throwable e2) {
                Throwable th = e2;
                replace = str2;
                x.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", th, "", new Object[0]);
            }
            aVar.fHB = replace;
        }
        stringBuilder.append("<statextstr>" + bi.Wm(aVar.fHB) + "</statextstr>");
    }

    public final void a(Map<String, String> map, a aVar) {
    }
}
