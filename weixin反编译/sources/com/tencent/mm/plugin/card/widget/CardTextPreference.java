package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class CardTextPreference extends Preference {
    private TextView Zv;
    private TextView ldE;
    public int ldF = 0;
    boolean ldG = true;
    Context mContext;

    public CardTextPreference(Context context) {
        super(context, null);
        this.mContext = context;
    }

    public CardTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public CardTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutResource(R.i.dnz);
        this.mContext = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.ldE = (TextView) view.findViewById(16908304);
        this.Zv = (TextView) view.findViewById(16908310);
        axQ();
        ei(this.ldG);
    }

    public final void axQ() {
        if (this.ldE != null && this.ldF != 0) {
            this.ldE.setTextColor(this.ldF);
        }
    }

    public final void axR() {
        ei(false);
        this.ldG = false;
    }

    private void ei(boolean z) {
        if (this.Zv != null) {
            View view = this.Zv;
            Rect rect = new Rect();
            rect.left = view.getPaddingLeft();
            rect.right = view.getPaddingRight();
            rect.top = view.getPaddingTop();
            rect.bottom = view.getPaddingBottom();
            this.Zv.setSingleLine(z);
            if (!z) {
                rect.top = this.mContext.getResources().getDimensionPixelOffset(R.f.bvw);
                rect.bottom = this.mContext.getResources().getDimensionPixelOffset(R.f.bvw);
                view = this.Zv;
                if (view != null) {
                    view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                }
            }
        }
    }
}
