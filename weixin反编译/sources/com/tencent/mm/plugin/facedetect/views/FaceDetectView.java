package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.d.b;
import com.tencent.mm.plugin.facedetect.d.b.a;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.c.a.c;

public class FaceDetectView extends RelativeLayout {
    public static long mst = 100;
    public static int msu = 1;
    public boolean isPaused;
    public volatile boolean kRY;
    public long mmd;
    public TextView mpU;
    public FaceDetectCameraView msd;
    public FaceDetectDecorView mse;
    public ViewGroup msf;
    public ViewGroup msg;
    public a msh;
    public b msi;
    public boolean msj;
    public boolean msk;
    public String msl;
    public boolean msm;
    public boolean msn;
    public long mso;
    private long msp;
    private final int msq;
    private Animation msr;
    private View mss;

    /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectView$4 */
    class AnonymousClass4 implements c {
        final /* synthetic */ c msy;

        public AnonymousClass4(c cVar) {
            this.msy = cVar;
        }

        public final void pV(int i) {
            x.i("MicroMsg.FaceDetectView", "hy: camera preview init done : %d", Integer.valueOf(i));
            if (i == 0) {
                FaceDetectView.this.msk = false;
                FaceDetectView.this.aIl();
            }
            if (this.msy != null) {
                this.msy.pV(i);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectView$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ p mod = null;

        AnonymousClass5(p pVar) {
        }

        public final void run() {
            FaceDetectView.this.msd.aIf();
            if (this.mod != null) {
                this.mod.b(FaceDetectView.this.msd.aIh());
            }
        }
    }

    static /* synthetic */ void a(FaceDetectView faceDetectView, a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.FaceDetectView", "hy: motion eat but no data");
            return;
        }
        Object obj;
        if (aVar == null) {
            x.e("MicroMsg.FaceDetectView", "hy: motion eat but no data");
        } else if (aVar.mng > 0) {
            if (faceDetectView.msh != null) {
                faceDetectView.msh.pU(aVar.mng);
            }
            obj = 1;
            if (obj == null) {
                faceDetectView.msk = FaceCharacteristicsResult.pK(aVar.mnh);
                faceDetectView.At(aVar.foE == null ? aVar.foE : faceDetectView.getContext().getString(h.mjA));
                if (faceDetectView.msh != null) {
                    faceDetectView.msh.K(aVar.mnh, aVar.foE == null ? aVar.foE : faceDetectView.getContext().getString(h.mjA));
                }
            }
        }
        obj = null;
        if (obj == null) {
            faceDetectView.msk = FaceCharacteristicsResult.pK(aVar.mnh);
            if (aVar.foE == null) {
            }
            faceDetectView.At(aVar.foE == null ? aVar.foE : faceDetectView.getContext().getString(h.mjA));
            if (faceDetectView.msh != null) {
                if (aVar.foE == null) {
                }
                faceDetectView.msh.K(aVar.mnh, aVar.foE == null ? aVar.foE : faceDetectView.getContext().getString(h.mjA));
            }
        }
    }

    static /* synthetic */ void e(FaceDetectView faceDetectView) {
        if (faceDetectView.msi != null && faceDetectView.msi.aHB()) {
            x.i("MicroMsg.FaceDetectView", "hy: meet require");
            faceDetectView.msd.aIf();
            faceDetectView.isPaused = true;
            long bB = bi.bB(faceDetectView.mso);
            x.i("MicroMsg.FaceDetectView", "hy: current motion used time: %d", Long.valueOf(bB));
            if (bB < faceDetectView.mmd - 5) {
                ah.h(new Runnable() {
                    public final void run() {
                        if (FaceDetectView.this.msh != null && !FaceDetectView.this.kRY) {
                            FaceDetectView.this.msh.K(0, "");
                        }
                    }
                }, faceDetectView.mmd - bB);
            } else if (faceDetectView.msh != null && !faceDetectView.kRY) {
                faceDetectView.msh.K(0, "");
            }
        }
    }

    static /* synthetic */ boolean f(FaceDetectView faceDetectView) {
        long Wz = bi.Wz();
        x.d("MicroMsg.FaceDetectView", "hy: tick between: %d, threshold: %d", Long.valueOf(Wz - faceDetectView.msp), Integer.valueOf(1500));
        if (Wz - faceDetectView.msp <= 1500) {
            return false;
        }
        faceDetectView.msp = Wz;
        return true;
    }

