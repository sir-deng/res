package com.tencent.mm.plugin.webview.ui.tools;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;

public final class f implements b {
    static final int tEs = R.g.bHR;
    public boolean iQf = false;
    private View tEA;
    View tEB;
    private TextView tEC;
    private boolean tED = true;
    public boolean tEE = false;
    a tEo;
    ImageView tEp;
    LogoWebViewWrapper tEq;
    int tEr = 0;
    private boolean tEt = false;
    private boolean tEu = false;
    private int tEv = 0;
    private float tEw = 0.0f;
    private ValueAnimator tEx;
    private ViewPropertyAnimator tEy;
    private float tEz;

    public interface a {
        void bTj();
    }

    public final void cU(View view) {
        String str;
        this.tEq = (LogoWebViewWrapper) view.findViewById(R.h.cuC);
        this.tEp = (ImageView) view.findViewById(R.h.cYZ);
        this.tEA = view.findViewById(R.h.cYY);
        if (this.tEA != null) {
            this.tEB = this.tEA.findViewById(R.h.cZY);
            this.tEC = (TextView) this.tEB.findViewById(R.h.daa);
        }
        this.tEr = BackwardSupportUtil.b.b(this.tEq.getContext(), 72.0f);
        String str2 = "MicroMsg.WebViewPullDownLogoDelegate";
        String str3 = "refreshImage.id = %s, logoWrapper.id = %s";
        Object[] objArr = new Object[2];
        if (this.tEp == null) {
            str = "null";
        } else {
            str = String.valueOf(this.tEp.getId());
        }
        objArr[0] = str;
        if (this.tEq == null) {
            str = "null";
        } else {
            str = String.valueOf(this.tEq.getId());
        }
        objArr[1] = str;
        x.d(str2, str3, objArr);
        x.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", Integer.valueOf(this.tEr));
    }

    public final void b(MMWebView mMWebView) {
        mMWebView.zEL = this.tEq;
        mMWebView.czO();
        if (VERSION.SDK_INT <= 10) {
            this.tEq.bST().setBackgroundColor(this.tEq.getResources().getColor(R.e.bui));
        }
        LogoWebViewWrapper logoWebViewWrapper = this.tEq;
        logoWebViewWrapper.bST();
        if (logoWebViewWrapper.tCA != null) {
            logoWebViewWrapper.lhb = mMWebView;
            logoWebViewWrapper.tCA.addView(logoWebViewWrapper.lhb);
        }
        CharSequence charSequence = "";
        if (mMWebView.isXWalkKernel() || mMWebView.isX5Kernel) {
            this.tED = true;
        } else {
            this.tED = false;
        }
        if (!(this.tEB == null || mMWebView.isX5Kernel)) {
            ((ImageView) this.tEB.findViewById(R.h.cZZ)).setVisibility(8);
            ((TextView) this.tEB.findViewById(R.h.cpR)).setText(charSequence);
        }
        if (!this.tED || this.tEE) {
            ky(true);
            return;
        }
        ky(false);
        if (this.tEB != null) {
            this.tEB.setVisibility(0);
        }
    }

    public final void bTh() {
        this.iQf = false;
        stopLoading();
        if (this.tED && this.tEB != null && !this.tEE) {
            ky(false);
            this.tEq.tCI = 0;
            this.tEB.setVisibility(0);
        }
    }

