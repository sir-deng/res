package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.favorite.a.j;

public class FavCapacityPanel extends LinearLayout {
    private LinearLayout mAt = this;
    public long mAu;
    public TextView mAv;
    public int mAw = 0;
    public long mAx;
    private OnClickListener myR = new OnClickListener() {
        public final void onClick(View view) {
            Intent intent = new Intent();
            if (FavCapacityPanel.this.mAw == 0) {
                intent.putExtra("key_enter_fav_cleanui_from", 1);
            } else {
                intent.putExtra("key_enter_fav_cleanui_from", 2);
            }
            d.b(FavCapacityPanel.this.getContext(), "favorite", ".ui.FavCleanUI", intent);
        }
    };

    public FavCapacityPanel(Context context, AttributeSet attributeSet) {
        long j;
        super(context, attributeSet);
        View inflate = View.inflate(getContext(), R.i.dhS, null);
        inflate.measure(-2, -2);
        View findViewById = inflate.findViewById(R.h.cgm);
        View findViewById2 = inflate.findViewById(R.h.cgn);
        this.mAv = (TextView) inflate.findViewById(R.h.cgl);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        layoutParams.width = inflate.getMeasuredWidth();
        findViewById.setLayoutParams(layoutParams);
        findViewById2.setOnClickListener(this.myR);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        this.mAt.addView(inflate, layoutParams2);
        this.mAu = j.aJr() / 1048576;
        this.mAx = j.aJs() / 1048576;
        TextView textView = this.mAv;
        Context context2 = this.mAv.getContext();
        int i = R.l.eeK;
        Object[] objArr = new Object[2];
        if (this.mAx - this.mAu > 0) {
            j = this.mAx - this.mAu;
        } else {
            j = 0;
        }
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(this.mAu);
        textView.setText(context2.getString(i, objArr));
    }
}
