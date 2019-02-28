package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.t.h;
import com.tencent.mm.sdk.platformtools.bi;

public final class x implements OnClickListener {
    private int itU = 13;
    private Context mContext;
    private int mPosition;
    private int nBN;
    private int niV;

    public x(Context context) {
        this.mContext = context;
    }

    public final void cK(int i, int i2) {
        this.niV = i;
        this.nBN = 1301;
        this.mPosition = i2;
    }

    public final void onClick(View view) {
        if (view.getTag() != null) {
            String str;
            if (view.getTag() instanceof t) {
                t tVar = (t) view.getTag();
                if (!bi.cC(tVar.nhS)) {
                    str = ((h) tVar.nhS.get(0)).niQ;
                    if (bi.oN(str)) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GameURLClickListener", "message's jumpurl is null");
                        return;
                    }
                    ap.a(this.mContext, this.itU, this.nBN, this.mPosition, c.ac(this.mContext, str), 0, tVar.field_appId, this.niV, tVar.field_msgType, tVar.field_gameMsgId, tVar.niB, null);
                }
            } else if (view.getTag() instanceof String) {
                str = (String) view.getTag();
                if (!bi.oN(str)) {
                    ap.a(this.mContext, this.itU, this.nBN, this.mPosition, c.ac(this.mContext, str), this.niV, null);
                }
            }
        }
    }
}
