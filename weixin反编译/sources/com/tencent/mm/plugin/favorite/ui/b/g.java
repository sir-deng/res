package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.platformtools.bi;

public final class g extends a {
    private final int mDH;

    public static class a extends b {
        TextView ikL;
        TextView ikM;
        ImageView jIs;
        TextView mDG;
    }

    public g(h hVar) {
        super(hVar);
        this.mDH = com.tencent.mm.bu.a.aa(hVar.context, R.f.buZ);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.i.dhD, null), aVar, fVar);
            aVar.jIs = (ImageView) view.findViewById(R.h.cgK);
            aVar.ikL = (TextView) view.findViewById(R.h.chq);
            aVar.ikM = (TextView) view.findViewById(R.h.cgw);
            aVar.mDG = (TextView) view.findViewById(R.h.chb);
            aVar.mDG.setVisibility(8);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, fVar);
        vm vmVar = fVar.field_favProto.wlh;
        aVar.ikL.setText(bi.oM(vmVar.title));
        aVar.ikM.setText(bi.oM(vmVar.desc));
        aVar.ikL.setSingleLine(false);
        aVar.ikL.setMaxLines(2);
        this.muM.a(aVar.jIs, null, fVar, R.k.dvI, this.mDH, this.mDH);
        return view;
    }

    public final void a(View view, vp vpVar) {
        e.a(view.getContext(), ((a) view.getTag()).mwn, vpVar);
    }
}
