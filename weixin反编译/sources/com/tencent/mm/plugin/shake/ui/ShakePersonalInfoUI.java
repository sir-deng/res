package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.j.g;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.shake.a;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class ShakePersonalInfoUI extends MMPreference {
    private f inW;

    public final int XK() {
        return R.o.fcN;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        a.ihO.un();
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eOM);
        this.inW = this.yrJ;
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("shake_item_sound");
        as.Hm();
        if (c.Db().get(4112, null) == null) {
            as.Hm();
            c.Db().set(4112, Boolean.valueOf(true));
        }
        as.Hm();
        checkBoxPreference.tYU = bi.b((Boolean) c.Db().get(4112, null));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShakePersonalInfoUI.this.finish();
                return true;
            }
        });
        if (!com.tencent.mm.au.c.QE()) {
            this.inW.Zv("shake_item_shake_music_list");
        }
    }

    public void onResume() {
        boolean z = false;
        super.onResume();
        if (as.Hp()) {
            a.ihO.un();
        }
        if (this.inW.Zu("shake_item_shake_tv_list") == null) {
            x.e("MicroMsg.mmui.MMPreference", "shake_tv_list preference is null");
            return;
        }
        if (bi.getInt(g.Ag().F("ShowConfig", "showShakeTV"), 0) == 1) {
            z = true;
        }
        x.d("MicroMsg.ConfigListDecoder", "isShowShakeTV : " + z);
        if (!z && !r.ifE) {
            this.inW.bl("shake_item_shake_tv_list", true);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        String str = preference.idX;
        if ("shake_item_default_bgimg".equals(str)) {
            as.Hm();
            c.Db().set(4110, Boolean.valueOf(true));
            h.bu(this, getResources().getString(R.l.ePj));
        }
        if ("shake_item_change_bgimg".equals(str)) {
            k.a((Activity) this, 1, null);
        }
        if ("shake_item_sound".equals(str)) {
            as.Hm();
            boolean b = bi.b((Boolean) c.Db().get(4112, null));
            as.Hm();
            c.Db().set(4112, Boolean.valueOf(!b));
        }
        if ("say_hi_list_shake_title".equals(str)) {
            intent = new Intent(this, ShakeSayHiListUI.class);
            intent.putExtra("IntentSayHiType", 1);
            startActivity(intent);
        }
        if ("shake_item_histoty_list".equals(str)) {
            intent = new Intent(this, ShakeItemListUI.class);
            intent.putExtra("_key_show_type_", 100);
            intent.putExtra("_key_title_", getString(R.l.eOL));
            startActivity(intent);
        }
        if ("shake_msg_list".equals(str)) {
            intent = new Intent(this, ShakeMsgListUI.class);
            intent.putExtra("shake_msg_from", 2);
            intent.putExtra("shake_msg_list_title", getString(R.l.ePq));
            startActivity(intent);
        }
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (intent != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 4);
                    intent2.putExtra("CropImage_Filter", true);
                    intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                    StringBuilder stringBuilder = new StringBuilder();
                    as.Hm();
                    intent2.putExtra("CropImage_OutputPath", stringBuilder.append(c.Fp()).append("custom_shake_img_filename.jpg").toString());
                    a.ihN.a(intent2, 2, this, intent);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    as.Hm();
                    c.Db().set(4110, Boolean.valueOf(false));
                    as.Hm();
                    c.Db().set(4111, stringExtra);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
