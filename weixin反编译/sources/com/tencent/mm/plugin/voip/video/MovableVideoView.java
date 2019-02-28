package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;

public class MovableVideoView extends OpenGlView {
    private float fiU;
    private float fiV;
    private OnClickListener mOnClickListener;
    private int mScreenHeight;
    private int mScreenWidth;
    int mWidth;
    int szJ;
    private int szK;
    private int szL;
    private long szM;

    public MovableVideoView(Context context) {
        this(context, null);
    }

    public MovableVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWidth = 320;
        this.szJ = 240;
        this.szK = 800;
        this.szL = 480;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        x.d("MicroMsg.MovableVideoView", "event: " + motionEvent.getAction());
        switch (motionEvent.getAction()) {
            case 0:
                this.fiU = motionEvent.getRawX();
                this.fiV = motionEvent.getRawY();
                this.szM = System.currentTimeMillis();
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (this.szM != 0 && currentTimeMillis - this.szM < 300 && currentTimeMillis - this.szM >= 0 && this.mOnClickListener != null) {
                    this.mOnClickListener.onClick(this);
                }
                g.pWK.h(11079, Integer.valueOf(2));
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.fiU;
                float rawY = motionEvent.getRawY() - this.fiV;
                if (Math.abs(rawX) > 1.0f || Math.abs(rawY) > 1.0f) {
                    LayoutParams layoutParams = (LayoutParams) getLayoutParams();
                    int i2 = (int) (rawX + ((float) layoutParams.leftMargin));
                    int i3 = (int) (rawY + ((float) layoutParams.topMargin));
                    if (i2 < 0) {
                        i2 = 0;
                    } else if (i2 > this.szL) {
                        i2 = this.szL;
                    }
                    layoutParams.leftMargin = i2;
                    if (i3 >= 0) {
                        i = i3 > this.szK ? this.szK : i3;
                    }
                    layoutParams.topMargin = i;
                    setLayoutParams(layoutParams);
                    this.fiU = motionEvent.getRawX();
                    this.fiV = motionEvent.getRawY();
                    break;
                }
        }
        return true;
    }

    public final void dV(int i, int i2) {
        this.mWidth = i;
        this.szJ = i2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (this.mScreenWidth == 0) {
            this.mScreenWidth = windowManager.getDefaultDisplay().getWidth();
            this.mScreenHeight = windowManager.getDefaultDisplay().getHeight();
        }
        ViewGroup.LayoutParams layoutParams = new LayoutParams(i, i2);
        layoutParams.topMargin = a.fromDPToPix(getContext(), 12) + u.fL(getContext());
        layoutParams.leftMargin = ((this.mScreenWidth - this.mWidth) - layoutParams.topMargin) + u.fL(getContext());
        setLayoutParams(layoutParams);
        this.szK = this.mScreenHeight - this.szJ;
        this.szL = this.mScreenWidth - this.mWidth;
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
    }

    public final void dW(int i, int i2) {
        dV(i, i2);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public final void dX(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(i, i2);
        layoutParams2.leftMargin = layoutParams.leftMargin;
        layoutParams2.topMargin = layoutParams.topMargin;
        this.mWidth = i;
        this.szJ = i2;
        setLayoutParams(layoutParams2);
    }
}