    public final void startLoading() {
        if (!this.tEt && this.tEp != null && this.tEq != null) {
            this.tEt = true;
            this.tEq.ky(true);
            this.tEp.clearAnimation();
            if (this.tEx != null) {
                this.tEx.cancel();
            }
            this.tEx = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[]{this.tEw + 0.0f, this.tEw + 354.0f});
            this.tEx.setDuration(960);
            this.tEx.setRepeatMode(1);
            this.tEx.setRepeatCount(-1);
            this.tEx.setInterpolator(new LinearInterpolator());
            this.tEx.start();
            if (this.tEo != null) {
                this.tEo.bTj();
            }
        }
    }

    public final void stopLoading() {
        if (this.tEt) {
            x.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
            this.tEu = true;
            this.tEt = false;
            if (this.tEq != null && this.iQf) {
                this.tEq.ky(false);
            }
            if (this.tEx != null) {
                this.tEx.cancel();
            }
            if (this.tEq != null) {
                this.tEq.O(0, 250);
            }
            if (this.tEp != null) {
                x.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
                this.tEp.animate().alpha(0.0f).setDuration(500).start();
            }
        }
    }

    public final void release() {
        if (this.tEq != null) {
            LogoWebViewWrapper logoWebViewWrapper = this.tEq;
            if (logoWebViewWrapper.tCA != null) {
                logoWebViewWrapper.tCA.removeView(logoWebViewWrapper.lhb);
                logoWebViewWrapper.lhb = null;
            }
            logoWebViewWrapper = this.tEq;
            logoWebViewWrapper.tCK = null;
            logoWebViewWrapper.tCJ = null;
        }
        if (this.tEA != null) {
            ((ViewGroup) this.tEA).removeAllViews();
        }
        this.tEq = null;
        this.tEp = null;
        this.tEv = 0;
        if (this.tEx != null) {
            this.tEx.cancel();
            this.tEx = null;
        }
    }

    public final void AX(int i) {
        if (this.tEA != null) {
            this.tEA.setBackgroundColor(i);
        }
    }

    public final void bTi() {
        if (this.tEB != null) {
            this.tEB.setVisibility(8);
        }
    }

    public final void T(int i, boolean z) {
        String str;
        String str2 = "MicroMsg.WebViewPullDownLogoDelegate";
        String str3 = "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(z);
        if (this.tEp == null) {
            str = "null";
        } else {
            str = String.valueOf(this.tEp.getVisibility());
        }
        objArr[2] = str;
        if (this.tEp == null) {
            str = "null";
        } else {
            str = this.tEp.getDrawable().toString();
        }
        objArr[3] = str;
        if (this.tEp == null) {
            str = "null";
        } else {
            str = String.valueOf(this.tEp.getAlpha());
        }
        objArr[4] = str;
        x.v(str2, str3, objArr);
        if (this.iQf) {
            if (i == 0) {
                this.tEu = false;
            }
            if (this.tEp != null) {
                if (z) {
                    if (Math.abs(i) >= this.tEr) {
                        if (this.tEq != null) {
                            this.tEq.tCI = this.tEr;
                        }
                    } else if (this.tEq != null) {
                        this.tEq.tCI = 0;
                    }
                } else if (Math.abs(i) > this.tEr && !this.tEt) {
                    x.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
                    startLoading();
                    return;
                } else if (this.tEt) {
                    return;
                }
                if (this.tEp != null && this.tEp.getAlpha() < 1.0f && this.tEy == null && z) {
                    x.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
                    this.tEy = this.tEp.animate().alpha(1.0f).setDuration(500);
                    this.tEy.setListener(new AnimatorListenerAdapter() {
                        public final void onAnimationCancel(Animator animator) {
                            super.onAnimationCancel(animator);
                            f.this.tEy = null;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            f.this.tEy = null;
                        }
                    });
                    this.tEy.start();
                }
                if (!this.tEu) {
                    int i2 = (-i) - this.tEv;
                    if (Math.abs(i) >= this.tEr) {
                        i2 *= 5;
                    } else {
                        i2 *= 2;
                    }
                    this.tEv = -i;
                    float height = ((float) this.tEp.getHeight()) / 2.0f;
                    float width = ((float) this.tEp.getWidth()) / 2.0f;
                    this.tEw -= (float) i2;
                    this.tEp.setScaleType(ScaleType.MATRIX);
                    Matrix imageMatrix = this.tEp.getImageMatrix();
                    imageMatrix.postRotate((float) (-i2), width, height);
                    this.tEp.setImageMatrix(imageMatrix);
                    this.tEp.setImageResource(tEs);
                }
                this.tEp.invalidate();
            }
        }
    }

    public final float getStartLoadingStep() {
        return this.tEz;
    }

    public final void setStartLoadingStep(float f) {
        float f2 = 0.0f;
        this.tEz = f;
        this.tEp.setScaleType(ScaleType.MATRIX);
        Matrix imageMatrix = this.tEp.getImageMatrix();
        float width = this.tEp == null ? 0.0f : ((float) this.tEp.getWidth()) / 2.0f;
        if (this.tEp != null) {
            f2 = ((float) this.tEp.getHeight()) / 2.0f;
        }
        imageMatrix.setRotate(f, width, f2);
        this.tEw = f;
        this.tEp.invalidate();
    }

    public final void ky(boolean z) {
        if (this.tEq != null && this.tEq.tCG != z) {
            this.tEq.ky(z);
            if (this.tEB != null) {
                this.tEB.setVisibility(8);
            }
            this.tEE = z;
        }
    }

    public final void PO(String str) {
        if (!this.tED || this.tEE) {
            ky(true);
            if (this.tEB != null && this.tEB.getVisibility() == 0) {
                this.tEB.setVisibility(8);
            }
        } else if (this.tEC != null) {
            if (!bi.oN(str)) {
                if (!bi.oN(Uri.parse(str).getHost())) {
                    CharSequence string = this.tEC.getContext().getString(R.l.eXn, new Object[]{r0});
                    this.tEC.setVisibility(0);
                    this.tEC.setText(string);
                    ky(false);
                    return;
                }
            }
            this.tEC.setVisibility(8);
        }
    }
}
