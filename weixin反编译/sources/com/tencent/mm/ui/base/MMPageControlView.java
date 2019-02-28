package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import java.util.HashMap;
import java.util.Map;

public class MMPageControlView extends LinearLayout {
    public Context context;
    public int count;
    public ImageView fwa;
    public Map<Integer, ImageView> map = new HashMap();
    public int ykM = h.gZL;

    public final void eU(int i, int i2) {
        this.count = i;
        xs(i2);
    }

    public MMPageControlView(Context context) {
        super(context);
        this.context = context;
    }

    public MMPageControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public void xs(int i) {
        removeAllViews();
        if (i < this.count) {
            int i2 = this.count;
            for (int i3 = 0; i3 < i2; i3++) {
                this.fwa = null;
                if (i == i3) {
                    if (this.map.size() > i3) {
                        this.fwa = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.fwa == null) {
                        this.fwa = (ImageView) View.inflate(this.context, this.ykM, null).findViewById(g.gXD);
                        this.map.put(Integer.valueOf(i3), this.fwa);
                    }
                    this.fwa.setSelected(true);
                } else {
                    if (this.map.size() > i3) {
                        this.fwa = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.fwa == null) {
                        this.fwa = (ImageView) View.inflate(this.context, this.ykM, null).findViewById(g.gXD);
                        this.map.put(Integer.valueOf(i3), this.fwa);
                    }
                    this.fwa.setSelected(false);
                }
                if (i3 == 0) {
                    this.fwa.setPadding(0, 0, 0, 0);
                }
                addView(this.fwa);
            }
        }
    }
}
