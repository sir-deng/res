package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Array;
import java.util.Arrays;

public class a {
    protected boolean isAnimating;
    protected View kIZ;
    protected int oND;
    protected int tKF;
    protected int tKG;
    protected int tKH;
    protected int tKI;
    protected View tKJ;
    protected View tKK;
    protected View tKL;
    protected View tKM;
    protected View tKN;
    protected View tKO;
    protected View tKP;
    protected View tKQ;
    protected float[][] tKR;
    protected int tKS = b.tLc;
    protected a tKT;
    protected AnimatorUpdateListener tKU = new AnimatorUpdateListener() {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = ((a.this.tKR[0][1] - a.this.tKR[0][0]) * floatValue) + a.this.tKR[0][0];
            a.this.tKJ.setX(((a.this.tKR[1][1] - a.this.tKR[1][0]) * floatValue) + a.this.tKR[1][0]);
            a.this.tKJ.setY(f);
            if (a.this.bUK()) {
                a.this.tKJ.setPadding((int) ((((float) (a.this.tKI - a.this.tKH)) * floatValue) + ((float) a.this.tKH)), 0, 0, 0);
            }
            LayoutParams layoutParams = (LayoutParams) a.this.tKJ.getLayoutParams();
            int i = (int) ((1.0f - floatValue) * ((float) a.this.tKF));
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            layoutParams.width = ((a.this.tKF - i) * 2) + ((int) a.this.tKR[2][0]);
            a.this.tKJ.setLayoutParams(layoutParams);
        }
    };
    protected AnimatorUpdateListener tKV = new AnimatorUpdateListener() {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.tKJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            a.this.tKJ.setX(a.this.tKR[1][1]);
            a.this.tKJ.setY(a.this.tKR[0][1]);
            if (a.this.bUK()) {
                a.this.tKJ.setPadding(a.this.tKI, 0, 0, 0);
            }
            LayoutParams layoutParams = (LayoutParams) a.this.tKJ.getLayoutParams();
            if (layoutParams.leftMargin != 0) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.width = ((int) a.this.tKR[2][0]) + (a.this.tKF * 2);
                a.this.tKJ.setLayoutParams(layoutParams);
            }
        }
    };
    protected AnimatorUpdateListener tKW = new AnimatorUpdateListener() {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = ((a.this.tKR[0][0] - a.this.tKR[0][1]) * floatValue) + a.this.tKR[0][1];
            a.this.tKJ.setX(((a.this.tKR[1][0] - a.this.tKR[1][1]) * floatValue) + a.this.tKR[1][1]);
            a.this.tKJ.setY(f);
            if (a.this.bUK()) {
                a.this.tKJ.setPadding((int) ((((float) (a.this.tKH - a.this.tKI)) * floatValue) + ((float) a.this.tKI)), 0, 0, 0);
            }
            LayoutParams layoutParams = (LayoutParams) a.this.tKJ.getLayoutParams();
            int i = (int) (floatValue * ((float) a.this.tKF));
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            layoutParams.width = ((a.this.tKF - i) * 2) + ((int) a.this.tKR[2][0]);
            a.this.tKJ.setLayoutParams(layoutParams);
        }
    };
    protected AnimatorUpdateListener tKX = new AnimatorUpdateListener() {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (((double) Math.abs(floatValue - 1.0f)) <= 0.001d) {
                a.this.tKJ.setX(a.this.tKR[1][0]);
                a.this.tKJ.setY(a.this.tKR[0][0]);
                if (a.this.bUK()) {
                    a.this.tKJ.setPadding(0, 0, 0, 0);
                }
                LayoutParams layoutParams = (LayoutParams) a.this.tKJ.getLayoutParams();
                layoutParams.leftMargin = a.this.tKF;
                layoutParams.rightMargin = a.this.tKF;
                layoutParams.width = (int) a.this.tKR[2][0];
                a.this.tKJ.setLayoutParams(layoutParams);
                a.this.tKJ.setAlpha(1.0f);
                return;
            }
            a.this.tKJ.setAlpha(1.0f - floatValue);
        }
    };

    public enum b {
        ;

        public static int[] bUL() {
            return (int[]) tLe.clone();
        }

        static {
            tLc = 1;
            tLd = 2;
            tLe = new int[]{tLc, tLd};
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.a$7 */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] tLb = new int[b.bUL().length];

        static {
            try {
                tLb[b.tLc - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                tLb[b.tLd - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public interface a {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public a(Context context, final View view, View view2, View view3, View view4, View view5, View view6, View view7, final View view8, View view9) {
        this.tKF = com.tencent.mm.bu.a.fromDPToPix(context, 48) / 2;
        this.oND = (int) context.getResources().getDimension(R.f.byd);
        this.tKR = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 2});
        this.tKJ = view;
        this.tKK = view2;
        this.tKL = view3;
        this.tKM = view4;
        this.tKN = view5;
        this.kIZ = view6;
        this.tKO = view7;
        this.tKP = view8;
        this.tKQ = view9;
        this.tKJ.post(new Runnable() {
            public final void run() {
                a.this.tKR[0][0] = view.getY();
                a.this.tKR[0][1] = 0.0f;
                a.this.tKR[1][0] = view.getX();
                a.this.tKR[1][1] = 0.0f;
                a.this.tKR[2][0] = (float) view.getMeasuredWidth();
                a.this.tKR[2][1] = (float) (view.getMeasuredWidth() + (a.this.tKF * 2));
                x.i("MicroMsg.FTS.SosAnimatorBaseController", "searchBarData %s", Arrays.toString(a.this.tKR));
            }
        });
        this.tKP.post(new Runnable() {
            public final void run() {
                a.this.tKG = view8.getMeasuredHeight();
            }
        });
    }

    public final void Bl(int i) {
        this.tKR[0][0] = (float) i;
    }

    public final void Bm(int i) {
        this.tKS = i;
    }

    public void Bn(int i) {
        if (i != this.tKS) {
            switch (AnonymousClass7.tLb[i - 1]) {
                case 1:
                    bUI();
                    break;
                case 2:
                    bUJ();
                    break;
            }
            this.tKS = i;
        }
    }

    protected void bUI() {
    }

    protected void bUJ() {
    }

    public final void a(a aVar) {
        this.tKT = aVar;
    }

    protected boolean bUK() {
        return true;
    }
}
