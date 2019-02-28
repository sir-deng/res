package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class s implements e {
    Context context;
    r mNX;
    private al pra = new al(new a() {
        public final boolean uG() {
            s sVar = s.this;
            Context context = s.this.context;
            s.this.context.getString(R.l.dGZ);
            sVar.mNX = h.a(context, s.this.context.getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(s.this.qfw);
                    s.this.mNX = null;
                }
            });
            return false;
        }
    }, false);
    l qfw;
    private String vvi;

    public s(Context context) {
        this.context = context;
    }

    public final void SZ(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
            return;
        }
        this.vvi = str;
        as.Hm();
        String str2 = (String) c.Db().get(46, null);
        as.Hm();
        x.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", str2, bi.oM((String) c.Db().get(72, null)));
        if (bi.oN(str2) && bi.oN(r1)) {
            Ta(str);
            return;
        }
        as.CN().a(233, (e) this);
        this.qfw = new l(o.bY(str), (int) System.currentTimeMillis());
        as.CN().a(this.qfw, 0);
        this.pra.K(3000, 3000);
    }

    private void Ta(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.context.getString(R.l.dWk, new Object[]{str}));
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("neverGetA8Key", true);
        d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.pra.TN();
        if (this.mNX != null) {
            this.mNX.dismiss();
        }
        as.CN().b(233, (e) this);
        if (i == 0 && i2 == 0) {
            l lVar = (l) kVar;
            String RL = lVar.RL();
            if (RL == null || RL.length() == 0) {
                Ta(this.vvi);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", RL);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("geta8key_session_id", lVar.RT());
            d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
            return;
        }
        x.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + i + ", errCode = " + i2);
        Ta(this.vvi);
    }
}
