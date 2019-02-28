package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public class SettingsHideUsernameUI extends MMPreference {
    private f inW;
    private boolean jGh;
    private long lrE;
    private int qoR;
    private CheckBoxPreference qpt;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.username = q.FZ();
        if (bi.oN(this.username)) {
            this.username = q.FY();
        }
        this.inW = this.yrJ;
        this.lrE = q.Gd();
        this.qoR = q.Ge();
        initView();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsHideUsernameUI.this.finish();
                return true;
            }
        });
    }

    protected final void initView() {
        boolean z = true;
        setMMTitle(R.l.eOd);
        this.inW.Zu("settings_my_username").setSummary(this.username);
        boolean z2 = (this.lrE & 16384) != 0;
        this.jGh = z2;
        x.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", Boolean.valueOf(z2));
        this.qpt = (CheckBoxPreference) this.inW.Zu("settings_show_username");
        this.qpt.ysp = false;
        CheckBoxPreference checkBoxPreference = this.qpt;
        if (z2) {
            z = false;
        }
        checkBoxPreference.tYU = z;
        if (bi.oN(q.Ga())) {
            this.qpt.setEnabled(false);
        }
        this.inW.notifyDataSetChanged();
    }

    public final int XK() {
        return R.o.fcw;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        if (!preference.idX.equals("settings_show_username")) {
            return false;
        }
        if (!((CheckBoxPreference) preference).isChecked()) {
            z = true;
        }
        this.jGh = z;
        brr();
        return true;
    }

    private void brr() {
        if (this.jGh) {
            this.qpt.setSummary(getString(R.l.eNk));
        } else if (this.qpt.isEnabled()) {
            this.qpt.setSummary(getString(R.l.eNi));
        } else {
            this.qpt.setSummary(getString(R.l.eNj));
        }
    }

    protected void onResume() {
        super.onResume();
        brr();
    }

    protected void onPause() {
        boolean z = false;
        int i = 1;
        super.onPause();
        x.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", Boolean.valueOf(this.jGh));
        if ((this.lrE & 16384) != 0) {
            z = true;
        }
        if (z != this.jGh) {
            if (this.jGh) {
                this.lrE |= 16384;
                this.qoR |= WXMediaMessage.TITLE_LENGTH_LIMIT;
            } else {
                this.lrE &= -16385;
                this.qoR &= -513;
            }
            g.Dr();
            g.Dq().Db().set(147457, Long.valueOf(this.lrE));
            g.Dr();
            g.Dq().Db().set(40, Integer.valueOf(this.qoR));
            a wuVar = new wu();
            wuVar.wnP = 46;
            if (this.jGh) {
                i = 2;
            }
            wuVar.wnQ = i;
            as.Hm();
            c.Fe().b(new e.a(23, wuVar));
        }
    }
}
