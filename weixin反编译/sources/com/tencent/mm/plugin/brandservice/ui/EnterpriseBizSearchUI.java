package com.tencent.mm.plugin.brandservice.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.b;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class EnterpriseBizSearchUI extends MMActivity implements b, p.a {
    private p kLM;
    private EnterpriseBizContactListView kLR;
    private String kMt;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kLR != null) {
            EnterpriseBizContactListView.release();
        }
    }

    public final void XC() {
    }

    public final void XD() {
    }

    protected final void initView() {
        if (bi.oN(this.kMt)) {
            this.kMt = getIntent().getStringExtra("enterprise_biz_name");
            if (bi.oN(this.kMt)) {
                finish();
            }
        }
        this.kLR = (EnterpriseBizContactListView) findViewById(R.h.cPc);
        this.kLR.kLP = this.kMt;
        this.kLR.kLW = true;
        this.kLR.refresh();
        this.kLR.crf();
        this.kLR.atc();
        this.kLR.crg();
        this.kLR.mF(false);
        this.kLR.kLZ = this;
        ((TextView) this.kLR.ate()).setText(R.l.ecm);
        this.kLM = new p();
        this.kLM.nC(true);
        this.kLM.a(this);
        this.kLM.vFI = false;
    }

    public final void XB() {
    }

    public final void XA() {
        finish();
    }

    public final void pd(String str) {
        x.i("MicroMsg.EnterpriseBizSearchUI", "search biz, key word : %s", str);
        this.kLR.Zy(str);
    }

    public final boolean pc(String str) {
        aWY();
        return true;
    }

    public final void asZ() {
        aWY();
    }

    public final void ata() {
    }

    protected void onPause() {
        super.onPause();
        this.kLM.cancel();
        this.kLM.clearFocus();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.kLM.a((FragmentActivity) this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.kLM.a(this, menu);
        return true;
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    protected final int getLayoutId() {
        return R.i.dgx;
    }

    public final boolean atb() {
        aWY();
        return false;
    }
}
