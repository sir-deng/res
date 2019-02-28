package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;

public class FingerPrintAuthUI extends WalletBaseUI implements com.tencent.mm.pluginsdk.wallet.a {
    private boolean isPaused = false;
    private Dialog mFC = null;
    private j mFD = null;
    private Animation mFF;
    private int mFG = 0;
    private TextView mFM;
    private c mFN;
    private a mFO;
    private boolean mFP = false;
    private final int mFQ = 1;

    public class a implements com.tencent.mm.pluginsdk.wallet.c {
        private WeakReference<FingerPrintAuthUI> mFU = null;

        public a(FingerPrintAuthUI fingerPrintAuthUI) {
            this.mFU = new WeakReference(fingerPrintAuthUI);
        }

        private FingerPrintAuthUI aLq() {
            if (this.mFU != null) {
                return (FingerPrintAuthUI) this.mFU.get();
            }
            return null;
        }

        public final void aH(int i, int i2) {
            String string;
            switch (i) {
                case 0:
                    x.i("MicroMsg.FingerPrintAuthUI", "identify success");
                    if (aLq() != null) {
                        FingerPrintAuthUI.a(aLq(), i2);
                        return;
                    }
                    return;
                case 2001:
                    x.i("MicroMsg.FingerPrintAuthUI", "identify timeout");
                    if (aLq() != null) {
                        FingerPrintAuthUI.this.fr(false);
                        return;
                    }
                    return;
                case 2002:
                    x.i("MicroMsg.FingerPrintAuthUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                    if (aLq() != null) {
                        FingerPrintAuthUI.a(aLq());
                        FingerPrintAuthUI.this.fr(true);
                        return;
                    }
                    return;
                case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                case 10308:
                    x.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", Integer.valueOf(i));
                    string = ad.getContext().getString(i.uUQ);
                    if (i == 10308) {
                        string = ad.getContext().getString(i.uUR);
                        com.tencent.mm.plugin.soter.c.a.c(6, -1000223, -1, "too many trial");
                    } else {
                        com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, i, "fingerprint error");
                    }
                    if (aLq() != null) {
                        aLq().bn(string, -1);
                        return;
                    }
                    return;
                case TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION /*2009*/:
                    x.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", Integer.valueOf(i));
                    string = ad.getContext().getString(i.uUQ);
                    com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, i, "fingerprint error");
                    com.tencent.mm.plugin.soter.c.a.yt(2);
                    if (aLq() != null) {
                        aLq().bn(string, -1);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthUI.mFG > 1) {
            fingerPrintAuthUI.mFG = currentTimeMillis;
            fingerPrintAuthUI.mFM.setText(i.uPI);
            fingerPrintAuthUI.mFM.setTextColor(fingerPrintAuthUI.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btC));
            fingerPrintAuthUI.mFM.setVisibility(4);
            if (fingerPrintAuthUI.mFF == null) {
                fingerPrintAuthUI.mFF = AnimationUtils.loadAnimation(fingerPrintAuthUI.mController.xRr, com.tencent.mm.plugin.wxpay.a.a.ugL);
            }
            fingerPrintAuthUI.mFM.startAnimation(fingerPrintAuthUI.mFF);
            ah.h(new Runnable() {
                public final void run() {
                    FingerPrintAuthUI.this.mFM.setVisibility(0);
                }
            }, fingerPrintAuthUI.mFF.getDuration());
        }
    }

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI, int i) {
        fingerPrintAuthUI.mFP = false;
        c.abort();
        c.release();
        fingerPrintAuthUI.mFD.a((com.tencent.mm.pluginsdk.wallet.a) fingerPrintAuthUI, String.valueOf(i), 1);
    }

    static /* synthetic */ boolean c(FingerPrintAuthUI fingerPrintAuthUI) {
        String str = "MicroMsg.FingerPrintAuthUI";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(!fingerPrintAuthUI.isPaused);
        x.i(str, str2, objArr);
        return !fingerPrintAuthUI.isPaused;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(i.uSH));
        this.mFM = (TextView) findViewById(f.urB);
        com.tencent.mm.plugin.fingerprint.a.aKz();
        this.mFN = com.tencent.mm.plugin.fingerprint.a.aKA();
        this.mFD = c.aKJ();
        Bundle af = com.tencent.mm.wallet_core.a.af(this);
        if (af != null) {
            String string = af.getString("pwd");
            if (TextUtils.isEmpty(string)) {
                x.e("MicroMsg.FingerPrintAuthUI", "get user pwd error");
                bn(getString(i.uPL), -1);
                com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, -1, "get user pwd error");
                return;
            } else if (e.aKP()) {
                ec(true);
                com.tencent.d.b.f.f.cHb().cHc();
                this.mFD.a((Context) this, new com.tencent.mm.pluginsdk.wallet.a() {
                    public final void ai(int i, String str) {
                        FingerPrintAuthUI.this.ec(false);
                        if (i == 0) {
                            FingerPrintAuthUI.this.mFP = true;
                            if (FingerPrintAuthUI.c(FingerPrintAuthUI.this)) {
                                FingerPrintAuthUI.this.fr(false);
                                return;
                            }
                            return;
                        }
                        FingerPrintAuthUI.this.bn(str, i);
                    }
                }, string);
                return;
            } else {
                x.e("MicroMsg.FingerPrintAuthUI", "device is not support FingerPrintAuth");
                return;
            }
        }
        x.e("MicroMsg.FingerPrintAuthUI", "contextdata is null,for that reason program can't get user pwd");
        bn(getString(i.uPL), -1);
        com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, -1, "contextdata is null,for that reason program can't get user pwd");
    }

    protected final void ec(final boolean z) {
        ah.y(new Runnable() {
            public final void run() {
                if (z) {
                    FingerPrintAuthUI.this.mFC = g.a(FingerPrintAuthUI.this, false, null);
                } else if (FingerPrintAuthUI.this.mFC != null && FingerPrintAuthUI.this.mFC.isShowing()) {
                    FingerPrintAuthUI.this.mFC.dismiss();
                    FingerPrintAuthUI.this.mFC = null;
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        this.isPaused = false;
        if (this.mFP) {
            fr(false);
        }
    }

    private void fr(boolean z) {
        com.tencent.mm.plugin.fingerprint.a.aKz();
        com.tencent.mm.plugin.fingerprint.a.aKA();
        c.abort();
        c.release();
        if (c.aKI()) {
            if (this.mFO == null) {
                this.mFO = new a(this);
            }
            if (c.a(this.mFO, z) != 0) {
                x.e("MicroMsg.FingerPrintAuthUI", "startFingerprintAuth failed!");
                return;
            }
            return;
        }
        x.e("MicroMsg.FingerPrintAuthUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
    }

    public void onPause() {
        super.onPause();
        this.isPaused = true;
        WakeLock newWakeLock = ((PowerManager) this.mController.xRr.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        x.i("MicroMsg.FingerPrintAuthUI", "hy: user cancelled");
        com.tencent.mm.plugin.fingerprint.a.aKz();
        if (com.tencent.mm.plugin.fingerprint.a.aKA() != null) {
            c.aKH();
        }
        if (newWakeLock != null) {
            newWakeLock.release();
        }
    }

    public void onDestroy() {
        x.i("MicroMsg.FingerPrintAuthUI", "hy: fingerprint auth ui on destroy");
        if (this.mFF != null) {
            this.mFF.cancel();
        }
        this.mFO = null;
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (this.mFD.d(i, i2, str, kVar)) {
            return true;
        }
        if (!(kVar instanceof y)) {
            return false;
        }
        ec(false);
        com.tencent.mm.wallet_core.a.c(this, new Bundle(), 0);
        Toast.makeText(this, i.uPM, 0).show();
        return true;
    }

    private void bn(final String str, final int i) {
        ah.y(new Runnable() {
            public final void run() {
                h.a(FingerPrintAuthUI.this, str, "", FingerPrintAuthUI.this.getString(i.uYs), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.wallet_core.a.c(FingerPrintAuthUI.this, new Bundle(), i);
                    }
                });
            }
        });
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uIx;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final void ai(int i, String str) {
        if (i == 0) {
            x.i("MicroMsg.FingerPrintAuthUI", "open fingerprintpay success");
            b(new y(null, 19), false);
            return;
        }
        ec(false);
        x.e("MicroMsg.FingerPrintAuthUI", "open fingerprintpay failed");
        h.a((Context) this, getString(i.uPL), "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.wallet_core.a.c(FingerPrintAuthUI.this, new Bundle(), -1);
            }
        });
    }
}
