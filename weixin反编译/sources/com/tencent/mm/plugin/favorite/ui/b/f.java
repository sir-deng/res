package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.platformtools.bi;

public final class f extends a {

    public static class a extends b {
        TextView ikL;
        TextView ikM;
        ImageView jIs;
    }

    public f(h hVar) {
        super(hVar);
    }

    public final View a(View view, ViewGroup viewGroup, com.tencent.mm.plugin.fav.a.f fVar) {
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
        bVar2.jIs.setImageResource(R.k.dvx);
        vg vgVar = fVar.field_favProto.wld;
        CharSequence charSequence = fVar.field_favProto.iLo;
        if (!bi.oN(charSequence)) {
            bVar2.ikL.setText(i.b(bVar2.ikL.getContext(), charSequence, bVar2.ikL.getTextSize()));
            if (com.tencent.mm.al.a.kR(vgVar.fEp)) {
                bVar2.ikM.setText(vgVar.fEp);
                return view;
            }
        } else if (com.tencent.mm.al.a.kR(vgVar.fEp)) {
            bVar2.ikL.setText(vgVar.fEp);
        } else {
            bVar2.ikL.setText(vgVar.label);
            bVar2.ikM.setVisibility(8);
            return view;
        }
        bVar2.ikM.setText(vgVar.label);
        return view;
    }

    public final void a(View view, vp vpVar) {
        e.a(view.getContext(), ((a) view.getTag()).mwn, vpVar);
    }
}
