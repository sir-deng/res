package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;

public class WalletSelectProfessionUI extends MMPreference {
    private f inW;
    private Profession[] sOW = null;

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        setMMTitle(i.vdh);
        this.inW = this.yrJ;
        Preference preferenceTitleCategory = new PreferenceTitleCategory(this.mController.xRr);
        preferenceTitleCategory.setTitle(getString(i.vdg));
        preferenceTitleCategory.setKey("title_category");
        this.inW.a(preferenceTitleCategory);
        Parcelable[] parcelableArrayExtra = getIntent().getParcelableArrayExtra("key_profession_list");
        if (parcelableArrayExtra != null && parcelableArrayExtra.length > 0) {
            this.sOW = new Profession[parcelableArrayExtra.length];
            for (int i2 = 0; i2 < this.sOW.length; i2++) {
                this.sOW[i2] = (Profession) parcelableArrayExtra[i2];
            }
        }
        if (this.sOW != null) {
            Profession[] professionArr = this.sOW;
            int length = professionArr.length;
            int i3 = 0;
            while (i < length) {
                Profession profession = professionArr[i];
                if (!(profession == null || bi.oN(profession.sQn))) {
                    Preference preference = new Preference(this.mController.xRr);
                    preference.setTitle(profession.sQn);
                    preference.setKey("index_" + i3);
                    this.inW.a(preference);
                }
                i3++;
                i++;
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletSelectProfessionUI.this.setResult(0);
                WalletSelectProfessionUI.this.finish();
                return true;
            }
        });
    }

    public final int XK() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.idX.startsWith("index_")) {
            String[] split = preference.idX.split("_");
            if (split.length == 2) {
                Parcelable parcelable = this.sOW[bi.getInt(split[1], 0)];
                Intent intent = new Intent();
                intent.putExtra("key_select_profession", parcelable);
                setResult(-1, intent);
            } else {
                x.w("MicroMsg.WalletSelectProfessionUI", "error key: %s, %s", preference.idX, preference.getTitle());
                setResult(0);
            }
            finish();
        }
        return true;
    }
}
