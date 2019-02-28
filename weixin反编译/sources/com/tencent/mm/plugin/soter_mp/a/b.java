package com.tencent.mm.plugin.soter_mp.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.d.b.a.c;
import com.tencent.d.b.c.a;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.plugin.soter_mp.ui.SoterAuthenticationUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import java.lang.ref.WeakReference;

public final class b extends c implements e {
    TextView jIe = null;
    a mFo = null;
    boolean rYZ = false;
    private i rZa = null;
    ImageView rZb = null;
    private final int rZc = 3;
    private int rZd = 0;
    private final long rZe = 500;
    Animation rZf = null;
    Animation rZg = null;
    Runnable rZh = new Runnable() {
        public final void run() {
            b.this.jIe.setTextColor(b.this.jIe.getResources().getColor(R.e.bsM));
            b.this.jIe.setText(b.this.jIe.getResources().getString(R.l.eQq));
            b.this.rZb.setImageResource(R.k.cid);
        }
    };

    /* renamed from: com.tencent.mm.plugin.soter_mp.a.b$7 */
    class AnonymousClass7 implements AnimationListener {
        final /* synthetic */ CharSequence lp;

        AnonymousClass7(CharSequence charSequence) {
            this.lp = charSequence;
        }

        public final void onAnimationStart(Animation animation) {
            b.this.rZb.setImageResource(R.k.dyO);
            b.this.jIe.setText(this.lp);
            b.this.jIe.setTextColor(b.this.jIe.getResources().getColor(R.e.bue));
            b.this.jIe.removeCallbacks(b.this.rZh);
        }

        public final void onAnimationEnd(Animation animation) {
            b.this.jIe.post(b.this.rZh);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    static /* synthetic */ void a(b bVar, boolean z) {
        if (bVar.rZa == null || !bVar.rZa.isShowing()) {
            if (bVar.rZo == null || bVar.rZo.get() == null) {
                x.e("MicroMsg.SoterControllerFingerprint", "hy: ui released.");
                bVar.rZn.errCode = 90007;
                bVar.rZn.foE = "internal error occurred: ui released";
                bVar.bDK();
            } else {
                if (bVar.rZa == null) {
                    Activity activity = (Activity) bVar.rZo.get();
                    i.a aVar = new i.a(activity);
                    View inflate = activity.getLayoutInflater().inflate(R.i.dir, null, false);
                    bVar.rZb = (ImageView) inflate.findViewById(R.h.cid);
                    bVar.jIe = (TextView) inflate.findViewById(R.h.cie);
                    ((TextView) inflate.findViewById(R.h.cic)).setText(bVar.rZm.content);
                    aVar.dk(inflate);
                    aVar.mp(true);
                    aVar.EW(R.l.dEy).b(new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth by click button");
                            b.this.mFo.od(true);
                            b.this.bDJ();
                        }
                    });
                    aVar.d(new OnCancelListener() {
                        @TargetApi(16)
                        public final void onCancel(DialogInterface dialogInterface) {
                            x.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth");
                            b.this.bDJ();
                        }
                    });
                    bVar.rZa = aVar.ale();
                    c.a(bVar.rZa);
                    bVar.rZa.setCanceledOnTouchOutside(false);
                }
                if (!bVar.rZa.isShowing()) {
                    bVar.rZa.show();
                }
            }
        }
        if (z) {
            if (!(VERSION.SDK_INT < 23)) {
                x.i("MicroMsg.SoterControllerFingerprint", "hy: req restart after fail, but no need");
                return;
            }
        }
        if (bVar.mFo != null) {
            x.e("MicroMsg.SoterControllerFingerprint", "alvinluo mFingerprintCanceller not null, cancel and start auth by delaying 500ms.");
            bVar.mFo.od(true);
            ah.h(new Runnable() {
                public final void run() {
                    b.this.mFo = new a();
                    b.this.bDG();
                }
            }, 500);
            return;
        }
        bVar.bDG();
    }

