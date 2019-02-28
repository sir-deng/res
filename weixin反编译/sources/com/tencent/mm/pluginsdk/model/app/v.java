package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.mm.ad.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;

public final class v implements t {
    k frW;
    public Context mContext;
    public r tipDialog;
    public a vli;

    public interface a {
        void bGh();
    }

    public v(Context context, a aVar) {
        this.mContext = context;
        this.vli = aVar;
    }

    public final void a(int i, int i2, String str, w wVar) {
        x.i("MicroMsg.LoadAppInfoAfterLogin", "OnScenEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        an.aRP().b(7, this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.vli != null) {
            this.vli.bGh();
        }
        g.bZt();
    }
}
