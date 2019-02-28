package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

public final class d extends BaseAdapter implements b {
    private DataSetObserver BD = new DataSetObserver() {
        public final void onChanged() {
            d.this.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            d.this.notifyDataSetInvalidated();
        }
    };
    private ListAdapter zon;

    public d(ListAdapter listAdapter) {
        this.zon = listAdapter;
        listAdapter.registerDataSetObserver(this.BD);
    }

    public final int getCount() {
        return this.zon.getCount();
    }

    public final Object getItem(int i) {
        return this.zon.getItem(i);
    }

    public final long getItemId(int i) {
        return this.zon.getItemId(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.zon.getView(i, view, viewGroup);
    }

    public final int GS(int i) {
        return 0;
    }

    public final int cyd() {
        return 0;
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
