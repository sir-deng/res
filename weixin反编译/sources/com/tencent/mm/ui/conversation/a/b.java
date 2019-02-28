package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.j.a.a;
import com.tencent.mm.ui.o;
import java.util.ArrayList;

public final class b extends o<c> {
    private ArrayList<c> yah = new ArrayList();
    a zjv = null;

    public final /* bridge */ /* synthetic */ Object a(Object obj, Cursor cursor) {
        return null;
    }

    public final /* synthetic */ Object getItem(int i) {
        return GN(i);
    }

    public b(Context context) {
        super(context, null);
        XI();
    }

    protected final void XI() {
        XH();
    }

    public final void XH() {
        this.yah.clear();
        if (this.zjv != null) {
            this.yah.add(new c(this.zjv));
            notifyDataSetChanged();
        }
    }

    public final int getCount() {
        return this.yah.size();
    }

    public final c GN(int i) {
        return (c) this.yah.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        c cVar = (c) this.yah.get(i);
        if (view == null) {
            view = View.inflate(this.context, R.i.daj, null);
            d dVar2 = new d();
            dVar2.zjx = view;
            dVar2.zjy = (Button) view.findViewById(R.h.bIZ);
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        if (cVar.a(dVar) != 0) {
            return null;
        }
        return view;
    }
}
