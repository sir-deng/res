package com.tencent.mm.ui.account;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c extends BaseAdapter implements Filterable {
    private Context mContext;
    private final Object mLock = new Object();
    private List<String> pyO;
    private ArrayList<String> pyQ;
    private a xVX;
    private String xVY;

    private class a extends Filter {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        protected final FilterResults performFiltering(CharSequence charSequence) {
            int i = 0;
            FilterResults filterResults = new FilterResults();
            if (c.this.pyQ == null) {
                synchronized (c.this.mLock) {
                    c.this.pyQ = new ArrayList(c.this.pyO);
                }
            }
            if (charSequence == null || charSequence.length() == 0) {
                synchronized (c.this.mLock) {
                    ArrayList arrayList = new ArrayList(c.this.pyQ);
                    filterResults.values = arrayList;
                    filterResults.count = arrayList.size();
                }
            } else {
                String str;
                ArrayList a;
                int size;
                ArrayList arrayList2;
                String toLowerCase = charSequence.toString().toLowerCase();
                String str2 = "";
                if (c.this.xVY != null && c.this.xVY.length() > 0) {
                    String[] split = toLowerCase.split(c.this.xVY);
                    if (split != null && split.length > 1) {
                        str2 = split[0] + c.this.xVY;
                        toLowerCase = split[1];
                        str = str2;
                        str2 = toLowerCase;
                        a = c.this.pyQ;
                        size = a.size();
                        arrayList2 = new ArrayList(size);
                        while (i < size) {
                            toLowerCase = (String) a.get(i);
                            if (toLowerCase.toString().toLowerCase().startsWith(str2)) {
                                arrayList2.add(str + toLowerCase);
                            }
                            i++;
                        }
                        filterResults.values = arrayList2;
                        filterResults.count = arrayList2.size();
                    }
                }
                str = str2;
                str2 = toLowerCase;
                a = c.this.pyQ;
                size = a.size();
                arrayList2 = new ArrayList(size);
                while (i < size) {
                    toLowerCase = (String) a.get(i);
                    if (toLowerCase.toString().toLowerCase().startsWith(str2)) {
                        arrayList2.add(str + toLowerCase);
                    }
                    i++;
                }
                filterResults.values = arrayList2;
                filterResults.count = arrayList2.size();
            }
            return filterResults;
        }

        protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            c.this.pyO = (List) filterResults.values;
            if (filterResults.count > 0) {
                c.this.notifyDataSetChanged();
            } else {
                c.this.notifyDataSetInvalidated();
            }
        }
    }

    static class b {
        public TextView ioR;

        b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return kF(i);
    }

    public c(Context context, String[] strArr, String str) {
        this.mContext = context;
        this.pyO = Arrays.asList(strArr);
        this.xVY = str;
    }

    public final int getCount() {
        return this.pyO.size();
    }

    private String kF(int i) {
        return (String) this.pyO.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.daP, null);
            b bVar2 = new b();
            bVar2.ioR = (TextView) view.findViewById(R.h.cQM);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.ioR.setText(kF(i));
        view.setBackgroundResource(R.g.bBy);
        return view;
    }

    public final Filter getFilter() {
        if (this.xVX == null) {
            this.xVX = new a();
        }
        return this.xVX;
    }
}
