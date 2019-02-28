package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;

public class MallProductItemView extends LinearLayout {
    private TextView jOY;
    private Object mData;
    private String mTitle;
    private int mType;
    private String piE;
    private TextView pkT;
    private ImageView pkU;
    private int plB;

    public MallProductItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.plB = 1;
        this.mType = 0;
        this.mData = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.vgg, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(k.vgi, 0);
        if (resourceId != 0) {
            this.mTitle = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(k.vgj, 0);
        if (resourceId != 0) {
            this.piE = context.getString(resourceId);
        }
        this.plB = obtainStyledAttributes.getInt(k.vgh, 1);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(g.uKa, this, true);
        this.jOY = (TextView) inflate.findViewById(f.cSB);
        this.pkT = (TextView) inflate.findViewById(f.uDh);
        this.pkU = (ImageView) inflate.findViewById(f.uru);
        this.jOY.setText(this.mTitle);
        this.pkT.setText(this.piE);
        this.pkT.setLines(this.plB);
    }

    public MallProductItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void Ia(String str) {
        this.piE = str;
        this.pkT.setText(this.piE);
    }
}
