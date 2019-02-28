package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;

public class PreferenceInfoCategory extends Preference {
    public int xRX;
    public OnClickListener ysy;
    public OnClickListener ysz;

    public PreferenceInfoCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceInfoCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ysy = null;
        this.ysz = null;
        this.xRX = 0;
        setLayoutResource(h.gZA);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            if (getTitle() == null || getTitle().length() <= 0) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(getTitle());
                textView.setOnClickListener(this.ysz);
            }
            ImageView imageView = (ImageView) view.findViewById(g.gWV);
            imageView.setOnClickListener(this.ysy);
            if (this.xRX > 0) {
                imageView.setImageResource(this.xRX);
                imageView.setVisibility(0);
                return;
            }
            imageView.setVisibility(8);
        }
    }
}
