package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.vp;

public final class n extends a {

    public static class a extends b {
        TextView lju;
    }

    public n(h hVar) {
        super(hVar);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.i.dhI, null), aVar, fVar);
            aVar.lju = (TextView) view.findViewById(R.h.cho);
            bVar = aVar;
        } else {
            a bVar2 = (a) view.getTag();
        }
        a(bVar2, fVar);
        if (fVar.field_favProto.desc == null || fVar.field_favProto.desc.length() <= 0) {
            bVar2.lju.setText("");
        } else {
            bVar2.lju.setText(i.b(bVar2.lju.getContext(), fVar.field_favProto.desc, bVar2.lju.getTextSize()));
        }
        return view;
    }

    public final void a(View view, vp vpVar) {
        e.a(view.getContext(), ((a) view.getTag()).mwn, vpVar);
    }
}
