package com.tencent.mm.plugin.multitalk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class d implements OnClickListener {
    private Context context;
    private View mVw;
    private int oNA = b.oNA;
    private int oNG = b.oNG;
    private LinearLayout oNS;
    public LinearLayout oNT;
    public LinearLayout oNU;
    private int oNV;
    private int oNW;
    private int oNX = (b.oNA + b.oNz);
    private int oNY = ((b.oNA * 2) + b.oNz);
    private int oNZ = (b.oNA * 4);
    public int oOa;
    public int size = 0;

    public d(Activity activity) {
        this.context = activity.getBaseContext();
        int eB = a.eB(this.context) - (this.oNZ * 2);
        this.oNV = (eB - (this.oNX * 10)) / 5;
        this.oNW = (eB - (this.oNY * 10)) / 5;
        eB = (this.oNW * 2) + (this.oNA * 12);
        this.mVw = activity.findViewById(R.h.cCr);
        this.mVw.getLayoutParams().height = eB;
        this.oNS = (LinearLayout) activity.findViewById(R.h.bLI);
        LayoutParams layoutParams = (LayoutParams) this.oNS.getLayoutParams();
        layoutParams.topMargin = this.oNA * 2;
        layoutParams.bottomMargin = this.oNA * 2;
        layoutParams.leftMargin = this.oNZ;
        layoutParams.rightMargin = this.oNZ;
        this.oNS.setLayoutParams(layoutParams);
        this.oNT = new LinearLayout(this.context);
        this.oNU = new LinearLayout(this.context);
        this.oNT.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        this.oNU.setLayoutParams(layoutParams2);
        layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        View relativeLayout = new RelativeLayout(this.context);
        relativeLayout.addView(this.oNU);
        relativeLayout.setLayoutParams(layoutParams2);
        this.oNS.addView(this.oNT);
        this.oNS.addView(relativeLayout);
    }

    public final void setVisible(boolean z) {
        if (z) {
            this.mVw.setVisibility(0);
        } else {
            this.mVw.setVisibility(8);
        }
    }

    public final void Gm(String str) {
        this.size++;
        View imageView = new ImageView(this.context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setTag(str);
        imageView.setOnClickListener(this);
        b.a(imageView, str, 0.1f, false);
        if (this.size <= 5) {
            this.oNT.addView(imageView);
        } else {
            this.oNU.addView(imageView);
        }
        tC(this.size);
        tD(this.size);
    }

    public final void tC(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oNT.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) this.oNU.getLayoutParams();
        if (i <= 5) {
            layoutParams.height = this.oNV;
            this.oNU.setVisibility(8);
            return;
        }
        layoutParams.height = this.oNW;
        layoutParams.topMargin = this.oNA * 2;
        layoutParams.bottomMargin = this.oNA * 2;
        this.oNU.setVisibility(0);
        layoutParams2.height = this.oNW;
        layoutParams2.topMargin = this.oNA * 2;
        layoutParams2.bottomMargin = this.oNA * 2;
    }

    public final void tD(int i) {
        int i2 = 0;
        int i3;
        LinearLayout.LayoutParams layoutParams;
        if (i <= 5) {
            for (i3 = 0; i3 < this.oNT.getChildCount(); i3++) {
                layoutParams = (LinearLayout.LayoutParams) this.oNT.getChildAt(i3).getLayoutParams();
                layoutParams.width = this.oNV;
                layoutParams.height = this.oNV;
                layoutParams.rightMargin = this.oNX;
                layoutParams.leftMargin = this.oNX;
            }
            while (i2 < this.oNU.getChildCount()) {
                layoutParams = (LinearLayout.LayoutParams) this.oNU.getChildAt(i2).getLayoutParams();
                layoutParams.width = this.oNW;
                layoutParams.height = this.oNW;
                layoutParams.rightMargin = this.oNX;
                layoutParams.leftMargin = this.oNX;
                i2++;
            }
            return;
        }
        for (i3 = 0; i3 < this.oNT.getChildCount(); i3++) {
            layoutParams = (LinearLayout.LayoutParams) this.oNT.getChildAt(i3).getLayoutParams();
            layoutParams.width = this.oNW;
            layoutParams.height = this.oNW;
            layoutParams.rightMargin = this.oNY;
            layoutParams.leftMargin = this.oNY;
        }
        while (i2 < this.oNU.getChildCount()) {
            layoutParams = (LinearLayout.LayoutParams) this.oNU.getChildAt(i2).getLayoutParams();
            layoutParams.width = this.oNW;
            layoutParams.height = this.oNW;
            layoutParams.rightMargin = this.oNY;
            layoutParams.leftMargin = this.oNY;
            i2++;
        }
    }

    public final void onClick(View view) {
        this.oOa++;
    }
}
