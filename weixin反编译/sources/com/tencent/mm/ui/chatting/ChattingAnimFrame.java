package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ay.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class ChattingAnimFrame extends FrameLayout {
    private static String lBx = "";
    private int kku;
    private int kkv;
    private int mScreenHeight = com.tencent.mm.bu.a.eC(getContext());
    private int xru = 40;
    List<MMAnimateView> yzO = new ArrayList();
    private int yzP = 30;
    private int yzQ = 30;
    private boolean yzR = false;
    private int yzS = 0;
    private ArrayList<Integer> yzT = new ArrayList();

    class a implements AnimationListener {
        a() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    private class b extends Animation {
        private int hX = 0;
        private float kGM;
        private float kGN;
        private float kGO;
        private float kGP;
        private float kGQ;
        private float kGR;
        private OnLayoutChangeListener xOL = new OnLayoutChangeListener() {
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                b.this.asp();
            }
        };
        private boolean yAa = false;
        private float yzV;
        private float yzW;
        private float yzX;
        private float yzY;
        private int yzZ = 0;

        public b(int i, int i2) {
            this.yzZ = i;
            this.hX = i2;
            this.yAa = false;
        }

        public b(int i, int i2, boolean z) {
            this.yzZ = i;
            this.hX = i2;
            this.yAa = z;
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            switch (this.yzZ) {
                case 1:
                    this.yzV = ChattingAnimFrame.s(0.1f, 0.9f);
                    this.yzW = ChattingAnimFrame.s(this.yzV - 0.25f, this.yzV + 0.25f);
                    this.yzX = 1.5f;
                    this.yzY = -0.2f;
                    setInterpolator(new LinearInterpolator());
                    break;
                case 2:
                    this.yzV = 0.0f;
                    this.yzW = 0.0f;
                    this.yzX = 0.0f;
                    this.yzY = 1.0f;
                    setInterpolator(new com.tencent.mm.ui.c.a.a());
                    break;
                case 3:
                    this.yzV = 0.0f;
                    this.yzW = 0.0f;
                    this.yzX = 1.5f;
                    if (this.yAa) {
                        this.yzY = ChattingAnimFrame.s(0.4f, 0.55f);
                    } else {
                        this.yzY = ChattingAnimFrame.s(0.54999995f, 0.85f);
                    }
                    setInterpolator(new com.tencent.mm.ui.c.a.b());
                    break;
                case 999:
                    this.yzV = ChattingAnimFrame.s(0.1f, 0.9f);
                    this.yzW = ChattingAnimFrame.s(this.yzV - 0.5f, this.yzV + 0.5f);
                    this.yzX = 0.0f;
                    this.yzY = 0.0f;
                    this.kGM = 0.8f;
                    this.kGN = 1.1f;
                    setInterpolator(new LinearInterpolator());
                    break;
                default:
                    this.yzV = ChattingAnimFrame.s(0.1f, 0.9f);
                    this.yzW = ChattingAnimFrame.s(this.yzV - 0.5f, this.yzV + 0.5f);
                    this.yzX = -0.2f;
                    this.yzY = 1.2f;
                    setInterpolator(new LinearInterpolator());
                    break;
            }
            if (!(this.yzZ == 0 || this.yzZ == 1)) {
                ChattingAnimFrame.this.addOnLayoutChangeListener(this.xOL);
            }
            asp();
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.kGO;
            float f3 = this.kGQ;
            if (this.kGO != this.kGP) {
                f2 = this.kGO + ((this.kGP - this.kGO) * f);
            }
            if (this.kGQ != this.kGR) {
                f3 = this.kGQ + ((this.kGR - this.kGQ) * f);
                if (this.yzZ == 2) {
                    f3 -= (float) this.hX;
                }
            }
            transformation.getMatrix().setTranslate(f2, f3);
            if (this.kGM != this.kGN && 3 == this.yzZ) {
                f2 = this.kGM + ((this.kGN - this.kGM) * f);
                transformation.getMatrix().postScale(f2, f2);
            }
        }

        protected final void finalize() {
            super.finalize();
            x.i("MicroMsg.ChattingAnimFrame", "finalize!");
            ChattingAnimFrame.this.removeOnLayoutChangeListener(this.xOL);
        }

        public final void asp() {
            this.kGO = this.yzV * ((float) ChattingAnimFrame.this.kku);
            this.kGP = this.yzW * ((float) ChattingAnimFrame.this.kku);
            if (this.yzZ == 2) {
                this.kGQ = this.yzX * ((float) ChattingAnimFrame.this.kkv);
                this.kGR = this.yzY * ((float) ChattingAnimFrame.this.kkv);
            } else if (this.yzZ == 3) {
                this.kGQ = this.yzX * ((float) ChattingAnimFrame.this.mScreenHeight);
                this.kGR = this.yzY * ((float) ChattingAnimFrame.this.mScreenHeight);
                if (ChattingAnimFrame.this.yzR) {
                    this.kGQ = (this.yzX * ((float) ChattingAnimFrame.this.mScreenHeight)) - ((float) ChattingAnimFrame.this.yzS);
                    this.kGR = (this.yzY * ((float) ChattingAnimFrame.this.mScreenHeight)) - ((float) ChattingAnimFrame.this.yzS);
                }
                if (this.kGR < 0.0f) {
                    this.kGR = 0.0f;
                }
            } else {
                this.kGQ = this.yzX * ((float) ChattingAnimFrame.this.mScreenHeight);
                this.kGR = this.yzY * ((float) ChattingAnimFrame.this.mScreenHeight);
            }
        }
    }

    class c extends AnimationSet {
        int hX;
        private long yAc;
        MMAnimateView yAd;

        static /* synthetic */ void a(c cVar) {
            cVar.setStartOffset(cVar.yAc);
            cVar.start();
        }

        public c(int i, int i2, long j, boolean z) {
            super(false);
            this.hX = i2;
            switch (i) {
                case 0:
                case 1:
                    addAnimation(new b(i, this.hX));
                    break;
                case 2:
                    addAnimation(new b(999, this.hX));
                    addAnimation(new b(i, this.hX));
                    break;
                case 3:
                    addAnimation(new b(i, this.hX, z));
                    addAnimation(new b(999, this.hX));
                    break;
                default:
                    addAnimation(new b(0, this.hX));
                    break;
            }
            setAnimationListener(new a(ChattingAnimFrame.this) {
                public final void onAnimationEnd(Animation animation) {
                    c cVar = c.this;
                    if (cVar.yAd != null) {
                        cVar.yAd.post(new Runnable() {
                            public final void run() {
                                if (c.this.yAd != null) {
                                    c.this.yAd.clearAnimation();
                                    ChattingAnimFrame chattingAnimFrame = ChattingAnimFrame.this;
                                    MMAnimateView mMAnimateView = c.this.yAd;
                                    if (mMAnimateView != null && chattingAnimFrame.yzO != null) {
                                        chattingAnimFrame.yzO.remove(mMAnimateView);
                                        mMAnimateView.recycle();
                                        if (chattingAnimFrame.yzO.isEmpty()) {
                                            mMAnimateView.setLayerType(0, null);
                                            chattingAnimFrame.removeAllViews();
                                            return;
                                        }
                                        mMAnimateView.setVisibility(4);
                                        mMAnimateView.setLayerType(0, null);
                                    }
                                }
                            }
                        });
                    } else {
                        x.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
                    }
                }
            });
            this.yAc = 500 + j;
            reset();
            setDuration(ChattingAnimFrame.FK(i));
        }
    }

    static /* synthetic */ long FK(int i) {
        switch (i) {
            case 2:
                return 1200;
            case 3:
                return 1500;
            default:
                return (long) ((int) s(4000.0f, 6000.0f));
        }
    }

    public ChattingAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.kkv = getMeasuredHeight();
        this.kku = getMeasuredWidth();
        x.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", Integer.valueOf(this.kku), Integer.valueOf(this.kkv));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.kkv = i4 - i2;
        this.kku = i3 - i;
        if (this.kkv < this.mScreenHeight) {
            this.yzR = true;
            this.yzS = this.mScreenHeight - this.kkv;
        } else {
            this.yzR = false;
            this.yzS = 0;
        }
        x.d("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", Integer.valueOf(this.kku), Integer.valueOf(this.kkv), Boolean.valueOf(this.yzR), Integer.valueOf(this.yzS));
    }

    public final void a(d dVar) {
        stop();
        if (dVar == null) {
            x.w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (bi.oN(lBx)) {
            lBx = e.hbw.replace("/data/user/0", "/data/data");
            lBx += "/emoji";
        }
        String stringBuilder2 = stringBuilder.append(lBx).append("/egg/").append(dVar.hLi).toString();
        if (com.tencent.mm.a.e.bO(stringBuilder2)) {
            setVisibility(0);
            if (dVar.hLk > 0) {
                this.yzP = dVar.hLk;
                if (this.yzP > 60) {
                    this.yzP = 60;
                }
            } else {
                this.yzP = 30;
            }
            if (dVar.hLl > 0) {
                this.yzQ = dVar.hLl;
            } else {
                this.yzQ = 30;
            }
            if (dVar.maxSize > 0) {
                this.xru = dVar.maxSize;
            } else {
                this.xru = 40;
            }
            x.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", Integer.valueOf(this.yzP), Integer.valueOf(this.yzQ), Integer.valueOf(this.xru), Integer.valueOf(dVar.hLj), Integer.valueOf(dVar.hLe));
            long j = 0;
            FJ(this.yzP);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.yzP) {
                    int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(getContext(), (int) s((float) this.yzQ, (float) this.xru));
                    int i3 = dVar.hLj;
                    boolean z = this.yzT != null && this.yzT.contains(Integer.valueOf(i2));
                    Animation cVar = new c(i3, fromDPToPix, j, z);
                    View mMAnimateView = new MMAnimateView(getContext());
                    mMAnimateView.CV(stringBuilder2);
                    mMAnimateView.setAnimation(cVar);
                    mMAnimateView.setLayerType(2, null);
                    cVar.yAd = mMAnimateView;
                    mMAnimateView.setLayoutParams(new LayoutParams(cVar.hX, cVar.hX));
                    this.yzO.add(mMAnimateView);
                    addView(mMAnimateView);
                    i = dVar.hLj;
                    int i4 = this.yzP;
                    switch (i) {
                        case 2:
                            j = i2 < 2 ? 800 + j : ((long) (((Math.abs((((double) i2) - (((double) i4) * 0.5d)) - 5.0d) / ((double) (i4 * 3))) + 0.01d) * 1000.0d)) + j;
                            break;
                        case 3:
                            j += (long) (((Math.abs((((double) i2) - (((double) i4) * 0.5d)) - 5.0d) / ((double) (i4 * 6))) + 0.06d) * 1000.0d);
                            break;
                        default:
                            j = (long) ((int) (s(0.0f, 4.0f) * 1000.0f));
                            break;
                    }
                    i = i2 + 1;
                } else if (this.yzO != null) {
                    for (View view : this.yzO) {
                        if (view != null && (view.getAnimation() instanceof c)) {
                            c.a((c) view.getAnimation());
                        }
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        x.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
    }

    private void FJ(int i) {
        if (i <= 0) {
            x.w("MicroMsg.ChattingAnimFrame", "count is zero.");
            return;
        }
        int i2 = (int) (((double) i) * 0.1d);
        if (this.yzT != null) {
            this.yzT.clear();
        } else {
            this.yzT = new ArrayList();
        }
        while (this.yzT.size() < i2) {
            int s = (int) s(0.0f, (float) i);
            if (!this.yzT.contains(Integer.valueOf(s))) {
                this.yzT.add(Integer.valueOf(s));
            }
        }
    }

    public final void stop() {
        for (MMAnimateView mMAnimateView : this.yzO) {
            mMAnimateView.clearAnimation();
            mMAnimateView.recycle();
        }
        removeAllViews();
    }

    static float s(float f, float f2) {
        return (((float) Math.random()) * (f2 - f)) + f;
    }
}
