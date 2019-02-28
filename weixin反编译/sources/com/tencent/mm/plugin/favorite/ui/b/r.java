package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.protocal.c.vp;

public final class r extends a {

    public static class a extends b {
        TextView ikL;
    }

    public r(h hVar) {
        super(hVar);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        b bVar;
        CharSequence string;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.i.dhJ, null), aVar, fVar);
            aVar.ikL = (TextView) view.findViewById(R.h.chq);
            bVar = aVar;
        } else {
            a bVar2 = (a) view.getTag();
        }
        a(bVar2, fVar);
        int bw = (int) j.bw((long) j.p(fVar).duration);
        TextView textView = bVar2.ikL;
        context = this.muM.context;
        if (bw <= 0) {
            string = context.getString(R.l.ehh, new Object[]{Integer.valueOf(0)});
        } else {
            string = context.getString(R.l.ehh, new Object[]{Integer.valueOf(bw)});
        }
        textView.setText(string);
        return view;
    }

    public final void a(View view, vp vpVar) {
        e.a(view.getContext(), ((a) view.getTag()).mwn, vpVar);
    }
}
