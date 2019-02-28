package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import b.c.b.f;
import b.c.b.i;
import b.c.b.j;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class RadarStateView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ b.e.d[] pDC = new b.e.d[]{j.a(new i(j.R(RadarStateView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), j.a(new i(j.R(RadarStateView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;"))};
    private static final int pEF = 300;
    public static final a pEG = new a();
    e pDh = e.Stranger;
    boolean pEC = true;
    final d pED = new d(this);
    private ImageView pEE;
    boolean pEt;
    private final b.b pEu = b.c.b(new c(this));
    private final b.b pEv = b.c.b(new b(this));

    static final class b extends f implements b.c.a.a<Animation> {
        final /* synthetic */ RadarStateView pEH;

        public static final class a implements AnimationListener {
            final /* synthetic */ b pEI;

            a(b bVar) {
                this.pEI = bVar;
            }

            public final void onAnimationStart(Animation animation) {
                b.c.b.e.i(animation, "animation");
            }

            public final void onAnimationEnd(Animation animation) {
                b.c.b.e.i(animation, "animation");
                this.pEI.pEH.pEt = false;
                this.pEI.pEH.setVisibility(8);
            }

            public final void onAnimationRepeat(Animation animation) {
                b.c.b.e.i(animation, "animation");
            }
        }

        b(RadarStateView radarStateView) {
            this.pEH = radarStateView;
        }

        public final /* synthetic */ Object invoke() {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pEH.getContext(), com.tencent.mm.plugin.radar.a.a.pAW);
            loadAnimation.setAnimationListener(new a(this));
            return loadAnimation;
        }
    }

    static final class c extends f implements b.c.a.a<Animation> {
        final /* synthetic */ RadarStateView pEH;

        public static final class a implements AnimationListener {
            a() {
            }

            public final void onAnimationStart(Animation animation) {
                b.c.b.e.i(animation, "animation");
            }

            public final void onAnimationEnd(Animation animation) {
                b.c.b.e.i(animation, "animation");
            }

            public final void onAnimationRepeat(Animation animation) {
                b.c.b.e.i(animation, "animation");
            }
        }

        c(RadarStateView radarStateView) {
            this.pEH = radarStateView;
        }

        public final /* synthetic */ Object invoke() {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pEH.getContext(), com.tencent.mm.plugin.radar.a.a.pAX);
            loadAnimation.setAnimationListener(new a());
            return loadAnimation;
        }
    }

    public static final class d extends ag {
        final /* synthetic */ RadarStateView pEH;

        d(RadarStateView radarStateView) {
            this.pEH = radarStateView;
        }

        public final void handleMessage(Message message) {
            b.c.b.e.i(message, "msg");
            this.pEH.bmt();
            this.pEH.bmu();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public RadarStateView(Context context, AttributeSet attributeSet) {
        b.c.b.e.i(context, "context");
        b.c.b.e.i(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public RadarStateView(Context context, AttributeSet attributeSet, int i) {
        b.c.b.e.i(context, "context");
        b.c.b.e.i(attributeSet, "attrs");
        super(context, attributeSet, i);
    }

    final void bmt() {
        x.d(TAG, " state : " + this.pDh);
        if (this.pEC) {
            ImageView imageView;
            switch (f.pDt[this.pDh.ordinal()]) {
                case 1:
                    setVisibility(8);
                    return;
                case 2:
                    setBackgroundResource(com.tencent.mm.plugin.radar.a.e.pBK);
                    imageView = this.pEE;
                    if (imageView == null) {
                        b.c.b.e.cKr();
                    }
                    imageView.setImageResource(com.tencent.mm.plugin.radar.a.e.pBO);
                    setVisibility(0);
                    return;
                case 3:
                    setBackgroundResource(com.tencent.mm.plugin.radar.a.e.pBL);
                    imageView = this.pEE;
                    if (imageView == null) {
                        b.c.b.e.cKr();
                    }
                    imageView.setImageResource(com.tencent.mm.plugin.radar.a.e.pBN);
                    setVisibility(0);
                    return;
                case 4:
                    setBackgroundResource(com.tencent.mm.plugin.radar.a.e.pBL);
                    imageView = this.pEE;
                    if (imageView == null) {
                        b.c.b.e.cKr();
                    }
                    imageView.setImageResource(com.tencent.mm.plugin.radar.a.e.pBM);
                    setVisibility(0);
                    return;
                default:
                    return;
            }
        }
        setVisibility(8);
    }

    final void init() {
        if (this.pEE == null) {
            this.pEE = new ImageView(getContext());
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.setMargins(0, 0, com.tencent.mm.bu.a.fromDPToPix(getContext(), 5), com.tencent.mm.bu.a.fromDPToPix(getContext(), 2));
            ImageView imageView = this.pEE;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            addView(this.pEE);
        }
    }

    public final void bmu() {
        if (this.pEC) {
            init();
            bmt();
            this.pEt = true;
            startAnimation((Animation) this.pEu.getValue());
        }
    }

    public final void bmv() {
        if (this.pEC) {
            init();
            bmt();
            startAnimation((Animation) this.pEv.getValue());
        }
    }
}
