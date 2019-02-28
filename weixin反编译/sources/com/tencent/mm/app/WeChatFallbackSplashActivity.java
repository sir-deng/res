package com.tencent.mm.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mm.splash.d.a;
import com.tencent.mm.splash.d.b;
import com.tencent.mm.splash.e;
import java.io.File;

public class WeChatFallbackSplashActivity extends Activity {
    private Runnable fgg = new Runnable() {
        private long fgh = -1;

        public final void run() {
            if (this.fgh == -1) {
                this.fgh = System.currentTimeMillis();
            }
            if (WeChatFallbackSplashActivity.ue()) {
                e.a("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone true", new Object[0]);
                WeChatFallbackSplashActivity.this.finish();
                WeChatFallbackSplashActivity.this.overridePendingTransition(a.bpQ, a.bqa);
            } else if (System.currentTimeMillis() - this.fgh >= 80000) {
                e.a("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone timeout", new Object[0]);
                WeChatFallbackSplashActivity.this.finish();
                WeChatFallbackSplashActivity.this.overridePendingTransition(a.bpQ, a.bqa);
            } else {
                WeChatFallbackSplashActivity.this.mHandler.postDelayed(WeChatFallbackSplashActivity.this.fgg, 100);
            }
        }
    };
    private Handler mHandler;

    static /* synthetic */ boolean ue() {
        String chU = com.tencent.mm.splash.a.chU();
        if (!new File(chU).exists()) {
            e.a("MicroMsg.FigLeaf", "dex opt dir not exists.", new Object[0]);
        } else if (new File(chU + "/main-process-blocking").exists()) {
            return false;
        }
        return true;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b.xtP);
        e.a("MicroMsg.FallbackSplash", "onCreate", new Object[0]);
        HandlerThread handlerThread = new HandlerThread("splash-activity");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mHandler.postDelayed(this.fgg, 100);
    }

    public void onBackPressed() {
        e.a("MicroMsg.FallbackSplash", "block onBackPressed", new Object[0]);
    }
}
