package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.t.d;
import com.tencent.mm.plugin.game.ui.GameMessageUI;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class u implements OnClickListener {
    private Context mContext;
    public int niV;

    public static class a {
        public int fGe = 1301;
        public t ngZ;
        public String niS;
        public int position;

        public a(t tVar, String str, int i) {
            this.ngZ = tVar;
            this.niS = str;
            this.position = i;
        }
    }

    public u(Context context) {
        this.mContext = context;
    }

    public u(Context context, int i) {
        this.mContext = context;
        this.niV = i;
    }

    public final void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            x.e("MicroMsg.GameMessageClickListener", "v.getTag is null");
            return;
        }
        a aVar = (a) view.getTag();
        if (aVar.ngZ == null) {
            x.e("MicroMsg.GameMessageClickListener", "message is null");
        } else if (aVar.niS == null) {
            x.e("MicroMsg.GameMessageClickListener", "jumpId is null");
        } else {
            d dVar = (d) aVar.ngZ.nhX.get(aVar.niS);
            if (dVar == null) {
                x.e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
                return;
            }
            int a = a(this.mContext, aVar.ngZ, dVar, aVar.ngZ.field_appId, aVar.fGe);
            if (a != 0) {
                ap.a(this.mContext, 13, aVar.fGe, aVar.position, a, 0, aVar.ngZ.field_appId, this.niV, aVar.ngZ.niA, aVar.ngZ.field_gameMsgId, aVar.ngZ.niB, null);
            }
        }
    }

    public static int a(Context context, t tVar, d dVar, String str, int i) {
        int i2 = 0;
        switch (dVar.niJ) {
            case 1:
                if (!g.m(context, str)) {
                    return g(context, str, i);
                }
                g.Y(context, str);
                return 3;
            case 2:
                if (!g.m(context, str)) {
                    return 0;
                }
                g.Y(context, str);
                return 3;
            case 3:
                return g(context, str, i);
            case 4:
                if (tVar != null) {
                    tVar.field_isRead = true;
                    SubCoreGameCenter.aRK().c(tVar, new String[0]);
                }
                Intent intent = new Intent(context, GameMessageUI.class);
                intent.putExtra("game_report_from_scene", i);
                context.startActivity(intent);
                return 6;
            case 5:
                String str2 = dVar.lZU;
                if (!bi.oN(str2)) {
                    i2 = c.ac(context, str2);
                }
                return i2;
            default:
                x.i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + dVar.niJ);
                return 0;
        }
    }

    private static int g(Context context, String str, int i) {
        if (bi.oN(str)) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence("game_app_id", str);
        bundle.putInt("game_report_from_scene", i);
        return c.a(context, str, null, bundle);
    }
}
