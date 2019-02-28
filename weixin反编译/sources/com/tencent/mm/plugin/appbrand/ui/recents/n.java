package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.t;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.List;

final class n extends a {
    private LayoutInflater DF;
    final SparseArray<o> jXd = new SparseArray();
    private final ArrayList<?> jXe;

    n(ArrayList<?> arrayList) {
        this.jXe = arrayList;
    }

    final boolean isEmpty() {
        return this.jXe == null || bi.cC(this.jXe);
    }

    final Object lX(int i) {
        return (i < 0 || i > getItemCount()) ? null : this.jXe.get(i);
    }

    public final t a(ViewGroup viewGroup, int i) {
        o oVar = (o) this.jXd.get(i);
        if (oVar == null) {
            return null;
        }
        Context context = viewGroup.getContext();
        if (this.DF == null) {
            this.DF = LayoutInflater.from(context);
        }
        return oVar.a(this.DF, viewGroup);
    }

    public final void a(t tVar, int i) {
        o oVar = (o) this.jXd.get(getItemViewType(i));
        if (oVar != null) {
            oVar.a(tVar, lX(i));
        }
    }

    public final void a(t tVar, int i, List list) {
        o oVar = (o) this.jXd.get(getItemViewType(i));
        if (oVar == null) {
            super.a(tVar, i, list);
        } else if (list.size() <= 0 || !oVar.a(tVar, lX(i), list.get(0))) {
            oVar.a(tVar, lX(i));
        }
    }

    public final int getItemViewType(int i) {
        Object lX = lX(i);
        return lX == null ? 0 : lX.getClass().hashCode();
    }

    public final long getItemId(int i) {
        Object lX = lX(i);
        o oVar = (o) this.jXd.get(getItemViewType(i));
        return (lX == null || oVar == null) ? 0 : oVar.bg(lX);
    }

    public final int getItemCount() {
        return this.jXe == null ? 0 : this.jXe.size();
    }
}
