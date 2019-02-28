package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.v;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    ArrayList<n> pIr = null;
    a pIs = null;

    public interface a {
        void a(n nVar);
    }

    private class b {
        TextView ipR;
        TextView jbl;
        TextView pIv;

        private b() {
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }
    }

    public final int getCount() {
        return this.pIr == null ? 0 : this.pIr.size();
    }

    public final Object getItem(int i) {
        return this.pIr.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        final n nVar = (n) getItem(i);
        if (view == null) {
            view = v.fw(viewGroup.getContext()).inflate(g.uKw, viewGroup, false);
            b bVar2 = new b();
            bVar2.jbl = (TextView) view.findViewById(f.caR);
            bVar2.ipR = (TextView) view.findViewById(f.name);
            bVar2.pIv = (TextView) view.findViewById(f.uAf);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.ipR.setText(nVar.name);
        if (bi.oN(nVar.desc)) {
            bVar.jbl.setVisibility(8);
        } else {
            bVar.jbl.setVisibility(0);
            bVar.jbl.setText(nVar.desc);
        }
        if (bi.oN(nVar.sJR)) {
            bVar.pIv.setVisibility(8);
        } else {
            bVar.pIv.setVisibility(0);
            bVar.pIv.setText(nVar.sJR);
        }
        if (nVar.status == 1) {
            view.setEnabled(true);
            bVar.jbl.setEnabled(true);
            bVar.ipR.setEnabled(true);
        } else {
            view.setEnabled(false);
            bVar.jbl.setEnabled(false);
            bVar.ipR.setEnabled(false);
        }
        if (nVar.type == 1 && nVar.sJS.equals("1") && !nVar.sJT.equals("0")) {
            Context context = viewGroup.getContext();
            int parseColor = Color.parseColor(nVar.sJT);
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius((float) com.tencent.mm.bu.a.fromDPToPix(context, 2));
            gradientDrawable.setColor(parseColor);
            Drawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius((float) com.tencent.mm.bu.a.fromDPToPix(context, 2));
            gradientDrawable2.setStroke(2, com.tencent.mm.bu.a.c(context, c.uhL));
            Drawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setShape(0);
            gradientDrawable3.setCornerRadius((float) com.tencent.mm.bu.a.fromDPToPix(context, 2));
            gradientDrawable3.setColor(com.tencent.mm.bu.a.c(context, c.uhJ));
            gradientDrawable3.setStroke(2, parseColor);
            Drawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, gradientDrawable);
            stateListDrawable.addState(new int[]{-16842910}, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable3);
            Context context2 = viewGroup.getContext();
            int parseColor2 = Color.parseColor(nVar.sJT);
            r6 = new int[3][];
            r6[0] = new int[]{16842919};
            r6[1] = new int[]{-16842910};
            r6[2] = new int[0];
            ColorStateList colorStateList = new ColorStateList(r6, new int[]{com.tencent.mm.bu.a.c(context2, c.white), com.tencent.mm.bu.a.c(context2, c.uhH), parseColor2});
            bVar.jbl.setTextColor(colorStateList);
            bVar.ipR.setTextColor(colorStateList);
            view.setBackground(stateListDrawable);
        }
        view.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (b.this.pIs != null) {
                    b.this.pIs.a(nVar);
                }
            }
        });
        return view;
    }
}
