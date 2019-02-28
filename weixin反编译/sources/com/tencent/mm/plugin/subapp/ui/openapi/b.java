package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import java.util.List;

public final class b extends BaseAdapter implements a {
    private Context context;
    private List<f> qpF;
    boolean sdD = false;

    public b(Context context, List<f> list) {
        this.context = context;
        this.qpF = list;
    }

    public final void iW(boolean z) {
        this.sdD = z;
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            cVar = new c();
            view = View.inflate(this.context, R.i.day, null);
            cVar.jTd = (ImageView) view.findViewById(R.h.bKR);
            cVar.sdZ = (TextView) view.findViewById(R.h.bKQ);
            cVar.ipR = (TextView) view.findViewById(R.h.bKS);
            cVar.sea = view.findViewById(R.h.bKT);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.sea.setVisibility(4);
        if (rq(i)) {
            cVar.jTd.setVisibility(4);
            cVar.sdZ.setVisibility(4);
            cVar.ipR.setVisibility(4);
        } else {
            f fVar = (f) getItem(i);
            cVar.jTd.setVisibility(0);
            Bitmap b = g.b(fVar.field_appId, 5, com.tencent.mm.bu.a.getDensity(this.context));
            if (b == null) {
                cVar.jTd.setBackgroundResource(R.g.byY);
            } else {
                cVar.jTd.setBackgroundDrawable(new BitmapDrawable(b));
            }
            cVar.ipR.setVisibility(0);
            cVar.ipR.setText(g.a(this.context, fVar, null));
            if (this.sdD) {
                cVar.sdZ.setVisibility(0);
            } else {
                cVar.sdZ.setVisibility(8);
            }
        }
        return view;
    }

    public final int getCount() {
        return aDx() + aSm();
    }

    public final boolean rq(int i) {
        int size = this.qpF.size();
        return i >= size && i < size + aSm();
    }

    public final Object getItem(int i) {
        if (rq(i)) {
            return null;
        }
        return this.qpF.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    private int aDx() {
        return this.qpF.size();
    }

    private int aSm() {
        return (4 - (aDx() % 4)) % 4;
    }

    public final void a(String str, l lVar) {
        notifyDataSetChanged();
    }
}
