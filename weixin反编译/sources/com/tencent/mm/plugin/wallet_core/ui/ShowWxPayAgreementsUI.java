package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;

@a(3)
public class ShowWxPayAgreementsUI extends MMActivity {
    private String content;
    private MMWebView sXn;
    private TextView sXo;
    private TextView sXp;
    private int type;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        g.pWK.h(15236, Integer.valueOf(1));
        getSupportActionBar().hide();
        overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.bqo, com.tencent.mm.plugin.wxpay.a.a.bpQ);
        this.type = getIntent().getIntExtra("agreement_type", 0);
        this.sXn = MMWebView.a.a(this, this.mController.contentView, f.bJM);
        this.sXn.getSettings().setJavaScriptEnabled(true);
        this.sXo = (TextView) findViewById(f.bJL);
        this.sXp = (TextView) findViewById(f.bJI);
        this.content = getIntent().getStringExtra("agreement_content");
        this.sXp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.pWK.h(15236, Integer.valueOf(2));
                ShowWxPayAgreementsUI.this.setResult(-1);
                ShowWxPayAgreementsUI.this.finish();
            }
        });
        this.sXo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.pWK.h(15236, Integer.valueOf(3));
                ShowWxPayAgreementsUI.this.finish();
            }
        });
        this.sXn.setWebViewClient(new e(this));
        this.sXn.loadData(this.content, "text/html; charset=UTF-8", null);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uKJ;
    }

    public void finish() {
        x.i("MicroMsg.ShowWxPayAgreementsUI", "onRefreshed");
        super.finish();
        overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.bpQ, com.tencent.mm.plugin.wxpay.a.a.bqm);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
