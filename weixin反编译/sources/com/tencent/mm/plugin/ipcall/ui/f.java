package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.List;

public final class f extends BaseAdapter {
    private String inJ;
    private List<a> list;
    private List<a> nOF = new ArrayList();
    private IPCallCountryCodeSelectUI nOG;
    int[] nOH;
    boolean nOI = false;
    boolean nOJ = false;

    static class a {
        TextView kKL;
        TextView nOK;
        TextView nOL;

        a() {
        }
    }

    public f(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI, List<a> list) {
        this.nOG = iPCallCountryCodeSelectUI;
        this.list = list;
        aUZ();
        aVa();
    }

    private void aUZ() {
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nOF.add(this.list.get(i));
        }
        this.nOG.nOx.setVisibility(8);
    }

    private void aVa() {
        this.nOH = new int[this.list.size()];
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nOH[i] = ((a) this.list.get(i)).aUP();
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
                if (((a) this.nOF.get(i)).hGi.toUpperCase().contains(this.inJ.toUpperCase()) || ((a) this.nOF.get(i)).nMz.toUpperCase().contains(this.inJ.toUpperCase()) || ((a) this.nOF.get(i)).countryCode.contains(this.inJ)) {
                    this.list.add(this.nOF.get(i));
                }
                i++;
            }
            aVa();
            if (this.list.size() == 0) {
                this.nOG.nOx.setVisibility(0);
            } else {
                this.nOG.nOx.setVisibility(8);
            }
            super.notifyDataSetChanged();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2 = (a) getItem(i);
        if (view == null) {
            view = View.inflate(this.nOG, R.i.dmd, null);
            aVar = new a();
            aVar.nOK = (TextView) view.findViewById(R.h.bYB);
            aVar.kKL = (TextView) view.findViewById(R.h.bYD);
            aVar.nOL = (TextView) view.findViewById(R.h.bYG);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = i > 0 ? this.nOH[i - 1] : -1;
        if (i == 0) {
            aVar.nOK.setVisibility(0);
            if (this.nOJ) {
                aVar.nOK.setText(R.l.eBf);
            } else {
                aVar.nOK.setText(rQ(this.nOH[i]));
            }
        } else if (i <= 0 || this.nOH[i] == i2) {
            aVar.nOK.setVisibility(8);
        } else {
            aVar.nOK.setVisibility(0);
            aVar.nOK.setText(rQ(this.nOH[i]));
        }
        if (bi.oN(this.inJ)) {
            aVar.kKL.setText(aVar2.hGi);
            aVar.nOL.setText(" (+" + aVar2.countryCode + ")");
        } else {
            aVar.kKL.setText(b.a(aVar2.hGi, this.inJ));
            aVar.nOL.setText(b.a(" (+" + aVar2.countryCode + ")", this.inJ));
        }
        if (this.nOI) {
            aVar.nOL.setVisibility(0);
        } else {
            aVar.nOL.setVisibility(4);
        }
        return view;
    }

    private static String rQ(int i) {
        String valueOf = String.valueOf((char) i);
        for (String equals : IPCallCountryCodeScrollbar.nOM) {
            if (equals.equals(String.valueOf((char) i))) {
                return valueOf;
            }
        }
        return "#";
    }
}
