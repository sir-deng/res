package com.tencent.mm.vending.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.vending.e.b;

public abstract class PresenterActivity extends Activity implements b {
    private c gUB = new c();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUB.B(getIntent(), this);
    }

    protected void onResume() {
        super.onResume();
        this.gUB.HF(2);
    }

    protected void onPause() {
        this.gUB.HF(3);
        super.onPause();
    }

    protected void onDestroy() {
        this.gUB.onDestroy();
        super.onDestroy();
    }
}
