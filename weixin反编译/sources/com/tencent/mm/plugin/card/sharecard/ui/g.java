package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class g extends BaseAdapter {
    c kUm;
    List<b> kUx;
    Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        return nV(i);
    }

    public final int getCount() {
        return this.kUx.size();
    }

    public final b nV(int i) {
        return (b) this.kUx.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.kUm.a(i, view, nV(i));
    }
}
