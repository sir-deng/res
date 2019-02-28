package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class r implements OnClickListener {
    int kKY;
    protected Context mContext;
    private d nhC;
    String nzB = null;

    public r(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof d) {
            this.nhC = (d) view.getTag();
            x.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.nhC.field_appId);
            if (g.m(this.mContext, this.nhC.field_appId)) {
                x.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.nhC.field_appId + ", pkg = " + this.nhC.field_packageName + ", openId = " + this.nhC.field_openId);
                com.tencent.mm.plugin.game.model.g.Y(this.mContext, this.nhC.field_appId);
                ap.a(this.mContext, this.nhC.scene, this.nhC.fGe, this.nhC.position, 3, this.nhC.field_appId, this.kKY, this.nhC.fpi, this.nhC.ngQ);
                return;
            }
            x.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", this.nzB);
            if (bi.oN(this.nzB)) {
                x.e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
                return;
            }
            c.ac(this.mContext, this.nzB);
            ap.a(this.mContext, this.nhC.scene, this.nhC.fGe, this.nhC.position, 11, this.nhC.field_appId, this.kKY, this.nhC.fpi, this.nhC.ngQ);
            return;
        }
        x.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
    }
}
