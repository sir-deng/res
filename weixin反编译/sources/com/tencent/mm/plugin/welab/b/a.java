package com.tencent.mm.plugin.welab.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.kx;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.aj.a.h;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class a implements b {
    public final void e(Activity activity, String str) {
        if (g.Ae(0)) {
            String optString = h.Oy("discoverRecommendEntry").optString("wording");
            if (bi.oN(optString)) {
                x.e("MicroMsg.FTS.LookOneLookOpener", "empty query");
                return;
            }
            Intent QT = com.tencent.mm.bb.b.QT();
            QT.putExtra("ftsbizscene", 21);
            QT.putExtra("ftsQuery", optString);
            QT.putExtra("title", optString);
            QT.putExtra("isWebwx", optString);
            QT.putExtra("ftscaneditable", false);
            Map b = com.tencent.mm.bb.b.b(21, false, 2);
            b.put("query", optString);
            b.put("sceneActionType", "2");
            QT.putExtra("rawUrl", com.tencent.mm.bb.b.a(b, 1));
            com.tencent.mm.sdk.b.b kxVar = new kx();
            kxVar.fCZ.scene = 0;
            com.tencent.mm.sdk.b.a.xmy.m(kxVar);
            d.b(activity, "webview", ".ui.tools.fts.FTSWebViewUI", QT);
            com.tencent.mm.bb.g.u(21, optString);
            return;
        }
        x.e("MicroMsg.FTS.LookOneLookOpener", "fts h5 template not avail");
    }

    public final String bWp() {
        return h.Oy("discoverRecommendEntry").optString("labIcon");
    }

    public final String bWq() {
        String optString = h.Oy("discoverRecommendEntry").optString("wording");
        if (bi.oN(optString)) {
            return ad.getContext().getString(R.l.ehK);
        }
        return optString;
    }
}
