package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.q;
import com.tencent.rtmp.TXLiveConstants;

@a(7)
public class FingerPrintAuthTransparentUI extends WalletBaseUI implements com.tencent.mm.pluginsdk.wallet.a {
    private c mEQ = new c() {
        public final void aH(int i, int i2) {
            String string;
            switch (i) {
                case 0:
                    x.i("MicroMsg.FingerPrintAuthTransparentUI", "identify success");
                    FingerPrintAuthTransparentUI.this.mFE = i2;
                    FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this);
                    return;
                case 2001:
                    x.i("MicroMsg.FingerPrintAuthTransparentUI", "identify timeout");
                    return;
                case 2002:
                    x.i("MicroMsg.FingerPrintAuthTransparentUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                    FingerPrintAuthTransparentUI.b(FingerPrintAuthTransparentUI.this);
                    FingerPrintAuthTransparentUI.this.fr(true);
                    return;
                case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                case 10308:
                    x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", Integer.valueOf(i));
                    string = ad.getContext().getString(i.uUQ);
                    if (i == 10308) {
                        string = ad.getContext().getString(i.uUR);
                        com.tencent.mm.plugin.soter.c.a.c(6, -1000223, -1, "too many trial");
                    } else {
                        com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, i, "fingerprint error");
                    }
                    FingerPrintAuthTransparentUI.this.al(-1, string);
                    return;
                case TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION /*2009*/:
                    x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", Integer.valueOf(i));
                    string = ad.getContext().getString(i.uUQ);
                    com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, i, "fingerprint error");
                    com.tencent.mm.plugin.soter.c.a.yt(2);
                    FingerPrintAuthTransparentUI.this.al(-1, string);
                    return;
                default:
                    return;
            }
        }
    };
    private k mFB = null;
    Dialog mFC;
    private j mFD = null;
    private int mFE = -1;
    private Animation mFF;
    private int mFG = 0;
    private boolean mFH = false;
    private int mFI = 0;
    private boolean mFJ = false;
    View view = null;

    static /* synthetic */ void a(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        fingerPrintAuthTransparentUI.mFH = false;
        com.tencent.mm.plugin.fingerprint.a.aKz();
        com.tencent.mm.plugin.fingerprint.a.aKA();
        com.tencent.mm.plugin.fingerprint.b.c.release();
        fingerPrintAuthTransparentUI.mFB.dismiss();
        fingerPrintAuthTransparentUI.mFD.a((com.tencent.mm.pluginsdk.wallet.a) fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.mFE, 2);
    }

    static /* synthetic */ void b(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthTransparentUI.mFG > 1) {
            fingerPrintAuthTransparentUI.mFG = currentTimeMillis;
            ((TextView) fingerPrintAuthTransparentUI.view.findViewById(f.cSf)).setVisibility(8);
            final TextView textView = (TextView) fingerPrintAuthTransparentUI.view.findViewById(f.uqx);
            textView.setVisibility(4);
            if (fingerPrintAuthTransparentUI.mFF == null) {
                fingerPrintAuthTransparentUI.mFF = AnimationUtils.loadAnimation(fingerPrintAuthTransparentUI.mController.xRr, com.tencent.mm.plugin.wxpay.a.a.ugL);
            }
            textView.startAnimation(fingerPrintAuthTransparentUI.mFF);
            ah.h(new Runnable() {
                public final void run() {
                    textView.setVisibility(0);
                }
            }, fingerPrintAuthTransparentUI.mFF.getDuration());
        }
    }

    static /* synthetic */ void b(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI, boolean z) {
        com.tencent.mm.plugin.soter.c.a.dP(2, fingerPrintAuthTransparentUI.mFI);
        if (z) {
            com.tencent.mm.plugin.soter.c.a.c(10, -1000223, -1, "user permanent cancelled");
            x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled and checked as not show anymore");
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.valueOf(true));
        } else {
            x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled but will show again");
            com.tencent.mm.plugin.soter.c.a.c(1, -1000223, -1, "user cancelled");
        }
        fingerPrintAuthTransparentUI.finish();
    }

    static /* synthetic */ void c(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        com.tencent.mm.plugin.soter.c.a.dP(3, fingerPrintAuthTransparentUI.mFI);
        Bundle af = com.tencent.mm.wallet_core.a.af(fingerPrintAuthTransparentUI);
        String str = "";
        if (af != null) {
            str = af.getString("key_pwd1");
        }
        fingerPrintAuthTransparentUI.mFD.a((Context) fingerPrintAuthTransparentUI, new com.tencent.mm.pluginsdk.wallet.a() {
            public final void ai(int i, String str) {
                FingerPrintAuthTransparentUI.this.ec(false);
                if (i == 0) {
                    x.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
                    FingerPrintAuthTransparentUI.d(FingerPrintAuthTransparentUI.this);
                    FingerPrintAuthTransparentUI.this.fr(false);
                    return;
                }
                FingerPrintAuthTransparentUI.this.al(-1, str);
            }
        }, str);
        fingerPrintAuthTransparentUI.ec(true);
        if (fingerPrintAuthTransparentUI.mFB != null && fingerPrintAuthTransparentUI.mFB.isShowing()) {
            fingerPrintAuthTransparentUI.mFB.dismiss();
        }
    }

    static /* synthetic */ void d(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "showIdentifyUI!");
        fingerPrintAuthTransparentUI.view = LayoutInflater.from(fingerPrintAuthTransparentUI).inflate(com.tencent.mm.plugin.wxpay.a.g.uIw, null);
        ViewParent parent = fingerPrintAuthTransparentUI.view.getParent();
        ViewGroup viewGroup = parent != null ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ((ImageView) fingerPrintAuthTransparentUI.view.findViewById(f.uqZ)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (FingerPrintAuthTransparentUI.this.mFB != null) {
                    FingerPrintAuthTransparentUI.this.mFB.cancel();
                }
                FingerPrintAuthTransparentUI.aLo();
                FingerPrintAuthTransparentUI.this.finish();
            }
        });
        if (fingerPrintAuthTransparentUI.mFB != null && fingerPrintAuthTransparentUI.mFB.isShowing()) {
            fingerPrintAuthTransparentUI.mFB.dismiss();
            fingerPrintAuthTransparentUI.mFB = null;
        }
        fingerPrintAuthTransparentUI.mFB = new k(fingerPrintAuthTransparentUI, com.tencent.mm.plugin.wxpay.a.j.eZo);
        fingerPrintAuthTransparentUI.mFB.setContentView(fingerPrintAuthTransparentUI.view);
        fingerPrintAuthTransparentUI.mFB.setCanceledOnTouchOutside(false);
        fingerPrintAuthTransparentUI.mFB.setCancelable(true);
        fingerPrintAuthTransparentUI.mFB.show();
        fingerPrintAuthTransparentUI.mFB.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                FingerPrintAuthTransparentUI.aLo();
                FingerPrintAuthTransparentUI.this.finish();
            }
        });
        h.a(fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.mFB);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "launch FingerPrintAuthTransparentUI");
        if (!e.aKP()) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
            finish();
        } else if (q.Gl()) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
            finish();
        } else if (e.aLb()) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
            finish();
        } else {
            com.tencent.mm.plugin.fingerprint.a.aKz();
            com.tencent.mm.plugin.fingerprint.a.aKA();
            if (com.tencent.mm.plugin.fingerprint.b.c.aKI()) {
                if (com.tencent.mm.compatible.e.q.gHJ.gHS != 1) {
                    x.e("MicroMsg.FingerPrintAuthTransparentUI", "hy: device config force to not support");
                    finish();
                }
                ag bMc = o.bMc();
                com.tencent.mm.plugin.fingerprint.a.aKz();
                com.tencent.mm.plugin.fingerprint.a.aKA();
                this.mFD = com.tencent.mm.plugin.fingerprint.b.c.aKJ();
                this.mFJ = g.Dq().Db().getBoolean(w.a.USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC, false);
                if (!bMc.bMy() || e.aLb()) {
                    x.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + bMc.bMy() + ";isOpenTouch:" + e.aLb());
                    x.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
                    finish();
                    return;
                }
                x.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
                com.tencent.d.b.f.f.cHb().cHc();
                com.tencent.mm.plugin.report.service.g.pWK.h(12924, Integer.valueOf(1));
                com.tencent.mm.plugin.soter.c.a.yr(0);
                if (g.Dq().Db().getBoolean(w.a.USERINFO_FINGER_PRINT_IS_FIRST_SHOWN_BOOLEAN_SYNC, true)) {
                    x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
                    g.Dq().Db().a(w.a.USERINFO_FINGER_PRINT_IS_FIRST_SHOWN_BOOLEAN_SYNC, Boolean.valueOf(false));
                    g.Dq().Db().a(w.a.USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC, Boolean.valueOf(false));
                    h.a((Context) this, this.mFJ ? getString(i.uPQ) : getString(i.uPP), "", getString(i.uOD), getString(i.dEy), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            FingerPrintAuthTransparentUI.c(FingerPrintAuthTransparentUI.this);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            FingerPrintAuthTransparentUI.b(FingerPrintAuthTransparentUI.this, false);
                        }
                    });
                    g.Dq().Db().a(w.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_COUNT_INT_SYNC, Integer.valueOf(1));
                    this.mFI = 1;
                    com.tencent.mm.plugin.soter.c.a.dP(1, this.mFI);
                    return;
                }
                x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
                View inflate = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uIy, null);
                final CheckBox checkBox = (CheckBox) inflate.findViewById(f.urd);
                this.mFI = ((Integer) g.Dq().Db().get(w.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_COUNT_INT_SYNC, null)).intValue() + 1;
                g.Dq().Db().a(w.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_COUNT_INT_SYNC, Integer.valueOf(this.mFI));
                com.tencent.mm.plugin.soter.c.a.dP(1, this.mFI);
                h.a((Context) this, false, null, inflate, getString(i.uOD), getString(i.dEy), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FingerPrintAuthTransparentUI.c(FingerPrintAuthTransparentUI.this);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FingerPrintAuthTransparentUI.b(FingerPrintAuthTransparentUI.this, checkBox.isChecked());
                    }
                });
                return;
            }
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.mFH) {
            fr(false);
        }
    }

    public void onPause() {
        super.onPause();
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "alvinluo onPause");
        WakeLock newWakeLock = ((PowerManager) this.mController.xRr.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        aLo();
        if (newWakeLock != null) {
            newWakeLock.release();
        }
    }

    protected void onStop() {
        super.onStop();
        finish();
    }

    private void fr(boolean z) {
        com.tencent.mm.plugin.fingerprint.a.aKz();
        com.tencent.mm.plugin.fingerprint.a.aKA();
        com.tencent.mm.plugin.fingerprint.b.c.abort();
        com.tencent.mm.plugin.fingerprint.b.c.release();
        if (!com.tencent.mm.plugin.fingerprint.b.c.aKI()) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
        } else if (com.tencent.mm.plugin.fingerprint.b.c.a(this.mEQ, z) != 0) {
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "startFingerprintAuth failed!");
        }
    }

    private static void aLo() {
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
        com.tencent.mm.plugin.fingerprint.a.aKz();
        if (com.tencent.mm.plugin.fingerprint.a.aKA() != null) {
            com.tencent.mm.plugin.fingerprint.b.c.aKH();
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        return this.mFD.d(i, i2, str, kVar);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void finish() {
        if (this.mFD != null) {
            this.mFD.clear();
        }
        super.finish();
    }

    private void al(int i, String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            string = getString(-1);
        } else {
            string = str;
        }
        h.a((Context) this, string, "", getString(i.uYs), false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.FingerPrintAuthTransparentUI", "showErrorAlert, finish ui!");
                dialogInterface.dismiss();
                FingerPrintAuthTransparentUI.this.finish();
            }
        });
    }

    protected final void ec(boolean z) {
        if (z) {
            this.mFC = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        } else if (this.mFC != null && this.mFC.isShowing()) {
            this.mFC.dismiss();
            this.mFC = null;
        }
    }

    public void onDestroy() {
        if (this.mFB != null && this.mFB.isShowing()) {
            this.mFB.dismiss();
            this.mFB = null;
        }
        if (this.mFF != null) {
            this.mFF.cancel();
        }
        ec(false);
        super.onDestroy();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final void ai(int i, String str) {
        ec(false);
        if (i == 0) {
            x.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
            b(new y(null, 19), false);
            h.a(this.mController.xRr, false, null, LayoutInflater.from(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uIv, null), getString(i.uYs), "", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    x.i("MicroMsg.FingerPrintAuthTransparentUI", "showSuccessAlert, finish ui!");
                    FingerPrintAuthTransparentUI.this.finish();
                }
            }, null);
        } else if (i == -2) {
            String string;
            x.e("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay failed");
            int i2 = i.uPL;
            if (TextUtils.isEmpty(str)) {
                string = getString(i2);
            } else {
                string = str;
            }
            h.a((Context) this, string, "", getString(i.uPN), getString(i.dEy), false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
                    FingerPrintAuthTransparentUI.d(FingerPrintAuthTransparentUI.this);
                    FingerPrintAuthTransparentUI.this.fr(false);
                    dialogInterface.dismiss();
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    FingerPrintAuthTransparentUI.this.finish();
                }
            });
        } else {
            al(-1, str);
        }
    }
}
