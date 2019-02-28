package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.Map.Entry;

public class SettingsAddMeUI extends MMPreference {
    private f inW;
    private HashMap<Integer, Integer> kHY = new HashMap();
    private long lrE;
    private int qoR;
    private int status;

    public final h a(SharedPreferences sharedPreferences) {
        return new a(this, sharedPreferences);
    }

    public final int XK() {
        return R.o.fcu;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.inW = this.yrJ;
        this.qoR = q.Ge();
        this.status = q.Gc();
        this.lrE = q.Gd();
        initView();
    }

    public void onPause() {
        super.onPause();
        x.d("MicroMsg.SettingsAddMeUI", "plug:" + this.qoR + ",status:" + this.status + ",extstatus:" + this.lrE);
        as.Hm();
        c.Db().set(7, Integer.valueOf(this.status));
        as.Hm();
        c.Db().set(40, Integer.valueOf(this.qoR));
        as.Hm();
        c.Db().set(147457, Long.valueOf(this.lrE));
        for (Entry entry : this.kHY.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            com.tencent.mm.bp.a wuVar = new wu();
            wuVar.wnP = intValue;
            wuVar.wnQ = intValue2;
            as.Hm();
            c.Fe().b(new e.a(23, wuVar));
            x.d("MicroMsg.SettingsAddMeUI", "switch  " + intValue + " " + intValue2);
        }
        this.kHY.clear();
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.idX;
        x.i("MicroMsg.SettingsAddMeUI", str + " item has been clicked!");
        if (str.equals("settings_find_me_by_QQ")) {
            boolean z2 = !((CheckBoxPreference) fVar.Zu("settings_find_me_by_QQ")).isChecked();
            a(z2, 8, 2);
            a(z2, 16, 3);
            return true;
        } else if (str.equals("settings_find_me_by_weixin")) {
            if (!((CheckBoxPreference) fVar.Zu("settings_find_me_by_weixin")).isChecked()) {
                z = true;
            }
            x.d("MicroMsg.SettingsAddMeUI", "switch plug change : open = " + z + " item value = 512 functionId = 25");
            if (z) {
                this.qoR |= WXMediaMessage.TITLE_LENGTH_LIMIT;
            } else {
                this.qoR &= -513;
            }
            this.kHY.put(Integer.valueOf(25), Integer.valueOf(z ? 1 : 2));
            return true;
        } else if (str.equals("settings_find_me_by_mobile")) {
            if (!((CheckBoxPreference) fVar.Zu("settings_find_me_by_mobile")).isChecked()) {
                z = true;
            }
            a(z, WXMediaMessage.TITLE_LENGTH_LIMIT, 8);
            return true;
        } else if (str.equals("settings_find_me_by_google")) {
            if (!((CheckBoxPreference) fVar.Zu("settings_find_me_by_google")).isChecked()) {
                z = true;
            }
            a(z, SQLiteGlobal.journalSizeLimit, 30);
            return true;
        } else if (str.equals("settings_add_me_by_chatroom")) {
            if (!((CheckBoxPreference) fVar.Zu("settings_add_me_by_chatroom")).isChecked()) {
                z = true;
            }
            b(z, 1, 38);
            return true;
        } else if (str.equals("settings_add_me_by_qrcode")) {
            if (!((CheckBoxPreference) fVar.Zu("settings_add_me_by_qrcode")).isChecked()) {
                z = true;
            }
            b(z, 2, 39);
            return true;
        } else if (!str.equals("settings_add_me_by_namecard")) {
            return false;
        } else {
            if (!((CheckBoxPreference) fVar.Zu("settings_add_me_by_namecard")).isChecked()) {
                z = true;
            }
            b(z, 4, 40);
            return true;
        }
    }

    private void a(boolean z, int i, int i2) {
        x.d("MicroMsg.SettingsAddMeUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.kHY.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
    }

    private void b(boolean z, int i, int i2) {
        x.d("MicroMsg.SettingsAddMeUI", "switch ext change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.lrE |= (long) i;
        } else {
            this.lrE &= (long) (i ^ -1);
        }
        this.kHY.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
    }

    protected final void initView() {
        boolean z;
        boolean z2;
        setMMTitle(R.l.eLh);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsAddMeUI.this.aWY();
                SettingsAddMeUI.this.finish();
                return true;
            }
        });
        x.d("MicroMsg.SettingsAddMeUI", "plug:" + this.qoR + ",status:" + this.status + ",extstatus:" + this.lrE);
        this.inW.removeAll();
        this.inW.addPreferencesFromResource(R.o.fcu);
        as.Hm();
        Integer num = (Integer) c.Db().get(9, null);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_find_me_by_QQ");
        checkBoxPreference.ysp = false;
        if (num == null || num.intValue() == 0) {
            this.inW.c(checkBoxPreference);
        } else {
            z = (vj(8) && vj(16)) ? false : true;
            checkBoxPreference.tYU = z;
        }
        as.Hm();
        String str = (String) c.Db().get(6, null);
        checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_find_me_by_mobile");
        checkBoxPreference.ysp = false;
        if (str == null || str.length() <= 0) {
            this.inW.c(checkBoxPreference);
        } else {
            if (vj(WXMediaMessage.TITLE_LENGTH_LIMIT)) {
                z = false;
            } else {
                z = true;
            }
            checkBoxPreference.tYU = z;
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.inW.Zu("settings_find_me_by_weixin");
        checkBoxPreference2.ysp = false;
        if ((this.qoR & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            checkBoxPreference2.tYU = false;
        } else {
            checkBoxPreference2.tYU = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.inW.Zu("settings_find_me_by_google");
        if (vj(SQLiteGlobal.journalSizeLimit)) {
            z2 = false;
        } else {
            z2 = true;
        }
        checkBoxPreference2.tYU = z2;
        checkBoxPreference2.ysp = false;
        as.Hm();
        String str2 = (String) c.Db().get(208903, null);
        if (!bi.PZ() || TextUtils.isEmpty(str2)) {
            this.inW.c(checkBoxPreference2);
        }
        checkBoxPreference2 = (CheckBoxPreference) this.inW.Zu("settings_add_me_by_chatroom");
        checkBoxPreference2.ysp = false;
        if ((this.lrE & 1) != 0) {
            checkBoxPreference2.tYU = false;
        } else {
            checkBoxPreference2.tYU = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.inW.Zu("settings_add_me_by_qrcode");
        checkBoxPreference2.ysp = false;
        if ((this.lrE & 2) != 0) {
            checkBoxPreference2.tYU = false;
        } else {
            checkBoxPreference2.tYU = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.inW.Zu("settings_add_me_by_namecard");
        checkBoxPreference2.ysp = false;
        if ((this.lrE & 4) != 0) {
            checkBoxPreference2.tYU = false;
        } else {
            checkBoxPreference2.tYU = true;
        }
        this.inW.notifyDataSetChanged();
    }

    private boolean vj(int i) {
        return (this.status & i) != 0;
    }
}
