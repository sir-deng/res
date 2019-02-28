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
import com.tencent.mm.pluginsdk.c;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.bi;

public final class p extends a {
    private final int mDH;

    public static class a extends b {
        TextView ikL;
        ImageView jIs;
    }

    public p(h hVar) {
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
            aVar.ikL.setMaxLines(2);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, fVar);
        uz p = j.p(fVar);
        wc wcVar = fVar.field_favProto.wlf;
        vt vtVar = fVar.field_favProto.wlW;
        TextView textView = aVar.ikL;
        uz p2 = j.p(fVar);
        CharSequence charSequence = "";
        if (wcVar != null) {
            charSequence = wcVar.title;
        }
        if (bi.oN(charSequence) && p2 != null) {
            charSequence = p2.title;
        }
        if (bi.oN(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
        int RI = c.RI(p.wkc);
        h hVar = this.muM;
        ImageView imageView = aVar.jIs;
        if (RI == c.bYK()) {
            RI = R.k.dvO;
        }
        hVar.a(imageView, p, fVar, RI, this.mDH, this.mDH);
        return view;
    }

    public final void a(View view, vp vpVar) {
        e.a(view.getContext(), ((a) view.getTag()).mwn, vpVar);
    }
}
