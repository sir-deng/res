package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.v.a.e;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference extends Preference {
    private View contentView;
    public TextView ppv;
    public String xRi;
    private boolean yrA;
    public boolean yrB;
    private int yrC;
    public int yrD;
    public int yrE;
    public ImageView yrF;
    public Drawable yrG;
    public List<View> yrH;
    private Drawable yrx;
    public boolean yry;
    private boolean yrz;

    public KeyValuePreference(Context context) {
        this(context, null);
    }

    public KeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yrx = null;
        this.yry = true;
        this.yrz = false;
        this.xRi = null;
        this.yrA = false;
        this.yrB = false;
        this.yrC = 17;
        this.yrD = 17;
        this.yrE = 0;
        this.yrF = null;
        this.yrG = null;
        this.yrH = new LinkedList();
        setLayoutResource(h.dnz);
    }

    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(h.gZt, viewGroup2);
        return onCreateView;
    }

    public void onBindView(View view) {
        LinearLayout linearLayout;
        super.onBindView(view);
        this.contentView = view.findViewById(g.content);
        if (this.ysi != null) {
            this.contentView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    KeyValuePreference.this.ysi.bkg();
                }
            });
        }
        this.ppv = (TextView) view.findViewById(16908304);
        this.ppv.setSingleLine(this.yry);
        if (this.yrz) {
            setWidgetLayoutResource(h.doj);
        }
        if (this.yrB) {
            linearLayout = (LinearLayout) view.findViewById(g.bYH);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            layoutParams.width = -1;
            linearLayout.setLayoutParams(layoutParams);
            linearLayout = (LinearLayout) view.findViewById(g.gYb);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.getChildAt(0).setLayoutParams(layoutParams);
            this.ppv.setGravity(this.yrD);
        }
        TextView textView = (TextView) view.findViewById(16908310);
        if (!bi.oN(this.xRi)) {
            textView.setText(this.xRi);
        }
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            layoutParams2.width = a.aa(this.mContext, e.bvc);
            textView.setLayoutParams(layoutParams2);
        }
        if (this.yrx != null) {
            ((ImageView) view.findViewById(g.gXm)).setImageDrawable(this.yrx);
        }
        this.yrF = (ImageView) view.findViewById(g.cpm);
        if (this.yrG != null) {
            this.yrF.setVisibility(this.yrE);
            this.yrF.setImageDrawable(this.yrG);
        } else {
            this.yrF.setVisibility(8);
        }
        if (this.yrA) {
            linearLayout = (LinearLayout) view.findViewById(g.bYH);
            if (linearLayout != null) {
                linearLayout.setGravity(this.yrC);
            }
        }
        if (this.yrH.size() > 0) {
            linearLayout = (LinearLayout) view.findViewById(g.gYb);
            linearLayout.removeAllViews();
            for (View view2 : this.yrH) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view2);
                }
                linearLayout.addView(view2);
            }
        }
    }

    public final void mE(boolean z) {
        this.yrz = z;
        if (this.yrz) {
            setWidgetLayoutResource(h.doj);
        }
    }

    public final void crc() {
        this.yrA = true;
        this.yrC = 49;
    }
}
