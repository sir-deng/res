package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.config.d.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.Iterator;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 395;
    public static final String NAME = "setDeviceOrientation";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        b qX = d.qX(jSONObject.optString(Columns.VALUE, null));
        if (qX == null) {
            jVar.E(i, e("fail", null));
        } else if (jVar.iuk == null || jVar.iuk.isO == null) {
            jVar.E(i, e("fail", null));
        } else {
            e.iQr.a(jVar.iuk.isO, qX, new com.tencent.mm.plugin.appbrand.config.d.a() {
                public final void a(b bVar, boolean z) {
                    jVar.E(i, a.this.e(z ? "ok" : "fail", null));
                    if (z) {
                        Iterator it = jVar.iuk.isX.jIM.iterator();
                        while (it.hasNext()) {
                            ((l) it.next()).aeN();
                        }
                    }
                }
            });
        }
    }
}
