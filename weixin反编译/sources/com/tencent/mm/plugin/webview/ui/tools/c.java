package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

final class c {
    al hmy = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (c.this.tDd.isFinishing()) {
                x.w("MicroMsg.OAuthSession", "onTimerExpired, context is finishing");
            } else {
                c cVar = c.this;
                Context context = c.this.tDd;
                c.this.tDd.getString(R.l.dGZ);
                cVar.mNX = h.a(context, c.this.tDd.getString(R.l.dHn), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        try {
                            dialogInterface.dismiss();
                        } catch (Exception e) {
                            x.e("MicroMsg.OAuthSession", "onCancel, ex = " + e.getMessage());
                        }
                    }
                });
            }
            return false;
        }
    }, false);
    d jAm;
    r mNX;
    boolean tDa = false;
    boolean tDb = false;
    final a tDc;
    OAuthUI tDd;

    public interface a {
        void a(c cVar, String str, boolean z);

        void c(boolean z, String str, String str2, String str3);
    }

    private c(OAuthUI oAuthUI, a aVar, d dVar) {
        this.tDd = oAuthUI;
        this.tDc = aVar;
        this.jAm = dVar;
    }

    public static c a(OAuthUI oAuthUI, String str, Req req, a aVar, d dVar) {
        c cVar = new c(oAuthUI, aVar, dVar);
        String str2 = req.scope;
        String str3 = req.state;
        if (cVar.tDa) {
            x.e("MicroMsg.OAuthSession", "already getting");
        } else {
            cVar.tDb = true;
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_appid", str);
            bundle.putString("geta8key_data_scope", str2);
            bundle.putString("geta8key_data_state", str3);
            try {
                cVar.jAm.r(233, bundle);
                cVar.tDa = true;
            } catch (Exception e) {
                x.w("MicroMsg.OAuthSession", "startGetA8Key, ex = " + e.getMessage());
            }
            cVar.hmy.K(3000, 3000);
        }
        return cVar;
    }
}
