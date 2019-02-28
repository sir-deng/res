package com.tencent.mm.x;

import com.tencent.mm.af.j;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.x.g.a;
import java.util.LinkedList;
import java.util.Map;

public class e extends d {
    public LinkedList<j> hcI = null;

    public final d EQ() {
        return new e();
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult keep_sceneresult, int i, int i2) {
    }

    public final void a(Map<String, String> map, a aVar) {
        switch (aVar.showType) {
            case 1:
                this.hcI = j.q(aVar.hcK);
                return;
            default:
                return;
        }
    }
}
