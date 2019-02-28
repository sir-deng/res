package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.m;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class i extends BaseAdapter {
    private LayoutInflater DF;
    private Context mContext;
    private List<m> omo = new LinkedList();
    String opG;
    boolean opH;
    OnClickListener opI;
    int opJ = 1;
    b opK = null;

    final class a implements b {
        a() {
        }

        public final void a(c cVar, Context context) {
            int color = context.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhn);
            int color2 = context.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uho);
            int color3 = context.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uht);
            cVar.lzm.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.c.transparent);
            cVar.lzm.setPadding(0, context.getResources().getDimensionPixelOffset(d.bvC), 0, context.getResources().getDimensionPixelOffset(d.bvC));
            cVar.nwk.setTextColor(color);
            cVar.onI.setTextColor(color2);
            cVar.omb.setTextColor(color);
            cVar.opM.setTextColor(color);
            cVar.opN.setTextColor(color3);
        }
    }

    class c {
        ImageView lpW;
        View lzm;
        TextView nwk;
        TextView omb;
        TextView onI;
        TextView opM;
        TextView opN;
        ImageView opO;
        TextView opP;

        c() {
        }
    }

    interface b {
        void a(c cVar, Context context);
    }

    public final /* synthetic */ Object getItem(int i) {
        return sD(i);
    }

    public i(Context context) {
        this.mContext = context;
        this.DF = LayoutInflater.from(context);
    }

    public final void bf(List<m> list) {
        if (list == null) {
            LinkedList linkedList = new LinkedList();
        } else {
            this.omo = list;
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.omo.size();
    }

    private m sD(int i) {
        return (m) this.omo.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = this.DF.inflate(g.uJh, viewGroup, false);
            c cVar2 = new c();
            cVar2.lzm = view.findViewById(f.cIB);
            cVar2.lpW = (ImageView) view.findViewById(f.uvW);
            cVar2.nwk = (TextView) view.findViewById(f.uvZ);
            cVar2.onI = (TextView) view.findViewById(f.uwa);
            cVar2.omb = (TextView) view.findViewById(f.uvU);
            cVar2.opM = (TextView) view.findViewById(f.uvV);
            cVar2.opN = (TextView) view.findViewById(f.uwb);
            cVar2.opO = (ImageView) view.findViewById(f.uvX);
            cVar2.opP = (TextView) view.findViewById(f.uvY);
            if (this.opK != null) {
                this.opK.a(cVar2, this.mContext);
            }
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        m sD = sD(i);
        n.a(cVar.lpW, sD.oij, sD.userName);
        if (bi.oM(sD.ohB).equals(this.opG) && this.opH) {
            cVar.opN.setOnClickListener(this.opI);
            cVar.opN.setVisibility(0);
            cVar.opM.setVisibility(8);
            cVar.onI.setVisibility(8);
        } else {
            if (bi.oN(sD.oik)) {
                cVar.opM.setVisibility(8);
            } else {
                n.a(this.mContext, cVar.opM, sD.oik);
                cVar.opM.setVisibility(0);
            }
            cVar.onI.setText(n.i(this.mContext, bi.getLong(sD.ohX, 0) * 1000));
            cVar.onI.setVisibility(0);
            cVar.opN.setVisibility(8);
        }
        n.a(this.mContext, cVar.nwk, sD.oii);
        cVar.omb.setText(this.mContext.getString(com.tencent.mm.plugin.wxpay.a.i.uvJ, new Object[]{e.t(((double) sD.ohW) / 100.0d)}));
        if (bi.oN(sD.oil)) {
            cVar.opO.setVisibility(8);
            cVar.opP.setVisibility(8);
        } else {
            cVar.opP.setText(sD.oil);
            if (this.opJ == 2) {
                cVar.opO.setImageResource(com.tencent.mm.plugin.wxpay.a.e.ujx);
            } else {
                cVar.opO.setImageResource(com.tencent.mm.plugin.wxpay.a.e.ujk);
            }
            cVar.opO.setVisibility(0);
            cVar.opP.setVisibility(0);
        }
        return view;
    }
}
