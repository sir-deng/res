package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.search.ui.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import java.util.List;

public abstract class FTSBaseUI extends MMActivity implements a, c, FTSEditTextView.a, com.tencent.mm.ui.fts.widget.a.a {
    String fEe;
    private TextView nBh;
    ListView qhV;
    private b qhW;
    private boolean qhX = false;
    com.tencent.mm.ui.fts.widget.a qhY;
    private ag qhu = new ag() {
        public final void handleMessage(Message message) {
            if (message.what == 1 && !bi.oN(FTSBaseUI.this.fEe)) {
                FTSBaseUI.this.bqE();
            }
        }
    };

    protected abstract b a(c cVar);

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.mController.xRr;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cnK();
        setMMTitle("");
        bqH();
        this.qhY = new com.tencent.mm.ui.fts.widget.a(this);
        this.qhY.zny = this;
        this.qhY.znx.MB(getHint());
        this.qhY.znx.znb = this;
        this.qhY.znx.zmY = false;
        getSupportActionBar().setCustomView(this.qhY);
        this.qhV = (ListView) findViewById(R.h.cKh);
        this.qhW = a((c) this);
        this.qhW.qhU = this;
        this.qhV.setAdapter(this.qhW);
        this.qhV.setOnScrollListener(this.qhW);
        this.qhV.setOnItemClickListener(this.qhW);
        this.qhV.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                FTSBaseUI.this.qhY.znx.yqL.clearFocus();
                FTSBaseUI.this.aWY();
                return false;
            }
        });
        this.nBh = (TextView) findViewById(R.h.cAD);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FTSBaseUI.this.finish();
                return true;
            }
        });
    }

    protected void bqH() {
    }

    public String getHint() {
        return getString(R.l.dGK);
    }

    public void a(b bVar) {
    }

    public final void bqI() {
        finish();
    }

    public final void bqJ() {
    }

    protected final void l(String str, List<com.tencent.mm.ui.fts.widget.a.b> list) {
        this.fEe = str;
        this.qhY.znx.t(str, list);
    }

    public void a(String str, String str2, List<com.tencent.mm.ui.fts.widget.a.b> list, FTSEditTextView.b bVar) {
        if (bVar == FTSEditTextView.b.UserInput) {
            String BJ = d.BJ(str);
            if (bi.oN(this.fEe) || !this.fEe.equals(BJ)) {
                Jz(BJ);
                return;
            }
            x.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", this.fEe, BJ);
        }
    }

    protected void Jz(String str) {
        if (bi.oN(str)) {
            stopSearch();
            return;
        }
        this.fEe = str;
        this.qhu.removeMessages(1);
        this.qhu.sendEmptyMessageDelayed(1, 300);
    }

    protected void stopSearch() {
        this.fEe = "";
        this.qhu.removeMessages(1);
        this.qhX = false;
        this.qhW.stopSearch();
        this.qhY.znx.MB(getHint());
        bqN();
    }

    public final void hQ(boolean z) {
    }

    public void cs(View view) {
        stopSearch();
        this.qhY.znx.cxS();
        showVKB();
    }

    public boolean als() {
        aWY();
        this.qhY.znx.yqL.clearFocus();
        return false;
    }

    protected void onDestroy() {
        this.qhu.removeMessages(1);
        this.qhW.finish();
        super.onDestroy();
    }

    protected void bqE() {
        this.qhX = true;
        this.qhW.Jy(this.fEe);
        bqK();
    }

    protected void bqK() {
        this.nBh.setVisibility(8);
        this.qhV.setVisibility(8);
    }

    protected void bqL() {
        this.nBh.setVisibility(0);
        this.nBh.setText(f.a(getString(R.l.eIR), getString(R.l.eIQ), com.tencent.mm.plugin.fts.d.b.a.d(this.fEe, this.fEe)).mVW);
        this.qhV.setVisibility(8);
    }

    protected void bqM() {
        this.nBh.setVisibility(8);
        this.qhV.setVisibility(0);
    }

    protected void bqN() {
        this.nBh.setVisibility(8);
        this.qhV.setVisibility(8);
    }

    public final void I(int i, boolean z) {
        x.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", Integer.valueOf(i), Boolean.valueOf(z));
        if (z) {
            if (i > 0) {
                bqM();
            } else {
                bqL();
            }
        } else if (i > 0) {
            bqM();
        } else {
            bqK();
        }
        if (this.qhX) {
            this.qhX = false;
            this.qhV.setSelection(0);
        }
    }
}
