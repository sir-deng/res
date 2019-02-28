package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

public class VoipBigIconButton extends FrameLayout {
    private TextView kO;
    private ImageView lNZ;
    private Drawable swA = null;
    private Drawable swB = null;
    private OnTouchListener swC = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    VoipBigIconButton.this.lNZ.setBackgroundDrawable(VoipBigIconButton.this.swz);
                    VoipBigIconButton.this.lNZ.setImageDrawable(VoipBigIconButton.this.swB);
                    VoipBigIconButton.this.kO.setTextColor(-855638017);
                    break;
                case 1:
                    VoipBigIconButton.this.lNZ.setBackgroundDrawable(VoipBigIconButton.this.swy);
                    VoipBigIconButton.this.lNZ.setImageDrawable(VoipBigIconButton.this.swA);
                    VoipBigIconButton.this.kO.setTextColor(-1);
                    break;
            }
            return false;
        }
    };
    private Drawable swy = null;
    private Drawable swz = null;

    public VoipBigIconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.i.dmF, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.n.fbm, 0, 0);
        try {
            CharSequence string;
            this.swy = obtainStyledAttributes.getDrawable(R.n.fbn);
            this.swz = obtainStyledAttributes.getDrawable(R.n.fbo);
            this.swA = obtainStyledAttributes.getDrawable(R.n.fbp);
            this.swB = obtainStyledAttributes.getDrawable(R.n.fbq);
            int resourceId = obtainStyledAttributes.getResourceId(R.n.fbr, -1);
            int resourceId2 = obtainStyledAttributes.getResourceId(R.n.fbr, 0);
            if (resourceId2 != 0) {
                string = getContext().getString(resourceId2);
            } else {
                string = null;
            }
            obtainStyledAttributes.recycle();
            this.swz = this.swz == null ? this.swy : this.swz;
            this.swB = this.swB == null ? this.swA : this.swB;
            this.lNZ = (ImageView) findViewById(R.h.bMU);
            this.lNZ.setBackgroundDrawable(this.swy);
            this.lNZ.setImageDrawable(this.swA);
            this.lNZ.setOnTouchListener(this.swC);
            this.lNZ.setContentDescription(string);
            this.kO = (TextView) findViewById(R.h.bMX);
            if (resourceId != -1) {
                this.kO.setText(getContext().getString(resourceId));
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    public void setEnabled(boolean z) {
        this.lNZ.setEnabled(z);
        this.kO.setEnabled(z);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.lNZ.setOnClickListener(onClickListener);
    }
}
