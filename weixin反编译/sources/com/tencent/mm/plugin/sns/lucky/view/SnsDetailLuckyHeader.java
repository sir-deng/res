package com.tencent.mm.plugin.sns.lucky.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.TouchImageView;
import com.tencent.mm.protocal.c.blb;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class SnsDetailLuckyHeader extends LinearLayout {
    private View lHV = null;
    private TextView qYk;
    private LinearLayout qYl;
    private LinearLayout qYm;

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SnsDetailLuckyHeader(Context context) {
        super(context);
        init();
    }

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        View inflate = View.inflate(getContext(), g.qMB, this);
        this.lHV = inflate.findViewById(f.qHl);
        this.qYk = (TextView) inflate.findViewById(f.qGU);
        this.qYl = (LinearLayout) inflate.findViewById(f.qGV);
        b.b(getContext(), 2.0f);
        LayoutParams layoutParams = new AbsListView.LayoutParams(-1, 1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(e.qFR);
        linearLayout.setLayoutParams(layoutParams);
        this.qYm = linearLayout;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.lHV != null) {
            this.lHV.setVisibility(i);
        }
    }

    public final void a(m mVar, com.tencent.mm.plugin.sns.ui.b.b bVar) {
        blf n = ai.n(mVar);
        blu blu = n.wVf;
        if (blu == null || blu.wVI.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        double b = ((double) com.tencent.mm.plugin.sns.lucky.a.m.b(mVar, n)) * 1.0d;
        this.qYk.setText(getContext().getString(j.qRF, new Object[]{Integer.valueOf(n.wVf.wVH), bi.t(b / 100.0d)}));
        this.lHV.setTag(mVar);
        this.lHV.setOnClickListener(bVar.rVE);
        LinkedList linkedList = blu.wVI;
        boolean isEmpty = blu.wVI.isEmpty();
        int b2 = b.b(getContext(), 32.0f);
        int b3 = b.b(getContext(), 6.0f);
        int b4 = b.b(getContext(), 10.0f);
        int b5 = b.b(getContext(), 17.0f);
        if (this.qYl != null) {
            int i;
            LinearLayout linearLayout;
            x.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d %f", Integer.valueOf(((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth()), Float.valueOf(getResources().getDimension(d.bvK)));
            float f = ((float) i) - (f * 2.0f);
            if (linkedList.size() <= 0) {
                if (this.qYl.getParent() != null) {
                    this.qYl.setVisibility(8);
                }
                this.qYl.removeAllViews();
                this.qYl.setVisibility(8);
                linearLayout = this.qYl;
                i = 8;
            } else {
                this.qYl.getParent();
                this.qYl.removeAllViews();
                this.qYl.setVisibility(0);
                this.qYl.setPadding(0, b3, 0, b3);
                View imageView = new ImageView(getContext());
                imageView.setImageResource(i.qOP);
                imageView.setPadding(b4, b5, b4, 0);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                imageView.setLayoutParams(layoutParams);
                imageView.setClickable(false);
                imageView.setFocusable(false);
                this.qYl.addView(imageView);
                b4 = a.fromDPToPix(getContext(), SnsCommentDetailUI.rFV);
                i = ((int) (f - ((float) b4))) / (b3 + b2);
                if (((int) (f - ((float) b4))) % (b3 + b2) > b2) {
                    i++;
                }
                x.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d", Integer.valueOf(i));
                View iVar = new com.tencent.mm.plugin.sns.ui.i(getContext());
                iVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                iVar.rxt = i;
                i = 0;
                while (true) {
                    b4 = i;
                    if (b4 >= linkedList.size()) {
                        break;
                    }
                    blb blb = (blb) linkedList.get(b4);
                    View touchImageView = new TouchImageView(getContext());
                    touchImageView.setScaleType(ScaleType.FIT_XY);
                    touchImageView.setImageResource(e.qFh);
                    LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b2, b2);
                    layoutParams2.setMargins(0, b3, b3, 0);
                    touchImageView.setLayoutParams(layoutParams2);
                    touchImageView.setTag(blb.vPp);
                    com.tencent.mm.pluginsdk.ui.a.b.b(touchImageView, blb.vPp, true);
                    touchImageView.setOnClickListener(bVar.rVt);
                    iVar.addView(touchImageView);
                    i = b4 + 1;
                }
                this.qYl.addView(iVar);
                linearLayout = this.qYm;
                i = isEmpty ? 8 : 0;
            }
            linearLayout.setVisibility(i);
        }
    }
}
