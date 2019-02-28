package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.q;

public class d {
    protected String appId;
    protected Context context;
    protected a kAz;
    protected String openId;

    public interface a {
        void dT(boolean z);
    }

    public d(Context context, String str, String str2, a aVar) {
        this.context = context;
        this.appId = str;
        this.openId = str2;
        this.kAz = aVar;
    }

    public final void arC() {
        if (this.openId == null || this.openId.length() == 0) {
            x.w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
            this.kAz.dT(true);
            return;
        }
        f aZ = g.aZ(this.appId, false);
        if (aZ == null) {
            x.e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
            this.kAz.dT(true);
        } else if (t.oN(aZ.field_openId)) {
            x.w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
            x.d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
            an.biV().Pm(this.appId);
            this.kAz.dT(true);
        } else if (this.openId.equalsIgnoreCase(aZ.field_openId)) {
            x.d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
            this.kAz.dT(true);
        } else {
            x.w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.openId + ", localOpenId = " + aZ.field_openId);
            Wk();
        }
    }

    protected void Wk() {
        h.b(this.context, R.l.ezY, R.l.dGZ, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                j jVar = com.tencent.mm.pluginsdk.q.a.vjc;
                if (jVar != null) {
                    jVar.N(d.this.openId, q.Gb(), d.this.appId);
                }
                d.this.kAz.dT(true);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                j jVar = com.tencent.mm.pluginsdk.q.a.vjc;
                if (jVar != null) {
                    jVar.N(d.this.openId, q.Gb(), d.this.appId);
                }
                d.this.kAz.dT(false);
            }
        });
    }
}
