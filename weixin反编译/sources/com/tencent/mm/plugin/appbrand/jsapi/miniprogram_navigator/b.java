package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public final class b extends a {
    static final int CTRL_INDEX = 191;
    static final String NAME = "exitMiniProgram";

    public final void a(final j jVar, JSONObject jSONObject, int i) {
        ah.y(new Runnable() {
            public final void run() {
                jVar.iuk.finish();
                Activity ch = com.tencent.mm.plugin.appbrand.ui.j.ch(jVar.getContext());
                if (ch != null && !ch.isFinishing()) {
                    ch.moveTaskToBack(true);
                }
            }
        });
    }
}
