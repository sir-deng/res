package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.ah.a.e;
import com.tencent.mm.plugin.ah.a.f;
import com.tencent.mm.plugin.ah.a.g;
import com.tencent.mm.sdk.platformtools.x;

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar extends RelativeLayout implements a {
    private View contentView = null;
    public boolean fwB = false;
    private boolean ktS = false;
    private int mPosition = 0;
    private int qAA = -1;
    private int qAB = -1;
    public b qAn = null;
    private ImageView qAo;
    private ImageView qAp = null;
    private ImageView qAq = null;
    private ImageView qAr = null;
    private TextView qAs;
    private TextView qAt;
    public int qAu = 0;
    private int qAv = 0;
    private float qAx = 0.0f;
    private int qAy = -1;
    private int qAz = -1;

    static /* synthetic */ int a(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar, int i) {
        int width = ((snsAdNativeLandingPagesVideoPlayerLoadingBar.qAq.getWidth() - snsAdNativeLandingPagesVideoPlayerLoadingBar.qAq.getPaddingLeft()) - snsAdNativeLandingPagesVideoPlayerLoadingBar.qAq.getPaddingRight()) / 2;
        LayoutParams layoutParams = (LayoutParams) snsAdNativeLandingPagesVideoPlayerLoadingBar.qAp.getLayoutParams();
        if (i < (layoutParams.leftMargin - snsAdNativeLandingPagesVideoPlayerLoadingBar.qAq.getPaddingLeft()) - width) {
            return (layoutParams.leftMargin - snsAdNativeLandingPagesVideoPlayerLoadingBar.qAq.getPaddingLeft()) - width;
        }
        return i > snsAdNativeLandingPagesVideoPlayerLoadingBar.btI() ? snsAdNativeLandingPagesVideoPlayerLoadingBar.btI() - width : i - width;
    }

    static /* synthetic */ int d(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar) {
        int paddingLeft = (int) (((((double) (((LayoutParams) snsAdNativeLandingPagesVideoPlayerLoadingBar.qAq.getLayoutParams()).leftMargin - (((LayoutParams) snsAdNativeLandingPagesVideoPlayerLoadingBar.qAp.getLayoutParams()).leftMargin - snsAdNativeLandingPagesVideoPlayerLoadingBar.qAq.getPaddingLeft()))) * 1.0d) / ((double) snsAdNativeLandingPagesVideoPlayerLoadingBar.btI())) * ((double) snsAdNativeLandingPagesVideoPlayerLoadingBar.qAu));
        return paddingLeft < 0 ? 0 : paddingLeft;
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context) {
        super(context);
        init();
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void a(b bVar) {
        this.qAn = bVar;
    }

    private void init() {
        this.contentView = View.inflate(getContext(), f.sjD, this);
        this.qAo = (ImageView) this.contentView.findViewById(e.pji);
        this.qAp = (ImageView) this.contentView.findViewById(e.pjh);
        this.qAq = (ImageView) this.contentView.findViewById(e.pjj);
        this.qAr = (ImageView) this.contentView.findViewById(e.cCK);
        this.qAs = (TextView) this.contentView.findViewById(e.pjf);
        this.qAt = (TextView) this.contentView.findViewById(e.pjg);
        this.qAq.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    x.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "ontouch down");
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ktS = false;
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qAx = motionEvent.getX();
                    if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qAn != null) {
                        SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qAn.ahn();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    LayoutParams layoutParams = (LayoutParams) SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qAq.getLayoutParams();
                    layoutParams.leftMargin = SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, ((int) (x - SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qAx)) + layoutParams.leftMargin);
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qAq.setLayoutParams(layoutParams);
                    int d = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this);
                    if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qAu > 0) {
                        layoutParams = (LayoutParams) SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qAo.getLayoutParams();
                        layoutParams.width = (int) (((((double) d) * 1.0d) / ((double) SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qAu)) * ((double) SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.btI()));
                        SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qAo.setLayoutParams(layoutParams);
                    }
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qAs.setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.kJ(d / 60) + ":" + SnsAdNativeLandingPagesVideoPlayerLoadingBar.kJ(d % 60));
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ktS = true;
                } else if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ktS) {
                    int d2 = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this);
                    if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qAn != null) {
                        x.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : " + d2);
                        SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.qAn.kK(d2);
                    }
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ktS = false;
                }
                return true;
            }
        });
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!(i == this.qAy && i2 == this.qAz && i3 == this.qAA && i4 == this.qAB)) {
            ahu();
        }
        this.qAy = i;
        this.qAz = i2;
        this.qAA = i3;
        this.qAB = i4;
    }

    public final void h(OnClickListener onClickListener) {
        this.qAr.setOnClickListener(onClickListener);
    }

    public final void dd(boolean z) {
        this.fwB = z;
        if (z) {
            this.qAr.setImageResource(g.pjm);
        } else {
            this.qAr.setImageResource(g.pjn);
        }
    }

    public final void seek(int i) {
        this.mPosition = i;
        ahu();
    }

    public final int btG() {
        return this.qAu;
    }

    public final void wD(final int i) {
        if (this.qAq.isShown() && this.qAq.getWidth() == 0) {
            post(new Runnable() {
                public final void run() {
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.wD(i);
                }
            });
            return;
        }
        this.qAu = i;
        this.mPosition = 0;
        this.qAt.setText(kJ(this.qAu / 60) + ":" + kJ(this.qAu % 60));
        ahu();
    }

    private int btI() {
        this.qAv = this.qAp.getWidth();
        return this.qAv;
    }

    public final void btJ() {
        this.qAv = 0;
    }

    private void ahu() {
        if (this.qAu != 0 && !this.ktS && this.qAq != null && btI() != 0) {
            int width = ((this.qAq.getWidth() - this.qAq.getPaddingLeft()) - this.qAq.getPaddingRight()) / 2;
            this.qAs.setText(kJ(this.mPosition / 60) + ":" + kJ(this.mPosition % 60));
            LayoutParams layoutParams = (LayoutParams) this.qAq.getLayoutParams();
            layoutParams.leftMargin = ((((LayoutParams) this.qAp.getLayoutParams()).leftMargin - this.qAq.getPaddingLeft()) + ((int) (((((double) this.mPosition) * 1.0d) / ((double) this.qAu)) * ((double) btI())))) - width;
            this.qAq.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.qAo.getLayoutParams();
            layoutParams.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.qAu)) * ((double) btI()));
            this.qAo.setLayoutParams(layoutParams);
        }
    }

    public static String kJ(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return String.valueOf(i);
    }
}
