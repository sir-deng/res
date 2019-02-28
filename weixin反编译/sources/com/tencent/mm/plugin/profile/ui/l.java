package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import junit.framework.Assert;

abstract class l implements a, b {
    protected Context context;
    protected f inW;
    protected x jQP;
    protected HelperHeaderPreference.a ppq;

    protected abstract int XK();

    protected abstract boolean bkf();

    protected abstract void clear();

    protected abstract void hm(boolean z);

    public l(Context context, HelperHeaderPreference.a aVar) {
        this.context = context;
        this.ppq = aVar;
    }

    public void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(p), mVar);
        as.Hm();
        if (mVar != c.Db() || p <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(p), mVar);
        } else if (p == 40 || p == 34 || p == 7) {
            asy();
        }
    }

    public boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        Assert.assertTrue(xVar != null);
        if (bi.oM(xVar.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (fVar != null) {
            z3 = true;
        }
        Assert.assertTrue(z3);
        as.Hm();
        c.Db().a(this);
        this.jQP = xVar;
        this.inW = fVar;
        asy();
        return true;
    }

    public boolean asz() {
        as.Hm();
        c.Db().b(this);
        this.inW.Zu("contact_info_header_helper");
        return true;
    }

    public boolean ww(String str) {
        if ("contact_info_plugin_clear_data".equals(str)) {
            h.a(this.context, this.context.getString(R.l.dUR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    l.this.clear();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_plugin_install")) {
            hm(true);
            return true;
        } else if (str.equals("contact_info_plugin_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    l.this.hm(false);
                }
            }, null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = " + str);
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    private void asy() {
        this.inW.removeAll();
        this.inW.addPreferencesFromResource(XK());
        boolean bkf = bkf();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.inW.Zu("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            helperHeaderPreference.a(this.jQP, this.ppq);
        }
        if (bkf) {
            this.inW.Zv("contact_info_plugin_install");
            return;
        }
        this.inW.Zv("contact_info_plugin_view");
        this.inW.Zv("contact_info_plugin_clear_data");
        this.inW.Zv("contact_info_plugin_uninstall");
    }
}
