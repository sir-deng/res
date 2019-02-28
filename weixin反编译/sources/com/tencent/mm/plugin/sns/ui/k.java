package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.d.n.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;

public final class k implements a {
    Activity activity;
    private ad rxY;
    private int scene = 0;

    public k(Activity activity, int i, ad adVar) {
        this.activity = activity;
        this.scene = i;
        this.rxY = adVar;
    }

    public final void bK(Object obj) {
        boolean z = false;
        Intent intent = new Intent();
        if (this.activity != null) {
            String str;
            if (obj instanceof com.tencent.mm.plugin.sns.data.a) {
                com.tencent.mm.plugin.sns.data.a aVar = (com.tencent.mm.plugin.sns.data.a) obj;
                x.d("Micro.ClickableCallBack", "onClick : " + aVar.userName + " activity: " + (this.activity == null));
                m LR = ae.bwf().LR(aVar.fvn);
                if (aVar.qWK) {
                    b byB = LR.byB();
                    String bzj = LR.bzj();
                    if (byB == null || byB.rkJ != 1 || bi.oN(byB.rkK)) {
                        this.rxY.bvK().a(LR, false);
                        intent.putExtra("Contact_User", aVar.userName);
                        intent.putExtra("Contact_Scene", 37);
                        com.tencent.mm.plugin.sns.c.a.ihN.d(intent, this.activity);
                        com.tencent.mm.ad.k cVar = new c(LR.bzj(), 2, aVar.scene, "", LR.bzn(), LR.byG());
                        g.Dr();
                        g.Dp().gRu.a(cVar, 0);
                        return;
                    }
                    String str2 = byB.rkK;
                    x.i("Micro.ClickableCallBack", "headClickParam url " + str2 + " " + byB.rkL);
                    Intent intent2 = new Intent();
                    if (byB.rkL == 0) {
                        z = true;
                    }
                    intent2.putExtra("KsnsViewId", bzj);
                    intent2.putExtra("KRightBtn", z);
                    intent2.putExtra("jsapiargs", new Bundle());
                    intent2.putExtra("rawUrl", str2);
                    intent2.putExtra("useJs", true);
                    com.tencent.mm.plugin.sns.c.a.ihN.j(intent2, this.activity);
                    return;
                }
                com.tencent.mm.modelsns.b ix;
                str = aVar.userName;
                if (this.scene == 0) {
                    ix = com.tencent.mm.modelsns.b.ix(719);
                } else {
                    ix = com.tencent.mm.modelsns.b.iy(719);
                }
                ix.mF(i.g(LR)).iA(LR.field_type).bW(LR.xD(32)).mF(LR.bzk()).mF(str);
                ix.SE();
                if (this.scene == 0) {
                    ix = com.tencent.mm.modelsns.b.ix(746);
                } else {
                    ix = com.tencent.mm.modelsns.b.iy(746);
                }
                ix.mF(str).bW(str.endsWith(q.FY()));
                ix.b(intent, "intent_key_StatisticsOplog");
                if (this.scene == 0) {
                    this.rxY.bvK().a(LR, false);
                }
            } else {
                str = (String) obj;
                if (str.contains("@")) {
                    str = str.replace("@", "");
                }
                g.Dr();
                com.tencent.mm.storage.x Xt = ((h) g.h(h.class)).Ff().Xt(str);
                if (Xt != null && Xt.ciN()) {
                    intent.putExtra("Contact_User", str);
                    intent.putExtra("Contact_Scene", 37);
                    com.tencent.mm.plugin.sns.c.a.ihN.d(intent, this.activity);
                    return;
                } else if (this.scene == 0) {
                    m mVar = new m();
                    mVar.field_userName = str;
                    this.rxY.bvK().a(mVar, false);
                }
            }
            intent.putExtra("Contact_User", str);
            com.tencent.mm.plugin.sns.c.a.ihN.d(intent, this.activity);
        }
    }
}
