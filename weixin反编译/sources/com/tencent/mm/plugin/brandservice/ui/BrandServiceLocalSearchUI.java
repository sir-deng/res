package com.tencent.mm.plugin.brandservice.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import com.tencent.mm.R;
import com.tencent.mm.ay.k;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.as;

@a(3)
public class BrandServiceLocalSearchUI extends MMActivity implements BrandServiceSortView.a, p.a {
    private p kLM;
    private BrandServiceSortView kLN;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        as.CN().a(new k(18), 0);
    }

    public final void XC() {
    }

    public final void XD() {
    }

    protected final void initView() {
        this.kLN = (BrandServiceSortView) findViewById(R.h.cPc);
        this.kLN.crf();
        this.kLN.kLK = getIntent().getBooleanExtra("is_return_result", false);
        this.kLN.crg();
        this.kLN.mF(false);
        this.kLN.M(false);
        this.kLN.kMX = this;
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
        x.i("MicroMsg.BrandServiceLocalSearchUI", "search biz, key word : %s", str);
        this.kLN.Zy(str);
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

    protected void onDestroy() {
        super.onDestroy();
        this.kLN.release();
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
        return R.i.dbI;
    }

    public final boolean atb() {
        aWY();
        return false;
    }
}
