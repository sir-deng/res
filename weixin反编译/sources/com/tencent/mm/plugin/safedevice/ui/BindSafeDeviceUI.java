package com.tencent.mm.plugin.safedevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.safedevice.a;
import com.tencent.mm.ui.MMWizardActivity;

public class BindSafeDeviceUI extends MMWizardActivity {
    protected final int getLayoutId() {
        return R.i.drH;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.eGN);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BindSafeDeviceUI.this.finish();
                return true;
            }
        });
        ((ImageView) findViewById(R.h.cKz)).setImageResource(R.k.duY);
        ((TextView) findViewById(R.h.cKA)).setText(R.l.eGT);
        ((TextView) findViewById(R.h.cSb)).setText(R.l.eGU);
        findViewById(R.h.cSb).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("is_bind_for_safe_device", true);
                a.ihN.b(BindSafeDeviceUI.this, intent);
            }
        });
    }
}
