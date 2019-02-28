package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ax.n;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.c.a, b {
    Context context;
    private f inW;
    private x jQP;
    private Map<String, Preference> kIf = new HashMap();

    /* renamed from: com.tencent.mm.plugin.masssend.ui.a$3 */
    static class AnonymousClass3 extends ag {
        final /* synthetic */ boolean kIh;
        final /* synthetic */ o kIi = null;

        AnonymousClass3(boolean z, o oVar) {
            this.kIh = z;
        }

        public final void handleMessage(Message message) {
            int i;
            int Gj = q.Gj();
            if (this.kIh) {
                i = Gj & -65537;
            } else {
                i = Gj | 65536;
            }
            as.Hm();
            c.Db().set(34, Integer.valueOf(i));
            as.Hm();
            c.Fe().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.kIh) {
                a.abi();
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
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetMassSend", "handleEvent : key = " + str);
        if (bi.oM(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_masssend_view")) {
            this.context.startActivity(new Intent(this.context, MassSendHistoryUI.class));
            return true;
        } else if (str.equals("contact_info_masssend_clear_data")) {
            h.a(this.context, this.context.getString(R.l.dUR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.abi();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_masssend_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_masssend_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.g(a.this.context, false);
                }
            }, null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetMassSend", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(s.gR(xVar.field_username));
        as.Hm();
        c.Db().a(this);
        this.jQP = xVar;
        this.inW = fVar;
        fVar.addPreferencesFromResource(R.o.fbK);
        asy();
        return true;
    }

    private void asy() {
        int i;
        boolean z;
        boolean z2 = true;
        boolean z3 = (q.Gj() & 65536) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.inW.Zu("contact_info_masssend_header_helper");
        helperHeaderPreference.af(this.jQP.field_username, this.jQP.AX(), this.context.getString(R.l.dVM));
        if (z3) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.nP(i);
        this.inW.bl("contact_info_masssend_install", z3);
        f fVar = this.inW;
        String str = "contact_info_masssend_view";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bl(str, z);
        fVar = this.inW;
        str = "contact_info_masssend_clear_data";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bl(str, z);
        f fVar2 = this.inW;
        String str2 = "contact_info_masssend_uninstall";
        if (z3) {
            z2 = false;
        }
        fVar2.bl(str2, z2);
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMO) : context.getString(R.l.eMV);
        context.getString(R.l.dGZ);
        final r a = h.a(context, string, true, null);
        final ag anonymousClass3 = new AnonymousClass3(z, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass3.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public static void abi() {
        com.tencent.mm.plugin.masssend.a.b aZj = com.tencent.mm.plugin.masssend.a.h.aZj();
        if (aZj.hiZ.fD("massendinfo", "delete from massendinfo")) {
            aZj.doNotify();
        }
        as.Hm();
        c.Fk().XE("masssendapp");
    }

    public final boolean asz() {
        as.Hm();
        c.Db().b(this);
        com.tencent.mm.plugin.masssend.a.ihO.un();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetMassSend", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(p), mVar);
        as.Hm();
        if (mVar != c.Db() || p <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetMassSend", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(p), mVar);
        } else if (p == 40 || p == 34 || p == 7) {
            asy();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
