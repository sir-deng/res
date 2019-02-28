package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.c.b.i;
import b.c.b.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class RadarTipsView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ b.e.d[] pDC = new b.e.d[]{j.a(new i(j.R(RadarTipsView.class), "tipsFadeIn", "getTipsFadeIn()Landroid/view/animation/Animation;")), j.a(new i(j.R(RadarTipsView.class), "tipsFadeOut", "getTipsFadeOut()Landroid/view/animation/Animation;")), j.a(new i(j.R(RadarTipsView.class), "tvTextTips", "getTvTextTips()Landroid/widget/TextView;")), j.a(new i(j.R(RadarTipsView.class), "textTipsContainer", "getTextTipsContainer()Landroid/view/View;")), j.a(new i(j.R(RadarTipsView.class), "noviceEducationTips", "getNoviceEducationTips()Landroid/widget/LinearLayout;"))};
    private static final int pFd = 3;
    private static final int pFe = 0;
    static final int pFf = 1;
    static final int pFg = 2;
    private static final int pFh = 3;
    public static final a pFi = new a();
    private final b pEJ = new b(this);
    private final b.b pEK = b.c.b(new d(this));
    private final b.b pEL = b.c.b(new e(this));
    private final b.b pEM = i.C(this, com.tencent.mm.plugin.radar.a.c.pBD);
    private final b.b pEN = i.C(this, com.tencent.mm.plugin.radar.a.c.pBB);
    private final b.b pEO = i.C(this, com.tencent.mm.plugin.radar.a.c.pBE);
    private final int pEP;
    final int pEQ = 1;
    final int pER = 2;
    private final int pES = 3;
    private final int pET = 3;
    final f pEU = new f(this, Looper.getMainLooper());
    boolean pEV;
    private boolean pEW = true;
    boolean pEX;
    boolean pEY;
    int pEZ;
    long pFa;
    boolean pFb;
    int pFc = pFe;

    public static final class b extends ag {
        final /* synthetic */ RadarTipsView pFj;

        b(RadarTipsView radarTipsView) {
            this.pFj = radarTipsView;
        }

        public final void handleMessage(Message message) {
            b.c.b.e.i(message, "msg");
            this.pFj.setVisibility(8);
        }
    }

    static final class d extends b.c.b.f implements b.c.a.a<Animation> {
        final /* synthetic */ RadarTipsView pFj;

        d(RadarTipsView radarTipsView) {
            this.pFj = radarTipsView;
        }

        public final /* synthetic */ Object invoke() {
            return AnimationUtils.loadAnimation(this.pFj.getContext(), com.tencent.mm.plugin.radar.a.a.pAY);
        }
    }

    static final class e extends b.c.b.f implements b.c.a.a<Animation> {
        final /* synthetic */ RadarTipsView pFj;

        public static final class a implements AnimationListener {
            final /* synthetic */ e pFk;

            a(e eVar) {
                this.pFk = eVar;
            }

            public final void onAnimationStart(Animation animation) {
                b.c.b.e.i(animation, "animation");
            }

            public final void onAnimationEnd(Animation animation) {
                b.c.b.e.i(animation, "animation");
                if (!this.pFk.pFj.pEV) {
                    this.pFk.pFj.pEJ.sendEmptyMessage(0);
                }
            }

            public final void onAnimationRepeat(Animation animation) {
                b.c.b.e.i(animation, "animation");
            }
        }

        e(RadarTipsView radarTipsView) {
            this.pFj = radarTipsView;
        }

        public final /* synthetic */ Object invoke() {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pFj.getContext(), com.tencent.mm.plugin.radar.a.a.pAZ);
            loadAnimation.setAnimationListener(new a(this));
            return loadAnimation;
        }
    }

    public static final class f extends ag {
        final /* synthetic */ RadarTipsView pFj;

        f(RadarTipsView radarTipsView, Looper looper) {
            this.pFj = radarTipsView;
            super(looper);
        }

        public final void handleMessage(Message message) {
            b.c.b.e.i(message, "msg");
            int i = message.what;
            if (i == this.pFj.pEP) {
                this.pFj.bmC();
            } else if (i == this.pFj.pEQ) {
                if (this.pFj.pEW && this.pFj.pEY) {
                    RadarTipsView.a(this.pFj, com.tencent.mm.plugin.radar.a.f.pBZ);
                }
            } else if (i == this.pFj.pES) {
                RadarTipsView radarTipsView = this.pFj;
                radarTipsView.pEV = true;
                a aVar = RadarTipsView.pFi;
                radarTipsView.pFc = RadarTipsView.pFg;
                aVar = RadarTipsView.pFi;
                x.d(RadarTipsView.TAG, "showNoviceEducation");
                radarTipsView.pEX = true;
                radarTipsView.bmz().setVisibility(8);
                radarTipsView.bmz().clearAnimation();
                radarTipsView.setVisibility(0);
                radarTipsView.bmA().setVisibility(0);
                radarTipsView.bmA().startAnimation(radarTipsView.bmx());
                radarTipsView.bmA().requestFocus();
            } else if (i == this.pFj.pET) {
                this.pFj.bmB();
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static final class c implements OnClickListener {
        final /* synthetic */ RadarTipsView pFj;

        c(RadarTipsView radarTipsView) {
            this.pFj = radarTipsView;
        }

        public final void onClick(View view) {
            a aVar = RadarTipsView.pFi;
            x.d(RadarTipsView.TAG, "noviceEducationTips onclick");
            this.pFj.bmB();
        }
    }

    private final Animation bmy() {
        return (Animation) this.pEL.getValue();
    }

    final LinearLayout bmA() {
        return (LinearLayout) this.pEO.getValue();
    }

    final Animation bmx() {
        return (Animation) this.pEK.getValue();
    }

    final View bmz() {
        return (View) this.pEN.getValue();
    }

    public RadarTipsView(Context context, AttributeSet attributeSet) {
        b.c.b.e.i(context, "context");
        b.c.b.e.i(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public RadarTipsView(Context context, AttributeSet attributeSet, int i) {
        b.c.b.e.i(context, "context");
        b.c.b.e.i(attributeSet, "attrs");
        super(context, attributeSet, i);
    }

    public static /* synthetic */ void a(RadarTipsView radarTipsView, int i) {
        Object string = radarTipsView.getContext().getString(i);
        b.c.b.e.h(string, "context.getString(res)");
        radarTipsView.bY(string, -1);
    }

    private void bY(String str, int i) {
        b.c.b.e.i(str, "msg");
        this.pEV = true;
        bmA().setVisibility(8);
        bmA().clearAnimation();
        ((TextView) this.pEM.getValue()).setText(str);
        setVisibility(0);
        bmz().setVisibility(0);
        bmz().startAnimation(bmx());
        this.pEU.removeMessages(this.pEP);
        this.pEU.removeMessages(this.pER);
        if (i > 0) {
            this.pEU.sendEmptyMessageDelayed(this.pEP, (long) i);
        }
    }

    public final void IG(String str) {
        b.c.b.e.i(str, "msg");
        this.pFc = pFh;
        bY(str, 5000);
    }

    public final void bmB() {
        this.pEV = false;
        this.pFc = pFe;
        x.d(TAG, "hidNoviceEducation");
        this.pEU.removeMessages(this.pES);
        if (getVisibility() == 0 && bmA().getVisibility() == 0) {
            bmA().clearAnimation();
            if (bmz().getAnimation() == bmy()) {
                bmz().clearAnimation();
            }
            x.d(TAG, "hideNoviceEducation real");
            bmA().startAnimation(bmy());
        }
    }

    public final void hz(boolean z) {
        this.pEW = z;
        if (!this.pEW) {
            bmC();
            bmD();
            bmB();
        }
    }

    public final void bmC() {
        x.d(TAG, "hideRadarTips");
        if (getVisibility() == 0 && bmz().getVisibility() == 0) {
            if (bmA().getAnimation() == bmy()) {
                bmA().clearAnimation();
            }
            bmz().clearAnimation();
            x.d(TAG, "hideRadarTips real");
            this.pFc = pFe;
            this.pEV = false;
            bmz().startAnimation(bmy());
        }
    }

    public final void bmD() {
        this.pEV = false;
        f fVar = this.pEU;
        fVar.removeMessages(this.pEQ);
        fVar.removeMessages(this.pER);
        fVar.removeMessages(this.pES);
    }
}
