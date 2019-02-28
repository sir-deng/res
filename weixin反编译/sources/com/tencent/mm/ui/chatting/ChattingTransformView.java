package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public class ChattingTransformView extends LinearLayout {
    private ImageView tVh;
    private TextView yDY;
    private a yDZ;
    private boolean yEa;

    public enum a {
        NoTranslate,
        Translating,
        Translated
    }

    public ChattingTransformView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yDZ = null;
        this.yEa = false;
        init();
    }

    public ChattingTransformView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet);
        init();
    }

    private void init() {
        int applyDimension = (int) TypedValue.applyDimension(1, 3.0f, getResources().getDisplayMetrics());
        this.tVh = new ImageView(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.setMargins(applyDimension, applyDimension, 0, applyDimension);
        this.tVh.setLayoutParams(layoutParams);
        addView(this.tVh);
        this.yDY = new TextView(getContext());
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(applyDimension, applyDimension, applyDimension, applyDimension);
        layoutParams.gravity = 16;
        this.yDY.setLayoutParams(layoutParams);
        this.yDY.setTextSize(1, 11.0f);
        this.yDY.setTextColor(-1);
        addView(this.yDY);
        setBackgroundResource(R.g.bAP);
        a aVar = a.NoTranslate;
        if (this.yEa) {
            super.setVisibility(8);
        } else if (this.yDZ != aVar) {
            x.d("MicroMsg.ChattingTransformView", "from status %s to status %s", this.yDZ, aVar);
            this.yDZ = aVar;
            switch (aVar) {
                case NoTranslate:
                    super.setVisibility(8);
                    break;
                case Translating:
                    super.setVisibility(0);
                    this.tVh.setImageResource(R.k.dBw);
                    this.yDY.setText(R.l.dTs);
                    break;
            }
            invalidate();
        }
    }
}
