package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public class SettingsAboutTimelineUI extends MMPreference {
    private String gAM = "";
    private f inW;
    private boolean qox = false;
    private boolean qoy = false;

    public final int XK() {
        return R.o.fct;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        super.onResume();
        bmk bmk = new bmk();
        if (n.qWC != null) {
            bmk = n.qWC.Ke(this.gAM);
        }
        if (bmk == null) {
            x.e("MicroMsg.SettingsAboutTimelineUI", "userinfo is null");
        } else {
            int i = bmk.wWj;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("timeline_stranger_show");
            if (checkBoxPreference != null) {
                this.qoy = (i & 1) > 0;
                SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
                if (this.qoy) {
                    checkBoxPreference.tYU = false;
                    sharedPreferences.edit().putBoolean("timeline_stranger_show", false).commit();
                } else {
                    checkBoxPreference.tYU = true;
                    sharedPreferences.edit().putBoolean("timeline_stranger_show", true).commit();
                }
            }
        }
        this.inW.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        String str = preference.idX;
        if (str.equals("timline_outside_permiss")) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4);
            intent.putExtra("k_sns_from_settings_about_sns", 1);
            d.b(this, "sns", ".ui.SnsBlackDetailUI", intent);
        }
        if (str.equals("timeline_black_permiss")) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 5);
            intent.putExtra("k_sns_from_settings_about_sns", 2);
            d.b(this, "sns", ".ui.SnsTagDetailUI", intent);
        }
        if (str.equals("timeline_stranger_show")) {
            this.qoy = !this.qoy;
            if (n.qWC != null) {
                n.qWC.aC(this.gAM, this.qoy);
            }
            this.qox = true;
        }
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.qox && n.qWC != null) {
            a aD = n.qWC.aD(this.gAM, this.qoy);
            if (aD != null) {
                x.d("MicroMsg.SettingsAboutTimelineUI", "userinfo " + aD.toString());
                as.Hm();
                c.Fe().b(new e.a(51, aD));
            }
        }
    }

    protected final void initView() {
        this.inW = this.yrJ;
        setMMTitle(R.l.eMA);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsAboutTimelineUI.this.aWY();
                SettingsAboutTimelineUI.this.finish();
                return true;
            }
        });
        this.gAM = q.FY();
    }
}
