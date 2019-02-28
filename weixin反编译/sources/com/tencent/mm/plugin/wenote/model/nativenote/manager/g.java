package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mm.R;

public final class g {
    public View mParentView;
    public PopupWindow tZF;
    public a tZG;

    public interface a {
        void bXs();

        void bXt();

        void bXu();

        void bXv();
    }

    public g(Context context, View view) {
        this.mParentView = view;
        View inflate = LayoutInflater.from(context).inflate(R.i.duv, null);
        inflate.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.tZF = new PopupWindow(inflate, -2, -2, false);
        this.tZF.setClippingEnabled(false);
        inflate.findViewById(R.h.cZE).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.this.tZF.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.tZG != null) {
                    g.this.tZG.bXs();
                }
            }
        });
        inflate.findViewById(R.h.cZB).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.this.tZF.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.tZG != null) {
                    g.this.tZG.bXt();
                }
            }
        });
        inflate.findViewById(R.h.cZD).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.this.tZF.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.tZG != null) {
                    g.this.tZG.bXu();
                }
            }
        });
        inflate.findViewById(R.h.cZK).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.this.tZF.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.tZG != null) {
                    g.this.tZG.bXv();
                }
            }
        });
    }
}
