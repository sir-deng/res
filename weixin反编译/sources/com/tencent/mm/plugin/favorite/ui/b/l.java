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
import com.tencent.mm.y.as;
import java.util.HashSet;
import java.util.LinkedList;

public final class l extends a {
    final int mDH;
    private HashSet<Long> mEn = new HashSet();

    public static class a extends b {
        ImageView mDI;
        TextView mEp;
    }

    public l(h hVar) {
        super(hVar);
        this.mDH = com.tencent.mm.bu.a.aa(hVar.context, R.f.bva);
    }

    public final View a(View view, ViewGroup viewGroup, final f fVar) {
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
        LinkedList linkedList = fVar.field_favProto.wlY;
        if (linkedList.size() > 0) {
            int i = ((uz) linkedList.getFirst()).duration;
            aVar.mEp.setText(g.v(context, i));
            if (!(fVar == null || i > 1 || this.mEn.contains(Long.valueOf(fVar.field_localId)))) {
                this.mEn.add(Long.valueOf(fVar.field_localId));
                as.Dt().F(new Runnable() {
                    public final void run() {
                        j.v(fVar);
                    }
                });
            }
            aVar.mEp.setVisibility(0);
        } else {
            aVar.mEp.setVisibility(8);
        }
        a(aVar, fVar);
        this.muM.a(aVar.mDI, j.p(fVar), fVar, R.k.dvL, this.mDH, this.mDH);
        return view;
    }

    public final void a(View view, vp vpVar) {
        e.a(view.getContext(), ((a) view.getTag()).mwn, vpVar);
    }
}
