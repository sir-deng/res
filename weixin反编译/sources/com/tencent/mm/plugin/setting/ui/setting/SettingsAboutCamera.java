package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class SettingsAboutCamera extends MMPreference {
    private f inW;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final int XK() {
        return R.o.fcB;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean booleanValue;
        boolean z = true;
        String str = preference.idX;
        if (str.equals("settings_auto_mul_terminal_sync")) {
            as.Hm();
            booleanValue = ((Boolean) c.Db().get(a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.valueOf(true))).booleanValue();
            as.Hm();
            c.Db().a(a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.valueOf(!booleanValue));
        }
        if (str.equals("settings_take_photo_auto_save_photo")) {
            as.Hm();
            booleanValue = ((Boolean) c.Db().get(a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, Boolean.valueOf(true))).booleanValue();
            as.Hm();
            t Db = c.Db();
            a aVar = a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN;
            if (booleanValue) {
                booleanValue = false;
            } else {
                booleanValue = true;
            }
            Db.a(aVar, Boolean.valueOf(booleanValue));
        }
        if (str.equals("settings_take_photo_auto_save_video")) {
            as.Hm();
            booleanValue = ((Boolean) c.Db().get(a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, Boolean.valueOf(true))).booleanValue();
            as.Hm();
            t Db2 = c.Db();
            a aVar2 = a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN;
            if (booleanValue) {
                z = false;
            }
            Db2.a(aVar2, Boolean.valueOf(z));
        }
        return false;
    }

    protected final void initView() {
        this.inW = this.yrJ;
        setMMTitle(R.l.eMz);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsAboutCamera.this.aWY();
                SettingsAboutCamera.this.finish();
                return true;
            }
        });
        as.Hm();
        boolean booleanValue = ((Boolean) c.Db().get(a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.valueOf(true))).booleanValue();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_auto_mul_terminal_sync");
        checkBoxPreference.ysp = false;
        checkBoxPreference.tYU = booleanValue;
        as.Hm();
        booleanValue = ((Boolean) c.Db().get(a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, Boolean.valueOf(true))).booleanValue();
        checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_take_photo_auto_save_photo");
        checkBoxPreference.ysp = false;
        checkBoxPreference.tYU = booleanValue;
        as.Hm();
        checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_take_photo_auto_save_video");
        checkBoxPreference.tYU = ((Boolean) c.Db().get(a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, Boolean.valueOf(true))).booleanValue();
        checkBoxPreference.ysp = false;
        this.inW.notifyDataSetChanged();
    }
}
