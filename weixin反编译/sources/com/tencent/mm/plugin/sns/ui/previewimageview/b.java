package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class b extends a {
    ArrayList<Object> ep = new ArrayList();
    Context mContext;
    int rWm;

    protected b(Context context, int i) {
        this.mContext = context;
        this.rWm = 4;
    }

    public void cb(List<?> list) {
        clear();
        ca(list);
        this.ep.addAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        this.rWl.clear();
        this.ep.clear();
        notifyDataSetChanged();
    }

    public final void add(Object obj) {
        bN(obj);
        this.ep.add(obj);
        notifyDataSetChanged();
    }

    public final void add(int i, Object obj) {
        bN(obj);
        this.ep.add(i, obj);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.ep.size();
    }

    public Object getItem(int i) {
        return this.ep.get(i);
    }

    public final int getColumnCount() {
        return this.rWm;
    }

    public void dL(int i, int i2) {
        if (i2 < getCount()) {
            List list = this.ep;
            list.add(i2, list.remove(i));
            notifyDataSetChanged();
        }
    }

    public boolean yj(int i) {
        return true;
    }

    public boolean yk(int i) {
        return true;
    }
}
