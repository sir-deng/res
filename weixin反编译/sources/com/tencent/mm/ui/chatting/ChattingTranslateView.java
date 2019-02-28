package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class ChattingTranslateView extends LinearLayout {
    private String fIQ;
    private ImageView tVh;
    private TextView yDY;
    private boolean yEa;
    private boolean yEg;
    private a yEh;

    public enum a {
        NoTranslate,
        Translating,
        Translated
    }

    public ChattingTranslateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yEg = false;
        this.yEh = null;
        this.yEa = false;
        init();
    }

    public ChattingTranslateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet);
        init();
    }

    public final void mN(boolean z) {
        this.yEa = z;
        if (z) {
            super.setVisibility(8);
        }
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
        a(a.NoTranslate);
    }

    public final void csP() {
        a(a.NoTranslate);
    }

    public final void csQ() {
        a(a.Translating);
    }

    public final void ZJ(String str) {
        if (!bi.oM(this.fIQ).equals(bi.oM(str))) {
            this.yEg = true;
        }
        this.fIQ = str;
        a(a.Translated);
    }

    private void a(a aVar) {
        if (this.yEa) {
            super.setVisibility(8);
        } else if (this.yEh != aVar || this.yEg) {
            this.yEg = false;
            x.d("MicroMsg.ChattingTranslateView", "from status %s to status %s", this.yEh, aVar);
            this.yEh = aVar;
            switch (aVar) {
                case NoTranslate:
                    super.setVisibility(8);
                    break;
                case Translating:
                    super.setVisibility(0);
                    this.tVh.setImageResource(R.k.dBw);
                    this.yDY.setText(R.l.dTv);
                    break;
                case Translated:
                    super.setVisibility(0);
                    this.tVh.setImageResource(R.k.dBv);
                    if (!bi.oN(this.fIQ)) {
                        this.yDY.setText(this.fIQ);
                        break;
                    } else {
                        this.yDY.setText(R.l.dTu);
                        break;
                    }
            }
            invalidate();
        }
    }
}
