package com.tencent.mm.x;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.x.g.a;
import java.util.Map;

public class c extends d {
    public String hcG;

    public final d EQ() {
        return new c();
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult keep_sceneresult, int i, int i2) {
    }

    public final void a(Map<String, String> map, a aVar) {
        if (aVar.type == 2001) {
            this.hcG = bi.oM((String) map.get(".msg.appmsg.wcpayinfo.locallogoicon"));
        }
    }
}
