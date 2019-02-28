package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.v.a.e;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;

public class IconMsgPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int height;
    private String qnm;
    private int qnn;
    private int qno;
    private int yqO;
    private int yqP;
    private int yqQ;
    private ImageView yqR;
    private ViewGroup yqS;
    private TextView yqT;
    private String yqU;

    public IconMsgPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconMsgPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qnm = "";
        this.qnn = -1;
        this.qno = 8;
        this.yqO = 8;
        this.yqP = 0;
        this.yqQ = 8;
        this.yqR = null;
        this.yqS = null;
        this.height = -1;
        this.yqU = "";
        this.context = context;
        setLayoutResource(h.dnz);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.gZx, viewGroup2);
        onCreateView.setMinimumHeight(onCreateView.getResources().getDimensionPixelSize(e.bvS));
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(g.cpm);
        if (imageView != null) {
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.Kw != 0) {
                imageView.setImageResource(this.Kw);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
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
        this.yqR = (ImageView) view.findViewById(g.gYh);
        this.yqR.setVisibility(this.yqO);
        this.yqS = (ViewGroup) view.findViewById(g.gXS);
        this.yqS.setVisibility(this.yqP);
        this.yqT = (TextView) view.findViewById(16908310);
        textView = (TextView) view.findViewById(g.gYi);
        if (bi.oN(this.yqU)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(this.yqU);
    }
}
