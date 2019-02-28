package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.sdk.platformtools.bi;

public final class p extends c {
    public p(Context context, int i) {
        super(context);
        this.niV = i;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof t) {
            t tVar = (t) view.getTag();
            switch (tVar.field_msgType) {
                case 6:
                    if (!bi.oN(tVar.nhR)) {
                        ap.a(this.mContext, 13, 1301, 5, c.ac(this.mContext, tVar.nhR), 0, tVar.field_appId, this.niV, tVar.field_msgType, tVar.field_gameMsgId, tVar.niB, null);
                        return;
                    }
                    return;
                default:
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", tVar.field_appId);
                    bundle.putInt("game_report_from_scene", 1301);
                    ap.a(this.mContext, 13, 1301, 5, c.a(this.mContext, tVar.field_appId, null, bundle), 0, tVar.field_appId, this.niV, tVar.field_msgType, tVar.field_gameMsgId, tVar.niB, null);
                    return;
            }
        }
    }
}
