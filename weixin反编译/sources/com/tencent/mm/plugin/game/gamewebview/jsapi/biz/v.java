package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.e;
import com.tencent.mm.plugin.game.gamewebview.ui.i;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class v extends a {
    public static final int CTRL_BYTE = 14;
    public static final String NAME = "hideOptionMenu";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiHideOptionMenu", "invoke");
        e eVar = dVar.neq;
        if (eVar == null) {
            x.e("MicroMsg.GameJsApiHideOptionMenu", "actionBar is null");
            return;
        }
        if (eVar.nfA != null) {
            i iVar = eVar.nfA;
            iVar.nfN.clear();
            iVar.nfN.addAll(iVar.nfO.values());
            iVar.nfN.removeAll(iVar.nfP);
        }
        dVar.E(i, a.e("hideOptionMenu:ok", null));
    }
}
