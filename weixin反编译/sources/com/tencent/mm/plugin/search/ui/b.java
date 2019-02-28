package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b extends BaseAdapter implements OnScrollListener, OnItemClickListener {
    private int count;
    String fEe;
    private OnScrollListener lmb;
    private c qhR;
    private SparseArray<com.tencent.mm.plugin.fts.d.a.b> qhS = new SparseArray();
    long qhT;
    a qhU;

    public interface a {
        void I(int i, boolean z);
    }

    protected abstract boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z);

    protected abstract void bqD();

    protected abstract com.tencent.mm.plugin.fts.d.a.b qx(int i);

    public /* synthetic */ Object getItem(int i) {
        return wi(i);
    }

    public final Context getContext() {
        return this.qhR.getContext();
    }

    public b(c cVar) {
        x.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
        this.qhR = cVar;
    }

    protected final void wh(int i) {
        x.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", Integer.valueOf(i));
        this.count = i;
    }

    public int getCount() {
        return this.count;
    }

    public int getItemViewType(int i) {
        if (wi(i) != null) {
            return wi(i).kZv;
        }
        x.e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", Integer.valueOf(getCount()), Integer.valueOf(i));
        return -1;
    }

    public int getViewTypeCount() {
        return 21;
    }

    private com.tencent.mm.plugin.fts.d.a.b wi(int i) {
        if (this.qhS.indexOfKey(i) >= 0) {
            return (com.tencent.mm.plugin.fts.d.a.b) this.qhS.get(i);
        }
        com.tencent.mm.plugin.fts.d.a.b bVar = null;
        if (i >= 0 && i < getCount()) {
            bVar = qx(i);
        }
        if (bVar == null) {
            return (com.tencent.mm.plugin.fts.d.a.b) this.qhS.get(0);
        }
        this.qhS.put(i, bVar);
        return bVar;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.fts.d.a.b wi = wi(i);
        if (view == null) {
            view = wi.adG().a(getContext(), viewGroup);
        }
        com.tencent.mm.plugin.fts.d.a.b.a aVar = (com.tencent.mm.plugin.fts.d.a.b.a) view.getTag();
        if (!wi.mVh) {
            wi.a(getContext(), aVar, new Object[0]);
            wi.mVh = true;
        }
        wi.adG().a(getContext(), aVar, wi, new Object[0]);
        return view;
    }

    public final void Jy(String str) {
        stopSearch();
        this.qhT = System.currentTimeMillis();
        this.fEe = str;
        x.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", str);
        bqD();
    }

    public void stopSearch() {
        this.count = 0;
        this.fEe = "";
        clearCache();
        notifyDataSetChanged();
    }

    public void finish() {
        stopSearch();
    }

    protected void clearCache() {
        this.qhS.clear();
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lmb != null) {
            this.lmb.onScrollStateChanged(absListView, i);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lmb != null) {
            this.lmb.onScroll(absListView, i, i2, i3);
        }
    }

    protected final void H(int i, boolean z) {
        if (this.qhU != null) {
            this.qhU.I(i, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.qhR.aWY();
        if (i < getCount()) {
            com.tencent.mm.plugin.fts.d.a.b wi = wi(i);
            a(view, wi, wi.adG().a(getContext(), wi));
            this.qhR.a(wi);
        }
    }

    protected int aNW() {
        return getCount();
    }
}
