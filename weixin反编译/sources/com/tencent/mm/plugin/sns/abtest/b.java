package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;

public final class b {
    int MP = 0;
    int jSO = 0;
    int mScreenHeight = 0;
    c qTC;
    NotInterestMenu qTH;
    ViewGroup qTI;
    com.tencent.mm.plugin.sns.abtest.NotInterestMenu.b qTJ = new com.tencent.mm.plugin.sns.abtest.NotInterestMenu.b() {
        public final void buC() {
            b.this.buD();
        }
    };
    Animation qTK = null;
    Animation qTL = null;
    private Animation qTM = null;
    private Animation qTN = null;
    int qTO = 0;
    int qTP = 0;
    int qTQ = 0;
    int qTR = 0;
    int qTS = 0;
    boolean qTT = false;
    AbsoluteLayout qTU = null;
    boolean qTV = false;
    boolean qTW = false;

    public b(ViewGroup viewGroup) {
        this.qTI = viewGroup;
        this.qTK = AnimationUtils.loadAnimation(ad.getContext(), a.qEs);
        this.qTK.setFillAfter(true);
        this.qTK.setDuration(100);
        this.qTK.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                b.this.qTV = true;
            }

            public final void onAnimationEnd(Animation animation) {
                if (b.this.qTH != null) {
                    b.this.qTH.setVisibility(0);
                }
                b.this.qTV = false;
                b.this.qTT = true;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.qTL = AnimationUtils.loadAnimation(ad.getContext(), a.qEv);
        this.qTL.setFillAfter(true);
        this.qTL.setDuration(100);
        this.qTL.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                b.this.qTV = true;
            }

            public final void onAnimationEnd(Animation animation) {
                if (b.this.qTH != null) {
                    b.this.qTH.setVisibility(0);
                }
                b.this.qTV = false;
                b.this.qTT = true;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.qTM = AnimationUtils.loadAnimation(ad.getContext(), a.qEt);
        this.qTM.setFillAfter(true);
        this.qTM.setDuration(100);
        this.qTM.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                b.this.qTV = true;
            }

            public final void onAnimationEnd(Animation animation) {
                ah.y(new Runnable() {
                    public final void run() {
                        b.this.buD();
                    }
                });
                b.this.qTV = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.qTN = AnimationUtils.loadAnimation(ad.getContext(), a.qEu);
        this.qTN.setFillAfter(true);
        this.qTN.setDuration(100);
        this.qTN.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                b.this.qTV = true;
            }

            public final void onAnimationEnd(Animation animation) {
                ah.y(new Runnable() {
                    public final void run() {
                        b.this.buD();
                    }
                });
                b.this.qTV = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public final void buD() {
        if (this.qTU != null && this.qTI != null && this.qTH != null) {
            this.qTU.removeView(this.qTH);
            this.qTI.removeView(this.qTU);
            this.qTU = null;
            this.qTH = null;
            this.qTT = false;
        }
    }
}
