package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public abstract class GameBaseActivity extends MMActivity {
    private long mStartTime = 0;
    private int nro = 1;
    private long nrp = 0;
    private long nrq = 0;

    public abstract int aRY();

    public abstract int aRZ();

    public abstract int aSa();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        if (this.mStartTime == 0) {
            this.mStartTime = System.currentTimeMillis();
        }
        this.nrq = System.currentTimeMillis();
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.nrp += System.currentTimeMillis() - this.nrq;
    }

    public void onDestroy() {
        if (this.mStartTime != 0) {
            x.i("MicroMsg.GameBaseActivity", "visit page(%s), stayTime:%sms, foregroundTime:%sms", getClass().getSimpleName(), Long.valueOf(System.currentTimeMillis() - this.mStartTime), Long.valueOf(this.nrp));
            if (aRX()) {
                ap.a(this.nro, aRY(), aRZ(), (long) aSa(), "", null, "", r8 / 1000, this.nrp / 1000, null);
            }
        }
        super.onDestroy();
    }

    public boolean aRX() {
        return true;
    }
}
