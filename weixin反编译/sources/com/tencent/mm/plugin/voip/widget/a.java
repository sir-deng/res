package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends BaseSmallView {
    private boolean Ki;
    private Runnable sBA = new Runnable() {
        public final void run() {
            a.this.sBv.setVisibility(0);
        }
    };
    private OpenGlRender sBs;
    private OpenGlView sBt;
    private OpenGlRender sBu;
    private OpenGlView sBv;
    private int[] sBw = null;
    private int sBx = 0;
    private float sBy;
    private Runnable sBz = new Runnable() {
        public final void run() {
            a.this.sBv.setVisibility(4);
        }
    };

    public a(Context context, float f) {
        super(context, null);
        LayoutInflater.from(context).inflate(R.i.dub, this);
        this.sBy = f;
        this.sBt = (OpenGlView) findViewById(R.h.cBH);
        this.sBs = new OpenGlRender(this.sBt, OpenGlRender.sAr);
        this.sBt.a(this.sBs);
        this.sBt.setRenderMode(0);
        this.sBv = (OpenGlView) findViewById(R.h.cBG);
        this.sBu = new OpenGlRender(this.sBv, OpenGlRender.sAq);
        this.sBv.a(this.sBu);
        this.sBv.setRenderMode(0);
        this.sBv.setZOrderMediaOverlay(true);
        this.sBv.setVisibility(4);
        this.lKV.postDelayed(new Runnable() {
            public final void run() {
                a.this.findViewById(R.h.cXJ).setVisibility(8);
            }
        }, 3000);
        this.lKV.postDelayed(this.sBA, 2000);
        this.lKV.postDelayed(this.sBz, 5000);
    }

    public final void dY(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.sBv.getLayoutParams();
        layoutParams.height = i2 / 4;
        layoutParams.width = (int) (this.sBy * ((float) layoutParams.height));
        this.sBv.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = (WindowManager.LayoutParams) getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new WindowManager.LayoutParams();
        }
        layoutParams2.width = i;
        layoutParams2.height = i2;
        setLayoutParams(layoutParams2);
    }

    private void bJv() {
        if (!this.Ki) {
            this.Ki = true;
            this.sBs.szX = true;
            this.sBu.szX = true;
        }
    }

    public final void b(int i, int i2, int[] iArr) {
        bJv();
        if (OpenGlRender.sAB == 1) {
            this.sBs.a(iArr, i, i2, OpenGlRender.sAh + OpenGlRender.sAn);
        } else {
            this.sBs.a(iArr, i, i2, OpenGlRender.sAk + OpenGlRender.sAn);
        }
    }

    public final void bHJ() {
        if (this.Ki) {
            this.sBu.bJp();
            this.sBs.bJp();
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5) {
        if (this.sBv.getVisibility() == 0) {
            bJv();
            if (OpenGlRender.sAB == 1) {
                if (this.sBx < i * i2) {
                    this.sBw = null;
                }
                if (this.sBw == null) {
                    this.sBx = i * i2;
                    this.sBw = new int[this.sBx];
                }
                if (d.bGT().a(bArr, (int) j, i3 & 31, i, i2, this.sBw, false) >= 0 && this.sBw != null) {
                    this.sBu.a(this.sBw, i, i2, (OpenGlRender.sAi + i4) + i5);
                }
            } else if (OpenGlRender.sAB == 2) {
                this.sBu.c(bArr, i, i2, (OpenGlRender.sAm + i4) + i5);
            }
        }
    }

    public final void uninit() {
        super.uninit();
        setVisibility(4);
        if (this.Ki) {
            this.sBs.bJo();
            this.sBu.bJo();
        }
        this.lKV.removeCallbacks(this.sBz);
    }

    public final void a(CaptureView captureView) {
        x.j("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
        if (this.srU != null) {
            removeView(this.srU);
            this.srU = null;
        }
        if (captureView != null) {
            this.srU = captureView;
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
            layoutParams.leftMargin = 20;
            layoutParams.topMargin = 20;
            addView(captureView, layoutParams);
            captureView.setVisibility(0);
            x.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
        }
    }

    protected final void bIT() {
        this.sBv.setVisibility(0);
        this.lKV.removeCallbacks(this.sBz);
        this.lKV.postDelayed(this.sBz, 3000);
    }

    protected final void bIU() {
        this.sBs.bJo();
        this.sBu.bJo();
    }

    protected final void onAnimationEnd() {
        this.sBs.szX = true;
        this.sBu.szX = true;
    }
}
