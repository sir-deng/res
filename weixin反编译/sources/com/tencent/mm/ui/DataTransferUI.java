package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

@a(19)
public class DataTransferUI extends MMBaseActivity {
    private r jQQ;
    private long startTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.DataTransferUI", "onCreate, timestamp = " + System.currentTimeMillis());
        this.startTime = System.currentTimeMillis();
        getString(R.l.dGZ);
        this.jQQ = h.a((Context) this, getString(R.l.dEG), false, null);
        new ag() {
            public final void handleMessage(Message message) {
                if (DataTransferUI.this.jQQ != null && DataTransferUI.this.jQQ.isShowing()) {
                    x.e("MicroMsg.DataTransferUI", "dialog has shown for a long time, auto dismiss it...");
                    DataTransferUI.this.jQQ.dismiss();
                    DataTransferUI.this.finish();
                }
            }
        }.sendEmptyMessageDelayed(0, 60000);
        ai(getIntent());
    }

    protected void onNewIntent(Intent intent) {
        x.d("MicroMsg.DataTransferUI", "onNewIntent, timestamp = " + System.currentTimeMillis());
        ai(intent);
    }

    private void ai(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("finish_data_transfer", false);
        x.d("MicroMsg.DataTransferUI", "tryFinish, timestamp = " + System.currentTimeMillis() + ", finish = " + booleanExtra);
        if (booleanExtra) {
            finish();
        }
    }

    protected void onPause() {
        x.d("MicroMsg.DataTransferUI", "edw DataTransferUI duration time = " + (System.currentTimeMillis() - this.startTime));
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        x.d("MicroMsg.DataTransferUI", "onDestroy");
        if (this.jQQ != null && this.jQQ.isShowing()) {
            this.jQQ.dismiss();
        }
    }
}
