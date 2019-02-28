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

public class VoipSmallIconButton extends FrameLayout {
    private TextView kO;
    private ImageView lNZ;
    private Drawable swA = null;
    private Drawable swB = null;
    private OnTouchListener swC = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    VoipSmallIconButton.this.lNZ.setImageDrawable(VoipSmallIconButton.this.swB);
                    VoipSmallIconButton.this.kO.setTextColor(-855638017);
                    break;
                case 1:
                    VoipSmallIconButton.this.lNZ.setImageDrawable(VoipSmallIconButton.this.swA);
                    VoipSmallIconButton.this.kO.setTextColor(-1);
                    break;
            }
            return false;
        }
    };

    public void setOnClickListener(OnClickListener onClickListener) {
        this.lNZ.setOnClickListener(onClickListener);
    }

    public VoipSmallIconButton(Context context, AttributeSet attributeSet) {
        CharSequence charSequence = 0;
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.i.dmG, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.n.fbm, 0, 0);
        try {
            this.swA = obtainStyledAttributes.getDrawable(R.n.fbp);
            this.swB = obtainStyledAttributes.getDrawable(R.n.fbq);
            charSequence = obtainStyledAttributes.getString(R.n.fbr);
            int resourceId = obtainStyledAttributes.getResourceId(R.n.fbr, -1);
            this.lNZ = (ImageView) findViewById(R.h.cOQ);
            this.lNZ.setImageDrawable(this.swA);
            this.lNZ.setOnTouchListener(this.swC);
            this.lNZ.setContentDescription(charSequence);
            this.kO = (TextView) findViewById(R.h.cOS);
            if (resourceId != -1) {
                this.kO.setText(getContext().getString(resourceId));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setEnabled(boolean z) {
        this.lNZ.setEnabled(z);
        this.kO.setEnabled(z);
    }
}