    public b(WeakReference<Activity> weakReference, d dVar, com.tencent.mm.plugin.soter_mp.b.e eVar) {
        super(weakReference, dVar, eVar);
    }

    @TargetApi(23)
    public final void cS() {
        if (!com.tencent.d.a.a.if(ad.getContext())) {
            this.rZn.errCode = 90011;
            this.rZn.foE = "no fingerprint enrolled";
            bDK();
        }
        try {
            if (ad.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0) {
                String[] strArr = new String[]{"android.permission.USE_FINGERPRINT"};
                if (SoterAuthenticationUI.rZt != null) {
                    Message obtainMessage = SoterAuthenticationUI.rZt.obtainMessage(3);
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("permissions", strArr);
                    bundle.putInt("request_code", 0);
                    obtainMessage.setData(bundle);
                    obtainMessage.sendToTarget();
                    return;
                }
                x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
                return;
            }
            this.rYZ = true;
        } catch (NoSuchMethodError e) {
            x.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
            this.rYZ = true;
        }
    }

    private boolean bDF() {
        if (SoterAuthenticationUI.rZt != null) {
            SoterAuthenticationUI.rZt.obtainMessage(4).sendToTarget();
        } else {
            x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
        x.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
        com.tencent.d.b.a.a(new com.tencent.d.b.a.b<c>() {
            public final /* synthetic */ void a(com.tencent.d.b.a.e eVar) {
                c cVar = (c) eVar;
                x.i("MicroMsg.SoterControllerFingerprint", "hy: update mp auth key result: errcode: %d, errmsg: %s", Integer.valueOf(cVar.errCode), cVar.foE);
                c.bDH();
                if (cVar.isSuccess()) {
                    b.a(b.this, false);
                } else {
                    com.tencent.mm.plugin.soter.c.a.dQ(2, cVar.errCode);
                }
                if (cVar.errCode == 12) {
                    x.e("MicroMsg.SoterControllerFingerprint", "hy: model is null");
                    b.this.rZn.errCode = 90007;
                    b.this.rZn.foE = "auth key can not be retrieved";
                    b.this.bDK();
                } else if (cVar.errCode == 5) {
                    x.v("MicroMsg.SoterControllerFingerprint", "alvinluo: gen auth key failed, remove auth key");
                    com.tencent.d.b.a.Is(2);
                    b.this.rZn.errCode = 90007;
                    b.this.rZn.foE = "auth key generate failed";
                    b.this.bDK();
                } else if (cVar.errCode == 10) {
                    x.i("MicroMsg.SoterControllerFingerprint", "hy: update auth key failed. remove auth key");
                    com.tencent.d.b.a.Is(2);
                    b.this.rZn.errCode = 90007;
                    b.this.rZn.foE = "auth key update error";
                    b.this.bDK();
                }
            }
        }, false, 2, new com.tencent.mm.plugin.soter_mp.b.c(), new com.tencent.mm.plugin.soter.b.e());
        return false;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 0) {
            return;
        }
        if (strArr.length <= 0 || iArr.length <= 0 || !"android.permission.USE_FINGERPRINT".equals(strArr[0]) || iArr[0] != 0) {
            x.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
            this.rZn.errCode = 90002;
            this.rZn.foE = "user not grant to use fingerprint";
            bDK();
            return;
        }
        x.i("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
        bDF();
        this.rYZ = true;
    }

    private void bDG() {
        this.mFo = new a();
        com.tencent.d.b.a.b anonymousClass3 = new com.tencent.d.b.a.b<com.tencent.d.b.a.a>() {
            public final /* synthetic */ void a(com.tencent.d.b.a.e eVar) {
                final com.tencent.d.b.a.a aVar = (com.tencent.d.b.a.a) eVar;
                x.i("MicroMsg.SoterControllerFingerprint", "alvinluo request authentication result errCode: %d, errMsg: %s", Integer.valueOf(aVar.errCode), aVar.foE);
                b.this.rYZ = false;
                if (aVar.isSuccess()) {
                    ah.h(new Runnable() {
                        public final void run() {
                            com.tencent.d.a.c.i iVar = (com.tencent.d.a.c.i) aVar.AlN;
                            b.this.rZn.errCode = 0;
                            b.this.rZn.foE = "OK";
                            b.this.rZn.rZq = (byte) 1;
                            b.this.rZn.fHh = iVar.AlM;
                            b.this.rZn.rZr = iVar.signature;
                            b.this.bDI();
                        }
                    }, 500);
                    return;
                }
                com.tencent.mm.plugin.soter.c.a.dQ(3, aVar.errCode);
                if (aVar.errCode == 13 || aVar.errCode == 20) {
                    x.i("MicroMsg.SoterControllerFingerprint", "hy: start authen error, maybe key invalid. remove former key and give suggestion");
                    com.tencent.d.b.a.Is(2);
                    b.this.rZn.errCode = 90007;
                    b.this.rZn.foE = "start fingerprint authen failed";
                } else if (aVar.errCode == 25) {
                    b.this.rZn.errCode = 90010;
                    b.this.rZn.foE = "authenticate freeze. please try again later";
                } else {
                    b.this.rZn.errCode = 90007;
                    b.this.rZn.foE = "authenticate error: " + aVar.foE;
                }
                b.this.bDK();
            }
        };
        com.tencent.d.b.c.b anonymousClass4 = new com.tencent.d.b.c.b() {
            public final void aLi() {
                x.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
                b.this.rYZ = true;
            }

            public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                x.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen help errCode: %d, errMsg:%s", Integer.valueOf(i), charSequence);
            }

            public final void aLj() {
                x.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
                b.this.rYZ = false;
                b.this.mFo = null;
                b bVar = b.this;
                bVar.jIe.removeCallbacks(bVar.rZh);
                bVar.rZb.setImageResource(R.k.dyP);
                bVar.jIe.setTextColor(bVar.jIe.getResources().getColor(R.e.btU));
                bVar.jIe.setText(bVar.jIe.getResources().getString(R.l.eQr));
            }

            public final void onAuthenticationFailed() {
                x.w("MicroMsg.SoterControllerFingerprint", "hy: mp user trying failed");
                b bVar = b.this;
                CharSequence string = ad.getContext().getString(R.l.eQp);
                if (bVar.rZf == null) {
                    bVar.rZf = com.tencent.mm.ui.c.a.fB(bVar.rZb.getContext());
                }
                if (bVar.rZg == null) {
                    bVar.rZg = com.tencent.mm.ui.c.a.fB(bVar.rZb.getContext());
                }
                bVar.rZf.setAnimationListener(new AnonymousClass7(string));
                bVar.jIe.startAnimation(bVar.rZf);
                bVar.rZb.startAnimation(bVar.rZg);
                ah.h(new Runnable() {
                    public final void run() {
                        b.this.rYZ = false;
                        b.a(b.this, true);
                    }
                }, 500);
            }

            public final void aLk() {
                x.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
                b.this.mFo = null;
            }

            public final void onAuthenticationError(int i, CharSequence charSequence) {
                x.e("MicroMsg.SoterControllerFingerprint", "hy: on mp authen error errCode: %d, errMsg: %s", Integer.valueOf(i), charSequence);
            }
        };
        com.tencent.d.b.f.b.a ack = new com.tencent.d.b.f.b.a().It(2).iq(ad.getContext()).a(this.mFo).ack(this.rZm.mFv);
        ack.Aml.Amj = null;
        com.tencent.d.b.a.a(anonymousClass3, ack.a(anonymousClass4).Aml);
    }

    public final void onResume() {
        if (this.rYZ) {
            bDF();
        }
    }

    @TargetApi(16)
    public final void onPause() {
        if (this.rYZ && this.mFo != null) {
            this.mFo.od(true);
        }
        if (this.rZa != null && this.rZa.isShowing()) {
            this.rZa.dismiss();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
    }
}
