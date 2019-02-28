package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountUI extends MMActivity {
    protected final int getLayoutId() {
        return R.i.dsd;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eKx);
        initView();
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingDeleteAccountUI.this.aWY();
                SettingDeleteAccountUI.this.finish();
                return true;
            }
        });
        ((TextView) findViewById(R.h.caO)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
    }
}
