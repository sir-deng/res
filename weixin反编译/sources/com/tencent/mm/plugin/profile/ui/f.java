package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ax.n;
import com.tencent.mm.bl.d;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
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

public final class f implements a, b {
    Context context;
    private com.tencent.mm.ui.base.preference.f inW;
    private x jQP;
    private Map<String, Preference> kIf = new HashMap();
    private HelperHeaderPreference.a poM;

    /* renamed from: com.tencent.mm.plugin.profile.ui.f$2 */
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
                i = Gj & -8193;
            } else {
                i = Gj | 8192;
            }
            as.Hm();
            c.Db().set(34, Integer.valueOf(i));
            as.Hm();
            c.Fe().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.kIh) {
                af.OK().NM();
                as.Hm();
                c.Db().set(65828, "");
                as.Hm();
                c.Fk().XE("facebookapp");
                as.Hm();
                c.Fh().Fj("facebookapp");
            }
            if (this.kIi != null) {
                this.kIi.a(null, null);
            }
        }
    }

    public f(Context context) {
        this.context = context;
        this.poM = new p(context);
        as.Hm();
        c.Fk().XH("facebookapp");
    }

    public final boolean ww(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetFacebookapp", "handleEvent : key = " + str);
        if (bi.oM(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_facebookapp_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_facebookapp_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    f.g(f.this.context, false);
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_facebookapp_listfriend")) {
            d.b(this.context, "", "com.tencent.mm.ui.account.FacebookFriendUI", new Intent());
            return true;
        } else if (str.equals("contact_info_facebookapp_connect")) {
            d.a(this.context, ".ui.account.FacebookAuthUI", new Intent());
            return true;
        } else if (str.equals("contact_info_facebookapp_addr")) {
            d.a(this.context, ".ui.account.FacebookAuthUI", new Intent());
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.gQ(xVar.field_username));
        as.Hm();
        c.Db().a(this);
        this.jQP = xVar;
        this.inW = fVar;
        fVar.addPreferencesFromResource(R.o.fbE);
        Preference Zu = fVar.Zu("contact_info_header_helper");
        if (Zu != null) {
            this.kIf.put("contact_info_header_helper", Zu);
        }
        Zu = fVar.Zu("contact_info_facebookapp_listfriend");
        if (Zu != null) {
            this.kIf.put("contact_info_facebookapp_listfriend", Zu);
        }
        Zu = fVar.Zu("contact_info_facebookapp_connect");
        if (Zu != null) {
            this.kIf.put("contact_info_facebookapp_connect", Zu);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) fVar.Zu("contact_info_facebookapp_cat");
        if (preferenceCategory != null) {
            this.kIf.put("contact_info_facebookapp_cat", preferenceCategory);
        }
        Zu = fVar.Zu("contact_info_facebookapp_addr");
        if (Zu != null) {
            this.kIf.put("contact_info_facebookapp_addr", Zu);
        }
        preferenceCategory = (PreferenceCategory) fVar.Zu("contact_info_facebookapp_cat2");
        if (preferenceCategory != null) {
            this.kIf.put("contact_info_facebookapp_cat2", preferenceCategory);
        }
        Zu = fVar.Zu("contact_info_facebookapp_install");
        if (Zu != null) {
            this.kIf.put("contact_info_facebookapp_install", Zu);
        }
        Zu = fVar.Zu("contact_info_facebookapp_uninstall");
        if (Zu != null) {
            this.kIf.put("contact_info_facebookapp_uninstall", Zu);
        }
        asy();
        return true;
    }

    private void asy() {
        this.inW.removeAll();
        if (this.kIf.containsKey("contact_info_header_helper")) {
            HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.kIf.get("contact_info_header_helper");
            helperHeaderPreference.a(this.jQP, this.poM);
            this.inW.a(helperHeaderPreference);
        }
        if (this.kIf.containsKey("contact_info_facebookapp_cat")) {
            this.inW.a((Preference) this.kIf.get("contact_info_facebookapp_cat"));
        }
        if (((q.Gj() & 8192) == 0 ? 1 : null) != null) {
            if (q.Gz()) {
                if (this.kIf.containsKey("contact_info_facebookapp_addr")) {
                    this.inW.a((Preference) this.kIf.get("contact_info_facebookapp_addr"));
                    Preference preference = (Preference) this.kIf.get("contact_info_facebookapp_addr");
                    as.Hm();
                    preference.setSummary((String) c.Db().get(65826, null));
                }
            } else if (this.kIf.containsKey("contact_info_facebookapp_connect")) {
                this.inW.a((Preference) this.kIf.get("contact_info_facebookapp_connect"));
            }
            if (this.kIf.containsKey("contact_info_facebookapp_cat2")) {
                this.inW.a((Preference) this.kIf.get("contact_info_facebookapp_cat2"));
            }
            if (this.kIf.containsKey("contact_info_facebookapp_uninstall")) {
                this.inW.a((Preference) this.kIf.get("contact_info_facebookapp_uninstall"));
            }
        } else if (this.kIf.containsKey("contact_info_facebookapp_install")) {
            this.inW.a((Preference) this.kIf.get("contact_info_facebookapp_install"));
        }
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMO) : context.getString(R.l.eMV);
        context.getString(R.l.dGZ);
        final r a = h.a(context, string, true, null);
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
        this.kIf.get("contact_info_header_helper");
        com.tencent.mm.plugin.profile.a.ihO.un();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(p), mVar);
        as.Hm();
        if (mVar != c.Db() || p <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(p), mVar);
        } else if (p == 40 || p == 34 || p == 65825) {
            asy();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
