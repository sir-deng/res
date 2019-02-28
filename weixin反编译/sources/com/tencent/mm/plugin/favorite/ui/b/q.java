package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.g;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vp;
import java.util.LinkedList;

public final class q extends a {
    final int mDH;

    public static class a extends b {
        ImageView mDI;
        TextView mEp;
    }

    public q(h hVar) {
        super(hVar);
        this.mDH = com.tencent.mm.bu.a.aa(hVar.context, R.f.bva);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.i.dhH, null), aVar, fVar);
            aVar.mDI = (ImageView) view.findViewById(R.h.cgR);
            aVar.mEp = (TextView) view.findViewById(R.h.chu);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mEp.setVisibility(0);
        LinkedList linkedList = fVar.field_favProto.wlY;
        if (linkedList.size() > 0) {
            aVar.mEp.setText(g.v(context, ((uz) linkedList.getFirst()).duration));
        } else {
            aVar.mEp.setText("");
        }
        a(aVar, fVar);
        this.muM.a(aVar.mDI, j.p(fVar), fVar, R.k.dvL, this.mDH, this.mDH);
        return view;
    }

    public final void a(View view, vp vpVar) {
        e.a(view.getContext(), ((a) view.getTag()).mwn, vpVar);
    }
}
