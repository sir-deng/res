package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f extends BaseAdapter implements b {
    private e zop;
    private List<b> zoq;

    private class b {
        int mCount = 0;
        int zos;

        public b(int i) {
            this.zos = i;
        }
    }

    private final class a extends DataSetObserver {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b) {
            this();
        }

        public final void onChanged() {
            f.this.zoq = f.this.a(f.this.zop);
            f.this.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            f.this.zoq = f.this.a(f.this.zop);
            f.this.notifyDataSetInvalidated();
        }
    }

    public f(e eVar) {
        this.zop = eVar;
        eVar.registerDataSetObserver(new a());
        this.zoq = a(eVar);
    }

    public final int getCount() {
        return this.zop.getCount();
    }

    public final int GS(int i) {
        try {
            return ((b) this.zoq.get(i)).mCount;
        } catch (IndexOutOfBoundsException e) {
            e.toString();
            return 0;
        }
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        return this.zop.a(((b) this.zoq.get(i)).zos, view, viewGroup);
    }

    public final Object getItem(int i) {
        return this.zop.getItem(i);
    }

    public final long getItemId(int i) {
        return this.zop.getItemId(i);
    }

    public final int cyd() {
        return this.zoq.size();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.zop.getView(i, view, viewGroup);
    }

    protected final List<b> a(e eVar) {
        Map hashMap = new HashMap();
        List<b> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= eVar.getCount()) {
                return arrayList;
            }
            long oE = eVar.oE(i2);
            b bVar = (b) hashMap.get(Long.valueOf(oE));
            if (bVar == null) {
                bVar = new b(i2);
                arrayList.add(bVar);
            }
            bVar.mCount++;
            hashMap.put(Long.valueOf(oE), bVar);
            i = i2 + 1;
        }
    }
}
