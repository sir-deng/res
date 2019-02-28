package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.blf;

public final class bh {
    Context mContext;
    int qVg = -1;
    LinearLayout rFE;
    LinearLayout rFF;
    SnsCommentShowAbLayout rSN = null;
    private av rfY;
    FrameLayout rft;

    class a {
        View qUh = null;
        String rfN;

        public a(String str, View view) {
            this.rfN = str;
            this.qUh = view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.bh$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ View rSO;
        final /* synthetic */ View zS;

        AnonymousClass1(View view, View view2) {
            this.zS = view;
            this.rSO = view2;
        }

        public final void run() {
            bh.a(bh.this, this.zS, this.rSO);
        }
    }

    static /* synthetic */ void a(bh bhVar, View view, View view2) {
        c cVar = (c) view.getTag();
        m LR = ae.bwf().LR(cVar.fsC);
        if (LR != null) {
            b ix = b.ix(740);
            blf n = ai.n(LR);
            ix.mF(i.g(LR)).iA(LR.field_type).bW(LR.xD(32)).mF(LR.bzk()).mF(LR.field_userName).iA(n == null ? 0 : n.wUP).iA(n == null ? 0 : n.wUS);
            ix.SE();
        }
        view2.setVisibility(0);
        view2.startAnimation(bhVar.rfY.rFC);
        bhVar.rFE = (LinearLayout) view2.findViewById(f.qGO);
        bhVar.rFE.setOnClickListener(bhVar.rfY.rfs.rVy);
        bhVar.rFE.setOnTouchListener(bhVar.rfY.ryR);
        bhVar.rFF = (LinearLayout) view2.findViewById(f.qHg);
        bhVar.rFF.setOnClickListener(bhVar.rfY.rfs.rVz);
        bhVar.rFF.setOnTouchListener(bhVar.rfY.ryR);
        bhVar.rFF.setTag(cVar);
        bhVar.rFE.setTag(cVar);
        ImageView imageView = (ImageView) bhVar.rFF.findViewById(f.qHf);
        ImageView imageView2 = (ImageView) bhVar.rFE.findViewById(f.qGG);
        TextView textView = (TextView) bhVar.rFF.findViewById(f.qHh);
        TextView textView2 = (TextView) bhVar.rFE.findViewById(f.qGP);
        if (u.Mn(cVar.fAR)) {
            bhVar.rFE.setEnabled(false);
            bhVar.rFF.setEnabled(false);
            textView2.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEB));
            if (cVar.kZv == 11) {
                imageView.setImageResource(com.tencent.mm.plugin.sns.i.i.qOI);
                imageView2.setImageResource(com.tencent.mm.plugin.sns.i.i.qOL);
            } else {
                imageView.setImageResource(com.tencent.mm.plugin.sns.i.i.qOK);
                imageView2.setImageResource(com.tencent.mm.plugin.sns.i.i.qOM);
            }
            textView.setText(bhVar.mContext.getString(j.qRA));
            textView.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEB));
        } else {
            bhVar.rFE.setEnabled(true);
            if (cVar.kZv == 11) {
                imageView.setImageResource(e.qFo);
                imageView2.setImageResource(e.qFp);
                textView.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEC));
                textView2.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEC));
            } else {
                imageView.setImageResource(e.qFg);
                textView.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
                textView2.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
            }
            bhVar.rFF.setEnabled(true);
            if (cVar.rTH == 0) {
                textView.setText(bhVar.mContext.getString(j.qRA));
            } else {
                textView.setText(bhVar.mContext.getString(j.qRa));
            }
        }
        if (cVar.kZv == 11) {
            bhVar.rFF.setBackgroundResource(e.qFq);
            bhVar.rFE.setBackgroundResource(e.qFr);
        }
    }

    public bh(Context context, av avVar, FrameLayout frameLayout) {
        this.mContext = context;
        this.rfY = avVar;
        this.rft = frameLayout;
    }

    final void cJ(final View view) {
        view.clearAnimation();
        view.startAnimation(this.rfY.rFD);
        this.rfY.rFD.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (view != null) {
                    view.setVisibility(8);
                    bh.this.bAb();
                }
            }
        });
    }

    public final boolean bAb() {
        if (this.rSN == null) {
            return false;
        }
        this.rft.removeView(this.rSN);
        this.rSN = null;
        return true;
    }
}
