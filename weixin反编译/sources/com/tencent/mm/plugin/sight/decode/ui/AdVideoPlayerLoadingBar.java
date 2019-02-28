package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.ab.a.a;
import com.tencent.mm.plugin.ab.a.b;
import com.tencent.mm.plugin.ab.a.c;
import com.tencent.mm.sdk.platformtools.x;

public class AdVideoPlayerLoadingBar extends RelativeLayout implements a {
    public View contentView = null;
    public boolean ktS = false;
    public int mPosition = 0;
    private int qAA = -1;
    private int qAB = -1;
    public b qAn = null;
    public ImageView qAo;
    public ImageView qAp = null;
    public ImageView qAq = null;
    public ImageView qAr = null;
    public TextView qAs;
    public TextView qAt;
    public int qAu = 0;
    private int qAv = 0;
    private int qAw = 0;
    public float qAx = 0.0f;
    private int qAy = -1;
    private int qAz = -1;

    static /* synthetic */ int a(AdVideoPlayerLoadingBar adVideoPlayerLoadingBar, int i) {
        int btK = ((adVideoPlayerLoadingBar.btK() - adVideoPlayerLoadingBar.qAq.getPaddingLeft()) - adVideoPlayerLoadingBar.qAq.getPaddingRight()) / 2;
        LayoutParams layoutParams = (LayoutParams) adVideoPlayerLoadingBar.qAp.getLayoutParams();
        if (i < (layoutParams.leftMargin - adVideoPlayerLoadingBar.qAq.getPaddingLeft()) - btK) {
            return (layoutParams.leftMargin - adVideoPlayerLoadingBar.qAq.getPaddingLeft()) - btK;
        }
        if (i <= ((adVideoPlayerLoadingBar.btI() + layoutParams.leftMargin) - btK) - adVideoPlayerLoadingBar.qAq.getPaddingLeft()) {
            return i;
        }
        return ((layoutParams.leftMargin + adVideoPlayerLoadingBar.btI()) - btK) - adVideoPlayerLoadingBar.qAq.getPaddingLeft();
    }

    public AdVideoPlayerLoadingBar(Context context) {
        super(context);
        init();
    }

    public AdVideoPlayerLoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AdVideoPlayerLoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public int getLayoutId() {
        return b.pjl;
    }

    public final void a(b bVar) {
        this.qAn = bVar;
    }

