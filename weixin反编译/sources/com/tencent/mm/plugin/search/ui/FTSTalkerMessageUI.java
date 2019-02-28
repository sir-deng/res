package com.tencent.mm.plugin.search.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.ui.fts.widget.a.b;
import java.util.ArrayList;
import java.util.List;

public class FTSTalkerMessageUI extends FTSBaseUI {
    private String fEe;
    private String mRE;
    private int mUl;
    private j qjl;

    private class a implements b {
        private String gDt;

        private a() {
        }

        /* synthetic */ a(FTSTalkerMessageUI fTSTalkerMessageUI, byte b) {
            this();
        }

        public final String getTagName() {
            return this.gDt;
        }

        public final int compareTo(Object obj) {
            return 0;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.aOe().aOa();
        a aVar = new a();
        aVar.gDt = this.mRE;
        List arrayList = new ArrayList();
        arrayList.add(aVar);
        l(this.fEe, arrayList);
        bqE();
    }

    protected final void bqH() {
        super.bqH();
        this.mRE = getIntent().getStringExtra("key_talker_query");
        this.fEe = getIntent().getStringExtra("key_query");
        this.mUl = getIntent().getIntExtra("Search_Scene", 0);
        x.i("MicroMsg.FTS.FTSTalkerMessageUI", "initSearchData query=%s talkerQuery=%s", this.fEe, this.mRE);
    }

    protected final b a(c cVar) {
        if (this.qjl == null) {
            this.qjl = new j(this, this.mRE, this.mUl);
        }
        return this.qjl;
    }

    protected final int getLayoutId() {
        return R.i.djp;
    }

    protected void onDestroy() {
        this.qjl.finish();
        h.aOe().aNY();
        super.onDestroy();
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        super.a(str2, str2, list, bVar);
    }
}
