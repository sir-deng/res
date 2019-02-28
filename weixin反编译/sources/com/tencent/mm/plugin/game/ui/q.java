package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends c {
    public q(Context context, int i) {
        super(context);
        this.niV = i;
    }

    public final void onClick(View view) {
        t tVar;
        Object tag = view.getTag();
        if (tag == null) {
            x.e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
            tVar = null;
        } else if (tag instanceof Long) {
            t dw = SubCoreGameCenter.aRK().dw(((Long) tag).longValue());
            if (dw != null) {
                dw.aQT();
            }
            tVar = dw;
        } else {
            x.e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
            tVar = null;
        }
        if (tVar == null) {
            x.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
            return;
        }
        switch (tVar.field_msgType) {
            case 5:
                if (!bi.oN(tVar.nip)) {
                    ap.a(this.mContext, 13, 1301, 3, c.ac(this.mContext, tVar.nip), 0, tVar.field_appId, this.niV, tVar.field_msgType, tVar.field_gameMsgId, tVar.niB, null);
                    return;
                }
                return;
            case 6:
                if (!bi.oN(tVar.nim)) {
                    ap.a(this.mContext, 13, 1301, 3, c.ac(this.mContext, tVar.nim), 0, tVar.field_appId, this.niV, tVar.field_msgType, tVar.field_gameMsgId, tVar.niB, null);
                    return;
                }
                return;
            case 10:
            case 11:
                if (bi.oN(tVar.nhK)) {
                    ap.a(this.mContext, 13, 1301, 3, c.a(this.mContext, tVar), 0, tVar.field_appId, this.niV, tVar.field_msgType, tVar.field_gameMsgId, tVar.niB, null);
                    return;
                }
                ap.a(this.mContext, 13, 1301, 3, c.ac(this.mContext, tVar.nhK), 0, tVar.field_appId, this.niV, tVar.field_msgType, tVar.field_gameMsgId, tVar.niB, null);
                return;
            default:
                ap.a(this.mContext, 13, 1301, 3, c.a(this.mContext, tVar), 0, tVar.field_appId, this.niV, tVar.field_msgType, tVar.field_gameMsgId, tVar.niB, null);
                return;
        }
    }
}
