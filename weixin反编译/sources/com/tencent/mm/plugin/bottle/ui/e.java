package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ax.g;
import com.tencent.mm.ax.n;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bj;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class e implements a, b {
    final Context context;
    private boolean frK;
    private f inW;
    private x jQP;
    private final Map<String, Preference> kIf = new HashMap();
    private int status;

    /* renamed from: com.tencent.mm.plugin.bottle.ui.e$3 */
    static class AnonymousClass3 extends ag {
        final /* synthetic */ boolean kIh;
        final /* synthetic */ o kIi = null;

        AnonymousClass3(boolean z, o oVar) {
            this.kIh = z;
        }

        public final void handleMessage(Message message) {
            int i;
            int i2;
            boolean z = this.kIh;
            int Gc = q.Gc();
            int Gj = q.Gj();
            if (z) {
                i = Gc | Downloads.RECV_BUFFER_SIZE;
                i2 = Gj & -65;
                as.Hm();
                c.Fe().b(new g(11, 1));
            } else {
                i = Gc & -4097;
                i2 = Gj | 64;
                as.Hm();
                c.Fe().b(new g(11, 2));
            }
            as.Hm();
            c.Db().set(7, Integer.valueOf(i));
            as.Hm();
            c.Db().set(34, Integer.valueOf(i2));
            as.Hm();
            c.Fe().b(new n("", "", "", "", "", "", "", "", i2, "", ""));
            if (!this.kIh) {
                i.aso();
            }
            if (this.kIi != null) {
                this.kIi.a(null, null);
            }
        }
    }

    public e(Context context) {
        this.context = context;
    }

    public final boolean ww(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetFloatBottle", "handleEvent : key = " + str);
        if (bi.oM(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_goto_floatbottle")) {
            bj HW = bj.HW();
            if (bi.a(Integer.valueOf(HW.fXa), 0) <= 0 || bi.oN(HW.getProvince())) {
                this.context.startActivity(new Intent(this.context, BottleWizardStep1.class));
            } else {
                this.context.startActivity(new Intent(this.context, BottleBeachUI.class));
            }
            return true;
        } else if (str.equals("contact_info_floatbottle_clear_data")) {
            h.a(this.context, this.context.getString(R.l.dUR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    i.aso();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_floatbottle_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_floatbottle_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    e.g(e.this.context, false);
                }
            }, null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetFloatBottle", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(s.gO(xVar.field_username));
        as.Hm();
        c.Db().a(this);
        this.jQP = xVar;
        this.inW = fVar;
        fVar.addPreferencesFromResource(R.o.fbG);
        Preference Zu = fVar.Zu("contact_info_header_helper");
        if (Zu != null) {
            this.kIf.put("contact_info_header_helper", Zu);
        }
        Zu = fVar.Zu("contact_info_goto_floatbottle");
        if (Zu != null) {
            this.kIf.put("contact_info_goto_floatbottle", Zu);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) fVar.Zu("contact_info_floatbottle_hide_cat");
        if (preferenceCategory != null) {
            this.kIf.put("contact_info_floatbottle_hide_cat", preferenceCategory);
        }
        Zu = fVar.Zu("contact_info_floatbottle_clear_data");
        if (Zu != null) {
            this.kIf.put("contact_info_floatbottle_clear_data", Zu);
        }
        preferenceCategory = (PreferenceCategory) fVar.Zu("contact_info_floatbottle_hide_cat2");
        if (preferenceCategory != null) {
            this.kIf.put("contact_info_floatbottle_hide_cat2", preferenceCategory);
        }
        preferenceCategory = (PreferenceCategory) fVar.Zu("contact_info_floatbottle_hide_cat3");
        if (preferenceCategory != null) {
            this.kIf.put("contact_info_floatbottle_hide_cat3", preferenceCategory);
        }
        Zu = fVar.Zu("contact_info_floatbottle_install");
        if (Zu != null) {
            this.kIf.put("contact_info_floatbottle_install", Zu);
        }
        Zu = fVar.Zu("contact_info_floatbottle_uninstall");
        if (Zu != null) {
            this.kIf.put("contact_info_floatbottle_uninstall", Zu);
        }
        asy();
        return true;
    }

    private void asy() {
        int i = 1;
        this.status = q.Gc();
        this.frK = (q.Gj() & 64) == 0;
        this.inW.removeAll();
        if (this.kIf.containsKey("contact_info_header_helper")) {
            this.inW.a((HelperHeaderPreference) this.kIf.get("contact_info_header_helper"));
            HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.inW.Zu("contact_info_header_helper");
            helperHeaderPreference.af(this.jQP.field_username, this.jQP.AX(), this.context.getString(R.l.dVq));
            if (!this.frK) {
                i = 0;
            }
            helperHeaderPreference.nP(i);
        }
        if (this.kIf.containsKey("contact_info_floatbottle_hide_cat")) {
            this.inW.a((Preference) this.kIf.get("contact_info_floatbottle_hide_cat"));
        }
        if (this.frK) {
            if (this.kIf.containsKey("contact_info_goto_floatbottle")) {
                this.inW.a((Preference) this.kIf.get("contact_info_goto_floatbottle"));
            }
            if (this.kIf.containsKey("contact_info_floatbottle_clear_data")) {
                this.inW.a((Preference) this.kIf.get("contact_info_floatbottle_clear_data"));
            }
            if (this.kIf.containsKey("contact_info_floatbottle_hide_cat2")) {
                this.inW.a((Preference) this.kIf.get("contact_info_floatbottle_hide_cat2"));
            }
            if (this.kIf.containsKey("contact_info_floatbottle_uninstall")) {
                this.inW.a((Preference) this.kIf.get("contact_info_floatbottle_uninstall"));
            }
        } else if (this.kIf.containsKey("contact_info_floatbottle_install")) {
            this.inW.a((Preference) this.kIf.get("contact_info_floatbottle_install"));
        }
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

    public final boolean asz() {
        as.Hm();
        c.Db().b(this);
        com.tencent.mm.plugin.bottle.a.ihO.un();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetFloatBottle", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(p), mVar);
        as.Hm();
        if (mVar != c.Db() || p <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetFloatBottle", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(p), mVar);
        } else if (p == 40 || p == 34 || p == 7) {
            asy();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
