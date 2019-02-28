package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.platformtools.bi;

public final class j extends a {
    private final int mDH;
    private final String mEf;

    public static class a extends b {
        TextView ikL;
        TextView ikM;
        ImageView jIs;
        TextView mDG;
    }

    public j(h hVar) {
        super(hVar);
        this.mDH = com.tencent.mm.bu.a.aa(hVar.context, R.f.buZ);
        this.mEf = hVar.context.getString(R.l.egq);
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
            aVar.ikM.setVisibility(8);
            aVar.mDG = (TextView) view.findViewById(R.h.chb);
            aVar.mDG.setVisibility(0);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, fVar);
        aVar.ikL.setText(bi.oM(fVar.field_favProto.wlh.title));
        aVar.mDG.setText(bi.aD(d.getAppName(context, fVar.field_favProto.wlW.appId), this.mEf));
        this.muM.a(aVar.jIs, null, fVar, R.k.dvI, this.mDH, this.mDH);
        return view;
    }

    public final void a(View view, vp vpVar) {
        e.a(view.getContext(), ((a) view.getTag()).mwn, vpVar);
    }
}
