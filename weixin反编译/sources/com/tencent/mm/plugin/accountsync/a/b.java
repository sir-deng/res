package com.tencent.mm.plugin.accountsync.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;

public final class b implements e, f {
    public Context context;
    public k frW;
    private ag handler = new ag(Looper.getMainLooper());
    public a imX;
    public r tipDialog;

    public interface a {
        void Xx();
    }

    public b(Context context, a aVar) {
        this.context = context;
        this.imX = aVar;
    }

    public final void a(int i, int i2, k kVar) {
        final int i3 = i2 != 0 ? (int) ((((long) i) * 100) / ((long) i2)) : 0;
        this.handler.post(new Runnable() {
            public final void run() {
                if (b.this.tipDialog != null) {
                    b.this.tipDialog.setMessage(b.this.context.getString(R.l.dFJ) + i3 + "%");
                }
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == v.CTRL_INDEX) {
            as.CN().b((int) v.CTRL_INDEX, (e) this);
        } else if (kVar.getType() == 138) {
            as.CN().b(138, (e) this);
        }
        if (i2 == 0 && i == 0) {
            this.imX.Xx();
        } else {
            x.e("MicroMsg.DoInit", "do init failed, err=" + i + "," + i2);
            this.imX.Xx();
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
    }
}
