package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;

public final class a implements e {
    Activity fBA;
    r mNX;
    public com.tencent.mm.plugin.profile.a.a pqZ;
    public al pra = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (!a.this.fBA.isFinishing()) {
                a aVar = a.this;
                Context context = a.this.fBA;
                a.this.fBA.getString(R.l.dGZ);
                aVar.mNX = h.a(context, a.this.fBA.getString(R.l.dHn), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(a.this.pqZ);
                        a.this.mNX = null;
                    }
                });
            }
            return false;
        }
    }, false);

    public a(Activity activity) {
        this.fBA = activity;
    }

    public final void a(int i, int i2, String str, k kVar) {
        as.CN().b((int) g.CTRL_INDEX, (e) this);
        com.tencent.mm.plugin.profile.a.a aVar = (com.tencent.mm.plugin.profile.a.a) kVar;
        if (i == 0 && i2 == 0) {
            Ih(aVar.getURL());
            return;
        }
        if (i != 4) {
            x.e("MicroMsg.ViewTWeibo", "view weibo failed: " + i + ", " + i2);
        }
        Ih("http://t.qq.com/" + aVar.pmM);
    }

    private void Ih(String str) {
        this.pra.TN();
        if (this.mNX != null) {
            this.mNX.dismiss();
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.putExtra("title", this.fBA.getString(R.l.dXu));
        intent.putExtra("zoom", true);
        intent.putExtra("vertical_scroll", false);
        d.b(this.fBA, "webview", ".ui.tools.WebViewUI", intent);
    }
}
