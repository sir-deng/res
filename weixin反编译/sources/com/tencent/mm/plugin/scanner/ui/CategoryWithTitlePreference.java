package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class CategoryWithTitlePreference extends Preference implements a {
    private Context context;
    private String iconUrl;
    private TextView ikn;
    private f inW;
    private ImageView jTd;
    private int lqi;
    private int pYl;
    private String title;

    public final /* bridge */ /* synthetic */ CharSequence getTitle() {
        return this.title;
    }

    public CategoryWithTitlePreference(Context context) {
        this(context, null);
    }

    public CategoryWithTitlePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CategoryWithTitlePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.title = "";
        this.lqi = 34;
        this.pYl = 34;
        setLayoutResource(R.i.dnA);
        this.context = context;
        j.a((a) this);
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            this.title = charSequence.toString();
            if (this.ikn != null) {
                this.ikn.setVisibility(0);
                this.ikn.setText(charSequence);
                x.v("MicroMsg.scanner.CategoryWithTitlePreference", "title : " + this.ikn.getText());
            }
        } else if (this.ikn != null) {
            this.ikn.setVisibility(8);
        }
        super.setTitle(charSequence);
    }

    public final void setTitle(int i) {
        if (this.ikn != null) {
            if (this.context != null) {
                this.title = this.context.getString(i);
            }
            if (bi.oN(this.title)) {
                this.ikn.setVisibility(8);
            } else {
                this.ikn.setVisibility(0);
                this.ikn.setText(this.title);
            }
        }
        super.setTitle(i);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.ikn = (TextView) view.findViewById(16908310);
        this.jTd = (ImageView) view.findViewById(R.h.icon);
        LayoutParams layoutParams = this.jTd.getLayoutParams();
        layoutParams.width = b.b(this.context, (float) (this.lqi / 2));
        layoutParams.height = b.b(this.context, (float) (this.pYl / 2));
        this.jTd.setLayoutParams(layoutParams);
        if (!(this.title == null || this.title.length() <= 0 || this.ikn == null)) {
            this.ikn.setVisibility(0);
            this.ikn.setText(this.title);
            x.v("MicroMsg.scanner.CategoryWithTitlePreference", "onBindView title : " + this.ikn.getText());
        }
        if (!bi.oN(this.iconUrl)) {
            Bitmap a = j.a(new o(this.iconUrl));
            if (a != null && !a.isRecycled()) {
                this.jTd.setImageBitmap(a);
                this.jTd.setVisibility(0);
            }
        }
    }

    public final void l(String str, final Bitmap bitmap) {
        x.d("MicroMsg.scanner.CategoryWithTitlePreference", "get pic:" + str + ", iconurl:" + this.iconUrl);
        if (!bi.oN(str) && str.equals(this.iconUrl) && bitmap != null && !bitmap.isRecycled() && this.jTd != null) {
            ah.y(new Runnable() {
                public final void run() {
                    CategoryWithTitlePreference.this.jTd.setImageBitmap(bitmap);
                    CategoryWithTitlePreference.this.jTd.setVisibility(0);
                    if (CategoryWithTitlePreference.this.inW != null) {
                        CategoryWithTitlePreference.this.inW.notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
