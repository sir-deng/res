package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bj;
import com.tencent.mm.y.c;
import com.tencent.mm.y.r;

public class NearbyPersonalInfoUI extends MMPreference {
    private int fXa = -1;
    private f inW;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.exI);
        this.inW = this.yrJ;
        ((KeyValuePreference) this.inW.Zu("settings_signature")).yry = false;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                NearbyPersonalInfoUI.this.finish();
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.l.dGb), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                bj HW;
                if (NearbyPersonalInfoUI.this.fXa != -1) {
                    HW = bj.HW();
                    HW.fXa = NearbyPersonalInfoUI.this.fXa;
                    bj.a(HW);
                }
                HW = bj.HX();
                if (HW == null) {
                    h.a(NearbyPersonalInfoUI.this.mController.xRr, R.l.exJ, R.l.dGZ, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    String oM = bi.oM(HW.getProvince());
                    bi.oM(HW.getCity());
                    int i = HW.fXa;
                    if (bi.oN(oM) || i == 0) {
                        h.a(NearbyPersonalInfoUI.this.mController.xRr, R.l.exJ, R.l.dGZ, /* anonymous class already generated */);
                    } else {
                        NearbyPersonalInfoUI.this.startActivity(new Intent(NearbyPersonalInfoUI.this, NearbyFriendsUI.class));
                        bj HW2 = bj.HW();
                        if (i != -1) {
                            HW2.fXa = i;
                        }
                        as.Hm();
                        c.Fe().b(new a(1, bj.a(HW2)));
                        NearbyPersonalInfoUI.this.finish();
                    }
                }
                return true;
            }
        });
        ((ChoicePreference) this.inW.Zu("settings_sex")).yqF = new Preference.a() {
            public final boolean a(Preference preference, Object obj) {
                String str = (String) obj;
                if ("male".equalsIgnoreCase(str)) {
                    NearbyPersonalInfoUI.this.fXa = 1;
                } else if ("female".equalsIgnoreCase(str)) {
                    NearbyPersonalInfoUI.this.fXa = 2;
                }
                return false;
            }
        };
        as.Hm();
        int a = bi.a((Integer) c.Db().get(12290, null), 0);
        ChoicePreference choicePreference = (ChoicePreference) this.inW.Zu("settings_sex");
        choicePreference.setTitle(Html.fromHtml(getString(R.l.eNh) + "<font color='red'>*</font>"));
        switch (a) {
            case 1:
                choicePreference.setValue("male");
                return;
            case 2:
                choicePreference.setValue("female");
                return;
            default:
                choicePreference.setValue("unknown");
                return;
        }
    }

    public void onResume() {
        bj HW = bj.HW();
        String province = HW.getProvince();
        String city = HW.getCity();
        Preference Zu = this.inW.Zu("settings_district");
        Zu.setSummary(r.gy(province) + " " + city);
        Zu.setTitle(Html.fromHtml(getString(R.l.eLw) + "<font color='red'>*</font>"));
        Preference Zu2 = this.inW.Zu("settings_signature");
        as.Hm();
        CharSequence oM = bi.oM((String) c.Db().get(12291, null));
        if (oM.length() <= 0) {
            oM = getString(R.l.eNn);
        }
        Zu2.setSummary(i.a((Context) this, oM));
        super.onResume();
    }

    public final int XK() {
        return R.o.exI;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        if ("settings_district".equals(str)) {
            com.tencent.mm.plugin.nearby.a.ihN.b(null, (Context) this);
            return true;
        } else if (!"settings_signature".equals(str)) {
            return false;
        } else {
            com.tencent.mm.plugin.nearby.a.ihN.c(null, this);
            overridePendingTransition(R.a.bqo, R.a.bqn);
            return true;
        }
    }
}
