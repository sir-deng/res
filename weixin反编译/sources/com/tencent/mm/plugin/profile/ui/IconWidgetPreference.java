package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class IconWidgetPreference extends Preference {
    private ImageView ppJ;
    private int ppK;
    private Bitmap ppL;

    public IconWidgetPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconWidgetPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ppJ = null;
        this.ppK = -1;
        this.ppL = null;
        setLayoutResource(R.i.dnz);
        setWidgetLayoutResource(0);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.dol, viewGroup2);
        return onCreateView;
    }

    public final void A(Bitmap bitmap) {
        this.ppL = bitmap;
        if (this.ppJ != null) {
            this.ppJ.setImageBitmap(bitmap);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.ppJ = (ImageView) view.findViewById(R.h.cDt);
        if (this.ppJ != null) {
            this.ppJ.setVisibility(8);
            if (this.ppK != -1) {
                this.ppJ.setImageResource(this.ppK);
                this.ppJ.setVisibility(0);
            } else if (this.ppL != null) {
                this.ppJ.setImageBitmap(this.ppL);
                this.ppJ.setVisibility(0);
            }
        }
    }
}
