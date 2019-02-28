package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.ah;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;
import com.tencent.mm.y.be.a;
import com.tencent.mm.y.q;

public class JSAPIUploadLogHelperUI extends MMBaseActivity {
    private static volatile boolean mIsRunning = false;
    private static byte[] xPm = new byte[0];

    protected void onCreate(Bundle bundle) {
        boolean z;
        x.i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", Boolean.valueOf(mIsRunning));
        super.onCreate(bundle);
        setContentView(R.i.daS);
        synchronized (xPm) {
            if (mIsRunning) {
                x.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
                finish();
            }
        }
        final String stringExtra = getIntent().getStringExtra("key_user");
        final int intExtra = getIntent().getIntExtra("key_time", 0);
        String str = "MicroMsg.JSAPIUploadLogHelperUI";
        String str2 = "upload log from jsapi, in upload activity, username-recv-well:%b, time:%d";
        Object[] objArr = new Object[2];
        if (stringExtra == null || !stringExtra.equals(q.FY())) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(intExtra);
        x.i(str, str2, objArr);
        if (stringExtra == null) {
            x.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: userName is null.");
            finish();
        } else if (intExtra < 0) {
            x.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: illegal time value: %d", Integer.valueOf(intExtra));
            finish();
        } else {
            getString(R.l.dGZ);
            final ProgressDialog a = h.a((Context) this, getString(R.l.eYV), false, null);
            as.CN().a(new be(new a() {
                public final void a(e eVar) {
                    synchronized (JSAPIUploadLogHelperUI.xPm) {
                        JSAPIUploadLogHelperUI.mIsRunning = true;
                    }
                    as.CN().a(1, "", 0, false);
                    x.cfX();
                    as.CN().a(2, stringExtra, intExtra, as.Hp());
                }
            }), 0);
            final OnDismissListener anonymousClass2 = new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    if (!JSAPIUploadLogHelperUI.this.isFinishing()) {
                        JSAPIUploadLogHelperUI.this.finish();
                    }
                }
            };
            as.a(new ah() {
                public final void fX(int i) {
                    i h;
                    if (i < 0) {
                        x.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", Integer.valueOf(i));
                        as.a(null);
                        if (a != null) {
                            a.dismiss();
                        }
                        h = h.h(JSAPIUploadLogHelperUI.this, R.l.eSv, R.l.dGZ);
                        if (h != null) {
                            h.setOnDismissListener(anonymousClass2);
                        }
                        synchronized (JSAPIUploadLogHelperUI.xPm) {
                            JSAPIUploadLogHelperUI.mIsRunning = false;
                        }
                    } else if (i >= 100) {
                        x.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
                        as.a(null);
                        if (a != null) {
                            a.dismiss();
                        }
                        h = h.h(JSAPIUploadLogHelperUI.this, R.l.eSz, R.l.dGZ);
                        if (h != null) {
                            h.setOnDismissListener(anonymousClass2);
                        }
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        g.pWK.h(12975, Long.valueOf(currentTimeMillis));
                        synchronized (JSAPIUploadLogHelperUI.xPm) {
                            JSAPIUploadLogHelperUI.mIsRunning = false;
                        }
                    } else {
                        x.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", Integer.valueOf(i));
                        if (a != null) {
                            a.setMessage(JSAPIUploadLogHelperUI.this.getString(R.l.eSw) + i + "%");
                        }
                    }
                }
            });
        }
    }

    protected void onDestroy() {
        x.i("MicroMsg.JSAPIUploadLogHelperUI", "onDestroy called, isRunning:%b", Boolean.valueOf(mIsRunning));
        super.onDestroy();
    }
}
