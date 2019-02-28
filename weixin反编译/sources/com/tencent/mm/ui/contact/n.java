package com.tencent.mm.ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.a;
import junit.framework.Assert;

public abstract class n extends BaseAdapter {
    public int scene;
    private SparseArray<a> xuO;
    public l zbQ;
    private boolean zbR;
    boolean zbS;

    public abstract a je(int i);

    public /* synthetic */ Object getItem(int i) {
        return GF(i);
    }

    public n(l lVar, boolean z, int i, boolean z2) {
        this.zbQ = lVar;
        this.zbR = z;
        this.xuO = new SparseArray();
        this.scene = i;
        this.zbS = z2;
    }

    public n(l lVar, boolean z, int i) {
        this(lVar, z, i, false);
    }

    public boolean buj() {
        return this.zbR;
    }

    public final void nj(boolean z) {
        this.zbR = z;
        notifyDataSetChanged();
    }

    public final a GF(int i) {
        if (this.xuO.indexOfKey(i) >= 0) {
            return (a) this.xuO.get(i);
        }
        if (i < 0 || i >= getCount()) {
            x.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", Integer.valueOf(i));
            return null;
        }
        a je = je(i);
        if (je != null) {
            je.kLA = c(je);
            this.xuO.put(i, je);
            x.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", Integer.valueOf(je.kZv), Integer.valueOf(i));
            return je;
        }
        x.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", Integer.valueOf(i));
        return je;
    }

    protected boolean c(a aVar) {
        return false;
    }

    public long getItemId(int i) {
        return -1;
    }

    public int getItemViewType(int i) {
        if (GF(i) != null) {
            return GF(i).kZv;
        }
        x.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", Integer.valueOf(getCount()), Integer.valueOf(i));
        return -1;
    }

    public int getViewTypeCount() {
        return 8;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a GF = GF(i);
        if (view == null) {
            view = GF.WZ().a(this.zbQ.getActivity(), viewGroup);
        }
        a.a aVar = (a.a) view.getTag();
        Assert.assertNotNull(aVar);
        if (!GF.zed) {
            GF.bH(this.zbQ.getActivity());
            GF.zed = true;
        }
        GF.zbR = buj();
        GF.WZ().a(this.zbQ.getActivity(), aVar, GF, this.zbQ.b(GF), this.zbQ.a(GF));
        return view;
    }

    public final void clearCache() {
        if (this.xuO != null) {
            this.xuO.clear();
        }
    }

    public void finish() {
        clearCache();
    }

    public boolean GG(int i) {
        return false;
    }
}
