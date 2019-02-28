package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.m;

public final class ImagePreference extends Preference {
    private ImageView ppw;
    private e yrr;

    public ImagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ppw = null;
        this.yrr = new e();
        setLayoutResource(h.gZy);
        setWidgetLayoutResource(h.doj);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.faE);
        int resourceId = obtainStyledAttributes.getResourceId(m.haO, 0);
        if (resourceId > 0) {
            e eVar = this.yrr;
            eVar.jyc = resourceId;
            eVar.bitmap = null;
            this.yrr.e(this.ppw);
        }
        obtainStyledAttributes.recycle();
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.bYS);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.gZy, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.ppw = (ImageView) view.findViewById(g.cpm);
        this.yrr.e(this.ppw);
    }
}
