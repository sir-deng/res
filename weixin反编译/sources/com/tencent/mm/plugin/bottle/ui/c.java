package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import com.tencent.mm.R;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bj;
import com.tencent.mm.y.r;

public final class c {
    private MMActivity fnF;
    private f inW;

    public c(MMActivity mMActivity, f fVar) {
        this.fnF = mMActivity;
        this.inW = fVar;
        ChoicePreference choicePreference = (ChoicePreference) this.inW.Zu("settings_sex");
        choicePreference.yqF = new a() {
            public final boolean a(Preference preference, Object obj) {
                String str = (String) obj;
                int i = -1;
                if ("male".equalsIgnoreCase(str)) {
                    i = 1;
                } else if ("female".equalsIgnoreCase(str)) {
                    i = 2;
                }
                if (i > 0) {
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(12290, Integer.valueOf(i));
                }
                return false;
            }
        };
        choicePreference.setTitle(Html.fromHtml(this.fnF.getString(R.l.eNh) + "<font color='red'>*</font>"));
        ((KeyValuePreference) this.inW.Zu("settings_district")).setTitle(Html.fromHtml(this.fnF.getString(R.l.eLw) + "<font color='red'>*</font>"));
    }

    public static void ast() {
        bj HW = bj.HW();
        as.Hm();
        com.tencent.mm.y.c.Fe().b(new e.a(1, bj.a(HW)));
        com.tencent.mm.plugin.bottle.a.ihO.un();
    }

    public final void update() {
        as.Hm();
        ChoicePreference choicePreference = (ChoicePreference) this.inW.Zu("settings_sex");
        switch (bi.a((Integer) com.tencent.mm.y.c.Db().get(12290, null), 0)) {
            case 1:
                choicePreference.setValue("male");
                break;
            case 2:
                choicePreference.setValue("female");
                break;
            default:
                choicePreference.setValue("unknown");
                break;
        }
        bj HW = bj.HW();
        String province = HW.getProvince();
        this.inW.Zu("settings_district").setSummary(r.gy(province) + " " + HW.getCity());
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.inW.Zu("settings_signature");
        keyValuePreference.yry = false;
        as.Hm();
        CharSequence oM = bi.oM((String) com.tencent.mm.y.c.Db().get(12291, null));
        Context context = this.fnF;
        if (oM.length() <= 0) {
            oM = this.fnF.getString(R.l.eNn);
        }
        keyValuePreference.setSummary(i.a(context, oM));
        this.inW.notifyDataSetChanged();
    }

    public final boolean asu() {
        Intent intent = new Intent();
        intent.putExtra("persist_signature", false);
        com.tencent.mm.plugin.bottle.a.ihN.c(intent, this.fnF);
        return true;
    }

    public final boolean asv() {
        com.tencent.mm.plugin.bottle.a.ihN.b(new Intent(), this.fnF);
        return true;
    }
}
