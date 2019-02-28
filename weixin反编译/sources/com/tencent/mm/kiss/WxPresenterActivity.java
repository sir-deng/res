package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.e.a;

public abstract class WxPresenterActivity extends MMActivity {
    protected c gUB = new c();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUB.B(getIntent(), this);
    }

    public void onResume() {
        super.onResume();
        this.gUB.HF(2);
    }

    public void onPause() {
        this.gUB.HF(3);
        super.onPause();
    }

    public void onDestroy() {
        this.gUB.onDestroy();
        super.onDestroy();
    }

    public void keep(a aVar) {
        this.gUB.keep(aVar);
    }

    public final <T extends b<? extends com.tencent.mm.vending.app.a>> T q(Class<? extends b<? extends com.tencent.mm.vending.app.a>> cls) {
        return this.gUB.a(this, cls);
    }

    public final com.tencent.mm.vending.app.a Ed() {
        return this.gUB.Ed();
    }
}
