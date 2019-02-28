package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public class WalletOpenFingerprintPayRedirectUI extends AutoLoginActivity implements e {
    private boolean HF = false;
    private Dialog ion = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.Dr();
        g.Dp().gRu.a(385, (e) this);
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final boolean z(Intent intent) {
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        g.Dr();
        g.Dp().gRu.b(385, (e) this);
    }

    protected final void a(a aVar, Intent intent) {
        x.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, loginResult = " + aVar);
        switch (aVar) {
            case LOGIN_OK:
                x.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: login ok.");
                g.Dr();
                g.Dp().gRu.a(new y(null, 19), 0);
                if (this.ion != null) {
                    this.ion.dismiss();
                    this.ion = null;
                }
                this.ion = com.tencent.mm.wallet_core.ui.g.e(this, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        WalletOpenFingerprintPayRedirectUI.this.HF = true;
                        WalletOpenFingerprintPayRedirectUI.this.b(4, false, "");
                    }
                });
                return;
            case LOGIN_CANCEL:
            case LOGIN_FAIL:
                x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin fail, loginResult = " + aVar);
                b(1, false, "");
                break;
            default:
                x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, unknown login result = " + aVar);
                break;
        }
        b(2, true, getString(i.uVr));
    }

    private void b(int i, boolean z, String str) {
        x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: redirect to open fingerprint failed. errCode: %d", Integer.valueOf(i));
        if (this.ion != null && this.ion.isShowing()) {
            this.ion.dismiss();
            this.ion = null;
        }
        if (z) {
            h.a((Context) this, str, "", false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletOpenFingerprintPayRedirectUI.this.finish();
                }
            });
        } else {
            finish();
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.ion != null && this.ion.isShowing()) {
            this.ion.dismiss();
            this.ion = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof y)) {
            return;
        }
        if (this.HF) {
            x.w("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: is already handled");
            return;
        }
        this.HF = true;
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query ok. start judge.");
            p.bKx();
            ag bKy = p.bKy();
            if (bKy == null || !bKy.bMy()) {
                x.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not open wechat payment. hint bind bankcard");
                b(5, true, getString(i.uYl));
                return;
            } else if (com.tencent.mm.plugin.wallet.b.a.bLq() && q.gHJ.gHT == 1) {
                Intent intent = new Intent();
                intent.putExtra("key_is_from_system", true);
                d.b(this, "wallet", ".pwd.ui.WalletPasswordSettingUI", intent);
                finish();
                return;
            } else {
                x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not support wechat fp pay or not allow");
                b(6, true, getString(i.uYn));
                return;
            }
        }
        x.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query failed. inform fail.");
        b(3, true, getString(i.uVr));
    }
}