    public void init() {
        this.contentView = View.inflate(getContext(), getLayoutId(), this);
        this.qAo = (ImageView) this.contentView.findViewById(a.pji);
        this.qAp = (ImageView) this.contentView.findViewById(a.pjh);
        this.qAq = (ImageView) this.contentView.findViewById(a.pjj);
        this.qAr = (ImageView) this.contentView.findViewById(a.cCK);
        this.qAs = (TextView) this.contentView.findViewById(a.pjf);
        this.qAt = (TextView) this.contentView.findViewById(a.pjg);
        this.qAq.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    x.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
                    AdVideoPlayerLoadingBar.this.ktS = false;
                    AdVideoPlayerLoadingBar.this.qAx = motionEvent.getX();
                    if (AdVideoPlayerLoadingBar.this.qAn != null) {
                        AdVideoPlayerLoadingBar.this.qAn.ahn();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    LayoutParams layoutParams = (LayoutParams) AdVideoPlayerLoadingBar.this.qAq.getLayoutParams();
                    layoutParams.leftMargin = AdVideoPlayerLoadingBar.a(AdVideoPlayerLoadingBar.this, ((int) (x - AdVideoPlayerLoadingBar.this.qAx)) + layoutParams.leftMargin);
                    AdVideoPlayerLoadingBar.this.qAq.setLayoutParams(layoutParams);
                    int btF = AdVideoPlayerLoadingBar.this.btF();
                    if (AdVideoPlayerLoadingBar.this.qAu > 0) {
                        layoutParams = (LayoutParams) AdVideoPlayerLoadingBar.this.qAo.getLayoutParams();
                        layoutParams.width = (int) (((((double) btF) * 1.0d) / ((double) AdVideoPlayerLoadingBar.this.qAu)) * ((double) AdVideoPlayerLoadingBar.this.btI()));
                        AdVideoPlayerLoadingBar.this.qAo.setLayoutParams(layoutParams);
                    }
                    AdVideoPlayerLoadingBar.this.qAs.setText(AdVideoPlayerLoadingBar.kJ(btF / 60) + ":" + AdVideoPlayerLoadingBar.kJ(btF % 60));
                    AdVideoPlayerLoadingBar.this.ktS = true;
                } else if (AdVideoPlayerLoadingBar.this.ktS) {
                    int btF2 = AdVideoPlayerLoadingBar.this.btF();
                    if (AdVideoPlayerLoadingBar.this.qAn != null) {
                        x.i("MicroMsg.VideoPlayerLoadingBar", "current time : " + btF2);
                        AdVideoPlayerLoadingBar.this.qAn.kK(btF2);
                    }
                    AdVideoPlayerLoadingBar.this.ktS = false;
                }
                return true;
            }
        });
        this.qAq.post(new Runnable() {
            public final void run() {
                LayoutParams layoutParams = (LayoutParams) AdVideoPlayerLoadingBar.this.qAq.getLayoutParams();
                layoutParams.leftMargin = (((LayoutParams) AdVideoPlayerLoadingBar.this.qAp.getLayoutParams()).leftMargin - AdVideoPlayerLoadingBar.this.qAq.getPaddingLeft()) - (((AdVideoPlayerLoadingBar.this.btK() - AdVideoPlayerLoadingBar.this.qAq.getPaddingLeft()) - AdVideoPlayerLoadingBar.this.qAq.getPaddingRight()) / 2);
                AdVideoPlayerLoadingBar.this.qAq.setLayoutParams(layoutParams);
            }
        });
        LayoutParams layoutParams = (LayoutParams) this.qAo.getLayoutParams();
        layoutParams.width = 0;
        this.qAo.setLayoutParams(layoutParams);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.qAv = 0;
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

    public void dd(boolean z) {
        if (z) {
            this.qAr.setImageResource(c.pjm);
        } else {
            this.qAr.setImageResource(c.pjn);
        }
    }

    protected final int btF() {
        return Math.max(0, (int) (((((double) ((((LayoutParams) this.qAq.getLayoutParams()).leftMargin - (((LayoutParams) this.qAp.getLayoutParams()).leftMargin - this.qAq.getPaddingLeft())) + (((btK() - this.qAq.getPaddingLeft()) - this.qAq.getPaddingRight()) / 2))) * 1.0d) / ((double) btI())) * ((double) this.qAu)));
    }

    public void seek(int i) {
        this.mPosition = i;
        ahu();
    }

    public final int btG() {
        return this.qAu;
    }

    public void wD(int i) {
        this.qAu = i;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            post(new Runnable() {
                public final void run() {
                    AdVideoPlayerLoadingBar.this.btH();
                }
            });
        } else {
            btH();
        }
    }

    public final void btH() {
        this.qAt.setText(kJ(this.qAu / 60) + ":" + kJ(this.qAu % 60));
        ahu();
    }

    public int btI() {
        if (this.qAv <= 0) {
            this.qAv = this.qAp.getWidth();
        }
        return this.qAv;
    }

    public final void btJ() {
        this.qAv = 0;
    }

    public int btK() {
        if (this.qAw <= 0) {
            this.qAw = this.qAq.getWidth();
        }
        return this.qAw;
    }

    public void ahu() {
        if (this.qAu != 0 && !this.ktS && this.qAq != null && btI() != 0) {
            int btK = ((btK() - this.qAq.getPaddingLeft()) - this.qAq.getPaddingRight()) / 2;
            this.qAs.setText(kJ(this.mPosition / 60) + ":" + kJ(this.mPosition % 60));
            LayoutParams layoutParams = (LayoutParams) this.qAq.getLayoutParams();
            layoutParams.leftMargin = ((((LayoutParams) this.qAp.getLayoutParams()).leftMargin - this.qAq.getPaddingLeft()) + ((int) (((((double) this.mPosition) * 1.0d) / ((double) this.qAu)) * ((double) btI())))) - btK;
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
