package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import b.c.b.e;
import b.c.b.f;
import b.c.b.i;
import b.c.b.j;
import b.e.d;

public final class RadarStateChooseView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ d[] pDC = new d[]{j.a(new i(j.R(RadarStateChooseView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), j.a(new i(j.R(RadarStateChooseView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;"))};
    public static final a pEy = new a();
    boolean pEt;
    final b.b pEu = b.c.b(new c(this));
    final b.b pEv = b.c.b(new b(this));
    boolean pEw = true;
    com.tencent.mm.plugin.radar.b.e.a pEx = com.tencent.mm.plugin.radar.b.e.a.UnSelected;

    static final class b extends f implements b.c.a.a<Animation> {
        final /* synthetic */ RadarStateChooseView pEA;

        public static final class a implements AnimationListener {
            final /* synthetic */ b pEB;

            a(b bVar) {
                this.pEB = bVar;
            }

            public final void onAnimationStart(Animation animation) {
                e.i(animation, "animation");
            }

            public final void onAnimationEnd(Animation animation) {
                e.i(animation, "animation");
                this.pEB.pEA.pEt = false;
                this.pEB.pEA.setVisibility(8);
            }

            public final void onAnimationRepeat(Animation animation) {
                e.i(animation, "animation");
            }
        }

        b(RadarStateChooseView radarStateChooseView) {
            this.pEA = radarStateChooseView;
        }

        public final /* synthetic */ Object invoke() {
            Object loadAnimation = AnimationUtils.loadAnimation(this.pEA.getContext(), com.tencent.mm.plugin.radar.a.a.pAU);
            loadAnimation.setAnimationListener(new a(this));
            e.h(loadAnimation, "AnimationUtils.loadAnima…\n            })\n        }");
            return loadAnimation;
        }
    }

    static final class c extends f implements b.c.a.a<Animation> {
        final /* synthetic */ RadarStateChooseView pEA;

        public static final class a implements AnimationListener {
            a() {
            }

            public final void onAnimationStart(Animation animation) {
                e.i(animation, "animation");
            }

            public final void onAnimationEnd(Animation animation) {
                e.i(animation, "animation");
            }

            public final void onAnimationRepeat(Animation animation) {
                e.i(animation, "animation");
            }
        }

        c(RadarStateChooseView radarStateChooseView) {
            this.pEA = radarStateChooseView;
        }

        public final /* synthetic */ Object invoke() {
            Object loadAnimation = AnimationUtils.loadAnimation(this.pEA.getContext(), com.tencent.mm.plugin.radar.a.a.pAV);
            loadAnimation.setAnimationListener(new a());
            e.h(loadAnimation, "AnimationUtils.loadAnima…\n            })\n        }");
            return loadAnimation;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public RadarStateChooseView(Context context, AttributeSet attributeSet) {
        e.i(context, "context");
        e.i(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public RadarStateChooseView(Context context, AttributeSet attributeSet, int i) {
        e.i(context, "context");
        e.i(attributeSet, "attrs");
        super(context, attributeSet, i);
    }

    final void bmt() {
        switch (e.pDt[this.pEx.ordinal()]) {
            case 1:
                setVisibility(4);
                return;
            case 2:
                setBackgroundResource(com.tencent.mm.plugin.radar.a.e.pBP);
                setVisibility(0);
                return;
            default:
                setVisibility(4);
                return;
        }
    }
}
