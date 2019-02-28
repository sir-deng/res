package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class MMGridPaperGridView extends GridView {
    private int mCount;
    int mIndex;
    private OnItemClickListener sdH = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (MMGridPaperGridView.this.yjW == null) {
                x.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
            }
        }
    };
    private int yjQ;
    private int yjR;
    private int yjS;
    private int yjT = -1;
    private boolean yjU = false;
    a yjV;
    private l yjW;
    private OnItemLongClickListener yjX = new OnItemLongClickListener() {
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (MMGridPaperGridView.this.yjW == null) {
                x.w("MicroMsg.MMGridPaperGridView", "on item long click, but main adapter is null");
            }
            return false;
        }
    };

    private class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(MMGridPaperGridView mMGridPaperGridView, byte b) {
            this();
        }

        public final boolean isEnabled(int i) {
            return MMGridPaperGridView.this.yjW != null;
        }

        public final int getItemViewType(int i) {
            return 0;
        }

        public final int getViewTypeCount() {
            return 1;
        }

        public final int getCount() {
            return (MMGridPaperGridView.this.mCount < 0 || MMGridPaperGridView.this.yjW == null) ? 0 : MMGridPaperGridView.this.mCount;
        }

        public final Object getItem(int i) {
            return MMGridPaperGridView.this.yjW == null ? null : MMGridPaperGridView.this.yjW.getItem(MMGridPaperGridView.this.yjS + i);
        }

        public final long getItemId(int i) {
            return MMGridPaperGridView.this.yjW == null ? 0 : MMGridPaperGridView.this.yjW.getItemId(MMGridPaperGridView.this.yjS + i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z;
            long Wz = bi.Wz();
            String str = "MicroMsg.MMGridPaperGridView";
            String str2 = "getView:index[%d], pos[%d], converrView is null[%B], parent is [%s], mClearMode[%B]";
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(MMGridPaperGridView.this.mIndex);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Boolean.valueOf(view == null);
            objArr[3] = viewGroup.toString();
            objArr[4] = Boolean.valueOf(MMGridPaperGridView.this.yjU);
            x.v(str, str2, objArr);
            if (MMGridPaperGridView.this.yjU) {
                view = null;
            }
            View d = MMGridPaperGridView.this.yjW == null ? null : MMGridPaperGridView.this.yjW.d(MMGridPaperGridView.this.yjS + i, view);
            if (d != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (-1 == MMGridPaperGridView.this.yjT || MMGridPaperGridView.this.yjS + i != MMGridPaperGridView.this.yjT) {
                d.setVisibility(0);
            } else {
                d.setVisibility(4);
            }
            x.v("MicroMsg.MMGridPaperGridView", "get View ok: use %d ms, hidden index[%d], cur global index[%d]", Long.valueOf(bi.bB(Wz)), Integer.valueOf(MMGridPaperGridView.this.yjT), Integer.valueOf(MMGridPaperGridView.this.yjS + i));
            return d;
        }
    }

    public MMGridPaperGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMGridPaperGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(int i, int i2, int i3, l lVar) {
        boolean z = true;
        String str = "MicroMsg.MMGridPaperGridView";
        String str2 = "index[%d], rows[%d], columns[%d], adapter is null[%B]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        if (lVar != null) {
            z = false;
        }
        objArr[3] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        this.mIndex = i;
        this.yjQ = i2;
        this.yjR = i3;
        this.yjW = lVar;
        this.mCount = this.yjQ * this.yjR;
        this.yjS = this.mIndex * this.mCount;
        if (this.yjW != null && this.yjW.getCount() - this.yjS < this.mCount) {
            this.mCount = this.yjW.getCount() - this.yjS;
        }
        if (getAdapter() == null) {
            x.w("MicroMsg.MMGridPaperGridView", "get adapter null, new one");
            this.yjV = new a();
            setAdapter(this.yjV);
        }
        setNumColumns(this.yjR);
        setColumnWidth(3);
        setOnItemClickListener(this.sdH);
        setOnItemLongClickListener(this.yjX);
    }
}
