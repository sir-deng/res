package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.platformtools.bi;

public final class c extends a {

    public static class a extends b {
        TextView ikL;
        TextView ikM;
        ImageView jIs;
    }

    public c(h hVar) {
        super(hVar);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.i.dhE, null), aVar, fVar);
            aVar.jIs = (ImageView) view.findViewById(R.h.cgK);
            aVar.ikL = (TextView) view.findViewById(R.h.chq);
            aVar.ikM = (TextView) view.findViewById(R.h.cgz);
            bVar = aVar;
        } else {
            a bVar2 = (a) view.getTag();
        }
        a(bVar2, fVar);
        uz p = j.p(fVar);
        CharSequence charSequence = fVar.field_favProto.title;
        if (bi.oN(charSequence)) {
            charSequence = p.title;
        }
        bVar2.ikL.setText(charSequence);
        bVar2.ikM.setText(j.ah((float) p.wki));
        if (p.wkV == 2) {
            bVar2.ikM.setText(">25MB");
        }
        bVar2.jIs.setImageResource(com.tencent.mm.pluginsdk.model.c.RW(p.wkc));
        return view;
    }

    public final void a(View view, vp vpVar) {
        e.a(view.getContext(), ((a) view.getTag()).mwn, vpVar);
    }
}
