package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;

public final class b extends a {
    com.tencent.mm.plugin.nearlife.b.a oWa;
    private com.tencent.mm.plugin.nearlife.b.a oWb = new com.tencent.mm.plugin.nearlife.b.a("", new aos());
    String oWc;
    private HashMap<String, Integer> oWd = new HashMap();

    class a {
        TextView ikn;
        TextView jbl;
        TextView nQU;
        String oUX;
        com.tencent.mm.plugin.nearlife.b.a oWe;
        LinearLayout oWf;
        ImageView oWg;
        int position;
        int type;

        a() {
        }
    }

    public b(Context context, OnClickListener onClickListener, String str, boolean z) {
        super(context, onClickListener, str, z);
        this.oWb.fpg = context.getString(R.l.exh);
        this.oWd.put(this.oWb.oUX, Integer.valueOf(2));
        if (!z) {
            a(this.oWb, 0);
            notifyDataSetChanged();
        }
    }

    public final com.tencent.mm.plugin.nearlife.b.a dH(String str, String str2) {
        if (this.oWa == null) {
            this.oWa = new com.tencent.mm.plugin.nearlife.b.a("", new aos());
            this.oWa.oUX = "City";
            this.oWd.put(this.oWa.oUX, Integer.valueOf(1));
            a(this.oWa, 1);
        }
        this.oWa.fpg = str;
        this.oWa.hMN = str2;
        notifyDataSetChanged();
        return this.oWa;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int intValue;
        if (view == null) {
            aVar = new a();
            view = View.inflate(this.mContext, R.i.doM, null);
            aVar.ikn = (TextView) view.findViewById(R.h.csU);
            aVar.nQU = (TextView) view.findViewById(R.h.csT);
            aVar.jbl = (TextView) view.findViewById(R.h.csS);
            aVar.oWf = (LinearLayout) view.findViewById(R.h.cIE);
            aVar.oWg = (ImageView) view.findViewById(R.h.cKZ);
            aVar.oWf.setOnClickListener(this.myR);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.nearlife.b.a uk = uk(i);
        if (this.oWd.containsKey(uk.oUX)) {
            intValue = ((Integer) this.oWd.get(uk.oUX)).intValue();
        } else {
            intValue = 0;
        }
        aVar.oWg.setVisibility(8);
        aVar.type = intValue;
        aVar.oWe = uk;
        if (!bi.oN(this.oWc) && this.oWc.equals(uk.oUX)) {
            aVar.oWg.setVisibility(0);
        }
        switch (intValue) {
            case 0:
                aVar.ikn.setTextColor(this.mContext.getResources().getColor(R.e.black));
                aVar.jbl.setVisibility(0);
                break;
            case 1:
                aVar.ikn.setTextColor(this.mContext.getResources().getColor(R.e.black));
                aVar.jbl.setVisibility(8);
                break;
            case 2:
                aVar.jbl.setVisibility(8);
                aVar.ikn.setTextColor(this.mContext.getResources().getColor(R.e.btS));
                if (bi.oN(this.oWc)) {
                    aVar.oWg.setVisibility(0);
                    break;
                }
                break;
        }
        aVar.position = i;
        aVar.oUX = uk.oUX;
        if (this.oVo) {
            aVar.ikn.setText(Ew(uk.fpg));
            aVar.jbl.setText(Ew(a.bl(uk.oVc)));
        } else {
            aVar.ikn.setText(uk.fpg);
            aVar.jbl.setText(a.bl(uk.oVc));
        }
        aVar.nQU.setVisibility(8);
        return view;
    }

    private Spannable Ew(String str) {
        return com.tencent.mm.bb.b.a((CharSequence) str, this.oVk);
    }
}
