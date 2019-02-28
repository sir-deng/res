package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.HashSet;

public final class a extends BaseAdapter {
    HashSet<Integer> krN = new HashSet();
    CleanChattingUI lns;

    class a {
        ImageView ikK;
        TextView ikL;
        TextView ikM;
        CheckBox ikN;
        RelativeLayout krQ;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return oG(i);
    }

    public a(CleanChattingUI cleanChattingUI) {
        this.lns = cleanChattingUI;
    }

    public final int getCount() {
        ArrayList ayR = d.ayR();
        if (ayR != null) {
            return ayR.size();
        }
        return 0;
    }

    private static b oG(int i) {
        return (b) d.ayR().get(i);
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.lns.getLayoutInflater().inflate(R.i.deC, viewGroup, false);
            a aVar2 = new a();
            aVar2.ikK = (ImageView) view.findViewById(R.h.bLM);
            aVar2.ikL = (TextView) view.findViewById(R.h.cSB);
            aVar2.ikM = (TextView) view.findViewById(R.h.caU);
            aVar2.ikN = (CheckBox) view.findViewById(R.h.cKP);
            aVar2.krQ = (RelativeLayout) view.findViewById(R.h.cKQ);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.krQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (a.this.krN.contains(Integer.valueOf(i))) {
                    a.this.krN.remove(Integer.valueOf(i));
                } else {
                    a.this.krN.add(Integer.valueOf(i));
                }
                a.this.notifyDataSetChanged();
                a.this.lns.a(a.this.krN);
            }
        });
        b oG = oG(i);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.ikK, oG.username);
        aVar.ikL.setText(bi.by(oG.fxb));
        if (s.eX(oG.username)) {
            aVar.ikM.setText(i.b(this.lns, r.L(oG.username, oG.username), aVar.ikM.getTextSize()));
        } else {
            aVar.ikM.setText(i.b(this.lns, r.gw(oG.username), aVar.ikM.getTextSize()));
        }
        if (this.krN.contains(Integer.valueOf(i))) {
            aVar.ikN.setChecked(true);
        } else {
            aVar.ikN.setChecked(false);
        }
        return view;
    }

    public final void azf() {
        this.krN.clear();
        this.lns.a(this.krN);
    }
}
