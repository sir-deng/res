package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.chatting.c.b.a;
import com.tencent.mm.ui.chatting.c.b.b;
import com.tencent.mm.ui.chatting.e.c;
import com.tencent.mm.y.s;

public class AppBrandHistoryListUI extends MMActivity implements b {
    private RecyclerView Va;
    private String jXh;
    private TextView liY;
    private ProgressDialog nFW;
    private a yLE;

    public final /* bridge */ /* synthetic */ void a(c cVar) {
        this.yLE = (a) cVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jXh = getIntent().getStringExtra("Chat_User");
        new com.tencent.mm.ui.chatting.e.a(this).a(this);
        initView();
        this.yLE.cvf();
        if (s.eX(this.jXh)) {
            g.pWK.h(14562, this.jXh, Integer.valueOf(0));
            return;
        }
        g.pWK.h(14562, this.jXh, Integer.valueOf(1));
    }

    protected final void initView() {
        setMMTitle(getString(R.l.dQe));
        this.liY = (TextView) findViewById(R.h.cJY);
        this.Va = (RecyclerView) findViewById(R.h.coG);
        this.Va.setBackgroundColor(-1);
        this.Va.a(this.yLE.fN(this));
        this.Va.a(this.yLE.ZT(this.jXh));
        this.Va.Ub = true;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppBrandHistoryListUI.this.finish();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.daD;
    }

    public final void cvj() {
        ec(true);
    }

    public final void z(boolean z, int i) {
        ec(false);
        x.i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i));
        if (i <= 0) {
            this.liY.setVisibility(0);
            this.Va.setVisibility(8);
            this.liY.setText(getString(R.l.dSP));
            return;
        }
        this.liY.setVisibility(8);
        this.Va.setVisibility(0);
        this.Va.fn().UR.notifyChanged();
    }

    public final void onFinish() {
        x.i("MicroMsg.AppBrandHistoryListUI", "[onRefreshed]");
        finish();
    }

    public final void bo(String str, boolean z) {
    }

    private void ec(boolean z) {
        x.i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.nFW = r.b(this, getString(R.l.ctG), true, 0, null);
        } else if (this.nFW != null && this.nFW.isShowing()) {
            this.nFW.dismiss();
            this.nFW = null;
        }
    }
}
