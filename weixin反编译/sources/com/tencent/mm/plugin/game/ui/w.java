package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.bj;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class w implements OnClickListener {
    private Context mContext;
    private int nBM;
    int niV = 0;
    private d njd;
    String nqO = null;

    public w(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof d) {
            this.njd = (d) view.getTag();
            x.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.njd.field_appId);
            if (g.m(this.mContext, this.njd.field_appId)) {
                x.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.njd.field_appId + ", pkg = " + this.njd.field_packageName + ", openId = " + this.njd.field_openId);
                ap.a(this.mContext, this.njd.scene, this.njd.fGe, this.njd.position, 3, this.njd.field_appId, this.niV, this.nqO);
                com.tencent.mm.plugin.game.model.g.Y(this.mContext, this.njd.field_appId);
                return;
            }
            bj.aRF();
            this.nBM = bj.CF(this.njd.fRI);
            x.i("MicroMsg.GameTMAssistClickListener", "get download status:[%s]", Integer.valueOf(this.nBM));
            switch (this.nBM) {
                case 1:
                    aSu();
                    return;
                case 2:
                    aSu();
                    return;
                case 3:
                    aSu();
                    return;
                case 4:
                    aSu();
                    return;
                case 5:
                    aSu();
                    return;
                default:
                    aSu();
                    return;
            }
        }
        x.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
    }

    private void aSu() {
        int i;
        String str = this.njd.fRI;
        if (!bi.oN(str)) {
            str = str.replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
        }
        if (this.njd.status == 3) {
            bj.aRF();
            bj.startToAuthorized(this.mContext, str);
        } else {
            bj.aRF();
            bj.ab(this.mContext, str);
        }
        int i2 = 5;
        if (this.njd.status == 3) {
            i2 = 10;
        }
        if (this.nBM == 4) {
            i = 8;
        } else {
            i = i2;
        }
        ap.a(this.mContext, this.njd.scene, this.njd.fGe, this.njd.position, i, this.njd.field_appId, this.niV, this.njd.fpi, this.nqO);
    }
}
