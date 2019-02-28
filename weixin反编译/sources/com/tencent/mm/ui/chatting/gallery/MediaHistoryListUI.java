package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.chatting.c.b.a;
import com.tencent.mm.ui.chatting.c.b.b;
import com.tencent.mm.ui.chatting.e.d;
import com.tencent.mm.ui.chatting.e.f;
import com.tencent.mm.ui.chatting.e.g;
import com.tencent.mm.ui.chatting.e.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;

public class MediaHistoryListUI extends MMActivity implements b {
    private RecyclerView Va;
    private String jXh;
    private TextView liY;
    private ProgressDialog nFW;
    private a yLE;
    private p yPG;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jXh = getIntent().getStringExtra("kintent_talker");
        a aVar = null;
        switch (getIntent().getIntExtra("key_media_type", -1)) {
            case 2:
                aVar = new d(this);
                break;
            case 3:
                aVar = new h(this);
                break;
            case 4:
                aVar = new f(this);
                break;
            case 5:
                aVar = new g(this);
                break;
        }
        if (aVar == null) {
            x.e("MicroMsg.MediaHistoryListUI", "[onCreate] presenter is null!");
            return;
        }
        aVar.a(this);
        initView();
        this.yLE.cvf();
        boolean eX = s.eX(this.jXh);
        as.Hm();
        q hH = c.Fo().hH(this.jXh);
        if (eX) {
            if (this.yLE.getType() == 6) {
                com.tencent.mm.plugin.report.service.g.pWK.h(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(hH.My().size()), Integer.valueOf(1));
            } else if (this.yLE.getType() == -1) {
                com.tencent.mm.plugin.report.service.g.pWK.h(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(hH.My().size()), Integer.valueOf(1));
            } else if (this.yLE.getType() == 3) {
                com.tencent.mm.plugin.report.service.g.pWK.h(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(hH.My().size()), Integer.valueOf(1));
            } else if (this.yLE.getType() == 5) {
                com.tencent.mm.plugin.report.service.g.pWK.h(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(hH.My().size()), Integer.valueOf(1), Integer.valueOf(1));
            }
        } else if (this.yLE.getType() == 6) {
            com.tencent.mm.plugin.report.service.g.pWK.h(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        } else if (this.yLE.getType() == -1) {
            com.tencent.mm.plugin.report.service.g.pWK.h(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        } else if (this.yLE.getType() == 3) {
            com.tencent.mm.plugin.report.service.g.pWK.h(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
        } else if (this.yLE.getType() == 5) {
            com.tencent.mm.plugin.report.service.g.pWK.h(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        }
    }

    protected final void initView() {
        this.yPG = new p();
        this.yPG.nC(false);
        this.yPG.a(this.yLE.cvh());
        this.yPG.vFI = false;
        this.liY = (TextView) findViewById(R.h.cJY);
        this.Va = (RecyclerView) findViewById(R.h.coG);
        findViewById(R.h.bYO).setBackgroundColor(-1);
        this.Va.setBackgroundColor(-1);
        this.Va.a(this.yLE.fN(this));
        this.Va.a(this.yLE.cve());
        this.Va.a(this.yLE.ZT(this.jXh));
        this.Va.Ub = true;
        setMMTitle(this.yLE.Xf());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MediaHistoryListUI.this.finish();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        this.yLE.onDetach();
    }

    public final void onKeyboardStateChanged() {
        super.onKeyboardStateChanged();
        if (this.mController.xRL == 2) {
            this.yPG.clearFocus();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.yPG.a((FragmentActivity) this, menu);
        com.tencent.mm.ui.tools.p pVar = this.yPG;
        String cvi = this.yLE.cvi();
        if (!(pVar.zvv == null || bi.oN(cvi))) {
            pVar.zvv.aaz(cvi);
        }
        this.mController.contentView.postDelayed(new Runnable() {
            public final void run() {
                MediaHistoryListUI.this.yPG.clearFocus();
            }
        }, 200);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.yPG.a(this, menu);
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    protected final int getLayoutId() {
        return R.i.dno;
    }

    public final void cvj() {
        ec(true);
    }

    public final void z(boolean z, int i) {
        ec(false);
        x.i("MicroMsg.MediaHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i));
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
        x.i("MicroMsg.MediaHistoryListUI", "[onRefreshed]");
        finish();
    }

    public final void bo(String str, boolean z) {
        if (z) {
            CharSequence string = getString(R.l.dSR, new Object[]{str});
            this.liY.setVisibility(0);
            this.Va.setVisibility(8);
            TextView textView = this.liY;
            this.liY.getContext();
            textView.setText(com.tencent.mm.bb.b.a(string, str));
            return;
        }
        this.liY.setVisibility(8);
        this.Va.setVisibility(0);
    }

    private void ec(boolean z) {
        x.i("MicroMsg.MediaHistoryListUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.nFW = r.b(this, getString(R.l.ctG), true, 0, null);
        } else if (this.nFW != null && this.nFW.isShowing()) {
            this.nFW.dismiss();
            this.nFW = null;
        }
    }
}
