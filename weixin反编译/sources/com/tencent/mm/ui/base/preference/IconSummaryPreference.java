package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;

public class IconSummaryPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int height;
    private ImageView ori;
    private String qnm;
    private int qnn;
    public int qno;
    private int yqP;
    private int yqQ;
    private ViewGroup yqS;
    private Bitmap yra;
    private int yrb;
    private int yrc;
    private View yre;
    LayoutParams yrg;
    public int yro;
    public TextView yrp;
    private int yrq;

    public IconSummaryPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconSummaryPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qnm = "";
        this.qnn = -1;
        this.qno = 8;
        this.yra = null;
        this.yrb = -1;
        this.yrc = 8;
        this.yqP = 0;
        this.yqQ = 8;
        this.yro = 8;
        this.ori = null;
        this.yqS = null;
        this.yre = null;
        this.yrp = null;
        this.yrq = -1;
        this.height = -1;
        this.context = context;
        setLayoutResource(h.dnz);
    }

    protected View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.gZs, viewGroup2);
        return onCreateView;
    }

    public final void dk(String str, int i) {
        this.qnm = str;
        this.qnn = i;
    }

    public final void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (this.yrp != null && getSummary() != null && getSummary().length() > 0) {
            this.yrp.setText(getSummary());
        }
    }

    public final void setSummary(int i) {
        super.setSummary(i);
        if (this.yrp != null && getSummary() != null && getSummary().length() > 0) {
            this.yrp.setText(getSummary());
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(g.cpm);
        if (imageView != null) {
            imageView.setVisibility(8);
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.jY != null) {
                imageView.setImageDrawable(this.jY);
                imageView.setVisibility(0);
            } else if (this.Kw != 0) {
                imageView.setImageResource(this.Kw);
                imageView.setVisibility(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(g.cwt);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        TextView textView = (TextView) view.findViewById(g.cQL);
        if (textView != null) {
            textView.setVisibility(this.qno);
            textView.setText(this.qnm);
            if (this.qnn != -1) {
                textView.setBackgroundDrawable(a.b(this.context, this.qnn));
            }
        }
        if (this.ori == null) {
            this.ori = (ImageView) view.findViewById(g.gXn);
        }
        if (this.yqS == null) {
            this.yqS = (ViewGroup) view.findViewById(g.gXS);
        }
        if (this.yre == null) {
            this.yre = view.findViewById(g.cIl);
        }
        this.yre.setVisibility(this.yqQ);
        if (this.yra != null) {
            this.ori.setImageBitmap(this.yra);
        } else if (this.yrb != -1) {
            this.ori.setImageResource(this.yrb);
        }
        this.ori.setVisibility(this.yrc);
        this.yqS.setVisibility(this.yqP);
        if (this.yrg != null) {
            this.ori.setLayoutParams(this.yrg);
        }
        this.yrp = (TextView) view.findViewById(g.gXT);
        if (!(this.yrp == null || getSummary() == null || getSummary().length() <= 0)) {
            this.yrp.setText(getSummary());
            this.yrp.setVisibility(this.yro);
        }
        if (this.yrp != null && this.yrq != -1) {
            this.yrp.setCompoundDrawablesWithIntrinsicBounds(this.yrq, 0, 0, 0);
            this.yrp.setCompoundDrawablePadding(b.b(this.mContext, 2.0f));
            this.yrp.setVisibility(this.yro);
        }
    }
}
