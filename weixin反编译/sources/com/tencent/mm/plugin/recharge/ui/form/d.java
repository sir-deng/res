package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends BaseAdapter implements Filterable {
    private static String TAG = "MicroMsg.MobileHistoryAdapter";
    private Context mContext;
    private AutoCompleteTextView pHY;
    private List<String[]> pIc;
    public List<com.tencent.mm.plugin.recharge.model.a> pIi = new ArrayList();
    public boolean pIj = false;
    private List<com.tencent.mm.plugin.recharge.model.a> pIk;
    private String pIm;
    private MallFormView pJK;
    private b pKx;
    public d pKy = null;
    public a pKz = null;

    public interface a {
        void bnh();
    }

    private class b extends Filter {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b) {
            this();
        }

        protected final synchronized FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults;
            FilterResults filterResults2 = new FilterResults();
            List arrayList = new ArrayList();
            String II = charSequence != null ? com.tencent.mm.plugin.recharge.model.b.II(charSequence.toString()) : "";
            if (!II.equals(d.this.pIm) || II.equals("")) {
                boolean z;
                d.this.pIm = II;
                if (d.this.pJK.XX()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    x.i(d.TAG, "performFiltering2 " + charSequence);
                    com.tencent.mm.plugin.recharge.model.a bmZ = com.tencent.mm.plugin.recharge.a.a.bmZ();
                    if (bmZ == null || !II.equals(bmZ.pHq)) {
                        if (d.this.pIc == null || d.this.pIc.isEmpty()) {
                            d.this.pIc = com.tencent.mm.pluginsdk.a.bW(d.this.mContext);
                        }
                        if (d.this.pIc != null) {
                            for (String[] strArr : d.this.pIc) {
                                String II2 = com.tencent.mm.plugin.recharge.model.b.II(strArr[2]);
                                Object dS = dS(d.this.pIm, II2);
                                if (com.tencent.mm.plugin.recharge.model.a.pHo.equals(dS)) {
                                    filterResults = filterResults2;
                                    break;
                                } else if (!com.tencent.mm.plugin.recharge.model.a.pHp.equals(dS) && arrayList.size() < 4) {
                                    com.tencent.mm.plugin.recharge.model.a aVar = new com.tencent.mm.plugin.recharge.model.a(II2, strArr[1], 1);
                                    aVar.pHs = dS;
                                    arrayList.add(aVar);
                                }
                            }
                        }
                        for (com.tencent.mm.plugin.recharge.model.a aVar2 : com.tencent.mm.plugin.recharge.a.a.bmX().bmY()) {
                            Object dS2 = dS(d.this.pIm, com.tencent.mm.plugin.recharge.model.b.II(aVar2.pHq));
                            if (com.tencent.mm.plugin.recharge.model.a.pHo.equals(dS2)) {
                                filterResults = filterResults2;
                                break;
                            } else if (!com.tencent.mm.plugin.recharge.model.a.pHp.equals(dS2) && arrayList.size() < 4) {
                                aVar2.pHs = dS2;
                                arrayList.add(aVar2);
                            }
                        }
                        x.d(d.TAG, " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                        z = true;
                    } else {
                        filterResults = filterResults2;
                    }
                } else if (bi.oN(d.this.pIm)) {
                    arrayList.addAll(d.this.pIk);
                    z = false;
                } else {
                    x.i(d.TAG, "performFiltering1 " + charSequence);
                    for (com.tencent.mm.plugin.recharge.model.a aVar22 : d.this.pIk) {
                        if (aVar22.pHq.startsWith(d.this.pIm)) {
                            arrayList.add(aVar22);
                        }
                    }
                    z = false;
                }
                filterResults2.count = arrayList.size();
                filterResults2.values = arrayList;
                d.this.pIj = z;
                if (arrayList.size() == 0) {
                    d.this.pJK.pKu = true;
                } else {
                    d.this.pJK.pKu = false;
                }
                filterResults = filterResults2;
            } else {
                d.this.pHY.post(new Runnable() {
                    public final void run() {
                        d.this.pHY.dismissDropDown();
                    }
                });
                filterResults = filterResults2;
            }
            return filterResults;
        }

        protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if (filterResults.values == null) {
                d.this.pIi = new ArrayList();
            } else {
                d.this.pIi = (List) filterResults.values;
            }
            x.i(d.TAG, "results.count " + filterResults.count);
            if (filterResults.count > 0) {
                d.this.notifyDataSetChanged();
            }
        }

        private static int[] dS(String str, String str2) {
            if (str.equals(str2)) {
                return com.tencent.mm.plugin.recharge.model.a.pHo;
            }
            if (str2 != null && str.length() == str2.length()) {
                int[] iArr = new int[]{-1, -1};
                int i = 0;
                for (int length = str.length() - 1; length > 0; length--) {
                    if (str2.charAt(length) != str.charAt(length)) {
                        i++;
                        if (i > 2) {
                            break;
                        }
                        iArr[i - 1] = length;
                    }
                }
                if (i <= 2) {
                    return iArr;
                }
            }
            return com.tencent.mm.plugin.recharge.model.a.pHp;
        }
    }

    private class c {
        TextView ipR;
        TextView pIq;
        ImageView pKC;

        private c() {
        }

        /* synthetic */ c(d dVar, byte b) {
            this();
        }
    }

    public interface d {
    }

    public final /* synthetic */ Object getItem(int i) {
        return vD(i);
    }

    public d(MallFormView mallFormView, List<String[]> list) {
        this.mContext = mallFormView.getContext();
        this.pJK = mallFormView;
        this.pHY = (AutoCompleteTextView) mallFormView.pJQ;
        this.pIc = list;
    }

    public final synchronized void bv(List<com.tencent.mm.plugin.recharge.model.a> list) {
        this.pIk = list;
        this.pIi.clear();
        this.pIj = false;
        notifyDataSetChanged();
    }

    public final Filter getFilter() {
        x.d(TAG, "getFilter");
        if (this.pKx == null) {
            this.pKx = new b();
        }
        return this.pKx;
    }

    public final int getCount() {
        if (this.pIj) {
            return this.pIi.size() + 2;
        }
        return this.pIi.size() > 0 ? this.pIi.size() + 1 : 0;
    }

    public final synchronized com.tencent.mm.plugin.recharge.model.a vD(int i) {
        com.tencent.mm.plugin.recharge.model.a aVar = null;
        synchronized (this) {
            if (this.pIj) {
                if (i != 0) {
                    if (i <= this.pIi.size()) {
                        aVar = (com.tencent.mm.plugin.recharge.model.a) this.pIi.get(i - 1);
                    }
                }
            } else if (i < this.pIi.size()) {
                aVar = (com.tencent.mm.plugin.recharge.model.a) this.pIi.get(i);
            }
        }
        return aVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 0:
                c cVar;
                if (view == null) {
                    view = View.inflate(this.mContext, g.uKs, null);
                    c cVar2 = new c();
                    cVar2.pIq = (TextView) view.findViewById(f.uwC);
                    cVar2.ipR = (TextView) view.findViewById(f.uwB);
                    cVar2.pKC = (ImageView) view.findViewById(f.uDL);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                if (!(cVar == null || cVar.pKC == null)) {
                    if (i == 0) {
                        cVar.pKC.setVisibility(0);
                    } else {
                        cVar.pKC.setVisibility(8);
                    }
                }
                com.tencent.mm.plugin.recharge.model.a vD = vD(i);
                if (vD == null || cVar == null || cVar.pIq == null || cVar.ipR == null) {
                    return view;
                }
                CharSequence IJ = com.tencent.mm.plugin.recharge.model.b.IJ(vD.pHq);
                x.d(TAG, "record.record " + IJ + ", record.name " + vD.name + "，record.location " + vD.pHr);
                if (com.tencent.mm.plugin.recharge.model.a.pHo.equals(vD.pHs)) {
                    cVar.pIq.setTextSize(16.0f);
                    cVar.pIq.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bsO));
                    cVar.ipR.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bsO));
                    cVar.pIq.setText(IJ);
                } else {
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(IJ);
                    for (int i2 : vD.pHs) {
                        int i22;
                        if (i22 >= 0) {
                            if (i22 >= 7) {
                                i22 += 2;
                            } else if (i22 >= 3) {
                                i22++;
                            }
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhM)), i22, i22 + 1, 34);
                        }
                    }
                    cVar.pIq.setTextSize(24.0f);
                    cVar.pIq.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv));
                    cVar.ipR.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv));
                    cVar.pIq.setText(spannableStringBuilder);
                }
                if (vD.name != null && !bi.oN(vD.name.trim())) {
                    if (bi.oN(vD.pHr)) {
                        cVar.ipR.setText(vD.name);
                    } else {
                        cVar.ipR.setText(vD.name + this.mContext.getString(i.vcq, new Object[]{vD.pHr}));
                    }
                    if (vD.name.equals(this.mContext.getString(i.vcw))) {
                        cVar.ipR.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhK));
                        return view;
                    }
                    cVar.ipR.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bts));
                    return view;
                } else if (bi.oN(vD.pHr)) {
                    cVar.ipR.setText(this.mContext.getString(i.vcy));
                    return view;
                } else {
                    cVar.ipR.setText(this.mContext.getString(i.vcy) + this.mContext.getString(i.vcq, new Object[]{vD.pHr}));
                    return view;
                }
            case 1:
                view = View.inflate(this.mContext, g.uKt, null);
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        com.tencent.mm.plugin.recharge.a.a.bmX().bv(null);
                        d.this.pJK.bnq();
                        d.this.bv(new LinkedList());
                        if (d.this.pKz != null) {
                            d.this.pKz.bnh();
                        }
                    }
                });
                return view;
            case 2:
                view = View.inflate(this.mContext, g.uKr, null);
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        d.this.pHY.dismissDropDown();
                    }
                });
                return view;
            case 3:
                view = View.inflate(this.mContext, g.uKt, null);
                ((TextView) view.findViewById(f.uBC)).setText(i.uSr);
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        d.this.pHY.dismissDropDown();
                        d.this.pJK.bnp();
                    }
                });
                return view;
            default:
                return view;
        }
    }

    public final int getItemViewType(int i) {
        if (this.pIj) {
            if (i == 0) {
                return 2;
            }
            if (i > this.pIi.size()) {
                return 3;
            }
            return 0;
        } else if (i >= this.pIi.size()) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }
}
