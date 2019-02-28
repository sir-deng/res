package com.tencent.mm.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.splash.d.a;
import java.util.Iterator;

public class SplashActivity extends Activity {
    private boolean xuj = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e.a(this);
        e.a("WxSplash.SplashActivity", "onCreate", new Object[0]);
        if (!e.cid()) {
            e.a("WxSplash.SplashActivity", "no need splash, finish", new Object[0]);
            cip();
        }
        if (e.xua != null) {
            e.xua.c(this);
        }
    }

    protected void onResume() {
        super.onResume();
        e.a("WxSplash.SplashActivity", "onResume", new Object[0]);
    }

    protected void onPause() {
        e.a("WxSplash.SplashActivity", "onPause", new Object[0]);
        s.bYS();
        super.onPause();
    }

    protected void onDestroy() {
        e.b(this);
        e.a("WxSplash.SplashActivity", "onDestroy", new Object[0]);
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (e.xtT != null) {
            e.xtT.a(this, i, strArr, iArr);
        }
    }

    private void cio() {
        if (e.xtT.b(this, new Runnable() {
            public final void run() {
                SplashActivity.this.cio();
            }
        })) {
            ciq();
        }
    }

    public final void cip() {
        if (e.xtT == null) {
            e.a("WxSplash.SplashActivity", "permissions delegate is null, call splash finish directly.", new Object[0]);
            ciq();
        } else if (!e.xtT.a(this, new Runnable() {
            public final void run() {
                SplashActivity.this.cio();
            }
        })) {
            cio();
        }
    }

    private void ciq() {
        if (!this.xuj) {
            this.xuj = true;
            e.xtT = null;
            if (isFinishing()) {
                onBackPressed();
                return;
            }
            setResult(-100);
            int intExtra = getIntent().getIntExtra("hashcode", 0);
            Iterator it = e.xtQ.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (intExtra == fVar.hashCode()) {
                    fVar.recreate();
                    e.a("WxSplash.SplashActivity", "do recreate", new Object[0]);
                    break;
                }
            }
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    SplashActivity.this.finish();
                    SplashActivity.this.overridePendingTransition(a.bpQ, a.xtO);
                }
            }, 50);
        }
    }
}
