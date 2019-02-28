package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountAgreementUI extends MMActivity {
    protected final int getLayoutId() {
        return R.i.dse;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eKx);
        initView();
    }

    protected final void initView() {
        final TextView textView = (TextView) findViewById(R.h.cAl);
        textView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SettingDeleteAccountAgreementUI.this.startActivity(new Intent(SettingDeleteAccountAgreementUI.this, SettingDeleteAccountInputPassUI.class));
            }
        });
        final CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.h.bJJ);
        checkedTextView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                textView.setEnabled(checkedTextView.isChecked());
            }
        });
        textView.setEnabled(checkedTextView.isChecked());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingDeleteAccountAgreementUI.this.aWY();
                SettingDeleteAccountAgreementUI.this.finish();
                return true;
            }
        });
    }
}
