package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class MailAddrProfileUI extends MMPreference {
    private f inW;
    private String nWa;
    private String name;
    private boolean pyB;

    public final int XK() {
        return R.o.fcg;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.name = getIntent().getStringExtra("name");
        this.nWa = getIntent().getStringExtra("addr");
        this.pyB = getIntent().getBooleanExtra("can_compose", false);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.epU);
        this.inW = this.yrJ;
        ((KeyValuePreference) this.inW.Zu("mail_receiver_info_name")).setSummary(this.name);
        ((KeyValuePreference) this.inW.Zu("mail_receiver_info_addr")).setSummary(getIntent().getStringExtra("addr"));
        Preference Zu = this.inW.Zu("mail_compose_btn");
        if (!this.pyB) {
            this.inW.c(Zu);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MailAddrProfileUI.this.aWY();
                MailAddrProfileUI.this.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.idX.equals("mail_compose_btn")) {
            Intent intent = new Intent(this, ComposeUI.class);
            intent.putExtra("composeType", 4);
            intent.putExtra("toList", new String[]{this.name + " " + this.nWa});
            startActivity(intent);
            finish();
        }
        return false;
    }
}
