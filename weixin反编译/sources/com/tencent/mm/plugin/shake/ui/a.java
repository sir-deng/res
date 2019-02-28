package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ax.n;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.ao;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.c.a, b, ao {
    Context context;
    private f inW;
    private x jQP;

    /* renamed from: com.tencent.mm.plugin.shake.ui.a$2 */
    static class AnonymousClass2 extends ag {
        final /* synthetic */ boolean kIh;
        final /* synthetic */ o kIi = null;

        AnonymousClass2(boolean z, o oVar) {
            this.kIh = z;
        }

        public final void handleMessage(Message message) {
            int i;
            int Gj = q.Gj();
            if (this.kIh) {
                i = Gj & -257;
            } else {
                i = Gj | 256;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetShake", "setInstall pluginFlag install:%b  pluginFlag : %d -> %d", Boolean.valueOf(this.kIh), Integer.valueOf(Gj), Integer.valueOf(i));
            as.Hm();
            c.Db().set(34, Integer.valueOf(i));
            as.Hm();
            c.Fe().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.kIh) {
                m.bsp();
            }
            if (this.kIi != null) {
                this.kIi.a(null, null);
            }
        }
    }

    public a(Context context) {
        this.context = context;
    }

    public final boolean ww(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetShake", "handleEvent : key = " + str);
        if (bi.oM(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_shake_go_shake")) {
            Intent intent = new Intent();
            intent.setClass(this.context, ShakeReportUI.class);
            this.context.startActivity(intent);
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_shake_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_shake_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.g(a.this.context, false);
                }
            }, null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetShake", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.gW(xVar.field_username));
        as.Hm();
        c.Db().a(this);
        as.Hm();
        c.a(this);
        this.jQP = xVar;
        this.inW = fVar;
        fVar.addPreferencesFromResource(R.o.fbS);
        asy();
        return true;
    }

    private void asy() {
        boolean z;
        boolean z2 = true;
        boolean z3 = (q.Gj() & 256) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.inW.Zu("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            int i;
            helperHeaderPreference.af(this.jQP.field_username, this.jQP.AX(), this.context.getString(R.l.dWH));
            if (z3) {
                i = 1;
            } else {
                i = 0;
            }
            helperHeaderPreference.nP(i);
        }
        this.inW.bl("contact_info_shake_install", z3);
        f fVar = this.inW;
        String str = "contact_info_shake_go_shake";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bl(str, z);
        f fVar2 = this.inW;
        String str2 = "contact_info_shake_uninstall";
        if (z3) {
            z2 = false;
        }
        fVar2.bl(str2, z2);
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMO) : context.getString(R.l.eMV);
        context.getString(R.l.dGZ);
        final ProgressDialog a = h.a(context, string, true, null);
        final ag anonymousClass2 = new AnonymousClass2(z, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass2.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public final boolean asz() {
        as.Hm();
        c.Db().b(this);
        as.Hm();
        c.b(this);
        com.tencent.mm.plugin.shake.a.ihO.un();
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void Hd() {
        asy();
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        int p = bi.p(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetShake", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(p), mVar);
        as.Hm();
        if (mVar != c.Db() || p <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetShake", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(p), mVar);
        } else if (p == 7 || p == 34) {
            asy();
        }
    }
}
