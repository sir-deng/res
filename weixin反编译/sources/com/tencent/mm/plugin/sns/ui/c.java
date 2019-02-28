package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.b.b;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;

public final class c {
    private Context mContext;
    private int qVg = -1;
    private b rfs;
    private FrameLayout rft;
    AbsoluteLayout rfu = null;
    protected Animation rfv;
    protected Animation rfw;
    boolean rfx = false;
    private com.tencent.mm.plugin.sns.f.b rwf;
    TextView rwg;
    ListView rwh;
    View rwi;

    class a {
        View qUh = null;
        String rfN;

        public a(String str, View view) {
            this.rfN = str;
            this.qUh = view;
        }
    }

    static /* synthetic */ void a(c cVar, View view, View view2) {
        boolean z;
        com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
        view2.setVisibility(0);
        cVar.rfx = true;
        cVar.rfv.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                c.this.rfx = true;
            }

            public final void onAnimationEnd(Animation animation) {
                c.this.rfx = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view2.startAnimation(cVar.rfv);
        cVar.rwg = (TextView) view2.findViewById(f.qGw);
        cVar.rwg.setOnClickListener(cVar.rfs.rVD);
        cVar.rwg.setOnTouchListener(bi.chk());
        cVar.rwg.setTag(bVar);
        if (bVar.qWL == null || bVar.qWL.rSp == null) {
            z = false;
        } else {
            com.tencent.mm.plugin.sns.storage.a aVar = bVar.qWL.rSq;
            String eM = w.eM(ad.getContext());
            CharSequence charSequence = "zh_CN".equals(eM) ? aVar.rkk : ("zh_TW".equals(eM) || "zh_HK".equals(eM)) ? aVar.rkm : aVar.rkl;
            if (!bi.oN(charSequence)) {
                cVar.rwg.setText(charSequence);
            }
            z = aVar.rkn;
        }
        cVar.rwh = (ListView) view2.findViewById(f.qGs);
        cVar.rwh.setAdapter(new d(cVar.mContext, (com.tencent.mm.plugin.sns.data.b) view.getTag()));
        cVar.rwh.setOnItemClickListener(cVar.rfs.rVU);
        if (z) {
            cVar.rwg.setClickable(false);
            cVar.rwg.setTextColor(Color.parseColor("#3a3a3a"));
        } else {
            cVar.rwg.setClickable(true);
            cVar.rwg.setTextColor(Color.parseColor("#576B95"));
        }
        cVar.rwi = view2;
    }

    public c(Context context, b bVar, FrameLayout frameLayout, com.tencent.mm.plugin.sns.f.b bVar2) {
        this.mContext = context;
        this.rwf = bVar2;
        this.rfs = bVar;
        this.rft = frameLayout;
        this.rfv = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rfv = AnimationUtils.loadAnimation(context, com.tencent.mm.plugin.sns.i.a.qEs);
        this.rfw = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.rfw = AnimationUtils.loadAnimation(context, com.tencent.mm.plugin.sns.i.a.qEt);
    }

    public final boolean cA(final View view) {
        if (ae.bvX().bwX() && this.rwf != null) {
            int cx = this.rwf.cx(view);
            if (cx == 0 || cx == 1) {
                return true;
            }
            x.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
        }
        if (this.rfx) {
            return false;
        }
        if (this.rfu != null) {
            if (this.rfu.getTag() instanceof a) {
                final View view2 = ((a) this.rfu.getTag()).qUh;
                this.rfx = true;
                view2.startAnimation(this.rfw);
                this.rfw.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                        c.this.rfx = true;
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        if (view2 != null) {
                            view2.clearAnimation();
                            view2.setVisibility(8);
                            c.this.bwW();
                        }
                        c.this.rfx = false;
                    }
                });
            } else {
                bwW();
            }
            return false;
        } else if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
            return false;
        } else {
            com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
            String str = bVar.fsC;
            this.rfu = new AbsoluteLayout(this.mContext);
            this.rfu.setId(f.dag);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.rft.addView(this.rfu);
            int b = BackwardSupportUtil.b.b(this.mContext, 150.0f);
            int b2 = BackwardSupportUtil.b.b(this.mContext, 17.0f);
            BackwardSupportUtil.b.b(this.mContext, 40.0f);
            final View inflate = v.fw(this.mContext).inflate(g.qMt, null);
            TextView textView = (TextView) inflate.findViewById(f.qGv);
            String eM = w.eM(ad.getContext());
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.qWL.rSp;
            if (bVar2 != null) {
                CharSequence charSequence;
                if ("zh_CN".equals(eM)) {
                    charSequence = bVar2.rkP;
                } else if ("zh_TW".equals(eM) || "zh_HK".equals(eM)) {
                    charSequence = bVar2.rkR;
                } else {
                    charSequence = bVar2.rkQ;
                }
                if (!bi.oN(charSequence)) {
                    textView.setText(charSequence);
                }
            }
            Rect rect = new Rect();
            int eb = e.eb(this.mContext);
            int[] bCT = bVar.qWL.bCT();
            x.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + bCT[0] + "  " + bCT[1] + " height: " + eb);
            this.qVg = e.ec(this.mContext);
            ViewGroup.LayoutParams layoutParams2 = new AbsoluteLayout.LayoutParams(-2, -2, bCT[0] - b, ((bCT[1] - this.qVg) - eb) + b2);
            this.rfu.setTag(new a(str, inflate));
            this.rfu.addView(inflate, layoutParams2);
            inflate.setVisibility(8);
            this.rfx = true;
            new ag().post(new Runnable() {
                public final void run() {
                    c.a(c.this, view, inflate);
                }
            });
            return true;
        }
    }

    public final boolean bwW() {
        if (this.rwf != null && ae.bvX().bwX()) {
            this.rwf.bwW();
        }
        if (this.rfu != null) {
            this.rft.removeView(this.rfu);
            this.rfu = null;
            return true;
        }
        this.rfx = false;
        this.rwh = null;
        this.rwi = null;
        return false;
    }

    public final boolean bzC() {
        final int height = this.rwg.getHeight();
        this.rwg.setVisibility(8);
        View view = null;
        int i = 0;
        for (int i2 = 0; i2 < this.rwh.getAdapter().getCount(); i2++) {
            view = this.rwh.getAdapter().getView(i2, view, null);
            view.measure(this.rwi.getWidth(), -2);
            i += view.getMeasuredHeight();
        }
        ((RelativeLayout.LayoutParams) this.rwh.getLayoutParams()).bottomMargin = height - i;
        this.rwh.setVisibility(0);
        Animation anonymousClass4 = new Animation() {
            protected final void applyTransformation(float f, Transformation transformation) {
                ((RelativeLayout.LayoutParams) c.this.rwh.getLayoutParams()).bottomMargin = f == 1.0f ? 0 : (int) (((float) (height - i)) * (1.0f - f));
                c.this.rwh.requestLayout();
            }

            public final boolean willChangeBounds() {
                return true;
            }
        };
        anonymousClass4.setDuration(250);
        this.rwh.startAnimation(anonymousClass4);
        return true;
    }
}
