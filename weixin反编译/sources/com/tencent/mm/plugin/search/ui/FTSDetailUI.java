package com.tencent.mm.plugin.search.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.search.a.c;
import com.tencent.mm.sdk.platformtools.x;

public class FTSDetailUI extends FTSBaseUI {
    private int mUl;
    private int mVj;
    private g qiv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.bqz().aOa();
        String stringExtra = getIntent().getStringExtra("detail_query");
        this.fEe = stringExtra;
        this.qhY.znx.t(stringExtra, null);
        x.i("MicroMsg.FTS.FTSDetailUI", "onCreate query=%s, searchType=%d, kvScene=%d", this.fEe, Integer.valueOf(this.mVj), Integer.valueOf(this.mUl));
        bqE();
    }

    protected final void bqH() {
        this.mVj = getIntent().getIntExtra("detail_type", 0);
        this.mUl = getIntent().getIntExtra("Search_Scene", 0);
    }

    protected final b a(c cVar) {
        if (this.qiv == null) {
            this.qiv = new g(cVar, this.mVj, this.mUl);
        }
        return this.qiv;
    }

    public final void a(b bVar) {
    }

    protected final int getLayoutId() {
        return R.i.diZ;
    }

    protected void onDestroy() {
        this.qiv.finish();
        c.bqz().aNX();
        super.onDestroy();
    }

    public final String getHint() {
        String qy = e.qy(this.mVj);
        if (qy == null) {
            return getString(R.l.dGK);
        }
        return qy;
    }
}
