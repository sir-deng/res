package com.tencent.mm.bf.b;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Set;

public final class b implements e {

    /* renamed from: com.tencent.mm.bf.b.b$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Set iaW;
        final /* synthetic */ String iaX;
        final /* synthetic */ String iaY;

        public AnonymousClass1(Set set, String str, String str2) {
            this.iaW = set;
            this.iaX = str;
            this.iaY = str2;
        }

        public final void run() {
            LinkedList linkedList = new LinkedList();
            for (String Vf : this.iaW) {
                linkedList.add(new bet().Vf(Vf));
                x.d("MicroMsg.NewVoiceInputReportManager", "mVoiceIdSet Id = %s", Vf);
            }
            bet Vf2 = new bet().Vf(this.iaX);
            bet Vf3 = new bet().Vf(this.iaY);
            g.CN().a((int) JsApiOpenWeRunSetting.CTRL_INDEX, b.this);
            g.CN().a(new a(linkedList.size(), linkedList, Vf2, Vf3), 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        g.CN().b((int) JsApiOpenWeRunSetting.CTRL_INDEX, (e) this);
        if (kVar instanceof a) {
            x.i("MicroMsg.NewVoiceInputReportManager", "onSceneEnd errType = %s, errCode = %s, errMsg = %s ", Integer.valueOf(i), Integer.valueOf(i2), str);
        }
    }
}
