package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a.a;
import junit.framework.Assert;

public abstract class b extends BaseAdapter implements OnScrollListener, OnItemClickListener {
    protected Context mContext;
    public SparseArray<a> ysB;
    public Runnable ysC;

    public abstract a nN(int i);

    public abstract Object[] nO(int i);

    public /* synthetic */ Object getItem(int i) {
        return nQ(i);
    }

    public b(Context context) {
        if (context == null) {
            throw new NullPointerException("context is null.");
        }
        this.mContext = context;
        this.ysB = new SparseArray();
        this.ysC = new Runnable() {
            public final void run() {
                b.this.notifyDataSetChanged();
            }
        };
    }

    public int getCount() {
        return this.ysB.size();
    }

    public int getItemViewType(int i) {
        if (nQ(i) == null) {
            x.d("MicroMsg.BaseMutilDataItemAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount(%d) , position(%d)", Integer.valueOf(getCount()), Integer.valueOf(i));
            return 0;
        } else if (nQ(i) == null) {
            return 0;
        } else {
            return nQ(i).type;
        }
    }

    public int getViewTypeCount() {
        return 7;
    }

    public a nQ(int i) {
        if (i < 0 || i > getCount()) {
            x.e("MicroMsg.BaseMutilDataItemAdapter", "The given position(%d) is illegal.", Integer.valueOf(i));
            return null;
        }
        a aVar = (a) this.ysB.get(i);
        if (aVar != null) {
            return aVar;
        }
        aVar = nN(i);
        this.ysB.put(i, aVar);
        return aVar;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        long currentTimeMillis = System.currentTimeMillis();
        a nQ = nQ(i);
        if (nQ == null) {
            x.e("MicroMsg.BaseMutilDataItemAdapter", "DataItem is null.");
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            com.tencent.mm.ui.base.sortview.a.b asT = nQ.asT();
            if (asT == null) {
                x.e("MicroMsg.BaseMutilDataItemAdapter", "ViewItem is null.");
            } else {
                a asU;
                if (view == null) {
                    view = asT.b(this.mContext, view);
                    asU = nQ.asU();
                    asT.a(view, asU);
                    view.setTag(asU);
                } else {
                    asU = (a) view.getTag();
                }
                Object[] nO = nO(i);
                Assert.assertNotNull(asU);
                if (!nQ.ysA) {
                    nQ.a(this.mContext, asU, nO);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                asT.a(this.mContext, asU, nQ);
                long currentTimeMillis4 = System.currentTimeMillis();
                x.d("MicroMsg.BaseMutilDataItemAdapter", "position %d, getItem %d, inflate %d, filling data %d", Integer.valueOf(i), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis4 - currentTimeMillis3));
            }
        }
        return view;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void onItemClick(android.widget.AdapterView<?> r5, android.view.View r6, int r7, long r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.nQ(r7);
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r1 = r0.asT();
        if (r1 == 0) goto L_0x0006;
    L_0x000d:
        r2 = r4.mContext;
        r3 = r4.nO(r7);
        r0 = r1.a(r2, r0, r3);
        if (r0 == 0) goto L_0x0006;
    L_0x0019:
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.base.sortview.b.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
    }
}
