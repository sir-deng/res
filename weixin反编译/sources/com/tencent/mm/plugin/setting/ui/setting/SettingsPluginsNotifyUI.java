package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ax.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public class SettingsPluginsNotifyUI extends MMPreference {
    private f inW;
    private int state;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        super.onResume();
        brC();
    }

    public final int XK() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        if (str.equals("settings_plugings_disturb_on")) {
            wp(0);
        }
        if (str.equals("settings_plugings_disturb_on_night")) {
            wp(1);
        }
        if (str.equals("settings_plugings_disturb_off")) {
            wp(2);
        }
        return false;
    }

    private void brC() {
        this.inW.removeAll();
        Preference preference = new Preference(this);
        preference.setTitle(R.l.eMC);
        preference.setKey("settings_plugings_disturb_on");
        preference.setLayoutResource(R.i.dnz);
        if (this.state == 0) {
            preference.setWidgetLayoutResource(R.i.dof);
        } else {
            preference.setWidgetLayoutResource(R.i.dog);
        }
        this.inW.a(preference);
        preference = new Preference(this);
        preference.setTitle(R.l.eMD);
        preference.setKey("settings_plugings_disturb_on_night");
        preference.setLayoutResource(R.i.dnz);
        if (this.state == 1) {
            preference.setWidgetLayoutResource(R.i.dof);
        } else {
            preference.setWidgetLayoutResource(R.i.dog);
        }
        this.inW.a(preference);
        preference = new Preference(this);
        preference.setTitle(R.l.eMB);
        preference.setKey("settings_plugings_disturb_off");
        preference.setLayoutResource(R.i.dnz);
        if (this.state == 2) {
            preference.setWidgetLayoutResource(R.i.dof);
        } else {
            preference.setWidgetLayoutResource(R.i.dog);
        }
        this.inW.a(preference);
        preference = new Preference(this);
        preference.setTitle(R.l.eME);
        preference.setLayoutResource(R.i.doc);
        this.inW.a(preference);
        this.inW.notifyDataSetChanged();
    }

    private void wp(int i) {
        this.state = i;
        if (this.state == 1 || this.state == 0) {
            as.Hm();
            c.Db().set(8200, Boolean.valueOf(true));
            if (this.state == 1) {
                as.Hm();
                c.Db().set(8201, Integer.valueOf(22));
                as.Hm();
                c.Db().set(8208, Integer.valueOf(8));
                as.Hm();
                c.Fe().b(new l(true, 22, 8));
            } else {
                as.Hm();
                c.Db().set(8201, Integer.valueOf(0));
                as.Hm();
                c.Db().set(8208, Integer.valueOf(0));
                as.Hm();
                c.Fe().b(new l(true, 0, 0));
            }
        } else {
            as.Hm();
            c.Db().set(8200, Boolean.valueOf(false));
            as.Hm();
            c.Fe().b(new l());
        }
        brC();
    }

    protected final void initView() {
        Boolean valueOf = Boolean.valueOf(q.Gu());
        int GC = q.GC();
        int GD = q.GD();
        if (valueOf.booleanValue()) {
            this.state = GC == GD ? 0 : 1;
        } else {
            this.state = 2;
        }
        x.d("ui.settings.SettingsPlugingsNotify", valueOf + "st " + GC + " ed " + GD + "  state " + this.state);
        this.state = this.state;
        this.inW = this.yrJ;
        setMMTitle(R.l.eMF);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsPluginsNotifyUI.this.aWY();
                SettingsPluginsNotifyUI.this.finish();
                return true;
            }
        });
    }
}
