package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMWebView;

@a(3)
public class ShowAgreementsUI extends MMActivity {
    private String countryCode;
    private TextView kso;
    private MMWebView sXn;
    private TextView sXo;
    private TextView sXp;
    private int type;
    private String ybj;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        getSupportActionBar().hide();
        overridePendingTransition(R.a.bqo, R.a.bpQ);
        this.type = getIntent().getIntExtra("agreement_type", 0);
        this.countryCode = getIntent().getStringExtra("country_code");
        this.kso = (TextView) findViewById(R.h.bJK);
        this.sXn = MMWebView.a.a(this, this.mController.contentView, R.h.bJM);
        this.sXn.getSettings().setJavaScriptEnabled(true);
        this.sXo = (TextView) findViewById(R.h.bJL);
        this.sXp = (TextView) findViewById(R.h.bJI);
        this.ybj = getIntent().getStringExtra("disagree_tip");
        if (bi.oN(this.ybj)) {
            this.ybj = getString(R.l.eta);
        }
        if (this.type == 0) {
            this.kso.setVisibility(0);
            this.kso.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    g.pWK.a(712, 1, 1, false);
                    ShowAgreementsUI.this.finish();
                }
            });
            this.sXp.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    g.pWK.a(712, 2, 1, false);
                    ShowAgreementsUI.this.setResult(-1);
                    ShowAgreementsUI.this.finish();
                }
            });
            this.sXo.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    g.pWK.a(712, 1, 1, false);
                    ShowAgreementsUI.this.finish();
                }
            });
            g.pWK.a(712, 0, 1, false);
        } else if (this.type == 1) {
            this.sXp.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    g.pWK.a(712, 5, 1, false);
                    ShowAgreementsUI.this.setResult(102001);
                    ShowAgreementsUI.this.finish();
                }
            });
            this.sXo.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    h.a(ShowAgreementsUI.this, ShowAgreementsUI.this.ybj, "", ShowAgreementsUI.this.getString(R.l.etc), ShowAgreementsUI.this.getString(R.l.dDX), false, null, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            g.pWK.a(712, 4, 1, true);
                            ShowAgreementsUI.this.setResult(102002);
                            ShowAgreementsUI.this.finish();
                        }
                    });
                }
            });
            g.pWK.a(712, 3, 1, false);
        }
        if (bi.oN(this.countryCode)) {
            this.countryCode = w.cfU();
        }
        if (this.countryCode.equals("CN")) {
            this.sXn.loadUrl(getString(R.l.ete, new Object[]{w.cfV(), this.countryCode}));
            return;
        }
        this.sXn.loadUrl(getString(R.l.etd));
    }

    protected final int getLayoutId() {
        return R.i.dsL;
    }

    public void finish() {
        x.i("MicroMsg.ShowAgreementsUI", "onRefreshed");
        super.finish();
        overridePendingTransition(R.a.bpQ, R.a.bqm);
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
