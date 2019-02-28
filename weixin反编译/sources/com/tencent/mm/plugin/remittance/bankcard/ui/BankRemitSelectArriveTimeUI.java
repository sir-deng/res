package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class BankRemitSelectArriveTimeUI extends MMPreference {
    private f inW;
    private List<EnterTimeParcel> pPl;
    private List<Preference> pPm;
    private int pPn;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.uhd)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(a.f.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(c.black));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(c.black));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(c.uhd));
        }
        BankRemitBaseUI.H(this);
        this.mController.contentView.setFitsSystemWindows(true);
        setMMTitle(i.uOt);
        this.pPl = getIntent().getParcelableArrayListExtra("key_arrive_time_parcel_list");
        this.pPn = getIntent().getIntExtra("key_select_arrive_time", -1);
        initView();
        findViewById(16908298).setBackgroundColor(getResources().getColor(c.uhd));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BankRemitSelectArriveTimeUI.this.finish();
                return false;
            }
        }, h.dvZ);
    }

    protected final void initView() {
        this.inW = this.yrJ;
        if (this.pPl != null && this.pPl.size() > 0) {
            this.pPm = new ArrayList();
            for (int i = 0; i < this.pPl.size(); i++) {
                EnterTimeParcel enterTimeParcel = (EnterTimeParcel) this.pPl.get(i);
                x.d("MicroMsg.BankRemitSelectArriveTimeUI", "enter scene: %d", Integer.valueOf(enterTimeParcel.pNg));
                Preference preference = new Preference(this);
                preference.setLayoutResource(g.uHG);
                preference.ysp = false;
                preference.setKey(enterTimeParcel.pNg);
                preference.setTitle(enterTimeParcel.pNh);
                if (enterTimeParcel.pNg == this.pPn) {
                    preference.setWidgetLayoutResource(g.dof);
                } else {
                    preference.setWidgetLayoutResource(g.dog);
                }
                if (enterTimeParcel.pNj == 0) {
                    if (!bi.oN(enterTimeParcel.pNi)) {
                        preference.setSummary(enterTimeParcel.pNi);
                    }
                    preference.setEnabled(false);
                }
                preference.getExtras().putParcelable("arrive_time", enterTimeParcel);
                this.inW.a(preference);
                this.pPm.add(preference);
            }
        }
    }

    public final int XK() {
        return g.uHH;
    }

    public final boolean a(f fVar, Preference preference) {
        for (Preference preference2 : this.pPm) {
            if (preference2 == preference) {
                preference2.setWidgetLayoutResource(g.dof);
            } else {
                preference2.setWidgetLayoutResource(g.dog);
            }
        }
        this.inW.notifyDataSetChanged();
        EnterTimeParcel enterTimeParcel = (EnterTimeParcel) preference.getExtras().getParcelable("arrive_time");
        if (enterTimeParcel == null) {
            x.i("MicroMsg.BankRemitSelectArriveTimeUI", "is header");
        } else {
            Intent intent = new Intent();
            intent.putExtra("key_enter_time_scene", enterTimeParcel.pNg);
            setResult(-1, intent);
            finish();
        }
        return false;
    }
}
