package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class d extends BaseAdapter {
    private Context context;
    private String inJ;
    private List<c> list;
    private List<c> nOF = new ArrayList();
    int[] nOH;
    boolean nOI = false;

    static class a {
        TextView kKL;
        TextView nOK;
        TextView nOL;

        a() {
        }
    }

    public d(Context context, List<c> list) {
        this.context = context;
        this.list = list;
        aUZ();
        aVa();
    }

    private void aUZ() {
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nOF.add(this.list.get(i));
        }
    }

    private void aVa() {
        this.nOH = new int[this.list.size()];
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nOH[i] = ((c) this.list.get(i)).nMy;
        }
    }

    public final int getCount() {
        return this.list.size();
    }

    public final Object getItem(int i) {
        return this.list.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void Ds(String str) {
        if (str != null) {
            this.inJ = str.trim();
            this.list.clear();
            int size = this.nOF.size();
            int i = 0;
            while (i < size) {
                if (((c) this.nOF.get(i)).hGi.toUpperCase().contains(this.inJ.toUpperCase()) || ((c) this.nOF.get(i)).nMz.toUpperCase().contains(this.inJ.toUpperCase()) || ((c) this.nOF.get(i)).countryCode.contains(this.inJ)) {
                    this.list.add(this.nOF.get(i));
                }
                i++;
            }
            aVa();
            super.notifyDataSetChanged();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        c cVar = (c) getItem(i);
        if (view == null) {
            View inflate;
            if (w.cfT()) {
                inflate = View.inflate(this.context, R.i.dfo, null);
            } else {
                inflate = View.inflate(this.context, R.i.dfn, null);
            }
            a aVar2 = new a();
            aVar2.nOK = (TextView) inflate.findViewById(R.h.bYB);
            aVar2.kKL = (TextView) inflate.findViewById(R.h.bYD);
            aVar2.nOL = (TextView) inflate.findViewById(R.h.bYG);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = i > 0 ? this.nOH[i - 1] : -1;
        if (i == 0) {
            aVar.nOK.setVisibility(0);
            aVar.nOK.setText(rQ(this.nOH[i]));
        } else if (i <= 0 || this.nOH[i] == i2) {
            aVar.nOK.setVisibility(8);
        } else {
            aVar.nOK.setVisibility(0);
            aVar.nOK.setText(rQ(this.nOH[i]));
        }
        aVar.kKL.setText(cVar.hGi);
        aVar.nOL.setText(cVar.countryCode);
        if (this.nOI) {
            aVar.nOL.setVisibility(0);
        } else {
            aVar.nOL.setVisibility(4);
        }
        return view;
    }

    private static String rQ(int i) {
        if (w.cfT()) {
            return Integer.toString(i) + "劃";
        }
        return String.valueOf((char) i);
    }
}
