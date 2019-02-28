package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiErrorUI extends MMActivity {
    private ImageView mMQ;
    private TextView mMR;
    private TextView mMS;
    private TextView mMT;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ekp);
        this.mMQ = (ImageView) findViewById(R.h.cjz);
        if (getIntent().getIntExtra("free_wifi_show_detail_error", 0) == 1) {
            this.mMQ.setImageResource(R.g.bCj);
        }
        this.mMR = (TextView) findViewById(R.h.cjy);
        this.mMS = (TextView) findViewById(R.h.cjw);
        this.mMT = (TextView) findViewById(R.h.cjx);
        CharSequence stringExtra = getIntent().getStringExtra("free_wifi_error_ui_error_msg");
        CharSequence stringExtra2 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail1");
        CharSequence stringExtra3 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail12");
        if (!m.Bf(stringExtra)) {
            this.mMR.setText(stringExtra);
        }
        if (!m.Bf(stringExtra2)) {
            this.mMS.setText(stringExtra2);
        }
        if (!m.Bf(stringExtra3)) {
            this.mMT.setText(stringExtra3);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FreeWifiErrorUI.this.finish();
                return true;
            }
        });
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.cjz;
    }
}
