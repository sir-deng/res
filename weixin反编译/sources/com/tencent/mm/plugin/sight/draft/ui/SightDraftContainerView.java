package com.tencent.mm.plugin.sight.draft.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.sight.draft.ui.b.d;

public class SightDraftContainerView extends ListView {
    private boolean qBU;
    a qBV;
    b qBW;

    public SightDraftContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SightDraftContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SightDraftContainerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setBackgroundColor(getResources().getColor(R.e.black));
        setSelector(R.e.transparent);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bvT);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.bvw);
        View textView = new TextView(getContext());
        textView.setText(R.l.ePX);
        textView.setTextSize(0, (float) a.aa(getContext(), R.f.bvt));
        textView.setGravity(17);
        textView.setTextColor(getResources().getColor(R.e.bsP));
        textView.setTextSize(1, 11.0f);
        textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize2);
        addFooterView(textView);
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                SightDraftContainerView sightDraftContainerView = SightDraftContainerView.this;
                if (sightDraftContainerView.qBW != null) {
                    b bVar = sightDraftContainerView.qBW;
                    bVar.a(null);
                    bVar.qBz.btX();
                }
                return false;
            }
        });
    }

    public final void btY() {
        if (this.qBU) {
            this.qBW.qBG = 12;
            this.qBW.a(d.NORMAL, false);
            this.qBW.a(null, null);
            setSelection(0);
            return;
        }
        this.qBU = true;
        this.qBW = new b(getContext(), this.qBV);
        this.qBW.qBG = 12;
        setAdapter(this.qBW);
    }
}