    public FaceDetectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private FaceDetectView(Context context, AttributeSet attributeSet, int i, byte b) {
        Animation animation;
        super(context, attributeSet, i);
        this.msd = null;
        this.mse = null;
        this.mpU = null;
        this.msf = null;
        this.msg = null;
        this.msh = null;
        this.msj = false;
        this.kRY = false;
        this.isPaused = false;
        this.msk = false;
        this.msl = ad.getContext().getString(h.mkl);
        this.msm = true;
        this.msn = false;
        this.mmd = -1;
        this.mso = -1;
        this.msp = -1;
        this.msq = 1500;
        this.mss = null;
        View inflate = LayoutInflater.from(context).inflate(g.mjz, null, false);
        addView(inflate);
        this.msd = (FaceDetectCameraView) inflate.findViewById(e.miD);
        this.mse = (FaceDetectDecorView) inflate.findViewById(e.mjf);
        this.mss = inflate.findViewById(e.mje);
        this.msd.mrr = new b() {
            public final void b(int i, CharSequence charSequence) {
                x.e("MicroMsg.FaceDetectView", "hy: onDetectError: %d, %s", Integer.valueOf(i), charSequence);
                if (FaceDetectView.this.kRY || FaceDetectView.this.isPaused) {
                    x.w("MicroMsg.FaceDetectView", "hy: already end or paused");
                } else if (FaceDetectView.this.msi == null || !FaceDetectView.this.msi.aHC()) {
                    FaceDetectView.this.eZ(false);
                    FaceDetectView.this.msk = true;
                    FaceDetectView.this.At(charSequence != null ? charSequence.toString() : FaceDetectView.this.getContext().getString(h.mjA));
                    if (FaceDetectView.this.msh != null) {
                        FaceDetectView.this.msh.K(i, charSequence != null ? charSequence.toString() : FaceDetectView.this.getContext().getString(h.mjA));
                    }
                } else {
                    x.e("MicroMsg.FaceDetectView", "hy: motion eat result");
                    FaceDetectView.a(FaceDetectView.this, FaceDetectView.this.msi.aHF());
                }
            }

            public final void c(FaceCharacteristicsResult faceCharacteristicsResult) {
                int i = faceCharacteristicsResult.errCode;
                String str = faceCharacteristicsResult.foE;
                x.v("MicroMsg.FaceDetectView", "hy: onDetectHelp: %d, %s", Integer.valueOf(i), str);
                if (FaceDetectView.this.kRY || FaceDetectView.this.isPaused) {
                    x.w("MicroMsg.FaceDetectView", "hy: already end");
                } else if (FaceDetectView.this.msi == null || !FaceDetectView.this.msi.a(faceCharacteristicsResult)) {
                    FaceDetectView.e(FaceDetectView.this);
                    if (!FaceDetectView.f(FaceDetectView.this)) {
                        return;
                    }
                    if (FaceDetectView.this.msm || !(faceCharacteristicsResult.errCode == 10 || faceCharacteristicsResult.errCode == 11)) {
                        FaceDetectView.this.msk = FaceCharacteristicsResult.pJ(i);
                        FaceDetectView faceDetectView = FaceDetectView.this;
                        if (str == null) {
                            str = "";
                        }
                        faceDetectView.At(str);
                    }
                } else {
                    x.e("MicroMsg.FaceDetectView", "hy: motion eat result");
                    FaceDetectView.a(FaceDetectView.this, FaceDetectView.this.msi.aHF());
                }
            }

            public final void d(FaceCharacteristicsResult faceCharacteristicsResult) {
                x.d("MicroMsg.FaceDetectView", "hy: onDetectSucceed: %s", faceCharacteristicsResult.toString());
                if (FaceDetectView.this.kRY || FaceDetectView.this.isPaused) {
                    x.w("MicroMsg.FaceDetectView", "hy: already end pr paused");
                } else if (FaceDetectView.this.msi == null || !FaceDetectView.this.msi.b(faceCharacteristicsResult)) {
                    FaceDetectView.this.msk = false;
                    if ((FaceDetectView.this.msi != null && FaceDetectView.this.msi.aHB()) || FaceDetectView.f(FaceDetectView.this)) {
                        FaceDetectView.this.aIl();
                        FaceDetectView.e(FaceDetectView.this);
                    }
                } else {
                    x.e("MicroMsg.FaceDetectView", "hy: motion eat result");
                    FaceDetectView.a(FaceDetectView.this, FaceDetectView.this.msi.aHF());
                }
            }
        };
        Context context2 = getContext();
        if (context2 == null) {
            x.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
            animation = null;
        } else {
            animation = AnimationUtils.loadAnimation(context2, com.tencent.mm.v.a.a.gWe);
            animation.setInterpolator(new c());
        }
        this.msr = animation;
    }

    public final void g(boolean z, final String str) {
        if (z) {
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    final Bitmap Aq = o.Aq(str);
                    ah.y(new Runnable() {
                        public final void run() {
                            FaceDetectView.this.mss.setVisibility(0);
                            FaceDetectView.this.mss.setBackgroundDrawable(new BitmapDrawable(Aq));
                        }
                    });
                }
            }, "face_detect_set_backgroud");
            return;
        }
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        this.mss.startAnimation(alphaAnimation);
    }

    private void aIl() {
        this.mpU.setText("");
        this.mpU.setVisibility(4);
    }

    private void At(String str) {
        if (bi.oM(str).equals(this.mpU.getText().toString())) {
            x.v("MicroMsg.FaceDetectView", "hy: same error. ignore");
            return;
        }
        this.mpU.setText(str);
        this.mpU.setVisibility(0);
        this.mpU.setAnimation(this.msr);
    }

    public final int aIm() {
        return this.msd.mrJ.aHu();
    }

    public final void eZ(boolean z) {
        if (this.msi != null) {
            this.msi.aHD();
        }
        if (this.kRY) {
            x.w("MicroMsg.FaceDetectView", "hy: already end");
            return;
        }
        this.kRY = true;
        if (z) {
            if (this.msd != null) {
                f.w(new AnonymousClass5(null));
            }
        } else if (this.msd != null) {
            this.msd.aIf();
            f.mlS.mlT.mnX.aHp();
        }
        x.i("MicroMsg.FaceDetectView", "hy: stopped capture face");
        this.msk = false;
        aIl();
    }
}
