package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    private Context context;
    List<k> dataList = new ArrayList();
    int mode;

    private class a {
        public ImageView ikl;
        public TextView ikm;
        public TextView ikn;
        public TextView iko;
        public TextView ikp;
        public TextView ikq;

        public a(View view) {
            this.ikl = (ImageView) view.findViewById(f.ukD);
            this.ikm = (TextView) view.findViewById(f.ukE);
            this.ikn = (TextView) view.findViewById(f.ukH);
            this.iko = (TextView) view.findViewById(f.ukF);
            this.ikp = (TextView) view.findViewById(f.ukC);
            this.ikq = (TextView) view.findViewById(f.ukG);
        }
    }

    public b(Context context, int i) {
        this.context = context;
        this.mode = i;
    }

    public final int getCount() {
        return this.dataList.size();
    }

    public final Object getItem(int i) {
        return this.dataList.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = v.fw(this.context).inflate(g.uHs, viewGroup, false);
            view.setTag(new a(view));
        }
        a aVar = (a) view.getTag();
        k kVar = (k) getItem(i);
        aVar.ikl.setImageResource(h.uML);
        com.tencent.mm.pluginsdk.ui.a.b.g(aVar.ikl, kVar.vJJ, h.uML);
        aVar.ikn.setText(i.b(this.context, kVar.title, aVar.ikn.getTextSize()));
        CharSequence gw = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.a.b.class)).gw(kVar.vJJ);
        if (bi.oN(gw) || gw.endsWith("@chatroom")) {
            gw = this.context.getString(com.tencent.mm.plugin.wxpay.a.i.uNs);
        }
        aVar.ikm.setText(i.b(this.context, gw, aVar.ikm.getTextSize()));
        if (this.mode == 2) {
            aVar.iko.setText(kVar.vJV);
        } else {
            aVar.iko.setText(kVar.vJS);
        }
        aVar.ikp.setText(String.format("%s%s", new Object[]{Float.valueOf(((float) kVar.fMM) / 100.0f), this.context.getString(com.tencent.mm.plugin.wxpay.a.i.uNT)}));
        aVar.ikq.setVisibility(0);
        if (this.mode != 2) {
            switch (kVar.state) {
                case 1:
                    aVar.ikq.setText(com.tencent.mm.plugin.wxpay.a.i.uNF);
                    aVar.ikq.setTextColor(this.context.getResources().getColor(c.uhc));
                    break;
                case 2:
                    aVar.ikq.setText(com.tencent.mm.plugin.wxpay.a.i.uND);
                    aVar.ikq.setTextColor(this.context.getResources().getColor(c.uhc));
                    break;
                case 3:
                    aVar.ikq.setText(com.tencent.mm.plugin.wxpay.a.i.uNB);
                    aVar.ikq.setTextColor(this.context.getResources().getColor(c.btC));
                    break;
                case 4:
                    aVar.ikq.setText(com.tencent.mm.plugin.wxpay.a.i.uNC);
                    aVar.ikq.setTextColor(this.context.getResources().getColor(c.btC));
                    break;
                default:
                    aVar.ikq.setVisibility(4);
                    break;
            }
        }
        switch (kVar.state) {
            case 1:
                aVar.ikq.setText(com.tencent.mm.plugin.wxpay.a.i.uNG);
                aVar.ikq.setTextColor(this.context.getResources().getColor(c.uhc));
                break;
            case 2:
                aVar.ikq.setText(com.tencent.mm.plugin.wxpay.a.i.uNE);
                aVar.ikq.setTextColor(this.context.getResources().getColor(c.uhc));
                break;
            default:
                aVar.ikq.setVisibility(4);
                break;
        }
        return view;
    }

    public final void WY() {
        this.dataList.clear();
    }
}
